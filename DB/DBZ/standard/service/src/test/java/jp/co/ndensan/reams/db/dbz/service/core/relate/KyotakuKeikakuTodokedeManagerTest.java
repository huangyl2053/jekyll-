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
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJigyoshaSakuseiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.IKyotakuKeikakuTodokedeMapper;
import jp.co.ndensan.reams.db.dbz.persistence.db.relate.KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KyotakuKeikakuJigyoshaSakuseiManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {link KyotakuKeikakuTodokedeManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuTodokedeManagerTest {

    private static KyotakuKeikakuTodokedeDac relateDac;
    // 居宅給付計画届出
    private static DbT3005KyotakuKeikakuTodokedeDac dac;
    private static KyotakuKeikakuTodokedeManager sut;
    private static KyotakuKeikakuJigyoshaSakuseiManager 居宅給付計画事業者作成Manager;
    private static KyotakuKeikakuJikoSakuseiManager 居宅給付計画自己作成Manager;

    private static MapperProvider provider;
    private static IKyotakuKeikakuTodokedeMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IKyotakuKeikakuTodokedeMapper.class);
// 居宅給付計画届出
        dac = mock(DbT3005KyotakuKeikakuTodokedeDac.class);
        居宅給付計画事業者作成Manager = mock(KyotakuKeikakuJigyoshaSakuseiManager.class);
        居宅給付計画自己作成Manager = mock(KyotakuKeikakuJikoSakuseiManager.class);
        sut = new KyotakuKeikakuTodokedeManager(provider, dac,
                居宅給付計画事業者作成Manager,
                居宅給付計画自己作成Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            KyotakuKeikakuTodokedeManager result = KyotakuKeikakuTodokedeManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            KyotakuKeikakuTodokedeManager result = KyotakuKeikakuTodokedeManager.createInstance();
            assertThat(result, instanceOf(KyotakuKeikakuTodokedeManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画届出 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get居宅給付計画届出(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select居宅給付計画届出ByKey(any(KyotakuKeikakuTodokedeMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;

            KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件 = KyotakuKeikakuTodokedeMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            KyotakuKeikakuTodokede result = sut.get居宅給付計画届出(居宅給付計画届出検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KyotakuKeikakuTodokedeEntity entity = new KyotakuKeikakuTodokedeEntity();
            entity.set居宅給付計画届出Entity(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());
            when(mapper.select居宅給付計画届出ByKey(any(KyotakuKeikakuTodokedeMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件 = KyotakuKeikakuTodokedeMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            KyotakuKeikakuTodokede result = sut.get居宅給付計画届出(居宅給付計画届出検索条件);

            assertThat(result.get被保険者番号().value(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画届出リストBy主キー1 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get居宅給付計画届出リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select居宅給付計画届出リストBy主キー1(any(KyotakuKeikakuTodokedeMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件 = KyotakuKeikakuTodokedeMapperParameter.createSelectListParam(主キー1);
            List<KyotakuKeikakuTodokede> result = sut.get居宅給付計画届出リストBy主キー1(居宅給付計画届出検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            KyotakuKeikakuTodokedeEntity entity = new KyotakuKeikakuTodokedeEntity();
            entity.set居宅給付計画届出Entity(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());

            List<KyotakuKeikakuTodokedeEntity> entityList = Arrays.asList(entity);
            when(mapper.select居宅給付計画届出リストBy主キー1(any(KyotakuKeikakuTodokedeMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件 = KyotakuKeikakuTodokedeMapperParameter.createSelectListParam(主キー1);
            List<KyotakuKeikakuTodokede> result = sut.get居宅給付計画届出リストBy主キー1(居宅給付計画届出検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save居宅給付計画届出 extends DbzTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 居宅給付計画届出
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);
            when(居宅給付計画事業者作成Manager.save居宅給付計画事業者作成(any(KyotakuKeikakuJigyoshaSakusei.class))).thenReturn(true);
            when(居宅給付計画自己作成Manager.save(any(KyotakuKeikakuJikoSakusei.class))).thenReturn(true);
            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuTodokede 居宅給付計画届出 = TestSupport.createKyotakuKeikakuTodokede(主キー1, 主キー2);

            assertThat(sut.save(居宅給付計画届出), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 居宅給付計画届出
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);
            when(居宅給付計画事業者作成Manager.save居宅給付計画事業者作成(any(KyotakuKeikakuJigyoshaSakusei.class))).thenReturn(true);
            when(居宅給付計画自己作成Manager.save(any(KyotakuKeikakuJikoSakusei.class))).thenReturn(true);
            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuTodokede 居宅給付計画届出 = TestSupport.createKyotakuKeikakuTodokede(主キー1, 主キー2);

            assertThat(sut.save(居宅給付計画届出), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 居宅給付計画届出
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);
            when(居宅給付計画事業者作成Manager.save居宅給付計画事業者作成(any(KyotakuKeikakuJigyoshaSakusei.class))).thenReturn(true);
            when(居宅給付計画自己作成Manager.save(any(KyotakuKeikakuJikoSakusei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuTodokede 居宅給付計画届出 = TestSupport.createKyotakuKeikakuTodokede(主キー1, 主キー2);
            居宅給付計画届出 = TestSupport.initializeKyotakuKeikakuTodokede(居宅給付計画届出);
            居宅給付計画届出 = TestSupport.modifiedKyotakuKeikakuTodokede(居宅給付計画届出);

            assertThat(sut.save(居宅給付計画届出), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 居宅給付計画届出
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);
            when(居宅給付計画事業者作成Manager.save居宅給付計画事業者作成(any(KyotakuKeikakuJigyoshaSakusei.class))).thenReturn(true);
            when(居宅給付計画自己作成Manager.save(any(KyotakuKeikakuJikoSakusei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuTodokede 居宅給付計画届出 = TestSupport.createKyotakuKeikakuTodokede(主キー1, 主キー2);
            居宅給付計画届出 = TestSupport.initializeKyotakuKeikakuTodokede(居宅給付計画届出);
            居宅給付計画届出 = TestSupport.modifiedKyotakuKeikakuTodokede(居宅給付計画届出);

            assertThat(sut.save(居宅給付計画届出), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 居宅給付計画届出
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);
            when(居宅給付計画事業者作成Manager.save居宅給付計画事業者作成(any(KyotakuKeikakuJigyoshaSakusei.class))).thenReturn(true);
            when(居宅給付計画自己作成Manager.save(any(KyotakuKeikakuJikoSakusei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuTodokede 居宅給付計画届出 = TestSupport.createKyotakuKeikakuTodokede(主キー1, 主キー2);
            居宅給付計画届出 = TestSupport.initializeKyotakuKeikakuTodokede(居宅給付計画届出);
            居宅給付計画届出 = 居宅給付計画届出.deleted();

            assertThat(sut.save(居宅給付計画届出), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 居宅給付計画届出
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);
            when(居宅給付計画事業者作成Manager.save居宅給付計画事業者作成(any(KyotakuKeikakuJigyoshaSakusei.class))).thenReturn(true);
            when(居宅給付計画自己作成Manager.save(any(KyotakuKeikakuJikoSakusei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuTodokede 居宅給付計画届出 = TestSupport.createKyotakuKeikakuTodokede(主キー1, 主キー2);
            居宅給付計画届出 = TestSupport.initializeKyotakuKeikakuTodokede(居宅給付計画届出);
            居宅給付計画届出 = 居宅給付計画届出.deleted();

            assertThat(sut.save(居宅給付計画届出), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 居宅給付計画届出
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);
            when(居宅給付計画事業者作成Manager.save居宅給付計画事業者作成(any(KyotakuKeikakuJigyoshaSakusei.class))).thenReturn(true);
            when(居宅給付計画自己作成Manager.save(any(KyotakuKeikakuJikoSakusei.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuTodokede 居宅給付計画届出 = TestSupport.createKyotakuKeikakuTodokede(主キー1, 主キー2);
            居宅給付計画届出 = TestSupport.initializeKyotakuKeikakuTodokede(居宅給付計画届出);

            assertThat(sut.save(居宅給付計画届出), is(false));
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuTodokede createKyotakuKeikakuTodokede(HihokenshaNo 主キー1, FlexibleYearMonth 主キー2) {
            KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(主キー1, 主キー2, new Decimal(0));
            return 居宅給付計画届出.createBuilderForEdit()
                    // 居宅給付計画事業者作成
                    .setKyotakuKeikakuJigyosha(createKyotakuKeikakuJigyoshaSakusei(主キー1, 主キー2))
                    // 居宅給付計画自己作成
                    .setKyotakuKeikakuJiko(createKyotakuKeikakuJikoSakusei(主キー1, 主キー2))
                    .build();
        }

// 居宅給付計画事業者作成
        private static KyotakuKeikakuJigyoshaSakusei createKyotakuKeikakuJigyoshaSakusei(HihokenshaNo 主キー1, FlexibleYearMonth 主キー2) {
            return new KyotakuKeikakuJigyoshaSakusei(
                    主キー1,
                    主キー2,
                    new Decimal(0));
        }
// 居宅給付計画自己作成

        private static KyotakuKeikakuJikoSakusei createKyotakuKeikakuJikoSakusei(HihokenshaNo 主キー1, FlexibleYearMonth 主キー2) {
            return new KyotakuKeikakuJikoSakusei(主キー1, 主キー2, Decimal.ZERO);
        }

        public static KyotakuKeikakuTodokede initializeKyotakuKeikakuTodokede(KyotakuKeikakuTodokede 居宅給付計画届出) {

            DbT3005KyotakuKeikakuTodokedeEntity techoEntity = 居宅給付計画届出.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> KyotakuKeikakuJigyoshaSakuseiEntityList = new ArrayList<>();
            List<KyotakuKeikakuJigyoshaSakusei> 居宅給付計画事業者作成リスト = 居宅給付計画届出.getKyotakuKeikakuJigyoshaSakuseiList();
            for (KyotakuKeikakuJigyoshaSakusei 居宅給付計画事業者作成 : 居宅給付計画事業者作成リスト) {
                KyotakuKeikakuJigyoshaSakuseiEntityList.add(居宅給付計画事業者作成.toEntity());
            }
            List<DbT3007KyotakuKeikakuJikoSakuseiEntity> KyotakuKeikakuJikoSakuseiEntityList = new ArrayList<>();
            List<KyotakuKeikakuJikoSakusei> 居宅給付計画自己作成リスト = 居宅給付計画届出.getKyotakuKeikakuJikoSakuseiList();
            for (KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 : 居宅給付計画自己作成リスト) {
                KyotakuKeikakuJikoSakuseiEntityList.add(居宅給付計画自己作成.toEntity());
            }

            KyotakuKeikakuTodokedeEntity relateEntity = new KyotakuKeikakuTodokedeEntity();
            relateEntity.set居宅給付計画届出Entity(techoEntity);
            relateEntity.set居宅給付計画事業者作成Entity(KyotakuKeikakuJigyoshaSakuseiEntityList);
            relateEntity.set居宅給付計画自己作成Entity(KyotakuKeikakuJikoSakuseiEntityList);
            relateEntity.initializeMd5ToEntities();

// 居宅給付計画届出
            return new KyotakuKeikakuTodokede(relateEntity.get居宅給付計画届出Entity());
        }

        public static KyotakuKeikakuTodokede modifiedKyotakuKeikakuTodokede(KyotakuKeikakuTodokede 居宅給付計画届出) {

// 居宅給付計画事業者作成
            KyotakuKeikakuJigyoshaSakuseiBuilder KyotakuKeikakuJigyoshaSakuseiBuilder = 居宅給付計画届出.getKyotakuKeikakuJigyoshaSakuseiList().get(0).createBuilderForEdit();
            KyotakuKeikakuJigyoshaSakusei KyotakuKeikakuJigyoshaSakusei = KyotakuKeikakuJigyoshaSakuseiBuilder.set事業者変更事由(new RString("任意項目1を変更")).build();
// 居宅給付計画自己作成
            KyotakuKeikakuJikoSakuseiBuilder KyotakuKeikakuJikoSakuseiBuilder = 居宅給付計画届出.getKyotakuKeikakuJikoSakuseiList().get(0).createBuilderForEdit();
            KyotakuKeikakuJikoSakusei KyotakuKeikakuJikoSakusei = KyotakuKeikakuJikoSakuseiBuilder.set計画変更事由(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            居宅給付計画届出 = 居宅給付計画届出.createBuilderForEdit()
                    .set暫定区分(new RString("1")) // TODO 任意項目の値を変更してください。
                    // 居宅給付計画事業者作成
                    .setKyotakuKeikakuJigyosha(KyotakuKeikakuJigyoshaSakusei)
                    // 居宅給付計画自己作成
                    .setKyotakuKeikakuJiko(KyotakuKeikakuJikoSakusei)
                    .build();
            return 居宅給付計画届出.modified();
        }
    }
}
