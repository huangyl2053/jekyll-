/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.itakusakichosainichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.itakusakichosainichiran.ItakusakiChosainIchiranRelateEntity;

/**
 *
 * 調査委託先・調査員一覧表の処理のインタフェースです。
 */
public interface IItakusakiChosainIchiranMapper {

    /**
     * 調査員一覧情報の取得します。
     *
     * @param parameter データアクセスパラメータマップ
     * @return List<ItakusakiChosainIchiranRelateEntity>
     */
    public List<ItakusakiChosainIchiranRelateEntity> getNinteiChoSain(Map<String, Object> parameter);
}
