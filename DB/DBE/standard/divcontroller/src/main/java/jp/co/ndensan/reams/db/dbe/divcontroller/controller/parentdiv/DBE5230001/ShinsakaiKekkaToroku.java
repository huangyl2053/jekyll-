/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5230001;

import java.util.List;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.DBE5230001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.NinteiShinseiKubunHoreiMethod;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.OperationMode;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.IShinsaKekkaPreserver;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.IShinsakakKekksaTorokuManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuService;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.KaigoRowState;
import jp.co.ndensan.reams.db.dbz.service.core.ninteichosajokyo.NinteiChosaJokyoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaToroku {

    private static final RString 認定調査状況ダイアログ_照会モード = new RString("1");
    private static final RString 審査会メモ定型文GroupCode = new RString("5101");
    private static final RString 意見書定型文GroupCode = new RString("5201");
    private static final RString 一次判定結果変更理由定型文GroupCode = new RString("5103");
    private static final Code 二次判定結果入力方法_画面入力 = new Code("1");
    private static final RString 一_五次判定ダイアログ_照会モード = new RString("照会");

    private final ShinsakaiKekkaTorokuService service;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKekkaToroku() {
        this.service = ShinsakaiKekkaTorokuService.createInstance();
    }

    /**
     * 介護認定審査会審査結果登録Divを初期化します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData 介護認定審査会審査結果登録Div
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onLoad(ShinsakaiKekkaTorokuDiv div) {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        List<ShinsakaiKekkaTorokuBusiness> headList = service.getヘッドエリア内容検索(開催番号).records();
        List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList = service.get審査会委員一覧検索(開催番号).records();
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        if (申請書管理番号 == null || 申請書管理番号.isEmpty()) {
            handler.initalize(headList, iChiRanList);
        } else {
            handler.initalize(headList, iChiRanList, 申請書管理番号);
        }

        List<ShinsakaiWariateJoho> yoteiJohoList = service.get介護認定審査会割当情報(開催番号).records();
        Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiKaisaiYoteiJoho = Models.create(yoteiJohoList);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会開催予定情報, shinsakaiKaisaiYoteiJoho);
        List<NinteiShinseiJoho> ninteiShinseiJohoList = service.get要介護認定申請情報(開催番号).records();
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho = Models.create(ninteiShinseiJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, ninteiShinseiJoho);
        List<NinteiKekkaJoho> ninteiKekkaJohoList = service.get要介護認定結果情報(開催番号).records();
        Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho = Models.create(ninteiKekkaJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定結果情報, ninteiKekkaJoho);
        List<NinteiKanryoJoho> ninteiKanryoJohoList = service.get要介護認定完了情報(開催番号).records();
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho = Models.create(ninteiKanryoJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定完了情報, ninteiKanryoJoho);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員一覧Gridの「修正」ボタン押下時の処理です。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onSelectByModifyButton_dgTaishoshaIchiran(ShinsakaiKekkaTorokuDiv div) {
        return _onSelect_dgTaishoshaIchiran(div, OperationMode.更新);
    }

    /**
     * 審査会委員一覧Gridの「削除」ボタン押下時の処理です。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onSelectByDeleteButton_dgTaishoshaIchiran(ShinsakaiKekkaTorokuDiv div) {
        return _onSelect_dgTaishoshaIchiran(div, OperationMode.削除);
    }

    private ResponseData<ShinsakaiKekkaTorokuDiv> _onSelect_dgTaishoshaIchiran(ShinsakaiKekkaTorokuDiv div, OperationMode mode) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        dgTaishoshaIchiran_Row clickedRow = div.getShinseishaIchiran().getDgTaishoshaIchiran().getClickedItem();
        if (clickedRow == null) {
            return ResponseData.of(div).respond();
        }
        dgTaishoshaIchiran_Row updatingRow = handler.find更新中RowOrNull();
        if (updatingRow == null /*|| /*!handler.has個別事項Changed()*/) {
            handler.set個別表示欄入力可();
            handler.displayTo個別表示欄(clickedRow);
            ViewStateHolder.put(ViewStateKeys.処理モード, mode);
            return ResponseData.of(div).respond();
        }
        //<editor-fold defaultstate="collapsed" desc="コメント中…必要がありそうならば、復活する。">
