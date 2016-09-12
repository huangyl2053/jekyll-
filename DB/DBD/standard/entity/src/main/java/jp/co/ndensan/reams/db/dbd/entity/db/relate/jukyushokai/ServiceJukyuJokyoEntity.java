/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai;

/**
 * サービス受給状況エンティティです。
 *
 * @reamsid_L DBD-3560-011 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceJukyuJokyoEntity {

    private boolean had負担限度額認定;
    private boolean had利用者負担減免;
    private boolean had訪問介護減免;
    private boolean had社福軽減;
    private boolean had特地減免;
    private boolean had施設入退所;
    private boolean had老齢受給;
    private boolean had生保受給;
    private boolean had医療保険加入;
    private boolean had居宅届出;
    private boolean hadBeen総合事業対象;
    private boolean had非課税年金受給;

}
