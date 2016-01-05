/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.newoldhihokenshabango;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新旧被保険者番号変換するビジネスです。
 *
 */
public class NewOldHihokenshabango {

    private final DbT7026ShinKyuHihokenshaNoHenkanEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 新旧被保険者番号変換Entity
     */
    public NewOldHihokenshabango(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        this.entity = entity;
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
     * 新番号を返します。
     *
     * @return 新番号
     */
    public RString get新番号() {
        return entity.getKyuNo();
    }

    /**
     * 旧番号を返します。
     *
     * @return 旧番号
     */
    public RString get旧番号() {
        return entity.getKyuNo();
    }

    /**
     * 旧市町村コード２を返します。
     *
     * @return 旧市町村コード２
     */
    public LasdecCode get旧市町村コード２() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 旧番号２を返します。
     *
     * @return 旧番号２
     */
    public RString get旧番号２() {
        return entity.getKyuNo2();
    }

}
