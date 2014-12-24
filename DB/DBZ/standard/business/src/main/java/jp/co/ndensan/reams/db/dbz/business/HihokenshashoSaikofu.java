/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChohyoKofuRirekiID;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 被保険者証の再交付を扱うクラスです。
 *
 * @author N3327 三浦 凌
 */
@Deprecated
public class HihokenshashoSaikofu {

    /**
     * 被保険者証再交付がないことを表すオブジェクトです。<br />
     *
     * {@link #get有無区分() get有無区分()}は{@link HihokenshashoSaikofuKubun#なし なし}、
     * {@link #getReason() getReason()}は{@link HihokenshashoSaikofuJiyu#なし なし}、
     * {@link #getChohyoKofuRirekiID() getChohyoKofuRirekiID}はnull、
     * {@link #exists() exists()}はfalseを返します。
     */
    public static final HihokenshashoSaikofu NOTHING;

    static {
        NOTHING = new HihokenshashoSaikofu(
                HihokenshashoSaikofuKubun.なし,
                HihokenshashoSaikofuJiyu.なし, null);
    }
    private final HihokenshashoSaikofuKubun saikofuKubun;
    private final HihokenshashoSaikofuJiyu reason;
    private final ChohyoKofuRirekiID chohyoKofuRirekiID;

    private HihokenshashoSaikofu(HihokenshashoSaikofuKubun saikofuKubun,
            HihokenshashoSaikofuJiyu reason, ChohyoKofuRirekiID chohyoKofuRirekiID) {
        this.saikofuKubun = saikofuKubun;
        this.reason = reason;
        this.chohyoKofuRirekiID = chohyoKofuRirekiID;
    }

    /**
     * 新しいHihokenshashoSaikofuを生成します。<br />
     * 「被保険者証再交付がない」という状態を扱う場合は、
     * {@link HihokenshashoSaikofu#NOTHING HihokenshashoSaikofu.NOTHING}を使用してください。
     *
     * @param reason {@link HihokenshashoSaikofuJiyu 被保険者証再交付事由}
     * @param chohyoKofuRirekiID {@link ChohyoKofuRirekiID 帳票交付履歴ID}
     * @throws NullPointerException 引数にnullがあるとき。
     */
    public HihokenshashoSaikofu(HihokenshashoSaikofuJiyu reason, ChohyoKofuRirekiID chohyoKofuRirekiID) throws NullPointerException {
        this.saikofuKubun = HihokenshashoSaikofuKubun.あり;
        this.reason = requireNonNull(reason, errorMessageForE00003With("被保険者証再交付事由", simpleNameOf(HihokenshashoSaikofuJiyu.class)));
        this.chohyoKofuRirekiID = requireNonNull(chohyoKofuRirekiID,
                errorMessageForE00003With("帳票交付履歴ID", simpleNameOf(ChohyoKofuRirekiID.class)));
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

    private String simpleNameOf(Class clazz) {
        return clazz.getSimpleName();
    }

    private String errorMessageForE00003With(String name, String className) {
        return errorMessageForE00003With(name + "(" + className + ")");
    }

    private String errorMessageForE00003With(String str) {
        return Messages.E00003.replace(str, HihokenshashoSaikofu.class.getSimpleName()).getMessage();
    }
}
