/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.postmainpanel;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.postmainpanel.PostMainPanelMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.postmainpanel.PostMainPanelEntity;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public interface IPostMainPanelMapper {

    /**
     * 広域保険者情報取得する。
     *
     * @param parameter PostMainPanelMybatisParameter
     * @return List<PostMainPanelEntity>
     */
    List<PostMainPanelEntity> get広域保険者(PostMainPanelMybatisParameter parameter);

    /**
     * 広域保険者for00情報取得する
     *
     * @param parameter Map<String, Object>
     * @return List<PostMainPanelEntity>
     */
    List<PostMainPanelEntity> get広域保険者for00(Map<String, Object> parameter);

}
