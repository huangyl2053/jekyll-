/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410039;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kokuhorenkyoutsu.KokuhorenKyoutsuBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410039.TsuchishoJoho111Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報受取データ取込_[111]給付実績情報のクラスです。
 *
 * @reamsid_L DBC-0980-280 wangkanglei
 */
public class TsuchishoJoho111 {

    private static final RString 帳票ID = new RString("DBC200007_KyufujissekiTorikomiIchiran");
    private static final RString 対象ファイル = new RString("11100000.CSVと01110000.CSV");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TsuchishoJoho111Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho111Div> onLoad(TsuchishoJoho111Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(帳票ID));
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater, SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件のメソッドます。
     *
     * @param div TsuchishoJoho111Div
     * @return ResponseData
     */
    public ResponseData<KokuhorenKyoutsuBatchParameter> onClick_btnExcute(TsuchishoJoho111Div div) {
        KokuhorenKyoutsuBatchParameter parameter = new KokuhorenKyoutsuBatchParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        Long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
        parameter.setShutsuryokujunId(new RString(出力順ID));
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.再処理);
        } else if (SaiShoriKubun.空白.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.空白);
        }
        return ResponseData.of(parameter).respond();
    }

    /**
     * csv対象存在チェックのメソッドます。
     *
     * @param div TsuchishoJoho111Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho111Div> onClick_beforCheck(TsuchishoJoho111Div div) {
        List<RString> 処理対象情報 = div.getCcdKokurenJohoTorikomi().get処理対象情報();
        if (処理対象情報 == null || 処理対象情報.isEmpty()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.対象ファイルが存在しない, 対象ファイル.toString())));
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
