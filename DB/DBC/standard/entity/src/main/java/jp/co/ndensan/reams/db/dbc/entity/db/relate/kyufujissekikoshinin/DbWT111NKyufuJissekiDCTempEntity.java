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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績DC一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111NKyufuJissekiDCTempEntity {

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
    private RString 摘要2;
    private RString 摘要３;
    private RString 摘要４;
    private RString 摘要５;
    private RString 摘要６;
    private RString 摘要７;
    private RString 摘要８;
    private RString 摘要９;
    private RString 摘要10;
    private RString 摘要11;
    private RString 摘要12;
    private RString 摘要13;
    private RString 摘要14;
    private RString 摘要15;
    private RString 摘要16;
    private RString 摘要17;
    private RString 摘要18;
    private RString 摘要19;
    private RString 摘要20;
    private int 緊急時施設療養費合計点数;
    private RString 所定疾患施設療養費傷病名１;
    private RString 所定疾患施設療養費傷病名２;
    private RString 所定疾患施設療養費傷病名３;
    private FlexibleDate 所定疾患施設療養費開始年月日１;
    private FlexibleDate 所定疾患施設療養費開始年月日２;
    private FlexibleDate 所定疾患施設療養費開始年月日３;
    private int 所定疾患施設療養費単位数;
    private int 所定疾患施設療養費日数;
    private int 所定疾患施設療養費小計;
    private int 後_往診日数;
    private int 後_通院日数;
    private int 後_緊急時治療管理単位数;
    private int 後_緊急時治療管理日数;
    private int 後_リハビリテーション点数;
    private int 後_処置点数;
    private int 後_手術点数;
    private int 後_麻酔点数;
    private int 後_放射線治療点数;
    private int 後_所定疾患施設療養費単位数;
    private int 後_所定疾患施設療養費日数;
    private int 再審査回数;
    private int 過誤回数;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;
}
