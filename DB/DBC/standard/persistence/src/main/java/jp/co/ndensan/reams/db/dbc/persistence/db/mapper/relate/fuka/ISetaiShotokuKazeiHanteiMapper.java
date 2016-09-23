/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910.SetaiinHaakuSubMybitisParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiYinEntity;

/**
 * 2_世帯所得・課税判定（バッチ）のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2770-060 jinjue
 */
public interface ISetaiShotokuKazeiHanteiMapper {

    /**
     * 住所地特例該当情報を取得します。
     *
     * @param paramter 課税判定
     * @return 情報
     */
    List<SetaiYinEntity> select住所地特例該当(SetaiinHaakuSubMybitisParamter paramter);

    /**
     * 住所地特例該当以外情報を取得します。
     *
     * @param paramter 課税判定
     * @return 情報
     */
    List<SetaiYinEntity> select住所地特例該当以外(SetaiinHaakuSubMybitisParamter paramter);

    /**
     * 住所地特例以外の以外情報を取得します。
     *
     * @return 情報
     */
    List<SetaiYinEntity> select住所地特例以外の以外();

    /**
     * 生保区分情報を取得します。
     *
     * @return 情報
     */
    List<SetaiYinEntity> select生保区分();

    /**
     * 老齢福祉区分情報を取得します。
     *
     * @return 情報
     */
    List<SetaiYinEntity> select老齢福祉区分();

    /**
     * 介護所得情報を取得します。
     *
     * @return 情報
     */
    List<SetaiYinEntity> select介護所得();
}
