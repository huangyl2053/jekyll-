/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3086KyufuhiKashitsukekinShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3086KyufuhiKashitsukekinShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukekinShinseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinShinseiBuilderTest extends DbcTestBase {

    private static DbT3086KyufuhiKashitsukekinShinseiEntity KyufuhiKashitsukekinShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 借入申請年月日;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号;
        借入申請年月日 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日;
        履歴番号 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufuhiKashitsukekinShinseiBuilder sut;
        private static KyufuhiKashitsukekinShinsei business;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShinseiEntity = new DbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinseiEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinShinseiEntity.setKariireShinseiYMD(借入申請年月日);
            KyufuhiKashitsukekinShinseiEntity.setRirekiNo(履歴番号);

            business = new KyufuhiKashitsukekinShinsei(KyufuhiKashitsukekinShinseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の借入申請年月日は_設定した値と同じ借入申請年月日を返す() {
            business = sut.set借入申請年月日(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日).build();
            assertThat(business.get借入申請年月日(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の申請者郵便番号は_設定した値と同じ申請者郵便番号を返す() {
            business = sut.set申請者郵便番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者郵便番号).build();
            assertThat(business.get申請者郵便番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者郵便番号));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            business = sut.set申請者住所(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者住所).build();
            assertThat(business.get申請者住所(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者氏名カナは_設定した値と同じ申請者氏名カナを返す() {
            business = sut.set申請者氏名カナ(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者氏名カナ).build();
            assertThat(business.get申請者氏名カナ(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者氏名カナ));
        }

        @Test
        public void 戻り値の申請者氏名は_設定した値と同じ申請者氏名を返す() {
            business = sut.set申請者氏名(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者氏名).build();
            assertThat(business.get申請者氏名(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者氏名));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            business = sut.set申請者電話番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者電話番号).build();
            assertThat(business.get申請者電話番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請者との関係は_設定した値と同じ申請者との関係を返す() {
            business = sut.set申請者との関係(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者との関係).build();
            assertThat(business.get申請者との関係(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_申請者との関係));
        }

        @Test
        public void 戻り値の借入利用期間開始年月日は_設定した値と同じ借入利用期間開始年月日を返す() {
            business = sut.set借入利用期間開始年月日(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入利用期間開始年月日).build();
            assertThat(business.get借入利用期間開始年月日(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入利用期間開始年月日));
        }

        @Test
        public void 戻り値の借入利用期間終了年月日は_設定した値と同じ借入利用期間終了年月日を返す() {
            business = sut.set借入利用期間終了年月日(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入利用期間終了年月日).build();
            assertThat(business.get借入利用期間終了年月日(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入利用期間終了年月日));
        }

        @Test
        public void 戻り値の貸付対象_高額介護サービス費等有無は_設定した値と同じ貸付対象_高額介護サービス費等有無を返す() {
            business = sut.set貸付対象_高額介護サービス費等有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_高額介護サービス費等有無).build();
            assertThat(business.get貸付対象_高額介護サービス費等有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_高額介護サービス費等有無));
        }

        @Test
        public void 戻り値の貸付対象_住宅改修費等有無は_設定した値と同じ貸付対象_住宅改修費等有無を返す() {
            business = sut.set貸付対象_住宅改修費等有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_住宅改修費等有無).build();
            assertThat(business.get貸付対象_住宅改修費等有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_住宅改修費等有無));
        }

        @Test
        public void 戻り値の貸付対象_福祉用具購入費等有無は_設定した値と同じ貸付対象_福祉用具購入費等有無を返す() {
            business = sut.set貸付対象_福祉用具購入費等有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_福祉用具購入費等有無).build();
            assertThat(business.get貸付対象_福祉用具購入費等有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_福祉用具購入費等有無));
        }

        @Test
        public void 戻り値の貸付対象_特例介護サービス費等有無は_設定した値と同じ貸付対象_特例介護サービス費等有無を返す() {
            business = sut.set貸付対象_特例介護サービス費等有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_特例介護サービス費等有無).build();
            assertThat(business.get貸付対象_特例介護サービス費等有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_貸付対象_特例介護サービス費等有無));
        }

        @Test
        public void 戻り値の保証人氏名カナは_設定した値と同じ保証人氏名カナを返す() {
            business = sut.set保証人氏名カナ(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人氏名カナ).build();
            assertThat(business.get保証人氏名カナ(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人氏名カナ));
        }

        @Test
        public void 戻り値の保証人氏名は_設定した値と同じ保証人氏名を返す() {
            business = sut.set保証人氏名(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人氏名).build();
            assertThat(business.get保証人氏名(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人氏名));
        }

        @Test
        public void 戻り値の保証人生年月日は_設定した値と同じ保証人生年月日を返す() {
            business = sut.set保証人生年月日(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人生年月日).build();
            assertThat(business.get保証人生年月日(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人生年月日));
        }

        @Test
        public void 戻り値の保証人性別は_設定した値と同じ保証人性別を返す() {
            business = sut.set保証人性別(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人性別).build();
            assertThat(business.get保証人性別(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人性別));
        }

        @Test
        public void 戻り値の保証人郵便番号は_設定した値と同じ保証人郵便番号を返す() {
            business = sut.set保証人郵便番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人郵便番号).build();
            assertThat(business.get保証人郵便番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人郵便番号));
        }

        @Test
        public void 戻り値の保証人住所は_設定した値と同じ保証人住所を返す() {
            business = sut.set保証人住所(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人住所).build();
            assertThat(business.get保証人住所(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人住所));
        }

        @Test
        public void 戻り値の保証人電話番号は_設定した値と同じ保証人電話番号を返す() {
            business = sut.set保証人電話番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人電話番号).build();
            assertThat(business.get保証人電話番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人電話番号));
        }

        @Test
        public void 戻り値の借入申請者との関係は_設定した値と同じ借入申請者との関係を返す() {
            business = sut.set借入申請者との関係(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請者との関係).build();
            assertThat(business.get借入申請者との関係(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請者との関係));
        }

        @Test
        public void 戻り値の保証人勤務先名称は_設定した値と同じ保証人勤務先名称を返す() {
            business = sut.set保証人勤務先名称(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先名称).build();
            assertThat(business.get保証人勤務先名称(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先名称));
        }

        @Test
        public void 戻り値の保証人勤務先郵便番号は_設定した値と同じ保証人勤務先郵便番号を返す() {
            business = sut.set保証人勤務先郵便番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先郵便番号).build();
            assertThat(business.get保証人勤務先郵便番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先郵便番号));
        }

        @Test
        public void 戻り値の保証人勤務先所在地は_設定した値と同じ保証人勤務先所在地を返す() {
            business = sut.set保証人勤務先所在地(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先所在地).build();
            assertThat(business.get保証人勤務先所在地(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先所在地));
        }

        @Test
        public void 戻り値の保証人勤務先電話番号は_設定した値と同じ保証人勤務先電話番号を返す() {
            business = sut.set保証人勤務先電話番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先電話番号).build();
            assertThat(business.get保証人勤務先電話番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_保証人勤務先電話番号));
        }

        @Test
        public void 戻り値の請求書_領収書の有無は_設定した値と同じ請求書_領収書の有無を返す() {
            business = sut.set請求書_領収書の有無(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_請求書_領収書の有無).build();
            assertThat(business.get請求書_領収書の有無(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_請求書_領収書の有無));
        }

        @Test
        public void 戻り値の提出物管理番号は_設定した値と同じ提出物管理番号を返す() {
            business = sut.set提出物管理番号(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_提出物管理番号).build();
            assertThat(business.get提出物管理番号(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_提出物管理番号));
        }

    }
}
