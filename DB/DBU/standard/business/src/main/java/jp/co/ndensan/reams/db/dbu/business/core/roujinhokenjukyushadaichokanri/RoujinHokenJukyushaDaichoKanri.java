/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.roujinhokenjukyushadaichokanri;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老人保健受給者情報を管理するビジネスです。
 *
 */
public class RoujinHokenJukyushaDaichoKanri {

    private final DbT7005RojinHokenJukyushaJohoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 被保険者台帳管理Entity
     */
    public RoujinHokenJukyushaDaichoKanri(DbT7005RojinHokenJukyushaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 老人保健市町村コードを返します。
     *
     * @return 老人保健市町村コード
     */
    public LasdecCode get老人保健市町村コード() {
        return entity.getRojinHokenShichosonCode();
    }

    /**
     * 老人保健受給者番号を返します。
     *
     * @return 老人保健受給者番号
     */
    public RString get老人保健受給者番号() {
        return entity.getRojinHokenJukyushaNo();
    }
}
