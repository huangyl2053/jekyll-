/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujigyoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoOutputOrder;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakushikyufushikyuketteitsuchihakkoichiran.KogakuShikyuFushikyuKetteiTsuchiHakkoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票設計_DBCMN43002_高額介護サービス費支給（不支給）決定通知一覧表のPageBreak
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class KogakuShikyuFushikyuKetteiTsuchiHakkoPageBreak extends PageBreaker<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeysList List<RString>
     */
    public KogakuShikyuFushikyuKetteiTsuchiHakkoPageBreak(List<RString> breakKeysList) {
        this.breakKeysList = breakKeysList;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> currentSource,
            ReportLineRecord<KogakuShikyuFushikyuKetteiTsuchiHakkoSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flg = true;
        } else if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flg = true;
        } else if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flg = true;
        } else if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().kanaMeisho.equals(nextSource.getSource().kanaMeisho)) {
            flg = true;
        } else if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flg = true;
        } else if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flg = true;
        } else if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().hihokenshaNo.equals(nextSource.getSource().hihokenshaNo)) {
            flg = true;
        } else if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.決定通知番号.get項目ID())
                && !currentSource.getSource().tsuchishoNo.equals(nextSource.getSource().tsuchishoNo)) {
            flg = true;
        } else if (this.breakKeysList.contains(JigyoKogakuKetteiTsuchishoOutputOrder.資格状態区分.get項目ID())
                && !currentSource.getSource().shikakuJyotaiKubun.equals(nextSource.getSource().shikakuJyotaiKubun)) {
            flg = true;
        }
        return flg;
    }
}
