package jp.co.ndensan.reams.db.dbz.business.core.hihokenshaatenafinder;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;

/**
 * ビジネス設計_DBUMN00000_被保険者・宛名情報取得。
 *
 * @reamsid_L DBC-0980-590 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaAtenaResult {

    private DbV1001HihokenshaDaichoEntity entity;
    private IShikibetsuTaisho 識別対象;

    /**
     * コンストラクタです。
     *
     * @param entity DbV1001HihokenshaDaichoEntity
     * @param 識別対象 IShikibetsuTaisho
     */
    public HihokenshaAtenaResult(DbV1001HihokenshaDaichoEntity entity, IShikibetsuTaisho 識別対象) {
        this.entity = entity;
        this.識別対象 = 識別対象;
    }
}
