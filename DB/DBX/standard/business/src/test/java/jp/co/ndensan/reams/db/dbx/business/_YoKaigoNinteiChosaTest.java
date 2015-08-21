/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link _YoKaigoNinteiChosa}のテストクラスです。
 *
 * @author N2204 三井 沙織
 */
@RunWith(Enclosed.class)
public class _YoKaigoNinteiChosaTest extends DbxTestBase {

    private static _YoKaigoNinteiChosa sut;

    public static class 构造関数Test extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の依頼年月日にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _YoKaigoNinteiChosa(null, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の実施年月日にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _YoKaigoNinteiChosa(RDate.MIN, null, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の完了年月日にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の認定調査員コードにnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, null, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の認定調査員氏名にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _YoKaigoNinteiChosa(null, RDate.MIN, RDate.MIN, RString.EMPTY, null, RString.EMPTY, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の事業者コードにnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, null, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の事業者名称にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _YoKaigoNinteiChosa(null, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, null);
        }
    }

    public static class getTest extends DbxTestBase {

        @Test
        public void LDNS_依頼年月日gaを実施の場合_get依頼年月日は_MINを返す() {
            sut = new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            assertThat(sut.get依頼年月日(), is(RDate.MIN));
        }

        @Test
        public void LDNS_get依頼年月日を実施の場合_get実施年月日は_MINを返す() {
            sut = new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            assertThat(sut.get実施年月日(), is(RDate.MIN));
        }

        @Test
        public void LDNS_get完了年月日を実施の場合_get完了年月日_MINを返す() {
            sut = new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            assertThat(sut.get完了年月日(), is(RDate.MIN));
        }

        @Test
        public void LDNS_get認定調査員コードを実施の場合_get認定調査員コード_EMPTYを返す() {
            sut = new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            assertThat(sut.get認定調査員コード(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_get認定調査員氏名を実施の場合_get認定調査員氏名_EMPTYを返す() {
            sut = new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            assertThat(sut.get認定調査員氏名(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_get事業者コードを実施の場合_get事業者コード_EMPTYを返す() {
            sut = new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            assertThat(sut.get事業者コード(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_get事業者名称を実施の場合_get事業者名称_EMPTYを返す() {
            sut = new _YoKaigoNinteiChosa(RDate.MIN, RDate.MIN, RDate.MIN, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            assertThat(sut.get事業者名称(), is(RString.EMPTY));
        }
    }
}
