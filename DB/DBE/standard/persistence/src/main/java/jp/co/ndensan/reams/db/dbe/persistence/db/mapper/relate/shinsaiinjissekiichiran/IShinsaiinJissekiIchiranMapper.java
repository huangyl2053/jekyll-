/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsaiinjissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranRelateEntity;

/**
 * 介護認定審査会委員報酬集計表のデータ取得のマッパーインタフェ―スです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
public interface IShinsaiinJissekiIchiranMapper {

    /**
     * 介護認定審査会委員報酬集計表の取得します。
     *
     * @param mapperParameter 介護認定審査会委員報酬集計表のMyBatis用パラメータ
     * @return List<ShinsaiinJissekiIchiranRelateEntity>
     */
    List<ShinsaiinJissekiIchiranRelateEntity> get介護認定審査会委員報酬集計表(ShinsaiinJissekiIchiranMybitisParamter mapperParameter);

}
