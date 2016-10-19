/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nenkintokucho;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb241001.TokuchoHaishinDataTorikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nenkintokucho.NenkinTokuchoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みのmapperのクラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
public interface INenkinTokuchoMapper {

    /**
     * 取込ファイル_回付情報を取得
     *
     * @return NenkinTokuchoEntity
     */
    NenkinTokuchoEntity get取込ファイル_回付情報();

    /**
     * 年金特徴回付情報を取得
     *
     * @param parameter TokuchoHaishinDataTorikomiMybatisParameter
     * @return UeT0511NenkinTokuchoKaifuJohoEntity
     */
    UeT0511NenkinTokuchoKaifuJohoEntity select年金特徴回付情報(TokuchoHaishinDataTorikomiMybatisParameter parameter);
}
