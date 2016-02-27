/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjohogogitai;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会委員情報Entityです。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiIinJohoGoitaiEntity {

    private RString 介護認定審査会委員コード;
    private RString 介護認定審査会委員氏名;
    private int 合議体番号;
    private RString 合議体名称;
    private RString 住所;
}
