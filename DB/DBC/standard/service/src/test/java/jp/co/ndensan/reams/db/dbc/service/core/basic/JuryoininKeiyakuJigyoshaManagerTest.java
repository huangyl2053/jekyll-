/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link JuryoininKeiyakuJigyoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class JuryoininKeiyakuJigyoshaManagerTest {
//
//    private static DbT3077JuryoininKeiyakuJigyoshaDac dac;
//    private static JuryoininKeiyakuJigyoshaManager sut;
//    private static MapperProvider mapperProvider;
//
//    @BeforeClass
//    public static void test() {
//        dac = mock(DbT3077JuryoininKeiyakuJigyoshaDac.class);
//        mapperProvider = mock(MapperProvider.class);
//        sut = new JuryoininKeiyakuJigyoshaManager(mapperProvider, dac);
//    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get受領委任契約事業者 extends DbcTestBase {
//
//        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.get受領委任契約事業者(null);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
//            RString 主キー1 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号;
//            sut.get受領委任契約事業者(主キー1);
//        }
    // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
//        @Test
//        public void 検索結果がnullの場合() {
//            when(dac.selectByKey(any(RString.class))).thenReturn(null);
//
//            RString 主キー1 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号;
//            JuryoininKeiyakuJigyosha result = sut.get受領委任契約事業者(主キー1);
//
//            assertThat(result, is(nullValue()));
//        }
//        @Test
//        public void 検索結果が存在する場合() {
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
//            when(dac.selectByKey(any(RString.class))).thenReturn(entity);
//
//            RString 主キー1 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号;
//            JuryoininKeiyakuJigyosha result = sut.get受領委任契約事業者(主キー1);
//
//            assertThat(result.get契約事業者番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号));
//        }
//}
// TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get受領委任契約事業者一覧 extends DbcTestBase {
//
//        @Test
//        public void 検索結果が空の場合() {
//            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);
//
//            List<JuryoininKeiyakuJigyosha> result = sut.get受領委任契約事業者一覧();
//
//            assertThat(result.isEmpty(), is(true));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            List<DbT3077JuryoininKeiyakuJigyoshaEntity> entityList = Arrays.asList(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity());
//            when(dac.selectAll()).thenReturn(entityList);
//
//            List<JuryoininKeiyakuJigyosha> result = sut.get受領委任契約事業者一覧();
//
//            assertThat(result.size(), is(1));
//            assertThat(result.get(0).get契約事業者番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号));
//        }
//    }
//
//    public static class save受領委任契約事業者 extends DbcTestBase {
//
//        @Test
//        public void insertに成功するとtrueが返る() {
//            when(dac.save(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);
//
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
//            JuryoininKeiyakuJigyosha 受領委任契約事業者 = new JuryoininKeiyakuJigyosha(entity);
//
//            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(true));
//        }
//
//        @Test
//        public void insertに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);
//
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
//            JuryoininKeiyakuJigyosha 受領委任契約事業者 = new JuryoininKeiyakuJigyosha(entity);
//
//            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(false));
//        }
//
//        @Test
//        public void updateに成功するとtrueが返る() {
//            when(dac.save(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);
//
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
//            entity.initializeMd5();
//            JuryoininKeiyakuJigyosha 受領委任契約事業者 = new JuryoininKeiyakuJigyosha(entity);
//            受領委任契約事業者 = 受領委任契約事業者.createBuilderForEdit().set口座種別(new RString("任意項目1を変更")).build();
//
//            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(true));
//        }
//
//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);
//
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
//            entity.initializeMd5();
//            JuryoininKeiyakuJigyosha 受領委任契約事業者 = new JuryoininKeiyakuJigyosha(entity);
//            受領委任契約事業者 = 受領委任契約事業者.createBuilderForEdit().set口座種別(new RString("任意項目1を変更")).build();
//
//            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(false));
//        }
//
//        @Test
//        public void deleteに成功するとtrueが返る() {
//            when(dac.save(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);
//
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
//            entity.initializeMd5();
//            JuryoininKeiyakuJigyosha 受領委任契約事業者 = new JuryoininKeiyakuJigyosha(entity);
//            受領委任契約事業者 = 受領委任契約事業者.deleted();
//
//            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(true));
//        }
//
//        @Test
//        public void deleteに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);
//
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
//            entity.initializeMd5();
//            JuryoininKeiyakuJigyosha 受領委任契約事業者 = new JuryoininKeiyakuJigyosha(entity);
//            受領委任契約事業者 = 受領委任契約事業者.deleted();
//
//            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(false));
//        }
//
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
//            entity.initializeMd5();
//            JuryoininKeiyakuJigyosha 受領委任契約事業者 = new JuryoininKeiyakuJigyosha(entity);
//
//            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(false));
//        }
}
