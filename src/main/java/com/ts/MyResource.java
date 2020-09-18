package com.ts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dao.AmenityDao;
import com.dao.ApartmentDao;
import com.dao.BookingDao;
import com.dao.ComplaintsDao;
import com.dao.MailDao;
import com.dao.NoticeBoardDao;
import com.dao.PaymentDao;
import com.dao.RequestDao;
import com.dao.ResidentDao;
import com.dao.SlotDao;
import com.dao.VacancyDao;
import com.dto.Amenity;
import com.dto.Apartment;
import com.dto.Booking;
import com.dto.Complaints;
import com.dto.Mail;
import com.dto.NoticeBoard;
import com.dto.Payment;
import com.dto.Requests;
import com.dto.Resident;
import com.dto.Slot;
import com.dto.Vacancy;

@Path("myresource")
public class MyResource {	

	@Path("Hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		return "Hello ! Welcome to REST API";
	}

	

	@Path("getAllResidents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resident> getResidentAll(){
		System.out.println("Recieved in getAllResidents : " ); 
		ResidentDao resDaoH = new ResidentDao();
		List<Resident> resList = resDaoH.getAllResidents();	
		return resList;	
	}
/*
	@Path("getResidentByloginId/{loginId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void getResidentById(@PathParam("loginId") int loginId){
		System.out.println("Recieved in getEmployeeByID : " + loginId); 
		ResidentDao residentDaoH = new ResidentDao();
		residentDaoH.getResidents(loginId);	
		
	}*/
	@Path("getResidentByLoginId/{loginId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Resident getResByName(@PathParam("loginId") String loginId){
		System.out.println("Recieved in getEmployeeByID : " + loginId); 
		ResidentDao residentDaoH = new ResidentDao();
		 return (residentDaoH.getResByloginId(loginId));	
		 
	}
	@Path("getBookingById/{bookingId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Booking getBookingById(@PathParam("bookingId") int bookingId){
		System.out.println("Recieved in getBookingByID : " + bookingId); 
		BookingDao DaoH = new BookingDao();
		 return (DaoH.getBookingById(bookingId));	
		
	}

	
	@Path("registerResident")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void resisterResident(Resident resident) {
		System.out.println("Data Recieved in Register : " + resident); 
		ResidentDao resDao = new ResidentDao();
		System.out.println(resDao.register(resident));
		
	}
	@Path("registerComplaint")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void resisterComplaint(Complaints complaint) {
		System.out.println("Data Recieved in complaint register : " + complaint); 
		ComplaintsDao resDao = new ComplaintsDao();
		System.out.println(resDao.registerComplaint(complaint));
		
	}
	@Path("registerRequest")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void resisterRequest(Requests req) {
		System.out.println("Data Recieved in Register : " + req); 
		RequestDao resDao = new RequestDao();
		System.out.println(resDao.registerRequest(req));
		
	}
	@Path("sendMail")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void sendmail(Mail mail) {
		System.out.println("Data Recieved in Register : " + mail); 
		MailDao Dao = new MailDao();
		Dao.send(mail.getTo(), mail.getSub(), mail.getMsg());
		
	}
	@Path("sendPasswordResetMail")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void sendPasswordRestMail(Mail mail) {
		System.out.println("Data Recieved in Register : " + mail); 
		MailDao Dao = new MailDao();
		Dao.sendPasswordResetMail(mail.getTo(), mail.getSub(), mail.getMsg());
		
	}
	@Path("sendRandomPassword")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sendRandomPassword() {
		MailDao Dao = new MailDao();
		char[] ch = Dao.generatePassword(8);
		String str2 = String.valueOf(ch);
		return str2;
		
	}
	@Path("getMailStatus/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Resident getStatus(@PathParam("email") String email){
		System.out.println("Recieved in getStatus : " ); 
		
		ResidentDao Dao = new ResidentDao();
		System.out.println(Dao.findByEmail(email));
		return Dao.findByEmail(email);	
	}
	
