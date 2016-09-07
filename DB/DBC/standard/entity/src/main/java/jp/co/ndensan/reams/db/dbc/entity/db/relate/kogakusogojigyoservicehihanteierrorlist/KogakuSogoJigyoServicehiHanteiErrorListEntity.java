/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorlist;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額総合事業サービス費判定エラーリストのEntity Entity
 *
 * @reamsid_L DBC-2010-130 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuSogoJigyoServicehiHanteiErrorListEntity {

    private FlexibleYearMonth 審査年月From;
    private FlexibleYearMonth 審査年月To;
    private RString 被保険者番号;
    private RString 被保険者名;
    private ShikibetsuCode 識別コード;
    private RString 市町村コード;
    private FlexibleYearMonth サービス提供年月;
    private RString エラーコード;
    private RString 世帯コード;
    private RString 世帯員識別コード;
}
