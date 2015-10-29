/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.relate;

import static java.nio.channels.spi.AsynchronousChannelProvider.provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KibetsuBuilder;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.FukaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.IFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.basic.KibetsuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
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
 * {link FukaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class FukaManagerTest {

    // 介護賦課
    private static DbT2002FukaDac dac;
    private static FukaManager sut;
    private static KibetsuManager 介護期別Manager;

    private static MapperProvider provider;
    private static IFukaMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IFukaMapper.class);
// 介護賦課
        dac = mock(DbT2002FukaDac.class);
        介護期別Manager = mock(KibetsuManager.class);
        sut = new FukaManager(provider, dac,
                介護期別Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            FukaManager result = FukaManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            FukaManager result = FukaManager.createInstance();
            assertThat(result, instanceOf(FukaManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護賦課 extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護賦課(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select介護賦課ByKey(any(FukaMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;

            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            Fuka result = sut.get介護賦課(介護賦課検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            FukaEntity entity = new FukaEntity();
            entity.set介護賦課Entity(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());
            when(mapper.select介護賦課ByKey(any(FukaMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            Fuka result = sut.get介護賦課(介護賦課検索条件);

            assertThat(result.get調定年度(), is(DbT2002FukaEntityGenerator.DEFAULT_調定年度));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護賦課リストBy主キー1 extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護賦課リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select介護賦課リストBy主キー1(any(FukaMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createSelectListParam(主キー1);
            List<Fuka> result = sut.get介護賦課リストBy主キー1(介護賦課検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            FukaEntity entity = new FukaEntity();
            entity.set介護賦課Entity(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());

            List<FukaEntity> entityList = Arrays.asList(entity);
            when(mapper.select介護賦課リストBy主キー1(any(FukaMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createSelectListParam(主キー1);
            List<Fuka> result = sut.get介護賦課リストBy主キー1(介護賦課検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調定年度(), is(DbT2002FukaEntityGenerator.DEFAULT_調定年度));
        }
    }

    public static class save介護賦課 extends DbbTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 介護賦課
            when(dac.save(any(DbT2002FukaEntity.class))).thenReturn(1);
            when(介護期別Manager.save介護期別(any(Kibetsu.class))).thenReturn(true);
            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
            Fuka 介護賦課 = TestSupport.createFuka(主キー1, 主キー2);

            assertThat(sut.save(介護賦課), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護賦課
            when(dac.save(any(DbT2002FukaEntity.class))).thenReturn(1);
            when(介護期別Manager.save介護期別(any(Kibetsu.class))).thenReturn(true);
            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
            Fuka 介護賦課 = TestSupport.createFuka(主キー1, 主キー2);

            assertThat(sut.save(介護賦課), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 介護賦課
            when(dac.save(any(DbT2002FukaEntity.class))).thenReturn(1);
            when(介護期別Manager.save介護期別(any(Kibetsu.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
            Fuka 介護賦課 = TestSupport.createFuka(主キー1, 主キー2);
            介護賦課 = TestSupport.initializeFuka(介護賦課);
            介護賦課 = TestSupport.modifiedFuka(介護賦課);

            assertThat(sut.save(介護賦課), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護賦課
            when(dac.save(any(DbT2002FukaEntity.class))).thenReturn(1);
            when(介護期別Manager.save介護期別(any(Kibetsu.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
            Fuka 介護賦課 = TestSupport.createFuka(主キー1, 主キー2);
            介護賦課 = TestSupport.initializeFuka(介護賦課);
            介護賦課 = TestSupport.modifiedFuka(介護賦課);

            assertThat(sut.save(介護賦課), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 介護賦課
            when(dac.save(any(DbT2002FukaEntity.class))).thenReturn(1);
            when(介護期別Manager.save介護期別(any(Kibetsu.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
            Fuka 介護賦課 = TestSupport.createFuka(主キー1, 主キー2);
            介護賦課 = TestSupport.initializeFuka(介護賦課);
            介護賦課 = 介護賦課.deleted();

            assertThat(sut.save(介護賦課), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護賦課
            when(dac.save(any(DbT2002FukaEntity.class))).thenReturn(1);
            when(介護期別Manager.save介護期別(any(Kibetsu.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
            Fuka 介護賦課 = TestSupport.createFuka(主キー1, 主キー2);
            介護賦課 = TestSupport.initializeFuka(介護賦課);
            介護賦課 = 介護賦課.deleted();

            assertThat(sut.save(介護賦課), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護賦課
            when(dac.save(any(DbT2002FukaEntity.class))).thenReturn(1);
            when(介護期別Manager.save介護期別(any(Kibetsu.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
            Fuka 介護賦課 = TestSupport.createFuka(主キー1, 主キー2);
            介護賦課 = TestSupport.initializeFuka(介護賦課);

            assertThat(sut.save(介護賦課), is(false));
        }
    }

    private static class TestSupport {

        public static Fuka createFuka(FlexibleYear 主キー1, FlexibleYear 主キー2) {
            Fuka 介護賦課 = new Fuka(主キー1, 主キー2, TsuchishoNo.EMPTY, Decimal.ZERO);
            return 介護賦課.createBuilderForEdit()
                    // 介護期別
                    .setKibetsu(createKibetsu(主キー1, 主キー2))
                    .build();
        }

// 介護期別
        private static Kibetsu createKibetsu(FlexibleYear 主キー1, FlexibleYear 主キー2) {
            return new Kibetsu(主キー2, 主キー2, TsuchishoNo.EMPTY, Decimal.ZERO, RString.EMPTY, 1);
        }

        public static Fuka initializeFuka(Fuka 介護賦課) {

            DbT2002FukaEntity techoEntity = 介護賦課.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT2003KibetsuEntity> KibetsuEntityList = new ArrayList<>();
            List<Kibetsu> 介護期別リスト = 介護賦課.getKibetsuList();
            for (Kibetsu 介護期別 : 介護期別リスト) {
                KibetsuEntityList.add(介護期別.toEntity());
            }

            FukaEntity relateEntity = new FukaEntity();
            relateEntity.set介護賦課Entity(techoEntity);
            relateEntity.set介護期別Entity(KibetsuEntityList);
            relateEntity.initializeMd5ToEntities();

// 介護賦課
            return new Fuka(relateEntity.get介護賦課Entity());
        }

        public static Fuka modifiedFuka(Fuka 介護賦課) {

// 介護期別
            KibetsuBuilder KibetsuBuilder = 介護賦課.getKibetsuList().get(0).createBuilderForEdit();
            Kibetsu Kibetsu = KibetsuBuilder.set徴収方法(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            介護賦課 = 介護賦課.createBuilderForEdit()
                    .set調定事由1(new RString("変更")) // TODO 任意項目の値を変更してください。
                    // 介護期別
                    .setKibetsu(Kibetsu)
                    .build();
            return 介護賦課.modifiedModel();
        }
    }
}
