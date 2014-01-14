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
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.ILocalGovernmentCode;
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
    private final ShikakuHenkoJiyu 資格変更事由;
    private final RDate 資格変更届出年月日;
    private final RDate 資格変更年月日;
    private final JushochitokureiTekiyoJiyu 住所地特例適用事由;
    private final RDate 住所地特例適用届出年月日;
    private final RDate 住所地特例適用年月日;
    private final ILocalGovernmentCode 住所地特例措置元_地方公共団体コード;
    private final JushochitokureiKaijoJiyu 住所地特例解除事由;
    private final RDate 住所地特例解除届出年月日;
    private final RDate 住所地特例解除年月日;
    private final boolean 住所地特例有無;
    private final boolean 広域内_住所地特例有無;
    private final boolean 再交付有無;
    private final SaikofuJiyu 再交付事由;

    public Hihokensha(IKaigoShikaku 介護保険資格, ShikakuIdoKubun 資格異動区分, HihokenshaKubun 被保険者区分,
            ShikakuHenkoJiyu 資格変更事由, RDate 資格変更届出年月日, RDate 資格変更年月日,
            JushochitokureiTekiyoJiyu 住所地特例適用事由, RDate 住所地特例適用届出年月日, RDate 住所地特例適用年月日,
            ILocalGovernmentCode 住所地特例措置元_地方公共団体コード, JushochitokureiKaijoJiyu 住所地特例解除事由, RDate 住所地特例解除届出年月日, RDate 住所地特例解除年月日,
            boolean 住所地特例有無, boolean 広域内_住所地特例有無, boolean 再交付有無, SaikofuJiyu 再交付事由) {

        String className = "被保険者";

        this.介護保険資格 = Objects.requireNonNull(介護保険資格, Messages.E00003.replace("共通の介護保険資格情報", className).getMessage());
        this.資格異動区分 = Objects.requireNonNull(資格異動区分, Messages.E00003.replace("資格異動区分", className).getMessage());
        this.被保険者区分 = Objects.requireNonNull(被保険者区分, Messages.E00003.replace("被保険者区分", className).getMessage());
        this.資格変更事由 = 資格変更事由;
        this.資格変更届出年月日 = 資格変更届出年月日;
        this.資格変更年月日 = 資格変更年月日;
        this.住所地特例適用事由 = 住所地特例適用事由;
        this.住所地特例適用届出年月日 = 住所地特例適用届出年月日;
        this.住所地特例適用年月日 = 住所地特例適用年月日;
        this.住所地特例措置元_地方公共団体コード = 住所地特例措置元_地方公共団体コード;
        this.住所地特例解除事由 = 住所地特例解除事由;
        this.住所地特例解除届出年月日 = 住所地特例解除届出年月日;
        this.住所地特例解除年月日 = 住所地特例解除年月日;

        this.住所地特例有無 = 住所地特例有無;
        this.広域内_住所地特例有無 = 広域内_住所地特例有無;
        this.再交付有無 = 再交付有無;
        this.再交付事由 = 再交付事由;
    }

//    public RString get市町村コード(){
//        return null;
//    }
    /**
     * 再交付事由を取得します。
     *
     * @return 再交付事由
     */
    public SaikofuJiyu get再交付事由() {
        return 再交付事由;
    }

    /**
     * 被保険者証の再発行有無を調べます。
     *
     * @return 被保険者証の再発行があったかどうか
     */
    public boolean has被保険者証の再交付() {
        return 再交付有無;
    }

    /**
     * 広域内の住所地特例者かどうかを返します。
     *
     * @return 広域内の住所地特例者かどうか
     */
    public boolean is広域内住所地特例() {
        return 広域内_住所地特例有無;
    }

    /**
     * 住所地特例者かどうかを返します。
     *
     * @return 住所地特例かどうか
     */
    public boolean is住所地特例() {
        return 住所地特例有無;
    }

    /**
     * 住所地特例解除年月日を取得します。
     *
     * @return 住所地特例解除年月日
     */
    public RDate get住所地特例解除年月日() {
        return 住所地特例解除年月日;
    }

    /**
     * 住所地特例解除届出年月日を取得します。
     *
     * @return 住所地特例解除届出年月日
     */
    public RDate get住所地特例解除届出年月日() {
        return 住所地特例解除届出年月日;
    }

    /**
     * 住所地特例解除事由を取得します。
     *
     * @return 住所地特例解除事由
     */
    public JushochitokureiKaijoJiyu get住所地特例解除事由() {
        return 住所地特例解除事由;
    }

    /**
     * 住所地特例適用年月日を取得します。
     *
     * @return 住所地特例適用年月日
     */
    public RDate get住所地特例適用年月日() {
        return 住所地特例適用年月日;
    }

    /**
     * 住所地特例適用届出年月日を取得します。
     *
     * @return 住所地特例適用届出年月日
     */
    public RDate get住所地特例適用届出年月日() {
        return 住所地特例適用届出年月日;
    }

    /**
     * 住所地特例適用事由を取得します。
     *
     * @return 住所地特例適用事由
     */
    public JushochitokureiTekiyoJiyu get住所地特例適用事由() {
        return 住所地特例適用事由;
    }

    /**
     * 資格変更年月日を取得します。
     *
     * @return 資格変更年月日
     */
    public RDate get資格変更年月日() {
        return 資格変更年月日;
    }

    /**
     * 資格変更届出年月日を取得します。
     *
     * @return 資格変更届出年月日
     */
    public RDate get資格変更届出年月日() {
        return 資格変更届出年月日;
    }

    /**
     * 資格変更事由を取得します。
     *
     * @return 資格変更事由
     */
    public ShikakuHenkoJiyu get資格変更事由() {
        return 資格変更事由;
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
