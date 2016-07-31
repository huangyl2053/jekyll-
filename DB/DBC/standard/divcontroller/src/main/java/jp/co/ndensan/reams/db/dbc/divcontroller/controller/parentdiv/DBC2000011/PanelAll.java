/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000011.PanelAllDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogButtonType;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 年次利用者負担割合判定です。
 *
 * @reamsid_L DBC-4980-010 lihang
 */
public class PanelAll {

    private static final RString 処理済 = new RString("処理済");
    private static final RString 再処理前 = new RString("再処理前");
    private static final RString 未処理 = new RString("未処理");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    /**
     * 画面の初期化です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<PanelAllDiv> onLoad(PanelAllDiv div) {

        RYear 年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課).toString());
        div.getTxtNendo().setValue(new RDate(年度.toString()));

        RYear 年次負担割合処理済年度 = new RYear(DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理済年度, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付));
        RString 処理状態 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理状態, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        if (年次負担割合処理済年度.equals(年度)) {
            if (ONE.equals(処理状態)) {
                div.getTxtShoriJotai().setValue(処理済);
            }
            if (TWO.equals(処理状態)) {
                div.getTxtShoriJotai().setValue(再処理前);
            }
        } else {
            div.getTxtShoriJotai().setValue(未処理);
        }
        RString 月日 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        RString 基準日 = (年度.toDateString()).concat(月日);
        div.getTxtKijunbi().setValue(new RDate(基準日.toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_beforeBatch
     *
     * @param div PanelAllDiv
     * @return ResponseData
     */
    public ResponseData<PanelAllDiv> onClick_beforeBatch(PanelAllDiv div) {
        RString 処理状態 = div.getTxtShoriJotai().getValue();
        if (処理状態.equals(未処理) && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            message.setInitialFocusButton(MessageDialogButtonType.Yes);
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (処理状態.equals(再処理前) && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbcQuestionMessages.年次負担割合再処理.getMessage().getCode(),
                    DbcQuestionMessages.年次負担割合再処理.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbcQuestionMessages.年次負担割合再処理.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            message.setInitialFocusButton(MessageDialogButtonType.Yes);
            return ResponseData.of(div).addMessage(message).respond();

        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンを押下します。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<NenjiRiyoshaFutanwariaiHanteiParameter> onClick_Batch(PanelAllDiv div) {
        NenjiRiyoshaFutanwariaiHanteiParameter parameter = new NenjiRiyoshaFutanwariaiHanteiParameter();
        RYear 年 = div.getTxtNendo().getValue().getYear().plusYear(1);
        RString 月日 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        parameter.set対象年度(new FlexibleYear(div.getTxtNendo().getValue().getYear().toDateString()));
        parameter.set処理区分(SaiShoriKubun.toValue(ONE));
        parameter.set処理日時(FlexibleDate.getNowDate());
        parameter.set基準日(new FlexibleDate(div.getTxtKijunbi().getValue().plusDay(1).toDateString()));
        parameter.set年度終了年月日(new FlexibleDate((年.toDateString()).concat(月日)));
        parameter.set処理状態(new RString(div.getTxtShoriJotai().getValue().toString()));
        parameter.setテストモード(false);
        return ResponseData.of(parameter).respond();
    }
}
