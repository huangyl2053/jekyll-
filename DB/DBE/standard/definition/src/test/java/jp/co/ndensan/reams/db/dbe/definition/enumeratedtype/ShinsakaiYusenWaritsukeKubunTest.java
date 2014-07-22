/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * ShinsakaiYusenWaritsukeKubunのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShinsakaiYusenWaritsukeKubunTest extends DbzTestBase {

    public static class toValue extends DbzTestBase {

        private ShinsakaiYusenWaritsukeKubun sut;

        @Test
        public void toValueは_あるShinsakaiYusenWaritsukeKubunのcodeメソッドと値を同じ値を渡した時_そのShinsakaiYusenWaritsukeKubunを返す() {
            ShinsakaiYusenWaritsukeKubun theValue = sut.優先する;
            assertThat(sut.toValue(theValue.code()), is(theValue));
        }

        @Test
        public void toValueは_引数と一致するコードを持つオブジェクトがShinsakaiYusenWaritsukeKubunにないとき_defaultValueメソッドと同値を返す() {
            assertThat(sut.toValue(null), is(sut.defaultValue()));
        }
    }

}
