/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.keisangojoho.KeisangoJohoSakuseiMybitisParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.KeisangoJohoSakuseiRelateEntity;

/**
 * 計算後情報作成のマッパーインタフェースです。
 */
public interface IKeisangoJohoSakuseiMapper {

    /**
     * 計算後情報_最新2を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<KeisangoJohoSakuseiRelateEntity>
     */
    List<KeisangoJohoSakuseiRelateEntity> get計算後情報_最新2(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 計算後情報_履歴を取得します。
     *
     * @param entity dbT2015KeisangoJohoEntity
     * @return List<KeisangoJohoSakuseiRelateEntity>
     */
    List<KeisangoJohoSakuseiRelateEntity> get計算後情報_履歴(DbT2015KeisangoJohoEntity entity);

    /**
     * 計算後情報_最新3を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<KeisangoJohoSakuseiRelateEntity>
     */
    List<KeisangoJohoSakuseiRelateEntity> get計算後情報_最新3(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 計算後情報_最新4を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<KeisangoJohoSakuseiRelateEntity>
     */
    List<KeisangoJohoSakuseiRelateEntity> get計算後情報_最新4(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 計算後情報_最新5を取得します。
     *
     * @param param 計算後情報作成のパラメータ
     * @return List<KeisangoJohoSakuseiRelateEntity>
     */
    List<KeisangoJohoSakuseiRelateEntity> get計算後情報_最新5(KeisangoJohoSakuseiMybitisParamter param);

    /**
     * 計算後情報一時を作成します。
     *
     * @return DbT2015KeisangoJohoTemp
     */
    int createDbT2015KeisangoJohoTemp();

    /**
     * 計算後情報一時を削除します。
     *
     * @return DbT2015KeisangoJohoTemp
     */
    int dropDbT2015KeisangoJohoTemp();

    /**
     * 計算後情報一時に登録します。
     *
     * @param entity dbT2015KeisangoJohoEntity
     * @return 登録件数
     */
    int insertDbT2015KeisangoJohoTemp(DbT2015KeisangoJohoEntity entity);
}
