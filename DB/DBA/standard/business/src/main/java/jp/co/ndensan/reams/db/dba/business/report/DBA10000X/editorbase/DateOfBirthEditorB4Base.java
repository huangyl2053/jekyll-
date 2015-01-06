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
 * 被保険者証B4版の、生年月日を編集するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class DateOfBirthEditorB4Base {

    private final HihokenshashoModel hihokenshashoModel;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public DateOfBirthEditorB4Base(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    public void set生年月日(IHihokenshashoB4CommonEditData source) {
        //TODO
        //1, 被保険者が日本人の場合
        //  1-1, 明治生まれの場合、source.umareTaisho1・source.umareShowa1に対して、"*"を設定する。
        //       また、source.umareYy1・source.umareMm1・source.umareDd1に対して、生年月日を和暦で設定する。
        //  1-2, 大正生まれの場合、source.umareMeiji1・source.umareShowa1に対して、"*"を設定する。
        //       また、source.umareYy1・source.umareMm1・source.umareDd1に対して、生年月日を和暦で設定する。
        //  1-3, 昭和生まれの場合、source.umareMeiji1・source.umareTaisho1に対して、"*"を設定する。
        //       また、source.umareYy1・source.umareMm1・source.umareDd1に対して、生年月日を和暦で設定する。
        //  1-4, 上記以外の生まれの場合、元号に対しては何も設定しない。
        //       以下の項目に生年月日を、西暦で設定する。
        //      source.umareYyyy1
        //      source.umareMmS1
        //      source.umareDdS1
        //
        //2, 被保険者が外国人の場合
        //  2-1, source.umareMeiji1・source.umareTaisho1・source.umareShowa1に対して、"*"を設定する。
        //  2-2, 以下の項目に生年月日を、西暦で設定する。
        //      source.umareYyyy1
        //      source.umareMmS1
        //      source.umareDdS1
    }
}
