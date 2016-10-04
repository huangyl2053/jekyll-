/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業分高額合算支給決定通知書OutputEntityクラスです。
 *
 * @reamsid_L DBC-2310-030 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyuKetteiTsuchishoOutputEntity {

    private KogakuGassanShikyuKetteiTsuchishoEntity 高額合算支給決定通知書;
    private RString データ有無;
}
