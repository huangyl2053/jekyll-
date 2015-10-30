/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.relate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KibetsuChoshuYuyoBuilder;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.ChoshuYuyoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.IChoshuYuyoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.basic.KibetsuChoshuYuyoManager;
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
 * {link ChoshuYuyoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ChoshuYuyoManagerTest {

    // 介護賦課徴収猶予
    private static DbT2006ChoshuYuyoDac dac;
    private static ChoshuYuyoManager sut;
    private static KibetsuChoshuYuyoManager 介護期別徴収猶予Manager;

    private static MapperProvider provider;
    private static IChoshuYuyoMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IChoshuYuyoMapper.class);
// 介護賦課徴収猶予
        dac = mock(DbT2006ChoshuYuyoDac.class);
        介護期別徴収猶予Manager = mock(KibetsuChoshuYuyoManager.class);
        sut = new ChoshuYuyoManager(provider, dac,
                介護期別徴収猶予Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            ChoshuYuyoManager result = ChoshuYuyoManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            ChoshuYuyoManager result = ChoshuYuyoManager.createInstance();
            assertThat(result, instanceOf(ChoshuYuyoManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護賦課徴収猶予 extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護賦課徴収猶予(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select介護賦課徴収猶予ByKey(any(ChoshuYuyoMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;

            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            ChoshuYuyo result = sut.get介護賦課徴収猶予(介護賦課徴収猶予検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            ChoshuYuyoEntity entity = new ChoshuYuyoEntity();
            entity.set介護賦課徴収猶予Entity(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity());
            when(mapper.select介護賦課徴収猶予ByKey(any(ChoshuYuyoMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            ChoshuYuyo result = sut.get介護賦課徴収猶予(介護賦課徴収猶予検索条件);

            assertThat(result.get調定年度(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護賦課徴収猶予リストBy主キー1 extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護賦課徴収猶予リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select介護賦課徴収猶予リストBy主キー1(any(ChoshuYuyoMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createSelectListParam(主キー1);
            List<ChoshuYuyo> result = sut.get介護賦課徴収猶予リストBy主キー1(介護賦課徴収猶予検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            ChoshuYuyoEntity entity = new ChoshuYuyoEntity();
            entity.set介護賦課徴収猶予Entity(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity());

            List<ChoshuYuyoEntity> entityList = Arrays.asList(entity);
            when(mapper.select介護賦課徴収猶予リストBy主キー1(any(ChoshuYuyoMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createSelectListParam(主キー1);
            List<ChoshuYuyo> result = sut.get介護賦課徴収猶予リストBy主キー1(介護賦課徴収猶予検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調定年度(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度));
        }
    }

    public static class save介護賦課徴収猶予 extends DbbTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 介護賦課徴収猶予
            when(dac.save(any(DbT2006ChoshuYuyoEntity.class))).thenReturn(1);
            when(介護期別徴収猶予Manager.save介護期別徴収猶予(any(KibetsuChoshuYuyo.class))).thenReturn(true);
            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(主キー1, 主キー2);

            assertThat(sut.save(介護賦課徴収猶予), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護賦課徴収猶予
            when(dac.save(any(DbT2006ChoshuYuyoEntity.class))).thenReturn(1);
            when(介護期別徴収猶予Manager.save介護期別徴収猶予(any(KibetsuChoshuYuyo.class))).thenReturn(true);
            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(主キー1, 主キー2);

            assertThat(sut.save(介護賦課徴収猶予), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 介護賦課徴収猶予
            when(dac.save(any(DbT2006ChoshuYuyoEntity.class))).thenReturn(1);
            when(介護期別徴収猶予Manager.save介護期別徴収猶予(any(KibetsuChoshuYuyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(主キー1, 主キー2);
            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
            介護賦課徴収猶予 = TestSupport.modifiedChoshuYuyo(介護賦課徴収猶予);

            assertThat(sut.save(介護賦課徴収猶予), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護賦課徴収猶予
            when(dac.save(any(DbT2006ChoshuYuyoEntity.class))).thenReturn(1);
            when(介護期別徴収猶予Manager.save介護期別徴収猶予(any(KibetsuChoshuYuyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(主キー1, 主キー2);
            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
            介護賦課徴収猶予 = TestSupport.modifiedChoshuYuyo(介護賦課徴収猶予);

            assertThat(sut.save(介護賦課徴収猶予), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 介護賦課徴収猶予
            when(dac.save(any(DbT2006ChoshuYuyoEntity.class))).thenReturn(1);
            when(介護期別徴収猶予Manager.save介護期別徴収猶予(any(KibetsuChoshuYuyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(主キー1, 主キー2);
            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
            介護賦課徴収猶予 = 介護賦課徴収猶予.deleted();

            assertThat(sut.save(介護賦課徴収猶予), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護賦課徴収猶予
            when(dac.save(any(DbT2006ChoshuYuyoEntity.class))).thenReturn(1);
            when(介護期別徴収猶予Manager.save介護期別徴収猶予(any(KibetsuChoshuYuyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(主キー1, 主キー2);
            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
            介護賦課徴収猶予 = 介護賦課徴収猶予.deleted();

            assertThat(sut.save(介護賦課徴収猶予), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護賦課徴収猶予
            when(dac.save(any(DbT2006ChoshuYuyoEntity.class))).thenReturn(1);
            when(介護期別徴収猶予Manager.save介護期別徴収猶予(any(KibetsuChoshuYuyo.class))).thenReturn(true);

            FlexibleYear 主キー1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(主キー1, 主キー2);
            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);

            assertThat(sut.save(介護賦課徴収猶予), is(false));
        }
    }

    private static class TestSupport {

        public static ChoshuYuyo createChoshuYuyo(FlexibleYear 主キー1, FlexibleYear 主キー2) {
            ChoshuYuyo 介護賦課徴収猶予 = new ChoshuYuyo(主キー1, 主キー2, TsuchishoNo.EMPTY, Decimal.ZERO);
            return 介護賦課徴収猶予.createBuilderForEdit()
                    // 介護期別徴収猶予
                    .setKibetsuChoshuYuyo(createKibetsuChoshuYuyo(主キー1, 主キー2))
                    .build();
        }

// 介護期別徴収猶予
        private static KibetsuChoshuYuyo createKibetsuChoshuYuyo(FlexibleYear 主キー1, FlexibleYear 主キー2) {
            return new KibetsuChoshuYuyo(主キー2, 主キー2, TsuchishoNo.EMPTY, Decimal.ZERO, RString.EMPTY, 1);
        }

        public static ChoshuYuyo initializeChoshuYuyo(ChoshuYuyo 介護賦課徴収猶予) {

            DbT2006ChoshuYuyoEntity techoEntity = 介護賦課徴収猶予.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT2007KibetsuChoshuYuyoEntity> KibetsuChoshuYuyoEntityList = new ArrayList<>();
            List<KibetsuChoshuYuyo> 介護期別徴収猶予リスト = 介護賦課徴収猶予.getKibetsuChoshuYuyoList();
            for (KibetsuChoshuYuyo 介護期別徴収猶予 : 介護期別徴収猶予リスト) {
                KibetsuChoshuYuyoEntityList.add(介護期別徴収猶予.toEntity());
            }

            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(techoEntity);
            relateEntity.set介護期別徴収猶予Entity(KibetsuChoshuYuyoEntityList);
            relateEntity.initializeMd5ToEntities();

// 介護賦課徴収猶予
            return new ChoshuYuyo(relateEntity.get介護賦課徴収猶予Entity());
        }

        public static ChoshuYuyo modifiedChoshuYuyo(ChoshuYuyo 介護賦課徴収猶予) {

// 介護期別徴収猶予
            KibetsuChoshuYuyoBuilder KibetsuChoshuYuyoBuilder = 介護賦課徴収猶予.getKibetsuChoshuYuyoList().get(0).createBuilderForEdit();
            KibetsuChoshuYuyo KibetsuChoshuYuyo = KibetsuChoshuYuyoBuilder.set徴収方法(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            介護賦課徴収猶予 = 介護賦課徴収猶予.createBuilderForEdit()
                    .set徴収猶予事由(new RString("変更")) // TODO 任意項目の値を変更してください。
                    // 介護期別徴収猶予
                    .setKibetsuChoshuYuyo(KibetsuChoshuYuyo)
                    .build();
            return 介護賦課徴収猶予.modifiedModel();
        }
    }
}
