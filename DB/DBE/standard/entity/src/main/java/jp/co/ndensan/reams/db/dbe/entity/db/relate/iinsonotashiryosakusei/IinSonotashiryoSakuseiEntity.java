/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.iinsonotashiryosakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用その他資料Entityクラスです。
 *
 * @reamsid_L DBE-0150-170 wangrenze
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class IinSonotashiryoSakuseiEntity {

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
    private RString 左のその他資料イメージ;
    private RString 右のその他資料イメージ;
    private RString その他資料;
    private RString 頁番号;
    private RString chosaGengo;
    private RString sakuseiGengo;
    private RString shinsaGengo;
    private RString shinseiGengo;
    private RString 申請書管理番号;

}
