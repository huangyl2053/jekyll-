/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc160022;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecodeichiran.ServicecodeIchiranMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.ServicecodeIchiranEntity;

/**
 * サービスコード一覧表のMapperです。
 *
 * @reamsid_L DBC-3310-030 chenyadong
 */
public interface IServicecodeIchiranMapper {

    /**
     * 介護サービス内容データを取得する。
     *
     * @param param param
     * @return {@link List<ServicecodeIchiranEntity>}
     */
    List<ServicecodeIchiranEntity> select介護サービス内容(ServicecodeIchiranMybatisParameter param);
}
