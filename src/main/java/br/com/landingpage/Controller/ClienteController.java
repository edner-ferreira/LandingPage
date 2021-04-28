package br.com.landingpage.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.landingpage.model.Cliente;
import br.com.landingpage.model.Lista;
import br.com.landingpage.repository.ListaRepository;
import br.com.landingpage.service.ClienteService;
import br.com.landingpage.service.ListaService;

@Controller
@RequestMapping(value ="/")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ListaService listaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getPostNew() {
        return "index.html";

    }
	
	@PostMapping("/save")
	public void save(@ModelAttribute("forms") @Validated Cliente cliente, HttpServletResponse resp) throws IOException {
//		String command = "curl -X POST https://google.com";
//		Process process = Runtime.getRuntime().exec(command);
//		process.getInputStream();
//		System.out.println(process.toString());
		cURL(cliente);
		clienteService.save(cliente);
		Lista lista = new Lista();
		lista.setCliente(cliente);
		listaService.save(lista);
	    resp.sendRedirect("index.html");
	}
	
	
	public void cURL(Cliente cliente) {
//		BufferedReader reader;
		 
        try {
//            URL url = new URL("http://localhost:3000/sendText?number=" + cliente.getNumeroCelular()+"&message=olaEdner");
// 
//            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
////            System.out.println(reader.read);
//            for (String line; (line = reader.readLine()) != null; ) {
//                System.out.println(line);
//            }
// 
//            reader.close();
            URL url = new URL("http://localhost:3000/sendText?number=" + cliente.getNumeroCelular()+ 
            		"&messages=olaEdner");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestProperty("Content-Type", "application/json");
            http.setRequestProperty("Accept", "application/json");

            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            http.disconnect();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
	
}
