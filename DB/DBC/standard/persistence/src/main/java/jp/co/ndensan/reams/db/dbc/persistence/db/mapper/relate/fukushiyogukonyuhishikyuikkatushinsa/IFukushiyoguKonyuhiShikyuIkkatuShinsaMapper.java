/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyuikkatushinsa;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.shokanfukushiyoguhanbaihi.ShokanShinseiEntity;

/**
 * 未審査申請一覧取得 のマッパーインタフェースです。
 *
 * @author chenaoqi
 */
public interface IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper {

    /**
     * 償還払請求基本のキーより、該当する償還払い請求基本情報を取得する。
     *
     * @param 未審査申請取得検索条件 未審査申請取得検索条件
     * @return DbT3038ShokanKihonEntity 償還払請求基本Entity
     */
    List<ShokanShinseiEntity> select未審査申請(Map<String, Object> 未審査申請取得検索条件);
}
