/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 期別小計用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KibetsuShokei {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final RString choshuHouhou;
    private final Decimal dai1kiChoteiIdGakuCount;
    private final Decimal dai2kiChoteiIdGakuCount;
    private final Decimal dai3kiChoteiIdGakuCount;
    private final Decimal dai4kiChoteiIdGakuCount;
    private final Decimal dai5kiChoteiIdGakuCount;
    private final Decimal dai6kiChoteiIdGakuCount;
    private final Decimal dai7kiChoteiIdGakuCount;
    private final Decimal dai8kiChoteiIdGakuCount;
    private final Decimal dai9kiChoteiIdGakuCount;
    private final Decimal dai10kiChoteiIdGakuCount;
    private final Decimal dai11kiChoteiIdGakuCount;
    private final Decimal dai12kiChoteiIdGakuCount;
    private final Decimal dai13kiChoteiIdGakuCount;
    private final Decimal dai14kiChoteiIdGakuCount;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 第1期の調定額の小計 第1期の調定額の小計
     * @param 第2期の調定額の小計 第2期の調定額の小計
     * @param 第3期の調定額の小計 第3期の調定額の小計
     * @param 第4期の調定額の小計 第4期の調定額の小計
     * @param 第5期の調定額の小計 第5期の調定額の小計
     * @param 第6期の調定額の小計 第6期の調定額の小計
     * @param 第7期の調定額の小計 第7期の調定額の小計
     * @param 第8期の調定額の小計 第8期の調定額の小計
     * @param 第9期の調定額の小計 第9期の調定額の小計
     * @param 第10期の調定額の小計 第10期の調定額の小計
     * @param 第11期の調定額の小計 第11期の調定額の小計
     * @param 第12期の調定額の小計 第12期の調定額の小計
     * @param 第13期の調定額の小計 第13期の調定額の小計
     * @param 第14期の調定額の小計 第14期の調定額の小計
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KibetsuShokei(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            Decimal 第1期の調定額の小計,
            Decimal 第2期の調定額の小計,
            Decimal 第3期の調定額の小計,
            Decimal 第4期の調定額の小計,
            Decimal 第5期の調定額の小計,
            Decimal 第6期の調定額の小計,
            Decimal 第7期の調定額の小計,
            Decimal 第8期の調定額の小計,
            Decimal 第9期の調定額の小計,
            Decimal 第10期の調定額の小計,
            Decimal 第11期の調定額の小計,
            Decimal 第12期の調定額の小計,
            Decimal 第13期の調定額の小計,
            Decimal 第14期の調定額の小計) {

        this.choteiNendo = requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        this.fukaNendo = requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        this.choshuHouhou = requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        this.dai1kiChoteiIdGakuCount = requireNonNull(第1期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第1期の調定額の小計"));
        this.dai2kiChoteiIdGakuCount = requireNonNull(第2期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第2期の調定額の小計"));
        this.dai3kiChoteiIdGakuCount = requireNonNull(第3期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第3期の調定額の小計"));
        this.dai4kiChoteiIdGakuCount = requireNonNull(第4期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第4期の調定額の小計"));
        this.dai5kiChoteiIdGakuCount = requireNonNull(第5期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第5期の調定額の小計"));
        this.dai6kiChoteiIdGakuCount = requireNonNull(第6期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第6期の調定額の小計"));
        this.dai7kiChoteiIdGakuCount = requireNonNull(第7期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第7期の調定額の小計"));
        this.dai8kiChoteiIdGakuCount = requireNonNull(第8期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第8期の調定額の小計"));
        this.dai9kiChoteiIdGakuCount = requireNonNull(第9期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第9期の調定額の小計"));
        this.dai10kiChoteiIdGakuCount = requireNonNull(第10期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第10期の調定額の小計"));
        this.dai11kiChoteiIdGakuCount = requireNonNull(第11期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第11期の調定額の小計"));
        this.dai12kiChoteiIdGakuCount = requireNonNull(第12期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第12期の調定額の小計"));
        this.dai13kiChoteiIdGakuCount = requireNonNull(第13期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第13期の調定額の小計"));
        this.dai14kiChoteiIdGakuCount = requireNonNull(第14期の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("第14期の調定額の小計"));
    }

    /**
     * 期別小計用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 第1期の調定額の小計 第1期の調定額の小計
     * @param 第2期の調定額の小計 第2期の調定額の小計
     * @param 第3期の調定額の小計 第3期の調定額の小計
     * @param 第4期の調定額の小計 第4期の調定額の小計
     * @param 第5期の調定額の小計 第5期の調定額の小計
     * @param 第6期の調定額の小計 第6期の調定額の小計
     * @param 第7期の調定額の小計 第7期の調定額の小計
     * @param 第8期の調定額の小計 第8期の調定額の小計
     * @param 第9期の調定額の小計 第9期の調定額の小計
     * @param 第10期の調定額の小計 第10期の調定額の小計
     * @param 第11期の調定額の小計 第11期の調定額の小計
     * @param 第12期の調定額の小計 第12期の調定額の小計
     * @param 第13期の調定額の小計 第13期の調定額の小計
     * @param 第14期の調定額の小計 第14期の調定額の小計
     * @return 期別小計用パラメータ
     */
    public static KibetsuShokei createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            Decimal 第1期の調定額の小計,
            Decimal 第2期の調定額の小計,
            Decimal 第3期の調定額の小計,
            Decimal 第4期の調定額の小計,
            Decimal 第5期の調定額の小計,
            Decimal 第6期の調定額の小計,
            Decimal 第7期の調定額の小計,
            Decimal 第8期の調定額の小計,
            Decimal 第9期の調定額の小計,
            Decimal 第10期の調定額の小計,
            Decimal 第11期の調定額の小計,
            Decimal 第12期の調定額の小計,
            Decimal 第13期の調定額の小計,
            Decimal 第14期の調定額の小計
    ) {
        return new KibetsuShokei(調定年度, 賦課年度, 徴収方法, 第1期の調定額の小計, 第2期の調定額の小計,
                第3期の調定額の小計, 第4期の調定額の小計, 第5期の調定額の小計, 第6期の調定額の小計,
                第7期の調定額の小計, 第8期の調定額の小計, 第9期の調定額の小計, 第10期の調定額の小計,
                第11期の調定額の小計, 第12期の調定額の小計, 第13期の調定額の小計, 第14期の調定額の小計);
    }

}
