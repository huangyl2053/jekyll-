/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJogaiTokureiTaishoShisetsuModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoJogaiTokureiTaishoShisetsuModel sut;

        @BeforeClass
        public static void test() {
            sut = new KaigoJogaiTokureiTaishoShisetsuModel();
        }

        @Test
        public void 戻り値の事業者種別は_設定した値と同じ事業者種別を返す() {
            sut.set事業者種別(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別);
            assertThat(sut.get事業者種別(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の有効開始年月日は_設定した値と同じ有効開始年月日を返す() {
            sut.set有効開始年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日);
            assertThat(sut.get有効開始年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日));
        }

        @Test
        public void 戻り値の有効終了年月日は_設定した値と同じ有効終了年月日を返す() {
            sut.set有効終了年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効終了年月日);
            assertThat(sut.get有効終了年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効終了年月日));
        }

        @Test
        public void 戻り値の管内_管外区分は_設定した値と同じ管内_管外区分を返す() {
            sut.set管内_管外区分(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_管内_管外区分);
            assertThat(sut.get管内_管外区分(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_管内_管外区分));
        }

        @Test
        public void 戻り値の事業者名称は_設定した値と同じ事業者名称を返す() {
            sut.set事業者名称(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者名称);
            assertThat(sut.get事業者名称(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void 戻り値の事業者名称カナは_設定した値と同じ事業者名称カナを返す() {
            sut.set事業者名称カナ(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者名称カナ);
            assertThat(sut.get事業者名称カナ(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            sut.set郵便番号(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_郵便番号);
            assertThat(sut.get郵便番号(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の事業者住所は_設定した値と同じ事業者住所を返す() {
            sut.set事業者住所(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者住所);
            assertThat(sut.get事業者住所(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者住所));
        }

        @Test
        public void 戻り値の事業者住所カナは_設定した値と同じ事業者住所カナを返す() {
            sut.set事業者住所カナ(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者住所カナ);
            assertThat(sut.get事業者住所カナ(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者住所カナ));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            sut.set電話番号(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_電話番号);
            assertThat(sut.get電話番号(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値のFAX番号は_設定した値と同じFAX番号を返す() {
            sut.setFAX番号(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_FAX番号);
            assertThat(sut.getFAX番号(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void 戻り値の異動事由は_設定した値と同じ異動事由を返す() {
            sut.set異動事由(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_異動事由);
            assertThat(sut.get異動事由(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_異動事由));
        }

        @Test
        public void 戻り値の異動年月日は_設定した値と同じ異動年月日を返す() {
            sut.set異動年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_異動年月日);
            assertThat(sut.get異動年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_異動年月日));
        }

        @Test
        public void 戻り値の代表者名称は_設定した値と同じ代表者名称を返す() {
            sut.set代表者名称(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_代表者名称);
            assertThat(sut.get代表者名称(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_代表者名称));
        }

        @Test
        public void 戻り値の代表者名称カナは_設定した値と同じ代表者名称カナを返す() {
            sut.set代表者名称カナ(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_代表者名称カナ);
            assertThat(sut.get代表者名称カナ(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_代表者名称カナ));
        }

        @Test
        public void 戻り値の役職は_設定した値と同じ役職を返す() {
            sut.set役職(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_役職);
            assertThat(sut.get役職(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_役職));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            sut.set備考(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_備考);
            assertThat(sut.get備考(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の事業開始年月日は_設定した値と同じ事業開始年月日を返す() {
            sut.set事業開始年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業開始年月日);
            assertThat(sut.get事業開始年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業開始年月日));
        }

        @Test
        public void 戻り値の事業休止年月日は_設定した値と同じ事業休止年月日を返す() {
            sut.set事業休止年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業休止年月日);
            assertThat(sut.get事業休止年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業休止年月日));
        }

        @Test
        public void 戻り値の事業廃止年月日は_設定した値と同じ事業廃止年月日を返す() {
            sut.set事業廃止年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業廃止年月日);
            assertThat(sut.get事業廃止年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業廃止年月日));
        }

        @Test
        public void 戻り値の事業再開年月日は_設定した値と同じ事業再開年月日を返す() {
            sut.set事業再開年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業再開年月日);
            assertThat(sut.get事業再開年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業再開年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KaigoJogaiTokureiTaishoShisetsuModel sut = new KaigoJogaiTokureiTaishoShisetsuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KaigoJogaiTokureiTaishoShisetsuModel sut = new KaigoJogaiTokureiTaishoShisetsuModel();
            sut.setEntity(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KaigoJogaiTokureiTaishoShisetsuModel sut = new KaigoJogaiTokureiTaishoShisetsuModel();
            sut.setEntity(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KaigoJogaiTokureiTaishoShisetsuModel sut = new KaigoJogaiTokureiTaishoShisetsuModel();
            sut.setEntity(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
