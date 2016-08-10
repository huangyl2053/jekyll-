/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100025;

import jp.co.ndensan.reams.db.dbd.business.core.dbt4030011.NinteishoJohoBusiness;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 障がい者控除対象者認定証のEditorです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class ShogaishaKojoNinteishoEditorImpl implements IShogaishaKojoNinteishoEditor {

    private final NinteishoJohoBusiness target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link NinteishoJohoBusiness}
     */
    protected ShogaishaKojoNinteishoEditorImpl(NinteishoJohoBusiness target) {
        this.target = target;
    }

    /**
     * 障がい者控除対象者認定証Editorです。
     *
     * @param source NinteishoJohoReportSource
     * @return NinteishoJohoReportSource
     */
    @Override
    public NinteishoJohoReportSource edit(NinteishoJohoReportSource source) {
        return edit項目(source);
    }

    private NinteishoJohoReportSource edit項目(NinteishoJohoReportSource source) {
        edit文書番号(source);
        edit発行日(source);
        edit申請者(source);
        edit認証者(source);
        edit申請者住所(source);
        edit申請者氏名(source);
        edit対象者住所(source);
        edit対象者氏名(source);
        edit生年月日(source);
        edit性別(source);
        edit障害理由(source);
        edit要介護認定日(source);
        edit申告年(source);

        return source;
    }

    private void edit文書番号(NinteishoJohoReportSource source) {
        source.bunshoNo = target.get文書番号();
    }

    private void edit発行日(NinteishoJohoReportSource source) {
        source.hakkoYMD = target.get発行日() == null ? RString.EMPTY : target.get発行日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    private void edit申請者(NinteishoJohoReportSource source) {
        source.ninshoshaYakushokuMei = target.get申請者();
    }

    private void edit認証者(NinteishoJohoReportSource source) {
        source.ninshoshaShimeiKakenai = target.get認職者氏名();
        source.ninshoshaShimeiKakeru = target.get電子公印();
    }

    private void edit申請者住所(NinteishoJohoReportSource source) {
        source.shiseishaJusho = target.get申請者住所();
    }

    private void edit申請者氏名(NinteishoJohoReportSource source) {
        source.shiseishaShimei = target.get申請者氏名();
    }

    private void edit対象者住所(NinteishoJohoReportSource source) {
        source.hihokenshaJusho = target.get対象者住所();
    }

    private void edit対象者氏名(NinteishoJohoReportSource source) {
        source.hihokenshaName = target.get対象者氏名();
    }

    private void edit生年月日(NinteishoJohoReportSource source) {
        IKojin ikojin = ShikibetsuTaishoFactory.createKojin(target.getPsmEntity());
        if (ikojin.is日本人()) {
            source.birthYMD = target.get対象者生年月日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else {
            source.birthYMD = target.get対象者生年月日().seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit性別(NinteishoJohoReportSource source) {
        source.seibetsu = target.get対象者性別();
    }

    private void edit障害理由(NinteishoJohoReportSource source) {
        //TODO layout与rse不一致 source.shogaiRiyu = target.get障害理由区分()
        source.shogaiRiyu = target.get障害理由内容();
    }

    private void edit要介護認定日(NinteishoJohoReportSource source) {
        source.ninteiYMD = target.get要介護認定日() == null ? RString.EMPTY : target.get要介護認定日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
    }

    private void edit申告年(NinteishoJohoReportSource source) {
        source.shiyoMokuteki = target.get申告年() == null ? RString.EMPTY : target.get申告年().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }

}
