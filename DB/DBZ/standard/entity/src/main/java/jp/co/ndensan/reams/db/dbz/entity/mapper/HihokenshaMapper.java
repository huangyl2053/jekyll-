/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;

/**
 * Hihokenshaマッパークラスです。
 *
 * @author N3327 三浦 凌
 * @deprecated 別に使う必要ない。
 */
@Deprecated
public final class HihokenshaMapper {

    private HihokenshaMapper() {
    }

    /**
     * {@link IKojin 個人情報}と{@link DbT1001HihokenshaDaichoEntity 資格情報Entity}から、
     * {@link Hihokensha 介護保険被保険者}へ変換します。
     *
     * @param profile {@link IKojin 個人情報}
     * @param entity {@link DbT1001HihokenshaDaichoEntity 被保険者台帳Entity}
     * @return {@link Hihokensha 介護保険被保険者}。ただし、引数のどちらかがnullの場合null。
     */
    public static Hihokensha toHihokensha(IKojin profile, DbT1001HihokenshaDaichoEntity entity) {
        if (isNull(profile) || isNull(entity)) {
            return null;
        }
        return _toHihokensha(profile, entity);
    }

    private static Hihokensha _toHihokensha(IKojin profile, DbT1001HihokenshaDaichoEntity entity) {
        IHihokenshaShikaku hihokenshaShikaku = HihokenshaShikakuMapper.toHihokenshaShikaku(entity);
        return new Hihokensha(profile, hihokenshaShikaku);
    }

    private static boolean isNull(Object target) {
        return target == null;
    }
}
