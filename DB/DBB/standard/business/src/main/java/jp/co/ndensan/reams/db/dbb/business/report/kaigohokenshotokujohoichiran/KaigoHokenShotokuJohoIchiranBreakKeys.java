/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranProperty.DBB200008ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票設計_DBBPR51003_介護保険所得情報一覧表のBreakKeysのクラスです。
 *
 * @reamsid_L DBB-1650-060 lijunjun
 */
public class KaigoHokenShotokuJohoIchiranBreakKeys extends PageBreaker<KaigoHokenShotokuJohoIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public KaigoHokenShotokuJohoIchiranBreakKeys(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KaigoHokenShotokuJohoIchiranSource> currentSource,
            ReportLineRecord<KaigoHokenShotokuJohoIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(DBB200008ShutsuryokujunEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().listIchiranhyoLower_1.equals(nextSource.getSource().listIchiranhyoLower_1)) {
            flag = true;
        }
        if (this.breakKeysList.contains(DBB200008ShutsuryokujunEnum.識別コード.get項目ID())
                && !currentSource.getSource().listIchiranhyoUpper_2.equals(nextSource.getSource().listIchiranhyoUpper_2)) {
            flag = true;
        }
        if (this.breakKeysList.contains(DBB200008ShutsuryokujunEnum.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().listIchiranhyoUpper_3.equals(nextSource.getSource().listIchiranhyoUpper_3)) {
            flag = true;
        }
        return flag;
    }
}
