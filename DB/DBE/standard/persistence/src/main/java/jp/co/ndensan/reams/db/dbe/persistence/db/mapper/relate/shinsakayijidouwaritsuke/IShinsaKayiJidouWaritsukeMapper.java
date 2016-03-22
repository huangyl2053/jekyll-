/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakayijidouwaritsuke;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.kaigoninteishinsakai.KaigoNinteiShinsakaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeRelateEntity;

/**
 * 審査会自動割付のマッパーインタフェースです。
 */
public interface IShinsaKayiJidouWaritsukeMapper {

    /**
     * 審査会自動割付のリストを取得します。
     *
     * @param 審査会自動割付_審査会自動割付検索条件 審査会自動割付_審査会自動割付検索条件
     * @return List<ShinsaKayiJidouWaritsukeRelateEntity>
     */
    List<ShinsaKayiJidouWaritsukeRelateEntity> getShinsaKayiJidouWaritsukeList(KaigoNinteiShinsakaiParameter 審査会自動割付_審査会自動割付検索条件);

}
