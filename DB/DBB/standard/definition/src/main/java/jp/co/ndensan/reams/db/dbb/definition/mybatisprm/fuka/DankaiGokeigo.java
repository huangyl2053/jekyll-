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
 * 段階合計後用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class DankaiGokeigo {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final RString choshuHouhou;
    private final int dogetsuFlag;
    private final Decimal zengetsusueKensuCount;
    private final Decimal zengetsusueChoteigakuCount;
    private final Decimal dogetsusueKensuCount;
    private final Decimal dogetsusueChoteigakuCount;
    private final Decimal tokuchosyaKensuCount;
    private final Decimal fuchosyaKensuCount;
    private final Decimal naiheisyaKensuCount;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 当月フラグ 当月フラグ
     * @param 前月末の全部件数の合計 前月末の全部件数の合計
     * @param 前月末の全部調定額の合計 前月末の全部調定額の合計
     * @param 当月末の全部件数の合計 当月末の全部件数の合計
     * @param 当月末の全部調定額の合計 当月末の全部調定額の合計
     * @param 特徴者数の合計 特徴者数の合計
     * @param 普徴者数の合計 普徴者数の合計
     * @param 内併徴者数の合計 内併徴者数の合計
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private DankaiGokeigo(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            int 当月フラグ,
            Decimal 前月末の全部件数の合計,
            Decimal 前月末の全部調定額の合計,
            Decimal 当月末の全部件数の合計,
            Decimal 当月末の全部調定額の合計,
            Decimal 特徴者数の合計,
            Decimal 普徴者数の合計,
            Decimal 内併徴者数の合計) {

        this.choteiNendo = requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        this.fukaNendo = requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        this.choshuHouhou = requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        this.dogetsuFlag = requireNonNull(当月フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("当月フラグ"));
        this.zengetsusueKensuCount = requireNonNull(前月末の全部件数の合計, UrSystemErrorMessages.値がnull.getReplacedMessage("前月末の全部件数の合計"));
        this.zengetsusueChoteigakuCount = requireNonNull(前月末の全部調定額の合計, UrSystemErrorMessages.値がnull.getReplacedMessage("前月末の全部調定額の合計"));
        this.dogetsusueKensuCount = requireNonNull(当月末の全部件数の合計, UrSystemErrorMessages.値がnull.getReplacedMessage("当月末の全部件数の合計"));
        this.dogetsusueChoteigakuCount = requireNonNull(当月末の全部調定額の合計, UrSystemErrorMessages.値がnull.getReplacedMessage("当月末の全部調定額の合計"));
        this.tokuchosyaKensuCount = requireNonNull(特徴者数の合計, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴者数の合計"));
        this.fuchosyaKensuCount = requireNonNull(普徴者数の合計, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴者数の合計"));
        this.naiheisyaKensuCount = requireNonNull(内併徴者数の合計, UrSystemErrorMessages.値がnull.getReplacedMessage("内併徴者数の合計"));
    }

    /**
     * 段階合計後用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 当月フラグ 当月フラグ
     * @param 前月末の全部件数の合計 前月末の全部件数の合計
     * @param 前月末の全部調定額の合計 前月末の全部調定額の合計
     * @param 当月末の全部件数の合計 当月末の全部件数の合計
     * @param 当月末の全部調定額の合計 当月末の全部調定額の合計
     * @param 特徴者数の合計 特徴者数の合計
     * @param 普徴者数の合計 普徴者数の合計
     * @param 内併徴者数の合計 内併徴者数の合計
     * @return 段階合計後用パラメータ
     */
    public static DankaiGokeigo createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            int 当月フラグ,
            Decimal 前月末の全部件数の合計,
            Decimal 前月末の全部調定額の合計,
            Decimal 当月末の全部件数の合計,
            Decimal 当月末の全部調定額の合計,
            Decimal 特徴者数の合計,
            Decimal 普徴者数の合計,
            Decimal 内併徴者数の合計
    ) {
        return new DankaiGokeigo(調定年度, 賦課年度, 徴収方法, 当月フラグ, 前月末の全部件数の合計,
                前月末の全部調定額の合計, 当月末の全部件数の合計, 当月末の全部調定額の合計, 特徴者数の合計,
                普徴者数の合計, 内併徴者数の合計);
    }

}
