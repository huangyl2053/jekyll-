/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import jp.co.ndensan.reams.db.dbb.entity.report.fukadaicho.FukaDaichoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 */
public class FukaDaichoProperty extends ReportPropertyBase<FukaDaichoSource>{
    
    private static final ReportId ID = new ReportId("DBB100065_FukaDaicho");
    
    public FukaDaichoProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }
    
    // TODO 翻页
    @Override
    protected Breakers<FukaDaichoSource> defineBreakers(Breakers<FukaDaichoSource> breakers, BreakerCatalog<FukaDaichoSource> catalog) {
        return super.defineBreakers(breakers, catalog); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
