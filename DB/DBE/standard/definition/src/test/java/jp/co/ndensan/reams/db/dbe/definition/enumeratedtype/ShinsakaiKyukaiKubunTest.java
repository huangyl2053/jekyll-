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
 * 審査会休会区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKyukaiKubunTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void trueを渡した場合_休会が返る() {
            assertThat(ShinsakaiKyukaiKubun.toValue(true), is(ShinsakaiKyukaiKubun.休会));
        }

        @Test
        public void falseを渡した場合_休会が返る() {
            assertThat(ShinsakaiKyukaiKubun.toValue(false), is(ShinsakaiKyukaiKubun.開催));
        }
    }
}