	@Path("bookAmenity")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int bookAmenity(Booking booking) {
		System.out.println("Data Recieved in booking register : " + booking); 
		BookingDao Dao = new BookingDao();
		System.out.println(Dao.bookAmenity(booking));
		Booking b = new Booking();
		System.out.println(b.getBookingId());
		return b.getBookingId();
		
	}
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Resident resident){
		System.out.println("Data Recieved in update : " + resident); 
		ResidentDao empDao = new ResidentDao();
		empDao.update(resident);
		
	}	
	@Path("lastbooking")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Booking lastBooking() {
		System.out.println("Data Recieved in booking last: " ); 
		BookingDao Dao = new BookingDao();
		List<Booking> aptList =Dao.getLastBooking();
		System.out.println(aptList);
		return aptList.get(0);			
		
	}
	@Path("getMyBooking/{residentId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Booking> getMyBooking(@PathParam("residentId") int residentId){
		System.out.println("Recieved in getBookingByID : " + residentId); 
		BookingDao DaoH = new BookingDao();
		 return DaoH.getMyBooking(residentId);	
		 
		
	}
	@Path("getPaidList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int getMyBooking(){
		System.out.println("Recieved in getpaidlist: "); 
		PaymentDao DaoH = new PaymentDao();
		System.out.println(DaoH.getPaidList());
		return DaoH.getPaidList();	
		
	}
	
