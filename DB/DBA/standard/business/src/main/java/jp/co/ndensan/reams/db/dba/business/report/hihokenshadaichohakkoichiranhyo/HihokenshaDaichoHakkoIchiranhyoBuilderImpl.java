package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 被保険者台帳一覧表Builderクラスです。
 *
 * @reamsid_L DBA-0510-070 wangxiaodong
 */
public class HihokenshaDaichoHakkoIchiranhyoBuilderImpl implements IHihokenshaDaichoHakkoIchiranhyoBuilder {

    private final IHihokenshaDaichoHakkoIchiranhyoEditor headerEditor;
    private final IHihokenshaDaichoHakkoIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor 被保険者台帳一覧表エディター
     */
    HihokenshaDaichoHakkoIchiranhyoBuilderImpl(HihokenshaDaichoHakkoIchiranhyoHeaderEditor headerEditor,
            HihokenshaDaichoHakkoIchiranhyoBodyEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public HihokenshaDaichoHakkoIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new HihokenshaDaichoHakkoIchiranhyoReportSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }
}
