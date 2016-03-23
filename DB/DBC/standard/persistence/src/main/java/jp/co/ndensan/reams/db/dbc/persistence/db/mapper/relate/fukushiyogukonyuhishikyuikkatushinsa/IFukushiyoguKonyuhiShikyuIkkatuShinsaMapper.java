/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyuikkatushinsa;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyuikkatushinsa.ShokanFukushiYoguHanbaihiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyuikkatushinsa.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 未審査申請一覧取得
 */
public interface IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper {

    /**
     * select未審査申請。
     *
     * @param 未審査申請取得検索条件 未審査申請取得検索条件
     * @return ShokanShinseiEntity 未審査申請一覧Entity
     */
    List<ShokanShinseiEntity> select未審査申請(ShokanFukushiYoguHanbaihiParameter 未審査申請取得検索条件);

    /**
     * get識別コード
     *
     * @param parameter Map<String, Object>
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity get識別コード(Map<String, Object> parameter);
}
