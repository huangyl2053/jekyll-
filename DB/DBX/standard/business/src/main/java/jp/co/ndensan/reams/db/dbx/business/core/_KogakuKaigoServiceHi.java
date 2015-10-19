/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費の実装クラスです。
 *
 * @author N9943 王 永康
 * @jpName 高額介護サービス費
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
public class _KogakuKaigoServiceHi implements IKogakuKaigoServiceHi {

    private final RString 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final Decimal 支給高額介護サービス費;
    private final Decimal 利用者負担額;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 支給高額介護サービス費 支給高額介護サービス費
     * @param 利用者負担額 利用者負担額
     * @throws NullPointerException 引数がNullの場合はスローされる。
     * @throws IllegalArgumentException 支給高額介護サービス費と利用者負担額が0より小さい、または利用者負担額が支給高額介護サービス費より小さい場合はスローされる。
     */
    public _KogakuKaigoServiceHi(RString 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            Decimal 支給高額介護サービス費,
            Decimal 利用者負担額) throws NullPointerException, IllegalArgumentException {

        this.被保険者番号 = requireNonNull(被保険者番号, UrSystemErrorMessages.引数がnullのため生成不可.
                getReplacedMessage("被保険者番号", getClass().getName().toString()));
        this.サービス提供年月 = requireNonNull(サービス提供年月, UrSystemErrorMessages.引数がnullのため生成不可.
                getReplacedMessage("サービス提供年月", getClass().getName().toString()));
        this.支給高額介護サービス費 = requireNonNull(支給高額介護サービス費, UrSystemErrorMessages.引数がnullのため生成不可.
                getReplacedMessage("支給高額介護サービス費", getClass().getName().toString()));
        this.利用者負担額 = requireNonNull(利用者負担額, UrSystemErrorMessages.引数がnullのため生成不可.
                getReplacedMessage("利用者負担額", getClass().getName().toString()));

        checkMinus(this.支給高額介護サービス費, "支給高額介護サービス費");
        checkMinus(this.利用者負担額, "利用者負担額");

        checkGreaterEqual(this.利用者負担額, this.支給高額介護サービス費);
    }

    @Override
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    @Override
    public FlexibleYearMonth getサービス提供年月() {
        return サービス提供年月;
    }

    @Override
    public Decimal get支給高額介護サービス費() {
        return 支給高額介護サービス費;
    }

    @Override
    public Decimal get利用者負担額() {
        return 利用者負担額;
    }

    @Override
    public Decimal get償還後利用者負担額() {
        return 利用者負担額.subtract(支給高額介護サービス費);
    }

    private void checkMinus(Decimal target, String message) {
        if (target.compareTo(Decimal.ZERO) < 0) {
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(message, "0以上").evaluate());
        }
    }

    private void checkGreaterEqual(Decimal 利用者負担額, Decimal 支給高額介護サービス費) {
        if (利用者負担額.compareTo(支給高額介護サービス費) < 0) {
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace("利用者負担額", "支給高額介護サービス費以上の金額").evaluate());
        }
    }

}
