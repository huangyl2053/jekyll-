/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Test;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * _ViewStateAccessorsのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class _ViewStateAccessorsTest extends DbzTestBase {

    public _ViewStateAccessorsTest() {
    }

    public static class valueAssigningToA extends DbzTestBase {

        private _ViewStateAccessors sut;

        @Before
        public void setUp() {
            sut = new _ViewStateAccessors();
        }

        @Test(expected = NullPointerException.class)
        public void valueAssigningToAは_引数がnullのとき_NullPointerExceptionをスローする() {
            sut.valueAssignedToA(null);
        }
    }

    public static class valueAssignedTo_IViewStateKey extends DbzTestBase {

        private _ViewStateAccessors sut;

        @Before
        public void setUp() {
            sut = new _ViewStateAccessors();
        }

        @Test(expected = NullPointerException.class)
        public void IViewStateKeyを引数に持つ_valueAssigningToは_引数のIViewStateKeyがnullのとき_NullPointerExceptionをスローする() {
            sut.valueAssignedTo((IViewStateKey) null, HihokenshaNo.class);
        }

        @Test(expected = NullPointerException.class)
        public void IViewStateKeyを引数に持つ_valueAssigningToは_引数のClassがnullのとき_NullPointerExceptionをスローする() {
            IViewStateKey key = mock(IViewStateKey.class);
            sut.valueAssignedTo(key, null);
        }

        @Test(expected = NullPointerException.class)
        public void IViewStateKeyを引数に持つ_valueAssigningToは_引数がどちらもnullのとき_NullPointerExceptionをスローする() {
            sut.valueAssignedTo((IViewStateKey) null, null);
        }
    }

    public static class valueAssignedTo_ViewStateKeyAssignedClass extends DbzTestBase {

        private _ViewStateAccessors sut;

        @Before
        public void setUp() {
            sut = new _ViewStateAccessors();
        }

        @Test(expected = NullPointerException.class)
        public void ViewStateKeyAssignedClassを引数に持つ_valueAssigningToは_引数のViewStateKeyAssignedClassがnullのとき_NullPointerExceptionをスローする() {
            sut.valueAssignedTo((ViewStateKeyAssignedClass) null, HihokenshaNo.class);
        }

        @Test(expected = NullPointerException.class)
        public void ViewStateKeyAssignedClassを引数に持つ_valueAssigningToは_引数のClassがnullのとき_NullPointerExceptionをスローする() {
            IViewStateKey key = mock(IViewStateKey.class);
            sut.valueAssignedTo(key, null);
        }

        @Test(expected = NullPointerException.class)
        public void ViewStateKeyAssignedClassを引数に持つ_valueAssigningToは_引数がどちらもnullのとき_NullPointerExceptionをスローする() {
            sut.valueAssignedTo((ViewStateKeyAssignedClass) null, null);
        }
    }
}
