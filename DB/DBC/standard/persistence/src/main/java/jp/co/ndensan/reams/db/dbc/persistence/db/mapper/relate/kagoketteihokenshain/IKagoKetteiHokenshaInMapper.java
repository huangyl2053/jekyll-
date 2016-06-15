/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteihokenshain.KagoKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.ShihihokenshabangoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 過誤決定通知書情報取込（保険者分）自己作成のマッパーインタフェースです
 *
 * @reamsid_L DBC-0980-320 xupeng
 */
public interface IKagoKetteiHokenshaInMapper {

    /**
     * 過誤決定明細一時テーブルを作成する。
     */
    void create保険者分情報_明細();

    /**
     * 過誤決定明細一時テーブルの登録処理
     *
     * @param entity 過誤決定明細一時テーブルEntity
     */
    void insert保険者分情報_明細(KagoKetteiHokenshaInMeisaiEntity entity);

    /**
     * 過誤決定集計一時テーブルを作成する。
     */
    void create保険者分情報_集計();

    /**
     * 過誤決定集計一時テーブルの登録処理
     *
     * @param entity 過誤決定集計一時テーブルEntity
     */
    void insert保険者分情報_集計(KagoKetteiHokenshaInShukeiEntity entity);

    /**
     * 過誤決定明細の登録処理
     */
    void insert過誤決定明細();

    /**
     * 過誤決定集計の登録処理
     */
    void insert過誤決定集計();

    /**
     * 一時テーブルから被保険者番号を取得する
     *
     * @return List<KagoKetteiHokenshaInMeisaiEntity>
     */
    List<KagoKetteiHokenshaInMeisaiEntity> select被保険者番号From一時テーブル();

    /**
     * 市町村コードを取得する。
     *
     * @param parameter KagoKetteiHokenshaInParameter
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity get市町村コード(KagoKetteiHokenshaInParameter parameter);

    /**
     * 新被保険者番号を取得する。
     *
     * @param parameter KagoKetteiHokenshaInParameter
     * @return ShihihokenshabangoTempTableEntity
     */
    ShihihokenshabangoTempTableEntity get新被保険者番号(KagoKetteiHokenshaInParameter parameter);

    /**
     * 過誤決定集計一時テーブルの更新処理
     */
    void update保険者分情報_明細();

    /**
     * 新被保険者番号一時テーブルを作成する。
     */
    void create新被保険者番号();

    /**
     * 新被保険者番号一時テーブルの登録処理
     *
     * @param entity 新被保険者番号一時テーブルEntity
     */
    void insert新被保険者番号(ShihihokenshabangoTempTableEntity entity);

    /**
     * 一時テーブル取得する
     *
     * @return List<KagoKetteiHokenshaInEntity>
     */
    List<KagoKetteiHokenshaInEntity> select一時テーブル();
}
