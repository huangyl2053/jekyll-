/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdoTblTmpEntity;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * データ比較処理を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class DataCompareShoriProcess extends BatchKeyBreakBase<IdoTblTmpEntity> {

    private static final RString READ_DATA_ID = new RString("");
    private static final RString CSV_FILENAME = new RString("JukyusyaIdouJohoRirekilist.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200074");
    private static final int COUNT_0 = 0;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSV_作成年月日 = new RString("作成年月日");
    private static final RString CSV_ページ数 = new RString("ページ数");
    private static final RString CSV_市町村コード = new RString("市町村コード");
    private static final RString CSV_市町村名称 = new RString("市町村名称");
    private static final RString CSV_被保険者番号1 = new RString("被保険者番号1");
    private static final RString CSV_氏名1 = new RString("氏名1");
    private static final RString CSV_異動年月日１ = new RString("異動年月日１");
    private static final RString CSV_訂正情報_項目１ = new RString("訂正情報　項目１");
    private static final RString CSV_訂正情報_項目２ = new RString("訂正情報　項目２");
    private static final RString CSV_訂正情報_項目３ = new RString("訂正情報　項目３");
    private static final RString CSV_訂正情報_項目４ = new RString("訂正情報　項目４");
    private static final RString CSV_訂正情報_項目５ = new RString("訂正情報　項目５");
    private static final RString CSV_訂正情報_項目６ = new RString("訂正情報　項目６");
    private static final RString CSV_訂正情報_項目７ = new RString("訂正情報　項目７");
    private static final RString CSV_訂正情報_項目８ = new RString("訂正情報　項目８");
    private static final RString CSV_訂正情報_項目９ = new RString("訂正情報　項目９");
    private static final RString CSV_訂正情報_項目１０ = new RString("訂正情報　項目１０");
    private static final RString CSV_訂正情報_項目１１ = new RString("訂正情報　項目１１");
    private static final RString CSV_訂正情報_項目１２ = new RString("訂正情報　項目１２");
    private static final RString CSV_被保険者番号２ = new RString("被保険者番号２");
    private static final RString CSV_氏名２ = new RString("氏名２");
    private static final RString CSV_異動年月日２ = new RString("異動年月日２");
    private static final RString CSV_訂正情報_送付済内容１ = new RString("訂正情報　送付済内容１");
    private static final RString CSV_訂正情報_送付済内容２ = new RString("訂正情報　送付済内容２");
    private static final RString CSV_訂正情報_送付済内容３ = new RString("訂正情報　送付済内容３");
    private static final RString CSV_訂正情報_送付済内容４ = new RString("訂正情報　送付済内容４");
    private static final RString CSV_訂正情報_送付済内容５ = new RString("訂正情報　送付済内容５");
    private static final RString CSV_訂正情報_送付済内容６ = new RString("訂正情報　送付済内容６");
    private static final RString CSV_訂正情報_送付済内容７ = new RString("訂正情報　送付済内容７");
    private static final RString CSV_訂正情報_訂正内容８ = new RString("訂正情報　訂正内容８");
    private static final RString CSV_訂正情報_訂正内容９ = new RString("訂正情報　訂正内容９");
    private static final RString CSV_訂正情報_訂正内容１０ = new RString("訂正情報　訂正内容１０");
    private static final RString CSV_訂正情報_訂正内容１１ = new RString("訂正情報　訂正内容１１");
    private static final RString CSV_訂正情報_訂正内容１２ = new RString("訂正情報_訂正内容１２");
    private static final RString 証保険番号 = new RString("証保険番号");
    private static final RString 資格取得日 = new RString("資格取得日");
    private static final RString 資格喪失日 = new RString("資格喪失日");
    private static final RString 変更申請中 = new RString("変更申請中");
    private static final RString 申請年月日 = new RString("申請年月日");
    private static final RString みなし区分 = new RString("みなし区分");
    private static final RString 要介護度 = new RString("要介護度");
    private static final RString 認定開始日 = new RString("認定開始日");
    private static final RString 認定終了日 = new RString("認定終了日");
    private static final RString 計作成区分 = new RString("計作成区分");
    private static final RString 記号 = new RString("*");

    private RString eucFilePath;
    private int 連番;
    private RString 市町村コード = RString.EMPTY;
    private RString 市町村名称 = RString.EMPTY;
    private RString 作成年月日 = RString.EMPTY;
    private FileSpoolManager spoolManager;
    private CsvListWriter csvListWriter;

    @Override
    protected void initialize() {
        市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        市町村名称 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records().get(COUNT_0).get市町村名称();
        RDateTime sysDate = RDate.getNowDateTime();
        RString 年月日 = sysDate.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        RTime 時刻 = sysDate.getTime();
        作成年月日 = new RString(年月日.toString()
                + 時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        連番 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(),
                CSV_FILENAME);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .setHeader(getHeaderList())
                .build();
    }

    @Override
    protected void keyBreakProcess(IdoTblTmpEntity entity) {
    }

    @Override
    protected void usualProcess(IdoTblTmpEntity entity) {

        csvListWriter.writeLine(getBodyList(entity));
    }

    @Override
    protected void afterExecute() {
        csvListWriter.close();
        spoolManager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
    }

    /**
     * CSVヘッダを設定します。
     *
     * @return {@link List<RString>}
     */
    public List<RString> getHeaderList() {
        List<RString> headerList = new ArrayList<>();
        headerList.add(CSV_作成年月日);
        headerList.add(CSV_ページ数);
        headerList.add(CSV_市町村コード);
        headerList.add(CSV_市町村名称);
        headerList.add(CSV_被保険者番号1);
        headerList.add(CSV_氏名1);
        headerList.add(CSV_異動年月日１);
        headerList.add(CSV_訂正情報_項目１);
        headerList.add(CSV_訂正情報_項目２);
        headerList.add(CSV_訂正情報_項目３);
        headerList.add(CSV_訂正情報_項目４);
        headerList.add(CSV_訂正情報_項目５);
        headerList.add(CSV_訂正情報_項目６);
        headerList.add(CSV_訂正情報_項目７);
        headerList.add(CSV_訂正情報_項目８);
        headerList.add(CSV_訂正情報_項目９);
        headerList.add(CSV_訂正情報_項目１０);
        headerList.add(CSV_訂正情報_項目１１);
        headerList.add(CSV_訂正情報_項目１２);
        headerList.add(CSV_被保険者番号２);
        headerList.add(CSV_氏名２);
        headerList.add(CSV_異動年月日２);
        headerList.add(CSV_訂正情報_送付済内容１);
        headerList.add(CSV_訂正情報_送付済内容２);
        headerList.add(CSV_訂正情報_送付済内容３);
        headerList.add(CSV_訂正情報_送付済内容４);
        headerList.add(CSV_訂正情報_送付済内容５);
        headerList.add(CSV_訂正情報_送付済内容６);
        headerList.add(CSV_訂正情報_送付済内容７);
        headerList.add(CSV_訂正情報_訂正内容８);
        headerList.add(CSV_訂正情報_訂正内容９);
        headerList.add(CSV_訂正情報_訂正内容１０);
        headerList.add(CSV_訂正情報_訂正内容１１);
        headerList.add(CSV_訂正情報_訂正内容１２);
        return headerList;
    }

    /**
     * CSVレコードを取得します。
     *
     * @param entity IdoTblTmpEntity
     *
     * @return {@link List<RString>}
     */
    private List<RString> getBodyList(IdoTblTmpEntity entity) {
        List<RString> bodyList = new ArrayList<>();
        bodyList.add(作成年月日);
        bodyList.add(市町村コード);
        bodyList.add(市町村名称);
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
            bodyList.add(entity.get被保険者番号().value());
        }
        bodyList.add(entity.get被保険者氏名カナ());
        bodyList.add(dateChangeToRString(entity.get異動年月日()));
        bodyList.add(証保険番号);
        bodyList.add(資格取得日);
        bodyList.add(資格喪失日);
        bodyList.add(変更申請中);
        bodyList.add(申請年月日);
        bodyList.add(みなし区分);
        bodyList.add(要介護度);
        bodyList.add(認定開始日);
        bodyList.add(認定終了日);
        bodyList.add(計作成区分);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        if (entity.get証記載保険者番号() != null && !entity.get証記載保険者番号().isEmpty()) {
            bodyList.add(entity.get証記載保険者番号().value());
        }
        bodyList.add(dateChangeToRString(entity.get資格取得年月日()));
        bodyList.add(entity.get変更申請中区分コード());
        bodyList.add(dateChangeToRString(entity.get申請年月日()));
        bodyList.add(entity.getみなし要介護状態区分コード());
        bodyList.add(entity.get要介護状態区分コード());
        bodyList.add(dateChangeToRString(entity.get認定有効期間開始年月日()));
        bodyList.add(dateChangeToRString(entity.get認定有効期間終了年月日()));
        bodyList.add(entity.get居宅サービス計画作成区分コード());
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(記号);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        return bodyList;
    }

    private RString dateChangeToRString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }
}
