package projects.nyinyihtunlwin.proofofconceptscreen.dagger;

import javax.inject.Singleton;

import dagger.Component;
import projects.nyinyihtunlwin.proofofconceptscreen.POC_Screen_App;
import projects.nyinyihtunlwin.proofofconceptscreen.data.models.MovieModel;
import projects.nyinyihtunlwin.proofofconceptscreen.fragments.NowOnCinemaFragment;
import projects.nyinyihtunlwin.proofofconceptscreen.mvp.presenters.MovieListPresenter;

/**
 * Created by Dell on 1/11/2018.
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(POC_Screen_App app);

    void inject(MovieModel movieModel);

    void inject(MovieListPresenter presenter);

    void inject(NowOnCinemaFragment nowOnCinemaFragment);

}
