/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査会割当委員情報出力（モバイル）CSV用データEntity。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NijihanteiKekkaTorokuMobileShinsaiinEucCsvEntity {

    @CsvField(order = 1, name = "介護認定審査会開催番号 ")
    private RString 介護認定審査会開催番号;
    @CsvField(order = 2, name = "介護認定審査会開催予定年月日")
    private RString 介護認定審査会開催予定年月日;
    @CsvField(order = 3, name = "介護認定審査会開始予定時刻")
    private RString 介護認定審査会開始予定時刻;
    @CsvField(order = 4, name = "介護認定審査会終了予定時刻")
    private RString 介護認定審査会終了予定時刻;
    @CsvField(order = 5, name = "介護認定審査会開催予定場所コード　")
    private RString 介護認定審査会開催予定場所コード;
    @CsvField(order = 6, name = "合議体番号")
    private RString 合議体番号;
    @CsvField(order = 7, name = "介護認定審査会予定定員")
    private RString 介護認定審査会予定定員;
    @CsvField(order = 8, name = "介護認定審査会最大定員")
    private RString 介護認定審査会最大定員;
    @CsvField(order = 9, name = "介護認定審査会自動割当定員")
    private RString 介護認定審査会自動割当定員;
    @CsvField(order = 10, name = "介護認定審査会委員定員")
    private RString 介護認定審査会委員定員;
    @CsvField(order = 11, name = "介護認定審査会資料作成年月日")
    private RString 介護認定審査会資料作成年月日;
    @CsvField(order = 12, name = "介護認定審査会進捗状況")
    private RString 介護認定審査会進捗状況;
    @CsvField(order = 13, name = "介護認定審査会割当済み人数")
    private RString 介護認定審査会割当済み人数;
    @CsvField(order = 14, name = "資料作成済フラグ")
    private RString 資料作成済フラグ;
    @CsvField(order = 15, name = "介護認定審査会委員コード")
    private RString 介護認定審査会委員コード;
    @CsvField(order = 16, name = "介護認定審査会開催年月日")
    private RString 介護認定審査会開催年月日;
    @CsvField(order = 17, name = "介護認定審査会議長区分コード")
    private RString 介護認定審査会議長区分コード;
    @CsvField(order = 18, name = "委員出席")
    private RString 委員出席;
    @CsvField(order = 19, name = "委員遅刻有無")
    private RString 委員遅刻有無;
    @CsvField(order = 20, name = "委員出席時間")
    private RString 委員出席時間;
    @CsvField(order = 21, name = "委員早退有無")
    private RString 委員早退有無;
    @CsvField(order = 22, name = "委員退席時間")
    private RString 委員退席時間;
}
