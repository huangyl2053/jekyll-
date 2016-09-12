/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬支払明細書のHeadクラスです。
 *
 * @reamsid_L DBE-1980-046 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsainShiharaimeisaisho {

    private RString タイトル;
    private RString 対象期間;
    private RString 保険者名;
    private RString 審査委員名;
    private RString 審査委員コード;
    private RString 帳票印刷日時;
    private RString ページ数;
    private RString 明細番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 生年月日;
    private RString 査会開催年月日;
    private RString 報酬総額;
    private RString 費用弁償;
    private RString 税額控除;
    private RString 報酬合計;
    private RString 合計金額;
    private RString 消費税;
    private RString 合計請求額;
}
