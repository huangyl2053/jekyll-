/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 増減・不支給の理由設定Entityクラスです。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ZougenFushikyuRiyu {

    private RString 増減_不支給の理由1;
    private RString 増減_不支給の理由2;
    private RString 増減_不支給の理由3;
}
