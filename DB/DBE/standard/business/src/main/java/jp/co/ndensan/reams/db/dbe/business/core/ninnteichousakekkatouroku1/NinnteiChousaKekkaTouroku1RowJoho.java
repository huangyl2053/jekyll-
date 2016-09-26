/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1;

import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 「認定調査結果登録1」画面の利用状況と施設利用フラグ情報クラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinnteiChousaKekkaTouroku1RowJoho {

    private Decimal 利用状況;
    private Boolean 施設利用フラグ;
}
