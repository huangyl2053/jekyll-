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
    private YokaigoNinteiJisshiJokyohyoReportEntity yokaigoNinteiJisshiJokyohyoReportEntity;

    @Override
    protected void initialize() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        parameter.setPsmShikibetsuTaisho(psmShikibetsuTaisho);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD300004.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
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
    protected void process(YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity) {
        set市町村(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity);
        if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("01"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("認定件数　（旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("02"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("要介護度１（旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("03"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("要介護度２（旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("04"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("要介護度３（旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("05"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("要介護度４（旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("06"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("要介護度５（旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("07"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("要支援１  （旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("08"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("要支援２  （旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("09"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("経過介護  （旧措置）"));
        } else if (yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get取得条件().equals(new RString("10"))) {
            yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("自立      （旧措置）"));
        }
        yokaigoNinteiJisshiJokyohyoReportEntity.set年度合計(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get件数().intValue())
                .concat("(")
                .concat(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get件数旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(yokaigoNinteiJisshiJokyohyoReportEntity);
        set市町村(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity);
        yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("新規　  （旧措置）"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set年度合計(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get新規().intValue())
                .concat("(")
                .concat(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get新規旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(yokaigoNinteiJisshiJokyohyoReportEntity);
        set市町村(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity);
        yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("（要支援）（旧措置）"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set年度合計(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get要支援().intValue())
                .concat("(")
                .concat(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get要支援旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(yokaigoNinteiJisshiJokyohyoReportEntity);
        set市町村(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity);
        yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("更新　  （旧措置）"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set年度合計(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get更新().intValue())
                .concat("(")
                .concat(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get更新旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(yokaigoNinteiJisshiJokyohyoReportEntity);
        set市町村(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity);
        yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("区分変更　（旧措置）"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set年度合計(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get区分変更().intValue())
                .concat("(")
                .concat(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get区分変更旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(yokaigoNinteiJisshiJokyohyoReportEntity);
        set市町村(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity);
        yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("転入　  （旧措置）"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set年度合計(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get転入().intValue())
                .concat("(")
                .concat(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get転入旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(yokaigoNinteiJisshiJokyohyoReportEntity);
        set市町村(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity);
        yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString("職権他    （旧措置）"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set年度合計(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get職権他().intValue())
                .concat("(")
                .concat(new RString(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get職権他旧措置().intValue()))
                .concat(")"));
        受給状況Entity.get受給状況リスト().add(yokaigoNinteiJisshiJokyohyoReportEntity);
        set市町村(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity);
        yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(new RString(""));
        受給状況Entity.get受給状況リスト().add(yokaigoNinteiJisshiJokyohyoReportEntity);
    }

    private void set市町村(YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity) {
        yokaigoNinteiJisshiJokyohyoReportEntity = new YokaigoNinteiJisshiJokyohyoReportEntity();
        yokaigoNinteiJisshiJokyohyoReportEntity.set市町村番号(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get市町村コード().getColumnValue());
        yokaigoNinteiJisshiJokyohyoReportEntity.set市町村名(yokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity.get市町村名称());
    }

    @Override
    protected void afterExecute() {
        FlexibleDate 基準日 = parameter.get基準年月日();
        RString 年齢 = new RString(parameter.get年齢From())
                .concat(new RString("～"))
                .concat(new RString(parameter.get年齢To()));
        RString 地区 = RString.EMPTY;
        RString 集計単位 = RString.EMPTY;
        if (parameter.get地区区分().equals(new RString("ALL"))) {
            地区 = new RString("全て");

        } else {
            地区 = new RString(parameter.get開始地区コード().toString())
                    .concat(new RString("～"))
                    .concat(new RString(parameter.get終了地区コード().toString()));
        }
        if (parameter.get集計単位().equals(new RString("ZIYU"))) {
            集計単位 = new RString("受給申請事由");
        } else if (parameter.get集計単位().equals(new RString("SHINSEIZI"))) {
            集計単位 = new RString("申請区分(申請時)");

        } else if (parameter.get集計単位().equals(new RString("HOUREI"))) {
            集計単位 = new RString("申請区分(法令)");
        }

        YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport report = new YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport(
                基準日,
                年齢,
                地区,
                集計単位,
                parameter.get対象年度().getYear(),
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
