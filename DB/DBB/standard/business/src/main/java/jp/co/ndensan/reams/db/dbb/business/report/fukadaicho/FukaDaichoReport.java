/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.fukadaicho.FukaDaichoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 */
public class FukaDaichoReport extends Report<FukaDaichoSource>{
    
    private final List<FukaDaichoItem> targets;
    
    protected FukaDaichoReport(List<FukaDaichoItem> targets) {
        this.targets = targets;
    }
    
    public static FukaDaichoReport createForm(@NonNull List<FukaDaichoItem> choteiboItems) {
        return new FukaDaichoReport(choteiboItems);
    }

    @Override
    public void writeBy(ReportSourceWriter<FukaDaichoSource> writer) {
        for (FukaDaichoItem target : targets) {
            IFukaDaichoEditor headerEditor = new HeaderEditor(target);
            IFukaDaichoEditor bodyEditor = new BodyEditor(target);
            IFukaDaichoBuilder builder = new FukaDaichoBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }
    
}
