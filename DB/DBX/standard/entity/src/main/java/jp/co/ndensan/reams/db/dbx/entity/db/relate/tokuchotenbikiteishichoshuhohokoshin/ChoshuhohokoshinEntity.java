/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴天引き停止徴収方法更新のエンティティです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ChoshuhohokoshinEntity {

    private RString 被保険者番号;
    private DbV2001ChoshuHohoEntity 介護徴収方法;

}
