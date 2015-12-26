/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbz.business.core.HokenshaShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4120ShinseitodokedeJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * {@link HokenshaShinseitodokedeJoho}のテストクラスです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class HokenshaShinseitodokedeJohoTest extends DbdTestBase {

    public static class getterSetterTest extends DbdTestBase {

        private static HokenshaShinseitodokedeJoho sut;

        @BeforeClass
        public static void test() {
            sut = new HokenshaShinseitodokedeJoho(DbT4120ShinseitodokedeJohoEntityGenerator.createDbT4120ShinseitodokedeJohoEntity());
        }

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の申請届出代行区分コードは_設定した値と同じ申請届出代行区分コードを返す() {
            assertThat(sut.get申請届出代行区分コード(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出代行区分コード));
        }

        @Test
        public void 戻り値の申請届出者氏名は_設定した値と同じ申請届出者氏名を返す() {
            assertThat(sut.get申請届出者氏名(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者氏名));
        }

        @Test
        public void 戻り値の申請届出者氏名カナは_設定した値と同じ申請届出者氏名カナを返す() {
            assertThat(sut.get申請届出者氏名カナ(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者氏名カナ));
        }

        @Test
        public void 戻り値の申請届出者続柄コードは_設定した値と同じ申請届出者続柄コードを返す() {
            assertThat(sut.get申請届出者続柄コード(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者続柄コード));
        }

        @Test
        public void 戻り値の申請届出代行事業者番号は_設定した値と同じ申請届出代行事業者番号を返す() {
            assertThat(sut.get申請届出代行事業者番号(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出代行事業者番号));
        }

        @Test
        public void 戻り値の事業者区分は_設定した値と同じ事業者区分を返す() {
            assertThat(sut.get事業者区分(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_事業者区分));
        }

        @Test
        public void 戻り値の申請届出者郵便番号は_設定した値と同じ申請届出者郵便番号を返す() {
            assertThat(sut.get申請届出者郵便番号(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者郵便番号));
        }

        @Test
        public void 戻り値の申請届出者住所は_設定した値と同じ申請届出者住所を返す() {
            assertThat(sut.get申請届出者住所(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者住所));
        }

        @Test
        public void 戻り値の申請届出者電話番号は_設定した値と同じ申請届出者電話番号を返す() {
            assertThat(sut.get申請届出者電話番号(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者電話番号));
        }
    }

    public static class BuilderTest extends DbdTestBase {

        @Test
        public void setShinseishoKanriNoで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseishoKanriNo(new ShinseishoKanriNo("0000000001")).build();
            assertThat(result.get申請書管理番号(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void setShinseiTodokedeDaikoKubunCodeで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseiTodokedeDaikoKubunCode(new Code("1")).build();
            assertThat(result.get申請届出代行区分コード(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出代行区分コード));
        }

        @Test
        public void setShinseiTodokedeshaShimeiで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseiTodokedeshaShimei(new RString("申請届出者氏名")).build();
            assertThat(result.get申請届出者氏名(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者氏名));
        }

        @Test
        public void setShinseiTodokedeshaKanaShimeiで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseiTodokedeshaKanaShimei(new RString("申請届出者カナ")).build();
            assertThat(result.get申請届出者氏名カナ(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者氏名カナ));
        }

        @Test
        public void setShinseiTodokedeshaTsuzukigaraCodeで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseiTodokedeshaTsuzukigaraCode(new RString("01")).build();
            assertThat(result.get申請届出者続柄コード(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者続柄コード));
        }

        @Test
        public void setShinseiTodokedeDaikoJigyoshaNoで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseiTodokedeDaikoJigyoshaNo(new JigyoshaNo("1234567890")).build();
            assertThat(result.get申請届出代行事業者番号(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出代行事業者番号));
        }

        @Test
        public void setJigyoshaKubunで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setJigyoshaKubun(new RString("01")).build();
            assertThat(result.get事業者区分(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_事業者区分));
        }

        @Test
        public void setShinseiTodokedeshaYubinNoで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseiTodokedeshaYubinNo(new YubinNo("123-4567")).build();
            assertThat(result.get申請届出者郵便番号(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者郵便番号));
        }

        @Test
        public void setShinseiTodokedeshaJushoで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseiTodokedeshaJusho(new RString("申請届出者住所")).build();
            assertThat(result.get申請届出者住所(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者住所));
        }

        @Test
        public void setShinseiTodokedeshaTelNoで設定した値を_生成されたHokenshaShinseitodokedeJohoも保持する() {
            HokenshaShinseitodokedeJoho result = HokenshaShinseitodokedeJoho.newBuilder().setShinseiTodokedeshaTelNo(new TelNo("1234567890")).build();
            assertThat(result.get申請届出者電話番号(), is(DbT4120ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者電話番号));
        }
    }

    public static class SerializationProxyTest {

        private HokenshaShinseitodokedeJoho sut;

        @Before
        public void setUp() {
            sut = HokenshaShinseitodokedeJoho.newBuilder().build(); //builderを用いて、インスタンスを生成してください。
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            sut.createBuilderForEdit().setShinseiTodokedeshaShimei(new AtenaMeisho("申請届出者氏名"));
            String b64 = _Base64Serializer.serialize(sut.serialize());
            HokenshaShinseitodokedeJoho desirialized = _Base64Serializer.deSerialize(b64, HokenshaShinseitodokedeJoho.class);
            assertThat(desirialized.get申請届出者氏名(), is(sut.get申請届出者氏名()));// デシリアライズが成功していることを確認できるコードを書いてください。
        }
    }
}
