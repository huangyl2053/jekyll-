/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更（償還払い化）終了申請書ヘッダEditorです。
 */
class ShiharaiHenkoShokanbaraikaShoryoShinseishoEditorImpl implements IShiharaiHenkoShokanbaraikaShoryoShinseishoEditor {

    private final ShiharaiHenkoShokanbaraikaShoryoShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShiharaiHenkoShokanbaraikaShoryoShinseishoItem}
     */
    protected ShiharaiHenkoShokanbaraikaShoryoShinseishoEditorImpl(
            ShiharaiHenkoShokanbaraikaShoryoShinseishoItem item) {
        this.item = item;
    }

    @Override
    public ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource edit(
            ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource source) {
        return editHeader(source);
    }

    private ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource editHeader(
            ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = item.get認証者();
        source.hihokenshaNameKana = item.getフリガナ();
        source.hihokenshaName = item.get被保険者氏名();
        source.hihokenshaNo = item.get被保険者番号();
        source.birthYMD = item.get生年月日();
        source.seibetsu = item.get性別();
        source.hihokenshaYubinNo = item.get郵便番号();
        source.hihokenJusho = item.get住所();
        source.hihokenshaTelNo = item.get電話番号();
        source.tsuchiBun = item.get通知文();
        source.remban = new RString("1");
        return source;
    }
}
