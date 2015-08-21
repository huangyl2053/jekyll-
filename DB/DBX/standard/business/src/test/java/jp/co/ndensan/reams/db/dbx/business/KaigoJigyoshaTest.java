/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.HojinsShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShiteiKijunGaitoJigyoshoKubun;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 事業者の情報を保持するクラスのテストクラスです。
 *
 * @author n3317 塚田萌
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaTest extends DbxTestBase {

    static class Constructor extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタにnullを指定した時_NullPointerException_をスローする() {
            KaigoJigyosha sut = new KaigoJigyosha(null);
        }
    }

    public static class BuilderTest {

        @Test
        public void setJigyoshaNoで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoshaNo(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(result.get事業者番号(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void setYukoKaishiYMDで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setYukoKaishiYMD(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日).build();
            assertThat(result.get有効開始日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日));
        }

        @Test
        public void setYukoShuryoYMDで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setYukoShuryoYMD(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効終了日).build();
            assertThat(result.get有効終了日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効終了日));
        }

        @Test
        public void setIdoYMDで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setIdoYMD(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_異動日).build();
            assertThat(result.get異動日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_異動日));
        }

        @Test
        public void setIdoJiyuCodeで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setIdoJiyuCode(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_異動事由).build();
            assertThat(result.get異動事由(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_異動事由));
        }

        @Test
        public void setJigyoKaishiYMDで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoKaishiYMD(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業開始日).build();
            assertThat(result.get事業開始日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業開始日));
        }

        @Test
        public void setJigyoKyushiYMDで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoKyushiYMD(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業休止日).build();
            assertThat(result.get事業休止日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業休止日));
        }

        @Test
        public void setJigyoSaikaiYMDで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoSaikaiYMD(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業再開日).build();
            assertThat(result.get事業再開日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業再開日));
        }

        @Test
        public void setJigyoHaishiYMDで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoHaishiYMD(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業廃止日).build();
            assertThat(result.get事業廃止日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業廃止日));
        }

        @Test
        public void setJigyoshaNameで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoshaName(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者名称).build();
            assertThat(result.get事業者名称(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void setJigyoshaNameKanaで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoshaNameKana(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者名称カナ).build();
            assertThat(result.get事業者名称カナ(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void setYubinNoで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setYubinNo(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(result.get郵便番号(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void setJigyoshaAddressで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoshaAddress(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者住所).build();
            assertThat(result.get事業者住所(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者住所));
        }

        @Test
        public void setJigyoshaKanaAddressで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setJigyoshaKanaAddress(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者住所カナ).build();
            assertThat(result.get事業者住所カナ(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者住所カナ));
        }

        @Test
        public void setTelNoで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setTelNo(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_電話番号).build();
            assertThat(result.get電話番号(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void setFaxNoで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setFaxNo(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_FAX番号).build();
            assertThat(result.getFAX番号(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void setAtesakiBushoで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setAtesakiBusho(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先部署).build();
            assertThat(result.get宛先部署(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先部署));
        }

        @Test
        public void setAtesakininNameで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setAtesakininName(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先人名).build();
            assertThat(result.get宛先人名(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先人名));
        }

        @Test
        public void setAtesakininNamekanaで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setAtesakininNamekana(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先人名カナ).build();
            assertThat(result.get宛先人名カナ(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先人名カナ));
        }

        @Test
        public void setShozaiShichosonで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setShozaiShichoson(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_所在市町村).build();
            assertThat(result.get所在市町村(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_所在市町村));
        }

        @Test
        public void setServiceJisshiChiikiで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setServiceJisshiChiiki(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_サービス実施地域).build();
            assertThat(result.getサービス実施地域(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_サービス実施地域));
        }

        @Test
        public void setHojinShubetsuで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setHojinShubetsu(
                    new HojinsShubetsu(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_法人等種別)).build();
            assertThat(result.get法人等種別().value(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_法人等種別));
        }

        @Test
        public void setBedSuで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setBedSu(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_ベッド数.intValue()).build();
            assertThat(result.getベッド数(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_ベッド数.intValue()));
        }

        @Test
        public void setShozokuNinzuで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setShozokuNinzu(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_所属人数.intValue()).build();
            assertThat(result.get所属人数(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_所属人数.intValue()));
        }

        @Test
        public void setRiyoshaSuで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setRiyoshaSu(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_利用者数.intValue()).build();
            assertThat(result.get利用者数(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_利用者数.intValue()));
        }

        @Test
        public void setBikoで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setBiko(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_備考).build();
            assertThat(result.get備考(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void setDaihyoshaで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setDaihyosha(createDaihyosha()).build();
            assertThat(result.createDaihyosha().get代表者名(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名));
        }

        @Test
        public void setShiteiSerivceListで設定した値を_生成された_KaigoJigyoshaも保持する() {
            KaigoJigyosha result = KaigoJigyosha.newBuilder().setShiteiSerivceList(createServiceList()).build();
            assertThat(result.createShiteiServiceList().get(0).getサービス種類コード(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード));
        }

        private KaigoJigyoshaDaihyosha createDaihyosha() {
            return new KaigoJigyoshaDaihyosha(
                    DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity());
        }

        private List<KaigoJigyoshaShiteiService> createServiceList() {
            List<KaigoJigyoshaShiteiService> list = new ArrayList<>();
            list.add(new KaigoJigyoshaShiteiService(
                    DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity()));
            return list;
        }
    }

    public static class SerializationProxyTest {

        private KaigoJigyosha sut;

        @Before
        public void setUp() {
            sut = KaigoJigyosha.newBuilder().build();
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            sut.createBuilderForEdit().setJigyoshaNo(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号);
            String b64 = _Base64Serializer.serialize(sut.serialize());
            KaigoJigyosha desirialized = _Base64Serializer.deSerialize(b64, KaigoJigyosha.class);
            assertThat(desirialized.get事業者番号(), is(sut.get事業者番号()));
        }
    }

    public static class toEntityTest extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaRelateEntity entity = new KaigoJigyoshaRelateEntity();
            DbT7060KaigoJigyoshaEntity entityDbT7060 = new DbT7060KaigoJigyoshaEntity();
            entityDbT7060.setBiko(new RString("11"));
            entity.set事業者エンティティ(entityDbT7060);
            sut = new KaigoJigyosha(entity);
        }

        @Test
        public void LDNS_メソッドtoEntityが呼び出される場合_toEntityは_11を返す() {
            assertThat(sut.toEntity().get事業者エンティティ().getBiko(), is(new RString("11")));
        }
    }

    public static class コンストラクタTEST extends DbxTestBase {

        @Test
        public void LDNS_privateConstructor() throws Exception {
            java.lang.reflect.Constructor<KaigoJigyosha> constructor = KaigoJigyosha.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }

    }
}
