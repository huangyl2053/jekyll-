/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosaitakusakimaster;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosaitakusakimaster.INinteichosaItakusakiMasterMapper;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusaki.NinteichosaItakusakiKensakuParameter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class NinteichosaItakusakiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteichosaItakusakiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShichosonMasterManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoseiShichosonMasterManager}のインスタンス
     */
    public static NinteichosaItakusakiManager createInstance() {
        return InstanceProvider.create(NinteichosaItakusakiManager.class);
    }

    /**
     * 認定調査委託先マスタ検索のリストを取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntityの{@code list}
     */
    public List<KoseiShichosonMaster> ninteichosaItakusakiSearch(NinteichosaItakusakiKensakuParameter 構成市町村マスタ検索条件) {
        INinteichosaItakusakiMasterMapper mapper = mapperProvider.create(INinteichosaItakusakiMasterMapper.class);
        List<KoseiShichosonMasterRelateEntity> entitys
                = mapper.ninteichosaItakusakiSearch(構成市町村マスタ検索条件);
        List<KoseiShichosonMaster> list = new ArrayList<>();
        for (KoseiShichosonMasterRelateEntity relateEntity : entitys) {
            list.add(new KoseiShichosonMaster(relateEntity));
        }
        return list;
    }
}
