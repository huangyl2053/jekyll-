/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranSource.ReportSourceFields;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN32001_受領委任契約事業者一覧表帳票のプロパティです。
 *
 * @reamsid_L DBC-2110-040 liuxiaoyu
 */
public class JuryoIninJigyoshaIchiranProperty extends ReportPropertyBase<JuryoIninJigyoshaIchiranSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public JuryoIninJigyoshaIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200012.getReportId());

        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(ReportSourceFields.listUpper_1.name()));
        pageBreakKeys.add(new RString(ReportSourceFields.listUpper_2.name()));
        pageBreakKeys.add(new RString(ReportSourceFields.listUpper_5.name()));
        pageBreakKeys.add(new RString(ReportSourceFields.listLower_3.name()));
    }
}
