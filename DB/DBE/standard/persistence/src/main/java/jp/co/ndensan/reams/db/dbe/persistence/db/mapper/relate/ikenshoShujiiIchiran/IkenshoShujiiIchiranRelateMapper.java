/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshoShujiiIchiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.basic.ikenshoShujiiIchiran.IkenshoShujiiIchiranRelateEntity;

/**
 * 主治医医療機関・主治医一覧表のマッパーインタフェースです。
 */
public interface IkenshoShujiiIchiranRelateMapper {
 
    /**
     * 主治医医療機関・主治医一覧表を取得します。
     *
     * @param parameter 主治医一覧表検索条件
     * @return IkenshoShujiiIchiranRelateEntity 検索結果の{@link IkenshoShujiiIchiranRelateEntity}
     */
    List<IkenshoShujiiIchiranRelateEntity> getIkenshoShujiiIchiranRelateEntity(Map<String, Object> parameter);
}
