/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5090001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CreateTargetBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CreateTargetCsvBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CreateTargetDataBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.createtarget.CreateTargetMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001.CreateTargetCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001.CreateTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001.DBE5090001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001.dgCreateTargetSummary_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5090001.CreateTargetHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5090001.CreateTargetValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.createtarget.CreateTargetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * センター送信データ出力のコントローラです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
public class CreateTarget {

    private static final RString キー_0 = new RString("key0");
    private static final RString キー_1 = new RString("key1");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 申請書管理番号 = new RString("申請書管理番号");
    private static final RString 申請日_開始 = new RString("申請日(開始)");
    private static final RString 申請日_終了 = new RString("申請日(終了)");
    private static final RString 認定日_開始 = new RString("認定日(開始)");
    private static final RString 認定日_終了 = new RString("認定日(終了)");
    private static final int 連番0 = 0;
    private static final int 連番1 = 1;
    private static final int 連番2 = 2;
    private static final int 連番3 = 3;
    private static final int 連番4 = 4;
    private static final int 連番5 = 5;
    private static final int 連番6 = 6;
    private static final int 連番7 = 7;
    private static final int 連番8 = 8;
    private static final int 連番9 = 9;
    private static final int 連番10 = 10;
    private static final int 連番11 = 11;
    private static final int 連番12 = 12;
    private static final int 連番13 = 13;
    private static final int 連番14 = 14;
    private static final int 連番15 = 15;
    private static final int 連番16 = 16;
    private static final int 連番17 = 17;
    private static final int 連番18 = 18;
    private static final int 連番19 = 19;
    private static final int 連番20 = 20;
    private static final int 連番21 = 21;
    private static final int 連番22 = 22;
    private static final int 連番23 = 23;
    private static final int 連番24 = 24;
    private static final int 連番25 = 25;
    private static final int 連番26 = 26;
    private static final int 連番27 = 27;
    private static final int 連番28 = 28;
    private static final int 連番29 = 29;
    private static final int 連番30 = 30;
    private static final int 連番31 = 31;
    private static final int 連番32 = 32;
    private static final int 連番33 = 33;
    private static final int 連番34 = 34;
    private static final int 連番35 = 35;
    private static final int 連番36 = 36;
    private static final int 連番37 = 37;
    private static final int 連番38 = 38;
    private static final int 連番39 = 39;
    private static final int 連番40 = 40;
    private static final int 連番41 = 41;
    private static final int 連番42 = 42;
    private static final int 連番43 = 43;
    private static final int 連番44 = 44;
    private static final int 連番45 = 45;
    private static final int 連番46 = 46;
    private static final int 連番47 = 47;
    private static final int 連番48 = 48;
    private static final int 連番49 = 49;
    private static final int 連番50 = 50;
    private static final int 連番51 = 51;
    private static final int 連番52 = 52;
    private static final int 連番53 = 53;
    private static final int 連番54 = 54;
    private static final int 連番55 = 55;
    private static final int 連番56 = 56;
    private static final int 連番57 = 57;
    private static final int 連番58 = 58;
    private static final int 連番59 = 59;
    private static final int 連番60 = 60;
    private static final int 連番61 = 61;
    private static final int 連番62 = 62;
    private static final int 連番63 = 63;
    private static final int 連番64 = 64;
    private static final int 連番65 = 65;
    private static final int 連番66 = 66;
    private static final int 連番67 = 67;
    private static final int 連番68 = 68;
    private static final int 連番69 = 69;
    private static final int 連番70 = 70;
    private static final int 連番71 = 71;
    private static final int 連番72 = 72;
    private static final int 連番73 = 73;
    private static final int 連番74 = 74;
    private static final int 連番75 = 75;
    private static final int 連番76 = 76;
    private static final int 連番77 = 77;
    private static final int 連番78 = 78;
    private static final int 連番79 = 79;
    private static final int 連番80 = 80;
    private static final int 連番81 = 81;
    private static final int 連番82 = 82;
    private static final int 連番83 = 83;
    private static final int 連番84 = 84;

