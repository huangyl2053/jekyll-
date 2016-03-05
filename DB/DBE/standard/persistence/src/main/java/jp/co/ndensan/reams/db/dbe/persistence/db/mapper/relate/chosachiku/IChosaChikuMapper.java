/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosachiku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachiku.ChosaChikuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachiku.ChosaChikuEntity;

/**
 * 地区認定調査員情報のマッパーインタフェースです。
 */
public interface IChosaChikuMapper {

    /**
     * 調査地区/市町村情報のリストを取得します。
     *
     * @return List<ChosaChikuEntity>
     */
    List<ChosaChikuEntity> select調査地区情報();

    /**
     * 調査地区一覧のリストを取得します。
     *
     * @param paramer ChosaChikuMapperParameter
     * @return List<ChosaChikuEntity>
     */
    List<ChosaChikuEntity> select認定調査員一覧(ChosaChikuMapperParameter paramer);

    /**
     * 地区認定調査員情報の削除処理する。
     *
     * @param paramer ChosaChikuMapperParameter
     * @return int
     */
    int delete認定調査員情報(ChosaChikuMapperParameter paramer);

}
