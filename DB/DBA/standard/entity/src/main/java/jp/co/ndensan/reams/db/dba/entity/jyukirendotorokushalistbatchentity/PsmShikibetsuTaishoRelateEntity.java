/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;

/**
 * 宛名識別対象Entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PsmShikibetsuTaishoRelateEntity {

    private AtenaMeisho meisho;
    private AtenaKanaMeisho kanaMeisho;
    private SetaiCode setaiCode;
}
