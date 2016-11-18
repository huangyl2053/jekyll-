/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran.KogakuJigyoShinseishoHakkoIchiranParamter;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran.KogakuJigyoShinseishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.JigyoShinseishoHakkoIchiranhyoCsvEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.KogakuJigyoShinseishoHakkoIchiranOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.KogakuJigyoShinseishoHakkoIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 申請書発行一覧表の発行処理です。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class JigyoShinseishoHakoIchiranhyoOutputProcess extends BatchProcessBase<ShinseiJohoChohyoTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get申請書発行一覧表");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString CSV_FILE_NAME = new RString("KogakuJigyoServiceHiShinseishoHakkoIchiran");
    private static final RString CSV = new RString(".csv");
    private static final RString UNDER_LINE = new RString("_");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 一覧EUCエンティティID = new RString("DBC200091");
    private static final RString 旧措置 = new RString("旧措置者");
    private static final RString 対象 = new RString("対象");
    private static final RString 対象外 = new RString("対象外");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    private RString 保険者情報_保険者名称;
    private RString csvFileName;
    private List<RString> breakItemIds;
    private FileSpoolManager manager;
    private IOutputOrder 出力順;
    private RDateTime システム日付;

    private int count;
    @BatchWriter
    private BatchReportWriter<KogakuJigyoShinseishoHakkoIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuJigyoShinseishoHakkoIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<JigyoShinseishoHakkoIchiranhyoCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        count = 1;
        システム日付 = RDateTime.now();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();

        csvFileName = CSV_FILE_NAME.concat(UNDER_LINE).
                concat(導入団体クラス.get地方公共団体コード().value()).concat(UNDER_LINE).
                concat(parameter.getSakuseibi().toString()).concat(CSV);
        breakItemIds = new ArrayList<>();
        出力順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200091.getReportId(), parameter.getShutsuryokujunId());

        保険者情報_保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (出力順 != null) {
            parameter.setOrderBy(MyBatisOrderByClauseCreator.create(
                    KogakuJigyoShinseishoHakkoIchiranOrder.class, 出力順).replace(ORDER_BY, RString.EMPTY));
            for (ISetSortItem item : 出力順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    breakItemIds.add(item.get項目ID());
                }
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200091.getReportId().value())
                .addBreak(new KogakuJigyoShinseishoHakkoIchiranPageBreak(breakItemIds)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 一覧EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        csvWriter = new CsvWriter.InstanceBuilder(Path.combinePath(manager.getEucOutputDirectry(), csvFileName)).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(ShinseiJohoChohyoTempRelateEntity entity) {
        KogakuJigyoShinseishoHakkoIchiranParamter param = new KogakuJigyoShinseishoHakkoIchiranParamter();
        entity.get申請情報().setEditJusho(get住所Edit(entity));
        param.set帳票出力対象データ(entity.get申請情報());
        param.set出力順(出力順);
        param.set連番(new RString(count));
        param.setシステム日付(システム日付);
        param.set市町村名(保険者情報_保険者名称);
        KogakuJigyoShinseishoHakkoIchiranReport report = new KogakuJigyoShinseishoHakkoIchiranReport(param);
        report.writeBy(reportSourceWriter);

        csvWriter.writeLine(new JigyoShinseishoHakkoIchiranhyoCsvEntity(
                getパターン32(RDate.getNowDate()),
                new RString(count),
                entity.get申請情報().getHihokenshaNoChohyo().value(),
                getパターン82(entity.get申請情報().getServiceTeikyoYMChohyo()),
                get名称(entity.get申請情報().getMeishoChohyo()),
                get郵便番号(entity.get申請情報().getYubinNoChohyo()),
                get住所(entity.get申請情報().getJushoChohyo()),
                get行政区コード(entity.get申請情報().getGyoseikuCodeChohyo()),
                entity.get申請情報().getGyoseikuNameChohyo(),
                entity.get申請情報().isKyuSochishaFlagChohyo() ? 旧措置 : RString.EMPTY,
                get要介護状態区分コード(entity.get申請情報().getYokaigoJotaiKubunCodeChohyo()),
                get要介護状態区分(get要介護状態区分コード(entity.get申請情報().getYokaigoJotaiKubunCodeChohyo())),
                getパターン32(entity.get申請情報().getNinteiYukoKikanKaishiYMDChohyo()),
                getパターン32(entity.get申請情報().getNinteiYukoKikanShuryoYMDChohyo()),
                get金額(entity.get申請情報().getHonninShiharaiGakuChohyo()),
                get金額(entity.get申請情報().getShikyuKingakuChohyo()),
                entity.get申請情報().isHojinKeigenTaishoFlagChohyo() ? 対象 : 対象外,
                entity.get申請情報().isJidoShokanTaishoFlagChohyo() ? 対象 : 対象外,
                entity.get申請情報().getShikakuSoshitsuJiyuCodeChohyo(),
                get資格喪失事由(entity.get申請情報().getShikakuSoshitsuJiyuCodeChohyo()))
        );

        count = count + 1;
    }

    @Override
    protected void afterExecute() {
        if (count == 1) {
            KogakuJigyoShinseishoHakkoIchiranParamter param = new KogakuJigyoShinseishoHakkoIchiranParamter();
            ShinseiJohoChohyoTempEntity 申請情報 = new ShinseiJohoChohyoTempEntity();
            申請情報.setJushoChohyo(new AtenaJusho(new RString("該当者なし")));
            申請情報.setKyuSochishaFlagChohyo(false);
            申請情報.setHojinKeigenTaishoFlagChohyo(false);
            申請情報.setJidoShokanTaishoFlagChohyo(false);
            param.set帳票出力対象データ(申請情報);
            param.set出力順(出力順);
            param.set連番(new RString(count));
            param.setシステム日付(システム日付);
            param.set市町村名(保険者情報_保険者名称);
            KogakuJigyoShinseishoHakkoIchiranReport report = new KogakuJigyoShinseishoHakkoIchiranReport(param);
            report.writeBy(reportSourceWriter);
        }
        csvWriter.close();
        manager.spool(SubGyomuCode.DBC介護給付, csvFileName);
    }

    private RString get名称(AtenaMeisho meisho) {
        if (meisho == null) {
            return RString.EMPTY;
        }
        return meisho.value();
    }

    private RString get郵便番号(YubinNo yubinNo) {
        if (yubinNo == null) {
            return RString.EMPTY;
        }
        return yubinNo.getEditedYubinNo();
    }

    private RString get住所(AtenaJusho jusho) {
        if (jusho == null) {
            return RString.EMPTY;
        }
        return jusho.getColumnValue();
    }

    private RString get行政区コード(GyoseikuCode gyoseikuCode) {
        if (gyoseikuCode == null) {
            return RString.EMPTY;
        }
        return gyoseikuCode.getColumnValue();
    }

    private RString get要介護状態区分コード(Code yokaigoJotaiKubunCode) {
        if (yokaigoJotaiKubunCode == null) {
            return RString.EMPTY;
        }
        return yokaigoJotaiKubunCode.getKey();
    }

    private RString get要介護状態区分(RString yokaigoJotaiKubunCode) {
        if (RString.isNullOrEmpty(yokaigoJotaiKubunCode)) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubun.toValue(yokaigoJotaiKubunCode).get名称();
    }

    private RString get金額(Decimal decimal) {
        return decimal == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(decimal, 0);
    }

    private RString getパターン32(RDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン32(FlexibleDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン82(FlexibleYearMonth date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get資格喪失事由(RString code) {
        return RString.isNullOrEmpty(code) ? RString.EMPTY : ShikakuSoshitsuJiyu.toValue(code).get名称();
    }
    
    private RString get住所Edit(ShinseiJohoChohyoTempRelateEntity entity) {
        RString 住所 = entity.get申請情報().getJushoChohyo() == null ? RString.EMPTY : entity.get申請情報().getJushoChohyo().getColumnValue();
        RString 番地 = entity.get申請情報().getBanchi() == null ? RString.EMPTY : entity.get申請情報().getBanchi().getColumnValue();
        RString 方書 = entity.get申請情報().getKatagaki() == null ? RString.EMPTY : entity.get申請情報().getKatagaki().getColumnValue();
        return 住所.concat(番地).concat(RString.EMPTY).concat(方書);
    }
}
