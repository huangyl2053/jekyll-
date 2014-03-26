/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KariIchijiHanteiKubunTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void trueを渡したとき_仮判定が返る() {
            assertThat(KariIchijiHanteiKubun.toValue(true), is(KariIchijiHanteiKubun.仮判定));
        }

        @Test
        public void falseを渡したとき_本判定が返る() {
            assertThat(KariIchijiHanteiKubun.toValue(false), is(KariIchijiHanteiKubun.本判定));
        }
    }
}
