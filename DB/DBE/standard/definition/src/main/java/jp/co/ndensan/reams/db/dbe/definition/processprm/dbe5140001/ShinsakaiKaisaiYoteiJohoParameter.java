/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.dbe5140001;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会開催予定登録1Parameterクラスです。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKaisaiYoteiJohoParameter {

    private RString 開催番号;
    private FlexibleDate 日付;
    private RString 開始予定時刻;
    private RString 終了予定時刻;
    private RString 催予定場所コード;
    private int 合議体番号;
    private int 予定定員;
    private int 自動割当定員;
    private int 委員定員;
    private RString 介護認定審査会進捗状況;
    private RString 審査会名称;
    private boolean is存在;
    private boolean is変更;
}
