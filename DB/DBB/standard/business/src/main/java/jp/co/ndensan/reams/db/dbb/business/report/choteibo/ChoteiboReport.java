/*
 * To change this license headerItem, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 調定簿帳票出力
 */
public class ChoteiboReport extends Report<ChoteiboSource> {

    private final List<ChoteiboItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets targets
     */
    protected ChoteiboReport(List<ChoteiboItem> targets) {
        this.targets = targets;
    }

    /**
     * 調定簿帳票Reort作成
     *
     * @param targets targets
     * @return ChoteiboReport
     */
    public static ChoteiboReport createForm(@NonNull List<ChoteiboItem> targets) {
        return new ChoteiboReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<ChoteiboSource> writer) {
        for (ChoteiboItem target : targets) {
            IChoteiboEditor headerEditor = new ChoteiboHeaderEditor(target.getHeaderItem());
            ChoteiboKitsukiEditor kitsukiEditor = new ChoteiboKitsukiEditor(target.getKitsukiItem());
            ChoteiboDankaiGokeiEditor dankaiGokeiEditor = new ChoteiboDankaiGokeiEditor(target.getDankaiGokeiItem());
            for (ChoteiboDankaiItem dankaiItem : target.getDankaiItemList()) {
                ChoteiboDankaiEditor dankaiEditor = new ChoteiboDankaiEditor(dankaiItem);
                IChoteiboBuilder builder = new ChoteiboBuilder(headerEditor,
                        kitsukiEditor, dankaiEditor, dankaiGokeiEditor);
                writer.writeLine(builder);
            }
        }
    }
}
