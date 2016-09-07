/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項Entityクラスです。
 *
 * @reamsid_L DBE-0150-330 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokkiJikou {

    private RString 事項番号;
    private RString 項目名称;
    private RString テキストとイメージ;
}
