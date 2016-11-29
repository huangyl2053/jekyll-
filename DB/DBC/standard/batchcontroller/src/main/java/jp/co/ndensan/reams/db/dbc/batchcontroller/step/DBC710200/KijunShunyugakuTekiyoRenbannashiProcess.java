/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyo.KijunShunyugakuTekiyo;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunshunyugakutekiyo.KijunShunyugakuTekiyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistparam.HanyoListParamRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistparam.HanyoListParamRenbannashiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 汎用リスト_基準収入額適用情報_連番なしのProcessクラスです。
 *
 * @reamsid_L DBC-5050-030 duanzhanli
 */
public class KijunShunyugakuTekiyoRenbannashiProcess extends BatchProcessBase<HanyoListParamRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc."
            + "persistence.db.mapper.relate.hanyolistparam.IHanyoListParamMapper.get基準収入額適用情報");
    private KijunShunyugakuTekiyoProcessParameter processParameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701020");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private KijunShunyugakuTekiyo kijunShunyugakuTekiyo;
    private Association association;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private ReportId 帳票ID;
    private boolean flag;
    @BatchWriter
    private CsvWriter<HanyoListParamRenbannashiEUCEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        flag = false;
        association = AssociationFinderFactory.createInstance().getAssociation();
        kijunShunyugakuTekiyo = new KijunShunyugakuTekiyo(processParameter);
        get市町村名();
        帳票ID = ReportIdDBC.DBC701020.getReportId();
        帳票制御共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票ID);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, kijunShunyugakuTekiyo.createMybatisParameter(get出力順()));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_KijunShunyugakuTekiyo.csv"));
        eucCsvWriter = BatchWriters.csvWriter(HanyoListParamRenbannashiEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(processParameter.is項目名付加())
                .build();
    }

    @Override
    protected void process(HanyoListParamRelateEntity entity) {
        flag = true;
        IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
        IKojin iKojin = iShikibetsuTaisho.to個人();
        Association 導入団体情報 = AssociationFinderFactory.createInstance().getAssociation(new LasdecCode(entity.get市町村コード()));
        RString 住所 = JushoHenshu.editJusho(帳票制御共通情報, iKojin, 導入団体情報);
        eucCsvWriter.writeLine(kijunShunyugakuTekiyo.setRenbannashiEUCEntity(entity, 市町村名MasterMap, association, 住所));
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            eucCsvWriter.writeLine(kijunShunyugakuTekiyo.setRenbannashiEUCEntity());
            eucCsvWriter.close();
            manager.spool(eucFilePath);
        } else {
            eucCsvWriter.close();
            manager.spool(eucFilePath, kijunShunyugakuTekiyo.getアクセスログ());
        }
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("汎用リスト　基準収入額適用情報CSV"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("HanyoList_KijunShunyugakuTekiyo.csv"),
                EUC_ENTITY_ID.toRString(),
                get出力件数(new Decimal(eucCsvWriter.getCount())),
                kijunShunyugakuTekiyo.set出力条件());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString get出力件数(Decimal 出力件数) {
        RString 件数;
        if (flag) {
            RStringBuilder builder = new RStringBuilder();
            builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
            件数 = builder.toRString();
        } else {
            件数 = new RString("0");
        }
        return 件数;
    }

    private void get市町村名() {
        市町村名MasterMap = new HashMap<>();
        List<KoseiShichosonMaster> 市町村名Master = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (KoseiShichosonMaster koseiShichosonMaster : 市町村名Master) {
            市町村名MasterMap.put(koseiShichosonMaster.get市町村コード().value(), koseiShichosonMaster);
        }
    }

    private RString get出力順() {
        ShutsuryokujunRelateEntity shutsuryokujunrelateentity = ReportUtil.get出力順情報(KijunShunyugakuTekiyo.ShutsuryokujunEnum.class,
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701020.getReportId(),
                processParameter.get出力順ID());
        RString 出力順 = RString.EMPTY;
        if (shutsuryokujunrelateentity != null) {
            出力順 = shutsuryokujunrelateentity.get出力順OrderBy();
        }
        return 出力順;
    }
}
