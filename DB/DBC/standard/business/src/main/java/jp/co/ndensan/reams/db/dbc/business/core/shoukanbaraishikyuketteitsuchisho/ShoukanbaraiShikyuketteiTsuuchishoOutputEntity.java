/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給決定通知書OutputEntityクラスです。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanbaraiShikyuketteiTsuuchishoOutputEntity {

    private ShoukanbaraiShikyuketteiTsuuchisho 償還払支給決定通知書;
    private RString データ有無;
}
