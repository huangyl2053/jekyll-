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
 * 給付実績D3・2一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111EKyufuJissekiD32TempEntity {

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
    private RString 特定診療情報レコード順次番号;
    private RString 傷病名;
    private RString 識別番号;
    private int 単位数;
    private int 保険_回数;
    private int 保険_ｻｰﾋﾞｽ単位数;
    private int 保険_合計単位数;
    private int 公費１_回数;
    private int 公費１_ｻｰﾋﾞｽ単位数;
    private int 公費１_合計単位数;
    private int 公費２_回数;
    private int 公費２_ｻｰﾋﾞｽ単位数;
    private int 公費２_合計単位数;
    private int 公費３_回数;
    private int 公費３_ｻｰﾋﾞｽ単位数;
    private int 公費３_合計単位数;
    private RString 摘要;
    private int 後_単位数;
    private int 後_保険_回数;
    private int 後_保険_ｻｰﾋﾞｽ単位数;
    private int 後_保険_合計単位数;
    private int 後_公費１_回数;
    private int 後_公費１_ｻｰﾋﾞｽ単位数;
    private int 後_公費１_合計単位数;
    private int 後_公費２_回数;
    private int 後_公費２_ｻｰﾋﾞｽ単位数;
    private int 後_公費２_合計単位数;
    private int 後_公費３_回数;
    private int 後_公費３_ｻｰﾋﾞｽ単位数;
    private int 後_公費３_合計単位数;
    private int 再審査回数;
    private int 過誤回数;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;
}
