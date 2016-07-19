/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;

/**
 * 仮算定異動（一括）結果一覧表のEntityクラスです。
 *
 * @reamsid_L DBB-0850-020 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiIdoKekkaEntity implements Serializable {

    private DbT2015KeisangoJohoEntity 計算後情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private KozaRelateEntity 口座;
}
