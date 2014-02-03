/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査継続区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsaKeizokuKubunTest extends TestBase {

    public static class toValueのテスト {

        @Test
        public void 引数にtrueが渡されたとき_継続するが返る() {
            assertThat(ShinsaKeizokuKubun.toValue(true), is(ShinsaKeizokuKubun.継続する));
        }

        @Test
        public void 引数にfalseが渡されたとき_継続しないが返る() {
            assertThat(ShinsaKeizokuKubun.toValue(false), is(ShinsaKeizokuKubun.継続しない));
        }
    }
}
