/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.IChoshuYuyoMapper;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.ChoshuYuyoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2007KibetsuChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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
 * {@link IChoshuYuyoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IChoshuYuyoMapperTest {

    private static IChoshuYuyoMapper sut;
    private static DbT2006ChoshuYuyoDac 介護賦課徴収猶予Dac;
    private static DbT2007KibetsuChoshuYuyoDac 介護期別徴収猶予Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final FlexibleYear 主キー11 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
    private static final FlexibleYear 主キー12 = new FlexibleYear("1999");
    private static final FlexibleYear 主キー21 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 主キー22 = new FlexibleYear("2001");

    @BeforeClass
    public static void setUpClass() {
        介護賦課徴収猶予Dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
        介護期別徴収猶予Dac = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護賦課徴収猶予ByKeyTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IChoshuYuyoMapper.class);
            TestSupport.insertDbT2006(主キー11, 主キー21);
            TestSupport.insertDbT2006(主キー11, 主キー22);
            TestSupport.insertDbT2006(主キー12, 主キー21);
            TestSupport.insertDbT2006(主キー12, 主キー22);

            TestSupport.insertDbT2007(主キー11, 主キー21);
            TestSupport.insertDbT2007(主キー11, 主キー22);
            TestSupport.insertDbT2007(主キー12, 主キー21);
            TestSupport.insertDbT2007(主キー12, 主キー22);
        }

        // TODO 見つかる場合、介護賦課徴収猶予Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_介護賦課徴収猶予Entity返す() {
            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select介護賦課徴収猶予ByKey(介護賦課徴収猶予検索条件).get介護賦課徴収猶予Entity().getChoteiNendo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createSelectByKeyParam(new FlexibleYear("2099"), 主キー21);
            assertThat(sut.select介護賦課徴収猶予ByKey(介護賦課徴収猶予検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護賦課徴収猶予一覧By主キーTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IChoshuYuyoMapper.class);
            TestSupport.insertDbT2006(主キー11, 主キー21);
            TestSupport.insertDbT2006(主キー11, 主キー22);
            TestSupport.insertDbT2006(主キー12, 主キー21);
            TestSupport.insertDbT2006(主キー12, 主キー22);

            TestSupport.insertDbT2007(主キー11, 主キー21);
            TestSupport.insertDbT2007(主キー11, 主キー22);
            TestSupport.insertDbT2007(主キー12, 主キー21);
            TestSupport.insertDbT2007(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createSelectListParam(主キー11);
            List<ChoshuYuyoEntity> entityList = sut.select介護賦課徴収猶予リストBy主キー1(介護賦課徴収猶予検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get介護賦課徴収猶予Entity().getChoteiNendo(), is(主キー11));
            assertThat(entityList.get(1).get介護賦課徴収猶予Entity().getChoteiNendo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createSelectListParam(new FlexibleYear("2099"));
            assertThat(sut.select介護賦課徴収猶予リストBy主キー1(介護賦課徴収猶予検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT2006(
                FlexibleYear 主キー1,
                FlexibleYear 主キー2) {
            DbT2006ChoshuYuyoEntity entity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            entity.setChoteiNendo(主キー1);
            entity.setFukaNendo(主キー2);
            entity.setState(EntityDataState.Added);
            介護賦課徴収猶予Dac.save(entity);
        }

        public static void insertDbT2007(
                FlexibleYear 主キー1,
                FlexibleYear 主キー2) {
            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.setChoteiNendo(主キー1);
            entity.setFukaNendo(主キー2);
            entity.setState(EntityDataState.Added);
            介護期別徴収猶予Dac.save(entity);
        }
    }

}
