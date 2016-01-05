/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.IBemmeiNaiyoMapper;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.BemmeiNaiyoMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7002BemmeiNaiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7002BemmeiNaiyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7003BemmeishaJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link IBemmeiNaiyoMapper}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IBemmeiNaiyoMapperTest {

    private static IBemmeiNaiyoMapper sut;
    private static DbT7002BemmeiNaiyoDac 弁明内容Dac;
    private static DbT7003BemmeishaJohoDac 弁明者情報Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final ShoKisaiHokenshaNo 主キー11 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
    private static final ShoKisaiHokenshaNo 主キー12 = new ShoKisaiHokenshaNo("0123400001");
    private static final ShikibetsuCode 主キー21 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
    private static final ShikibetsuCode 主キー22 = new ShikibetsuCode("012340123400001");
    private static final HihokenshaNo 主キー31 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_原処分被保険者番号;
    private static final HihokenshaNo 主キー32 = new HihokenshaNo("0123400001");
    private static final FlexibleDate 主キー41 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求届出日;
    private static final FlexibleDate 主キー42 = new FlexibleDate("20150101");
    private static final FlexibleDate 主キー51 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日;
    private static final FlexibleDate 主キー52 = new FlexibleDate("20150101");

    @BeforeClass
    public static void setUpClass() {
        弁明内容Dac = InstanceProvider.create(DbT7002BemmeiNaiyoDac.class);
        弁明者情報Dac = InstanceProvider.create(DbT7003BemmeishaJohoDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select弁明内容ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IBemmeiNaiyoMapper.class);
            TestSupport.insertDbT7002(主キー11, 主キー21);
            TestSupport.insertDbT7002(主キー11, 主キー22);
            TestSupport.insertDbT7002(主キー12, 主キー21);
            TestSupport.insertDbT7002(主キー12, 主キー22);

            TestSupport.insertDbT7003(主キー11, 主キー21);
            TestSupport.insertDbT7003(主キー11, 主キー22);
            TestSupport.insertDbT7003(主キー12, 主キー21);
            TestSupport.insertDbT7003(主キー12, 主キー22);
        }

        // TODO 見つかる場合、弁明内容Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_弁明内容Entity返す() {
            BemmeiNaiyoMapperParameter 弁明内容検索条件 = BemmeiNaiyoMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select弁明内容ByKey(弁明内容検索条件).get弁明内容Entity().getShoKisaiHokenshaNo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            BemmeiNaiyoMapperParameter 弁明内容検索条件 = BemmeiNaiyoMapperParameter.createSelectByKeyParam(new ShoKisaiHokenshaNo("012345"), 主キー21);
            assertThat(sut.select弁明内容ByKey(弁明内容検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select弁明内容一覧By主キーTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IBemmeiNaiyoMapper.class);
            TestSupport.insertDbT7002(主キー11, 主キー21);
            TestSupport.insertDbT7002(主キー11, 主キー22);
            TestSupport.insertDbT7002(主キー12, 主キー21);
            TestSupport.insertDbT7002(主キー12, 主キー22);

            TestSupport.insertDbT7003(主キー11, 主キー21);
            TestSupport.insertDbT7003(主キー11, 主キー22);
            TestSupport.insertDbT7003(主キー12, 主キー21);
            TestSupport.insertDbT7003(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            BemmeiNaiyoMapperParameter 弁明内容検索条件 = BemmeiNaiyoMapperParameter.createSelectListParam(主キー11);
            List<BemmeiNaiyoEntity> entityList = sut.select弁明内容リストBy主キー1(弁明内容検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get弁明内容Entity().getShoKisaiHokenshaNo(), is(主キー11));
            assertThat(entityList.get(1).get弁明内容Entity().getShoKisaiHokenshaNo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            BemmeiNaiyoMapperParameter 弁明内容検索条件 = BemmeiNaiyoMapperParameter.createSelectListParam(new ShoKisaiHokenshaNo("999999"));
            assertThat(sut.select弁明内容リストBy主キー1(弁明内容検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT7002(
                ShoKisaiHokenshaNo 主キー1,
                ShikibetsuCode 主キー2) {
            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            entity.setShoKisaiHokenshaNo(主キー1);
            entity.setShikibetsuCode(主キー2);
            entity.setState(EntityDataState.Added);
            弁明内容Dac.save(entity);
        }

        public static void insertDbT7003(
                ShoKisaiHokenshaNo 主キー1,
                ShikibetsuCode 主キー2) {
            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            entity.setShoKisaiHokenshaNo(主キー1);
            entity.setShikibetsuCode(主キー2);
            entity.setState(EntityDataState.Added);
            弁明者情報Dac.save(entity);
        }
    }

}
