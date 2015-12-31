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
public class NewOldHihokenshabangoBusiness {

    private final DbT7026ShinKyuHihokenshaNoHenkanEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 新旧被保険者番号変換Entity
     */
    public NewOldHihokenshabangoBusiness(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * getShinNo
     *
     * @return shinNo
     */
    public RString getShinNo() {
        return entity.getKyuNo();
    }

    /**
     * getKyuNo
     *
     * @return kyuNo
     */
    public RString getKyuNo() {
        return entity.getKyuNo();
    }

    /**
     * getKyuShichosonCode
     *
     * @return kyuShichosonCode
     */
    public LasdecCode getKyuShichosonCode() {
        return entity.getKyuShichosonCode();
    }

    /**
     * getKyuNo2
     *
     * @return kyuNo2
     */
    public RString getKyuNo2() {
        return entity.getKyuNo2();
    }

}
