/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 合計用Entityクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GokeiYo {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 段階;
    private RString 徴収方法;
    private int yoGetuNinsuu;
    private int goGetuNinsuu;
    private int rokuGetuNinsuu;
    private int nanaGetuNinsuu;
    private int hakuGetuNinsuu;
    private int kyuGetuNinsuu;
    private int jyuGetuNinsuu;
    private int jyuitiGetuNinsuu;
    private int jyuniGetuNinsuu;
    private int itiGetuNinsuu;
    private int niGetuNinsuu;
    private int sanGetuNinsuu;
    private int 現年随時の人数;
    private int 過年度の人数;
    private int 歳出還付の人数;
    private int yoGetuKinkaku;
    private int goGetuKinkaku;
    private int rokuGetuKinkaku;
    private int nanaGetuKinkaku;
    private int hakuGetuKinkaku;
    private int kyuGetuKinkaku;
    private int jyuGetuKinkaku;
    private int jyuitiGetuKinkaku;
    private int jyuniGetuKinkaku;
    private int itiGetuKinkaku;
    private int niGetuKinkaku;
    private int sanGetuKinkaku;
    private int 現年随時の金額;
    private int 過年度の金額;
    private int 歳出還付の金額;

}
