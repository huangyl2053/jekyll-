/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプCompKaigoToiawasesakiEditor
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class CompKaigoToiawasesakiA4Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor {

    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;

    /**
     * コンストラクタです
     *
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     */
    public CompKaigoToiawasesakiA4Editor(IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource edit(KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource source) {

        CompKaigoToiawasesakiSource buildSource = 介護問合せ先ソースビルダー.buildSource();
        source.yubinBango = buildSource.yubinBango;
        source.shozaichi = buildSource.shozaichi;
        source.choshaBushoName = buildSource.choshaBushoName;
        source.tantoName = buildSource.tantoName;
        source.telNo = buildSource.telNo;
        source.naisenLabel = buildSource.naisenLabel;
        source.naisenNo = buildSource.naisenNo;
        return source;
    }

}
