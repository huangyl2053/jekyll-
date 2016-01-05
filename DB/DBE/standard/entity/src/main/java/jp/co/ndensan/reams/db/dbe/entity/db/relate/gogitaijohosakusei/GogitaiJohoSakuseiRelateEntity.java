/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;

/**
 * 合議体情報作成RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GogitaiJohoSakuseiRelateEntity {

    private DbT5591GogitaiJohoEntity gogitaiJohoEntity;
    private DbT5592ShinsakaiKaisaiBashoJohoEntity shinsakaiKaisaiBashoJohoEntity;
    private DbT5593GogitaiWariateIinJohoEntity gogitaiWariateIinJohoEntity;
    private DbT5594ShinsakaiIinJohoEntity shinsakaiIinJohoEntity;
}
