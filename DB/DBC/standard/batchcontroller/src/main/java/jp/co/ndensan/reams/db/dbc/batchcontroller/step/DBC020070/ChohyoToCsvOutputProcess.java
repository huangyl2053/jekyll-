/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranOrder;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.jigyobunshikyugakurenrakuhyo.JigyobunShikyugakuRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020070.JigyobunShikyugakuKeisanProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc020070.GassanJigyobunShikyugakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 事業分支給額計算結果の帳票・CSVを出力する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class ChohyoToCsvOutputProcess extends BatchKeyBreakBase<ShikyugakuUpdateTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get出力情報");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString CSV_FILE_NAME = new RString("DBC200204_GassanJigyobunShikyugakuKeisanKekkaIchiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 一覧EUCエンティティID = new RString("DBC200204");
    private static final RString 区分１ = new RString("1");
    private static final RString 区分２ = new RString("2");
    private static final RString 区分３ = new RString("3");
    private static final RString 区分４ = new RString("4");
    private static final RString 該当データ無し = new RString("該当データ無し");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString 合計 = new RString("合計");
    private static final RString 高額合算 = new RString("高額合算");
    private static final RString 高額合算小計 = new RString("高額合算小計");
    private static final RString 事業高額合算 = new RString("事業高額合算");
    private static final RString 事業高額合算_転入前 = new RString("事業高額合算（転入前）");
    private static final RString 事業高額合算小計 = new RString("事業高額合算小計");
    private static final RString 保険制度コード1 = new RString("1");
    private static final RString 国保 = new RString("1：国保");
    private static final RString 保険制度コード2 = new RString("2");
    private static final RString 後期 = new RString("2：後期");
    private static final RString 保険制度コード3 = new RString("3");
    private static final RString 介護 = new RString("3：介護");
    private static final RString 保険制度コード5 = new RString("5");
    private static final RString 所得区分0 = new RString("0");
    private static final RString 所得区分_一般 = new RString("0：一般");
    private static final RString 所得区分1 = new RString("1");
    private static final RString 低所得 = new RString("1：低所得");
    private static final RString 一般 = new RString("1：一般");
    private static final RString 所得区分2 = new RString("2");
    private static final RString 上位所得者 = new RString("2：上位所得者");
    private static final RString 所得区分3 = new RString("3");
    private static final RString 低所得者II = new RString("3：低所得者Ⅱ");
    private static final RString 所得区分4 = new RString("4");
    private static final RString 低所得者I = new RString("4：低所得者Ⅰ");
    private static final RString 所得区分5 = new RString("5");
    private static final RString 区分ア = new RString("5：区分ア");
    private static final RString 所得区分6 = new RString("6");
    private static final RString 区分イ = new RString("6：区分イ");
    private static final RString 所得区分7 = new RString("7");
    private static final RString 区分ウ = new RString("7：区分ウ");
    private static final RString 所得区分8 = new RString("8");
    private static final RString 区分エ = new RString("8：区分エ");
    private static final RString 所得区分9 = new RString("9");
    private static final RString 区分オ = new RString("9：区分オ");
    private static final RString 国保被保険者以外 = new RString("国保被保険者以外");
    private static final RString 再計算実施1 = new RString("1");
    private static final RString 支給 = new RString("支給");
    private static final RString 再計算実施2 = new RString("2");
    private static final RString 支給額が0円で不支給 = new RString("支給額が0円で不支給");
    private static final RString 再計算実施3 = new RString("3");
    private static final RString 支給額が支給基準額以下で不支給 = new RString("支給額が支給基準額以下で不支給");
    private static final RString 再支給区分1 = new RString(1);
    private static final RString 再支給区分2 = new RString(2);
    private static final RString 窓口区分1 = new RString(1);
    private static final RString 高額_口座 = new RString("高額-口座");
    private static final RString 窓口区分2 = new RString(2);
    private static final RString 高額_窓口 = new RString("高額-窓口");
    private static final RString 窓口区分3 = new RString(3);
    private static final RString 事業_口座 = new RString("事業-口座");
    private static final RString 窓口区分4 = new RString(4);
    private static final RString 窓口区分5 = new RString(5);
    private static final RString 画面_口座 = new RString("画面-口座");
    private static final RString 窓口 = new RString("1：窓口");
    private static final RString 口座 = new RString("2：口座");
    private static final RString 支払方法区分1 = new RString("1");
    private static final RString 支払方法区分2 = new RString("2");

    private JigyobunShikyugakuKeisanProcessParameter parameter;
    private Association 地方公共団体;

    @BatchWriter
    private BatchReportWriter<GassanJigyobunKekkaIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanJigyobunKekkaIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<GassanJigyobunShikyugakuKeisanKekkaIchiranEntity> csvWriter;

    private List<ShikyugakuUpdateTempEntity> キー項目List;
    private List<RString> breakItemIds;
    private FileSpoolManager manager;
    private IOutputOrder 出力順;
    private int 通番;
    private RString 自市町村コード;
    private RString 自市町村名;

    private Decimal 七十歳以上負担額_合計 = Decimal.ZERO;
    private Decimal 七十歳以上負担額_高額合算小計 = Decimal.ZERO;
    private Decimal 七十歳以上負担額_事業高額合算小計 = Decimal.ZERO;
    private Decimal 三一にかかる支給額_合計 = Decimal.ZERO;
    private Decimal 三一にかかる支給額_高額合算小計 = Decimal.ZERO;
    private Decimal 三一にかかる支給額_事業合算小計 = Decimal.ZERO;
    private Decimal 五四一三_合計 = Decimal.ZERO;
    private Decimal 五四一三_高額合算小計 = Decimal.ZERO;
    private Decimal 五四一三_事業合算小計 = Decimal.ZERO;
    private Decimal 七十歳未満負担額_合計 = Decimal.ZERO;
    private Decimal 七十歳未満負担額_高額合算小計 = Decimal.ZERO;
    private Decimal 七十歳未満負担額_事業高額合算小計 = Decimal.ZERO;
    private Decimal 五に係る支給額_合計 = Decimal.ZERO;
    private Decimal 五に係る支給額_高額合算小計 = Decimal.ZERO;
    private Decimal 五に係る支給額_事業高額合算小計 = Decimal.ZERO;
    private Decimal 八三七_合計 = Decimal.ZERO;
    private Decimal 八三七_高額合算小計 = Decimal.ZERO;
    private Decimal 八三七_事業合算小計 = Decimal.ZERO;

    private boolean hasData;

    @Override
    protected void initialize() {
        通番 = 0;
        hasData = false;
        breakItemIds = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        出力順 = ReportUtil.get出力順ID(SubGyomuCode.DBC介護給付, parameter.get出力順ID(), ReportIdDBC.DBC200204.getReportId());
        if (null == 出力順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        parameter.setOrderBy(MyBatisOrderByClauseCreator.create(
                GassanJigyobunKekkaIchiranOrder.class, 出力順).replace(ORDER_BY, RString.EMPTY));
        for (ISetSortItem item : 出力順.get設定項目リスト()) {
            if (item.is改頁項目()) {
                breakItemIds.add(item.get項目ID());
            } else {
                breakItemIds.add(RString.EMPTY);
            }
        }
        parameter.set自市町村コード(地方公共団体.get地方公共団体コード().value());
        キー項目List = new ArrayList<>();
        自市町村コード = 地方公共団体.get地方公共団体コード().value();
        自市町村名 = 地方公共団体.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200204.getReportId().value()).
                addBreak(new GassanJigyobunKekkaIchiranPageBreak(breakItemIds)).create();

        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 一覧EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        csvWriter = new CsvWriter.InstanceBuilder(Path.combinePath(manager.getEucOutputDirectry(), CSV_FILE_NAME)).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(ShikyugakuUpdateTempEntity entity) {
        if (!(getBefore().getHihokenshaNo().equals(entity.getHihokenshaNo())
                && getBefore().getTaishoNendo().equals(entity.getTaishoNendo())
                && getBefore().getShoKisaiHokenshaNo().equals(entity.getShoKisaiHokenshaNo())
                && getBefore().getShikyuShinseishoSeiriNo().equals(entity.getShikyuShinseishoSeiriNo()))) {
            csvOutput();
        }
    }

    @Override
    protected void usualProcess(ShikyugakuUpdateTempEntity entity) {
        hasData = true;
        if (区分１.equals(entity.getKubun())) {
            JigyobunShikyugakuRenrakuhyo param = new JigyobunShikyugakuRenrakuhyo();
            param.set出力対象区分(parameter.get出力対象区分());
            param.set受取年月(parameter.get受取年月());
            param.set年度(parameter.get年度());
            param.set被保険者番号(parameter.get被保険者番号());
            param.set市町村名(自市町村名);
            GassanJigyobunKekkaIchiranEntity 帳票用データ = new GassanJigyobunKekkaIchiranEntity();
            帳票用データ.set件数(1);
            帳票用データ.set口座番号(entity.getKozaNo());
            帳票用データ.set宛名氏名(entity.getAtenaShimei() == null ? RString.EMPTY : entity.getAtenaShimei().getColumnValue());
            帳票用データ.set支給額_70歳以上介護等合算一部負担金等世帯合算額(entity.getShikyugaku_over70_SetaiGassanGaku());
            帳票用データ.set支給額_70歳以上介護等合算算定基準額(entity.getShikyugaku_over70_SanteiKijyunGaku());
            帳票用データ.set支給額_うち70歳以上分世帯支給総額(entity.getShikyugaku_over70_SetaiShikyuSogaku());
            帳票用データ.set支給額_うち70歳以上分按分後支給額(entity.getShikyugaku_over70_honninShikyugaku());
            帳票用データ.set支給額_世帯支給総額(entity.getShikyugaku_setaiShikyuSogaku());
            帳票用データ.set支給額_世帯負担総額(entity.getShikyugaku_setaiFutanSogaku());
            帳票用データ.set支給額_介護等合算一部負担金等世帯合算額(entity.getShikyugaku_setaiGassanGaku());
            帳票用データ.set支給額_介護等合算算定基準額(entity.getShikyugaku_santeiKijunGaku());
            帳票用データ.set支給額_按分後支給額(entity.getShikyugaku_honninShikyugaku());
            帳票用データ.set支給額_支給申請書整理番号(entity.getShikyugaku_shikyuShinseishoSeiriNo());
            帳票用データ.set支給額_被保険者番号(entity.getShikyugaku_hihokenshaNo());
            帳票用データ.set支給額明細_自己負担額証明書整理番号(entity.getShikyugakuMeisai_jikoFutanSeiriNo());
            帳票用データ.set決定_支払場所(entity.getKettei_shiharaiBasho());
            帳票用データ.set決定_支払方法区分(entity.getKettei_shiharaiHohoKubun());
            帳票用データ.set決定_支給区分コード(entity.getKettei_shikyuKubun());
            帳票用データ.set識別コード(entity.getShikibetsuCode());
            帳票用データ.set金融機関コード(entity.getKinyukikanCode() == null ? RString.EMPTY : entity.getKinyukikanCode().value());
            帳票用データ.set金融機関支店コード(entity.getKinyuKikanShitenCode() == null ? RString.EMPTY : entity.getKinyuKikanShitenCode().value());
            帳票用データ.setGyoseiCode(entity.getGyoseiCode());
            帳票用データ.setChoikiCode(entity.getChoikiCode() == null ? RString.EMPTY : entity.getChoikiCode().getColumnValue());
            帳票用データ.setShichosonCode(entity.getShichosonCode() == null ? RString.EMPTY : entity.getShichosonCode().value());
            帳票用データ.setTaishoNendo(entity.getTaishoNendo().toDateString());
            帳票用データ.setYubinNo(entity.getYubinNo() == null ? RString.EMPTY : entity.getYubinNo().value());
            帳票用データ.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo().getColumnValue());
            param.set帳票用データ(帳票用データ);
            GassanJigyobunKekkaIchiranReport report = new GassanJigyobunKekkaIchiranReport(param, 出力順, 自市町村コード, breakItemIds);
            report.writeBy(reportSourceWriter);
        }
        キー項目List.add(entity);

        七十歳以上負担額_合計 = 七十歳以上負担額_合計.add(getDecimal2(entity.getShikyugakuMeisai_over70_Futangaku()));
        三一にかかる支給額_合計 = 三一にかかる支給額_合計.add(getDecimal2(entity.getShikyugakuMeisai_over70_Shikyugaku()));
        七十歳未満負担額_合計 = 七十歳未満負担額_合計.add(getDecimal2(entity.getShikyugakuMeisai_under70_Futangaku()));
        五に係る支給額_合計 = 五に係る支給額_合計.add(getDecimal2(entity.getShikyugakuMeisai_under70_Shikyugaku()));
        五四一三_合計 = 五四一三_合計.add(getDecimal2(entity.getShikyugakuMeisai_futangaku()));
        八三七_合計 = 八三七_合計.add(getDecimal2(entity.getShikyugakuMeisai_shikyugaku()));
        if (区分２.equals(entity.getKubun()) && !保険制度コード5.equals(entity.getShikyugakuMeisai_hokenSeidoCode())) {
            七十歳以上負担額_高額合算小計 = 七十歳以上負担額_高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_over70_Futangaku()));
            三一にかかる支給額_高額合算小計 = 三一にかかる支給額_高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_over70_Shikyugaku()));
            七十歳未満負担額_高額合算小計 = 七十歳未満負担額_高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_under70_Futangaku()));
            五に係る支給額_高額合算小計 = 五に係る支給額_高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_under70_Shikyugaku()));
            五四一三_高額合算小計 = 五四一三_高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_futangaku()));
            八三七_高額合算小計 = 八三七_高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_shikyugaku()));
        }
        if ((区分３.equals(entity.getKubun()) || 区分４.equals(entity.getKubun()))
                && 保険制度コード5.equals(entity.getShikyugakuMeisai_hokenSeidoCode())) {
            七十歳以上負担額_事業高額合算小計 = 七十歳以上負担額_事業高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_over70_Futangaku()));
            三一にかかる支給額_事業合算小計 = 三一にかかる支給額_事業合算小計.add(getDecimal2(entity.getShikyugakuMeisai_over70_Shikyugaku()));
            七十歳未満負担額_事業高額合算小計 = 七十歳未満負担額_事業高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_under70_Futangaku()));
            五に係る支給額_事業高額合算小計 = 五に係る支給額_事業高額合算小計.add(getDecimal2(entity.getShikyugakuMeisai_under70_Shikyugaku()));
            五四一三_事業合算小計 = 五四一三_事業合算小計.add(getDecimal2(entity.getShikyugakuMeisai_futangaku()));
            八三七_事業合算小計 = 八三七_事業合算小計.add(getDecimal2(entity.getShikyugakuMeisai_shikyugaku()));
        }
    }

    @Override
    protected void afterExecute() {
        if (!hasData) {
            GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity = new GassanJigyobunShikyugakuKeisanKekkaIchiranEntity();
            csvEntity.set氏名(該当データ無し);
            csvWriter.writeLine(csvEntity);
        } else {
            csvOutput();
        }
        csvWriter.close();
        manager.spool(CSV_FILE_NAME);
    }

    private void csvOutput() {
        int 明細通番 = 0;
        boolean has区分34 = false;
        boolean isFirst = true;
        ShikyugakuUpdateTempEntity 区分２合算 = new ShikyugakuUpdateTempEntity();
        ShikyugakuUpdateTempEntity 合算 = new ShikyugakuUpdateTempEntity();
        for (ShikyugakuUpdateTempEntity tmp : キー項目List) {
            明細通番 = 明細通番 + 1;
            GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity = new GassanJigyobunShikyugakuKeisanKekkaIchiranEntity();
            setCommonData(csvEntity, tmp);
            csvEntity.set明細通番(new RString(明細通番));

            if (区分２.equals(tmp.getKubun())) {
                区分２合算 = tmp;
            }
            if (isFirst && 区分２.equals(区分２合算.getKubun()) && 区分３.equals(tmp.getKubun())) {
                csvEntity.setデータ内容(高額合算小計);
                writeCsvData(区分２合算, csvEntity);
                isFirst = false;
            }
            if (区分１.equals(tmp.getKubun())) {
                csvEntity.setデータ内容(合計);
            } else if (区分２.equals(tmp.getKubun())) {
                csvEntity.setデータ内容(高額合算);
            } else if (区分３.equals(tmp.getKubun())) {
                csvEntity.setデータ内容(事業高額合算);
                has区分34 = true;
                合算 = tmp;
            } else if (区分４.equals(tmp.getKubun())) {
                csvEntity.setデータ内容(事業高額合算_転入前);
                has区分34 = true;
                合算 = tmp;
            }
            writeCsvData(tmp, csvEntity);
        }
        if (isFirst && 区分２合算.getHihokenshaNo() != null && !区分２合算.getHihokenshaNo().isEmpty()) {
            GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity = new GassanJigyobunShikyugakuKeisanKekkaIchiranEntity();
            csvEntity.setデータ内容(高額合算小計);
            setCommonData(csvEntity, 区分２合算);
            csvEntity.set明細通番(new RString(明細通番 + 1));
            writeCsvData(キー項目List.get(0), csvEntity);
        }
        if (has区分34) {
            GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity = new GassanJigyobunShikyugakuKeisanKekkaIchiranEntity();
            setCommonData(csvEntity, 合算);
            csvEntity.set明細通番(new RString(明細通番 + 1));
            csvEntity.setデータ内容(事業高額合算小計);
            writeCsvData(キー項目List.get(0), csvEntity);
        }
        init();
    }

    private void setCommonData(GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity, ShikyugakuUpdateTempEntity tmp) {
        通番 = 通番 + 1;
        csvEntity.set通番(new RString(通番));
        csvEntity.set被保険者番号(tmp.getHihokenshaNo().getColumnValue());
        csvEntity.set対象年度(ReportKomokuEditorUtil.パターン107(tmp.getTaishoNendo()));
        csvEntity.set証記載保険者番号(tmp.getShoKisaiHokenshaNo().getColumnValue());
        csvEntity.set支給申請書整理番号(tmp.getShikyuShinseishoSeiriNo());
        csvEntity.set氏名カナ(tmp.getAtenaKanaShimei().getColumnValue());
        csvEntity.set氏名(tmp.getAtenaShimei().getColumnValue());
        csvEntity.set生年月日(ReportKomokuEditorUtil.パターン12(tmp.getSeinengappiYMD()));
    }

    private void writeCsvData(ShikyugakuUpdateTempEntity entity, GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity) {
        if (合計.equals(csvEntity.getデータ内容())) {
            set区分１(entity, csvEntity);
        } else if (高額合算.equals(csvEntity.getデータ内容())
                || 事業高額合算.equals(csvEntity.getデータ内容())
                || 事業高額合算_転入前.equals(csvEntity.getデータ内容())) {
            set区分２３４(entity, csvEntity);
        }
        if (合計.equals(csvEntity.getデータ内容())) {
            csvEntity.set一七十歳以上負担額(ReportKomokuEditorUtil.金額1(七十歳以上負担額_合計));
            csvEntity.set三一にかかる支給額(ReportKomokuEditorUtil.金額1(三一にかかる支給額_合計));
            csvEntity.set四七十歳未満負担額(ReportKomokuEditorUtil.金額1(七十歳未満負担額_合計));
            csvEntity.set五四一三(ReportKomokuEditorUtil.金額1(五四一三_合計));
            csvEntity.set七五に係る支給額(ReportKomokuEditorUtil.金額1(五に係る支給額_合計));
            csvEntity.set八三七(ReportKomokuEditorUtil.金額1(八三七_合計));
        } else if (高額合算小計.equals(csvEntity.getデータ内容())) {
            csvEntity.set一七十歳以上負担額(ReportKomokuEditorUtil.金額1(七十歳以上負担額_高額合算小計));
            csvEntity.set三一にかかる支給額(ReportKomokuEditorUtil.金額1(三一にかかる支給額_高額合算小計));
            csvEntity.set四七十歳未満負担額(ReportKomokuEditorUtil.金額1(七十歳未満負担額_高額合算小計));
            csvEntity.set五四一三(ReportKomokuEditorUtil.金額1(五四一三_高額合算小計));
            csvEntity.set七五に係る支給額(ReportKomokuEditorUtil.金額1(五に係る支給額_高額合算小計));
            csvEntity.set八三七(ReportKomokuEditorUtil.金額1(八三七_高額合算小計));
        } else if (事業高額合算小計.equals(csvEntity.getデータ内容())) {
            csvEntity.set一七十歳以上負担額(ReportKomokuEditorUtil.金額1(七十歳以上負担額_事業高額合算小計));
            csvEntity.set三一にかかる支給額(ReportKomokuEditorUtil.金額1(三一にかかる支給額_事業合算小計));
            csvEntity.set四七十歳未満負担額(ReportKomokuEditorUtil.金額1(七十歳未満負担額_事業高額合算小計));
            csvEntity.set五四一三(ReportKomokuEditorUtil.金額1(五四一三_事業合算小計));
            csvEntity.set七五に係る支給額(ReportKomokuEditorUtil.金額1(五に係る支給額_事業高額合算小計));
            csvEntity.set八三七(ReportKomokuEditorUtil.金額1(八三七_事業合算小計));
        } else {
            csvEntity.set一七十歳以上負担額(ReportKomokuEditorUtil.金額1(getDecimal2(entity.getShikyugakuMeisai_over70_Futangaku())));
            csvEntity.set三一にかかる支給額(ReportKomokuEditorUtil.金額1(getDecimal2(entity.getShikyugakuMeisai_over70_Shikyugaku())));
            csvEntity.set四七十歳未満負担額(ReportKomokuEditorUtil.金額1(getDecimal2(entity.getShikyugakuMeisai_under70_Futangaku())));
            csvEntity.set五四一三(ReportKomokuEditorUtil.金額1(getDecimal2(entity.getShikyugakuMeisai_futangaku())));
            csvEntity.set七五に係る支給額(ReportKomokuEditorUtil.金額1(getDecimal2(entity.getShikyugakuMeisai_under70_Shikyugaku())));
            csvEntity.set八三七(ReportKomokuEditorUtil.金額1(getDecimal2(entity.getShikyugakuMeisai_shikyugaku())));
        }
        csvWriter.writeLine(csvEntity);
    }

    private void set区分２３４(ShikyugakuUpdateTempEntity entity, GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity) {
        csvEntity.set支給額明細_保険制度コード(entity.getShikyugakuMeisai_hokenSeidoCode());
        csvEntity.set内訳保険者番号(entity.getShikyugakuMeisai_uchiwakeHokenshaNo());
        csvEntity.set国保_被保険者証記号(entity.getShikyugakuMeisai_kokuho_HihokenshaShoKigo());
        csvEntity.set被保険者_証番号(entity.getShikyugakuMeisai_hiHokenshaShoNo());
        csvEntity.set内訳保険者名(entity.getShikyugakuMeisai_uchiwakeHokenshaMei());
        csvEntity.set支給額明細_自己負担額証明書整理番号(entity.getShikyugakuMeisai_jikoFutanSeiriNo());
        csvEntity.set対象者氏名_漢字(entity.getShikyugakuMeisai_taishoshaShimei());
        csvEntity.set二七十歳以上按分率(entity.getShikyugakuMeisai_over70_AmbunRitsu());
        csvEntity.set按分率(entity.getShikyugakuMeisai_ambunRitsu());
        csvEntity.set備考欄記載70歳以上負担額_平成20年4月_7月分(ReportKomokuEditorUtil.金額1(getDecimal(entity.getShikyugakuMeisai_over70_Biko())));
        csvEntity.set備考欄記載70歳未満負担額_平成20年4月_7月分(ReportKomokuEditorUtil.金額1(getDecimal(entity.getShikyugakuMeisai_under70_Biko())));
    }

    private void set区分１(ShikyugakuUpdateTempEntity entity, GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity) {
        if (保険制度コード1.equals(entity.getShikyugaku_hokenSeidoCode())) {
            csvEntity.set保険制度コード(国保);
        } else if (保険制度コード2.equals(entity.getShikyugaku_hokenSeidoCode())) {
            csvEntity.set保険制度コード(後期);
        } else if (保険制度コード3.equals(entity.getShikyugaku_hokenSeidoCode())) {
            csvEntity.set保険制度コード(介護);
        }
        csvEntity.set自己負担額証明書整理番号(entity.getShikyugaku_jikoFutanSeiriNo());
        csvEntity.set対象計算期間_開始(ReportKomokuEditorUtil.パターン12(entity.getShikyugaku_taishoKeisanKaishiYMD()));
        csvEntity.set対象計算期間_終了(ReportKomokuEditorUtil.パターン12(entity.getShikyugaku_taishoKeisanShuryoYMD()));
        csvEntity.set世帯負担総額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_setaiFutanSogaku()));
        csvEntity.set介護等合算一部負担金等世帯合算額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_setaiGassanGaku()));
        csvEntity.set七十歳以上介護等合算一部負担金等世帯合算額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_over70_SetaiGassanGaku()));
        set所得区分(entity, csvEntity);
        csvEntity.set介護等合算算定基準額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_santeiKijunGaku()));
        csvEntity.set七十歳以上介護等合算算定基準額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_over70_SanteiKijyunGaku()));
        csvEntity.set世帯支給総額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_setaiShikyuSogaku()));
        csvEntity.setうち70歳以上分世帯支給総額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_over70_SetaiShikyuSogaku()));
        csvEntity.set按分後支給額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_honninShikyugaku()));
        csvEntity.setうち70歳以上分按分後支給額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_over70_honninShikyugaku()));
        csvEntity.set介護低所得者Ⅰ再計算実施の有無(entity.getShikyugaku_teiShotoku_1_SaiKeisanUmu());
        csvEntity.set備考(entity.getShikyugaku_biko());
        csvEntity.set支給額計算結果連絡先郵便番号(get郵便番号(entity.getShikyugaku_kekkaRenrakusakiYubinNo()));
        csvEntity.set支給額計算結果連絡先住所(entity.getShikyugaku_kekkaRenrakusakiJusho());
        csvEntity.set支給額計算結果連絡先名称1(entity.getShikyugaku_kettaRenrakusakiMeisho1());
        csvEntity.set支給額計算結果連絡先名称2(entity.getShikyugaku_kekkaRenrakusakiMeisho2());
        if (再計算実施1.equals(entity.getShikyugaku_teiShotoku_1_SaiKeisanUmu())) {
            csvEntity.set決定情報_支給額再計算(支給);
        } else if (再計算実施2.equals(entity.getShikyugaku_teiShotoku_1_SaiKeisanUmu())) {
            csvEntity.set決定情報_支給額再計算(支給額が0円で不支給);
        } else if (再計算実施3.equals(entity.getShikyugaku_teiShotoku_1_SaiKeisanUmu())) {
            csvEntity.set決定情報_支給額再計算(支給額が支給基準額以下で不支給);
        }
        if (再支給区分1.equals(entity.getSaiShikyuKubun())) {
            csvEntity.set決定情報_支給区分(再支給区分1);
            csvEntity.set決定情報_支給額(ReportKomokuEditorUtil.金額1(entity.getKettei_shikyugaku()));
            if (支払方法区分1.equals(entity.getKettei_shiharaiHohoKubun())) {
                csvEntity.set決定情報_支払方法区分(窓口);
            } else if (支払方法区分2.equals(entity.getKettei_shiharaiHohoKubun())) {
                csvEntity.set決定情報_支払方法区分(口座);
            }
            csvEntity.set決定情報_支払場所(entity.getKettei_shiharaiBasho());
            csvEntity.set決定情報_支払期間開始日(ReportKomokuEditorUtil.パターン12(entity.getKettei_shiharaikikanKaishiYMD()));
            csvEntity.set決定情報_支払期間終了日(ReportKomokuEditorUtil.パターン12(entity.getKettei_shiharaikikanShuryoYMD()));
            csvEntity.set決定情報_支払期間開始日_開始時間(パターン142(entity.getKettei_shiharaikikanKaishiTime()));
            csvEntity.set決定情報_支払期間終了日_終了時間(パターン142(entity.getKettei_shiharaikikanShuryoTime()));
            csvEntity.set決定情報_金融機関コード(ReportKomokuEditorUtil.get金融機関コード(entity.getKinyukikanCode()));
            csvEntity.set決定情報_金融機関名(entity.getKinyukikanMei());
            csvEntity.set決定情報_金融機関支店コード(ReportKomokuEditorUtil.get金融機関支店コード(entity.getKinyuKikanShitenCode()));
            csvEntity.set決定情報_金融機関支店名(entity.getKinyuKikanShitenMei());
            csvEntity.set決定情報_口座種目(entity.getKozaShumoku());
            csvEntity.set決定情報_口座種目名(entity.getKozaShumokuMei());
            csvEntity.set決定情報_口座番号(entity.getKozaNo());
            csvEntity.set決定情報_口座名義人_カナ(ReportKomokuEditorUtil.get氏名カナ(entity.getKozaMeiginin()));
        } else {
            csvEntity.set決定情報_支給区分(再支給区分2);
            csvEntity.set決定情報_支給額(ReportKomokuEditorUtil.金額1(Decimal.ZERO));
        }
        csvEntity.set決定情報_世帯負担総額(ReportKomokuEditorUtil.金額1(entity.getShikyugaku_setaiFutanSogaku()));
        if (窓口区分1.equals(entity.getMadoguchiKubun())) {
            csvEntity.set決定情報_支払方法引き継ぎ元(高額_口座);
        } else if (窓口区分2.equals(entity.getMadoguchiKubun())) {
            csvEntity.set決定情報_支払方法引き継ぎ元(高額_窓口);
        } else if (窓口区分3.equals(entity.getMadoguchiKubun())) {
            csvEntity.set決定情報_支払方法引き継ぎ元(事業_口座);
        } else if (窓口区分4.equals(entity.getMadoguchiKubun())) {
            csvEntity.set決定情報_支払方法引き継ぎ元(事業_口座);
        } else if (窓口区分5.equals(entity.getMadoguchiKubun())) {
            csvEntity.set決定情報_支払方法引き継ぎ元(画面_口座);
        }
        csvEntity.set郵便番号(get郵便番号(entity.getYubinNo()));
        csvEntity.set住所コード(entity.getJushoCode());
        csvEntity.set行政区コード(entity.getGyoseiCode());
        csvEntity.set市町村コード(get市町村コード(entity.getShichosonCode()));
    }

    private void set所得区分(ShikyugakuUpdateTempEntity entity, GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity) {
        if (所得区分0.equals(entity.getShikyugaku_shotokuKubun())) {
            csvEntity.set所得区分(所得区分_一般);
        } else if (所得区分1.equals(entity.getShikyugaku_shotokuKubun())) {
            csvEntity.set所得区分(低所得);
        } else if (所得区分2.equals(entity.getShikyugaku_shotokuKubun())) {
            csvEntity.set所得区分(上位所得者);
        } else if (所得区分5.equals(entity.getShikyugaku_shotokuKubun())) {
            csvEntity.set所得区分(区分ア);
        } else if (所得区分6.equals(entity.getShikyugaku_shotokuKubun())) {
            csvEntity.set所得区分(区分イ);
        } else if (所得区分7.equals(entity.getShikyugaku_shotokuKubun())) {
            csvEntity.set所得区分(区分ウ);
        } else if (所得区分8.equals(entity.getShikyugaku_shotokuKubun())) {
            csvEntity.set所得区分(区分エ);
        } else if (所得区分9.equals(entity.getShikyugaku_shotokuKubun())) {
            csvEntity.set所得区分(区分オ);
        } else {
            csvEntity.set所得区分(国保被保険者以外);
        }
        if (所得区分1.equals(entity.getShikyugaku_over70_ShotokuKubun())) {
            csvEntity.set七十歳以上の者に係る所得区分(一般);
        } else if (所得区分2.equals(entity.getShikyugaku_over70_ShotokuKubun())) {
            csvEntity.set七十歳以上の者に係る所得区分(上位所得者);
        } else if (所得区分3.equals(entity.getShikyugaku_over70_ShotokuKubun())) {
            csvEntity.set七十歳以上の者に係る所得区分(低所得者II);
        } else if (所得区分4.equals(entity.getShikyugaku_over70_ShotokuKubun())) {
            csvEntity.set七十歳以上の者に係る所得区分(低所得者I);
        }
    }

    private RString get郵便番号(YubinNo yubinNo) {
        return yubinNo == null ? RString.EMPTY : yubinNo.getEditedYubinNo();
    }

    private RString get市町村コード(LasdecCode shichosonCode) {
        return shichosonCode == null ? RString.EMPTY : shichosonCode.getColumnValue();
    }

    private Decimal getDecimal(RString kingaku) {
        return RString.isNullOrEmpty(kingaku) ? null : new Decimal(kingaku.toString());
    }

    private Decimal getDecimal2(RString kingaku) {
        return RString.isNullOrEmpty(kingaku) ? Decimal.ZERO : new Decimal(kingaku.toString());
    }

    private void init() {
        キー項目List = new ArrayList<>();

        七十歳以上負担額_合計 = Decimal.ZERO;
        七十歳以上負担額_高額合算小計 = Decimal.ZERO;
        七十歳以上負担額_事業高額合算小計 = Decimal.ZERO;
        三一にかかる支給額_合計 = Decimal.ZERO;
        三一にかかる支給額_高額合算小計 = Decimal.ZERO;
        三一にかかる支給額_事業合算小計 = Decimal.ZERO;
        七十歳未満負担額_合計 = Decimal.ZERO;
        七十歳未満負担額_高額合算小計 = Decimal.ZERO;
        七十歳未満負担額_事業高額合算小計 = Decimal.ZERO;
        五に係る支給額_合計 = Decimal.ZERO;
        五に係る支給額_高額合算小計 = Decimal.ZERO;
        五に係る支給額_事業高額合算小計 = Decimal.ZERO;
        五四一三_合計 = Decimal.ZERO;
        五四一三_高額合算小計 = Decimal.ZERO;
        五四一三_事業合算小計 = Decimal.ZERO;
        八三七_合計 = Decimal.ZERO;
        八三七_高額合算小計 = Decimal.ZERO;
        八三七_事業合算小計 = Decimal.ZERO;
    }

    private RString パターン142(RString time) {
        if (RString.isNullOrEmpty(time)) {
            return RString.EMPTY;
        }
        return new RTime(time).toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
    }
}
