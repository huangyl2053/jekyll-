/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 要介護認定のテストクラスです。
 *
 * @author n3310 酒井 裕亮
 */
@RunWith(Enclosed.class)
public class _YoKaigoNinteiTest extends DbxTestBase {

    private static IYoKaigoNinteiShinsei 要介護認定申請;
    private static IYoKaigoNinteiChosa 要介護認定調査;
    private static IIkensho 意見書;
    private static IYoKaigoNinteiIchijiHantei 要介護認定一次判定;
    private static IKaigoNinteiShinsaKai 介護認定審査会;
    private static IYoKaigoNinteiKekka 要介護認定結果;
    private static RString 主治医医師識別コード;
    private static RString 主治医氏名;
    private static RString 主治医医療機関コード;
    private static RString 主治医医療機関名称;
    private static _YoKaigoNintei sut;

    @BeforeClass
    public static void setUpClass() {
        要介護認定申請 = mock(IYoKaigoNinteiShinsei.class);
        要介護認定調査 = mock(IYoKaigoNinteiChosa.class);
        意見書 = mock(IIkensho.class);
        要介護認定一次判定 = mock(IYoKaigoNinteiIchijiHantei.class);
        介護認定審査会 = mock(IKaigoNinteiShinsaKai.class);
        要介護認定結果 = mock(IYoKaigoNinteiKekka.class);
        主治医医師識別コード = RString.EMPTY;
        主治医氏名 = RString.EMPTY;
        主治医医療機関コード = RString.EMPTY;
        主治医医療機関名称 = RString.EMPTY;
        sut = new _YoKaigoNintei(要介護認定申請, 要介護認定調査, 意見書, 要介護認定一次判定, 介護認定審査会, 要介護認定結果, 主治医医師識別コード, 主治医氏名, 主治医医療機関コード, 主治医医療機関名称);
    }

    public static class ConstructorTest extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 要介護認定申請がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(null, 要介護認定調査, 意見書, 要介護認定一次判定, 介護認定審査会, 要介護認定結果, 主治医医師識別コード, 主治医氏名, 主治医医療機関コード, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定調査がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, null, 意見書, 要介護認定一次判定, 介護認定審査会, 要介護認定結果, 主治医医師識別コード, 主治医氏名, 主治医医療機関コード, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, 要介護認定調査, null, 要介護認定一次判定, 介護認定審査会, 要介護認定結果, 主治医医師識別コード, 主治医氏名, 主治医医療機関コード, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定一次判定がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, 要介護認定調査, 意見書, null, 介護認定審査会, 要介護認定結果, 主治医医師識別コード, 主治医氏名, 主治医医療機関コード, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定審査会がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, 要介護認定調査, 意見書, 要介護認定一次判定, null, 要介護認定結果, 主治医医師識別コード, 主治医氏名, 主治医医療機関コード, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定結果がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, 要介護認定調査, 意見書, 要介護認定一次判定, 介護認定審査会, null, 主治医医師識別コード, 主治医氏名, 主治医医療機関コード, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医師識別コードがnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, 要介護認定調査, 意見書, 要介護認定一次判定, 介護認定審査会, 要介護認定結果, null, 主治医氏名, 主治医医療機関コード, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医氏名がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, 要介護認定調査, 意見書, 要介護認定一次判定, 介護認定審査会, 要介護認定結果, 主治医医師識別コード, null, 主治医医療機関コード, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関コードがnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, 要介護認定調査, 意見書, 要介護認定一次判定, 介護認定審査会, 要介護認定結果, 主治医医師識別コード, 主治医氏名, null, 主治医医療機関名称);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関名称がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNintei(要介護認定申請, 要介護認定調査, 意見書, 要介護認定一次判定, 介護認定審査会, 要介護認定結果, 主治医医師識別コード, 主治医氏名, 主治医医療機関コード, null);
        }

    }

    public static class getTest extends DbxTestBase {

        @Test
        public void LDNS_get要介護認定申請を実施の場合_get要介護認定申請は_要介護認定申請を返す() {
            assertThat(sut.get要介護認定申請(), is(要介護認定申請));
        }

        @Test
        public void LDNS_get要介護認定調査を実施の場合_get要介護認定調査は_要介護認定調査を返す() {
            assertThat(sut.get要介護認定調査(), is(要介護認定調査));
        }

        @Test
        public void LDNS_get意見書を実施の場合_get意見書は_意見書を返す() {
            assertThat(sut.get意見書(), is(意見書));
        }

        @Test
        public void LDNS_get要介護認定一次判定を実施の場合_get要介護認定一次判定は_要介護認定一次判定を返す() {
            assertThat(sut.get要介護認定一次判定(), is(要介護認定一次判定));
        }

        @Test
        public void LDNS_get介護認定審査会を実施の場合_get介護認定審査会は_介護認定審査会を返す() {
            assertThat(sut.get介護認定審査会(), is(介護認定審査会));
        }

        @Test
        public void LDNS_get要介護認定結果を実施の場合_get要介護認定結果は_要介護認定結果を返す() {
            assertThat(sut.get要介護認定結果(), is(要介護認定結果));
        }

        @Test
        public void LDNS_get主治医医師識別コードを実施の場合_get主治医医師識別コードは_EMPTYを返す() {
            assertThat(sut.get主治医医師識別コード(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_get主治医氏名を実施の場合_get主治医氏名は_EMPTYを返す() {
            assertThat(sut.get主治医氏名(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_get主治医医療機関コードを実施の場合_get主治医医療機関コードは_EMPTYを返す() {
            assertThat(sut.get主治医医療機関コード(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_get主治医医療機関名称を実施の場合_get主治医医療機関名称は_EMPTYを返す() {
            assertThat(sut.get主治医医療機関名称(), is(RString.EMPTY));
        }
    }
}
