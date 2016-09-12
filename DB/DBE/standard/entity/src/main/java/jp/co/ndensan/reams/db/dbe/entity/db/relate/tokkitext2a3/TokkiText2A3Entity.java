/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext2a3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項Entityクラスです。
 *
 * @reamsid_L DBE-0150-290 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokkiText2A3Entity {

    private RString 申請書管理番号;
    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 名前;
    private RString 審査会資料作成年号;
    private RString 審査会資料作成年;
    private RString 審査会資料作成月;
    private RString 審査会資料作成日;
    private RString 今回認定申請年号;
    private RString 今回認定申請年;
    private RString 今回認定申請月;
    private RString 今回認定申請日;
    private RString 今回認定調査実施年号;
    private RString 今回認定調査実施年;
    private RString 今回認定調査実施月;
    private RString 今回認定調査実施日;
    private RString 今回認定審査年号;
    private RString 今回認定審査年;
    private RString 今回認定審査月;
    private RString 今回認定審査日;
    private RString 特記事項テキスト_イメージ区分;
    private RString 特記パターン;
    private RString tokkiText1;
    private RString tokkiText2;
    private RString tokkiImg1;
    private RString tokkiImg2;
    private List<TokkiJikou> listChosa1;
    private List<TokkiJikou> listChosa2;

}
