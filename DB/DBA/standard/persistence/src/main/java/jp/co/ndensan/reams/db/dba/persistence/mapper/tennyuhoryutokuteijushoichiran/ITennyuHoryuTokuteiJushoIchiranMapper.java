/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.tennyuhoryutokuteijushoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiJushoIchiranEntity;

/**
 *
 * 転入保留特定住所登録のMapperクラスです。
 */
public interface ITennyuHoryuTokuteiJushoIchiranMapper {

    /**
     * 転入保留特定住所一覧のデータを取得します。
     *
     * @return List<TennyuHoryuTokuteiJushoIchiranEntity>
     */
    List<TennyuHoryuTokuteiJushoIchiranEntity> getTennyuHoryuTokuteiJushoIchiran();
}
