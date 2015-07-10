/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.model.helper.HihokenshaDaichoModelTestHelper;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.validation.JushochiTokureiValidationMessage;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.JuchochiTokureiTekiyoValidator}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JuchochiTokureiTekiyoValidatorTest {

    public static class setTekiyoDate extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            JuchochiTokureiTekiyoValidator.setTekiyoDate(null);
            fail();
        }
    }

    public static class setNewestHihokenshaDaicho extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            JuchochiTokureiTekiyoValidator.setTekiyoDate(FlexibleDate.MIN).setNewestHihokenshaDaicho(null);
            fail();
        }
    }

    public static class validate extends DbzTestBase {

        //TODO #55852
        //バリデーション処理のテストを実装する。
        //１）適用日 ＜ 最新履歴データの資格取得日 を満たす場合、メッセージを返す。
        //２）適用日 ＜ 最新履歴データの資格変更日 を満たす場合、メッセージを返す。
        //３）適用日 ＜ 最新履歴データの住所地特例解除日 を満たす場合、メッセージを返す。
        //４）上記の条件を満たさない場合、メッセージを保持していない。
        private FlexibleDate tekiyoDate;
        private HihokenshaDaichoModel newestModel;

        @Before
        public void setUp() {
            tekiyoDate = new FlexibleDate("20140101");
            newestModel = HihokenshaDaichoModelTestHelper.createModel();
            newestModel.set資格取得年月日(FlexibleDate.MIN);
            newestModel.set資格変更年月日(FlexibleDate.MIN);
            newestModel.set解除年月日(FlexibleDate.MIN);
        }

        @Test
        public void 適用日が最新履歴データの資格取得日より前の日付のとき_メッセージを返す() {
            newestModel.set資格取得年月日(FlexibleDate.MAX);
            IValidationMessages result = JuchochiTokureiTekiyoValidator.setTekiyoDate(tekiyoDate).setNewestHihokenshaDaicho(newestModel).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前),
                    is(true));
        }

        @Test
        public void 適用日が最新履歴データの資格変更日より前の日付のとき_メッセージを返す() {
            newestModel.set資格変更年月日(FlexibleDate.MAX);
            IValidationMessages result = JuchochiTokureiTekiyoValidator.setTekiyoDate(tekiyoDate).setNewestHihokenshaDaicho(newestModel).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前),
                    is(true));
        }

        @Test
        public void 適用日が最新履歴データの住所地特例適用年月日より前の日付のとき_メッセージを返す() {
            newestModel.set解除年月日(FlexibleDate.MAX);
            IValidationMessages result = JuchochiTokureiTekiyoValidator.setTekiyoDate(tekiyoDate).setNewestHihokenshaDaicho(newestModel).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前),
                    is(true));
        }

        @Test
        public void 上記以外の場合_メッセージを返さない() {
            IValidationMessages result = JuchochiTokureiTekiyoValidator.setTekiyoDate(tekiyoDate).setNewestHihokenshaDaicho(newestModel).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前),
                    is(false));
        }

    }

}
