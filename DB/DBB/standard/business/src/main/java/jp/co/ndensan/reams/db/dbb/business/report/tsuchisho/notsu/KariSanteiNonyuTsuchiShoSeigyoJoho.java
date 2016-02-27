/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SanteiKiso;

/**
 *
 * 仮算定の納入通知書制御情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteiNonyuTsuchiShoSeigyoJoho {

    private NonyuTsuchiShoSeigyoJoho 納入通知書制御情報;
    private SanteiKiso 算定の基礎1;
    private SanteiKiso 算定の基礎2;
    private SanteiKiso 算定の基礎3;

}
