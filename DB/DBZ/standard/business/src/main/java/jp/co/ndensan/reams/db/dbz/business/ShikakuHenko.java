/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者の資格変更を扱います。
 *
 * @author N3327 三浦 凌
 */
@Deprecated
public class ShikakuHenko extends ShikakuIdoBaseItem<ShikakuHenkoJiyu> {

    /**
     * 資格変更がないことを表すオブジェクトです。
     */
    public static final ShikakuHenko NOTHING;

    static {
        NOTHING = new ShikakuHenko(ShikakuHenkoJiyu.なし, FlexibleDate.MAX, FlexibleDate.MAX);
    }

    /**
     * 新しい資格変更の事由、届出年月日、処理年月日を持ったインスタンスを生成します。
     *
     * @param reason 資格変更事由
     * @param noticeDate 資格変更届出年月日
     * @param actionDate 資格変更年月日
     */
    public ShikakuHenko(ShikakuHenkoJiyu reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
        super(reason, noticeDate, actionDate);
    }

    @Override
    public boolean isNothing() {
        return this == NOTHING;
    }
}
