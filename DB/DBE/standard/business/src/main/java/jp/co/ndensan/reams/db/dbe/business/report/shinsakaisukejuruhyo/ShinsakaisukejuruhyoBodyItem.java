/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会スケジュール表ボディのITEMです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaisukejuruhyoBodyItem {

    private int 項番;
    private RString 審査会番号;
    private RString 開催日;
    private RString 開催時間;
    private RString 合議体;
    private RString 会場;
    private RString 住所;
    private RString 電話番号;
}
