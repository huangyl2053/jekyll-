/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofuIchiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200046_総合事業費（経過措置）過誤申立書情報送付一覧表 Propertyクラスです。
 *
 * @reamsid_L DBC-2530-041 liuxiaoyu
 */
public class SogojigyohiKagoMoshitateshojohoSofuIchiranProperty
        extends ReportPropertyBase<SogojigyohiKagoMoshitateshojohoSofuIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public SogojigyohiKagoMoshitateshojohoSofuIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200046.getReportId());
    }
}
