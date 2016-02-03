/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.business.core.shiharaikekka;

import jp.co.ndensan.reams.db.dbc.entity.db.shiharaikekka.ShiharaiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author sunhui
 */
public class ShiharaiKekka {
    public Decimal 費用額合計;
    public Decimal 保険対象費用額;
    public Decimal 保険給付額;
    public Decimal 利用者負担額;
    public RString 住宅改修住宅住所;

    public ShiharaiKekka(Decimal 費用額合計, Decimal 保険対象費用額, Decimal 保険給付額, Decimal 利用者負担額, RString 住宅改修住宅住所) {
        this.費用額合計 = 費用額合計;
        this.保険対象費用額 = 保険対象費用額;
        this.保険給付額 = 保険給付額;
        this.利用者負担額 = 利用者負担額;
        this.住宅改修住宅住所 = 住宅改修住宅住所;
    }
     public ShiharaiKekka(ShiharaiKekkaEntity entity){
         this.住宅改修住宅住所=entity.住宅改修住宅住所;
         this.保険対象費用額=entity.保険対象費用額;
         this.保険給付額=entity.保険給付額;
         this.利用者負担額=entity.利用者負担額;
         this.費用額合計=entity.費用額合計;
     }
}
