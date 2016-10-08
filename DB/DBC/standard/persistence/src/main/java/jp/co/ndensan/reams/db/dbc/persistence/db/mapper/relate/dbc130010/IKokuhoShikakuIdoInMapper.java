/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc130010.UpdShoriDateKanriMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoKannriDataYoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoShikakuJyohoInpotoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoShikakuJyohoYoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.TorikomiKokuhoJyohoResultEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * バッチ設計_DBC130010_国保資格異動情報取込
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public interface IKokuhoShikakuIdoInMapper {

    /**
     * 取込国保情報一時表のデータ取得。
     *
     * @return List<TorikomiKokuhoJyohoResultEntity>
     */
    List<TorikomiKokuhoJyohoResultEntity> get取込国保情報Temp();

    /**
     * 引数相同市町村コードなデータ件数を取得する。
     *
     * @return List<LasdecCode>
     */
    List<LasdecCode> get構成市町村マスタ();

    /**
     * 国保管理データ作成用データを取得。
     *
     * @return List<KokuhoKannriDataYoEntity>
     */
    List<KokuhoKannriDataYoEntity> get国保管理データ作成用データ();

    /**
     * 国保管理データ作成用データを取得。
     *
     * @return List<KokuhoShikakuJyohoYoResultEntity>
     */
    List<KokuhoShikakuJyohoYoResultEntity> get国保資格情報インポート用データ();

    /**
     * 一時表国保資格情報インポート用Entitｙリストデータを取得。
     *
     * @return List<KokuhoShikakuJyohoInpotoyoEntity>
     */
    List<KokuhoShikakuJyohoInpotoyoEntity> get国保資格情報インポート用Entitｙリスト();

    /**
     * 国保資格情報を削除する。
     *
     */
    void delete国保資格情報();

    /**
     * 処理管理日付マスタデータを取得。
     *
     * @param parameter UpdShoriDateKanriMybatisParameter
     */
    void up処理管理日付マスタ(UpdShoriDateKanriMybatisParameter parameter);
}
