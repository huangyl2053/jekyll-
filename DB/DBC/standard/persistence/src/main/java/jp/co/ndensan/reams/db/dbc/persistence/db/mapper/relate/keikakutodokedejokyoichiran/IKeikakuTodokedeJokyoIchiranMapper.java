/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.keikakutodokedejokyoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.keikakutodokedejokyoichiran.KeikakuTodokedeJokyoIchiranParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.keikakutodokedejokyoichiran.KeikakuTodokedeJokyoIchiranEntity;

/**
 * 計画届出状況リストのデータを抽出するのマッピングクラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
public interface IKeikakuTodokedeJokyoIchiranMapper {

    /**
     * データを抽出。
     *
     * @param param 検索パラメータ
     * @return 処理対象外のデータ
     */
    List<KeikakuTodokedeJokyoIchiranEntity> getデータを抽出(KeikakuTodokedeJokyoIchiranParameter param);

}
