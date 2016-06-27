/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho;

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
    private RString 審査会資料作成年;
    private RString 審査会資料作成月;
    private RString 審査会資料作成日;
    private RString 今回認定申請年;
    private RString 今回認定申請月;
    private RString 今回認定申請日;
    private RString 今回認定調査実施年;
    private RString 今回認定調査実施月;
    private RString 今回認定調査実施日;
    private RString 今回認定審査年;
    private RString 今回認定審査月;
    private RString 今回認定審査日;
    private RString sakuseiGengo;
    private RString chosaGengo;
    private RString shinseiGengo;
    private RString shinsaGengo;
    private RString 左の主治医意見書イメージ;
    private RString 右の主治医意見書イメージ;
    private RString 主治医意見書イメージ１;
    private RString 主治医意見書イメージ２;
    private RString 頁番号;

}
