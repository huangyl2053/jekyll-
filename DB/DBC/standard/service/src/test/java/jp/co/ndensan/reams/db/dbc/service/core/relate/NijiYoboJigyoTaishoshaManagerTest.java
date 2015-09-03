/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboKihonCheckList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboKihonCheckListBuilder;
import jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate.NijiYoboJigyoTaishoshaMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3100NijiYoboJigyoTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.relate.NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3100NijiYoboJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate.INijiYoboJigyoTaishoshaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
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
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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

/**
 * {link NijiYoboJigyoTaishoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboJigyoTaishoshaManagerTest {

//    private static NijiYoboJigyoTaishoshaDac relateDac;
    // 二次予防事業対象者
    private static DbT3100NijiYoboJigyoTaishoshaDac dac;
    private static NijiYoboJigyoTaishoshaManager sut;
    private static NijiYoboKihonCheckListManager 二次予防基本チェックリストManager;

    private static MapperProvider provider;
    private static INijiYoboJigyoTaishoshaMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(INijiYoboJigyoTaishoshaMapper.class);
// 二次予防事業対象者
        dac = mock(DbT3100NijiYoboJigyoTaishoshaDac.class);
        二次予防基本チェックリストManager = mock(NijiYoboKihonCheckListManager.class);
        sut = new NijiYoboJigyoTaishoshaManager(provider, dac,
                二次予防基本チェックリストManager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            NijiYoboJigyoTaishoshaManager result = NijiYoboJigyoTaishoshaManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            NijiYoboJigyoTaishoshaManager result = NijiYoboJigyoTaishoshaManager.createInstance();
            assertThat(result, instanceOf(NijiYoboJigyoTaishoshaManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防事業対象者 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get二次予防事業対象者(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select二次予防事業対象者ByKey(any(NijiYoboJigyoTaishoshaMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;

            NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件 = NijiYoboJigyoTaishoshaMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            NijiYoboJigyoTaishosha result = sut.get二次予防事業対象者(二次予防事業対象者検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            NijiYoboJigyoTaishoshaEntity entity = new NijiYoboJigyoTaishoshaEntity();
            entity.set二次予防事業対象者Entity(DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity());
            when(mapper.select二次予防事業対象者ByKey(any(NijiYoboJigyoTaishoshaMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件 = NijiYoboJigyoTaishoshaMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            NijiYoboJigyoTaishosha result = sut.get二次予防事業対象者(二次予防事業対象者検索条件);

            assertThat(result.get証記載保険者番号(), is(DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防事業対象者リストBy主キー1 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get二次予防事業対象者リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select二次予防事業対象者リストBy主キー1(any(NijiYoboJigyoTaishoshaMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件 = NijiYoboJigyoTaishoshaMapperParameter.createSelectListParam(主キー1);
            List<NijiYoboJigyoTaishosha> result = sut.get二次予防事業対象者リストBy主キー1(二次予防事業対象者検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            NijiYoboJigyoTaishoshaEntity entity = new NijiYoboJigyoTaishoshaEntity();
            entity.set二次予防事業対象者Entity(DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity());

            List<NijiYoboJigyoTaishoshaEntity> entityList = Arrays.asList(entity);
            when(mapper.select二次予防事業対象者リストBy主キー1(any(NijiYoboJigyoTaishoshaMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件 = NijiYoboJigyoTaishoshaMapperParameter.createSelectListParam(主キー1);
            List<NijiYoboJigyoTaishosha> result = sut.get二次予防事業対象者リストBy主キー1(二次予防事業対象者検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get証記載保険者番号(), is(DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号));
        }
    }

    public static class save二次予防事業対象者 extends DbcTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 二次予防事業対象者
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);
            when(二次予防基本チェックリストManager.save(any(NijiYoboKihonCheckList.class))).thenReturn(true);
            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboJigyoTaishosha 二次予防事業対象者 = TestSupport.createNijiYoboJigyoTaishosha(主キー1, 主キー2);

            assertThat(sut.save(二次予防事業対象者), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 二次予防事業対象者
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);
            when(二次予防基本チェックリストManager.save(any(NijiYoboKihonCheckList.class))).thenReturn(true);
            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboJigyoTaishosha 二次予防事業対象者 = TestSupport.createNijiYoboJigyoTaishosha(主キー1, 主キー2);

            assertThat(sut.save(二次予防事業対象者), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 二次予防事業対象者
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);
            when(二次予防基本チェックリストManager.save(any(NijiYoboKihonCheckList.class))).thenReturn(true);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboJigyoTaishosha 二次予防事業対象者 = TestSupport.createNijiYoboJigyoTaishosha(主キー1, 主キー2);
            二次予防事業対象者 = TestSupport.initializeNijiYoboJigyoTaishosha(二次予防事業対象者);
            二次予防事業対象者 = TestSupport.modifiedNijiYoboJigyoTaishosha(二次予防事業対象者);

            assertThat(sut.save(二次予防事業対象者), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 二次予防事業対象者
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);
            when(二次予防基本チェックリストManager.save(any(NijiYoboKihonCheckList.class))).thenReturn(true);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboJigyoTaishosha 二次予防事業対象者 = TestSupport.createNijiYoboJigyoTaishosha(主キー1, 主キー2);
            二次予防事業対象者 = TestSupport.initializeNijiYoboJigyoTaishosha(二次予防事業対象者);
            二次予防事業対象者 = TestSupport.modifiedNijiYoboJigyoTaishosha(二次予防事業対象者);

            assertThat(sut.save(二次予防事業対象者), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 二次予防事業対象者
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);
            when(二次予防基本チェックリストManager.save(any(NijiYoboKihonCheckList.class))).thenReturn(true);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboJigyoTaishosha 二次予防事業対象者 = TestSupport.createNijiYoboJigyoTaishosha(主キー1, 主キー2);
            二次予防事業対象者 = TestSupport.initializeNijiYoboJigyoTaishosha(二次予防事業対象者);
            二次予防事業対象者 = 二次予防事業対象者.deleted();

            assertThat(sut.save(二次予防事業対象者), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 二次予防事業対象者
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);
            when(二次予防基本チェックリストManager.save(any(NijiYoboKihonCheckList.class))).thenReturn(true);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboJigyoTaishosha 二次予防事業対象者 = TestSupport.createNijiYoboJigyoTaishosha(主キー1, 主キー2);
            二次予防事業対象者 = TestSupport.initializeNijiYoboJigyoTaishosha(二次予防事業対象者);
            二次予防事業対象者 = 二次予防事業対象者.deleted();

            assertThat(sut.save(二次予防事業対象者), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 二次予防事業対象者
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);
            when(二次予防基本チェックリストManager.save(any(NijiYoboKihonCheckList.class))).thenReturn(true);

            HokenshaNo 主キー1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboJigyoTaishosha 二次予防事業対象者 = TestSupport.createNijiYoboJigyoTaishosha(主キー1, 主キー2);
            二次予防事業対象者 = TestSupport.initializeNijiYoboJigyoTaishosha(二次予防事業対象者);

            assertThat(sut.save(二次予防事業対象者), is(false));
        }
    }

    private static class TestSupport {

        public static NijiYoboJigyoTaishosha createNijiYoboJigyoTaishosha(HokenshaNo 主キー1, HihokenshaNo 主キー2) {
            NijiYoboJigyoTaishosha 二次予防事業対象者 = new NijiYoboJigyoTaishosha(主キー1, 主キー2, Decimal.ZERO);
            return 二次予防事業対象者.createBuilderForEdit()
                    // 二次予防基本チェックリスト
                    .setNijiYoboKihonCheckList(createNijiYoboKihonCheckList(主キー1, 主キー2))
                    .build();
        }

// 二次予防基本チェックリスト
        private static NijiYoboKihonCheckList createNijiYoboKihonCheckList(HokenshaNo 主キー1, HihokenshaNo 主キー2) {
            return new NijiYoboKihonCheckList(ShikibetsuCode.EMPTY, 主キー2, FlexibleDate.MAX, Decimal.ZERO);
        }

        public static NijiYoboJigyoTaishosha initializeNijiYoboJigyoTaishosha(NijiYoboJigyoTaishosha 二次予防事業対象者) {

            DbT3100NijiYoboJigyoTaishoshaEntity techoEntity = 二次予防事業対象者.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT3101NijiYoboKihonCheckListEntity> NijiYoboKihonCheckListEntityList = new ArrayList<>();
            List<NijiYoboKihonCheckList> 二次予防基本チェックリストリスト = 二次予防事業対象者.getNijiYoboKihonCheckListList();
            for (NijiYoboKihonCheckList 二次予防基本チェックリスト : 二次予防基本チェックリストリスト) {
                NijiYoboKihonCheckListEntityList.add(二次予防基本チェックリスト.toEntity());
            }

            NijiYoboJigyoTaishoshaEntity relateEntity = new NijiYoboJigyoTaishoshaEntity();
            relateEntity.set二次予防事業対象者Entity(techoEntity);
            relateEntity.set二次予防基本チェックリストEntity(NijiYoboKihonCheckListEntityList);
            relateEntity.initializeMd5ToEntities();

// 二次予防事業対象者
            return new NijiYoboJigyoTaishosha(relateEntity.get二次予防事業対象者Entity());
        }

        public static NijiYoboJigyoTaishosha modifiedNijiYoboJigyoTaishosha(NijiYoboJigyoTaishosha 二次予防事業対象者) {

// 二次予防基本チェックリスト
            NijiYoboKihonCheckListBuilder NijiYoboKihonCheckListBuilder = 二次予防事業対象者.getNijiYoboKihonCheckListList().get(0).createBuilderForEdit();
            NijiYoboKihonCheckList NijiYoboKihonCheckList = NijiYoboKihonCheckListBuilder.set質問事項１(new Decimal(1)).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            二次予防事業対象者 = 二次予防事業対象者.createBuilderForEdit()
                    .set適用開始年月日(new FlexibleDate("20150909")) // TODO 任意項目の値を変更してください。
                    // 二次予防基本チェックリスト
                    .setNijiYoboKihonCheckList(NijiYoboKihonCheckList)
                    .build();
            return 二次予防事業対象者.modifiedModel();
        }
    }
}
