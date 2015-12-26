/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate;

import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IFufukuMoshitateMapper}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IFufukuMoshitateMapperTest {
//
//    private static IFufukuMoshitateMapper sut;
//    private static DbT7001FufukuMoshitateDac 不服審査申立情報Dac;
//    private static DbT7002BemmeiNaiyoDac 弁明内容Dac;
//    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
//    // TODO 主キーの数が足りない場合、追加してください。
//    private static final ShoKisaiHokenshaNo 主キー11 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//    private static final ShoKisaiHokenshaNo 主キー12 = new ShoKisaiHokenshaNo("012345");
//    private static final ShikibetsuCode 主キー21 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//    private static final ShikibetsuCode 主キー22 = new ShikibetsuCode("01234012400001");
//    private static final HihokenshaNo 主キー31 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者番号;
//    private static final HihokenshaNo 主キー32 = new HihokenshaNo("0123400001");
//    private static final FlexibleDate 主キー41 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分日;
//    private static final FlexibleDate 主キー42 = new FlexibleDate("20150101");
//
//    @BeforeClass
//    public static void setUpClass() {
//        不服審査申立情報Dac = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
//        弁明内容Dac = InstanceProvider.create(DbT7002BemmeiNaiyoDac.class);
//    }
//
//// TODO 検索条件に合わせてのテストケースを追記して下さい。
//    public static class select不服審査申立情報ByKeyTest extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            sut = sqlSession.getMapper(IFufukuMoshitateMapper.class);
//            TestSupport.insertDbT7001(主キー11, 主キー21);
//            TestSupport.insertDbT7001(主キー11, 主キー22);
//            TestSupport.insertDbT7001(主キー12, 主キー21);
//            TestSupport.insertDbT7001(主キー12, 主キー22);
//
//            TestSupport.insertDbT7002(主キー11, 主キー21);
//            TestSupport.insertDbT7002(主キー11, 主キー22);
//            TestSupport.insertDbT7002(主キー12, 主キー21);
//            TestSupport.insertDbT7002(主キー12, 主キー22);
//        }
//
//        // TODO 見つかる場合、不服審査申立情報Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
//        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
//        @Test
//        public void データが見つかる検索条件を渡すと_不服審査申立情報Entity返す() {
//            FufukuMoshitateMapperParameter 不服審査申立情報検索条件 = FufukuMoshitateMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
//            assertThat(sut.select不服審査申立情報ByKey(不服審査申立情報検索条件).get不服審査申立情報Entity().getShoKisaiHokenshaNo(), is(主キー11));
//        }
//
//        // データが見つからない値を指定するように修正してください。
//        @Test
//        public void データが見つかない検索条件を渡すと_nullを返す() {
//            FufukuMoshitateMapperParameter 不服審査申立情報検索条件 = FufukuMoshitateMapperParameter.createSelectByKeyParam(new ShoKisaiHokenshaNo("012345"), 主キー21);
//            assertThat(sut.select不服審査申立情報ByKey(不服審査申立情報検索条件), is(nullValue()));
//        }
//    }
//
//// TODO 検索条件に合わせてのテストケースを追記して下さい。
//    public static class select不服審査申立情報一覧By主キーTest extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            sut = sqlSession.getMapper(IFufukuMoshitateMapper.class);
//            TestSupport.insertDbT7001(主キー11, 主キー21);
//            TestSupport.insertDbT7001(主キー11, 主キー22);
//            TestSupport.insertDbT7001(主キー12, 主キー21);
//            TestSupport.insertDbT7001(主キー12, 主キー22);
//
//            TestSupport.insertDbT7002(主キー11, 主キー21);
//            TestSupport.insertDbT7002(主キー11, 主キー22);
//            TestSupport.insertDbT7002(主キー12, 主キー21);
//            TestSupport.insertDbT7002(主キー12, 主キー22);
//        }
//
//        @Test
//        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
//            FufukuMoshitateMapperParameter 不服審査申立情報検索条件 = FufukuMoshitateMapperParameter.createSelectListParam(主キー11);
//            List<FufukuMoshitateEntity> entityList = sut.select不服審査申立情報リストBy主キー1(不服審査申立情報検索条件);
//            assertThat(entityList.size(), is(2));
//            // 任意の項目が一致するテストケースを記述してください。
//            assertThat(entityList.get(0).get不服審査申立情報Entity().getShoKisaiHokenshaNo(), is(主キー11));
//            assertThat(entityList.get(1).get不服審査申立情報Entity().getShoKisaiHokenshaNo(), is(主キー11));
//        }
//
//        @Test
//        public void データが見つかない検索条件を渡すと__空のリストを返す() {
//            FufukuMoshitateMapperParameter 不服審査申立情報検索条件 = FufukuMoshitateMapperParameter.createSelectListParam(new ShoKisaiHokenshaNo("012345"));
//            assertThat(sut.select不服審査申立情報リストBy主キー1(不服審査申立情報検索条件).isEmpty(), is(true));
//        }
//    }
//
//    // TODO 主キー型と変数名を適切な値に置換してください
//    // TODO 主キーの数が足りない場合、追加してください。
//    private static class TestSupport {
//
//        public static void insertDbT7001(
//                ShoKisaiHokenshaNo 主キー1,
//                ShikibetsuCode 主キー2) {
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            entity.setShoKisaiHokenshaNo(主キー1);
//            entity.setShikibetsuCode(主キー2);
//            entity.setState(EntityDataState.Added);
//            不服審査申立情報Dac.save(entity);
//        }
//
//        public static void insertDbT7002(
//                ShoKisaiHokenshaNo 主キー1,
//                ShikibetsuCode 主キー2) {
//            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
//            entity.setShoKisaiHokenshaNo(主キー1);
//            entity.setShikibetsuCode(主キー2);
//            entity.setState(EntityDataState.Added);
//            弁明内容Dac.save(entity);
//        }
//    }

}
