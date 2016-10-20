/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 所得照会票一括発行（バッチ）のクラス
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class Shotokushokaihyo {

    private final DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;

    Shotokushokaihyo() {
        構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link Shotokushokaihyo}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link Shotokushokaihyo}のインスタンス
     */
    public static Shotokushokaihyo createInstance() {
        return InstanceProvider.create(Shotokushokaihyo.class);
    }

    /**
     * 市町村識別IDを取得のメソッドです。
     *
     * @param 市町村コード LasdecCode
     * @return RString
     */
    public RString get市町村識別ID(LasdecCode 市町村コード) {
        if (市町村コード == null) {
            return RString.EMPTY;
        }
        DbT7051KoseiShichosonMasterEntity 構成市町村マスタEntity = 構成市町村マスタDac.selectBy市町村コード(市町村コード);
        if (構成市町村マスタEntity == null) {
            return RString.EMPTY;
        }
        return 構成市町村マスタEntity.getShichosonShokibetsuID();
    }
}
