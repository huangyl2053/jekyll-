/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 提供内容のEntityクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TeyikyouNaiyouRelateEntity {

    private RString 提供内容;
    private RString 未設定事由;
}
