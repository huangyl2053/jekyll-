/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import jp.co.ndensan.reams.db.dbc.business.KyufuJisseki;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.entity.mapper.KyufuJissekiMapper;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiKihonDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付実績情報を取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiFinder {

    private final IKyufuJissekiKihonDac dac;

    /**
     * InstanceProviderを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public KyufuJissekiFinder() {
        dac = InstanceProvider.create(IKyufuJissekiKihonDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 給付実績基本Dac
     */
    KyufuJissekiFinder(IKyufuJissekiKihonDac dac) {
        this.dac = dac;
    }

    /**
     * 指定した給付実績キーを元に詳細キーを取得します。
     *
     * @param キー情報 キー情報
     * @return 詳細キー情報
     */
    public KyufuJissekiDetailKeyInfo get給付実績詳細キー(KyufuJissekiKeyInfo キー情報) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 指定した給付実績詳細キーに該当する給付実績情報を取得する
     *
     * @param 詳細キー情報 詳細キー情報
     * @return 給付実績情報
     */
    public KyufuJisseki get給付実績(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return new KyufuJisseki(get給付実績基本(詳細キー情報), null, null, null);
    }

    private KyufuJissekiKihon get給付実績基本(KyufuJissekiDetailKeyInfo 詳細キー情報) {
        return KyufuJissekiMapper.to給付実績基本(dac.select(
                詳細キー情報.get交換情報識別番号(),
                詳細キー情報.get入力識別番号().getInputShikibetsuNoCode(),
                詳細キー情報.getレコード種別コード(),
                詳細キー情報.get給付実績情報作成区分().getCode(),
                詳細キー情報.get証記載保険者番号(),
                詳細キー情報.get被保番号(),
                詳細キー情報.getサービス提供年月().value(),
                詳細キー情報.get給付実績区分().getCode(),
                詳細キー情報.get事業所番号(),
                詳細キー情報.get通番()));
    }
}
