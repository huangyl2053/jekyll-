/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定データ出力RelateEntityです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchijiHanteizumiDataShutsuryokuRelateEntity {

    private RString shinseishoKanriNo;
    private RString koroshoIfShikibetsuCode;
    private RString shoKisaiHokenshaNo;
    private RString shichosonMeisho;
    private RString ninteiShinseiYMD;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString ninteiShinseiShinseijiKubunCode;
    private RString ninteiShinseiHoreiKubunCode;
    private RString ichijiHanteiYMD;
    private RString ichijiHanteiKekkaCode;
    private RString ichijihanteiChushutsuYMD;
    private RString ichijiHnateiKeikokuCode;

}
