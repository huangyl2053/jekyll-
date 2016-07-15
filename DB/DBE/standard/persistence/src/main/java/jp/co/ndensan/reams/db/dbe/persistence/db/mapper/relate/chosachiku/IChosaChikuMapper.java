/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosachiku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosachiku.ChosaChikuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachiku.ChosaChikuEntity;

/**
 * 地区認定調査員情報のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0021-010 zhangzhiming
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
}
