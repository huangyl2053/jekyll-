/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import java.util.List;

/**
 * 要介護認定情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiJohoEntity {

    private SentoEntity 先頭Entity;
    private List<NinteiKekkaJohoEntity> 要介護認定情報;

}
