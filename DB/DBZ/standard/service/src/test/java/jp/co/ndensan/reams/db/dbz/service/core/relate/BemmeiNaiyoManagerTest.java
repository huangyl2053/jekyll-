/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.relate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.relate.BemmeiNaiyoMapperParameter;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7002BemmeiNaiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.relate.BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7002BemmeiNaiyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.relate.IBemmeiNaiyoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.BemmeishaJohoManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link BemmeiNaiyoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class BemmeiNaiyoManagerTest {

    // 弁明内容
    private static DbT7002BemmeiNaiyoDac dac;
    private static BemmeiNaiyoManager sut;
    private static BemmeishaJohoManager 弁明者情報Manager;

    private static MapperProvider provider;
    private static IBemmeiNaiyoMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IBemmeiNaiyoMapper.class);
// 弁明内容
        dac = mock(DbT7002BemmeiNaiyoDac.class);
        弁明者情報Manager = mock(BemmeishaJohoManager.class);
        sut = new BemmeiNaiyoManager(provider, dac,
                弁明者情報Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            BemmeiNaiyoManager result = BemmeiNaiyoManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            BemmeiNaiyoManager result = BemmeiNaiyoManager.createInstance();
            assertThat(result, instanceOf(BemmeiNaiyoManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get弁明内容 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get弁明内容(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select弁明内容ByKey(any(BemmeiNaiyoMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;

            BemmeiNaiyoMapperParameter 弁明内容検索条件 = BemmeiNaiyoMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            BemmeiNaiyo result = sut.get弁明内容(弁明内容検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            BemmeiNaiyoEntity entity = new BemmeiNaiyoEntity();
            entity.set弁明内容Entity(DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity());
            when(mapper.select弁明内容ByKey(any(BemmeiNaiyoMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyoMapperParameter 弁明内容検索条件 = BemmeiNaiyoMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            BemmeiNaiyo result = sut.get弁明内容(弁明内容検索条件);

            assertThat(result.get証記載保険者番号().value(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get弁明内容リストBy主キー1 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get弁明内容リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select弁明内容リストBy主キー1(any(BemmeiNaiyoMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            BemmeiNaiyoMapperParameter 弁明内容検索条件 = BemmeiNaiyoMapperParameter.createSelectListParam(主キー1);
            List<BemmeiNaiyo> result = sut.get弁明内容リストBy主キー1(弁明内容検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            BemmeiNaiyoEntity entity = new BemmeiNaiyoEntity();
            entity.set弁明内容Entity(DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity());

            List<BemmeiNaiyoEntity> entityList = Arrays.asList(entity);
            when(mapper.select弁明内容リストBy主キー1(any(BemmeiNaiyoMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            BemmeiNaiyoMapperParameter 弁明内容検索条件 = BemmeiNaiyoMapperParameter.createSelectListParam(主キー1);
            List<BemmeiNaiyo> result = sut.get弁明内容リストBy主キー1(弁明内容検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    public static class save弁明内容 extends DbzTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 弁明内容
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);
            when(弁明者情報Manager.save弁明者情報(any(BemmeishaJoho.class))).thenReturn(true);
            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo 弁明内容 = TestSupport.createBemmeiNaiyo(主キー1, 主キー2);

            assertThat(sut.save(弁明内容), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 弁明内容
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);
            when(弁明者情報Manager.save弁明者情報(any(BemmeishaJoho.class))).thenReturn(true);
            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo 弁明内容 = TestSupport.createBemmeiNaiyo(主キー1, 主キー2);

            assertThat(sut.save(弁明内容), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 弁明内容
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);
            when(弁明者情報Manager.save弁明者情報(any(BemmeishaJoho.class))).thenReturn(true);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo 弁明内容 = TestSupport.createBemmeiNaiyo(主キー1, 主キー2);
            弁明内容 = TestSupport.initializeBemmeiNaiyo(弁明内容);
            弁明内容 = TestSupport.modifiedBemmeiNaiyo(弁明内容);

            assertThat(sut.save(弁明内容), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 弁明内容
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);
            when(弁明者情報Manager.save弁明者情報(any(BemmeishaJoho.class))).thenReturn(true);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo 弁明内容 = TestSupport.createBemmeiNaiyo(主キー1, 主キー2);
            弁明内容 = TestSupport.initializeBemmeiNaiyo(弁明内容);
            弁明内容 = TestSupport.modifiedBemmeiNaiyo(弁明内容);

            assertThat(sut.save(弁明内容), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 弁明内容
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);
            when(弁明者情報Manager.save弁明者情報(any(BemmeishaJoho.class))).thenReturn(true);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo 弁明内容 = TestSupport.createBemmeiNaiyo(主キー1, 主キー2);
            弁明内容 = TestSupport.initializeBemmeiNaiyo(弁明内容);
            弁明内容 = 弁明内容.deleted();

            assertThat(sut.save(弁明内容), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 弁明内容
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);
            when(弁明者情報Manager.save弁明者情報(any(BemmeishaJoho.class))).thenReturn(true);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo 弁明内容 = TestSupport.createBemmeiNaiyo(主キー1, 主キー2);
            弁明内容 = TestSupport.initializeBemmeiNaiyo(弁明内容);
            弁明内容 = 弁明内容.deleted();

            assertThat(sut.save(弁明内容), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 弁明内容
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);
            when(弁明者情報Manager.save弁明者情報(any(BemmeishaJoho.class))).thenReturn(true);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo 弁明内容 = TestSupport.createBemmeiNaiyo(主キー1, 主キー2);
            弁明内容 = TestSupport.initializeBemmeiNaiyo(弁明内容);

            assertThat(sut.save(弁明内容), is(false));
        }
    }

    private static class TestSupport {

        public static BemmeiNaiyo createBemmeiNaiyo(ShoKisaiHokenshaNo 主キー1, ShikibetsuCode 主キー2) {
            BemmeiNaiyo 弁明内容 = new BemmeiNaiyo(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);
            return 弁明内容.createBuilderForEdit()
                    // 弁明者情報
                    .setBemmeishaJoho(createBemmeishaJoho(主キー1, 主キー2))
                    .build();
        }

// 弁明者情報
        private static BemmeishaJoho createBemmeishaJoho(ShoKisaiHokenshaNo 主キー1, ShikibetsuCode 主キー2) {
            return new BemmeishaJoho(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX, Decimal.ZERO);
        }

        public static BemmeiNaiyo initializeBemmeiNaiyo(BemmeiNaiyo 弁明内容) {

            DbT7002BemmeiNaiyoEntity techoEntity = 弁明内容.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT7003BemmeishaJohoEntity> BemmeishaJohoEntityList = new ArrayList<>();
            List<BemmeishaJoho> 弁明者情報リスト = 弁明内容.getBemmeishaJohoList();
            for (BemmeishaJoho 弁明者情報 : 弁明者情報リスト) {
                BemmeishaJohoEntityList.add(弁明者情報.toEntity());
            }

            BemmeiNaiyoEntity relateEntity = new BemmeiNaiyoEntity();
            relateEntity.set弁明内容Entity(techoEntity);
            relateEntity.set弁明者情報Entity(BemmeishaJohoEntityList);
            relateEntity.initializeMd5ToEntities();

// 弁明内容
            return new BemmeiNaiyo(relateEntity.get弁明内容Entity());
        }

        public static BemmeiNaiyo modifiedBemmeiNaiyo(BemmeiNaiyo 弁明内容) {

// 弁明者情報
            BemmeishaJohoBuilder BemmeishaJohoBuilder = 弁明内容.getBemmeishaJohoList().get(0).createBuilderForEdit();
            BemmeishaJoho BemmeishaJoho = BemmeishaJohoBuilder.set役職名(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            弁明内容 = 弁明内容.createBuilderForEdit()
                    .set弁明内容(new RString("変更")) // TODO 任意項目の値を変更してください。
                    // 弁明者情報
                    .setBemmeishaJoho(BemmeishaJoho)
                    .build();
            return 弁明内容.modified();
        }
    }
}
