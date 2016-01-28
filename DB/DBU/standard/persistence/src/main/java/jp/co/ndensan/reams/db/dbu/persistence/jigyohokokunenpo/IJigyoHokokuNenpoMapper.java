/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.jigyohokokunenpo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.JigyoHokokuNenpoDetalParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo.JigyoHokokuNenpoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;

/**
 * 事業報告（年報）補正、発行のMapperクラスです。
 *
 */
public interface IJigyoHokokuNenpoMapper {

    /**
     * 事業報告年報集計データ一覧を取得します。
     *
     * @param parameter 事業報告集計一覧データの取得処理のパラメター
     * @return 事業報告集計一覧データEntityリスト
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> getJigyoHokokuNenpoList(JigyoHokokuNenpoParameter parameter);

    /**
     * 事業報告年報詳細データを取得します。
     *
     * @param parameter 事業報告年報詳細データの取得処理のパラメター
     * @return 事業報告集計一覧データEntityリスト
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> getJigyoHokokuNenpoDetal(JigyoHokokuNenpoDetalParameter parameter);

}
