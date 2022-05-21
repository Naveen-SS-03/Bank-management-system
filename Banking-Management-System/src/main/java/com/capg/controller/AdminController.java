package com.capg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Admin;
import com.capg.entity.Appointment;
import com.capg.entity.PrimaryAccount;
import com.capg.entity.Recipient;
import com.capg.entity.SavingsAccount;
import com.capg.entity.Transactions;
import com.capg.entity.User;
import com.capg.exceptions.RecordNotFoundException;
import com.capg.exceptions.UserNotFoundException;
import com.capg.service.AdminServiceImpl;
import com.capg.service.AppointmentService;
import com.capg.service.RecipientService;
import com.capg.service.TransactionsService;
import com.capg.service.UserService;

@RestController
public class AdminController {
private int validAdmin = 0; //flag variable
	
	@Autowired
	private AdminServiceImpl adminservice;
	@Autowired
	private AppointmentService AppointmentService;
	@Autowired
	private TransactionsService TransactionsService;
	@Autowired
	private RecipientService RecipientService;
	@Autowired
	private UserService UserService;
	
	
	/*---------------------------------------- Admin------------------------------------------------- */
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<?> loginAdmin(@PathVariable("username") String username, @PathVariable("password") String password) {
		if(adminservice.validateAdmin(username, password) == true) {
			validAdmin = 1;
			Admin admin = adminservice.viewByAdminUserName(username, password).get();
			String welcome = "Welcome \n........................\n";
			return ResponseEntity.ok(welcome + "Id : " + admin.getAdminId() + "\nUsername : " + admin.getAdminUsername());
		} else
			return ResponseEntity.ok("Invalid credentials");
	}
	
	@PostMapping("/add")
	public Admin addAdmin(@Validated @RequestBody Admin admin) {
		return adminservice.addAdmin(admin);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		if(validAdmin == 1) {
			validAdmin = 0;
			return ResponseEntity.ok("Logged out...");		
		}else
			return ResponseEntity.ok("Not Logged In");
	}
	
	/*---------------------------Appointment--------------------------------*/
	
	@PostMapping("/Appointment-createAppointment")
    public ResponseEntity<?> createAppointments(@RequestBody Appointment appointment) {
		if(validAdmin == 1) {
		Appointment app = AppointmentService.addAppointments(appointment);
		return new ResponseEntity<Appointment>(app,HttpStatus.CREATED);
		}else {
			return ResponseEntity.ok("Invalid Credentials");
		}
		
	}
	
	
	/*------------------------------ Transactions----------------------------------- */
	@PostMapping("/Transactions-createTransactions")
	public ResponseEntity<?> createTransactions(@RequestBody Transactions transactions){
		if(validAdmin == 1) {
	    Transactions t= TransactionsService.addTransactions(transactions);
		return new ResponseEntity<Transactions>(t,HttpStatus.CREATED);
		}else {
			return ResponseEntity.ok("Invalid Credentials");
		}
	}
	
	/*------------------------------ Recipient------------------------------------- */
	
	@PostMapping("/Recipient-create Recipient")
	public ResponseEntity<?>createRecipient( @RequestBody Recipient Recipient){
		if(validAdmin == 1) {
		Recipient bt= RecipientService.addRecipient(Recipient);
		return new ResponseEntity<Recipient>(bt,HttpStatus.CREATED);
		}else {
			return ResponseEntity.ok("Invalid Credentials");
		}
	}
	
	@DeleteMapping("/Recipient-deleteById/{recipientid}")
	private String deleteRecipients(@PathVariable int recipientid) throws RecordNotFoundException {
		if(validAdmin == 1) {
		RecipientService.deleteRecipient(recipientid);
		return "deleted";
		}else {
			return "Invalid Credentials";
		}
	}
	
	/* ----------------------------------User ----------------------------------------*/
	
	@PostMapping("/user-createUser")
	public ResponseEntity<?>createUser(@RequestBody User User ){
		if(validAdmin == 1) {
		User u	= UserService.addsave(User);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
		}else {
			return ResponseEntity.ok("Invalid Credentials");
		}
		
	}
	
