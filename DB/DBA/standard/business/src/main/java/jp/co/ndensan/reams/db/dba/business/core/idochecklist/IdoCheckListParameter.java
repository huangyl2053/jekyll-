/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.idochecklist;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動チェックリストパラメータBusinessクラスです。
 *
 * @reamsid_L DBA-0530-010 chengsanyuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IdoCheckListParameter {

    private final FlexibleDate 前回開始日時FROM;
    private final FlexibleDate 前回終了日時TO;
    private final FlexibleDate 今回開始日時FROM;
    private final FlexibleDate 今回終了日時TO;
    private final List<RString> 対象List;
    private final Long 出力順ID;
    private final boolean すべて選択;

    private IdoCheckListParameter(
            FlexibleDate 前回開始日時FROM,
            FlexibleDate 前回終了日時TO,
            FlexibleDate 今回開始日時FROM,
            FlexibleDate 今回終了日時TO,
            List<RString> 対象List,
            Long 出力順ID,
            boolean すべて選択) {
        this.今回終了日時TO = 今回終了日時TO;
        this.前回開始日時FROM = 前回開始日時FROM;
        this.前回終了日時TO = 前回終了日時TO;
        this.今回開始日時FROM = 今回開始日時FROM;
        this.対象List = 対象List;
        this.出力順ID = 出力順ID;
        this.すべて選択 = すべて選択;
    }

    /**
     *
     * 異動チェックリストパラメータを作成します。
     *
     * @param 前回開始日時FROM 前回開始日時FROM
     * @param 前回終了日時TO 前回終了日時TO
     * @param 今回開始日時FROM 今回開始日時FROM
     * @param 今回終了日時TO 今回終了日時TO
     * @param 対象List 対象List
     * @param 出力順ID 出力順ID
     * @param すべて選択 すべて選択
     * @return IdoCheckListParameter
     */
    public static IdoCheckListParameter createIdoCheckListParameter(
            FlexibleDate 前回開始日時FROM,
            FlexibleDate 前回終了日時TO,
            FlexibleDate 今回開始日時FROM,
            FlexibleDate 今回終了日時TO,
            List<RString> 対象List,
            Long 出力順ID,
            boolean すべて選択) {
        return new IdoCheckListParameter(前回開始日時FROM, 前回終了日時TO,
                今回開始日時FROM, 今回終了日時TO, 対象List, 出力順ID, すべて選択);
    }
}
