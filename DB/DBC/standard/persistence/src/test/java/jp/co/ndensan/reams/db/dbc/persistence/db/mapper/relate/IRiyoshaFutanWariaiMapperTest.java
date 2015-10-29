/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.IRiyoshaFutanWariaiMapper;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.RiyoshaFutanWariaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3113RiyoshaFutanWariaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3113RiyoshaFutanWariaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link IRiyoshaFutanWariaiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IRiyoshaFutanWariaiMapperTest {

    private static IRiyoshaFutanWariaiMapper sut;
    private static DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac;
    private static DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final FlexibleYear 主キー11 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
    private static final FlexibleYear 主キー12 = new FlexibleYear("2015");
    private static final HihokenshaNo 主キー21 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 主キー22 = new HihokenshaNo("0123400001");
    private Decimal 主キー31;

    @BeforeClass
    public static void setUpClass() {
        利用者負担割合Dac = InstanceProvider.create(DbT3113RiyoshaFutanWariaiDac.class);
        利用者負担割合明細Dac = InstanceProvider.create(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select利用者負担割合ByKeyTest extends DbcTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IRiyoshaFutanWariaiMapper.class);
            TestSupport.insertDbT3113(主キー11, 主キー21);
            TestSupport.insertDbT3113(主キー11, 主キー22);
            TestSupport.insertDbT3113(主キー12, 主キー21);
            TestSupport.insertDbT3113(主キー12, 主キー22);

            TestSupport.insertDbT3114(主キー11, 主キー21);
            TestSupport.insertDbT3114(主キー11, 主キー22);
            TestSupport.insertDbT3114(主キー12, 主キー21);
            TestSupport.insertDbT3114(主キー12, 主キー22);
        }

        // TODO 見つかる場合、利用者負担割合Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_利用者負担割合Entity返す() {
            RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件 = RiyoshaFutanWariaiMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select利用者負担割合ByKey(利用者負担割合検索条件).get利用者負担割合Entity().getNendo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件 = RiyoshaFutanWariaiMapperParameter.createSelectByKeyParam(new FlexibleYear("2015"), 主キー21);
            assertThat(sut.select利用者負担割合ByKey(利用者負担割合検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select利用者負担割合一覧By主キーTest extends DbcTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IRiyoshaFutanWariaiMapper.class);
            TestSupport.insertDbT3113(主キー11, 主キー21);
            TestSupport.insertDbT3113(主キー11, 主キー22);
            TestSupport.insertDbT3113(主キー12, 主キー21);
            TestSupport.insertDbT3113(主キー12, 主キー22);

            TestSupport.insertDbT3114(主キー11, 主キー21);
            TestSupport.insertDbT3114(主キー11, 主キー22);
            TestSupport.insertDbT3114(主キー12, 主キー21);
            TestSupport.insertDbT3114(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件 = RiyoshaFutanWariaiMapperParameter.createSelectListParam(主キー11);
            List<RiyoshaFutanWariaiEntity> entityList = sut.select利用者負担割合リストBy主キー1(利用者負担割合検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get利用者負担割合Entity().getNendo(), is(主キー11));
            assertThat(entityList.get(1).get利用者負担割合Entity().getNendo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件 = RiyoshaFutanWariaiMapperParameter.createSelectListParam(new FlexibleYear("2015"));
            assertThat(sut.select利用者負担割合リストBy主キー1(利用者負担割合検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT3113(
                FlexibleYear 主キー1,
                HihokenshaNo 主キー2) {
            DbT3113RiyoshaFutanWariaiEntity entity = DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity();
            entity.setNendo(主キー1);
            entity.setHihokenshaNo(主キー2);
            entity.setState(EntityDataState.Added);
            利用者負担割合Dac.save(entity);
        }

        public static void insertDbT3114(
                FlexibleYear 主キー1,
                HihokenshaNo 主キー2) {
            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            entity.setNendo(主キー1);
            entity.setHihokenshaNo(主キー2);
            entity.setState(EntityDataState.Added);
            利用者負担割合明細Dac.save(entity);
        }
    }

}
