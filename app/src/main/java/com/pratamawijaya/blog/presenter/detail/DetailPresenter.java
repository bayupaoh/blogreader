package com.pratamawijaya.blog.presenter.detail;

import com.pratamawijaya.blog.base.BasePresenter;
import com.pratamawijaya.blog.data.DataManager;
import com.pratamawijaya.blog.ui.detail.DetailArticleInterface;
import javax.inject.Inject;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by pratama on 4/17/16.
 */
public class DetailPresenter extends BasePresenter<DetailArticleInterface> {
  private static final String TAG = "";
  private final DataManager dataManager;
  private CompositeSubscription compositeSubscription = new CompositeSubscription();

  @Inject public DetailPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  @Override public void attachView(DetailArticleInterface mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
    if (compositeSubscription != null) {
      compositeSubscription.unsubscribe();
    }
  }

  public void getArticleDetail(final int id, final boolean isUpdate) {
    //checkViewAttached();
    //
    //dataManager.getPost(id, isUpdate)
    //    .subscribeOn(Schedulers.io())
    //    .observeOn(AndroidSchedulers.mainThread())
    //    .subscribe(post -> {
    //      if (post != null) {
    //        // do something
    //      }
    //    }, throwable -> {
    //      Log.e(TAG, "getArticleDetail: "+throwable.getLocalizedMessage() );
    //    }, () -> {
    //      Log.i(TAG, "getArticleDetail: completed");
    //    });
    //compositeSubscription.add(dataManager.getPost(id, isUpdate)
    //    .subscribeOn(Schedulers.io())
    //    .observeOn(AndroidSchedulers.mainThread())
    //    .subscribe(post -> {
    //      Timber.d("getArticleDetail() : data source %s", post.getSource().name());
    //      if (post != null) {
    //        getMvpView().setData(post.getData());
    //      }
    //    }, throwable -> {
    //      Timber.e("getArticleDetail() :  %s", throwable.getLocalizedMessage());
    //    }));
  }
}
