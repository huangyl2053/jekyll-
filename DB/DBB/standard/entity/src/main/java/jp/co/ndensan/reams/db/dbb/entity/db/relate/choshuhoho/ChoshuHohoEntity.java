/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuhoho;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護徴収方法RelateEntityクラスです。
 *
 * @reamsid_L DBB-1760-030 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoshuHohoEntity {

    private DbT2001ChoshuHohoEntity entity;
    private RString choshuHoho3gat;

    /**
     * 介護徴収方法Entityを生成します
     */
    public ChoshuHohoEntity() {
        entity = new DbT2001ChoshuHohoEntity();
        choshuHoho3gat = new RString("");
    }

    /**
     * MD5値を計算し、設定します
     */
    public void initializeMd5ToEntities() {
        entity.initializeMd5();
    }
}
