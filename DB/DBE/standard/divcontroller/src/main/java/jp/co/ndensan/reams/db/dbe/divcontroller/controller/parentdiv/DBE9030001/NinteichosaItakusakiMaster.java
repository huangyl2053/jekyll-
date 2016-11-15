/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE9030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.ShichosonMeishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaItakusakiJohoRelate;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.DBE9030001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.DBE9030001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiJohoCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiMasterDivSpec;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9030001.NinteichosaItakusakiMasterHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosainmaster.NinteiChosainMasterFinder;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector.KoseiShiChosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKikanKubun;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 認定調査委託先マスタのクラスです
 *
 * @reamsid_L DBE-0270-010 liangbc
 */
public class NinteichosaItakusakiMaster {

    private static final RString 状況フラグ有効 = new RString("有効");
    private static final RString 自動割付フラグ可能 = new RString("可能");
    private static final RString 特定調査員表示フラグ表示 = new RString("表示");
    private static final RString 削除状態 = new RString("削除");
    private static final RString 追加状態コード = new RString("追加");
    private static final RString 修正状態コード = new RString("修正");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 市町村の合法性チェックREPLACE = new RString("市町村コード");
    private static final RString その他状態コード = new RString("その他");
    private static final RString CSVファイル名 = new RString("認定調査委託先情報.csv");
    private static final RString 構成市町村マスタ市町村コード重複種別
            = DbBusinessConfig.get(ConfigNameDBE.構成市町村マスタ市町村コード重複種別, new RDate("20000401"),
                    SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("構成市町村マスタ市町村コード重複種別"));
    private static final RString 四マスタ優先表示市町村識別ID
            = DbBusinessConfig.get(ConfigNameDBE.四マスタ優先表示市町村識別ID, new RDate("20000401"),
                    SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("四マスタ優先表示市町村識別ID"));

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onLoad(NinteichosaItakusakiMasterDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, true);
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE9030001StateName.検索);
    }

    public ResponseData<NinteichosaItakusakiMasterDiv> onActive(NinteichosaItakusakiMasterDiv div) {
        if (div.get状態().equals(追加状態コード)) {
            ViewStateHolder.put(ViewStateKeys.状態, false);
            div.set状態(修正状態コード);
            div.setHdnSelectID(new RString(String.valueOf(div.getChosaitakusakichiran().getDgChosainIchiran().getClickedRowId())));
            div.getChosaitakusakiJohoInput().getTxtShichoson().setDisabled(Boolean.TRUE);
            div.getChosaitakusakiJohoInput().getBtnToSearchShichoson().setDisabled(Boolean.TRUE);
            div.getChosaitakusakiJohoInput().getTxtShichosonmei().setDisabled(Boolean.TRUE);
            div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().setDisabled(Boolean.TRUE);
            div.getChosaitakusakiJohoInput().getBtnKakutei().setDisabled(Boolean.FALSE);
            div.getChosaitakusakiJohoInput().getBtnKoza().setVisible(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件入力項目をクリアする。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnClearKensakuJoken(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件に従い、調査委託先情報を検索する。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnSearchShujii(NinteichosaItakusakiMasterDiv div) {
        List<KoseiShichosonMaster> list = getHandler(div).searchShujii();
        getHandler(div).setDataSource(list);
        if (list.isEmpty()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            DBE9030001ErrorMessage 該当データなし = new DBE9030001ErrorMessage(UrErrorMessages.該当データなし);
            pairs.add(new ValidationMessageControlPair(該当データなし));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示する
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnInsert(NinteichosaItakusakiMasterDiv div) {
        div.set状態(追加状態コード);
        getHandler(div).set追加状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 修正アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力可能にする
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByModifyButton_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        div.set状態(修正状態コード);
        getHandler(div).set修正状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 削除アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力不可にする
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByDeleteButton_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).set削除状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 選択行の内容を、明細エリアに表示
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByDlbClick_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).onSelectByDlbClick_dgChosainIchiran();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * ＣＳＶを出力する
     *
     * @param div 画面情報
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(NinteichosaItakusakiMasterDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<NinteichosaItakusakiJohoCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(true).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            int rowIndex = 0;
            for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
                csvWriter.writeLine(converterDataSourceFromToCsvEntity(div, row, rowIndex));
                rowIndex++;
            }
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 口座情報画面へ遷移する。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onBeforeOpenDialog_btnKoza(NinteichosaItakusakiMasterDiv div) {
        div.setHdnShikibetsuCode(div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
        div.setHdnSubGyomuCode(SubGyomuCode.DBE認定支援.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 調査員情報管理「DBE9040001」へ遷移する。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnChosaininsert(NinteichosaItakusakiMasterDiv div) {
        ViewStateHolder.put(SaibanHanyokeyName.調査委託先コード, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
        ViewStateHolder.put(ViewStateKeys.市町村コード, div.getChosaitakusakiJohoInput().getTxtShichoson().getValue());

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE9030001ErrorMessage 編集なしで更新不可 = new DBE9030001ErrorMessage(UrErrorMessages.編集なしで更新不可);
        DBE9030001ErrorMessage 入力値が不正_追加メッセージあり
                = new DBE9030001ErrorMessage(UrErrorMessages.入力値が不正_追加メッセージあり, 市町村の合法性チェックREPLACE.toString());
        DBE9030001ErrorMessage 既に登録済 = new DBE9030001ErrorMessage(
                UrErrorMessages.既に登録済, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue() == null
                ? RString.EMPTY.toString() : div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue().toString());
        if (!div.get状態().equals(追加状態コード) && !div.get状態().equals(修正状態コード)) {
            messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先情報登録エリアの編集状態チェック)
                    .thenAdd(編集なしで更新不可).messages());
        }
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

        if (div.get状態().equals(追加状態コード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(new RString("調査委託先情報を登録してから画面遷移して").toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

                NinteichosaItakusakiJohoManager johoManager = NinteichosaItakusakiJohoManager.createInstance();

                NinteichosaItakusaki ninteichosaItakusaki = new NinteichosaItakusaki();
                ninteichosaItakusaki.getEntity().setShichosonCode(new LasdecCode(div.getChosaitakusakiJohoInput().getTxtShichoson().getValue()));
                ninteichosaItakusaki.getEntity().setNinteichosaItakusakiCode(div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
                ninteichosaItakusaki.getEntity().setJigyoshaNo(new JigyoshaNo(div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue()));
                ninteichosaItakusaki.getEntity().setJigyoshaMeisho(div.getChosaitakusakiJohoInput().getTxtChosaitakusakiname().getValue());
                ninteichosaItakusaki.getEntity().setJigyoshaMeishoKana(div.getChosaitakusakiJohoInput().getTxtChosaitakusakiKananame().getValue());
                ninteichosaItakusaki.getEntity().setYubinNo(div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue());
                ninteichosaItakusaki.getEntity().setJusho(div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().getColumnValue());
                ninteichosaItakusaki.getEntity().setTelNo(new TelNo(div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain().getColumnValue()));
                ninteichosaItakusaki.getEntity().setFaxNo(new TelNo(div.getChosaitakusakiJohoInput().getTxtFaxNo().getDomain().getColumnValue()));
                ninteichosaItakusaki.getEntity().setDaihyoshaName(div.getChosaitakusakiJohoInput().getTxtdaihyoshaname().getValue());
                ninteichosaItakusaki.getEntity().setDaihyoshaNameKana(div.getChosaitakusakiJohoInput().getTxtdaihyoshakananame().getValue());
                RString chosaItakuKubunCode;
                try {
                    chosaItakuKubunCode = ChosaItakuKubunCode.toValueFrom名称(div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedValue()).getコード();
                } catch (IllegalArgumentException e) {
                    chosaItakuKubunCode = RString.EMPTY;
                }
                ninteichosaItakusaki.getEntity().setChosaItakuKubun(chosaItakuKubunCode);
                ninteichosaItakusaki.getEntity().setTokuteiChosainDisplayFlag(div.getChosaitakusakiJohoInput().getDdltokuteichosain().getSelectedValue().equals(特定調査員表示フラグ表示));
                ninteichosaItakusaki.getEntity().setWaritsukeTeiin(div.getChosaitakusakiJohoInput().getTxtTeiin().getValue().intValue());
                ninteichosaItakusaki.getEntity().setWaritsukeChiku(new ChikuCode(div.getChosaitakusakiJohoInput().getCcdChiku().getCode().getKey()));
                ninteichosaItakusaki.getEntity().setAutoWaritsukeFlag(自動割付フラグ可能.equals(div.getChosaitakusakiJohoInput().getRadautowatitsuke().getSelectedValue()));
                RString chosaKikanKubun;
                try {
                    chosaKikanKubun = ChosaKikanKubun.toValue(div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedKey()).getコード();
                } catch (IllegalArgumentException e) {
                    chosaKikanKubun = RString.EMPTY;
                }
                ninteichosaItakusaki.getEntity().setKikanKubun(chosaKikanKubun);
                ninteichosaItakusaki.getEntity().setJokyoFlag(状況フラグ有効.equals(div.getChosaitakusakiJohoInput().getRadChosainJokyo().getSelectedValue()));

                NinteichosaItakusakiJohoRelate johoRelate = new NinteichosaItakusakiJohoRelate();
                johoRelate.getEntity().set認定調査委託先情報Entity(ninteichosaItakusaki.getEntity());
                NinteichosaItakusakiJoho joho = new NinteichosaItakusakiJoho(johoRelate.getEntity());
                johoManager.save(joho);

                int selectID = -1;
                if (!RString.isNullOrEmpty(div.getHdnSelectID())) {
                    selectID = Integer.valueOf(div.getHdnSelectID().toString());
                }

                TextBoxCode 認定調査委託先コード = new TextBoxCode();
                TextBoxNum 割付定員 = new TextBoxNum();
                認定調査委託先コード.setValue(div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
                割付定員.setValue(div.getChosaitakusakiJohoInput().getTxtTeiin().getValue());
                dgChosainIchiran_Row row = new dgChosainIchiran_Row(
                        RString.EMPTY,
                        div.getChosaitakusakiJohoInput().getTxtShichosonmei().getValue(),
                        認定調査委託先コード,
                        div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue() == null
                        ? RString.EMPTY : new RString(div.getChosaitakusakiJohoInput().getTxtjigyoshano().getValue().toString()),
                        div.getChosaitakusakiJohoInput().getTxtChosaitakusakiname().getValue(),
                        div.getChosaitakusakiJohoInput().getTxtChosaitakusakiKananame().getValue(),
                        div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue().getEditedYubinNo(),
                        div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().getColumnValue(),
                        div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain().getColumnValue(),
                        div.getChosaitakusakiJohoInput().getTxtFaxNo().getDomain().getColumnValue(),
                        div.getChosaitakusakiJohoInput().getTxtdaihyoshaname().getValue(),
                        div.getChosaitakusakiJohoInput().getTxtdaihyoshakananame().getValue(),
                        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedValue(),
                        div.getChosaitakusakiJohoInput().getDdltokuteichosain().getSelectedValue(),
                        割付定員,
                        div.getChosaitakusakiJohoInput().getCcdChiku().getCode().getColumnValue(),
                        div.getChosaitakusakiJohoInput().getCcdChiku().getCodeMeisho(),
                        div.getChosaitakusakiJohoInput().getRadautowatitsuke().getSelectedValue(),
                        div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedValue(),
                        div.getChosaitakusakiJohoInput().getRadChosainJokyo().getSelectedValue());
                if (selectID == -1) {
                    div.setHdnShichosonCodeList(div.getHdnShichosonCodeList().concat(
                            div.getChosaitakusakiJohoInput().getTxtShichoson().getValue()).concat(CSV_WRITER_DELIMITER));
                    div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().add(row);
                } else {
                    div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().set(selectID, row);
                }

                return ResponseData.of(div).forwardWithEventName(DBE9030001TransitionEventName.認定調査員へ遷移).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBE9030001TransitionEventName.認定調査員へ遷移).respond();
    }

    /**
     * 入力明細エリアの入力内容を破棄し、調査委託先一覧エリアへ戻る
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnTorikeshi(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()
                && (div.get状態().equals(追加状態コード) || div.get状態().equals(修正状態コード))) {
            if (getHandler(div).is調査委託先情報登録エリア編集有り()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            getHandler(div).clear();
            ViewStateHolder.put(ViewStateKeys.状態, true);
            return ResponseData.of(div).setState(DBE9030001StateName.一覧);
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).clear();
            ViewStateHolder.put(ViewStateKeys.状態, true);
            return ResponseData.of(div).setState(DBE9030001StateName.一覧);
        }
        if (div.get状態().equals(その他状態コード) || div.get状態().equals(削除状態)) {
            return ResponseData.of(div).setState(DBE9030001StateName.一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 入力明細エリアの入力内容を調査委託先一覧に反映させる。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnKakutei(NinteichosaItakusakiMasterDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE9030001ErrorMessage 編集なしで更新不可 = new DBE9030001ErrorMessage(UrErrorMessages.編集なしで更新不可);
        DBE9030001ErrorMessage 入力値が不正_追加メッセージあり
                = new DBE9030001ErrorMessage(UrErrorMessages.入力値が不正_追加メッセージあり, 市町村の合法性チェックREPLACE.toString());
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
        boolean 状態 = ViewStateHolder.get(ViewStateKeys.状態, boolean.class);
        getHandler(div).onClick_btnKakutei(状態);
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 調査委託先検索へ戻る
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
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
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
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
                if (削除状態.equals(row.getJotai())
                        && !getHandler(div).削除行データの整合性チェック(
                                new LasdecCode(div.getHdnShichosonCodeList().split(CSV_WRITER_DELIMITER.toString())
                                        .get(rowIndex)), row.getChosaItakusakiCode().getValue())) {
                    throw new ApplicationException(DbeErrorMessages.他の情報で使用している為削除不可.getMessage());

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

    /**
     * 委託先一覧へ戻る
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnBackShujiiIchiran(NinteichosaItakusakiMasterDiv div) {
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 委託先検索へ戻る
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnBackSearchShujii(NinteichosaItakusakiMasterDiv div) {
        return ResponseData.of(div).setState(DBE9030001StateName.検索);
    }

    /**
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnComplete(NinteichosaItakusakiMasterDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE9030001TransitionEventName.処理完了).respond();
    }

    /**
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onOkClose_btnToSearchShichoson(NinteichosaItakusakiMasterDiv div) {
        KoseiShiChosonSelectorModel 構成市町村データ
                = ViewStateHolder.get(ViewStateKeys.引き継ぎデータ, KoseiShiChosonSelectorModel.class);
        div.getChosaitakusakiJohoInput().getTxtShichoson().setValue(構成市町村データ.get市町村コード());
        div.getChosaitakusakiJohoInput().getTxtShichosonmei().setValue(構成市町村データ.get市町村名称());
        return ResponseData.of(div).respond();
    }

    /**
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onBeforeOpenDialog_btnToSearchjigyosha(NinteichosaItakusakiMasterDiv div) {
        JigyoshaMode mode = new JigyoshaMode();
        mode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setHdnJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(div).respond();
    }

    /**
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onOkClose_btnToSearchjigyosha(NinteichosaItakusakiMasterDiv div) {
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getHdnJigyoshaMode(), JigyoshaMode.class);
        div.getChosaitakusakiJohoInput().getTxtjigyoshano().setValue(mode.getJigyoshaNo().getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村名を取得します。
     *
     * @param div NinteiChosainMasterDiv
     * @return ResponseData<NinteiChosainMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onBlur_txtShichoson(NinteichosaItakusakiMasterDiv div) {
        RString shichoson = div.getChosaitakusakiJohoInput().getTxtShichoson().getValue();
        if (RString.isNullOrEmpty(shichoson)) {
            div.getChosaitakusakiJohoInput().getTxtShichosonmei().setValue(RString.EMPTY);
            return ResponseData.of(div).respond();
        }

        List<ShichosonMeishoBusiness> list = NinteiChosainMasterFinder.createInstance().getShichosonMeisho(new LasdecCode(shichoson)).records();
        if (list.isEmpty()) {
            div.getChosaitakusakiJohoInput().getTxtShichosonmei().setValue(RString.EMPTY);
            return ResponseData.of(div).respond();
        }

        div.getChosaitakusakiJohoInput().getTxtShichosonmei().setValue(list.get(0).getShichosonMeisho());
        if (構成市町村マスタ市町村コード重複種別.equals(new RString("0"))) {
            return ResponseData.of(div).respond();
        }

        for (ShichosonMeishoBusiness item : list) {
            if (四マスタ優先表示市町村識別ID.equals(item.getShichosonShikibetuID())) {
                div.getChosaitakusakiJohoInput().getTxtShichosonmei().setValue(item.getShichosonMeisho());
                break;
            }
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

    private NinteichosaItakusakiJohoCsvEntity converterDataSourceFromToCsvEntity(
            NinteichosaItakusakiMasterDiv div, dgChosainIchiran_Row row, int rowIndex) {
        NinteichosaItakusakiJohoCsvEntity csvEntity = new NinteichosaItakusakiJohoCsvEntity();
        csvEntity.set市町村コード(div.getHdnShichosonCodeList().split(CSV_WRITER_DELIMITER.toString()).get(rowIndex));
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
        csvEntity.set割付地区コード(row.getChikuCode());
        csvEntity.set割付地区名称(row.getChikuName());
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
