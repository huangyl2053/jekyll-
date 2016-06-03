/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBRP43002_5_介護保険料額変更通知書発行一覧表KaigoHokenryogakuBuilder
 *
 * @reamsid_L DBB-0780-120 yangchenbing
 */
public class KaigoHokenryogakuBuilder implements IKaigoHokenryogakuBuilder {

    private final IKaigoHokenryogakuEditor headerEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKarisanteiFukaDaichoEditor}
     */
    public KaigoHokenryogakuBuilder(IKaigoHokenryogakuEditor headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public KaigoHokenryogakuSource build() {
        return ReportEditorJoiner.from(new KaigoHokenryogakuSource()).join(headerEditor).buildSource();
    }

}
