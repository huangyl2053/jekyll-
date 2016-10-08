/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5190001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseijoho.NinteiShinseiJohoBusiness;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519001.DBD519001_NinteishinseiInfoIfParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.Datakubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
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
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> onLoad(RenkeiDataSakuseiShinseiJohoDiv div) {
        Code データ区分 = new Code(Datakubun.申請情報.getコード());
        getHandler(div).get保険者リスト取得(div, データ区分);
        return ResponseData.of(div).respond();
    }

    /**
     * 最大件数のチェック。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> check_Maxkensu(RenkeiDataSakuseiShinseiJohoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor最大件数チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧情報初期化のチェック。 対象者一覧情報初期化。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> checkInput(RenkeiDataSakuseiShinseiJohoDiv div) {
        RString chushutsujokenselected = div.getChushutsuJoken().getRadChushutsuJoken().getSelectedValue();
        RString 対象期間 = new RString("対象期間");
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor保険者の非空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (chushutsujokenselected.equals(対象期間)) {
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
        }
        RString shoKisaiHokenshaNo = div.getCommonChildDiv1().getSelectedItem().get証記載保険者番号().value();

        RString hihokenshaNo = new RString("");
        if (!chushutsujokenselected.equals(対象期間)) {
            hihokenshaNo = div.getTxtHihokenshaNo().getValue();
        }
        RString saidaikensu = div.getTxtMaxKensu().getText();
        RDate nenngappi = RDate.MIN;
        RDate nenngappisyuryo = RDate.MIN;
        RTime jifunyou = RTime.of(0, 0, 0);
        RTime jifunyousyuryo = RTime.of(0, 0, 0);
        if (div.getTxtKonkaiKaishiDay().getValue() != null) {
            nenngappi = div.getTxtKonkaiKaishiDay().getValue();
        }
        if (div.getTxtKonkaiKaishiTime().getValue() != null) {
            jifunyou = div.getTxtKonkaiKaishiTime().getValue();
        }
        if (div.getTxtKonkaiShuryoDay().getValue() != null) {
            nenngappisyuryo = div.getTxtKonkaiShuryoDay().getValue();
        }
        if (div.getTxtKonkaiShuryoTime().getValue() != null) {
            jifunyousyuryo = div.getTxtKonkaiShuryoTime().getValue();
        }
        RDateTime konkaikaishiTime = RDateTime.of(nenngappi.getYearValue(), nenngappi.getMonthValue(), nenngappi.getDayValue(),
                jifunyou.getHour(), jifunyou.getMinute(), jifunyou.getSecond());
        RDateTime konkaisyuryoTime = RDateTime.of(nenngappisyuryo.getYearValue(), nenngappisyuryo.getMonthValue(),
                nenngappisyuryo.getDayValue(), jifunyousyuryo.getHour(),
                jifunyousyuryo.getMinute(), jifunyousyuryo.getSecond());
        List<NinteiShinseiJohoBusiness> ninteiShinseiJohos = getHandler(div).getNinteishinseijohos(shoKisaiHokenshaNo, konkaikaishiTime,
                konkaisyuryoTime, hihokenshaNo, saidaikensu);
        if (ninteiShinseiJohos == null || ninteiShinseiJohos.isEmpty()) {
            div.getDgTaishoshaIchiran().getDataSource().clear();
            div.getTaishoshaIchiran().setIsOpen(false);
            getValidationHandler().validateForデータない(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return getHandler(div).対象者一覧情報初期化(shoKisaiHokenshaNo, konkaikaishiTime, konkaisyuryoTime, hihokenshaNo, saidaikensu, div);
    }

    /**
     * 被保険者番号を取り、前の状態に戻します。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> onActive(RenkeiDataSakuseiShinseiJohoDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.getTxtHihokenshaNo().setValue(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件入力項目をクリアする。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> btnJokenClear_onClick(RenkeiDataSakuseiShinseiJohoDiv div) {
        getHandler(div).条件をクリア(div);
        return ResponseData.of(div).respond();
    }

    /**
     * radio保険者番号と対象期間の状態定義。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> onChangeRadioButton(RenkeiDataSakuseiShinseiJohoDiv div) {
        getHandler(div).checkRadioButton();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行確認ダイアログのチェック事件。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> validate_check(RenkeiDataSakuseiShinseiJohoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor被保険者番号の非空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getValidationHandler().validateFor対象者一覧選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータの設定について。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return ResponseData<DBD519001_NinteishinseiInfoIfParameter>
     */
    public ResponseData<DBD519001_NinteishinseiInfoIfParameter> onClick_btnBatch(RenkeiDataSakuseiShinseiJohoDiv div) {
        DBD519001_NinteishinseiInfoIfParameter parameter = getHandler(div).batchParameterSave();
        return ResponseData.of(parameter).respond();
    }

    private RenkeiDataSakuseiShinseiJohoHandler getHandler(RenkeiDataSakuseiShinseiJohoDiv div) {
        return new RenkeiDataSakuseiShinseiJohoHandler(div);
    }

    private RenkeiDataSakuseiShinseiJohoValidationHandler getValidationHandler() {
        return new RenkeiDataSakuseiShinseiJohoValidationHandler();
    }

}
