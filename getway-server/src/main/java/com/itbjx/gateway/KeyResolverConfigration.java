package com.itbjx.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class KeyResolverConfigration {

	/*
	*   基于请求路径的限流规则
	*
	* */
	//@Bean
	public KeyResolver pathKeyResolver(){
		return exchange -> Mono.just(
				exchange.getRequest().getPath().toString()
		);
	}

	/*
	 *   基于请求参数的限流规则
	 * */
	@Bean
	public KeyResolver parmKeyResolver(){
		return exchange -> Mono.just(
				exchange.getRequest().getQueryParams().getFirst("userId")
				//exchange.getRequest().getHeaders().getFirst("X-Forwarded-For") //基于IP限流
		);
	}
}
