/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.shinsakayijidouwaritsuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.kaigoninteishinsakai.KaigoNinteiShinsakaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakayijidouwaritsuke.IShinsaKayiJidouWaritsukeMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査会自動割付クラスです。
 */
public class ShinsaKayiJidouWaritsukeFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsaKayiJidouWaritsukeFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    ShinsaKayiJidouWaritsukeFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsaKayiJidouWaritsukeFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsaKayiJidouWaritsukeFinder}のインスタンス
     */
    public static ShinsaKayiJidouWaritsukeFinder createInstance() {
        return InstanceProvider.create(ShinsaKayiJidouWaritsukeFinder.class);
    }

    /**
     * 審査会自動割付を検索します。
     *
     * @param parametere KaigoNinteiShinsakaiParameter
     * @return 審査会自動割付出力リスト
     */
    @Transaction
    public SearchResult<ShinsaKayiJidouWaritsukeBusiness> getHanteiKekka(KaigoNinteiShinsakaiParameter parametere) {
        List<ShinsaKayiJidouWaritsukeBusiness> kojinJokyoShokaiList = new ArrayList();
        IShinsaKayiJidouWaritsukeMapper mapper = mapperProvider.create(IShinsaKayiJidouWaritsukeMapper.class);
        List<ShinsaKayiJidouWaritsukeRelateEntity> 審査会自動割付出力リスト = mapper.getShinsaKayiJidouWaritsukeList(parametere);
        if (審査会自動割付出力リスト == null || 審査会自動割付出力リスト.isEmpty()) {
            return SearchResult.of(Collections.<ShinsaKayiJidouWaritsukeBusiness>emptyList(), 0, false);
        }
        for (ShinsaKayiJidouWaritsukeRelateEntity entity : 審査会自動割付出力リスト) {
            kojinJokyoShokaiList.add(new ShinsaKayiJidouWaritsukeBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

}
