/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.ITandokuJoseikinKyufuShinseiMapper;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.TandokuJoseikinKyufuShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3097TandokuJoseikinKyufuKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3098TandokuJoseikinKyufuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3097TandokuJoseikinKyufuKetteiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3098TandokuJoseikinKyufuShinseiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
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
 * {@link ITandokuJoseikinKyufuShinseiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ITandokuJoseikinKyufuShinseiMapperTest {

    private static ITandokuJoseikinKyufuShinseiMapper sut;
    private static DbT3098TandokuJoseikinKyufuShinseiDac 市町村単独助成金給付申請Dac;
    private static DbT3097TandokuJoseikinKyufuKetteiDac 市町村単独助成金給付決定Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final HihokenshaNo 主キー11 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 主キー12 = new HihokenshaNo("0123400001");
    private static final FlexibleDate 主キー21 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
    private static final FlexibleDate 主キー22 = new FlexibleDate("20150101");
    private Decimal 主キー31;

    @BeforeClass
    public static void setUpClass() {
        市町村単独助成金給付申請Dac = InstanceProvider.create(DbT3098TandokuJoseikinKyufuShinseiDac.class);
        市町村単独助成金給付決定Dac = InstanceProvider.create(DbT3097TandokuJoseikinKyufuKetteiDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select市町村単独助成金給付申請ByKeyTest extends DbcTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(ITandokuJoseikinKyufuShinseiMapper.class);
            TestSupport.insertDbT3098(主キー11, 主キー21);
            TestSupport.insertDbT3098(主キー11, 主キー22);
            TestSupport.insertDbT3098(主キー12, 主キー21);
            TestSupport.insertDbT3098(主キー12, 主キー22);

            TestSupport.insertDbT3097(主キー11, 主キー21);
            TestSupport.insertDbT3097(主キー11, 主キー22);
            TestSupport.insertDbT3097(主キー12, 主キー21);
            TestSupport.insertDbT3097(主キー12, 主キー22);
        }

        // TODO 見つかる場合、市町村単独助成金給付申請Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_市町村単独助成金給付申請Entity返す() {
            TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件 = TandokuJoseikinKyufuShinseiMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select市町村単独助成金給付申請ByKey(市町村単独助成金給付申請検索条件).get市町村単独助成金給付申請Entity().getHihokenshaNo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件 = TandokuJoseikinKyufuShinseiMapperParameter.createSelectByKeyParam(new HihokenshaNo("0123400001"), 主キー21);
            assertThat(sut.select市町村単独助成金給付申請ByKey(市町村単独助成金給付申請検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select市町村単独助成金給付申請一覧By主キーTest extends DbcTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(ITandokuJoseikinKyufuShinseiMapper.class);
            TestSupport.insertDbT3098(主キー11, 主キー21);
            TestSupport.insertDbT3098(主キー11, 主キー22);
            TestSupport.insertDbT3098(主キー12, 主キー21);
            TestSupport.insertDbT3098(主キー12, 主キー22);

            TestSupport.insertDbT3097(主キー11, 主キー21);
            TestSupport.insertDbT3097(主キー11, 主キー22);
            TestSupport.insertDbT3097(主キー12, 主キー21);
            TestSupport.insertDbT3097(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件 = TandokuJoseikinKyufuShinseiMapperParameter.createSelectListParam(主キー11);
            List<TandokuJoseikinKyufuShinseiEntity> entityList = sut.select市町村単独助成金給付申請リストBy主キー1(市町村単独助成金給付申請検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get市町村単独助成金給付申請Entity().getHihokenshaNo(), is(主キー11));
            assertThat(entityList.get(1).get市町村単独助成金給付申請Entity().getHihokenshaNo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件 = TandokuJoseikinKyufuShinseiMapperParameter.createSelectListParam(new HihokenshaNo("0123400001"));
            assertThat(sut.select市町村単独助成金給付申請リストBy主キー1(市町村単独助成金給付申請検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT3098(
                HihokenshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT3098TandokuJoseikinKyufuShinseiEntity entity = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setUketsukeYMD(主キー2);
            entity.setState(EntityDataState.Added);
            市町村単独助成金給付申請Dac.save(entity);
        }

        public static void insertDbT3097(
                HihokenshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT3097TandokuJoseikinKyufuKetteiEntity entity = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setUketsukeYMD(主キー2);
            entity.setState(EntityDataState.Added);
            市町村単独助成金給付決定Dac.save(entity);
        }
    }

}
