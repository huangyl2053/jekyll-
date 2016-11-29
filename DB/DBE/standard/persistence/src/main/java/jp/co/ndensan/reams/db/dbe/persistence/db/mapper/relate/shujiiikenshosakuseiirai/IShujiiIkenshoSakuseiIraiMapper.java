/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshosakuseiirai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiikenshosakuseiiraiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;

/**
 * 主治医意見書のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public interface IShujiiIkenshoSakuseiIraiMapper {

    /**
     * 申請者情報を取得します。
     *
     * @param param 主治医意見書一覧のMyBatis用パラメータ
     * @return 主治医意見書作成依頼RelateEntity
     */
    List<ShujiiikenshosakuseiiraiRelateEntity> get申請者情報(ShujiiIkenshoSakuseiIraiParameter param);
    
    /**
     * 指定条件による申請者情報の該当件数を返します。
     *
     * @param parameter パラメータ
     * @return 申請者情報の件数
     */
    int countShinSeiShaJoho(ShujiiIkenshoSakuseiIraiParameter parameter);

    /**
     * 主治医意見書作成依頼情報を取得します。
     *
     * @param param 主治医意見書一覧のMyBatis用パラメータ
     * @return 主治医意見書作成依頼情報Entity
     */
    List<DbT5301ShujiiIkenshoIraiJohoEntity> get主治医意見書作成依頼情報(ShujiiIkenshoSakuseiIraiParameter param);

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param param 主治医意見書一覧のMyBatis用パラメータ
     * @return 要介護認定申請情報Entity
     */
    List<DbT5101NinteiShinseiJohoEntity> get要介護認定申請情報(ShujiiIkenshoSakuseiIraiParameter param);

    /**
     * 宛名情報を取得します。
     *
     * @param param 宛名情報のMyBatis用パラメータ
     * @return 宛名情報Entity
     */
    ShujiiIraiAtenaJohoRelateEntity get宛名情報(ShujiiIraiAtenaJohoParameter param);
}
