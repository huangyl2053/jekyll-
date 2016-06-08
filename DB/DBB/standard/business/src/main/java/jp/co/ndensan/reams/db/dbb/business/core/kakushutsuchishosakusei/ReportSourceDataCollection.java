/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種通知書発行パラメータのクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ReportSourceDataCollection implements Serializable {

    private ReportId 帳票ID;
    private FlexibleDate 通知書発行日;
    private Map<Code, RString> 業務固有情報;
    private List<ShikibetsuCode> 識別コードList;
}
