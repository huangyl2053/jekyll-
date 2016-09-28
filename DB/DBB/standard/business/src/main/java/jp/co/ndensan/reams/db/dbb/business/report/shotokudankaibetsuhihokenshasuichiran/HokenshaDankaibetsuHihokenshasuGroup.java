/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsuhihokenshasuichiran;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険者設定段階別被保険者数合計entityのクラスです。
 *
 * @reamsid_L DBB-1820-060 zhouchuanlin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaDankaibetsuHihokenshasuGroup {

    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RString 保険者設定段階;
    private Decimal 保険者設定人数;

}
