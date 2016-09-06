/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassan.KogakugassanMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassan.SyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku.DbWT37K1KogakuGassanJikoFutanGakuTempEntity;

/**
 * 高額合算補正済自己負担額情報作成のMapperです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public interface IKogakugassanHoseisumiJikofutangakuOutMapper {

    /**
     * 高額合算自己負担額データ取得する。
     *
     * @param param KogakugassanMybatisParameter
     * @return 高額合算自己負担額データ
     */
    List<DbT3070KogakuGassanJikoFutanGakuEntity> get高額合算自己負担額データ(KogakugassanMybatisParameter param);

    /**
     * 高額合算自己負担額明細データの存在確認する。
     *
     * @return 高額合算自己負担額明細データの存在確認データ
     */
    List<DbWT37K1KogakuGassanJikoFutanGakuTempEntity> get明細データ();

    /**
     * 被保険者一時テーブルデータ取得する。
     *
     * @return 被保険者一時テーブルリスト
     */
    List<DbWT1001HihokenshaTempEntity> get識別コードがないデータ();

    /**
     * 出力対象データを取得する。
     *
     * @return 出力対象データ
     */
    List<SyuturyokuEntity> get出力対象データ();

    /**
     * 送付一覧表出力対象データを取得する。
     *
     * @return 送付一覧表出力対象データ
     */
    List<SyuturyokuEntity> get送付一覧表出力対象データ();

    /**
     * 未送付一覧表出力対象データを取得する。
     *
     * @return 未送付一覧表出力対象データ
     */
    List<SyuturyokuEntity> get未送付一覧表出力対象データ();

    /**
     * 送付済高額合算自己負担額データを取得する。
     *
     * @return 送付済高額合算自己負担額データ
     */
    List<DbT3070KogakuGassanJikoFutanGakuEntity> get送付済高額合算自己負担額データ();

    /**
     * 未送付高額合算自己負担額データを取得する。
     *
     * @return 未送付高額合算自己負担額データ
     */
    List<DbT3070KogakuGassanJikoFutanGakuEntity> get未送付高額合算自己負担額データ();

}
