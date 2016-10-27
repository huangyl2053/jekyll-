/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 *
 * 帳票設計_DBC100064_基準収入額適用申請書のPageBreakクラスです
 *
 * @reamsid_L DBC-2500-031 jiangwenkai
 */
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranPageBreak extends PageBreaker<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * breakKeysの構造方法です
     *
     * @param breakKeys ページングキー
     */
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> currentSource,
            ReportLineRecord<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.世帯コード.get項目ID())
                && !currentSource.getSource().setaiCode.equals(nextSource.getSource().setaiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KijunShunyugakuTekiyoShinseishoHakkoIchiranOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        }
        return flag;
    }
}
