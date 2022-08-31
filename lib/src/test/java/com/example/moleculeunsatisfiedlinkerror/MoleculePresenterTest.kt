package com.example.moleculeunsatisfiedlinkerror

import app.cash.molecule.RecompositionClock
import app.cash.molecule.launchMolecule
import app.cash.turbine.test
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MoleculePresenterTest {
  @Test(expected = CancellationException::class)
  fun test() = runBlocking {
    makePresenter().test {
      assertEquals(Model("Hello!"), awaitItem())
      coroutineContext.cancel()
    }
  }

  private fun CoroutineScope.makePresenter(): StateFlow<Model> {
    return launchMolecule(RecompositionClock.Immediate) {
      MoleculePresenter()
    }
  }
}
