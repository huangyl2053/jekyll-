/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100025;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
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

    private final NinteishoJohoEntity entity;

    protected ShogaishaKojoNinteishoEditorImpl(NinteishoJohoEntity entity) {
        this.entity = entity;
    }

    @Override
    public NinteishoJohoReportSource edit(NinteishoJohoReportSource source) {
        return edit項目(source);
    }

    private NinteishoJohoReportSource edit項目(NinteishoJohoReportSource source) {
        editタイトル(source);
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

    private void editタイトル(NinteishoJohoReportSource source) {
        source.title = new RString("障がい者控除対象者認定書");
    }

    private void edit文書番号(NinteishoJohoReportSource source) {
        source.title = entity.get文書番号();
    }

    private void edit発行日(NinteishoJohoReportSource source) {
        source.hakkoYMD = entity.get発行日() == null ? RString.EMPTY : entity.get発行日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    private void edit申請者(NinteishoJohoReportSource source) {
        source.title = entity.get申請者();
    }

    private void edit認証者(NinteishoJohoReportSource source) {
        source.title = entity.getNinshoshaDenshiKoinDataEntity().get認職者氏名();
        source.title = entity.getNinshoshaDenshiKoinDataEntity().get電子公印();
    }

    private void edit申請者住所(NinteishoJohoReportSource source) {
        source.title = entity.get申請者住所();
    }

    private void edit申請者氏名(NinteishoJohoReportSource source) {
        source.title = entity.get申請者氏名();
    }

    private void edit対象者住所(NinteishoJohoReportSource source) {
        AtenaJusho jusho = entity.getPsmEntity().getJusho();
        source.title = jusho.getColumnValue();
    }

    private void edit対象者氏名(NinteishoJohoReportSource source) {
        AtenaMeisho meisho = entity.getPsmEntity().getMeisho();
        if (RString.isNullOrEmpty(meisho.getColumnValue())) {
            source.title = meisho.getColumnValue();
        }
    }

    private void edit生年月日(NinteishoJohoReportSource source) {
        IKojin ikojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
        if (ikojin.is日本人()) {
            source.title = entity.getPsmEntity().getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        } else {
            source.title = entity.getPsmEntity().getSeinengappiYMD().seireki().separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit性別(NinteishoJohoReportSource source) {
        source.title = entity.getPsmEntity().getSeibetsuCode();
    }

    private void edit障害理由(NinteishoJohoReportSource source) {
        source.title = entity.get障害理由区分();
        source.title = entity.get障害理由内容();
    }

    private void edit要介護認定日(NinteishoJohoReportSource source) {
        source.hakkoYMD = entity.get要介護認定日() == null ? RString.EMPTY : entity.get要介護認定日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    private void edit申告年(NinteishoJohoReportSource source) {
        source.hakkoYMD = entity.get申告年() == null ? RString.EMPTY : entity.get申告年().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).toDateString();
    }

}
