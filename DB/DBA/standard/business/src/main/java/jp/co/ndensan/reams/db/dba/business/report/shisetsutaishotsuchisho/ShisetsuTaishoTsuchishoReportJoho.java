/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho;

/**
 * 介護保険住所地特例施設退所通知書_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuTaishoTsuchishoReportJoho {

    private final ShisetsuTaishoTsuchishoItem item;

    /**
     * コンストラクタを作成します。
     *
     * @param item 主介護保険住所地特例施設退所通知書情報item
     */
    public ShisetsuTaishoTsuchishoReportJoho(ShisetsuTaishoTsuchishoItem item) {
        this.item = item;
    }
}
