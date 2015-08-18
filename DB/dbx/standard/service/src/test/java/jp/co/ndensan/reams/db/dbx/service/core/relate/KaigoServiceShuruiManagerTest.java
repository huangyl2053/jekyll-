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
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceNaiyouBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.relate.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.relate.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.relate.IKaigoServiceShuruiMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoServiceNaiyouManager;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link KaigoServiceShuruiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiManagerTest {

//    private static KaigoServiceShuruiDac relateDac;
    // 介護サービス種類
    private static DbT7130KaigoServiceShuruiDac dac;
    private static KaigoServiceShuruiManager sut;
    private static KaigoServiceNaiyouManager 介護サービス内容Manager;

    private static MapperProvider provider;
    private static IKaigoServiceShuruiMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IKaigoServiceShuruiMapper.class);
// 介護サービス種類
        dac = mock(DbT7130KaigoServiceShuruiDac.class);
        介護サービス内容Manager = mock(KaigoServiceNaiyouManager.class);
        sut = new KaigoServiceShuruiManager(provider, dac,
                介護サービス内容Manager);
    }

    public static class createInstanceのテスト {

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

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護サービス種類 extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護サービス種類(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select介護サービス種類ByKey(any(KaigoServiceShuruiMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;

            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            KaigoServiceShurui result = sut.get介護サービス種類(介護サービス種類検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.set介護サービス種類Entity(DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity());
            when(mapper.select介護サービス種類ByKey(any(KaigoServiceShuruiMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            KaigoServiceShurui result = sut.get介護サービス種類(介護サービス種類検索条件);

            assertThat(result.getサービス種類コード(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護サービス種類リストBy主キー1 extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護サービス種類リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select介護サービス種類リストBy主キー1(any(KaigoServiceShuruiMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createSelectListParam(主キー1);
            List<KaigoServiceShurui> result = sut.get介護サービス種類リストBy主キー1(介護サービス種類検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.set介護サービス種類Entity(DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity());

            List<KaigoServiceShuruiEntity> entityList = Arrays.asList(entity);
            when(mapper.select介護サービス種類リストBy主キー1(any(KaigoServiceShuruiMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createSelectListParam(主キー1);
            List<KaigoServiceShurui> result = sut.get介護サービス種類リストBy主キー1(介護サービス種類検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサービス種類コード().value(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class save介護サービス種類 extends DbxTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(true);
            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);

            assertThat(sut.save(介護サービス種類), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(true);
            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);

            assertThat(sut.save(介護サービス種類), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(true);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
            介護サービス種類 = TestSupport.modifiedKaigoServiceShurui(介護サービス種類);

            assertThat(sut.save(介護サービス種類), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(true);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
            介護サービス種類 = TestSupport.modifiedKaigoServiceShurui(介護サービス種類);

            assertThat(sut.save(介護サービス種類), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(true);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
            介護サービス種類 = 介護サービス種類.deleted();

            assertThat(sut.save(介護サービス種類), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(true);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
            介護サービス種類 = 介護サービス種類.deleted();

            assertThat(sut.save(介護サービス種類), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(true);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);

            assertThat(sut.save(介護サービス種類), is(false));
        }
    }

    private static class TestSupport {

        public static KaigoServiceShurui createKaigoServiceShurui(KaigoServiceShuruiCode 主キー1, FlexibleYearMonth 主キー2) {
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(主キー1, 主キー2);
            return 介護サービス種類.createBuilderForEdit()
                    // 介護サービス内容
                    .setKaigoServiceNaiyou(createKaigoServiceNaiyou(主キー1, 主キー2))
                    .build();
        }

// 介護サービス内容
        private static KaigoServiceNaiyou createKaigoServiceNaiyou(KaigoServiceShuruiCode 主キー1, FlexibleYearMonth 主キー2) {
            return new KaigoServiceNaiyou(
                    主キー1, RString.EMPTY, 主キー2, Decimal.ZERO);
        }

        public static KaigoServiceShurui initializeKaigoServiceShurui(KaigoServiceShurui 介護サービス種類) {

            DbT7130KaigoServiceShuruiEntity techoEntity = 介護サービス種類.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
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
            return new KaigoServiceShurui(relateEntity.get介護サービス種類Entity());
        }

        public static KaigoServiceShurui modifiedKaigoServiceShurui(KaigoServiceShurui 介護サービス種類) {

// 介護サービス内容
            KaigoServiceNaiyouBuilder KaigoServiceNaiyouBuilder = 介護サービス種類.getKaigoServiceNaiyouList().get(0).createBuilderForEdit();
            KaigoServiceNaiyou KaigoServiceNaiyou = KaigoServiceNaiyouBuilder.setサービス略称(new RString("りゃっくしょー")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            介護サービス種類 = 介護サービス種類.createBuilderForEdit()
                    .setサービス種類略称(new RString("略称")) // TODO 任意項目の値を変更してください。
                    // 介護サービス内容
                    .setKaigoServiceNaiyou(KaigoServiceNaiyou)
                    .build();
            return 介護サービス種類.modifiedModel();
        }
    }
}
