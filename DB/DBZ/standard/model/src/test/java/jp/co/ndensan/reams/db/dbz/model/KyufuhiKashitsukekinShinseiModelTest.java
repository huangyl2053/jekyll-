/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3086KyufuhiKashitsukekinShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukekinShinseiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinShinseiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuhiKashitsukekinShinseiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuhiKashitsukekinShinseiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の借入申請年月日は_設定した値と同じ借入申請年月日を返す() {
            sut.set借入申請年月日(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日);
            assertThat(sut.get借入申請年月日(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の申請者郵便番号は_設定した値と同じ申請者郵便番号を返す() {
            sut.set申請者郵便番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者郵便番号);
            assertThat(sut.get申請者郵便番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者郵便番号));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            sut.set申請者住所(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者住所);
            assertThat(sut.get申請者住所(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者氏名カナは_設定した値と同じ申請者氏名カナを返す() {
            sut.set申請者氏名カナ(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者氏名カナ);
            assertThat(sut.get申請者氏名カナ(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者氏名カナ));
        }

        @Test
        public void 戻り値の申請者氏名は_設定した値と同じ申請者氏名を返す() {
            sut.set申請者氏名(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者氏名);
            assertThat(sut.get申請者氏名(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者氏名));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            sut.set申請者電話番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者電話番号);
            assertThat(sut.get申請者電話番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請者との関係は_設定した値と同じ申請者との関係を返す() {
            sut.set申請者との関係(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者との関係);
            assertThat(sut.get申請者との関係(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者との関係));
        }

        @Test
        public void 戻り値の借入利用期間開始年月日は_設定した値と同じ借入利用期間開始年月日を返す() {
            sut.set借入利用期間開始年月日(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入利用期間開始年月日);
            assertThat(sut.get借入利用期間開始年月日(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入利用期間開始年月日));
        }

        @Test
        public void 戻り値の借入利用期間終了年月日は_設定した値と同じ借入利用期間終了年月日を返す() {
            sut.set借入利用期間終了年月日(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入利用期間終了年月日);
            assertThat(sut.get借入利用期間終了年月日(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入利用期間終了年月日));
        }

        @Test
        public void 戻り値の貸付対象_高額介護サービス費等有無は_設定した値と同じ貸付対象_高額介護サービス費等有無を返す() {
            sut.set貸付対象_高額介護サービス費等有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_高額介護サービス費等有無);
            assertThat(sut.get貸付対象_高額介護サービス費等有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_高額介護サービス費等有無));
        }

        @Test
        public void 戻り値の貸付対象_住宅改修費等有無は_設定した値と同じ貸付対象_住宅改修費等有無を返す() {
            sut.set貸付対象_住宅改修費等有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_住宅改修費等有無);
            assertThat(sut.get貸付対象_住宅改修費等有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_住宅改修費等有無));
        }

        @Test
        public void 戻り値の貸付対象_福祉用具購入費等有無は_設定した値と同じ貸付対象_福祉用具購入費等有無を返す() {
            sut.set貸付対象_福祉用具購入費等有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_福祉用具購入費等有無);
            assertThat(sut.get貸付対象_福祉用具購入費等有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_福祉用具購入費等有無));
        }

        @Test
        public void 戻り値の貸付対象_特例介護サービス費等有無は_設定した値と同じ貸付対象_特例介護サービス費等有無を返す() {
            sut.set貸付対象_特例介護サービス費等有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_特例介護サービス費等有無);
            assertThat(sut.get貸付対象_特例介護サービス費等有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_特例介護サービス費等有無));
        }

        @Test
        public void 戻り値の保証人氏名カナは_設定した値と同じ保証人氏名カナを返す() {
            sut.set保証人氏名カナ(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人氏名カナ);
            assertThat(sut.get保証人氏名カナ(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人氏名カナ));
        }

        @Test
        public void 戻り値の保証人氏名は_設定した値と同じ保証人氏名を返す() {
            sut.set保証人氏名(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人氏名);
            assertThat(sut.get保証人氏名(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人氏名));
        }

        @Test
        public void 戻り値の保証人生年月日は_設定した値と同じ保証人生年月日を返す() {
            sut.set保証人生年月日(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人生年月日);
            assertThat(sut.get保証人生年月日(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人生年月日));
        }

        @Test
        public void 戻り値の保証人性別は_設定した値と同じ保証人性別を返す() {
            sut.set保証人性別(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人性別);
            assertThat(sut.get保証人性別(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人性別));
        }

        @Test
        public void 戻り値の保証人郵便番号は_設定した値と同じ保証人郵便番号を返す() {
            sut.set保証人郵便番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人郵便番号);
            assertThat(sut.get保証人郵便番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人郵便番号));
        }

        @Test
        public void 戻り値の保証人住所は_設定した値と同じ保証人住所を返す() {
            sut.set保証人住所(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人住所);
            assertThat(sut.get保証人住所(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人住所));
        }

        @Test
        public void 戻り値の保証人電話番号は_設定した値と同じ保証人電話番号を返す() {
            sut.set保証人電話番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人電話番号);
            assertThat(sut.get保証人電話番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人電話番号));
        }

        @Test
        public void 戻り値の借入申請者との関係は_設定した値と同じ借入申請者との関係を返す() {
            sut.set借入申請者との関係(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請者との関係);
            assertThat(sut.get借入申請者との関係(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請者との関係));
        }

        @Test
        public void 戻り値の保証人勤務先名称は_設定した値と同じ保証人勤務先名称を返す() {
            sut.set保証人勤務先名称(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先名称);
            assertThat(sut.get保証人勤務先名称(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先名称));
        }

        @Test
        public void 戻り値の保証人勤務先郵便番号は_設定した値と同じ保証人勤務先郵便番号を返す() {
            sut.set保証人勤務先郵便番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先郵便番号);
            assertThat(sut.get保証人勤務先郵便番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先郵便番号));
        }

        @Test
        public void 戻り値の保証人勤務先所在地は_設定した値と同じ保証人勤務先所在地を返す() {
            sut.set保証人勤務先所在地(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先所在地);
            assertThat(sut.get保証人勤務先所在地(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先所在地));
        }

        @Test
        public void 戻り値の保証人勤務先電話番号は_設定した値と同じ保証人勤務先電話番号を返す() {
            sut.set保証人勤務先電話番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先電話番号);
            assertThat(sut.get保証人勤務先電話番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先電話番号));
        }

        @Test
        public void 戻り値の請求書_領収書の有無は_設定した値と同じ請求書_領収書の有無を返す() {
            sut.set請求書_領収書の有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_請求書_領収書の有無);
            assertThat(sut.get請求書_領収書の有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_請求書_領収書の有無));
        }

        @Test
        public void 戻り値の提出物管理番号は_設定した値と同じ提出物管理番号を返す() {
            sut.set提出物管理番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_提出物管理番号);
            assertThat(sut.get提出物管理番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_提出物管理番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuhiKashitsukekinShinseiModel sut = new KyufuhiKashitsukekinShinseiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuhiKashitsukekinShinseiModel sut = new KyufuhiKashitsukekinShinseiModel();
            sut.setEntity(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuhiKashitsukekinShinseiModel sut = new KyufuhiKashitsukekinShinseiModel();
            sut.setEntity(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuhiKashitsukekinShinseiModel sut = new KyufuhiKashitsukekinShinseiModel();
            sut.setEntity(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
