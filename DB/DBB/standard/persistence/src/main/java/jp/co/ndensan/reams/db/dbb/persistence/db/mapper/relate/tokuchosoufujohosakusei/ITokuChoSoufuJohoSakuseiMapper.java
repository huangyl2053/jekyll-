
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;

/**
 * 通知書打ち分け条件の取得処理
 *
 * @reamsid_L DBB-0780-030 xicongwang
 */
public interface ITokuChoSoufuJohoSakuseiMapper {

    /**
     * 特徴開始月が10月 or 12月 or 2月の場合<br/>
     * 取得された年金特徴回付情報を元に最新の被保険者情報、最新の賦課情報、最新の徴収方法情報を取得する<br/>
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> selectUe10122T0511NenkinTokuchoKaifuJohotemp();

    /**
     * 特徴開始月が翌4月 or 翌6月の場合<br/>
     * 取得された年金特徴回付情報を元に最新の被保険者情報、最新の賦課情報、最新の徴収方法情報を取得する<br/>
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> select46UeT0511NenkinTokuchoKaifuJohotemp();

    /**
     * 特徴開始月が8月の場合<br/>
     * 取得された年金特徴回付情報を元に最新の被保険者情報、最新の賦課情報、最新の徴収方法情報を取得する<br/>
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> select8UeT0511NenkinTokuchoKaifuJohotemp();

    /**
     * 介護保険年金特徴対象者情報(550バイト)を取得する
     *
     * @return List<ResultEntity>
     */
    List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> selectUeT0515KaigohokenNenkinTokuchoTaishoshaJoho550tempAll();
}
