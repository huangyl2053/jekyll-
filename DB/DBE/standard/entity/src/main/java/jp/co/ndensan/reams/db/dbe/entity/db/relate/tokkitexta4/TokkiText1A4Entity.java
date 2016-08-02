/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項（A4版）のEntityです。
 *
 * @reamsid_L DBE-0150-340 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokkiText1A4Entity {

    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 申請書管理番号;
    private RString 名前;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 認定申請年月日;
    private FlexibleDate 介護認定審査会開催年月日;
    private RString 概況特記テキスト_イメージ区分;
    private RString 概況調査の特記事項テキスト;
    private RString 概況調査の特記事項イメージ;
    private boolean is委員用;
    private List<TokkiA4Entity> 短冊情報リスト;
    private RString tokkiImg;
    private RString tokkiText;
    private RString 特記事項テキスト_イメージ区分;
    private RString 特記パターン;
}
