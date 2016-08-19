/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ出力（モバイル）のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NijihanteiKekkaTorokuMobileShinsaiinRelateEntity {

    private RString 介護認定審査会開催番号;
    private RString 介護認定審査会開催予定年月日;
    private RString 介護認定審査会開始予定時刻;
    private RString 介護認定審査会終了予定時刻;
    private RString 介護認定審査会開催予定場所コード;
    private RString 合議体番号;
    private RString 介護認定審査会予定定員;
    private RString 介護認定審査会最大定員;
    private RString 介護認定審査会自動割当定員;
    private RString 介護認定審査会委員定員;
    private RString 介護認定審査会資料作成年月日;
    private RString 介護認定審査会進捗状況;
    private RString 介護認定審査会割当済み人数;
    private RString 資料作成済フラグ;
    private RString 介護認定審査会委員コード;
    private RString 介護認定審査会開催年月日;
    private RString 介護認定審査会議長区分コード;
    private RString 委員出席;
    private RString 委員遅刻有無;
    private RString 委員出席時間;
    private RString 委員早退有無;
    private RString 委員退席時間;
}
