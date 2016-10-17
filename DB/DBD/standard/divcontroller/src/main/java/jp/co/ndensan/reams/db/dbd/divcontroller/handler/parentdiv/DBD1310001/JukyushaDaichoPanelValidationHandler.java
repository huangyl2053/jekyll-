/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1310001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001.JukyushaDaichoDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public class JukyushaDaichoPanelValidationHandler {

    private final JukyushaDaichoDiv div;

    /**
     * コンストラクタです
     *
     * @param div ドメインオブジェクトを取り出したい{@link JukyushaDaichoDiv}
     */
    public JukyushaDaichoPanelValidationHandler(JukyushaDaichoDiv div) {
        this.div = div;
    }

    /**
     * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)のバリデーション。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _JukyushaDaichoPanelValidator validator = new _JukyushaDaichoPanelValidator(div);
        validateResult.add(createDictionary().check(validator.validate()));
        validateResult = 範囲From_Toの大小Check(validateResult);
        return validateResult;

    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック1, div.getTxtKijyunYmd())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック2, div.getTxtNinteiYmdHani())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック4, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtNenrei())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック5, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtNenrei())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック6, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtNenreiKijunbi())
                .add(JukyushaDaichoPanelValidationMessage.実行するボタンクリック7, div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtSeinengappi())
                .build();
    }

    private ValidationMessageControlPairs 範囲From_Toの大小Check(ValidationMessageControlPairs validateResult) {
        if (!check範囲()) {
            validateResult.add(new ValidationMessageControlPair(new ReplaceErrorMessage(
                    div.getTxtNinteiYmdHani().getToValue().toDateString().toString(),
                    div.getTxtNinteiYmdHani().getFromValue().toDateString().toString()),
                    div.getTxtNinteiYmdHani()));
        }
        if (!check生年月日()) {
            validateResult.add(new ValidationMessageControlPair(new ReplaceErrorMessage(
                    div.getCcdAtenaJoken().get生年月日開始().toDateString().toString(),
                    div.getCcdAtenaJoken().get生年月日終了().toDateString().toString()),
                    div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtSeinengappi()));
        }
        return validateResult;
    }

    private boolean check範囲() {
        if (div.getRadChushutsuTaisho().getSelectedKey().equals(ChushutsuHohoKubun.範囲.getコード())
                && div.getTxtNinteiYmdHani().getFromValue() != null && div.getTxtNinteiYmdHani().getToValue() != null) {
            return div.getTxtNinteiYmdHani().getFromValue().isBeforeOrEquals(div.getTxtNinteiYmdHani().getToValue());
        }
        return true;
    }

    private boolean check生年月日() {
        if (div.getCcdAtenaJoken().get年齢層抽出方法().equals(NenreiSoChushutsuHoho.生年月日範囲)
                && div.getCcdAtenaJoken().get生年月日開始() != null && div.getCcdAtenaJoken().get生年月日終了() != null) {
            return div.getCcdAtenaJoken().get生年月日開始().isBeforeOrEquals(div.getCcdAtenaJoken().get生年月日終了());
        }
        return true;
    }

    private static class ReplaceErrorMessage implements IValidationMessage {

        private final Message message;

        @Override
        public Message getMessage() {
            return message;
        }

        public ReplaceErrorMessage(String... replacements) {
            this.message = UrErrorMessages.期間が不正_追加メッセージあり１.getMessage().replace(replacements);
        }
    }

}
