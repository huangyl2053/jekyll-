/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikentokusokujo;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiikentokusokujo.ShujiiIkenTokusokujoParameter;

/**
 * 主治医意見書のマッパーインタフェースです。
 */
public interface IShujiiIkenTokusokujoMapper {

    /**
     * 督促状該当データ件数を取得します。
     *
     * @param parameter 検索条件
     * @return 督促状該当データ件数
     */
    int select督促状件数(ShujiiIkenTokusokujoParameter parameter);

    /**
     * 督促状対象者該当データ件数を取得します。
     *
     * @param parameter 検索条件
     * @return 督促状対象者該当データ件数
     */
    int select督促状対象者件数(ShujiiIkenTokusokujoParameter parameter);
}
