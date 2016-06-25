/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosascheduleinput;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面項目のクラスです。
 *
 * @reamsid_L DBE-0020-060 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.Unusedprivate finalField")
public class NinteiChosaScheduleGamenkoumuku implements Serializable {

    private RString 認定調査員コード値;
    private boolean 認定調査員コード状態;
    private RString 認定調査員氏名値;
    private RString 認定調査委託先コード値;
    private RString 認定調査委託先名称値;
    private FlexibleDate 調査日値;
    private RString 調査日時値;
    private RString 時間枠値;
    private RString 予約可否値;
    private boolean 予約可否状態;
    private RString 備考値;
    private boolean 備考状態;
    private RString 予約状況値;
    private boolean 予約状況状態;
    private boolean 被保番号状態;
    private RString 場所値;
    private boolean 場所状態;
    private RString 駐車場値;
    private RString 立会人１値;
    private RString 連絡先１値;
    private RString 立会人２値;
    private RString 連絡先２値;
    private RString 対象者メモ値;

}
