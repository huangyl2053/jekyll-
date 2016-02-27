/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanshinseiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshinseiichiran.ShokanShinseiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshinseiichiran.ShokanShinseiIchiranParameterCount;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinseiichiran.ShokanShinseiIchiranRelateEntity;

/**
 * 償還払申請一覧のマッパーインタフェースです。
 */
public interface ShokanShinseiIchiranMapper {

    /**
     * 償還払支給申請リスト照会
     *
     * @param 償還払支給申請リスト取得条件照会 ShokanShinseiIchiranParameter
     * @return List<ShokanShinseiIchiranRelateEntity>
     */
    List<ShokanShinseiIchiranRelateEntity> select償還払支給申請リスト照会(ShokanShinseiIchiranParameter 償還払支給申請リスト取得条件照会);

    /**
     * 償還払支給申請リスト申請
     *
     * @param 償還払支給申請リスト取得条件申請 ShokanShinseiIchiranParameter
     * @return List<ShokanShinseiIchiranRelateEntity>
     */
    List<ShokanShinseiIchiranRelateEntity> select償還払支給申請リスト申請(ShokanShinseiIchiranParameter 償還払支給申請リスト取得条件申請);

    /**
     * select償還払支給申請情報件数取得
     *
     * @param 償還払支給申請情報件数取得 ShokanShinseiIchiranParameterCount
     * @return 償還払支給申請情報件数
     */
    int select償還払支給申請情報件数取得(ShokanShinseiIchiranParameterCount 償還払支給申請情報件数取得);

}
