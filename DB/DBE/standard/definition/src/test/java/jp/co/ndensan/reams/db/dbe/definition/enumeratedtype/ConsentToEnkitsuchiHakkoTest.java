/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;

/**
 * 延期通知発行に対する同意有無のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ConsentToEnkitsuchiHakkoTest extends TestBase {

    public static class toValueのテスト {

        @Test
        public void 引数にtrueを指定したとき_有効が返る() {
            assertThat(ConsentToEnkitsuchiHakko.toValue(true), is(ConsentToEnkitsuchiHakko.同意));
        }

        @Test
        public void 引数にfalseを指定したとき_無効が返る() {
            assertThat(ConsentToEnkitsuchiHakko.toValue(false), is(ConsentToEnkitsuchiHakko.不同意));
        }
    }
}
