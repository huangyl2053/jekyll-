/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.IShikakuIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 資格異動に関する基本的な項目を扱います。
 *
 * @author N3327 三浦 凌
 * @param <E> 資格異動事由を表すEnum
 */
public abstract class ShikakuIdoBaseItem<E extends Enum & IShikakuIdoJiyu> {

    private final E reason;
    private final FlexibleDate noticeDate;
    private final FlexibleDate actionDate;

    /**
     * 資格異動異動の事由、届出年月日、処理年月日で初期化します。
     *
     * @param reason 資格異動事由
     * @param noticeDate 届出年月日
     * @param actionDate 処理年月日
     */
    public ShikakuIdoBaseItem(E reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
        requireNonNull(reason, Messages.E00001.replace("資格異動事由").getMessage());
        requireNonNull(noticeDate, Messages.E00001.replace("noticeDate").getMessage());
        requireNonNull(actionDate, Messages.E00001.replace("actionDate").getMessage());
        this.reason = reason;
        this.noticeDate = noticeDate;
        this.actionDate = actionDate;
    }

    /**
     * 資格異動の事由を返します。
     *
     * @return 資格異動の事由
     */
    public E getReason() {
        return this.reason;
    }

    /**
     * 資格異動の届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate getNoticeDate() {
        return this.noticeDate;
    }

    /**
     * 資格異動の処理年月日を返します。
     *
     * @return 処理年月日
     */
    public FlexibleDate getActionDate() {
        return this.actionDate;
    }

    /**
     * 資格異動が存在するかどうかを返します。
     *
     * @return 資格異動が存在するかどうか
     */
    public abstract boolean isNothing();
}
