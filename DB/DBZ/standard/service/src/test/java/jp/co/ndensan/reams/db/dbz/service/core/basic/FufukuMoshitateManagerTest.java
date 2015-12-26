/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link FufukuMoshitateManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class FufukuMoshitateManagerTest {

//    private static DbT7001FufukuMoshitateDac dac;
//    private static FufukuMoshitateManager sut;
//
//    @BeforeClass
//    public static void test() {
//        dac = mock(DbT7001FufukuMoshitateDac.class);
//        sut = new FufukuMoshitateManager(dac);
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get不服審査申立情報 extends DbzTestBase {
//
//        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
//        @Test(expected = NullPointerException.class)
//        public void 引数のShoKisaiHokenshaNoにnullを指定した場合_NullPointerExceptionが発生する() {
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            sut.get不服審査申立情報(null, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MIN);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数のShikibetsuCodeにnullを指定した場合_NullPointerExceptionが発生する() {
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            sut.get不服審査申立情報(主キー1, null, HihokenshaNo.EMPTY, FlexibleDate.MIN);
//        }
//
//        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
//        @Test
//        public void 検索結果がnullの場合() {
//            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(ShikibetsuCode.class), any(HihokenshaNo.class),
//                    any(FlexibleDate.class))).thenReturn(null);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate result = sut.get不服審査申立情報(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MIN);
//
//            assertThat(result, is(nullValue()));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(ShikibetsuCode.class), any(HihokenshaNo.class),
//                    any(FlexibleDate.class))).thenReturn(entity);
//
//            ShoKisaiHokenshaNo 主キー1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//            ShikibetsuCode 主キー2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//            FufukuMoshitate result = sut.get不服審査申立情報(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX);
//
//            assertThat(result.get証記載保険者番号().value(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号.value()));
//        }
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get不服審査申立情報一覧 extends DbzTestBase {
//
//        @Test
//        public void 検索結果が空の場合() {
//            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);
//
//            List<FufukuMoshitate> result = sut.get不服審査申立情報一覧();
//
//            assertThat(result.isEmpty(), is(true));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            List<DbT7001FufukuMoshitateEntity> entityList = Arrays.asList(DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity());
//            when(dac.selectAll()).thenReturn(entityList);
//
//            List<FufukuMoshitate> result = sut.get不服審査申立情報一覧();
//
//            assertThat(result.size(), is(1));
//            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号.value()));
//        }
//    }
//
//    public static class save不服審査申立情報 extends DbzTestBase {
//
//        @Test
//        public void insertに成功するとtrueが返る() {
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            FufukuMoshitate 不服審査申立情報 = new FufukuMoshitate(entity);
//
//            assertThat(sut.save不服審査申立情報(不服審査申立情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(0);
//
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            FufukuMoshitate 不服審査申立情報 = new FufukuMoshitate(entity);
//
//            assertThat(sut.save不服審査申立情報(不服審査申立情報), is(false));
//        }
//
//        @Test
//        public void updateに成功するとtrueが返る() {
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            entity.initializeMd5();
//            FufukuMoshitate 不服審査申立情報 = new FufukuMoshitate(entity);
//            不服審査申立情報 = 不服審査申立情報.createBuilderForEdit().set審査請求の理由(new RString("任意項目1を変更")).build();
//
//            assertThat(sut.save不服審査申立情報(不服審査申立情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(0);
//
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            entity.initializeMd5();
//            FufukuMoshitate 不服審査申立情報 = new FufukuMoshitate(entity);
//            不服審査申立情報 = 不服審査申立情報.createBuilderForEdit().set審査請求の理由(new RString("任意項目1を変更")).build();
//
//            assertThat(sut.save不服審査申立情報(不服審査申立情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功するとtrueが返る() {
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(1);
//
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            entity.initializeMd5();
//            FufukuMoshitate 不服審査申立情報 = new FufukuMoshitate(entity);
//            不服審査申立情報 = 不服審査申立情報.deleted();
//
//            assertThat(sut.save不服審査申立情報(不服審査申立情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7001FufukuMoshitateEntity.class))).thenReturn(0);
//
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            entity.initializeMd5();
//            FufukuMoshitate 不服審査申立情報 = new FufukuMoshitate(entity);
//            不服審査申立情報 = 不服審査申立情報.deleted();
//
//            assertThat(sut.save不服審査申立情報(不服審査申立情報), is(false));
//        }
//
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT7001FufukuMoshitateEntity entity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            entity.initializeMd5();
//            FufukuMoshitate 不服審査申立情報 = new FufukuMoshitate(entity);
//
//            assertThat(sut.save不服審査申立情報(不服審査申立情報), is(false));
//        }
//    }
}
