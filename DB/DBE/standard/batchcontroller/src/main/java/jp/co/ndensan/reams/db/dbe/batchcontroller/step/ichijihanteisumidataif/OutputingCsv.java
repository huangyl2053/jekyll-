/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif;

import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 出力中のCSVに関する情報を持ちます。
 */
@lombok.Getter
final class OutputingCsv {

    private final EucEntityId eucEntityId;
    private final RString fileName;
    private final Decimal linage;

    OutputingCsv(EucEntityId eucEntityId, RString fileName, long linage) {
        this.eucEntityId = eucEntityId;
        this.fileName = fileName;
        this.linage = new Decimal(linage);
    }
}
