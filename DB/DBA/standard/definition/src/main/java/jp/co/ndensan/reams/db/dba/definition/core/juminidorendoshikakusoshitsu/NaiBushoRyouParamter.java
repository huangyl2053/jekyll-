/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 内部処理用パラメータです。
 *
 * @reamsid_L DBA-1410-013 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NaiBushoRyouParamter implements Serializable {

    private FlexibleDate 到達日_65歳;
    private FlexibleDate 補正後65歳到達日;
    private FlexibleDate 消除異動日翌日;
    private FlexibleDate 補正後消除異動日翌日;
    private FlexibleDate 転出予定日翌日;
    private FlexibleDate 補正後転出予定日翌日;
    private RString 年齢;
}
