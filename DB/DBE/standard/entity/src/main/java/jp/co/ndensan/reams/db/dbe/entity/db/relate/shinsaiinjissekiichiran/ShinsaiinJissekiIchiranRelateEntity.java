/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会委員実績情報のクラスです。
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaiinJissekiIchiranRelateEntity {

    private RString コード;
    private RString 氏名;
    private RString 議長区分コード;
    private RString 審査員資格コード;
    private boolean 出欠;
    private RString 医療機関コード;
    private RString 医療機関名称;
    private RString 調査委託先コード;
    private RString 調査委託先名称;
    private RString その他機関コード;
    private RString その他機関名称;
    private RString 審査会地区コード;
    private RString 審査会地区;
    private RString 審査会番号;
    private RString 実施日;
    private RString 開始;
    private RString 終了;
    private RString 単価_委員;
    private RString 単価_医師;
}
