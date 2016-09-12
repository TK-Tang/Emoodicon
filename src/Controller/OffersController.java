package Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.Offer;
import ServiceLayers.OffersService;

@Controller
public class OffersController {

//  Using session (???)_	
//	@RequestMapping("/")
//	public String showHome(HttpSession session) {
//
//		session.setAttribute("name", "TKTang");
//		return "Home";
//	}

//	@RequestMapping("/")
//	public ModelAndView showHome() {
//		ModelAndView mv = new ModelAndView("Home");
//		Map<String, Object> model = mv.getModel();
//
//		model.put("name", "TKTang");
//		return mv;
//	}
	
	// More elegant way than above
	
	
	private OffersService offersService;
	
	@RequestMapping("/Offers")
	public String showOffers(Model model){
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("name", "<b> Asdf </b>");
		model.addAttribute("offers", offers);
		
		return "Offers";
	}



	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id){
		
		
		System.out.println( "Id is " + id);
		return "Home";
	}
	
	@RequestMapping("/CreateOffer")
	public String createOffers(Model model){
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("name", "Kevin");
		
		model.addAttribute("offer", new Offer());
		
		return "CreateOffer";
	}
	
	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println("Form does not validate.");
			
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors){
				System.out.println(error);	
			}
			
			return "CreateOffer";
		}
		
		offersService.create(offer);
		
		System.out.println(offer);
		return "OfferCreated";
	}
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
}
