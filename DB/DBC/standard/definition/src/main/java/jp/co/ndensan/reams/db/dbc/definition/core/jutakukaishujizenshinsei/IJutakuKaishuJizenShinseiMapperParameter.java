/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sunhui
 */
@Getter
@Setter
public class IJutakuKaishuJizenShinseiMapperParameter {
    HihokenshaNo 被保険者番号;
    RString 住宅改修住宅住所;
    RString 整理番号;
    FlexibleYearMonth サービス提供年月;
    ServiceShuruiCode サービス種類コード;

    public IJutakuKaishuJizenShinseiMapperParameter(HihokenshaNo 被保険者番号, RString 住宅改修住宅住所, RString 整理番号, FlexibleYearMonth サービス提供年月, ServiceShuruiCode サービス種類コード) {
        this.被保険者番号 = 被保険者番号;
        this.住宅改修住宅住所 = 住宅改修住宅住所;
        this.整理番号 = 整理番号;
        this.サービス提供年月 = サービス提供年月;
        this.サービス種類コード = サービス種類コード;
    }

    
    public static IJutakuKaishuJizenShinseiMapperParameter createParameterForJutakuKaishuJizenShinsei(HihokenshaNo 被保険者番号, RString 住宅改修住宅住所, RString 整理番号, FlexibleYearMonth サービス提供年月, ServiceShuruiCode サービス種類コード){
        return new IJutakuKaishuJizenShinseiMapperParameter(被保険者番号,住宅改修住宅住所, 整理番号,サービス提供年月,サービス種類コード);
    }
    
}
