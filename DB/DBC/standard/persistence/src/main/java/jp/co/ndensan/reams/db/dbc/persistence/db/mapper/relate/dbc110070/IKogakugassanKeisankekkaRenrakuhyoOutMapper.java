/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110070;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110070.KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoTmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaTmpEntity;

/**
 * 高額合算計算結果連絡票情報作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public interface IKogakugassanKeisankekkaRenrakuhyoOutMapper {

    /**
     * 高額合算支給額計算結果を取得します。
     *
     * @param parameter KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter
     * @return 高額合算自己負担額データ
     */
    List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> get高額合算計算結果連絡票情報(
            KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter parameter);

    /**
     * 高額合算支給額計算結果一時情報を取得します。
     *
     * @return 高額合算支給額計算結果一時情報
     */
    List<DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity> get識別コードがないデータ();

    /**
     * 高額合算支給額計算結果一時情報を取得します。
     *
     * @return 高額合算支給額計算結果一時情報
     */
    List<DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity> get高額合算支給額計算結果明細データがない();

    /**
     * 送付ファイル作成情報を取得します。
     *
     * @return 送付ファイル作成情報
     */
    List<KogakuGassanKeisanKekkaRenrakuJohoTmpEntity> get送付ファイル作成データ();

    /**
     * 送付一覧表情報を取得します。
     *
     * @param parameter KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter
     * @return 送付一覧表情報
     */
    List<GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity> get送付一覧表情報(
            KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter parameter);

    /**
     * 送付済データを取得します。
     *
     * @return 送付済データ
     */
    List<KogakuGassanShikyuGakuKeisanKekkaTmpEntity> get送付済データ();

    /**
     * 未送付データを取得します。
     *
     * @return 未送付データ
     */
    List<KogakuGassanShikyuGakuKeisanKekkaTmpEntity> get未送付データ();
}
