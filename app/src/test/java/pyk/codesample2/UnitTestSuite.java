package pyk.codesample2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import pyk.codesample2.helper.TMDBHelperTest;
import pyk.codesample2.presenter.MovieListItemAdapterPresenterTest;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({MovieListItemAdapterPresenterTest.class, TMDBHelperTest.class})
public class UnitTestSuite {}