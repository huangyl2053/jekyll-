/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;

/**
 * 計算後情報と宛名識別対象PSM、口座情報取得PSMをもとに取得した情報
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsenteiKeisangojohoEntity {

    private DbT2015KeisangoJohoEntity 計算後情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private KozaRelateEntity 口座;
}
