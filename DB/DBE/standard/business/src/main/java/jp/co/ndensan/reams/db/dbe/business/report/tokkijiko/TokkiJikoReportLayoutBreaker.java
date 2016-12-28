/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkijiko;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkijiko.TokkiJikoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.LayoutBreaker;

/**
 * 特記事項帳票のLayoutBreakerクラスです。
 */
public class TokkiJikoReportLayoutBreaker extends LayoutBreaker<TokkiJikoReportSource> {

    private static final List<RString> LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(TokkiJikoReportSource.ReportSourceFields.tokkiImg.name()),
            new RString(TokkiJikoReportSource.ReportSourceFields.tokkiText1.name()),
            new RString(TokkiJikoReportSource.ReportSourceFields.tokkiImg1.name())));
    private static final int FORM_INDEX_テキスト短冊 = 1;
    private static final int FORM_INDEX_テキスト短冊_2頁目以降 = 2;
    private static final int FORM_INDEX_イメージ全面 = 3;
    private static final int FORM_INDEX_イメージ全面_2頁目以降 = 4;
    private static final int FORM_INDEX_イメージ短冊 = 5;
    private static final int FORM_INDEX_イメージ短冊_2頁目以降 = 6;

    @Override
    public List<RString> breakKeys() {
        return LAYOUT_BREAK_KEYS;
    }

    @Override
    public ReportLineRecord<TokkiJikoReportSource> occuredBreak(ReportLineRecord<TokkiJikoReportSource> currentRecord,
            ReportLineRecord<TokkiJikoReportSource> nextRecord,
            ReportDynamicChart dynamicChart) {
        boolean isCurrent2頁目以降 = currentRecord.getFormGroupIndex() == FORM_INDEX_テキスト短冊_2頁目以降
                || currentRecord.getFormGroupIndex() == FORM_INDEX_イメージ全面_2頁目以降
                || currentRecord.getFormGroupIndex() == FORM_INDEX_イメージ短冊_2頁目以降;
        currentRecord.setFormGroupIndex(getFormIndex(currentRecord.getSource(), isCurrent2頁目以降));
        if (nextRecord != null && nextRecord.getSource() != null) {
            boolean isNext2頁目以降 = !is被保険者Break(currentRecord.getSource(), nextRecord.getSource());
            nextRecord.setFormGroupIndex(getFormIndex(nextRecord.getSource(), isNext2頁目以降));
        }
        return currentRecord;
    }

    private int getFormIndex(TokkiJikoReportSource source, boolean is2頁目以降) {
        if (source.tokkiText1 != null && !source.tokkiText1.isEmpty()) {
            return !is2頁目以降 ? FORM_INDEX_テキスト短冊 : FORM_INDEX_テキスト短冊_2頁目以降;
        } else if (source.tokkiImg != null && !source.tokkiImg.isEmpty()) {
            return !is2頁目以降 ? FORM_INDEX_イメージ全面 : FORM_INDEX_イメージ全面_2頁目以降;
        } else if (source.tokkiImg1 != null && !source.tokkiImg1.isEmpty()) {
            return !is2頁目以降 ? FORM_INDEX_イメージ短冊 : FORM_INDEX_イメージ短冊_2頁目以降;
        }
        return FORM_INDEX_テキスト短冊;
    }

    private boolean is被保険者Break(TokkiJikoReportSource currentSource, TokkiJikoReportSource nextSource) {
        return !currentSource.hihokenshaNo.equals(nextSource.hihokenshaNo);
    }
}
