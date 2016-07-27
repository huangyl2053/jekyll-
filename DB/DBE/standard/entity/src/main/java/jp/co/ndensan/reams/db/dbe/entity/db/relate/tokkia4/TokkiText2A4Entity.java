/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkia4;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項2枚目以降（A4版）のEntityです。
 *
 * @reamsid_L DBE-0150-350 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokkiText2A4Entity {

    private RString 申請書管理番号;
    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 名前;
    private FlexibleDate 認定申請年月日;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 介護認定審査会開催年月日;
    private List<TokkiTextEntity> 短冊テキスト情報リスト;
    private List<TokkiTextEntity> 短冊イメージ情報リスト;
    private RString 特記パターン;
    private RString 特記事項テキスト_イメージ区分;
    private RString 概況特記テキスト_イメージ区分;
    private RString 概況調査の特記事項テキスト;
    private RString 概況調査の特記事項イメージ;
    private boolean is委員用;
    private RString 特記事項Img;
    private RString 特記事項Text;
    private RString 特記Img10;
    private RString 特記Img1;
    private RString 特記Img2;
    private RString 特記Img3;
    private RString 特記Img4;
    private RString 特記Img5;
    private RString 特記Img6;
    private RString 特記Img7;
    private RString 特記Img8;
    private RString 特記Img9;
    private RString 特記Img11;
    private RString 特記Img12;
    private RString 特記Img13;
    private RString 特記Img14;
    private RString 特記Img15;
    private RString 特記Text2;
    private RString 特記Text1;
    private RString 特記Text3;
    private RString 特記Text4;
    private RString 特記Text5;
    private RString 特記Text6;
    private RString 特記Text7;
    private RString 特記Text8;
    private RString 特記Text9;
    private RString 特記Text10;
    private RString 特記Text11;
    private RString 特記Text12;
    private RString 特記Text13;
    private RString 特記Text14;
    private RString 特記Text15;
}
