/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170020.TorikomiDataTempEntity;

/**
 * 介護サービス内容取込結果のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3400-030 liuyl
 */
public interface IKaigoSabisuNaiyoCSVSakuseiMapper {

    /**
     * 介護サービス内容取込結果を取得します。
     *
     * @return List<TorikomiDataTempEntity>
     */
    List<TorikomiDataTempEntity> select介護サービス内容取込結果();
}
