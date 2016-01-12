/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.benmeitoroku;

import jp.co.ndensan.reams.db.dbu.definition.mybatis.param.benmeitoroku.BenmeiTorokuMeisaiJohoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeitoroku.BenmeiTorokuMeisaiJohoEntity;

/**
 * 弁明登録明細情報の取得処理を行うです。
 *
 */
public interface IBenmeiTorokuMeisaiJohoMapper {

    /**
     * 弁明登録明細情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 弁明登録明細情報パラメータ
     * @return BenmeiTorokuMeisaiJohoEntity
     */
    BenmeiTorokuMeisaiJohoEntity getBenmeiTorokuMeisaiJoho(BenmeiTorokuMeisaiJohoParameter mapperParameter);
}
