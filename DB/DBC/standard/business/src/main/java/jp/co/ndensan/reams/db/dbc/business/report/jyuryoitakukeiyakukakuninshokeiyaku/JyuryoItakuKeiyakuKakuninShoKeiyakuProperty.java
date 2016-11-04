/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakukeiyakukakuninshokeiyaku;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jyuryoitakukeiyakukakuninshokeiyaku.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN31003_介護保険受領委任契約承認（不承認）確認書（事業者用）帳票のプロパティです。
 *
 * @reamsid_L DBC-2130-060 liuxiaoyu
 */
public class JyuryoItakuKeiyakuKakuninShoKeiyakuProperty
        extends ReportPropertyBase<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> {

    /**
     * コンストラクタです。
     *
     */
    public JyuryoItakuKeiyakuKakuninShoKeiyakuProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100030.getReportId());
    }
}
