/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaTest extends DbxTestBase {

    private static DbT7060KaigoJigyoshaEntity kaigoJigyoshaEntity;
    private static KaigoJigyoshaNo 事業者番号;
    private static FlexibleDate 有効開始日;

    @BeforeClass
    public static void setUpClass() {

        事業者番号 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
        有効開始日 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            kaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            kaigoJigyoshaEntity.setJigyoshaNo(事業者番号);
            kaigoJigyoshaEntity.setYukoKaishiYMD(有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyosha(null, 有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyosha(事業者番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT7060KaigoJigyoshaEntityにセットされている() {
            sut = new KaigoJigyosha(事業者番号, 有効開始日);
            assertThat(sut.get事業者番号(), is(事業者番号));
            assertThat(sut.get有効開始日(), is(有効開始日));
        }

        @Test
        public void 指定したキーが保持するKaigoJigyoshaIdentifierにセットされている() {
            sut = new KaigoJigyosha(事業者番号, 有効開始日);
            assertThat(sut.identifier().get事業者番号(), is(事業者番号));
            assertThat(sut.identifier().get有効開始日(), is(有効開始日));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            kaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            kaigoJigyoshaEntity.setJigyoshaNo(事業者番号);
            kaigoJigyoshaEntity.setYukoKaishiYMD(有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoJigyosha(null);
        }

        @Test
        public void 指定したDbT7060KaigoJigyoshaEntityのキー情報を識別子が持つ() {

            KaigoJigyoshaEntity techoRelateEntity = new KaigoJigyoshaEntity();
            techoRelateEntity.set介護事業者Entity(kaigoJigyoshaEntity);
            sut = new KaigoJigyosha(techoRelateEntity);
            assertThat(sut.identifier().get事業者番号(), is(事業者番号));
            assertThat(sut.identifier().get有効開始日(), is(有効開始日));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            kaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            kaigoJigyoshaEntity.setJigyoshaNo(事業者番号);
            kaigoJigyoshaEntity.setYukoKaishiYMD(有効開始日);

            KaigoJigyoshaEntity techoRelateEntity = new KaigoJigyoshaEntity();
            techoRelateEntity.set介護事業者Entity(kaigoJigyoshaEntity);
            sut = new KaigoJigyosha(techoRelateEntity);
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(kaigoJigyoshaEntity.getJigyoshaNo()));
        }

        @Test
        public void get有効開始日は_entityが持つ有効開始日を返す() {
            assertThat(sut.get有効開始日(), is(kaigoJigyoshaEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効終了日は_entityが持つ有効終了日を返す() {
            assertThat(sut.get有効終了日(), is(kaigoJigyoshaEntity.getYukoShuryoYMD()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(kaigoJigyoshaEntity.getIdoYMD()));
        }

        @Test
        public void get異動事由は_entityが持つ異動事由を返す() {
            assertThat(sut.get異動事由(), is(kaigoJigyoshaEntity.getIdoJiyuCode()));
        }

        @Test
        public void get事業開始日は_entityが持つ事業開始日を返す() {
            assertThat(sut.get事業開始日(), is(kaigoJigyoshaEntity.getJigyoKaishiYMD()));
        }

        @Test
        public void get事業休止日は_entityが持つ事業休止日を返す() {
            assertThat(sut.get事業休止日(), is(kaigoJigyoshaEntity.getJigyoKyushiYMD()));
        }

        @Test
        public void get事業再開日は_entityが持つ事業再開日を返す() {
            assertThat(sut.get事業再開日(), is(kaigoJigyoshaEntity.getJigyoSaikaiYMD()));
        }

        @Test
        public void get事業廃止日は_entityが持つ事業廃止日を返す() {
            assertThat(sut.get事業廃止日(), is(kaigoJigyoshaEntity.getJigyoHaishiYMD()));
        }

        @Test
        public void get事業者名称は_entityが持つ事業者名称を返す() {
            assertThat(sut.get事業者名称(), is(kaigoJigyoshaEntity.getJigyoshaName()));
        }

        @Test
        public void get事業者名称カナは_entityが持つ事業者名称カナを返す() {
            assertThat(sut.get事業者名称カナ(), is(kaigoJigyoshaEntity.getJigyoshaNameKana()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(kaigoJigyoshaEntity.getYubinNo()));
        }

        @Test
        public void get事業者住所は_entityが持つ事業者住所を返す() {
            assertThat(sut.get事業者住所(), is(kaigoJigyoshaEntity.getJigyoshaAddress()));
        }

        @Test
        public void get事業者住所カナは_entityが持つ事業者住所カナを返す() {
            assertThat(sut.get事業者住所カナ(), is(kaigoJigyoshaEntity.getJigyoshaKanaAddress()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(kaigoJigyoshaEntity.getTelNo()));
        }

        @Test
        public void getFAX番号は_entityが持つFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(kaigoJigyoshaEntity.getFaxNo()));
        }

        @Test
        public void get宛先部署は_entityが持つ宛先部署を返す() {
            assertThat(sut.get宛先部署(), is(kaigoJigyoshaEntity.getAtesakiBusho()));
        }

        @Test
        public void get宛先人名は_entityが持つ宛先人名を返す() {
            assertThat(sut.get宛先人名(), is(kaigoJigyoshaEntity.getAtesakininName()));
        }

        @Test
        public void get宛先人名カナは_entityが持つ宛先人名カナを返す() {
            assertThat(sut.get宛先人名カナ(), is(kaigoJigyoshaEntity.getAtesakininNamekana()));
        }

        @Test
        public void get指定_基準該当等事業所区分は_entityが持つ指定_基準該当等事業所区分を返す() {
            assertThat(sut.get指定_基準該当等事業所区分(), is(kaigoJigyoshaEntity.getShiteiKijungaitoJigyoshaKubun()));
        }

        @Test
        public void get所在市町村は_entityが持つ所在市町村を返す() {
            assertThat(sut.get所在市町村(), is(kaigoJigyoshaEntity.getShozaiShichoson()));
        }

        @Test
        public void getサービス実施地域は_entityが持つサービス実施地域を返す() {
            assertThat(sut.getサービス実施地域(), is(kaigoJigyoshaEntity.getServiceJisshiChiiki()));
        }

        @Test
        public void get法人等種別は_entityが持つ法人等種別を返す() {
            assertThat(sut.get法人等種別(), is(kaigoJigyoshaEntity.getHojinShubetsu()));
        }

        @Test
        public void getベッド数は_entityが持つベッド数を返す() {
            assertThat(sut.getベッド数(), is(kaigoJigyoshaEntity.getBedSu()));
        }

        @Test
        public void get所属人数は_entityが持つ所属人数を返す() {
            assertThat(sut.get所属人数(), is(kaigoJigyoshaEntity.getShozokuNinzu()));
        }

        @Test
        public void get利用者数は_entityが持つ利用者数を返す() {
            assertThat(sut.get利用者数(), is(kaigoJigyoshaEntity.getRiyoshaSu()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(kaigoJigyoshaEntity.getBiko()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            kaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            kaigoJigyoshaEntity.setJigyoshaNo(事業者番号);
            kaigoJigyoshaEntity.setYukoKaishiYMD(有効開始日);

            KaigoJigyoshaEntity techoRelateEntity = new KaigoJigyoshaEntity();
            techoRelateEntity.set介護事業者Entity(kaigoJigyoshaEntity);
            sut = new KaigoJigyosha(techoRelateEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(kaigoJigyoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoJigyosha sut;

        @Before
        public void setUp() {
            kaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            kaigoJigyoshaEntity.setJigyoshaNo(事業者番号);
            kaigoJigyoshaEntity.setYukoKaishiYMD(有効開始日);

            KaigoJigyoshaEntity techoRelateEntity = new KaigoJigyoshaEntity();
            techoRelateEntity.set介護事業者Entity(kaigoJigyoshaEntity);
            sut = new KaigoJigyosha(techoRelateEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoJigyosha sut;
        private static KaigoJigyosha result;

        @Before
        public void setUp() {
            kaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            kaigoJigyoshaEntity.setJigyoshaNo(事業者番号);
            kaigoJigyoshaEntity.setYukoKaishiYMD(有効開始日);
        }

        @Test
        public void KaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Unchanged, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Modified, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Deleted, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoJigyoshaが保持するDbT7060KaigoJigyoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Added, EntityDataState.Unchanged);
            result = sut.deleted();
        }

        @Test
        public void KaigoJigyoshaが保持するKaigoJigyoshaShiteiServiceで保持するEntityのEntityDataStateがUnchangedであった場合_deletedメソッド_によりEntityDataStateがDeletedとなる() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Unchanged, EntityDataState.Unchanged);
            result = sut.deleted();
            for (KaigoJigyoshaShiteiService seishinTechoNini : result.getKaigoJigyoshaShiteiServiceList()) {
                assertThat(seishinTechoNini.toEntity().getState(), is(EntityDataState.Deleted));
            }
        }

        @Test
        public void KaigoJigyoshaが保持するKaigoJigyoshaShiteiServiceで保持するEntityのEntityDataStateがAddedのみであった場合_deletedメソッド_によりKaigoJigyoshaShiteiServiceリストのサイズが0となる() {
            sut = TestSupport.setStateKaigoJigyosha(EntityDataState.Unchanged, EntityDataState.Added);
            result = sut.deleted();
            assertThat(result.getKaigoJigyoshaShiteiServiceList().size(), is(0));
        }

    }

    public static class getKaigoJigyoshaShiteiServiceテスト extends DbxTestBase {

        private static KaigoJigyosha sut;
        private static KaigoJigyoshaShiteiService resultKaigoJigyoshaShiteiService;
        private static KaigoJigyoshaNo 事業者番号_1;
        private static KaigoJigyoshaNo 事業者番号_2;
        private static KaigoJigyoshaNo 事業者番号_3;
        private static KaigoServiceShuruiCode サービス種類コード;
        private static KaigoJigyoshaShiteiServiceIdentifier KaigoJigyoshaShiteiServiceId;

        @Before
        public void setUp() {
            kaigoJigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            事業者番号_1 = new KaigoJigyoshaNo("1234567890");
            事業者番号_2 = new KaigoJigyoshaNo("1234567891");
            事業者番号_3 = new KaigoJigyoshaNo("1234567892");
            サービス種類コード = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード;
        }

        @Test
        public void 指定の識別子に該当するKaigoJigyoshaShiteiServiceが存在する場合_getKaigoJigyoshaShiteiService_は該当のKaigoJigyoshaShiteiServiceを返す() {
            sut = TestSupport.createKaigoJigyosha(事業者番号_1, 事業者番号_2, 事業者番号_3);
            KaigoJigyoshaShiteiServiceId = new KaigoJigyoshaShiteiServiceIdentifier(事業者番号_3, サービス種類コード, 有効開始日);
            resultKaigoJigyoshaShiteiService = sut.getKaigoJigyoshaShiteiServiceList(KaigoJigyoshaShiteiServiceId);
            assertThat(resultKaigoJigyoshaShiteiService.identifier(), is(KaigoJigyoshaShiteiServiceId));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定の識別子に該当するKaigoJigyoshaShiteiServiceが存在しない場合_getKaigoJigyoshaShiteiService_はIllegalArgumentExceptionを返す() {
            sut = TestSupport.createKaigoJigyosha(事業者番号_1, 事業者番号_2, 事業者番号_3);
            KaigoJigyoshaShiteiServiceId = new KaigoJigyoshaShiteiServiceIdentifier(new KaigoJigyoshaNo("値_4"), サービス種類コード, 有効開始日);
            resultKaigoJigyoshaShiteiService = sut.getKaigoJigyoshaShiteiServiceList(KaigoJigyoshaShiteiServiceId);
        }
    }

    private static class TestSupport {

        private static DbT7063KaigoJigyoshaShiteiServiceEntity KaigoJigyoshaShiteiServiceEntity_1;
        private static DbT7063KaigoJigyoshaShiteiServiceEntity KaigoJigyoshaShiteiServiceEntity_2;
        private static DbT7063KaigoJigyoshaShiteiServiceEntity KaigoJigyoshaShiteiServiceEntity_3;

        public static KaigoJigyosha setStateKaigoJigyosha(EntityDataState parentState, EntityDataState childState) {
            KaigoJigyoshaEntity relateEntity = new KaigoJigyoshaEntity();

            kaigoJigyoshaEntity.setState(parentState);
            relateEntity.set介護事業者Entity(kaigoJigyoshaEntity);

            List<DbT7063KaigoJigyoshaShiteiServiceEntity> niniEntityList = new ArrayList<>();
            KaigoJigyoshaShiteiServiceEntity_1 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity_1.setJigyoshaNo(kaigoJigyoshaEntity.getJigyoshaNo());
            KaigoJigyoshaShiteiServiceEntity_1.setYukoKaishiYMD(kaigoJigyoshaEntity.getYukoKaishiYMD());
            KaigoJigyoshaShiteiServiceEntity_1.setIdoJiyu(new RString("値１"));
            KaigoJigyoshaShiteiServiceEntity_1.setState(childState);
            KaigoJigyoshaShiteiServiceEntity_2 = KaigoJigyoshaShiteiServiceEntity_1.clone();
            KaigoJigyoshaShiteiServiceEntity_2.setIdoJiyu(new RString("値２"));
            niniEntityList.add(KaigoJigyoshaShiteiServiceEntity_1);
            niniEntityList.add(KaigoJigyoshaShiteiServiceEntity_2);
            relateEntity.set介護事業者指定サービスEntity(niniEntityList);

            return new KaigoJigyosha(relateEntity);
        }

        public static KaigoJigyosha createKaigoJigyosha(
                KaigoJigyoshaNo 事業者番号_1,
                KaigoJigyoshaNo 事業者番号_2,
                KaigoJigyoshaNo 事業者番号_3
        ) {
            KaigoJigyoshaEntity relateEntity = new KaigoJigyoshaEntity();
            relateEntity.set介護事業者Entity(kaigoJigyoshaEntity);

            List<DbT7063KaigoJigyoshaShiteiServiceEntity> niniEntityList = new ArrayList<>();
            KaigoJigyoshaShiteiServiceEntity_1 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity_1.setJigyoshaNo(事業者番号_1);
            KaigoJigyoshaShiteiServiceEntity_1.setYukoKaishiYMD(kaigoJigyoshaEntity.getYukoKaishiYMD());
            KaigoJigyoshaShiteiServiceEntity_2 = KaigoJigyoshaShiteiServiceEntity_1.clone();
            KaigoJigyoshaShiteiServiceEntity_2.setJigyoshaNo(事業者番号_2);
            KaigoJigyoshaShiteiServiceEntity_3 = KaigoJigyoshaShiteiServiceEntity_1.clone();
            KaigoJigyoshaShiteiServiceEntity_3.setJigyoshaNo(事業者番号_3);
            niniEntityList.add(KaigoJigyoshaShiteiServiceEntity_1);
            niniEntityList.add(KaigoJigyoshaShiteiServiceEntity_2);
            niniEntityList.add(KaigoJigyoshaShiteiServiceEntity_3);
            relateEntity.set介護事業者指定サービスEntity(niniEntityList);

            return new KaigoJigyosha(relateEntity);
        }
    }
}
