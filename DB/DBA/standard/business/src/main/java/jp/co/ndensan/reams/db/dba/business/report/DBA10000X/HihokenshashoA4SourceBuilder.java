/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.ur.urz.business.report.IReportSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 被保険者証A4版の帳票ソースを作成するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoA4SourceBuilder implements IHihokenshashoA4SourceBuilder {

    private final HihokenshashoA4Editor hihokenshashoEditor;

    /**
     * コンストラクタです。
     *
     * @param hihokenshashoEditor 被保険者証A4版Editor
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public HihokenshashoA4SourceBuilder(HihokenshashoA4Editor hihokenshashoEditor) throws NullPointerException {
        requireNonNull(hihokenshashoEditor, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証Editor", getClass().getName()));
        this.hihokenshashoEditor = hihokenshashoEditor;
    }

    @Override
    public HihokenshashoA4 buildSource() {
        return hihokenshashoEditor.edit(new HihokenshashoA4());
    }
}
