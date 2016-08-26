/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd582001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd582001.DBD582001ProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd582001.JukyushaSuJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd582001.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoReportEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定月別受給者数状況表（統計表）の発行_process処理クラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
public class ShukihyoHakkouProcess extends BatchProcessBase<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity> {

    private static final ReportId REPORT_DBD300004 = ReportIdDBD.DBD300004.getReportId();
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteitsukibetsujukyushasujokyohyo."
                    + "IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoMapper.get印刷対象");
    @BatchWriter
    private BatchReportWriter<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource> batchReportWriter;
    private ReportSourceWriter<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource> reportSourceWriter;
    private DBD582001ProcessParameter parameter;
    private JukyushaSuJokyohyoEntity 受給状況Entity;
    private YokaigoNinteiJisshiJokyohyoReportEntity jisshiJokyohyoReportEntity;
    private static final RString 取得条件01 = new RString("01");
    private static final RString 取得条件02 = new RString("02");
    private static final RString 取得条件03 = new RString("03");
    private static final RString 取得条件04 = new RString("04");
    private static final RString 取得条件05 = new RString("05");
    private static final RString 取得条件06 = new RString("06");
    private static final RString 取得条件07 = new RString("07");
    private static final RString 取得条件08 = new RString("08");
    private static final RString 取得条件09 = new RString("09");
    private static final RString 取得条件10 = new RString("10");
    private static final RString 集計項目認定件数 = new RString("認定件数　（旧措置）");
    private static final RString 集計項目要介護度1 = new RString("要介護度１（旧措置）");
    private static final RString 集計項目要介護度2 = new RString("要介護度２（旧措置）");
    private static final RString 集計項目要介護度3 = new RString("要介護度３（旧措置）");
    private static final RString 集計項目要介護度4 = new RString("要介護度４（旧措置）");
    private static final RString 集計項目要介護度5 = new RString("要介護度５（旧措置）");
    private static final RString 集計項目要支援1 = new RString("要支援１  （旧措置）");
    private static final RString 集計項目要支援2 = new RString("要支援２  （旧措置）");
    private static final RString 集計項目経過介護 = new RString("経過介護  （旧措置）");
    private static final RString 集計項目自立 = new RString("自立      （旧措置）");
    private static final RString 集計項目新規 = new RString("新規　  （旧措置）");
    private static final RString 集計項目要支援 = new RString("（要支援）（旧措置）");
    private static final RString 集計項目更新 = new RString("更新　  （旧措置）");
    private static final RString 集計項目区分変更 = new RString("区分変更　（旧措置）");
    private static final RString 集計項目転入 = new RString("転入　  （旧措置）");
    private static final RString 集計項目職権他 = new RString("職権他    （旧措置）");
    private static final RString 地区区分全て = new RString("ALL");
    private static final RString 地区全て = new RString("全て");
    private static final RString 集計単位受給申請 = new RString("ZIYU");
    private static final RString 集計単位申請時 = new RString("SHINSEIZI");
    private static final RString 集計単位法令 = new RString("HOUREI");
    private static final RString 受給申請事由 = new RString("受給申請事由");
    private static final RString 申請区分申請時 = new RString("申請区分(申請時)");
    private static final RString 申請区分法令 = new RString("申請区分(法令)");

    @Override
    protected void initialize() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        parameter.setPsmShikibetsuTaisho(psmShikibetsuTaisho);
        受給状況Entity = new JukyushaSuJokyohyoEntity();
        受給状況Entity.set受給状況リスト1(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト2(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト3(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト4(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト5(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト6(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト7(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト8(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト9(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト10(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト11(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト12(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト13(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト14(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト15(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト16(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        受給状況Entity.set受給状況リスト(new ArrayList<YokaigoNinteiJisshiJokyohyoReportEntity>());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toYokaigoNinteiTsukibetsuJukyushaMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD300004.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

    @Override
    protected void process(YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity jukyushaSuJokyohyoEntity) {
        set市町村(jukyushaSuJokyohyoEntity);
        if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件01)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目認定件数);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件02)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目要介護度1);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件03)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目要介護度2);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件04)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目要介護度3);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件05)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目要介護度4);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件06)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目要介護度5);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件07)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目要支援1);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件08)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目要支援2);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件09)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目経過介護);
        } else if (jukyushaSuJokyohyoEntity.get取得条件().equals(取得条件10)) {
            jisshiJokyohyoReportEntity.set集計項目(集計項目自立);
        }
        jisshiJokyohyoReportEntity.set年度合計(new RString(jukyushaSuJokyohyoEntity.get件数().intValue())
                .concat("(")
                .concat(new RString(jukyushaSuJokyohyoEntity.get件数旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(jisshiJokyohyoReportEntity);
        set市町村(jukyushaSuJokyohyoEntity);
        jisshiJokyohyoReportEntity.set集計項目(集計項目新規);
        jisshiJokyohyoReportEntity.set年度合計(new RString(jukyushaSuJokyohyoEntity.get新規().intValue())
                .concat("(")
                .concat(new RString(jukyushaSuJokyohyoEntity.get新規旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(jisshiJokyohyoReportEntity);
        set市町村(jukyushaSuJokyohyoEntity);
        jisshiJokyohyoReportEntity.set集計項目(集計項目要支援);
        jisshiJokyohyoReportEntity.set年度合計(new RString(jukyushaSuJokyohyoEntity.get要支援().intValue())
                .concat("(")
                .concat(new RString(jukyushaSuJokyohyoEntity.get要支援旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(jisshiJokyohyoReportEntity);
        set市町村(jukyushaSuJokyohyoEntity);
        jisshiJokyohyoReportEntity.set集計項目(集計項目更新);
        jisshiJokyohyoReportEntity.set年度合計(new RString(jukyushaSuJokyohyoEntity.get更新().intValue())
                .concat("(")
                .concat(new RString(jukyushaSuJokyohyoEntity.get更新旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(jisshiJokyohyoReportEntity);
        set市町村(jukyushaSuJokyohyoEntity);
        jisshiJokyohyoReportEntity.set集計項目(集計項目区分変更);
        jisshiJokyohyoReportEntity.set年度合計(new RString(jukyushaSuJokyohyoEntity.get区分変更().intValue())
                .concat("(")
                .concat(new RString(jukyushaSuJokyohyoEntity.get区分変更旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(jisshiJokyohyoReportEntity);
        set市町村(jukyushaSuJokyohyoEntity);
        jisshiJokyohyoReportEntity.set集計項目(集計項目転入);
        jisshiJokyohyoReportEntity.set年度合計(new RString(jukyushaSuJokyohyoEntity.get転入().intValue())
                .concat("(")
                .concat(new RString(jukyushaSuJokyohyoEntity.get転入旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(jisshiJokyohyoReportEntity);
        set市町村(jukyushaSuJokyohyoEntity);
        jisshiJokyohyoReportEntity.set集計項目(集計項目職権他);
        jisshiJokyohyoReportEntity.set年度合計(new RString(jukyushaSuJokyohyoEntity.get職権他().intValue())
                .concat("(")
                .concat(new RString(jukyushaSuJokyohyoEntity.get職権他旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(jisshiJokyohyoReportEntity);
        set市町村(jukyushaSuJokyohyoEntity);
        jisshiJokyohyoReportEntity.set集計項目(RString.EMPTY);
        受給状況Entity.get受給状況リスト().add(jisshiJokyohyoReportEntity);
    }

    private void set市町村(YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity jukyushaSuJokyohyoEntity) {
        jisshiJokyohyoReportEntity = new YokaigoNinteiJisshiJokyohyoReportEntity();
        jisshiJokyohyoReportEntity.set市町村番号(jukyushaSuJokyohyoEntity.get市町村コード().value());
        jisshiJokyohyoReportEntity.set市町村名(jukyushaSuJokyohyoEntity.get市町村名称());
    }

    @Override
    protected void afterExecute() {
        FlexibleDate 基準日 = parameter.get基準年月日();
        RString 年齢 = new RString(parameter.get年齢From())
                .concat("～")
                .concat(new RString(parameter.get年齢To()));
        RString 地区;
        RString 集計単位 = RString.EMPTY;
        if (parameter.get地区区分().equals(地区区分全て)) {
            地区 = 地区全て;

        } else {
            地区 = new RString(parameter.get開始地区コード().toString())
                    .concat("～")
                    .concat(new RString(parameter.get終了地区コード().toString()));
        }
        if (parameter.get集計単位().equals(集計単位受給申請)) {
            集計単位 = 受給申請事由;
        } else if (parameter.get集計単位().equals(集計単位申請時)) {
            集計単位 = 申請区分申請時;

        } else if (parameter.get集計単位().equals(集計単位法令)) {
            集計単位 = 申請区分法令;
        }

        YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport report = YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport.createReport(
                基準日,
                年齢,
                地区,
                集計単位,
                parameter.get対象年度(),
                受給状況Entity.get受給状況リスト());
        report.writeBy(reportSourceWriter);
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD300004.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD300004.getReportName(),
                new RString("3ページ"),
                new RString("なし"),
                new RString("なし"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(new RString("【対象年度】 " + parameter.get対象年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString()));
        出力条件.add(new RString("【基準日】 "));
        出力条件.add(new RString("【集計単位】 " + parameter.get集計単位()));
        出力条件.add(new RString("【年齢From】 " + parameter.get年齢From()));
        出力条件.add(new RString("【年齢To】 " + parameter.get年齢To()));
        出力条件.add(new RString("【年齢基準日】 " + parameter.get年齢基準日().wareki().toDateString()));
        出力条件.add(new RString("【生年月日From】 " + parameter.get生年月日From()));
        出力条件.add(new RString("【生年月日To】 " + parameter.get生年月日To()));
        出力条件.add(new RString("【地区区分】 " + parameter.get地区区分()));
        出力条件.add(new RString("【開始地区コード】 " + parameter.get開始地区コード()));
        出力条件.add(new RString("【終了地区コード】 " + parameter.get終了地区コード()));
        return 出力条件;
    }
}
