/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成介護住民票個別事項連携情報RelateEntityクラスです。
 *
 * @reamsid_L DBU-0350-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KaigoJuminhyoRelateEntity implements Cloneable, Serializable {

    private RString 広域運用_shichosonCode;
    private RString 広域運用_shikibetsuCode;

    /**
     * @param dbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity
     */
    private final DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity;

    /**
     * @param dbT4001JukyushaDaichoEntity 受給者台帳Entity
     */
    private final DbT4001JukyushaDaichoEntity dbT4001JukyushaDaichoEntity;

    /**
     * コンストラクタです。
     */
    public KaigoJuminhyoRelateEntity() {
        dbT1001HihokenshaDaichoEntity = new DbT1001HihokenshaDaichoEntity();
        dbT4001JukyushaDaichoEntity = new DbT4001JukyushaDaichoEntity();
    }
}
