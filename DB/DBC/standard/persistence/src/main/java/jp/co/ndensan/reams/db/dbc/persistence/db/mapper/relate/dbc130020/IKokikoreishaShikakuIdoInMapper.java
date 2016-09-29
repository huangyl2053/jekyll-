/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc130010.UpdShoriDateKanriMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.KokiKoreshaJyohoRealEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoImportEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 後期高齢者情報CSVデータのバッチのDB操作です。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
public interface IKokikoreishaShikakuIdoInMapper {

    /**
     * 宛名識別コードリスト取得。
     *
     * @return List<ShikibetsuCode>
     */
    List<ShikibetsuCode> get宛名識別コードリスト();

    /**
     * 後期高齢者情報データを取得する。
     *
     *
     * @return {@link List<TorikomiKokiKoreshaJyohoEntity>}
     */
    List<TorikomiKokiKoreshaJyohoEntity> get取込後期高齢者情報();

    /**
     * 引数相同市町村コードなデータ件数を取得する。
     *
     * @param 市町村コード RString
     * @return Integer
     */
    Integer get構成市町村マスタ(RString 市町村コード);

    /**
     * 後期高齢者情報作成用データを取得。
     *
     * @return List<KokiKoreshaJyohoRealEntity>
     */
    List<KokiKoreshaJyohoRealEntity> get後期高齢者情報作成用データ();

    /**
     * 後期高齢者情報インポート作成用データを取得。
     *
     * @return List<KokiKoreshaJyohoRealEntity>
     */
    List<KokiKoreshaJyohoRealEntity> get後期高齢者情報インポート用データ();

    /**
     * 一時表取込後期高齢者情報インポート用Entitｙリストデータを取得。
     *
     * @return List<TorikomiKokiKoreshaJyohoImportEntity>
     */
    List<TorikomiKokiKoreshaJyohoImportEntity> get取込後期高齢者情報インポート用Entityリスト();

    /**
     * 現在後期高齢者情報の全データを取得。
     *
     * @return List<DbT7124KokiKoreishaInfoEntity>
     */
    List<DbT7124KokiKoreishaInfoEntity> get現在後期高齢者情報の全データ();

    /**
     * 処理管理日付マスタデータを取得。
     *
     * @param parameter UpdShoriDateKanriMybatisParameter
     */
    void up処理管理日付マスタ(UpdShoriDateKanriMybatisParameter parameter);
}
