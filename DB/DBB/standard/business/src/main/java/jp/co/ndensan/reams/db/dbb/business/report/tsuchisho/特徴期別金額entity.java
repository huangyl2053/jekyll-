/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 特徴期別金額entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class 特徴期別金額entity {

    private int 期;
    private Decimal 金額;
}
