package com.anderson.tiendaback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.tiendaback.models.Category;
import com.anderson.tiendaback.models.Order;
import com.anderson.tiendaback.models.OrderDetail;
import com.anderson.tiendaback.models.Payment;
import com.anderson.tiendaback.models.Product;
import com.anderson.tiendaback.models.User;
import com.anderson.tiendaback.repositories.CategoryRepository;
import com.anderson.tiendaback.repositories.OrderRepository;
import com.anderson.tiendaback.repositories.PaymentRepository;
import com.anderson.tiendaback.repositories.ProductRepository;
import com.anderson.tiendaback.repositories.UserRepository;
import com.anderson.tiendaback.viewModels.CategoryViewModel;
import com.anderson.tiendaback.viewModels.OrderDetailViewModel;
import com.anderson.tiendaback.viewModels.OrderViewModel;
import com.anderson.tiendaback.viewModels.PaymentViewModel;
import com.anderson.tiendaback.viewModels.ProductViewModel;
import com.anderson.tiendaback.viewModels.UserViewModel;

@Component
public class Mapper {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	
	public UserViewModel convertToUsuarioViewModel(User entity) {
		UserViewModel viewModel = new UserViewModel();
		viewModel.setUserId(entity.getUserId());
		viewModel.setEmail(entity.getEmail());
		viewModel.setPassword(entity.getPassword());
		viewModel.setUsername(entity.getUsername());
		return viewModel;

	}

	public User convertToUsuarioEntity(UserViewModel viewModel) {
		User usuario = new User(viewModel.getUserId(),viewModel.getEmail(),viewModel.getPassword(),viewModel.getUsername());
		return usuario;

	}
	
	public CategoryViewModel convertToCategoryViewModel(Category entity) {
		CategoryViewModel viewModel = new CategoryViewModel();
		viewModel.setCategoryId(entity.getCategoryId());
		viewModel.setNameCategory(entity.getNameCategory());
		return viewModel;
	}
	
	public Category convertToCategoryEntity(CategoryViewModel viewModel) {
		Category category = new Category(viewModel.getCategoryId(),viewModel.getNameCategory());
		return category;
	}
	
	public ProductViewModel convertToProductViewModel(Product entity) {
		ProductViewModel viewModel = new ProductViewModel();
		viewModel.setProductId(entity.getProductId());
		viewModel.setNameProduct(entity.getNameProduct());
		viewModel.setDescriptionProduct(entity.getDescriptionProduct());
		viewModel.setPriceProduct(entity.getPriceProduct());
		viewModel.setCategoryId(entity.getCategory().getCategoryId());
		return viewModel;
	}
	
	public Product convertToProductEntity(ProductViewModel viewModel) {
		Category category = this.categoryRepository.findById(viewModel.getCategoryId()).get();
		Product product = new Product(viewModel.getProductId(),viewModel.getNameProduct(),viewModel.getDescriptionProduct(),
				viewModel.getPriceProduct(),category);
		return product;
	}
	
	public OrderViewModel convertToOrderViewModel(Order entity) {
		OrderViewModel viewModel = new OrderViewModel();
		viewModel.setOrderId(entity.getOrderId());
		viewModel.setMount(entity.getMount());
		viewModel.setUserId(entity.getUser().getUserId());
		return viewModel;
	}
	
	public Order convertToOrderEntity(OrderViewModel viewModel) {
		User user = this.userRepository.findById(viewModel.getUserId()).get();
		Order order = new Order(viewModel.getOrderId(),viewModel.getMount(),user);
		return order;
	}
	
	public PaymentViewModel convertToPaymentViewModel(Payment entity) {
		PaymentViewModel viewModel= new PaymentViewModel();
		viewModel.setPaymentId(entity.getPaymentId());
		viewModel.setnOperation(entity.getnOperation());
		viewModel.setMount(entity.getMount());
		viewModel.setDatePayment(entity.getDatePayment());
		viewModel.setOrderId(entity.getOrder().getOrderId());
		return viewModel;
	}
	
	public Payment convertToPaymentEntity(PaymentViewModel viewModel) {
		Order order = this.orderRepository.findById(viewModel.getOrderId()).get();
		Payment payment = new Payment(viewModel.getPaymentId(),viewModel.getnOperation(),viewModel.getMount(),viewModel.getDatePayment(),order);
		return payment;
	}
	
	public OrderDetailViewModel convertToOrderDetailViewModel(OrderDetail entity) {
		OrderDetailViewModel viewModel = new OrderDetailViewModel();
		viewModel.setOrderDetailId(entity.getOrderDetailId());
		viewModel.setOrderId(entity.getOrder().getOrderId());
		viewModel.setProductId(entity.getProduct().getProductId());
		viewModel.setPrice(entity.getPrice());
		viewModel.setQuantity(entity.getQuantity());
		return viewModel;
	}
	
	public OrderDetail convertToOrderDetailEntity(OrderDetailViewModel viewModel) {
		Order order = this.orderRepository.findById(viewModel.getOrderId()).get();
		Product product = this.productRepository.findById(viewModel.getProductId()).get();
		OrderDetail orderDetail = new OrderDetail(viewModel.getOrderDetailId(),order,product,viewModel.getQuantity(),viewModel.getPrice());
		return orderDetail;
	}
}
