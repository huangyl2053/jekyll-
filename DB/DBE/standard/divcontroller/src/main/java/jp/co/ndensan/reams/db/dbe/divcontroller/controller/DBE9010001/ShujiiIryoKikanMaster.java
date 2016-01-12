/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBE9010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterCSV;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.DBE9010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.DBE9010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.ShujiiIryoKikanMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9010001.KoseiShujiiIryoKikanMasterHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9010001.KoseiShujiiIryoKikanMasterValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster.KoseiShujiiIryoKikanMasterCsvManager;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster.KoseiShujiiIryoKikanMasterFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster.ShujiiIryoKikanJohoManager;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJohoIdentifier;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 認定調査員マスタ処理のクラスです。
 *
 */
public class ShujiiIryoKikanMaster {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     */
    public ShujiiIryoKikanMaster() {
    }

    /**
     * 画面初期化処理です。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onLoad(ShujiiIryoKikanMasterDiv div) {
        getHandler(div).load();
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * クリアボタン押下で検索条件入力項目をクリアします。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnClearKensakuJoken(ShujiiIryoKikanMasterDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタン押下で検索条件に従い、 主治医医療機関情報を検索します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnSearchKoseiShujiiIryoKikan(ShujiiIryoKikanMasterDiv div) {
        searchKoseiShujiiIryoKikanInfo(div);
        div.getShujiiIchiran().getDgShujiiIchiran().getGridSetting().getColumn("iryoKikanCode").setVisible(false);
        div.getShujiiIchiran().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    private void searchKoseiShujiiIryoKikanInfo(ShujiiIryoKikanMasterDiv div) {
        boolean JokyoFlag = false;
        if (div.getRadSearchJokyoFlag().getSelectedIndex() == 0) {
            JokyoFlag = true;
        }
        KoseiShujiiIryoKikanMasterMapperParameter parameter = KoseiShujiiIryoKikanMasterMapperParameter.createParam_SelectShujiiIryoKikanJohoList(JokyoFlag,
                div.getCcdHokenshaList().getSelectedItem().get市町村コード(),
                div.getTxtSearchShujiiIryokikanCodeFrom().getValue(),
                div.getTxtSearchShujiiIryokikanCodeTo().getValue(),
                div.getTxtSearchShujiiIryokikanMeisho().getValue(),
                div.getTxtSearchShujiiIryokikanKanaMeisho().getValue(),
                div.getTxtSaidaiHyojiKensu().getValue()
        );
        KoseiShujiiIryoKikanMasterFinder koseiShujiiIryoKikanMasterFinder = KoseiShujiiIryoKikanMasterFinder.createInstance();
        List<jp.co.ndensan.reams.db.dbe.business.core.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterBusiness> 主治医医療機関情報List
                = koseiShujiiIryoKikanMasterFinder.getShujiKikanJohoIchiranList(parameter).records();
        if (主治医医療機関情報List.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.主治医医療機関マスタ検索結果, Models.create(new ArrayList<ShujiiIryoKikanJoho>()));
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        getHandler(div).setShujiKikanJohoIchiran(主治医医療機関情報List);
        List<ShujiiIryoKikanJoho> 主治医医療機関マスタList = koseiShujiiIryoKikanMasterFinder.getShujiiIryoKikanJohoList(parameter).records();
        ViewStateHolder.put(ViewStateKeys.主治医医療機関マスタ検索結果, Models.create(主治医医療機関マスタList));
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnInsert(ShujiiIryoKikanMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_追加);
        getHandler(div).setDisabledFalseToShujiiIryoKikanJoho();
        getHandler(div).clearShujiiIryoKikanJohoToMeisai();
        div.getShujiiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 修正アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力可能にします。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onSelectByModifyButton_dgShujiiIchiran(ShujiiIryoKikanMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_修正);
        getHandler(div).setDisabledFalseToShujiiIryoKikanJoho();
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getClickedItem();
        getHandler(div).setShujiiJohoToMeisai(row);
        div.getShujiiJohoInput().getTxtShichoson().setDisabled(true);
        div.getShujiiJohoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getShujiiJohoInput().getTxtShichosonmei().setDisabled(true);
        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
        div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
        div.getShujiiJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 削除アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力不可にします。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onSelectByDeleteButton_dgShujiiIchiran(ShujiiIryoKikanMasterDiv div) {
        div.getShujiiJohoInput().setState(状態_削除);
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        getHandler(div).setShujiiJohoToMeisai(row);
        getHandler(div).setDisabledTrueToShujiiJohoToMeisai();
        div.getShujiiJohoInput().getBtnKakutei().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行の内容を、明細エリアに表示します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onSelectByDlbClick_dgShujiiIchiran(ShujiiIryoKikanMasterDiv div) {
        dgShujiiIchiran_Row row = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow();
        getHandler(div).setShujiiJohoToMeisai(row);
        if (状態_修正.equals(row.getJotai())) {
            div.getShujiiJohoInput().getTxtShichoson().setDisabled(true);
            div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().setDisabled(true);
        } else if (状態_削除.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToShujiiJohoToMeisai();
        } else if (RString.EMPTY.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToShujiiJohoToMeisai();
            div.getShujiiJohoInput().getBtnKakutei().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ＣＳＶを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnOutputCsv(ShujiiIryoKikanMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForOutputCsv();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            KoseiShujiiIryoKikanMasterCsvManager.createInstance().CSVOutput(getCsvData(div));
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.正常終了.getMessage().replace("CSV出力")).respond();
        }
        return ResponseData.of(div).respond();
    }

    private List<KoseiShujiiIryoKikanMasterCSV> getCsvData(ShujiiIryoKikanMasterDiv div) {
        List<KoseiShujiiIryoKikanMasterCSV> list = new ArrayList<>();
        List<dgShujiiIchiran_Row> dataList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        for (dgShujiiIchiran_Row row : dataList) {
            list.add(new KoseiShujiiIryoKikanMasterCSV(
                    row.getShichosonCode(),
                    row.getShichoson(),
                    row.getShujiiIryoKikanCode().getValue(),
                    row.getIryoKikanCode(),
                    row.getShujiiIryoKikan(),
                    row.getShujiiIryoKikankana(),
                    row.getYubinNo(),
                    row.getJusho(),
                    row.getTelNo(),
                    row.getFaxNo(),
                    row.getDaihyosha(),
                    row.getDaihyoshakana(),
                    row.getJokyoFlag()));
        }
        return list;
    }

    /**
     * 市町村名を取得します、入力した市町村コードをキーにして市町村名を取得し、市町村名テキストに名称を表示する。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onBlur_txtShichoson(ShujiiIryoKikanMasterDiv div) {
        getHandler(div).setTxtShichosonmei();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消するボタンが押下された場合、入力明細エリアの入力内容を破棄し、主治医医療機関情報一覧エリアへ戻ります。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnTorikeshi(ShujiiIryoKikanMasterDiv div) {
        if ((状態_追加.equals(div.getShujiiJohoInput().getState())
                || 状態_修正.equals(div.getShujiiJohoInput().getState()))
                && getValidationHandler(div).isUpdate()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getShujiiIchiran().setDisabled(false);
                return ResponseData.of(div).setState(DBE9010001StateName.医療機関一覧);
            }
        }
        div.getShujiiIchiran().setDisabled(false);
        return ResponseData.of(div).setState(DBE9010001StateName.医療機関一覧);
    }

    /**
     * 確定するボタンが押下された場合、入力明細エリアの入力内容を主治医医療機関情報一覧に反映させます。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnKakutei(ShujiiIryoKikanMasterDiv div) {
        RString イベント状態 = div.getShujiiJohoInput().getState();
        int shujiiIryoKikanJohoCount = KoseiShujiiIryoKikanMasterFinder.createInstance().getShujiiIryoKikanJohoCount(
                KoseiShujiiIryoKikanMasterSearchParameter.createParam_SelectShujiiIryoKikanJoho(
                        new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                        div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue()));
        ValidationMessageControlPairs validPairs
                = getValidationHandler(div).validateForKakutei(イベント状態, shujiiIryoKikanJohoCount);

        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        Models<ShujiiIryoKikanJohoIdentifier, ShujiiIryoKikanJoho> models
                = ViewStateHolder.get(ViewStateKeys.主治医医療機関マスタ検索結果, Models.class);
        if (状態_追加.equals(イベント状態)) {
            ShujiiIryoKikanJoho shujiiIryoKikanJoho = new ShujiiIryoKikanJoho(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue());
            shujiiIryoKikanJoho = getHandler(div).editShujiiIryoKikanJoho(shujiiIryoKikanJoho);
            models.add(shujiiIryoKikanJoho);
        } else if (状態_修正.equals(イベント状態)) {
            ShujiiIryoKikanJohoIdentifier key = new ShujiiIryoKikanJohoIdentifier(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue());
            ShujiiIryoKikanJoho shujiiIryoKikanJoho = getHandler(div).editShujiiIryoKikanJoho(models.get(key).modifiedModel());
            models.deleteOrRemove(key);
            models.add(shujiiIryoKikanJoho);
        } else if (状態_削除.equals(イベント状態)) {
            ShujiiIryoKikanJohoIdentifier key = new ShujiiIryoKikanJohoIdentifier(
                    new LasdecCode(div.getShujiiJohoInput().getTxtShichoson().getValue()),
                    div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue());

            RString jotai = div.getShujiiIchiran().getDgShujiiIchiran().getActiveRow().getJotai();
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                ShujiiIryoKikanJoho shujiiIryoKikanJoho = getHandler(div).editShujiiIryoKikanJoho(models.get(key).deleted());
                models.add(shujiiIryoKikanJoho);
            }
        }
        ViewStateHolder.put(ViewStateKeys.主治医医療機関マスタ検索結果, models);
        div.getShujiiIchiran().setDisabled(false);
        getHandler(div).setShujiiIryoKikanJohoToIchiran(イベント状態);
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタン押下で検索条件に従い、 主治医医療機関情報を検索します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnReSearch(ShujiiIryoKikanMasterDiv div) {
        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        boolean isUpdate = false;
        for (dgShujiiIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (isUpdate) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                onLoad(div);
                div.getShujiiSearch().setDisabled(false);
                return ResponseData.of(div).setState(DBE9010001StateName.検索);
            }
        } else {
            onLoad(div);
            div.getShujiiSearch().setDisabled(false);
            return ResponseData.of(div).setState(DBE9010001StateName.検索);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnSave(ShujiiIryoKikanMasterDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForUpdate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            validPairs = validateForDelete(div);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            Models<ShujiiIryoKikanJohoIdentifier, ShujiiIryoKikanJoho> models = ViewStateHolder.
                    get(ViewStateKeys.主治医医療機関マスタ検索結果, Models.class);
            ShujiiIryoKikanJohoManager shujiiIryoKikanJohoManager = ShujiiIryoKikanJohoManager.createInstance();
            for (ShujiiIryoKikanJoho shujiiIryoKikanJoho : models) {
                shujiiIryoKikanJohoManager.saveOrDelete主治医医療機関情報(shujiiIryoKikanJoho);
            }
            return ResponseData.of(div).setState(DBE9010001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs validateForDelete(ShujiiIryoKikanMasterDiv div) {
        List<dgShujiiIchiran_Row> dataList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        KoseiShujiiIryoKikanMasterFinder koseiShujiiIryoKikanMasterFinder = KoseiShujiiIryoKikanMasterFinder.createInstance();
        for (dgShujiiIchiran_Row row : dataList) {
            if (状態_削除.equals(row.getJotai())) {
                KoseiShujiiIryoKikanMasterSearchParameter parameter = KoseiShujiiIryoKikanMasterSearchParameter.createParam_SelectShujiiIryoKikanJoho(
                        new LasdecCode(row.getShichosonCode()),
                        row.getShujiiIryoKikanCode().getValue());
                return getValidationHandler(div).validateForUpdate(
                        koseiShujiiIryoKikanMasterFinder.getShujiiJohoCount(parameter));
            }
        }
        return new ValidationMessageControlPairs();
    }

    /**
     * 主治医一覧に戻ります。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnBackIchiran(ShujiiIryoKikanMasterDiv div) {
        div.getShujiiIchiran().setDisabled(false);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医検索に戻ります。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnBackSearch(ShujiiIryoKikanMasterDiv div) {
        div.getShujiiSearch().setDisabled(false);
        div.getShujiiIchiran().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医を登録ボタンボタン押下で、主治医マスタに戻ります。
     *
     * @param div ShujiiIryoKikanMasterDiv
     * @return ResponseData<ShujiiIryoKikanMasterDiv>
     */
    public ResponseData<ShujiiIryoKikanMasterDiv> onClick_btnBackShujiiMasterToToroku(ShujiiIryoKikanMasterDiv div) {
        if (状態_削除.equals(div.getShujiiJohoInput().getState())
                || RString.EMPTY.equals(div.getShujiiJohoInput().getState())
                || ((状態_修正.equals(div.getShujiiJohoInput().getState())
                || 状態_追加.equals(div.getShujiiJohoInput().getState())
                && !getValidationHandler(div).isUpdate()))) {
            return ResponseData.of(div).forwardWithEventName(DBE9010001TransitionEventName.主治医マスタに遷移).respond();
        } else if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE9010001TransitionEventName.主治医マスタに遷移).respond();
        }
        return ResponseData.of(div).respond();
    }

    private KoseiShujiiIryoKikanMasterHandler getHandler(ShujiiIryoKikanMasterDiv div) {
        return new KoseiShujiiIryoKikanMasterHandler(div);
    }

    private KoseiShujiiIryoKikanMasterValidationHandler getValidationHandler(ShujiiIryoKikanMasterDiv div) {
        return new KoseiShujiiIryoKikanMasterValidationHandler(div);
    }
}
