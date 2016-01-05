/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe223001.UpdateMybatisParameter;

/**
 * {@link jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5031NinteiChosaHoshuTankaEntity}のマッパーIFです。
 *
 */
public interface IDbT5201NinteichosaIraiJohoMapper {


   /**
     * 認定調査依頼情報を更新します。
     *
     * @param 認定調査依頼情報 認定調査依頼情報
     * @return 更新件数
     */
    int update認定調査依頼情報BY申請書管理番号(UpdateMybatisParameter 認定調査依頼情報);
}
