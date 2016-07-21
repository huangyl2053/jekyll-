/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko;

/**
 * 基準日時点で指定の被保険者が受給者もしくは事業対象者かを判定する結果エンティティクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@lombok.Setter
public class JukyushaSogoJigyoTaishoshaHantei {

    private boolean is受給者;
    private boolean is総合事業対象者;
}
