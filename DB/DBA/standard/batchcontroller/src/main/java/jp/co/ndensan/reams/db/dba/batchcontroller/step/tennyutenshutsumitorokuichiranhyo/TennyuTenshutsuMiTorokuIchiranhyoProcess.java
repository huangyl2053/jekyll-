package jp.co.ndensan.reams.db.dba.batchcontroller.step.tennyutenshutsumitorokuichiranhyo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidomishorisha.TennyuSakuseiJiyu;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidomishorisha.TenshutsuSakuseiJiyu;
import jp.co.ndensan.reams.db.dba.definition.processprm.tennyutensyutsumitorokuichiranhyo.TennyuTensyutsuMiTorokuIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TennyuHosyutaiSyosyaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TensyuHosyutaiSyosyaEntity;
import jp.co.ndensan.reams.db.dba.entity.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMitorokuIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyutenshutsumitorokuichiranhyo.ITennyuTenshutsuMiTorokuIchiranhyoMapper;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 転入転出未登録一覧表のProcessクラスです。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
public class TennyuTenshutsuMiTorokuIchiranhyoProcess extends BatchProcessBase<TennyuHosyutaiSyosyaEntity> {

//    private static final int INDEX_0 = 0;
//    private static final int INDEX_1 = 1;
//    private static final int INDEX_2 = 2;
//    private static final int INDEX_3 = 3;
//    private static final int INDEX_4 = 4;
    private static final RString フラグ1 = new RString("1");
    private static final RString 住所地特例フラグ1 = new RString("住所地特例");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 転入 = new RString("転入不一致");
    private static final RString 転出 = new RString("転出不一致");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity");
    private static final RString FILENAME = new RString("ShikakuIdoMishorishaIchiranhyo_");
    private static final RString FILENAMEGO = new RString(".csv");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyutenshutsumitorokuichiranhyo."
            + "ITennyuTenshutsuMiTorokuIchiranhyoMapper.get転入保留対象者");
    TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem;
    private ITennyuTenshutsuMiTorokuIchiranhyoMapper mapper;
    private List<RString> page_break_keys;
    private FileSpoolManager manager;
    private RString eucFilePath;
    List<TennyuTenshutsuMiTorokuIchiranhyoBodyItem> bodyItemList;
    private TennyuTensyutsuMiTorokuIchiranhyoProcessParameter processParamter;
    @BatchWriter
    private BatchReportWriter<TennyuTenshutsuMitorokuIchiranhyoReportSource> batchWriter;
    private ReportSourceWriter<TennyuTenshutsuMitorokuIchiranhyoReportSource> reportSourceWriter;
    private EucCsvWriter<TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity> eucCsvWriter;
    private List<TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity> eucCsvList;

    @Override
    protected void initialize() {
        mapper = getMapper(ITennyuTenshutsuMiTorokuIchiranhyoMapper.class);
        bodyItemList = new ArrayList<>();
        eucCsvList = new ArrayList<>();
        editHeader();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toTennyuTensyutsuMiTorokuIchiranhyoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200014.getReportId().value())
                .addBreak(new BreakerCatalog<TennyuTenshutsuMitorokuIchiranhyoReportSource>().simplePageBreaker(page_break_keys))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(TennyuHosyutaiSyosyaEntity entity) {
        if (!processParamter.getTennyusakuseijiyucode().isEmpty()) {
            TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity csvEntity = new TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity();
            TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem = new TennyuTenshutsuMiTorokuIchiranhyoBodyItem();
            setNyuBodyItem(entity, csvEntity, bodyItem);
            bodyItemList.add(bodyItem);
            eucCsvList.add(csvEntity);
        }
    }

    @Override
    protected void afterExecute() {
        if (!processParamter.getTensyutsusakuseiJiyucode().isEmpty()) {
            List<TensyuHosyutaiSyosyaEntity> syuHosyutaiSyosyaEntityList = mapper.get転出保留対象者(
                    processParamter.toTennyuTensyutsuMiTorokuIchiranhyoMybatisParameter());
            for (TensyuHosyutaiSyosyaEntity entity : syuHosyutaiSyosyaEntityList) {
                TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity csvEntity = new TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity();
                TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem = new TennyuTenshutsuMiTorokuIchiranhyoBodyItem();
                setShuBodyItem(entity, csvEntity, bodyItem);
                bodyItemList.add(bodyItem);
                eucCsvList.add(csvEntity);
            }
        }
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        if (!eucCsvList.isEmpty()) {
            Collections.sort(eucCsvList, new Comparator<TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity>() {
                @Override
                public int compare(TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity entity1, TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity entity2) {
                    return entity1.getShichosonCode().compareTo(entity2.getShichosonCode());
                }
            });
        }
        if (processParamter.getShichosoncode().size() > 1) {
            setFilePath(RString.EMPTY, spoolWorkPath);
            set全市町村Csv();
        } else {
            set市町村コードCsv(spoolWorkPath);
        }
        if (!eucCsvList.isEmpty()) {
            eucCsvWriter.close();
            manager.spool(eucFilePath);
        }
        TennyuTenshutsuMiTorokuIchiranhyoReport report = TennyuTenshutsuMiTorokuIchiranhyoReport.createFrom(headItem, bodyItemList);
        report.writeBy(reportSourceWriter);

    }

    private void set全市町村Csv() {
        for (TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity eucCsvEntity : eucCsvList) {
            eucCsvWriter.writeLine(eucCsvEntity);
        }
    }

    private void set市町村コードCsv(RString spoolWorkPath) {
        int i = 1;
        RString backShichosonCode = new RString("back");
        for (TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity eucCsvEntity : eucCsvList) {
            RString shichosonCode = eucCsvEntity.getShichosonCode();
            if (!backShichosonCode.equals(shichosonCode)) {
                if (i != 1) {
                    eucCsvWriter.close();
                }
                setFilePath(shichosonCode, spoolWorkPath);
                backShichosonCode = shichosonCode;
            }
            eucCsvWriter.writeLine(eucCsvEntity);
            i++;
        }
    }

    private void setFilePath(RString shichosonCode, RString spoolWorkPath) {
        RStringBuilder filePath = new RStringBuilder();
        if (processParamter.getShichosoncode().size() > 1) {
            filePath.append(FILENAME).append(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード()).append(FILENAMEGO);
        } else {
            filePath.append(FILENAME).append(shichosonCode).append(FILENAMEGO);
        }
        eucFilePath = Path.combinePath(spoolWorkPath, filePath.toRString());
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    private void setNyuBodyItem(TennyuHosyutaiSyosyaEntity entity,
            TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity csvEntity, TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem) {
        csvEntity.setDatanaiyo(転入);
        bodyItem.setデータ内容(転入);
        csvEntity.setShikibetsuCode(entity.get識別コード());
        bodyItem.set識別コード(entity.get識別コード());
        csvEntity.setSetaiCode(entity.get世帯コード());
        bodyItem.set世帯コード(entity.get世帯コード());
        RString 市町村コード = entity.get市町村コード();
        csvEntity.setShichosonCode(市町村コード);
        bodyItem.set市町村コード(市町村コード);
        RString 市町村名 = RString.isNullOrEmpty(市町村コード) ? RString.EMPTY : ZenkokuJushoFinderFactory.createInstance().get全国住所By地方公共団体コード(
                new LasdecCode(市町村コード)) == null ? RString.EMPTY : ZenkokuJushoFinderFactory.createInstance().get全国住所By地方公共団体コード(
                        new LasdecCode(市町村コード)).get市町村名();
        csvEntity.setShichosonName(市町村名);
        bodyItem.set市町村名(市町村名);
        csvEntity.setKanaShimei(entity.get宛名カナ氏名());
        bodyItem.setカナ氏名(entity.get宛名カナ氏名());
        csvEntity.setShimei(entity.get宛名氏名());
        bodyItem.set氏名(entity.get宛名氏名());
        RString 住民状態コード = entity.get住民状態コード();
        RString 住民状態 = RString.isNullOrEmpty(住民状態コード) ? RString.EMPTY : JuminJotai.toValue(住民状態コード).住民状態略称();
        csvEntity.setJuminJotai(住民状態);
        bodyItem.set住民状態(住民状態);
        RString 年月日 = entity.get生年月日();
        RString 生年月日 = RString.isNullOrEmpty(年月日) ? RString.EMPTY : format(年月日);
        csvEntity.setSeinengappiYMD(生年月日);
        bodyItem.set生年月日(生年月日);
        RString 性別コード = entity.get性別コード();
        RString 性別 = RString.isNullOrEmpty(性別コード) ? RString.EMPTY : Gender.toValue(性別コード).getCommonName();
        csvEntity.setSeibetsu(性別);
        bodyItem.set性別(性別);
        RString 異動事由コード = entity.get異動事由コード();
        csvEntity.setIdoJiyuCode(異動事由コード);
        bodyItem.set異動事由コード(異動事由コード);
        // TODO QA1013  Redmine：   (異動事由の取得用方法)
        RString 異動事由 = RString.isNullOrEmpty(異動事由コード) ? RString.EMPTY : JukiIdoJiyu.toValue(異動事由コード).get異動事由略称();
        csvEntity.setIdoJiyu(異動事由);
        bodyItem.set異動事由(異動事由);
        RString 登録異動年月日 = entity.get登録異動年月日();
        RString 登録異動日 = RString.isNullOrEmpty(登録異動年月日) ? RString.EMPTY : format(登録異動年月日);
        csvEntity.setTorokuIdoYMD(登録異動日);
        bodyItem.set登録異動日(登録異動日);
        RString 登録届出年月日 = entity.get登録異動届出年月日();
        RString 登録届出日 = RString.isNullOrEmpty(登録届出年月日) ? RString.EMPTY : format(登録届出年月日);
        csvEntity.setTorokuTodokedeYMD(登録届出日);
        bodyItem.set登録届出日(登録届出日);
        RString 住所地特例 = entity.get住所地特例フラグ();
        if (フラグ1.equals(住所地特例)) {
            住所地特例 = 住所地特例フラグ1;
        } else {
            住所地特例 = RString.EMPTY;
        }
        csvEntity.setJushochiTokurei(住所地特例);
        bodyItem.set住所地特例(住所地特例);
        RString 消除異動年月日 = entity.get消除異動年月日();
        RString 消除異動日 = RString.isNullOrEmpty(消除異動年月日) ? RString.EMPTY : format(消除異動年月日);
        csvEntity.setShojoIdoYMD(消除異動日);
        bodyItem.set消除異動日(消除異動日);
        RString 消除届出年月日 = entity.get消除異動届出年月日();
        RString 消除届出日 = RString.isNullOrEmpty(消除届出年月日) ? RString.EMPTY : format(消除届出年月日);
        csvEntity.setShojoTodokedeYMD(消除届出日);
        bodyItem.set消除届出日(消除届出日);
        RString 転出予定異動年月日 = entity.get転出予定異動年月日();
        RString 転出予定異動日 = RString.isNullOrEmpty(転出予定異動年月日) ? RString.EMPTY : format(転出予定異動年月日);
        csvEntity.setTenshutsuYoteiIdoYMD(転出予定異動日);
        bodyItem.set転出予定異動日(転出予定異動日);
        RStringBuilder 住所 = new RStringBuilder();
        住所.append(entity.get住所()).append(entity.get番地()).append(entity.get方書());
        csvEntity.setJusho(住所.toRString());
        bodyItem.set住所(住所.toRString());
        RStringBuilder 転出予定住所前住所 = new RStringBuilder();
        転出予定住所前住所.append(entity.get前住所住所()).append(entity.get前住所番地()).append(entity.get前住所方書());
        csvEntity.setTenshutsuYoteiJusho(転出予定住所前住所.toRString());
        bodyItem.set転出予定住所前住所(転出予定住所前住所.toRString());
        RString 作成事由コード = entity.get作成事由コード();
        csvEntity.setSakuseiJiyuCode(作成事由コード);
        bodyItem.set作成事由コードMiddle(作成事由コード);
        RString 作成事由 = RString.isNullOrEmpty(作成事由コード) ? RString.EMPTY : TennyuSakuseiJiyu.toValue(作成事由コード).get名称();
        csvEntity.setSakuseiJiyu(作成事由);
        bodyItem.set作成事由Middle(作成事由);
    }

    private void setShuBodyItem(TensyuHosyutaiSyosyaEntity entity,
            TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity csvEntity, TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem) {
        csvEntity.setDatanaiyo(転出);
        bodyItem.setデータ内容(転出);
        csvEntity.setShikibetsuCode(entity.get識別コード());
        bodyItem.set識別コード(entity.get識別コード());
        csvEntity.setSetaiCode(entity.get世帯コード());
        bodyItem.set世帯コード(entity.get世帯コード());
        RString 市町村コード = entity.get市町村コード();
        csvEntity.setShichosonCode(市町村コード);
        bodyItem.set市町村コード(市町村コード);
        RString 市町村名 = RString.isNullOrEmpty(市町村コード) ? RString.EMPTY : ZenkokuJushoFinderFactory.createInstance().get全国住所By地方公共団体コード(
                new LasdecCode(市町村コード)) == null ? RString.EMPTY : ZenkokuJushoFinderFactory.createInstance().get全国住所By地方公共団体コード(
                        new LasdecCode(市町村コード)).get市町村名();
        csvEntity.setShichosonName(市町村名);
        bodyItem.set市町村名(市町村名);
        csvEntity.setKanaShimei(entity.get宛名カナ氏名());
        bodyItem.setカナ氏名(entity.get宛名カナ氏名());
        csvEntity.setShimei(entity.get宛名氏名());
        bodyItem.set氏名(entity.get宛名氏名());
        RString 住民状態コード = entity.get住民状態コード();
        RString 住民状態 = RString.isNullOrEmpty(住民状態コード) ? RString.EMPTY : JuminJotai.toValue(住民状態コード).住民状態略称();
        csvEntity.setJuminJotai(住民状態);
        bodyItem.set住民状態(住民状態);
        RString 年月日 = entity.get生年月日();
        RString 生年月日 = RString.isNullOrEmpty(年月日) ? RString.EMPTY : format(年月日);
        csvEntity.setSeinengappiYMD(生年月日);
        bodyItem.set生年月日(生年月日);
        RString 性別コード = entity.get性別コード();
        RString 性別 = RString.isNullOrEmpty(性別コード) ? RString.EMPTY : Gender.toValue(性別コード).getCommonName();
        csvEntity.setSeibetsu(性別);
        bodyItem.set性別(性別);
        RString 異動事由コード = entity.get異動事由コード();
        csvEntity.setIdoJiyuCode(異動事由コード);
        bodyItem.set異動事由コード(異動事由コード);
        // TODO QA1013  Redmine：   (異動事由の取得用方法)
        RString 異動事由 = RString.isNullOrEmpty(異動事由コード) ? RString.EMPTY : JukiIdoJiyu.toValue(異動事由コード).get異動事由略称();
        csvEntity.setIdoJiyu(異動事由);
        bodyItem.set異動事由(異動事由);
        RString 登録異動年月日 = entity.get登録異動年月日();
        RString 登録異動日 = RString.isNullOrEmpty(登録異動年月日) ? RString.EMPTY : format(登録異動年月日);
        csvEntity.setTorokuIdoYMD(登録異動日);
        bodyItem.set登録異動日(登録異動日);
        RString 登録届出年月日 = entity.get登録異動届出年月日();
        RString 登録届出日 = RString.isNullOrEmpty(登録届出年月日) ? RString.EMPTY : format(登録届出年月日);
        csvEntity.setTorokuTodokedeYMD(登録届出日);
        bodyItem.set登録届出日(登録届出日);
        RString 住所地特例 = entity.get住所地特例フラグ();
        if (フラグ1.equals(住所地特例)) {
            住所地特例 = 住所地特例フラグ1;
        } else {
            住所地特例 = RString.EMPTY;
        }
        csvEntity.setJushochiTokurei(住所地特例);
        bodyItem.set住所地特例(住所地特例);
        RString 消除異動年月日 = entity.get消除異動年月日();
        RString 消除異動日 = RString.isNullOrEmpty(消除異動年月日) ? RString.EMPTY : format(消除異動年月日);
        csvEntity.setShojoIdoYMD(消除異動日);
        bodyItem.set消除異動日(消除異動日);
        RString 消除届出年月日 = entity.get消除異動届出年月日();
        RString 消除届出日 = RString.isNullOrEmpty(消除届出年月日) ? RString.EMPTY : format(消除届出年月日);
        csvEntity.setShojoTodokedeYMD(消除届出日);
        bodyItem.set消除届出日(消除届出日);
        RString 転出予定異動年月日 = entity.get転出予定異動年月日();
        RString 転出予定異動日 = RString.isNullOrEmpty(転出予定異動年月日) ? RString.EMPTY : format(転出予定異動年月日);
        csvEntity.setTenshutsuYoteiIdoYMD(転出予定異動日);
        bodyItem.set転出予定異動日(転出予定異動日);
        RStringBuilder 住所 = new RStringBuilder();
        住所.append(entity.get住所()).append(entity.get番地()).append(entity.get方書());
        csvEntity.setJusho(住所.toRString());
        bodyItem.set住所(住所.toRString());
        RStringBuilder 転出予定住所前住所 = new RStringBuilder();
        転出予定住所前住所.append(entity.get転出予定住所()).append(entity.get転出予定番地()).append(entity.get転出予定方書());
        csvEntity.setTenshutsuYoteiJusho(転出予定住所前住所.toRString());
        bodyItem.set転出予定住所前住所(転出予定住所前住所.toRString());
        RString 作成事由コード = entity.get作成事由コード();
        csvEntity.setSakuseiJiyuCode(作成事由コード);
        bodyItem.set作成事由コードMiddle(作成事由コード);
        RString 作成事由 = RString.isNullOrEmpty(作成事由コード) ? RString.EMPTY : TenshutsuSakuseiJiyu.toValue(作成事由コード).get名称();
        csvEntity.setSakuseiJiyu(作成事由);
        bodyItem.set作成事由Middle(作成事由);
    }

    private void editHeader() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        // TODO 出力順と改ページ お待ち
//        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBA介護資格,
//                ReportIdDBA.DBA200014.getReportId(),
//                UrControlDataFactory.createInstance().getLoginInfo().getUserId(), processParamter.getCyohyosyutsuryokujyun());
//        List<ISetSortItem> isortItem = outputOrder.get設定項目リスト();
//        Collections.sort(isortItem, new Comparator<ISetSortItem>() {
//            @Override
//            public int compare(ISetSortItem entity1, ISetSortItem entity2) {
//                return String.valueOf(entity1.get出力順位()).compareTo(String.valueOf(entity2.get出力順位()));
//            }
//        });
//        ISetSortItem 出力順位1 = isortItem.get(INDEX_0);
//        ISetSortItem 出力順位2 = isortItem.get(INDEX_1);
//        ISetSortItem 出力順位3 = isortItem.get(INDEX_2);
//        ISetSortItem 出力順位4 = isortItem.get(INDEX_3);
//        ISetSortItem 出力順位5 = isortItem.get(INDEX_4);
//        RString 改ページ1 = get改ページ項目(出力順位1);
//        RString 改ページ2 = get改ページ項目(出力順位2);
//        RString 改ページ3 = get改ページ項目(出力順位3);
//        RString 改ページ4 = get改ページ項目(出力順位4);
//        RString 改ページ5 = get改ページ項目(出力順位5);
        RString 改ページ1 = new RString("listUpper_1");
        RString 改ページ2 = new RString("listUpper_2");
        RString 改ページ3 = new RString("listUpper_3");
        RString 改ページ4 = new RString("listUpper_4");
        RString 改ページ5 = new RString("listUpper_5");
        RString 出力順位1 = RString.EMPTY;
        RString 出力順位2 = RString.EMPTY;
        RString 出力順位3 = RString.EMPTY;
        RString 出力順位4 = RString.EMPTY;
        RString 出力順位5 = RString.EMPTY;
        page_break_keys = Collections.unmodifiableList(Arrays.asList(改ページ1, 改ページ2, 改ページ3, 改ページ4, 改ページ5));
        headItem = new TennyuTenshutsuMiTorokuIchiranhyoHeadItem(association.getLasdecCode_().getColumnValue(), association.get市町村名(),
                出力順位1, 出力順位2, 出力順位3,
                出力順位4, 出力順位5, 改ページ1, 改ページ2, 改ページ3,
                改ページ4, 改ページ5);
    }

//    private RString get改ページ項目(ISetSortItem 出力順位) {
//        if (出力順位.is改頁項目()) {
//            return 出力順位.get項目名();
//        } else {
//            return RString.EMPTY;
//        }
//    }
    private RString format(RString 年月日) {
        return new FlexibleDate(年月日).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
