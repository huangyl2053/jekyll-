/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.UrT0705ChoteiKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * {@link ChoteiKyotsuModel}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChoteiKyotsuModelTest extends DbbTestBase {

    public static class getterSetterTest extends DbbTestBase {

        private static ChoteiKyotsuModel sut;

        @BeforeClass
        public static void test() {
            sut = new ChoteiKyotsuModel();
        }

        @Test
        public void 戻り値の調定IDは_設定した値と同じ調定IDを返す() {
            sut.set調定ID(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定ID);
            assertThat(sut.get調定ID(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定ID));
        }

        @Test
        public void 戻り値の収納IDは_設定した値と同じ収納IDを返す() {
            sut.set収納ID(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_収納ID);
            assertThat(sut.get収納ID(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_収納ID));
        }

        @Test
        public void 戻り値の会計年度は_設定した値と同じ会計年度を返す() {
            sut.set会計年度(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_会計年度);
            assertThat(sut.get会計年度(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_会計年度));
        }

        @Test
        public void 戻り値の処理年度は_設定した値と同じ処理年度を返す() {
            sut.set処理年度(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_処理年度);
            assertThat(sut.get処理年度(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_処理年度));
        }

        @Test
        public void 戻り値の処理番号は_設定した値と同じ処理番号を返す() {
            sut.set処理番号(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_処理番号);
            assertThat(sut.get処理番号(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_処理番号));
        }

        @Test
        public void 戻り値の更正回数は_設定した値と同じ更正回数を返す() {
            sut.set更正回数(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_更正回数);
            assertThat(sut.get更正回数(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_更正回数));
        }

        @Test
        public void 戻り値の調定事由コードは_設定した値と同じ調定事由コードを返す() {
            sut.set調定事由コード(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定事由コード);
            assertThat(sut.get調定事由コード(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定事由コード));
        }

        @Test
        public void 戻り値の調定日は_設定した値と同じ調定日を返す() {
            sut.set調定日(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定日);
            assertThat(sut.get調定日(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定日));
        }

        @Test
        public void 戻り値の調定額は_設定した値と同じ調定額を返す() {
            sut.set調定額(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定額);
            assertThat(sut.get調定額(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定額));
        }

        @Test
        public void 戻り値の消費税額は_設定した値と同じ消費税額を返す() {
            sut.set消費税額(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_消費税額);
            assertThat(sut.get消費税額(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_消費税額));
        }

        @Test
        public void 戻り値の納期限は_設定した値と同じ納期限を返す() {
            sut.set納期限(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_納期限);
            assertThat(sut.get納期限(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_納期限));
        }

        @Test
        public void 戻り値の法定納期限等は_設定した値と同じ法定納期限等を返す() {
            sut.set法定納期限等(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_法定納期限等);
            assertThat(sut.get法定納期限等(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_法定納期限等));
        }

        @Test
        public void 戻り値の賦課処理状況は_設定した値と同じ賦課処理状況を返す() {
            sut.set賦課処理状況(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_賦課処理状況);
            assertThat(sut.is賦課側確定(), is(UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_賦課処理状況));
        }
    }

    public static class getStateTest extends DbbTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ChoteiKyotsuModel sut = new ChoteiKyotsuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ChoteiKyotsuModel sut = new ChoteiKyotsuModel();
            sut.setEntity(UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity());

            sut.getEntity().initializeMd5();
            sut.getEntity().setChoteigaku(new Decimal(9999));

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ChoteiKyotsuModel sut = new ChoteiKyotsuModel();
            sut.setEntity(UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ChoteiKyotsuModel sut = new ChoteiKyotsuModel();
            sut.setEntity(UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
