/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
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
 * {@link ShinsakaiNinteichosaItakusakiJoho}のテストクラスです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class ShinsakaiNinteichosaItakusakiJohoTest extends DbdTestBase {

    public static class getterSetterTest extends DbdTestBase {

        private static ShinsakaiNinteichosaItakusakiJoho sut;

        @BeforeClass
        public static void setUp() {
            sut = new ShinsakaiNinteichosaItakusakiJoho(DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity());
        }

        @Test
        public void 引数に市町村コードを設定した場合_get市町村コードは_市町村コードと同じ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 引数に認定調査委託先コードを設定した場合_get認定調査委託先コードは_認定調査委託先コードと同じ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void 引数に事業者番号を設定した場合_get事業者番号は_事業者番号と同じ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 引数に事業者名称を設定した場合_get事業者名称は_事業者名称と同じ事業者名称を返す() {
            assertThat(sut.get事業者名称(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void 引数に事業者名称カナを設定した場合_get事業者名称カナは_事業者名称カナと同じ事業者名称カナ称を返す() {
            assertThat(sut.get事業者名称カナ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void 引数に郵便番号を設定した場合_get郵便番号は_郵便番号と同じ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 引数に住所を設定した場合_get住所は_住所と同じ住所を返す() {
            assertThat(sut.get住所(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 引数に電話番号を設定した場合_get電話番号は_電話番号と同じ電話番号を返す() {
            assertThat(sut.get電話番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 引数にFAX番号を設定した場合_getFAX番号は_FAX番号と同じFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void 引数に代表者名を設定した場合_get代表者名は_代表者名と同じ代表者名を返す() {
            assertThat(sut.get代表者名(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_代表者名));
        }

        @Test
        public void 引数に調査委託区分を設定した場合_get調査委託区分は_調査委託区分と同じ調査委託区分を返す() {
            assertThat(sut.get調査委託区分(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_調査委託区分));
        }

        @Test
        public void 引数に割付定員を設定した場合_get割付定員は_割付定員と同じ割付定員を返す() {
            assertThat(sut.get割付定員(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付定員));
        }

        @Test
        public void 引数に割付地区を設定した場合_get割付地区は_割付地区と同じ割付地区を返す() {
            assertThat(sut.get割付地区(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付地区));
        }

        @Test
        public void 引数に自動割付フラグを設定した場合_get自動割付フラグは_自動割付フラグと同じ自動割付フラグを返す() {
            assertThat(sut.has自動割付フラグ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_自動割付フラグ));
        }

        @Test
        public void 引数に機関の区分を設定した場合_get機関の区分は_機関の区分と同じ機関の区分を返す() {
            assertThat(sut.get機関の区分(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_機関の区分));
        }

        @Test
        public void 引数に状況フラグを設定した場合_get状況フラグは_状況フラグと同じ状況フラグを返す() {
            assertThat(sut.has状況フラグ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_状況フラグ));
        }
    }

    public static class BuilderTest {

        @Test
        public void setShichosonCodeで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setShichosonCode(new LasdecCode("123456")).build();
            assertThat(result.get市町村コード(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void setNinteichosaItakusakiCodeで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setNinteichosaItakusakiCode(new ChosaItakusakiCode("1234567890")).build();
            assertThat(result.get認定調査委託先コード(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void setJigyoshaNoで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setJigyoshaNo(new JigyoshaNo("1234567890")).build();
            assertThat(result.get事業者番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void setJigyoshaMeishoで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setJigyoshaMeisho(new RString("事業者名称")).build();
            assertThat(result.get事業者名称(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void setJigyoshaMeishoKanaで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setJigyoshaMeishoKana(new RString("事業者名称カナ")).build();
            assertThat(result.get事業者名称カナ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void setYubinNoで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setYubinNo(new YubinNo("1234567")).build();
            assertThat(result.get郵便番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void setJushoで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setJusho(new RString("住所")).build();
            assertThat(result.get住所(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void setTelNoで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setTelNo(new TelNo("電話番号")).build();
            assertThat(result.get電話番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void setFaxNoで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setFaxNo(new TelNo("FAX番号")).build();
            assertThat(result.getFAX番号(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void setDaihyoshaNameで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setDaihyoshaName(new AtenaMeisho("代表者名")).build();
            assertThat(result.get代表者名(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_代表者名));
        }

        @Test
        public void setChosaItakuKubunで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setChosaItakuKubun(new RString("1")).build();
            assertThat(result.get調査委託区分(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_調査委託区分));
        }

        @Test
        public void setWaritsukeTeiinで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setWaritsukeTeiin(1).build();
            assertThat(result.get割付定員(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付定員));
        }

        @Test
        public void setWaritsukeChikuで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setWaritsukeChiku(new ChikuCode("1")).build();
            assertThat(result.get割付地区(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付地区));
        }

        @Test
        public void setAutoWaritsukeFlagで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setAutoWaritsukeFlag(Boolean.TRUE).build();
            assertThat(result.has自動割付フラグ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_自動割付フラグ));
        }

        @Test
        public void setKikanKubunで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setKikanKubun(new RString("1")).build();
            assertThat(result.get機関の区分(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_機関の区分));
        }

        @Test
        public void setJokyoFlagで設定した値を_生成されたNinteichosaItakusakiJohoJukyuも保持する() {
            HokenshaNinteichosaItakusakiJoho result = HokenshaNinteichosaItakusakiJoho.newBuilder().setJokyoFlag(Boolean.TRUE).build();
            assertThat(result.has状況フラグ(), is(DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_状況フラグ));
        }
    }

    public static class SerializationProxyTest {

        private HokenshaNinteichosaItakusakiJoho sut;

        @Before
        public void setUp() {
            sut = HokenshaNinteichosaItakusakiJoho.newBuilder().build();
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            sut.createBuilderForEdit().setJusho(new RString("住所"));
            String b64 = _Base64Serializer.serialize(sut.serialize());
            HokenshaNinteichosaItakusakiJoho desirialized = _Base64Serializer.deSerialize(b64, HokenshaNinteichosaItakusakiJoho.class);
            assertThat(desirialized.get事業者名称カナ(), is(sut.get事業者名称カナ()));
        }
    }
}