	@DeleteMapping("/user-deleteById/{userid}")
	private String deleteUsers(@PathVariable int userid) throws UserNotFoundException {
		if(validAdmin == 1) {
		UserService.deleteUser(userid);
		return "deleted";
		}else {
			return "Invalid Credentials";
		}
	}
	//---------------------------Primary Account Withdraw--------------------------------------------	
	
    @GetMapping("/Primary Account-Amount withdraw")
    public String menu(Model model, HttpSession session) {
        model.addAttribute("account", new PrimaryAccount());
        int accnum = (int)session.getAttribute("accountNum");
        model.addAttribute("accnum", accnum);
        return "withdraw"; //view
    }
    
    
    @PostMapping("/Primary Account-Amount withdraw")
    public String withdrawMoney(@ModelAttribute PrimaryAccount account, HttpSession session, Model model) {
        int accountNum = (Integer)session.getAttribute("accountNum");
        boolean result = account.withdrawMoney(accountNum,
                account.getAccountBalance());
        Object balance = account.getAccountBalance();
        if (result) {
            model.addAttribute("message", "You withdrew $" + account.getAccountBalance());
            model.addAttribute("balance", balance);
            model.addAttribute("accountNum", accountNum);
        } else {
            model.addAttribute("message", "Low balance. Could not withdraw. ");
        }
        return "withdraw";
    }
//----------------------------------Primary Account Deposit--------------------------------------	    
    @GetMapping("/Primary Account-Amount deposit")
    public String deposit(Model model) {
        model.addAttribute("account", new PrimaryAccount());
        return "deposit"; //view
    }
    
    @PostMapping("/Primary Account-Amount deposit")
    public String depositMoney(@ModelAttribute PrimaryAccount account, HttpSession session, Model model) {
        int accountNum = (Integer)session.getAttribute("accountNum");
        boolean result = PrimaryAccount.depositMoney(accountNum,
                account.getAccountBalance());
        Object balance = account.getAccountBalance(accountNum);
        if (result) {
            model.addAttribute("message", "You deposited $" + account.getAccountBalance());
            model.addAttribute("balance", balance);
            model.addAttribute("accountNum", accountNum);
        } else {
            model.addAttribute("message", "Error while depositing.");
        }
        return "deposit";
    }
    
//---------------------------Savings Account Withdraw--------------------------------------------	
	
    @GetMapping("/Savings Account-Amount withdraw")
    public String menu1(Model model, HttpSession session) {
        model.addAttribute("account", new SavingsAccount());
        int accnum = (int)session.getAttribute("accountNum");
        model.addAttribute("accnum", accnum);
        return "withdraw"; //view
    }
    
    
    @PostMapping("/Savings Account-Amount withdraw")
    public String withdrawMoney1(@ModelAttribute SavingsAccount account, HttpSession session, Model model) {
        int accountNum = (Integer)session.getAttribute("accountNum");
        boolean result = account.withdrawMoney(accountNum,
                account.getAccountBalance());
        Object balance = account.getAccountBalance();
        if (result) {
            model.addAttribute("message", "You withdrew $" + account.getAccountBalance());
            model.addAttribute("balance", balance);
            model.addAttribute("accountNum", accountNum);
        } else {
            model.addAttribute("message", "Low balance. Could not withdraw. ");
        }
        return "withdraw";
    }
  //----------------------------------Savings Account Deposit--------------------------------------	    
    @GetMapping("/Savings Account-Amount deposit")
    public String deposit1(Model model) {
        model.addAttribute("account", new SavingsAccount());
        return "deposit"; //view
    }
    
    @PostMapping("/Savings Account-Amount deposit")
    public String depositMoney1(@ModelAttribute SavingsAccount account, HttpSession session, Model model) {
        int accountNum = (Integer)session.getAttribute("accountNum");
        boolean result = PrimaryAccount.depositMoney(accountNum,
                account.getAccountBalance());
        Object balance = account.getAccountBalance(accountNum);
        if (result) {
            model.addAttribute("message", "You deposited $" + account.getAccountBalance());
            model.addAttribute("balance", balance);
            model.addAttribute("accountNum", accountNum);
        } else {
            model.addAttribute("message", "Error while depositing.");
        }
        return "deposit";
    }
}
