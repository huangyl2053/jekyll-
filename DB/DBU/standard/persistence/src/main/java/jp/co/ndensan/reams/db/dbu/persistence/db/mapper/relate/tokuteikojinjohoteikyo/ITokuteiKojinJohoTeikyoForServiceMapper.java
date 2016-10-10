/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoParamater;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TokuteiKojinJohoKoumokuHanKanriRelateEntity;

/**
 * 特定個人情報提供のマッパーインタフェースです。
 *
 * @reamsid_L DBU-4880-110 dingyi
 */
public interface ITokuteiKojinJohoTeikyoForServiceMapper {

    /**
     * 有効な版番号情報を取得します。
     *
     * @param paramater パラメータ
     * @return 有効な版番号情報
     */
    List<DbT7301TokuteiKojinJohoHanKanriEntity> get有効な版番号(TokuteiKojinJohoTeikyoParamater paramater);

    /**
     * 初回提供済情報を取得します。
     *
     * @param paramater パラメータ
     * @return 初回提供済である直近の版番号情報
     */
    List<DbT7301TokuteiKojinJohoHanKanriEntity> get初回提供済である直近の版番号(TokuteiKojinJohoTeikyoParamater paramater);

    /**
     * 直近の版番号情報を取得します。
     *
     * @param paramater パラメータ
     * @return 直近の版番号情報
     */
    List<DbT7301TokuteiKojinJohoHanKanriEntity> get直近の版番号(TokuteiKojinJohoTeikyoParamater paramater);

    /**
     * 特定個人情報項目版管理情報を取得します。
     *
     * @param paramater パラメータ
     * @return 特定個人情報項目版管理情報
     */
    List<TokuteiKojinJohoKoumokuHanKanriRelateEntity> get特定個人情報項目版管理(TokuteiKojinJohoTeikyoParamater paramater);

}
