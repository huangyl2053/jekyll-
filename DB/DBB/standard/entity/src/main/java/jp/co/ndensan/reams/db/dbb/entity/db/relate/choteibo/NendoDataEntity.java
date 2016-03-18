/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ処理で作成した帳票用Entityリスト
 */
@lombok.Getter
@lombok.Setter
public class NendoDataEntity {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 徴収方法;
    private Decimal 第1期の調定額の小計;
    private Decimal 第2期の調定額の小計;
    private Decimal 第3期の調定額の小計;
    private Decimal 第4期の調定額の小計;
    private Decimal 第5期の調定額の小計;
    private Decimal 第6期の調定額の小計;
    private Decimal 第7期の調定額の小計;
    private Decimal 第8期の調定額の小計;
    private Decimal 第9期の調定額の小計;
    private Decimal 第10期の調定額の小計;
    private Decimal 第11期の調定額の小計;
    private Decimal 第12期の調定額の小計;
    private Decimal 第13期の調定額の小計;
    private Decimal 第14期の調定額の小計;
    private List<DankaiShokeiEntity> 段階小計リスト;
    private Decimal 特別徴収の調定額の合計;
    private Decimal 普通徴収の調定額の合計;
    private Decimal 特徴と普徴の合計;
    private Decimal 減免の件数;
    private Decimal 減免の調定額;
    private Decimal 特徴歳出還付の件数;
    private Decimal 特徴歳出還付の調定額;
    private Decimal 普徴歳出還付の件数;
    private Decimal 普徴歳出還付の調定額;
    private int 当月フラグ;
    private Decimal 前月末の全部件数の合計;
    private Decimal 前月末の全部調定額の合計;
    private Decimal 増の全部件数の合計;
    private Decimal 増の全部調定額の合計;
    private Decimal 減の全部件数の合計;
    private Decimal 減の全部調定額の合計;
    private Decimal 当月末の全部件数の合計;
    private Decimal 当月末の全部調定額の合計;
    private Decimal 特徴者数の合計;
    private Decimal 普徴者数の合計;
    private Decimal 内併徴者数の合計;

}
