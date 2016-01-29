/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishuyaokaigojyotaisandannkaihantei;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 要介護状態３段階変更の判定のマッパーインタフェースです。
 */
public interface IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper {
    
  /**
   * 要介護認定状態区分コードを返します。
   * @param 要介護認定状態区分検索条件
   * @return 
   */
    Code select要介護認定状態区分コードByParam(Map<String, Object> 要介護認定状態区分検索条件);

   /**
    * サービス提供を返します。
    * @param サービス提供年月検索条件
    * @return 
    */
    DbT3034ShokanShinseiEntity selectサービス提供年月ByParam(Map<String, Object> サービス提供年月検索条件);
}