/*
	@Path("deleteEmp/{empId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmp(@PathParam("empId") int empId){
		System.out.println("Data Recieved in delete : " + empId);
		ResidentDao empDao = new ResidentDao();
		Resident resident = empDao.getResident(empId);
		empDao.deleteResident(resident);
		
	}	
	@Path("updateEmp")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateEmp(Resident resident){
		System.out.println("Data Recieved in update : " + resident); 
		ResidentDao empDao = new ResidentDao();
		empDao.updateResident(resident);
		
	}	
*/

	@Path("getAllApartments")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Apartment> getAllApartments(){
		System.out.println("Recieved in getAllApartments : " ); 
		ApartmentDao aptDaoH = new ApartmentDao();
		List<Apartment> aptList =aptDaoH.getAllApartments();	
		return aptList;	
	}
	@Path("getAllPayments")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getAllPayments(){
		System.out.println("Recieved in getAllPayments : " ); 
		PaymentDao aptDaoH = new PaymentDao();
		List<Payment> aptList =aptDaoH.getAllPayments();	
		return aptList;	
	}
	@Path("getAllComplaints")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Complaints> getAllComplaints(){
		System.out.println("Recieved in getAllPayments : " ); 
		ComplaintsDao DaoH = new ComplaintsDao();
		List<Complaints> List =DaoH.getAllComplaints();	
		return List;	
	}
	@Path("getAllAmenities")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Amenity> getAllAmenities(){
		System.out.println("Recieved in getAllAmenities : " ); 
		AmenityDao DaoH = new AmenityDao();
		List<Amenity> List =DaoH.getAllAmenities();	
		return List;	
	}
	@Path("getAllRequests")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Requests> getAllRequests(){
		System.out.println("Recieved in getAllRequests : " ); 
		RequestDao DaoH = new RequestDao();
		List<Requests> List =DaoH.getAllRequests();	
		return List;	
	}
	@Path("getAllSlots")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Slot> getAllSlots(){
		System.out.println("Recieved in getAllSlots : " ); 
		SlotDao DaoH = new SlotDao();
		List<Slot> List =DaoH.getAllSlots();	
		return List;	
	}
	@Path("getAllBookings")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Booking> getAllBookings(){
		System.out.println("Recieved in getAllBookings : " ); 
		BookingDao DaoH = new BookingDao();
		List<Booking> List =DaoH.getAllBookings();	
		return List;	
	}
	@Path("deleteReq/{requestId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteReq(@PathParam("requestId") int requestId){
		System.out.println("Data Recieved in delete : " + requestId);
		RequestDao Dao = new RequestDao();
		Requests req = Dao.getRequest(requestId);
		Dao.deleteReq(req);
		
	}	
	@Path("deletebook/{bookingId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deletebook(@PathParam("bookingId") int bookingId){
		System.out.println("Data Recieved in delete : " + bookingId);
		BookingDao Dao = new BookingDao();
		Booking book = Dao.getbook(bookingId);
		Dao.deletebook(book);
		
	}	
	
	@POST
	@Path("/uploadImage")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage(@FormDataParam("Image") InputStream fileInputStream,
			@FormDataParam("Image") FormDataContentDisposition formDataContentDisposition,
			@FormDataParam("title") String title,
			@FormDataParam("description") String description

			) throws IOException{
		int read=0;
		byte [] bytes = new byte[1024];
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		 System.out.println(path);
		// String fileLocation = "/home/madhumitha/Downloads" + formDataContentDisposition.getFileName();  
        String pathArr[] = path.split("/WEB-INF/classes");  
        FileOutputStream out = new FileOutputStream(new File(pathArr[0] + "/image/" + formDataContentDisposition.getFileName()));
		while((read = fileInputStream.read(bytes))!=-1) {
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		System.out.println("upload in");
		NoticeBoard notice = new NoticeBoard();
           
		notice.setDescription(description);
		notice.setTitle(title);
		notice.setImageurl(formDataContentDisposition.getFileName());
		
		NoticeBoardDao Dao = new NoticeBoardDao();
		Dao.addNotice(notice);
		
		
	}
	
	@Path("getAllNotices")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NoticeBoard> getAllNotices(){
		System.out.println("Recieved in getAllNotices : " ); 
		NoticeBoardDao nDaoH = new NoticeBoardDao();
		List<NoticeBoard> notList =nDaoH.getAllNotices();	
		return notList;	
	}

	@Path("deleteNotice/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteNotice(@PathParam("id") int id){
		System.out.println("Data Recieved in delete : " + id);
		NoticeBoardDao Dao = new NoticeBoardDao();
		NoticeBoard notice = Dao.getNotice(id);
		Dao.deleteNotice(notice);
		
	}	
	@POST
	@Path("/uploadProfile")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadProfile(@FormDataParam("Image") InputStream fileInputStream,
			@FormDataParam("Image") FormDataContentDisposition formDataContentDisposition,
			@FormDataParam("residentId") int residentId
			

			) throws IOException{
		int read=0;
		byte [] bytes = new byte[1024];
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		 System.out.println(path);
		// String fileLocation = "/home/madhumitha/Downloads" + formDataContentDisposition.getFileName();  
        String pathArr[] = path.split("/WEB-INF/classes");  
        FileOutputStream out = new FileOutputStream(new File(pathArr[0] + "/image/" + formDataContentDisposition.getFileName()));
		while((read = fileInputStream.read(bytes))!=-1) {
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		System.out.println("upload in");
		Configuration cf=new Configuration();  
		cf.configure();  
		SessionFactory fact = cf.buildSessionFactory();  
		Session sess = fact.openSession();  
		Transaction tr = sess.beginTransaction();  
		Resident resident = (Resident)sess.get(Resident.class,residentId);
		resident.setImageurl(formDataContentDisposition.getFileName());
		/*ResidentDao dao = new ResidentDao();
		dao.update(resident);*/
		/*Configuration cf=new Configuration();  
		cf.configure();  
		SessionFactory fact = cf.buildSessionFactory();  
		Session sess = fact.openSession();  
		Transaction tr = sess.beginTransaction();  */
		//Emp e = (Emp)sess.get(Emp.class,empno);  
		//e.setEname(name);  
		//e.setSal(salary);  
		tr.commit();  
		sess.update(resident);  
		sess.close();  
		System.out.println("<h1>Updated successfully!</h1>");
		
		
	}
	
	@POST
	@Path("/uploadVacancy")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadVacancy(@FormDataParam("Image") InputStream fileInputStream,
			@FormDataParam("Image") FormDataContentDisposition formDataContentDisposition,
			@FormDataParam("title") String title,
			@FormDataParam("description") String description

			) throws IOException{
		int read=0;
		byte [] bytes = new byte[1024];
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		 System.out.println(path);
		// String fileLocation = "/home/madhumitha/Downloads" + formDataContentDisposition.getFileName();  
        String pathArr[] = path.split("/WEB-INF/classes");  
        FileOutputStream out = new FileOutputStream(new File(pathArr[0] + "/image/" + formDataContentDisposition.getFileName()));
		while((read = fileInputStream.read(bytes))!=-1) {
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		System.out.println("upload in");
		/*NoticeBoard notice = new NoticeBoard();
           
		notice.setDescription(description);
		notice.setTitle(title);
		notice.setImageurl(formDataContentDisposition.getFileName());
		
		NoticeBoardDao Dao = new NoticeBoardDao();
		Dao.addNotice(notice);*/
		
		Vacancy vacancy = new Vacancy();
		
		vacancy.setApartmentName(title);
		vacancy.setDescription(description);
		vacancy.setImageUrl(formDataContentDisposition.getFileName());
		
        VacancyDao Dao = new VacancyDao();
		Dao.addVacancy(vacancy);
		
	}
	@Path("getAllVacancies")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vacancy> getAllVacancies(){
		System.out.println("Recieved in getAllNotices : " ); 
		VacancyDao nDaoH = new VacancyDao();
		List<Vacancy> notList =nDaoH.getAllVacancies();	
		return notList;	
	}
	
}

