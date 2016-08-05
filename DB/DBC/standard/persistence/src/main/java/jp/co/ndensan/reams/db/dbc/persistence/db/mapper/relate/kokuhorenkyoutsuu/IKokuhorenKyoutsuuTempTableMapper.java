/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;

/**
 * 国保連情報取込処理共通のMapperです<br>
 * 一時TBLを更新します。
 *
 * @reamsid_L DBC-0980-550 zhangrui
 */
public interface IKokuhorenKyoutsuuTempTableMapper {

    /**
     * 被保険者一時TBLを作成する。
     */
    void create被保険者一時TBL();

    /**
     * 処理結果リスト一時TBLを作成する。
     */
    void create処理結果リスト一時TBL();

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

    /**
     * すべての処理結果を取得(テスト用)
     *
     * @return 処理結果リスト一時TBLのエンティティ
     */
    List<DbWT0002KokuhorenTorikomiErrorTempEntity> get処理結果リスト一時TBLの全件();

    /**
     * すべての被保険者を取得(テスト用)
     *
     * @return 被保険者一時TBLのエンティティList
     */
    List<DbWT0001HihokenshaTempEntity> get被保険者一時TBLの全件();

}
