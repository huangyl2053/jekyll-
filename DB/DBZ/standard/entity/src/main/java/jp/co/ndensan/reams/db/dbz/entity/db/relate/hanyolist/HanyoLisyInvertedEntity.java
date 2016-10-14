/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.hanyolist;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リストのEntityです。
 *
 * @reamsid_L DBZ-4570-020 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoLisyInvertedEntity {

    private RString 項目ID;
    private int 項目位置;
    private RString 帳票表示位置;
    private RString 金額編集;
}
