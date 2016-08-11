/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000011.NenjiRiyoshaFutanWariaiHanteiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogButtonType;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 年次利用者負担割合判定です。
 *
 * @reamsid_L DBC-4980-010 lihang
 */
public class NenjiRiyoshaFutanWariaiHantei {

    private static final RString 処理済 = new RString("処理済");
    private static final RString 再処理前 = new RString("再処理前");
    private static final RString 未処理 = new RString("未処理");
    private static final RString 実行するボタン = new RString("btnBatchRegister");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    /**
     * 画面の初期化です。
     *
     * @param div NenjiRiyoshaFutanWariaiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<NenjiRiyoshaFutanWariaiHanteiDiv> onLoad(NenjiRiyoshaFutanWariaiHanteiDiv div) {
        RDate 現在時刻 = RDate.getNowDate();
        RYear 年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, 現在時刻,
                SubGyomuCode.DBB介護賦課).toString());
        div.getPanelAll().getTxtNendo().setValue(new RDate(年度.toString()));
        // TODO QA 1096 「イベント定義」と「初期取得」の表示の処理 回復待ち  2016/8/01まで
        RYear 年次負担割合処理済年度 = new RYear(DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理済年度, 現在時刻,
                SubGyomuCode.DBC介護給付));
        RString 処理状態 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理状態, 現在時刻,
                SubGyomuCode.DBC介護給付);
        div.getPanelAll().getTxtShoriJotai().setValue(未処理);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(実行するボタン, false);

        if (年次負担割合処理済年度.equals(年度)) {
            if (ONE.equals(処理状態)) {
                div.getPanelAll().getTxtShoriJotai().setValue(処理済);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行するボタン, true);

            } else if (TWO.equals(処理状態)) {
                div.getPanelAll().getTxtShoriJotai().setValue(再処理前);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行するボタン, false);

            }
        }
        RString 月日 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, 現在時刻,
                SubGyomuCode.DBC介護給付);
        RDate 基準 = new RDate(((年度.toDateString()).concat(月日)).toString());
        RDate 基準日 = 基準.plusDay(1);
        div.getPanelAll().getTxtKijunbi().setValue(基準日);

        if ((div.getPanelAll().getTxtShoriJotai().getValue().equals(未処理)) || (div.getPanelAll().getTxtShoriJotai().getValue().equals(処理済))) {
            div.getPanelAll().setDisplayNone(false);
            div.getNenjipnlNote().getLblNote1().setDisplayNone(false);
            div.getNenjipnlNote().getLblNote2().setDisplayNone(true);
            div.getNenjipnlNote().getLblNote3().setDisplayNone(true);
            div.getNenjipnlNote().getLblNote4().setDisplayNone(true);
            div.getNenjipnlNote().getLblNote5().setDisplayNone(true);
        } else if (div.getPanelAll().getTxtShoriJotai().getValue().equals(再処理前)) {
            div.getNenjipnlNote().setDisplayNone(false);
            div.getPanelAll().setDisplayNone(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_beforeBatch
     *
     * @param div NenjiRiyoshaFutanWariaiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<NenjiRiyoshaFutanWariaiHanteiDiv> onClick_beforeBatch(NenjiRiyoshaFutanWariaiHanteiDiv div) {
        RString 処理状態 = div.getPanelAll().getTxtShoriJotai().getValue();
        if (処理状態.equals(未処理) && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            message.setInitialFocusButton(MessageDialogButtonType.Yes);
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (処理状態.equals(再処理前)) {
            QuestionMessage message = new QuestionMessage(DbcQuestionMessages.年次負担割合再処理.getMessage().getCode(),
                    DbcQuestionMessages.年次負担割合再処理.getMessage().replace(div.getPanelAll().getTxtNendo().getValue().getYear().wareki().fillType(FillType.BLANK).getYear().toString()).evaluate());
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
     * @param div NenjiRiyoshaFutanWariaiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<NenjiRiyoshaFutanwariaiHanteiParameter> onClick_Batch(NenjiRiyoshaFutanWariaiHanteiDiv div) {
        NenjiRiyoshaFutanwariaiHanteiParameter parameter = new NenjiRiyoshaFutanwariaiHanteiParameter();
        RYear 年 = div.getPanelAll().getTxtNendo().getValue().getYear().plusYear(1);
        RString 月日 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        parameter.set対象年度(new FlexibleYear(div.getPanelAll().getTxtNendo().getValue().getYear().toDateString()));
        parameter.set処理区分(SaiShoriKubun.toValue(ONE));
        parameter.set処理日時(FlexibleDate.getNowDate());
        parameter.set基準日(new FlexibleDate(div.getPanelAll().getTxtKijunbi().getValue().plusDay(1).toDateString()));
        parameter.set年度終了年月日(new FlexibleDate((年.toDateString()).concat(月日)));
        parameter.set処理状態(new RString(div.getPanelAll().getTxtShoriJotai().getValue().toString()));
        parameter.setテストモード(false);
        return ResponseData.of(parameter).respond();
    }
}
