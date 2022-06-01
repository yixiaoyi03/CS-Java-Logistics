package net.csjava.logistics;




@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync
@EnableSwagger2
public class DispatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DispatchApplication.class, args);
    }

}
