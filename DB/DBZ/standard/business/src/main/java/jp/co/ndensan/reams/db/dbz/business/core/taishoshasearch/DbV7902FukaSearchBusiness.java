/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.taishoshasearch;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 *
 * @author n2810
 */
public class DbV7902FukaSearchBusiness {

    private final DbV7902FukaSearchEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 要介護認定申請情報(受給)Entity
     */
    public DbV7902FukaSearchBusiness(DbV7902FukaSearchEntity entity) {
        this.entity = entity;
    }

    /**
     * choteiNendoのgetメソッドです。
     *
     * @return choteiNendo
     */
    public FlexibleYear getChoteiNendo() {
        return this.entity.getChoteiNendo();
    }

    /**
     * fukaNendoのgetメソッドです。
     *
     * @return fukaNendo
     */
    public FlexibleYear getFukaNendo() {
        return this.entity.getFukaNendo();
    }

    /**
     * tsuchishoNoのgetメソッドです。
     *
     * @return tsuchishoNo
     */
    public TsuchishoNo getTsuchishoNo() {
        return this.entity.getTsuchishoNo();
    }

    /**
     * hihokenshaNoのgetメソッドです。
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return this.entity.getHihokenshaNo();
    }

    /**
     * shikibetsuCodeのgetメソッドです。
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return this.entity.getShikibetsuCode();
    }

    /**
     * hihodaichoHihokenshaNoのgetメソッドです。
     *
     * @return hihodaichoHihokenshaNo
     */
    public HihokenshaNo getHihodaichoHihokenshaNo() {
        return this.entity.getHihodaichoHihokenshaNo();
    }

}
