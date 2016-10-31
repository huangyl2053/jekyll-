/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護対象者抽出（遡及分）
 *
 * @reamsid_L DBC-5750-050 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiKaKuiDoDeTaEntity {

    private ShikibetsuCode 識別コード;
    private HihokenshaNo 被保険者番号;
    private RString 世帯コード;
    private FlexibleYear 賦課年度;
    private FlexibleYearMonth 年月;
    private FlexibleDate 年月日;
    private RString 抽出_マスタ;
    private RString 抽出_事由;
    private RString 抽出_識別コード;
    private RString 抽出_マスタ1;
    private RString 抽出_マスタ2;
    private RString 抽出_マスタ3;
    private RString 抽出_マスタ4;
    private RString 抽出_マスタ5;
    private RString 抽出_マスタ6;
    private RString 抽出_マスタ7;
    private RString 抽出_マスタ8;
    private RString 抽出_マスタ9;
    private RString 抽出_マスタ10;
    private RString 抽出_事由1;
    private RString 抽出_事由2;
    private RString 抽出_事由3;
    private RString 抽出_事由4;
    private RString 抽出_事由5;
    private RString 抽出_事由6;
    private RString 抽出_事由7;
    private RString 抽出_事由8;
    private RString 抽出_事由9;
    private RString 抽出_事由10;
    private RString 抽出_識別コード1;
    private RString 抽出_識別コード2;
    private RString 抽出_識別コード3;
    private RString 抽出_識別コード4;
    private RString 抽出_識別コード5;
    private RString 抽出_識別コード6;
    private RString 抽出_識別コード7;
    private RString 抽出_識別コード8;
    private RString 抽出_識別コード9;
    private RString 抽出_識別コード10;
    private RString 交換情報識別番号;
    private RString 入力識別番号;
    private RString レコード種別コード;
    private RString 給付実績情報作成区分コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号基本;
    private RString サービス提供年月;
    private RString 給付実績区分コード;
    private RString 事業所番号;
    private RString 通し番号;
    private RString 公費１負担者番号;
    private RString 公費１受給者番号;
    private RString 公費２負担者番号;
    private RString 公費２受給者番号;
    private RString 公費３負担者番号;
    private RString 公費３受給者番号;
    private RString 生年月日;
    private RString 性別コード;
    private RString 要介護状態区分コード;
    private RString 旧措置入所者特例コード;
    private RString 認定有効期間開始年月日;
    private RString 認定有功期間終了年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 保険者番号後期;
    private RString 被保険者番号後期;
    private RString 保険者番号国保;
    private RString 被保険者証番号国保;
    private RString 個人番号国保;
    private RString 居宅サービス計画作成区分コード;
    private RString 事業所番号居宅介護支援事業所等;
    private RString 開始年月日;
    private RString 中止年月日;
    private RString 中止理由入所院前の状況コード;
    private RString 入所院年月日;
    private RString 退所院年月日;
    private int 入所院実日数;
    private int 外泊日数;
    private RString 退所院後の状態コード;
    private RString 保険給付率;
    private RString 公費１給付率;
    private RString 公費２給付率;
    private RString 公費３給付率;
    private int 前保険サービス単位数;
    private Decimal 前保険請求額;
    private RString 前保険利用者負担額;
    private Decimal 前保険緊急時施設療養費請求額;
    private Decimal 前保険特定診療費請求額;
    private RString 前保険特定入所者介護サービス費等請求額;
    private int 前公費１サービス単位数;
    private int 前公費１請求額;
    private int 前公費１本人負担額;
    private int 前公費１緊急時施設療養費請求額;
    private int 前公費１特定診療費請求額;
    private int 前公費１特定入所者介護サービス費等請求額;
    private int 前公費２サービス単位数;
    private int 前公費２請求額;
    private int 前公費２本人負担額;
    private int 前公費２緊急時施設療養費請求額;
    private int 前公費２特定診療費請求額;
    private int 前公費２特定入所者介護サービス費等請求額;
    private int 前公費３サービス単位数;
    private int 前公費３請求額;
    private int 前公費３本人負担額;
    private int 前公費３緊急時施設療養費請求額;
    private int 前公費３特定診療費請求額;
    private int 前公費３特定入所者介護サービス費等請求額;
    private int 後保険サービス単位数;
    private Decimal 後保険請求額;
    private int 後保険利用者負担額;
    private Decimal 後緊急時施設療養費請求額;
    private Decimal 後保険特定診療費請求額;
    private int 後保険特定入所者介護サービス費等請求額;
    private int 後公費１サービス単位数;
    private int 後公費１請求額;
    private int 後公費１本人負担額;
    private int 後公費１緊急時施設療養費請求額;
    private int 後公費１特定診療費請求額;
    private int 後公費１特定入所者介護サービス費等請求額;
    private int 後公費２サービス単位数;
    private int 後公費２請求額;
    private int 後公費２利用者負担額;
    private int 後公費２緊急時施設療養費請求額;
    private int 後公費２特定診療費請求額;
    private int 後公費２特定入所者介護サービス費等請求額;
    private int 後公費３サービス単位数;
    private int 後公費３請求額;
    private int 後公費３利用者負担額;
    private int 後公費３緊急時施設療養費請求額;
    private int 後公費３特定診療費請求額;
    private int 後公費３特定入所者介護サービス費等請求額;
    private RString 警告区分コード;
    private RString 審査年月;
    private RString 整理番号;
    private RString 送付年月;
    private RString 取込年月;
    private RString 独自作成区分;
    private boolean 保険者保有給付実績情報削除済フラグ;
    private RString 被保険者年月識別区分事業所;
}
