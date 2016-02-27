/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteifukadaicho;

import jp.co.ndensan.reams.db.dbb.definition.reportId.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteifukadaicho.KarisanteiFukaDaichoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * KarisanteiFukaDaichoPropertyのプロパティです。
 */
public class KarisanteiFukaDaichoProperty extends ReportPropertyBase<KarisanteiFukaDaichoSource> {

    private static final ReportId ID = ReportIdDBB.DBB100031.getReportId();

    /**
     * コンストラクタです。
     */
    public KarisanteiFukaDaichoProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

    @Override
    protected Breakers<KarisanteiFukaDaichoSource> defineBreakers(Breakers<KarisanteiFukaDaichoSource> breakers,
            BreakerCatalog<KarisanteiFukaDaichoSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

}
