/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb014001.FuchoKarisanteiFukaMybatisParameter;

/**
 * バッチ設計_DBBBT34001_普徴仮算定賦課のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public interface IFuchoKarisanteiFukaMapper {

    /**
     * 処理日付管理テーブルを更新するメソッドです。
     *
     * @param parameter FuchoKarisanteiFukaMybatisParameter
     */
    void update処理日付管理(FuchoKarisanteiFukaMybatisParameter parameter);
}
