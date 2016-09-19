/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranRelateEntity;

/**
 * 受給者給付実績一覧表取得Entityクラスです。
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
public interface IJukyushaKyufujissekiIchiranMapper {

    /**
     *
     * 受給者給付実績一覧表Entityの内容
     *
     * @param parameter JukyushaKyufujissekiIchiranMybatisParameter
     * @return List<JukyushaKyufujissekiIchiranRelateEntity>
     */
    List<JukyushaKyufujissekiIchiranRelateEntity> get受給者給付実績(JukyushaKyufujissekiIchiranMybatisParameter parameter);

    /**
     *
     * 受給者給付実績一覧表Entityの内容
     *
     * @param parameter JukyushaKyufujissekiIchiranMybatisParameter
     * @return List<JukyushaKyufujissekiIchiranRelateEntity>
     */
    List<JukyushaKyufujissekiIchiranRelateEntity> get給付実績高額介護サービス費(JukyushaKyufujissekiIchiranMybatisParameter parameter);

    /**
     *
     * 受給者給付実績一覧表Entityの内容
     *
     * @return List<JukyushaKyufujissekiIchiranRelateEntity>
     */
    List<JukyushaKyufujissekiIchiranRelateEntity> getSelectAll();
}
