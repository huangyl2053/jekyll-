/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.keisangojoho.KeisangoJohoSakuseiMybitisParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.KeisangoJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;

/**
 * 計算後情報作成のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public interface IKeisangoJohoSakuseiMapper {

    /**
     * 調定日時が指定されない且つ帳票分類IDが指定されない場合、全賦課最新の情報を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<DbT2002FukaEntity>
     */
    List<DbT2002FukaEntity> get全賦課最新情報2(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 調定日時が指定された且つ帳票分類IDが指定されない場合、全賦課最新の情報を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<DbT2002FukaEntity>
     */
    List<DbT2002FukaEntity> get全賦課最新情報3(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 調定日時が指定されない且つ帳票分類IDが指定された場合、全賦課最新の情報を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<DbT2002FukaEntity>
     */
    List<DbT2002FukaEntity> get全賦課最新情報4(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 調定日時が指定された且つ帳票分類IDが指定された場合、全賦課最新の情報を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<DbT2002FukaEntity>
     */
    List<DbT2002FukaEntity> get全賦課最新情報5(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 計算後情報_期別金額を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<KeisangoJohoSakuseiRelateEntity>
     */
    List<KeisangoJohoSakuseiRelateEntity> get期別金額(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 計算後情報_収入情報を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<KeisangoJohoSakuseiRelateEntity>
     */
    List<KeisangoJohoSakuseiRelateEntity> get収入情報(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 計算後情報_更新前賦課情報を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<DbT2002FukaEntity>
     */
    List<DbT2002FukaEntity> get更新前賦課情報(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 計算中間Temp更新後情報を取得します。
     *
     * @return List<DbTKeisangoJohoTempTableEntity>
     */
    List<DbTKeisangoJohoTempTableEntity> get計算中間Temp更新後情報();

}
