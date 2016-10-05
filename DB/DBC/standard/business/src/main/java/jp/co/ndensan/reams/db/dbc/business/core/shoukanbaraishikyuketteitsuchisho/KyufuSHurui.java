/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付の種類設定Entityクラスです。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuSHurui {

    private RString 給付の種類1;
    private RString 給付の種類2;
    private RString 給付の種類3;
    private int 償還計画費データ件数;
    private int 償還集計データ件数;

}
