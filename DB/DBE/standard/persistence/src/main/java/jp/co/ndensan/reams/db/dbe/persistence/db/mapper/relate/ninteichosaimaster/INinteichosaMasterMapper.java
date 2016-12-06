/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosaimaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.NinteichosaMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.NinteichosaMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster.SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;

/**
 * その他機関マスタのマッパーインタフェースです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
public interface INinteichosaMasterMapper {

    /**
     * 検索条件より、適当な条件を連結して、その他機関情報を検索する。
     *
     * @param 検索条件 その他機関情報検索条件
     * @return DbT5914SonotaKikanJohoEntity 検索結果の{@link DbT5914SonotaKikanJohoEntity}
     */
    List<SonotaKikanJohoEntity> selectSonotaKikanichiranList(NinteichosaMasterMapperParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、その他機関情報を検索する。
     *
     * @param 検索条件 その他機関情報検索条件
     * @return DbT5914SonotaKikanJohoEntity 検索結果の{@link DbT5914SonotaKikanJohoEntity}
     */
    List<DbT5914SonotaKikanJohoEntity> selectSonotaKikanJohoList(NinteichosaMasterMapperParameter 検索条件);

    /**
     * その他機関情報の重複チェック。
     *
     * @param 検索条件 その他機関情報検索条件
     * @return その他機関情報
     */
    int selectSonotaKikanJohoCount(NinteichosaMasterSearchParameter 検索条件);

    /**
     * 介護認定審査会委員所属機関情報件数検索処理。
     *
     * @param 検索条件 その他機関情報検索条件
     * @return 介護認定審査会委員所属機関情報件数
     */
    int selectKaigoNinteiShinsakaiCount(NinteichosaMasterSearchParameter 検索条件);

}
