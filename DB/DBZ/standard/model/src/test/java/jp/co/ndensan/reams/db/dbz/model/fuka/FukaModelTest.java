/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GaitoHigaitoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaModel}のテストクラスです。
 *
 * @author n3317 塚田萌
 */
@RunWith(Enclosed.class)
public class FukaModelTest extends DbbTestBase {

    public static class getterSetterTest extends DbbTestBase {

        private static FukaModel sut;

        @BeforeClass
        public static void test() {
            sut = new FukaModel();
        }

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            ChoteiNendo 調定年度 = new ChoteiNendo(DbT2002FukaEntityGenerator.DEFAULT_調定年度);
            sut.set調定年度(調定年度);
            assertThat(sut.get調定年度(), is(調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            FukaNendo 賦課年度 = new FukaNendo(DbT2002FukaEntityGenerator.DEFAULT_賦課年度);
            sut.set賦課年度(賦課年度);
            assertThat(sut.get賦課年度(), is(賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            sut.set通知書番号(DbT2002FukaEntityGenerator.DEFAULT_通知書番号);
            assertThat(sut.get通知書番号(), is(DbT2002FukaEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT2002FukaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT2002FukaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT2002FukaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT2002FukaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT2002FukaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT2002FukaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の世帯コードは_設定した値と同じ世帯コードを返す() {
            sut.set世帯コード(DbT2002FukaEntityGenerator.DEFAULT_世帯コード);
            assertThat(sut.get世帯コード(), is(DbT2002FukaEntityGenerator.DEFAULT_世帯コード));
        }

        @Test
        public void 戻り値の世帯員数は_設定した値と同じ世帯員数を返す() {
            sut.set世帯員数(DbT2002FukaEntityGenerator.DEFAULT_世帯員数);
            assertThat(sut.get世帯員数(), is(DbT2002FukaEntityGenerator.DEFAULT_世帯員数));
        }

        @Test
        public void 戻り値の資格取得日は_設定した値と同じ資格取得日を返す() {
            sut.set資格取得日(DbT2002FukaEntityGenerator.DEFAULT_資格取得日);
            assertThat(sut.get資格取得日(), is(DbT2002FukaEntityGenerator.DEFAULT_資格取得日));
        }

        @Test
        public void 戻り値の資格取得事由は_設定した値と同じ資格取得事由を返す() {
            sut.set資格取得事由(DbT2002FukaEntityGenerator.DEFAULT_資格取得事由);
            assertThat(sut.get資格取得事由(), is(DbT2002FukaEntityGenerator.DEFAULT_資格取得事由));
        }

        @Test
        public void 戻り値の資格喪失日は_設定した値と同じ資格喪失日を返す() {
            sut.set資格喪失日(DbT2002FukaEntityGenerator.DEFAULT_資格喪失日);
            assertThat(sut.get資格喪失日(), is(DbT2002FukaEntityGenerator.DEFAULT_資格喪失日));
        }

        @Test
        public void 戻り値の資格喪失事由は_設定した値と同じ資格喪失事由を返す() {
            sut.set資格喪失事由(DbT2002FukaEntityGenerator.DEFAULT_資格喪失事由);
            assertThat(sut.get資格喪失事由(), is(DbT2002FukaEntityGenerator.DEFAULT_資格喪失事由));
        }

        @Test
        public void 戻り値の生活保護扶助種類は_設定した値と同じ生活保護扶助種類を返す() {
            sut.set生活保護扶助種類(DbT2002FukaEntityGenerator.DEFAULT_生活保護扶助種類);
            assertThat(sut.get生活保護扶助種類(), is(DbT2002FukaEntityGenerator.DEFAULT_生活保護扶助種類));
        }

        @Test
        public void 戻り値の生保開始日は_設定した値と同じ生保開始日を返す() {
            sut.set生保開始日(DbT2002FukaEntityGenerator.DEFAULT_生保開始日);
            assertThat(sut.get生保開始日(), is(DbT2002FukaEntityGenerator.DEFAULT_生保開始日));
        }

        @Test
        public void 戻り値の生保廃止日は_設定した値と同じ生保廃止日を返す() {
            sut.set生保廃止日(DbT2002FukaEntityGenerator.DEFAULT_生保廃止日);
            assertThat(sut.get生保廃止日(), is(DbT2002FukaEntityGenerator.DEFAULT_生保廃止日));
        }

        @Test
        public void 戻り値の老年開始日は_設定した値と同じ老年開始日を返す() {
            sut.set老年開始日(DbT2002FukaEntityGenerator.DEFAULT_老年開始日);
            assertThat(sut.get老年開始日(), is(DbT2002FukaEntityGenerator.DEFAULT_老年開始日));
        }

        @Test
        public void 戻り値の老年廃止日は_設定した値と同じ老年廃止日を返す() {
            sut.set老年廃止日(DbT2002FukaEntityGenerator.DEFAULT_老年廃止日);
            assertThat(sut.get老年廃止日(), is(DbT2002FukaEntityGenerator.DEFAULT_老年廃止日));
        }

        @Test
        public void 戻り値の賦課期日は_設定した値と同じ賦課期日を返す() {
            sut.set賦課期日(DbT2002FukaEntityGenerator.DEFAULT_賦課期日);
            assertThat(sut.get賦課期日(), is(DbT2002FukaEntityGenerator.DEFAULT_賦課期日));
        }

        @Test
        public void 戻り値の課税区分は_設定した値と同じ課税区分を返す() {
            sut.set課税区分(KazeiKubun.toValue(DbT2002FukaEntityGenerator.DEFAULT_課税区分));
            assertThat(sut.get課税区分().code(), is(DbT2002FukaEntityGenerator.DEFAULT_課税区分));
        }

        @Test
        public void 戻り値の世帯課税区分は_設定した値と同じ世帯課税区分を返す() {
            sut.set世帯課税区分(KazeiKubun.toValue(DbT2002FukaEntityGenerator.DEFAULT_世帯課税区分));
            assertThat(sut.get世帯課税区分().code(), is(DbT2002FukaEntityGenerator.DEFAULT_世帯課税区分));
        }

        @Test
        public void 戻り値の合計所得金額は_設定した値と同じ合計所得金額を返す() {
            sut.set合計所得金額(DbT2002FukaEntityGenerator.DEFAULT_合計所得金額);
            assertThat(sut.get合計所得金額(), is(DbT2002FukaEntityGenerator.DEFAULT_合計所得金額));
        }

        @Test
        public void 戻り値の公的年金収入額は_設定した値と同じ公的年金収入額を返す() {
            sut.set公的年金収入額(DbT2002FukaEntityGenerator.DEFAULT_公的年金収入額);
            assertThat(sut.get公的年金収入額(), is(DbT2002FukaEntityGenerator.DEFAULT_公的年金収入額));
        }

        @Test
        public void 戻り値の保険料段階は_設定した値と同じ保険料段階を返す() {
            sut.set保険料段階(DbT2002FukaEntityGenerator.DEFAULT_保険料段階);
            assertThat(sut.get保険料段階(), is(DbT2002FukaEntityGenerator.DEFAULT_保険料段階));
        }

        @Test
        public void 戻り値の保険料算定段階1は_設定した値と同じ保険料算定段階1を返す() {
            sut.set保険料算定段階1(DbT2002FukaEntityGenerator.DEFAULT_保険料算定段階1);
            assertThat(sut.get保険料算定段階1(), is(DbT2002FukaEntityGenerator.DEFAULT_保険料算定段階1));
        }

        @Test
        public void 戻り値の算定年額保険料1は_設定した値と同じ算定年額保険料1を返す() {
            sut.set算定年額保険料1(DbT2002FukaEntityGenerator.DEFAULT_算定年額保険料1);
            assertThat(sut.get算定年額保険料1(), is(DbT2002FukaEntityGenerator.DEFAULT_算定年額保険料1));
        }

        @Test
        public void 戻り値の月割開始年月1は_設定した値と同じ月割開始年月1を返す() {
            sut.set月割開始年月1(DbT2002FukaEntityGenerator.DEFAULT_月割開始年月1);
            assertThat(sut.get月割開始年月1(), is(DbT2002FukaEntityGenerator.DEFAULT_月割開始年月1));
        }

        @Test
        public void 戻り値の月割終了年月1は_設定した値と同じ月割終了年月1を返す() {
            sut.set月割終了年月1(DbT2002FukaEntityGenerator.DEFAULT_月割終了年月1);
            assertThat(sut.get月割終了年月1(), is(DbT2002FukaEntityGenerator.DEFAULT_月割終了年月1));
        }

        @Test
        public void 戻り値の保険料算定段階2は_設定した値と同じ保険料算定段階2を返す() {
            sut.set保険料算定段階2(DbT2002FukaEntityGenerator.DEFAULT_保険料算定段階2);
            assertThat(sut.get保険料算定段階2(), is(DbT2002FukaEntityGenerator.DEFAULT_保険料算定段階2));
        }

        @Test
        public void 戻り値の算定年額保険料2は_設定した値と同じ算定年額保険料2を返す() {
            sut.set算定年額保険料2(DbT2002FukaEntityGenerator.DEFAULT_算定年額保険料2);
            assertThat(sut.get算定年額保険料2(), is(DbT2002FukaEntityGenerator.DEFAULT_算定年額保険料2));
        }

        @Test
        public void 戻り値の月割開始年月2は_設定した値と同じ月割開始年月2を返す() {
            sut.set月割開始年月2(DbT2002FukaEntityGenerator.DEFAULT_月割開始年月2);
            assertThat(sut.get月割開始年月2(), is(DbT2002FukaEntityGenerator.DEFAULT_月割開始年月2));
        }

        @Test
        public void 戻り値の月割終了年月2は_設定した値と同じ月割終了年月2を返す() {
            sut.set月割終了年月2(DbT2002FukaEntityGenerator.DEFAULT_月割終了年月2);
            assertThat(sut.get月割終了年月2(), is(DbT2002FukaEntityGenerator.DEFAULT_月割終了年月2));
        }

        @Test
        public void 戻り値の調定日時は_設定した値と同じ調定日時を返す() {
            sut.set調定日時(DbT2002FukaEntityGenerator.DEFAULT_調定日時);
            assertThat(sut.get調定日時(), is(DbT2002FukaEntityGenerator.DEFAULT_調定日時));
        }

        @Test
        public void 戻り値の調定事由1は_設定した値と同じ調定事由1を返す() {
            sut.set調定事由1(DbT2002FukaEntityGenerator.DEFAULT_調定事由1);
            assertThat(sut.get調定事由1(), is(DbT2002FukaEntityGenerator.DEFAULT_調定事由1));
        }

        @Test
        public void 戻り値の調定事由2は_設定した値と同じ調定事由2を返す() {
            sut.set調定事由2(DbT2002FukaEntityGenerator.DEFAULT_調定事由2);
            assertThat(sut.get調定事由2(), is(DbT2002FukaEntityGenerator.DEFAULT_調定事由2));
        }

        @Test
        public void 戻り値の調定事由3は_設定した値と同じ調定事由3を返す() {
            sut.set調定事由3(DbT2002FukaEntityGenerator.DEFAULT_調定事由3);
            assertThat(sut.get調定事由3(), is(DbT2002FukaEntityGenerator.DEFAULT_調定事由3));
        }

        @Test
        public void 戻り値の調定事由4は_設定した値と同じ調定事由4を返す() {
            sut.set調定事由4(DbT2002FukaEntityGenerator.DEFAULT_調定事由4);
            assertThat(sut.get調定事由4(), is(DbT2002FukaEntityGenerator.DEFAULT_調定事由4));
        }

        @Test
        public void 戻り値の更正月は_設定した値と同じ更正月を返す() {
            sut.set更正月(DbT2002FukaEntityGenerator.DEFAULT_更正月);
            assertThat(sut.get更正月(), is(DbT2002FukaEntityGenerator.DEFAULT_更正月));
        }

        @Test
        public void 戻り値の減免前介護保険料_年額は_設定した値と同じ減免前介護保険料_年額を返す() {
            sut.set減免前介護保険料_年額(DbT2002FukaEntityGenerator.DEFAULT_減免前介護保険料_年額);
            assertThat(sut.get減免前介護保険料_年額(), is(DbT2002FukaEntityGenerator.DEFAULT_減免前介護保険料_年額));
        }

        @Test
        public void 戻り値の減免額は_設定した値と同じ減免額を返す() {
            sut.set減免額(DbT2002FukaEntityGenerator.DEFAULT_減免額);
            assertThat(sut.get減免額(), is(DbT2002FukaEntityGenerator.DEFAULT_減免額));
        }

        @Test
        public void 戻り値の確定介護保険料_年額は_設定した値と同じ確定介護保険料_年額を返す() {
            sut.set確定介護保険料_年額(DbT2002FukaEntityGenerator.DEFAULT_確定介護保険料_年額);
            assertThat(sut.get確定介護保険料_年額(), is(DbT2002FukaEntityGenerator.DEFAULT_確定介護保険料_年額));
        }

        @Test
        public void 戻り値の保険料段階_仮算定時は_設定した値と同じ保険料段階_仮算定時を返す() {
            sut.set保険料段階_仮算定時(DbT2002FukaEntityGenerator.DEFAULT_保険料段階_仮算定時);
            assertThat(sut.get保険料段階_仮算定時(), is(DbT2002FukaEntityGenerator.DEFAULT_保険料段階_仮算定時));
        }

        @Test
        public void 戻り値の徴収方法処理日時は_設定した値と同じ徴収方法処理日時を返す() {
            sut.set徴収方法処理日時(DbT2002FukaEntityGenerator.DEFAULT_徴収方法処理日時);
            assertThat(sut.get徴収方法処理日時(), is(DbT2002FukaEntityGenerator.DEFAULT_徴収方法処理日時));
        }

        @Test
        public void 戻り値の異動基準日時は_設定した値と同じ異動基準日時を返す() {
            sut.set異動基準日時(DbT2002FukaEntityGenerator.DEFAULT_異動基準日時);
            assertThat(sut.get異動基準日時(), is(DbT2002FukaEntityGenerator.DEFAULT_異動基準日時));
        }

        @Test
        public void 戻り値の口座区分は_設定した値と同じ口座区分を返す() {
            sut.set口座区分(GaitoHigaitoKubun.toValue(DbT2002FukaEntityGenerator.DEFAULT_口座区分));
            assertThat(sut.get口座区分().getCode(), is(DbT2002FukaEntityGenerator.DEFAULT_口座区分));
        }

        @Test
        public void 戻り値の境界層区分は_設定した値と同じ境界層区分を返す() {
            sut.set境界層区分(GaitoHigaitoKubun.toValue(DbT2002FukaEntityGenerator.DEFAULT_境界層区分));
            assertThat(sut.get境界層区分().getCode(), is(DbT2002FukaEntityGenerator.DEFAULT_境界層区分));
        }

        @Test
        public void 戻り値の職権区分は_設定した値と同じ職権区分を返す() {
            sut.set職権区分(GaitoHigaitoKubun.toValue(DbT2002FukaEntityGenerator.DEFAULT_職権区分));
            assertThat(sut.get職権区分().getCode(), is(DbT2002FukaEntityGenerator.DEFAULT_職権区分));
        }

        @Test
        public void 戻り値の賦課市町村コードは_設定した値と同じ賦課市町村コードを返す() {
            sut.set賦課市町村コード(DbT2002FukaEntityGenerator.DEFAULT_賦課市町村コード);
            assertThat(sut.get賦課市町村コード(), is(DbT2002FukaEntityGenerator.DEFAULT_賦課市町村コード));
        }

    }

    public static class getStateTest extends DbbTestBase {

        @Test
        public void 状態Addedの取得確認() {
            FukaModel sut = new FukaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            FukaModel sut = new FukaModel();
            sut.setEntity(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());

            sut.getEntity().initializeMd5();

            sut.getEntity().setGemmenGaku(new Decimal(999));

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            FukaModel sut = new FukaModel();
            sut.setEntity(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            FukaModel sut = new FukaModel();
            sut.setEntity(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
