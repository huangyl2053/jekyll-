/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060.KogakugassanShikyushinseishoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060.KozaKyomuBetsuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060.SofuFileSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.DbWT3711KogakuGassanShinseishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoHokenshaShutokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoInsertKozaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoSetHokenshameEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoSofuFileEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakugassanShikyushinseishoOutFileEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    KogakuGassanShinseishoDataEntity get高額合算申請書データ(KogakugassanShikyushinseishoOutMybatisParameter parameter);

    /**
     * 識別コードがないデータを取得する。
     *
     * @return DbWT3711KogakuGassanShinseishoTempEntity
     */
    DbWT3711KogakuGassanShinseishoTempEntity get識別コードがないデータ();

    /**
     * 口座情報がないデータを取得する。
     *
     * @param parameter SofuFileSakuseiMybatisParameter
     * @return DbWT3711KogakuGassanShinseishoTempEntity
     */
    KogakuGassanShinseishoInsertKozaEntity get口座情報がないデータ(SofuFileSakuseiMybatisParameter parameter);

    /**
     * 導入形態が単一データを取得する。
     *
     * @return KogakuGassanShinseishoSetHokenshameEntity
     */
    KogakuGassanShinseishoSetHokenshameEntity get導入形態が単一データ();

    /**
     * 導入形態が単一データを取得する。
     *
     * @return KogakuGassanShinseishoSetHokenshameEntity
     */
    KogakuGassanShinseishoSetHokenshameEntity get導入形態が広域データ();

    /**
     * 保険者番号の取得データです。
     *
     * @return KogakuGassanShinseishoHokenshaShutokuEntity
     */
    KogakuGassanShinseishoHokenshaShutokuEntity get保険者番号の取得データ();

    /**
     * 送付ファイル作成データです。
     *
     * @param parameter KogakugassanShikyushinseishoOutMybatisParameter
     * @return KogakuGassanShinseishoSofuFileEntity
     */
    KogakuGassanShinseishoSofuFileEntity get送付ファイル作成データ(SofuFileSakuseiMybatisParameter parameter);

    /**
     * 送付一覧表出力対象データを取得する。
     *
     * @return 送付一覧表出力対象データ
     */
    KogakugassanShikyushinseishoOutFileEntity get送付一覧表出力対象データ();

    /**
     * DB更新の送付済データです。
     *
     * @return DbT3068KogakuGassanShinseishoEntity
     */
    DbT3068KogakuGassanShinseishoEntity getDB更新の送付済データ();

    /**
     * DB更新の未送付データです。
     *
     * @return DbT3068KogakuGassanShinseishoEntity
     */
    DbT3068KogakuGassanShinseishoEntity getDB更新の未送付データ();

    /**
     * 業務別主キーが業務別主キーTBLから取得する。
     *
     * @param parameter KozaKyomuBetsuMybatisParameter
     * @return RString
     */
    RString get業務別主キー(KozaKyomuBetsuMybatisParameter parameter);
}
