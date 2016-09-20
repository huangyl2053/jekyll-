/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD583001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd583001.NenreiKaikyubetsuYokaigodoJokyo;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300005.NenreiKaikyubetsuYokaigodoJokyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001.ToukeiNinzuEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300005.NenreiKaikyubetsuYokaigodoJokyoReportSource;
import jp.co.ndensan.reams.db.dbd.service.report.dbd583001.OutputJokenhyo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 年齢階級別要介護度状況（統計表）のprocess処理クラスです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyoProcess extends BatchProcessBase<ToukeiNinzuEntity> {

    private static final ReportId REPORT_DBD300005 = ReportIdDBD.DBD300005.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.nenreikaidanbetsuyokaigodujyokyo.INenreiKaikyubetsuYokaigodoJokyoMapper.get人数");
    private NenreiKaikyubetsuYokaigodoJokyoProcessParameter parameter;
    private static final int FLAG10 = 10;
    private static final int FLAG16 = 16;
    private static final int FLAG18 = 18;
    private static final int FLAG28 = 28;
    private static final int FLAG42 = 42;
    private static final int FLAG60 = 60;
    private static final int INDEX4 = 4;
    private List<ToukeiNinzuEntity> 統計人数Entityリスト;
    private int flag = 0;

    @BatchWriter
    private BatchReportWriter<NenreiKaikyubetsuYokaigodoJokyoReportSource> batchReportWriter;
    private ReportSourceWriter<NenreiKaikyubetsuYokaigodoJokyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        統計人数Entityリスト = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNenreiKaikyubetsuYokaigodoJokyoMybatisParameter(shikibetsuTaishoPSMSearchKey));
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD300005.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

    @Override
    protected void process(ToukeiNinzuEntity toukeiNinzuEntity) {
        NenreiKaikyubetsuYokaigodoJokyo business = new NenreiKaikyubetsuYokaigodoJokyo();
        business.initializeToukeiNinzuEntity(toukeiNinzuEntity);
        統計人数Entityリスト.add(toukeiNinzuEntity);

        ToukeiNinzuEntity toukeiNinzuEntity1 = new ToukeiNinzuEntity();
        ToukeiNinzuEntity toukeiNinzuEntity2 = new ToukeiNinzuEntity();
        business.setToukeiNinzuEntityZero(toukeiNinzuEntity1);
        business.setToukeiNinzuEntityZero(toukeiNinzuEntity2);
        flag = flag + 1;
        if (flag == FLAG10 || flag == FLAG42) {
            for (int index = flag - FLAG10; index < flag; index = index + 2) {
                business.setToukeiNinzuEntity(index, toukeiNinzuEntity1, toukeiNinzuEntity2, 統計人数Entityリスト);
            }
            統計人数Entityリスト.add(toukeiNinzuEntity1);
            統計人数Entityリスト.add(toukeiNinzuEntity2);
            flag = flag + 2;
        }
        if (flag == FLAG28 || flag == FLAG60) {
            for (int index = flag - FLAG16; index < flag; index = index + 2) {
                business.setToukeiNinzuEntity(index, toukeiNinzuEntity1, toukeiNinzuEntity2, 統計人数Entityリスト);
            }
            統計人数Entityリスト.add(toukeiNinzuEntity1);
            統計人数Entityリスト.add(toukeiNinzuEntity2);
            ToukeiNinzuEntity toukeiNinzuEntity3 = new ToukeiNinzuEntity();
            ToukeiNinzuEntity toukeiNinzuEntity4 = new ToukeiNinzuEntity();
            business.setToukeiNinzuEntityZero(toukeiNinzuEntity3);
            business.setToukeiNinzuEntityZero(toukeiNinzuEntity4);
            for (int index = flag - FLAG18; index < flag + 1; index = index + FLAG18) {
                business.setToukeiNinzuEntity(index, toukeiNinzuEntity3, toukeiNinzuEntity4, 統計人数Entityリスト);
            }
            統計人数Entityリスト.add(toukeiNinzuEntity3);
            統計人数Entityリスト.add(toukeiNinzuEntity4);
            flag = flag + INDEX4;
        }
    }

    @Override
    protected void afterExecute() {

        RString 市町村番号 = parameter.get旧市町村コード();
        RString 市町村名 = parameter.get旧市町村名称();
        RString 基準日;
        if (parameter.get基準日() != null && !parameter.get基準日().toDateString().isEmpty()) {
            基準日 = parameter.get基準日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                    Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        } else {
            基準日 = parameter.get基準年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                    Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        RString 地区開始コード = RString.EMPTY;
        RString 地区終了コード = RString.EMPTY;
        if (parameter.get開始地区コード() != null && !parameter.get開始地区コード().isEmpty()) {
            地区開始コード = parameter.get開始地区コード().getColumnValue();
        }
        if (parameter.get終了地区コード() != null && !parameter.get終了地区コード().isEmpty()) {
            地区終了コード = parameter.get終了地区コード().getColumnValue();
        }
        RString 地区 = 地区開始コード.concat("～").concat(地区終了コード);
        NenreiKaikyubetsuYokaigodoJokyoReport report = new NenreiKaikyubetsuYokaigodoJokyoReport(
                市町村番号, 市町村名, 基準日, 地区, 統計人数Entityリスト);
        report.writeBy(reportSourceWriter);
        OutputJokenhyo outputJokenhyo = new OutputJokenhyo();
        outputJokenhyo.outputJokenhyoFactory(parameter);

    }

}
