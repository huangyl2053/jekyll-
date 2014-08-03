/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import jp.co.ndensan.reams.db.dbc.business.KyufuJisseki;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiYoguHanbaihiCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiJutakuKaishuhiCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKyotakuServiceCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiMeisaiCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShafukuKeigenCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShukeiCollection;
import jp.co.ndensan.reams.db.dbc.entity.mapper.KyufuJissekiMapper;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiKyotakuServiceDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiShafukuKeigenDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiYoguHanbaihiDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiJutakuKaishuhiDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.KyufuJissekiServiceDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付実績情報を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiFinder {

    private final KyufuJissekiServiceDac serviceDac;
    private final IKyufuJissekiKihonDac kihonDac;
    private final IKyufuJissekiMeisaiDac meisaiDac;
    private final IKyufuJissekiShukeiDac shukeiDac;
    private final IKyufuJissekiShafukuKeigenDac shafukuDac;
    private final IKyufuJissekiKyotakuServiceDac kyotakuDac;
    private final IKyufuJissekiYoguHanbaihiDac yoguDac;
    private final IKyufuJissekiJutakuKaishuhiDac jutakuDac;

    /**
     * InstanceProviderを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public KyufuJissekiFinder() {
        serviceDac = InstanceProvider.create(KyufuJissekiServiceDac.class);
        kihonDac = InstanceProvider.createWithCustomize(IKyufuJissekiKihonDac.class);
        meisaiDac = InstanceProvider.createWithCustomize(IKyufuJissekiMeisaiDac.class);
        shukeiDac = InstanceProvider.createWithCustomize(IKyufuJissekiShukeiDac.class);
        shafukuDac = InstanceProvider.createWithCustomize(IKyufuJissekiShafukuKeigenDac.class);
        kyotakuDac = InstanceProvider.createWithCustomize(IKyufuJissekiKyotakuServiceDac.class);
        yoguDac = InstanceProvider.createWithCustomize(IKyufuJissekiYoguHanbaihiDac.class);
        jutakuDac = InstanceProvider.createWithCustomize(IKyufuJissekiJutakuKaishuhiDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param kihonDac 給付実績基本Dac
     * @param meisaiDac 給付実績明細Dac
     * @param shukeiDac 給付実績集計Dac
     * @param shafukuDac 給付実績社会福祉法人軽減額Dac
     * @param kyotakuDac 給付実績サービス計画費Dac
     * @param yoguDac 給付実績福祉用具購入費Dac
     * @param jutakuDac 給付実績住宅改修費Dac
     */
    KyufuJissekiFinder(
            KyufuJissekiServiceDac serviceDac,
            IKyufuJissekiKihonDac kihonDac,
            IKyufuJissekiMeisaiDac meisaiDac,
            IKyufuJissekiShukeiDac shukeiDac,
            IKyufuJissekiShafukuKeigenDac shafukuDac,
            IKyufuJissekiKyotakuServiceDac kyotakuDac,
            IKyufuJissekiYoguHanbaihiDac fukushiYoguHanbaihiDac,
            IKyufuJissekiJutakuKaishuhiDac jutakuKaishuhiDac) {
        this.serviceDac = serviceDac;
        this.kihonDac = kihonDac;
        this.meisaiDac = meisaiDac;
        this.shukeiDac = shukeiDac;
        this.shafukuDac = shafukuDac;
        this.kyotakuDac = kyotakuDac;
        this.yoguDac = fukushiYoguHanbaihiDac;
        this.jutakuDac = jutakuKaishuhiDac;
    }

    /**
     * 指定した給付実績キーを元に詳細キーを取得します。
     *
     * @param キー情報 キー情報
     * @return 詳細キー情報
     */
    public KyufuJissekiDetailKeyInfo get給付実績詳細キー(KyufuJissekiKeyInfo キー情報) {
        return KyufuJissekiMapper.to給付実績詳細キー(serviceDac.select(
                キー情報.get被保番号(),
                キー情報.getサービス提供期間().getFrom(),
                キー情報.getサービス提供期間().getTo()), キー情報);
    }

    /**
     * 指定した給付実績詳細キーに該当する給付実績情報を取得する
     *
     * @param 詳細キー情報 詳細キー情報
     * @return 給付実績情報
     */
    public KyufuJisseki get給付実績(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return new KyufuJisseki(
                get給付実績基本(詳細キー情報),
                get給付実績明細(詳細キー情報),
                get給付実績集計(詳細キー情報),
                get給付実績社会福祉法人軽減額(詳細キー情報),
                get給付実績サービス計画費(詳細キー情報),
                get給付実績福祉用具購入費(詳細キー情報),
                get給付実績住宅改修費(詳細キー情報));
    }

    private KyufuJissekiKihon get給付実績基本(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return KyufuJissekiMapper.to給付実績基本(kihonDac.select(
                詳細キー情報.get交換情報識別番号(),
                詳細キー情報.get入力識別番号().getInputShikibetsuNoCode(),
                詳細キー情報.get証記載保険者番号(),
                詳細キー情報.get被保番号(),
                詳細キー情報.getサービス提供年月().value(),
                詳細キー情報.get事業所番号(),
                詳細キー情報.get通番()));
    }

    private KyufuJissekiMeisaiCollection get給付実績明細(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return KyufuJissekiMapper.to給付実績明細List(meisaiDac.select(
                詳細キー情報.get交換情報識別番号(),
                詳細キー情報.get入力識別番号().getInputShikibetsuNoCode(),
                詳細キー情報.get証記載保険者番号(),
                詳細キー情報.get被保番号(),
                詳細キー情報.getサービス提供年月().value(),
                詳細キー情報.get事業所番号(),
                詳細キー情報.get通番()));
    }

    private KyufuJissekiShukeiCollection get給付実績集計(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return KyufuJissekiMapper.to給付実績集計List(shukeiDac.select(
                詳細キー情報.get交換情報識別番号(),
                詳細キー情報.get入力識別番号().getInputShikibetsuNoCode(),
                詳細キー情報.get証記載保険者番号(),
                詳細キー情報.get被保番号(),
                詳細キー情報.getサービス提供年月().value(),
                詳細キー情報.get事業所番号(),
                詳細キー情報.get通番()));
    }

    private KyufuJissekiShafukuKeigenCollection get給付実績社会福祉法人軽減額(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return KyufuJissekiMapper.to給付実績社会福祉法人軽減額List(shafukuDac.select(
                詳細キー情報.get交換情報識別番号(),
                詳細キー情報.get入力識別番号().getInputShikibetsuNoCode(),
                詳細キー情報.get証記載保険者番号(),
                詳細キー情報.get被保番号(),
                詳細キー情報.getサービス提供年月().value(),
                詳細キー情報.get事業所番号(),
                詳細キー情報.get通番()));
    }

    private KyufuJissekiKyotakuServiceCollection get給付実績サービス計画費(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return KyufuJissekiMapper.to給付実績サービス計画費List(kyotakuDac.select(
                詳細キー情報.get交換情報識別番号(),
                詳細キー情報.get入力識別番号().getInputShikibetsuNoCode(),
                詳細キー情報.get証記載保険者番号(),
                詳細キー情報.get被保番号(),
                詳細キー情報.getサービス提供年月().value(),
                詳細キー情報.get事業所番号(),
                詳細キー情報.get通番()));
    }

    private KyufuJissekiYoguHanbaihiCollection get給付実績福祉用具購入費(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return KyufuJissekiMapper.to福祉用具購入費List(yoguDac.select(
                詳細キー情報.get交換情報識別番号(),
                詳細キー情報.get入力識別番号().getInputShikibetsuNoCode(),
                詳細キー情報.get証記載保険者番号(),
                詳細キー情報.get被保番号(),
                詳細キー情報.getサービス提供年月().value(),
                詳細キー情報.get事業所番号(),
                詳細キー情報.get通番()));
    }

    private KyufuJissekiJutakuKaishuhiCollection get給付実績住宅改修費(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return KyufuJissekiMapper.to住宅改修費情報List(jutakuDac.select(
                詳細キー情報.get交換情報識別番号(),
                詳細キー情報.get入力識別番号().getInputShikibetsuNoCode(),
                詳細キー情報.get証記載保険者番号(),
                詳細キー情報.get被保番号(),
                詳細キー情報.getサービス提供年月().value(),
                詳細キー情報.get事業所番号(),
                詳細キー情報.get通番()));
    }
}
