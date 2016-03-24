/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.ShihihokenshabangoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 過誤決定通知書情報取込（保険者分）自己作成のマッパーインタフェースです
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
     * 過誤決定明細一時テーブルを取得する。
     *
     * @return 過誤決定明細一時テーブルEntity
     */
    List<KagoKetteiHokenshaInMeisaiEntity> get保険者分情報_明細();

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
     * 過誤決定集計一時テーブルを取得する。
     *
     * @return 過誤決定集計一時テーブルEntity
     */
    List<KagoKetteiHokenshaInShukeiEntity> get保険者分情報_集計();

    /**
     * 過誤決定明細の登録処理
     *
     * @param entity KagoKetteiHokenshaInMeisaiEntity
     */
    void insert過誤決定明細(KagoKetteiHokenshaInMeisaiEntity entity);

    /**
     * 過誤決定集計の登録処理
     *
     * @param entity KagoKetteiHokenshaInShukeiEntity
     */
    void insert過誤決定集計(KagoKetteiHokenshaInShukeiEntity entity);

    /**
     * 市町村コードを取得する。
     *
     * @return DbT1001HihokenshaDaichoEntity
     */
    List<DbT1001HihokenshaDaichoEntity> get市町村コード();

    /**
     * 新被保険者番号を取得する。
     *
     * @param shichosonCode LasdecCode
     * @return 新被保険者番号一時テーブルEntity
     */
    List<ShihihokenshabangoTempTableEntity> get新被保険者番号(LasdecCode shichosonCode);

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

}
