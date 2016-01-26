/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 期別用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class Kibetsu {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final TsuchishoNo tsuchishoNo;
    private final Decimal rirekiNo;
    private final HihokenshaNo hihokenshaNo;
    private final RString choshuHouhou;
    private final int ki;
    private final Decimal choteiId;
    private final Decimal dai1kiChoteiIdGaku;
    private final Decimal dai2kiChoteiIdGaku;
    private final Decimal dai3kiChoteiIdGaku;
    private final Decimal dai4kiChoteiIdGaku;
    private final Decimal dai5kiChoteiIdGaku;
    private final Decimal dai6kiChoteiIdGaku;
    private final Decimal dai7kiChoteiIdGaku;
    private final Decimal dai8kiChoteiIdGaku;
    private final Decimal dai9kiChoteiIdGaku;
    private final Decimal dai10kiChoteiIdGaku;
    private final Decimal dai11kiChoteiIdGaku;
    private final Decimal dai12kiChoteiIdGaku;
    private final Decimal dai13kiChoteiIdGaku;
    private final Decimal dai14kiChoteiIdGaku;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 被保険者番号 被保険者番号
     * @param 徴収方法 徴収方法
     * @param 期 期
     * @param 調定ID 調定ID
     * @param 第1期の調定額 第1期の調定額
     * @param 第2期の調定額 第2期の調定額
     * @param 第3期の調定額 第3期の調定額
     * @param 第4期の調定額 第4期の調定額
     * @param 第5期の調定額 第5期の調定額
     * @param 第6期の調定額 第6期の調定額
     * @param 第7期の調定額 第7期の調定額
     * @param 第8期の調定額 第8期の調定額
     * @param 第9期の調定額 第9期の調定額
     * @param 第10期の調定額 第10期の調定額
     * @param 第11期の調定額 第11期の調定額
     * @param 第12期の調定額 第12期の調定額
     * @param 第13期の調定額 第13期の調定額
     * @param 第14期の調定額 第14期の調定額
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private Kibetsu(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号,
            HihokenshaNo 被保険者番号,
            RString 徴収方法,
            int 期,
            Decimal 調定ID,
            Decimal 第1期の調定額,
            Decimal 第2期の調定額,
            Decimal 第3期の調定額,
            Decimal 第4期の調定額,
            Decimal 第5期の調定額,
            Decimal 第6期の調定額,
            Decimal 第7期の調定額,
            Decimal 第8期の調定額,
            Decimal 第9期の調定額,
            Decimal 第10期の調定額,
            Decimal 第11期の調定額,
            Decimal 第12期の調定額,
            Decimal 第13期の調定額,
            Decimal 第14期の調定額) {

        this.choteiNendo = requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        this.fukaNendo = requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        this.tsuchishoNo = requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        this.rirekiNo = requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.hihokenshaNo = requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.choshuHouhou = requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        this.ki = requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));
        this.choteiId = requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));
        this.dai1kiChoteiIdGaku = requireNonNull(第1期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第1期の調定額"));
        this.dai2kiChoteiIdGaku = requireNonNull(第2期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第2期の調定額"));
        this.dai3kiChoteiIdGaku = requireNonNull(第3期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第3期の調定額"));
        this.dai4kiChoteiIdGaku = requireNonNull(第4期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第4期の調定額"));
        this.dai5kiChoteiIdGaku = requireNonNull(第5期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第5期の調定額"));
        this.dai6kiChoteiIdGaku = requireNonNull(第6期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第6期の調定額"));
        this.dai7kiChoteiIdGaku = requireNonNull(第7期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第7期の調定額"));
        this.dai8kiChoteiIdGaku = requireNonNull(第8期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第8期の調定額"));
        this.dai9kiChoteiIdGaku = requireNonNull(第9期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第9期の調定額"));
        this.dai10kiChoteiIdGaku = requireNonNull(第10期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第10期の調定額"));
        this.dai11kiChoteiIdGaku = requireNonNull(第11期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第11期の調定額"));
        this.dai12kiChoteiIdGaku = requireNonNull(第12期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第12期の調定額"));
        this.dai13kiChoteiIdGaku = requireNonNull(第13期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第13期の調定額"));
        this.dai14kiChoteiIdGaku = requireNonNull(第14期の調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("第14期の調定額"));
    }

    /**
     * 期別用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 被保険者番号 被保険者番号
     * @param 徴収方法 徴収方法
     * @param 期 期
     * @param 調定ID 調定ID
     * @param 第1期の調定額 第1期の調定額
     * @param 第2期の調定額 第2期の調定額
     * @param 第3期の調定額 第3期の調定額
     * @param 第4期の調定額 第4期の調定額
     * @param 第5期の調定額 第5期の調定額
     * @param 第6期の調定額 第6期の調定額
     * @param 第7期の調定額 第7期の調定額
     * @param 第8期の調定額 第8期の調定額
     * @param 第9期の調定額 第9期の調定額
     * @param 第10期の調定額 第10期の調定額
     * @param 第11期の調定額 第11期の調定額
     * @param 第12期の調定額 第12期の調定額
     * @param 第13期の調定額 第13期の調定額
     * @param 第14期の調定額 第14期の調定額
     * @return 期別用パラメータ
     */
    public static Kibetsu createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号,
            HihokenshaNo 被保険者番号,
            RString 徴収方法,
            int 期,
            Decimal 調定ID,
            Decimal 第1期の調定額,
            Decimal 第2期の調定額,
            Decimal 第3期の調定額,
            Decimal 第4期の調定額,
            Decimal 第5期の調定額,
            Decimal 第6期の調定額,
            Decimal 第7期の調定額,
            Decimal 第8期の調定額,
            Decimal 第9期の調定額,
            Decimal 第10期の調定額,
            Decimal 第11期の調定額,
            Decimal 第12期の調定額,
            Decimal 第13期の調定額,
            Decimal 第14期の調定額
    ) {
        return new Kibetsu(調定年度, 賦課年度, 通知書番号, 履歴番号,
                被保険者番号, 徴収方法, 期, 調定ID, 第1期の調定額, 第2期の調定額, 第3期の調定額,
                第4期の調定額, 第5期の調定額, 第6期の調定額, 第7期の調定額, 第8期の調定額,
                第9期の調定額, 第10期の調定額, 第11期の調定額, 第12期の調定額,
                第13期の調定額, 第14期の調定額);
    }

}
