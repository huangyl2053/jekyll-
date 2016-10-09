/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hokenshakyufujisseki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshakyufujisseki.HokenshaKyufujissekiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujisseki.DbWT1111KyufuJissekiTempTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki.IHokenshaKyufujissekiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額合算補正済自己負担額情報作成のFinderです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class HokenshaKyufujissekiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    HokenshaKyufujissekiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link HokenshaKyufujissekiFinder}のインスタンスを返します。
     *
     * @return HokenshaKyufujissekiFinder
     */
    public static HokenshaKyufujissekiFinder createInstance() {
        return InstanceProvider.create(HokenshaKyufujissekiFinder.class);
    }

    /**
     * 給付実績Tempデータを取得。
     *
     * @return List<DbWT1111KyufuJissekiTempTempEntity>
     */
    public List<DbWT1111KyufuJissekiTempTempEntity> get給付実績Temp() {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        List<DbWT1111KyufuJissekiTempTempEntity> list = mapper.get給付実績Temp();
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    /**
     * 給付実績基本Tempデータを取得。
     *
     * @return List<DbWT1111KyufuJissekiTempTempEntity>
     */
    public List<DbWT1111KyufuJissekiTempTempEntity> get給付実績基本Temp() {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        List<DbWT1111KyufuJissekiTempTempEntity> list = mapper.get給付実績基本Temp();
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    /**
     * 給付実績高額Tempデータを取得。
     *
     * @return List<DbWT1111KyufuJissekiTempTempEntity>
     */
    public List<DbWT1111KyufuJissekiTempTempEntity> get給付実績高額Temp() {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        List<DbWT1111KyufuJissekiTempTempEntity> list = mapper.get給付実績高額Temp();
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績基本(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績基本(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績基本(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績基本(param);
    }

    /**
     * 給付実績高額介護サービス費．送付除外フラグ＝TRUEのデータを物理削除する。
     */
    public void delete給付実績高額介護サービス費() {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績高額介護サービス費();
    }

    /**
     * 給付実績高額介護サービス費．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績高額介護サービス費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績高額介護サービス費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績明細(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績明細(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績明細(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績明細(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績緊急時施設療養(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績緊急時施設療養(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績緊急時施設療養(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績緊急時施設療養(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績特定診療費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績特定診療費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績特定診療費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績特定診療費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績特定診療費_特別療養費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績特定診療費_特別療養費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績特定診療費_特別療養費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績特定診療費_特別療養費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績食事費用(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績食事費用(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績食事費用(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績食事費用(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績居宅サービス計画費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績居宅サービス計画費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績居宅サービス計画費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績居宅サービス計画費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績福祉用具販売費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績福祉用具販売費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績福祉用具販売費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績福祉用具販売費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績住宅改修費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績住宅改修費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績住宅改修費(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績住宅改修費(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績集計(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績集計(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績集計(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績集計(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績特定入所者介護サービス費用(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績特定入所者介護サービス費用(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績特定入所者介護サービス費用(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績特定入所者介護サービス費用(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績社会福祉法人軽減額(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績社会福祉法人軽減額(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績社会福祉法人軽減額(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績社会福祉法人軽減額(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績所定疾患施設療養費等(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績所定疾患施設療養費等(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績所定疾患施設療養費等(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績所定疾患施設療養費等(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝TRUEのデータを物理削除する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void delete給付実績明細_住所地特例(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.delete給付実績明細_住所地特例(param);
    }

    /**
     * 給付実績基本一時TBL．送付除外フラグ＝FALSEのデータを更新する。
     *
     * @param param HokenshaKyufujissekiMybatisParameter
     */
    public void update給付実績明細_住所地特例(HokenshaKyufujissekiMybatisParameter param) {
        IHokenshaKyufujissekiMapper mapper = mapperProvider.create(IHokenshaKyufujissekiMapper.class);
        mapper.update給付実績明細_住所地特例(param);
    }
}
