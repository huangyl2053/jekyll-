/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.YoboKeikakuJikoSakuseiTankiRiyoNissu;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeika.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 短期入所情報クラスです。
 *
 * @reamsid_L DBC-1930-060 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TankiNyushoResult implements Serializable {

    private KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅短期入所情報;
    private YoboKeikakuJikoSakuseiTankiRiyoNissu 予防短期入所情報;
    private RString 居宅予防区分;
}
