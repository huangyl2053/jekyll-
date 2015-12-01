/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.kaigoserviceshurui.IKaigoServiceShuruiMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouManager;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link KaigoServiceShuruiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiManagerTest extends DbxTestDacBase {

    private static MapperProvider provider;
    private static IKaigoServiceShuruiMapper mapper;
    private static DbT7130KaigoServiceShuruiDac dac;
    private static KaigoServiceShuruiManager sut;
    private static KaigoServiceNaiyouManager 介護サービス内容Manager;
    private static KaigoServiceShuruiCode サービス種類コード;
    private static FlexibleYearMonth 提供開始年月;
    private static RString サービス項目コード;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void test() {
        provider = InstanceProvider.create(MapperProvider.class);
//        mapper = InstanceProvider.create(IKaigoServiceShuruiMapper.class);
        dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        介護サービス内容Manager = InstanceProvider.create(KaigoServiceNaiyouManager.class);
        sut = new KaigoServiceShuruiManager(provider, dac, 介護サービス内容Manager);
        サービス種類コード = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
        提供開始年月 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
        サービス項目コード = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
        履歴番号 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_履歴番号;
    }

    public static class createInstanceのテスト extends DbxTestDacBase {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            KaigoServiceShuruiManager result = KaigoServiceShuruiManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            KaigoServiceShuruiManager result = KaigoServiceShuruiManager.createInstance();
            assertThat(result, instanceOf(KaigoServiceShuruiManager.class));
        }
    }

    public static class get介護サービス種類 extends DbxTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護サービス種類(null);
        }

        @Test
        public void 検索結果がnullの場合() {

            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件
                    = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(サービス種類コード, 提供開始年月);
            KaigoServiceShurui result = sut.get介護サービス種類(介護サービス種類検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.set介護サービス種類Entity(DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity());
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件
                    = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(サービス種類コード, 提供開始年月);
            KaigoServiceShurui result = sut.get介護サービス種類(介護サービス種類検索条件);

            assertThat(result.getサービス種類コード().value(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class save介護サービス種類 extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.clearTable();
        }

        @Test
        public void insertに成功すると_trueが返る() {
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(サービス種類コード, 提供開始年月);
            assertThat(sut.save(介護サービス種類), is(true));
        }

//        @Test
//        public void insertに失敗すると_falseが返る() {
//// 介護サービス種類
//            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(0);
//            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(false);
//            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(サービス種類コード, 提供開始年月);
//
//            assertThat(sut.save(介護サービス種類), is(false));
//        }
////
//        @Test
//        public void updateに成功すると_trueが返る() {
//            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(サービス種類コード, 提供開始年月);
//            sut.save(介護サービス種類);
//
//            KaigoServiceShurui kaigoServiceShurui
//                    = sut.get介護サービス種類(KaigoServiceShuruiMapperParameter.createSelectByKeyParam(サービス種類コード, 提供開始年月));
//
//            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(kaigoServiceShurui.getKaigoServiceNaiyouList().get(0).toEntity());
//            介護サービス内容 = 介護サービス内容.createBuilderForEdit().set単位数(9).build();
//            kaigoServiceShurui = kaigoServiceShurui.createBuilderForEdit().setKaigoServiceNaiyou(介護サービス内容).build();
//
//            assertThat(sut.save(kaigoServiceShurui), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//// 介護サービス種類
//            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(0);
//            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(false);
//
//            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(サービス種類コード, 提供開始年月);
//            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
//            介護サービス種類 = TestSupport.modifiedKaigoServiceShurui(介護サービス種類);
//
//            assertThat(sut.save(介護サービス種類), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//// 介護サービス種類
//            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
//            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(true);
//
//            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(サービス種類コード, 提供開始年月);
//            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
//            介護サービス種類 = 介護サービス種類.deleted();
//
//            assertThat(sut.save(介護サービス種類), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//// 介護サービス種類
//            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(0);
//            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(false);
//
//            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(サービス種類コード, 提供開始年月);
//            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
//            介護サービス種類 = 介護サービス種類.deleted();
//
//            assertThat(sut.save(介護サービス種類), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//// 介護サービス種類
//            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(0);
//            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(false);
//
//            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(サービス種類コード, 提供開始年月);
//            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
//
//            assertThat(sut.save(介護サービス種類), is(false));
//        }
        @After
        public void after() {
            rollback();
        }
    }

    private static class TestSupport {

        public static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT7130KaigoServiceShuruiEntity.TABLE_NAME.toString());
            csvDataUtil.clearTable(sqlSession, DbT7131KaigoServiceNaiyouEntity.TABLE_NAME.toString());
        }

        public static KaigoServiceShurui createKaigoServiceShurui(KaigoServiceShuruiCode サービス種類コード,
                FlexibleYearMonth 提供開始年月) {
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(サービス種類コード, 提供開始年月);
            return 介護サービス種類.createBuilderForEdit()
                    .setサービス種類名称(new RString("サービス種類名称"))
                    .setサービス分類コード(new KaigoServiceBunruiCode(new RString("01")))
                    .setKaigoServiceNaiyou(createKaigoServiceNaiyou())
                    .build();
        }

        private static KaigoServiceNaiyou createKaigoServiceNaiyou() {

            return new KaigoServiceNaiyou(DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity());
        }

        public static KaigoServiceShurui initializeKaigoServiceShurui(KaigoServiceShurui 介護サービス種類) {

            DbT7130KaigoServiceShuruiEntity techoEntity = 介護サービス種類.toEntity();

            List<DbT7131KaigoServiceNaiyouEntity> KaigoServiceNaiyouEntityList = new ArrayList<>();
            List<KaigoServiceNaiyou> 介護サービス内容リスト = 介護サービス種類.getKaigoServiceNaiyouList();
            for (KaigoServiceNaiyou 介護サービス内容 : 介護サービス内容リスト) {
                KaigoServiceNaiyouEntityList.add(介護サービス内容.toEntity());
            }

            KaigoServiceShuruiEntity relateEntity = new KaigoServiceShuruiEntity();
            relateEntity.set介護サービス種類Entity(techoEntity);
            relateEntity.set介護サービス内容Entity(KaigoServiceNaiyouEntityList);
            relateEntity.initializeMd5ToEntities();

// 介護サービス種類
            return new KaigoServiceShurui(relateEntity);
        }

        public static KaigoServiceShurui modifiedKaigoServiceShurui(KaigoServiceShurui 介護サービス種類) {

// 介護サービス内容
            KaigoServiceNaiyouBuilder KaigoServiceNaiyouBuilder = 介護サービス種類.getKaigoServiceNaiyouList().get(0).createBuilderForEdit();
            KaigoServiceNaiyou KaigoServiceNaiyou = KaigoServiceNaiyouBuilder.setサービス略称(new RString("任意項目1を変更")).build();
            介護サービス種類 = 介護サービス種類.createBuilderForEdit()
                    .setサービス種類略称(new RString("交付備考を変更"))
                    // 介護サービス内容
                    .setKaigoServiceNaiyou(KaigoServiceNaiyou)
                    .build();
            return 介護サービス種類.modifiedModel();
        }
    }
}
