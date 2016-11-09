/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 受給者台帳情報Entity項目定義クラスです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaDaichoRelateEntity {

    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
}
