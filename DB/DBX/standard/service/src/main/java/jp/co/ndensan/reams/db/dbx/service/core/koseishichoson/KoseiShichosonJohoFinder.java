/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.koseishichoson;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 市町村情報_広域を取得クラスです。
 */
public class KoseiShichosonJohoFinder {

    private final DbT7051KoseiShichosonMasterDac koseiShichosonMasterDac;

    /**
     * コンストラクタです。
     */
    protected KoseiShichosonJohoFinder() {
        koseiShichosonMasterDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     * @param dac DbT7051KoseiShichosonMasterDac
     */
    KoseiShichosonJohoFinder(DbT7051KoseiShichosonMasterDac dac) {
        this.koseiShichosonMasterDac = dac;
    }

    /**
     * KoseiShichosonJohoFinder を生成します。
     *
     * @return KoseiShichosonJohoFinder
     */
    public static KoseiShichosonJohoFinder createInstance() {
        return InstanceProvider.create(KoseiShichosonJohoFinder.class);
    }

    /**
     * 合併前の旧市町村と最新の広域構成市町村を含む全部市町村情報を取得します。
     *
     * @return 全部市町村情報
     */
    public List<KoseiShichosonMaster> get全市町村情報() {
        return toKoseiShichosonList(koseiShichosonMasterDac.zenShichosonJoho());
    }

    private static List<KoseiShichosonMaster> toKoseiShichosonList(List<DbT7051KoseiShichosonMasterEntity> entities) {
        List<KoseiShichosonMaster> list = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : entities) {
            entity.initializeMd5();
            list.add(new KoseiShichosonMaster(entity));
        }
        return list;
    }

    /**
     * 現市町村情報取得を取得します。
     *
     * @return 現市町村情報
     */
    public List<KoseiShichosonMaster> get現市町村情報() {
        return toKoseiShichosonList(koseiShichosonMasterDac.genShichosonJoho());
    }

    /**
     * 指定の地域番号と1桁目が一致する旧市町村をListで取得し返却します。
     *
     * @param 地域番号 地域番号（1桁目を使用する)
     * @return 指定の地域番号と1桁目が一致する旧市町村のList
     */
    public List<KoseiShichosonMaster> get合併旧市町村sBy地域番号(RString 地域番号) {
        return toKoseiShichosonList(koseiShichosonMasterDac.getKouikiKyuShichosonCodeJohoList(地域番号));
    }
}
