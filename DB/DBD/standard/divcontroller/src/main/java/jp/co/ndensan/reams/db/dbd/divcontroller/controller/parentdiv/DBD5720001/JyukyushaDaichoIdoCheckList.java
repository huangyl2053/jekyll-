/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5720001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5720001.JyukyushaDaichoIdoCheckListParameter;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5720001.JyukyushaDaichoIdoCheckListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5720001.JyukyushaDaichoIdoCheckListHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 受給者台帳異動チェックリスト画面のDivControllerです。
 *
 * @reamsid_L DBD-1770-010 donghj
 */
public class JyukyushaDaichoIdoCheckList {

    /**
     * 画面初期化
     *
     * @param div JyukyushaDaichoIdoCheckListDiv
     * @return ResponseData<JyukyushaDaichoIdoCheckListDiv>
     */
    public ResponseData<JyukyushaDaichoIdoCheckListDiv> onLoad(JyukyushaDaichoIdoCheckListDiv div) {
        JyukyushaDaichoIdoCheckListHandler handler = getHandler(div);
        handler.onLoad();
        return ResponseData.of(div).respond();

    }

    /**
     * 「実行する」を押下する。
     *
     * @param div JyukyushaDaichoIdoCheckListDiv
     * @return ResponseData<JyukyushaDaichoIdoCheckListDiv>
     */
    public ResponseData<JyukyushaDaichoIdoCheckListDiv> onClick_brforeBtnJiko(JyukyushaDaichoIdoCheckListDiv div) {
        RDate 今回抽出開始年月日 = div.getJhokenPancel().getTxtRangeKonkai().getFromDateValue();
        RDate 今回抽出終了年月日 = div.getJhokenPancel().getTxtRangeKonkai().getToDateValue();
        RTime 今回抽出開始時分秒 = div.getJhokenPancel().getTxtRangeKonkai().getFromTimeValue();
        RTime 今回抽出終了時分秒 = div.getJhokenPancel().getTxtRangeKonkai().getToTimeValue();
        if (今回抽出開始年月日 != null && 今回抽出終了年月日 != null && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (今回抽出開始年月日 == null && 今回抽出終了年月日 != null && !ResponseHolder.isReRequest()) {
            if (今回抽出終了時分秒 != null) {
                Message 以前出力確認 = DbdQuestionMessages.受給者台帳異動チェックリスト_以前出力確認.getMessage().replace(
                        今回抽出終了年月日.toString() + 今回抽出終了時分秒.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
                return ResponseData.of(div).addMessage(以前出力確認).respond();
            } else {
                Message 以前出力確認 = DbdQuestionMessages.受給者台帳異動チェックリスト_以前出力確認.getMessage().
                        replace(今回抽出終了年月日.toString());
                return ResponseData.of(div).addMessage(以前出力確認).respond();
            }

        }
        if (今回抽出開始年月日 != null && 今回抽出終了年月日 == null && !ResponseHolder.isReRequest()) {
            if (今回抽出開始時分秒 != null) {
                Message 以後出力確認 = DbdQuestionMessages.受給者台帳異動チェックリスト_以後出力確認.getMessage().replace(
                        今回抽出開始年月日.toString() + 今回抽出開始時分秒.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
                return ResponseData.of(div).addMessage(以後出力確認).respond();
            } else {
                Message 以後出力確認 = DbdQuestionMessages.受給者台帳異動チェックリスト_以後出力確認.getMessage().
                        replace(今回抽出開始年月日.toString());
                return ResponseData.of(div).addMessage(以後出力確認).respond();
            }

        }
        if (今回抽出開始年月日 == null && 今回抽出終了年月日 == null && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbdQuestionMessages.受給者台帳異動チェックリスト_全件出力確認.getMessage()).respond();
        }
        onClick_btnJiko(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行確認ダイアログYesを実行する。
     *
     * @param div JyukyushaDaichoIdoCheckListDiv
     * @return ResponseData<JyukyushaDaichoIdoCheckListParameter>
     */
    public ResponseData<JyukyushaDaichoIdoCheckListParameter> onClick_btnJiko(JyukyushaDaichoIdoCheckListDiv div) {
        JyukyushaDaichoIdoCheckListParameter parameter = getHandler(div).getParameter();
        return ResponseData.of(parameter).respond();
    }

    private JyukyushaDaichoIdoCheckListHandler getHandler(JyukyushaDaichoIdoCheckListDiv div) {
        return new JyukyushaDaichoIdoCheckListHandler(div);
    }

}
