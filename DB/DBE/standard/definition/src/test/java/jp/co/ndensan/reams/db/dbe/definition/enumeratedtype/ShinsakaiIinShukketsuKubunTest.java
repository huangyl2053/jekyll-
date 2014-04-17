/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会委員出欠区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinShukketsuKubunTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 出欠区分コードに1を指定したとき_出席が返る() {
            assertThat(ShinsakaiIinShukketsuKubun.toValue(new RString("1")), is(ShinsakaiIinShukketsuKubun.出席));
        }

        @Test
        public void 出欠区分コードに2を指定したとき_欠席が返る() {
            assertThat(ShinsakaiIinShukketsuKubun.toValue(new RString("2")), is(ShinsakaiIinShukketsuKubun.欠席));
        }

        @Test
        public void 出欠区分コードに3を指定したとき_遅刻が返る() {
            assertThat(ShinsakaiIinShukketsuKubun.toValue(new RString("3")), is(ShinsakaiIinShukketsuKubun.遅刻));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 出欠区分コードに対応する項目が存在しない値を渡したとき_IllegalArgumentExceptionが発生する() {
            ShinsakaiIinShukketsuKubun.toValue(new RString("4"));
        }
    }
}
