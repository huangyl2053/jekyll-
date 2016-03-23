/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410039;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410039.TsuchishoJoho111Div;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 国保連情報受取データ取込_[111]給付実績情報のクラスです
 */
public class TsuchishoJoho111 {

    /**
     * 画面初期化
     *
     * @param div TsuchishoJoho111Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho111Div> onLoad(TsuchishoJoho111Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200007_KyufujissekiTorikomiIchiran")));
        div.getCcdKokurenJohoTorikomi().onLoadModeKakuninMsgJoken3(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件
     *
     * @param div TsuchishoJoho111Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho111Div> onClick_btnExcute(TsuchishoJoho111Div div) {
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        return ResponseData.of(div).respond();
    }

    /**
     * csv対象存在チェック
     *
     * @param div TsuchishoJoho111Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho111Div> onClick_beforCheck(TsuchishoJoho111Div div) {
        List<RString> 処理対象情報 = div.getCcdKokurenJohoTorikomi().get処理対象情報();
        if (処理対象情報 == null || 処理対象情報.isEmpty()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.対象ファイルが存在しない, "11100000.CSVと01110000.CSV")));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
