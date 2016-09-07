/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.ShujiiUpdateMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
public interface IDbT5301ShujiiIkenshoIraiJohoMapper {

    /**
     * {@link  DbT5301ShujiiIkenshoIraiJohoEntity}を取得します。
     *
     * @return {@link  DbT5301ShujiiIkenshoIraiJohoEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT5301ShujiiIkenshoIraiJohoEntity getEntity();

    /**
     * 主治医意見書作成依頼情報を更新します。
     *
     * @param 主治医意見書依頼情報 主治医意見書依頼情報
     * @return 更新件数
     */
    DbT5301ShujiiIkenshoIraiJohoEntity get主治医意見書依頼情報BY申請書管理番号(ShujiiUpdateMybatisParameter 主治医意見書依頼情報);

    /**
     * バッチプロセス用。
     *
     * @return List<RString>
     */
    List<RString> getListForProcess();
}
