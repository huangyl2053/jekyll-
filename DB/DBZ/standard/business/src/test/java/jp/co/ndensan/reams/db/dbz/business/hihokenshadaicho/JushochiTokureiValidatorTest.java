/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.model.helper.HihokenshaDaichoModelTestHelper;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.validation.JushochiTokureiValidationMessage;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * {@link jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.JushochiTokureiValidator}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiValidatorTest {

    public static class setJushochiTokureiData extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            JushochiTokureiValidator.setJushochiTokureiData(null);
            fail();
        }
    }

    public static class setJushochiTokureiList extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            JushochiTokureiValidator.setJushochiTokureiData(mock(HihokenshaDaichoModel.class))
                    .setJushochiTokureiList(null);
            fail();
        }
    }

    public static class validate extends DbzTestBase {

        private HihokenshaDaichoModel daicho;
        private IItemList<HihokenshaDaichoModel> daichoList;

        @Test
        public void 適用日が取得日より前の日付の場合_メッセージを保持する() {
            daicho = HihokenshaDaichoModelTestHelper.createModel();
            set取得_喪失日(daicho, new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            set適用_解除日(daicho, new FlexibleDate("20130101"), new FlexibleDate("20140909"));
            daichoList = ItemList.<HihokenshaDaichoModel>empty();

            IValidationMessages result = JushochiTokureiValidator.setJushochiTokureiData(daicho)
                    .setJushochiTokureiList(daichoList).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住特適用日が資格取得日より前), is(true));
        }

        @Test
        public void 適用日が喪失日以降の日付の場合_メッセージを保持する() {
            daicho = HihokenshaDaichoModelTestHelper.createModel();
            set取得_喪失日(daicho, new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            set適用_解除日(daicho, new FlexibleDate("20150101"), new FlexibleDate("20150909"));
            daichoList = ItemList.<HihokenshaDaichoModel>empty();

            IValidationMessages result = JushochiTokureiValidator.setJushochiTokureiData(daicho)
                    .setJushochiTokureiList(daichoList).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住特適用日が資格喪失日以降), is(true));
        }

        @Test
        public void 解除日が取得日より前の日付の場合_メッセージを保持する() {
            daicho = HihokenshaDaichoModelTestHelper.createModel();
            set取得_喪失日(daicho, new FlexibleDate("20160101"), new FlexibleDate("20161231"));
            set適用_解除日(daicho, new FlexibleDate("20150101"), new FlexibleDate("20150909"));
            daichoList = ItemList.<HihokenshaDaichoModel>empty();

            IValidationMessages result = JushochiTokureiValidator.setJushochiTokureiData(daicho)
                    .setJushochiTokureiList(daichoList).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住特解除日が資格取得日より前), is(true));
        }

        @Test
        public void 解除日が喪失日以降の日付の場合_メッセージを保持する() {
            daicho = HihokenshaDaichoModelTestHelper.createModel();
            set取得_喪失日(daicho, new FlexibleDate("20150101"), new FlexibleDate("20151231"));
            set適用_解除日(daicho, new FlexibleDate("20150101"), new FlexibleDate("20160909"));
            daichoList = ItemList.<HihokenshaDaichoModel>empty();

            IValidationMessages result = JushochiTokureiValidator.setJushochiTokureiData(daicho)
                    .setJushochiTokureiList(daichoList).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住特解除日が資格喪失日以降), is(true));
        }

        @Test
        public void 解除日がEMPTYの場合_住特適用日が資格喪失日以降を保持していない() {
            daicho = HihokenshaDaichoModelTestHelper.createModel();
            set取得_喪失日(daicho, new FlexibleDate("20150101"), new FlexibleDate("20151231"));
            set適用_解除日(daicho, new FlexibleDate("20150101"), FlexibleDate.EMPTY);
            daichoList = ItemList.<HihokenshaDaichoModel>empty();

            IValidationMessages result = JushochiTokureiValidator.setJushochiTokureiData(daicho)
                    .setJushochiTokureiList(daichoList).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住特適用日が資格喪失日以降), is(false));
        }

        @Test
        public void 解除日がEMPTYの場合_住特解除日が資格喪失日以降を保持していない() {
            daicho = HihokenshaDaichoModelTestHelper.createModel();
            set取得_喪失日(daicho, new FlexibleDate("20150101"), new FlexibleDate("20151231"));
            set適用_解除日(daicho, new FlexibleDate("20150201"), new FlexibleDate("20150601"));
            daichoList = ItemList.<HihokenshaDaichoModel>empty();

            IValidationMessages result = JushochiTokureiValidator.setJushochiTokureiData(daicho)
                    .setJushochiTokureiList(daichoList).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住特解除日が資格喪失日以降), is(false));
        }

        @Test
        public void 住特適用日が住特解除日より後の日付の場合_住所地特例期間が不正_適用日が解除日の後_を保持する() {
            daicho = HihokenshaDaichoModelTestHelper.createModel();
            set取得_喪失日(daicho, new FlexibleDate("20150101"), new FlexibleDate("20151231"));
            set適用_解除日(daicho, new FlexibleDate("20150601"), new FlexibleDate("20150201"));
            daichoList = ItemList.<HihokenshaDaichoModel>empty();

            IValidationMessages result = JushochiTokureiValidator.setJushochiTokureiData(daicho)
                    .setJushochiTokureiList(daichoList).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間が不正_適用日が解除日の後), is(true));
        }

        @Test
        public void 住特適用日が住特解除日より前の日付の場合_住所地特例期間が不正_適用日が解除日の後_を保持していない() {
            daicho = HihokenshaDaichoModelTestHelper.createModel();
            set取得_喪失日(daicho, new FlexibleDate("20150101"), new FlexibleDate("20151231"));
            set適用_解除日(daicho, new FlexibleDate("20150101"), FlexibleDate.EMPTY);
            daichoList = ItemList.<HihokenshaDaichoModel>empty();

            IValidationMessages result = JushochiTokureiValidator.setJushochiTokureiData(daicho)
                    .setJushochiTokureiList(daichoList).validate();
            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間が不正_適用日が解除日の後), is(false));
        }

        @Test
        public void dummy() {
            //TODO n8178 実装側のTODOが解消した後テストする。
            //５）登録する情報の適用日・解除日の期間と、住所地特例履歴一覧内の全データの適用日・解除日との比較で重複が有る場合、メッセージを返す。
        }

        private void set取得_喪失日(HihokenshaDaichoModel model, FlexibleDate 取得日, FlexibleDate 喪失日) {
            model.set資格取得年月日(取得日);
            model.set資格喪失年月日(喪失日);
        }

        private void set適用_解除日(HihokenshaDaichoModel model, FlexibleDate 適用日, FlexibleDate 解除日) {
            model.set適用年月日(適用日);
            model.set解除年月日(解除日);
        }
    }
}
