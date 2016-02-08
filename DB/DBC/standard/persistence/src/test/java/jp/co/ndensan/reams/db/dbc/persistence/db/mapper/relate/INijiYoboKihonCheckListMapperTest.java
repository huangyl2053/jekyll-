/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.NijiYoboKihonCheckListMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3102NijiYoboNiniCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3101NijiYoboKihonCheckListDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3102NijiYoboNiniCheckListDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3103NijiYoboCheckListHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link INijiYoboKihonCheckListMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class INijiYoboKihonCheckListMapperTest {

    private static INijiYoboKihonCheckListMapper sut;
    private static DbT3101NijiYoboKihonCheckListDac 二次予防基本チェックリストDac;
    private static DbT3102NijiYoboNiniCheckListDac 二次予防任意チェックリストDac;
    private static DbT3103NijiYoboCheckListHanteiKekkaDac 二次予防チェックリスト判定結果Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final HihokenshaNo 主キー11 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 主キー12 = new HihokenshaNo("0123400001");
    private static final FlexibleDate 主キー21 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日;
    private static final FlexibleDate 主キー22 = new FlexibleDate("20150102");

    @BeforeClass
    public static void setUpClass() {
        二次予防基本チェックリストDac = InstanceProvider.create(DbT3101NijiYoboKihonCheckListDac.class);
        二次予防任意チェックリストDac = InstanceProvider.create(DbT3102NijiYoboNiniCheckListDac.class);
        二次予防チェックリスト判定結果Dac = InstanceProvider.create(DbT3103NijiYoboCheckListHanteiKekkaDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select二次予防基本チェックリストByKeyTest extends DbcTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(INijiYoboKihonCheckListMapper.class);
            TestSupport.insertDbT3101(主キー11, 主キー21);
            TestSupport.insertDbT3101(主キー11, 主キー22);
            TestSupport.insertDbT3101(主キー12, 主キー21);
            TestSupport.insertDbT3101(主キー12, 主キー22);

            TestSupport.insertDbT3102(主キー11, 主キー21);
            TestSupport.insertDbT3102(主キー11, 主キー22);
            TestSupport.insertDbT3102(主キー12, 主キー21);
            TestSupport.insertDbT3102(主キー12, 主キー22);

            TestSupport.insertDbT3103(主キー11, 主キー21);
            TestSupport.insertDbT3103(主キー11, 主キー22);
            TestSupport.insertDbT3103(主キー12, 主キー21);
            TestSupport.insertDbT3103(主キー12, 主キー22);
        }

        // TODO 見つかる場合、二次予防基本チェックリストEntityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_二次予防基本チェックリストEntity返す() {
            NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件 = NijiYoboKihonCheckListMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select二次予防基本チェックリストByKey(二次予防基本チェックリスト検索条件).get二次予防基本チェックリストEntity().getHihokenshaNo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件 = NijiYoboKihonCheckListMapperParameter.createSelectByKeyParam(new HihokenshaNo("012340123400001"), 主キー21);
            assertThat(sut.select二次予防基本チェックリストByKey(二次予防基本チェックリスト検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select二次予防基本チェックリスト一覧By主キーTest extends DbcTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(INijiYoboKihonCheckListMapper.class);
            TestSupport.insertDbT3101(主キー11, 主キー21);
            TestSupport.insertDbT3101(主キー11, 主キー22);
            TestSupport.insertDbT3101(主キー12, 主キー21);
            TestSupport.insertDbT3101(主キー12, 主キー22);

            TestSupport.insertDbT3102(主キー11, 主キー21);
            TestSupport.insertDbT3102(主キー11, 主キー22);
            TestSupport.insertDbT3102(主キー12, 主キー21);
            TestSupport.insertDbT3102(主キー12, 主キー22);

            TestSupport.insertDbT3103(主キー11, 主キー21);
            TestSupport.insertDbT3103(主キー11, 主キー22);
            TestSupport.insertDbT3103(主キー12, 主キー21);
            TestSupport.insertDbT3103(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
//            NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件 = NijiYoboKihonCheckListMapperParameter.createSelectListParam(主キー11);
//            List<NijiYoboKihonCheckListEntity> entityList = sut.select二次予防基本チェックリストリストBy主キー1(二次予防基本チェックリスト検索条件);
//            assertThat(entityList.size(), is(2));
//             任意の項目が一致するテストケースを記述してください。
//            assertThat(entityList.get(0).get二次予防基本チェックリストEntity().getShikibetsuCode(), is(主キー11));
//            assertThat(entityList.get(1).get二次予防基本チェックリストEntity().getShikibetsuCode(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件 = NijiYoboKihonCheckListMapperParameter.createSelectListParam(new HihokenshaNo("0123400001"));
            assertThat(sut.select二次予防基本チェックリストリストBy主キー1(二次予防基本チェックリスト検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT3101(
                HihokenshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT3101NijiYoboKihonCheckListEntity entity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setUketsukeYMD(主キー2);
            entity.setState(EntityDataState.Added);
            二次予防基本チェックリストDac.save(entity);
        }

        public static void insertDbT3102(
                HihokenshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setUketsukeYMD(主キー2);
            entity.setState(EntityDataState.Added);
            二次予防任意チェックリストDac.save(entity);
        }

        public static void insertDbT3103(
                HihokenshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            entity.setHihokenshaNo(主キー1);
            entity.setUketsukeYMD(主キー2);
            entity.setState(EntityDataState.Added);
            二次予防チェックリスト判定結果Dac.save(entity);
        }
    }

}
