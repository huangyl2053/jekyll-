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
 * 一時変数用パラメータです。
 *
 * @reamsid_L DBA-1410-013 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TemParamter implements Serializable {

    private RString lc解除事由;
    private FlexibleDate lc異動日;
    private FlexibleDate tmp異動日;
    private FlexibleDate tmp届出日;
    private RString tmp取得事由;
    private FlexibleDate tmp日付;
    private FlexibleDate tmp1号資格取得日;
    private RString tmp被保険者区分;
    private RString tmp処理要否;
    private FlexibleDate 登録届出日;
    private FlexibleDate 登録異動日;
}
