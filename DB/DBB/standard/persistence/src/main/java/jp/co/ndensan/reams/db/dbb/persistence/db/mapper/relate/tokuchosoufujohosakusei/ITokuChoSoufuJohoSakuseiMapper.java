
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;

/**
 * 通知書打ち分け条件の取得処理
 *
 * @reamsid_L DBB-0780-030 xicongwang
 */
public interface ITokuChoSoufuJohoSakuseiMapper {

    /**
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> selectUe10122T0511NenkinTokuchoKaifuJohotemp();

    /**
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> select46UeT0511NenkinTokuchoKaifuJohotemp();

    /**
     *
     * @return List<ResultEntity>
     */
    List<TokuChoSoufuJohoSakuseiEntity> select8UeT0511NenkinTokuchoKaifuJohotemp();

    /**
     *
     * @return List<ResultEntity>
     */
    List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> selectUeT0515KaigohokenNenkinTokuchoTaishoshaJoho550tempAll();
}
