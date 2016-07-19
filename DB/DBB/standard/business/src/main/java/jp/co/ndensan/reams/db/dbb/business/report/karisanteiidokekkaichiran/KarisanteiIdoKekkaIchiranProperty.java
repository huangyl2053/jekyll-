/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteiidokekkaichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP36001_2_仮算定異動（一括）結果一覧表のプロパティです。
 *
 * @reamsid_L DBB-0850-030 zhaowei
 */
public class KarisanteiIdoKekkaIchiranProperty extends ReportPropertyBase<KarisanteiIdoKekkaIchiranSource> {

    /**
     * コンストラクタです。
     */
    public KarisanteiIdoKekkaIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200013.getReportId());
    }

    /**
     * 改頁メソッド
     *
     * @param breakers Breakers<KarisanteiIdoKekkaIchiranSource>
     * @param catalog BreakerCatalog<KarisanteiIdoKekkaIchiranSource>
     * @return Breaker
     */
    @Override
    protected Breakers<KarisanteiIdoKekkaIchiranSource> defineBreakers(
            Breakers<KarisanteiIdoKekkaIchiranSource> breakers,
            BreakerCatalog<KarisanteiIdoKekkaIchiranSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

}
