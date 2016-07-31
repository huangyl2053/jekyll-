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
    private RString tokkiImg1;
    private RString tokkiImg2;
    private RString tokkiImg3;
    private RString tokkiImg4;
    private RString tokkiImg5;
    private RString tokkiImg6;
    private RString tokkiImg7;
    private RString tokkiImg8;
    private RString tokkiImg9;
    private RString tokkiImg10;
    private RString tokkiImg11;
    private RString tokkiImg12;
    private RString tokkiImg13;
    private RString tokkiImg14;
    private RString tokkiImg15;
    private RString tokkiText1;
    private List<TokkiA4Entity> 短冊テキスト情報リスト;
    private List<TokkiA4Entity> 短冊イメージ情報リスト;
    private RString tokkiText2;
    private RString tokkiText3;
    private RString tokkiText4;
    private RString tokkiText5;
    private RString tokkiText6;
    private RString tokkiText7;
    private RString tokkiText8;
    private RString tokkiText9;
    private RString tokkiText10;
    private RString tokkiText11;
    private RString tokkiText12;
    private RString tokkiText13;
    private RString tokkiText14;
    private RString tokkiText15;
    private RString tokkiImg;
    private RString tokkiText;
    private RString 特記事項テキスト_イメージ区分;
    private RString 特記パターン;
}
