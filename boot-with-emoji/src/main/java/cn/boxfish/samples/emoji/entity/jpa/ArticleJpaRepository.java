package cn.boxfish.samples.emoji.entity.jpa;

import cn.boxfish.samples.emoji.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by undancer on 15/5/8.
 */
public interface ArticleJpaRepository extends JpaRepository<Article, Long> {
}
