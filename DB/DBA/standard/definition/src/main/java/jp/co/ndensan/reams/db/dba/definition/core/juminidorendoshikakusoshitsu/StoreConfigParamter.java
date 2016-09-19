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
 * コンフィグ情報パラメータ格納パラメータクラスです。
 *
 * @reamsid_L DBA-1410-013 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class StoreConfigParamter implements Serializable {

    private FlexibleDate 介護保険法施行日;
    private RString 第１号被保険者基準年齢;
    private RString 第２号被保険者基準年齢;
    private RString 合併区分;
}
