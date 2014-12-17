/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.model.KiwarigakuModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static java.util.Objects.requireNonNull;

/**
 * 期割額を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class Kiwarigaku {

    private final List<KiwarigakuModel> 期割額明細;
    private Decimal 特徴期別額合計 = Decimal.ZERO;
    private Decimal 特徴納付額合計 = Decimal.ZERO;
    private Decimal 普徴期別額合計 = Decimal.ZERO;
    private Decimal 普徴納付額合計 = Decimal.ZERO;

    /**
     * コンストラクタです。
     *
     * @param 期割額明細 期割額のリスト
     * @throws NullPointerException 引数がnullの場合
     */
    public Kiwarigaku(List<KiwarigakuModel> 期割額明細) throws NullPointerException {
        this.期割額明細 = requireNonNull(期割額明細, UrSystemErrorMessages.値がnull.getReplacedMessage("期割額明細"));
        for (KiwarigakuModel 期割額 : 期割額明細) {
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
    }

    /**
     * 期割額明細を返します。
     *
     * @return 期割額明細
     */
    public List<KiwarigakuModel> get期割額明細() {
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
