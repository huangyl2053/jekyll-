/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;

/**
 * 国保資格情報インポート用Entityリストの編集用のデータ取得Entity。
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhoShikakuJyohoYoResultEntity {

    private TorikomiKokuhoJyohoEntity 取込国保情報Entity;
    private DbT7123KokuhoShikakuInfoEntity 現在国保資格情報Entity;
}
