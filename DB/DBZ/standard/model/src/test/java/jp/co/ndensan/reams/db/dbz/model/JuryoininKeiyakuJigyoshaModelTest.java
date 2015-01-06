/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JuryoininKeiyakuJigyoshaModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class JuryoininKeiyakuJigyoshaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static JuryoininKeiyakuJigyoshaModel sut;

        @BeforeClass
        public static void test() {
            sut = new JuryoininKeiyakuJigyoshaModel();
        }

        @Test
        public void 戻り値の事業者契約番号は_設定した値と同じ事業者契約番号を返す() {
            sut.set事業者契約番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号);
            assertThat(sut.get事業者契約番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            sut.set開始年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日);
            assertThat(sut.get開始年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の終了年月日は_設定した値と同じ終了年月日を返す() {
            sut.set終了年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_終了年月日);
            assertThat(sut.get終了年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_終了年月日));
        }

        @Test
        public void 戻り値の届出年月日は_設定した値と同じ届出年月日を返す() {
            sut.set届出年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出年月日);
            assertThat(sut.get届出年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出年月日));
        }

        @Test
        public void 戻り値の届出者住所は_設定した値と同じ届出者住所を返す() {
            sut.set届出者住所(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者住所);
            assertThat(sut.get届出者住所(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者住所));
        }

        @Test
        public void 戻り値の届出者事業者名称は_設定した値と同じ届出者事業者名称を返す() {
            sut.set届出者事業者名称(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者事業者名称);
            assertThat(sut.get届出者事業者名称(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者事業者名称));
        }

        @Test
        public void 戻り値の届出者代表者氏名は_設定した値と同じ届出者代表者氏名を返す() {
            sut.set届出者代表者氏名(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者代表者氏名);
            assertThat(sut.get届出者代表者氏名(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者代表者氏名));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の事業者FAX番号は_設定した値と同じ事業者FAX番号を返す() {
            sut.set事業者FAX番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者FAX番号);
            assertThat(sut.get事業者FAX番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者FAX番号));
        }

        @Test
        public void 戻り値の契約登録年月日は_設定した値と同じ契約登録年月日を返す() {
            sut.set契約登録年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約登録年月日);
            assertThat(sut.get契約登録年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約登録年月日));
        }

        @Test
        public void 戻り値の送付先部署は_設定した値と同じ送付先部署を返す() {
            sut.set送付先部署(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_送付先部署);
            assertThat(sut.get送付先部署(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_送付先部署));
        }

        @Test
        public void 戻り値の営業形態は_設定した値と同じ営業形態を返す() {
            sut.set営業形態(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_営業形態);
            assertThat(sut.get営業形態(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_営業形態));
        }

        @Test
        public void 戻り値の住宅改修契約有無は_設定した値と同じ住宅改修契約有無を返す() {
            sut.set住宅改修契約有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_住宅改修契約有無);
            assertThat(sut.get住宅改修契約有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_住宅改修契約有無));
        }

        @Test
        public void 戻り値の特定福祉用具販売契約有無は_設定した値と同じ特定福祉用具販売契約有無を返す() {
            sut.set特定福祉用具販売契約有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_特定福祉用具販売契約有無);
            assertThat(sut.get特定福祉用具販売契約有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_特定福祉用具販売契約有無));
        }

        @Test
        public void 戻り値の償還払給付契約有無は_設定した値と同じ償還払給付契約有無を返す() {
            sut.set償還払給付契約有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_償還払給付契約有無);
            assertThat(sut.get償還払給付契約有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_償還払給付契約有無));
        }

        @Test
        public void 戻り値の高額給付契約有無は_設定した値と同じ高額給付契約有無を返す() {
            sut.set高額給付契約有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_高額給付契約有無);
            assertThat(sut.get高額給付契約有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_高額給付契約有無));
        }

        @Test
        public void 戻り値の契約事業者番号は_設定した値と同じ契約事業者番号を返す() {
            sut.set契約事業者番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号);
            assertThat(sut.get契約事業者番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号));
        }

        @Test
        public void 戻り値の取扱確約書有無は_設定した値と同じ取扱確約書有無を返す() {
            sut.set取扱確約書有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_取扱確約書有無);
            assertThat(sut.get取扱確約書有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_取扱確約書有無));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            JuryoininKeiyakuJigyoshaModel sut = new JuryoininKeiyakuJigyoshaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // JuryoininKeiyakuJigyoshaModel sut = new JuryoininKeiyakuJigyoshaModel();
        //sut.setEntity(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            JuryoininKeiyakuJigyoshaModel sut = new JuryoininKeiyakuJigyoshaModel();
            sut.setEntity(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            JuryoininKeiyakuJigyoshaModel sut = new JuryoininKeiyakuJigyoshaModel();
            sut.setEntity(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
