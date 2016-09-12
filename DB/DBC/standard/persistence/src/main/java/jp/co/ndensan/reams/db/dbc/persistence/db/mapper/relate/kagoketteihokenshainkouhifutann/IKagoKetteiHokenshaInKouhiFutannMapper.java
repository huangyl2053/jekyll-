/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshainkouhifutann;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3060KagoKetteiShukeiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3061KagoKetteiMeisaiTempEntity;

/**
 * 過誤決定通知書情報取込共通処理（公費負担者分・ファイル読込）DB操作です。
 *
 * @reamsid_L DBC-0980-421 surun
 */
public interface IKagoKetteiHokenshaInKouhiFutannMapper {

    /**
     * 過誤決定集計一時TBLを作成する。
     */
    void create過誤決定集計一時TBL();

    /**
     * 過誤決定明細一時TBLを作成する。
     */
    void create過誤決定明細一時TBL();

    /**
     * 被保険者一時TBLを作成する。
     */
    void create被保険者一時TBL();

    /**
     * 処理結果リスト一時TBLを作成する。
     */
    void create処理結果リスト一時TBL();

    /**
     * 過誤決定集計一時TBLに登録する。
     *
     * @param entity DbWT3060KagoKetteiShukeiTempEntity
     */
    void 過誤決定集計一時TBLに登録(DbWT3060KagoKetteiShukeiTempEntity entity);

    /**
     * 過誤決定明細一時TBLに登録する。
     *
     * @param entity DbWT3061KagoKetteiMeisaiTempEntity
     */
    void 過誤決定明細一時TBLに登録(DbWT3061KagoKetteiMeisaiTempEntity entity);

    /**
     * 被保険者一時TBLに登録する。
     *
     * @param entity DbWT0001HihokenshaTempEntity
     */
    void 被保険者一時TBLに登録(DbWT0001HihokenshaTempEntity entity);

    /**
     * 処理結果リスト一時TBLに登録する。
     *
     * @param entity DbWT0002KokuhorenTorikomiErrorTempEntity
     */
    void 処理結果リスト一時TBLに登録(DbWT0002KokuhorenTorikomiErrorTempEntity entity);
}
