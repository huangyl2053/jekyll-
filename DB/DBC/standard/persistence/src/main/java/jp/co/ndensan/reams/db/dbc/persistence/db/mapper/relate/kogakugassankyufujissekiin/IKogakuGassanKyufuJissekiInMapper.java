/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInLoginMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInDoMasterTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInEntity;

/**
 * 高額合算給付実績取込のMapperです。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
public interface IKogakuGassanKyufuJissekiInMapper {

    /**
     * 高額合算給付実績と一時データを取得する。
     *
     * @param parameter パラメータ
     * @return List<KogakuGassanKyufuJissekiInDoMasterTorokuEntity>
     */
    List<KogakuGassanKyufuJissekiInDoMasterTorokuEntity> select高額合算給付実績と一時データ(KogakuGassanKyufuJissekiInLoginMybatisParameter parameter);

    /**
     * 高額合算給付実績と一時データを更新する。
     *
     * @param parameter パラメータ
     */
    void update高額合算給付実績と一時データ(KogakuGassanKyufuJissekiInLoginMybatisParameter parameter);

    /**
     * 高額合算給付実績一時再処理準備のデータを取ります。
     *
     * @param parameter パラメータ
     * @return List<DbWT38P1KogakuGassanKyufuJissekiTempEntity>
     */
    List<DbT3075KogakuGassanKyufuJissekiEntity> get高額合算給付実績一時再処理準備のデータ(KogakuGassanKyufuJissekiInLoginMybatisParameter parameter);

    /**
     * 高額合算給付実績一時TBLのデータと被保険者一時TBLを取ります。
     *
     * @param parameter パラメータ
     * @return List<KogakuGassanKyufuJissekiInEntity>
     */
    List<KogakuGassanKyufuJissekiInEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);

}
