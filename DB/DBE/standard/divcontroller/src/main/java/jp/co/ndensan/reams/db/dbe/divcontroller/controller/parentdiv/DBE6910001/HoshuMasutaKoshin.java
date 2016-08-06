/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTankaIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuTankaIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShujiiIkenshoHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShujiiIkenshoHoshuTankaIdentifier;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.DBE6910001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.HoshuMasutaKoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgChosainhoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgHomonChosahoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgIkenShohoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6910001.HoshuMasutaKoshinHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6910001.HoshuMasutaKoshinValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.hoshumasutakoshin.HoshuMasutaKoshinManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 報酬マスタメンテナンス画面のクラスです。
 *
 * @reamsid_L DBE-1710-010 dingyi
 */
public class HoshuMasutaKoshin {

    private final RString タブ名_審査員報酬単価マスタ = new RString("審査員報酬単価マスタ");
    private final RString タブ名_意見書報酬単価マスタ = new RString("意見書報酬単価マスタ");
    private final RString タブ名_訪問調査報酬単価マスタ = new RString("訪問調査報酬単価マスタ");
    private final RString タブ名_審査会委員別単価マスタ = new RString("審査会委員別単価マスタ");
    private final RString 追加モード = new RString("追加");
    private final RString 更新モード = new RString("修正");
    private final RString 削除モード = new RString("削除");

