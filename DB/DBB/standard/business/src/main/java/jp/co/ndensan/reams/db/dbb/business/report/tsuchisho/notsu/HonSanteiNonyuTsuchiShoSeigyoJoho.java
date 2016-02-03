/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KanendoMongon;

/**
 *
 * 本算定納入通知書制御情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonSanteiNonyuTsuchiShoSeigyoJoho {

    private NonyuTsuchiShoSeigyoJoho 納入通知書制御情報;
    private KanendoMongon 過年度文言1;
    private KanendoMongon 過年度文言2;

}
