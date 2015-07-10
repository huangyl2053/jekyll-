/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoB4CommonEditData;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証B4版の、性別を編集するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class GenderEditorB4Base {

    private final HihokenshashoModel hihokenshashoModel;

    private static final RString DAUB_WORD;

    static {
        DAUB_WORD = new RString("*");
    }

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

    /**
     * 被保険者証B4版の帳票ソースに、性別の情報を設定します。
     *
     * @param source 被保険者証B4版帳票ソース
     */
    public void set性別(IHihokenshashoB4CommonEditData source) {

        if (!hihokenshashoModel.getShikakuHakko().is性同一障害用()) {
            switch (hihokenshashoModel.getKojinJoho().get性別()) {
                case MALE:
                    source.setSeibetsuWoman1(DAUB_WORD);
                    break;
                case FEMALE:
                    source.setSeibetsuMan1(DAUB_WORD);
                    break;
                default:
                    break;
            }
        }
    }
}
