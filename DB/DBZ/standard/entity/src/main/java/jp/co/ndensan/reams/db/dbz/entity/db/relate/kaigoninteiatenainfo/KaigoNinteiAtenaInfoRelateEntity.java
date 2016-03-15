/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigoninteiatenainfo;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定宛名情報のRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoNinteiAtenaInfoRelateEntity {

    private RString shikibetsuCode;
    private RString shinseishoKanriNo;
    private RString hihokenshaName;
    private RString seinengappiYMD;
    private RString age;
    private RString seibetsu;
    private UaFt200FindShikibetsuTaishoEntity ft200Entity;

}
