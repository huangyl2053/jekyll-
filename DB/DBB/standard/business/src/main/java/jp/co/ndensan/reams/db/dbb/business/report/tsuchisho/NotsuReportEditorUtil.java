/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納入通知書のユーティリティクラスです。
 *
 * @reamsid_L DBB-9110-070 wangjie2
 */
public final class NotsuReportEditorUtil {

    private static final int INT_6 = 6;

    private NotsuReportEditorUtil() {

    }

    /**
     * 連番より納通連番を取得します。
     *
     * @param 連番 連番
     * @return 納通連番
     */
    public static RString get納通連番(int 連番) {
        return new RString("*").concat(new RString(連番).padLeft("0", INT_6)).concat("#");
    }

}
