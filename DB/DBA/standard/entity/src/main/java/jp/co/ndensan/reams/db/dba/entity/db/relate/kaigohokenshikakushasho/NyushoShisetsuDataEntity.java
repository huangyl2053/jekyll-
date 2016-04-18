/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険施設等ビジネスです。
 *
 * @reamsid_L DBU-0490-040 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NyushoShisetsuDataEntity {

    private RString nyushoShisetsuShurui;
    private RString nyushoShisetsuName;
    private RString shisetsuNyushoYMD;
    private RString shisetsuTaishoYMD;
}
