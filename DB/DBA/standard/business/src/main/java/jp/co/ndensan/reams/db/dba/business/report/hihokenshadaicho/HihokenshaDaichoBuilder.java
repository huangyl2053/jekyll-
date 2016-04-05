/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 被保険者証発行一覧表Builderクラスです
 */
public final class HihokenshashoHakkoIchiranHyoBuilderImpl implements IHihokenshashoHakkoIchiranHyoBuilder {
    
    private final IHihokenshashoHakkoIchiranHyoEditor joho;
    
    /**
     * コンストラクタです。
     * @param joho 被保険者証発行一覧表ヘッダエディターのインターフェース
     */
    public HihokenshashoHakkoIchiranHyoBuilderImpl(IHihokenshashoHakkoIchiranHyoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public HihokenshashoHakkoIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new HihokenshashoHakkoIchiranhyoReportSource()).join(joho).buildSource();
    }
    
}
