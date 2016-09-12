/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 被保険者証帳票Entity作成クラスです。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshashoChohyoParameter {

    private RString 被保険者番号;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 交付日;
    private RString 保険者;
    private RString 要介護認定状態区分コード;
    private RDate 認定年月日;
    private RDate 認定有効期間開始年月日;
    private RDate 認定有効期間終了年月日;
    private RDate 支給限度有効開始年月日;
    private RDate 支給限度有効終了年月日;
    private Decimal 支給限度単位数;
    private RString 対象区分;
    private List<ShiteiServiceParameter> 指定サービス種類;
    private RString 介護認定審査会意見;
    private List<JushochitokureiTekiParameter> 適用年月日;
    private List<ShutokuTodokedeParameter> 届出年月日;
    private List<NyutaiShoParameter> 入退所年月日;
}
