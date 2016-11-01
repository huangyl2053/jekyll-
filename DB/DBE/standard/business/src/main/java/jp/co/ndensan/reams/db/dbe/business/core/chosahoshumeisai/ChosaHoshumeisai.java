/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahoshumeisai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査報酬支払明細書のHeadクラスです。
 *
 * @reamsid_L DBE-1980-045 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaHoshumeisai {

    private RString 申請書管理番号;
    private RString タイトル;
    private RString 対象期間;
    private RString 保険者名;
    private RString 調査機関名;
    private RString 調査員名;
    private RString 調査員コード;
    private RString 帳票印刷日時;
    private RString ページ数;
    private RString 明細番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 生年月日;
    private RString 調査票提出日;
    private RString 新規申請在宅;
    private RString 新規申請施設;
    private RString 継続申請在宅;
    private RString 継続申請施設;
    private RString 調査票作成料;
    private RString 合計件数新規在宅;
    private RString 合計件数新規施設;
    private RString 合計件数継続在宅;
    private RString 合計件数継続施設;
    private RString 合計金額;
    private RString 消費税;
    private RString 合計請求額;
}
