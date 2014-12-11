/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuKyufuTaishoshaGokeiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuKyufuTaishoshaGokeiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuKyufuTaishoshaGokeiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuKyufuTaishoshaGokeiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値のサービス費用合計額合計は_設定した値と同じサービス費用合計額合計を返す() {
            sut.setサービス費用合計額合計(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス費用合計額合計);
            assertThat(sut.getサービス費用合計額合計(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス費用合計額合計));
        }

        @Test
        public void 戻り値の利用者負担額合計は_設定した値と同じ利用者負担額合計を返す() {
            sut.set利用者負担額合計(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_利用者負担額合計);
            assertThat(sut.get利用者負担額合計(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_利用者負担額合計));
        }

        @Test
        public void 戻り値の算定基準額は_設定した値と同じ算定基準額を返す() {
            sut.set算定基準額(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_算定基準額);
            assertThat(sut.get算定基準額(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_算定基準額));
        }

        @Test
        public void 戻り値の支払済金額合計は_設定した値と同じ支払済金額合計を返す() {
            sut.set支払済金額合計(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_支払済金額合計);
            assertThat(sut.get支払済金額合計(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_支払済金額合計));
        }

        @Test
        public void 戻り値の高額支給額は_設定した値と同じ高額支給額を返す() {
            sut.set高額支給額(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_高額支給額);
            assertThat(sut.get高額支給額(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_高額支給額));
        }

        @Test
        public void 戻り値の対象者受取年月は_設定した値と同じ対象者受取年月を返す() {
            sut.set対象者受取年月(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_対象者受取年月);
            assertThat(sut.get対象者受取年月(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_対象者受取年月));
        }

        @Test
        public void 戻り値の対象者判定審査年月は_設定した値と同じ対象者判定審査年月を返す() {
            sut.set対象者判定審査年月(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_対象者判定審査年月);
            assertThat(sut.get対象者判定審査年月(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_対象者判定審査年月));
        }

        @Test
        public void 戻り値の世帯集約番号は_設定した値と同じ世帯集約番号を返す() {
            sut.set世帯集約番号(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_世帯集約番号);
            assertThat(sut.get世帯集約番号(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_世帯集約番号));
        }

        @Test
        public void 戻り値の境界層対象者フラグは_設定した値と同じ境界層対象者フラグを返す() {
            sut.set境界層対象者フラグ(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_境界層対象者フラグ);
            assertThat(sut.get境界層対象者フラグ(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_境界層対象者フラグ));
        }

        @Test
        public void 戻り値の社会福祉法人軽減対象フラグは_設定した値と同じ社会福祉法人軽減対象フラグを返す() {
            sut.set社会福祉法人軽減対象フラグ(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_社会福祉法人軽減対象フラグ);
            assertThat(sut.get社会福祉法人軽減対象フラグ(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_社会福祉法人軽減対象フラグ));
        }

        @Test
        public void 戻り値の高額対象外フラグは_設定した値と同じ高額対象外フラグを返す() {
            sut.set高額対象外フラグ(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_高額対象外フラグ);
            assertThat(sut.get高額対象外フラグ(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_高額対象外フラグ));
        }

        @Test
        public void 戻り値の自動償還対象フラグは_設定した値と同じ自動償還対象フラグを返す() {
            sut.set自動償還対象フラグ(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_自動償還対象フラグ);
            assertThat(sut.get自動償還対象フラグ(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_自動償還対象フラグ));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuKyufuTaishoshaGokeiModel sut = new KogakuKyufuTaishoshaGokeiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuKyufuTaishoshaGokeiModel sut = new KogakuKyufuTaishoshaGokeiModel();
        //sut.setEntity(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuKyufuTaishoshaGokeiModel sut = new KogakuKyufuTaishoshaGokeiModel();
            sut.setEntity(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuKyufuTaishoshaGokeiModel sut = new KogakuKyufuTaishoshaGokeiModel();
            sut.setEntity(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
