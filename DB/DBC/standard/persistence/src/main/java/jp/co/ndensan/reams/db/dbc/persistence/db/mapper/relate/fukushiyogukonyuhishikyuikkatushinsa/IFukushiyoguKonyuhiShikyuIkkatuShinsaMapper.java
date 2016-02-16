/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyuikkatushinsa;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyuikkatushinsa.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyuikkatushinsa.ShokanFukushiYoguHanbaihiParameter;

/**
 * 未審査申請一覧取得
 *
 * @author 陳奥奇
 */
public interface IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper {

    /**
     * select未審査申請。
     *
     * @param 未審査申請取得検索条件 未審査申請取得検索条件
     * @return DbT3038ShokanKihonEntity 償還払請求基本Entity
     */
    List<ShokanShinseiEntity> select未審査申請(ShokanFukushiYoguHanbaihiParameter 未審査申請取得検索条件);
}
