/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2920001;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.iraijohodatatorikomi.NinteiShinseiJohoIraiJohoData;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.iraijohodatatorikomi.IraiJohoDataTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.DBE2920001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.IraiJohoDataTorikomiCsvData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.IraiJohoDataTorikomiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.IraiJohoDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001.dgTorikomiFileIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2920001.IraiJohoDataTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2920001.IraiJohoDataTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.iraijohodatatorikomi.IraiJohoDataTorikomiManager;
import jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01PrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 依頼情報データ受取（オルカ）のクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
public class IraiJohoDataTorikomi {

    private static final LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
    private static final RString CSVファイル名 = new RString("依頼情報データ受取（オルカ）.csv");
    private static final RString 奇数行 = new RString("1");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * 依頼情報データ受取（オルカ）の初期化。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @return レスポンスデータ
     */
    public ResponseData<IraiJohoDataTorikomiDiv> onLoad(IraiJohoDataTorikomiDiv div) {
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            throw new PessimisticLockingException();
        }
        return ResponseData.of(div).setState(DBE2920001StateName.初期状態);
    }

    /**
     * データ取込ボタンのonClick処理です。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @param files ファイル
     * @return レスポンスデータ
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<IraiJohoDataTorikomiDiv> onClick_BtnUpload(IraiJohoDataTorikomiDiv div, FileData[] files) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).取込みファイル対象未選択チェック(files);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        for (FileData file : files) {
            savaCsvファイル(file);
        }
        return ResponseData.of(div).respond();
    }

    private boolean savaCsvファイル(FileData file) {
        RString imagePath = Path.combinePath(Path.getRootPath(RString.EMPTY), DbBusinessConfig
                .get(ConfigNameDBE.OCRアップロード用ファイル格納パス, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        File localファイル = new File(file.getFilePath().toString());
        File サーバパス = new File(imagePath.toString());
        boolean fileFlag;
        boolean サーバFlag;
        File サーバ = new File(imagePath.toString(), file.getFileName().toString());
        if (!サーバパス.exists()) {
            fileFlag = サーバパス.mkdirs();
        } else {
            fileFlag = true;
        }
        if (サーバ.exists()) {
            サーバFlag = サーバ.delete();
        } else {
            サーバFlag = true;
        }
        if (サーバFlag && fileFlag) {
            return localファイル.renameTo(サーバ);
        }
        return true;
    }

    /**
     * データ取込ボタンのonClick処理です。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @return レスポンスデータ
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<IraiJohoDataTorikomiDiv> onClick_BtnDataTorikomi(IraiJohoDataTorikomiDiv div) {
        RString imagePath = Path.combinePath(Path.getRootPath(RString.EMPTY), DbBusinessConfig
                .get(ConfigNameDBE.OCRアップロード用ファイル格納パス, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        RString csvReaderPath = Path.combinePath(imagePath, CSVファイル名);

        List<IraiJohoDataTorikomiCsvEntity> csvEntityList = insertCsvDate(csvReaderPath);

        ValidationMessageControlPairs validationMessages = getValidationHandler(div).データを取込のチェック(csvEntityList);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        IraiJohoDataTorikomiCsvData csvData = new IraiJohoDataTorikomiCsvData();
        csvData.setCsvEntityList(csvEntityList);
        ViewStateHolder.put(ViewStateKeys.要介護認定主治医意見書情報, csvData);
        getHandler(div).set一覧エリア(csvEntityList);
        return ResponseData.of(div).setState(DBE2920001StateName.一覧表示);
    }

    /**
     * 入力チェックボタンのonClick処理です。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @return レスポンスデータ
     */
    public ResponseData<IraiJohoDataTorikomiDiv> onClick_NyuryokuCyeku(IraiJohoDataTorikomiDiv div) {
        List<dgTorikomiFileIchiran_Row> rowList = div.getDgTorikomiFileIchiran().getDataSource();
        List<NinteiShinseiJohoIraiJohoData> ninteiShinseiJohoList = new ArrayList<>();
        for (dgTorikomiFileIchiran_Row row : rowList) {
            if (奇数行.equals(row.getKiguusuu())) {
                IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
                parameter.set保険者番号(row.getHokenshaBango());
                parameter.set被保険者番号(row.getHihokenshaBango());
                parameter.set認定申請年月日(new FlexibleDate(row.getShinseibi()));
                parameter.set処理状態区分_0(ShoriJotaiKubun.通常.getコード());
                parameter.set処理状態区分_3(ShoriJotaiKubun.延期.getコード());
                ninteiShinseiJohoList.add(IraiJohoDataTorikomiManager.createInstance().get要介護認定申請情報(parameter, row.getHokenshaBango()));
            }
        }
        getHandler(div).set一覧エリア_入力チェック(ninteiShinseiJohoList);
        return ResponseData.of(div).respond();
    }

    /**
     * 印刷するボタンのonClick処理です。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @return レスポンスデータ
     */
    public ResponseData<SourceDataCollection> onClick_Insatu(IraiJohoDataTorikomiDiv div) {
        IraiJohoDataTorikomiCsvData csvData = ViewStateHolder.get(ViewStateKeys.要介護認定主治医意見書情報, IraiJohoDataTorikomiCsvData.class);
        List<IraiJohoDataTorikomiCsvEntity> csvEntityList = csvData.getCsvEntityList();
        List<dgTorikomiFileIchiran_Row> rowList = div.getDgTorikomiFileIchiran().getDataSource();
        List<IkenshokinyuyoshiBusiness> businessList = new ArrayList<>();
        for (dgTorikomiFileIchiran_Row row : rowList) {
            if (row.getCheckBox()) {
                for (IraiJohoDataTorikomiCsvEntity csvEntity : csvEntityList) {
                    if (csvEntity.get保険者番号().equals(row.getHokenshaBango()) && csvEntity.get被保険者番号().equals(row.getHihokenshaBango())) {
                        businessList.add(getHandler(div).帳票出力用情報の編集(csvEntity));
                    }
                }
            }
        }
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            Ikenshokinyuyoshi01PrintService printService = new Ikenshokinyuyoshi01PrintService(reportManager);
            for (IkenshokinyuyoshiBusiness business : businessList) {
                printService.print主治医意見書01(business);
                printService.print主治医意見書02(business);
            }
            response.data = reportManager.publish();
        }
        return response;
    }

    /**
     * 保存するボタンのonClick処理です。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @return レスポンスデータ
     */
    public ResponseData<IraiJohoDataTorikomiDiv> onClick_Koushin(IraiJohoDataTorikomiDiv div) {
        IraiJohoDataTorikomiCsvData csvData = ViewStateHolder.get(ViewStateKeys.要介護認定主治医意見書情報, IraiJohoDataTorikomiCsvData.class);
        List<IraiJohoDataTorikomiCsvEntity> csvEntityList = csvData.getCsvEntityList();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = getValidationHandler(div).申請日のチェック();
            if (validationMessages.iterator().hasNext() && !ResponseHolder.isWarningIgnoredRequest()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            List<dgTorikomiFileIchiran_Row> rowlist = div.getDgTorikomiFileIchiran().getDataSource();
            for (dgTorikomiFileIchiran_Row row : rowlist) {
                if (row.getCheckBox()) {
                    IkenshokinyuyoshiBusiness business = getBusiness(csvEntityList, row, div);
                    IraiJohoDataTorikomiManager.createInstance().各テーブルへの登録(row.getShinseishoKanriNo(), row.getKoroshoIfShikibetsuCode(),
                            row.getShinseishoKanriNo(), row.getKoroshoIfShikibetsuCode(), business);
                }
            }
        }
        return ResponseData.of(div).respond();
    }

    private IkenshokinyuyoshiBusiness getBusiness(List<IraiJohoDataTorikomiCsvEntity> csvEntityList,
            dgTorikomiFileIchiran_Row row, IraiJohoDataTorikomiDiv div) {
        IkenshokinyuyoshiBusiness business = new IkenshokinyuyoshiBusiness();
        for (IraiJohoDataTorikomiCsvEntity csvEntity : csvEntityList) {
            if (csvEntity.get保険者番号().equals(row.getHokenshaBango()) && csvEntity.get被保険者番号().equals(row.getHihokenshaBango())) {
                business = getHandler(div).帳票出力用情報の編集(csvEntity);
            }
        }
        return business;
    }

    private List<IraiJohoDataTorikomiCsvEntity> insertCsvDate(RString ファイルの場所) {
        RString filePath = Path.combinePath(ファイルの場所);
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, IraiJohoDataTorikomiCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile(csvReader);
    }

    private List<IraiJohoDataTorikomiCsvEntity> readCsvFile(CsvReader csvReader) {
        List<IraiJohoDataTorikomiCsvEntity> entityList = new ArrayList<>();
        while (true) {
            IraiJohoDataTorikomiCsvEntity entity = (IraiJohoDataTorikomiCsvEntity) csvReader.readLine();
            if (entity != null) {
                entityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return entityList;
    }

    private IraiJohoDataTorikomiHandler getHandler(IraiJohoDataTorikomiDiv div) {
        return new IraiJohoDataTorikomiHandler(div);
    }

    private IraiJohoDataTorikomiValidationHandler getValidationHandler(IraiJohoDataTorikomiDiv div) {
        return new IraiJohoDataTorikomiValidationHandler(div);
    }
}
