/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.itakuservicekeikalusakuseiiraitodokedesho;

import jp.co.ndensan.reams.db.dba.entity.report.itakuservicekeikalusakuseiiraitodokedesho.ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 居宅（介護予防）サービス計画作成依頼（変更）届出書Builderクラスです。
 */
public final class ItakuServiceKeikaluSakuseiIraiTodokedeshoBuilderImpl implements IItakuServiceKeikaluSakuseiIraiTodokedeshoBuilder {

    private final IItakuServiceKeikaluSakuseiIraiTodokedeshoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 居宅（介護予防）サービス計画作成依頼（変更）届出書ヘッダエディターのインターフェース
     */
    public ItakuServiceKeikaluSakuseiIraiTodokedeshoBuilderImpl(IItakuServiceKeikaluSakuseiIraiTodokedeshoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource}
     */
    @Override
    public ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource build() {
        return ReportEditorJoiner.from(new ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource()).join(joho).buildSource();
    }

}
