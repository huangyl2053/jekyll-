/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import java.util.Objects;
import jp.co.ndensan.reams.db.dba.definition.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.definition.ShikakuIdoKubun;
import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urf.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険の被保険者を扱うクラスです。
 *
 * @author N3327 三浦 凌
 */
public class Hihokensha implements IKaigoShikaku {

    private final IKaigoShikaku 介護保険資格;
    private final ShikakuIdoKubun 資格異動区分;
    private final HihokenshaKubun 被保険者区分;

    public Hihokensha(IKaigoShikaku 介護保険資格, ShikakuIdoKubun 資格異動区分, HihokenshaKubun 被保険者区分) {
        String name = "被保険者";
        this.介護保険資格 = Objects.requireNonNull(介護保険資格, Messages.E00003.replace("共通の介護保険資格情報", name).getMessage());
        this.資格異動区分 = Objects.requireNonNull(資格異動区分, Messages.E00003.replace("資格異動区分", name).getMessage());
        this.被保険者区分 = Objects.requireNonNull(被保険者区分, Messages.E00003.replace("被保険者区分", name).getMessage());
    }

    /**
     * 被保険者区分を取得します。
     *
     * @return 被保険者区分
     */
    public HihokenshaKubun get被保険者区分() {
        return 被保険者区分;
    }

    /**
     * 資格異動区分を取得します。
     *
     * @return 資格異動区分
     */
    public ShikakuIdoKubun get資格異動区分() {
        return 資格異動区分;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    @Override
    public RString get被保険者番号() {
        return 介護保険資格.get被保険者番号();
    }

    /**
     * 介護保険広域構成市町村コードを取得します。
     *
     * @return 介護保険広域構成市町村コード
     */
    @Override
    public RString get介護保険広域構成市町村コード() {
        return 介護保険資格.get介護保険広域構成市町村コード();
    }

    /**
     * 一号該当日(65歳年齢到達日)を取得します。
     *
     * @return 一号該当日
     */
    @Override
    public RDate get一号該当日() {
        return 介護保険資格.get一号該当日();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    @Override
    public IShikibetsuCode get識別コード() {
        return 介護保険資格.get識別コード();
    }

    /**
     * 保険種別を取得します。戻り値は「介護保険」で固定です。
     *
     * @return HokenShubetsu.介護保険
     */
    @Override
    public HokenShubetsu get保険種別() {
        return 介護保険資格.get保険種別();
    }

    /**
     * 資格取得届出年月日を取得します。
     *
     * @return 資格取得届出年月日
     */
    @Override
    public RDate get資格取得届出年月日() {
        return 介護保険資格.get資格取得届出年月日();
    }

    /**
     * 資格取得年月日を取得します。
     *
     * @return 資格取得年月日
     */
    @Override
    public RDate get資格取得年月日() {
        return 介護保険資格.get資格取得年月日();
    }

    /**
     * 資格取得事由を取得します。
     *
     * @return 資格取得事由
     */
    @Override
    public RString get資格取得事由() {
        //TODO N3327 三浦凌 資格取得事由のインターフェースを共通へ作成する。 2014/1/31まで
        return 介護保険資格.get資格取得事由();
    }

    /**
     * 資格喪失届出年月日を取得します。
     *
     * @return 資格喪失届出年月日
     */
    @Override
    public RDate get資格喪失届出年月日() {
        return 介護保険資格.get資格喪失届出年月日();
    }

    /**
     * 資格喪失年月日を取得します。
     *
     * @return 資格喪失年月日
     */
    @Override
    public RDate get資格喪失年月日() {
        return 介護保険資格.get資格喪失年月日();
    }

    /**
     * 資格喪失事由を取得します。
     *
     * @return 資格喪失事由
     */
    @Override
    public RString get資格喪失事由() {
        //TODO N3327 三浦凌 資格喪失事由のインターフェースを共通へ作成する。 2014/1/31まで
        return 介護保険資格.get資格喪失事由();
    }

    /**
     * 基準日時点で資格が有無を調べます。
     *
     * @param baseDate 基準日
     * @return 基準日時点の資格有無
     */
    @Override
    public boolean is資格あり(RDate baseDate) {
        return 介護保険資格.is資格あり(baseDate);
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
