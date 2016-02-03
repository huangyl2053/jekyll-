/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sunhui
 */
@Getter
@Setter
public class JutakuKaishuJizenShinseiChildDivParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号 ;
    private final RString 様式番号;
    private final RString 明細番号;
    private final RString 連番;
    private final ServiceCode サービスコード;
    private final FlexibleDate 住宅改修着工年月日;
    private final RString 住宅改修内容;
    private final RString 住宅改修事業者名;
    private final RString 住宅改修住宅住所;
    private final int 改修金額;
    private final RString 審査方法区分コード;
    private final FlexibleDate 住宅改修完成年月日;
    private final int 差額金額;
    private final FlexibleYearMonth 事前申請サービス提供年月;
    private final RString 事前申請整理番号;
     private final EntityDataState status;

    public JutakuKaishuJizenShinseiChildDivParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, RString 連番, ServiceCode サービスコード, FlexibleDate 住宅改修着工年月日, RString 住宅改修内容, RString 住宅改修事業者名, RString 住宅改修住宅住所, int 改修金額, RString 審査方法区分コード, FlexibleDate 住宅改修完成年月日, int 差額金額, FlexibleYearMonth 事前申請サービス提供年月, RString 事前申請整理番号,EntityDataState status) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
        this.連番 = 連番;
        this.サービスコード = サービスコード;
        this.住宅改修着工年月日 = 住宅改修着工年月日;
        this.住宅改修内容 = 住宅改修内容;
        this.住宅改修事業者名 = 住宅改修事業者名;
        this.住宅改修住宅住所 = 住宅改修住宅住所;
        this.改修金額 = 改修金額;
        this.審査方法区分コード = 審査方法区分コード;
        this.住宅改修完成年月日 = 住宅改修完成年月日;
        this.差額金額 = 差額金額;
        this.事前申請サービス提供年月 = 事前申請サービス提供年月;
        this.事前申請整理番号 = 事前申請整理番号;
        this.status=status;
    }

    
    
    

}
