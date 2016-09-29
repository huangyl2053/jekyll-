/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績D3・１一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111DKyufuJissekiD31TempEntity {

    private RString 連番;
    private RString レコード番号;
    private KokanShikibetsuNo 交換情報識別番号;
    private NyuryokuShikibetsuNo 入力識別番号;
    private RString レコード種別コード;
    private HokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 通し番号;
    private RString 特定診療情報レコード順次番号;
    private RString 傷病名;
    private int 保険_指導管理料等;
    private int 保険_単純エックス線;
    private int 保険_リハビリテーション;
    private int 保険_精神科専門療法;
    private int 保険_合計単位数;
    private int 公費１_指導管理料等;
    private int 公費１_単純エックス線;
    private int 公費１_リハビリテーション;
    private int 公費１_精神科専門療法;
    private int 公費１_合計単位数;
    private int 公費２_指導管理料等;
    private int 公費２_単純エックス線;
    private int 公費２_リハビリテーション;
    private int 公費２_精神科専門療法;
    private int 公費２_合計単位数;
    private int 公費３_指導管理料等;
    private int 公費３_単純エックス線;
    private int 公費３_リハビリテーション;
    private int 公費３_精神科専門療法;
    private int 公費３_合計単位数;
    private RString 摘要１;
    private RString 摘要２;
    private RString 摘要３;
    private RString 摘要４;
    private RString 摘要５;
    private RString 摘要６;
    private RString 摘要７;
    private RString 摘要８;
    private RString 摘要９;
    private RString 摘要１０;
    private RString 摘要１１;
    private RString 摘要１２;
    private RString 摘要１３;
    private RString 摘要１４;
    private RString 摘要１５;
    private RString 摘要１６;
    private RString 摘要１７;
    private RString 摘要１８;
    private RString 摘要１９;
    private RString 摘要２０;
    private int 後_保険_指導管理料等;
    private int 後_保険_単純エックス線;
    private int 後_保険_リハビリテーション;
    private int 後_保険_精神科専門療法;
    private int 後_公費１_指導管理料等;
    private int 後_公費１_単純エックス線;
    private int 後_公費１_リハビリテーション;
    private int 後_公費１_精神科専門療法;
    private int 後_公費２_指導管理料等;
    private int 後_公費２_単純エックス線;
    private int 後_公費２_リハビリテーション;
    private int 後_公費２_精神科専門療法;
    private int 後_公費３_指導管理料等;
    private int 後_公費３_単純エックス線;
    private int 後_公費３_リハビリテーション;
    private int 後_公費３_精神科専門療法;
    private int 再審査回数;
    private int 過誤回数;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;

}
