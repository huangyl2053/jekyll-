/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.KokuhorenFuicchi;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.SanteiKijun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShiharaiSaki;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShinsaHoho;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.Taishosha;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyouRisutoSyuturyokuEucCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyourisutosyuturyoku.HanyouRisutoSyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.service.report.hanyolistkogakukaigo.HanyoListKogakuKaigoEucCsvEntityEditor;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト出力(高額介護サービス費状況)CSV出力の処理クラスです。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public class HanyoListKogakuKaigoServiceHiJokyoProcess extends BatchProcessBase<HanyouRisutoSyuturyokuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyourisutosyuturyoku.IHanyouRisutoSyuturyokuMapper.selectAllデータ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC701003"));
    private static final ReportId EUC_ID = new ReportId("DBC701003");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　高額介護サービス費状況CSV");
    private static final RString CSV出力有無 = new RString("");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CODE_1 = new RString("1");
    private static final RString CODE_2 = new RString("2");
    private static final RString CODE_3 = new RString("3");
    private static final RString 構成市町村 = new RString("【構成市町村】");
    private static final RString サービス提供年月 = new RString("【サービス提供年月】");
    private static final RString 処理状況 = new RString("【処理状況】");
    private static final RString 審査方法 = new RString("【審査方法】");
    private static final RString 算定基準 = new RString("【算定基準】");
    private static final RString 国保連不一致 = new RString("【国保連不一致】");
    private static final RString 対象者 = new RString("【対象者】");
    private static final RString 申請区分 = new RString("【申請区分】");
    private static final RString 支払先 = new RString("【支払先】");
    private static final RString 金融機関 = new RString("【金融機関】");
    private static final RString 申請日 = new RString("【申請日】");
    private static final RString 保険者決定日 = new RString("【保険者決定日】");
    private static final RString 国保連決定年月 = new RString("【国保連決定年月】");
    private static final RString 対象者受取年月 = new RString("【対象者受取年月】");
    private static final RString 国保連送付年月 = new RString("【国保連送付年月】");
    private static final RString 決定情報受取年月 = new RString("【決定情報受取年月】");
    private static final RString 括弧_L = new RString("(");
    private static final RString 括弧_R = new RString(")");
    private static final RString 波線 = new RString("　～　");
    private static final RString 振込 = new RString("振込");
    private static final RString 英数字ファイル名 = new RString("HanyoList_KogakuKaigoServiceHiJokyo.csv");
    private HanyoListKogakuKaigoProcessParameter parameter;
    private HanyoListKogakuKaigoEucCsvEntityEditor dataCreate;
    private RString eucFilePath;
    private List<PersonalData> personalDataList;
    private FileSpoolManager manager;
    private Association 地方公共団体;
    private RString 文字コード;
    private Encode csv文字コード;
    private Decimal 連番;

    @BatchWriter
    private EucCsvWriter<HanyouRisutoSyuturyokuEucCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        連番 = Decimal.ONE;
        dataCreate = new HanyoListKogakuKaigoEucCsvEntityEditor();
        personalDataList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected IBatchReader createReader() {
        //DbBusinessConifg.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        parameter.set宛名検索条件(searchKey);
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        RDate システム日時 = RDate.getNowDate();
        文字コード = DbBusinessConifg.get(ConfigNameDBU.EUC共通_文字コード, システム日時, SubGyomuCode.DBU介護統計報告);
        if (CODE_1.equals(文字コード)) {
            csv文字コード = Encode.UTF_8withBOM;
        } else if (CODE_2.equals(文字コード)) {
            csv文字コード = Encode.SJIS;
        } else if (CODE_3.equals(文字コード)) {
            csv文字コード = Encode.JIS;
        } else {
            csv文字コード = Encode.UTF_8withBOM;
        }
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(csv文字コード).
                setNewLine(NewLine.CRLF).
                hasHeader(parameter.isTomokumeFuka())
                .build();
    }

    @Override
    protected void process(HanyouRisutoSyuturyokuEntity entity) {
        eucCsvWriter.writeLine(dataCreate.edit(entity, parameter, 連番));
        連番 = 連番.add(Decimal.ONE);
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        バッチ出力条件リストの出力();
    }

    private PersonalData toPersonalData(HanyouRisutoSyuturyokuEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者番号().value());
        return PersonalData.of(entity.get宛名().getShikibetsuCode(), expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));

        List<RString> 出力条件 = get出力条件();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号.concat(String.valueOf(JobContextHolder.getJobId())),
                日本語ファイル名,
                出力件数,
                CSV出力有無,
                英数字ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private List<RString> get出力条件() {

        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(構成市町村);
        // TODO : 構成市町村名
        builder.append(parameter.getKouseiShichosonCode() == null
                || parameter.getKouseiShichosonCode().isEmpty()
                ? RString.EMPTY : 括弧_L.concat(new RString(parameter.getKouseiShichosonCode().toString())
                        .concat(括弧_R).concat(括弧_R)));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(サービス提供年月);
        if (parameter.getServiceYmFrom() != null && parameter.getServiceYmTo() != null) {
            builder.append(get提供年月(parameter.getServiceYmFrom()).concat(波線)
                    .concat(get提供年月(parameter.getServiceYmTo())));
        } else if (parameter.getServiceYmFrom() != null && parameter.getServiceYmTo() == null) {
            builder.append(get提供年月(parameter.getServiceYmFrom()).concat(波線));

        } else if (parameter.getServiceYmFrom() == null && parameter.getServiceYmTo() != null) {
            builder.append(波線.concat(get提供年月(parameter.getServiceYmTo())));

        }
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(処理状況);
        builder.append(null == parameter.getShoriJokyo() || parameter.getShoriJokyo().isEmpty()
                ? RString.EMPTY : ShoriJokyo.toValue(parameter.getShoriJokyo()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(審査方法);
        builder.append(null == parameter.getShinsaHoho() || parameter.getShinsaHoho().isEmpty()
                ? RString.EMPTY : ShinsaHoho.toValue(parameter.getShinsaHoho()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(算定基準);
        builder.append(null == parameter.getSanteiKijun()
                || parameter.getSanteiKijun().isEmpty()
                ? RString.EMPTY : SanteiKijun.toValue(parameter.getSanteiKijun()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(国保連不一致);
        builder.append(null == parameter.getKokuhorenFuicchi()
                || parameter.getKokuhorenFuicchi().isEmpty()
                ? RString.EMPTY : KokuhorenFuicchi.toValue(parameter.getKokuhorenFuicchi()));
        出力条件.add(builder.toRString());

        get時間出力条件(出力条件);
        get対象者TO金融機関の出力条件(出力条件);

        return 出力条件;
    }

    private void get対象者TO金融機関の出力条件(List<RString> 出力条件) {

        RStringBuilder builder = new RStringBuilder();
        builder.append(対象者);
        builder.append(null == parameter.getTaishosha()
                || parameter.getTaishosha().isEmpty()
                ? RString.EMPTY : Taishosha.toValue(parameter.getTaishosha()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(申請区分);
        builder.append(null == parameter.getShinseiKubun()
                || parameter.getShinseiKubun().isEmpty()
                ? RString.EMPTY : ShinseiKubun.toValue(parameter.getShinseiKubun()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(支払先);
        builder.append(null == parameter.getShiharaiSaki()
                || parameter.getShiharaiSaki().isEmpty()
                ? RString.EMPTY : ShiharaiSaki.toValue(parameter.getShiharaiSaki()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(金融機関);
        // TODO : 金融機関名称
        builder.append(null == parameter.getKiyuKikanCode()
                || parameter.getKiyuKikanCode().isEmpty()
                ? RString.EMPTY : 括弧_L.concat(new RString(parameter.getKiyuKikanCode().toString())
                        .concat(括弧_R).concat(括弧_R)));
        出力条件.add(builder.toRString());
    }

    private void get時間出力条件(List<RString> 出力条件) {

        RStringBuilder builder = new RStringBuilder();
        builder.append(申請日);
        if (parameter.getShisehiFrom() != null && parameter.getShisehiTo() != null) {
            builder.append(get年月日(parameter.getShisehiFrom()).concat(波線)
                    .concat(get年月日(parameter.getShisehiTo())));
        } else if (parameter.getShisehiFrom() != null && parameter.getShisehiTo() == null) {
            builder.append(get年月日(parameter.getShisehiFrom()).concat(波線));

        } else if (parameter.getShisehiFrom() == null && parameter.getShisehiTo() != null) {
            builder.append(波線.concat(get年月日(parameter.getShisehiTo())));

        }
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(保険者決定日);
        if (parameter.getHokemonoKeteihiFrom() != null && parameter.getHokemonoKeteihiTo() != null) {
            builder.append(get年月日(parameter.getHokemonoKeteihiFrom()).concat(波線)
                    .concat(get年月日(parameter.getHokemonoKeteihiTo())));
        } else if (parameter.getHokemonoKeteihiFrom() != null
                && parameter.getHokemonoKeteihiTo() == null) {
            builder.append(get年月日(parameter.getHokemonoKeteihiFrom()).concat(波線));

        } else if (parameter.getHokemonoKeteihiFrom() == null
                && parameter.getHokemonoKeteihiTo() != null) {
            builder.append(波線.concat(get年月日(parameter.getHokemonoKeteihiTo())));

        }
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(国保連決定年月);
        if (parameter.getKokuhoreKeteiymFrom() != null && parameter.getKokuhoreKeteiymTo() != null) {
            builder.append(get提供年月(parameter.getKokuhoreKeteiymFrom()).concat(波線)
                    .concat(get提供年月(parameter.getKokuhoreKeteiymTo())));
        } else if (parameter.getKokuhoreKeteiymFrom() != null
                && parameter.getKokuhoreKeteiymTo() == null) {
            builder.append(get提供年月(parameter.getKokuhoreKeteiymFrom()).concat(波線));

        } else if (parameter.getKokuhoreKeteiymFrom() == null
                && parameter.getKokuhoreKeteiymTo() != null) {
            builder.append(波線.concat(get提供年月(parameter.getKokuhoreKeteiymTo())));

        }
        出力条件.add(builder.toRString());
        get年月出力条件(出力条件);
    }

    private void get年月出力条件(List<RString> 出力条件) {

        RStringBuilder builder = new RStringBuilder();
        builder.append(対象者受取年月);
        if (parameter.getTaishoshaUketoriymFrom() != null && parameter.getTaishoshaUketoriymTo() != null) {
            builder.append(get提供年月(parameter.getTaishoshaUketoriymFrom()).concat(波線)
                    .concat(get提供年月(parameter.getTaishoshaUketoriymTo())));
        } else if (parameter.getTaishoshaUketoriymFrom() != null && parameter.getTaishoshaUketoriymTo() == null) {
            builder.append(get提供年月(parameter.getTaishoshaUketoriymFrom()).concat(波線));

        } else if (parameter.getTaishoshaUketoriymFrom() == null && parameter.getTaishoshaUketoriymTo() != null) {
            builder.append(波線.concat(get提供年月(parameter.getTaishoshaUketoriymTo())));

        }
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(国保連送付年月);
        if (parameter.getKokuhoreSofuYMFrom() != null && parameter.getKokuhoreSofuYMTo() != null) {
            builder.append(get提供年月(parameter.getKokuhoreSofuYMFrom()).concat(波線)
                    .concat(get提供年月(parameter.getKokuhoreSofuYMTo())));
        } else if (parameter.getKokuhoreSofuYMFrom() != null && parameter.getKokuhoreSofuYMTo() == null) {
            builder.append(get提供年月(parameter.getKokuhoreSofuYMFrom()).concat(波線));

        } else if (parameter.getKokuhoreSofuYMFrom() == null && parameter.getKokuhoreSofuYMTo() != null) {
            builder.append(波線.concat(get提供年月(parameter.getKokuhoreSofuYMTo())));
        }
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(決定情報受取年月);
        if (parameter.getKeteijohoUketoriymFrom() != null && parameter.getKeteijohoUketoriymTo() != null) {
            builder.append(get提供年月(parameter.getKeteijohoUketoriymFrom()).concat(波線)
                    .concat(get提供年月(parameter.getKeteijohoUketoriymTo())));
        } else if (parameter.getKeteijohoUketoriymFrom() != null && parameter.getKeteijohoUketoriymTo() == null) {
            builder.append(get提供年月(parameter.getKeteijohoUketoriymFrom()).concat(波線));

        } else if (parameter.getKeteijohoUketoriymFrom() == null && parameter.getKeteijohoUketoriymTo() != null) {
            builder.append(波線.concat(get提供年月(parameter.getKeteijohoUketoriymTo())));
        }
        出力条件.add(builder.toRString());
    }

    private RString get提供年月(FlexibleYearMonth サービス提供年月) {

        return サービス提供年月.wareki().firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private RString get年月日(FlexibleDate 年月日) {

        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

}
