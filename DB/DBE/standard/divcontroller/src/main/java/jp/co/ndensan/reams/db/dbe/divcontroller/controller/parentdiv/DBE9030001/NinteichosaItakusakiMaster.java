/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE9030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.DBE9030001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.DBE9030001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiJohoCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiMasterDivSpec;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9030001.NinteichosaItakusakiMasterHandler;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 認定調査委託先マスタのクラスです
 */
public class NinteichosaItakusakiMaster {

    private static final RString CSV出力完了 = new RString("CSV出力");
    private static final RString 削除状態 = new RString("削除");
    private static final RString 追加状態コード = new RString("追加");
    private static final RString 修正状態コード = new RString("修正");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 市町村の合法性チェックreplace = new RString("市町村コード");
    private static final RString その他状態コード = new RString("その他");
    private static final CodeShubetsu 割付地区名称コード種別 = new CodeShubetsu("5002");
    private static final RString CSVファイル名 = new RString("認定調査委託先情報.csv");

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onLoad(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE9030001StateName.検索);
    }

    /**
     * 検索条件入力項目をクリアする。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnClearKensakuJoken(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件に従い、調査委託先情報を検索する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnSearchShujii(NinteichosaItakusakiMasterDiv div) {
        List<KoseiShichosonMaster> list = getHandler(div).searchShujii();
        if (list.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).setDataSource(list);
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示する
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnInsert(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).set追加状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 修正アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力可能にする
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByModifyButton_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).set修正状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 削除アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力不可にする
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByDeleteButton_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).set削除状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 選択行の内容を、明細エリアに表示
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByDlbClick_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).onSelectByDlbClick_dgChosainIchiran();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * ＣＳＶを出力する
     *
     * @param div
     * @param response
     * @return
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(NinteichosaItakusakiMasterDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        CsvWriter<NinteichosaItakusakiJohoCsvEntity> csvWriter = new CsvWriter.InstanceBuilder(filePath).canAppend(true).
                setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8).setNewLine(NewLine.CRLF).hasHeader(true).build();
        for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
            csvWriter.writeLine(converterDataSourceFromToCsvEntity(div, row));
        }
        csvWriter.close();
        FilesystemName sharedFileName = new FilesystemName(CSVファイル名);
        RDateTime sharedFileId = SharedFile.copyToSharedFile(new FilesystemPath(filePath), sharedFileName);

        return SharedFileDirectAccessDownload.directAccessDownload(sharedFileName, sharedFileId, CSVファイル名, response);
//        TODO QA #72362
//        if (!ResponseHolder.isReRequest()) {
//            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
//            IValidationMessages messages = ValidationMessagesFactory.createInstance();
//            DBE9030001ErrorMessage 対象データなし = new DBE9030001ErrorMessage(UrErrorMessages.対象データなし);
//            messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先一覧データの存在チェック)
//                    .thenAdd(対象データなし).messages());
//            messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先一覧データの編集しないチェック)
//                    .thenAdd(DbzErrorMessages.編集後更新指示).messages());
//            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
//                    対象データなし, div.getChosaitakusakiJohoInput()).build().check(messages));
//            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
//                    DbzErrorMessages.編集後更新指示,
//                    div.getChosaitakusakiJohoInput()).build().check(messages));
//            if (pairs.iterator().hasNext()) {
//                return ResponseData.of(div).addValidationMessages(pairs).respond();
//            }
//            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
//        } else {
//            getHandler(div).outputCsv();
//            div.getCcdKanryoMessage().setSuccessMessage(
//                    new RString(UrInformationMessages.正常終了.getMessage().evaluate()), CSV出力完了, RString.EMPTY);
//            return ResponseData.of(div).setState(DBE9030001StateName.完了);
//        }
    }

//TODO DBZ.JigyoshaInputGuideが未作成
//    public ResponseData<NinteichosaItakusakiMasterDiv> onBeforeClick_btnToSearchjigyosha(NinteichosaItakusakiMasterDiv div) {
//        return ResponseData.of(div).respond();
//    }
    /**
     * 割付地区選択ダイアログを表示する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onBeforeClick_btnToSearchchiku(NinteichosaItakusakiMasterDiv div) {
        div.setHdnTxtCode(div.getChosaitakusakiJohoInput().getTxtChiku().getValue());
        div.getChosaitakusakiJohoInput().getTxtChikuMei().clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 割付地区選択ダイアログを表示する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onOkClose_btnToSearchchiku(NinteichosaItakusakiMasterDiv div) {
        div.getChosaitakusakiJohoInput().getTxtChikuMei().setValue(div.getHdnTxtCodeMeisho());
        return ResponseData.of(div).respond();
    }

    /**
     * 口座情報画面へ遷移する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnKoza(NinteichosaItakusakiMasterDiv div) {
        //TODO 口座情報画面?
        return ResponseData.of(div).forwardWithEventName(null).respond();
    }

    /**
     * 調査員情報管理「DBE9040001」へ遷移する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnChosaininsert(NinteichosaItakusakiMasterDiv div) {
        ViewStateHolder.put(SaibanHanyokeyName.調査委託先コード, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
        return ResponseData.of(div).forwardWithEventName(DBE9030001TransitionEventName.認定調査員へ遷移).respond();
    }

    /**
     * 入力明細エリアの入力内容を破棄し、調査委託先一覧エリアへ戻る
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnTorikeshi(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()
                && (div.get状態().equals(追加状態コード) || div.get状態().equals(修正状態コード))) {
            if (getHandler(div).is調査委託先情報登録エリア編集有り()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            div.getChosaitakusakiJohoInput().clear();
            return ResponseData.of(div).setState(DBE9030001StateName.一覧);
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            div.getChosaitakusakiJohoInput().clear();
            return ResponseData.of(div).setState(DBE9030001StateName.一覧);
        }
        if (div.get状態().equals(その他状態コード)) {
            return ResponseData.of(div).setState(DBE9030001StateName.一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 入力明細エリアの入力内容を調査委託先一覧に反映させる。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnKakutei(NinteichosaItakusakiMasterDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE9030001ErrorMessage 編集なしで更新不可 = new DBE9030001ErrorMessage(UrErrorMessages.編集なしで更新不可);
        DBE9030001ErrorMessage 入力値が不正_追加メッセージあり
                = new DBE9030001ErrorMessage(UrErrorMessages.入力値が不正_追加メッセージあり, 市町村の合法性チェックreplace.toString());
        DBE9030001ErrorMessage 既に登録済 = new DBE9030001ErrorMessage(
                UrErrorMessages.既に登録済, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue() == null
                ? RString.EMPTY.toString() : div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue().toString());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先情報登録エリアの編集状態チェック)
                .thenAdd(編集なしで更新不可).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.市町村の合法性チェック)
                .thenAdd(入力値が不正_追加メッセージあり).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先コードの重複チェック)
                .thenAdd(既に登録済).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                編集なしで更新不可, div.getChosaitakusakiJohoInput()).build().check(messages));
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                入力値が不正_追加メッセージあり, div.getChosaitakusakiJohoInput().getTxtShichoson()).build().check(messages));
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                既に登録済, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki()).build().check(messages));
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).onClick_btnKakutei();
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 調査委託先検索へ戻る
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnReSearch(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (is一覧エリア編集有り(div)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
            } else {
                return onLoad(div);
            }
        } else {
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
                return onLoad(div);
            }
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 入力データをＤＢに保存する
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnUpdate(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            DBE9030001ErrorMessage 編集なしで更新不可 = new DBE9030001ErrorMessage(UrErrorMessages.編集なしで更新不可);
            messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先一覧データの編集中チェック)
                    .thenAdd(編集なしで更新不可).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    編集なしで更新不可, div.getChosaitakusakiJohoInput()).build().check(messages));
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            } else {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            int rowIndex = 0;
            for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
                if (削除状態.equals(row.getJotai())) {
                    if (!getHandler(div).削除行データの整合性チェック(
                            new LasdecCode(div.getHdnShichosonCodeList().split(CSV_WRITER_DELIMITER.toString())
                                    .get(rowIndex)), row.getChosaItakusakiCode().getValue())) {
                        throw new ApplicationException(DbeErrorMessages.他の情報で使用している為削除不可.getMessage());
                    }
                }
                rowIndex++;
            }
            getHandler(div).save調査委託先一覧データ();
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE9030001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private NinteichosaItakusakiMasterHandler getHandler(NinteichosaItakusakiMasterDiv div) {
        return new NinteichosaItakusakiMasterHandler(div);
    }

    private boolean is一覧エリア編集有り(NinteichosaItakusakiMasterDiv div) {
        for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
            if (!row.getJotai().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private NinteichosaItakusakiJohoCsvEntity converterDataSourceFromToCsvEntity(NinteichosaItakusakiMasterDiv div, dgChosainIchiran_Row row) {
        NinteichosaItakusakiJohoCsvEntity csvEntity = new NinteichosaItakusakiJohoCsvEntity();
        csvEntity.set市町村コード(div.getHdnShichosonCodeList().split(CSV_WRITER_DELIMITER.toString())
                .get(Integer.valueOf(div.getHdnSelectID().toString())));
        csvEntity.set市町村(row.getShichoson());
        csvEntity.set調査委託先コード(row.getChosaItakusakiCode().getValue());
        csvEntity.set事業者番号(row.getJigyoshaNo());
        csvEntity.set調査委託先名称(row.getChosaItakusakiMeisho());
        csvEntity.set調査委託先カナ名称(row.getChosaItakusakiKana());
        csvEntity.set郵便番号(row.getYubinNo());
        csvEntity.set住所(row.getJusho());
        csvEntity.set電話番号(row.getTelNo());
        csvEntity.setＦＡＸ番号(row.getFaxNo());
        csvEntity.set機関代表者氏名(row.getKikanDaihyoshaName());
        csvEntity.set機関代表者カナ氏名(row.getKikanDaihyoshaKanaName());
        csvEntity.set調査委託区分(row.getChosaItakuKubun());
        csvEntity.set特定調査員表示フラグ(row.getTokuteiChosainDispFlag());
        csvEntity.set割付定員(new RString(row.getWaritsukeTeiin().getValue().toString()));
        csvEntity.set割付地区コード(row.getChiku());
        csvEntity.set割付地区名称(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, 割付地区名称コード種別, new Code(row.getChiku())));
        csvEntity.set自動割付フラグ(row.getAutoWaritsukeFlag());
        csvEntity.set機関の区分(row.getKikanKubun());
        csvEntity.set状況フラグ(row.getJokyoFlag());
        return csvEntity;
    }

    private static class DBE9030001ErrorMessage implements IMessageGettable, IValidationMessage {

        private final Message message;

        public DBE9030001ErrorMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
