/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link KaigoServiceShurui}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiTest extends DbxTestBase {

    private static DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity;
    private static KaigoServiceShuruiCode サービス種類コード;
    private static FlexibleYearMonth 提供開始年月;

    @BeforeClass
    public static void setUpClass() {
        サービス種類コード = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
        提供開始年月 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoServiceShurui(null, 提供開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 提供開始年月がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoServiceShurui(サービス種類コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7130KaigoServiceShuruiEntityにセットされている() {
            sut = new KaigoServiceShurui(サービス種類コード, 提供開始年月);
            assertThat(sut.getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.get提供開始年月(), is(提供開始年月));
        }

        @Test
        public void 指定したキーが保持するKaigoServiceShuruiIdentifierにセットされている() {
            sut = new KaigoServiceShurui(サービス種類コード, 提供開始年月);
            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().get提供開始年月(), is(提供開始年月));
        }

        @Test
        public void 空のKaigoServiceNaiyouリストがセットされている() {
            sut = new KaigoServiceShurui(サービス種類コード, 提供開始年月);
            assertThat(sut.getKaigoServiceNaiyouList().size(), is(0));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したKaigoServiceShuruiRelateEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoServiceShurui(null);
        }

        @Test
        public void 指定したKaigoServiceShuruiRelateEntityの保持するDbT7130KaigoServiceShuruiEntityのキー情報を識別子が持つ() {
            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.set介護サービス種類Entity(kaigoServiceShuruiEntity);
            sut = new KaigoServiceShurui(entity);

            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().get提供開始年月(), is(提供開始年月));
        }

        @Test
        public void 指定したKaigoServiceShuruiRelateEntityの保持するFdT1309KaigoServiceNaiyouEntityがKaigoServiceNaiyouリストにセットされている() {
            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.set介護サービス種類Entity(kaigoServiceShuruiEntity);
            entity.set介護サービス内容Entity(Arrays.asList((DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity())));
            sut = new KaigoServiceShurui(entity);
            assertThat(sut.getKaigoServiceNaiyouList().size(), is(1));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);

            KaigoServiceShuruiEntity techoRelateEntity = new KaigoServiceShuruiEntity();
            techoRelateEntity.set介護サービス種類Entity(kaigoServiceShuruiEntity);
            sut = new KaigoServiceShurui(techoRelateEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(kaigoServiceShuruiEntity.getServiceShuruiCd()));
        }

        @Test
        public void get提供開始年月は_entityが持つ提供開始年月を返す() {
            assertThat(sut.get提供開始年月(), is(kaigoServiceShuruiEntity.getTeikyoKaishiYM()));
        }

        @Test
        public void get提供終了年月は_entityが持つ提供終了年月を返す() {
            assertThat(sut.get提供終了年月(), is(kaigoServiceShuruiEntity.getTeikyoshuryoYM()));
        }

        @Test
        public void getサービス種類名称は_entityが持つサービス種類名称を返す() {
            assertThat(sut.getサービス種類名称(), is(kaigoServiceShuruiEntity.getServiceShuruiMeisho()));
        }

        @Test
        public void getサービス種類略称は_entityが持つサービス種類略称を返す() {
            assertThat(sut.getサービス種類略称(), is(kaigoServiceShuruiEntity.getServiceShuruiRyakusho()));
        }

        @Test
        public void getサービス分類コードは_entityが持つサービス分類コードを返す() {
            assertThat(sut.getサービス分類コード(), is(kaigoServiceShuruiEntity.getServiceBunrruicode()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);

            KaigoServiceShuruiEntity techoRelateEntity = new KaigoServiceShuruiEntity();
            techoRelateEntity.set介護サービス種類Entity(kaigoServiceShuruiEntity);
            sut = new KaigoServiceShurui(techoRelateEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(kaigoServiceShuruiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);

            KaigoServiceShuruiEntity techoRelateEntity = new KaigoServiceShuruiEntity();
            techoRelateEntity.set介護サービス種類Entity(kaigoServiceShuruiEntity);
            sut = new KaigoServiceShurui(techoRelateEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;
        private static KaigoServiceShurui result;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);

        }

        @Test
        public void KaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがDeletedに指定されたKaigoServiceShuruiが返る() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Unchanged, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがDeletedに指定されたKaigoServiceShuruiが返る() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Modified, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがDeletedに指定されたKaigoServiceShuruiが返る() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Deleted, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Added, EntityDataState.Unchanged);
            result = sut.deleted();
        }

        @Test
        public void KaigoServiceShuruiが保持するKaigoServiceNaiyouで保持するEntityのEntityDataStateがUnchangedであった場合_deletedメソッド_によりEntityDataStateがDeletedとなる() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Unchanged, EntityDataState.Unchanged);
            result = sut.deleted();
            for (KaigoServiceNaiyou naiyou : result.getKaigoServiceNaiyouList()) {
                assertThat(naiyou.toEntity().getState(), is(EntityDataState.Deleted));
            }
        }
    }

    public static class getKaigoServiceNaiyouテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;
        private static KaigoServiceNaiyou resultKaigoServiceNaiyou;
        private static RString サービス種類コード_1;
        private static RString サービス種類コード_2;
        private static RString サービス種類コード_3;
        private static Decimal 主キー名4;
        private static KaigoServiceNaiyouIdentifier naiyouId;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);

            サービス種類コード_1 = new RString("01");
            サービス種類コード_2 = new RString("02");
            サービス種類コード_3 = new RString("03");
            主キー名4 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_履歴番号;
        }

        @Test
        public void 指定の識別子に該当するKaigoServiceNaiyouが存在する場合_getKaigoServiceNaiyou_は該当のKaigoServiceNaiyouを返す() {
            sut = TestSupport.createKaigoServiceShurui(サービス種類コード_1, サービス種類コード_2, サービス種類コード_3);
            naiyouId = new KaigoServiceNaiyouIdentifier(サービス種類コード, サービス種類コード_1, 提供開始年月, 主キー名4);
            resultKaigoServiceNaiyou = sut.getKaigoServiceNaiyou(naiyouId);
            assertThat(resultKaigoServiceNaiyou.identifier(), is(naiyouId));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定の識別子に該当するKaigoServiceNaiyouが存在しない場合_getKaigoServiceNaiyou_はIllegalArgumentExceptionを返す() {
            sut = TestSupport.createKaigoServiceShurui(サービス種類コード_1, サービス種類コード_2, サービス種類コード_3);
            
            naiyouId = new KaigoServiceNaiyouIdentifier(サービス種類コード, new RString("04"), 提供開始年月,  主キー名4);
            resultKaigoServiceNaiyou = sut.getKaigoServiceNaiyou(naiyouId);
        }
    }

    private static class TestSupport {

        private static DbT7131KaigoServiceNaiyouEntity techoNiniEntity_1;
        private static DbT7131KaigoServiceNaiyouEntity techoNiniEntity_2;
        private static DbT7131KaigoServiceNaiyouEntity techoNiniEntity_3;

        public static KaigoServiceShurui setStateKaigoServiceShurui(EntityDataState parentState, EntityDataState childState) {
            KaigoServiceShuruiEntity relateEntity = new KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setState(parentState);
            relateEntity.set介護サービス種類Entity(kaigoServiceShuruiEntity);

            List<DbT7131KaigoServiceNaiyouEntity> niniEntityList = new ArrayList<>();
            techoNiniEntity_1 = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            techoNiniEntity_1.setServiceShuruiCode(kaigoServiceShuruiEntity.getServiceShuruiCd());
            techoNiniEntity_1.setTeikyoKaishiYM(kaigoServiceShuruiEntity.getTeikyoKaishiYM());
            techoNiniEntity_1.setServiceKoumokuCode(new RString("001"));
            techoNiniEntity_1.setRirekiNo(Decimal.ONE);

            techoNiniEntity_1.setServiceName(new RString("値１"));
            techoNiniEntity_1.setState(childState);
            techoNiniEntity_2 = techoNiniEntity_1.clone();
            techoNiniEntity_2.setServiceName(new RString("値２"));
            niniEntityList.add(techoNiniEntity_1);
            niniEntityList.add(techoNiniEntity_2);
            relateEntity.set介護サービス内容Entity(niniEntityList);

            return new KaigoServiceShurui(relateEntity);
        }

        public static KaigoServiceShurui createKaigoServiceShurui(
                RString サービス項目コード_1,
                RString サービス項目コード_2,
                RString サービス項目コード_3
        ) {
            KaigoServiceShuruiEntity relateEntity = new KaigoServiceShuruiEntity();
            relateEntity.set介護サービス種類Entity(kaigoServiceShuruiEntity);

            List<DbT7131KaigoServiceNaiyouEntity> niniEntityList = new ArrayList<>();
            techoNiniEntity_1 = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            techoNiniEntity_1.setServiceShuruiCode(kaigoServiceShuruiEntity.getServiceShuruiCd());
            techoNiniEntity_1.setServiceKoumokuCode(サービス項目コード_1);
            techoNiniEntity_1.setTeikyoKaishiYM(kaigoServiceShuruiEntity.getTeikyoKaishiYM());
            techoNiniEntity_1.setRirekiNo(Decimal.ONE);
            techoNiniEntity_2 = techoNiniEntity_1.clone();
            techoNiniEntity_2.setServiceKoumokuCode(サービス項目コード_2);
            techoNiniEntity_3 = techoNiniEntity_1.clone();
            techoNiniEntity_3.setServiceKoumokuCode(サービス項目コード_3);
            niniEntityList.add(techoNiniEntity_1);
            niniEntityList.add(techoNiniEntity_2);
            niniEntityList.add(techoNiniEntity_3);
            relateEntity.set介護サービス内容Entity(niniEntityList);

            return new KaigoServiceShurui(relateEntity);
        }
    }
}
