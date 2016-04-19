/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;

/**
 * 介護保険料徴収猶予決定通知書B5横タイプCompKaigoToiawasesakiEditor
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class CompKaigoToiawasesakiB5Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoEditor {

    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;

    /**
     * コンストラクタです
     *
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     */
    public CompKaigoToiawasesakiB5Editor(IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource edit(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource source) {

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
