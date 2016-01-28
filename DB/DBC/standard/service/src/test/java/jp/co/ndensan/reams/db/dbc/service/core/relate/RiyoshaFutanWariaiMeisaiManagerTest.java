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
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiKonkyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiKonkyoBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.RiyoshaFutanWariaiMeisaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.IRiyoshaFutanWariaiMeisaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.RiyoshaFutanWariaiKonkyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {link RiyoshaFutanWariaiMeisaiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class RiyoshaFutanWariaiMeisaiManagerTest {

//    private static RiyoshaFutanWariaiMeisaiDac relateDac;
    // 利用者負担割合明細
    private static DbT3114RiyoshaFutanWariaiMeisaiDac dac;
    private static RiyoshaFutanWariaiMeisaiManager sut;
    private static RiyoshaFutanWariaiKonkyoManager 利用者負担割合世帯員Manager;

    private static MapperProvider provider;
    private static IRiyoshaFutanWariaiMeisaiMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IRiyoshaFutanWariaiMeisaiMapper.class);
// 利用者負担割合明細
        dac = mock(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
        利用者負担割合世帯員Manager = mock(RiyoshaFutanWariaiKonkyoManager.class);
        sut = new RiyoshaFutanWariaiMeisaiManager(provider, dac,
                利用者負担割合世帯員Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            RiyoshaFutanWariaiMeisaiManager result = RiyoshaFutanWariaiMeisaiManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            RiyoshaFutanWariaiMeisaiManager result = RiyoshaFutanWariaiMeisaiManager.createInstance();
            assertThat(result, instanceOf(RiyoshaFutanWariaiMeisaiManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get利用者負担割合明細 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get利用者負担割合明細(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select利用者負担割合明細ByKey(any(RiyoshaFutanWariaiMeisaiMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;

            RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件 = RiyoshaFutanWariaiMeisaiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            RiyoshaFutanWariaiMeisai result = sut.get利用者負担割合明細(利用者負担割合明細検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            RiyoshaFutanWariaiMeisaiEntity entity = new RiyoshaFutanWariaiMeisaiEntity();
            entity.set利用者負担割合明細Entity(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity());
            when(mapper.select利用者負担割合明細ByKey(any(RiyoshaFutanWariaiMeisaiMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件 = RiyoshaFutanWariaiMeisaiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            RiyoshaFutanWariaiMeisai result = sut.get利用者負担割合明細(利用者負担割合明細検索条件);

            assertThat(result.get年度(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get利用者負担割合明細リストBy主キー1 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get利用者負担割合明細リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select利用者負担割合明細リストBy主キー1(any(RiyoshaFutanWariaiMeisaiMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件 = RiyoshaFutanWariaiMeisaiMapperParameter.createSelectListParam(主キー1);
            List<RiyoshaFutanWariaiMeisai> result = sut.get利用者負担割合明細リストBy主キー1(利用者負担割合明細検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            RiyoshaFutanWariaiMeisaiEntity entity = new RiyoshaFutanWariaiMeisaiEntity();
            entity.set利用者負担割合明細Entity(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity());

            List<RiyoshaFutanWariaiMeisaiEntity> entityList = Arrays.asList(entity);
            when(mapper.select利用者負担割合明細リストBy主キー1(any(RiyoshaFutanWariaiMeisaiMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件 = RiyoshaFutanWariaiMeisaiMapperParameter.createSelectListParam(主キー1);
            List<RiyoshaFutanWariaiMeisai> result = sut.get利用者負担割合明細リストBy主キー1(利用者負担割合明細検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get年度(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度));
        }
    }

    public static class save利用者負担割合明細 extends DbcTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 利用者負担割合明細
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);
            when(利用者負担割合世帯員Manager.save利用者負担割合世帯員(any(RiyoshaFutanWariaiKonkyo.class))).thenReturn(true);
            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = TestSupport.createRiyoshaFutanWariaiMeisai(主キー1, 主キー2);

            assertThat(sut.save(利用者負担割合明細), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 利用者負担割合明細
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);
            when(利用者負担割合世帯員Manager.save利用者負担割合世帯員(any(RiyoshaFutanWariaiKonkyo.class))).thenReturn(true);
            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = TestSupport.createRiyoshaFutanWariaiMeisai(主キー1, 主キー2);

            assertThat(sut.save(利用者負担割合明細), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 利用者負担割合明細
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);
            when(利用者負担割合世帯員Manager.save利用者負担割合世帯員(any(RiyoshaFutanWariaiKonkyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = TestSupport.createRiyoshaFutanWariaiMeisai(主キー1, 主キー2);
            利用者負担割合明細 = TestSupport.initializeRiyoshaFutanWariaiMeisai(利用者負担割合明細);
            利用者負担割合明細 = TestSupport.modifiedRiyoshaFutanWariaiMeisai(利用者負担割合明細);

            assertThat(sut.save(利用者負担割合明細), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 利用者負担割合明細
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);
            when(利用者負担割合世帯員Manager.save利用者負担割合世帯員(any(RiyoshaFutanWariaiKonkyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = TestSupport.createRiyoshaFutanWariaiMeisai(主キー1, 主キー2);
            利用者負担割合明細 = TestSupport.initializeRiyoshaFutanWariaiMeisai(利用者負担割合明細);
            利用者負担割合明細 = TestSupport.modifiedRiyoshaFutanWariaiMeisai(利用者負担割合明細);

            assertThat(sut.save(利用者負担割合明細), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 利用者負担割合明細
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);
            when(利用者負担割合世帯員Manager.save利用者負担割合世帯員(any(RiyoshaFutanWariaiKonkyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = TestSupport.createRiyoshaFutanWariaiMeisai(主キー1, 主キー2);
            利用者負担割合明細 = TestSupport.initializeRiyoshaFutanWariaiMeisai(利用者負担割合明細);
            利用者負担割合明細 = 利用者負担割合明細.deleted();

            assertThat(sut.save(利用者負担割合明細), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 利用者負担割合明細
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);
            when(利用者負担割合世帯員Manager.save利用者負担割合世帯員(any(RiyoshaFutanWariaiKonkyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = TestSupport.createRiyoshaFutanWariaiMeisai(主キー1, 主キー2);
            利用者負担割合明細 = TestSupport.initializeRiyoshaFutanWariaiMeisai(利用者負担割合明細);
            利用者負担割合明細 = 利用者負担割合明細.deleted();

            assertThat(sut.save(利用者負担割合明細), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 利用者負担割合明細
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);
            when(利用者負担割合世帯員Manager.save利用者負担割合世帯員(any(RiyoshaFutanWariaiKonkyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = TestSupport.createRiyoshaFutanWariaiMeisai(主キー1, 主キー2);
            利用者負担割合明細 = TestSupport.initializeRiyoshaFutanWariaiMeisai(利用者負担割合明細);

            assertThat(sut.save(利用者負担割合明細), is(false));
        }
    }

    private static class TestSupport {

        public static RiyoshaFutanWariaiMeisai createRiyoshaFutanWariaiMeisai(FlexibleYear 主キー1, HihokenshaNo 主キー2) {
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(主キー1, 主キー2, 1, 1);
            return 利用者負担割合明細.createBuilderForEdit()
                    // 利用者負担割合世帯員
                    .setRiyoshaFutanWariaiKonkyo(createRiyoshaFutanWariaiKonkyo(主キー1, 主キー2))
                    .build();
        }

// 利用者負担割合世帯員
        private static RiyoshaFutanWariaiKonkyo createRiyoshaFutanWariaiKonkyo(FlexibleYear 主キー1, HihokenshaNo 主キー2) {
            return new RiyoshaFutanWariaiKonkyo(
                    主キー1,
                    主キー2, 0, 0, new HihokenshaNo("0123400001"));
        }

        public static RiyoshaFutanWariaiMeisai initializeRiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisai 利用者負担割合明細) {

            DbT3114RiyoshaFutanWariaiMeisaiEntity techoEntity = 利用者負担割合明細.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT3115RiyoshaFutanWariaiKonkyoEntity> RiyoshaFutanWariaiKonkyoEntityList = new ArrayList<>();
            List<RiyoshaFutanWariaiKonkyo> 利用者負担割合世帯員リスト = 利用者負担割合明細.getRiyoshaFutanWariaiKonkyoList();
            for (RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 : 利用者負担割合世帯員リスト) {
                RiyoshaFutanWariaiKonkyoEntityList.add(利用者負担割合世帯員.toEntity());
            }

            RiyoshaFutanWariaiMeisaiEntity relateEntity = new RiyoshaFutanWariaiMeisaiEntity();
            relateEntity.set利用者負担割合明細Entity(techoEntity);
            relateEntity.set利用者負担割合世帯員Entity(RiyoshaFutanWariaiKonkyoEntityList);
            relateEntity.initializeMd5ToEntities();

// 利用者負担割合明細
            return new RiyoshaFutanWariaiMeisai(relateEntity.get利用者負担割合明細Entity());
        }

        public static RiyoshaFutanWariaiMeisai modifiedRiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisai 利用者負担割合明細) {

// 利用者負担割合世帯員
            RiyoshaFutanWariaiKonkyoBuilder RiyoshaFutanWariaiKonkyoBuilder = 利用者負担割合明細.getRiyoshaFutanWariaiKonkyoList().get(0).createBuilderForEdit();
            RiyoshaFutanWariaiKonkyo RiyoshaFutanWariaiKonkyo = RiyoshaFutanWariaiKonkyoBuilder.set世帯員被保険者番号(new HihokenshaNo("0123400002")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            利用者負担割合明細 = 利用者負担割合明細.createBuilderForEdit()
                    .set更正理由(new RString("変更")) // TODO 任意項目の値を変更してください。
                    // 利用者負担割合世帯員
                    .setRiyoshaFutanWariaiKonkyo(RiyoshaFutanWariaiKonkyo)
                    .build();
            return 利用者負担割合明細.modifiedModel();
        }
    }
}
