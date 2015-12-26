/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 被保険者証の、認定情報を編集するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class NinteiEditorBase {

    private final HihokenshashoModel hihokenshashoModel;

    private static final RString TANI;
    private static final int ROKU = 6;
    private static final int SAN = 3;
    private static final int YONN = 4;

    static {
        TANI = new RString("単位");
    }

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public NinteiEditorBase(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    /**
     * 被保険者証帳票ソースに、要介護認定状態区分などの情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set要介護状態区分等(IHihokenshashoCommonEditData source) {
        source.setKaigokbn(hihokenshashoModel.getShikakuHakko().get要介護状態());
    }

    /**
     * 被保険者証帳票ソースに、認定年月日の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set認定年月日(IHihokenshashoCommonEditData source) {
        source.setNinteiymd(toWarekiString(hihokenshashoModel.getShikakuHakko().get認定日()));
    }

    /**
     * 被保険者証帳票ソースに、認定有効期間の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set認定有効期間(IHihokenshashoCommonEditData source) {
        source.setYukokikanst(toWarekiString(hihokenshashoModel.getShikakuHakko().get有効期間開始日()));
        source.setYukokikaned(toWarekiString(hihokenshashoModel.getShikakuHakko().get有効期間終了日()));
    }

    /**
     * 被保険者証帳票ソースに、居宅サービスの情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set居宅サービス(IHihokenshashoCommonEditData source) {
        HihokenshaShikakuHakkoModel shikakuHakko = hihokenshashoModel.getShikakuHakko();
        source.setHomonkikanst(toWarekiString(shikakuHakko.get限度額有効期間開始日()));
        source.setHomonkikaned(toWarekiString(shikakuHakko.get限度額有効期間終了日()));
        source.setService1(new RString(shikakuHakko.get限度基準額().toString("#,###")));
        source.setTen0(TANI);
    }

    /**
     * 被保険者証帳票ソースに、うち種類支給限度基準額の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void setうち種類支給限度基準額(IHihokenshashoCommonEditData source) {

        List<RString> serviceShu = hihokenshashoModel.getShikakuHakko().get限度基準額サービス種類();
        List<RString> serviceGaku = hihokenshashoModel.getShikakuHakko().get限度基準額サービス額();

        for (int i = 0; i < ROKU && i < serviceShu.size(); i++) {
            switch (i) {
                case 0:
                    source.setShurui1(serviceShu.get(i));
                    source.setShuruigendo1(serviceGaku.get(i));
                    source.setTen1(TANI);
                    break;
                case 1:
                    source.setShurui2(serviceShu.get(i));
                    source.setShuruigendo2(serviceGaku.get(i));
                    source.setTen2(TANI);
                    break;
                case 2:
                    source.setShurui3(serviceShu.get(i));
                    source.setShuruigendo3(serviceGaku.get(i));
                    source.setTen3(TANI);
                    break;
                case SAN:
                    source.setShurui4(serviceShu.get(i));
                    source.setShuruigendo4(serviceGaku.get(i));
                    source.setTen4(TANI);
                    break;
                case YONN:
                    source.setShurui5(serviceShu.get(i));
                    source.setShuruigendo5(serviceGaku.get(i));
                    source.setTen5(TANI);
                    break;
                default:
                    source.setShurui6(serviceShu.get(i));
                    source.setShuruigendo6(serviceGaku.get(i));
                    source.setTen6(TANI);
                    break;
            }
        }
    }

    /**
     * 被保険者証帳票ソースに、認定審査会の意見等の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set認定審査会の意見等(IHihokenshashoCommonEditData source) {
        source.setRyui(hihokenshashoModel.getShikakuHakko().get審査会意見());
    }

//    private static RString toWarekiString(RDate date) {
//        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
//                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
//    }

    private static RString toWarekiString(FlexibleDate date) {
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
