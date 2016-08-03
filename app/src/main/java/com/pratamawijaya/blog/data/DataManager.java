package com.pratamawijaya.blog.data;

import com.pratamawijaya.blog.data.local.DatabaseHelper;
import com.pratamawijaya.blog.data.network.PratamaService;
import com.pratamawijaya.blog.model.pojo.Post;
import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Singleton public class DataManager {
  private final PratamaService pratamaService;
  private final DatabaseHelper databaseHelper;
  private final CacheProviders cacheProviders;

  @Inject public DataManager(CacheProviders cacheProviders, DatabaseHelper databaseHelper,
      PratamaService pratamaService) {
    this.cacheProviders = cacheProviders;
    this.databaseHelper = databaseHelper;
    this.pratamaService = pratamaService;
  }

  /**
   * get post data from local
   *
   * @return List Post
   */
  public Observable<Reply<List<Post>>> getPosts(final int page, final boolean isUpdate) {
    return cacheProviders.getListPost(pratamaService.getRecentPost(page)
            .flatMap(postResponse -> Observable.just(postResponse.posts)), new DynamicKey(page),
        new EvictDynamicKey(isUpdate));
  }

  public Observable<Post> getPost(final int id, final boolean isUpdate) {
    //return cacheProviders.getPost(pratamaService.getPost(id)
    //        .flatMap(singlePostResponse -> Observable.just(singlePostResponse.post)),
    //    new DynamicKey(id), new EvictDynamicKey(isUpdate));
    return pratamaService.getPost(id)
        .flatMap(singlePostResponse -> Observable.just(singlePostResponse.post));
  }
}
