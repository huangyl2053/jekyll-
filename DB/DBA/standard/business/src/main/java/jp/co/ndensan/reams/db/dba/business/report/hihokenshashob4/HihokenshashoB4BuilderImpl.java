/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4.HihokenshashoB4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険被保険者証（B4版）Builderクラスです
 */
public final class HihokenshashoB4BuilderImpl implements IHihokenshashoB4Builder {
    
    private final IHihokenshashoB4Editor joho;
    
    /**
     * コンストラクタです。
     * @param joho 被保険者証発行一覧表ヘッダエディターのインターフェース
     */
    public HihokenshashoB4BuilderImpl(IHihokenshashoB4Editor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public HihokenshashoB4ReportSource build() {
        return ReportEditorJoiner.from(new HihokenshashoB4ReportSource()).join(joho).buildSource();
    }
    
}
