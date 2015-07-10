/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3084DaisanshaKoiTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiTodokedeModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiTodokedeModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static DaisanshaKoiTodokedeModel sut;

        @BeforeClass
        public static void test() {
            sut = new DaisanshaKoiTodokedeModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            sut.set第三者行為届出管理番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_第三者行為届出管理番号);
            assertThat(sut.get第三者行為届出管理番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の届出年月日は_設定した値と同じ届出年月日を返す() {
            sut.set届出年月日(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出年月日);
            assertThat(sut.get届出年月日(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出年月日));
        }

        @Test
        public void 戻り値の届出人郵便番号は_設定した値と同じ届出人郵便番号を返す() {
            sut.set届出人郵便番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人郵便番号);
            assertThat(sut.get届出人郵便番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人郵便番号));
        }

        @Test
        public void 戻り値の届出人住所は_設定した値と同じ届出人住所を返す() {
            sut.set届出人住所(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人住所);
            assertThat(sut.get届出人住所(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人住所));
        }

        @Test
        public void 戻り値の届出人氏名カナは_設定した値と同じ届出人氏名カナを返す() {
            sut.set届出人氏名カナ(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人氏名カナ);
            assertThat(sut.get届出人氏名カナ(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人氏名カナ));
        }

        @Test
        public void 戻り値の届出人氏名は_設定した値と同じ届出人氏名を返す() {
            sut.set届出人氏名(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人氏名);
            assertThat(sut.get届出人氏名(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人氏名));
        }

        @Test
        public void 戻り値の届出人電話番号は_設定した値と同じ届出人電話番号を返す() {
            sut.set届出人電話番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人電話番号);
            assertThat(sut.get届出人電話番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人電話番号));
        }

        @Test
        public void 戻り値の届出人との続柄は_設定した値と同じ届出人との続柄を返す() {
            sut.set届出人との続柄(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人との続柄);
            assertThat(sut.get届出人との続柄(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_届出人との続柄));
        }

        @Test
        public void 戻り値の要介護状態区分は_設定した値と同じ要介護状態区分を返す() {
            sut.set要介護状態区分(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_要介護状態区分);
            assertThat(sut.get要介護状態区分(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_要介護状態区分));
        }

        @Test
        public void 戻り値の認定有効期間開始年月日は_設定した値と同じ認定有効期間開始年月日を返す() {
            sut.set認定有効期間開始年月日(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_認定有効期間開始年月日);
            assertThat(sut.get認定有効期間開始年月日(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_認定有効期間開始年月日));
        }

        @Test
        public void 戻り値の認定有効期間終了年月日は_設定した値と同じ認定有効期間終了年月日を返す() {
            sut.set認定有効期間終了年月日(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_認定有効期間終了年月日);
            assertThat(sut.get認定有効期間終了年月日(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_認定有効期間終了年月日));
        }

        @Test
        public void 戻り値の加害者郵便番号は_設定した値と同じ加害者郵便番号を返す() {
            sut.set加害者郵便番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者郵便番号);
            assertThat(sut.get加害者郵便番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者郵便番号));
        }

        @Test
        public void 戻り値の加害者住所は_設定した値と同じ加害者住所を返す() {
            sut.set加害者住所(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者住所);
            assertThat(sut.get加害者住所(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者住所));
        }

        @Test
        public void 戻り値の加害者氏名カナは_設定した値と同じ加害者氏名カナを返す() {
            sut.set加害者氏名カナ(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者氏名カナ);
            assertThat(sut.get加害者氏名カナ(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者氏名カナ));
        }

        @Test
        public void 戻り値の加害者氏名は_設定した値と同じ加害者氏名を返す() {
            sut.set加害者氏名(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者氏名);
            assertThat(sut.get加害者氏名(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者氏名));
        }

        @Test
        public void 戻り値の加害者生年月日は_設定した値と同じ加害者生年月日を返す() {
            sut.set加害者生年月日(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者生年月日);
            assertThat(sut.get加害者生年月日(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者生年月日));
        }

        @Test
        public void 戻り値の加害者電話番号は_設定した値と同じ加害者電話番号を返す() {
            sut.set加害者電話番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者電話番号);
            assertThat(sut.get加害者電話番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者電話番号));
        }

        @Test
        public void 戻り値の加害者職業は_設定した値と同じ加害者職業を返す() {
            sut.set加害者職業(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者職業);
            assertThat(sut.get加害者職業(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_加害者職業));
        }

        @Test
        public void 戻り値の使用者郵便番号は_設定した値と同じ使用者郵便番号を返す() {
            sut.set使用者郵便番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者郵便番号);
            assertThat(sut.get使用者郵便番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者郵便番号));
        }

        @Test
        public void 戻り値の使用者住所は_設定した値と同じ使用者住所を返す() {
            sut.set使用者住所(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者住所);
            assertThat(sut.get使用者住所(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者住所));
        }

        @Test
        public void 戻り値の使用者氏名カナは_設定した値と同じ使用者氏名カナを返す() {
            sut.set使用者氏名カナ(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者氏名カナ);
            assertThat(sut.get使用者氏名カナ(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者氏名カナ));
        }

        @Test
        public void 戻り値の使用者氏名は_設定した値と同じ使用者氏名を返す() {
            sut.set使用者氏名(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者氏名);
            assertThat(sut.get使用者氏名(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者氏名));
        }

        @Test
        public void 戻り値の使用者生年月日は_設定した値と同じ使用者生年月日を返す() {
            sut.set使用者生年月日(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者生年月日);
            assertThat(sut.get使用者生年月日(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者生年月日));
        }

        @Test
        public void 戻り値の使用者電話番号は_設定した値と同じ使用者電話番号を返す() {
            sut.set使用者電話番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者電話番号);
            assertThat(sut.get使用者電話番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者電話番号));
        }

        @Test
        public void 戻り値の使用者職業は_設定した値と同じ使用者職業を返す() {
            sut.set使用者職業(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者職業);
            assertThat(sut.get使用者職業(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_使用者職業));
        }

        @Test
        public void 戻り値の負傷年月日は_設定した値と同じ負傷年月日を返す() {
            sut.set負傷年月日(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_負傷年月日);
            assertThat(sut.get負傷年月日(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_負傷年月日));
        }

        @Test
        public void 戻り値の負傷時間は_設定した値と同じ負傷時間を返す() {
            sut.set負傷時間(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_負傷時間);
            assertThat(sut.get負傷時間(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_負傷時間));
        }

        @Test
        public void 戻り値の負傷時の場所は_設定した値と同じ負傷時の場所を返す() {
            sut.set負傷時の場所(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_負傷時の場所);
            assertThat(sut.get負傷時の場所(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_負傷時の場所));
        }

        @Test
        public void 戻り値の発病原因_負傷時状況は_設定した値と同じ発病原因_負傷時状況を返す() {
            sut.set発病原因_負傷時状況(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_発病原因_負傷時状況);
            assertThat(sut.get発病原因_負傷時状況(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_発病原因_負傷時状況));
        }

        @Test
        public void 戻り値の自賠責保険契約会社名は_設定した値と同じ自賠責保険契約会社名を返す() {
            sut.set自賠責保険契約会社名(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_自賠責保険契約会社名);
            assertThat(sut.get自賠責保険契約会社名(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_自賠責保険契約会社名));
        }

        @Test
        public void 戻り値の自賠責保険証明書番号は_設定した値と同じ自賠責保険証明書番号を返す() {
            sut.set自賠責保険証明書番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_自賠責保険証明書番号);
            assertThat(sut.get自賠責保険証明書番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_自賠責保険証明書番号));
        }

        @Test
        public void 戻り値の自賠責保険契約者住所は_設定した値と同じ自賠責保険契約者住所を返す() {
            sut.set自賠責保険契約者住所(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_自賠責保険契約者住所);
            assertThat(sut.get自賠責保険契約者住所(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_自賠責保険契約者住所));
        }

        @Test
        public void 戻り値の所有者住所は_設定した値と同じ所有者住所を返す() {
            sut.set所有者住所(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_所有者住所);
            assertThat(sut.get所有者住所(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_所有者住所));
        }

        @Test
        public void 戻り値の所有者氏名は_設定した値と同じ所有者氏名を返す() {
            sut.set所有者氏名(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_所有者氏名);
            assertThat(sut.get所有者氏名(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_所有者氏名));
        }

        @Test
        public void 戻り値の登録番号は_設定した値と同じ登録番号を返す() {
            sut.set登録番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_登録番号);
            assertThat(sut.get登録番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_登録番号));
        }

        @Test
        public void 戻り値の車台番号は_設定した値と同じ車台番号を返す() {
            sut.set車台番号(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_車台番号);
            assertThat(sut.get車台番号(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_車台番号));
        }

        @Test
        public void 戻り値の任意保険対人保障有無は_設定した値と同じ任意保険対人保障有無を返す() {
            sut.set任意保険対人保障有無(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_任意保険対人保障有無);
            assertThat(sut.get任意保険対人保障有無(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_任意保険対人保障有無));
        }

        @Test
        public void 戻り値の任意保険対人保障保険契約会社名は_設定した値と同じ任意保険対人保障保険契約会社名を返す() {
            sut.set任意保険対人保障保険契約会社名(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_任意保険対人保障保険契約会社名);
            assertThat(sut.get任意保険対人保障保険契約会社名(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_任意保険対人保障保険契約会社名));
        }

        @Test
        public void 戻り値の任意保険対人保障保険契約会社連絡先は_設定した値と同じ任意保険対人保障保険契約会社連絡先を返す() {
            sut.set任意保険対人保障保険契約会社連絡先(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_任意保険対人保障保険契約会社連絡先);
            assertThat(sut.get任意保険対人保障保険契約会社連絡先(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_任意保険対人保障保険契約会社連絡先));
        }

        @Test
        public void 戻り値の任意保険対人保障保険契約会社担当者は_設定した値と同じ任意保険対人保障保険契約会社担当者を返す() {
            sut.set任意保険対人保障保険契約会社担当者(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_任意保険対人保障保険契約会社担当者);
            assertThat(sut.get任意保険対人保障保険契約会社担当者(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_任意保険対人保障保険契約会社担当者));
        }

        @Test
        public void 戻り値の示談成立有無は_設定した値と同じ示談成立有無を返す() {
            sut.set示談成立有無(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_示談成立有無);
            assertThat(sut.get示談成立有無(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_示談成立有無));
        }

        @Test
        public void 戻り値の示談成立年月日は_設定した値と同じ示談成立年月日を返す() {
            sut.set示談成立年月日(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_示談成立年月日);
            assertThat(sut.get示談成立年月日(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_示談成立年月日));
        }

        @Test
        public void 戻り値の損害賠償交渉経過は_設定した値と同じ損害賠償交渉経過を返す() {
            sut.set損害賠償交渉経過(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_損害賠償交渉経過);
            assertThat(sut.get損害賠償交渉経過(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_損害賠償交渉経過));
        }

        @Test
        public void 戻り値の事故発生状況報告書有無は_設定した値と同じ事故発生状況報告書有無を返す() {
            sut.set事故発生状況報告書有無(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_事故発生状況報告書有無);
            assertThat(sut.get事故発生状況報告書有無(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_事故発生状況報告書有無));
        }

        @Test
        public void 戻り値の念書兼同意書有無は_設定した値と同じ念書兼同意書有無を返す() {
            sut.set念書兼同意書有無(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_念書兼同意書有無);
            assertThat(sut.get念書兼同意書有無(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_念書兼同意書有無));
        }

        @Test
        public void 戻り値の誓約書有無は_設定した値と同じ誓約書有無を返す() {
            sut.set誓約書有無(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_誓約書有無);
            assertThat(sut.get誓約書有無(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_誓約書有無));
        }

        @Test
        public void 戻り値の交通事故証明書有無は_設定した値と同じ交通事故証明書有無を返す() {
            sut.set交通事故証明書有無(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_交通事故証明書有無);
            assertThat(sut.get交通事故証明書有無(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_交通事故証明書有無));
        }

        @Test
        public void 戻り値の人身事故証明書入手不能理由書有無は_設定した値と同じ人身事故証明書入手不能理由書有無を返す() {
            sut.set人身事故証明書入手不能理由書有無(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_人身事故証明書入手不能理由書有無);
            assertThat(sut.get人身事故証明書入手不能理由書有無(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_人身事故証明書入手不能理由書有無));
        }

        @Test
        public void 戻り値の示談書写し有無は_設定した値と同じ示談書写し有無を返す() {
            sut.set示談書写し有無(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_示談書写し有無);
            assertThat(sut.get示談書写し有無(), is(DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_示談書写し有無));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            DaisanshaKoiTodokedeModel sut = new DaisanshaKoiTodokedeModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            DaisanshaKoiTodokedeModel sut = new DaisanshaKoiTodokedeModel();
            sut.setEntity(DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity());

            sut.getEntity().initializeMd5();
            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            DaisanshaKoiTodokedeModel sut = new DaisanshaKoiTodokedeModel();
            sut.setEntity(DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            DaisanshaKoiTodokedeModel sut = new DaisanshaKoiTodokedeModel();
            sut.setEntity(DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
