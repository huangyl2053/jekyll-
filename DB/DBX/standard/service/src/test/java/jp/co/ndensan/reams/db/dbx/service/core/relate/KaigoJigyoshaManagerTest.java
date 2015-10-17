/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.relate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyoshaDaihyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyoshaShiteiServiceBuilder;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.relate.KaigoJigyoshaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.relate.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.relate.IKaigoJigyoshaMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoJigyoshaDaihyoshaManager;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoJigyoshaShiteiServiceManager;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;
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

//    private static KaigoJigyoshaDac relateDac;
    // 介護事業者
    private static DbT7060KaigoJigyoshaDac dac;
    private static KaigoJigyoshaManager sut;
    private static KaigoJigyoshaDaihyoshaManager 介護事業者代表者Manager;
    private static KaigoJigyoshaShiteiServiceManager 介護事業者指定サービスManager;

    private static MapperProvider provider;
    private static IKaigoJigyoshaMapper mapper;

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
    public static class get介護事業者 extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護事業者(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select介護事業者ByKey(any(KaigoJigyoshaMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;

            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            KaigoJigyosha result = sut.get介護事業者(介護事業者検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoJigyoshaEntity entity = new KaigoJigyoshaEntity();
            entity.set介護事業者Entity(DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity());
            when(mapper.select介護事業者ByKey(any(KaigoJigyoshaMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            KaigoJigyosha result = sut.get介護事業者(介護事業者検索条件);

            assertThat(result.get事業者番号().value(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護事業者リストBy主キー1 extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護事業者リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select介護事業者リストBy主キー1(any(KaigoJigyoshaMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectListParam(主キー1);
            List<KaigoJigyosha> result = sut.get介護事業者リストBy主キー1(介護事業者検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoJigyoshaEntity entity = new KaigoJigyoshaEntity();
            entity.set介護事業者Entity(DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity());

            List<KaigoJigyoshaEntity> entityList = Arrays.asList(entity);
            when(mapper.select介護事業者リストBy主キー1(any(KaigoJigyoshaMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectListParam(主キー1);
            List<KaigoJigyosha> result = sut.get介護事業者リストBy主キー1(介護事業者検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get事業者番号().value(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号.value()));
        }
    }

    public static class save介護事業者 extends DbxTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);
            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);

            assertThat(sut.save(介護事業者), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);
            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);

            assertThat(sut.save(介護事業者), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = TestSupport.modifiedKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = TestSupport.modifiedKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = 介護事業者.deleted();

            assertThat(sut.save(介護事業者), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);
            介護事業者 = 介護事業者.deleted();

            assertThat(sut.save(介護事業者), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護事業者
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);
            when(介護事業者代表者Manager.save介護事業者代表者(any(KaigoJigyoshaDaihyosha.class))).thenReturn(true);
            when(介護事業者指定サービスManager.save介護事業者指定サービス(any(KaigoJigyoshaShiteiService.class))).thenReturn(true);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha 介護事業者 = TestSupport.createKaigoJigyosha(主キー1, 主キー2);
            介護事業者 = TestSupport.initializeKaigoJigyosha(介護事業者);

            assertThat(sut.save(介護事業者), is(false));
        }
    }

    private static class TestSupport {

        public static KaigoJigyosha createKaigoJigyosha(KaigoJigyoshaNo 主キー1, FlexibleDate 主キー2) {
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(主キー1, 主キー2);
            return 介護事業者.createBuilderForEdit()
                    // 介護事業者代表者
                    .setKaigoJigyoshaDaihyosha(createKaigoJigyoshaDaihyosha(主キー1, 主キー2))
                    // 介護事業者指定サービス
                    .setKaigoJigyoshaShiteiService(createKaigoJigyoshaShiteiService(主キー1, 主キー2))
                    .build();
        }

// 介護事業者代表者
        private static KaigoJigyoshaDaihyosha createKaigoJigyoshaDaihyosha(KaigoJigyoshaNo 主キー1, FlexibleDate 主キー2) {
            return new KaigoJigyoshaDaihyosha(
                    主キー1, 主キー2);
        }
// 介護事業者指定サービス

        private static KaigoJigyoshaShiteiService createKaigoJigyoshaShiteiService(KaigoJigyoshaNo 主キー1, FlexibleDate 主キー2) {
            return new KaigoJigyoshaShiteiService(
                    主キー1, KaigoServiceShuruiCode.EMPTY, 主キー2);
        }

        public static KaigoJigyosha initializeKaigoJigyosha(KaigoJigyosha 介護事業者) {

            DbT7060KaigoJigyoshaEntity techoEntity = 介護事業者.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
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
            return new KaigoJigyosha(relateEntity.get介護事業者Entity());
        }

        public static KaigoJigyosha modifiedKaigoJigyosha(KaigoJigyosha 介護事業者) {

// 介護事業者代表者
            KaigoJigyoshaDaihyoshaBuilder KaigoJigyoshaDaihyoshaBuilder = 介護事業者.getKaigoJigyoshaDaihyoshaList().get(0).createBuilderForEdit();
            KaigoJigyoshaDaihyosha KaigoJigyoshaDaihyosha = KaigoJigyoshaDaihyoshaBuilder.set代表者名(new AtenaMeisho("任意項目1を変更")).build();
// 介護事業者指定サービス
            KaigoJigyoshaShiteiServiceBuilder KaigoJigyoshaShiteiServiceBuilder = 介護事業者.getKaigoJigyoshaShiteiServiceList().get(0).createBuilderForEdit();
            KaigoJigyoshaShiteiService KaigoJigyoshaShiteiService = KaigoJigyoshaShiteiServiceBuilder.set事業者名称(new AtenaMeisho("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            介護事業者 = 介護事業者.createBuilderForEdit()
                    .set備考(new RString("備考を変更")) // TODO 任意項目の値を変更してください。
                    // 介護事業者代表者
                    .setKaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyosha)
                    // 介護事業者指定サービス
                    .setKaigoJigyoshaShiteiService(KaigoJigyoshaShiteiService)
                    .build();
            return 介護事業者.modifiedModel();
        }
    }
}
