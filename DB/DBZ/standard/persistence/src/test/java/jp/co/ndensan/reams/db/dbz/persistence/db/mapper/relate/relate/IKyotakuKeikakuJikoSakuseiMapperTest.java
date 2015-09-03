/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.relate.KyotakuKeikakuJikoSakuseiMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.relate.KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IKyotakuKeikakuJikoSakuseiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IKyotakuKeikakuJikoSakuseiMapperTest {

    private static IKyotakuKeikakuJikoSakuseiMapper sut;
    private static DbT3007KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac;
    private static DbT3008KyotakuKeikakuJikosakuseiMeisaiDac 居宅給付計画自己作成明細Dac;
    private static DbT3011YoboKeikakuJikoSakuseiMeisaiDac 予防給付計画自己作成明細Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final HihokenshaNo 主キー11 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 主キー12 = new HihokenshaNo("9999999999");
    private static final FlexibleYearMonth 主キー21 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
    private static final FlexibleYearMonth 主キー22 = new FlexibleYearMonth("201501");
    private static final Decimal 主キー31 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_履歴番号;
    private static final Decimal 主キー32 = new Decimal(2341);

    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth taishoYM;
    private Decimal rirekiNo;

    @BeforeClass
    public static void setUpClass() {
        居宅給付計画自己作成Dac = InstanceProvider.create(DbT3007KyotakuKeikakuJikoSakuseiDac.class);
        居宅給付計画自己作成明細Dac = InstanceProvider.create(DbT3008KyotakuKeikakuJikosakuseiMeisaiDac.class);
        予防給付計画自己作成明細Dac = InstanceProvider.create(DbT3011YoboKeikakuJikoSakuseiMeisaiDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select居宅給付計画自己作成ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKyotakuKeikakuJikoSakuseiMapper.class);
            TestSupport.insertDbT3007(主キー11, 主キー21);
            TestSupport.insertDbT3007(主キー11, 主キー22);
            TestSupport.insertDbT3007(主キー12, 主キー21);
            TestSupport.insertDbT3007(主キー12, 主キー22);

            TestSupport.insertDbT3008(主キー11, 主キー21);
            TestSupport.insertDbT3008(主キー11, 主キー22);
            TestSupport.insertDbT3008(主キー12, 主キー21);
            TestSupport.insertDbT3008(主キー12, 主キー22);

            TestSupport.insertDbT3011(主キー11, 主キー21);
            TestSupport.insertDbT3011(主キー11, 主キー22);
            TestSupport.insertDbT3011(主キー12, 主キー21);
            TestSupport.insertDbT3011(主キー12, 主キー22);
        }

        // TODO 見つかる場合、居宅給付計画自己作成Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_居宅給付計画自己作成Entity返す() {
            KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件 = KyotakuKeikakuJikoSakuseiMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select居宅給付計画自己作成ByKey(居宅給付計画自己作成検索条件).get居宅給付計画自己作成Entity().getHihokenshaNo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件 = KyotakuKeikakuJikoSakuseiMapperParameter.createSelectByKeyParam(new HihokenshaNo("9999999999"), 主キー21);
            assertThat(sut.select居宅給付計画自己作成ByKey(居宅給付計画自己作成検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select居宅給付計画自己作成一覧By主キーTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKyotakuKeikakuJikoSakuseiMapper.class);
            TestSupport.insertDbT3007(主キー11, 主キー21);
            TestSupport.insertDbT3007(主キー11, 主キー22);
            TestSupport.insertDbT3007(主キー12, 主キー21);
            TestSupport.insertDbT3007(主キー12, 主キー22);

            TestSupport.insertDbT3008(主キー11, 主キー21);
            TestSupport.insertDbT3008(主キー11, 主キー22);
            TestSupport.insertDbT3008(主キー12, 主キー21);
            TestSupport.insertDbT3008(主キー12, 主キー22);

            TestSupport.insertDbT3011(主キー11, 主キー21);
            TestSupport.insertDbT3011(主キー11, 主キー22);
            TestSupport.insertDbT3011(主キー12, 主キー21);
            TestSupport.insertDbT3011(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件 = KyotakuKeikakuJikoSakuseiMapperParameter.createSelectListParam(主キー11);
            List<KyotakuKeikakuJikoSakuseiEntity> entityList = sut.select居宅給付計画自己作成リストBy主キー1(居宅給付計画自己作成検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get居宅給付計画自己作成Entity().getHihokenshaNo(), is(主キー11));
            assertThat(entityList.get(1).get居宅給付計画自己作成Entity().getHihokenshaNo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件 = KyotakuKeikakuJikoSakuseiMapperParameter.createSelectListParam(new HihokenshaNo("9999999999"));
            assertThat(sut.select居宅給付計画自己作成リストBy主キー1(居宅給付計画自己作成検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT3007(
                HihokenshaNo 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT3007KyotakuKeikakuJikoSakuseiEntity entity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setTaishoYM(主キー2);
            entity.setState(EntityDataState.Added);
            居宅給付計画自己作成Dac.save(entity);
        }

        public static void insertDbT3008(
                HihokenshaNo 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setTaishoYM(主キー2);
            entity.setState(EntityDataState.Added);
            居宅給付計画自己作成明細Dac.save(entity);
        }

        public static void insertDbT3011(
                HihokenshaNo 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setTaishoYM(主キー2);
            entity.setState(EntityDataState.Added);
            予防給付計画自己作成明細Dac.save(entity);
        }
    }

}
