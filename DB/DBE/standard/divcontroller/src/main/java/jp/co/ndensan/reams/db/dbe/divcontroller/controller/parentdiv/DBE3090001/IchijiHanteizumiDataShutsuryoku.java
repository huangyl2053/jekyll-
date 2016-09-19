/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE3090001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE309003.DBE309003_IchijihanteiSumidataIfParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001.DBE3090001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001.IchijiHanteizumiDataShutsuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001.dgIchijiHanteiZumi_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3090001.IchijiHanteizumiDataShutsuryokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3090001.IchijiHanteizumiDataShutsuryokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3090001.ItiziHanteiZumiItiranEntity;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE3090001_一次判定データ出力です。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijiHanteizumiDataShutsuryoku {

    private final IchijiHanteizumiDataShutsuryokuFinder finder;
    private static final RString CSVファイル名 = new RString("IchijiHanteiSumiIchiran.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 申請日 = new RString("0");
    private static final RString 一次判定日 = new RString("1");

    /**
     * コンストラクタです。
     */
    public IchijiHanteizumiDataShutsuryoku() {
        finder = IchijiHanteizumiDataShutsuryokuFinder.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 一次判定データ出力div
     * @return ResponseData<IchijiHanteizumiDataShutsuryokuDiv>
     */
    public ResponseData<IchijiHanteizumiDataShutsuryokuDiv> onLoad(IchijiHanteizumiDataShutsuryokuDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE3090001StateName.初期表示);
    }

    /**
     * 「日付指定」ラジオボタンの画面制御処理です。
     *
     * @param div 一次判定データ出力div
     * @return ResponseData<IchijiHanteizumiDataShutsuryokuDiv>
     */
    public ResponseData<IchijiHanteizumiDataShutsuryokuDiv> onChange_Shinseibi(IchijiHanteizumiDataShutsuryokuDiv div) {
        getHandler(div).settxtShinseibi();
        return ResponseData.of(div).setState(DBE3090001StateName.初期表示);
    }

    /**
     * 「条件をクリアする」ボタンの検索条件をクリアする。
     *
     * @param div 一次判定データ出力div
     * @return ResponseData<IchijiHanteizumiDataShutsuryokuDiv>
     */
    public ResponseData<IchijiHanteizumiDataShutsuryokuDiv> onClick_btnKensakuClear(IchijiHanteizumiDataShutsuryokuDiv div) {
        getHandler(div).setbtnKensakuClear();
        return ResponseData.of(div).setState(DBE3090001StateName.初期表示);
    }

    /**
     * 一次判定済みデータの取得する。
     *
     * @param div 一次判定データ出力div
     * @return ResponseData<IchijiHanteizumiDataShutsuryokuDiv>
     */
    public ResponseData<IchijiHanteizumiDataShutsuryokuDiv> onClick_btnKensaku(IchijiHanteizumiDataShutsuryokuDiv div) {
        if (申請日.equals(div.getRadJyoken().getSelectedKey())) {
            ValidationMessageControlPairs validPairsMessage = getValidatisonHandlerr(div).get申請日必須入力チェック();
            if (validPairsMessage.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairsMessage).respond();
            }
        } else if (一次判定日.equals(div.getRadJyoken().getSelectedKey())) {
            ValidationMessageControlPairs validPairs = getValidatisonHandlerr(div).get一次判定日必須チェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        List<IchijiHanteizumiDataShutsuryokuBusiness> 一次判定情報List = finder.get次判定済みデータ(getHandler(div).createParam()).records();
        getHandler(div).setdgIchijiHanteiZumi(一次判定情報List);
        return ResponseData.of(div).setState(DBE3090001StateName.検索結果);
    }

    /**
     * 一覧表を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div IchijiHanteizumiDataShutsuryokuDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(IchijiHanteizumiDataShutsuryokuDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<ItiziHanteiZumiItiranEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgIchijiHanteiZumi_Row> dgChosainList = div.getDgIchijiHanteiZumi().getSelectedItems();
            for (dgIchijiHanteiZumi_Row row : dgChosainList) {
                csvWriter.writeLine(set一次判定済一覧(row));
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
     * 「一次判定結果票を出力する」ボタンを押下。
     *
     * @param div 一次判定データ出力div
     * @return ResponseData
     */
    public ResponseData<IchijiHanteizumiDataShutsuryokuDiv> onClick_btnIchijiHanteiKekkahyoShutsuryoku(IchijiHanteizumiDataShutsuryokuDiv div) {
        ValidationMessageControlPairs validPairs = getValidatisonHandlerr(div).validate一覧未選択チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<IchijiHanteizumiDataBusiness> 一次判定結果list = finder.get一次判定結果情報(getHandler(div).createParam帳票()).records();
        getHandler(div).set帳票(一次判定結果list);
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定ソフト用データを出力する」ボタンを押下時、バッチパラメータを引き渡し、バッチを起動する。
     *
     * @param div 一次判定データ出力div
     * @return ResponseData
     */
    public ResponseData<DBE309003_IchijihanteiSumidataIfParameter> onClick_jiko(IchijiHanteizumiDataShutsuryokuDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * 対象者一覧データの選択チェック。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteizumiDataShutsuryokuDiv> btn_check(IchijiHanteizumiDataShutsuryokuDiv div) {

        ValidationMessageControlPairs validation = getValidatisonHandlerr(div).validate一覧未選択チェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        return ResponseData.of(div).respond();
    }

    private IchijiHanteizumiDataShutsuryokuHandler getHandler(IchijiHanteizumiDataShutsuryokuDiv div) {
        return new IchijiHanteizumiDataShutsuryokuHandler(div);
    }

    private IchijiHanteizumiDataShutsuryokuValidationHandler getValidatisonHandlerr(IchijiHanteizumiDataShutsuryokuDiv div) {
        return new IchijiHanteizumiDataShutsuryokuValidationHandler(div);
    }

    /**
     * CSVでEntityの設定します。
     *
     * @param div div
     * @return List<ItiziHanteiZumiItiranEntity>
     */
    private ItiziHanteiZumiItiranEntity set一次判定済一覧(dgIchijiHanteiZumi_Row row) {
        ItiziHanteiZumiItiranEntity entity = new ItiziHanteiZumiItiranEntity();
        entity.set保険者名(row.getHokenshaMei());
        entity.set申請日(row.getShinseibi());
        entity.set被保険者_被保番号(row.getHihoBango());
        entity.set被保険者_氏名(row.getShimei());
        entity.set申請区分_申請時(row.getShinseitoki());
        entity.set申請区分_法令(row.getHorei());
        entity.set一次判定_完了日(row.getKanryobi());
        entity.set一次判定_一次判定結果(row.getIchijihanteikekka());
        entity.set一次判定_資料作成(row.getShiryoSakusei());
        entity.set一次判定_警告コード(row.getKeikokuCode());
        return entity;

    }
}
