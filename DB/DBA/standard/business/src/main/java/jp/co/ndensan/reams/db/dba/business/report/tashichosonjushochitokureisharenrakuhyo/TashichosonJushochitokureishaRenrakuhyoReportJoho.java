/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo;

/**
 * 介護保険他市町村住所地特例者連絡票_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TashichosonJushochitokureishaRenrakuhyoReportJoho {

    private final TashichosonJushochitokureishaRenrakuhyoItem item;

    /**
     * コンストラクタを作成します。
     *
     * @param item 介護保険他市町村住所地特例者連絡票item
     */
    public TashichosonJushochitokureishaRenrakuhyoReportJoho(TashichosonJushochitokureishaRenrakuhyoItem item) {
        this.item = item;
    }
}
