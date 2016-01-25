/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 緊急時施設療養費登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanKinkyuShisetsuRyoyoEntity {

    private final RString 連番;
    private final RString 緊急時傷病名1;
    private final RString 緊急時傷病名2;
    private final RString 緊急時傷病名3;
    private final FlexibleDate 緊急時治療開始年月日1;
    private final FlexibleDate 緊急時治療開始年月日2;
    private final FlexibleDate 緊急時治療開始年月日3;
    private final Decimal 往診日数;
    private final RString 往診医療機関名;
    private final Decimal 通院日数;
    private final RString 通院医療機関名;
    private final int 緊急時治療管理単位数;
    private final Decimal 緊急時治療管理日数;
    private final int 緊急時治療管理小計;
    private final int リハビリテーション単位数;
    private final int 処置単位数;
    private final int 手術単位数;
    private final int 麻酔単位数;
    private final int 放射線治療単位数;
    private final RString 摘要;
    private final int 緊急時施設療養費合計単位数;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param 緊急時傷病名1
     * @param 緊急時傷病名2
     * @param 緊急時傷病名3
     * @param 緊急時治療開始年月日1
     * @param 緊急時治療開始年月日2
     * @param 緊急時治療開始年月日3
     * @param 往診日数
     * @param 往診医療機関名
     * @param 通院日数
     * @param 通院医療機関名
     * @param 緊急時治療管理単位数
     * @param 緊急時治療管理日数
     * @param 緊急時治療管理小計
     * @param リハビリテーション単位数
     * @param 処置単位数
     * @param 手術単位数
     * @param 麻酔単位数
     * @param 放射線治療単位数
     * @param 摘要
     * @param 緊急時施設療養費合計単位数
     * @param 状態
     */
    protected ShokanKinkyuShisetsuRyoyoEntity(RString 連番, RString 緊急時傷病名1, RString 緊急時傷病名2,
            RString 緊急時傷病名3, FlexibleDate 緊急時治療開始年月日1, FlexibleDate 緊急時治療開始年月日2,
            FlexibleDate 緊急時治療開始年月日3, Decimal 往診日数, RString 往診医療機関名, Decimal 通院日数,
            RString 通院医療機関名, int 緊急時治療管理単位数, Decimal 緊急時治療管理日数,
            int 緊急時治療管理小計, int リハビリテーション単位数, int 処置単位数, int 手術単位数,
            int 麻酔単位数, int 放射線治療単位数, RString 摘要, int 緊急時施設療養費合計単位数, RString 状態) {
        this.連番 = 連番;
        this.緊急時傷病名1 = 緊急時傷病名1;
        this.緊急時傷病名2 = 緊急時傷病名2;
        this.緊急時傷病名3 = 緊急時傷病名3;
        this.緊急時治療開始年月日1 = 緊急時治療開始年月日1;
        this.緊急時治療開始年月日2 = 緊急時治療開始年月日2;
        this.緊急時治療開始年月日3 = 緊急時治療開始年月日3;
        this.往診日数 = 往診日数;
        this.往診医療機関名 = 往診医療機関名;
        this.通院日数 = 通院日数;
        this.通院医療機関名 = 通院医療機関名;
        this.緊急時治療管理単位数 = 緊急時治療管理単位数;
        this.緊急時治療管理日数 = 緊急時治療管理日数;
        this.緊急時治療管理小計 = 緊急時治療管理小計;
        this.リハビリテーション単位数 = リハビリテーション単位数;
        this.処置単位数 = 処置単位数;
        this.手術単位数 = 手術単位数;
        this.麻酔単位数 = 麻酔単位数;
        this.放射線治療単位数 = 放射線治療単位数;
        this.摘要 = 摘要;
        this.緊急時施設療養費合計単位数 = 緊急時施設療養費合計単位数;
        this.状態 = 状態;
    }

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param 緊急時傷病名1
     * @param 緊急時傷病名2
     * @param 緊急時傷病名3
     * @param 緊急時治療開始年月日1
     * @param 緊急時治療開始年月日2
     * @param 緊急時治療開始年月日3
     * @param 往診日数
     * @param 往診医療機関名
     * @param 通院日数
     * @param 通院医療機関名
     * @param 緊急時治療管理単位数
     * @param 緊急時治療管理日数
     * @param 緊急時治療管理小計
     * @param リハビリテーション単位数
     * @param 処置単位数
     * @param 手術単位数
     * @param 麻酔単位数
     * @param 放射線治療単位数
     * @param 摘要
     * @param 緊急時施設療養費合計単位数
     * @param 状態
     * @return
     */
    public static ShokanKinkyuShisetsuRyoyoEntity createSelectByKeyParam(RString 連番, RString 緊急時傷病名1,
            RString 緊急時傷病名2, RString 緊急時傷病名3, FlexibleDate 緊急時治療開始年月日1,
            FlexibleDate 緊急時治療開始年月日2, FlexibleDate 緊急時治療開始年月日3,
            Decimal 往診日数, RString 往診医療機関名, Decimal 通院日数, RString 通院医療機関名,
            int 緊急時治療管理単位数, Decimal 緊急時治療管理日数, int 緊急時治療管理小計, int リハビリテーション単位数,
            int 処置単位数, int 手術単位数, int 麻酔単位数, int 放射線治療単位数,
            RString 摘要, int 緊急時施設療養費合計単位数, RString 状態) {
        return new ShokanKinkyuShisetsuRyoyoEntity(連番, 緊急時傷病名1, 緊急時傷病名2, 緊急時傷病名3,
                緊急時治療開始年月日1, 緊急時治療開始年月日2, 緊急時治療開始年月日3, 往診日数, 往診医療機関名,
                通院日数, 通院医療機関名, 緊急時治療管理単位数, 緊急時治療管理日数, 緊急時治療管理小計,
                リハビリテーション単位数, 処置単位数, 手術単位数, 麻酔単位数, 放射線治療単位数,
                摘要, 緊急時施設療養費合計単位数, 状態);
    }
}
