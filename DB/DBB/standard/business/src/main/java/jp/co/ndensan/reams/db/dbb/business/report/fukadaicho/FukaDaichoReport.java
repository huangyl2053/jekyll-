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
 * 賦課台帳（本算定）帳票FukaDaichoReport
 *
 * @reamsid_L DBB-9100-030 surun
 */
public class FukaDaichoReport extends Report<FukaDaichoSource> {

    private final List<FukaDaichoItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<FukaDaichoItem>
     */
    public FukaDaichoReport(List<FukaDaichoItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param choteiboItems List<FukaDaichoItem>
     * @return FukaDaichoReport
     */
    public static FukaDaichoReport createForm(@NonNull List<FukaDaichoItem> choteiboItems) {
        return new FukaDaichoReport(choteiboItems);
    }

    @Override
    public void writeBy(ReportSourceWriter<FukaDaichoSource> writer) {
        for (FukaDaichoItem target : targets) {
            IFukaDaichoEditor headerEditor = new FukaDaichoHeaderEditor(target);
            IFukaDaichoEditor bodyEditor = new FukaDaichoBodyEditor(target);
            IFukaDaichoBuilder builder = new FukaDaichoBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
