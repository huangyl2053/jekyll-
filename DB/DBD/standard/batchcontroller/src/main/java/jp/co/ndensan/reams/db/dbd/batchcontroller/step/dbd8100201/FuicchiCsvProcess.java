/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201;

import jp.co.ndensan.reams.db.dbd.business.report.dbd8100201.FuicchiCsvProcessProperty;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.KakushuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.ShoriKekka;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TeiseiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.FuicchiCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.FuicchiCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * ファイル出力(非課税年金対象者情報　不一致～CSV)_process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_miaocl
 */
public class FuicchiCsvProcess extends BatchProcessBase<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.hikazeinennkintaishousyajohotorikomi.IResultIchirannMapper.get不一致情報");
    private FuicchiCsvProcessParameter parameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBD900003"));
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final RString 初回回付 = new RString("初回回付");
    private static final RString 月次回付 = new RString("月次回付");
    private static final RString 新規者 = new RString("新規者");
    private static final RString 前年度継続者 = new RString("前年度継続者");
    private static final RString 初期値 = new RString("初期値");
    private static final RString 受給権の失権 = new RString("受給権の失権");
    private static final RString 差止一時差止停止 = new RString("差止・一時差止・停止");
    private static final RString 同一日 = new RString("同一日");
    private static final RString 不一致 = new RString("不一致");
    private static final RString 同一人 = new RString("同一人");
    private FileSpoolManager manager;
    private RString spoolWorkPath;
    private RString fileName;
    private RString reamsLoginID;
    private CsvWriter<FuicchiCsvEntity> csvWriterJunitoJugo;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int SEVEN = 7;
    private static final int THREE = 3;
    private static final int ZERO = 0;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE_T = new RString("3");
    private static final RString BAR = new RString("-");

    private static final ReportId REPORT_DBD900003 = ReportIdDBD.DBD900003.getReportId();

    @Override
    protected void initialize() {
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        fileName = Path.combinePath(spoolWorkPath, new RString("HikazeiNenkinFuicchiCheckList.csv"));
        csvWriterJunitoJugo = new CsvWriter.InstanceBuilder(fileName)
                .alwaysWriteHeader(FuicchiCsvEntity.class)
                .setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, REPORT_DBD900003, reamsLoginID, parameter.get出力順ID2());
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(FuicchiCsvProcessProperty.DBD900003_ResultListEnum.class, order);
        }
        return 出力順;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toFuicchiCsvMybatisParameter(get出力順()));
    }

    @Override
    protected void process(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity t) {
        FuicchiCsvEntity eucCsvEntity = new FuicchiCsvEntity();
        eucCsvEntity(eucCsvEntity, t);
        csvWriterJunitoJugo.writeLine(eucCsvEntity);
        manager.spool(fileName);

    }

    @Override
    protected void afterExecute() {
        csvWriterJunitoJugo.close();
    }

    private void eucCsvEntity(FuicchiCsvEntity eucCsvEntity, HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity t) {
        eucCsvEntity.set市町村コード(t.getDtShichosonCode());
        eucCsvEntity.set年金保険者コード(t.getDtNennkinnHokenshaCode());
        eucCsvEntity.set年金保険者名称(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                UEXCodeShubetsu.年金保険者コード.getCodeShubetsu(), new Code(t.getDtNennkinnHokenshaCode())));
        eucCsvEntity.set基礎年金番号(t.getDtKisoNennkinnNo());
        eucCsvEntity.set年金コード(t.getDtNennkinnCode());
        eucCsvEntity.set年金名称(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                UEXCodeShubetsu.年金保険者コード.getCodeShubetsu(), new Code(set年金(t.getDtNennkinnCode()))));
        eucCsvEntity.set対象年(t.getDtTaisyoYear());
        eucCsvEntity.set生年月日(set年月日(t.getDtSeinenngappi()));
        eucCsvEntity.set性別コード(t.getDtSeibetsu());
        eucCsvEntity.set性別(set性別コード(t.getDtSeibetsu()));
        eucCsvEntity.setカナ氏名(t.getDtKanaShimei());
        eucCsvEntity.set漢字氏名(t.getDtKanjiShimei());
        eucCsvEntity.set郵便番号(setフォ(t.getDtYubinNo()));
        eucCsvEntity.set住所(t.getDtKanajusyo());
        eucCsvEntity.set訂正表示コード(t.getDtTeiseiHyouji());
        eucCsvEntity.set訂正表示(set訂正表示(t.getDtTeiseiHyouji()));
        eucCsvEntity.set各種区分コード(t.getDtKakushuKubun());
        eucCsvEntity.set各種区分(set各種区分(t.getDtKakushuKubun()));
        eucCsvEntity.set処理結果コード(t.getDtShoriResult());
        eucCsvEntity.set処理結果(set処理結果(t.getDtShoriResult()));
        eucCsvEntity.set金額(set除去(t.getDtkinngaku1()));
        eucCsvEntity.set出力事由(set不一致事由(t.getFuicchiJiyu()));

    }

    private RString set性別コード(RString code) {
        if (Seibetsu.男.getコード().equals(code)) {
            return 男;
        } else if (Seibetsu.女.getコード().equals(code)) {
            return 女;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set訂正表示(RString code) {
        if (TeiseiHyoji.初回回付.getコード().equals(code)) {
            return 初回回付;
        } else if (TeiseiHyoji.月次回付.getコード().equals(code)) {
            return 月次回付;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set各種区分(RString code) {
        if (KakushuKubun.新規者.getコード().equals(code)) {
            return 新規者;
        } else if (KakushuKubun.前年度継続者.getコード().equals(code)) {
            return 前年度継続者;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set処理結果(RString code) {
        if (ShoriKekka.初期値.getコード().equals(code)) {
            return 初期値;
        } else if (ShoriKekka.受給権の失権.getコード().equals(code)) {
            return 受給権の失権;
        } else if (ShoriKekka.差止_一時差し止め_停止.getコード().equals(code)) {
            return 差止一時差止停止;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set不一致事由(RString code) {
        if (ONE.equals(code)) {
            return 同一日;
        } else if (TWO.equals(code)) {
            return 不一致;
        } else if (THREE_T.equals(code)) {
            return 同一人;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set年月日(RString 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        } else {
            FlexibleDate date = new FlexibleDate(年月日);
            return date.seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        }
    }

    private RString setフォ(RString obj) {

        StringBuilder builder = new StringBuilder();

        if (!obj.isNullOrEmpty() && obj.length() >= SEVEN) {
            builder.append(obj.substring(ZERO, THREE));
            builder.append(BAR);
            builder.append(obj.substring(THREE, SEVEN));
        }
        return new RString(builder.toString());
    }

    private RString set除去(RString code) {
        if (!code.isNullOrEmpty()) {
            return new RString(Decimal.valueOf(Long.parseLong(code.toString())).toString());
        } else {
            return RString.EMPTY;
        }
    }

    private RString set年金(RString obj) {
        if (!obj.isNullOrEmpty()) {
            return obj.substring(ZERO, THREE);
        } else {
            return RString.EMPTY;
        }
    }
}
