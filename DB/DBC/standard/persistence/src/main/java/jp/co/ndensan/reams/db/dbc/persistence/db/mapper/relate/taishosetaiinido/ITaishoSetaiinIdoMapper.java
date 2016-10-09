/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishosetaiinido;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishosetaiinido.TaishoSetaiinIdoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.taishosetaiinido.TaishoSetaiinIdoEntity;

/**
 * 基準収入額適用管理マスタのリストの取得
 *
 * @reamsid_L DBC-4640-080 liuxiaoyu
 */
public interface ITaishoSetaiinIdoMapper {

    /**
     * 基準収入額適用管理取得する。
     *
     * @param parameter TaishoSetaiinIdoMybatisParameter
     * @return List<TaishoSetaiinIdoEntity>
     */
    List<TaishoSetaiinIdoEntity> select基準収入額適用管理(TaishoSetaiinIdoMybatisParameter parameter);

    /**
     * 基準収入額適用管理マスタを取得します。
     *
     * @param parameter TaishoSetaiinIdoMybatisParameter
     * @return List<DbT3116KijunShunyugakuTekiyoKanriEntity>
     */
    List<DbT3116KijunShunyugakuTekiyoKanriEntity> select基準収入額適用管理情報(TaishoSetaiinIdoMybatisParameter parameter);

    /**
     * 基準収入額適用管理マスタねんど年度 によっての抽出。
     *
     * @param parameter TaishoSetaiinIdoMybatisParameter
     * @return List<DbT3116KijunShunyugakuTekiyoKanriEntity>
     */
    List<DbT3116KijunShunyugakuTekiyoKanriEntity> select基準収入額適用管理マスタ(TaishoSetaiinIdoMybatisParameter parameter);

}
