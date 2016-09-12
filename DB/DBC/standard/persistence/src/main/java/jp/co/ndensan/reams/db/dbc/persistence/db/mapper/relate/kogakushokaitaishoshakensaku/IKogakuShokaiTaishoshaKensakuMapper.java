/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakushokaitaishoshakensaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuSearch;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku.JigyoKogakuShokaiTaishoshaKensakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuEntity;

/**
 * 検索条件より、対象者一覧を取得する。
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
public interface IKogakuShokaiTaishoshaKensakuMapper {

    /**
     * 入力.メニューID＝DBCMN11004(高額介護サービス費照会)の場合、検索条件より、対象者一覧を取得する。
     *
     * @param parameter 高額介護サービス費一覧検索条件Entity
     * @return list＜高額介護サービス費一覧＞
     */
    List<KogakuShokaiTaishoshaKensakuEntity> get高額介護サービス費一覧(KogakuShokaiTaishoshaKensakuSearch parameter);

    /**
     * 入力.メニューID＝DBCMN11004(高額介護サービス費照会)の場合、検索条件より、対象者一覧を取得する。
     *
     * @param parameter 高額介護サービス費一覧検索条件Entity
     * @return list＜高額介護サービス費一覧＞
     */
    List<JigyoKogakuShokaiTaishoshaKensakuEntity> get事業高額介護サービス費一覧(KogakuShokaiTaishoshaKensakuSearch parameter);
}
