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
import jp.co.ndensan.reams.db.dbc.business.core.basic.TandokuJoseikinKyufuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TandokuJoseikinKyufuKetteiBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TandokuJoseikinKyufuShinsei;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.TandokuJoseikinKyufuShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3098TandokuJoseikinKyufuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3098TandokuJoseikinKyufuShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.ITandokuJoseikinKyufuShinseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.TandokuJoseikinKyufuKetteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link TandokuJoseikinKyufuShinseiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseikinKyufuShinseiManagerTest {

//    private static TandokuJoseikinKyufuShinseiDac relateDac;
    // 市町村単独助成金給付申請
    private static DbT3098TandokuJoseikinKyufuShinseiDac dac;
    private static TandokuJoseikinKyufuShinseiManager sut;
    private static TandokuJoseikinKyufuKetteiManager 市町村単独助成金給付決定Manager;

    private static MapperProvider provider;
    private static ITandokuJoseikinKyufuShinseiMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(ITandokuJoseikinKyufuShinseiMapper.class);
// 市町村単独助成金給付申請
        dac = mock(DbT3098TandokuJoseikinKyufuShinseiDac.class);
        市町村単独助成金給付決定Manager = mock(TandokuJoseikinKyufuKetteiManager.class);
        sut = new TandokuJoseikinKyufuShinseiManager(provider, dac,
                市町村単独助成金給付決定Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            TandokuJoseikinKyufuShinseiManager result = TandokuJoseikinKyufuShinseiManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            TandokuJoseikinKyufuShinseiManager result = TandokuJoseikinKyufuShinseiManager.createInstance();
            assertThat(result, instanceOf(TandokuJoseikinKyufuShinseiManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get市町村単独助成金給付申請 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get市町村単独助成金給付申請(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select市町村単独助成金給付申請ByKey(any(TandokuJoseikinKyufuShinseiMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;

            TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件 = TandokuJoseikinKyufuShinseiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            TandokuJoseikinKyufuShinsei result = sut.get市町村単独助成金給付申請(市町村単独助成金給付申請検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            TandokuJoseikinKyufuShinseiEntity entity = new TandokuJoseikinKyufuShinseiEntity();
            entity.set市町村単独助成金給付申請Entity(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity());
            when(mapper.select市町村単独助成金給付申請ByKey(any(TandokuJoseikinKyufuShinseiMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
            TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件 = TandokuJoseikinKyufuShinseiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            TandokuJoseikinKyufuShinsei result = sut.get市町村単独助成金給付申請(市町村単独助成金給付申請検索条件);

            assertThat(result.get事業者区分(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_事業者区分));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get市町村単独助成金給付申請リストBy主キー1 extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get市町村単独助成金給付申請リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select市町村単独助成金給付申請リストBy主キー1(any(TandokuJoseikinKyufuShinseiMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件 = TandokuJoseikinKyufuShinseiMapperParameter.createSelectListParam(主キー1);
            List<TandokuJoseikinKyufuShinsei> result = sut.get市町村単独助成金給付申請リストBy主キー1(市町村単独助成金給付申請検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            TandokuJoseikinKyufuShinseiEntity entity = new TandokuJoseikinKyufuShinseiEntity();
            entity.set市町村単独助成金給付申請Entity(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity());

            List<TandokuJoseikinKyufuShinseiEntity> entityList = Arrays.asList(entity);
            when(mapper.select市町村単独助成金給付申請リストBy主キー1(any(TandokuJoseikinKyufuShinseiMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件 = TandokuJoseikinKyufuShinseiMapperParameter.createSelectListParam(主キー1);
            List<TandokuJoseikinKyufuShinsei> result = sut.get市町村単独助成金給付申請リストBy主キー1(市町村単独助成金給付申請検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get事業者区分(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_事業者区分));
        }
    }

    public static class save市町村単独助成金給付申請 extends DbcTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 市町村単独助成金給付申請
            when(dac.save(any(DbT3098TandokuJoseikinKyufuShinseiEntity.class))).thenReturn(1);
            when(市町村単独助成金給付決定Manager.save市町村単独助成金給付決定(any(TandokuJoseikinKyufuKettei.class))).thenReturn(true);
            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;

            TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請 = TestSupport.createTandokuJoseikinKyufuShinsei(主キー1, 主キー2);

            assertThat(sut.save(市町村単独助成金給付申請), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 市町村単独助成金給付申請
            when(dac.save(any(DbT3098TandokuJoseikinKyufuShinseiEntity.class))).thenReturn(1);
            when(市町村単独助成金給付決定Manager.save市町村単独助成金給付決定(any(TandokuJoseikinKyufuKettei.class))).thenReturn(true);
            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
            TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請 = TestSupport.createTandokuJoseikinKyufuShinsei(主キー1, 主キー2);

            assertThat(sut.save(市町村単独助成金給付申請), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 市町村単独助成金給付申請
            when(dac.save(any(DbT3098TandokuJoseikinKyufuShinseiEntity.class))).thenReturn(1);
            when(市町村単独助成金給付決定Manager.save市町村単独助成金給付決定(any(TandokuJoseikinKyufuKettei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
            TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請 = TestSupport.createTandokuJoseikinKyufuShinsei(主キー1, 主キー2);
            市町村単独助成金給付申請 = TestSupport.initializeTandokuJoseikinKyufuShinsei(市町村単独助成金給付申請);
            市町村単独助成金給付申請 = TestSupport.modifiedTandokuJoseikinKyufuShinsei(市町村単独助成金給付申請);

            assertThat(sut.save(市町村単独助成金給付申請), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 市町村単独助成金給付申請
            when(dac.save(any(DbT3098TandokuJoseikinKyufuShinseiEntity.class))).thenReturn(1);
            when(市町村単独助成金給付決定Manager.save市町村単独助成金給付決定(any(TandokuJoseikinKyufuKettei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
            TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請 = TestSupport.createTandokuJoseikinKyufuShinsei(主キー1, 主キー2);
            市町村単独助成金給付申請 = TestSupport.initializeTandokuJoseikinKyufuShinsei(市町村単独助成金給付申請);
            市町村単独助成金給付申請 = TestSupport.modifiedTandokuJoseikinKyufuShinsei(市町村単独助成金給付申請);

            assertThat(sut.save(市町村単独助成金給付申請), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 市町村単独助成金給付申請
            when(dac.save(any(DbT3098TandokuJoseikinKyufuShinseiEntity.class))).thenReturn(1);
            when(市町村単独助成金給付決定Manager.save市町村単独助成金給付決定(any(TandokuJoseikinKyufuKettei.class))).thenReturn(false);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
            TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請 = TestSupport.createTandokuJoseikinKyufuShinsei(主キー1, 主キー2);
            市町村単独助成金給付申請 = TestSupport.initializeTandokuJoseikinKyufuShinsei(市町村単独助成金給付申請);
            市町村単独助成金給付申請 = 市町村単独助成金給付申請.deleted();

            assertThat(sut.save(市町村単独助成金給付申請), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 市町村単独助成金給付申請
            when(dac.save(any(DbT3098TandokuJoseikinKyufuShinseiEntity.class))).thenReturn(1);
            when(市町村単独助成金給付決定Manager.save市町村単独助成金給付決定(any(TandokuJoseikinKyufuKettei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
            TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請 = TestSupport.createTandokuJoseikinKyufuShinsei(主キー1, 主キー2);
            市町村単独助成金給付申請 = TestSupport.initializeTandokuJoseikinKyufuShinsei(市町村単独助成金給付申請);
            市町村単独助成金給付申請 = 市町村単独助成金給付申請.deleted();

            assertThat(sut.save(市町村単独助成金給付申請), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 市町村単独助成金給付申請
            when(dac.save(any(DbT3098TandokuJoseikinKyufuShinseiEntity.class))).thenReturn(1);
            when(市町村単独助成金給付決定Manager.save市町村単独助成金給付決定(any(TandokuJoseikinKyufuKettei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
            TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請 = TestSupport.createTandokuJoseikinKyufuShinsei(主キー1, 主キー2);
            市町村単独助成金給付申請 = TestSupport.initializeTandokuJoseikinKyufuShinsei(市町村単独助成金給付申請);

            assertThat(sut.save(市町村単独助成金給付申請), is(false));
        }
    }

    private static class TestSupport {

        public static TandokuJoseikinKyufuShinsei createTandokuJoseikinKyufuShinsei(HihokenshaNo 主キー1, FlexibleDate 主キー2) {
            TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請 = new TandokuJoseikinKyufuShinsei(主キー1, 主キー2, Decimal.ZERO);
            return 市町村単独助成金給付申請.createBuilderForEdit()
                    // 市町村単独助成金給付決定
                    .setTandokuJoseikinKyufuKettei(createTandokuJoseikinKyufuKettei(主キー1, 主キー2))
                    .build();
        }

// 市町村単独助成金給付決定
        private static TandokuJoseikinKyufuKettei createTandokuJoseikinKyufuKettei(HihokenshaNo 主キー1, FlexibleDate 主キー2) {
            return new TandokuJoseikinKyufuKettei(主キー1, 主キー2, Decimal.ZERO);
        }

        public static TandokuJoseikinKyufuShinsei initializeTandokuJoseikinKyufuShinsei(TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請) {

            DbT3098TandokuJoseikinKyufuShinseiEntity techoEntity = 市町村単独助成金給付申請.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT3097TandokuJoseikinKyufuKetteiEntity> TandokuJoseikinKyufuKetteiEntityList = new ArrayList<>();
            List<TandokuJoseikinKyufuKettei> 市町村単独助成金給付決定リスト = 市町村単独助成金給付申請.getTandokuJoseikinKyufuKetteiList();
            for (TandokuJoseikinKyufuKettei 市町村単独助成金給付決定 : 市町村単独助成金給付決定リスト) {
                TandokuJoseikinKyufuKetteiEntityList.add(市町村単独助成金給付決定.toEntity());
            }

            TandokuJoseikinKyufuShinseiEntity relateEntity = new TandokuJoseikinKyufuShinseiEntity();
            relateEntity.set市町村単独助成金給付申請Entity(techoEntity);
            relateEntity.set市町村単独助成金給付決定Entity(TandokuJoseikinKyufuKetteiEntityList);
            relateEntity.initializeMd5ToEntities();

// 市町村単独助成金給付申請
            return new TandokuJoseikinKyufuShinsei(relateEntity.get市町村単独助成金給付申請Entity());
        }

        public static TandokuJoseikinKyufuShinsei modifiedTandokuJoseikinKyufuShinsei(TandokuJoseikinKyufuShinsei 市町村単独助成金給付申請) {

// 市町村単独助成金給付決定
            TandokuJoseikinKyufuKetteiBuilder TandokuJoseikinKyufuKetteiBuilder = 市町村単独助成金給付申請.getTandokuJoseikinKyufuKetteiList().get(0).createBuilderForEdit();
            TandokuJoseikinKyufuKettei TandokuJoseikinKyufuKettei = TandokuJoseikinKyufuKetteiBuilder.set保留区分_認定申請中(new RString("1")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            市町村単独助成金給付申請 = 市町村単独助成金給付申請.createBuilderForEdit()
                    .set申請理由(new RString("変更")) // TODO 任意項目の値を変更してください。
                    // 市町村単独助成金給付決定
                    .setTandokuJoseikinKyufuKettei(TandokuJoseikinKyufuKettei)
                    .build();
            return 市町村単独助成金給付申請.modifiedModel();
        }
    }
}
