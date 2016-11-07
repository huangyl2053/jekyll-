/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishocover;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishocover.KyufuhiTsuchishoCoverEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishocover.KyufuhiTsuchishoCoverReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC100041_介護保険給付費通知書_２ページ目以降のEditorです。
 *
 * @reamsid_L DBC-2280-040 chenxiangyu
 *
 */
public class KyufuhiTsuchishoCoverTwoEditor implements IKyufuhiTsuchishoCoverEditor {

    private final KyufuhiTsuchishoCoverEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyufuhiTsuchishoCoverEntity}
     */
    protected KyufuhiTsuchishoCoverTwoEditor(KyufuhiTsuchishoCoverEntity item) {
        this.item = item;
    }

    @Override
    public KyufuhiTsuchishoCoverReportSource edit(KyufuhiTsuchishoCoverReportSource source) {
        return editSource(source);
    }

    private KyufuhiTsuchishoCoverReportSource editSource(KyufuhiTsuchishoCoverReportSource source) {
        source.key_hihokenshaName = item.getHihokenshaName();
        source.key_hokenshaNo = item.getHokenshaNo();
        source.key_shukeiserviceSTYM = new FlexibleYearMonth(item.getShukeiserviceSTYM()).
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                .toDateString();
        source.key_shukeiserviceEDYM = new FlexibleYearMonth(item.getShukeiserviceEDYM()).
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                .toDateString();
        source.key_listServiceIchiranUpper_1 = new FlexibleYearMonth(item.getListServiceIchiranUpper_1()).
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                .toDateString();
        source.key_listServiceIchiranUpper_2 = item.getListServiceIchiranUpper_2();
        source.key_listServiceIchiranUpper_3 = item.getListServiceIchiranUpper_3();
        source.key_listServiceIchiranUpper_4 = item.getListServiceIchiranUpper_4();
        source.key_listServiceIchiranUpper_5
                = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getListServiceIchiranUpper_5().toString()), 0).concat("円");
        source.key_listServiceIchiranUpper_6
                = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getListServiceIchiranUpper_6().toString()), 0).concat("円");
        source.key_listServiceIchiranLower_1 = item.getListServiceIchiranLower_1();
        source.key_listServiceIchiranLower_2 = item.getListServiceIchiranLower_2();
        source.key_tsuchibun1 = item.getTsuchibun1();
        source.key_tsuchibun2 = item.getTsuchibun2();
        source.key_pageBunshi = new RString(item.getPageBunshi());
        source.key_pageBunbo = new RString(item.getPageBunbo());
        source.key_listServiceIchiranLower_2 = item.getListServiceIchiranLower_2();
        source.layout = Layouts.必須;
        return source;
    }
}
