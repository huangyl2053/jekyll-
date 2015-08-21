/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IMinashi2GoshaDaicho;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;

/**
 * みなし2号者台帳を管理するインターフェースです。
 *
 * @author N8211 田辺 紘一
 */
public interface IMinashi2GoshaDaichoFinder {

    /**
     * 検索条件から該当する、みなし2号者台帳を取得します。
     *
     * @param condition
     * @return
     */
    List<IMinashi2GoshaDaicho> getみなし2号者台帳(ISearchCondition condition);
}
