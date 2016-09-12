/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.kouhoushajoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.KouhoushaJoho;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.kouhoushajoho.KouhoushaJohoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kouhoushajoho.KouhoushaJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kouhoushajoho.IKouhoushaJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 候補者情報を取得クラスです。
 *
 * @reamsid_L DBD-3530-050 liuyl
 */
public class KouhoushaJohoService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KouhoushaJohoService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KouhoushaJohoService}のインスタンスを返します。
     *
     * @return KouhoushaJohoService
     */
    public static KouhoushaJohoService creatInstence() {
        return InstanceProvider.create(KouhoushaJohoService.class);
    }

    /**
     * 候補者情報を取得する。
     *
     * @param parameter KouhoushaJohoParameter
     * @return List<KouhoushaJoho>
     */
    @Transaction
    public List<KouhoushaJoho> find候補者情報(KouhoushaJohoParameter parameter) {
        IKouhoushaJohoMapper mapper = mapperProvider.create(IKouhoushaJohoMapper.class);
        List<KouhoushaJohoEntity> 候補者情報EntityList = mapper.find候補者情報(parameter);
        if (候補者情報EntityList == null) {
            候補者情報EntityList = new ArrayList<>();
        }
        List<KouhoushaJoho> johoList = new ArrayList<>();
        for (KouhoushaJohoEntity entity : 候補者情報EntityList) {
            KouhoushaJoho joho = new KouhoushaJoho(entity);
            johoList.add(joho);
        }
        return johoList;
    }
}
