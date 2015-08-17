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
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisaiBuilder;
import jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate.RiyoshaFutanWariaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3113RiyoshaFutanWariaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.relate.RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3113RiyoshaFutanWariaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate.IRiyoshaFutanWariaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
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
 * {link RiyoshaFutanWariaiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RiyoshaFutanWariaiManagerTest {

//    private static RiyoshaFutanWariaiDac relateDac;
    // 利用者負担割合
    private static DbT3113RiyoshaFutanWariaiDac dac;
    private static RiyoshaFutanWariaiManager sut;
    private static RiyoshaFutanWariaiMeisaiManager 利用者負担割合明細Manager;

    private static MapperProvider provider;
    private static IRiyoshaFutanWariaiMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IRiyoshaFutanWariaiMapper.class);
// 利用者負担割合
        dac = mock(DbT3113RiyoshaFutanWariaiDac.class);
        利用者負担割合明細Manager = mock(RiyoshaFutanWariaiMeisaiManager.class);
        sut = new RiyoshaFutanWariaiManager(provider, dac,
                利用者負担割合明細Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            RiyoshaFutanWariaiManager result = RiyoshaFutanWariaiManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            RiyoshaFutanWariaiManager result = RiyoshaFutanWariaiManager.createInstance();
            assertThat(result, instanceOf(RiyoshaFutanWariaiManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get利用者負担割合 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get利用者負担割合(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select利用者負担割合ByKey(any(RiyoshaFutanWariaiMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;

            RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件 = RiyoshaFutanWariaiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            RiyoshaFutanWariai result = sut.get利用者負担割合(利用者負担割合検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            RiyoshaFutanWariaiEntity entity = new RiyoshaFutanWariaiEntity();
            entity.set利用者負担割合Entity(DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity());
            when(mapper.select利用者負担割合ByKey(any(RiyoshaFutanWariaiMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件 = RiyoshaFutanWariaiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            RiyoshaFutanWariai result = sut.get利用者負担割合(利用者負担割合検索条件);

            assertThat(result.get年度(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get利用者負担割合リストBy主キー1 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get利用者負担割合リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select利用者負担割合リストBy主キー1(any(RiyoshaFutanWariaiMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件 = RiyoshaFutanWariaiMapperParameter.createSelectListParam(主キー1);
            List<RiyoshaFutanWariai> result = sut.get利用者負担割合リストBy主キー1(利用者負担割合検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            RiyoshaFutanWariaiEntity entity = new RiyoshaFutanWariaiEntity();
            entity.set利用者負担割合Entity(DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity());

            List<RiyoshaFutanWariaiEntity> entityList = Arrays.asList(entity);
            when(mapper.select利用者負担割合リストBy主キー1(any(RiyoshaFutanWariaiMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件 = RiyoshaFutanWariaiMapperParameter.createSelectListParam(主キー1);
            List<RiyoshaFutanWariai> result = sut.get利用者負担割合リストBy主キー1(利用者負担割合検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get年度(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度));
        }
    }

    public static class save利用者負担割合 extends DbcTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 利用者負担割合
            when(dac.save(any(DbT3113RiyoshaFutanWariaiEntity.class))).thenReturn(1);
            when(利用者負担割合明細Manager.save(any(RiyoshaFutanWariaiMeisai.class))).thenReturn(true);
            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariai 利用者負担割合 = TestSupport.createRiyoshaFutanWariai(主キー1, 主キー2);

            assertThat(sut.save(利用者負担割合), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 利用者負担割合
            when(dac.save(any(DbT3113RiyoshaFutanWariaiEntity.class))).thenReturn(1);
            when(利用者負担割合明細Manager.save(any(RiyoshaFutanWariaiMeisai.class))).thenReturn(true);
            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariai 利用者負担割合 = TestSupport.createRiyoshaFutanWariai(主キー1, 主キー2);

            assertThat(sut.save(利用者負担割合), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 利用者負担割合
            when(dac.save(any(DbT3113RiyoshaFutanWariaiEntity.class))).thenReturn(1);
            when(利用者負担割合明細Manager.save(any(RiyoshaFutanWariaiMeisai.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariai 利用者負担割合 = TestSupport.createRiyoshaFutanWariai(主キー1, 主キー2);
            利用者負担割合 = TestSupport.initializeRiyoshaFutanWariai(利用者負担割合);
            利用者負担割合 = TestSupport.modifiedRiyoshaFutanWariai(利用者負担割合);

            assertThat(sut.save(利用者負担割合), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 利用者負担割合
            when(dac.save(any(DbT3113RiyoshaFutanWariaiEntity.class))).thenReturn(1);
            when(利用者負担割合明細Manager.save(any(RiyoshaFutanWariaiMeisai.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariai 利用者負担割合 = TestSupport.createRiyoshaFutanWariai(主キー1, 主キー2);
            利用者負担割合 = TestSupport.initializeRiyoshaFutanWariai(利用者負担割合);
            利用者負担割合 = TestSupport.modifiedRiyoshaFutanWariai(利用者負担割合);

            assertThat(sut.save(利用者負担割合), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 利用者負担割合
            when(dac.save(any(DbT3113RiyoshaFutanWariaiEntity.class))).thenReturn(1);
            when(利用者負担割合明細Manager.save(any(RiyoshaFutanWariaiMeisai.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariai 利用者負担割合 = TestSupport.createRiyoshaFutanWariai(主キー1, 主キー2);
            利用者負担割合 = TestSupport.initializeRiyoshaFutanWariai(利用者負担割合);
            利用者負担割合 = 利用者負担割合.deleted();

            assertThat(sut.save(利用者負担割合), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 利用者負担割合
            when(dac.save(any(DbT3113RiyoshaFutanWariaiEntity.class))).thenReturn(1);
            when(利用者負担割合明細Manager.save(any(RiyoshaFutanWariaiMeisai.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariai 利用者負担割合 = TestSupport.createRiyoshaFutanWariai(主キー1, 主キー2);
            利用者負担割合 = TestSupport.initializeRiyoshaFutanWariai(利用者負担割合);
            利用者負担割合 = 利用者負担割合.deleted();

            assertThat(sut.save(利用者負担割合), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 利用者負担割合
            when(dac.save(any(DbT3113RiyoshaFutanWariaiEntity.class))).thenReturn(1);
            when(利用者負担割合明細Manager.save(any(RiyoshaFutanWariaiMeisai.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
            RiyoshaFutanWariai 利用者負担割合 = TestSupport.createRiyoshaFutanWariai(主キー1, 主キー2);
            利用者負担割合 = TestSupport.initializeRiyoshaFutanWariai(利用者負担割合);

            assertThat(sut.save(利用者負担割合), is(false));
        }
    }

    private static class TestSupport {

        public static RiyoshaFutanWariai createRiyoshaFutanWariai(FlexibleYear 主キー1, HihokenshaNo 主キー2) {
            RiyoshaFutanWariai 利用者負担割合 = new RiyoshaFutanWariai(主キー1, 主キー2, Decimal.ZERO);
            return 利用者負担割合.createBuilderForEdit()
                    // 利用者負担割合明細
                    .setRiyoshaFutanWariaiMeisai(createRiyoshaFutanWariaiMeisai(主キー1, 主キー2))
                    .build();
        }

// 利用者負担割合明細
        private static RiyoshaFutanWariaiMeisai createRiyoshaFutanWariaiMeisai(FlexibleYear 主キー1, HihokenshaNo 主キー2) {
            return new RiyoshaFutanWariaiMeisai(
                    主キー1,
                    主キー2, Decimal.ZERO, Decimal.ONE);
        }

        public static RiyoshaFutanWariai initializeRiyoshaFutanWariai(RiyoshaFutanWariai 利用者負担割合) {

            DbT3113RiyoshaFutanWariaiEntity techoEntity = 利用者負担割合.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> RiyoshaFutanWariaiMeisaiEntityList = new ArrayList<>();
            List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細リスト = 利用者負担割合.getRiyoshaFutanWariaiMeisaiList();
            for (RiyoshaFutanWariaiMeisai 利用者負担割合明細 : 利用者負担割合明細リスト) {
                RiyoshaFutanWariaiMeisaiEntityList.add(利用者負担割合明細.toEntity());
            }

            RiyoshaFutanWariaiEntity relateEntity = new RiyoshaFutanWariaiEntity();
            relateEntity.set利用者負担割合Entity(techoEntity);
            relateEntity.set利用者負担割合明細Entity(RiyoshaFutanWariaiMeisaiEntityList);
            relateEntity.initializeMd5ToEntities();

// 利用者負担割合
            return new RiyoshaFutanWariai(relateEntity.get利用者負担割合Entity());
        }

        public static RiyoshaFutanWariai modifiedRiyoshaFutanWariai(RiyoshaFutanWariai 利用者負担割合) {

// 利用者負担割合明細
            RiyoshaFutanWariaiMeisaiBuilder RiyoshaFutanWariaiMeisaiBuilder = 利用者負担割合.getRiyoshaFutanWariaiMeisaiList().get(0).createBuilderForEdit();
            RiyoshaFutanWariaiMeisai RiyoshaFutanWariaiMeisai = RiyoshaFutanWariaiMeisaiBuilder.set更正理由(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            利用者負担割合 = 利用者負担割合.createBuilderForEdit()
                    .set発行区分(new RString("2")) // TODO 任意項目の値を変更してください。
                    // 利用者負担割合明細
                    .setRiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisai)
                    .build();
            return 利用者負担割合.modifiedModel();
        }
    }
}
