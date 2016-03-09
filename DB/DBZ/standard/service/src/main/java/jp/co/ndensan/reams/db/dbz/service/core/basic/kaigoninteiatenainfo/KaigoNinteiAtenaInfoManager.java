/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic.kaigoninteiatenainfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.kaigoninteiatenainfo.KaigoNinteiAtenaInfoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kaigoninteiatenainfo.KaigoNinteiAtenaInfoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigoninteiatenainfo.KaigoNinteiAtenaInfoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.mapper.kaigoninteiatenainfo.IKaigoNinteiAtenaInfoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 介護認定宛名情報クラスです。
 */
public class KaigoNinteiAtenaInfoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KaigoNinteiAtenaInfoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    KaigoNinteiAtenaInfoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoNinteiAtenaInfoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoNinteiAtenaInfoManager}のインスタンス
     */
    public static KaigoNinteiAtenaInfoManager createInstance() {
        return InstanceProvider.create(KaigoNinteiAtenaInfoManager.class);
    }

    /**
     * パラメータ．モード：2(スケジュール照会)の場合、画面の検索条件より、介護認定宛名情報を検索する。
     *
     * @param parametere KaigoNinteiAtenaInfoParameter
     * @return 判定結果情報出力リスト
     */
    @Transaction
    public SearchResult<KaigoNinteiAtenaInfoBusiness> getKaigoNinteiAtenaInfo(KaigoNinteiAtenaInfoParameter parametere) {
        List<KaigoNinteiAtenaInfoBusiness> kojinJokyoShokaiList = new ArrayList();
        IKaigoNinteiAtenaInfoMapper mapper = mapperProvider.create(IKaigoNinteiAtenaInfoMapper.class);
        if (parametere.get識別コード().isNullOrEmpty() && parametere.get申請書管理番号().isNullOrEmpty()) {
            List<KaigoNinteiAtenaInfoRelateEntity> 介護認定宛名情報リスト = mapper.getKaigoNinteiAtenaInfoList(parametere);
            if (介護認定宛名情報リスト == null || 介護認定宛名情報リスト.isEmpty()) {
                return SearchResult.of(Collections.<KaigoNinteiAtenaInfoBusiness>emptyList(), 0, false);
            }
            for (KaigoNinteiAtenaInfoRelateEntity entity : 介護認定宛名情報リスト) {
                kojinJokyoShokaiList.add(new KaigoNinteiAtenaInfoBusiness(entity));
            }
        }

        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

}