    /**
     * 画面初期化処理です。
     *
     * @param div CreateTargetDiv
     * @return ResponseData<CreateTargetDiv>
     */
    public ResponseData<CreateTargetDiv> onLoad(CreateTargetDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE5090001StateName.初期状態);
    }

    /**
     * 検索条件をクリア処理です。
     *
     * @param div CreateTargetDiv
     * @return ResponseData<CreateTargetDiv>
     */
    public ResponseData<CreateTargetDiv> btn_Clear(CreateTargetDiv div) {
        getHandler(div).btn_Clear();
        return ResponseData.of(div).setState(DBE5090001StateName.初期状態);
    }

    /**
     * 申請日認定日処理です。
     *
     * @param div CreateTargetDiv
     * @return ResponseData<CreateTargetDiv>
     */
    public ResponseData<CreateTargetDiv> btn_Change(CreateTargetDiv div) {
        getHandler(div).btn_Change();
        return ResponseData.of(div).setState(DBE5090001StateName.初期状態);
    }

    /**
     * 対象者一覧未選択チェック処理です。
     *
     * @param div CreateTargetDiv
     * @return ResponseData<CreateTargetDiv>
     */
    public ResponseData<CreateTargetDiv> btn_DetaSyutsuRyoku(CreateTargetDiv div) {
        List<dgCreateTargetSummary_Row> rowList = div.getDgCreateTargetSummary().getDataSource();
        List<RString> shinsei = new ArrayList();
        for (dgCreateTargetSummary_Row row : rowList) {
            if (row.getSelected()) {
                shinsei.add(row.getShinseishokanrino());
            }
        }
        ValidationMessageControlPairs validPair = getValidationHandler(div).未選択チェック(shinsei);
        if (validPair.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPair).respond();
        }
        return ResponseData.of(div).setState(DBE5090001StateName.検索結果);
    }

    /**
     * 検索処理です。
     *
     * @param div CreateTargetDiv
     * @return ResponseData<CreateTargetDiv>
     */
    public ResponseData<CreateTargetDiv> btn_Kensaku(CreateTargetDiv div) {
        ValidationMessageControlPairs validPair = getValidationHandler(div).入力チェック();
        if (validPair.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPair).respond();
        }
        RString データ出力 = キー_1;
        FlexibleDate 申請_開始日 = FlexibleDate.EMPTY;
        FlexibleDate 申請_終了日 = FlexibleDate.EMPTY;
        FlexibleDate 認定_開始日 = FlexibleDate.EMPTY;
        FlexibleDate 認定_終了日 = FlexibleDate.EMPTY;
        if (キー_0.equals(div.getRdoSyutsuryoku().getSelectedKey())) {
            データ出力 = キー_0;
        }
        if (div.getTxtShinseiYMD().getFromValue() != null) {
            申請_開始日 = new FlexibleDate(div.getTxtShinseiYMD().getFromValue().toDateString());
        }
        if (div.getTxtShinseiYMD().getToValue() != null) {
            申請_終了日 = new FlexibleDate(div.getTxtShinseiYMD().getToValue().toDateString());
        }
        if (div.getNinteiYMD().getFromValue() != null) {
            認定_開始日 = new FlexibleDate(div.getNinteiYMD().getFromValue().toDateString());
        }
        if (div.getNinteiYMD().getToValue() != null) {
            認定_終了日 = new FlexibleDate(div.getNinteiYMD().getToValue().toDateString());
        }
        CreateTargetMapperParameter param = CreateTargetMapperParameter.createParam(データ出力, 申請_開始日, 申請_終了日,
                認定_開始日, 認定_終了日, Integer.parseInt(div.getTxtMaxKensu().getValue().toString()), false, false, false, false, false);
        List<CreateTargetBusiness> business = CreateTargetManager.createInstance().get対象者一覧情報(param).records();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).データチェック(business);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).btn_Kensaku(business);
        return ResponseData.of(div).setState(DBE5090001StateName.検索結果);
    }

    /**
     * データ出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div CreateTargetDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<CreateTargetDiv>
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(CreateTargetDiv div, IDownLoadServletResponse response) {
        RString ファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定支援センター送信ファイル名,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        List<dgCreateTargetSummary_Row> rowList = div.getDgCreateTargetSummary().getDataSource();
        List<RString> shinsei = new ArrayList();
        for (dgCreateTargetSummary_Row row : rowList) {
            if (row.getSelected()) {
                shinsei.add(row.getShinseishokanrino());
            }
        }
        int 連番 = 1;
        CreateTargetMapperParameter param = CreateTargetMapperParameter.createCsvDataParam(shinsei);
        List<CreateTargetCsvBusiness> csvBusiness = CreateTargetManager.createInstance().getCsv出力用データ(param).records();
        List<CreateTargetBusiness> 主治医意見書 = CreateTargetManager.createInstance().get主治医意見書意見項目(param).records();
        List<CreateTargetBusiness> サービスの状況 = CreateTargetManager.createInstance().getサービスの状況(param).records();
        List<CreateTargetBusiness> 調査票調査項目 = CreateTargetManager.createInstance().get調査票調査項目(param).records();
        List<CreateTargetBusiness> 前回調査票調査項目 = CreateTargetManager.createInstance().get前回調査票調査項目(param).records();
        List<CreateTargetBusiness> 前回サービスの状況 = CreateTargetManager.createInstance().get前回サービスの状況(param).records();

        Map<RString, CreateTargetDataBusiness> dataMap = new HashMap<>();
        for (CreateTargetCsvBusiness entity : csvBusiness) {
            CreateTargetDataBusiness dataBusiness = new CreateTargetDataBusiness();
            List<CreateTargetBusiness> 主治医意見書Business = new ArrayList<>();
            List<CreateTargetBusiness> サービス状況Business = new ArrayList<>();
            List<CreateTargetBusiness> 調査項目Business = new ArrayList<>();
            List<CreateTargetBusiness> 前回サービス状況Business = new ArrayList<>();
            List<CreateTargetBusiness> 前回調査項目Business = new ArrayList<>();
            dataBusiness.setCsvBusiness(entity);
            dataBusiness.set主治医意見書(主治医意見書Business);
            dataBusiness.setサービスの状況(サービス状況Business);
            dataBusiness.set調査票調査項目(調査項目Business);
            dataBusiness.set前回サービスの状況(前回サービス状況Business);
            dataBusiness.set前回調査票調査項目(前回調査項目Business);
            dataMap.put(entity.get申請書管理番号(), dataBusiness);
        }
        for (CreateTargetBusiness 主治医項目 : 主治医意見書) {
            List<CreateTargetBusiness> 主治医意見書List = dataMap.get(主治医項目.get申請書管理番号()).get主治医意見書();
            主治医意見書List.add(主治医項目);
        }
        for (CreateTargetBusiness サービス項目 : サービスの状況) {
            List<CreateTargetBusiness> サービス状況List = dataMap.get(サービス項目.get申請書管理番号()).getサービスの状況();
            サービス状況List.add(サービス項目);
        }
        for (CreateTargetBusiness 調査項目 : 調査票調査項目) {
            List<CreateTargetBusiness> 調査項目List = dataMap.get(調査項目.get申請書管理番号()).get調査票調査項目();
            調査項目List.add(調査項目);
        }
        for (CreateTargetBusiness 前回調査項目 : 前回調査票調査項目) {
            List<CreateTargetBusiness> 前回調査項目List = dataMap.get(前回調査項目.get申請書管理番号()).get前回調査票調査項目();
            前回調査項目List.add(前回調査項目);
        }
        for (CreateTargetBusiness 前回サービス項目 : 前回サービスの状況) {
            List<CreateTargetBusiness> 前回サービス項目List = dataMap.get(前回サービス項目.get申請書管理番号()).get前回サービスの状況();
            前回サービス項目List.add(前回サービス項目);
        }
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), ファイル名);
        try (CsvWriter<CreateTargetCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            for (CreateTargetDataBusiness business : dataMap.values()) {
                csvWriter.writeLine(getCsvData(business, 連番));
                連番 = 連番 + 1;
                CreateTargetManager.createInstance().update(business.getCsvBusiness().get申請書管理番号());
                CreateTargetManager.createInstance().insertUpdate(business.getCsvBusiness().get申請書管理番号());
                AccessLogger.log(AccessLogType.照会, toPersonalData(business.getCsvBusiness().get申請書管理番号()));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(ファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        出力条件リストの出力(div, shinsei);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, ファイル名), response);
    }

    private CreateTargetCsvEntity get主治医意見書(CreateTargetDataBusiness business, CreateTargetCsvEntity data) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().get識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().get識別コード())) {
            data.set意見書短期記憶(get意見書項目(business.get主治医意見書(), 連番15));
            data.set意見書認知能力(get意見書項目(business.get主治医意見書(), 連番16));
            data.set意見書伝達能力(get意見書項目(business.get主治医意見書(), 連番17));
            data.set意見書食事行為(get意見書項目(business.get主治医意見書(), 連番18));
            data.set意見書認知症高齢者の日常生活自立度(get意見書項目(business.get主治医意見書(), 連番14));
        } else {
            data.set意見書短期記憶(get意見書項目(business.get主治医意見書(), 連番14));
            data.set意見書認知能力(get意見書項目(business.get主治医意見書(), 連番15));
            data.set意見書伝達能力(get意見書項目(business.get主治医意見書(), 連番16));
            data.set意見書食事行為(get意見書項目(business.get主治医意見書(), 連番68));
            data.set意見書認知症高齢者の日常生活自立度(get意見書項目(business.get主治医意見書(), 連番13));
        }
        return data;
    }

    private RString get意見書項目(List<CreateTargetBusiness> business, int 連番) {
        if (連番 < business.size()) {
            return business.get(連番).get項目();
        }
        return RString.EMPTY;
    }

    private CreateTargetCsvEntity getサービスの状況(CreateTargetDataBusiness business, CreateTargetCsvEntity data) {
        if (ServiceKubunCode.介護給付サービス.getコード().equals(business.getCsvBusiness().get現在のサービス区分コード())) {
            data.set訪問介護ホームヘルプサービス(getサービス状況項目(business.getサービスの状況(), 連番0));
            data.set訪問入浴介護(getサービス状況項目(business.getサービスの状況(), 連番1));
            data.set訪問看護(getサービス状況項目(business.getサービスの状況(), 連番2));
            data.set訪問リハビリテーション(getサービス状況項目(business.getサービスの状況(), 連番3));
            data.set居宅療養管理指導(getサービス状況項目(business.getサービスの状況(), 連番4));
            data.set通所介護デイサービス(getサービス状況項目(business.getサービスの状況(), 連番5));
            data.set通所リハビリテーション(getサービス状況項目(business.getサービスの状況(), 連番6));
            data.set住宅改修介護給付(business.getCsvBusiness().get住宅改修介護給付());
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().get識別コード())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().get識別コード())) {
                data.set短期入所生活介護ショートステイ(getサービス状況項目(business.getサービスの状況(), 連番8));
                data.set短期入所療養介護(getサービス状況項目(business.getサービスの状況(), 連番9));
                data.set特定施設入居者生活介護(getサービス状況項目(business.getサービスの状況(), 連番11));
                data.set福祉用具貸与(getサービス状況項目(business.getサービスの状況(), 連番7));
                data.set特定福祉用具販売(getサービス状況項目(business.getサービスの状況(), 連番12));
                data.set夜間対応型訪問介護(RString.EMPTY);
                data.set認知症対応型通所介護(RString.EMPTY);
                data.set小規模多機能型居宅介護(RString.EMPTY);
                data.set認知症対応型共同生活介護グループホーム(getサービス状況項目(business.getサービスの状況(), 連番10));
                data.set地域密着型特定施設入居者生活介護(RString.EMPTY);
                data.set地域密着型介護老人福祉施設入所者生活介護(RString.EMPTY);
                data.set地域密着型特定施設入居者生活介護(RString.EMPTY);
                data.set地域密着型介護老人福祉施設入所者生活介護(RString.EMPTY);
            } else {
                data.set短期入所生活介護ショートステイ(getサービス状況項目(business.getサービスの状況(), 連番7));
                data.set短期入所療養介護(getサービス状況項目(business.getサービスの状況(), 連番8));
                data.set特定施設入居者生活介護(getサービス状況項目(business.getサービスの状況(), 連番9));
                data.set福祉用具貸与(getサービス状況項目(business.getサービスの状況(), 連番10));
                data.set特定福祉用具販売(getサービス状況項目(business.getサービスの状況(), 連番11));
                data.set夜間対応型訪問介護(getサービス状況項目(business.getサービスの状況(), 連番12));
                data.set認知症対応型通所介護(getサービス状況項目(business.getサービスの状況(), 連番13));
                data.set小規模多機能型居宅介護(getサービス状況項目(business.getサービスの状況(), 連番14));
                data.set認知症対応型共同生活介護グループホーム(getサービス状況項目(business.getサービスの状況(), 連番15));
                data.set地域密着型特定施設入居者生活介護(getサービス状況項目(business.getサービスの状況(), 連番16));
                data.set地域密着型介護老人福祉施設入所者生活介護(getサービス状況項目(business.getサービスの状況(), 連番17));
                data.set定期巡回随時対応型訪問介護看護(getサービス状況項目(business.getサービスの状況(), 連番18));
                data.set複合型サービス(getサービス状況項目(business.getサービスの状況(), 連番19));
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(business.getCsvBusiness().get識別コード())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(business.getCsvBusiness().get識別コード())) {
                data.set地域密着型特定施設入居者生活介護(RString.EMPTY);
                data.set地域密着型介護老人福祉施設入所者生活介護(RString.EMPTY);
            } else {
                data.set定期巡回随時対応型訪問介護看護(getサービス状況項目(business.getサービスの状況(), 連番18));
                data.set複合型サービス(getサービス状況項目(business.getサービスの状況(), 連番19));
            }
        }
        if (ServiceKubunCode.予防給付サービス.getコード().equals(business.getCsvBusiness().get現在のサービス区分コード())) {
            data.set介護予防訪問介護ホームヘルプサービス(getサービス状況項目(business.getサービスの状況(), 連番0));
            data.set介護予防訪問入浴介護(getサービス状況項目(business.getサービスの状況(), 連番1));
            data.set介護予防訪問看護(getサービス状況項目(business.getサービスの状況(), 連番2));
            data.set介護予防訪問リハビリテーション(getサービス状況項目(business.getサービスの状況(), 連番3));
            data.set介護予防居宅療養管理指導(getサービス状況項目(business.getサービスの状況(), 連番4));
            data.set介護予防通所介護デイサービス(getサービス状況項目(business.getサービスの状況(), 連番5));
            data.set介護予防通所リハビリテーション(getサービス状況項目(business.getサービスの状況(), 連番6));
            data.set住宅改修予防給付(business.getCsvBusiness().get住宅改修予防給付());
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().get識別コード())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().get識別コード())) {
                data.set介護予防短期入所生活介護ショートステイ(getサービス状況項目(business.getサービスの状況(), 連番8));
                data.set介護予防短期入所療養介護(getサービス状況項目(business.getサービスの状況(), 連番9));
                data.set介護予防特定施設入居者生活介護(getサービス状況項目(business.getサービスの状況(), 連番11));
                data.set介護予防福祉用具貸与(getサービス状況項目(business.getサービスの状況(), 連番7));
                data.set特定介護予防福祉用具販売(getサービス状況項目(business.getサービスの状況(), 連番12));
                data.set介護予防認知症対応型通所介護(RString.EMPTY);
                data.set介護予防小規模多機能型居宅介護(RString.EMPTY);
                data.set介護予防認知症対応型共同生活介護グループホーム(getサービス状況項目(business.getサービスの状況(), 連番10));
            } else {
                data.set介護予防短期入所生活介護ショートステイ(getサービス状況項目(business.getサービスの状況(), 連番7));
                data.set介護予防短期入所療養介護(getサービス状況項目(business.getサービスの状況(), 連番8));
                data.set介護予防特定施設入居者生活介護(getサービス状況項目(business.getサービスの状況(), 連番9));
                data.set介護予防福祉用具貸与(getサービス状況項目(business.getサービスの状況(), 連番10));
                data.set特定介護予防福祉用具販売(getサービス状況項目(business.getサービスの状況(), 連番11));
                data.set介護予防認知症対応型通所介護(getサービス状況項目(business.getサービスの状況(), 連番13));
                data.set介護予防小規模多機能型居宅介護(getサービス状況項目(business.getサービスの状況(), 連番14));
                data.set介護予防認知症対応型共同生活介護グループホーム(getサービス状況項目(business.getサービスの状況(), 連番15));
            }
        }
        return data;
    }

    private RString getサービス状況項目(List<CreateTargetBusiness> business, int 連番) {
        if (連番 < business.size()) {
            return business.get(連番).get項目();
        }
        return RString.EMPTY;
    }

    private CreateTargetCsvEntity get調査票調査項目(CreateTargetDataBusiness business, CreateTargetCsvEntity data) {
        data.set麻痺左上肢(get調査票項目(business.get調査票調査項目(), 連番0));
        data.set麻痺右上肢(get調査票項目(business.get調査票調査項目(), 連番1));
        data.set麻痺左下肢(get調査票項目(business.get調査票調査項目(), 連番2));
        data.set麻痺右下肢(get調査票項目(business.get調査票調査項目(), 連番3));
        data.set麻痺その他(get調査票項目(business.get調査票調査項目(), 連番4));
        data.set拘縮肩関節(get調査票項目(business.get調査票調査項目(), 連番5));
        get調査票調査項目01(business, data);
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().get識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().get識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(business.getCsvBusiness().get識別コード())) {
            data.set拘縮股関節(get調査票項目(business.get調査票調査項目(), 連番7));
            data.set拘縮膝関節(get調査票項目(business.get調査票調査項目(), 連番8));
            data.set拘縮その他(get調査票項目(business.get調査票調査項目(), 連番10));
            data.set寝返り(get調査票項目(business.get調査票調査項目(), 連番11));
            data.set起き上がり(get調査票項目(business.get調査票調査項目(), 連番12));
            data.set座位保持(get調査票項目(business.get調査票調査項目(), 連番13));
            data.set立ち上がり(get調査票項目(business.get調査票調査項目(), 連番18));
            data.set片足での立位(get調査票項目(business.get調査票調査項目(), 連番19));
            data.set独り言独り笑い(RString.EMPTY);
            data.set自分勝手に行動する(RString.EMPTY);
            data.set話がまとまらない(RString.EMPTY);
            data.set集団への不適応(RString.EMPTY);
            data.set買い物(RString.EMPTY);
            data.set簡単な調理(RString.EMPTY);
        } else {
            data.set拘縮股関節(get調査票項目(business.get調査票調査項目(), 連番6));
            data.set拘縮膝関節(get調査票項目(business.get調査票調査項目(), 連番7));
            data.set拘縮その他(get調査票項目(business.get調査票調査項目(), 連番8));
            data.set寝返り(get調査票項目(business.get調査票調査項目(), 連番9));
            data.set起き上がり(get調査票項目(business.get調査票調査項目(), 連番10));
            data.set座位保持(get調査票項目(business.get調査票調査項目(), 連番11));
            data.set立ち上がり(get調査票項目(business.get調査票調査項目(), 連番14));
            data.set片足での立位(get調査票項目(business.get調査票調査項目(), 連番15));
            data.set独り言独り笑い(get調査票項目(business.get調査票調査項目(), 連番53));
            data.set自分勝手に行動する(get調査票項目(business.get調査票調査項目(), 連番54));
            data.set話がまとまらない(get調査票項目(business.get調査票調査項目(), 連番55));
            data.set集団への不適応(get調査票項目(business.get調査票調査項目(), 連番59));
            data.set買い物(get調査票項目(business.get調査票調査項目(), 連番60));
            data.set簡単な調理(get調査票項目(business.get調査票調査項目(), 連番61));
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().get識別コード())) {
            data.set両足での立位(get調査票項目(business.get調査票調査項目(), 連番15));
            data.set歩行(get調査票項目(business.get調査票調査項目(), 連番16));
            data.set洗身(get調査票項目(business.get調査票調査項目(), 連番21));
            data.setつめ切り(get調査票項目(business.get調査票調査項目(), 連番34));
            data.set視力(get調査票項目(business.get調査票調査項目(), 連番44));
            data.set聴力(get調査票項目(business.get調査票調査項目(), 連番45));
            data.set移乗(get調査票項目(business.get調査票調査項目(), 連番17));
            data.set移動(RString.EMPTY);
            data.setえん下(get調査票項目(business.get調査票調査項目(), 連番25));
            data.set食事摂取(get調査票項目(business.get調査票調査項目(), 連番30));
            data.set排尿(RString.EMPTY);
            data.set排便(RString.EMPTY);
            data.set口腔清潔(get調査票項目(business.get調査票調査項目(), 連番31));
            data.set洗顔(get調査票項目(business.get調査票調査項目(), 連番32));
            data.set整髪(get調査票項目(business.get調査票調査項目(), 連番33));
            data.set上衣の着脱(get調査票項目(business.get調査票調査項目(), 連番36));
            data.setズボン等の着脱(get調査票項目(business.get調査票調査項目(), 連番37));
            data.set外出頻度(RString.EMPTY);
            data.set意思の伝達(get調査票項目(business.get調査票調査項目(), 連番46));
            data.set毎日の日課を理解(get調査票項目(business.get調査票調査項目(), 連番48));
            data.set生年月日をいう(get調査票項目(business.get調査票調査項目(), 連番49));
            data.set短期記憶(get調査票項目(business.get調査票調査項目(), 連番50));
            data.set自分の名前をいう(get調査票項目(business.get調査票調査項目(), 連番51));
            data.set今の季節を理解(get調査票項目(business.get調査票調査項目(), 連番52));
            data.set場所の理解(get調査票項目(business.get調査票調査項目(), 連番53));
            data.set徘徊(get調査票項目(business.get調査票調査項目(), 連番63));
            data.set外出して戻れない(get調査票項目(business.get調査票調査項目(), 連番65));
            data.set被害的(get調査票項目(business.get調査票調査項目(), 連番54));
            data.set作話(get調査票項目(business.get調査票調査項目(), 連番55));
            data.set感情が不安定(get調査票項目(business.get調査票調査項目(), 連番57));
            data.set昼夜逆転(get調査票項目(business.get調査票調査項目(), 連番58));
            data.set同じ話をする(get調査票項目(business.get調査票調査項目(), 連番60));
            data.set大声を出す(get調査票項目(business.get調査票調査項目(), 連番61));
            data.set介護に抵抗(get調査票項目(business.get調査票調査項目(), 連番62));
            data.set落ち着きなし(get調査票項目(business.get調査票調査項目(), 連番64));
            data.set一人で出たがる(get調査票項目(business.get調査票調査項目(), 連番66));
            data.set収集癖(get調査票項目(business.get調査票調査項目(), 連番67));
            data.set物や衣類を壊す(get調査票項目(business.get調査票調査項目(), 連番69));
            data.setひどい物忘れ(get調査票項目(business.get調査票調査項目(), 連番42));
            data.set薬の内服(get調査票項目(business.get調査票調査項目(), 連番40));
            data.set金銭の管理(get調査票項目(business.get調査票調査項目(), 連番41));
            data.set日常の意思決定(RString.EMPTY);
            data.set点滴の管理(get調査票項目(business.get調査票調査項目(), 連番73));
            data.set中心静脈栄養(get調査票項目(business.get調査票調査項目(), 連番74));
            data.set透析(get調査票項目(business.get調査票調査項目(), 連番75));
            data.setストーマの処置(get調査票項目(business.get調査票調査項目(), 連番76));
            data.set酸素療法(get調査票項目(business.get調査票調査項目(), 連番77));
            data.setレスピレーター(get調査票項目(business.get調査票調査項目(), 連番78));
            data.set気管切開の処置(get調査票項目(business.get調査票調査項目(), 連番79));
            data.set疼痛の看護(get調査票項目(business.get調査票調査項目(), 連番80));
            data.set経管栄養(get調査票項目(business.get調査票調査項目(), 連番81));
            data.setモニター測定(get調査票項目(business.get調査票調査項目(), 連番82));
            data.setじょくそうの処置(get調査票項目(business.get調査票調査項目(), 連番83));
            data.setカテーテル(get調査票項目(business.get調査票調査項目(), 連番84));
        }
        return data;
    }

    private CreateTargetCsvEntity get調査票調査項目01(CreateTargetDataBusiness business, CreateTargetCsvEntity data) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().get識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(business.getCsvBusiness().get識別コード())) {
            data.set両足での立位(get調査票項目(business.get調査票調査項目(), 連番14));
            data.set歩行(get調査票項目(business.get調査票調査項目(), 連番15));
            data.set洗身(get調査票項目(business.get調査票調査項目(), 連番20));
            data.setつめ切り(get調査票項目(business.get調査票調査項目(), 連番31));
            data.set視力(get調査票項目(business.get調査票調査項目(), 連番38));
            data.set聴力(get調査票項目(business.get調査票調査項目(), 連番39));
            data.set移乗(get調査票項目(business.get調査票調査項目(), 連番16));
            data.set移動(get調査票項目(business.get調査票調査項目(), 連番17));
            data.setえん下(get調査票項目(business.get調査票調査項目(), 連番23));
            data.set食事摂取(get調査票項目(business.get調査票調査項目(), 連番24));
            data.set排尿(get調査票項目(business.get調査票調査項目(), 連番26));
            data.set排便(get調査票項目(business.get調査票調査項目(), 連番27));
            data.set口腔清潔(get調査票項目(business.get調査票調査項目(), 連番28));
            data.set洗顔(get調査票項目(business.get調査票調査項目(), 連番29));
            data.set整髪(get調査票項目(business.get調査票調査項目(), 連番30));
            data.set上衣の着脱(get調査票項目(business.get調査票調査項目(), 連番32));
            data.setズボン等の着脱(get調査票項目(business.get調査票調査項目(), 連番33));
            data.set外出頻度(get調査票項目(business.get調査票調査項目(), 連番80));
            data.set意思の伝達(get調査票項目(business.get調査票調査項目(), 連番40));
            data.set毎日の日課を理解(get調査票項目(business.get調査票調査項目(), 連番42));
            data.set生年月日をいう(get調査票項目(business.get調査票調査項目(), 連番43));
            data.set短期記憶(get調査票項目(business.get調査票調査項目(), 連番44));
            data.set自分の名前をいう(get調査票項目(business.get調査票調査項目(), 連番45));
            data.set今の季節を理解(get調査票項目(business.get調査票調査項目(), 連番46));
            data.set場所の理解(get調査票項目(business.get調査票調査項目(), 連番47));
            data.set徘徊(get調査票項目(business.get調査票調査項目(), 連番57));
            data.set外出して戻れない(get調査票項目(business.get調査票調査項目(), 連番59));
            data.set被害的(get調査票項目(business.get調査票調査項目(), 連番48));
            data.set作話(get調査票項目(business.get調査票調査項目(), 連番49));
            data.set感情が不安定(get調査票項目(business.get調査票調査項目(), 連番51));
            data.set昼夜逆転(get調査票項目(business.get調査票調査項目(), 連番52));
            data.set同じ話をする(get調査票項目(business.get調査票調査項目(), 連番54));
            data.set大声を出す(get調査票項目(business.get調査票調査項目(), 連番55));
            data.set介護に抵抗(get調査票項目(business.get調査票調査項目(), 連番56));
            data.set落ち着きなし(get調査票項目(business.get調査票調査項目(), 連番58));
            data.set一人で出たがる(get調査票項目(business.get調査票調査項目(), 連番60));
            data.set収集癖(get調査票項目(business.get調査票調査項目(), 連番61));
            data.set物や衣類を壊す(get調査票項目(business.get調査票調査項目(), 連番63));
            data.setひどい物忘れ(get調査票項目(business.get調査票調査項目(), 連番46));
            data.set薬の内服(get調査票項目(business.get調査票調査項目(), 連番34));
            data.set金銭の管理(get調査票項目(business.get調査票調査項目(), 連番35));
            data.set日常の意思決定(get調査票項目(business.get調査票調査項目(), 連番37));
            data.set点滴の管理(get調査票項目(business.get調査票調査項目(), 連番67));
            data.set中心静脈栄養(get調査票項目(business.get調査票調査項目(), 連番68));
            data.set透析(get調査票項目(business.get調査票調査項目(), 連番69));
            data.setストーマの処置(get調査票項目(business.get調査票調査項目(), 連番70));
            data.set酸素療法(get調査票項目(business.get調査票調査項目(), 連番71));
            data.setレスピレーター(get調査票項目(business.get調査票調査項目(), 連番72));
            data.set気管切開の処置(get調査票項目(business.get調査票調査項目(), 連番73));
            data.set疼痛の看護(get調査票項目(business.get調査票調査項目(), 連番74));
            data.set経管栄養(get調査票項目(business.get調査票調査項目(), 連番75));
            data.setモニター測定(get調査票項目(business.get調査票調査項目(), 連番76));
            data.setじょくそうの処置(get調査票項目(business.get調査票調査項目(), 連番77));
            data.setカテーテル(get調査票項目(business.get調査票調査項目(), 連番78));
        }
        if (!KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().get識別コード())
                && !KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(business.getCsvBusiness().get識別コード())
                && !KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().get識別コード())) {
            data.set両足での立位(get調査票項目(business.get調査票調査項目(), 連番12));
            data.set歩行(get調査票項目(business.get調査票調査項目(), 連番13));
            data.set洗身(get調査票項目(business.get調査票調査項目(), 連番16));
            data.setつめ切り(get調査票項目(business.get調査票調査項目(), 連番17));
            data.set視力(get調査票項目(business.get調査票調査項目(), 連番18));
            data.set聴力(get調査票項目(business.get調査票調査項目(), 連番19));
            data.set移乗(get調査票項目(business.get調査票調査項目(), 連番20));
            data.set移動(get調査票項目(business.get調査票調査項目(), 連番21));
            data.setえん下(get調査票項目(business.get調査票調査項目(), 連番22));
            data.set食事摂取(get調査票項目(business.get調査票調査項目(), 連番23));
            data.set排尿(get調査票項目(business.get調査票調査項目(), 連番24));
            data.set排便(get調査票項目(business.get調査票調査項目(), 連番25));
            data.set口腔清潔(get調査票項目(business.get調査票調査項目(), 連番26));
            data.set洗顔(get調査票項目(business.get調査票調査項目(), 連番27));
            data.set整髪(get調査票項目(business.get調査票調査項目(), 連番28));
            data.set上衣の着脱(get調査票項目(business.get調査票調査項目(), 連番29));
            data.setズボン等の着脱(get調査票項目(business.get調査票調査項目(), 連番30));
            data.set外出頻度(get調査票項目(business.get調査票調査項目(), 連番31));
            data.set意思の伝達(get調査票項目(business.get調査票調査項目(), 連番32));
            data.set毎日の日課を理解(get調査票項目(business.get調査票調査項目(), 連番33));
            data.set生年月日をいう(get調査票項目(business.get調査票調査項目(), 連番34));
            data.set短期記憶(get調査票項目(business.get調査票調査項目(), 連番35));
            data.set自分の名前をいう(get調査票項目(business.get調査票調査項目(), 連番36));
            data.set今の季節を理解(get調査票項目(business.get調査票調査項目(), 連番37));
            data.set場所の理解(get調査票項目(business.get調査票調査項目(), 連番38));
            data.set徘徊(get調査票項目(business.get調査票調査項目(), 連番39));
            data.set外出して戻れない(get調査票項目(business.get調査票調査項目(), 連番40));
            data.set被害的(get調査票項目(business.get調査票調査項目(), 連番41));
            data.set作話(get調査票項目(business.get調査票調査項目(), 連番42));
            data.set感情が不安定(get調査票項目(business.get調査票調査項目(), 連番43));
            data.set昼夜逆転(get調査票項目(business.get調査票調査項目(), 連番44));
            data.set同じ話をする(get調査票項目(business.get調査票調査項目(), 連番45));
            data.set大声を出す(get調査票項目(business.get調査票調査項目(), 連番46));
            data.set介護に抵抗(get調査票項目(business.get調査票調査項目(), 連番47));
            data.set落ち着きなし(get調査票項目(business.get調査票調査項目(), 連番48));
            data.set一人で出たがる(get調査票項目(business.get調査票調査項目(), 連番49));
            data.set収集癖(get調査票項目(business.get調査票調査項目(), 連番50));
            data.set物や衣類を壊す(get調査票項目(business.get調査票調査項目(), 連番51));
            data.setひどい物忘れ(get調査票項目(business.get調査票調査項目(), 連番52));
            data.set薬の内服(get調査票項目(business.get調査票調査項目(), 連番56));
            data.set金銭の管理(get調査票項目(business.get調査票調査項目(), 連番57));
            data.set日常の意思決定(get調査票項目(business.get調査票調査項目(), 連番58));
            data.set点滴の管理(get調査票項目(business.get調査票調査項目(), 連番62));
            data.set中心静脈栄養(get調査票項目(business.get調査票調査項目(), 連番63));
            data.set透析(get調査票項目(business.get調査票調査項目(), 連番64));
            data.setストーマの処置(get調査票項目(business.get調査票調査項目(), 連番65));
            data.set酸素療法(get調査票項目(business.get調査票調査項目(), 連番66));
            data.setレスピレーター(get調査票項目(business.get調査票調査項目(), 連番67));
            data.set気管切開の処置(get調査票項目(business.get調査票調査項目(), 連番68));
            data.set疼痛の看護(get調査票項目(business.get調査票調査項目(), 連番69));
            data.set経管栄養(get調査票項目(business.get調査票調査項目(), 連番70));
            data.setモニター測定(get調査票項目(business.get調査票調査項目(), 連番71));
            data.setじょくそうの処置(get調査票項目(business.get調査票調査項目(), 連番72));
            data.setカテーテル(get調査票項目(business.get調査票調査項目(), 連番73));
        }
        return data;
    }

    private RString get調査票項目(List<CreateTargetBusiness> business, int 連番) {
        if (連番 < business.size()) {
            return business.get(連番).get項目();
        }
        return RString.EMPTY;
    }

    private CreateTargetCsvEntity get前回調査票調査項目01(CreateTargetDataBusiness business, CreateTargetCsvEntity data) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード()
                .equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())) {
            data.set前回結果_両足での立位(get前回調査票項目(business.get前回調査票調査項目(), 連番14));
            data.set前回結果_歩行(get前回調査票項目(business.get前回調査票調査項目(), 連番15));
            data.set前回結果_洗身(get前回調査票項目(business.get前回調査票調査項目(), 連番20));
            data.set前回結果_つめ切り(get前回調査票項目(business.get前回調査票調査項目(), 連番31));
            data.set前回結果_視力(get前回調査票項目(business.get前回調査票調査項目(), 連番38));
            data.set前回結果_聴力(get前回調査票項目(business.get前回調査票調査項目(), 連番39));
            data.set前回結果_移乗(get前回調査票項目(business.get前回調査票調査項目(), 連番16));
            data.set前回結果_移動(get前回調査票項目(business.get前回調査票調査項目(), 連番17));
            data.set前回結果_えん下(get前回調査票項目(business.get前回調査票調査項目(), 連番23));
            data.set前回結果_食事摂取(get前回調査票項目(business.get前回調査票調査項目(), 連番24));
            data.set前回結果_排尿(get前回調査票項目(business.get前回調査票調査項目(), 連番26));
            data.set前回結果_排便(get前回調査票項目(business.get前回調査票調査項目(), 連番27));
            data.set前回結果_口腔清潔(get前回調査票項目(business.get前回調査票調査項目(), 連番28));
            data.set前回結果_洗顔(get前回調査票項目(business.get前回調査票調査項目(), 連番29));
            data.set前回結果_整髪(get前回調査票項目(business.get前回調査票調査項目(), 連番30));
            data.set前回結果_上衣の着脱(get前回調査票項目(business.get前回調査票調査項目(), 連番32));
            data.set前回結果_ズボン等の着脱(get前回調査票項目(business.get前回調査票調査項目(), 連番33));
            data.set前回結果_外出頻度(get前回調査票項目(business.get前回調査票調査項目(), 連番80));
            data.set前回結果_意思の伝達(get前回調査票項目(business.get前回調査票調査項目(), 連番40));
            data.set前回結果_毎日の日課を理解(get前回調査票項目(business.get前回調査票調査項目(), 連番42));
            data.set前回結果_生年月日をいう(get前回調査票項目(business.get前回調査票調査項目(), 連番43));
            data.set前回結果_短期記憶(get前回調査票項目(business.get前回調査票調査項目(), 連番44));
            data.set前回結果_自分の名前をいう(get前回調査票項目(business.get前回調査票調査項目(), 連番45));
            data.set前回結果_今の季節を理解(get前回調査票項目(business.get前回調査票調査項目(), 連番46));
            data.set前回結果_場所の理解(get前回調査票項目(business.get前回調査票調査項目(), 連番47));
            data.set前回結果_徘徊(get前回調査票項目(business.get前回調査票調査項目(), 連番57));
            data.set前回結果_外出して戻れない(get前回調査票項目(business.get前回調査票調査項目(), 連番59));
            data.set前回結果_被害的(get前回調査票項目(business.get前回調査票調査項目(), 連番48));
            data.set前回結果_作話(get前回調査票項目(business.get前回調査票調査項目(), 連番49));
            data.set前回結果_感情が不安定(get前回調査票項目(business.get前回調査票調査項目(), 連番51));
            data.set前回結果_昼夜逆転(get前回調査票項目(business.get前回調査票調査項目(), 連番52));
            data.set前回結果_同じ話をする(get前回調査票項目(business.get前回調査票調査項目(), 連番54));
            data.set前回結果_大声を出す(get前回調査票項目(business.get前回調査票調査項目(), 連番55));
            data.set前回結果_介護に抵抗(get前回調査票項目(business.get前回調査票調査項目(), 連番56));
            data.set前回結果_落ち着きなし(get前回調査票項目(business.get前回調査票調査項目(), 連番58));
            data.set前回結果_一人で出たがる(get前回調査票項目(business.get前回調査票調査項目(), 連番60));
            data.set前回結果_収集癖(get前回調査票項目(business.get前回調査票調査項目(), 連番61));
            data.set前回結果_物や衣類を壊す(get前回調査票項目(business.get前回調査票調査項目(), 連番63));
            data.set前回結果_ひどい物忘れ(get前回調査票項目(business.get前回調査票調査項目(), 連番66));
            data.set前回結果_薬の内服(get前回調査票項目(business.get前回調査票調査項目(), 連番34));
            data.set前回結果_金銭の管理(get前回調査票項目(business.get前回調査票調査項目(), 連番35));
            data.set前回結果_日常の意思決定(get前回調査票項目(business.get前回調査票調査項目(), 連番37));
            data.set前回結果_点滴の管理(get前回調査票項目(business.get前回調査票調査項目(), 連番67));
            data.set前回結果_中心静脈栄養(get前回調査票項目(business.get前回調査票調査項目(), 連番68));
            data.set前回結果_透析(get前回調査票項目(business.get前回調査票調査項目(), 連番69));
            data.set前回結果_ストーマの処置(get前回調査票項目(business.get前回調査票調査項目(), 連番70));
            data.set前回結果_酸素療法(get前回調査票項目(business.get前回調査票調査項目(), 連番71));
            data.set前回結果_レスピレーター(get前回調査票項目(business.get前回調査票調査項目(), 連番72));
            data.set前回結果_気管切開の処置(get前回調査票項目(business.get前回調査票調査項目(), 連番73));
            data.set前回結果_疼痛の看護(get前回調査票項目(business.get前回調査票調査項目(), 連番74));
            data.set前回結果_経管栄養(get前回調査票項目(business.get前回調査票調査項目(), 連番75));
            data.set前回結果_モニター測定(get前回調査票項目(business.get前回調査票調査項目(), 連番76));
            data.set前回結果_じょくそうの処置(get前回調査票項目(business.get前回調査票調査項目(), 連番77));
            data.set前回結果_カテーテル(get前回調査票項目(business.get前回調査票調査項目(), 連番78));
        }
        if (!KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())
                && !KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード()
                .equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード()) && !KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード()
                .equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())) {
            data.set前回結果_両足での立位(get前回調査票項目(business.get前回調査票調査項目(), 連番12));
            data.set前回結果_歩行(get前回調査票項目(business.get前回調査票調査項目(), 連番13));
            data.set前回結果_洗身(get前回調査票項目(business.get前回調査票調査項目(), 連番16));
            data.set前回結果_つめ切り(get前回調査票項目(business.get前回調査票調査項目(), 連番17));
            data.set前回結果_視力(get前回調査票項目(business.get前回調査票調査項目(), 連番18));
            data.set前回結果_聴力(get前回調査票項目(business.get前回調査票調査項目(), 連番19));
            data.set前回結果_移乗(get前回調査票項目(business.get前回調査票調査項目(), 連番20));
            data.set前回結果_移動(get前回調査票項目(business.get前回調査票調査項目(), 連番21));
            data.set前回結果_えん下(get前回調査票項目(business.get前回調査票調査項目(), 連番22));
            data.set前回結果_食事摂取(get前回調査票項目(business.get前回調査票調査項目(), 連番23));
            data.set前回結果_排尿(get前回調査票項目(business.get前回調査票調査項目(), 連番24));
            data.set前回結果_排便(get前回調査票項目(business.get前回調査票調査項目(), 連番25));
            data.set前回結果_口腔清潔(get前回調査票項目(business.get前回調査票調査項目(), 連番26));
            data.set前回結果_洗顔(get前回調査票項目(business.get前回調査票調査項目(), 連番27));
            data.set前回結果_整髪(get前回調査票項目(business.get前回調査票調査項目(), 連番28));
            data.set前回結果_上衣の着脱(get前回調査票項目(business.get前回調査票調査項目(), 連番29));
            data.set前回結果_ズボン等の着脱(get前回調査票項目(business.get前回調査票調査項目(), 連番30));
            data.set前回結果_外出頻度(get前回調査票項目(business.get前回調査票調査項目(), 連番31));
            data.set前回結果_意思の伝達(get前回調査票項目(business.get前回調査票調査項目(), 連番32));
            data.set前回結果_毎日の日課を理解(get前回調査票項目(business.get前回調査票調査項目(), 連番33));
            data.set前回結果_生年月日をいう(get前回調査票項目(business.get前回調査票調査項目(), 連番34));
            data.set前回結果_短期記憶(get前回調査票項目(business.get前回調査票調査項目(), 連番35));
            data.set前回結果_自分の名前をいう(get前回調査票項目(business.get前回調査票調査項目(), 連番36));
            data.set前回結果_今の季節を理解(get前回調査票項目(business.get前回調査票調査項目(), 連番37));
            data.set前回結果_場所の理解(get前回調査票項目(business.get前回調査票調査項目(), 連番38));
            data.set前回結果_徘徊(get前回調査票項目(business.get前回調査票調査項目(), 連番39));
            data.set前回結果_外出して戻れない(get前回調査票項目(business.get前回調査票調査項目(), 連番40));
            data.set前回結果_被害的(get前回調査票項目(business.get前回調査票調査項目(), 連番41));
            data.set前回結果_作話(get前回調査票項目(business.get前回調査票調査項目(), 連番42));
            data.set前回結果_感情が不安定(get前回調査票項目(business.get前回調査票調査項目(), 連番43));
            data.set前回結果_昼夜逆転(get前回調査票項目(business.get前回調査票調査項目(), 連番44));
            data.set前回結果_同じ話をする(get前回調査票項目(business.get前回調査票調査項目(), 連番45));
            data.set前回結果_大声を出す(get前回調査票項目(business.get前回調査票調査項目(), 連番46));
            data.set前回結果_介護に抵抗(get前回調査票項目(business.get前回調査票調査項目(), 連番47));
            data.set前回結果_落ち着きなし(get前回調査票項目(business.get前回調査票調査項目(), 連番48));
            data.set前回結果_一人で出たがる(get前回調査票項目(business.get前回調査票調査項目(), 連番49));
            data.set前回結果_収集癖(get前回調査票項目(business.get前回調査票調査項目(), 連番50));
            data.set前回結果_物や衣類を壊す(get前回調査票項目(business.get前回調査票調査項目(), 連番51));
            data.set前回結果_ひどい物忘れ(get前回調査票項目(business.get前回調査票調査項目(), 連番52));
            data.set前回結果_薬の内服(get前回調査票項目(business.get前回調査票調査項目(), 連番56));
            data.set前回結果_金銭の管理(get前回調査票項目(business.get前回調査票調査項目(), 連番57));
            data.set前回結果_日常の意思決定(get前回調査票項目(business.get前回調査票調査項目(), 連番58));
            data.set前回結果_点滴の管理(get前回調査票項目(business.get前回調査票調査項目(), 連番62));
            data.set前回結果_中心静脈栄養(get前回調査票項目(business.get前回調査票調査項目(), 連番63));
            data.set前回結果_透析(get前回調査票項目(business.get前回調査票調査項目(), 連番64));
            data.set前回結果_ストーマの処置(get前回調査票項目(business.get前回調査票調査項目(), 連番65));
            data.set前回結果_酸素療法(get前回調査票項目(business.get前回調査票調査項目(), 連番66));
            data.set前回結果_レスピレーター(get前回調査票項目(business.get前回調査票調査項目(), 連番67));
            data.set前回結果_気管切開の処置(get前回調査票項目(business.get前回調査票調査項目(), 連番68));
            data.set前回結果_疼痛の看護(get前回調査票項目(business.get前回調査票調査項目(), 連番69));
            data.set前回結果_経管栄養(get前回調査票項目(business.get前回調査票調査項目(), 連番70));
            data.set前回結果_モニター測定(get前回調査票項目(business.get前回調査票調査項目(), 連番71));
            data.set前回結果_じょくそうの処置(get前回調査票項目(business.get前回調査票調査項目(), 連番72));
            data.set前回結果_カテーテル(get前回調査票項目(business.get前回調査票調査項目(), 連番73));
        }
        return data;
    }

    private CreateTargetCsvEntity get前回調査票調査項目(CreateTargetDataBusiness business, CreateTargetCsvEntity data) {
        data.set前回結果_麻痺左上肢(get前回調査票項目(business.get前回調査票調査項目(), 連番0));
        data.set前回結果_麻痺右上肢(get前回調査票項目(business.get前回調査票調査項目(), 連番1));
        data.set前回結果_麻痺左下肢(get前回調査票項目(business.get前回調査票調査項目(), 連番2));
        data.set前回結果_麻痺右下肢(get前回調査票項目(business.get前回調査票調査項目(), 連番3));
        data.set前回結果_麻痺その他(get前回調査票項目(business.get前回調査票調査項目(), 連番4));
        data.set前回結果_拘縮肩関節(get前回調査票項目(business.get前回調査票調査項目(), 連番5));
        get前回調査票調査項目01(business, data);
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(business.getCsvBusiness()
                        .getCreateCsvDataBusiness().get前回識別コード())) {
            data.set前回結果_拘縮股関節(get前回調査票項目(business.get前回調査票調査項目(), 連番7));
            data.set前回結果_拘縮膝関節(get前回調査票項目(business.get前回調査票調査項目(), 連番8));
            data.set前回結果_拘縮その他(get前回調査票項目(business.get前回調査票調査項目(), 連番10));
            data.set前回結果_寝返り(get前回調査票項目(business.get前回調査票調査項目(), 連番11));
            data.set前回結果_起き上がり(get前回調査票項目(business.get前回調査票調査項目(), 連番12));
            data.set前回結果_座位保持(get前回調査票項目(business.get前回調査票調査項目(), 連番13));
            data.set前回結果_立ち上がり(get前回調査票項目(business.get前回調査票調査項目(), 連番18));
            data.set前回結果_片足での立位(get前回調査票項目(business.get前回調査票調査項目(), 連番19));
            data.set前回結果_独り言独り笑い(RString.EMPTY);
            data.set前回結果_自分勝手に行動する(RString.EMPTY);
            data.set前回結果_話がまとまらない(RString.EMPTY);
            data.set前回結果_集団への不適応(RString.EMPTY);
            data.set前回結果_買い物(RString.EMPTY);
            data.set前回結果_簡単な調理(RString.EMPTY);
        } else {
            data.set前回結果_拘縮股関節(get前回調査票項目(business.get前回調査票調査項目(), 連番6));
            data.set前回結果_拘縮膝関節(get前回調査票項目(business.get前回調査票調査項目(), 連番7));
            data.set前回結果_拘縮その他(get前回調査票項目(business.get前回調査票調査項目(), 連番8));
            data.set前回結果_寝返り(get前回調査票項目(business.get前回調査票調査項目(), 連番9));
            data.set前回結果_起き上がり(get前回調査票項目(business.get前回調査票調査項目(), 連番10));
            data.set前回結果_座位保持(get前回調査票項目(business.get前回調査票調査項目(), 連番11));
            data.set前回結果_立ち上がり(get前回調査票項目(business.get前回調査票調査項目(), 連番14));
            data.set前回結果_片足での立位(get前回調査票項目(business.get前回調査票調査項目(), 連番15));
            data.set前回結果_独り言独り笑い(get前回調査票項目(business.get前回調査票調査項目(), 連番53));
            data.set前回結果_自分勝手に行動する(get前回調査票項目(business.get前回調査票調査項目(), 連番54));
            data.set前回結果_話がまとまらない(get前回調査票項目(business.get前回調査票調査項目(), 連番55));
            data.set前回結果_集団への不適応(get前回調査票項目(business.get前回調査票調査項目(), 連番59));
            data.set前回結果_買い物(get前回調査票項目(business.get前回調査票調査項目(), 連番60));
            data.set前回結果_簡単な調理(get前回調査票項目(business.get前回調査票調査項目(), 連番61));
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())) {
            data.set前回結果_両足での立位(get前回調査票項目(business.get前回調査票調査項目(), 連番15));
            data.set前回結果_歩行(get前回調査票項目(business.get前回調査票調査項目(), 連番16));
            data.set前回結果_洗身(get前回調査票項目(business.get前回調査票調査項目(), 連番21));
            data.set前回結果_つめ切り(get前回調査票項目(business.get前回調査票調査項目(), 連番34));
            data.set前回結果_視力(get前回調査票項目(business.get前回調査票調査項目(), 連番44));
            data.set前回結果_聴力(get前回調査票項目(business.get前回調査票調査項目(), 連番45));
            data.set前回結果_移乗(get前回調査票項目(business.get前回調査票調査項目(), 連番17));
            data.set前回結果_移動(RString.EMPTY);
            data.set前回結果_えん下(get前回調査票項目(business.get前回調査票調査項目(), 連番25));
            data.set前回結果_食事摂取(get前回調査票項目(business.get前回調査票調査項目(), 連番30));
            data.set前回結果_排尿(RString.EMPTY);
            data.set前回結果_排便(RString.EMPTY);
            data.set前回結果_口腔清潔(get前回調査票項目(business.get前回調査票調査項目(), 連番31));
            data.set前回結果_洗顔(get前回調査票項目(business.get前回調査票調査項目(), 連番32));
            data.set前回結果_整髪(get前回調査票項目(business.get前回調査票調査項目(), 連番33));
            data.set前回結果_上衣の着脱(get前回調査票項目(business.get前回調査票調査項目(), 連番36));
            data.set前回結果_ズボン等の着脱(get前回調査票項目(business.get前回調査票調査項目(), 連番37));
            data.set前回結果_外出頻度(RString.EMPTY);
            data.set前回結果_意思の伝達(get前回調査票項目(business.get前回調査票調査項目(), 連番46));
            data.set前回結果_毎日の日課を理解(get前回調査票項目(business.get前回調査票調査項目(), 連番48));
            data.set前回結果_生年月日をいう(get前回調査票項目(business.get前回調査票調査項目(), 連番49));
            data.set前回結果_短期記憶(get前回調査票項目(business.get前回調査票調査項目(), 連番50));
            data.set前回結果_自分の名前をいう(get前回調査票項目(business.get前回調査票調査項目(), 連番51));
            data.set前回結果_今の季節を理解(get前回調査票項目(business.get前回調査票調査項目(), 連番52));
            data.set前回結果_場所の理解(get前回調査票項目(business.get前回調査票調査項目(), 連番53));
            data.set前回結果_徘徊(get前回調査票項目(business.get前回調査票調査項目(), 連番63));
            data.set前回結果_外出して戻れない(get前回調査票項目(business.get前回調査票調査項目(), 連番65));
            data.set前回結果_被害的(get前回調査票項目(business.get前回調査票調査項目(), 連番54));
            data.set前回結果_作話(get前回調査票項目(business.get前回調査票調査項目(), 連番55));
            data.set前回結果_感情が不安定(get前回調査票項目(business.get前回調査票調査項目(), 連番57));
            data.set前回結果_昼夜逆転(get前回調査票項目(business.get前回調査票調査項目(), 連番58));
            data.set前回結果_同じ話をする(get前回調査票項目(business.get前回調査票調査項目(), 連番60));
            data.set前回結果_大声を出す(get前回調査票項目(business.get前回調査票調査項目(), 連番61));
            data.set前回結果_介護に抵抗(get前回調査票項目(business.get前回調査票調査項目(), 連番62));
            data.set前回結果_落ち着きなし(get前回調査票項目(business.get前回調査票調査項目(), 連番64));
            data.set前回結果_一人で出たがる(get前回調査票項目(business.get前回調査票調査項目(), 連番66));
            data.set前回結果_収集癖(get前回調査票項目(business.get前回調査票調査項目(), 連番67));
            data.set前回結果_物や衣類を壊す(get前回調査票項目(business.get前回調査票調査項目(), 連番69));
            data.set前回結果_ひどい物忘れ(get前回調査票項目(business.get前回調査票調査項目(), 連番42));
            data.set前回結果_薬の内服(get前回調査票項目(business.get前回調査票調査項目(), 連番40));
            data.set前回結果_金銭の管理(get前回調査票項目(business.get前回調査票調査項目(), 連番41));
            data.set前回結果_日常の意思決定(RString.EMPTY);
            data.set前回結果_点滴の管理(get前回調査票項目(business.get前回調査票調査項目(), 連番73));
            data.set前回結果_中心静脈栄養(get前回調査票項目(business.get前回調査票調査項目(), 連番74));
            data.set前回結果_透析(get前回調査票項目(business.get前回調査票調査項目(), 連番75));
            data.set前回結果_ストーマの処置(get前回調査票項目(business.get前回調査票調査項目(), 連番76));
            data.set前回結果_酸素療法(get前回調査票項目(business.get前回調査票調査項目(), 連番77));
            data.set前回結果_レスピレーター(get前回調査票項目(business.get前回調査票調査項目(), 連番78));
            data.set前回結果_気管切開の処置(get前回調査票項目(business.get前回調査票調査項目(), 連番79));
            data.set前回結果_疼痛の看護(get前回調査票項目(business.get前回調査票調査項目(), 連番80));
            data.set前回結果_経管栄養(get前回調査票項目(business.get前回調査票調査項目(), 連番81));
            data.set前回結果_モニター測定(get前回調査票項目(business.get前回調査票調査項目(), 連番82));
            data.set前回結果_じょくそうの処置(get前回調査票項目(business.get前回調査票調査項目(), 連番83));
            data.set前回結果_カテーテル(get前回調査票項目(business.get前回調査票調査項目(), 連番84));
        }
        return data;
    }

    private RString get前回調査票項目(List<CreateTargetBusiness> business, int 連番) {
        if (連番 < business.size()) {
            return business.get(連番).get項目();
        }
        return RString.EMPTY;
    }

    private CreateTargetCsvEntity get前回サービスの状況(CreateTargetDataBusiness business, CreateTargetCsvEntity data) {
        if (ServiceKubunCode.介護給付サービス.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness()
                .get前回結果_現在のサービス区分コード())) {
            data.set前回結果_訪問介護ホームヘルプサービス(get前回サービス状況項目(business.get前回サービスの状況(), 連番0));
            data.set前回結果_訪問入浴介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番1));
            data.set前回結果_訪問看護(get前回サービス状況項目(business.get前回サービスの状況(), 連番2));
            data.set前回結果_訪問リハビリテーション(get前回サービス状況項目(business.get前回サービスの状況(), 連番3));
            data.set前回結果_居宅療養管理指導(get前回サービス状況項目(business.get前回サービスの状況(), 連番4));
            data.set前回結果_通所介護デイサービス(get前回サービス状況項目(business.get前回サービスの状況(), 連番5));
            data.set前回結果_通所リハビリテーション(get前回サービス状況項目(business.get前回サービスの状況(), 連番6));
            data.set前回結果_住宅改修介護給付(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_住宅改修介護給付());
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness()
                            .get前回識別コード())) {
                data.set前回結果_短期入所生活介護ショートステイ(get前回サービス状況項目(business.get前回サービスの状況(), 連番8));
                data.set前回結果_短期入所療養介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番9));
                data.set前回結果_特定施設入居者生活介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番11));
                data.set前回結果_福祉用具貸与(get前回サービス状況項目(business.get前回サービスの状況(), 連番7));
                data.set前回結果_特定福祉用具販売(get前回サービス状況項目(business.get前回サービスの状況(), 連番12));
                data.set前回結果_夜間対応型訪問介護(RString.EMPTY);
                data.set前回結果_認知症対応型通所介護(RString.EMPTY);
                data.set前回結果_小規模多機能型居宅介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番10));
                data.set前回結果_認知症対応型共同生活介護グループホーム(RString.EMPTY);
                data.set前回結果_地域密着型特定施設入居者生活介護(RString.EMPTY);
                data.set前回結果_地域密着型介護老人福祉施設入所者生活介護(RString.EMPTY);
                data.set前回結果_定期巡回随時対応型訪問介護看護(RString.EMPTY);
                data.set前回結果_複合型サービス(RString.EMPTY);
            } else {
                data.set前回結果_短期入所生活介護ショートステイ(get前回サービス状況項目(business.get前回サービスの状況(), 連番7));
                data.set前回結果_短期入所療養介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番8));
                data.set前回結果_特定施設入居者生活介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番9));
                data.set前回結果_福祉用具貸与(get前回サービス状況項目(business.get前回サービスの状況(), 連番10));
                data.set前回結果_特定福祉用具販売(get前回サービス状況項目(business.get前回サービスの状況(), 連番11));
                data.set前回結果_夜間対応型訪問介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番12));
                data.set前回結果_認知症対応型通所介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番13));
                data.set前回結果_小規模多機能型居宅介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番14));
                data.set前回結果_認知症対応型共同生活介護グループホーム(get前回サービス状況項目(business.get前回サービスの状況(), 連番15));
                data.set前回結果_地域密着型特定施設入居者生活介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番16));
                data.set前回結果_地域密着型介護老人福祉施設入所者生活介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番17));
                data.set前回結果_定期巡回随時対応型訪問介護看護(get前回サービス状況項目(business.get前回サービスの状況(), 連番18));
                data.set前回結果_複合型サービス(get前回サービス状況項目(business.get前回サービスの状況(), 連番19));
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(business.getCsvBusiness().get識別コード())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(business.getCsvBusiness().get識別コード())) {
                data.set前回結果_定期巡回随時対応型訪問介護看護(RString.EMPTY);
                data.set前回結果_複合型サービス(RString.EMPTY);
            } else {
                data.set前回結果_定期巡回随時対応型訪問介護看護(get前回サービス状況項目(business.get前回サービスの状況(), 連番18));
                data.set前回結果_複合型サービス(get前回サービス状況項目(business.get前回サービスの状況(), 連番19));
            }
        }

        if (ServiceKubunCode.予防給付サービス.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness()
                .get前回結果_現在のサービス区分コード())) {
            data.set前回結果_介護予防訪問介護ホームヘルプサービス(get前回サービス状況項目(business.get前回サービスの状況(), 連番0));
            data.set前回結果_介護予防訪問入浴介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番1));
            data.set前回結果_介護予防訪問看護(get前回サービス状況項目(business.get前回サービスの状況(), 連番2));
            data.set前回結果_介護予防訪問リハビリテーション(get前回サービス状況項目(business.get前回サービスの状況(), 連番3));
            data.set前回結果_介護予防居宅療養管理指導(get前回サービス状況項目(business.get前回サービスの状況(), 連番4));
            data.set前回結果_介護予防通所介護デイサービス(get前回サービス状況項目(business.get前回サービスの状況(), 連番5));
            data.set前回結果_介護予防通所リハビリテーション(get前回サービス状況項目(business.get前回サービスの状況(), 連番6));
            data.set前回結果_住宅改修予防給付(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_住宅改修予防給付());
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(business.getCsvBusiness().getCreateCsvDataBusiness()
                            .get前回識別コード())) {
                data.set前回結果_介護予防短期入所生活介護ショートステイ(get前回サービス状況項目(business.get前回サービスの状況(), 連番8));
                data.set前回結果_介護予防短期入所療養介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番9));
                data.set前回結果_介護予防特定施設入居者生活介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番11));
                data.set前回結果_介護予防福祉用具貸与(get前回サービス状況項目(business.get前回サービスの状況(), 連番7));
                data.set前回結果_特定介護予防福祉用具販売(get前回サービス状況項目(business.get前回サービスの状況(), 連番12));
                data.set前回結果_介護予防認知症対応型通所介護(RString.EMPTY);
                data.set前回結果_介護予防小規模多機能型居宅介護(RString.EMPTY);
                data.set前回結果_介護予防認知症対応型共同生活介護グループホーム(get前回サービス状況項目(business.get前回サービスの状況(), 連番10));
            } else {
                data.set前回結果_介護予防短期入所生活介護ショートステイ(get前回サービス状況項目(business.get前回サービスの状況(), 連番7));
                data.set前回結果_介護予防短期入所療養介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番8));
                data.set前回結果_介護予防特定施設入居者生活介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番9));
                data.set前回結果_介護予防福祉用具貸与(get前回サービス状況項目(business.get前回サービスの状況(), 連番10));
                data.set前回結果_特定介護予防福祉用具販売(get前回サービス状況項目(business.get前回サービスの状況(), 連番11));
                data.set前回結果_介護予防認知症対応型通所介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番13));
                data.set前回結果_介護予防小規模多機能型居宅介護(get前回サービス状況項目(business.get前回サービスの状況(), 連番14));
                data.set前回結果_介護予防認知症対応型共同生活介護グループホーム(get前回サービス状況項目(business.get前回サービスの状況(), 連番15));
            }
        }
        return data;
    }

    private RString get前回サービス状況項目(List<CreateTargetBusiness> business, int 連番) {
        if (連番 < business.size()) {
            return business.get(連番).get項目();
        }
        return RString.EMPTY;
    }

    private CreateTargetCsvEntity getCsvData(CreateTargetDataBusiness business, int 連番) {
        CreateTargetCsvEntity data = new CreateTargetCsvEntity();
        get主治医意見書(business, data);
        getサービスの状況(business, data);
        get調査票調査項目(business, data);
        get前回調査票調査項目(business, data);
        get前回サービスの状況(business, data);
        RString 番号 = new RString(連番);
        data.setシーケンシャル番号(番号.padZeroToLeft(連番6));
        data.set機能コード(RString.EMPTY);
        data.set識別コード(business.getCsvBusiness().get識別コード());
        data.set保険者番号(business.getCsvBusiness().get保険者番号());
        data.set被保険者番号(business.getCsvBusiness().get被保険者番号());
        data.set認定申請日(business.getCsvBusiness().get認定申請日());
        data.set枝番(business.getCsvBusiness().get枝番());
        data.set申請区分法令コード(business.getCsvBusiness().get申請区分法令コード());
        data.set申請区分申請時コード(business.getCsvBusiness().get申請区分申請時コード());
        data.set取下区分コード(business.getCsvBusiness().get取下区分コード());
        data.set被保険者区分コード(business.getCsvBusiness().get被保険者区分コード());
        data.set申請代行区分コード(business.getCsvBusiness().get申請代行区分コード());
        data.set生年月日(business.getCsvBusiness().get生年月日());
        data.set年齢(business.getCsvBusiness().get年齢());
        data.set性別コード(business.getCsvBusiness().get性別コード());
        data.set被保険者ｶﾅ氏名(business.getCsvBusiness().get被保険者ｶﾅ氏名());
        data.set被保険者漢字氏名(business.getCsvBusiness().get被保険者漢字氏名());
        data.set郵便番号(business.getCsvBusiness().get郵便番号());
        data.set住所(business.getCsvBusiness().get住所());
        data.set電話番号(business.getCsvBusiness().get電話番号());
        data.set病院施設等の名称(business.getCsvBusiness().get病院施設等の名称());
        data.set病院施設等の所在地(business.getCsvBusiness().get病院施設等の所在地());
        data.set前回の認定審査会結果(business.getCsvBusiness().get前回の認定審査会結果());
        data.set前回の認定有効期間開始(business.getCsvBusiness().get前回の認定有効期間開始());
        data.set前回の認定有効期間終了(business.getCsvBusiness().get前回の認定有効期間終了());
        data.set主治医医療機関番号(business.getCsvBusiness().get主治医医療機関番号());
        data.set主治医番号(business.getCsvBusiness().get主治医番号());
        data.set意見書依頼日(business.getCsvBusiness().get意見書依頼日());
        data.set意見書入手日(business.getCsvBusiness().get意見書入手日());
        data.set調査依頼日(business.getCsvBusiness().get調査依頼日());
        data.set調査実施日(business.getCsvBusiness().get調査実施日());
        data.set指定居宅介護支援事業者等番号(business.getCsvBusiness().get指定居宅介護支援事業者等番号());
        data.set委託区分(business.getCsvBusiness().get委託区分());
        data.set認定調査員番号(business.getCsvBusiness().get認定調査員番号());
        data.set認定調査員資格コード(business.getCsvBusiness().get認定調査員資格コード());
        data.set一次判定日(business.getCsvBusiness().get一次判定日());
        data.set一次判定結果(business.getCsvBusiness().get一次判定結果());
        data.set一次判定結果認知症加算(business.getCsvBusiness().get一次判定結果認知症加算());
        data.set要介護認定等基準時間(business.getCsvBusiness().get要介護認定等基準時間());
        data.set要介護認定等基準時間食事(business.getCsvBusiness().get要介護認定等基準時間食事());
        data.set要介護認定等基準時間排泄(business.getCsvBusiness().get要介護認定等基準時間排泄());
        data.set要介護認定等基準時間移動(business.getCsvBusiness().get要介護認定等基準時間移動());
        data.set要介護認定等基準時間清潔保持(business.getCsvBusiness().get要介護認定等基準時間清潔保持());
        data.set要介護認定等基準時間間接ケア(business.getCsvBusiness().get要介護認定等基準時間間接ケア());
        data.set要介護認定等基準時間BPSD関連(business.getCsvBusiness().get要介護認定等基準時間BPSD関連());
        data.set要介護認定等基準時間機能訓練(business.getCsvBusiness().get要介護認定等基準時間機能訓練());
        data.set要介護認定等基準時間医療関連(business.getCsvBusiness().get要介護認定等基準時間医療関連());
        data.set要介護認定等基準時間認知症加算(business.getCsvBusiness().get要介護認定等基準時間認知症加算());
        data.set中間評価項目得点第１群(business.getCsvBusiness().get中間評価項目得点第１群());
        data.set中間評価項目得点第２群(business.getCsvBusiness().get中間評価項目得点第２群());
        data.set中間評価項目得点第３群(business.getCsvBusiness().get中間評価項目得点第３群());
        data.set中間評価項目得点第４群(business.getCsvBusiness().get中間評価項目得点第４群());
        data.set中間評価項目得点第５群(business.getCsvBusiness().get中間評価項目得点第５群());
        data.set一次判定警告配列コード(business.getCsvBusiness().get一次判定警告配列コード());
        data.set状態の安定性(business.getCsvBusiness().get状態の安定性());
        data.set認知症自立度Ⅱ以上の蓋然性(business.getCsvBusiness().get認知症自立度Ⅱ以上の蓋然性());
        data.set認知機能及び状態安定性から推定される給付区分(business.getCsvBusiness().get認知機能及び状態安定性から推定される給付区分());
        data.set認定審査会資料作成日(business.getCsvBusiness().get認定審査会資料作成日());
        data.set認定審査会予定日(business.getCsvBusiness().get認定審査会予定日());
        data.set合議体番号(business.getCsvBusiness().get合議体番号());
        data.set審査会資料番号(business.getCsvBusiness().get審査会資料番号());
        data.set二次判定日(business.getCsvBusiness().get二次判定日());
        data.set二次判定結果(business.getCsvBusiness().get二次判定結果());
        data.set認定有効期間開始(business.getCsvBusiness().get認定有効期間開始());
        data.set認定有効期間終了(business.getCsvBusiness().get認定有効期間終了());
        data.set特定疾病コード(business.getCsvBusiness().get特定疾病コード());
        data.set要介護１の場合の状態像(business.getCsvBusiness().get要介護１の場合の状態像());
        data.set現在のサービス区分コード(business.getCsvBusiness().get現在のサービス区分コード());
        data.set現在の状況(business.getCsvBusiness().get現在の状況());
        data.set障害高齢者自立度(business.getCsvBusiness().get障害高齢者自立度());
        data.set認知症高齢者自立度(business.getCsvBusiness().get認知症高齢者自立度());
        data.set前回結果_障害高齢者自立度(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_障害高齢者自立度());
        data.set前回結果_認知症高齢者自立度(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_認知症高齢者自立度());
        data.set前回結果_一次判定結果(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_一次判定結果());
        data.set前回結果_一次判定結果認知症加算(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_一次判定結果認知症加算());
        data.set前回結果_要介護認定等基準時間(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間());
        data.set前回結果_要介護認定等基準時間食事(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間食事());
        data.set前回結果_要介護認定等基準時間排泄(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間排泄());
        data.set前回結果_要介護認定等基準時間移動(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間移動());
        data.set前回結果_要介護認定等基準時間清潔保持(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間清潔保持());
        data.set前回結果_要介護認定等基準時間間接ケア(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間間接ケア());
        data.set前回結果_要介護認定等基準時間BPSD_関連(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間BPSD_関連());
        data.set前回結果_要介護認定等基準時間機能訓練(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間機能訓練());
        data.set前回結果_要介護認定等基準時間医療関連(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間医療関連());
        data.set前回結果_要介護認定等基準時間認知症加算(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_要介護認定等基準時間認知症加算());
        data.set前回結果_中間評価項目得点_第１群(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_中間評価項目得点_第１群());
        data.set前回結果_中間評価項目得点_第２群(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_中間評価項目得点_第２群());
        data.set前回結果_中間評価項目得点_第３群(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_中間評価項目得点_第３群());
        data.set前回結果_中間評価項目得点_第４群(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_中間評価項目得点_第４群());
        data.set前回結果_中間評価項目得点_第５群(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_中間評価項目得点_第５群());
        data.set前回結果_一次判定警告コード(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_一次判定警告コード());
        data.set前回結果_状態の安定性(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_状態の安定性());
        data.set前回結果_認知症自立度Ⅱ以上の蓋然性(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_認知症自立度Ⅱ以上の蓋然性());
        data.set前回結果_認知機能及び状態安定性から推定される給付区分(business.getCsvBusiness().getCreateCsvDataBusiness()
                .get前回結果_認知機能及び状態安定性から推定される給付区分());
        data.set前回結果_申請日(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_申請日());
        data.set前回結果_二次判定日(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_二次判定日());
        data.set前回結果_現在のサービス区分コード(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_現在のサービス区分コード());
        data.set前回結果_現在の状況(business.getCsvBusiness().getCreateCsvDataBusiness().get前回結果_現在の状況());
        data.set前回識別コード(business.getCsvBusiness().getCreateCsvDataBusiness().get前回識別コード());
        data.set認定審査会意見等(business.getCsvBusiness().getCreateCsvDataBusiness().get認定審査会意見等());
        return data;
    }

    private void 出力条件リストの出力(CreateTargetDiv div, List<RString> shiki) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("認定支援センター送信ファイル"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString("56"),
                DbBusinessConfig.get(ConfigNameDBE.認定支援センター送信ファイル名,
                        RDate.getNowDate(), SubGyomuCode.DBE認定支援),
                new RString("DBE561001"),
                new RString(String.valueOf(1)),
                get出力条件(div, shiki));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> get出力条件(CreateTargetDiv div, List<RString> shinsei) {
        RStringBuilder stringBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        stringBuilder.append(申請書管理番号);
        stringBuilder.append(shinsei);
        stringBuilder = new RStringBuilder();
        stringBuilder.append(申請日_開始);
        stringBuilder.append(div.getTxtShinseiYMD().getFromValue());
        出力条件List.add(stringBuilder.toRString());
        stringBuilder = new RStringBuilder();
        stringBuilder.append(申請日_終了);
        stringBuilder.append(div.getTxtShinseiYMD().getToValue());
        出力条件List.add(stringBuilder.toRString());
        stringBuilder = new RStringBuilder();
        stringBuilder.append(認定日_開始);
        stringBuilder.append(div.getNinteiYMD().getFromValue());
        出力条件List.add(stringBuilder.toRString());
        stringBuilder = new RStringBuilder();
        stringBuilder.append(認定日_終了);
        stringBuilder.append(div.getNinteiYMD().getToValue());
        出力条件List.add(stringBuilder.toRString());
        return 出力条件List;
    }

    private PersonalData toPersonalData(RString shinsei) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"),
                shinsei);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private CreateTargetHandler getHandler(CreateTargetDiv div) {
        return new CreateTargetHandler(div);
    }

    private CreateTargetValidationHandler getValidationHandler(CreateTargetDiv div) {
        return new CreateTargetValidationHandler(div);
    }
}
