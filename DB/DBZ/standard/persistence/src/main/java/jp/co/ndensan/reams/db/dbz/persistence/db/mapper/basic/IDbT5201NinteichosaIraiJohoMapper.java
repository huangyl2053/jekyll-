/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.UpdateMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;

/**
 * DbT5201NinteichosaIraiJohoのマッパーIFです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public interface IDbT5201NinteichosaIraiJohoMapper {

    /**
     * {@link  DbT5201NinteichosaIraiJohoEntity}を取得します。
     *
     * @return {@link  DbT5201NinteichosaIraiJohoEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT5201NinteichosaIraiJohoEntity getEntity();

    /**
     * 認定調査依頼情報を更新します。
     *
     * @param 認定調査依頼情報 認定調査依頼情報
     * @return 更新件数
     */
    int update認定調査依頼情報BY申請書管理番号(UpdateMybatisParameter 認定調査依頼情報);
}
