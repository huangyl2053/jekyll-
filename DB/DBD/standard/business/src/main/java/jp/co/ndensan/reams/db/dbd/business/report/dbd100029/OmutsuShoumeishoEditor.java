/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100029;

import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.OmutsusiyoSyomeishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100029.OmutsuShoumeishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * おむつ使用証明書Editorです。
 *
 * @reamsid_L DBD-5780-030 donghj
 */
public class OmutsuShoumeishoEditor implements IOmutsuShoumeishoEditor {

    private final OmutsusiyoSyomeishoEntity おむつ使用証明書Entity;

    /**
     * インスタンスを生成します。
     *
     * @param おむつ使用証明書Entity OmutsusiyoSyomeishoEntity
     */
    public OmutsuShoumeishoEditor(OmutsusiyoSyomeishoEntity おむつ使用証明書Entity) {
        this.おむつ使用証明書Entity = おむつ使用証明書Entity;
    }

    @Override
    public OmutsuShoumeishoReportSource edit(OmutsuShoumeishoReportSource source) {
        return editSource(source);
    }

    private OmutsuShoumeishoReportSource editSource(OmutsuShoumeishoReportSource source) {

        source.title = new RString("おむつ使用証明書");
        if (おむつ使用証明書Entity != null) {
            source.jusyo = おむつ使用証明書Entity.get住所();
            source.jusyo1 = おむつ使用証明書Entity.get住所１();
            source.jusyo2 = おむつ使用証明書Entity.get住所２();
            source.hihoName = おむつ使用証明書Entity.get氏名();
            source.hihoName1 = おむつ使用証明書Entity.get氏名１();
            source.hihoName2 = おむつ使用証明書Entity.get氏名２();
            source.umareYmd = おむつ使用証明書Entity.get生年月日();
            source.seibetuOtoko = おむつ使用証明書Entity.get性別男();
            source.seibetuOnna = おむつ使用証明書Entity.get性別女();
        }

        return source;
    }

}
