/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.YokaigoNinteiTsukibetsuJukyushaSuJokyohyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定受給状況のエンティティクラスです。
 *
 * @reamsid_L DBD-1771-034 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity {

    private FlexibleYear 対象年度;
    private RString 市町村名;
    private RString 市町村コード;
    private RString 集計項目;
    private RString 一月の合計;
    private RString 二月の合計;
    private RString 三月の合計;
    private RString 四月の合計;
    private RString 五月の合計;
    private RString 六月の合計;
    private RString 七月の合計;
    private RString 八月の合計;
    private RString 九月の合計;
    private RString 十月の合計;
    private RString 十一月の合計;
    private RString 十二月の合計;
    private RString 年度合計;
}
