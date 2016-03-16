/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.checknyutaisyokikanby;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 適用除外情報のパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuJouHouParamer {

    private FlexibleDate nyushoTsuchiHakkoYMD;
    private FlexibleDate taishoTsuchiHakkoYMD;
    private RString state;
}
