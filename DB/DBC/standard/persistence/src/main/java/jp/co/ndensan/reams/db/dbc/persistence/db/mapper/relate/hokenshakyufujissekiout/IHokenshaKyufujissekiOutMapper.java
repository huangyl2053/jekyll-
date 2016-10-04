/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaNoBatchParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaAtenaEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetOldHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;

/**
 * 国保連情報取込処理共通のMapperです
 *
 * @reamsid_L DBC-2460-011 jiangwenkai
 */
public interface IHokenshaKyufujissekiOutMapper {

    /**
     * 処理結果リスト一時TBLを取得する。
     *
     * @return 処理結果リスト一時TBLのList
     */
    List<DbWT0002KokuhorenTorikomiErrorTempEntity> select処理結果リスト一時TBL();

    /**
     * 被保険者一時TBLを取得する。
     *
     * @param parameter HokenshaKyufujissekiOutGetHihokenshaNoBatchParameter
     * @return 被保険者一時TBLのList
     */
    List<DbWT1001HihokenshaTempEntity> select被保険者一時TBL(HokenshaKyufujissekiOutGetHihokenshaNoBatchParameter parameter);

    /**
     * 保険者番号を設定する。
     *
     */
    void do保険者番号の設定();

    /**
     * 広域加入日以前のデータを取得する。
     *
     * @return 処理結果リスト一時TBLのList
     */
    List<DbWT1001HihokenshaTempEntity> select広域加入日以前のデータ();

    /**
     * 旧被保険者番号を取得する。
     *
     * @return 処理結果リスト一時TBLのList
     */
    List<HokenshaKyufujissekiOutGetOldHihokenshaEntity> select旧被保険者番号();

    /**
     * 保険者名を取得する。
     *
     * @return 処理結果リスト一時TBLのList
     */
    List<DbWT0002KokuhorenTorikomiErrorTempEntity> select保険者名();

    /**
     * 被保険者・宛名情報取得する。
     *
     * @return 処理結果リスト一時TBLのList
     */
    List<HokenshaKyufujissekiOutGetHihokenshaAtenaEntity> select被保険者_宛名();

    /**
     * エラー登録報取得する。
     *
     * @return 被保険者一時TBLのList
     */
    List<DbWT1001HihokenshaTempEntity> doエラー登録();

}
