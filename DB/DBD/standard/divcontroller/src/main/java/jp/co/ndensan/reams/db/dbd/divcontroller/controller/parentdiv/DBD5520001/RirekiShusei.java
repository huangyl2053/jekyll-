/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5520001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.rirekishusei.RirekiShuseiBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.rirekishusei.RirekiShuseiUpdBusiness;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5520001.DBD5520001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5520001.RirekiShuseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5520001.dgRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5520001.RirekiShuseiHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5520001.RirekiShuseiValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.rirekishusei.RirekiShuseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoHokensha;
import jp.co.ndensan.reams.db.dbz.business.core.rirekishusei.RirekiShuseiDataPass;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoHokenshaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 特殊修正のコントローラです。
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
public class RirekiShusei {

    private final RirekiShuseiManager manager;
    private final KaigoHokenshaManager dbt7050Manager;

    private static final int ZERO_5 = 5;
    private static final RString BTN_UPDATE = new RString("btnUpdate");
    private static final RString KU_BUN_回 = new RString("回");
    private static final RString KU_BUN_修 = new RString("修");
    private static final RString KU_BUN_削 = new RString("削");
    private static final RString KU_BUN_追 = new RString("追");
    private static final RString KU_BUN_直 = new RString("直");
    private static final RString SAKUJO_KUBUN = new RString("0");
    private static final RString MSG_履歴修正 = new RString("履歴修正");

    /**
     * コンストラクタです。
     *
     */
    public RirekiShusei() {
        this.manager = RirekiShuseiManager.createInstance();
        this.dbt7050Manager = KaigoHokenshaManager.createInstance();
    }

