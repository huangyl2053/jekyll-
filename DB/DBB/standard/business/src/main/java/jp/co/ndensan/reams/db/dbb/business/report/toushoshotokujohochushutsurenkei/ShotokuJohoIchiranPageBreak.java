/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.toushoshotokujohochushutsurenkei;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 所得情報抽出・連携バッチの介護保険所得情報一覧表帳票の改ページ処理です。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class ShotokuJohoIchiranPageBreak extends PageBreaker<KaigoHokenShotokuJohoIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public ShotokuJohoIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KaigoHokenShotokuJohoIchiranSource> currentSource,
            ReportLineRecord<KaigoHokenShotokuJohoIchiranSource> nextSource) {
        if (this.breakKeysList.contains(ShotokuJohoIchiranOrder.識別コード.get項目ID())
                && !currentSource.getSource().listIchiranhyoUpper_2.equals(nextSource.getSource().listIchiranhyoUpper_2)) {
            return true;
        } else if (this.breakKeysList.contains(ShotokuJohoIchiranOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().listIchiranhyoUpper_3.equals(nextSource.getSource().listIchiranhyoUpper_3)) {
            return true;
        } else if (this.breakKeysList.contains(ShotokuJohoIchiranOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listIchiranhyoLower_1.equals(nextSource.getSource().listIchiranhyoLower_1)) {
            return true;
        }
        return false;
    }

}
