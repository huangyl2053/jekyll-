/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.model.TashichosonJushochiTokureiModel;
import jp.co.ndensan.reams.db.dbz.model.TekiyoJogaishaModel;
import jp.co.ndensan.reams.db.dbz.model.helper.HihokenshaDaichoModelTestHelper;
import jp.co.ndensan.reams.db.dbz.model.helper.TashichosonJushochiTokureiModelTestHelper;
import jp.co.ndensan.reams.db.dbz.model.helper.TekiyoJogaishaModelTestHelper;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.validation.JushochiTokureiValidationMessage;
import jp.co.ndensan.reams.db.dbz.realservice.TashichosonJushochiTokureiManager;
import jp.co.ndensan.reams.db.dbz.realservice.TekiyoJogaishaManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho.JushochiTokureiDuplicateValidator}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiUnduplicateValidatorTest {

    private static JushochiTokureiUnduplicateValidator sut;

    public static class setHihokenshaDaichoData extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            JushochiTokureiUnduplicateValidator.setHihokenshaDaichoData(null);
            fail();
        }
    }

    public static class validate extends DbzTestBase {

        private HihokenshaDaichoModel target;
        private TashichosonJushochiTokureiManager tatokuManager;
        private TekiyoJogaishaManager jogaishaManager;

        @Test
        public void 入力した適用日と_他市町村住所地特例該当データの適用日と解除日の期間に重複が有る場合_メッセージを持つ() {
            tatokuManager = createTatokuManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            jogaishaManager = createJogaiManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            target = createHihoDaicho(new FlexibleDate("20140621"), new FlexibleDate("20151231"));

            IValidationMessages result = JushochiTokureiUnduplicateValidator
                    .setHihokenshaDaichoData(tatokuManager, jogaishaManager, target).validate();

            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある), is(true));
        }

        @Test
        public void 入力した解除日と_他市町村住所地特例該当データの適用日と解除日の期間に重複が有る場合_メッセージを持つ() {
            tatokuManager = createTatokuManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            jogaishaManager = createJogaiManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            target = createHihoDaicho(new FlexibleDate("20130101"), new FlexibleDate("20140629"));

            IValidationMessages result = JushochiTokureiUnduplicateValidator
                    .setHihokenshaDaichoData(tatokuManager, jogaishaManager, target).validate();

            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある), is(true));

        }

        @Test
        public void 入力した適用日と解除日の期間と_他市町村住所地特例該当データの適用日と解除日の期間に重複が無い場合_メッセージを持たない() {
            tatokuManager = createTatokuManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            jogaishaManager = createJogaiManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            target = createHihoDaicho(new FlexibleDate("20150101"), new FlexibleDate("20151231"));

            IValidationMessages result = JushochiTokureiUnduplicateValidator
                    .setHihokenshaDaichoData(tatokuManager, jogaishaManager, target).validate();

            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある), is(false));
        }

        @Test
        public void 対象者が他市町村住所地特例の該当データを持たない場合_メッセージを持たない() {
            tatokuManager = mock(TashichosonJushochiTokureiManager.class);
            when(tatokuManager.get他市町村住所地特例List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(ItemList.<TashichosonJushochiTokureiModel>empty());
            jogaishaManager = mock(TekiyoJogaishaManager.class);
            when(jogaishaManager.get適用除外者情報List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(ItemList.<TekiyoJogaishaModel>empty());
            target = createHihoDaicho(new FlexibleDate("20150101"), new FlexibleDate("20151231"));

            IValidationMessages result = JushochiTokureiUnduplicateValidator
                    .setHihokenshaDaichoData(tatokuManager, jogaishaManager, target).validate();

            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある), is(false));

        }

        @Test
        public void 入力した適用日と_適用除外該当データの適用日と解除日の期間に重複が有る場合_メッセージを持つ() {
            tatokuManager = createTatokuManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            jogaishaManager = createJogaiManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            target = createHihoDaicho(new FlexibleDate("20140621"), new FlexibleDate("20151231"));

            IValidationMessages result = JushochiTokureiUnduplicateValidator
                    .setHihokenshaDaichoData(tatokuManager, jogaishaManager, target).validate();

            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある), is(true));
        }

        @Test
        public void 入力した解除日と_適用除外該当データの適用日と解除日の期間に重複が有る場合_メッセージを持つ() {
            tatokuManager = createTatokuManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            jogaishaManager = createJogaiManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            target = createHihoDaicho(new FlexibleDate("20130101"), new FlexibleDate("20140629"));

            IValidationMessages result = JushochiTokureiUnduplicateValidator
                    .setHihokenshaDaichoData(tatokuManager, jogaishaManager, target).validate();

            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある), is(true));
        }

        @Test
        public void 入力した適用日と解除日の期間と_適用除外該当データの適用日と解除日の期間に重複が無い場合_メッセージを持たない() {
            tatokuManager = createTatokuManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            jogaishaManager = createJogaiManager(new FlexibleDate("20140101"), new FlexibleDate("20141231"));
            target = createHihoDaicho(new FlexibleDate("20150101"), new FlexibleDate("20151231"));

            IValidationMessages result = JushochiTokureiUnduplicateValidator
                    .setHihokenshaDaichoData(tatokuManager, jogaishaManager, target).validate();

            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある), is(false));
        }

        @Test
        public void 対象者が適用除外の該当データを持たない場合_メッセージを持たない() {
            tatokuManager = mock(TashichosonJushochiTokureiManager.class);
            when(tatokuManager.get他市町村住所地特例List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(ItemList.<TashichosonJushochiTokureiModel>empty());
            jogaishaManager = mock(TekiyoJogaishaManager.class);
            when(jogaishaManager.get適用除外者情報List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(ItemList.<TekiyoJogaishaModel>empty());
            target = createHihoDaicho(new FlexibleDate("20150101"), new FlexibleDate("20151231"));

            IValidationMessages result = JushochiTokureiUnduplicateValidator
                    .setHihokenshaDaichoData(tatokuManager, jogaishaManager, target).validate();

            assertThat(result.contains(JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある), is(false));
        }

        private HihokenshaDaichoModel createHihoDaicho(FlexibleDate 適用日, FlexibleDate 解除日) {
            HihokenshaDaichoModel model = HihokenshaDaichoModelTestHelper.createModel();
            model.set適用年月日(適用日);
            model.set解除年月日(解除日);
            return model;
        }

        private TashichosonJushochiTokureiManager createTatokuManager(FlexibleDate 適用日, FlexibleDate 解除日) {
            TashichosonJushochiTokureiModel model = TashichosonJushochiTokureiModelTestHelper.createModel();
            model.set適用年月日(適用日);
            model.set解除年月日(解除日);

            TashichosonJushochiTokureiManager manager = mock(TashichosonJushochiTokureiManager.class);
            when(manager.get他市町村住所地特例List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(ItemList.of(model));
            return manager;
        }

        private TekiyoJogaishaManager createJogaiManager(FlexibleDate 適用日, FlexibleDate 解除日) {
            TekiyoJogaishaModel model = TekiyoJogaishaModelTestHelper.createModel();
            model.set適用年月日(適用日);
            model.set解除年月日(解除日);

            TekiyoJogaishaManager manager = mock(TekiyoJogaishaManager.class);
            when(manager.get適用除外者情報List(any(LasdecCode.class), any(ShikibetsuCode.class)))
                    .thenReturn(ItemList.of(model));
            return manager;
        }

    }

}
