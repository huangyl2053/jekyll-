package jp.co.ndensan.reams.db.dbb.business.report.karisanteiidokekkaichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 「本算定賦課計算」Builderクラスです。
 *
 * @reamsid_L DBB-0850-030 zhaowei
 */
public class KarisanteiIdoKekkaIchiranBuilder implements IKarisanteiIdoKekkaIchiranBuilder {

    private final IKarisanteiIdoKekkaIchiranEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKarisanteiIdoKekkaIchiranEditor
     */
    public KarisanteiIdoKekkaIchiranBuilder(IKarisanteiIdoKekkaIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiIdoKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new KarisanteiIdoKekkaIchiranSource()).join(editor).buildSource();
    }

}
