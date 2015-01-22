/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoA4CommonEditData;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.Formatted;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;

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

    /**
     * 被保険者証A4版の帳票ソースに、生年月日の情報を設定します。
     *
     * @param source 被保険者証A4版帳票ソース
     */
    public void set生年月日(IHihokenshashoA4CommonEditData source) {
        IKojin kojin = hihokenshashoModel.getKojinJoho();
        Formatted formattedDate;

        if (kojin.is日本人()) {
            formattedDate = toWareki(kojin.get生年月日().toDate());
            source.setUmareG(formattedDate.getEra());
            source.setUmareYy(formattedDate.getYear().replace(formattedDate.getEra(), RString.EMPTY));
        } else {
            formattedDate = toSeireki(kojin.get生年月日().toDate());
            source.setUmareYyyy(formattedDate.getYear());
        }

        source.setUmareMm(formattedDate.getMonth());
        source.setUmareDd(formattedDate.getDay());
    }

    private Formatted toSeireki(RDate date) {
        return date.seireki().separator(Separator.NONE).fillType(FillType.BLANK).width(Width.HALF);
    }

    private Formatted toWareki(RDate date) {
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.NONE)
                .fillType(FillType.BLANK).width(Width.HALF);
    }
}
