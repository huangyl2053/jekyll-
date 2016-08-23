/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者の資格喪失を扱います。
 *
 * @author N3327 三浦 凌
 */
@Deprecated
public final class ShikakuSoshitsu extends ShikakuIdoBaseItem {

    /**
     * 資格喪失がないことを表すオブジェクトです。
     */
    public static final ShikakuSoshitsu NONE;

    static {
        NONE = new ShikakuSoshitsu(ShikakuSoshitsuJiyu.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);
    }

    /**
     * 新しい資格喪失の事由、届出年月日、処理年月日を持ったインスタンスを生成します。
     *
     * @param reason 資格喪失事由
     * @param noticeDate 資格喪失届出年月日
     * @param actionDate 資格喪失年月日
     */
    public ShikakuSoshitsu(ShikakuSoshitsuJiyu reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
        super(reason, noticeDate, actionDate);
    }

    @Override
    public boolean isNothing() {
        return this == NONE;
    }
}
