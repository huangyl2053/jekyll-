/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5591GogitaiJohoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 合議体情報作成のEntityクラスです。
 *
 * @author n3304 岡澤 政幸
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class GogitaiJohoSakuseiEntity {

    private DbT5591GogitaiJohoEntity 合議体情報;

    /**
     * コンストラクタです。
     */
    public GogitaiJohoSakuseiEntity() {
        this.合議体情報 = new DbT5591GogitaiJohoEntity();
    }

}
