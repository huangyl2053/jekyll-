/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員情報CSV用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiIinJohoEucCsvEntity {

    @CsvField(order = 1, name = "介護認定審査会開催番号")
    private RString 介護認定審査会開催番号;
    @CsvField(order = 2, name = "介護認定審査会委員コード")
    private RString 介護認定審査会委員コード;
    @CsvField(order = 3, name = "介護認定審査会委員氏名")
    private RString 介護認定審査会委員氏名;
    @CsvField(order = 4, name = "介護認定審査会委員長区分コード")
    private RString 介護認定審査会委員長区分コード;
    @CsvField(order = 5, name = "委員出席")
    private boolean 委員出席;
    @CsvField(order = 6, name = "介護認定審査員資格")
    private RString 介護認定審査員資格;
    @CsvField(order = 7, name = "委員出席時間")
    private RString 委員出席時間;
    @CsvField(order = 8, name = "委員退席時間")
    private RString 委員退席時間;
    @CsvField(order = 9, name = "委員遅刻有無")
    private boolean 委員遅刻有無;
    @CsvField(order = 10, name = "委員早退有無")
    private boolean 委員早退有無;

}
