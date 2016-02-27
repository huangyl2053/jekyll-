/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaigijiroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会議事録のマッパーインタフェースです。
 */
public interface IShinsakaiGijirokuMapper {

    /**
     * 介護認定審査会委員情報を検索します。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return 介護認定審査会委員情報リスト
     */
    List<DbT5594ShinsakaiIinJohoEntity> getShinsakaiIinJoho(RString shinsakaiKaisaiNo);

    /**
     * 介護認定審査会開催結果情報を検索します。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return 介護認定審査会開催結果情報リスト
     */
    List<ShinsakaiKaisaiKekkaJohoEntity> getShinsakaiKaisaiKekkaJoho(RString shinsakaiKaisaiNo);

    /**
     * 未判定件数を検索します。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return 未判定件数
     */
    int getHanteiYoteiSu(RString shinsakaiKaisaiNo);

    /**
     * 未審査件数を検索します。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return 未審査件数
     */
    int getMesinSaKensu(RString shinsakaiKaisaiNo);

    /**
     * 一次判定を変更した件数を検索します。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return 一次判定を変更した件数
     */
    int getItiDoHanteiHenkoKensu(RString shinsakaiKaisaiNo);

    /**
     * 審査会意見を付した件数を検索します。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return 審査会意見を付した件数
     */
    int getSinSakaiIkenTukeKensu(RString shinsakaiKaisaiNo);

    /**
     * 審査会審査結果等取得処理です。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return 審査会審査結果リスト
     */
    List<ShinsakaiKekkaJohoRelateEntity> getShinsakaiKekkaJoho(RString shinsakaiKaisaiNo);

}
