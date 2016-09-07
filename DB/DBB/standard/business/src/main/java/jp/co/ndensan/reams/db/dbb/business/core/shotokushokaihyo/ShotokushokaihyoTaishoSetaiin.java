/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.shotokushokaihyo;

import java.io.Serializable;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * Entity定義_DBBBZ51002
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokushokaihyoTaishoSetaiin implements Serializable {

    private IShikibetsuTaisho 識別対象;
    private boolean 出力対象;
    private ZenkokuJushoCode 送付先全国住所コード;
    private YubinNo 送付先郵便番号;
    private RString 送付先住所１段目;
    private RString 送付先住所２段目;
    private RString 送付先役所名１段目;
    private RString 送付先役所名２段目;
    private RString 前住所;
    private RString 現住所;
}
