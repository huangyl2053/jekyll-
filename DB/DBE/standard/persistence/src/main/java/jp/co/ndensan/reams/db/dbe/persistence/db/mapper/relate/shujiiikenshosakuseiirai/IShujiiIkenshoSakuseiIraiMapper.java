/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshosakuseiirai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiikenshosakuseiiraiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書のマッパーインタフェースです。
 */
public interface IShujiiIkenshoSakuseiIraiMapper {

    /**
     * 申請者情報を取得します。
     *
     * @param hiHokenshaNo 被保険者番号
     * @return 主治医意見書作成依頼RelateEntity
     */
    List<ShujiiikenshosakuseiiraiRelateEntity> get申請者情報(RString hiHokenshaNo);

    /**
     * 主治医意見書作成依頼情報を取得します。
     *
     * @param hiHokenshaNo 被保険者番号
     * @return 主治医意見書作成依頼情報Entity
     */
    List<DbT5301ShujiiIkenshoIraiJohoEntity> get主治医意見書作成依頼情報(RString hiHokenshaNo);

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param hiHokenshaNo 被保険者番号
     * @return 要介護認定申請情報Entity
     */
    List<DbT5101NinteiShinseiJohoEntity> get要介護認定申請情報(RString hiHokenshaNo);
}
