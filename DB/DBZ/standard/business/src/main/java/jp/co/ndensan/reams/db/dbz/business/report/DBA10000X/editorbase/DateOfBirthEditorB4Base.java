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
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.kojin.IKojin;
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
public class DateOfBirthEditorB4Base {

    private final HihokenshashoModel hihokenshashoModel;

    private static final RString DAUB_WORD;

    static {
        DAUB_WORD = new RString("**");
    }

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

    /**
     * 被保険者証B4版の帳票ソースに、生年月日の情報を設定します。
     *
     * @param source 被保険者証B4版帳票ソース
     */
    public void set生年月日(IHihokenshashoB4CommonEditData source) {

        IKojin kojin = hihokenshashoModel.getKojinJoho();
        RDate date = kojin.get生年月日().toDate();
        Formatted formattedDate;

        if (kojin.is日本人()) {
            formattedDate = toWareki(kojin.get生年月日().toDate());
            switch (formattedDate.getEra().toString()) {
                case "明治":
                    daubTaisho(source);
                    daubShowa(source);
                    setUmareDate(source, formattedDate);
                    break;
                case "大正":
                    daubMeiji(source);
                    daubShowa(source);
                    setUmareDate(source, formattedDate);
                    break;
                case "昭和":
                    daubMeiji(source);
                    daubTaisho(source);
                    setUmareDate(source, formattedDate);
                    break;
                default:
                    formattedDate = toSeireki(kojin.get生年月日().toDate());
                    setUmareSDate(source, formattedDate);
                    break;

            }
        } else {
            formattedDate = toSeireki(kojin.get生年月日().toDate());
            daubMeiji(source);
            daubTaisho(source);
            daubShowa(source);
            setUmareSDate(source, formattedDate);
        }

    }

    private Formatted toSeireki(RDate date) {
        return date.seireki().separator(Separator.NONE).fillType(FillType.BLANK).width(Width.HALF);
    }

    private Formatted toWareki(RDate date) {
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.NONE)
                .fillType(FillType.BLANK).width(Width.HALF);
    }

    private void daubMeiji(IHihokenshashoB4CommonEditData source) {
        source.setUmareMeiji1(DAUB_WORD);
    }

    private void daubTaisho(IHihokenshashoB4CommonEditData source) {
        source.setUmareTaisho1(DAUB_WORD);
    }

    private void daubShowa(IHihokenshashoB4CommonEditData source) {
        source.setUmareShowa1(DAUB_WORD);
    }

    private void setUmareDate(IHihokenshashoB4CommonEditData source, Formatted formattedDate) {
        source.setUmareYy1(formattedDate.getYear().replace(formattedDate.getEra(), RString.EMPTY));
        source.setUmareMm1(formattedDate.getMonth());
        source.setUmareDd1(formattedDate.getDay());
    }

    private void setUmareSDate(IHihokenshashoB4CommonEditData source, Formatted formattedDate) {
        source.setUmareYyyy1(formattedDate.getYear().replace(formattedDate.getEra(), RString.EMPTY));
        source.setUmareMmS1(formattedDate.getMonth());
        source.setUmareDdS1(formattedDate.getDay());
    }
}
