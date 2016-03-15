/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosachikuchichoson;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikuchichoson.ChosaChikuChichosonParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachikuchichoson.ChosaChikuChichosonRelateEntity;

/**
 * 認定調査スケジュール登録7のマッパーインタフェースです。
 */
public interface IChosaChikuChichosonMapper {

    /**
     * 調査地区市町村一覧のリストを取得します。
     *
     * @param parameter ChosaChikuChichosonParameter
     * @return List<ChosaChikuChichosonRelateEntity>
     */
    List<ChosaChikuChichosonRelateEntity> select調査地区市町村一覧(ChosaChikuChichosonParameter parameter);

    /**
     * 地区市町村情報の削除処理する。
     *
     * @param parameter ChosaChikuChichosonParameter
     * @return int
     */
    int delete地区市町村情報(ChosaChikuChichosonParameter parameter);
}
