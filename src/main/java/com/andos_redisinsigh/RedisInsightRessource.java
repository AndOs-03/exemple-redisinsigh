package com.andos_redisinsigh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author Anderson Ouattara 2024-09-17
 */
@RestController
@RequestMapping("/redis/insight")
public class RedisInsightRessource {

  @Autowired
  private StringRedisTemplate redisTemplate;

  @PostMapping
  public void saveData(@RequestBody ValeurRedisDTO dto) {
    redisTemplate.opsForValue().set(dto.cle(), dto.valeur());
  }

  @GetMapping("/{cle}")
  public String getData(@PathVariable String cle) {
    return redisTemplate.opsForValue().get(cle);
  }
}
