/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 納入通知書関連クラス継承する抽象クラスです。
 *
 * @param <T>
 */
public abstract class INonyuTsuchisho<T extends IReportSource> {

    /**
     * writeByメソッド
     *
     * @param writer writer
     */
    public abstract void writeBy(ReportSourceWriter<T> writer);

    /**
     * devidedByPageメソッド
     *
     * @return List<NonyuTsuchisho>
     */
    public abstract List<INonyuTsuchisho> devidedByPage();
}
