/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会スケジュール表かがみのEditorです。
 */
public class ShinsaschedulekagamiEditorImpl implements IShinsaschedulekagamiEditor {

    private final ShinsaschedulekagamiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsaschedulekagamiItem}
     */
    protected ShinsaschedulekagamiEditorImpl(ShinsaschedulekagamiItem item) {
        this.item = item;
    }

    /**
     * 介護認定審査会スケジュール表かがみを編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShinsaschedulekagamiReportSource edit(ShinsaschedulekagamiReportSource source) {
        return editSource(source);
    }

    private ShinsaschedulekagamiReportSource editSource(ShinsaschedulekagamiReportSource source) {
        source.hakkoYMD = item.getHakkoYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(item.getHakkoYMD()));
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.yubinNo = item.getYubinNo();
        source.jushoText = item.getJushoText();
        source.kikanNameText = item.getKikanNameText();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo = item.getMeishoFuyo();
        source.customerBarCode = item.getCustomerBarCode();
        source.atenaRenban = item.getAtenaRenban();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.shoriMikomiKaishiYMD = item.getShoriMikomiKaishiYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(item.getShoriMikomiKaishiYMD()));
        source.shoriMikomiShuryoYMD = item.getShoriMikomiShuryoYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(item.getShoriMikomiShuryoYMD()));
        source.tsuchibun2 = item.getTsuchibun2();
        return source;
    }

    private RString 和暦年月日Fomart(FlexibleDate date) {
        return (date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString());
    }

}
