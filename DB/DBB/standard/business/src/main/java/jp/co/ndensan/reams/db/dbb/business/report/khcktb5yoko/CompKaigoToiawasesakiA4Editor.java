/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプCompKaigoToiawasesakiEditor
 *
 * @reamsid_L DBC-0740-040 sunhui
 */
public class CompKaigoToiawasesakiA4Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor {

    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item;

    /**
     * コンストラクタです
     *
     * @param item KaigoHokenryoChoshuyuyoKetteiTsuchishoItem
     */
    public CompKaigoToiawasesakiA4Editor(KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource edit(KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource source) {

        source.yubinBango = item.getYubinBango();
        source.shozaichi = item.getShozaichi();
        source.choshaBushoName = item.getChoshaBushoName();
        source.tantoName = item.getTantoName();
        source.telNo = item.getTelNo();
        source.naisenLabel = item.getNaisenLabel();
        source.naisenNo = item.getNaisenNo();
        return source;
    }

}
