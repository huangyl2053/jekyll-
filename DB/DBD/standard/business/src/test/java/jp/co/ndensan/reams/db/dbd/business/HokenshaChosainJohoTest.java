/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4913ChosainJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HokenshaChosainJoho}のテストクラスです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class HokenshaChosainJohoTest extends DbdTestBase {

    private static HokenshaChosainJoho sut;

    public static class getterSetterTest extends DbdTestBase {

        @BeforeClass
        public static void setUp() {
            sut = new HokenshaChosainJoho(DbT4913ChosainJohoEntityGenerator.createDbT4913ChosainJohoEntity());
        }

        @Test
        public void 引数に市町村コードを設定した場合_get市町村コードは_市町村コードと同じ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 引数に認定調査委託先コードを設定した場合_get認定調査委託先コードは_認定調査委託先コードと同じ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void 引数に認定調査員コードを設定した場合_get認定調査員コードは認定調査員コードと同じ認定調査員コードを返す() {
            assertThat(sut.get認定調査員コード(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_認定調査員コード));
        }

        @Test
        public void 引数に調査員氏名を設定した場合_get調査員氏名は調査員氏名と同じ調査員氏名を返す() {
            assertThat(sut.get調査員氏名(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_調査員氏名));
        }

        @Test
        public void 引数に調査員氏名カナを設定した場合_get調査員氏名カナは調査員氏名カナと同じ調査員氏名カナを返す() {
            assertThat(sut.get調査員氏名カナ(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_調査員氏名カナ));
        }

        @Test
        public void 引数に性別を設定した場合_get調性別は性別と同じ性別を返す() {
            assertThat(sut.get性別(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_性別));
        }

        @Test
        public void 引数に調査員資格を設定した場合_get調査員資格と同じ調査員資格を返す() {
            assertThat(sut.get調査員資格(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_調査員資格));
        }

        @Test
        public void 引数に地区コードを設定した場合_get地区コードと同じ地区コードを返す() {
            assertThat(sut.get地区コード(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_地区コード));
        }

        @Test
        public void 引数に調査可能人数月を設定した場合_get地区コードと同じ調査可能人数月を返す() {
            assertThat(sut.get調査可能人数月(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_調査可能人数月));
        }

        @Test
        public void 引数に郵便番号を設定した場合_ge郵便番号と同じ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 引数に住所を設定した場合_ge住所と同じ住所を返す() {
            assertThat(sut.get住所(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 引数に電話番号を設定した場合_ge電話番号と同じ電話番号を返す() {
            assertThat(sut.get電話番号(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 引数にFAX番号を設定した場合_geFAX番号と同じFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void 引数に状況フラグを設定した場合_ge状況フラグと同じ状況フラグを返す() {
            assertThat(sut.get状況フラグ(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_状況フラグ));
        }

    }

    public static class BuilderTest extends DbdTestBase {

        @Test
        public void setLasdecCodeで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setShichosonCode(LasdecCode.EMPTY).setShichosonCode(new LasdecCode("123456")).build();
            assertThat(result.get市町村コード(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void setNinteichosaItakusakiCodeで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setNinteichosaItakusakiCode(new ChosaItakusakiCode("1234567890")).build();
            assertThat(result.get認定調査委託先コード(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void setNinteiChosainNoで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setNinteiChosainNo(new ChosainCode("12345678")).build();
            assertThat(result.get認定調査員コード(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_認定調査員コード));
        }

        @Test
        public void setChosainShimeiで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setChosainShimei(new RString("事業者名称")).build();
            assertThat(result.get調査員氏名(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_調査員氏名));
        }

        @Test
        public void setChosainKanaShimeiで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setChosainKanaShimei(new RString("事業者名称カナ")).build();
            assertThat(result.get調査員氏名カナ(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_調査員氏名カナ));
        }

        @Test
        public void setSeibetsuで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setSeibetsu(new RString("1")).build();
            assertThat(result.get性別(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_性別));
        }

        @Test
        public void setChosainShikakuで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setChosainShikaku(new RString("12")).build();
            assertThat(result.get調査員資格(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_調査員資格));
        }

        @Test
        public void setChikuCodeで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setChikuCode(new RString("12345678")).build();
            assertThat(result.get地区コード(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_地区コード));
        }

        @Test
        public void setChosaKanoNinzuPerMonthで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setChosaKanoNinzuPerMonth(1).build();
            assertThat(result.get調査可能人数月(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_調査可能人数月));
        }

        @Test
        public void setYubinNoで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setYubinNo(new YubinNo("1234567")).build();
            assertThat(result.get郵便番号(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void setJushoで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setJusho(new AtenaJusho("住所")).build();
            assertThat(result.get住所(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void setTelNoで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setTelNo(new TelNo("電話番号")).build();
            assertThat(result.get電話番号(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void setFaxNoで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setFaxNo(new TelNo("FAX番号")).build();
            assertThat(result.getFAX番号(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void setJokyoFlagで設定した値を＿生成されたChosainJohoJukyuも保持する() {
            HokenshaChosainJoho result = HokenshaChosainJoho.newBuilder().setJokyoFlag(new Boolean(true)).build();
            assertThat(result.get状況フラグ(), is(DbT4913ChosainJohoEntityGenerator.DEFAULT_状況フラグ));
        }
    }

    public static class SerializationProxyTest {

        private HokenshaChosainJoho sut;

        @Before
        public void setUp() {
            sut = HokenshaChosainJoho.newBuilder().build();
        }

        @Test
        public void serializeの戻り値の都道府県名は_デシリアライズすると_同じ都道府県名を持ったインスタンスを生成する() {
            sut.createBuilderForEdit().setChosainShimei(new RString("事業者名称"));
            String b64 = _Base64Serializer.serialize(sut.serialize());
            HokenshaChosainJoho desirialized = _Base64Serializer.deSerialize(b64, HokenshaChosainJoho.class);
            assertThat(desirialized.get調査員氏名カナ(), is(sut.get調査員氏名カナ()));
        }

    }
}
