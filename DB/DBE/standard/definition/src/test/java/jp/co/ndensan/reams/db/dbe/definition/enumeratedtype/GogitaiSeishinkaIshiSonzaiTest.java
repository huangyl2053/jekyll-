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
 * 合議体精神科医師存在のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiSeishinkaIshiSonzaiTest extends TestBase {

    public static class toValueのテスト {

        @Test
        public void 引数にtrueを渡したとき_在籍が返る() {
            assertThat(GogitaiSeishinkaIshiSonzai.toValue(true), is(GogitaiSeishinkaIshiSonzai.在籍));
        }

        @Test
        public void 引数にfalseを渡したとき_不在が返る() {
            assertThat(GogitaiSeishinkaIshiSonzai.toValue(false), is(GogitaiSeishinkaIshiSonzai.不在));
        }
    }
}
