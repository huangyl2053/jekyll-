/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd8100201.NennkinnBanngouCsvProperty;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.NennkinnBanngouCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.NennkinnBanngouCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchWriter;
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
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * ファイル出力(非課税年金対象者情報　年金番号～CSV)_process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_miaocl
 */
public class NennkinnBanngouCsvProcess extends BatchProcessBase<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazeinennkintaishousyajohotorikomi."
            + "IResultIchirannMapper.get年金番号情報");
    private NennkinnBanngouCsvProcessParameter parameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBD900005"));
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private RString spoolWorkPath;
    private RString fileName;
    private RString reamsLoginID;
    private CsvWriter<NennkinnBanngouCsvEntity> csvWriterJunitoJugo;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final int Seven = 7;
    private static final int Three = 3;
    private static final int Zero = 0;
    private static final ReportId REPORT_DBD900005 = ReportIdDBD.DBD900005.getReportId();

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        fileName = Path.combinePath(spoolWorkPath, new RString("HikazeiNenkinNenkinNoChackList.csv"));
        csvWriterJunitoJugo = new CsvWriter.InstanceBuilder(fileName)
                .alwaysWriteHeader(NennkinnBanngouCsvEntity.class)
                .setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, REPORT_DBD900005, reamsLoginID, parameter.get出力順ID4());
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(NennkinnBanngouCsvProperty.DBD900005_ResultListEnum.class, order);
        }
        return 出力順;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toNennkinnBanngouCsvMybatisParameter(get出力順()));
    }

    protected void process(HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity t) {
        NennkinnBanngouCsvEntity eucCsvEntity = new NennkinnBanngouCsvEntity();
        EucCsvEntity(eucCsvEntity, t);
        csvWriterJunitoJugo.writeLine(eucCsvEntity);
        ExpandedInformation expandedInformations
                = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), t.getHihokenshaNo().getColumnValue());
        PersonalData personalData = PersonalData.of(t.getShikibetsuCode(), expandedInformations);
        personalDataList.add(personalData);

        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        IBatchWriter batchWriter = (IBatchWriter) csvWriterJunitoJugo;
        batchWriter.close();
        manager.spool(fileName, id);

    }

    @Override
    protected void afterExecute() {
        csvWriterJunitoJugo.close();
    }

    private void EucCsvEntity(NennkinnBanngouCsvEntity eucCsvEntity, HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity t) {
        eucCsvEntity.set市町村コード(t.getDtShichosonCode());
        eucCsvEntity.set被保険者番号(t.getHihokenshaNo().getColumnValue());
        eucCsvEntity.set年金保険者コード(t.getDtNennkinnHokenshaCode());
        eucCsvEntity.set年金保険者(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.年金保険者コード.getCodeShubetsu(), new Code(t.getDtNennkinnHokenshaCode())));
        eucCsvEntity.set基礎年金番号(t.getDtKisoNennkinnNo());
        eucCsvEntity.set年金コード(t.getNennkinnCode());
        eucCsvEntity.set年金名称(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.年金保険者コード.getCodeShubetsu(), new Code(set年金(t.getNennkinnCode()))));
        eucCsvEntity.set識別コード(t.getShikibetsuCode().getColumnValue());
        eucCsvEntity.set世帯コード(t.getShotaiCode());
        eucCsvEntity.set生年月日(set年月日(t.getDtSeinenngappi()));
        eucCsvEntity.set性別コード(t.getDtSeibetsu());
        eucCsvEntity.set性別(Enum性別コード(t.getDtSeibetsu()));
        eucCsvEntity.setカナ氏名(t.getDtKanaShimei());
        eucCsvEntity.set漢字氏名(t.getAtenaKanaShimei());
        eucCsvEntity.set郵便番号(setフォーマット(t.getDtYubinNo()));
        eucCsvEntity.set住所(t.getDtKanajusyo());
    }

    private RString set年月日(RString 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        } else {
            FlexibleDate date = new FlexibleDate(年月日);
            return date.seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        }
    }

    private RString Enum性別コード(RString code) {
        if (Seibetsu.男.getコード().equals(code)) {
            return 男;
        } else if (Seibetsu.女.getコード().equals(code)) {
            return 女;
        } else {
            return RString.EMPTY;
        }
    }

    private RString setフォーマット(RString obj) {

        StringBuilder builder = new StringBuilder();

        if (!obj.isNullOrEmpty() && obj.length() >= Seven) {
            builder.append(obj.substring(Zero, Three));
            builder.append(new RString("-"));
            builder.append(obj.substring(Three, Seven));
        }
        return new RString(builder.toString());
    }

    private RString set年金(RString obj) {
        if (!obj.isNullOrEmpty()) {
            return obj.substring(Zero, Three);
        } else {
            return RString.EMPTY;
        }
    }
}
