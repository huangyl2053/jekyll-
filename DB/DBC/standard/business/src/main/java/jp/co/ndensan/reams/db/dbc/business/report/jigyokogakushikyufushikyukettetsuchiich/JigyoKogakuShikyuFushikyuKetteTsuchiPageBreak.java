/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujigyoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoOutputOrder;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakushikyufushikyukettetsuchiichiran.JigyoKogakuShikyuFushikyuKetteTsuchiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票設計_DBCMN43002_事業高額支給不支給決定通知一覧表のPageBreak。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class JigyoKogakuShikyuFushikyuKetteTsuchiPageBreak extends PageBreaker<JigyoKogakuShikyuFushikyuKetteTsuchiSource> {

    private final List<RString> breakKeys;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public JigyoKogakuShikyuFushikyuKetteTsuchiPageBreak(List<RString> breakKeys) {
        this.breakKeys = breakKeys;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<JigyoKogakuShikyuFushikyuKetteTsuchiSource> currentSource,
            ReportLineRecord<JigyoKogakuShikyuFushikyuKetteTsuchiSource> nextSource) {
        boolean flg = false;
        if (this.breakKeys.contains(JigyoKogakuKetteiTsuchishoOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            flg = true;
        } else if (this.breakKeys.contains(JigyoKogakuKetteiTsuchishoOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flg = true;
        } else if (this.breakKeys.contains(JigyoKogakuKetteiTsuchishoOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
            flg = true;
        } else if (this.breakKeys.contains(JigyoKogakuKetteiTsuchishoOutputOrder.決定通知番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flg = true;
        }
        return flg;
    }
}
