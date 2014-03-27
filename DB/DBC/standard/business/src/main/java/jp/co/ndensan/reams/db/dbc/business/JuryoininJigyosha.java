/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.JutakuKaishuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KogakuKyufuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShokanbaraiKyufuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.TokuteiFukushiYoguHanbaiKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ToriatsukaiKakuyakushoKubun;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 受領委任契約事業者のクラスです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyosha {

    private final KeiyakuNo 契約番号;
    private final Range<FlexibleDate> 契約期間;
    private final RDateTime 処理日時;
    private final FlexibleDate 届出年月日;
    private final Todokedesha 届出者;
    private final FlexibleDate 契約登録年月日;
    private final KeiyakuJigyosha 契約事業者;
    private final JutakuKaishuKeiyakuKubun 住宅改修契約有無;
    private final TokuteiFukushiYoguHanbaiKeiyakuKubun 特定福祉用具販売契約有無;
    private final ShokanbaraiKyufuKeiyakuKubun 償還払給付契約有無;
    private final KogakuKyufuKeiyakuKubun 高額給付契約有無;
    private final ToriatsukaiKakuyakushoKubun 取扱確約書有無;

    /**
     * コンストラクタです。
     *
     * @param 契約番号 契約番号
     * @param 契約期間 契約期間
     * @param 処理日時 処理日時
     * @param 届出年月日 届出年月日
     * @param 届出者 届出者
     * @param 契約登録年月日 契約登録年月日
     * @param 契約事業者 契約事業者
     * @param 住宅改修契約有無 住宅改修契約であるか否か
     * @param 特定福祉用具販売契約有無 特定福祉用具販売契約であるか否か
     * @param 償還払給付契約有無 償還払給付契約であるか否か
     * @param 高額給付契約有無 高額給付契約であるか否か
     * @param 取扱確約書有無 取扱確約書を持っているか否か
     */
    public JuryoininJigyosha(KeiyakuNo 契約番号, Range<FlexibleDate> 契約期間, RDateTime 処理日時,
            FlexibleDate 届出年月日, Todokedesha 届出者, FlexibleDate 契約登録年月日, KeiyakuJigyosha 契約事業者,
            JutakuKaishuKeiyakuKubun 住宅改修契約有無,
            TokuteiFukushiYoguHanbaiKeiyakuKubun 特定福祉用具販売契約有無,
            ShokanbaraiKyufuKeiyakuKubun 償還払給付契約有無,
            KogakuKyufuKeiyakuKubun 高額給付契約有無,
            ToriatsukaiKakuyakushoKubun 取扱確約書有無) {

        this.契約番号 = requireNonNull(契約番号, Messages.E00001.replace("契約番号").getMessage());
        this.契約期間 = requireNonNull(契約期間, Messages.E00001.replace("契約期間").getMessage());
        this.処理日時 = requireNonNull(処理日時, Messages.E00001.replace("処理日時").getMessage());
        this.届出年月日 = 届出年月日;
        this.届出者 = 届出者;
        this.契約登録年月日 = 契約登録年月日;
        this.契約事業者 = requireNonNull(契約事業者, Messages.E00001.replace("契約事業者").getMessage());
        this.住宅改修契約有無 = 住宅改修契約有無;
        this.特定福祉用具販売契約有無 = 特定福祉用具販売契約有無;
        this.償還払給付契約有無 = 償還払給付契約有無;
        this.高額給付契約有無 = 高額給付契約有無;
        this.取扱確約書有無 = 取扱確約書有無;
    }

    /**
     * 契約番号を返します。
     *
     * @return 契約番号
     */
    public KeiyakuNo get契約番号() {
        return 契約番号;
    }

    /**
     * 契約期間を返します。
     *
     * @return 契約期間
     */
    public Range<FlexibleDate> get契約期間() {
        return 契約期間;
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return 処理日時;
    }

    /**
     * 届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get届出年月日() {
        return 届出年月日;
    }

    /**
     * 届出者を返します。
     *
     * @return 届出者
     */
    public Todokedesha get届出者() {
        return 届出者;
    }

    /**
     * 契約登録年月日を返します。
     *
     * @return 契約登録年月日
     */
    public FlexibleDate get契約登録年月日() {
        return 契約登録年月日;
    }

    /**
     * 契約事業者を返します。
     *
     * @return 契約事業者
     */
    public KeiyakuJigyosha get契約事業者() {
        return 契約事業者;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 契約事業者.get法人().get識別コード();
    }

    /**
     * 住宅改修契約区分を返します。
     *
     * @return 住宅改修契約区分
     */
    public JutakuKaishuKeiyakuKubun get住宅改修契約区分() {
        return 住宅改修契約有無;
    }

    /**
     * 住宅改修契約か否かを返します。
     *
     * @return 住宅改修契約ならtrue、異なればfalse
     */
    public boolean has住宅改修契約() {
        return 住宅改修契約有無 == JutakuKaishuKeiyakuKubun.契約有り;
    }

    /**
     * 特定福祉用具販売契約区分を返します。
     *
     * @return 特定福祉用具販売契約有無
     */
    public TokuteiFukushiYoguHanbaiKeiyakuKubun get特定福祉用具販売契約区分() {
        return 特定福祉用具販売契約有無;
    }

    /**
     * 特定福祉用具販売契約か否かを返します。
     *
     * @return 特定福祉用具販売契約ならtrue、異なればfalse
     */
    public boolean has特定福祉用具販売契約() {
        return 特定福祉用具販売契約有無 == TokuteiFukushiYoguHanbaiKeiyakuKubun.契約有り;
    }

    /**
     * 償還払給付契約区分を返します。
     *
     * @return 償還払給付契約有無
     */
    public ShokanbaraiKyufuKeiyakuKubun get償還払給付契約区分() {
        return 償還払給付契約有無;
    }

    /**
     * 償還払給付契約か否かを返します。
     *
     * @return 償還払給付契約ならtrue、異なればfalse
     */
    public boolean has償還払給付契約() {
        return 償還払給付契約有無 == ShokanbaraiKyufuKeiyakuKubun.契約有り;
    }

    /**
     * 高額給付契約区分を返します。
     *
     * @return 高額給付契約有無
     */
    public KogakuKyufuKeiyakuKubun get高額給付契約区分() {
        return 高額給付契約有無;
    }

    /**
     * 高額給付契約か否かを返します。
     *
     * @return 高額給付契約ならtrue、異なればfalse
     */
    public boolean has高額給付契約() {
        return 高額給付契約有無 == KogakuKyufuKeiyakuKubun.契約有り;
    }

    /**
     * 取扱確約書区分を返します。
     *
     * @return 取扱確約書有無
     */
    public ToriatsukaiKakuyakushoKubun get取扱確約書区分() {
        return 取扱確約書有無;
    }

    /**
     * 取扱確約書があるか否かを返します。
     *
     * @return 取扱確約書があればtrue、なければfalse
     */
    public boolean has取扱確約書() {
        return 取扱確約書有無 == ToriatsukaiKakuyakushoKubun.確約書有り;
    }
}
