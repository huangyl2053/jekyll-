/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績H1一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111AKyufuJissekiH1TempEntity {

    private int 連番;
    private RString レコード番号;
    private KokanShikibetsuNo 交換情報識別番号;
    private NyuryokuShikibetsuNo 入力識別番号;
    private RString レコード種別コード;
    private HokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 給付実績情報作成区分コード;
    private RString 給付実績区分コード;
    private RString 通し番号;
    private RString 公費１_負担者番号;
    private RString 公費１_受給者番号;
    private RString 公費２_負担者番号;
    private RString 公費２_受給者番号;
    private RString 公費３_負担者番号;
    private RString 公費３_受給者番号;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private RString 要介護状態区分コード;
    private RString 旧措置入所者特例コード;
    private FlexibleDate 認定有効期間_開始年月日;
    private FlexibleDate 認定有功期間_終了年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 保険者番号_後期;
    private RString 被保険者番号_後期;
    private RString 保険者番号_国保;
    private RString 被保険者証番号_国保;
    private RString 個人番号_国保;
    private RString 居宅サービス計画作成区分コード;
    private JigyoshaNo 事業所番号_居宅介護支援事業所等;
    private FlexibleDate 開始年月日;
    private FlexibleDate 中止年月日;
    private RString 中止理由_入所_院前の状況コード;
    private FlexibleDate 入所_院年月日;
    private FlexibleDate 退所_院年月日;
    private int 入所_院実日数;
    private int 外泊日数;
    private RString 退所_院後の状態コード;
    private HokenKyufuRitsu 保険給付率;
    private HokenKyufuRitsu 公費１給付率;
    private HokenKyufuRitsu 公費２給付率;
    private HokenKyufuRitsu 公費３給付率;
    private int 前_保険_サービス単位数;
    private Decimal 前_保険_請求額;
    private int 前_保険_利用者負担額;
    private Decimal 前_保険_緊急時施設療養費請求額;
    private Decimal 前_保険_特定診療費請求額;
    private Decimal 前_保険_特定入所者介護サービス費等請求額;
    private int 前_公費１_サービス単位数;
    private int 前_公費１_請求額;
    private int 前_公費１_本人負担額;
    private int 前_公費１_緊急時施設療養費請求額;
    private int 前_公費１_特定診療費請求額;
    private int 前_公費１_特定入所者介護サービス費等請求額;
    private int 前_公費２_サービス単位数;
    private int 前_公費２_請求額;
    private int 前_公費２_本人負担額;
    private int 前_公費２_緊急時施設療養費請求額;
    private int 前_公費２_特定診療費請求額;
    private int 前_公費２_特定入所者介護サービス費等請求額;
    private int 前_公費３_サービス単位数;
    private int 前_公費３_請求額;
    private int 前_公費３_本人負担額;
    private int 前_公費３_緊急時施設療養費請求額;
    private int 前_公費３_特定診療費請求額;
    private int 前_公費３_特定入所者介護サービス費等請求額;
    private int 後_保険_サービス単位数;
    private Decimal 後_保険_請求額;
    private int 後_保険_利用者負担額;
    private Decimal 後_緊急時施設療養費請求額;
    private Decimal 後_保険_特定診療費請求額;
    private int 後_保険_特定入所者介護サービス費等請求額;
    private int 後_公費１_サービス単位数;
    private int 後_公費１_請求額;
    private int 後_公費１_本人負担額;
    private int 後_公費１_緊急時施設療養費請求額;
    private int 後_公費１_特定診療費請求額;
    private int 後_公費１_特定入所者介護サービス費等請求額;
    private int 後_公費２_サービス単位数;
    private int 後_公費２_請求額;
    private int 後_公費２_利用者負担額;
    private int 後_公費２_緊急時施設療養費請求額;
    private int 後_公費２_特定診療費請求額;
    private int 後_公費２_特定入所者介護サービス費等請求額;
    private int 後_公費３_サービス単位数;
    private int 後_公費３_請求額;
    private int 後_公費３_利用者負担額;
    private int 後_公費３_緊急時施設療養費請求額;
    private int 後_公費３_特定診療費請求額;
    private int 後_公費３_特定入所者介護サービス費等請求額;
    private RString 警告区分コード;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 送付年月;
    private FlexibleYearMonth 取込年月;
    private RString 独自作成区分;
    private boolean 保険者保有給付実績情報削除済フラグ;
}
