/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiDoSofuReportMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiUpdateDBMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.DbWT38Q1KogakuGassanKyufuJissekiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.KogakuGassanKyufuJissekiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.KogakuGassanKyufuJissekiSofuEntity;

/**
 * 高額合算給付実績情報作成のバッチのDB操作クラスです。
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public interface IKogakugassanKyufujissekiOutMapper {

    /**
     * 送付対象データを取得する。
     *
     * @param parameter KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter
     * @return KogakuGassanKyufuJissekiDataEntity
     */
    KogakuGassanKyufuJissekiDataEntity get送付対象データ(KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter parameter);

    /**
     * 送付外対象データを取得する。
     *
     * @return DbWT38Q1KogakuGassanKyufuJissekiTempEntity
     */
    DbWT38Q1KogakuGassanKyufuJissekiTempEntity get識別コード無しの対象データ();

    /**
     * 高額合算給付実績データを取得する。
     *
     * @param parameter KogakugassanKyufujissekiUpdateDBMybatisParameter
     * @return DbT3075KogakuGassanKyufuJissekiEntity
     */
    DbT3075KogakuGassanKyufuJissekiEntity get高額合算給付実績更新対象(KogakugassanKyufujissekiUpdateDBMybatisParameter parameter);

    /**
     * 送付ファイル作成データ件数を取得する。
     *
     * @return 件数
     */
    int get送付ファイル作成データ件数();

    /**
     * 送付ファイル作成データを取得する。
     *
     * @return KogakuGassanKyufuJissekiSofuEntity
     */
    KogakuGassanKyufuJissekiSofuEntity get送付ファイル作成データ();

    /**
     * 帳票出力データを取得する。
     *
     * @param parameter KogakugassanKyufujissekiDoSofuReportMybatisParameter
     * @return KogakuGassanKyufuJissekiSofuEntity
     */
    KogakuGassanKyufuJissekiSofuEntity get帳票出力データ(KogakugassanKyufujissekiDoSofuReportMybatisParameter parameter);

}
