/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd4100001;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 市町村コードによる市町村情報取得のクラスです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
public final class ShichosonCodeYoriShichosonJoho {

    private static DbT7051KoseiShichosonMasterDac 構成市町村Dac;

    /**
     * コンストラクタです。
     */
    private ShichosonCodeYoriShichosonJoho() {
    }

    /**
     * 市町村コードによる市町村情報を取得する(Batch用)
     *
     * @param 市町村コード LasdecCode
     * @return DbT7051KoseiShichosonMasterEntity
     */
    public static DbT7051KoseiShichosonMasterEntity getShichosonCodeYoriShichosonJoho(LasdecCode 市町村コード) {

        構成市町村Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);

        List<DbT7051KoseiShichosonMasterEntity> entitys = 構成市町村Dac.shichosonCodeYoriShichosonJoho(市町村コード);
        if (entitys != null && !entitys.isEmpty()) {
            return entitys.get(0);
        } else {
            DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
            entity.setGaikokujinHyojiHouhou(RString.EMPTY);
            entity.setGappeiChiikiNo(RString.EMPTY);
            entity.setGappeiKyuShichosonHyojiUmu(RString.EMPTY);
            entity.setGappeiKyuShichosonKubun(RString.EMPTY);
            entity.setGunMeisho(RString.EMPTY);
            return entity;
        }
    }
}
