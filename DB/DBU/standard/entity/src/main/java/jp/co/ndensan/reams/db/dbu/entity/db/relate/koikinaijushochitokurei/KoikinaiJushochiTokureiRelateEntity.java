/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.entity.db.relate.koikinaijushochitokurei;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 *
 *  広住特適用情報のエンティティクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KoikinaiJushochiTokureiRelateEntity {
    
    private DbT1001HihokenshaDaichoEntity dbT1001Entity;
    private UaFt200FindShikibetsuTaishoEntity ft200Entity;
}
