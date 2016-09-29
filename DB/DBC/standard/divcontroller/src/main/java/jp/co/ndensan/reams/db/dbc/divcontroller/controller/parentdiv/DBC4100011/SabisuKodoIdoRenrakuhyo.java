/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4100011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170010.DBC170010_ServicecodeIdoRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceCodeIdoRenrakuhyo_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4100011.SabisuKodoIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4100011.ShoriNaiyoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * SabisuKodoIdoRenrakuhyo_サービスコード異動連絡票作成のcontrollerクラスです。
 *
 * @reamsid_L DBC-4740-010 liuxiaoyu
 */
public class SabisuKodoIdoRenrakuhyo {

    private static final RString KEY0 = new RString("key0");
    private static final RString チェックあり = new RString("1");
    private static final RString チェックなし = new RString("0");

    /**
     * 画面初期化
     *
     * @param div 画面div
     *
     * @return ResponseData<SabisuKodoIdoRenrakuhyoDiv>
     */
    public ResponseData<SabisuKodoIdoRenrakuhyoDiv> onLoad(SabisuKodoIdoRenrakuhyoDiv div) {
        ShoriNaiyoDiv shoriNaiyoDiv = div.getShoriNaiyo();
        shoriNaiyoDiv.getRadShoriSentaku().setSelectedKey(ServiceCodeIdoRenrakuhyo_ShoriKubun.本番処理.getコード());
        RString ファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_サービスコード異動連絡票Ｆ_外部ＣＳＶファイル名,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        shoriNaiyoDiv.getTxtFuairuMei().setValue(ファイル名);
        shoriNaiyoDiv.getTxtShoriTaishoNengetsu().setValue(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下,実行確認メッセージ。
     *
     * @param div 画面div
     *
     * @return ResponseData<SabisuKodoIdoRenrakuhyoDiv>
     */
    public ResponseData<SabisuKodoIdoRenrakuhyoDiv> onClick_checkMessage(SabisuKodoIdoRenrakuhyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage 確認MESSAGE = new QuestionMessage(
                    UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(確認MESSAGE).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下する。
     *
     * @param div 画面div
     *
     * @return ResponseData<DBC170010_ServicecodeIdoRenrakuhyoOutParameter>
     */
    public ResponseData<DBC170010_ServicecodeIdoRenrakuhyoOutParameter> onClick_btnExecute(SabisuKodoIdoRenrakuhyoDiv div) {
        ShoriNaiyoDiv shoriNaiyoDiv = div.getShoriNaiyo();
        DBC170010_ServicecodeIdoRenrakuhyoOutParameter parameter = new DBC170010_ServicecodeIdoRenrakuhyoOutParameter();
        parameter.set処理年月(shoriNaiyoDiv.getTxtShoriTaishoNengetsu().getValue().getYearMonth());
        if (shoriNaiyoDiv.getChkTogetsuSofuZumiFukumeru().getSelectedKeys().contains(KEY0)) {
            parameter.set出力対象区分(チェックあり);
        } else {
            parameter.set出力対象区分(チェックなし);
        }
        parameter.set処理選択区分(shoriNaiyoDiv.getRadShoriSentaku().getSelectedKey());
        return ResponseData.of(parameter).respond();
    }
}
