/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyosha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceBuilder;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.KaigoJigyosha.KaigoJigyoshaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.kaigojigyosha.IKaigoJigyoshaMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaManager;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceManager;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KaigoJigyoshaManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoJigyoshaManagerTest {

//    private static KaigoJigyoshaDac relateDac;
    private static MapperProvider provider;
    private static IKaigoJigyoshaMapper mapper;
  // 介護事業者
    private static DbT7060KaigoJigyoshaDac dac;
    private static KaigoJigyoshaManager sut;
    private static KaigoJigyoshaDaihyoshaManager 介護事業者代表者Manager;
    private static KaigoJigyoshaShiteiServiceManager 介護事業者指定サービスManager;
    private static KaigoJigyoshaNo 事業者番号;
    private static KaigoServiceShuruiCode サービス種類コード;
    private static FlexibleDate 有効開始日;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IKaigoJigyoshaMapper.class);
// 介護事業者
        dac = mock(DbT7060KaigoJigyoshaDac.class);
        介護事業者代表者Manager = mock(KaigoJigyoshaDaihyoshaManager.class);
        介護事業者指定サービスManager = mock(KaigoJigyoshaShiteiServiceManager.class);
        sut = new KaigoJigyoshaManager(provider, dac, 
介護事業者代表者Manager,
介護事業者指定サービスManager);
        事業者番号 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号;
        サービス種類コード = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード;
        有効開始日 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効開始日;
    }
    
    
    public static class createInstanceのテスト {
    
        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            KaigoJigyoshaManager result = KaigoJigyoshaManager.createInstance();
            assertNotNull(result);
        }
        
        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            KaigoJigyoshaManager result = KaigoJigyoshaManager.createInstance();
            assertThat(result, instanceOf(KaigoJigyoshaManager.class));
        }
    }

    public static class get介護事業者 extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護事業者(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.getKaigoJigyoshaEntity(any(KaigoJigyoshaMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectByKeyParam(事業者番号, 有効開始日);
            KaigoJigyosha result = sut.get介護事業者(介護事業者検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoJigyoshaEntity entity = new KaigoJigyoshaEntity();
            entity.set介護事業者Entity(DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity());
            when(mapper.getKaigoJigyoshaEntity(any(KaigoJigyoshaMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectByKeyParam(事業者番号, 有効開始日);
            KaigoJigyosha result = sut.get介護事業者(介護事業者検索条件);


            assertThat(result.get事業者番号().value(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号.value()));
        }
    }

    public static class save介護事業者 extends DbxTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(事業者番号, サービス種類コード, 有効開始日);

            assertThat(sut.save(介護事業者)
                    , is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(0);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(false);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(false);
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(事業者番号, サービス種類コード, 有効開始日);

            assertThat(sut.save(介護事業者)
                    , is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);

            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(事業者番号, サービス種類コード, 有効開始日);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = TestSupport.modifiedKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者)
                    , is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(0);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(false);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(false);

            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(事業者番号, サービス種類コード, 有効開始日);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = TestSupport.modifiedKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者)
                    , is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);

            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(事業者番号, サービス種類コード, 有効開始日);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = 介護事業者.deleted();

            assertThat(sut.save(介護事業者)
                    , is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(0);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(false);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(false);

            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(事業者番号, サービス種類コード, 有効開始日);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = 介護事業者.deleted();

            assertThat(sut.save(介護事業者)
                    , is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(0);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(false);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(false);

            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(事業者番号, サービス種類コード, 有効開始日);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者)
                    , is(false));
        }
    }

    private static class TestSupport {

        public static KaigoJigyosha createKaigoJigyosha(KaigoJigyoshaNo 事業者番号,
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleDate 有効開始日) {
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(事業者番号, 有効開始日);
            return 介護事業者.createBuilderForEdit()
// 介護事業者代表者
                    .setKaigoJigyoshaDaihyosha(createKaigoJigyoshaDaihyosha(事業者番号, 
                    有効開始日))
// 介護事業者指定サービス
                    .setKaigoJigyoshaShiteiService(createKaigoJigyoshaShiteiService(事業者番号, サービス種類コード, 有効開始日))
                    .build();
        }

// 介護事業者代表者
        private static KaigoJigyoshaDaihyosha createKaigoJigyoshaDaihyosha(KaigoJigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) {
            return new KaigoJigyoshaDaihyosha(
                    事業者番号, 
                    有効開始日);
        }
// 介護事業者指定サービス
        private static KaigoJigyoshaShiteiService createKaigoJigyoshaShiteiService(KaigoJigyoshaNo 事業者番号,
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleDate 有効開始日) {
            return new KaigoJigyoshaShiteiService(
                    事業者番号, サービス種類コード, 有効開始日);
        }

        public static KaigoJigyosha initializeKaigoJigyosha(KaigoJigyosha 介護事業者) {

            DbT7060KaigoJigyoshaEntity techoEntity = 介護事業者.toEntity();

            List<DbT7062KaigoJigyoshaDaihyoshaEntity> KaigoJigyoshaDaihyoshaEntityList = new ArrayList<>();
            List<KaigoJigyoshaDaihyosha> 介護事業者代表者リスト = 介護事業者.getKaigoJigyoshaDaihyoshaList();
            for (KaigoJigyoshaDaihyosha 介護事業者代表者 : 介護事業者代表者リスト) {
                KaigoJigyoshaDaihyoshaEntityList.add(介護事業者代表者.toEntity());
            }
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> KaigoJigyoshaShiteiServiceEntityList = new ArrayList<>();
            List<KaigoJigyoshaShiteiService> 介護事業者指定サービスリスト = 介護事業者.getKaigoJigyoshaShiteiServiceList();
            for (KaigoJigyoshaShiteiService 介護事業者指定サービス : 介護事業者指定サービスリスト) {
                KaigoJigyoshaShiteiServiceEntityList.add(介護事業者指定サービス.toEntity());
            }

            KaigoJigyoshaEntity relateEntity = new KaigoJigyoshaEntity();
            relateEntity.set介護事業者Entity(techoEntity);
            relateEntity.set介護事業者代表者Entity(KaigoJigyoshaDaihyoshaEntityList);
            relateEntity.set介護事業者指定サービスEntity(KaigoJigyoshaShiteiServiceEntityList);
            relateEntity.initializeMd5ToEntities();

// 介護事業者
            return new KaigoJigyosha(relateEntity);
        }

        public static KaigoJigyosha modifiedKaigoJigyosha(KaigoJigyosha 介護事業者) {

// 介護事業者代表者
            KaigoJigyoshaDaihyoshaBuilder KaigoJigyoshaDaihyoshaBuilder = 介護事業者.getKaigoJigyoshaDaihyoshaList().get(0).createBuilderForEdit();
            KaigoJigyoshaDaihyosha KaigoJigyoshaDaihyosha = KaigoJigyoshaDaihyoshaBuilder.set代表者住所カナ(new RString("任意項目1を変更")).build();
// 介護事業者指定サービス
            KaigoJigyoshaShiteiServiceBuilder KaigoJigyoshaShiteiServiceBuilder = 介護事業者.getKaigoJigyoshaShiteiServiceList().get(0).createBuilderForEdit();
            KaigoJigyoshaShiteiService KaigoJigyoshaShiteiService = KaigoJigyoshaShiteiServiceBuilder.set事業者住所カナ(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            介護事業者 = 介護事業者.createBuilderForEdit()
                    .set事業者住所カナ(new RString("交付備考を変更"))
// 介護事業者代表者
                    .setKaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyosha)
// 介護事業者指定サービス
                    .setKaigoJigyoshaShiteiService(KaigoJigyoshaShiteiService)
                    .build();
            return 介護事業者.modifiedModel();
        }
    }
}
