/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkitexta3;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用概況特記Entityクラスです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class GaikyotokkiTextA4Entity {

    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 名前;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 認定申請年月日;
    private FlexibleDate 介護認定審査会開催年月日;
    private RString 概況特記Img;
    private RString two_概況特記Img;
    private RString 概況特記Text;
    private RString 住宅改修Img;
    private RString 市町村特別給付のサービス種類名Img;
    private RString 介護保険給付外の在宅サービス種類名Img;
    private RString 調査対象者の主訴Img;
    private RString 調査対象者の家族状況立会者Img;
    private RString 調査対象者の居住環境Img;
    private RString その他Img;
    private RString 頁番号;
    private RString 住宅改修Text;
    private RString 市町村特別給付のサービス種類名Text;
    private RString 介護保険給付外の在宅サービス種類名Text;
    private RString 調査対象者の主訴Text;
    private RString 調査対象者の家族状況立会者Text;
    private RString 調査対象者の居住環境Text;
    private RString その他Text;
    private RString 主治医意見書イメージ1;
    private RString 主治医意見書イメージ2;

}