    /**
     * 特殊修正初期化処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onLoad(RirekiShuseiDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShichosonSecurityJoho shichosonSecurity = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 介護導入形態 = RString.EMPTY;
        if (DonyuKeitaiCode.認定広域.getCode().equals(shichosonSecurity.get導入形態コード().value())) {
            介護導入形態 = HokenshaKosei.広域審査会.getコード();
        }
        if (DonyuKeitaiCode.認定単一.getCode().equals(shichosonSecurity.get導入形態コード().value())) {
            介護導入形態 = HokenshaKosei.単一市町村.getコード();
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_UPDATE, true);
        div.getBtnBeforeRirekiTsuika().setDisabled(true);
        div.getBtnAfterRirekiTsuika().setDisabled(true);
        div.setHdnSubGyomuCode(SubGyomuCode.DBD介護受給.value());
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (key.get被保険者番号() != null) {
            List<RirekiShuseiBusiness> rstList = manager.getDataForLoad(key.get被保険者番号().value()).records();
            validationMessages.add(getValidationHandler(div).データが存在しない(rstList));
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            getHandler(div).load(rstList, 介護導入形態, key);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタンに、履歴修正ダイアログを開くの時、画面の処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onBefore_shusei(RirekiShuseiDiv div) {
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        if (RString.isNullOrEmpty(row.getDeserializedBusiness())) {
            div.setHdnReceiveSerializeBusiness(row.getDataPass());
        } else {
            RirekiShuseiBusiness business = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
            div.setHdnReceiveSerializeBusiness(DataPassingConverter.serialize(business.get履歴修正情報()));
        }
        setHdnItem(div.getDgRirekiIchiran().getDataSource().indexOf(row), div);
        div.setHdnDeleteKey(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタンに、履歴修正ダイアログを開くの時、画面の処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onOkClose_shusei(RirekiShuseiDiv div) {
        RirekiShuseiDataPass business
                = DataPassingConverter.deserialize(div.getHdnReceiveSerializeBusiness(), RirekiShuseiDataPass.class);
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        row.setDataPass(DataPassingConverter.serialize(business));
        if (!KU_BUN_追.equals(row.getKubun())) {
            row.setKubun(KU_BUN_修);
        }
        row = getHandler(div).setデータグリッド状態(row);
        row = getHandler(div).setRowByDialog(business, row);
        div.getDgRirekiIchiran().getDataSource().set(div.getDgRirekiIchiran().getDataSource().indexOf(row), row);
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタンに、履歴修正ダイアログを開くの時、画面の処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onBefore_sakujo(RirekiShuseiDiv div) {
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        if (RString.isNullOrEmpty(row.getDeserializedBusiness())) {
            div.setHdnReceiveSerializeBusiness(row.getDataPass());
        } else {
            RirekiShuseiBusiness business = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
            div.setHdnReceiveSerializeBusiness(DataPassingConverter.serialize(business.get履歴修正情報()));
        }
        setHdnItem(div.getDgRirekiIchiran().getDataSource().indexOf(row), div);
        div.setHdnDeleteKey(div.getDgRirekiIchiran().getClickedItem().getShinseishoKanriNo());
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタンに、履歴修正ダイアログを開くの時、画面の処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onOkClose_sakujo(RirekiShuseiDiv div) {
        RirekiShuseiDataPass business
                = DataPassingConverter.deserialize(div.getHdnReceiveSerializeBusiness(), RirekiShuseiDataPass.class);
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        row.setDataPass(DataPassingConverter.serialize(business));
        if (KU_BUN_追.equals(row.getKubun())) {
            row.getTsuikaKubun().setValue(true);
        }
        row.setKubun(KU_BUN_削);
        row = getHandler(div).setデータグリッド状態(row);
        div.getDgRirekiIchiran().getDataSource().set(div.getDgRirekiIchiran().getDataSource().indexOf(row), row);
        return ResponseData.of(div).respond();
    }

    /**
     * 前に追加するに、履歴修正ダイアログを開くの時、画面の処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onBefore_btnBeforeRirekiTsuika(RirekiShuseiDiv div) {
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        if (RString.isNullOrEmpty(row.getDeserializedBusiness())) {
            div.setHdnReceiveSerializeBusiness(row.getDataPass());
        } else {
            RirekiShuseiBusiness business = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
            div.setHdnReceiveSerializeBusiness(DataPassingConverter.serialize(business.get履歴修正情報()));
        }
        setHdnItem(div.getDgRirekiIchiran().getDataSource().indexOf(row), div);
        div.setHdnDeleteKey(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 後に追加するに、履歴修正ダイアログを開くの時、画面の処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onBefore_btnAfterRirekiTsuika(RirekiShuseiDiv div) {
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        if (RString.isNullOrEmpty(row.getDeserializedBusiness())) {
            div.setHdnReceiveSerializeBusiness(row.getDataPass());
        } else {
            RirekiShuseiBusiness business = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
            div.setHdnReceiveSerializeBusiness(DataPassingConverter.serialize(business.get履歴修正情報()));
        }
        setHdnItem(div.getDgRirekiIchiran().getDataSource().indexOf(row), div);
        div.setHdnDeleteKey(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 前に追加するに、履歴修正ダイアログを閉じるの時、画面の処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onOkClose_btnBeforeRirekiTsuika(RirekiShuseiDiv div) {
        RirekiShuseiDataPass business
                = DataPassingConverter.deserialize(div.getHdnReceiveSerializeBusiness(), RirekiShuseiDataPass.class);
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        int rowId = div.getDgRirekiIchiran().getDataSource().indexOf(row);
        dgRirekiIchiran_Row addRow = getHandler(div).getRowByDialog(business);
        if (KU_BUN_追.equals(row.getKubun())) {
            addRow.setRirekiNo(row.getRirekiNo());
        } else {
            RirekiShuseiBusiness rirekiShusei
                    = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
            addRow.setRirekiNo(rirekiShusei.get受給者台帳().get履歴番号());
        }
        div.getDgRirekiIchiran().getDataSource().add(rowId, addRow);
        set申請履歴情報For履歴追加(addRow, row, true, div);
        set受給者台帳For履歴追加Upd(rowId, div.getDgRirekiIchiran().getDataSource());
        return ResponseData.of(div).respond();
    }

    /**
     * 後に追加するに、履歴修正ダイアログを閉じるの時、画面の処理です。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onOkClose_btnAfterRirekiTsuika(RirekiShuseiDiv div) {
        RirekiShuseiDataPass business
                = DataPassingConverter.deserialize(div.getHdnReceiveSerializeBusiness(), RirekiShuseiDataPass.class);
        dgRirekiIchiran_Row addRow = getHandler(div).getRowByDialog(business);
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        int rowId = div.getDgRirekiIchiran().getDataSource().indexOf(row);
        if (KU_BUN_追.equals(row.getKubun())) {
            addRow.setRirekiNo(row.getRirekiNo());
        } else {
            RirekiShuseiBusiness rirekiShusei
                    = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
            addRow.setRirekiNo(rirekiShusei.get受給者台帳().get履歴番号());
        }
        div.getDgRirekiIchiran().getDataSource().add(rowId + 1, addRow);
        set申請履歴情報For履歴追加(addRow, row, false, div);
        set受給者台帳For履歴追加Upd(rowId, div.getDgRirekiIchiran().getDataSource());
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴一覧選択ボタンをクリックの場合、選択した行の上と下にセットされています。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onSelectBySelectButton_dgRirekiIchiran(RirekiShuseiDiv div) {
        dgRirekiIchiran_Row row = getHandler(div).setデータグリッド状態(div.getDgRirekiIchiran().getSelectedItems().get(0));
        if (KU_BUN_追.equals(row.getKubun())) {
            div.setHdnReceiveSerializeBusiness(row.getDataPass());
        } else {
            RirekiShuseiBusiness business = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
            div.setHdnReceiveSerializeBusiness(DataPassingConverter.serialize(business.get履歴修正情報()));
        }
        div.getDgRirekiIchiran().getDataSource().set(div.getDgRirekiIchiran().getDataSource().indexOf(row), row);
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴一覧回復ボタンをクリックの場合、選択行のデータの論理削除をfalseにする。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onClick_kaihuku(RirekiShuseiDiv div) {
        dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getSelectedItems().get(0);
        if (div.getDgRirekiIchiran().getClickedItem().getTsuikaKubun().isValue()) {
            div.getDgRirekiIchiran().getClickedItem().setKubun(KU_BUN_追);
        } else if (!SAKUJO_KUBUN.equals(div.getDgRirekiIchiran().getClickedItem().getMaeGoKubun())) {
            div.getDgRirekiIchiran().getClickedItem().setKubun(RString.EMPTY);
        } else {
            div.getDgRirekiIchiran().getClickedItem().setKubun(KU_BUN_回);
        }
        div.getDgRirekiIchiran().getDataSource().set(div.getDgRirekiIchiran().getDataSource().indexOf(row),
                getHandler(div).setデータグリッド状態(row));
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧に戻るをクリックの場合、対象者検索へ遷移する
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onClick_btnBackToIchiran(RirekiShuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            boolean hasFlag = false;
            for (dgRirekiIchiran_Row row : div.getDgRirekiIchiran().getDataSource()) {
                if (!RString.isNullOrEmpty(row.getKubun()) && !KU_BUN_直.equals(row.getKubun())) {
                    hasFlag = true;
                    break;
                }
            }
            if (hasFlag) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBD5520001TransitionEventName.対象者一覧へ戻る).respond();
    }

    /**
     * 保存ボタンをクリックの場合、履歴一覧の情報をDBに登録する。
     *
     * @param div 特殊修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onClick_btnUpdate(RirekiShuseiDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(UrInformationMessages.正常終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).forwardWithEventName(DBD5520001TransitionEventName.完了).respond();
        }
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        for (dgRirekiIchiran_Row row : div.getDgRirekiIchiran().getDataSource()) {
            if (KU_BUN_追.equals(row.getKubun()) || row.getTsuikaKubun().isValue()) {
                validationMessages.add(getValidationHandler(div).重複チェック(row));
            }
            if (validationMessages.iterator().hasNext()) {
                break;
            }
        }
        validationMessages.add(getValidationHandler(div).変更レコード無しチェック());
        validationMessages.add(getValidationHandler(div).申請中のデータが存在());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        List<RirekiShuseiUpdBusiness> updDataList = new ArrayList<>();
        for (dgRirekiIchiran_Row row : div.getDgRirekiIchiran().getDataSource()) {
            dgRirekiIchiran_Row previousRow = getHandler(div).getPreviousRow(div.getDgRirekiIchiran().getDataSource().indexOf(row));
            dgRirekiIchiran_Row nextRow = getHandler(div).getNextRow(div.getDgRirekiIchiran().getDataSource().indexOf(row));
            DbT4121ShinseiRirekiJoho 申請履歴情報 = DataPassingConverter.deserialize(row.getShinseirirekiJoho(), DbT4121ShinseiRirekiJoho.class);
            ShinseishoKanriNo 申請書管理番号 = 申請履歴情報.get申請管理番号();
            RirekiShuseiUpdBusiness updData = new RirekiShuseiUpdBusiness();
            if (KU_BUN_追.equals(row.getKubun()) || row.getTsuikaKubun().isValue()) {
                updData.set受給者台帳(getHandler(div).set受給者台帳For履歴追加(申請書管理番号, row));
                updData.set要介護認定申請情報(getHandler(div).set認定申請For履歴追加(申請書管理番号, row));
                if (!row.getTsuikaKubun().isValue()) {
                    updData.set申請履歴情報更新行(申請履歴情報);
                }
                updData.set認定調査依頼情報(getHandler(div).set調査依頼情報For履歴追加(申請書管理番号, row));
                updData.set認定調査票_概況調査(getHandler(div).set認定調査票For履歴追加(申請書管理番号, row));
                updData.set主治医意見書作成依頼情報(getHandler(div).set主治医意見書作成依頼情報For履歴追加(申請書管理番号, row));
                updData.set要介護認定主治医意見書情報(getHandler(div).set主治医意見書情報For履歴追加(申請書管理番号, row));
                updData.set要介護認定一次判定結果情報(getHandler(div).set一次判定結果For履歴追加(申請書管理番号, row));
                updData.set要介護認定結果情報(getHandler(div).set要介護認定結果情報For履歴追加(申請書管理番号, row));
                updData.set申請届出情報(getHandler(div).set申請届出情報For履歴追加(申請書管理番号, row));
                updData.set要介護認定計画情報(getHandler(div).set認定計画情報For履歴追加(申請書管理番号));
            } else if (KU_BUN_回.equals(row.getKubun())) {
                updData.set受給者台帳(getHandler(div).set受給者台帳For削除回復(row));
                updData.set要介護認定申請情報(getHandler(div).set認定申請For削除回復(row, previousRow));
                updData.set要介護認定申請情報次回行(getHandler(div).set認定申請For削除回復次回行(row, nextRow));
                updData.set申請履歴情報更新行(getHandler(div).set申請履歴情報For削除回復前回(row, previousRow));
                updData.set申請履歴情報次回行(getHandler(div).set申請履歴情報For削除回復次回(row, nextRow));
            } else if (KU_BUN_削.equals(row.getKubun()) && !row.getTsuikaKubun().isValue()) {
                updData.set受給者台帳(getHandler(div).set受給者台帳For履歴削除(row));
                updData.set要介護認定申請情報(getHandler(div).set認定申請For履歴削除(row));
                if (!SAKUJO_KUBUN.equals(row.getMaeGoKubun())) {
                    updData.set申請履歴情報更新行(getHandler(div).set申請履歴情報For履歴削除(previousRow, nextRow));
                    updData.set申請履歴情報次回行(申請履歴情報);
                }
            } else if (KU_BUN_修.equals(row.getKubun())) {
                updData.set受給者台帳(getHandler(div).set受給者台帳For履歴修正(row));
                updData.set要介護認定申請情報(getHandler(div).set認定申請For履歴修正(row));
                updData.set認定調査依頼情報(getHandler(div).set調査依頼情報For履歴修正(row));
                updData.set認定調査票_概況調査(getHandler(div).set認定調査票For履歴修正(row));
                updData.set主治医意見書作成依頼情報(getHandler(div).set主治医意見書作成依頼情報For履歴修正(row));
                updData.set要介護認定主治医意見書情報(getHandler(div).set主治医意見書情報For履歴修正(row));
                updData.set要介護認定一次判定結果情報(getHandler(div).set一次判定結果For履歴修正(row));
                updData.set要介護認定結果情報(getHandler(div).set要介護認定結果情報For履歴修正(row));
                updData.set申請届出情報(getHandler(div).set申請届出情報For履歴修正(row));
                updData.set要介護認定計画情報(getHandler(div).set認定計画情報For履歴修正(row));
            }
            updData.setKubun(row.getKubun());
            updData.setTsuikaKubun(row.getTsuikaKubun().isValue());
            updData.setMaeGoKubun(row.getMaeGoKubun());
            updDataList.add(updData);
        }
        manager.save受給履歴(updDataList, set認定申請For履歴追加Upd(div.getDgRirekiIchiran().getDataSource()));
        return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(MSG_履歴修正.toString())).respond();
    }

    private RirekiShuseiHandler getHandler(RirekiShuseiDiv div) {
        return new RirekiShuseiHandler(div);
    }

    private RirekiShuseiValidationHandler getValidationHandler(RirekiShuseiDiv div) {
        return new RirekiShuseiValidationHandler(div);
    }

    private void setHdnItem(int rowId, RirekiShuseiDiv div) {
        dgRirekiIchiran_Row previousRow = getHandler(div).getPreviousRow(rowId);
        if (previousRow != null) {
            if (RString.isNullOrEmpty(previousRow.getDeserializedBusiness())) {
                div.setHdnZenkaiSerializeBusiness(previousRow.getDataPass());
            } else {
                RirekiShuseiBusiness business = DataPassingConverter.deserialize(previousRow.getDeserializedBusiness(), RirekiShuseiBusiness.class);
                div.setHdnZenkaiSerializeBusiness(DataPassingConverter.serialize(business.get履歴修正情報()));
            }
        }
        dgRirekiIchiran_Row nextRow = getHandler(div).getNextRow(rowId);
        if (nextRow != null) {
            if (RString.isNullOrEmpty(nextRow.getDeserializedBusiness())) {
                div.setHdnZenkaiSerializeBusiness(nextRow.getDataPass());
            } else {
                RirekiShuseiBusiness business = DataPassingConverter.deserialize(nextRow.getDeserializedBusiness(), RirekiShuseiBusiness.class);
                div.setHdnJikaiSerializeBusiness(DataPassingConverter.serialize(business.get履歴修正情報()));
            }
        }
    }

    private ShinseishoKanriNo get申請書管理番号(RString hookenshaCode) {
        KaigoHokensha hokensha = dbt7050Manager.get介護保険者By広域保険者番号(new ShoKisaiHokenshaNo(hookenshaCode));
        RString 連番 = Saiban.get(SubGyomuCode.DBZ介護共通, SaibanHanyokeyName.市町村コード_西暦_月.getコード()).nextString();
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(hokensha.get広域保険者市町村コード().value());
        rsb.append(RDate.getNowDate().getYearMonth().toDateString());
        rsb.append(連番.padZeroToLeft(ZERO_5));
        return new ShinseishoKanriNo(rsb.toRString());
    }

    private void set受給者台帳For履歴追加Upd(int rowId, List<dgRirekiIchiran_Row> rowList) {
        for (rowId = rowId + 1; rowId < rowList.size(); rowId++) {
            dgRirekiIchiran_Row row = rowList.get(rowId);
            if (RString.isNullOrEmpty(row.getDeserializedBusiness())) {
                row.setRirekiNo(set履歴番号(row.getRirekiNo()));
            } else {
                RirekiShuseiBusiness rirekiShusei
                        = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
                row.setRirekiNo(set履歴番号(rirekiShusei.get受給者台帳().get履歴番号()));
            }
        }
    }

    private void set申請履歴情報For履歴追加(dgRirekiIchiran_Row addRow, dgRirekiIchiran_Row selRow, boolean flag, RirekiShuseiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = get申請書管理番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        DbT4121ShinseiRirekiJoho 選択行申請履歴情報 = DataPassingConverter.deserialize(selRow.getShinseirirekiJoho(), DbT4121ShinseiRirekiJoho.class);
        DbT4121ShinseiRirekiJoho 申請履歴情報 = new DbT4121ShinseiRirekiJoho(申請書管理番号);
        DbT4121ShinseiRirekiJohoBuilder builder = 申請履歴情報.createBuilderForEdit();
        if (flag) {
            DbT4121ShinseiRirekiJohoBuilder beBuilder = 選択行申請履歴情報.createBuilderForEdit();
            builder.set前回申請管理番号(選択行申請履歴情報.get前回申請管理番号());
            beBuilder.set前回申請管理番号(申請書管理番号);
            addRow.setShinseirirekiJoho(DataPassingConverter.serialize(builder.build()));
            if (KU_BUN_追.equals(selRow.getKubun())) {
                selRow.setShinseirirekiJoho(DataPassingConverter.serialize(beBuilder.build()));
            } else {
                selRow.setShinseirirekiJoho(DataPassingConverter.serialize(beBuilder.build().modifiedModel()));
            }
        } else {
            builder.set前回申請管理番号(選択行申請履歴情報.get申請管理番号());
            addRow.setShinseirirekiJoho(DataPassingConverter.serialize(builder.build()));
            for (dgRirekiIchiran_Row row : div.getDgRirekiIchiran().getDataSource()) {
                if (set次の申請履歴情報(row, 選択行申請履歴情報, selRow, 申請書管理番号)) {
                    break;
                }
            }
        }
    }

    private boolean set次の申請履歴情報(dgRirekiIchiran_Row row, DbT4121ShinseiRirekiJoho 選択行申請履歴情報, dgRirekiIchiran_Row selRow, ShinseishoKanriNo 申請書管理番号) {
        DbT4121ShinseiRirekiJoho 次の申請履歴情報 = DataPassingConverter.deserialize(row.getShinseirirekiJoho(), DbT4121ShinseiRirekiJoho.class);
        if (選択行申請履歴情報.get申請管理番号().equals(次の申請履歴情報.get前回申請管理番号())) {
            DbT4121ShinseiRirekiJohoBuilder beBuilder = 次の申請履歴情報.createBuilderForEdit();
            beBuilder.set前回申請管理番号(申請書管理番号);
            if (KU_BUN_追.equals(selRow.getKubun())) {
                row.setShinseirirekiJoho(DataPassingConverter.serialize(beBuilder.build()));
            } else {
                row.setShinseirirekiJoho(DataPassingConverter.serialize(beBuilder.build().modifiedModel()));
            }
            return true;
        }
        return false;
    }

    private RString set履歴番号(RString 履歴番号) {
        if (!RString.isNullOrEmpty(履歴番号)) {
            return new RString(Integer.parseInt(履歴番号.toString()) + 1);
        }
        return RString.EMPTY;
    }

    private List<ShinseishoKanriNo> set認定申請For履歴追加Upd(List<dgRirekiIchiran_Row> rowList) {
        boolean flag = false;
        List<ShinseishoKanriNo> retList = new ArrayList<>();
        for (dgRirekiIchiran_Row row : rowList) {
            if (KU_BUN_追.equals(row.getKubun()) || row.getTsuikaKubun().isValue()) {
                flag = true;
            }
            if (flag && !KU_BUN_回.equals(row.getKubun()) && !KU_BUN_追.equals(row.getKubun()) && !row.getTsuikaKubun().isValue()) {
                RirekiShuseiBusiness business
                        = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
                retList.add(business.get要介護認定申請情報().get申請書管理番号());
            }
        }
        return retList;
    }
}
