/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChohyoKofuRirekiID;

/**
 * 被保険者証の再交付を扱うクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshashoSaikofu {

    private final HihokenshashoSaikofuKubun saikofuKubun;
    private final HihokenshashoSaikofuJiyu reason;
    private final ChohyoKofuRirekiID chohyoKofuRirekiID;

    /**
     * 新しいHihokenshashoSaikofuを生成します。
     *
     * @param saikofuKubun
     * 被保険者証再交付区分。nullのときは、{@link HihokenshashoSaikofuKubun#なし}として扱う。
     * @param reason
     * 被保険者証再交付事由。nullのときは、{@link HihokenshashoSaikofuJiyu#なし}として扱う。
     * @param chohyoKofuRirekiID 帳票交付履歴ID
     */
    public HihokenshashoSaikofu(HihokenshashoSaikofuKubun saikofuKubun,
            HihokenshashoSaikofuJiyu reason, ChohyoKofuRirekiID chohyoKofuRirekiID) {

        this.saikofuKubun = isNull(saikofuKubun) ? HihokenshashoSaikofuKubun.なし : saikofuKubun;
        this.reason = isNull(reason) ? HihokenshashoSaikofuJiyu.なし : reason;
        this.chohyoKofuRirekiID = chohyoKofuRirekiID;
    }

    /**
     * 被保険者証再交付区分を返します。
     *
     * @return {@link HihokenshashoSaikofuKubun 被保険者証再交付区分}
     */
    public HihokenshashoSaikofuKubun get有無区分() {
        return this.saikofuKubun;
    }

    /**
     * 被保険者証の再交付があるときはtrue、ないときにはfalseを返します。
     *
     * @return 被保険者証の再交付があるときはtrue、ないときにはfalse
     */
    public boolean exists() {
        return this.saikofuKubun == HihokenshashoSaikofuKubun.あり;
    }

    /**
     * 被保険者証再交付事由を返します。
     *
     * @return {@link HihokenshashoSaikofuJiyu 被保険者証再交付事由}
     */
    public HihokenshashoSaikofuJiyu getReason() {
        return this.reason;
    }

    /**
     * 帳票交付履歴IDを返します。
     *
     * @return {@link ChohyoKofuRirekiID 帳票交付履歴ID}
     */
    public ChohyoKofuRirekiID getChohyoKofuRirekiID() {
        return this.chohyoKofuRirekiID;
    }

    private boolean isNull(Object target) {
        return target == null;
    }
}
