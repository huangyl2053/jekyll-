/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE9030001;

import java.util.ArrayList;
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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiKozaMitorokuJohoCsvEntity;
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
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

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
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 市町村の合法性チェックREPLACE = new RString("市町村コード");
    private static final RString 口座情報チェックREPLACE = new RString("口座情報");
    private static final RString 事業者番号存在チェックREPLACE = new RString("事業者番号");
    private static final RString その他状態コード = new RString("その他");
    private static final RString CSVファイル名 = new RString("認定調査委託先情報.csv");
    private static final RString 構成市町村マスタ市町村コード重複種別
            = DbBusinessConfig.get(ConfigNameDBE.構成市町村マスタ市町村コード重複種別, new RDate("20000401"),
                    SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("構成市町村マスタ市町村コード重複種別"));
    private static final RString 四マスタ優先表示市町村識別ID
            = DbBusinessConfig.get(ConfigNameDBE.四マスタ優先表示市町村識別ID, new RDate("20000401"),
                    SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("四マスタ優先表示市町村識別ID"));
    private static final RString 普通 = new RString("普通");
    private static final RString 当座 = new RString("当座");
    private static final RString 納税準備 = new RString("納税準備");
    private static final RString 貯蓄 = new RString("貯蓄");
    private static final RString その他 = new RString("その他");
    private static final RString OUTPUT_CSV_FILE_NAME = new RString("口座情報未登録機関一覧表.csv");
    private static final RString SELECTKEY_空白 = new RString("blank");
    private static final RString 空白 = new RString("");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onLoad(NinteichosaItakusakiMasterDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, true);
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE9030001StateName.検索);
    }

    /**
     * 活性非活性の処理です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
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
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件入力項目をクリアする。
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnClearKensakuJoken(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件に従い、調査委託先情報を検索する。
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnSearchShujii(NinteichosaItakusakiMasterDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        List<KoseiShichosonMaster> list = getHandler(div).searchShujii();
        getHandler(div).setDataSource(list);
        if (list.isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示する
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
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
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
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
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByDeleteButton_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).set削除状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 選択行の内容を、明細エリアに表示
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByDlbClick_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).onSelectByDlbClick_dgChosainIchiran();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * ＣＳＶを出力前のCheck
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onBeforeDownlaod_btnOutputCsv(NinteichosaItakusakiMasterDiv div) {
        List<dgChosainIchiran_Row> list = div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (list.isEmpty()) {
            pairs.add(new ValidationMessageControlPair(new DBE9030001ErrorMessage(UrErrorMessages.該当データなし)));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        for (dgChosainIchiran_Row row : list) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                pairs.add(new ValidationMessageControlPair(new DBE9030001ErrorMessage(DbzErrorMessages.編集後更新指示)));
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ＣＳＶを出力する
     *
     * @param div 画面情報
     * @param response IDownLoadServletResponse
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(NinteichosaItakusakiMasterDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<NinteichosaItakusakiJohoCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
            int rowIndex = 0;

            KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
            List<KinyuKikan> 金融機関情報 = new ArrayList<>();
            金融機関情報 = kinyuKikanManager.getValidKinyuKikansOn(FlexibleDate.getNowDate());

            for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
                RString 金融機関名称 = RString.EMPTY;
                RString 支店名 = RString.EMPTY;
                if (row.getKinyuKikanCode() != null && !row.getKinyuKikanCode().isEmpty()) {
                    金融機関名称 = getKinyuKikan(金融機関情報, row);
                }
                if (row.getKinyuKikanShitenCode() != null && !row.getKinyuKikanShitenCode().isEmpty()) {
                    支店名 = getKinyuShiten(金融機関情報, row);
                }

                csvWriter.writeLine(converterDataSourceFromToCsvEntity(div, row, rowIndex, 金融機関名称, 支店名));
                rowIndex++;
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 金融機関を取得します。
     *
     * @param 金融機関情報 List<KinyuKikan>
     * @param row dgChosainIchiran_Row
     * @return 金融機関_支店　List<RString>
     */
    private RString getKinyuKikan(List<KinyuKikan> 金融機関情報, dgChosainIchiran_Row row) {
        RString 金融機関 = RString.EMPTY;
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if ((new RString(kinyuKikanJoho.get金融機関コード().toString())).equals(row.getKinyuKikanCode())) {
                金融機関 = kinyuKikanJoho.get金融機関名称();
            }
        }
        return 金融機関;
    }

    /**
     * 金融機関支店を取得します。
     *
     * @param 金融機関情報 List<KinyuKikan>
     * @param row dgChosainIchiran_Row
     * @return 支店名　RString
     */
    private RString getKinyuShiten(List<KinyuKikan> 金融機関情報, dgChosainIchiran_Row row) {
        List<KinyuKikanShiten> 支店リスト = new ArrayList<>();
        RString 支店名 = RString.EMPTY;
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if ((new RString(kinyuKikanJoho.get金融機関コード().toString())).equals(row.getKinyuKikanCode())) {
                支店リスト = kinyuKikanJoho.get支店リスト();
            }
        }
        if (支店リスト != null && !支店リスト.isEmpty()) {
            支店名 = getShitenMeisho(支店リスト, row, 支店名);

        }

        return 支店名;
    }

    private RString getShitenMeisho(List<KinyuKikanShiten> 支店リスト, dgChosainIchiran_Row row, RString 支店名) {
        for (KinyuKikanShiten shiten : 支店リスト) {
            if (new RString(shiten.get支店コード().toString()).equals(row.getKinyuKikanShitenCode())) {
                支店名 = shiten.get支店名称();
            }
        }
        return 支店名;
    }

    /**
     * 口座未登録csvを出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div NinteichosaItakusakiMasterDiv
     * @param response
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnCsvKozaNashi(NinteichosaItakusakiMasterDiv div, IDownLoadServletResponse response) {

        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), OUTPUT_CSV_FILE_NAME);
        try (CsvWriter<NinteichosaItakusakiKozaMitorokuJohoCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build()) {
            List<dgChosainIchiran_Row> dataList = div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource();
            int rowIndex = 0;
            for (dgChosainIchiran_Row row : dataList) {
                if (row.getKinyuKikanCode().isNull() || row.getKinyuKikanCode().isEmpty()) {
                    csvWriter.writeLine(getCsvDataSonota(div, row, rowIndex));
                    rowIndex++;
                }
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(OUTPUT_CSV_FILE_NAME));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, OUTPUT_CSV_FILE_NAME), response);
    }

    private NinteichosaItakusakiKozaMitorokuJohoCsvEntity getCsvDataSonota(NinteichosaItakusakiMasterDiv div, dgChosainIchiran_Row row, int rowIndex) {
        NinteichosaItakusakiKozaMitorokuJohoCsvEntity csvEntity = new NinteichosaItakusakiKozaMitorokuJohoCsvEntity();
        csvEntity.set市町村コード(div.getHdnShichosonCodeList().split(EUC_WRITER_DELIMITER.toString()).get(rowIndex));
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
        csvEntity.set調査委託区分コード(get調査委託区分コード(row.getChosaItakuKubun()));
        csvEntity.set調査委託区分(row.getChosaItakuKubun());
        csvEntity.set特定調査員表示フラグ(row.getTokuteiChosainDispFlag());
        csvEntity.set割付定員(new RString(row.getWaritsukeTeiin().getValue().toString()));
        csvEntity.set割付地区コード(row.getChikuCode());
        csvEntity.set割付地区名称(row.getChikuName());
        csvEntity.set自動割付フラグ(row.getAutoWaritsukeFlag());
        csvEntity.set機関の区分コード(get機関の区分コード(row.getKikanKubun()));
        csvEntity.set機関の区分(row.getKikanKubun());
        csvEntity.set状況フラグ(row.getJokyoFlag());
        return csvEntity;
    }

    private RString get調査委託区分コード(RString 調査委託区分) {
        RString 調査委託区分コード = RString.EMPTY;
        if (調査委託区分.equals(ChosaItakuKubunCode.保険者_市町村等.get名称())) {
            調査委託区分コード = ChosaItakuKubunCode.保険者_市町村等.getコード();
        } else if (調査委託区分.equals(ChosaItakuKubunCode.指定市町村事務受託法人.get名称())) {
            調査委託区分コード = ChosaItakuKubunCode.指定市町村事務受託法人.getコード();
        } else if (調査委託区分.equals(ChosaItakuKubunCode.指定居宅介護支援事業者.get名称())) {
            調査委託区分コード = ChosaItakuKubunCode.指定居宅介護支援事業者.getコード();
        } else if (調査委託区分.equals(ChosaItakuKubunCode.介護保険施設.get名称())) {
            調査委託区分コード = ChosaItakuKubunCode.介護保険施設.getコード();
        } else if (調査委託区分.equals(ChosaItakuKubunCode.介護支援専門員.get名称())) {
            調査委託区分コード = ChosaItakuKubunCode.介護支援専門員.getコード();
        } else if (調査委託区分.equals(ChosaItakuKubunCode.他市町村.get名称())) {
            調査委託区分コード = ChosaItakuKubunCode.他市町村.getコード();
        } else if (調査委託区分.equals(ChosaItakuKubunCode.その他.get名称())) {
            調査委託区分コード = ChosaItakuKubunCode.その他.getコード();
        }
        return 調査委託区分コード;
    }

    private RString get機関の区分コード(RString 機関の区分) {
        RString 機関の区分コード = RString.EMPTY;
        if (機関の区分.equals(ChosaKikanKubun.非調査機関.get名称())) {
            機関の区分コード = ChosaKikanKubun.非調査機関.getコード();
        } else if (機関の区分.equals(ChosaKikanKubun.調査機関.get名称())) {
            機関の区分コード = ChosaKikanKubun.調査機関.getコード();
        }
        return 機関の区分コード;
    }

    /**
     * 口座情報画面へ遷移する。
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
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
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnChosaininsert(NinteichosaItakusakiMasterDiv div) {
        ViewStateHolder.put(SaibanHanyokeyName.調査委託先コード, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
        ViewStateHolder.put(ViewStateKeys.市町村コード, div.getChosaitakusakiJohoInput().getTxtShichoson().getValue());

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE9030001ErrorMessage 編集なしで更新不可 = new DBE9030001ErrorMessage(UrErrorMessages.編集なしで更新不可);
        DBE9030001ErrorMessage 入力値が不正_追加メッセージあり_口座
                = new DBE9030001ErrorMessage(UrErrorMessages.入力値が不正_追加メッセージあり, 口座情報チェックREPLACE.toString());
        DBE9030001ErrorMessage 入力値が不正_追加メッセージあり
                = new DBE9030001ErrorMessage(UrErrorMessages.入力値が不正_追加メッセージあり, 市町村の合法性チェックREPLACE.toString());
        DBE9030001ErrorMessage 既に登録済 = new DBE9030001ErrorMessage(
                UrErrorMessages.既に登録済, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue() == null
                ? RString.EMPTY.toString() : div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue().toString());
        if (!div.get状態().equals(追加状態コード) && !div.get状態().equals(修正状態コード)) {
            messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先情報登録エリアの編集状態チェック)
                    .thenAdd(編集なしで更新不可).messages());
        }
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.口座情報入力有り時必須項目チェック)
                .thenAdd(入力値が不正_追加メッセージあり_口座).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.市町村の合法性チェック)
                .thenAdd(入力値が不正_追加メッセージあり).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先コードの重複チェック)
                .thenAdd(既に登録済).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                編集なしで更新不可, div.getChosaitakusakiJohoInput()).build().check(messages));
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                入力値が不正_追加メッセージあり_口座, div.getChosaitakusakiJohoInput().getKozaJoho()).build().check(messages));
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
                ninteichosaItakusaki.getEntity().setJusho(div.getChosaitakusakiJohoInput().getTxtJusho().getValue());
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
                //口座情報
                ninteichosaItakusaki.getEntity().setKinyuKikanCode(
                        new KinyuKikanCode(div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().value()));
                ninteichosaItakusaki.getEntity().setKinyuKikanShitenCode(
                        new KinyuKikanShitenCode(div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().value()));
                ninteichosaItakusaki.getEntity().setYokinShubetsu(div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShubetsu().getSelectedKey());
                ninteichosaItakusaki.getEntity().setKozaNo(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue());
                ninteichosaItakusaki.getEntity().setKozaMeigininKana(
                        new AtenaKanaMeisho(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue()));
                ninteichosaItakusaki.getEntity().setKozaMeiginin(
                        new AtenaMeisho(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().getValue()));

                NinteichosaItakusakiJohoRelate johoRelate = new NinteichosaItakusakiJohoRelate();
                johoRelate.getEntity().set認定調査委託先情報Entity(ninteichosaItakusaki.getEntity());
                NinteichosaItakusakiJoho joho = new NinteichosaItakusakiJoho(johoRelate.getEntity());
                johoManager.save(joho);

                int selectID = -1;
                selectID = setSelectID(selectID, div);

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
                        div.getChosaitakusakiJohoInput().getTxtJusho().getValue(),
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
                        div.getChosaitakusakiJohoInput().getRadChosainJokyo().getSelectedValue(),
                        div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関() == null
                        ? RString.EMPTY : div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関().get金融機関コード().getColumnValue(),
                        div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関支店() == null
                        ? RString.EMPTY : div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関支店().get支店コード().getColumnValue(),
                        div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShubetsu().getSelectedKey(),
                        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue(),
                        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue(),
                        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().getValue()
                );

                changeSelectID(selectID, div, row);
                return ResponseData.of(div).forwardWithEventName(DBE9030001TransitionEventName.認定調査員へ遷移).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBE9030001TransitionEventName.認定調査員へ遷移).respond();
    }

    private int setSelectID(int selectID, NinteichosaItakusakiMasterDiv div) {
        if (!RString.isNullOrEmpty(div.getHdnSelectID())) {
            selectID = Integer.valueOf(div.getHdnSelectID().toString());
        }
        return selectID;
    }

    private void changeSelectID(int selectID, NinteichosaItakusakiMasterDiv div, dgChosainIchiran_Row row) {
        if (selectID == -1) {
            div.setHdnShichosonCodeList(div.getHdnShichosonCodeList().concat(
                    div.getChosaitakusakiJohoInput().getTxtShichoson().getValue()).concat(EUC_WRITER_DELIMITER));
            div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().add(row);
        } else {
            div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource().set(selectID, row);
        }
    }

    /**
     * 入力明細エリアの入力内容を調査委託先一覧に反映させる。
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnKakutei(NinteichosaItakusakiMasterDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DBE9030001ErrorMessage 編集なしで更新不可 = new DBE9030001ErrorMessage(UrErrorMessages.編集なしで更新不可);
        DBE9030001ErrorMessage 入力値が不正_追加メッセージあり_口座
                = new DBE9030001ErrorMessage(UrErrorMessages.入力値が不正_追加メッセージあり, 口座情報チェックREPLACE.toString());
        DBE9030001ErrorMessage 入力値が不正_追加メッセージあり
                = new DBE9030001ErrorMessage(UrErrorMessages.入力値が不正_追加メッセージあり, 市町村の合法性チェックREPLACE.toString());
        DBE9030001ErrorMessage 既に登録済 = new DBE9030001ErrorMessage(
                UrErrorMessages.既に登録済, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue() == null
                ? RString.EMPTY.toString() : div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue().toString());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先情報登録エリアの編集状態チェック)
                .thenAdd(編集なしで更新不可).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.口座情報入力有り時必須項目チェック)
                .thenAdd(入力値が不正_追加メッセージあり_口座).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.市町村の合法性チェック)
                .thenAdd(入力値が不正_追加メッセージあり).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先コードの重複チェック)
                .thenAdd(既に登録済).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                編集なしで更新不可, div.getChosaitakusakiJohoInput()).build().check(messages));
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                入力値が不正_追加メッセージあり_口座, div.getChosaitakusakiJohoInput().getKozaJoho()).build().check(messages));
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
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnReSearch(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (is一覧エリア編集有り(div)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
            } else {
                if (!DBE9030001StateName.一覧.toString().equals(ResponseHolder.getState().toString())) {
                    onLoad(div);
                }
                return ResponseData.of(div).setState(DBE9030001StateName.検索);
            }
        } else {
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
                return ResponseData.of(div).setState(DBE9030001StateName.検索);
            }
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 入力データをＤＢに保存する
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
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
                                new LasdecCode(div.getHdnShichosonCodeList().split(EUC_WRITER_DELIMITER.toString())
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
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnBackShujiiIchiran(NinteichosaItakusakiMasterDiv div) {
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 委託先検索へ戻る
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnBackSearchShujii(NinteichosaItakusakiMasterDiv div) {
        onLoad(div);
        return ResponseData.of(div).setState(DBE9030001StateName.検索);
    }

    /**
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnComplete(NinteichosaItakusakiMasterDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE9030001TransitionEventName.処理完了).respond();
    }

    /**
     *
     * @param div 画面情報
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
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
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
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
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
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
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
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

    /**
     * 金融機関コードのonBlur。
     *
     * @param div NinteichosaItakusakiMasterDiv
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onBlur_kinyuKikanCode(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).setKozaJoho();
        div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShubetsu().setSelectedKey(空白);
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 店番のonBlur。
     *
     * @param div NinteichosaItakusakiMasterDiv
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onBlur_txtTenBan(NinteichosaItakusakiMasterDiv div) {
        RString tenBan = div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().getValue();
        if (!RString.isNullOrEmpty(tenBan)) {
            RString shitenMeisho = getHandler(div).getShitenMeisho(tenBan);
            if (!RString.EMPTY.equals(tenBan)) {
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().
                        setValue(shitenMeisho);
            } else {
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().clearValue();
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().clearValue();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 金融機関のonOkClose
     *
     * @param div NinteichosaItakusakiMasterDiv
     * @return ResponseData<NinteichosaItakusakiMasterDiv>
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onOkClose_KinyuKikan(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).setKozaJoho();
        div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShubetsu().setSelectedKey(空白);
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().clearValue();
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
            NinteichosaItakusakiMasterDiv div, dgChosainIchiran_Row row, int rowIndex, RString 金融機関名称, RString 支店名) {
        NinteichosaItakusakiJohoCsvEntity csvEntity = new NinteichosaItakusakiJohoCsvEntity();
        csvEntity.set市町村コード(div.getHdnShichosonCodeList().split(EUC_WRITER_DELIMITER.toString()).get(rowIndex));
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
        csvEntity.set調査委託区分コード(get調査委託区分コード(row.getChosaItakuKubun()));
        csvEntity.set調査委託区分(row.getKikanKubun());
        csvEntity.set特定調査員表示フラグ(row.getTokuteiChosainDispFlag());
        csvEntity.set割付定員(new RString(row.getWaritsukeTeiin().getValue().toString()));
        csvEntity.set割付地区コード(row.getChikuCode());
        csvEntity.set割付地区名称(row.getChikuName());
        csvEntity.set自動割付フラグ(row.getAutoWaritsukeFlag());
        csvEntity.set機関の区分コード(get機関の区分コード(row.getKikanKubun()));
        csvEntity.set機関の区分(row.getKikanKubun());
        csvEntity.set状況フラグ(row.getJokyoFlag());
        csvEntity.set金融機関コード(row.getKinyuKikanCode());
        csvEntity.set金融機関名称(金融機関名称);
        csvEntity.set支店コード(row.getKinyuKikanShitenCode());
        csvEntity.set支店(支店名);
        csvEntity.set預金種別コード(row.getYokinShubetsu());
        csvEntity.set預金種別(set預金種別(row.getYokinShubetsu()));
        csvEntity.set口座番号(row.getKozaNo());
        csvEntity.set口座名義人(row.getKozaMeigininKana());
        csvEntity.set漢字名義人(row.getKozaMeiginin());
        return csvEntity;
    }

    private RString get金融機関名称() {
        RString 金融機関名称 = RString.EMPTY;

        return 金融機関名称;
    }

    private RString set預金種別(RString 預金種別コード) {
        if (!預金種別コード.isEmpty()) {
            switch (預金種別コード.toInt()) {
                case 1:
                    return 普通;
                case 2:
                    return 当座;
                case 3:
                    return 納税準備;
                case 4:
                    return 貯蓄;
                case 9:
                    return その他;
            }
        }
        return RString.EMPTY;
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
