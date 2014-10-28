/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * _ViewStateValueのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class _ViewStateValueTest {

    public _ViewStateValueTest() {
    }

    public static class Constructor_Class extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のClassがnullのとき_NullPointerExceptionをスローする() {
            _ViewStateValue sut = new _ViewStateValue(null);
        }
    }

    public static class Constructor_IViewStateKey_Class extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のClassがnullのとき_NullPointerExceptionをスローする() {
            _ViewStateValue sut = new _ViewStateValue(null, HihokenshaNo.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のIViewStateKeyがnullのとき_NullPointerExceptionをスローする() {
            IViewStateKey key = mock(IViewStateKey.class);
            _ViewStateValue sut = new _ViewStateValue(key, null);
        }

        @Test(expected = NullPointerException.class)
        public void valueAssigningToは_引数がどちらもnullのとき_NullPointerExceptionをスローする() {
            _ViewStateValue sut = new _ViewStateValue(null, null);
        }
    }
}
