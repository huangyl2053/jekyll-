/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 総合事業費再審査決定通知書情報取込（保険者分）の一覧表作成パラメータです。
 *
 * @reamsid_L DBC-4680-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSaishinsaDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private long 出力順ID;
    private FlexibleYearMonth 処理年月;
}
