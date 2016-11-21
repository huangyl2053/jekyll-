/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票設計_DBBPR51001_所得照会票発行一覧表の改頁のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class ShotokushokaihyoHakkoIchiranBreakKey extends PageBreaker<ShotokushokaihyoHakkoIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public ShotokushokaihyoHakkoIchiranBreakKey(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<ShotokushokaihyoHakkoIchiranSource> currentSource,
            ReportLineRecord<ShotokushokaihyoHakkoIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        }
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        }
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.世帯コード.get項目ID())
                && !currentSource.getSource().listUpper_1.equals(nextSource.getSource().listUpper_1)) {
            flag = true;
        }
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.識別コード.get項目ID())
                && !currentSource.getSource().listLower_1.equals(nextSource.getSource().listLower_1)) {
            flag = true;
        }
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
            flag = true;
        }
        flag = setflag(currentSource, nextSource, flag);
        return flag;
    }

    private boolean setflag(ReportLineRecord<ShotokushokaihyoHakkoIchiranSource> currentSource,
            ReportLineRecord<ShotokushokaihyoHakkoIchiranSource> nextSource, boolean flag) {
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.生年月日.get項目ID())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            flag = true;
        }
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        }
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.異動年月日.get項目ID())
                && !currentSource.getSource().idoYMD.equals(nextSource.getSource().idoYMD)) {
            flag = true;
        }
        if (this.breakKeysList.contains(ShotokushokaihyoHakkoIchiranOutPutOrder.前住所コード.get項目ID())
                && !currentSource.getSource().zenjushoCode.equals(nextSource.getSource().zenjushoCode)) {
            flag = true;
        }
        if (!currentSource.getSource().kouhoshakubun.equals(nextSource.getSource().kouhoshakubun)) {
            flag = true;
        }
        return flag;
    }

}
