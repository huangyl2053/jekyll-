/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定・要支援認定等申請者一覧表Editorです。
 *
 * @reamsid_L DBE-1370-020 sunhaidi
 */
public class YokaigoYoshienShinseiIchiranEditorImpl implements IYokaigoYoshienShinseiIchiranEditor {

    private final YokaigoYoshienShinseiIchiranItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link YokaigoYoshienShinseiIchiranItem}
     */
    protected YokaigoYoshienShinseiIchiranEditorImpl(YokaigoYoshienShinseiIchiranItem item) {
        this.item = item;
    }

    /**
     * ReportSourceの編集処理です。
     *
     * @param reportSource 要支援認定等申請者一覧表ReportSourceクラス
     * @return YokaigoYoshienShinseiIchiranReportSource 要支援認定等申請者一覧表ReportSourceクラス
     */
    @Override
    public YokaigoYoshienShinseiIchiranReportSource edit(YokaigoYoshienShinseiIchiranReportSource reportSource) {
        reportSource.title = item.getTitle();
        reportSource.shichosonName = item.getShichosonName();
        reportSource.printTimeStamp = item.getPrintTimeStamp();
        reportSource.listShinseiIchiran_1 = item.getRenban();
        reportSource.listShinseiIchiran_2 = item.getShoKisaiHokenshaNo();
        reportSource.listShinseiIchiran_3 = item.getShichosonName();
        reportSource.listShinseiIchiran_4 = item.getHihokenshaName();
        reportSource.listShinseiIchiran_5 = item.getHihokenshaNo();
        FlexibleDate seinengappiYMD = item.getSeinengappiYMD();
        if (seinengappiYMD != null) {
            reportSource.listShinseiIchiran_6 = seinengappiYMD.wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        Code seibetsu = item.getSeibetsu();
        if (seibetsu != null) {
            reportSource.listShinseiIchiran_7 = Seibetsu.toValue(seibetsu.value()).get名称();
        }
        editListShinseiIchiran8(reportSource);
        reportSource.listShinseiIchiran_9 = new RString(String.valueOf(item.getNijiHanteiNinteiYukoKikan()));
        FlexibleDate nijiHanteiNinteiYukoKaishiYMD = item.getNijiHanteiNinteiYukoKaishiYMD();
        if (nijiHanteiNinteiYukoKaishiYMD != null) {
            reportSource.listShinseiIchiran_10 = nijiHanteiNinteiYukoKaishiYMD.wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        FlexibleDate nijiHanteiNinteiYukoShuryoYMD = item.getNijiHanteiNinteiYukoShuryoYMD();
        if (nijiHanteiNinteiYukoShuryoYMD != null) {
            reportSource.listShinseiIchiran_11 = nijiHanteiNinteiYukoShuryoYMD.wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        FlexibleDate ninteiShinseiYMD = item.getNinteiShinseiYMD();
        if (ninteiShinseiYMD != null) {
            reportSource.listShinseiIchiran_12 = ninteiShinseiYMD.wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        Code shinseijiKubunCode = item.getNinteiShinseiShinseijiKubun();
        if (shinseijiKubunCode != null) {
            reportSource.listShinseiIchiran_13 = NinteiShinseiShinseijiKubunCode.toValue(shinseijiKubunCode.value()).get略称();
        }
        reportSource.listShinseiIchiran_14 = item.getJigyoshaMeisho();
        reportSource.listShinseiIchiran_15 = item.getChosainShimei();
        reportSource.listShinseiIchiran_16 = item.getIryoKikanMeisho();
        reportSource.listShinseiIchiran_17 = item.getShujiiName();
        return reportSource;
    }

    private void editListShinseiIchiran8(YokaigoYoshienShinseiIchiranReportSource reportSource) {
        Code zenkaiKoroshoIfShikibetsuCode = item.getZenkaiKoroshoIfShikibetsuCode();
        Code kubunCode = item.getNijiHanteiYokaigoJotaiKubun();
        RString zenkaiKoroshoIfShikibetsu = RString.EMPTY;
        if (zenkaiKoroshoIfShikibetsuCode != null) {
            zenkaiKoroshoIfShikibetsu = zenkaiKoroshoIfShikibetsuCode.value();
        }
        RString nijiHanteiYokaigoJotaiKubun;
        if (kubunCode != null && !RString.isNullOrEmpty(kubunCode.value())) {
            nijiHanteiYokaigoJotaiKubun = kubunCode.value();
        } else {
            reportSource.listShinseiIchiran_8 = RString.EMPTY;
            return;
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(zenkaiKoroshoIfShikibetsu)) {
            reportSource.listShinseiIchiran_8 = YokaigoJotaiKubun99.toValue(nijiHanteiYokaigoJotaiKubun).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(zenkaiKoroshoIfShikibetsu)) {
            reportSource.listShinseiIchiran_8 = YokaigoJotaiKubun02.toValue(nijiHanteiYokaigoJotaiKubun).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(zenkaiKoroshoIfShikibetsu)) {
            reportSource.listShinseiIchiran_8 = YokaigoJotaiKubun06.toValue(nijiHanteiYokaigoJotaiKubun).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(zenkaiKoroshoIfShikibetsu)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(zenkaiKoroshoIfShikibetsu)) {
            reportSource.listShinseiIchiran_8 = YokaigoJotaiKubun09.toValue(nijiHanteiYokaigoJotaiKubun).get名称();
        }
    }
}
