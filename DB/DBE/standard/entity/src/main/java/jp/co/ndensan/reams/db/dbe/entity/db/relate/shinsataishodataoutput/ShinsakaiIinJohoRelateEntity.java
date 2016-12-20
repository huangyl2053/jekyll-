/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員情報のマッピング用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiIinJohoRelateEntity {

    private RString 介護認定審査会開催番号;
    private RString 介護認定審査会委員コード;
    private RString 介護認定審査会委員氏名;
    private RString 介護認定審査会議長区分コード;
    private boolean 委員出席;
    private RString 介護認定審査員資格;
    private RString 委員出席時間;
    private RString 委員退席時間;
    private boolean 委員遅刻有無;
    private boolean 委員早退有無;

}
