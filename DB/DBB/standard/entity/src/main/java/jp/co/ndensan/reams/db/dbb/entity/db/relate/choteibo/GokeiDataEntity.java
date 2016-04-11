/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ処理で作成した帳票用Entityリスト 合計データリスト
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GokeiDataEntity {

    private RString 徴収方法;
    private int 当月フラグ;
    private Decimal 当_1月の調定額の小計;
    private Decimal 当_2月の調定額の小計;
    private Decimal 当_3月の調定額の小計;
    private Decimal 当_4月の調定額の小計;
    private Decimal 当_5月の調定額の小計;
    private Decimal 当_6月の調定額の小計;
    private Decimal 当_7月の調定額の小計;
    private Decimal 当_8月の調定額の小計;
    private Decimal 当_9月の調定額の小計;
    private Decimal 当_10月の調定額の小計;
    private Decimal 当_11月の調定額の小計;
    private Decimal 当_12月の調定額の小計;
    private Decimal 翌_4月の調定額の小計;
    private Decimal 翌_5月の調定額の小計;
    private List<DankaiShokeiEntity> 合計の段階リスト;
    private Decimal 特別徴収の調定額の総計;
    private Decimal 普通徴収の調定額の総計;
    private Decimal 特徴と普徴の総計;
    private Decimal 前月末の全部件数の総計;
    private Decimal 前月末の全部調定額の総計;
    private Decimal 増の全部件数の総計;
    private Decimal 増の全部調定額の総計;
    private Decimal 減の全部件数の総計;
    private Decimal 減の全部調定額の総計;
    private Decimal 当月末の全部件数の総計;
    private Decimal 当月末の全部調定額の総計;
    private Decimal 特徴者数の総計;
    private Decimal 普徴者数の総計;
    private Decimal 内併徴者数の総計;
    private Decimal 減免の件数の総計;
    private Decimal 減免の調定額の総計;
    private Decimal 特徴歳出還付の件数の総計;
    private Decimal 特徴歳出還付の調定額の総計;
    private Decimal 普徴歳出還付の件数の総計;
    private Decimal 普徴歳出還付の調定額の総計;
}
