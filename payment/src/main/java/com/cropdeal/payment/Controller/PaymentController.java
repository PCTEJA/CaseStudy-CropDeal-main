package com.cropdeal.payment.Controller;

import java.math.BigInteger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cropdeal.payment.model.OrderRequest;
import com.cropdeal.payment.model.OrderResponse;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/payment")
public class PaymentController 
{
	
	@Autowired
	RestTemplate resttemplate;
	
	
	
	private RazorpayClient client;
	private static final String SECRET_ID1 = "rzp_test_K0eF9YF7j3tqob";
	private static final String SECRET_KEY1 = "uG7ZA4D5OgX0Fal1IOAo09JV";
	private static final String SECRET_ID2 = "rzp_test_J4fInjDpTX475d";
	private static final String SECRET_KEY2 ="r8fNXAB78RmsVfdiQbWGwyjr";
	
	@RequestMapping(path = "/createOrder", method = RequestMethod.POST)
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse response = new OrderResponse();
		try {

			if (orderRequest.getAmount().intValue() > 1000) {
				client = new RazorpayClient(SECRET_ID1, SECRET_KEY1);
			} else {
				client = new RazorpayClient(SECRET_ID2, SECRET_KEY2);
			}

			Order order = createRazorPayOrder(orderRequest.getAmount());
			System.out.println("---------------------------");
			String orderId = (String) order.get("id");
			System.out.println("Order ID: " + orderId);
			System.out.println("---------------------------");
			response.setRazorpayOrderId(orderId);
			response.setApplicationFee("" + orderRequest.getAmount());
			if (orderRequest.getAmount().intValue() > 1000) {
				response.setSecretKey(SECRET_KEY1);
				response.setSecretId(SECRET_ID1);
				response.setPgName("razor1");
			} else {
				response.setSecretKey(SECRET_KEY2);
				response.setSecretId(SECRET_ID2);
				response.setPgName("razor2");
			}

			return response;
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;

	}
	
	//intercommunication
		@RequestMapping(value = "/addorderforpayment", method = RequestMethod.POST)
	    public String addproductatcart(@RequestBody OrderRequest order) {
	        HttpEntity<OrderRequest > entity = new HttpEntity<OrderRequest >(order);
	        return resttemplate.exchange("http://cartservice/cart/findall", HttpMethod.POST, entity, String.class).getBody();
	}

	private Order createRazorPayOrder(BigInteger amount) throws RazorpayException {

		JSONObject options = new JSONObject();
		options.put("amount", amount.multiply(new BigInteger("100")));
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		options.put("payment_capture", 1); // You can enable this if you want to do Auto Capture.
		return client.orders.create(options);
	}
}
