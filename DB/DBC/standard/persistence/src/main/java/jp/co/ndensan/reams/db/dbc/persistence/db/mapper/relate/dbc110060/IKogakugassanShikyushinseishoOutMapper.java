/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060;

/**
 * 高額合算支給申請書情報作成のDB操作です。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public interface IKogakugassanShikyushinseishoOutMapper {

    /**
     * 高額合算申請書データ取得です。
     *
     * @param parameter KogakugassanShikyushinseishoOutMybatisParameter
     * @return KogakuGassanShinseishoDataEntity
     */
//    KogakuGassanShinseishoDataEntity get高額合算申請書データ(KogakugassanShikyushinseishoOutMybatisParameter parameter);
    /**
     * 識別コードがないデータを取得する。
     *
     * @return DbWT3711KogakuGassanShinseishoTempEntity
     */
//    DbWT3711KogakuGassanShinseishoTempEntity get識別コードがないデータ();
    /**
     * 口座情報がないデータを取得する。
     *
     * @return DbWT3711KogakuGassanShinseishoTempEntity
     */
//    KogakuGassanShinseishoInsertKozaEntity get口座情報がないデータ();
    /**
     * 導入形態が単一データを取得する。
     *
     * @return KogakuGassanShinseishoSetHokenshameEntity
     */
//    KogakuGassanShinseishoSetHokenshameEntity get導入形態が単一データ();
    /**
     * 導入形態が単一データを取得する。
     *
     * @return KogakuGassanShinseishoSetHokenshameEntity
     */
//    KogakuGassanShinseishoSetHokenshameEntity get導入形態が広域データ();
}
