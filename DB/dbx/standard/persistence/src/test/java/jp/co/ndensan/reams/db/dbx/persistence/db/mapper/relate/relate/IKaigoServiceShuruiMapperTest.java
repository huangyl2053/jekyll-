/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.relate;

/**
 * {@link IKaigoServiceShuruiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IKaigoServiceShuruiMapperTest {

    private static IKaigoServiceShuruiMapper sut;
    private static DbT7130KaigoServiceShuruiDac 介護サービス種類Dac;
    private static DbT7131KaigoServiceNaiyouDac 介護サービス内容Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final 主キー型1 主キー11 = XXXEntityGenerator.DEFAULT_主キー1;
    private static final 主キー型1 主キー12 = new 主キー型1();
    private static final 主キー型2 主キー21 = XXXEntityGenerator.DEFAULT_主キー2;
    private static final 主キー型2 主キー22 = new 主キー型2();

    @BeforeClass
    public static void setUpClass() {
        介護サービス種類Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        介護サービス内容Dac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護サービス種類ByKeyTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKaigoServiceShuruiMapper.class);
            TestSupport.insertDbT7130(主キー11, 主キー21);
            TestSupport.insertDbT7130(主キー11, 主キー22);
            TestSupport.insertDbT7130(主キー12, 主キー21);
            TestSupport.insertDbT7130(主キー12, 主キー22);

            TestSupport.insertDbT7131(主キー11, 主キー21);
            TestSupport.insertDbT7131(主キー11, 主キー22);
            TestSupport.insertDbT7131(主キー12, 主キー21);
            TestSupport.insertDbT7131(主キー12, 主キー22);
        }

        // TODO 見つかる場合、介護サービス種類Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_介護サービス種類Entity返す() {
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createXXXParam(主キー11, 主キー21);
            assertThat(sut.select介護サービス種類ByKey(介護サービス種類検索条件).getXXXEntity().get主キー型1(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createXXXParam(new 主キー型1(), 主キー21);
            assertThat(sut.select介護サービス種類ByKey(介護サービス種類検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護サービス種類一覧By主キーTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKaigoServiceShuruiMapper.class);
            TestSupport.insertDbT7130(主キー11, 主キー21);
            TestSupport.insertDbT7130(主キー11, 主キー22);
            TestSupport.insertDbT7130(主キー12, 主キー21);
            TestSupport.insertDbT7130(主キー12, 主キー22);

            TestSupport.insertDbT7131(主キー11, 主キー21);
            TestSupport.insertDbT7131(主キー11, 主キー22);
            TestSupport.insertDbT7131(主キー12, 主キー21);
            TestSupport.insertDbT7131(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createXXXParam(主キー11);
            List<KaigoServiceShuruiEntity> entityList = sut.select介護サービス種類一覧By主キー(介護サービス種類検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).getXXXEntity().get主キー型1(), is(主キー11));
            assertThat(entityList.get(1).getXXXEntity().get主キー型1(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
        KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createXXXParam(new 主キー型1());
            assertThat(sut.select介護サービス種類一覧By主キー(介護サービス種類検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT7130(
                主キー型1 主キー1,
                主キー型2 主キー2) {
            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.set主キー型1(主キー1);
            entity.set主キー型2(主キー2);
            entity.setState(EntityDataState.Added);
            介護サービス種類Dac.save(entity);
        }

        public static void insertDbT7131(
                主キー型1 主キー1,
                主キー型2 主キー2) {
            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.set主キー型1(主キー1);
            entity.set主キー型2(主キー2);
            entity.setState(EntityDataState.Added);
            介護サービス内容Dac.save(entity);
        }
    }

}
