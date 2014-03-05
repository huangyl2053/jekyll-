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
 * 合議体精神科医師存在のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiSeishinkaIshiSonzaiFlagTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数にtrueを渡したとき_存在が返る() {
            assertThat(GogitaiSeishinkaIshiSonzaiFlag.toValue(true), is(GogitaiSeishinkaIshiSonzaiFlag.存在));
        }

        @Test
        public void 引数にfalseを渡したとき_不在が返る() {
            assertThat(GogitaiSeishinkaIshiSonzaiFlag.toValue(false), is(GogitaiSeishinkaIshiSonzaiFlag.不在));
        }
    }
}
