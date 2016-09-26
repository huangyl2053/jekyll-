/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001;

import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 項目設定Entity
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OutFilekekka {

    private RString 識別コード;
    private RString 識別コード名称;
    private RString 保険者番号;
    private RString 被保険者番号;
    private FlexibleDate 認定申請日;
    private RString 枝番;
    private RString 申請区分_法令_コード;
    private RString 申請区分_法令_コード名称;
    private RString 申請区分_申請時_コード;
    private RString 申請区分_申請時_コード名称;
    private RString 取下区分コード;
    private RString 取下区分コード名称;
    private RString 被保険者区分コード;
    private RString 被保険者区分コード名称;
    private RString 申請代行区分コード;
    private RString 申請代行区分コード名称;
    private FlexibleDate 生年月日;
    private RString 年齢;
    private RString 性別コード;
    private RString 性別コード名称;
    private RString 被保険者ｶﾅ氏名;
    private RString 被保険者漢字氏名;
    private YubinNo 郵便番号;
    private RString 住所;
    private TelNo 電話番号;
    private RString 病院施設等の名称;
    private RString 病院施設等の所在地;
    private RString 前回の認定審査会結果;
    private RString 前回の認定審査会結果名称;
    private FlexibleDate 前回の認定有効期間_開始;
    private FlexibleDate 前回の認定有効期間_終了;
    private RString 主治医医療機関番号;
    private RString 主治医番号;
    private FlexibleDate 意見書依頼日;
    private FlexibleDate 意見書入手日;
    private RString 意見書_短期記憶;
    private RString 意見書_認知能力;
    private RString 意見書_伝達能力;
    private RString 意見書_食事行為;
    private RString 意見書_認知症高齢者の日常生活自立度;
    private FlexibleDate 調査依頼日;
    private FlexibleDate 調査実施日;
    private RString 指定居宅介護支援事業者等番号;
    private RString 委託区分;
    private RString 委託区分名称;
    private RString 認定調査員番号;
    private RString 認定調査員資格コード;
    private RString 認定調査員資格コード名称;
    private FlexibleDate 一次判定日;
    private RString 一次判定結果;
    private RString 一次判定結果名称;
    private RString 一次判定結果_認知症加算;
    private RString 一次判定結果_認知症加算_名称;
    private FlexibleDate 認定審査会資料作成日;
    private FlexibleDate 認定審査会予定日;
    private RString 合議体番号;
    private RString 審査会資料番号;
    private FlexibleDate 二次判定日;
    private RString 二次判定結果;
    private RString 二次判定結果名称;
    private FlexibleDate 認定有効期間_開始;
    private FlexibleDate 認定有効期間_終了;
    private RString 特定疾病コード;
    private RString 特定疾病コード名称;
    private RString 要介護1の場合の状態像;
    private RString 要介護1の場合の状態像名称;
    private RString 現在のサービス区分コード;
    private RString 現在のサービス区分コード名称;
    private RString 現在の状況;
    private RString 現在の状況名称;

}
