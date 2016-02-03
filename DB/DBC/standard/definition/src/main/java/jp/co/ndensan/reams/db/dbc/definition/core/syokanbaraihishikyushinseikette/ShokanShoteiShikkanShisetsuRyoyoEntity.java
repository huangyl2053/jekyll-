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
 * 緊急時・所定疾患登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShoteiShikkanShisetsuRyoyoEntity {

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
    private final RString 摘要1;
    private final RString 摘要2;
    private final RString 摘要3;
    private final RString 摘要4;
    private final RString 摘要5;
    private final RString 摘要6;
    private final RString 摘要7;
    private final RString 摘要8;
    private final RString 摘要9;
    private final RString 摘要10;
    private final RString 摘要11;
    private final RString 摘要12;
    private final RString 摘要13;
    private final RString 摘要14;
    private final RString 摘要15;
    private final RString 摘要16;
    private final RString 摘要17;
    private final RString 摘要18;
    private final RString 摘要19;
    private final RString 摘要20;
    private final int 緊急時施設療養費合計単位数;
    private final RString 所定疾患施設療養費傷病名1;
    private final RString 所定疾患施設療養費傷病名2;
    private final RString 所定疾患施設療養費傷病名3;
    private final FlexibleDate 所定疾患施設療養費開始年月日1;
    private final FlexibleDate 所定疾患施設療養費開始年月日2;
    private final FlexibleDate 所定疾患施設療養費開始年月日3;
    private final int 所定疾患施設療養費単位数;
    private final Decimal 所定疾患施設療養費日数;
    private final int 所定疾患施設療養費小計;
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
     * @param 摘要1
     * @param 摘要2
     * @param 摘要3
     * @param 摘要4
     * @param 摘要5
     * @param 摘要6
     * @param 摘要7
     * @param 摘要8
     * @param 摘要9
     * @param 摘要10
     * @param 摘要11
     * @param 摘要12
     * @param 摘要13
     * @param 摘要14
     * @param 摘要15
     * @param 摘要16
     * @param 摘要17
     * @param 摘要18
     * @param 摘要19
     * @param 摘要20
     * @param 緊急時施設療養費合計単位数
     * @param 所定疾患施設療養費傷病名1
     * @param 所定疾患施設療養費傷病名2
     * @param 所定疾患施設療養費傷病名3
     * @param 所定疾患施設療養費開始年月日1
     * @param 所定疾患施設療養費開始年月日2
     * @param 所定疾患施設療養費開始年月日3
     * @param 所定疾患施設療養費単位数
     * @param 所定疾患施設療養費日数
     * @param 所定疾患施設療養費小計
     * @param 状態
     */
    protected ShokanShoteiShikkanShisetsuRyoyoEntity(RString 連番, RString 緊急時傷病名1, RString 緊急時傷病名2,
            RString 緊急時傷病名3, FlexibleDate 緊急時治療開始年月日1, FlexibleDate 緊急時治療開始年月日2,
            FlexibleDate 緊急時治療開始年月日3, Decimal 往診日数, RString 往診医療機関名, Decimal 通院日数,
            RString 通院医療機関名, int 緊急時治療管理単位数, Decimal 緊急時治療管理日数,
            int 緊急時治療管理小計, int リハビリテーション単位数, int 処置単位数, int 手術単位数, int 麻酔単位数,
            int 放射線治療単位数, RString 摘要1,
            RString 摘要2, RString 摘要3, RString 摘要4, RString 摘要5, RString 摘要6, RString 摘要7,
            RString 摘要8, RString 摘要9, RString 摘要10, RString 摘要11, RString 摘要12, RString 摘要13,
            RString 摘要14, RString 摘要15, RString 摘要16, RString 摘要17, RString 摘要18, RString 摘要19,
            RString 摘要20, int 緊急時施設療養費合計単位数, RString 所定疾患施設療養費傷病名1,
            RString 所定疾患施設療養費傷病名2, RString 所定疾患施設療養費傷病名3,
            FlexibleDate 所定疾患施設療養費開始年月日1, FlexibleDate 所定疾患施設療養費開始年月日2,
            FlexibleDate 所定疾患施設療養費開始年月日3, int 所定疾患施設療養費単位数, Decimal 所定疾患施設療養費日数,
            int 所定疾患施設療養費小計, RString 状態) {
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
        this.摘要1 = 摘要1;
        this.摘要2 = 摘要2;
        this.摘要3 = 摘要3;
        this.摘要4 = 摘要4;
        this.摘要5 = 摘要5;
        this.摘要6 = 摘要6;
        this.摘要7 = 摘要7;
        this.摘要8 = 摘要8;
        this.摘要9 = 摘要9;
        this.摘要10 = 摘要10;
        this.摘要11 = 摘要11;
        this.摘要12 = 摘要12;
        this.摘要13 = 摘要13;
        this.摘要14 = 摘要14;
        this.摘要15 = 摘要15;
        this.摘要16 = 摘要16;
        this.摘要17 = 摘要17;
        this.摘要18 = 摘要18;
        this.摘要19 = 摘要19;
        this.摘要20 = 摘要20;
        this.緊急時施設療養費合計単位数 = 緊急時施設療養費合計単位数;
        this.所定疾患施設療養費傷病名1 = 所定疾患施設療養費傷病名1;
        this.所定疾患施設療養費傷病名2 = 所定疾患施設療養費傷病名2;
        this.所定疾患施設療養費傷病名3 = 所定疾患施設療養費傷病名3;
        this.所定疾患施設療養費開始年月日1 = 所定疾患施設療養費開始年月日1;
        this.所定疾患施設療養費開始年月日2 = 所定疾患施設療養費開始年月日2;
        this.所定疾患施設療養費開始年月日3 = 所定疾患施設療養費開始年月日3;
        this.所定疾患施設療養費単位数 = 所定疾患施設療養費単位数;
        this.所定疾患施設療養費日数 = 所定疾患施設療養費日数;
        this.所定疾患施設療養費小計 = 所定疾患施設療養費小計;
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
     * @param 摘要1
     * @param 摘要2
     * @param 摘要3
     * @param 摘要4
     * @param 摘要5
     * @param 摘要6
     * @param 摘要7
     * @param 摘要8
     * @param 摘要9
     * @param 摘要10
     * @param 摘要11
     * @param 摘要12
     * @param 摘要13
     * @param 摘要14
     * @param 摘要15
     * @param 摘要16
     * @param 摘要17
     * @param 摘要18
     * @param 摘要19
     * @param 摘要20
     * @param 緊急時施設療養費合計単位数
     * @param 所定疾患施設療養費傷病名1
     * @param 所定疾患施設療養費傷病名2
     * @param 所定疾患施設療養費傷病名3
     * @param 所定疾患施設療養費開始年月日1
     * @param 所定疾患施設療養費開始年月日2
     * @param 所定疾患施設療養費開始年月日3
     * @param 所定疾患施設療養費単位数
     * @param 所定疾患施設療養費日数
     * @param 所定疾患施設療養費小計
     * @param 状態
     * @return
     */
    public static ShokanShoteiShikkanShisetsuRyoyoEntity createSelectByKeyParam(RString 連番,
            RString 緊急時傷病名1, RString 緊急時傷病名2,
            RString 緊急時傷病名3, FlexibleDate 緊急時治療開始年月日1, FlexibleDate 緊急時治療開始年月日2,
            FlexibleDate 緊急時治療開始年月日3, Decimal 往診日数, RString 往診医療機関名, Decimal 通院日数,
            RString 通院医療機関名, int 緊急時治療管理単位数, Decimal 緊急時治療管理日数,
            int 緊急時治療管理小計, int リハビリテーション単位数, int 処置単位数, int 手術単位数, int 麻酔単位数,
            int 放射線治療単位数, RString 摘要1,
            RString 摘要2, RString 摘要3, RString 摘要4, RString 摘要5, RString 摘要6, RString 摘要7,
            RString 摘要8, RString 摘要9, RString 摘要10, RString 摘要11, RString 摘要12, RString 摘要13,
            RString 摘要14, RString 摘要15, RString 摘要16, RString 摘要17, RString 摘要18, RString 摘要19,
            RString 摘要20, int 緊急時施設療養費合計単位数, RString 所定疾患施設療養費傷病名1,
            RString 所定疾患施設療養費傷病名2, RString 所定疾患施設療養費傷病名3,
            FlexibleDate 所定疾患施設療養費開始年月日1, FlexibleDate 所定疾患施設療養費開始年月日2,
            FlexibleDate 所定疾患施設療養費開始年月日3, int 所定疾患施設療養費単位数, Decimal 所定疾患施設療養費日数,
            int 所定疾患施設療養費小計, RString 状態) {
        return new ShokanShoteiShikkanShisetsuRyoyoEntity(連番, 緊急時傷病名1, 緊急時傷病名2, 緊急時傷病名3,
                緊急時治療開始年月日1, 緊急時治療開始年月日2, 緊急時治療開始年月日3, 往診日数, 往診医療機関名,
                通院日数, 通院医療機関名, 緊急時治療管理単位数, 緊急時治療管理日数, 緊急時治療管理小計,
                リハビリテーション単位数, 処置単位数, 手術単位数, 麻酔単位数, 放射線治療単位数, 摘要1,
                摘要2, 摘要3, 摘要4, 摘要5, 摘要6, 摘要7, 摘要8, 摘要9, 摘要10, 摘要11, 摘要12, 摘要13,
                摘要14, 摘要15, 摘要16, 摘要17, 摘要18, 摘要19, 摘要20, 緊急時施設療養費合計単位数,
                所定疾患施設療養費傷病名1, 所定疾患施設療養費傷病名2, 所定疾患施設療養費傷病名3,
                所定疾患施設療養費開始年月日1, 所定疾患施設療養費開始年月日2, 所定疾患施設療養費開始年月日3,
                所定疾患施設療養費単位数, 所定疾患施設療養費日数, 所定疾患施設療養費小計, 状態);
    }
}
