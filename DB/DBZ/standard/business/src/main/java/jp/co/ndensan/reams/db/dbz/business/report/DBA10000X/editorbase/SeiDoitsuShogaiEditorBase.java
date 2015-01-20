/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証の、性同一障害について編集を行うEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class SeiDoitsuShogaiEditorBase {

    private final HihokenshashoModel hihokenshashoModel;

    private static final RString SEI_SHOGAI_TEXT_UPPER;
    private static final RString SEI_SHOGAI_TEXT_LOWER;
    private static final RString KOSEKI_GENDER_TEXT_UPPER;
    private static final RString KOSEKI_GENDER_TEXT_LOWER;

    static {
        SEI_SHOGAI_TEXT_UPPER = new RString("3枚目の");
        SEI_SHOGAI_TEXT_LOWER = new RString("下段参照");
        KOSEKI_GENDER_TEXT_UPPER = new RString("戸籍上の");
        KOSEKI_GENDER_TEXT_LOWER = new RString("性別：");
    }

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public SeiDoitsuShogaiEditorBase(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    /**
     * 被保険者証帳票ソースに性同一障害に関する情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set性同一障害考慮(IHihokenshashoCommonEditData source) {
        if (hihokenshashoModel.getShikakuHakko().is性同一障害用()) {
            source.setSeiShogai1(SEI_SHOGAI_TEXT_UPPER);
            source.setSeiShogai2(SEI_SHOGAI_TEXT_LOWER);
            source.setKosekiSeibetsu1(KOSEKI_GENDER_TEXT_UPPER);
            source.setKosekiSeibetsu2(KOSEKI_GENDER_TEXT_LOWER.concat(hihokenshashoModel.getKojinJoho().get性別().getCommonName()));
        }
    }

}
