/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KaigoJigyoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaManagerTest {

    private static KaigoJigyoshaDac relateDac;
  // 介護事業者
    private static DbT7060KaigoJigyoshaDac dac;
    private static KaigoJigyoshaManager sut;
    private static KaigoJigyoshaDaihyoshaManager 介護事業者代表者Manager;
    private static KaigoJigyoshaShiteiServiceManager 介護事業者指定サービスManager;

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

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護事業者 extends FdaTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護事業者(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.getKaigoJigyosha(any(KaigoJigyoshaMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            主キー型1 主キー1 = XXXEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = XXXEntityGenerator.DEFAULT_主キー2;
            
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createXXXParam(主キー1, 主キー2);
            親ビジネスクラス result = sut.get介護事業者(介護事業者検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoJigyoshaEntity entity = new KaigoJigyoshaEntity();
            entity.setXXXEntity(XXXEntityGenerator.createXXXEntity());
            when(mapper.getKaigoJigyosha(any(KaigoJigyoshaMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            主キー型1 主キー1 = XXXEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = XXXEntityGenerator.DEFAULT_主キー2;
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createXXXParam(主キー1, 主キー2);
            親ビジネスクラス result = sut.get介護事業者(介護事業者検索条件);


            assertThat(result.get主キー1().value(), is(XXXEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護事業者リストBy主キー1 extends FdaTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護事業者リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.getKaigoJigyoshaBy主キー型1(any(KaigoJigyoshaMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            主キー型1 主キー1 = XXXEntityGenerator.DEFAULT_主キー1;
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createXXXParam(主キー1);
            List<親ビジネスクラス> result = sut.get介護事業者リストBy主キー1(介護事業者検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoJigyoshaEntity entity = new KaigoJigyoshaEntity();
            entity.setXXXEntity(XXXEntityGenerator.createXXXEntity());

            List<KaigoJigyoshaEntity> entityList = Arrays.asList(entity);
            when(mapper.getKaigoJigyoshaBy主キー型1(any(KaigoJigyoshaMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            主キー型1 主キー1 = XXXEntityGenerator.DEFAULT_主キー1;
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createXXXParam(主キー1);
            List<親ビジネスクラス> result = sut.get介護事業者リストBy主キー1(介護事業者検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(XXXEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save介護事業者 extends DbxTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(1);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(1);
            主キー型1 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー2;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);

            assertThat(sut.save(介護事業者)
                    , is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(1);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(1);
            主キー型1 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー2;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);

            assertThat(sut.save(介護事業者)
                    , is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(1);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー2;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeSeishinTecho(介護事業者);
            介護事業者 = TestSupport.modifiedKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者)
                    , is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(1);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー2;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeSeishinTecho(介護事業者);
            介護事業者 = TestSupport.modifiedKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者)
                    , is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(1);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー2;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = 介護事業者.deleted();

            assertThat(sut.save(介護事業者)
                    , is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(1);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー2;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = 介護事業者.deleted();

            assertThat(sut.save(介護事業者)
                    , is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(1);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_主キー2;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者)
                    , is(false));
        }
    }

    private static class TestSupport {

        public static KaigoJigyosha createKaigoJigyosha(主キー型1 主キー1, 主キー型2 主キー2) {
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(主キー1, 主キー2);
            return 介護事業者.createBuilderForEdit()
// 介護事業者代表者
                    .setKaigoJigyoshaDaihyosha(createKaigoJigyoshaDaihyosha(主キー1, 主キー2))
// 介護事業者指定サービス
                    .setKaigoJigyoshaShiteiService(createKaigoJigyoshaShiteiService(主キー1, 主キー2))
                    .build();
        }

// 介護事業者代表者
        private static KaigoJigyoshaDaihyosha createKaigoJigyoshaDaihyosha(主キー型1 主キー1, 主キー型2 主キー2) {
            return new KaigoJigyoshaDaihyosha(
                    主キー1, 
                    主キー2);
        }
// 介護事業者指定サービス
        private static KaigoJigyoshaShiteiService createKaigoJigyoshaShiteiService(主キー型1 主キー1, 主キー型2 主キー2) {
            return new KaigoJigyoshaShiteiService(
                    主キー1, 
                    主キー2);
        }

        public static KaigoJigyosha initializeKaigoJigyosha(KaigoJigyosha 介護事業者) {

            DbT7060KaigoJigyoshaEntity techoEntity = 介護事業者.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT7062KaigoJigyoshaDaihyoshaEntity> KaigoJigyoshaDaihyoshaEntityList = new ArrayList<>();
            List<KaigoJigyoshaDaihyosha> 介護事業者代表者リスト = XXX.getKaigoJigyoshaDaihyoshaList();
            for (KaigoJigyoshaDaihyosha 介護事業者代表者 : 介護事業者代表者リスト) {
                KaigoJigyoshaDaihyoshaEntityList.add(介護事業者代表者.toEntity());
            }
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> KaigoJigyoshaShiteiServiceEntityList = new ArrayList<>();
            List<KaigoJigyoshaShiteiService> 介護事業者指定サービスリスト = XXX.getKaigoJigyoshaShiteiServiceList();
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
            KaigoJigyoshaDaihyoshaBuilder KaigoJigyoshaDaihyoshaBuilder = XXX.getKaigoJigyoshaDaihyoshaList().get(0).createBuilderForEdit();
            KaigoJigyoshaDaihyosha KaigoJigyoshaDaihyosha = KaigoJigyoshaDaihyoshaBuilder.set任意項目1(new RString("任意項目1を変更")).build();
// 介護事業者指定サービス
            KaigoJigyoshaShiteiServiceBuilder KaigoJigyoshaShiteiServiceBuilder = XXX.getKaigoJigyoshaShiteiServiceList().get(0).createBuilderForEdit();
            KaigoJigyoshaShiteiService KaigoJigyoshaShiteiService = KaigoJigyoshaShiteiServiceBuilder.set任意項目1(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            XXX = XXX.createBuilderForEdit()
                    .set交付備考(new RString("交付備考を変更"))  // TODO 任意項目の値を変更してください。
// 介護事業者代表者
                    .setKaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyosha)
// 介護事業者指定サービス
                    .setKaigoJigyoshaShiteiService(KaigoJigyoshaShiteiService)
                    .build();
            return XXX.modified();
        }
    }
}
