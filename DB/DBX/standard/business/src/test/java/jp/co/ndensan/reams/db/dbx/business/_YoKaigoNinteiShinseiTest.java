/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiYukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 要介護認定申請のテストクラスです。
 *
 * @author n3310 酒井 裕亮
 */
@RunWith(Enclosed.class)
public class _YoKaigoNinteiShinseiTest extends DbxTestBase {

    private static _YoKaigoNinteiShinsei sut;
    private static RString 申請書管理番号;
    private static RString 介護保険被保険者番号;
    private static NinteiShinseiYukoKubun 申請有効区分;
    private static RDate 申請年月日;
    private static NinteiShinseiKubunShinsei 認定申請区分_申請時;
    private static NinteiShinseiKubunHorei 認定申請区分_法令;
    private static RString 認定申請理由;
    private static LasdecCode 地方公共団体コード;
    private static TorisageKubun 取下げ区分;

    @BeforeClass
    public static void setUpClass() {
        申請書管理番号 = new RString("01");
        介護保険被保険者番号 = new RString("0000000001");
        申請有効区分 = NinteiShinseiYukoKubun.申請中;
        申請年月日 = mock(RDate.class);
        認定申請区分_申請時 = NinteiShinseiKubunShinsei.新規申請;
        認定申請区分_法令 = NinteiShinseiKubunHorei.新規申請;
        認定申請理由 = RString.EMPTY;
        地方公共団体コード = mock(LasdecCode.class);
        取下げ区分 = TorisageKubun.認定申請有効;
        sut = new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, 申請有効区分, 申請年月日, 認定申請区分_申請時, 認定申請区分_法令, 認定申請理由, 地方公共団体コード, 取下げ区分);
    }

    public static class _ZenkokuJushoGaijiItem_InitTest extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 申請管理番号がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(null, 介護保険被保険者番号, 申請有効区分, 申請年月日, 認定申請区分_申請時, 認定申請区分_法令, 認定申請理由, 地方公共団体コード, 取下げ区分);
        }

        @Test(expected = NullPointerException.class)
        public void 介護保険被保険者番号がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(申請書管理番号, null, 申請有効区分, 申請年月日, 認定申請区分_申請時, 認定申請区分_法令, 認定申請理由, 地方公共団体コード, 取下げ区分);
        }

        @Test(expected = NullPointerException.class)
        public void 申請有効区分がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, null, 申請年月日, 認定申請区分_申請時, 認定申請区分_法令, 認定申請理由, 地方公共団体コード, 取下げ区分);
        }

        @Test(expected = NullPointerException.class)
        public void 申請年月日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, 申請有効区分, null, 認定申請区分_申請時, 認定申請区分_法令, 認定申請理由, 地方公共団体コード, 取下げ区分);
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請区分_申請時がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, 申請有効区分, 申請年月日, null, 認定申請区分_法令, 認定申請理由, 地方公共団体コード, 取下げ区分);
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請区分_法令がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, 申請有効区分, 申請年月日, 認定申請区分_申請時, null, 認定申請理由, 地方公共団体コード, 取下げ区分);
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請理由がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, 申請有効区分, 申請年月日, 認定申請区分_申請時, 認定申請区分_法令, null, 地方公共団体コード, 取下げ区分);
        }

        @Test(expected = NullPointerException.class)
        public void 地方公共団体コードがnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, 申請有効区分, 申請年月日, 認定申請区分_申請時, 認定申請区分_法令, 認定申請理由, null, 取下げ区分);
        }

        @Test(expected = NullPointerException.class)
        public void 取下げ区分がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
            new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, 申請有効区分, 申請年月日, 認定申請区分_申請時, 認定申請区分_法令, 認定申請理由, 地方公共団体コード, null);
        }

        @Test
        public void LDNS_ZenkokuJushoGaijiItemは_全国住所外字変換を管理するを返す() {
            assertThat(new _YoKaigoNinteiShinsei(申請書管理番号, 介護保険被保険者番号, 申請有効区分, 申請年月日, 認定申請区分_申請時, 認定申請区分_法令, 認定申請理由, 地方公共団体コード, 取下げ区分), instanceOf(_YoKaigoNinteiShinsei.class));
        }
    }

    public static class getTest extends DbxTestBase {

        @Test
        public void LDNS_申請書管理番号は01の場合_get申請書管理番号は_01を返す() {
            assertThat(sut.get申請書管理番号(), is(new RString("01")));
        }

        @Test
        public void LDNS_介護保険被保険者番号は0000000001の場合_get介護保険被保険者番号は_0000000001を返す() {
            assertThat(sut.get介護保険被保険者番号(), is(new RString("0000000001")));
        }

        @Test
        public void LDNS_申請有効区分は申請中の場合_get申請有効区分は_申請中を返す() {
            assertThat(sut.get申請有効区分(), is(NinteiShinseiYukoKubun.申請中));
        }

        @Test
        public void LDNS_get申請年月日を調用の場合_get申請年月日は_申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(申請年月日));
        }

        @Test
        public void LDNS_認定申請区分_申請時は新規申請の場合_get認定申請区分_申請時は_新規申請を返す() {
            assertThat(sut.get認定申請区分_申請時(), is(NinteiShinseiKubunShinsei.新規申請));
        }

        @Test
        public void LDNS_認定申請区分_法令は新規申請の場合_get認定申請区分_法令は_新規申請を返す() {
            assertThat(sut.get認定申請区分_法令(), is(NinteiShinseiKubunHorei.新規申請));
        }

        @Test
        public void LDNS_認定申請理由はemptyの場合_get認定申請理由は_emptyを返す() {
            assertThat(sut.get認定申請理由(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_get地方公共団体コードを調用の場合_get地方公共団体コードは_地方公共団体コードを返す() {
            assertThat(sut.get地方公共団体コード(), is(地方公共団体コード));
        }

        @Test
        public void LDNS_取下げ区分は認定申請有効の場合_get取下げ区分は_認定申請有効を返す() {
            assertThat(sut.get取下げ区分(), is(TorisageKubun.認定申請有効));
        }
    }
}
