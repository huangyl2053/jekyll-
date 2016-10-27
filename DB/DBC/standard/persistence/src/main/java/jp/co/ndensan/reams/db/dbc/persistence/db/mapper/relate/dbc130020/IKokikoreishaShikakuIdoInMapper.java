/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.KokiKoreshaJyohoDataYoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.KokiKoreshaJyohoRealEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.KokiKoreshaJyohoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoImportEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 後期高齢者情報CSVデータのバッチのDB操作です。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
public interface IKokikoreishaShikakuIdoInMapper {

    /**
     * 後期高齢者情報データを取得する。
     *
     *
     * @return {@link List<KokiKoreshaJyohoRealEntity>}
     */
    List<KokiKoreshaJyohoRealEntity> get取込後期高齢者情報();

    /**
     * 引数相同市町村コードなデータ件数を取得する。
     *
     * @return List<LasdecCode>
     */
    List<LasdecCode> get構成市町村マスタ();

    /**
     * 後期高齢者情報作成用データを取得。
     *
     * @return List<KokiKoreshaJyohoDataYoEntity>
     */
    List<KokiKoreshaJyohoDataYoEntity> get後期高齢者情報作成用データ();

    /**
     * 後期高齢者情報インポート作成用データを取得。
     *
     * @return List<KokiKoreshaJyohoResultEntity>
     */
    List<KokiKoreshaJyohoResultEntity> get後期高齢者情報インポート用データ();

    /**
     * 一時表取込後期高齢者情報インポート用Entitｙリストデータを取得。
     *
     * @return List<TorikomiKokiKoreshaJyohoImportEntity>
     */
    List<TorikomiKokiKoreshaJyohoImportEntity> get取込後期高齢者情報インポート用Entityリスト();

    /**
     * 一時表取込後期高齢者情報インポート用Entitｙ件数を取得。
     *
     * @return Integer
     */
    Integer get取込後期高齢者情報インポート用Entitｙ件数();

    /**
     * 取込後期高齢者情報を削除する。
     *
     */
    void delete取込後期高齢者情報();
}
