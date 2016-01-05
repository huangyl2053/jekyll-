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
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikosakuseiMeisai;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikosakuseiMeisaiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.YoboKeikakuJikoSakuseiMeisai;
import jp.co.ndensan.reams.db.dbz.business.core.basic.YoboKeikakuJikoSakuseiMeisaiBuilder;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.KyotakuKeikakuJikoSakuseiMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.IKyotakuKeikakuJikoSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.persistence.db.relate.KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KyotakuKeikakuJikosakuseiMeisaiManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.YoboKeikakuJikoSakuseiMeisaiManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link KyotakuKeikakuJikoSakuseiManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiManagerTest {

    private static KyotakuKeikakuJikoSakuseiDac relateDac;
    // 居宅給付計画自己作成
    private static DbT3007KyotakuKeikakuJikoSakuseiDac dac;
    private static KyotakuKeikakuJikoSakuseiManager sut;
    private static KyotakuKeikakuJikosakuseiMeisaiManager 居宅給付計画自己作成明細Manager;
    private static YoboKeikakuJikoSakuseiMeisaiManager 予防給付計画自己作成明細Manager;

    private static MapperProvider provider;
    private static IKyotakuKeikakuJikoSakuseiMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IKyotakuKeikakuJikoSakuseiMapper.class);
