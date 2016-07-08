/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.hiyobenshotoshiharaimeisaisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書クラスです。
 *
 * @reamsid_L DBE-1980-048 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HiyobenshotoShiharaimeisaisho {

    private RString 審査会委員氏名;
    private RString 報酬;
    private RString 費用弁償;
    private RString 小計;
    private RString 所得税;
    private RString 差引支払額;
    private RString 金融機関;
    private RString 支店;
    private RString 種別;
    private RString 番号;
    private RString 振込予定日;
    private RString 対象期間;
    private RString 審査会出席回数;
    private RString 市町村名称;
}
