/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkajohoshutsuryoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力対象者明細一覧用RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HanteiKekkaJohoShutsuryokuRelateEntity {

    private RString shinsakaiKaisaiNo;
    private RString ninteiShinseiYMD;
    private RString shinsakaiKaisaiYMD;
    private RString hihokenshaNo;
    private RString hihokenshaKana;
    private RString hihokenshaName;
    private RString seinengappiYMD;
    private RString seibetsu;
    private RString nijiHanteiKekka;
}
