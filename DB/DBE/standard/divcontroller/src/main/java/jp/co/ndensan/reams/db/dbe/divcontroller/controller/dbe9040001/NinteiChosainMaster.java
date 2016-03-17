/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe9040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.csv.ninteichosainmaster.NinteiChosainMasterCsvBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.ShichosonMeishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainmaster.NinteiChosainMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainmaster.NinteiChosainMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.DBE9040001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.DBE9040001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9040001.NinteiChosainMasterHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe9040001.NinteiChosainMasterValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosainmaster.NinteiChosainMasterFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosainmaster.NinteiChosainMasterManager;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.chosainjoho.ChosainJohoManager;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector.KoseiShiChosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv.TaishoMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査員マスタ処理のクラスです。
 */
public class NinteiChosainMaster {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     */
    public NinteiChosainMaster() {
    }

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onLoad(NinteiChosainMasterDiv div) {
        getHandler(div).load();
        getHandler(div).clearKensakuJoken();
        RString 認定調査委託先コード = ViewStateHolder.get(SaibanHanyokeyName.調査委託先コード, RString.class);
        if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
            div.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom().setValue(認定調査委託先コード);
            onClick_btnSearchShujii(div);
            return ResponseData.of(div).setState(DBE9040001StateName.一覧_認定調査委託先マスタから遷移);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * クリアボタン押下で検索条件入力項目をクリアします。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnClearKensakuJoken(NinteiChosainMasterDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタン押下で検索条件に従い、調査員情報を検索します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnSearchShujii(NinteiChosainMasterDiv div) {

        searchChosainInfo(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタン押下で検索条件に従い、調査員情報を検索します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnReSearch(NinteiChosainMasterDiv div) {

        List<dgChosainIchiran_Row> ichiranList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();

        boolean isUpdate = false;
        for (dgChosainIchiran_Row row : ichiranList) {
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
                div.getChosainSearch().setDisabled(false);
                return ResponseData.of(div).setState(DBE9040001StateName.検索);
            }
        } else {
            onLoad(div);
            div.getChosainSearch().setDisabled(false);
            return ResponseData.of(div).setState(DBE9040001StateName.検索);
        }
        return ResponseData.of(div).respond();
    }

    private void searchChosainInfo(NinteiChosainMasterDiv div) {
        boolean chosainJokyo = false;
        if (div.getRadSearchChosainJokyo().getSelectedIndex() == 0) {
            chosainJokyo = true;
        }
        NinteiChosainMasterMapperParameter parameter = NinteiChosainMasterMapperParameter.createParamForSelectChosainJohoList(chosainJokyo,
                div.getHokenshaList().getSelectedItem().get市町村コード(),
                new ChosaItakusakiCode(div.getTxtSearchChosaItakusakiCodeFrom().getValue()),
                new ChosaItakusakiCode(div.getTxtSearchChosaItakusakiCodeTo().getValue()),
                div.getTxtSearchChosaItakusakiMeisho().getValue(),
                div.getTxtSearchChosaItakusakiKanaMeisho().getValue(),
                new ChosainCode(div.getTxtSearchChosainCodeFrom().getValue()),
                new ChosainCode(div.getTxtSearchChosainCodeTo().getValue()),
                div.getTxtSearchChosainShimei().getValue(),
                div.getTxtSearchChosainKanaShimei().getValue(),
                div.getDdlChikuCode().getSelectedKey(),
                div.getTxtSaidaiHyojiKensu().getValue());
        NinteiChosainMasterFinder ninteiChosainMasterFinder = NinteiChosainMasterFinder.createInstance();
        List<jp.co.ndensan.reams.db.dbe.business.core.ninteichosainmaster.NinteiChosainMaster> 調査員情報List
                = ninteiChosainMasterFinder.getChosainJohoIchiranList(
                        parameter).records();
        if (調査員情報List.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.認定調査員マスタ検索結果, Models.create(new ArrayList<ChosainJoho>()));
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        div.getChosainSearch().setDisabled(true);
        div.getChosainIchiran().setDisabled(false);
        getHandler(div).setChosainIchiran(調査員情報List);
        List<ChosainJoho> 認定調査員マスタList = ninteiChosainMasterFinder.getChosainJohoList(parameter).records();
        ViewStateHolder.put(ViewStateKeys.認定調査員マスタ検索結果, Models.create(認定調査員マスタList));
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnInsert(NinteiChosainMasterDiv div) {
        div.getChosainJohoInput().setState(状態_追加);
        div.getChosainIchiran().setDisabled(true);
        getHandler(div).setDisabledFalseToChosainJohoToMeisai();
        getHandler(div).clearChosainJohoToMeisai();
        div.getChosainJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        RString 認定調査委託先コード = ViewStateHolder.get(SaibanHanyokeyName.調査委託先コード, RString.class);
        if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
            return ResponseData.of(div).setState(DBE9040001StateName.詳細_認定調査委託先マスタから遷移);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ＣＳＶを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnOutputCsv(NinteiChosainMasterDiv div) {

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
            NinteiChosainMasterManager.createInstance().csvOutput(getCsvData(div));
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.正常終了.getMessage().replace("CSV出力")).respond();
        }
        return ResponseData.of(div).respond();
    }

    private List<NinteiChosainMasterCsvBusiness> getCsvData(NinteiChosainMasterDiv div) {
        List<NinteiChosainMasterCsvBusiness> list = new ArrayList<>();
        List<dgChosainIchiran_Row> dataList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        for (dgChosainIchiran_Row row : dataList) {
            Decimal chosaKanoNinzu = row.getChosaKanoNinzu().getValue();
            if (chosaKanoNinzu == null) {
                chosaKanoNinzu = Decimal.ZERO;
            }
            list.add(new NinteiChosainMasterCsvBusiness(
                    row.getShichosonCode(),
                    row.getShichoson(),
                    row.getChosainCode().getValue(),
                    row.getChosainShimei(),
                    row.getChosainKanaShimei(),
                    row.getChosaItakusakiCode().getValue(),
                    row.getChosaItakusakiMeisho(),
                    row.getSeibetsu(),
                    row.getChikuCode(),
                    row.getChiku(),
                    row.getChosainShikakuCode(),
                    new RString(chosaKanoNinzu.toString()),
                    row.getJokyoFlag(),
                    row.getYubinNo(),
                    row.getJusho(),
                    row.getTelNo(),
                    row.getFaxNo(),
                    row.getShozokuKikanName()));
        }
        return list;
    }

    /**
     * 取消するボタンが押下された場合、入力明細エリアの入力内容を破棄し、調査員一覧エリアへ戻ります。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnTorikeshi(NinteiChosainMasterDiv div) {
        if ((状態_追加.equals(div.getChosainJohoInput().getState())
                || 状態_修正.equals(div.getChosainJohoInput().getState()))
                && getValidationHandler(div).isUpdate()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.getChosainIchiran().setDisabled(false);
                return ResponseData.of(div).setState(DBE9040001StateName.一覧);
            }
        }

        div.getChosainIchiran().setDisabled(false);
        RString 認定調査委託先コード = ViewStateHolder.get(SaibanHanyokeyName.調査委託先コード, RString.class);
        if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
            return ResponseData.of(div).setState(DBE9040001StateName.一覧_認定調査委託先マスタから遷移);
        }
        return ResponseData.of(div).setState(DBE9040001StateName.一覧);
    }

    /**
     * 確定するボタンが押下された場合、入力明細エリアの入力内容を調査員一覧に反映させます。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnKakutei(NinteiChosainMasterDiv div) {

        RString イベント状態 = div.getChosainJohoInput().getState();
        int chosainJohoCount = NinteiChosainMasterFinder.createInstance().getChosainJohoCount(NinteiChosainMasterSearchParameter.createParamForSelectChosainJoho(
                new LasdecCode(div.getChosainJohoInput().getTxtShichoson().getValue()),
                new ChosaItakusakiCode(div.getChosainJohoInput().getTxtChosaItakusaki().getValue()),
                new ChosainCode(div.getChosainJohoInput().getTxtChosainCode().getValue())));
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei(イベント状態, chosainJohoCount);

        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        Models<ChosainJohoIdentifier, ChosainJoho> models = ViewStateHolder.get(ViewStateKeys.認定調査員マスタ検索結果, Models.class);

        if (状態_追加.equals(イベント状態)) {
            ChosainJoho chosainJoho = new ChosainJoho(new LasdecCode(div.getChosainJohoInput().getTxtShichoson().getValue()),
                    new ChosaItakusakiCode(div.getChosainJohoInput().getTxtChosaItakusaki().getValue()),
                    new ChosainCode(div.getChosainJohoInput().getTxtChosainCode().getValue()));
            chosainJoho = getHandler(div).editChosainJoho(chosainJoho);
            models.add(chosainJoho);
        } else if (状態_修正.equals(イベント状態)) {
            ChosainJohoIdentifier key = new ChosainJohoIdentifier(
                    new LasdecCode(div.getChosainJohoInput().getTxtShichoson().getValue()),
                    new ChosaItakusakiCode(div.getChosainJohoInput().getTxtChosaItakusaki().getValue()),
                    new ChosainCode(div.getChosainJohoInput().getTxtChosainCode().getValue()));
            ChosainJoho chosainJoho = getHandler(div).editChosainJoho(models.get(key).modifiedModel());
            models.deleteOrRemove(key);
            models.add(chosainJoho);
        } else if (状態_削除.equals(イベント状態)) {
            ChosainJohoIdentifier key = new ChosainJohoIdentifier(
                    new LasdecCode(div.getChosainJohoInput().getTxtShichoson().getValue()),
                    new ChosaItakusakiCode(div.getChosainJohoInput().getTxtChosaItakusaki().getValue()),
                    new ChosainCode(div.getChosainJohoInput().getTxtChosainCode().getValue()));
            RString jotai = div.getChosainIchiran().getDgChosainIchiran().getActiveRow().getJotai();
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                ChosainJoho chosainJoho = getHandler(div).editChosainJoho(models.get(key).deleted());
                models.add(chosainJoho);
            }
        }

        ViewStateHolder.put(ViewStateKeys.認定調査員マスタ検索結果, models);
        div.getChosainIchiran().setDisabled(false);
        getHandler(div).setChosainJohoToIchiran(イベント状態);
        RString 認定調査委託先コード = ViewStateHolder.get(SaibanHanyokeyName.調査委託先コード, RString.class);
        if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
            return ResponseData.of(div).setState(DBE9040001StateName.一覧_認定調査委託先マスタから遷移);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行の内容を、明細エリアに表示します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onSelectByDlbClick_dgChosainIchiran(NinteiChosainMasterDiv div) {
        div.getChosainJohoInput().setState(RString.EMPTY);
        dgChosainIchiran_Row row = div.getChosainIchiran().getDgChosainIchiran().getActiveRow();
        getHandler(div).setChosainJohoToMeisai(row);
        if (状態_修正.equals(row.getJotai())) {
            div.getChosainJohoInput().getTxtShichoson().setDisabled(true);
            div.getChosainJohoInput().getTxtChosaItakusaki().setDisabled(true);
            div.getChosainJohoInput().getTxtChosainCode().setDisabled(true);
        } else if (状態_削除.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosainJohoToMeisai();
        } else if (RString.EMPTY.equals(row.getJotai())) {
            getHandler(div).setDisabledTrueToChosainJohoToMeisai();
            div.getChosainJohoInput().getBtnKakutei().setDisabled(true);
        }
        div.getChosainIchiran().setDisabled(true);
        RString 認定調査委託先コード = ViewStateHolder.get(SaibanHanyokeyName.調査委託先コード, RString.class);
        if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
            return ResponseData.of(div).setState(DBE9040001StateName.詳細_認定調査委託先マスタから遷移);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 修正アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力可能にします。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onSelectByModifyButton_dgChosainIchiran(NinteiChosainMasterDiv div) {
        div.getChosainJohoInput().setState(状態_修正);
        getHandler(div).setDisabledFalseToChosainJohoToMeisai();
        dgChosainIchiran_Row row = div.getChosainIchiran().getDgChosainIchiran().getClickedItem();
        getHandler(div).setChosainJohoToMeisai(row);
        div.getChosainJohoInput().getTxtShichoson().setDisabled(true);
        div.getChosainJohoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getChosainJohoInput().getTxtChosaItakusaki().setDisabled(true);
        div.getChosainJohoInput().getBtnToSearchChosaItakusaki().setDisabled(true);
        div.getChosainJohoInput().getTxtChosainCode().setDisabled(true);
        div.getChosainIchiran().setDisabled(true);
        div.getChosainJohoInput().setHiddenInputDiv(getHandler(div).getInputDiv());
        RString 認定調査委託先コード = ViewStateHolder.get(SaibanHanyokeyName.調査委託先コード, RString.class);
        if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
            return ResponseData.of(div).setState(DBE9040001StateName.詳細_認定調査委託先マスタから遷移);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 削除アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力不可にします。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onSelectByDeleteButton_dgChosainIchiran(NinteiChosainMasterDiv div) {
        div.getChosainJohoInput().setState(状態_削除);
        dgChosainIchiran_Row row = div.getChosainIchiran().getDgChosainIchiran().getActiveRow();
        getHandler(div).setChosainJohoToMeisai(row);
        getHandler(div).setDisabledTrueToChosainJohoToMeisai();
        div.getChosainJohoInput().getBtnKakutei().setDisabled(false);
        div.getChosainIchiran().setDisabled(true);
        RString 認定調査委託先コード = ViewStateHolder.get(SaibanHanyokeyName.調査委託先コード, RString.class);
        if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
            return ResponseData.of(div).setState(DBE9040001StateName.詳細_認定調査委託先マスタから遷移);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村名を取得します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onBlur_txtShichoson(NinteiChosainMasterDiv div) {
        RString shichoson = div.getChosainJohoInput().getTxtShichoson().getValue();
        if (RString.isNullOrEmpty(shichoson)) {
            div.getChosainJohoInput().getTxtShichosonmei().setValue(RString.EMPTY);
        } else {
            List<ShichosonMeishoBusiness> list = NinteiChosainMasterFinder.createInstance().getShichosonMeisho(new LasdecCode(shichoson)).records();
            if (!list.isEmpty()) {
                div.getChosainJohoInput().getTxtShichosonmei().setValue(list.get(0).getShichosonMeisho());
            } else {
                div.getChosainJohoInput().getTxtShichosonmei().setValue(RString.EMPTY);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先名を取得します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onBlur_txtChosaItakusaki(NinteiChosainMasterDiv div) {
        RString txtChosaItakusaki = div.getChosainJohoInput().getTxtChosaItakusaki().getValue();
        if (!RString.isNullOrEmpty(txtChosaItakusaki)) {
            RString ninteichosaItakusakiMeisho = NinteiChosainMasterFinder.createInstance().getNinteichosaItakusakiMeisho(NinteiChosainMasterSearchParameter.createParamForSelectChosainJoho(
                    new LasdecCode(div.getChosainJohoInput().getTxtShichoson().getValue()),
                    new ChosaItakusakiCode(div.getChosainJohoInput().getTxtChosaItakusaki().getValue()),
                    new ChosainCode(div.getChosainJohoInput().getTxtChosainCode().getValue())));
            if (!RString.isNullOrEmpty(ninteichosaItakusakiMeisho)) {
                div.getChosainJohoInput().getTxtChosaItakusakiMeisho().setValue(ninteichosaItakusakiMeisho);
            } else {
                div.getChosainJohoInput().getTxtChosaItakusakiMeisho().setValue(RString.EMPTY);
            }
        } else {
            div.getChosainJohoInput().getTxtChosaItakusakiMeisho().setValue(RString.EMPTY);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 地区名を取得します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onOkClose_btnToSearchShichoson(NinteiChosainMasterDiv div) {
        KoseiShiChosonSelectorModel model = ViewStateHolder.get(ViewStateKeys.構成市町村選択_引き継ぎデータ, KoseiShiChosonSelectorModel.class);
        div.getChosainJohoInput().getTxtShichoson().setValue(model.get市町村コード());
        div.getChosainJohoInput().getTxtShichosonmei().setValue(model.get市町村名称());
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnUpdate(NinteiChosainMasterDiv div) {
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
            Models<ChosainJohoIdentifier, ChosainJoho> models = ViewStateHolder.get(ViewStateKeys.認定調査員マスタ検索結果, Models.class);
            ChosainJohoManager chosainJohoManager = ChosainJohoManager.createInstance();
            for (ChosainJoho chosainJoho : models) {
                chosainJohoManager.saveOrDelete調査員情報(chosainJoho);
            }
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            RString 認定調査委託先コード = ViewStateHolder.get(SaibanHanyokeyName.調査委託先コード, RString.class);
            if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
                return ResponseData.of(div).setState(DBE9040001StateName.完了_認定調査委託先マスタから遷移);
            }
            return ResponseData.of(div).setState(DBE9040001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ValidationMessageControlPairs validateForDelete(NinteiChosainMasterDiv div) {
        List<dgChosainIchiran_Row> dataList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        NinteiChosainMasterFinder ninteiChosainMasterFinder = NinteiChosainMasterFinder.createInstance();
        for (dgChosainIchiran_Row row : dataList) {
            if (状態_削除.equals(row.getJotai())) {
                NinteiChosainMasterSearchParameter parameter = NinteiChosainMasterSearchParameter.createParamForSelectChosainJoho(
                        new LasdecCode(row.getShichosonCode()),
                        new ChosaItakusakiCode(row.getChosaItakusakiCode().getValue()),
                        new ChosainCode(row.getChosainCode().getValue()));
                return getValidationHandler(div).validateForUpdate(
                        ninteiChosainMasterFinder.getNinteiShinseiJohoCount(parameter),
                        ninteiChosainMasterFinder.getNinteichosaIraiJohoCount(parameter));
            }
        }
        return new ValidationMessageControlPairs();
    }

    /**
     * 一覧に戻ります。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnBackIchiran(NinteiChosainMasterDiv div) {
        div.getChosainIchiran().setDisabled(false);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧に戻ります。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnBackSearch(NinteiChosainMasterDiv div) {
        div.getChosainSearch().setDisabled(false);
        div.getChosainIchiran().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先マスタに戻ります。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnBackItakusakiMasterToIchiran(NinteiChosainMasterDiv div) {
        List<dgChosainIchiran_Row> ichiranList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        boolean isUpdate = false;
        for (dgChosainIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            return ResponseData.of(div).forwardWithEventName(DBE9040001TransitionEventName.認定調査委託先マスタに戻る).respond();
        } else if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE9040001TransitionEventName.認定調査委託先マスタに戻る).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先マスタに戻ります。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnBackItakusakiMasterToToroku(NinteiChosainMasterDiv div) {
        if (状態_削除.equals(div.getChosainJohoInput().getState())
                || RString.EMPTY.equals(div.getChosainJohoInput().getState())
                || ((状態_修正.equals(div.getChosainJohoInput().getState())
                || 状態_追加.equals(div.getChosainJohoInput().getState())
                && !getValidationHandler(div).isUpdate()))) {
            return ResponseData.of(div).forwardWithEventName(DBE9040001TransitionEventName.認定調査委託先マスタに戻る).respond();
        } else if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE9040001TransitionEventName.認定調査委託先マスタに戻る).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先マスタに戻ります。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnBackItakusakiMasterToComplete(NinteiChosainMasterDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE9040001TransitionEventName.認定調査委託先マスタに戻る).respond();
    }

    /**
     * 認定調査委託先マスタから一覧に戻ります。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnBackIchiran_Itakusaki(NinteiChosainMasterDiv div) {
        div.getChosainIchiran().setDisabled(false);
        return ResponseData.of(div).setState(DBE9040001StateName.一覧_認定調査委託先マスタから遷移);
    }

    /**
     * 認定調査委託先の検索処理です。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnToSearchChosaItakusaki(NinteiChosainMasterDiv div) {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = new KijuntsukiShichosonjohoiDataPassModel();
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(div.getChosainJohoInput().getTxtShichoson().getValue());
        dataPassModel.set対象モード(new RString(TaishoMode.Itakusaki.toString()));

        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先の設定処理です。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData
     */
    public ResponseData<NinteiChosainMasterDiv> onOkClose_btnToSearchChosaItakusaki(NinteiChosainMasterDiv div) {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getChosainJohoInput().getTxtChosaItakusaki().setValue(dataPassModel.get委託先コード());
        div.getChosainJohoInput().getTxtChosaItakusakiMeisho().setValue(dataPassModel.get委託先名());
        return ResponseData.of(div).respond();
    }

    private NinteiChosainMasterHandler getHandler(NinteiChosainMasterDiv div) {
        return new NinteiChosainMasterHandler(div);
    }

    private NinteiChosainMasterValidationHandler getValidationHandler(NinteiChosainMasterDiv div) {
        return new NinteiChosainMasterValidationHandler(div);
    }
}
