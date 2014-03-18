/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;

/**
 * 延期通知発行に対する同意有無のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ConsentsToEnkitsuchiHakkoTest extends DbeTestBase {

    public static class toValueのテスト {

        @Test
        public void 引数にtrueを指定したとき_有効が返る() {
            assertThat(ConsentsToEnkitsuchiHakko.toValue(true), is(ConsentsToEnkitsuchiHakko.同意));
        }

        @Test
        public void 引数にfalseを指定したとき_無効が返る() {
            assertThat(ConsentsToEnkitsuchiHakko.toValue(false), is(ConsentsToEnkitsuchiHakko.不同意));
        }
    }
}
