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
 * 段階小計用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class DankaiShokei {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final RString choshuHouhou;
    private final RString dankai;
    private final int dogetsuFlag;
    private final Decimal zengetsusueKensu;
    private final Decimal zengetsusueChoteigakuCount;
    private final Decimal fueKensu;
    private final Decimal fueChoteigakuCount;
    private final Decimal genKensu;
    private final Decimal genChoteigakuCount;
    private final Decimal dogetsusueKensu;
    private final Decimal dogetsusueChoteigakuCount;
    private final Decimal tokuchosyaKensu;
    private final Decimal fuchosyaKensu;
    private final Decimal naiheisyaKensu;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 段階 段階
     * @param 当月フラグ 当月フラグ
     * @param 該当する段階の前月末の件数 該当する段階の前月末の件数
     * @param 該当する段階の前月末の調定額の小計 該当する段階の前月末の調定額の小計
     * @param 該当する段階の増の件数 該当する段階の増の件数
     * @param 該当する段階の増の調定額の小計 該当する段階の増の調定額の小計
     * @param 該当する段階の減の件数 該当する段階の減の件数
     * @param 該当する段階の減の調定額の小計 該当する段階の減の調定額の小計
     * @param 該当する段階の当月末の件数 該当する段階の当月末の件数
     * @param 該当する段階の当月末の調定額の小計 該当する段階の当月末の調定額の小計
     * @param 該当する段階の特徴者数の件数 該当する段階の特徴者数の件数
     * @param 該当する段階の普徴者数の件数 該当する段階の普徴者数の件数
     * @param 該当する段階の内併徴者数の件数 該当する段階の内併徴者数の件数
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private DankaiShokei(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            RString 段階,
            int 当月フラグ,
            Decimal 該当する段階の前月末の件数,
            Decimal 該当する段階の前月末の調定額の小計,
            Decimal 該当する段階の増の件数,
            Decimal 該当する段階の増の調定額の小計,
            Decimal 該当する段階の減の件数,
            Decimal 該当する段階の減の調定額の小計,
            Decimal 該当する段階の当月末の件数,
            Decimal 該当する段階の当月末の調定額の小計,
            Decimal 該当する段階の特徴者数の件数,
            Decimal 該当する段階の普徴者数の件数,
            Decimal 該当する段階の内併徴者数の件数) {

        this.choteiNendo = requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        this.fukaNendo = requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        this.choshuHouhou = requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        this.dankai = requireNonNull(段階, UrSystemErrorMessages.値がnull.getReplacedMessage("段階"));
        this.dogetsuFlag = requireNonNull(当月フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("当月フラグ"));
        this.zengetsusueKensu = requireNonNull(該当する段階の前月末の件数, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の前月末の件数"));
        this.zengetsusueChoteigakuCount = requireNonNull(該当する段階の前月末の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の前月末の調定額の小計"));
        this.fueKensu = requireNonNull(該当する段階の増の件数, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の増の件数"));
        this.fueChoteigakuCount = requireNonNull(該当する段階の増の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の増の調定額の小計"));
        this.genKensu = requireNonNull(該当する段階の減の件数, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の減の件数"));
        this.genChoteigakuCount = requireNonNull(該当する段階の減の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の減の調定額の小計"));
        this.dogetsusueKensu = requireNonNull(該当する段階の当月末の件数, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の当月末の件数"));
        this.dogetsusueChoteigakuCount = requireNonNull(該当する段階の当月末の調定額の小計, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の当月末の調定額の小計"));
        this.tokuchosyaKensu = requireNonNull(該当する段階の特徴者数の件数, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の特徴者数の件数"));
        this.fuchosyaKensu = requireNonNull(該当する段階の普徴者数の件数, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の普徴者数の件数"));
        this.naiheisyaKensu = requireNonNull(該当する段階の内併徴者数の件数, UrSystemErrorMessages.値がnull.getReplacedMessage("該当する段階の内併徴者数の件数"));
    }

    /**
     * 段階小計用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 段階 段階
     * @param 当月フラグ 当月フラグ
     * @param 該当する段階の前月末の件数 該当する段階の前月末の件数
     * @param 該当する段階の前月末の調定額の小計 該当する段階の前月末の調定額の小計
     * @param 該当する段階の増の件数 該当する段階の増の件数
     * @param 該当する段階の増の調定額の小計 該当する段階の増の調定額の小計
     * @param 該当する段階の減の件数 該当する段階の減の件数
     * @param 該当する段階の減の調定額の小計 該当する段階の減の調定額の小計
     * @param 該当する段階の当月末の件数 該当する段階の当月末の件数
     * @param 該当する段階の当月末の調定額の小計 該当する段階の当月末の調定額の小計
     * @param 該当する段階の特徴者数の件数 該当する段階の特徴者数の件数
     * @param 該当する段階の普徴者数の件数 該当する段階の普徴者数の件数
     * @param 該当する段階の内併徴者数の件数 該当する段階の内併徴者数の件数
     * @return 段階小計用パラメータ
     */
    public static DankaiShokei createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            RString 段階,
            int 当月フラグ,
            Decimal 該当する段階の前月末の件数,
            Decimal 該当する段階の前月末の調定額の小計,
            Decimal 該当する段階の増の件数,
            Decimal 該当する段階の増の調定額の小計,
            Decimal 該当する段階の減の件数,
            Decimal 該当する段階の減の調定額の小計,
            Decimal 該当する段階の当月末の件数,
            Decimal 該当する段階の当月末の調定額の小計,
            Decimal 該当する段階の特徴者数の件数,
            Decimal 該当する段階の普徴者数の件数,
            Decimal 該当する段階の内併徴者数の件数
    ) {
        return new DankaiShokei(調定年度, 賦課年度, 徴収方法, 段階, 当月フラグ, 該当する段階の前月末の件数,
                該当する段階の前月末の調定額の小計, 該当する段階の増の件数, 該当する段階の増の調定額の小計, 該当する段階の減の件数,
                該当する段階の減の調定額の小計, 該当する段階の当月末の件数, 該当する段階の当月末の調定額の小計,
                該当する段階の特徴者数の件数, 該当する段階の普徴者数の件数, 該当する段階の内併徴者数の件数);
    }

}
