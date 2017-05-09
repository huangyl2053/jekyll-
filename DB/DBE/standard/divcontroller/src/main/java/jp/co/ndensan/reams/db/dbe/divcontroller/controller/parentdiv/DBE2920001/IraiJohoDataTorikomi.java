/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2920001;

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
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
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

    private static final RString 奇数行 = new RString("1");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * 依頼情報データ受取（オルカ）の初期化。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @return レスポンスデータ
     */
    public ResponseData<IraiJohoDataTorikomiDiv> onLoad(IraiJohoDataTorikomiDiv div) {
        return ResponseData.of(div).setState(DBE2920001StateName.初期状態);
    }

    /**
     * アップロードボタンのonClick処理です。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @param files ファイル
     * @return レスポンスデータ
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<IraiJohoDataTorikomiDiv> onClick_BtnUpload(IraiJohoDataTorikomiDiv div, FileData[] files) {
        {
            ValidationMessageControlPairs uploaded = getValidationHandler(div).取込みファイル対象未選択チェック(files);
            if (uploaded.existsError()) {
                return ResponseData.of(div).addValidationMessages(uploaded).respond();
            }
        }
        IraiJohoDataTorikomiCsvData csvData = parseCsv(files);
        ValidationMessageControlPairs parsed = getValidationHandler(div).データを取込のチェック(csvData);
        if (parsed.existsError()) {
            return ResponseData.of(div).addValidationMessages(parsed).respond();
        }
        ViewStateHolder.put(ViewStateKeys.要介護認定主治医意見書情報, csvData);
        getHandler(div).set一覧エリア(csvData);
        return ResponseData.of(div).respond();
    }

    private static IraiJohoDataTorikomiCsvData parseCsv(FileData[] files) {
        List<IraiJohoDataTorikomiCsvEntity> list = new ArrayList<>();
        for (FileData f : files) {
            list.addAll(insertCsvDate(f.getFilePath()));
        }
        return new IraiJohoDataTorikomiCsvData(list);
    }

    private static List<IraiJohoDataTorikomiCsvEntity> insertCsvDate(RString filePath) {
        List<IraiJohoDataTorikomiCsvEntity> list = new ArrayList<>();
        try (CsvReader<IraiJohoDataTorikomiCsvEntity> csvReader = createCsvReader(filePath)) {
            while (true) {
                IraiJohoDataTorikomiCsvEntity entity = csvReader.readLine();
                if (entity == null) {
                    break;
                }
                list.add(entity);
            }
        }
        return list;
    }

    private static CsvReader<IraiJohoDataTorikomiCsvEntity> createCsvReader(RString filePath) {
        return new CsvReader.InstanceBuilder(filePath, IraiJohoDataTorikomiCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.LF).build();
    }

    /**
     * 入力チェックボタンのonClick処理です。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @return レスポンスデータ
     */
    public ResponseData<IraiJohoDataTorikomiDiv> onClick_NyuryokuCyeku(IraiJohoDataTorikomiDiv div) {
        List<NinteiShinseiJohoIraiJohoData> ninteiShinseiJohoList = new ArrayList<>();
        for (dgTorikomiFileIchiran_Row row : div.getDgTorikomiFileIchiran().getDataSource()) {
            if (奇数行.equals(row.getKiguusuu())) {
                IraiJohoDataTorikomiParameter parameter = new IraiJohoDataTorikomiParameter();
                parameter.set保険者番号(row.getHokenshaBango());
                parameter.set被保険者番号(row.getHihokenshaBango());
                parameter.set認定申請年月日(row.getShinseibi().getValue());
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
        List<IkenshokinyuyoshiBusiness> businessList = new ArrayList<>();
        for (dgTorikomiFileIchiran_Row row : div.getDgTorikomiFileIchiran().getDataSource()) {
            if (!row.getCheckBox().isAllSelected()) {
                continue;
            }
            IraiJohoDataTorikomiCsvEntity csvEntity
                    = csvData.getOrNull(row.getHokenshaBango(), row.getHihokenshaBango(), row.getShinseibi().getValue());
            if (csvEntity == null) {
                continue;
            }
            businessList.add(getHandler(div).帳票出力用情報の編集(csvEntity));
        }
        return ResponseData.of(publishShujiiIkensho(businessList)).respond();
    }

    private SourceDataCollection publishShujiiIkensho(List<IkenshokinyuyoshiBusiness> businessList) {
        try (ReportManager reportManager = new ReportManager()) {
            Ikenshokinyuyoshi01PrintService printService = new Ikenshokinyuyoshi01PrintService(reportManager);
            for (IkenshokinyuyoshiBusiness business : businessList) {
                printService.print主治医意見書01(business);
                printService.print主治医意見書02(business);
            }
            return reportManager.publish();
        }
    }

    /**
     * 保存するボタンのonClick処理です。
     *
     * @param div IraiJohoDataTorikomiDiv
     * @return レスポンスデータ
     */
    public ResponseData<IraiJohoDataTorikomiDiv> onClick_Koushin(IraiJohoDataTorikomiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if ((!new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) && !ResponseHolder.isWarningIgnoredRequest()) {
            return ResponseData.of(div).respond();
        }
        {
            ValidationMessageControlPairs validationMessages = getValidationHandler(div).申請日のチェック();
            if (validationMessages.existsError() && !ResponseHolder.isWarningIgnoredRequest()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
        }
        IraiJohoDataTorikomiCsvData csvData = ViewStateHolder.get(ViewStateKeys.要介護認定主治医意見書情報, IraiJohoDataTorikomiCsvData.class);
        for (dgTorikomiFileIchiran_Row row : div.getDgTorikomiFileIchiran().getDataSource()) {
            if (!row.getCheckBox().isAllSelected()) {
                continue;
            }
            IkenshokinyuyoshiBusiness business = getBusiness(csvData, row, div);
            IraiJohoDataTorikomiManager.createInstance().各テーブルへの登録(row.getShinseishoKanriNo(),
                    row.getIkenshoIraiRirekiNo().getValue().intValue(), row.getKoroshoIfShikibetsuCode(),
                    row.getShujiiIryokikanCode(), row.getShujiiCode(), business);
        }
        return ResponseData.of(div).respond();
    }

    private IkenshokinyuyoshiBusiness getBusiness(IraiJohoDataTorikomiCsvData csvData,
            dgTorikomiFileIchiran_Row row, IraiJohoDataTorikomiDiv div) {
        IkenshokinyuyoshiBusiness business = new IkenshokinyuyoshiBusiness();
        IraiJohoDataTorikomiCsvEntity csvEntity
                = csvData.getOrNull(row.getHokenshaBango(), row.getHihokenshaBango(), row.getShinseibi().getValue());
        if (csvEntity == null) {
            return business;
        }
        return getHandler(div).帳票出力用情報の編集(csvEntity);
    }

    private IraiJohoDataTorikomiHandler getHandler(IraiJohoDataTorikomiDiv div) {
        return new IraiJohoDataTorikomiHandler(div);
    }

    private IraiJohoDataTorikomiValidationHandler getValidationHandler(IraiJohoDataTorikomiDiv div) {
        return new IraiJohoDataTorikomiValidationHandler(div);
    }
}
