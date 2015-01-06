/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.IHihokenshashoB4CommonEditData;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 被保険者証B4版の、性別を編集するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class GenderEditorB4Base {

    private final HihokenshashoModel hihokenshashoModel;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public GenderEditorB4Base(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    public void set性別(IHihokenshashoB4CommonEditData source) {
        //TODO
        //1, 性同一障害の考慮が有る場合、設定を行わない。
        //2, 性同一障害の考慮を行わない場合、以下のように性別を設定する。
        //  2-1, 被保険者の性別が男である場合、以下の項目に"*"を設定する。
        //      source.seibetsuWoman1
        //  2-2, 被保険者の性別が女である場合、以下の項目に"*"を設定する。
        //      source.seibetsuMan1
    }
}
