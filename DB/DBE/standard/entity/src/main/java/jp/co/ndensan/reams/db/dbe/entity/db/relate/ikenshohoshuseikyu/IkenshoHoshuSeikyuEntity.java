/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshuseikyu;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBE621004_主治医意見書作成報酬請求書のEntityです。
 *
 * @reamsid_L DBE-1980-042 xuyongchao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoHoshuSeikyuEntity {

    private RString 発行年月日;
    private YubinNo 郵便番号;
    private RString 住所;
    private RString 医療機関;
    private RString 代表者名;
    private RString 帳票タイトル;
    private RString 通知文1;
    private RString 対象期間;
    private RString 請求金額;
    private RString 新規在宅件数;
    private RString 新規在宅単価;
    private RString 新規在宅計;
    private RString 新規施設件数;
    private RString 新規施設単価;
    private RString 新規施設計;
    private RString 更新在宅件数;
    private RString 更新在宅単価;
    private RString 更新在宅計;
    private RString 更新施設件数;
    private RString 更新施設単価;
    private RString 更新施設計;
    private RString 作成件数合計;
    private RString 小計;
    private RString 消費税額;
    private RString 合計金額;
    private RString 通知文2;
}
