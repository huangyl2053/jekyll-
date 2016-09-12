/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項Entity。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokkiText1A4Entity {

    private List<TokkiTextEntity> 特記事項リスト;
    private List<TokkiTextEntity> 特記事項番号リスト;
    private RString 特記事項イメージ;
    private List<TokkiTextEntity> 特記事項イメージリスト;
    private RString 厚労省IF識別コード;

}
