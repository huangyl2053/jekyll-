/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tekiyojogaikaijo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 適用除外情報のパラメータクラスです。
 *
 * @reamsid_L DBA-0410-010 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyoJogaiKaijo implements Serializable {

    private FlexibleDate nyushoTsuchiHakkoYMD;
    private FlexibleDate taishoTsuchiHakkoYMD;
}
