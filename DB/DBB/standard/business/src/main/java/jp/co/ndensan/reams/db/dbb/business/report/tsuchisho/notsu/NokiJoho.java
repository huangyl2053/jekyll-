/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbb.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;

/**
 *
 * 納期情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NokiJoho {

    private Kitsuki 期月;
    private Noki 納期;
}
