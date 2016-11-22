/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tsukibetsusuiihyo.TsukibetsuSuiihyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 月別推移表のReportです。
 *
 * @reamsid_L DBB-0760-050 wangxiaodong
 */
public class TsukibetsuSuiihyoReport extends Report<TsukibetsuSuiihyoReportSource> {

    private final TsukibetsuSuiihyoEntity reportEntity;

    /**
     * インスタンスを生成します。
     *
     * @param reportEntity 月別推移表（帳票）のEntity
     */
    public TsukibetsuSuiihyoReport(TsukibetsuSuiihyoEntity reportEntity) {
        this.reportEntity = reportEntity;
    }

    @Override
    public void writeBy(ReportSourceWriter<TsukibetsuSuiihyoReportSource> reportSourceWriter) {
        ITsukibetsuSuiihyoEditor headerEditor = new TsukibetsuSuiihyoHeaderEditorImpl(reportEntity);
        for (TsukibetsuSuiihyoBody body : getTsukibetsuSuiihyoBody()) {
            TsukibetsuSuiihyoBodyEditorImpl bodyEditor = new TsukibetsuSuiihyoBodyEditorImpl(body);
            ITsukibetsuSuiihyoBuilder builder = new TsukibetsuSuiihyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<TsukibetsuSuiihyoBody> getTsukibetsuSuiihyoBody() {
        List<TsukibetsuSuiihyoBody> bodyList = new ArrayList<>();
        bodyList.add(get人数_1段階());
        bodyList.add(get人数_2段階());
        bodyList.add(get人数_3段階());
        bodyList.add(get人数_4段階());
        bodyList.add(get人数_5段階());
        bodyList.add(get人数_6段階());
        bodyList.add(get人数_7段階());
        bodyList.add(get人数_8段階());
        bodyList.add(get人数_9段階());
        bodyList.add(get人数_10段階());
        bodyList.add(get人数_11段階());
        bodyList.add(get人数_12段階());
        bodyList.add(get人数_13段階());
        bodyList.add(get人数_14段階());
        bodyList.add(get人数_15段階());
        bodyList.add(get人数_16段階());
        bodyList.add(get人数_17段階());
        bodyList.add(get人数_18段階());
        bodyList.add(get人数_19段階());
        bodyList.add(get人数_20段階());
        bodyList.add(get人数_21段階());
        bodyList.add(get人数_合計());
        bodyList.add(get金額_1段階());
        bodyList.add(get金額_2段階());
        bodyList.add(get金額_3段階());
        bodyList.add(get金額_4段階());
        bodyList.add(get金額_5段階());
        bodyList.add(get金額_6段階());
        bodyList.add(get金額_7段階());
        bodyList.add(get金額_8段階());
        bodyList.add(get金額_9段階());
        bodyList.add(get金額_10段階());
        bodyList.add(get金額_11段階());
        bodyList.add(get金額_12段階());
        bodyList.add(get金額_13段階());
        bodyList.add(get金額_14段階());
        bodyList.add(get金額_15段階());
        bodyList.add(get金額_16段階());
        bodyList.add(get金額_17段階());
        bodyList.add(get金額_18段階());
        bodyList.add(get金額_19段階());
        bodyList.add(get金額_20段階());
        bodyList.add(get金額_21段階());
        bodyList.add(get金額_合計());
        return bodyList;
    }

    private TsukibetsuSuiihyoBody get人数_1段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_1段階_Title(),
                reportEntity.get人数_1段階_4月(),
                reportEntity.get人数_1段階_5月(),
                reportEntity.get人数_1段階_6月(),
                reportEntity.get人数_1段階_7月(),
                reportEntity.get人数_1段階_8月(),
                reportEntity.get人数_1段階_9月(),
                reportEntity.get人数_1段階_10月(),
                reportEntity.get人数_1段階_11月(),
                reportEntity.get人数_1段階_12月(),
                reportEntity.get人数_1段階_1月(),
                reportEntity.get人数_1段階_2月(),
                reportEntity.get人数_1段階_3月(),
                reportEntity.get人数_1段階_現年随時(),
                reportEntity.get人数_1段階_過年度(),
                reportEntity.get人数_1段階_合計(),
                reportEntity.get人数_1段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_2段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_2段階_Title(),
                reportEntity.get人数_2段階_4月(),
                reportEntity.get人数_2段階_5月(),
                reportEntity.get人数_2段階_6月(),
                reportEntity.get人数_2段階_7月(),
                reportEntity.get人数_2段階_8月(),
                reportEntity.get人数_2段階_9月(),
                reportEntity.get人数_2段階_10月(),
                reportEntity.get人数_2段階_11月(),
                reportEntity.get人数_2段階_12月(),
                reportEntity.get人数_2段階_1月(),
                reportEntity.get人数_2段階_2月(),
                reportEntity.get人数_2段階_3月(),
                reportEntity.get人数_2段階_現年随時(),
                reportEntity.get人数_2段階_過年度(),
                reportEntity.get人数_2段階_合計(),
                reportEntity.get人数_2段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_3段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_3段階_Title(),
                reportEntity.get人数_3段階_4月(),
                reportEntity.get人数_3段階_5月(),
                reportEntity.get人数_3段階_6月(),
                reportEntity.get人数_3段階_7月(),
                reportEntity.get人数_3段階_8月(),
                reportEntity.get人数_3段階_9月(),
                reportEntity.get人数_3段階_10月(),
                reportEntity.get人数_3段階_11月(),
                reportEntity.get人数_3段階_12月(),
                reportEntity.get人数_3段階_1月(),
                reportEntity.get人数_3段階_2月(),
                reportEntity.get人数_3段階_3月(),
                reportEntity.get人数_3段階_現年随時(),
                reportEntity.get人数_3段階_過年度(),
                reportEntity.get人数_3段階_合計(),
                reportEntity.get人数_3段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_4段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_4段階_Title(),
                reportEntity.get人数_4段階_4月(),
                reportEntity.get人数_4段階_5月(),
                reportEntity.get人数_4段階_6月(),
                reportEntity.get人数_4段階_7月(),
                reportEntity.get人数_4段階_8月(),
                reportEntity.get人数_4段階_9月(),
                reportEntity.get人数_4段階_10月(),
                reportEntity.get人数_4段階_11月(),
                reportEntity.get人数_4段階_12月(),
                reportEntity.get人数_4段階_1月(),
                reportEntity.get人数_4段階_2月(),
                reportEntity.get人数_4段階_3月(),
                reportEntity.get人数_4段階_現年随時(),
                reportEntity.get人数_4段階_過年度(),
                reportEntity.get人数_4段階_合計(),
                reportEntity.get人数_4段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_5段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_5段階_Title(),
                reportEntity.get人数_5段階_4月(),
                reportEntity.get人数_5段階_5月(),
                reportEntity.get人数_5段階_6月(),
                reportEntity.get人数_5段階_7月(),
                reportEntity.get人数_5段階_8月(),
                reportEntity.get人数_5段階_9月(),
                reportEntity.get人数_5段階_10月(),
                reportEntity.get人数_5段階_11月(),
                reportEntity.get人数_5段階_12月(),
                reportEntity.get人数_5段階_1月(),
                reportEntity.get人数_5段階_2月(),
                reportEntity.get人数_5段階_3月(),
                reportEntity.get人数_5段階_現年随時(),
                reportEntity.get人数_5段階_過年度(),
                reportEntity.get人数_5段階_合計(),
                reportEntity.get人数_5段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_6段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_6段階_Title(),
                reportEntity.get人数_6段階_4月(),
                reportEntity.get人数_6段階_5月(),
                reportEntity.get人数_6段階_6月(),
                reportEntity.get人数_6段階_7月(),
                reportEntity.get人数_6段階_8月(),
                reportEntity.get人数_6段階_9月(),
                reportEntity.get人数_6段階_10月(),
                reportEntity.get人数_6段階_11月(),
                reportEntity.get人数_6段階_12月(),
                reportEntity.get人数_6段階_1月(),
                reportEntity.get人数_6段階_2月(),
                reportEntity.get人数_6段階_3月(),
                reportEntity.get人数_6段階_現年随時(),
                reportEntity.get人数_6段階_過年度(),
                reportEntity.get人数_6段階_合計(),
                reportEntity.get人数_6段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_7段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_7段階_Title(),
                reportEntity.get人数_7段階_4月(),
                reportEntity.get人数_7段階_5月(),
                reportEntity.get人数_7段階_6月(),
                reportEntity.get人数_7段階_7月(),
                reportEntity.get人数_7段階_8月(),
                reportEntity.get人数_7段階_9月(),
                reportEntity.get人数_7段階_10月(),
                reportEntity.get人数_7段階_11月(),
                reportEntity.get人数_7段階_12月(),
                reportEntity.get人数_7段階_1月(),
                reportEntity.get人数_7段階_2月(),
                reportEntity.get人数_7段階_3月(),
                reportEntity.get人数_7段階_現年随時(),
                reportEntity.get人数_7段階_過年度(),
                reportEntity.get人数_7段階_合計(),
                reportEntity.get人数_7段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_8段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_8段階_Title(),
                reportEntity.get人数_8段階_4月(),
                reportEntity.get人数_8段階_5月(),
                reportEntity.get人数_8段階_6月(),
                reportEntity.get人数_8段階_7月(),
                reportEntity.get人数_8段階_8月(),
                reportEntity.get人数_8段階_9月(),
                reportEntity.get人数_8段階_10月(),
                reportEntity.get人数_8段階_11月(),
                reportEntity.get人数_8段階_12月(),
                reportEntity.get人数_8段階_1月(),
                reportEntity.get人数_8段階_2月(),
                reportEntity.get人数_8段階_3月(),
                reportEntity.get人数_8段階_現年随時(),
                reportEntity.get人数_8段階_過年度(),
                reportEntity.get人数_8段階_合計(),
                reportEntity.get人数_8段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_9段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_9段階_Title(),
                reportEntity.get人数_9段階_4月(),
                reportEntity.get人数_9段階_5月(),
                reportEntity.get人数_9段階_6月(),
                reportEntity.get人数_9段階_7月(),
                reportEntity.get人数_9段階_8月(),
                reportEntity.get人数_9段階_9月(),
                reportEntity.get人数_9段階_10月(),
                reportEntity.get人数_9段階_11月(),
                reportEntity.get人数_9段階_12月(),
                reportEntity.get人数_9段階_1月(),
                reportEntity.get人数_9段階_2月(),
                reportEntity.get人数_9段階_3月(),
                reportEntity.get人数_9段階_現年随時(),
                reportEntity.get人数_9段階_過年度(),
                reportEntity.get人数_9段階_合計(),
                reportEntity.get人数_9段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_10段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_10段階_Title(),
                reportEntity.get人数_10段階_4月(),
                reportEntity.get人数_10段階_5月(),
                reportEntity.get人数_10段階_6月(),
                reportEntity.get人数_10段階_7月(),
                reportEntity.get人数_10段階_8月(),
                reportEntity.get人数_10段階_9月(),
                reportEntity.get人数_10段階_10月(),
                reportEntity.get人数_10段階_11月(),
                reportEntity.get人数_10段階_12月(),
                reportEntity.get人数_10段階_1月(),
                reportEntity.get人数_10段階_2月(),
                reportEntity.get人数_10段階_3月(),
                reportEntity.get人数_10段階_現年随時(),
                reportEntity.get人数_10段階_過年度(),
                reportEntity.get人数_10段階_合計(),
                reportEntity.get人数_10段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_11段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_11段階_Title(),
                reportEntity.get人数_11段階_4月(),
                reportEntity.get人数_11段階_5月(),
                reportEntity.get人数_11段階_6月(),
                reportEntity.get人数_11段階_7月(),
                reportEntity.get人数_11段階_8月(),
                reportEntity.get人数_11段階_9月(),
                reportEntity.get人数_11段階_10月(),
                reportEntity.get人数_11段階_11月(),
                reportEntity.get人数_11段階_12月(),
                reportEntity.get人数_11段階_1月(),
                reportEntity.get人数_11段階_2月(),
                reportEntity.get人数_11段階_3月(),
                reportEntity.get人数_11段階_現年随時(),
                reportEntity.get人数_11段階_過年度(),
                reportEntity.get人数_11段階_合計(),
                reportEntity.get人数_11段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_12段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_12段階_Title(),
                reportEntity.get人数_12段階_4月(),
                reportEntity.get人数_12段階_5月(),
                reportEntity.get人数_12段階_6月(),
                reportEntity.get人数_12段階_7月(),
                reportEntity.get人数_12段階_8月(),
                reportEntity.get人数_12段階_9月(),
                reportEntity.get人数_12段階_10月(),
                reportEntity.get人数_12段階_11月(),
                reportEntity.get人数_12段階_12月(),
                reportEntity.get人数_12段階_1月(),
                reportEntity.get人数_12段階_2月(),
                reportEntity.get人数_12段階_3月(),
                reportEntity.get人数_12段階_現年随時(),
                reportEntity.get人数_12段階_過年度(),
                reportEntity.get人数_12段階_合計(),
                reportEntity.get人数_12段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_13段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_13段階_Title(),
                reportEntity.get人数_13段階_4月(),
                reportEntity.get人数_13段階_5月(),
                reportEntity.get人数_13段階_6月(),
                reportEntity.get人数_13段階_7月(),
                reportEntity.get人数_13段階_8月(),
                reportEntity.get人数_13段階_9月(),
                reportEntity.get人数_13段階_10月(),
                reportEntity.get人数_13段階_11月(),
                reportEntity.get人数_13段階_12月(),
                reportEntity.get人数_13段階_1月(),
                reportEntity.get人数_13段階_2月(),
                reportEntity.get人数_13段階_3月(),
                reportEntity.get人数_13段階_現年随時(),
                reportEntity.get人数_13段階_過年度(),
                reportEntity.get人数_13段階_合計(),
                reportEntity.get人数_13段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_14段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_14段階_Title(),
                reportEntity.get人数_14段階_4月(),
                reportEntity.get人数_14段階_5月(),
                reportEntity.get人数_14段階_6月(),
                reportEntity.get人数_14段階_7月(),
                reportEntity.get人数_14段階_8月(),
                reportEntity.get人数_14段階_9月(),
                reportEntity.get人数_14段階_10月(),
                reportEntity.get人数_14段階_11月(),
                reportEntity.get人数_14段階_12月(),
                reportEntity.get人数_14段階_1月(),
                reportEntity.get人数_14段階_2月(),
                reportEntity.get人数_14段階_3月(),
                reportEntity.get人数_14段階_現年随時(),
                reportEntity.get人数_14段階_過年度(),
                reportEntity.get人数_14段階_合計(),
                reportEntity.get人数_14段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_15段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_15段階_Title(),
                reportEntity.get人数_15段階_4月(),
                reportEntity.get人数_15段階_5月(),
                reportEntity.get人数_15段階_6月(),
                reportEntity.get人数_15段階_7月(),
                reportEntity.get人数_15段階_8月(),
                reportEntity.get人数_15段階_9月(),
                reportEntity.get人数_15段階_10月(),
                reportEntity.get人数_15段階_11月(),
                reportEntity.get人数_15段階_12月(),
                reportEntity.get人数_15段階_1月(),
                reportEntity.get人数_15段階_2月(),
                reportEntity.get人数_15段階_3月(),
                reportEntity.get人数_15段階_現年随時(),
                reportEntity.get人数_15段階_過年度(),
                reportEntity.get人数_15段階_合計(),
                reportEntity.get人数_15段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_16段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_16段階_Title(),
                reportEntity.get人数_16段階_4月(),
                reportEntity.get人数_16段階_5月(),
                reportEntity.get人数_16段階_6月(),
                reportEntity.get人数_16段階_7月(),
                reportEntity.get人数_16段階_8月(),
                reportEntity.get人数_16段階_9月(),
                reportEntity.get人数_16段階_10月(),
                reportEntity.get人数_16段階_11月(),
                reportEntity.get人数_16段階_12月(),
                reportEntity.get人数_16段階_1月(),
                reportEntity.get人数_16段階_2月(),
                reportEntity.get人数_16段階_3月(),
                reportEntity.get人数_16段階_現年随時(),
                reportEntity.get人数_16段階_過年度(),
                reportEntity.get人数_16段階_合計(),
                reportEntity.get人数_16段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_17段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_17段階_Title(),
                reportEntity.get人数_17段階_4月(),
                reportEntity.get人数_17段階_5月(),
                reportEntity.get人数_17段階_6月(),
                reportEntity.get人数_17段階_7月(),
                reportEntity.get人数_17段階_8月(),
                reportEntity.get人数_17段階_9月(),
                reportEntity.get人数_17段階_10月(),
                reportEntity.get人数_17段階_11月(),
                reportEntity.get人数_17段階_12月(),
                reportEntity.get人数_17段階_1月(),
                reportEntity.get人数_17段階_2月(),
                reportEntity.get人数_17段階_3月(),
                reportEntity.get人数_17段階_現年随時(),
                reportEntity.get人数_17段階_過年度(),
                reportEntity.get人数_17段階_合計(),
                reportEntity.get人数_17段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_18段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_18段階_Title(),
                reportEntity.get人数_18段階_4月(),
                reportEntity.get人数_18段階_5月(),
                reportEntity.get人数_18段階_6月(),
                reportEntity.get人数_18段階_7月(),
                reportEntity.get人数_18段階_8月(),
                reportEntity.get人数_18段階_9月(),
                reportEntity.get人数_18段階_10月(),
                reportEntity.get人数_18段階_11月(),
                reportEntity.get人数_18段階_12月(),
                reportEntity.get人数_18段階_1月(),
                reportEntity.get人数_18段階_2月(),
                reportEntity.get人数_18段階_3月(),
                reportEntity.get人数_18段階_現年随時(),
                reportEntity.get人数_18段階_過年度(),
                reportEntity.get人数_18段階_合計(),
                reportEntity.get人数_18段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_19段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_19段階_Title(),
                reportEntity.get人数_19段階_4月(),
                reportEntity.get人数_19段階_5月(),
                reportEntity.get人数_19段階_6月(),
                reportEntity.get人数_19段階_7月(),
                reportEntity.get人数_19段階_8月(),
                reportEntity.get人数_19段階_9月(),
                reportEntity.get人数_19段階_10月(),
                reportEntity.get人数_19段階_11月(),
                reportEntity.get人数_19段階_12月(),
                reportEntity.get人数_19段階_1月(),
                reportEntity.get人数_19段階_2月(),
                reportEntity.get人数_19段階_3月(),
                reportEntity.get人数_19段階_現年随時(),
                reportEntity.get人数_19段階_過年度(),
                reportEntity.get人数_19段階_合計(),
                reportEntity.get人数_19段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_20段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_20段階_Title(),
                reportEntity.get人数_20段階_4月(),
                reportEntity.get人数_20段階_5月(),
                reportEntity.get人数_20段階_6月(),
                reportEntity.get人数_20段階_7月(),
                reportEntity.get人数_20段階_8月(),
                reportEntity.get人数_20段階_9月(),
                reportEntity.get人数_20段階_10月(),
                reportEntity.get人数_20段階_11月(),
                reportEntity.get人数_20段階_12月(),
                reportEntity.get人数_20段階_1月(),
                reportEntity.get人数_20段階_2月(),
                reportEntity.get人数_20段階_3月(),
                reportEntity.get人数_20段階_現年随時(),
                reportEntity.get人数_20段階_過年度(),
                reportEntity.get人数_20段階_合計(),
                reportEntity.get人数_20段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_21段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_21段階_Title(),
                reportEntity.get人数_21段階_4月(),
                reportEntity.get人数_21段階_5月(),
                reportEntity.get人数_21段階_6月(),
                reportEntity.get人数_21段階_7月(),
                reportEntity.get人数_21段階_8月(),
                reportEntity.get人数_21段階_9月(),
                reportEntity.get人数_21段階_10月(),
                reportEntity.get人数_21段階_11月(),
                reportEntity.get人数_21段階_12月(),
                reportEntity.get人数_21段階_1月(),
                reportEntity.get人数_21段階_2月(),
                reportEntity.get人数_21段階_3月(),
                reportEntity.get人数_21段階_現年随時(),
                reportEntity.get人数_21段階_過年度(),
                reportEntity.get人数_21段階_合計(),
                reportEntity.get人数_21段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get人数_合計() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get人数_合計_Title(),
                reportEntity.get人数_合計_4月(),
                reportEntity.get人数_合計_5月(),
                reportEntity.get人数_合計_6月(),
                reportEntity.get人数_合計_7月(),
                reportEntity.get人数_合計_8月(),
                reportEntity.get人数_合計_9月(),
                reportEntity.get人数_合計_10月(),
                reportEntity.get人数_合計_11月(),
                reportEntity.get人数_合計_12月(),
                reportEntity.get人数_合計_1月(),
                reportEntity.get人数_合計_2月(),
                reportEntity.get人数_合計_3月(),
                reportEntity.get人数_合計_現年随時(),
                reportEntity.get人数_合計_過年度(),
                reportEntity.get人数_合計_合計(),
                reportEntity.get人数_合計_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_1段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_1段階_Title(),
                reportEntity.get金額_1段階_4月(),
                reportEntity.get金額_1段階_5月(),
                reportEntity.get金額_1段階_6月(),
                reportEntity.get金額_1段階_7月(),
                reportEntity.get金額_1段階_8月(),
                reportEntity.get金額_1段階_9月(),
                reportEntity.get金額_1段階_10月(),
                reportEntity.get金額_1段階_11月(),
                reportEntity.get金額_1段階_12月(),
                reportEntity.get金額_1段階_1月(),
                reportEntity.get金額_1段階_2月(),
                reportEntity.get金額_1段階_3月(),
                reportEntity.get金額_1段階_現年随時(),
                reportEntity.get金額_1段階_過年度(),
                reportEntity.get金額_1段階_合計(),
                reportEntity.get金額_1段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_2段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_2段階_Title(),
                reportEntity.get金額_2段階_4月(),
                reportEntity.get金額_2段階_5月(),
                reportEntity.get金額_2段階_6月(),
                reportEntity.get金額_2段階_7月(),
                reportEntity.get金額_2段階_8月(),
                reportEntity.get金額_2段階_9月(),
                reportEntity.get金額_2段階_10月(),
                reportEntity.get金額_2段階_11月(),
                reportEntity.get金額_2段階_12月(),
                reportEntity.get金額_2段階_1月(),
                reportEntity.get金額_2段階_2月(),
                reportEntity.get金額_2段階_3月(),
                reportEntity.get金額_2段階_現年随時(),
                reportEntity.get金額_2段階_過年度(),
                reportEntity.get金額_2段階_合計(),
                reportEntity.get金額_2段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_3段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_3段階_Title(),
                reportEntity.get金額_3段階_4月(),
                reportEntity.get金額_3段階_5月(),
                reportEntity.get金額_3段階_6月(),
                reportEntity.get金額_3段階_7月(),
                reportEntity.get金額_3段階_8月(),
                reportEntity.get金額_3段階_9月(),
                reportEntity.get金額_3段階_10月(),
                reportEntity.get金額_3段階_11月(),
                reportEntity.get金額_3段階_12月(),
                reportEntity.get金額_3段階_1月(),
                reportEntity.get金額_3段階_2月(),
                reportEntity.get金額_3段階_3月(),
                reportEntity.get金額_3段階_現年随時(),
                reportEntity.get金額_3段階_過年度(),
                reportEntity.get金額_3段階_合計(),
                reportEntity.get金額_3段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_4段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_4段階_Title(),
                reportEntity.get金額_4段階_4月(),
                reportEntity.get金額_4段階_5月(),
                reportEntity.get金額_4段階_6月(),
                reportEntity.get金額_4段階_7月(),
                reportEntity.get金額_4段階_8月(),
                reportEntity.get金額_4段階_9月(),
                reportEntity.get金額_4段階_10月(),
                reportEntity.get金額_4段階_11月(),
                reportEntity.get金額_4段階_12月(),
                reportEntity.get金額_4段階_1月(),
                reportEntity.get金額_4段階_2月(),
                reportEntity.get金額_4段階_3月(),
                reportEntity.get金額_4段階_現年随時(),
                reportEntity.get金額_4段階_過年度(),
                reportEntity.get金額_4段階_合計(),
                reportEntity.get金額_4段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_5段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_5段階_Title(),
                reportEntity.get金額_5段階_4月(),
                reportEntity.get金額_5段階_5月(),
                reportEntity.get金額_5段階_6月(),
                reportEntity.get金額_5段階_7月(),
                reportEntity.get金額_5段階_8月(),
                reportEntity.get金額_5段階_9月(),
                reportEntity.get金額_5段階_10月(),
                reportEntity.get金額_5段階_11月(),
                reportEntity.get金額_5段階_12月(),
                reportEntity.get金額_5段階_1月(),
                reportEntity.get金額_5段階_2月(),
                reportEntity.get金額_5段階_3月(),
                reportEntity.get金額_5段階_現年随時(),
                reportEntity.get金額_5段階_過年度(),
                reportEntity.get金額_5段階_合計(),
                reportEntity.get金額_5段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_6段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_6段階_Title(),
                reportEntity.get金額_6段階_4月(),
                reportEntity.get金額_6段階_5月(),
                reportEntity.get金額_6段階_6月(),
                reportEntity.get金額_6段階_7月(),
                reportEntity.get金額_6段階_8月(),
                reportEntity.get金額_6段階_9月(),
                reportEntity.get金額_6段階_10月(),
                reportEntity.get金額_6段階_11月(),
                reportEntity.get金額_6段階_12月(),
                reportEntity.get金額_6段階_1月(),
                reportEntity.get金額_6段階_2月(),
                reportEntity.get金額_6段階_3月(),
                reportEntity.get金額_6段階_現年随時(),
                reportEntity.get金額_6段階_過年度(),
                reportEntity.get金額_6段階_合計(),
                reportEntity.get金額_6段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_7段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_7段階_Title(),
                reportEntity.get金額_7段階_4月(),
                reportEntity.get金額_7段階_5月(),
                reportEntity.get金額_7段階_6月(),
                reportEntity.get金額_7段階_7月(),
                reportEntity.get金額_7段階_8月(),
                reportEntity.get金額_7段階_9月(),
                reportEntity.get金額_7段階_10月(),
                reportEntity.get金額_7段階_11月(),
                reportEntity.get金額_7段階_12月(),
                reportEntity.get金額_7段階_1月(),
                reportEntity.get金額_7段階_2月(),
                reportEntity.get金額_7段階_3月(),
                reportEntity.get金額_7段階_現年随時(),
                reportEntity.get金額_7段階_過年度(),
                reportEntity.get金額_7段階_合計(),
                reportEntity.get金額_7段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_8段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_8段階_Title(),
                reportEntity.get金額_8段階_4月(),
                reportEntity.get金額_8段階_5月(),
                reportEntity.get金額_8段階_6月(),
                reportEntity.get金額_8段階_7月(),
                reportEntity.get金額_8段階_8月(),
                reportEntity.get金額_8段階_9月(),
                reportEntity.get金額_8段階_10月(),
                reportEntity.get金額_8段階_11月(),
                reportEntity.get金額_8段階_12月(),
                reportEntity.get金額_8段階_1月(),
                reportEntity.get金額_8段階_2月(),
                reportEntity.get金額_8段階_3月(),
                reportEntity.get金額_8段階_現年随時(),
                reportEntity.get金額_8段階_過年度(),
                reportEntity.get金額_8段階_合計(),
                reportEntity.get金額_8段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_9段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_9段階_Title(),
                reportEntity.get金額_9段階_4月(),
                reportEntity.get金額_9段階_5月(),
                reportEntity.get金額_9段階_6月(),
                reportEntity.get金額_9段階_7月(),
                reportEntity.get金額_9段階_8月(),
                reportEntity.get金額_9段階_9月(),
                reportEntity.get金額_9段階_10月(),
                reportEntity.get金額_9段階_11月(),
                reportEntity.get金額_9段階_12月(),
                reportEntity.get金額_9段階_1月(),
                reportEntity.get金額_9段階_2月(),
                reportEntity.get金額_9段階_3月(),
                reportEntity.get金額_9段階_現年随時(),
                reportEntity.get金額_9段階_過年度(),
                reportEntity.get金額_9段階_合計(),
                reportEntity.get金額_9段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_10段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_10段階_Title(),
                reportEntity.get金額_10段階_4月(),
                reportEntity.get金額_10段階_5月(),
                reportEntity.get金額_10段階_6月(),
                reportEntity.get金額_10段階_7月(),
                reportEntity.get金額_10段階_8月(),
                reportEntity.get金額_10段階_9月(),
                reportEntity.get金額_10段階_10月(),
                reportEntity.get金額_10段階_11月(),
                reportEntity.get金額_10段階_12月(),
                reportEntity.get金額_10段階_1月(),
                reportEntity.get金額_10段階_2月(),
                reportEntity.get金額_10段階_3月(),
                reportEntity.get金額_10段階_現年随時(),
                reportEntity.get金額_10段階_過年度(),
                reportEntity.get金額_10段階_合計(),
                reportEntity.get金額_10段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_11段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_11段階_Title(),
                reportEntity.get金額_11段階_4月(),
                reportEntity.get金額_11段階_5月(),
                reportEntity.get金額_11段階_6月(),
                reportEntity.get金額_11段階_7月(),
                reportEntity.get金額_11段階_8月(),
                reportEntity.get金額_11段階_9月(),
                reportEntity.get金額_11段階_10月(),
                reportEntity.get金額_11段階_11月(),
                reportEntity.get金額_11段階_12月(),
                reportEntity.get金額_11段階_1月(),
                reportEntity.get金額_11段階_2月(),
                reportEntity.get金額_11段階_3月(),
                reportEntity.get金額_11段階_現年随時(),
                reportEntity.get金額_11段階_過年度(),
                reportEntity.get金額_11段階_合計(),
                reportEntity.get金額_11段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_12段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_12段階_Title(),
                reportEntity.get金額_12段階_4月(),
                reportEntity.get金額_12段階_5月(),
                reportEntity.get金額_12段階_6月(),
                reportEntity.get金額_12段階_7月(),
                reportEntity.get金額_12段階_8月(),
                reportEntity.get金額_12段階_9月(),
                reportEntity.get金額_12段階_10月(),
                reportEntity.get金額_12段階_11月(),
                reportEntity.get金額_12段階_12月(),
                reportEntity.get金額_12段階_1月(),
                reportEntity.get金額_12段階_2月(),
                reportEntity.get金額_12段階_3月(),
                reportEntity.get金額_12段階_現年随時(),
                reportEntity.get金額_12段階_過年度(),
                reportEntity.get金額_12段階_合計(),
                reportEntity.get金額_12段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_13段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_13段階_Title(),
                reportEntity.get金額_13段階_4月(),
                reportEntity.get金額_13段階_5月(),
                reportEntity.get金額_13段階_6月(),
                reportEntity.get金額_13段階_7月(),
                reportEntity.get金額_13段階_8月(),
                reportEntity.get金額_13段階_9月(),
                reportEntity.get金額_13段階_10月(),
                reportEntity.get金額_13段階_11月(),
                reportEntity.get金額_13段階_12月(),
                reportEntity.get金額_13段階_1月(),
                reportEntity.get金額_13段階_2月(),
                reportEntity.get金額_13段階_3月(),
                reportEntity.get金額_13段階_現年随時(),
                reportEntity.get金額_13段階_過年度(),
                reportEntity.get金額_13段階_合計(),
                reportEntity.get金額_13段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_14段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_14段階_Title(),
                reportEntity.get金額_14段階_4月(),
                reportEntity.get金額_14段階_5月(),
                reportEntity.get金額_14段階_6月(),
                reportEntity.get金額_14段階_7月(),
                reportEntity.get金額_14段階_8月(),
                reportEntity.get金額_14段階_9月(),
                reportEntity.get金額_14段階_10月(),
                reportEntity.get金額_14段階_11月(),
                reportEntity.get金額_14段階_12月(),
                reportEntity.get金額_14段階_1月(),
                reportEntity.get金額_14段階_2月(),
                reportEntity.get金額_14段階_3月(),
                reportEntity.get金額_14段階_現年随時(),
                reportEntity.get金額_14段階_過年度(),
                reportEntity.get金額_14段階_合計(),
                reportEntity.get金額_14段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_15段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_15段階_Title(),
                reportEntity.get金額_15段階_4月(),
                reportEntity.get金額_15段階_5月(),
                reportEntity.get金額_15段階_6月(),
                reportEntity.get金額_15段階_7月(),
                reportEntity.get金額_15段階_8月(),
                reportEntity.get金額_15段階_9月(),
                reportEntity.get金額_15段階_10月(),
                reportEntity.get金額_15段階_11月(),
                reportEntity.get金額_15段階_12月(),
                reportEntity.get金額_15段階_1月(),
                reportEntity.get金額_15段階_2月(),
                reportEntity.get金額_15段階_3月(),
                reportEntity.get金額_15段階_現年随時(),
                reportEntity.get金額_15段階_過年度(),
                reportEntity.get金額_15段階_合計(),
                reportEntity.get金額_15段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_16段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_16段階_Title(),
                reportEntity.get金額_16段階_4月(),
                reportEntity.get金額_16段階_5月(),
                reportEntity.get金額_16段階_6月(),
                reportEntity.get金額_16段階_7月(),
                reportEntity.get金額_16段階_8月(),
                reportEntity.get金額_16段階_9月(),
                reportEntity.get金額_16段階_10月(),
                reportEntity.get金額_16段階_11月(),
                reportEntity.get金額_16段階_12月(),
                reportEntity.get金額_16段階_1月(),
                reportEntity.get金額_16段階_2月(),
                reportEntity.get金額_16段階_3月(),
                reportEntity.get金額_16段階_現年随時(),
                reportEntity.get金額_16段階_過年度(),
                reportEntity.get金額_16段階_合計(),
                reportEntity.get金額_16段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_17段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_17段階_Title(),
                reportEntity.get金額_17段階_4月(),
                reportEntity.get金額_17段階_5月(),
                reportEntity.get金額_17段階_6月(),
                reportEntity.get金額_17段階_7月(),
                reportEntity.get金額_17段階_8月(),
                reportEntity.get金額_17段階_9月(),
                reportEntity.get金額_17段階_10月(),
                reportEntity.get金額_17段階_11月(),
                reportEntity.get金額_17段階_12月(),
                reportEntity.get金額_17段階_1月(),
                reportEntity.get金額_17段階_2月(),
                reportEntity.get金額_17段階_3月(),
                reportEntity.get金額_17段階_現年随時(),
                reportEntity.get金額_17段階_過年度(),
                reportEntity.get金額_17段階_合計(),
                reportEntity.get金額_17段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_18段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_18段階_Title(),
                reportEntity.get金額_18段階_4月(),
                reportEntity.get金額_18段階_5月(),
                reportEntity.get金額_18段階_6月(),
                reportEntity.get金額_18段階_7月(),
                reportEntity.get金額_18段階_8月(),
                reportEntity.get金額_18段階_9月(),
                reportEntity.get金額_18段階_10月(),
                reportEntity.get金額_18段階_11月(),
                reportEntity.get金額_18段階_12月(),
                reportEntity.get金額_18段階_1月(),
                reportEntity.get金額_18段階_2月(),
                reportEntity.get金額_18段階_3月(),
                reportEntity.get金額_18段階_現年随時(),
                reportEntity.get金額_18段階_過年度(),
                reportEntity.get金額_18段階_合計(),
                reportEntity.get金額_18段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_19段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_19段階_Title(),
                reportEntity.get金額_19段階_4月(),
                reportEntity.get金額_19段階_5月(),
                reportEntity.get金額_19段階_6月(),
                reportEntity.get金額_19段階_7月(),
                reportEntity.get金額_19段階_8月(),
                reportEntity.get金額_19段階_9月(),
                reportEntity.get金額_19段階_10月(),
                reportEntity.get金額_19段階_11月(),
                reportEntity.get金額_19段階_12月(),
                reportEntity.get金額_19段階_1月(),
                reportEntity.get金額_19段階_2月(),
                reportEntity.get金額_19段階_3月(),
                reportEntity.get金額_19段階_現年随時(),
                reportEntity.get金額_19段階_過年度(),
                reportEntity.get金額_19段階_合計(),
                reportEntity.get金額_19段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_20段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_20段階_Title(),
                reportEntity.get金額_20段階_4月(),
                reportEntity.get金額_20段階_5月(),
                reportEntity.get金額_20段階_6月(),
                reportEntity.get金額_20段階_7月(),
                reportEntity.get金額_20段階_8月(),
                reportEntity.get金額_20段階_9月(),
                reportEntity.get金額_20段階_10月(),
                reportEntity.get金額_20段階_11月(),
                reportEntity.get金額_20段階_12月(),
                reportEntity.get金額_20段階_1月(),
                reportEntity.get金額_20段階_2月(),
                reportEntity.get金額_20段階_3月(),
                reportEntity.get金額_20段階_現年随時(),
                reportEntity.get金額_20段階_過年度(),
                reportEntity.get金額_20段階_合計(),
                reportEntity.get金額_20段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_21段階() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_21段階_Title(),
                reportEntity.get金額_21段階_4月(),
                reportEntity.get金額_21段階_5月(),
                reportEntity.get金額_21段階_6月(),
                reportEntity.get金額_21段階_7月(),
                reportEntity.get金額_21段階_8月(),
                reportEntity.get金額_21段階_9月(),
                reportEntity.get金額_21段階_10月(),
                reportEntity.get金額_21段階_11月(),
                reportEntity.get金額_21段階_12月(),
                reportEntity.get金額_21段階_1月(),
                reportEntity.get金額_21段階_2月(),
                reportEntity.get金額_21段階_3月(),
                reportEntity.get金額_21段階_現年随時(),
                reportEntity.get金額_21段階_過年度(),
                reportEntity.get金額_21段階_合計(),
                reportEntity.get金額_21段階_歳出還付());
    }

    private TsukibetsuSuiihyoBody get金額_合計() {
        return new TsukibetsuSuiihyoBody(
                reportEntity.get金額_合計_Title(),
                reportEntity.get金額_合計_4月(),
                reportEntity.get金額_合計_5月(),
                reportEntity.get金額_合計_6月(),
                reportEntity.get金額_合計_7月(),
                reportEntity.get金額_合計_8月(),
                reportEntity.get金額_合計_9月(),
                reportEntity.get金額_合計_10月(),
                reportEntity.get金額_合計_11月(),
                reportEntity.get金額_合計_12月(),
                reportEntity.get金額_合計_1月(),
                reportEntity.get金額_合計_2月(),
                reportEntity.get金額_合計_3月(),
                reportEntity.get金額_合計_現年随時(),
                reportEntity.get金額_合計_過年度(),
                reportEntity.get金額_合計_合計(),
                reportEntity.get金額_合計_歳出還付());
    }
}
