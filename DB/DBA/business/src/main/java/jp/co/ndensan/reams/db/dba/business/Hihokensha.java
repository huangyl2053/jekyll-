/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urf.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険の被保険者を扱うクラスです。
 *
 * @author N3327 三浦 凌
 */
public class Hihokensha implements IKaigoShikaku {

    private final IKaigoShikaku shikaku;

    public Hihokensha(IKaigoShikaku shikaku) {
        this.shikaku = shikaku;
    }

    @Override
    public RString get被保険者番号() {
        return shikaku.get被保険者番号();
    }

    @Override
    public RString get介護保険広域構成市町村コード() {
        return shikaku.get介護保険広域構成市町村コード();
    }

    @Override
    public RDate get一号該当日() {
        return shikaku.get一号該当日();
    }

    @Override
    public IShikibetsuCode get識別コード() {
        return shikaku.get識別コード();
    }

    @Override
    public HokenShubetsu get保険種別() {
        return shikaku.get保険種別();
    }

    @Override
    public RDate get資格取得届出年月日() {
        return shikaku.get資格取得届出年月日();
    }

    @Override
    public RDate get資格取得年月日() {
        return shikaku.get資格取得年月日();
    }

    @Override
    public RString get資格取得事由() {
        return shikaku.get資格取得事由();
    }

    @Override
    public RDate get資格喪失届出年月日() {
        return shikaku.get資格喪失届出年月日();
    }

    @Override
    public RDate get資格喪失年月日() {
        return shikaku.get資格喪失年月日();
    }

    @Override
    public RString get資格喪失事由() {
        return shikaku.get資格喪失事由();
    }

    @Override
    public boolean is資格あり(RDate baseDate) {
        return shikaku.is資格あり(baseDate);
    }

    @Override
    public boolean isWapperFor(Class<?> iface) {
        return iface.isInstance(this);
    }

    @Override
    public <T> T unwrap(Class<T> iface) {
        return iface.cast(this);
    }
}
