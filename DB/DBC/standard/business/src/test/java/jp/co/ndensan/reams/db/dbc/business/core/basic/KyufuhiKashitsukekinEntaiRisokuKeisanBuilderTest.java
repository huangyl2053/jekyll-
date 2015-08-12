/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukekinEntaiRisokuKeisanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinEntaiRisokuKeisanBuilderTest extends DbcTestBase {

    private static DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity KyufuhiKashitsukekinEntaiRisokuKeisanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisanBuilder sut;
        private static KyufuhiKashitsukekinEntaiRisokuKeisan business;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = new DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名2);

            business = new KyufuhiKashitsukekinEntaiRisokuKeisan(KyufuhiKashitsukekinEntaiRisokuKeisanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の貸付管理番号は_設定した値と同じ貸付管理番号を返す() {
            business = sut.set貸付管理番号(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付管理番号).build();
            assertThat(business.get貸付管理番号(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付管理番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の貸付金延滞日数は_設定した値と同じ貸付金延滞日数を返す() {
            business = sut.set貸付金延滞日数(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付金延滞日数).build();
            assertThat(business.get貸付金延滞日数(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付金延滞日数));
        }

        @Test
        public void 戻り値の貸付金延滞利息金額は_設定した値と同じ貸付金延滞利息金額を返す() {
            business = sut.set貸付金延滞利息金額(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付金延滞利息金額).build();
            assertThat(business.get貸付金延滞利息金額(), is(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付金延滞利息金額));
        }

    }
}
