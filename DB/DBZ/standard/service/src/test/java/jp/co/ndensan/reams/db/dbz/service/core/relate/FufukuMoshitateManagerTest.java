/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.relate;

import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link FufukuMoshitateManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class FufukuMoshitateManagerTest {

//    // 不服審査申立情報
//    private static DbT7001FufukuMoshitateDac dac;
//    private static FufukuMoshitateManager sut;
//    private static BemmeiNaiyoManager 弁明内容Manager;
//
//    private static MapperProvider provider;
//    private static IFufukuMoshitateMapper mapper;
//
//    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
//    private ShikibetsuCode shikibetsuCode;
//    private HihokenshaNo genshobunsHihokennshaNo;
//    private FlexibleDate shinsaSeikyuTodokedeYMD;
//
//    @BeforeClass
//    public static void test() {
//        provider = mock(MapperProvider.class);
//        mapper = mock(IFufukuMoshitateMapper.class);
//// 不服審査申立情報
//        dac = mock(DbT7001FufukuMoshitateDac.class);
//        弁明内容Manager = mock(BemmeiNaiyoManager.class);
//        sut = new FufukuMoshitateManager(provider, dac,
//                弁明内容Manager);
//    }
//
//    public static class createInstanceのテスト {
//
//        @Test
//        public void createInstanceのテスト_戻り値はnullでない() {
//            FufukuMoshitateManager result = FufukuMoshitateManager.createInstance();
//            assertNotNull(result);
//        }
//
//        @Test
//        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
//            FufukuMoshitateManager result = FufukuMoshitateManager.createInstance();
//            assertThat(result, instanceOf(FufukuMoshitateManager.class));
//        }
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get不服審査申立情報 extends DbzTestBase {
//
//        @Test(expected = NullPointerException.class)
//        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.get不服審査申立情報(null);
//        }
//
//        @Test
//        public void 検索結果がnullの場合() {
//            when(mapper.select不服審査申立情報ByKey(any(FufukuMoshitateMapperParameter.class))).thenReturn(null);
//
//            when(provider.create(any(Class.class))).thenReturn(mapper);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//
//            FufukuMoshitateMapperParameter 不服審査申立情報検索条件 = FufukuMoshitateMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
//            FufukuMoshitate result = sut.get不服審査申立情報(不服審査申立情報検索条件);
//
//            assertThat(result, is(nullValue()));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            FufukuMoshitateEntity entity = new FufukuMoshitateEntity();
//            entity.set不服審査申立情報Entity(DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity());
//            when(mapper.select不服審査申立情報ByKey(any(FufukuMoshitateMapperParameter.class))).thenReturn(entity);
//
//            when(provider.create(any(Class.class))).thenReturn(mapper);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitateMapperParameter 不服審査申立情報検索条件 = FufukuMoshitateMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
//            FufukuMoshitate result = sut.get不服審査申立情報(不服審査申立情報検索条件);
//
//            assertThat(result.get証記載保険者番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号));
//        }
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get不服審査申立情報リストBy主キー1 extends DbzTestBase {
//
//        @Test(expected = NullPointerException.class)
//        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.get不服審査申立情報リストBy主キー1(null);
//        }
//
//        @Test
//        public void 検索結果が空の場合() {
//            when(mapper.select不服審査申立情報リストBy主キー1(any(FufukuMoshitateMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);
//
//            when(provider.create(any(Class.class))).thenReturn(mapper);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            FufukuMoshitateMapperParameter 不服審査申立情報検索条件 = FufukuMoshitateMapperParameter.createSelectListParam(主キー1);
//            List<FufukuMoshitate> result = sut.get不服審査申立情報リストBy主キー1(不服審査申立情報検索条件);
//
//            assertThat(result.isEmpty(), is(true));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            FufukuMoshitateEntity entity = new FufukuMoshitateEntity();
//            entity.set不服審査申立情報Entity(DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity());
//
//            List<FufukuMoshitateEntity> entityList = Arrays.asList(entity);
//            when(mapper.select不服審査申立情報リストBy主キー1(any(FufukuMoshitateMapperParameter.class))).thenReturn(entityList);
//
//            when(provider.create(any(Class.class))).thenReturn(mapper);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            FufukuMoshitateMapperParameter 不服審査申立情報検索条件 = FufukuMoshitateMapperParameter.createSelectListParam(主キー1);
//            List<FufukuMoshitate> result = sut.get不服審査申立情報リストBy主キー1(不服審査申立情報検索条件);
//
//            assertThat(result.size(), is(1));
//            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号.value()));
//        }
//    }
//
//    public static class save不服審査申立情報 extends DbzTestBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//// 不服審査申立情報
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//            when(弁明内容Manager.save(any(BemmeiNaiyo.class))).thenReturn(true);
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate 不服審査申立情報 = TestSupport.createFufukuMoshitate(主キー1, 主キー2);
//
//            assertThat(sut.save(不服審査申立情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 不服審査申立情報
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//            when(弁明内容Manager.save(any(BemmeiNaiyo.class))).thenReturn(true);
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate 不服審査申立情報 = TestSupport.createFufukuMoshitate(主キー1, 主キー2);
//
//            assertThat(sut.save(不服審査申立情報), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//// 不服審査申立情報
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//            when(弁明内容Manager.save(any(BemmeiNaiyo.class))).thenReturn(true);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate 不服審査申立情報 = TestSupport.createFufukuMoshitate(主キー1, 主キー2);
//            不服審査申立情報 = TestSupport.initializeFufukuMoshitate(不服審査申立情報);
//            不服審査申立情報 = TestSupport.modifiedFufukuMoshitate(不服審査申立情報);
//
//            assertThat(sut.save(不服審査申立情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 不服審査申立情報
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//            when(弁明内容Manager.save(any(BemmeiNaiyo.class))).thenReturn(true);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate 不服審査申立情報 = TestSupport.createFufukuMoshitate(主キー1, 主キー2);
//            不服審査申立情報 = TestSupport.initializeFufukuMoshitate(不服審査申立情報);
//            不服審査申立情報 = TestSupport.modifiedFufukuMoshitate(不服審査申立情報);
//
//            assertThat(sut.save(不服審査申立情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//// 不服審査申立情報
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//            when(弁明内容Manager.save(any(BemmeiNaiyo.class))).thenReturn(true);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate 不服審査申立情報 = TestSupport.createFufukuMoshitate(主キー1, 主キー2);
//            不服審査申立情報 = TestSupport.initializeFufukuMoshitate(不服審査申立情報);
//            不服審査申立情報 = 不服審査申立情報.deleted();
//
//            assertThat(sut.save(不服審査申立情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 不服審査申立情報
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//            when(弁明内容Manager.save(any(BemmeiNaiyo.class))).thenReturn(true);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate 不服審査申立情報 = TestSupport.createFufukuMoshitate(主キー1, 主キー2);
//            不服審査申立情報 = TestSupport.initializeFufukuMoshitate(不服審査申立情報);
//            不服審査申立情報 = 不服審査申立情報.deleted();
//
//            assertThat(sut.save(不服審査申立情報), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 不服審査申立情報
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//            when(弁明内容Manager.save(any(BemmeiNaiyo.class))).thenReturn(true);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate 不服審査申立情報 = TestSupport.createFufukuMoshitate(主キー1, 主キー2);
//            不服審査申立情報 = TestSupport.initializeFufukuMoshitate(不服審査申立情報);
//
//            assertThat(sut.save(不服審査申立情報), is(false));
//        }
//    }
//
//    private static class TestSupport {
//
//        public static FufukuMoshitate createFufukuMoshitate(ShoKisaiHokenshaNo 主キー1, ShikibetsuCode 主キー2) {
//            FufukuMoshitate 不服審査申立情報 = new FufukuMoshitate(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX);
//            return 不服審査申立情報.createBuilderForEdit()
//                    // 弁明内容
//                    .setBemmeiNaiyo(createBemmeiNaiyo(主キー1, 主キー2))
//                    .build();
//        }
//
//// 弁明内容
//        private static BemmeiNaiyo createBemmeiNaiyo(ShoKisaiHokenshaNo 主キー1, ShikibetsuCode 主キー2) {
//            return new BemmeiNaiyo(
//                    主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);
//        }
//
//        public static FufukuMoshitate initializeFufukuMoshitate(FufukuMoshitate 不服審査申立情報) {
//
//            DbT7001FufukuMoshitateEntity techoEntity = 不服審査申立情報.toEntity();
//
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            List<DbT7002BemmeiNaiyoEntity> BemmeiNaiyoEntityList = new ArrayList<>();
//            List<BemmeiNaiyo> 弁明内容リスト = 不服審査申立情報.getBemmeiNaiyoList();
//            for (BemmeiNaiyo 弁明内容 : 弁明内容リスト) {
//                BemmeiNaiyoEntityList.add(弁明内容.toEntity());
//            }
//
//            FufukuMoshitateEntity relateEntity = new FufukuMoshitateEntity();
//            relateEntity.set不服審査申立情報Entity(techoEntity);
//            relateEntity.set弁明内容Entity(BemmeiNaiyoEntityList);
//            relateEntity.initializeMd5ToEntities();
//
//// 不服審査申立情報
//            return new FufukuMoshitate(relateEntity.get不服審査申立情報Entity());
//        }
//
//        public static FufukuMoshitate modifiedFufukuMoshitate(FufukuMoshitate 不服審査申立情報) {
//
//// 弁明内容
//            BemmeiNaiyoBuilder BemmeiNaiyoBuilder = 不服審査申立情報.getBemmeiNaiyoList().get(0).createBuilderForEdit();
//            BemmeiNaiyo BemmeiNaiyo = BemmeiNaiyoBuilder.set弁明内容(new RString("任意項目1を変更")).build();
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            不服審査申立情報 = 不服審査申立情報.createBuilderForEdit()
//                    .set審査請求の理由(new RString("交付備考を変更")) // TODO 任意項目の値を変更してください。
//                    // 弁明内容
//                    .setBemmeiNaiyo(BemmeiNaiyo)
//                    .build();
//            return 不服審査申立情報.modified();
//        }
//    }
}