// 居宅給付計画自己作成
        dac = mock(DbT3007KyotakuKeikakuJikoSakuseiDac.class);
        居宅給付計画自己作成明細Manager = mock(KyotakuKeikakuJikosakuseiMeisaiManager.class);
        予防給付計画自己作成明細Manager = mock(YoboKeikakuJikoSakuseiMeisaiManager.class);
        sut = new KyotakuKeikakuJikoSakuseiManager(provider, dac,
                居宅給付計画自己作成明細Manager,
                予防給付計画自己作成明細Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            KyotakuKeikakuJikoSakuseiManager result = KyotakuKeikakuJikoSakuseiManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            KyotakuKeikakuJikoSakuseiManager result = KyotakuKeikakuJikoSakuseiManager.createInstance();
            assertThat(result, instanceOf(KyotakuKeikakuJikoSakuseiManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画自己作成 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get居宅給付計画自己作成(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select居宅給付計画自己作成ByKey(any(KyotakuKeikakuJikoSakuseiMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;

            KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件 = KyotakuKeikakuJikoSakuseiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            KyotakuKeikakuJikoSakusei result = sut.get居宅給付計画自己作成(居宅給付計画自己作成検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KyotakuKeikakuJikoSakuseiEntity entity = new KyotakuKeikakuJikoSakuseiEntity();
            entity.set居宅給付計画自己作成Entity(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity());
            when(mapper.select居宅給付計画自己作成ByKey(any(KyotakuKeikakuJikoSakuseiMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件 = KyotakuKeikakuJikoSakuseiMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            KyotakuKeikakuJikoSakusei result = sut.get居宅給付計画自己作成(居宅給付計画自己作成検索条件);

            assertThat(result.get被保険者番号().value(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画自己作成リストBy主キー1 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get居宅給付計画自己作成リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select居宅給付計画自己作成リストBy主キー1(any(KyotakuKeikakuJikoSakuseiMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件 = KyotakuKeikakuJikoSakuseiMapperParameter.createSelectListParam(主キー1);
            List<KyotakuKeikakuJikoSakusei> result = sut.get居宅給付計画自己作成リストBy主キー1(居宅給付計画自己作成検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            KyotakuKeikakuJikoSakuseiEntity entity = new KyotakuKeikakuJikoSakuseiEntity();
            entity.set居宅給付計画自己作成Entity(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity());

            List<KyotakuKeikakuJikoSakuseiEntity> entityList = Arrays.asList(entity);
            when(mapper.select居宅給付計画自己作成リストBy主キー1(any(KyotakuKeikakuJikoSakuseiMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件 = KyotakuKeikakuJikoSakuseiMapperParameter.createSelectListParam(主キー1);
            List<KyotakuKeikakuJikoSakusei> result = sut.get居宅給付計画自己作成リストBy主キー1(居宅給付計画自己作成検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save居宅給付計画自己作成 extends DbzTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 居宅給付計画自己作成
            when(dac.save(any(DbT3007KyotakuKeikakuJikoSakuseiEntity.class))).thenReturn(1);
            when(居宅給付計画自己作成明細Manager.save居宅給付計画自己作成明細(any(KyotakuKeikakuJikosakuseiMeisai.class))).thenReturn(true);
            when(予防給付計画自己作成明細Manager.save予防給付計画自己作成明細(any(YoboKeikakuJikoSakuseiMeisai.class))).thenReturn(true);
            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = TestSupport.createKyotakuKeikakuJikoSakusei(主キー1, 主キー2);

            assertThat(sut.save(居宅給付計画自己作成), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(true)を.thenReturn(0)に変更してください。
// 居宅給付計画自己作成
            when(dac.save(any(DbT3007KyotakuKeikakuJikoSakuseiEntity.class))).thenReturn(1);
            when(居宅給付計画自己作成明細Manager.save居宅給付計画自己作成明細(any(KyotakuKeikakuJikosakuseiMeisai.class))).thenReturn(true);
            when(予防給付計画自己作成明細Manager.save予防給付計画自己作成明細(any(YoboKeikakuJikoSakuseiMeisai.class))).thenReturn(true);
            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = TestSupport.createKyotakuKeikakuJikoSakusei(主キー1, 主キー2);

            assertThat(sut.save(居宅給付計画自己作成), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 居宅給付計画自己作成
            when(dac.save(any(DbT3007KyotakuKeikakuJikoSakuseiEntity.class))).thenReturn(1);
            when(居宅給付計画自己作成明細Manager.save居宅給付計画自己作成明細(any(KyotakuKeikakuJikosakuseiMeisai.class))).thenReturn(true);
            when(予防給付計画自己作成明細Manager.save予防給付計画自己作成明細(any(YoboKeikakuJikoSakuseiMeisai.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = TestSupport.createKyotakuKeikakuJikoSakusei(主キー1, 主キー2);
            居宅給付計画自己作成 = TestSupport.initializeKyotakuKeikakuJikoSakusei(居宅給付計画自己作成);
            居宅給付計画自己作成 = TestSupport.modifiedKyotakuKeikakuJikoSakusei(居宅給付計画自己作成);

            assertThat(sut.save(居宅給付計画自己作成), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(true)を.thenReturn(0)に変更してください。
// 居宅給付計画自己作成
            when(dac.save(any(DbT3007KyotakuKeikakuJikoSakuseiEntity.class))).thenReturn(1);
            when(居宅給付計画自己作成明細Manager.save居宅給付計画自己作成明細(any(KyotakuKeikakuJikosakuseiMeisai.class))).thenReturn(true);
            when(予防給付計画自己作成明細Manager.save予防給付計画自己作成明細(any(YoboKeikakuJikoSakuseiMeisai.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = TestSupport.createKyotakuKeikakuJikoSakusei(主キー1, 主キー2);
            居宅給付計画自己作成 = TestSupport.initializeKyotakuKeikakuJikoSakusei(居宅給付計画自己作成);
            居宅給付計画自己作成 = TestSupport.modifiedKyotakuKeikakuJikoSakusei(居宅給付計画自己作成);

            assertThat(sut.save(居宅給付計画自己作成), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 居宅給付計画自己作成
            when(dac.save(any(DbT3007KyotakuKeikakuJikoSakuseiEntity.class))).thenReturn(1);
            when(居宅給付計画自己作成明細Manager.save居宅給付計画自己作成明細(any(KyotakuKeikakuJikosakuseiMeisai.class))).thenReturn(true);
            when(予防給付計画自己作成明細Manager.save予防給付計画自己作成明細(any(YoboKeikakuJikoSakuseiMeisai.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = TestSupport.createKyotakuKeikakuJikoSakusei(主キー1, 主キー2);
            居宅給付計画自己作成 = TestSupport.initializeKyotakuKeikakuJikoSakusei(居宅給付計画自己作成);
            居宅給付計画自己作成 = 居宅給付計画自己作成.deleted();

            assertThat(sut.save(居宅給付計画自己作成), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(true)を.thenReturn(0)に変更してください。
// 居宅給付計画自己作成
            when(dac.save(any(DbT3007KyotakuKeikakuJikoSakuseiEntity.class))).thenReturn(1);
            when(居宅給付計画自己作成明細Manager.save居宅給付計画自己作成明細(any(KyotakuKeikakuJikosakuseiMeisai.class))).thenReturn(true);
            when(予防給付計画自己作成明細Manager.save予防給付計画自己作成明細(any(YoboKeikakuJikoSakuseiMeisai.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = TestSupport.createKyotakuKeikakuJikoSakusei(主キー1, 主キー2);
            居宅給付計画自己作成 = TestSupport.initializeKyotakuKeikakuJikoSakusei(居宅給付計画自己作成);
            居宅給付計画自己作成 = 居宅給付計画自己作成.deleted();

            assertThat(sut.save(居宅給付計画自己作成), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(true)を.thenReturn(0)に変更してください。
// 居宅給付計画自己作成
            when(dac.save(any(DbT3007KyotakuKeikakuJikoSakuseiEntity.class))).thenReturn(1);
            when(居宅給付計画自己作成明細Manager.save居宅給付計画自己作成明細(any(KyotakuKeikakuJikosakuseiMeisai.class))).thenReturn(true);
            when(予防給付計画自己作成明細Manager.save予防給付計画自己作成明細(any(YoboKeikakuJikoSakuseiMeisai.class))).thenReturn(true);

            HihokenshaNo 主キー1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = TestSupport.createKyotakuKeikakuJikoSakusei(主キー1, 主キー2);
            居宅給付計画自己作成 = TestSupport.initializeKyotakuKeikakuJikoSakusei(居宅給付計画自己作成);

            assertThat(sut.save(居宅給付計画自己作成), is(false));
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuJikoSakusei createKyotakuKeikakuJikoSakusei(HihokenshaNo 主キー1, FlexibleYearMonth 主キー2) {
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = new KyotakuKeikakuJikoSakusei(主キー1, 主キー2, Decimal.ZERO);
            return 居宅給付計画自己作成.createBuilderForEdit()
                    // 居宅給付計画自己作成明細
                    .setKyotakuKeikaku(createKyotakuKeikakuJikosakuseiMeisai(主キー1, 主キー2))
                    // 予防給付計画自己作成明細
                    .setYoboKeikaku(createYoboKeikakuJikoSakuseiMeisai(主キー1, 主キー2))
                    .build();
        }

// 居宅給付計画自己作成明細
        private static KyotakuKeikakuJikosakuseiMeisai createKyotakuKeikakuJikosakuseiMeisai(HihokenshaNo 主キー1, FlexibleYearMonth 主キー2) {
            return new KyotakuKeikakuJikosakuseiMeisai(
                    主キー1, 主キー2, Decimal.ZERO, RString.EMPTY, JigyoshaNo.EMPTY, ServiceShuruiCode.EMPTY, ServiceKomokuCode.EMPTY);
        }
// 予防給付計画自己作成明細

        private static YoboKeikakuJikoSakuseiMeisai createYoboKeikakuJikoSakuseiMeisai(HihokenshaNo 主キー1, FlexibleYearMonth 主キー2) {
            return new YoboKeikakuJikoSakuseiMeisai(
                    主キー1, 主キー2, Decimal.ZERO, RString.EMPTY, JigyoshaNo.EMPTY, ServiceShuruiCode.EMPTY, ServiceKomokuCode.EMPTY);
        }

        public static KyotakuKeikakuJikoSakusei initializeKyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakusei 居宅給付計画自己作成) {

            DbT3007KyotakuKeikakuJikoSakuseiEntity techoEntity = 居宅給付計画自己作成.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity> KyotakuKeikakuJikosakuseiMeisaiEntityList = new ArrayList<>();
            List<KyotakuKeikakuJikosakuseiMeisai> 居宅給付計画自己作成明細リスト = 居宅給付計画自己作成.getKyotakuKeikakuJikosakuseiMeisaiList();
            for (KyotakuKeikakuJikosakuseiMeisai 居宅給付計画自己作成明細 : 居宅給付計画自己作成明細リスト) {
                KyotakuKeikakuJikosakuseiMeisaiEntityList.add(居宅給付計画自己作成明細.toEntity());
            }
            List<DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity> YoboKeikakuJikoSakuseiMeisaiEntityList = new ArrayList<>();
            List<YoboKeikakuJikoSakuseiMeisai> 予防給付計画自己作成明細リスト = 居宅給付計画自己作成.getYoboKeikakuJikoSakuseiMeisaiList();
            for (YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 : 予防給付計画自己作成明細リスト) {
                YoboKeikakuJikoSakuseiMeisaiEntityList.add(予防給付計画自己作成明細.toEntity());
            }

            KyotakuKeikakuJikoSakuseiEntity relateEntity = new KyotakuKeikakuJikoSakuseiEntity();
            relateEntity.set居宅給付計画自己作成Entity(techoEntity);
            relateEntity.set居宅給付計画自己作成明細Entity(KyotakuKeikakuJikosakuseiMeisaiEntityList);
            relateEntity.set予防給付計画自己作成明細Entity(YoboKeikakuJikoSakuseiMeisaiEntityList);
            relateEntity.initializeMd5ToEntities();

// 居宅給付計画自己作成
            return new KyotakuKeikakuJikoSakusei(relateEntity.get居宅給付計画自己作成Entity());
        }

        public static KyotakuKeikakuJikoSakusei modifiedKyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakusei 居宅給付計画自己作成) {

// 居宅給付計画自己作成明細
            KyotakuKeikakuJikosakuseiMeisaiBuilder KyotakuKeikakuJikosakuseiMeisaiBuilder = 居宅給付計画自己作成.getKyotakuKeikakuJikosakuseiMeisaiList().get(0).createBuilderForEdit();
            KyotakuKeikakuJikosakuseiMeisai KyotakuKeikakuJikosakuseiMeisai = KyotakuKeikakuJikosakuseiMeisaiBuilder.set居宅サービス区分(new RString("1")).build();
// 予防給付計画自己作成明細
            YoboKeikakuJikoSakuseiMeisaiBuilder YoboKeikakuJikoSakuseiMeisaiBuilder = 居宅給付計画自己作成.getYoboKeikakuJikoSakuseiMeisaiList().get(0).createBuilderForEdit();
            YoboKeikakuJikoSakuseiMeisai YoboKeikakuJikoSakuseiMeisai = YoboKeikakuJikoSakuseiMeisaiBuilder.set居宅サービス区分(new RString("1")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            居宅給付計画自己作成 = 居宅給付計画自己作成.createBuilderForEdit()
                    .set計画変更年月日(new FlexibleDate("20150101")) // TODO 任意項目の値を変更してください。
                    // 居宅給付計画自己作成明細
                    .setKyotakuKeikaku(KyotakuKeikakuJikosakuseiMeisai)
                    // 予防給付計画自己作成明細
                    .setYoboKeikaku(YoboKeikakuJikoSakuseiMeisai)
                    .build();
            return 居宅給付計画自己作成.modified();
        }
    }
}
