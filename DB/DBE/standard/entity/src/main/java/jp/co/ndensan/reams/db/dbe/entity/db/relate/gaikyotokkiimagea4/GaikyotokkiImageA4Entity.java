/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkiimagea4;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局概況特記のEntityです。
 *
 * @reamsid_L DBE-0150-370 wangrenze
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class GaikyotokkiImageA4Entity {

    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 申請書管理番号;
    private RString 名前;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 認定申請年月日;
    private FlexibleDate 介護認定審査会開催年月日;
    private RString 概況特記テキスト_イメージ区分;
    private RString 住宅改修テキスト;
    private RString 市町村特別給付のサービス種類名テキスト;
    private RString 介護保険給付外の在宅サービス種類名テキスト;
    private RString 概況特記事項_主訴_テキスト;
    private RString 概況特記事項_家族状況_テキスト;
    private RString 概況特記事項_居住環境_テキスト;
    private RString 概況特記事項_機器_機械_テキスト;

}
