/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nenkintokucho;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.nenkintokucho.NenkinTokuchoEntity;

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

}
