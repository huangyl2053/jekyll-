/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5190001;

import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.Datakubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定申請連携データ作成画面のDivControllerです。
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public class RenkeiDataSakuseiShinseiJoho {

    /**
     * 要介護認定申請連携データ作成画面の初期化。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     * @reamsid_L DBD-1480-010 zhuxiaojun
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> onLoad(RenkeiDataSakuseiShinseiJohoDiv div) {
        Code データ区分 = new Code(Datakubun.申請情報.getコード());
        getHandler(div).get保険者リスト取得(div, データ区分);
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧情報初期化のチェック。 対象者一覧情報初期化
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     * @reamsid_L DBD-1480-010 zhuxiaojun
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> checkInput(RenkeiDataSakuseiShinseiJohoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor保険者の非空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getValidationHandler().validateFor今回開始時間の非空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getValidationHandler().validateFor今回終了時間の非空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getValidationHandler().validateFor対象期間時間チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        RString shoKisaiHokenshaNo = div.getCommonChildDiv1().getSelectedItem().get証記載保険者番号().value();
        RString chushutsujokenselected = div.getChushutsuJoken().getRadChushutsuJoken().getSelectedValue();
        RString 対象期間 = new RString("対象期間");
        RString hihokenshaNo = new RString("");
        if (!chushutsujokenselected.equals(対象期間)) {
            hihokenshaNo = div.getTxtHihokenshaNo().getValue();
        }
        RString saidaikensu = div.getTxtMaxKensu().getText();
        RDate nenngappi = div.getTxtKonkaiKaishiDay().getValue();
        RTime jifunyou = div.getTxtKonkaiKaishiTime().getValue();
        RDate nenngappisyuryo = div.getTxtKonkaiShuryoDay().getValue();
        RTime jifunyousyuryo = div.getTxtKonkaiShuryoTime().getValue();
        RDateTime konkaikaishiTime = RDateTime.of(nenngappi.getYearValue(), nenngappi.getMonthValue(), nenngappi.getDayValue(),
                jifunyou.getHour(), jifunyou.getMinute(), jifunyou.getSecond());
        RDateTime konkaisyuryoTime = RDateTime.of(nenngappisyuryo.getYearValue(), nenngappisyuryo.getMonthValue(),
                nenngappisyuryo.getDayValue(), jifunyousyuryo.getHour(),
                jifunyousyuryo.getMinute(), jifunyousyuryo.getSecond());
        getHandler(div).対象者一覧情報初期化(shoKisaiHokenshaNo, konkaikaishiTime, konkaisyuryoTime, hihokenshaNo, saidaikensu, div);
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号を取り、前の状態に戻します.
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     * @reamsid_L DBD-1480-010 zhuxiaojun
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> onActive(RenkeiDataSakuseiShinseiJohoDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.getTxtHihokenshaNo().setValue(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件入力項目をクリアする
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     * @reamsid_L DBD-1480-010 zhuxiaojun
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> btnJokenClear_onClick(RenkeiDataSakuseiShinseiJohoDiv div) {
        getHandler(div).条件をクリア(div);
        return ResponseData.of(div).respond();
    }

    /**
     * radio保険者番号と対象期間の状態定義
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     * @reamsid_L DBD-1480-010 zhuxiaojun
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> onChangeRadioButton(RenkeiDataSakuseiShinseiJohoDiv div) {
        getHandler(div).checkRadioButton();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行確認ダイアログのチェック事件
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     * @reamsid_L DBD-1480-010 zhuxiaojun
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> validate_check(RenkeiDataSakuseiShinseiJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            getValidationHandler().validateFor被保険者番号の非空チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            getValidationHandler().validateFor対象者一覧選択チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータの設定について
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<DBD519001_NinteishinseiInfoIfParameter>
     * @reamsid_L DBD-1480-010 zhuxiaojun
     */
//    public ResponseData<DBD519001_NinteishinseiInfoIfParameter> batch_paramter(RenkeiDataSakuseiShinseiJohoDiv div) {
//        DBD519001_NinteishinseiInfoIfParameter parameters = new DBD519001_NinteishinseiInfoIfParameter();
//        RDate fromdate = div.getTxtKonkaiKaishiDay().getValue();
//        RDate todate = div.getTxtKonkaiShuryoDay().getValue();
//        RTime fromtime = div.getTxtKonkaiKaishiTime().getValue();
//        RTime totime = div.getTxtKonkaiShuryoTime().getValue();
//        RString insatsukikan = div.getTxtInsatsuDay().getValue();
//        RDateTime konkaikaishiFrom = RDateTime.of(fromdate.getYearValue(), fromdate.getMonthValue(), fromdate.getDayValue(),
//                fromtime.getHour(), fromtime.getMinute(), fromtime.getSecond());
//        RDateTime konkaikaishiTo = RDateTime.of(todate.getYearValue(), todate.getMonthValue(), todate.getDayValue(),
//                totime.getHour(), totime.getMinute(), totime.getSecond());
//        FlexibleDate insatsukikanDate = new FlexibleDate(insatsukikan);
//        parameters.setShokisaihokenshano(div.getCommonChildDiv1().getSelectedItem().get証記載保険者番号().value());
//        parameters.setShichosoncode(div.getCommonChildDiv1().getSelectedItem().get市町村コード());
//        parameters.setHihokenshaNo(new HihokenshaNo(div.getTxtHihokenshaNo().getValue()));
//        parameters.setKonkaikaishikikanfrom(konkaikaishiFrom);
//        parameters.setKonkaikaishikikanto(konkaikaishiTo);
//        parameters.setAtarashifairunamee(div.getTxtNewFileName().getValue());
//        List<HihokenshaNo> hihokenshaNoList = getHandler(div).getHihokenshaNoList(div);
//        parameters.setTaishohihokenshabangoulist(hihokenshaNoList);
//        parameters.setInsatsukikan(insatsukikanDate);
//        return ResponseData.of(parameters).respond();
//    }
    private RenkeiDataSakuseiShinseiJohoHandler getHandler(RenkeiDataSakuseiShinseiJohoDiv div) {
        return new RenkeiDataSakuseiShinseiJohoHandler(div);
    }

    private RenkeiDataSakuseiShinseiJohoValidationHandler getValidationHandler() {
        return new RenkeiDataSakuseiShinseiJohoValidationHandler();
    }

}
