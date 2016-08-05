/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5120001;

import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseitorokuuketsuke.NinteiShinseiTorokuUketsukeBusiness;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5120001.NinteiShinseiTorokuUketsukeParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5120001.NinteiShinseiTorokuUketsukeEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseitorokuuketsuke.INinteiShinseiTorokuUketsukeMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請受付表示情報を取得する
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsukeManager {

    private final MapperProvider mapperProvider;

    NinteiShinseiTorokuUketsukeManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    NinteiShinseiTorokuUketsukeManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * NinteiShinseiTorokuUketsukeManagerのインスタンス化
     *
     * @return NinteiShinseiTorokuUketsukeManager
     */
    public static NinteiShinseiTorokuUketsukeManager createInstance() {
        return InstanceProvider.create(NinteiShinseiTorokuUketsukeManager.class);
    }

    /**
     * 初期化情報情報の検索
     *
     * @param param NinteiShinseiTorokuUketsukeParameter
     * @return NinteiShinseiTorokuUketsukeBusiness
     */
    @Transaction
    public NinteiShinseiTorokuUketsukeBusiness get初期化情報(NinteiShinseiTorokuUketsukeParameter param) {

        INinteiShinseiTorokuUketsukeMapper mapper = mapperProvider.create(INinteiShinseiTorokuUketsukeMapper.class);

        NinteiShinseiTorokuUketsukeEntity resultEntity
                = mapper.get初期化情報(param);
        if (resultEntity != null) {
            return new NinteiShinseiTorokuUketsukeBusiness(resultEntity);
        } else {
            return null;
        }
    }
}