    /**
     * 報酬マスタメンテナンス画面の初期化処理です。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onLoad(HoshuMasutaKoshinDiv div) {
        List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ情報 = HoshuMasutaKoshinManager.createInstance().get審査員報酬単価マスタ情報().records();
        if (審査員報酬単価マスタ情報 != null && !審査員報酬単価マスタ情報.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.審査員報酬単価マスタ情報, Models.create(審査員報酬単価マスタ情報));
        } else {
            ViewStateHolder.put(ViewStateKeys.審査員報酬単価マスタ情報, Models.create(new ArrayList()));
        }
        getHandler(div).onLoad(審査員報酬単価マスタ情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 報酬マスタ更新タブのonChange処理です。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onChange_tabHoshuMasutaKoshin(HoshuMasutaKoshinDiv div) {
        RString 選択したタブ名 = div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getSelectedItem().getTitle();
        if (タブ名_審査員報酬単価マスタ.equals(選択したタブ名)) {
            onLoad(div);
        } else if (タブ名_意見書報酬単価マスタ.equals(選択したタブ名)) {
            set意見書報酬単価マスタ情報(div);
        } else if (タブ名_訪問調査報酬単価マスタ.equals(選択したタブ名)) {
            set訪問調査報酬単価マスタ情報(div);
        } else if (タブ名_審査会委員別単価マスタ.equals(選択したタブ名)) {
            set審査会委員別単価マスタ情報(div);
        }
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 審査員報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnChoTsuika(HoshuMasutaKoshinDiv div) {
        getHandler(div).onClick_btnChoTsuika();
        return ResponseData.of(div).setState(DBE6910001StateName.審査明細);
    }

    /**
     * 審査員報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnChosainModify(HoshuMasutaKoshinDiv div) {
        getHandler(div).onSelect_btnChosainModify(div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.審査明細);
    }

    /**
     * 審査員報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnChosainDelete(HoshuMasutaKoshinDiv div) {
        getHandler(div).onSelect_btnChosainDelete(div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.審査明細);
    }

    /**
     * 審査員報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnChoTorikesu(HoshuMasutaKoshinDiv div) {
        getHandler(div).onClick_btnChoTorikesu();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 審査員報酬単価マスタ更新するボタンを押下するの場合、審査員報酬単価マスタ一覧を更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnChoKousin(HoshuMasutaKoshinDiv div) {
        ValidationMessageControlPairs controlPairs = check審査員報酬単価マスタ(div);
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        getHandler(div).onClick_btnChoKousin();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 意見書報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnIkenTsuika(HoshuMasutaKoshinDiv div) {
        getHandler(div).onClick_btnIkenTsuika();
        return ResponseData.of(div).setState(DBE6910001StateName.意見明細);
    }

    /**
     * 意見書報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnIkenShoModify(HoshuMasutaKoshinDiv div) {
        getHandler(div).onSelect_btnIkenShoModify(div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.意見明細);
    }

    /**
     * 意見書報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnIkenShoDelete(HoshuMasutaKoshinDiv div) {
        getHandler(div).onSelect_btnIkenShoDelete(div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.意見明細);
    }

    /**
     * 意見書報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnIkenTorikesu(HoshuMasutaKoshinDiv div) {
        getHandler(div).onClick_btnIkenTorikesu();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 意見書報酬単価マスタ更新するボタンを押下するの場合、意見書報酬単価マスタ一覧を更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnIkenKousin(HoshuMasutaKoshinDiv div) {
        ValidationMessageControlPairs controlPairs = check意見書報酬単価マスタ(div);
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        getHandler(div).onClick_btnIkenKousin();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 訪問調査報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnHomTsuika(HoshuMasutaKoshinDiv div) {
        getHandler(div).onClick_btnHomTsuika();
        return ResponseData.of(div).setState(DBE6910001StateName.訪問明細);
    }

    /**
     * 訪問調査報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnHomonChosaModify(HoshuMasutaKoshinDiv div) {
        getHandler(div).onSelect_btnHomonChosaModify(div.getHoshuMasutaTab().getDgHomonChosahoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.訪問明細);
    }

    /**
     * 訪問調査報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnHomonChosaDelete(HoshuMasutaKoshinDiv div) {
        getHandler(div).onSelect_btnHomonChosaDelete(div.getHoshuMasutaTab().getDgHomonChosahoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.訪問明細);
    }

    /**
     * 訪問調査報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnHomTorikesu(HoshuMasutaKoshinDiv div) {
        getHandler(div).onClick_btnHomTorikesu();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 訪問調査報酬単価マスタ更新するボタンを押下するの場合、訪問調査報酬単価マスタ一覧を更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnHomKousin(HoshuMasutaKoshinDiv div) {
        ValidationMessageControlPairs controlPairs = check訪問調査報酬単価マスタ(div);
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        getHandler(div).onClick_btnHomKousin();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 保存するボタンを押下するの場合、入力データをＤＢに更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnHozon(HoshuMasutaKoshinDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            update一覧情報(div);
            div.getShinsakaiMessage().getCcdKaigoKanryoMessage().setMessage(
                    new RString("報酬マスタメンテナンスの保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE6910001StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    private void set意見書報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ情報 = HoshuMasutaKoshinManager.createInstance().get意見書報酬単価マスタ情報().records();
        if (意見書報酬単価マスタ情報 != null && !意見書報酬単価マスタ情報.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.意見書報酬単価マスタ情報, Models.create(意見書報酬単価マスタ情報));
        } else {
            ViewStateHolder.put(ViewStateKeys.意見書報酬単価マスタ情報, Models.create(new ArrayList()));
        }
        getHandler(div).set意見書報酬単価マスタタブ(意見書報酬単価マスタ情報);
    }

    private void set訪問調査報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<NinteiChosaHoshuTanka> 訪問調査報酬単価マスタ情報 = HoshuMasutaKoshinManager.createInstance().get認定調査報酬単価マスタ情報().records();
        if (訪問調査報酬単価マスタ情報 != null && !訪問調査報酬単価マスタ情報.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.訪問調査報酬単価マスタ情報, Models.create(訪問調査報酬単価マスタ情報));
        } else {
            ViewStateHolder.put(ViewStateKeys.訪問調査報酬単価マスタ情報, Models.create(new ArrayList()));
        }
        getHandler(div).set訪問調査報酬単価マスタタブ(訪問調査報酬単価マスタ情報);
    }

    private void set審査会委員別単価マスタ情報(HoshuMasutaKoshinDiv div) {
        // TODO 該当テーブルがDBにありません。 1.11FWを待ち
//        List<NinteiChosaHoshuTanka> 審査会委員別単価マスタ情報 = HoshuMasutaKoshinManager.createInstance().get審査会委員別単価マスタ情報().records();
//        if (審査会委員別単価マスタ情報 != null && !審査会委員別単価マスタ情報.isEmpty()) {
//            ViewStateHolder.put(ViewStateKeys.審査会委員別単価マスタ情報, Models.create(審査会委員別単価マスタ情報));
//        } else {
        ViewStateHolder.put(ViewStateKeys.審査会委員別単価マスタ情報, Models.create(new ArrayList()));
//        }
        getHandler(div).set審査会委員別単価マスタタブ();
    }

    private ValidationMessageControlPairs check審査員報酬単価マスタ(HoshuMasutaKoshinDiv div) {
        TextBoxFlexibleYearMonth 開始年月 = div.getHoshuMasutaTab().getTxtChoKaishiYM();
        TextBoxFlexibleYearMonth 終了年月 = div.getHoshuMasutaTab().getTxtChoShuryoYM();
        ValidationMessageControlPairs controlPairs = getValidationHandler().check開始年月が必須(開始年月);
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        controlPairs = getValidationHandler().check終了年月が必須(終了年月);
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        if (追加モード.equals(div.getChosainhoshuTankaState())) {
            controlPairs = getValidationHandler().check期間が不正(開始年月, 終了年月);
            if (controlPairs.iterator().hasNext()) {
                return controlPairs;
            }
            List<dgChosainhoshuTankaIchiran_Row> 審査員報酬単価一覧情報
                    = div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getDataSource();
            for (dgChosainhoshuTankaIchiran_Row row : 審査員報酬単価一覧情報) {
                if (row.getKaigoNinteiShinsaIinShubetsuCode().equals(
                        div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedKey())
                        && row.getKaishiYM().getValue().getYearMonth().compareTo(
                                div.getHoshuMasutaTab().getTxtChoKaishiYM().getDomain()) == 0
                        && row.getShuryoYM().getValue().getYearMonth().compareTo(
                                div.getHoshuMasutaTab().getTxtChoShuryoYM().getDomain()) == 0) {
                    return getValidationHandler().checkデータが既に存在();
                }
                if (div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedKey().equals(
                        row.getKaigoNinteiShinsaIinShubetsuCode())
                        && is期間重複(div.getHoshuMasutaTab().getTxtChoKaishiYM().getDomain(),
                                row.getShuryoYM().getValue().getYearMonth())) {
                    return getValidationHandler().check期間が重複();
                }
            }
        }
        return new ValidationMessageControlPairs();
    }

    private boolean is期間重複(FlexibleYearMonth 新規作成開始年月, FlexibleYearMonth 既に存在終了年月) {
        return 新規作成開始年月.isBeforeOrEquals(既に存在終了年月);
    }

    private void update一覧情報(HoshuMasutaKoshinDiv div) {
        List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ更新情報 = update審査員報酬単価マスタ情報(div);
        List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ更新情報 = update意見書報酬単価マスタ情報(div);
        List<NinteiChosaHoshuTanka> 認定調査報酬単価マスタ更新情報 = update訪問調査報酬単価マスタ情報(div);
        HoshuMasutaKoshinManager.createInstance().updateマスタ情報(
                審査員報酬単価マスタ更新情報, 意見書報酬単価マスタ更新情報, 認定調査報酬単価マスタ更新情報);
    }

    private List<ShinsakaiIinHoshuTanka> update審査員報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<dgChosainhoshuTankaIchiran_Row> 審査員報酬単価一覧情報 = div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getDataSource();
        List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ更新情報 = new ArrayList<>();
        Models<ShinsakaiIinHoshuTankaIdentifier, ShinsakaiIinHoshuTanka> 審査員報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.審査員報酬単価マスタ情報, Models.class);
        for (dgChosainhoshuTankaIchiran_Row row : 審査員報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState())) {
                ShinsakaiIinHoshuTanka 新規情報 = new ShinsakaiIinHoshuTanka(
                        new CodeShubetsu(row.getKaigoNinteiShinsaIinShubetsuCode()),
                        row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYM().getValue().getYearMonth(),
                        row.getTanka().getValue());
                審査員報酬単価マスタ更新情報.add(新規情報);
            } else if (更新モード.equals(row.getColumnState())) {
                ShinsakaiIinHoshuTankaIdentifier 識別子 = new ShinsakaiIinHoshuTankaIdentifier(
                        new CodeShubetsu(row.getKaigoNinteiShinsaIinShubetsuCode()),
                        row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYM().getValue().getYearMonth());
                審査員報酬単価マスタ更新情報.add(
                        審査員報酬単価情報Model.get(識別子).createBuilderForEdit().
                        set単価(row.getTanka().getValue()).build());
            } else if (削除モード.equals(row.getColumnState())) {
                ShinsakaiIinHoshuTankaIdentifier 識別子 = new ShinsakaiIinHoshuTankaIdentifier(
                        new CodeShubetsu(row.getKaigoNinteiShinsaIinShubetsuCode()),
                        row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYM().getValue().getYearMonth());
                審査員報酬単価マスタ更新情報.add(審査員報酬単価情報Model.get(識別子).deleted());
            }
        }
        return 審査員報酬単価マスタ更新情報;
    }

    private ValidationMessageControlPairs check意見書報酬単価マスタ(HoshuMasutaKoshinDiv div) {
        TextBoxFlexibleYearMonth 開始年月 = div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM();
        TextBoxFlexibleYearMonth 終了年月 = div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM();
        ValidationMessageControlPairs controlPairs = getValidationHandler().check開始年月が必須(開始年月);
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        controlPairs = getValidationHandler().check終了年月が必須(終了年月);
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        controlPairs = getValidationHandler().check単価が必須(div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka());
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        if (追加モード.equals(div.getIkenShohoshuTankaState())) {
            controlPairs = getValidationHandler().check期間が不正(開始年月, 終了年月);
            if (controlPairs.iterator().hasNext()) {
                return controlPairs;
            }
            List<dgIkenShohoshuTankaIchiran_Row> 意見書報酬単価一覧情報
                    = div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getDataSource();
            for (dgIkenShohoshuTankaIchiran_Row row : 意見書報酬単価一覧情報) {
                if (row.getZaitakuShisetsuKubunCode().equals(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().getSelectedKey())
                        && row.getIkenshoSakuseiKaisuKubunCode().equals(div.getHoshuMasutaTab().
                                getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey())
                        && row.getKaishiYM().getValue().getYearMonth().compareTo(
                                div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().getDomain()) == 0) {
                    return getValidationHandler().checkデータが既に存在();
                }
                if (div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().getSelectedKey().equals(
                        row.getZaitakuShisetsuKubunCode())
                        && div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey().equals(
                                row.getIkenshoSakuseiKaisuKubunCode())
                        && is期間重複(div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().getDomain(),
                                row.getShuryoYM().getValue().getYearMonth())) {
                    return getValidationHandler().check期間が重複();
                }
            }
        }
        return new ValidationMessageControlPairs();
    }

    private List<ShujiiIkenshoHoshuTanka> update意見書報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<dgIkenShohoshuTankaIchiran_Row> 意見書報酬単価一覧情報 = div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getDataSource();
        List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ更新情報 = new ArrayList<>();
        Models<ShujiiIkenshoHoshuTankaIdentifier, ShujiiIkenshoHoshuTanka> 意見書報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.意見書報酬単価マスタ情報, Models.class);
        for (dgIkenShohoshuTankaIchiran_Row row : 意見書報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState())) {
                ShujiiIkenshoHoshuTanka 新規情報 = new ShujiiIkenshoHoshuTanka(
                        new Code(row.getZaitakuShisetsuKubunCode()),
                        new Code(row.getIkenshoSakuseiKaisuKubunCode()),
                        row.getKaishiYM().getValue().getYearMonth());
                意見書報酬単価マスタ更新情報.add(新規情報.createBuilderForEdit().
                        set終了年月(row.getShuryoYM().getValue().getYearMonth()).
                        set単価(row.getTanka().getValue()).
                        build());
            } else if (更新モード.equals(row.getColumnState())) {
                ShujiiIkenshoHoshuTankaIdentifier 識別子 = new ShujiiIkenshoHoshuTankaIdentifier(
                        new Code(row.getZaitakuShisetsuKubunCode()),
                        new Code(row.getIkenshoSakuseiKaisuKubunCode()),
                        row.getKaishiYM().getValue().getYearMonth());
                意見書報酬単価マスタ更新情報.add(意見書報酬単価情報Model.get(識別子).createBuilderForEdit().
                        set終了年月(row.getShuryoYM().getValue().getYearMonth()).
                        set単価(row.getTanka().getValue()).
                        build());
            } else if (削除モード.equals(row.getColumnState())) {
                ShujiiIkenshoHoshuTankaIdentifier 識別子 = new ShujiiIkenshoHoshuTankaIdentifier(
                        new Code(row.getZaitakuShisetsuKubunCode()),
                        new Code(row.getIkenshoSakuseiKaisuKubunCode()),
                        row.getKaishiYM().getValue().getYearMonth());
                意見書報酬単価マスタ更新情報.add(意見書報酬単価情報Model.get(識別子).deleted());
            }
        }
        return 意見書報酬単価マスタ更新情報;
    }

    private ValidationMessageControlPairs check訪問調査報酬単価マスタ(HoshuMasutaKoshinDiv div) {
        TextBoxFlexibleYearMonth 開始年月 = div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM();
        TextBoxFlexibleYearMonth 終了年月 = div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM();
        ValidationMessageControlPairs controlPairs = getValidationHandler().check開始年月が必須(開始年月);
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        controlPairs = getValidationHandler().check終了年月が必須(終了年月);
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        controlPairs = getValidationHandler().check単価が必須(
                div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka());
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        if (追加モード.equals(div.getHomonChosahoshuTankaState())) {
            controlPairs = getValidationHandler().check期間が不正(開始年月, 終了年月);
            if (controlPairs.iterator().hasNext()) {
                return controlPairs;
            }
            List<dgHomonChosahoshuTankaIchiran_Row> 訪問調査報酬単価一覧情報
                    = div.getHoshuMasutaTab().getDgHomonChosahoshuTankaIchiran().getDataSource();
            for (dgHomonChosahoshuTankaIchiran_Row row : 訪問調査報酬単価一覧情報) {
                if (row.getChosaKubunCode().equals(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedKey())
                        && row.getHomonShubetsuCode().equals(div.getHoshuMasutaTab().
                                getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedKey())
                        && row.getKaishiYM().getValue().getYearMonth().compareTo(
                                div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().getDomain()) == 0
                        && row.getShuryoYM().getValue().getYearMonth().compareTo(
                                div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().getDomain()) == 0) {
                    return getValidationHandler().checkデータが既に存在();
                }
                if (div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedKey().equals(
                        row.getChosaKubunCode())
                        && div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedKey().equals(
                                row.getHomonShubetsuCode())
                        && is期間重複(div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().getDomain(),
                                row.getShuryoYM().getValue().getYearMonth())) {
                    return getValidationHandler().check期間が重複();
                }
            }
        }
        return new ValidationMessageControlPairs();
    }

    private List<NinteiChosaHoshuTanka> update訪問調査報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<dgHomonChosahoshuTankaIchiran_Row> 訪問調査報酬単価一覧情報 = div.getHoshuMasutaTab().
                getDgHomonChosahoshuTankaIchiran().getDataSource();
        List<NinteiChosaHoshuTanka> 訪問調査報酬単価マスタ更新情報 = new ArrayList<>();
        Models<NinteiChosaHoshuTankaIdentifier, NinteiChosaHoshuTanka> 訪問調査報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.訪問調査報酬単価マスタ情報, Models.class);
        for (dgHomonChosahoshuTankaIchiran_Row row : 訪問調査報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState())) {
                NinteiChosaHoshuTanka 新規情報 = new NinteiChosaHoshuTanka(
                        new Code(row.getChosaKubunCode()),
                        new Code(row.getHomonShubetsuCode()),
                        row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYM().getValue().getYearMonth());
                訪問調査報酬単価マスタ更新情報.add(新規情報.createBuilderForEdit().
                        set単価(row.getTanka().getValue()).
                        build());
            } else if (更新モード.equals(row.getColumnState())) {
                NinteiChosaHoshuTankaIdentifier 識別子 = new NinteiChosaHoshuTankaIdentifier(
                        new Code(row.getChosaKubunCode()),
                        new Code(row.getHomonShubetsuCode()),
                        row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYM().getValue().getYearMonth());
                訪問調査報酬単価マスタ更新情報.add(訪問調査報酬単価情報Model.get(識別子).createBuilderForEdit().
                        set単価(row.getTanka().getValue()).
                        build());
            } else if (削除モード.equals(row.getColumnState())) {
                NinteiChosaHoshuTankaIdentifier 識別子 = new NinteiChosaHoshuTankaIdentifier(
                        new Code(row.getChosaKubunCode()),
                        new Code(row.getHomonShubetsuCode()),
                        row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYM().getValue().getYearMonth());
                訪問調査報酬単価マスタ更新情報.add(訪問調査報酬単価情報Model.get(識別子).deleted());
            }
        }
        return 訪問調査報酬単価マスタ更新情報;
    }

    private HoshuMasutaKoshinHandler getHandler(HoshuMasutaKoshinDiv div) {
        return new HoshuMasutaKoshinHandler(div);
    }

    private HoshuMasutaKoshinValidationHandler getValidationHandler() {
        return new HoshuMasutaKoshinValidationHandler();
    }

}
