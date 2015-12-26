/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.IKyotakuKeikakuTodokedeMapper;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IKyotakuKeikakuTodokedeMapper}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IKyotakuKeikakuTodokedeMapperTest {

    private static IKyotakuKeikakuTodokedeMapper sut;
    private static DbT3005KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac;
    private static DbT3006KyotakuKeikakuJigyoshaSakuseiDac 居宅給付計画事業者作成Dac;
    private static DbT3007KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final HihokenshaNo 主キー11 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 主キー12 = new HihokenshaNo("0123400001");
    private static final FlexibleYearMonth 主キー21 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
    private static final FlexibleYearMonth 主キー22 = new FlexibleYearMonth("201501");

    private Decimal rirekiNo;

    @BeforeClass
    public static void setUpClass() {
        居宅給付計画届出Dac = InstanceProvider.create(DbT3005KyotakuKeikakuTodokedeDac.class);
        居宅給付計画事業者作成Dac = InstanceProvider.create(DbT3006KyotakuKeikakuJigyoshaSakuseiDac.class);
        居宅給付計画自己作成Dac = InstanceProvider.create(DbT3007KyotakuKeikakuJikoSakuseiDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select居宅給付計画届出ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKyotakuKeikakuTodokedeMapper.class);
            TestSupport.insertDbT3005(主キー11, 主キー21);
            TestSupport.insertDbT3005(主キー11, 主キー22);
            TestSupport.insertDbT3005(主キー12, 主キー21);
            TestSupport.insertDbT3005(主キー12, 主キー22);

            TestSupport.insertDbT3006(主キー11, 主キー21);
            TestSupport.insertDbT3006(主キー11, 主キー22);
            TestSupport.insertDbT3006(主キー12, 主キー21);
            TestSupport.insertDbT3006(主キー12, 主キー22);

            TestSupport.insertDbT3007(主キー11, 主キー21);
            TestSupport.insertDbT3007(主キー11, 主キー22);
            TestSupport.insertDbT3007(主キー12, 主キー21);
            TestSupport.insertDbT3007(主キー12, 主キー22);
        }

        // TODO 見つかる場合、居宅給付計画届出Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_居宅給付計画届出Entity返す() {
            KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件 = KyotakuKeikakuTodokedeMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select居宅給付計画届出ByKey(居宅給付計画届出検索条件).get居宅給付計画届出Entity().getHihokenshaNo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件 = KyotakuKeikakuTodokedeMapperParameter.createSelectByKeyParam(new HihokenshaNo("9999999999"), 主キー21);
            assertThat(sut.select居宅給付計画届出ByKey(居宅給付計画届出検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select居宅給付計画届出一覧By主キーTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKyotakuKeikakuTodokedeMapper.class);
            TestSupport.insertDbT3005(主キー11, 主キー21);
            TestSupport.insertDbT3005(主キー11, 主キー22);
            TestSupport.insertDbT3005(主キー12, 主キー21);
            TestSupport.insertDbT3005(主キー12, 主キー22);

            TestSupport.insertDbT3006(主キー11, 主キー21);
            TestSupport.insertDbT3006(主キー11, 主キー22);
            TestSupport.insertDbT3006(主キー12, 主キー21);
            TestSupport.insertDbT3006(主キー12, 主キー22);

            TestSupport.insertDbT3007(主キー11, 主キー21);
            TestSupport.insertDbT3007(主キー11, 主キー22);
            TestSupport.insertDbT3007(主キー12, 主キー21);
            TestSupport.insertDbT3007(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件 = KyotakuKeikakuTodokedeMapperParameter.createSelectListParam(主キー11);
            List<KyotakuKeikakuTodokedeEntity> entityList = sut.select居宅給付計画届出リストBy主キー1(居宅給付計画届出検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get居宅給付計画届出Entity().getHihokenshaNo(), is(主キー11));
            assertThat(entityList.get(1).get居宅給付計画届出Entity().getHihokenshaNo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件 = KyotakuKeikakuTodokedeMapperParameter.createSelectListParam(new HihokenshaNo("9999999999"));
            assertThat(sut.select居宅給付計画届出リストBy主キー1(居宅給付計画届出検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT3005(
                HihokenshaNo 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setTaishoYM(主キー2);
            entity.setState(EntityDataState.Added);
            居宅給付計画届出Dac.save(entity);
        }

        public static void insertDbT3006(
                HihokenshaNo 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            entity.setHihokenshano(主キー1);
            entity.setTaishoYM(主キー2);
            entity.setState(EntityDataState.Added);
            居宅給付計画事業者作成Dac.save(entity);
        }

        public static void insertDbT3007(
                HihokenshaNo 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT3007KyotakuKeikakuJikoSakuseiEntity entity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setTaishoYM(主キー2);
            entity.setState(EntityDataState.Added);
            居宅給付計画自己作成Dac.save(entity);
        }
    }

}
