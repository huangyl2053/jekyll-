/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshotoroku;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医意見書登録RelateEntityクラスです。
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoTorokuRelateEntity {

    private LasdecCode shichosonCode;
    private DbT5301ShujiiIkenshoIraiJohoEntity dbt5301Entity;
    private DbT5302ShujiiIkenshoJohoEntity dbt5302Entity;
    private DbT5912ShujiiJohoEntity dbt5912Entity;
    private DbT5911ShujiiIryoKikanJohoEntity dbt5911Entity;

}
