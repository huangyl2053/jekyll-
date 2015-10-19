/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.IFukaMapper;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.FukaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link IFukaMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IFukaMapperTest {

    private static IFukaMapper sut;
    private static DbT2002FukaDac 介護賦課Dac;
    private static DbT2003KibetsuDac 介護期別Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final FlexibleYear 主キー11 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
    private static final FlexibleYear 主キー12 = new FlexibleYear("1999");
    private static final FlexibleYear 主キー21 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 主キー22 = new FlexibleYear("2001");

    @BeforeClass
    public static void setUpClass() {
        介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        介護期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護賦課ByKeyTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IFukaMapper.class);
            TestSupport.insertDbT2002(主キー11, 主キー21);
            TestSupport.insertDbT2002(主キー11, 主キー22);
            TestSupport.insertDbT2002(主キー12, 主キー21);
            TestSupport.insertDbT2002(主キー12, 主キー22);

            TestSupport.insertDbT2003(主キー11, 主キー21);
            TestSupport.insertDbT2003(主キー11, 主キー22);
            TestSupport.insertDbT2003(主キー12, 主キー21);
            TestSupport.insertDbT2003(主キー12, 主キー22);
        }

        // TODO 見つかる場合、介護賦課Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_介護賦課Entity返す() {
            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select介護賦課ByKey(介護賦課検索条件).get介護賦課Entity().getChoteiNendo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createSelectByKeyParam(new FlexibleYear("2099"), 主キー21);
            assertThat(sut.select介護賦課ByKey(介護賦課検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護賦課一覧By主キーTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IFukaMapper.class);
            TestSupport.insertDbT2002(主キー11, 主キー21);
            TestSupport.insertDbT2002(主キー11, 主キー22);
            TestSupport.insertDbT2002(主キー12, 主キー21);
            TestSupport.insertDbT2002(主キー12, 主キー22);

            TestSupport.insertDbT2003(主キー11, 主キー21);
            TestSupport.insertDbT2003(主キー11, 主キー22);
            TestSupport.insertDbT2003(主キー12, 主キー21);
            TestSupport.insertDbT2003(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createSelectListParam(主キー11);
            List<FukaEntity> entityList = sut.select介護賦課リストBy主キー1(介護賦課検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get介護賦課Entity().getChoteiNendo(), is(主キー11));
            assertThat(entityList.get(1).get介護賦課Entity().getChoteiNendo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createSelectListParam(new FlexibleYear("2099"));
            assertThat(sut.select介護賦課リストBy主キー1(介護賦課検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT2002(
                FlexibleYear 主キー1,
                FlexibleYear 主キー2) {
            DbT2002FukaEntity entity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            entity.setChoteiNendo(主キー1);
            entity.setFukaNendo(主キー2);
            entity.setState(EntityDataState.Added);
            介護賦課Dac.save(entity);
        }

        public static void insertDbT2003(
                FlexibleYear 主キー1,
                FlexibleYear 主キー2) {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.setChoteiNendo(主キー1);
            entity.setFukaNendo(主キー2);
            entity.setState(EntityDataState.Added);
            介護期別Dac.save(entity);
        }
    }

}
