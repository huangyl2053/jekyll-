/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.Kiwarigaku;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.fuka.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 期割額を計算するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KiwarigakuCalculator {

    private final List<KiwarigakuMeisai> 期割額明細;

    /**
     * コンストラクタです。
     *
     * @param 期割額明細 期割額のリスト
     * @throws NullPointerException 引数がnullの場合
     */
    public KiwarigakuCalculator(List<KiwarigakuMeisai> 期割額明細) throws NullPointerException {
        this.期割額明細 = requireNonNull(期割額明細, UrSystemErrorMessages.値がnull.getReplacedMessage("期割額明細"));
    }

    /**
     * 期割額を計算して返します。
     *
     * @return 期割額
     */
    public Kiwarigaku calculate() {
        Decimal 特徴期別額合計 = Decimal.ZERO;
        Decimal 特徴納付額合計 = Decimal.ZERO;
        Decimal 普徴期別額合計 = Decimal.ZERO;
        Decimal 普徴納付額合計 = Decimal.ZERO;
        for (KiwarigakuMeisai 期割額 : 期割額明細) {
            ChoshuHohoKibetsu 徴収方法 = ChoshuHohoKibetsu.toValue(期割額.get期別調定共通().get介護期別モデル().get徴収方法());
            Decimal 期別額 = 期割額.get期別調定共通().get調定共通モデル().get調定額();
            Decimal 納付額 = 期割額.get収入額();
            if (徴収方法 == ChoshuHohoKibetsu.特別徴収) {
                特徴期別額合計 = 特徴期別額合計.add(期別額);
                特徴納付額合計 = 特徴納付額合計.add(納付額);
            } else if (徴収方法 == ChoshuHohoKibetsu.普通徴収) {
                普徴期別額合計 = 普徴期別額合計.add(期別額);
                普徴納付額合計 = 普徴納付額合計.add(納付額);
            }
        }
        return new Kiwarigaku(期割額明細, 特徴期別額合計, 特徴納付額合計, 普徴期別額合計, 普徴納付額合計);
    }
}
