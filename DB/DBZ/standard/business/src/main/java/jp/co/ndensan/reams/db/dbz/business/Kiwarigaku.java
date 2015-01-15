/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.fuka.KiwarigakuMeisai;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static java.util.Objects.requireNonNull;

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
        return 期割額明細;
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
     * 特徴納付額合計を返します。
     *
     * @return 特徴納付額合計
     */
    public Decimal get特徴納付額合計() {
        return 特徴納付額合計;
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
     * 普徴納付額合計を返します。
     *
     * @return 普徴納付額合計
     */
    public Decimal get普徴納付額合計() {
        return 普徴納付額合計;
    }
}
