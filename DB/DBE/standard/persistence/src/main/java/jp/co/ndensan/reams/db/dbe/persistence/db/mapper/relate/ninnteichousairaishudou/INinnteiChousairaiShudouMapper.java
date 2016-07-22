/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninnteichousairaishudou;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairaishudou.NinnteiChousairaiShudouParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairaishudou.NinnteiChousairaiShudouEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairaijoho.ninteishinseijoho.NinteiShinseiJohoRelateEntity;

/**
 * 認定調査依頼(手動)のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1590-010 sunhaidi
 */
public interface INinnteiChousairaiShudouMapper {

    /**
     * 認定調査依頼情報を検索します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return NinnteiChousairaiShudouEntity
     */
    NinnteiChousairaiShudouEntity select認定調査依頼情報(NinnteiChousairaiShudouParameter parameter);

    /**
     * 更新用認定調査依頼情報を検索します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return NinteiShinseiJohoRelateEntity
     */
    NinteiShinseiJohoRelateEntity select更新用認定調査依頼情報(NinnteiChousairaiShudouParameter parameter);

    /**
     * 認定調査票差異チェック票を検索します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return List<NinnteiChousairaiShudouEntity>
     */
    List<NinnteiChousairaiShudouEntity> select認定調査票差異チェック票(NinnteiChousairaiShudouParameter parameter);

    /**
     * 認定調査依頼書情報を検索します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return NinnteiChousairaiShudouEntity
     */
    NinnteiChousairaiShudouEntity select認定調査依頼書(NinnteiChousairaiShudouParameter parameter);

    /**
     * 認定調査票_概況調査情報を検索します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return NinnteiChousairaiShudouEntity
     */
    NinnteiChousairaiShudouEntity select認定調査票_概況調査(NinnteiChousairaiShudouParameter parameter);

 /**
     * 認定調査依頼該当者履歴一覧を検索します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return List<NinnteiChousairaiShudouEntity>
     */
    List<NinnteiChousairaiShudouEntity> select認定調査依頼該当者履歴一覧(NinnteiChousairaiShudouParameter parameter);

}
