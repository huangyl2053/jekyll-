/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用主治医意見書のEntityクラスです。
 *
 * @reamsid_L DBE-0150-140 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiikenshoItem {

    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 名前;
    private FlexibleDate 審査会資料作成年月日;
    private FlexibleDate 今回認定申請年月日;
    private FlexibleDate 今回認定調査実施年月日;
    private FlexibleDate 今回認定審査年月日;
    private RString 左の主治医意見書イメージ;
    private RString 右の主治医意見書イメージ;
    private RString 主治医意見書イメージ一頁目;
    private RString 主治医意見書イメージ二頁目;
    private RString 頁番号;

}
