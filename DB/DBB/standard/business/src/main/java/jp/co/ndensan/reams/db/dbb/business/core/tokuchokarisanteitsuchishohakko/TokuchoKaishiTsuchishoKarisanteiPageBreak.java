/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KaishiTsuchishoKariHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特徴開始通知書(仮算定）の発行用引数クラスです。
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
public class TokuchoKaishiTsuchishoKarisanteiPageBreak
        extends PageBreaker<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys List<RString>
     */
    public TokuchoKaishiTsuchishoKarisanteiPageBreak(List<RString> breakKeys) {
        this.breakKeysList = breakKeys;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flg = true;
        } else if (this.breakKeysList.contains(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.世帯コード.get項目ID())
                && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
            flg = true;
        }
        return flg;
    }
}
