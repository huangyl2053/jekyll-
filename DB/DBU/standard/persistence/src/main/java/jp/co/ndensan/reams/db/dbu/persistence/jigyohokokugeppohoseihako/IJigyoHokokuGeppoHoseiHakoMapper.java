/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.persistence.jigyohokokugeppohoseihako;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataDeleteParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDataUpdateParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
/**
 *
 * @author sunhui
 */
public interface IJigyoHokokuGeppoHoseiHakoMapper {  
   List<DbT7021JigyoHokokuTokeiDataEntity> select事業報告集計一覧データ(JigyoHokokuGeppoSearchParameter jigyoHokokuGeppoParameter);
   List<DbT7021JigyoHokokuTokeiDataEntity> select報告年度様式種類(JigyoHokokuGeppoDetalSearchParameter jigyoHokokuGeppoDetalParameter);
   int update事業報告集計一覧データ(JigyoHokokuGeppoDataUpdateParameter jigyoHokokuGeppoDataParameter);
   int delete事業報告年報(JigyoHokokuGeppoDataDeleteParameter jigyoHokokuGeppoDataParameter);
}
