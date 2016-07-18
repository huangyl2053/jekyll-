/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査票概況調査サービスの状況RelateEntityクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosahyoServiceJokyoRelateEntity {

    private RString shinseishoKanriNo;
    private RString koroshoIfShikibetsuCode;
    private RString remban;
    private RString serviceJokyo;
    private RString zenkaiShinseishoKanriNo;
    private RString researchItem;
    private RString ikenItem;
}
