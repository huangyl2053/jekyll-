/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.ShinseiIchiranEntity;

/**
 * 要介護認定情報提供一括発行のマッパーインタフェースです。
 *
 * @author N3212 竹内 和紀
 */
public interface IYokaigoNinteiJohoTeikyoIkkatsuHakkoMapper {

    /**
     * 検索条件に該当する申請一覧の件数を取得します。
     *
     * @param parameter YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter
     * @return 検索条件に該当する申請一覧の件数
     */
    int select申請一覧件数(YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter parameter);

    /**
     * 検索条件に該当する申請一覧を取得します。
     *
     * @param parameter YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter
     * @return 検索条件に該当する申請一覧
     */
    List<ShinseiIchiranEntity> select申請一覧(YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter parameter);
}
