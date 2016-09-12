/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei;

/**
 * 判定対象者エンティティのクラスです。
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiTaishoshaEntity {

    private SogoJigyoTaishoshaTempEntity 総合事業対象者台帳;
    private JukyushaDaichoTempEntity 受給者台帳;

}
