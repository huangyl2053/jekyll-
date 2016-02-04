/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.choteibo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
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
    private final Decimal dai1kiChoteiGaku;
    private final Decimal dai2kiChoteiGaku;
    private final Decimal dai3kiChoteiGaku;
    private final Decimal dai4kiChoteiGaku;
    private final Decimal dai5kiChoteiGaku;
    private final Decimal dai6kiChoteiGaku;
    private final Decimal dai7kiChoteiGaku;
    private final Decimal dai8kiChoteiGaku;
    private final Decimal dai9kiChoteiGaku;
    private final Decimal dai10kiChoteiGaku;
    private final Decimal dai11kiChoteiGaku;
    private final Decimal dai12kiChoteiGaku;
    private final Decimal dai13kiChoteiGaku;
    private final Decimal dai14kiChoteiGaku;

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

        this.choteiNendo = 調定年度;
        this.fukaNendo = 賦課年度;
        this.tsuchishoNo = 通知書番号;
        this.rirekiNo = 履歴番号;
        this.hihokenshaNo = 被保険者番号;
        this.choshuHouhou = 徴収方法;
        this.ki = 期;
        this.choteiId = 調定ID;
        this.dai1kiChoteiGaku = 第1期の調定額;
        this.dai2kiChoteiGaku = 第2期の調定額;
        this.dai3kiChoteiGaku = 第3期の調定額;
        this.dai4kiChoteiGaku = 第4期の調定額;
        this.dai5kiChoteiGaku = 第5期の調定額;
        this.dai6kiChoteiGaku = 第6期の調定額;
        this.dai7kiChoteiGaku = 第7期の調定額;
        this.dai8kiChoteiGaku = 第8期の調定額;
        this.dai9kiChoteiGaku = 第9期の調定額;
        this.dai10kiChoteiGaku = 第10期の調定額;
        this.dai11kiChoteiGaku = 第11期の調定額;
        this.dai12kiChoteiGaku = 第12期の調定額;
        this.dai13kiChoteiGaku = 第13期の調定額;
        this.dai14kiChoteiGaku = 第14期の調定額;
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
