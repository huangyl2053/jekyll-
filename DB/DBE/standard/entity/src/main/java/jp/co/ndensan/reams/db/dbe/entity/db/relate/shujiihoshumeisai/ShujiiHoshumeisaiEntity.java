/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のEntityです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiHoshumeisaiEntity {

    private RString 対象期間;
    private RString 保険者名;
    private RString 医療機関名;
    private RString 医師名;
    private RString 印刷日時;
    private RString 頁数;
    private RString 明細番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 生年月日;
    private RString 意見書提出日;
    private RString 新規在宅;
    private RString 新規施設;
    private RString 継続在宅;
    private RString 継続施設;
    private RString 意見書作成料;
    private RString 新規在宅件数;
    private RString 新規施設件数;
    private RString 継続在宅件数;
    private RString 継続施設件数;
    private RString 合計金額;
    private RString 消費税;
    private RString 合計請求額;
    private RString 主治医コード;
}
