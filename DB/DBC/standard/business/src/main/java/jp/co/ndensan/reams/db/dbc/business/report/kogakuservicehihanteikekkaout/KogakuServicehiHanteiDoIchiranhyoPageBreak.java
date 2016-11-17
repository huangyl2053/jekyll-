/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehihanteikekkaout;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehisofuichiran.KogakuServicehiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額介護サービス費給付判定結果送付一覧表作成帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
public class KogakuServicehiHanteiDoIchiranhyoPageBreak extends PageBreaker<KogakuServicehiSofuIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KogakuServicehiHanteiDoIchiranhyoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KogakuServicehiSofuIchiranSource> currentSource,
            ReportLineRecord<KogakuServicehiSofuIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KogakuServicehiHanteiDoIchiranhyoOutPutOrder.保険者番号.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakuServicehiHanteiDoIchiranhyoOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakuServicehiHanteiDoIchiranhyoOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakuServicehiHanteiDoIchiranhyoOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakuServicehiHanteiDoIchiranhyoOutPutOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakuServicehiHanteiDoIchiranhyoOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakuServicehiHanteiDoIchiranhyoOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listCenter_2.equals(nextSource.getSource().listCenter_2)) {
            flag = true;
        }
        return flag;
    }
}
