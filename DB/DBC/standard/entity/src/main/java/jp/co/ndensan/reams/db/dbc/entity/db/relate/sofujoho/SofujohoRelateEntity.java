/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sofujoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤申立送付情報照会のRelateEntityクラスです。
 *
 * @reamsid_L DBC-2950-010 jinjue
 */
@lombok.Getter
@lombok.Setter
public class SofujohoRelateEntity {

    private RString 事業所番号;
    private RString 事業所名;
    private RString 被保険者番号;
    private RString 宛名名称;
    private RString 申立者区分コード;
    private RString 申立事由コード;
    private FlexibleYearMonth サービス提供年月;
    private FlexibleDate 申立年月日;
    private RString 証記載保険者番号;
}
