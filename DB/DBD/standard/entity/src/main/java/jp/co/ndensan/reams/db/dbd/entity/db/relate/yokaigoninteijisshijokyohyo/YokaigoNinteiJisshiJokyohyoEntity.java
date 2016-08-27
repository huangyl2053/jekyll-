/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定実施状況のエンティティクラスです。
 *
 * @reamsid_L DBD-1771-030 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class YokaigoNinteiJisshiJokyohyoEntity {

    private RString 市町村名;
    private RString 市町村番号;
    private FlexibleYear 対象年度;
    private RString 集計項目;
    private int 一月の合計;
    private int 二月の合計;
    private int 三月の合計;
    private int 四月の合計;
    private int 五月の合計;
    private int 六月の合計;
    private int 七月の合計;
    private int 八月の合計;
    private int 九月の合計;
    private int 十月の合計;
    private int 十一月の合計;
    private int 十二月の合計;
    private int 年度合計;
}
