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
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboCheckListHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboCheckListHanteiKekkaBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboKihonCheckList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboNiniCheckList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboNiniCheckListBuilder;
import jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate.NijiYoboKihonCheckListMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.relate.NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3101NijiYoboKihonCheckListDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate.INijiYoboKihonCheckListMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.NijiYoboCheckListHanteiKekkaManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.NijiYoboNiniCheckListManager;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
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
 * {link NijiYoboKihonCheckListManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboKihonCheckListManagerTest {

//    private static NijiYoboKihonCheckListDac relateDac;
    // 二次予防基本チェックリスト
    private static DbT3101NijiYoboKihonCheckListDac dac;
    private static NijiYoboKihonCheckListManager sut;
    private static NijiYoboNiniCheckListManager 二次予防任意チェックリストManager;
    private static NijiYoboCheckListHanteiKekkaManager 二次予防チェックリスト判定結果Manager;

    private static MapperProvider provider;
    private static INijiYoboKihonCheckListMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(INijiYoboKihonCheckListMapper.class);
// 二次予防基本チェックリスト
        dac = mock(DbT3101NijiYoboKihonCheckListDac.class);
        二次予防任意チェックリストManager = mock(NijiYoboNiniCheckListManager.class);
        二次予防チェックリスト判定結果Manager = mock(NijiYoboCheckListHanteiKekkaManager.class);
        sut = new NijiYoboKihonCheckListManager(provider, dac,
                二次予防任意チェックリストManager,
                二次予防チェックリスト判定結果Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            NijiYoboKihonCheckListManager result = NijiYoboKihonCheckListManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            NijiYoboKihonCheckListManager result = NijiYoboKihonCheckListManager.createInstance();
            assertThat(result, instanceOf(NijiYoboKihonCheckListManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防基本チェックリスト extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get二次予防基本チェックリスト(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select二次予防基本チェックリストByKey(any(NijiYoboKihonCheckListMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;

            NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件 = NijiYoboKihonCheckListMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            NijiYoboKihonCheckList result = sut.get二次予防基本チェックリスト(二次予防基本チェックリスト検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            NijiYoboKihonCheckListEntity entity = new NijiYoboKihonCheckListEntity();
            entity.set二次予防基本チェックリストEntity(DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity());
            when(mapper.select二次予防基本チェックリストByKey(any(NijiYoboKihonCheckListMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件 = NijiYoboKihonCheckListMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            NijiYoboKihonCheckList result = sut.get二次予防基本チェックリスト(二次予防基本チェックリスト検索条件);

            assertThat(result.get識別コード().value(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防基本チェックリストリストBy主キー1 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get二次予防基本チェックリストリストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select二次予防基本チェックリストリストBy主キー1(any(NijiYoboKihonCheckListMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件 = NijiYoboKihonCheckListMapperParameter.createSelectListParam(主キー1);
            List<NijiYoboKihonCheckList> result = sut.get二次予防基本チェックリストリストBy主キー1(二次予防基本チェックリスト検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            NijiYoboKihonCheckListEntity entity = new NijiYoboKihonCheckListEntity();
            entity.set二次予防基本チェックリストEntity(DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity());

            List<NijiYoboKihonCheckListEntity> entityList = Arrays.asList(entity);
            when(mapper.select二次予防基本チェックリストリストBy主キー1(any(NijiYoboKihonCheckListMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件 = NijiYoboKihonCheckListMapperParameter.createSelectListParam(主キー1);
            List<NijiYoboKihonCheckList> result = sut.get二次予防基本チェックリストリストBy主キー1(二次予防基本チェックリスト検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save二次予防基本チェックリスト extends DbcTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 二次予防基本チェックリスト
            when(dac.save(any(DbT3101NijiYoboKihonCheckListEntity.class))).thenReturn(1);
            when(二次予防任意チェックリストManager.save二次予防任意チェックリスト(any(NijiYoboNiniCheckList.class))).thenReturn(true);
            when(二次予防チェックリスト判定結果Manager.save二次予防チェックリスト判定結果(any(NijiYoboCheckListHanteiKekka.class))).thenReturn(true);
            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboKihonCheckList 二次予防基本チェックリスト = TestSupport.createNijiYoboKihonCheckList(主キー1, 主キー2);

            assertThat(sut.save(二次予防基本チェックリスト), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 二次予防基本チェックリスト
            when(dac.save(any(DbT3101NijiYoboKihonCheckListEntity.class))).thenReturn(1);
            when(二次予防任意チェックリストManager.save二次予防任意チェックリスト(any(NijiYoboNiniCheckList.class))).thenReturn(true);
            when(二次予防チェックリスト判定結果Manager.save二次予防チェックリスト判定結果(any(NijiYoboCheckListHanteiKekka.class))).thenReturn(true);
            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboKihonCheckList 二次予防基本チェックリスト = TestSupport.createNijiYoboKihonCheckList(主キー1, 主キー2);

            assertThat(sut.save(二次予防基本チェックリスト), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 二次予防基本チェックリスト
            when(dac.save(any(DbT3101NijiYoboKihonCheckListEntity.class))).thenReturn(1);
            when(二次予防任意チェックリストManager.save二次予防任意チェックリスト(any(NijiYoboNiniCheckList.class))).thenReturn(true);
            when(二次予防チェックリスト判定結果Manager.save二次予防チェックリスト判定結果(any(NijiYoboCheckListHanteiKekka.class))).thenReturn(true);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboKihonCheckList 二次予防基本チェックリスト = TestSupport.createNijiYoboKihonCheckList(主キー1, 主キー2);
            二次予防基本チェックリスト = TestSupport.initializeNijiYoboKihonCheckList(二次予防基本チェックリスト);
            二次予防基本チェックリスト = TestSupport.modifiedNijiYoboKihonCheckList(二次予防基本チェックリスト);

            assertThat(sut.save(二次予防基本チェックリスト), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 二次予防基本チェックリスト
            when(dac.save(any(DbT3101NijiYoboKihonCheckListEntity.class))).thenReturn(1);
            when(二次予防任意チェックリストManager.save二次予防任意チェックリスト(any(NijiYoboNiniCheckList.class))).thenReturn(true);
            when(二次予防チェックリスト判定結果Manager.save二次予防チェックリスト判定結果(any(NijiYoboCheckListHanteiKekka.class))).thenReturn(true);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboKihonCheckList 二次予防基本チェックリスト = TestSupport.createNijiYoboKihonCheckList(主キー1, 主キー2);
            二次予防基本チェックリスト = TestSupport.initializeNijiYoboKihonCheckList(二次予防基本チェックリスト);
            二次予防基本チェックリスト = TestSupport.modifiedNijiYoboKihonCheckList(二次予防基本チェックリスト);

            assertThat(sut.save(二次予防基本チェックリスト), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 二次予防基本チェックリスト
            when(dac.save(any(DbT3101NijiYoboKihonCheckListEntity.class))).thenReturn(1);
            when(二次予防任意チェックリストManager.save二次予防任意チェックリスト(any(NijiYoboNiniCheckList.class))).thenReturn(true);
            when(二次予防チェックリスト判定結果Manager.save二次予防チェックリスト判定結果(any(NijiYoboCheckListHanteiKekka.class))).thenReturn(true);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboKihonCheckList 二次予防基本チェックリスト = TestSupport.createNijiYoboKihonCheckList(主キー1, 主キー2);
            二次予防基本チェックリスト = TestSupport.initializeNijiYoboKihonCheckList(二次予防基本チェックリスト);
            二次予防基本チェックリスト = 二次予防基本チェックリスト.deleted();

            assertThat(sut.save(二次予防基本チェックリスト), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 二次予防基本チェックリスト
            when(dac.save(any(DbT3101NijiYoboKihonCheckListEntity.class))).thenReturn(1);
            when(二次予防任意チェックリストManager.save二次予防任意チェックリスト(any(NijiYoboNiniCheckList.class))).thenReturn(true);
            when(二次予防チェックリスト判定結果Manager.save二次予防チェックリスト判定結果(any(NijiYoboCheckListHanteiKekka.class))).thenReturn(true);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboKihonCheckList 二次予防基本チェックリスト = TestSupport.createNijiYoboKihonCheckList(主キー1, 主キー2);
            二次予防基本チェックリスト = TestSupport.initializeNijiYoboKihonCheckList(二次予防基本チェックリスト);
            二次予防基本チェックリスト = 二次予防基本チェックリスト.deleted();

            assertThat(sut.save(二次予防基本チェックリスト), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 二次予防基本チェックリスト
            when(dac.save(any(DbT3101NijiYoboKihonCheckListEntity.class))).thenReturn(1);
            when(二次予防任意チェックリストManager.save二次予防任意チェックリスト(any(NijiYoboNiniCheckList.class))).thenReturn(true);
            when(二次予防チェックリスト判定結果Manager.save二次予防チェックリスト判定結果(any(NijiYoboCheckListHanteiKekka.class))).thenReturn(true);

            ShikibetsuCode 主キー1 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
            NijiYoboKihonCheckList 二次予防基本チェックリスト = TestSupport.createNijiYoboKihonCheckList(主キー1, 主キー2);
            二次予防基本チェックリスト = TestSupport.initializeNijiYoboKihonCheckList(二次予防基本チェックリスト);

            assertThat(sut.save(二次予防基本チェックリスト), is(false));
        }
    }

    private static class TestSupport {

        public static NijiYoboKihonCheckList createNijiYoboKihonCheckList(ShikibetsuCode 主キー1, HihokenshaNo 主キー2) {
            NijiYoboKihonCheckList 二次予防基本チェックリスト = new NijiYoboKihonCheckList(主キー1, 主キー2, FlexibleDate.MAX, Decimal.ZERO);
            return 二次予防基本チェックリスト.createBuilderForEdit()
                    // 二次予防任意チェックリスト
                    .setNijiYoboNiniCheckList(createNijiYoboNiniCheckList(主キー1, 主キー2))
                    // 二次予防チェックリスト判定結果
                    .setNijiYoboCheckListHanteiKekka(createNijiYoboCheckListHanteiKekka(主キー1, 主キー2))
                    .build();
        }

// 二次予防任意チェックリスト
        private static NijiYoboNiniCheckList createNijiYoboNiniCheckList(ShikibetsuCode 主キー1, HihokenshaNo 主キー2) {
            return new NijiYoboNiniCheckList(
                    主キー1, 主キー2, FlexibleDate.MAX, Decimal.ZERO, Decimal.ZERO);
        }
// 二次予防チェックリスト判定結果

        private static NijiYoboCheckListHanteiKekka createNijiYoboCheckListHanteiKekka(ShikibetsuCode 主キー1, HihokenshaNo 主キー2) {
            return new NijiYoboCheckListHanteiKekka(
                    主キー1, 主キー2, FlexibleDate.MAX, Decimal.ZERO);
        }

        public static NijiYoboKihonCheckList initializeNijiYoboKihonCheckList(NijiYoboKihonCheckList 二次予防基本チェックリスト) {

            DbT3101NijiYoboKihonCheckListEntity techoEntity = 二次予防基本チェックリスト.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT3102NijiYoboNiniCheckListEntity> NijiYoboNiniCheckListEntityList = new ArrayList<>();
            List<NijiYoboNiniCheckList> 二次予防任意チェックリストリスト = 二次予防基本チェックリスト.getNijiYoboNiniCheckListList();
            for (NijiYoboNiniCheckList 二次予防任意チェックリスト : 二次予防任意チェックリストリスト) {
                NijiYoboNiniCheckListEntityList.add(二次予防任意チェックリスト.toEntity());
            }
            List<DbT3103NijiYoboCheckListHanteiKekkaEntity> NijiYoboCheckListHanteiKekkaEntityList = new ArrayList<>();
            List<NijiYoboCheckListHanteiKekka> 二次予防チェックリスト判定結果リスト = 二次予防基本チェックリスト.getNijiYoboCheckListHanteiKekkaList();
            for (NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 : 二次予防チェックリスト判定結果リスト) {
                NijiYoboCheckListHanteiKekkaEntityList.add(二次予防チェックリスト判定結果.toEntity());
            }

            NijiYoboKihonCheckListEntity relateEntity = new NijiYoboKihonCheckListEntity();
            relateEntity.set二次予防基本チェックリストEntity(techoEntity);
            relateEntity.set二次予防任意チェックリストEntity(NijiYoboNiniCheckListEntityList);
            relateEntity.set二次予防チェックリスト判定結果Entity(NijiYoboCheckListHanteiKekkaEntityList);
            relateEntity.initializeMd5ToEntities();

// 二次予防基本チェックリスト
            return new NijiYoboKihonCheckList(relateEntity.get二次予防基本チェックリストEntity());
        }

        public static NijiYoboKihonCheckList modifiedNijiYoboKihonCheckList(NijiYoboKihonCheckList 二次予防基本チェックリスト) {

// 二次予防任意チェックリスト
            NijiYoboNiniCheckListBuilder NijiYoboNiniCheckListBuilder = 二次予防基本チェックリスト.getNijiYoboNiniCheckListList().get(0).createBuilderForEdit();
            NijiYoboNiniCheckList NijiYoboNiniCheckList = NijiYoboNiniCheckListBuilder.set任意質問番号(new Decimal(1)).build();
// 二次予防チェックリスト判定結果
            NijiYoboCheckListHanteiKekkaBuilder NijiYoboCheckListHanteiKekkaBuilder = 二次予防基本チェックリスト.getNijiYoboCheckListHanteiKekkaList().get(0).createBuilderForEdit();
            NijiYoboCheckListHanteiKekka NijiYoboCheckListHanteiKekka = NijiYoboCheckListHanteiKekkaBuilder.set点数_うつ(new Decimal(1)).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            二次予防基本チェックリスト = 二次予防基本チェックリスト.createBuilderForEdit()
                    .set質問事項１(new Decimal(1)) // TODO 任意項目の値を変更してください。
                    // 二次予防任意チェックリスト
                    .setNijiYoboNiniCheckList(NijiYoboNiniCheckList)
                    // 二次予防チェックリスト判定結果
                    .setNijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekka)
                    .build();
            return 二次予防基本チェックリスト.modifiedModel();
        }
    }
}
