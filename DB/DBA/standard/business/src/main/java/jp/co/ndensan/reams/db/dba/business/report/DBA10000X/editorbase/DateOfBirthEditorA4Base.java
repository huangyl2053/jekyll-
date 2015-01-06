/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.IHihokenshashoA4CommonEditData;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 被保険者証B4版の、生年月日を編集するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class DateOfBirthEditorA4Base {

    private final HihokenshashoModel hihokenshashoModel;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public DateOfBirthEditorA4Base(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    public void set生年月日(IHihokenshashoA4CommonEditData source) {
        //TODO
        //1, 被保険者が日本人の場合
        //  1-1, 以下の項目に生年月日の元号を設定する。
        //source.umareG
        //  1-2, 以下の項目に生年月日の年を、和暦で設定する。
        //source.umareYy
        //
        //2, 被保険者が外国人の場合
        //  2-1, 以下の項目に生年月日の年を、西暦で設定する。
        //      source.umareYyyy1
        //
        //3, 以下の項目に、生年月日の月日を設定する。
        //source.umareMm
        //source.umareDd
    }
}
