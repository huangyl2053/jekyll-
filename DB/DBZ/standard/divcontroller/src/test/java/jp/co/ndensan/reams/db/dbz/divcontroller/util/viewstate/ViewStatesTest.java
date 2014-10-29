/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.isA;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ViewStatesのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ViewStatesTest extends DbzTestBase {

    public ViewStatesTest() {
    }

    public static class contains extends DbzTestBase {

        private ViewStates sut;

        @Test
        public void accessは_IViewStateAccessorsのインスタンスを返す() {
            assertThat(sut.access(), isA(IViewStateAccessors.class));
        }
    }

    public static class containsKey extends DbzTestBase {

        private ViewStates sut;

        @Test(expected = NullPointerException.class)
        public void containsKeyは_引数がnullのとき_NullPointerExceptionをスローする() {
            sut.containsKey(null);
        }
    }
}
