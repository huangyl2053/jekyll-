/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4.HihokenshashoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険被保険者証Builderクラスです。
 */
public class HihokenshashoA4BuilderItem implements IHihokenshashoA4Builder {
    
    private final IHihokenshashoA4Editor bodyEditor;
    
    /**
     * インスタンスを生成します。
     * @param headEditor {@link IHihokenshashoA4Editor}
     * @param bodyEditor {@link IHihokenshashoA4Editor}
     */
    HihokenshashoA4BuilderItem(IHihokenshashoA4Editor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HihokenshashoA4ReportSource}
     */
    @Override
    public HihokenshashoA4ReportSource build() {
        return ReportEditorJoiner.from(new HihokenshashoA4ReportSource())
                .join(bodyEditor).buildSource();
    }
    
}
