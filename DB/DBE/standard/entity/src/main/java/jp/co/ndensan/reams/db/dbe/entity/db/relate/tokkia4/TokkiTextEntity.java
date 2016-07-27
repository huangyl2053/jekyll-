/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkia4;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項2枚目以降（A4版）のEntityです。
 *
 * @reamsid_L DBE-0150-350 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokkiTextEntity {

    private RString 事項番号;
    private RString 項目名称;
}