//        if (選択行.getShinsakaiJunjo().equals(更新対象行.getShinsakaiJunjo())) {
//            return ResponseData.of(div).respond();
//        }
//        if (!ResponseHolder.isReRequest()) {
//            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
//                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
//            return ResponseData.of(div).addMessage(message).respond();
//        }
//        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
//                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//            handler.set個別表示欄入力可();
//            handler.displayTo個別表示欄(選択行);
//            return ResponseData.of(div).respond();
//        }
//        handler.set選択行(更新対象行.getShinsakaiJunjo());
//</editor-fold >
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタンを押下しました。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_KaKuTeiButton(ShinsakaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).validate個別();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.set個別表示欄To更新中Row(ViewStateHolder.get(ViewStateKeys.処理モード, OperationMode.class));
        handler.clear個別表示欄();
        handler.set個別表示欄入力不可();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力をやめるボタンを押下イベント
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_btnCancel(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.clear個別表示欄();
        handler.set個別表示欄入力不可();
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_btnBack(ShinsakaiKekkaTorokuDiv div) {
        removeViewState();
        return ResponseData.of(div).forwardWithEventName(DBE5230001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「保存する」ボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_Save(ShinsakaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).validate全体();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            service.saveBy(new ShinsaKekkaPreserver(div));
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        if (new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            removeViewState();
            return ResponseData.of(div).forwardWithEventName(DBE5230001TransitionEventName.一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    //<editor-fold defaultstate="collapsed" desc="ShinsaKekkaPreserver">
    @lombok.AllArgsConstructor
    private static class TaishoshaIchiranRow {

        private final dgTaishoshaIchiran_Row aRow;

        private ShinseishoKanriNo getShinseishoKanriNo() {
            return new ShinseishoKanriNo(aRow.getShinseishoKanriNo());
        }

        private FlexibleDate getNijiHanteiYMD() {
            return aRow.getNijiHanteiDate().getValue();
        }

        private Code getKonkaiNijiHanteiCode() {
            RString code = aRow.getKonkaiNijiHanteiCode();
            if (RString.isNullOrEmpty(code)) {
                return Code.EMPTY;
            } else {
                return new Code(code);
            }
        }

        @CheckForNull
        private Integer getNinteiKikanTsukiSu() {
            RString num = aRow.getNinteiKikanTukisu();
            if (RString.isNullOrEmpty(num)) {
                return null;
            }
            return Integer.parseInt(num.toString());
        }

        private KaigoRowState getJotai() {
            RString value = aRow.getJotai();
            if (RString.isNullOrEmpty(value)) {
                return KaigoRowState.空白;
            }
            return KaigoRowState.valueOf(value.toString());
        }

        private HanteiKekkaCode getHanteiKekka() {
            RString code = aRow.getHanteiKekkaCode();
            if (RString.isNullOrEmpty(code)) {
                return null;
            }
            return HanteiKekkaCode.toValue(code);
        }

        private Code getHoreiKubunCode() {
            NinteiShinseiKubunShinsei 申請時申請区分 = NinteiShinseiKubunShinsei.toValue(
                    Integer.parseInt(aRow.getShinseiKubunShinseijiCode().toString())
            );
            YokaigoJotaiKubun09 前回二次判定 = YokaigoJotaiKubun09.toValue(aRow.getZenkaiNijiHantei());
            FlexibleDate 前回有効期間終了日 = aRow.getZenkaiYukoKikanShuryoDay().getValue();
            YokaigoJotaiKubun09 今回二次判定 = YokaigoJotaiKubun09.toValue(aRow.getHanteiKekka());
            FlexibleDate 申請日 = aRow.getShinseiDay().getValue();
            NinteiShinseiKubunHorei kubun
                    = NinteiShinseiKubunHoreiMethod.calculate(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
            return (kubun == null)
                    ? Code.EMPTY
                    : new Code(new RString(kubun.getコード()));
        }

        private Code getTorisageKubunCode() {
            NinteiShinseiKubunShinsei 申請時申請区分 = NinteiShinseiKubunShinsei.toValue(
                    Integer.parseInt(aRow.getShinseiKubunShinseijiCode().toString())
            );
            YokaigoJotaiKubun09 前回二次判定 = YokaigoJotaiKubun09.toValue(aRow.getZenkaiNijiHantei());
            FlexibleDate 前回有効期間終了日 = aRow.getZenkaiYukoKikanShuryoDay().getValue();
            YokaigoJotaiKubun09 今回二次判定 = YokaigoJotaiKubun09.toValue(aRow.getHanteiKekka());
            FlexibleDate 申請日 = aRow.getShinseiDay().getValue();
            return TorisageKubun.toValue(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日)
                    .get取下げ区分コード();
        }

        private RString getShinsakaiIkenShuruiCode() {
            return aRow.getHidIkenCode();
        }

        private RString getShinsakaiMemo() {
            return aRow.getHidMemo();
        }

        private RString getShinsakaiIken() {
            return aRow.getHidIken();
        }

        private RString getIchijiHanteiKekkaHenkoRiyu() {
            return aRow.getIchijiHanteiKekkaHenkoRiyu();
        }

        private Code getJotaiZoReiCode() {
            RString code = aRow.getJotaizoCode();
            if (RString.isNullOrEmpty(code)) {
                return Code.EMPTY;
            } else {
                return new Code(code);
            }
        }

        private FlexibleDate getNinteiYukoKikanKaishiYMD() {
            return aRow.getNinteiKikanKaishi().getValue();
        }

        private FlexibleDate getNinteiYukoKikanShuryoYMD() {
            return aRow.getNinteiKikanShuryo().getValue();
        }
    }

    private static class ShinsaKekkaPreserver implements IShinsaKekkaPreserver {

        private final ShinsakaiKekkaTorokuDiv div;

        ShinsaKekkaPreserver(ShinsakaiKekkaTorokuDiv div) {
            this.div = div;
        }

        @Override
        public void saveBy(IShinsakakKekksaTorokuManager service) {
            save審査結果(service, this.div);
        }

        private void save審査結果(IShinsakakKekksaTorokuManager manager, ShinsakaiKekkaTorokuDiv div) {
            List<dgTaishoshaIchiran_Row> rowList = div.getDgTaishoshaIchiran().getDataSource();
            RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
            for (dgTaishoshaIchiran_Row row : rowList) {
                TaishoshaIchiranRow row2 = new TaishoshaIchiranRow(row);
                switch (row2.getJotai()) {
                    case 修正:
                        saveBy(manager, row2, 開催番号);
                        continue;
                    case 削除:
                        deleteBy(manager, row2, 開催番号);
                    default:
                }
            }
        }

        private static void saveBy(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, RString 開催番号) {
            HanteiKekkaCode hanteiKekka = row.getHanteiKekka();
            update介護認定審査会割当情報(manager, row, 開催番号, hanteiKekka);
            update要介護認定完了情報(manager, row, hanteiKekka);
            switch (hanteiKekka) {
                case 再審査:
                    return;
                case 認定:
                    save要介護認定結果情報(manager, row, 開催番号, true);
                default:
            }
        }

        //<editor-fold defaultstate="collapsed" desc="methods for saveBy()">
        private static void update介護認定審査会割当情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row,
                RString 開催番号, HanteiKekkaCode hanteiKekka) {
            Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiWariateJohoJoho
                    = ViewStateHolder.get(ViewStateKeys.介護認定審査会開催予定情報, Models.class);
            ShinsakaiWariateJohoIdentifier identifier
                    = new ShinsakaiWariateJohoIdentifier(開催番号, row.getShinseishoKanriNo());
            ShinsakaiWariateJoho shinsakaiWariateJoho = shinsakaiWariateJohoJoho.get(identifier);
            ShinsakaiWariateJohoBuilder shinsakaiWariate = shinsakaiWariateJoho.createBuilderForEdit();
            shinsakaiWariate.set判定結果コード(hanteiKekka == null ? Code.EMPTY : hanteiKekka.getCode());
            shinsakaiWariateJoho = shinsakaiWariate.build();
            manager.save介護認定審査会割当情報(shinsakaiWariateJoho);
        }

        private static void update要介護認定完了情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, HanteiKekkaCode code) {
            if (HanteiKekkaCode.認定 == code || null == code) {
                return;
            }

            Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho
                    = ViewStateHolder.get(ViewStateKeys.要介護認定完了情報, Models.class);
            NinteiKanryoJohoIdentifier identifier = new NinteiKanryoJohoIdentifier(row.getShinseishoKanriNo());
            NinteiKanryoJoho ninteiKanryo = ninteiKanryoJoho.get(identifier);
            manager.save要介護認定完了情報(edited(ninteiKanryo, code));
        }

        private static NinteiKanryoJoho edited(NinteiKanryoJoho kanryo, HanteiKekkaCode code) {
            NinteiKanryoJohoBuilder builder = kanryo.createBuilderForEdit();
            if (HanteiKekkaCode.再審査 == code || HanteiKekkaCode.未審査 == code) {
                builder.set認定審査会割当完了年月日(null);
                return builder.build();
            }

            if (HanteiKekkaCode.再調査_意見書のみ == code || HanteiKekkaCode.再調査_調査_意見書 == code) {
                builder.set主治医意見書作成依頼完了年月日(null);
                builder.set主治医意見書登録完了年月日(null);
            }
            if (HanteiKekkaCode.再調査_調査のみ == code || HanteiKekkaCode.再調査_調査_意見書 == code) {
                builder.set認定調査依頼完了年月日(null);
                builder.set認定調査完了年月日(null);
            }
            builder.set要介護認定一次判定完了年月日(null);
            builder.setマスキング完了年月日(null);
            builder.set認定審査会割当完了年月日(null);
            return builder.build();
        }

        private static void updateOrReset要介護認定申請情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row,
                boolean updates) {
            Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho
                    = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, Models.class);
            NinteiShinseiJohoIdentifier identifier = new NinteiShinseiJohoIdentifier(row.getShinseishoKanriNo());
            NinteiShinseiJoho ninteiShinsei = ninteiShinseiJoho.get(identifier);
            NinteiShinseiJohoBuilder ninteiShinseiBuilder = ninteiShinsei.createBuilderForEdit();
            if (updates) {
                ninteiShinseiBuilder.set認定申請区分_法令_コード(row.getHoreiKubunCode());
                ninteiShinseiBuilder.set取下区分コード(row.getTorisageKubunCode());
            } else {
                ninteiShinseiBuilder.set認定申請区分_法令_コード(Code.EMPTY);
                ninteiShinseiBuilder.set取下区分コード(Code.EMPTY);
            }
            ninteiShinsei = ninteiShinseiBuilder.build();
            manager.save要介護認定申請情報(ninteiShinsei);
        }

        private static void save要介護認定結果情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, RString 開催番号,
                boolean insertsOrUpdates) {
            Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho
                    = ViewStateHolder.get(ViewStateKeys.要介護認定結果情報, Models.class);
            NinteiKekkaJohoIdentifier identifier = new NinteiKekkaJohoIdentifier(row.getShinseishoKanriNo());
            NinteiKekkaJoho ninteiKekka = ninteiKekkaJoho.get(identifier);
            if (!insertsOrUpdates) {
                manager.save要介護認定結果情報(ninteiKekka.deleted());
                return;
            }
            if (ninteiKekka == null) {
                ninteiKekka = new NinteiKekkaJoho(identifier.get申請書管理番号());
            }
            manager.save要介護認定結果情報(edited(ninteiKekka, row, 開催番号));
        }

        private static NinteiKekkaJoho edited(NinteiKekkaJoho o, TaishoshaIchiranRow row, RString 開催番号) {
            NinteiKekkaJohoBuilder builder = o.createBuilderForEdit();
            builder.set二次判定年月日(row.getNijiHanteiYMD());
            builder.set二次判定要介護状態区分コード(row.getKonkaiNijiHanteiCode());
            Integer tsukiSu = row.getNinteiKikanTsukiSu();
            if (tsukiSu != null) {
                builder.set二次判定認定有効期間(tsukiSu);
            }
            builder.set二次判定認定有効開始年月日(row.getNinteiYukoKikanKaishiYMD());
            builder.set二次判定認定有効終了年月日(row.getNinteiYukoKikanShuryoYMD());
            builder.set介護認定審査会開催番号(開催番号);
            builder.set介護認定審査会意見(row.getShinsakaiIken());
            builder.set一次判定結果変更理由(row.getIchijiHanteiKekkaHenkoRiyu());
            builder.set要介護状態像例コード(row.getJotaiZoReiCode());
            builder.set認定審査会意見種類(row.getShinsakaiIkenShuruiCode());
            builder.set審査会メモ(row.getShinsakaiMemo());
            builder.set二次判定結果入力方法(二次判定結果入力方法_画面入力);
            builder.set二次判定結果入力年月日(FlexibleDate.getNowDate());
            return builder.build();
        }
        //</editor-fold>

        private static void deleteBy(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, RString 開催番号) {
            updateOrReset要介護認定申請情報(manager, row, false);
            save要介護認定結果情報(manager, row, 開催番号, false);
            update介護認定審査会割当情報(manager, row, 開催番号, null);
        }
    }
    //</editor-fold>

    /**
     * 「判定結果」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_HanteiKekka(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).set個別入力制御変更from判定結果();
        return ResponseData.of(div).respond();
    }

    /**
     * 「二次判定」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NijiHantei(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.set認定期間月数from申請内容();
        handler.change有効月数に関連するコントロール();
        handler.set認定期間開始日();
        handler.set認定期間終了日();

        handler.set判定結果DDLfrom二次判定();

        if (handler.get今回二次判定() == YokaigoJotaiKubun09.非該当) {
            handler.set認定期間Deisabled(true);
        } else {
            handler.set認定期間Deisabled(false);
        }

        if (handler.get今回二次判定() == YokaigoJotaiKubun09.要介護1) {
            handler.set状態像Deisabled(false);
        } else {
            handler.set状態像Deisabled(true);
        }

        NinteiShinseiKubunShinsei 申請時申請区分 = handler.get申請時申請区分();
        YokaigoJotaiKubun09 前回二次判定 = handler.get前回二次判定();
        FlexibleDate 前回有効期間終了日 = handler.get前回有効期間終了日();
        YokaigoJotaiKubun09 今回二次判定 = handler.get今回二次判定();
        FlexibleDate 申請日 = div.getTxtShinseiDay().getValue();
        NinteiShinseiKubunHorei 法令申請区分 = NinteiShinseiKubunHoreiMethod.calculate(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
        TorisageKubun 取下区分 = TorisageKubun.toValue(申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日);
        handler.set法令申請区分(法令申請区分);
        handler.set取下区分(取下区分);
        return ResponseData.of(div).respond();
    }

    /**
     * 「有効月数」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanMonth(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.change有効月数に関連するコントロール();
        if (handler.get認定期間月数() == 0) {
            return ResponseData.of(div).respond();
        }
        if (handler.get認定期間開始日() == null) {
            handler.set認定期間開始日();
        }
        handler.set認定期間終了日();
        return ResponseData.of(div).respond();
    }

    /**
     * メモ定型文ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnMemoTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(審査会メモ定型文GroupCode);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択したメモ定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnMemoTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtShinsakaiMemo().getValue() == null
                ? RString.EMPTY : div.getTxtShinsakaiMemo().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtShinsakaiMemo().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 意見書定型文ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIkenTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(意見書定型文GroupCode);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択した意見書定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnIkenTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {

        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtShinsakaiIken().getValue() == null
                ? RString.EMPTY : div.getTxtShinsakaiIken().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtShinsakaiIken().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定結果変更理由ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIChiTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(一次判定結果変更理由定型文GroupCode);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択した一次判定結果変更理由定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnIChiTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {

        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtIchijiHanteiKekkaHenkoRiyu().getValue() == null
                ? RString.EMPTY : div.getTxtIchijiHanteiKekkaHenkoRiyu().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtIchijiHanteiKekkaHenkoRiyu().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査状況照会ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnNinteiChosaJokyoShokai(ShinsakaiKekkaTorokuDiv div) {
        RString 申請書管理番号 = getHandler(div).get申請書管理番号();
        div.setHdnDialogDisplayModeKey(認定調査状況ダイアログ_照会モード);
        if (申請書管理番号 == null) {
            div.setHdnNinteiChosaJokyo(null);
        } else {
            NinteiChosaJokyoFinder finder = NinteiChosaJokyoFinder.createInstance();
            NinteiChosaJokyoDataPass konkaiDataPass = finder.get認定調査状況DataPass(new ShinseishoKanriNo(申請書管理番号));
            RDate 予定年月日 = (div.getKyotsuHyojiArea().getTxtShinsakaiKaisaiYoteiYMD().getValue() == null) ? null
                    : new RDate(div.getKyotsuHyojiArea().getTxtShinsakaiKaisaiYoteiYMD().getValue().toString());
            konkaiDataPass.set認定審査会予定年月日(予定年月日);
            div.setHdnNinteiChosaJokyo(DataPassingConverter.serialize(konkaiDataPass));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 1.5次判定ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIchigoHantei(ShinsakaiKekkaTorokuDiv div) {
        RString 申請書管理番号 = getHandler(div).get申請書管理番号();
        div.getKobetsuHyojiArea().setIchigoMode(一_五次判定ダイアログ_照会モード);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定期間From」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanFrom(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        if (handler.get認定期間開始日() == null) {
            return ResponseData.of(div).respond();
        }
        if (handler.get認定期間月数() == 0) {
            handler.set認定期間月数from申請内容();
        }
        handler.set認定期間終了日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定期間To」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanTo(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        if (handler.get認定期間開始日() == null || handler.get認定期間終了日() == null) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).set認定期間月数from認定期間();
        getHandler(div).change有効月数に関連するコントロール();
        return ResponseData.of(div).respond();
    }

    private ShinsakaiKekkaTorokuHandler getHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuHandler(div);
    }

    private ShinsakaiKekkaTorokuValidationHandler getValidationHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuValidationHandler(div);
    }

    private void removeViewState() {
        ViewStateHolder.remove(ViewStateKeys.介護認定審査会開催予定情報.name());
        ViewStateHolder.remove(ViewStateKeys.要介護認定申請情報.name());
        ViewStateHolder.remove(ViewStateKeys.要介護認定結果情報.name());
        ViewStateHolder.remove(ViewStateKeys.要介護認定完了情報.name());
        ViewStateHolder.remove(ViewStateKeys.開催番号.name());
        ViewStateHolder.remove(ViewStateKeys.申請書管理番号.name());
    }
}
