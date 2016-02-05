/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujyusyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ycb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FukushiyouguKonyuhiShikyuShinsei {

    public FlexibleYearMonth サービス提供年月;//
    public FlexibleDate 申請年月日;//
    public RString 支払区分;
    public FlexibleDate 決定日;
    public RString 整理番号;
    public RString 商品名;
    public RString 購入金額合計;
    public RString 被保険者番号;
    public RString 事業者番号;
    public RString 様式番号;

    private RString 明細番号;

}
