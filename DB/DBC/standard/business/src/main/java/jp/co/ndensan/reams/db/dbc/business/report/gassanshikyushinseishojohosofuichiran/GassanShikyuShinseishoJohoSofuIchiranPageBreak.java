/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算支給申請書情報作成の帳票PageBreak
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public class GassanShikyuShinseishoJohoSofuIchiranPageBreak extends PageBreaker<GassanShikyuShinseishoJohoSofuIchiranSource> {

    private static final RString 固定改頁項目 = new RString("重複フラグ");
    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeysList List<RString>
     */
    public GassanShikyuShinseishoJohoSofuIchiranPageBreak(List<RString> breakKeysList) {
        this.breakKeysList = breakKeysList;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanShikyuShinseishoJohoSofuIchiranSource> currentSource,
            ReportLineRecord<GassanShikyuShinseishoJohoSofuIchiranSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(固定改頁項目)
                && !currentSource.getSource().list_16.equals(nextSource.getSource().list_16)) {
            flg = true;
        }
        return flg;
    }
}
