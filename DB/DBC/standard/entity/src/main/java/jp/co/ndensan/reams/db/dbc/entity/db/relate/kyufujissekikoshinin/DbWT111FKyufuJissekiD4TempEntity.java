/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績D4一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111FKyufuJissekiD4TempEntity {

    private int 連番;
    private RString レコード番号;
    private RString 交換情報識別番号;
    private NyuryokuShikibetsuNo 入力識別番号;
    private RString レコード種別コード;
    private HokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 通し番号;
    private int 基本_提供日数;
    private int 基本_提供単価;
    private int 基本_提供金額;
    private int 特別_提供日数;
    private int 特別_提供単価;
    private int 特別_提供金額;
    private int 食事提供延べ日数;
    private int 公費１対象食事提供延べ日数;
    private int 公費２対象食事提供延べ日数;
    private int 公費３対象食事提供延べ日数;
    private int 食事提供費合計;
    private int 標準負担額_月額;
    private int 食事提供費請求額;
    private int 公費１食事提供費請求額;
    private int 公費２食事提供費請求額;
    private int 公費３食事提供費請求額;
    private int 標準負担額_日額;
    private int 後_基本食提供費用提供単価;
    private int 後_特別食提供費用提供単価;
    private int 後_食事提供費請求額;
    private int 再審査回数;
    private int 過誤回数;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;
}
