/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsamoshitateshoout;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 給付再審査申立書情報送付一覧表作成帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateDoIchiranhyoPageBreak extends PageBreaker<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SaishinsaMoshitateDoIchiranhyoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> currentSource,
            ReportLineRecord<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SaishinsaMoshitateDoIchiranhyoOutPutOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(SaishinsaMoshitateDoIchiranhyoOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(SaishinsaMoshitateDoIchiranhyoOutPutOrder.事業者番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(SaishinsaMoshitateDoIchiranhyoOutPutOrder.サービス提供年月.get項目ID())
                && !currentSource.getSource().listUpper_6.equals(nextSource.getSource().listUpper_6)) {
            flag = true;
        }
        return flag;
    }
}
