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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績D2一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111CKyufuJissekiD2TempEntity {

    private int 連番;
    private RString レコード番号;
    private KokanShikibetsuNo 交換情報識別番号;
    private NyuryokuShikibetsuNo 入力識別番号;
    private RString レコード種別コード;
    private HokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 通し番号;
    private RString 緊急時施設療養情報レコード順次番号;
    private RString 緊急時傷病名１;
    private RString 緊急時傷病名２;
    private RString 緊急時傷病名３;
    private FlexibleDate 緊急時治療開始年月日１;
    private FlexibleDate 緊急時治療開始年月日２;
    private FlexibleDate 緊急時治療開始年月日３;
    private int 往診日数;
    private RString 往診医療機関名;
    private int 通院日数;
    private RString 通院医療機関名;
    private int 緊急時治療管理単位数;
    private int 緊急時治療管理日数;
    private int 緊急時治療管理小計;
    private int リハビリテーション点数;
    private int 処置点数;
    private int 手術点数;
    private int 麻酔点数;
    private int 放射線治療点数;
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
    private int 緊急時施設療養費合計点数;
    private int 後_往診日数;
    private int 後_通院日数;
    private int 後_緊急時治療管理単位数;
    private int 後_緊急時治療管理日数;
    private int 後_リハビリテーション点数;
    private int 後_処置点数;
    private int 後_手術点数;
    private int 後_麻酔点数;
    private int 後_放射線治療点数;
    private int 再審査回数;
    private int 過誤回数;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;

}
