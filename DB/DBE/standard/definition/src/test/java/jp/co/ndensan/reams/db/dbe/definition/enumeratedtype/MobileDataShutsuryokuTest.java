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
 * モバイルデータ出力を表す列挙型のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class MobileDataShutsuryokuTest extends TestBase {

    public static class toValueのテスト {

        @Test
        public void trueが渡されたとき_出力済みを返す() {
            assertThat(MobileDataShutsuryoku.toValue(true), is(MobileDataShutsuryoku.出力済));
        }

        @Test
        public void falseが渡されたとき_未出力を返す() {
            assertThat(MobileDataShutsuryoku.toValue(false), is(MobileDataShutsuryoku.未出力));
        }
    }
}
