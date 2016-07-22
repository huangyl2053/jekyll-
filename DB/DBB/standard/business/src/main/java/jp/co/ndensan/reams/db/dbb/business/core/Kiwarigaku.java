/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KiwarigakuMeisai;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期割額を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class Kiwarigaku {

    private final List<KiwarigakuMeisai> 期割額明細;
    private Decimal 特徴期別額合計 = Decimal.ZERO;
    private Decimal 特徴納付額合計 = Decimal.ZERO;
    private Decimal 普徴期別額合計 = Decimal.ZERO;
    private Decimal 普徴納付額合計 = Decimal.ZERO;

    /**
     * コンストラクタです。
     *
     * @param 期割額明細 期割額のリスト
     * @param 特徴期別額合計 特徴期別額合計
     * @param 特徴納付額合計 特徴納付額合計
     * @param 普徴期別額合計 普徴期別額合計
     * @param 普徴納付額合計 普徴納付額合計
     * @throws NullPointerException 引数がnullの場合
     */
    public Kiwarigaku(List<KiwarigakuMeisai> 期割額明細,
            Decimal 特徴期別額合計, Decimal 特徴納付額合計, Decimal 普徴期別額合計, Decimal 普徴納付額合計) throws NullPointerException {
        this.期割額明細 = requireNonNull(期割額明細, UrSystemErrorMessages.値がnull.getReplacedMessage("期割額明細"));
        this.特徴期別額合計 = requireNonNull(特徴期別額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴期別額合計"));
        this.特徴納付額合計 = requireNonNull(特徴納付額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴納付額合計"));
        this.普徴期別額合計 = requireNonNull(普徴期別額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("期割額明細"));
        this.普徴納付額合計 = requireNonNull(普徴納付額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴納付額合計"));
    }

    /**
     * 期割額明細を返します。
     *
     * @return 期割額明細
     */
    public List<KiwarigakuMeisai> get期割額明細() {
        return new ArrayList<>(期割額明細);
    }

    /**
     * 特徴期別額合計を返します。
     *
     * @return 特徴期別額合計
     */
    public Decimal get特徴期別額合計() {
        return 特徴期別額合計;
    }

    /**
     * 特徴期別額合計を返します。
     *
     * @return 特徴期別額合計
     */
    public RString get特徴期別額合計表記() {
        return composedカンマ編集OrEmpty(特徴期別額合計);
    }

    private static RString composedカンマ編集OrEmpty(Decimal value) {
        return value == null ? RString.EMPTY : new RString(value.toString("#,##0"));
    }

    /**
     * 特徴期別額合計が0円の場合、{@code ture}を返します。
     *
     * @return 特徴期別額合計が0円の場合、{@code ture}.以外の場合、{@code false}.
     */
    public boolean is特徴期別額合計0円() {
        return isNullOrZERO(特徴期別額合計);
    }

    private static boolean isNullOrZERO(Decimal value) {
        return value == null || Decimal.ZERO.equals(value);
    }

    /**
     * 特徴納付額合計を返します。
     *
     * @return 特徴納付額合計
     */
    public Decimal get特徴納付額合計() {
        return 特徴納付額合計;
    }

    /**
     * 特徴納付額合計を返します。
     *
     * @return 特徴納付額合計
     */
    public RString get特徴納付額合計表記() {
        return composedカンマ編集OrEmpty(特徴納付額合計);
    }

    /**
     * 特徴納付額合計が0円の場合、{@code ture}を返します。
     *
     * @return 特徴納付額合計が0円の場合、{@code ture}.以外の場合、{@code false}.
     */
    public boolean is特徴納付額合計0円() {
        return isNullOrZERO(特徴納付額合計);
    }

    /**
     * 普徴期別額合計を返します。
     *
     * @return 普徴期別額合計
     */
    public Decimal get普徴期別額合計() {
        return 普徴期別額合計;
    }

    /**
     * 普徴期別額合計を返します。
     *
     * @return 普徴期別額合計
     */
    public RString get普徴期別額合計表記() {
        return composedカンマ編集OrEmpty(普徴期別額合計);
    }

    /**
     * 普徴期別額合計が0円の場合、{@code ture}を返します。
     *
     * @return 普徴期別額合計が0円の場合、{@code ture}.以外の場合、{@code false}.
     */
    public boolean is普徴期別額合計0円() {
        return isNullOrZERO(普徴期別額合計);
    }

    /**
     * 普徴納付額合計を返します。
     *
     * @return 普徴納付額合計
     */
    public Decimal get普徴納付額合計() {
        return 普徴納付額合計;
    }

    /**
     * 普徴納付額合計を返します。
     *
     * @return 普徴納付額合計
     */
    public RString get普徴納付額合計表記() {
        return composedカンマ編集OrEmpty(普徴納付額合計);
    }

    /**
     * 普徴納付額合計が0円の場合、{@code ture}を返します。
     *
     * @return 普徴納付額合計が0円の場合、{@code ture}.以外の場合、{@code false}.
     */
    public boolean is普徴納付額合計0円() {
        return isNullOrZERO(特徴納付額合計);
    }

}
