/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate.NijiYoboJigyoTaishoshaMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3100NijiYoboJigyoTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.relate.NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3100NijiYoboJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3101NijiYoboKihonCheckListDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link INijiYoboJigyoTaishoshaMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class INijiYoboJigyoTaishoshaMapperTest {

    private static INijiYoboJigyoTaishoshaMapper sut;
    private static DbT3100NijiYoboJigyoTaishoshaDac 二次予防事業対象者Dac;
    private static DbT3101NijiYoboKihonCheckListDac 二次予防基本チェックリストDac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final HokenshaNo 主キー11 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
    private static final HokenshaNo 主キー12 = new HokenshaNo("209007");
    private static final ShikibetsuCode 子テーブル主キー11 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
    private static final ShikibetsuCode 子テーブル主キー12 = new ShikibetsuCode("012340123400001");
    private static final HihokenshaNo 主キー21 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 主キー22 = new HihokenshaNo("0123400001");
    private Decimal 主キー31;

    @BeforeClass
    public static void setUpClass() {
        二次予防事業対象者Dac = InstanceProvider.create(DbT3100NijiYoboJigyoTaishoshaDac.class);
        二次予防基本チェックリストDac = InstanceProvider.create(DbT3101NijiYoboKihonCheckListDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select二次予防事業対象者ByKeyTest extends DbcTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(INijiYoboJigyoTaishoshaMapper.class);
            TestSupport.insertDbT3100(主キー11, 主キー21);
            TestSupport.insertDbT3100(主キー11, 主キー22);
            TestSupport.insertDbT3100(主キー12, 主キー21);
            TestSupport.insertDbT3100(主キー12, 主キー22);

            TestSupport.insertDbT3101(子テーブル主キー11, 主キー21);
            TestSupport.insertDbT3101(子テーブル主キー11, 主キー22);
            TestSupport.insertDbT3101(子テーブル主キー12, 主キー21);
            TestSupport.insertDbT3101(子テーブル主キー12, 主キー22);
        }

        // TODO 見つかる場合、二次予防事業対象者Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_二次予防事業対象者Entity返す() {
            NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件 = NijiYoboJigyoTaishoshaMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select二次予防事業対象者ByKey(二次予防事業対象者検索条件).get二次予防事業対象者Entity().getShoKisaiHokenshaNo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件 = NijiYoboJigyoTaishoshaMapperParameter.createSelectByKeyParam(new HokenshaNo("209007"), 主キー21);
            assertThat(sut.select二次予防事業対象者ByKey(二次予防事業対象者検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select二次予防事業対象者一覧By主キーTest extends DbcTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(INijiYoboJigyoTaishoshaMapper.class);
            TestSupport.insertDbT3100(主キー11, 主キー21);
            TestSupport.insertDbT3100(主キー11, 主キー22);
            TestSupport.insertDbT3100(主キー12, 主キー21);
            TestSupport.insertDbT3100(主キー12, 主キー22);

            TestSupport.insertDbT3101(子テーブル主キー11, 主キー21);
            TestSupport.insertDbT3101(子テーブル主キー11, 主キー22);
            TestSupport.insertDbT3101(子テーブル主キー12, 主キー21);
            TestSupport.insertDbT3101(子テーブル主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件 = NijiYoboJigyoTaishoshaMapperParameter.createSelectListParam(主キー11);
            List<NijiYoboJigyoTaishoshaEntity> entityList = sut.select二次予防事業対象者リストBy主キー1(二次予防事業対象者検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get二次予防事業対象者Entity().getShoKisaiHokenshaNo(), is(主キー11));
            assertThat(entityList.get(1).get二次予防事業対象者Entity().getShoKisaiHokenshaNo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件 = NijiYoboJigyoTaishoshaMapperParameter.createSelectListParam(new HokenshaNo("209007"));
            assertThat(sut.select二次予防事業対象者リストBy主キー1(二次予防事業対象者検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT3100(
                HokenshaNo 主キー1,
                HihokenshaNo 主キー2) {
            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            entity.setShoKisaiHokenshaNo(主キー1);
            entity.setHihokenshaNo(主キー2);
            entity.setState(EntityDataState.Added);
            二次予防事業対象者Dac.save(entity);
        }

        public static void insertDbT3101(
                ShikibetsuCode 主キー1,
                HihokenshaNo 主キー2) {
            DbT3101NijiYoboKihonCheckListEntity entity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            entity.setShikibetsuCode(主キー1);
            entity.setHihokenshaNo(主キー2);
            entity.setState(EntityDataState.Added);
            二次予防基本チェックリストDac.save(entity);
        }
    }

}
