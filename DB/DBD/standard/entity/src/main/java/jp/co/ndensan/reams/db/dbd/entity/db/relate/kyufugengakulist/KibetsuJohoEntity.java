/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;

/**
 * 期別情報のRelateEntityクラスです。
 *
 * @reamsid_L DBD-3610-050 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KibetsuJohoEntity {

    private DbT2003KibetsuEntity 期別Entity;
    private ChoteiRelateEntity 調定関連;
    private DbT4023JikoKisambiKanriEntity 時効起算日管理Entity;

}
