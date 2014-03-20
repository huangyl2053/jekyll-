/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
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
    private final boolean 住宅改修契約有無;
    private final boolean 特定福祉用具販売契約有無;
    private final boolean 償還払給付契約有無;
    private final boolean 高額給付契約有無;
    private final boolean 取扱確約書有無;

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
            boolean 住宅改修契約有無, boolean 特定福祉用具販売契約有無, boolean 償還払給付契約有無,
            boolean 高額給付契約有無, boolean 取扱確約書有無) {

        this.契約番号 = requireNonNull(契約番号, Messages.E00001.replace("契約番号").getMessage());
        this.契約期間 = requireNonNull(契約期間, Messages.E00001.replace("契約期間").getMessage());
        this.処理日時 = requireNonNull(処理日時, Messages.E00001.replace("処理日時").getMessage());
        this.届出年月日 = 届出年月日;
        this.届出者 = 届出者;
        this.契約登録年月日 = 契約登録年月日;
        this.契約事業者 = 契約事業者;
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
     * 住宅改修契約であればtrueを、異なればfalseを返します。
     *
     * @return is住宅改修契約
     */
    public boolean is住宅改修契約() {
        return 住宅改修契約有無;
    }

    /**
     * 特定福祉用具販売契約であればtrueを、異なればfalseを返します。
     *
     * @return is特定福祉用具販売契約
     */
    public boolean is特定福祉用具販売契約() {
        return 特定福祉用具販売契約有無;
    }

    /**
     * 償還払給付契約であればtrueを、異なればfalseを返します。
     *
     * @return is償還払給付契約
     */
    public boolean is償還払給付契約() {
        return 償還払給付契約有無;
    }

    /**
     * 高額給付契約であればtrueを、異なればfalseを返します。
     *
     * @return is高額給付契約
     */
    public boolean is高額給付契約() {
        return 高額給付契約有無;
    }

    /**
     * 取扱確約書があればtrueを、なければfalseを返します。
     *
     * @return has取扱確約書
     */
    public boolean has取扱確約書() {
        return 取扱確約書有無;
    }
}
