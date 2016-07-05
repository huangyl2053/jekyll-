/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用主治医意見書Entityクラスです。
 *
 * @reamsid_L DBE-0150-090 wangrenze
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiikenshoEntity {

    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 名前;
    private FlexibleDate 審査会資料作成年月日;
    private FlexibleDate 認定申請年月日;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 介護認定審査会開催年月日;
    private RString 左の主治医意見書イメージ;
    private RString 右の主治医意見書イメージ;
    private RString 主治医意見書イメージ１;
    private RString 主治医意見書イメージ２;
    private RString 頁番号;

}
