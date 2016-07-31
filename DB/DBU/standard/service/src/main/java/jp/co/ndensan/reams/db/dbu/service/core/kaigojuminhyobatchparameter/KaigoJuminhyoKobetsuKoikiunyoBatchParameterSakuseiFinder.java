/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.kaigojuminhyobatchparameter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyokobetsukoikiunyo.KaigoJuminhyoKobetsuKoikiunyo;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki.KaigoJuminhyoKobetsuParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki.KobetsuKoikiunyoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsu.KaigojuminhyokobetsuEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojuminhyokobetsu.IKaigoJuminhyoKobetsuMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域運用抽出期間情報リスト取得するクラスです。
 *
 * @reamsid_L DBU-0550-040 zhangzhiming
 */
public class KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ。
     *
     */
    public KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder}のインスタンス
     */
    public static KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder createInstance() {
        return InstanceProvider.create(KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder.class);
    }

    /**
     * 広域運用抽出期間情報取得です。
     *
     * @return KaigoJuminhyoKobetsuKoikiunyo 広域運用抽出期間リスト
     */
    @Transaction
    public SearchResult<KaigoJuminhyoKobetsuKoikiunyo> getKoikiunyoChushutsukikanJohoList() {
        List<KaigoJuminhyoKobetsuKoikiunyo> 広域運用抽出期間リスト = new ArrayList<>();
        IKaigoJuminhyoKobetsuMapper kaigoMapper = mapperProvider.create(IKaigoJuminhyoKobetsuMapper.class);
        List<KaigojuminhyokobetsuEntity> businessList = kaigoMapper.selectList();
        if (businessList == null || businessList.isEmpty()) {
            return SearchResult.of(Collections.<KaigoJuminhyoKobetsuKoikiunyo>emptyList(), 0, false);
        }
        for (KaigojuminhyokobetsuEntity entity : businessList) {
            広域運用抽出期間リスト.add(new KaigoJuminhyoKobetsuKoikiunyo(entity));
        }
        return SearchResult.of(広域運用抽出期間リスト, 0, false);
    }

    /**
     * 介護住民票個別事項連携情報バッチパラメータ取得です。
     *
     * @param kobetsuLsit kobetsuLsit
     * @return KaigoJuminhyoKobetsuKoikiunyo 介護住民票個別事項連携情報バッチパラメータ
     */
    @Transaction
    public SearchResult<KobetsuKoikiunyoParameter> getKaigoJuminhyoKobetsuKoikiunyoBatchParameter(List<KaigoJuminhyoKobetsuParameter> kobetsuLsit) {
        List<KobetsuKoikiunyoParameter> batchParameterList = new ArrayList<>();
        for (KaigoJuminhyoKobetsuParameter list : kobetsuLsit) {
            KobetsuKoikiunyoParameter batchParameter = new KobetsuKoikiunyoParameter();
            batchParameter.setDateTo(RDate.getNowDateTime());
            if (list.getKonkaiStSakuseiYMD() != null) {
                batchParameter.setDateFrom(RDateTime.of(list.getKonkaiStSakuseiYMD().toDateString(),
                        new RString(list.getKonkaiStSakuseiTime().toString())));
            }
            batchParameter.setShichosonCode(list.getSakiShichoson());
            batchParameterList.add(batchParameter);
        }
        return SearchResult.of(batchParameterList, 0, false);
    }
}
