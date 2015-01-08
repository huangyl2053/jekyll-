/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者の資格取得を扱います。
 *
 * @author N3327 三浦 凌
 */
@Deprecated
public class ShikakuShutoku extends ShikakuIdoBaseItem<ShikakuShutokuJiyu> {

    /**
     * 資格取得がないことを表すオブジェクトです。<br />
     * 通常、このオブジェクトを使うことはありえません。
     */
    public static final ShikakuShutoku NOTHING;

    static {
        NOTHING = new ShikakuShutoku(ShikakuShutokuJiyu.なし, FlexibleDate.MIN, FlexibleDate.MIN);
    }

    /**
     * 新しい資格取得の事由、届出年月日、処理年月日を持ったインスタンスを生成します。
     *
     * @param reason 資格取得事由
     * @param noticeDate 資格取得届出年月日
     * @param actionDate 資格取得年月日
     */
    public ShikakuShutoku(ShikakuShutokuJiyu reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
        super(reason, noticeDate, actionDate);
    }

    @Override
    public boolean isNothing() {
        return this == NOTHING;
    }
}
