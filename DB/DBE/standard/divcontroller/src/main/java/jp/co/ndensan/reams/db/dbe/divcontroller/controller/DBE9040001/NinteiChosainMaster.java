/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBE9040001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainmaster.NinteiChosainMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.DBE9040001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9040001.NinteiChosainMasterHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosainmaster.NinteiChosainMasterFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 認定調査員マスタ処理のクラスです。
 */
public class NinteiChosainMaster {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

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

        for (dgChosainIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    return ResponseData.of(div).setState(DBE9040001StateName.検索);
                }
            }
        }
        searchChosainInfo(div);
        return ResponseData.of(div).respond();
    }

    private void searchChosainInfo(NinteiChosainMasterDiv div) {
        boolean chosainJokyo = false;
        if (div.getRadSearchChosainJokyo().getSelectedIndex() == 0) {
            chosainJokyo = true;
        }
        NinteiChosainMasterMapperParameter parameter = NinteiChosainMasterMapperParameter.createParamForSelectChosainJohoList(chosainJokyo,
                new LasdecCode(div.getDdlSearchShichoson().getSelectedKey()),
                new ChosaItakusakiCode(div.getTxtSearchChosaItakusakiCodeFrom().getValue()),
                new ChosaItakusakiCode(div.getTxtSearchChosaItakusakiCodeTo().getValue()),
                div.getTxtSearchChosaItakusakiMeisho().getValue(),
                div.getTxtSearchChosaItakusakiKanaMeisho().getValue(),
                new ChosainCode(div.getTxtSearchChosainCodeFrom().getValue()),
                new ChosainCode(div.getTxtSearchChosainCodeTo().getValue()),
                div.getTxtSearchChosainShimei().getValue(),
                div.getTxtSearchChosainKanaShimei().getValue(),
                div.getDdlChikuCode().getSelectedKey(),
                div.getTxtSaidaiHyojiKensu().getValue().intValue());
        NinteiChosainMasterFinder ninteiChosainMasterFinder = NinteiChosainMasterFinder.createInstance();
        List<jp.co.ndensan.reams.db.dbe.business.core.ninteichosainmaster.NinteiChosainMaster> 調査員情報List
                = ninteiChosainMasterFinder.getChosainJohoIchiranList(
                        parameter).records();
        if (調査員情報List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }

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
        ViewStateHolder.put(ViewStateKeys.状態, 追加);
        return ResponseData.of(div).respond();
    }

    /**
     * ＣＳＶを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnOutputCsv(NinteiChosainMasterDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 取消するボタンが押下された場合、入力明細エリアの入力内容を破棄し、調査員一覧エリアへ戻ります。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnTorikeshi(NinteiChosainMasterDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 確定するボタンが押下された場合、入力明細エリアの入力内容を調査員一覧に反映させます。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onClick_btnKakutei(NinteiChosainMasterDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        Models<ChosainJohoIdentifier, ChosainJoho> models = ViewStateHolder.get(ViewStateKeys.認定調査員マスタ検索結果, Models.class);
        getHandler(div).setChosainJohoToIchiran(状態);
        ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (追加.equals(状態)) {
            ChosainJoho chosainJoho = new ChosainJoho(new LasdecCode(div.getChosainJohoInput().getTxtShichoson().getValue()), div.getChosainJohoInput().getTxtChosaItakusaki().getValue(),
                    div.getChosainJohoInput().getTxtChosainCode().getValue());
            chosainJoho = getHandler(div).editChosainJoho(chosainJoho);
            models.add(chosainJoho);
        } else if (修正.equals(状態)) {
            ChosainJohoIdentifier key = new ChosainJohoIdentifier(new LasdecCode(div.getChosainJohoInput().getTxtShichoson().getValue()), div.getChosainJohoInput().getTxtChosaItakusaki().getValue(),
                    div.getChosainJohoInput().getTxtChosainCode().getValue());
            getHandler(div).editChosainJoho(models.get(key).modifiedModel());
        } else if (削除.equals(状態)) {
            ChosainJohoIdentifier key = new ChosainJohoIdentifier(new LasdecCode(div.getChosainJohoInput().getTxtShichoson().getValue()), div.getChosainJohoInput().getTxtChosaItakusaki().getValue(),
                    div.getChosainJohoInput().getTxtChosainCode().getValue());
            getHandler(div).editChosainJoho(models.get(key).deleted());
        }
        ViewStateHolder.put(ViewStateKeys.認定調査員マスタ検索結果, models);
        ViewStateHolder.put(ViewStateKeys.状態, RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択行の内容を、明細エリアに表示します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onSelectByDlbClick_dgChosainIchiran(NinteiChosainMasterDiv div) {
        div.getChosainJohoInput().setVisible(true);
        dgChosainIchiran_Row row = div.getChosainIchiran().getDgChosainIchiran().getActiveRow();
        getHandler(div).setChosainJohoToMeisai(row);
        if (修正.equals(row.getJotai())) {
            div.getChosainJohoInput().getTxtShichoson().setDisabled(true);
            div.getChosainJohoInput().getTxtChosaItakusaki().setDisabled(true);
            div.getChosainJohoInput().getTxtChosainCode().setDisabled(true);
        } else if (削除.equals(row.getJotai())) {
            getHandler(div).setDisabledChosainJohoToMeisai();
        } else if (RString.EMPTY.equals(row.getJotai())) {
            getHandler(div).setDisabledChosainJohoToMeisai();
            div.getChosainJohoInput().getBtnKakutei().setDisabled(true);
        }
        ViewStateHolder.put(ViewStateKeys.状態, row.getJotai());
        return ResponseData.of(div).respond();
    }

    /**
     * 修正アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力可能にします。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onSelectByModifyButton_dgChosainIchiran(NinteiChosainMasterDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
//        div.getChosainJohoInput().setVisible(true);
//        getHandler(div).setChosainJohoToMeisai(div.getChosainIchiran().getDgChosainIchiran().getActiveRow());
//        div.getChosainJohoInput().getTxtShichoson().setDisabled(true);
//        div.getChosainJohoInput().getTxtChosaItakusaki().setDisabled(true);
//        div.getChosainJohoInput().getTxtChosainCode().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 削除アイコンを押下した場合、入力明細エリアに選択行の内容を表示し、項目を入力不可にします。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteiChosainMasterDiv> onSelectByDeleteButton_dgChosainIchiran(NinteiChosainMasterDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        div.getChosainJohoInput().setVisible(true);
        getHandler(div).setChosainJohoToMeisai(div.getChosainIchiran().getDgChosainIchiran().getActiveRow());
        getHandler(div).setDisabledChosainJohoToMeisai();
        return ResponseData.of(div).respond();
    }

    private NinteiChosainMasterHandler getHandler(NinteiChosainMasterDiv div) {
        return new NinteiChosainMasterHandler(div);
    }
}
