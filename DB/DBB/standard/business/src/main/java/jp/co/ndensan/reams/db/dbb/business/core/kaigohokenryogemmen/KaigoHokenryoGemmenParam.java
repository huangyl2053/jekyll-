/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険料減免 介護保険料減免保存処理用のパラメータです。
 *
 * @reamsid_L DBB-1660-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenryoGemmenParam {

    private RString 状況;
    private boolean 決定区分;
    private FlexibleDate 申請日;
    private FlexibleDate 決定日;
    private FlexibleDate 取消日;
    private Decimal 減免額;
    private Decimal 前回減免額;
    private RString 申請事由;
    private Code 減免種類コード;
    private RString 減免事由;
    private Code 減免取消種類コード;
    private RString 減免取消事由;
    private Decimal 申請減免額;
}
