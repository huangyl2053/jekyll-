/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 納入通知書関連クラス継承する抽象クラスです。
 *
 * @param <T>
 *
 * @reamsid_L DBB-9999-023 huangh
 */
public abstract class NonyuTsuchisho<T extends IReportSource> extends Report<T> {

    /**
     * writeByメソッド
     *
     * @param writer writer
     */
    @Override
    public abstract void writeBy(ReportSourceWriter<T> writer);

    /**
     * devidedByPageメソッド
     *
     * @return List<INonyuTsuchisho>
     */
    public abstract List<NonyuTsuchisho<T>> devidedByPage();
}
