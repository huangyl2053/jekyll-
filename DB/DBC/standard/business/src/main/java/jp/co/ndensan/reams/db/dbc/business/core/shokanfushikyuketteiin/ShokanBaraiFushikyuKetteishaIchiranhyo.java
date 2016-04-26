/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanfushikyuketteiin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin.ShokanFushikyuKetteiInItem;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * バッチで作成した帳票Entityリストより、償還払不支給決定者一覧表帳票データを作成する
 *
 * @reamsid_L DBC-2590-020 xuhao
 */
public class ShokanBaraiFushikyuKetteishaIchiranhyo {

    private static final RString PAGECOUNT_1 = new RString("1");
    private static final RString DATA_1 = new RString("該当データがありません");
    private static final RString COLON = new RString(":");
    private static final RString ASTERISK = new RString("*");
    private static final RString 保険者番号 = new RString("保険者番号");

    private RString 印刷日時;

    /**
     * getShokanBaraiFushikyuKetteishaIchiranhyo
     *
     * @param 並び順の１件目 並び順の１件目
     * @param 並び順の２件目 並び順の２件目
     * @param 並び順の３件目 並び順の３件目
     * @param 並び順の４件目 並び順の４件目
     * @param 並び順の５件目 並び順の５件目
     * @param 改頁 改頁
     * @param 償還払不支給決定者リスト 償還払不支給決定者リスト
     * @return List
     */
    public List<ShokanFushikyuKetteiInItem> getShokanBaraiFushikyuKetteishaIchiranhyo(
            RString 並び順の１件目,
            RString 並び順の２件目,
            RString 並び順の３件目,
            RString 並び順の４件目,
            RString 並び順の５件目,
            RString 改頁,
            List<ShokanFushikyuKetteiInEntity> 償還払不支給決定者リスト) {
        List<ShokanFushikyuKetteiInItem> itemList = new ArrayList<>();
        印刷日時表示作成();
        if (償還払不支給決定者リスト == null || 償還払不支給決定者リスト.isEmpty()) {
            ShokanFushikyuKetteiInItem item = new ShokanFushikyuKetteiInItem(印刷日時, PAGECOUNT_1, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY,
                    (並び順の１件目 == null) ? RString.EMPTY : 並び順の１件目,
                    (並び順の２件目 == null) ? RString.EMPTY : 並び順の２件目,
                    (並び順の３件目 == null) ? RString.EMPTY : 並び順の３件目,
                    (並び順の４件目 == null) ? RString.EMPTY : 並び順の４件目,
                    (並び順の５件目 == null) ? RString.EMPTY : 並び順の５件目,
                    (改頁 == null || 改頁.isEmpty()) ? 保険者番号 : 改頁,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, DATA_1,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            itemList.add(item);
        } else {
            for (ShokanFushikyuKetteiInEntity entity : 償還払不支給決定者リスト) {
                itemList.add(createItem(entity, 並び順の１件目, 並び順の２件目,
                        並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁));
            }
        }
        return itemList;

    }

    private void 印刷日時表示作成() {
        RStringBuilder builder = new RStringBuilder();
        RDateTime now = RDateTime.now();
        builder.append(now.getDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString());
        builder.append(RString.FULL_SPACE).append(now.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        印刷日時 = builder.toRString();
    }

    private RString サービス種類表示作成(ServiceShuruiCode サービス種類コード, RString サービス種類名) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(サービス種類コード.value()).append(COLON).append(サービス種類名);
        return builder.toRString();
    }

    private ShokanFushikyuKetteiInItem createItem(
            ShokanFushikyuKetteiInEntity entity,
            RString 並び順の１件目,
            RString 並び順の２件目,
            RString 並び順の３件目,
            RString 並び順の４件目,
            RString 並び順の５件目,
            RString 改頁) {
        RString 喪失事由コード = entity.getSoshitsuJiyuCode();
        // TODO QA555 Redmine#80882
        RString サービス種類 = サービス種類表示作成(entity.getServiceShuruiCode(), entity.getServiceShuruiName());
        return new ShokanFushikyuKetteiInItem(印刷日時, RString.EMPTY, entity.getKokuhoRenkokaiName(),
                entity.getShokisaiHokenshaNo().value(), entity.getHokenshaName(),
                (並び順の１件目 == null) ? RString.EMPTY : 並び順の１件目,
                (並び順の２件目 == null) ? RString.EMPTY : 並び順の２件目,
                (並び順の３件目 == null) ? RString.EMPTY : 並び順の３件目,
                (並び順の４件目 == null) ? RString.EMPTY : 並び順の４件目,
                (並び順の５件目 == null) ? RString.EMPTY : 並び順の５件目,
                (改頁 == null || 改頁.isEmpty()) ? entity.getShokisaiHokenshaNo().value() : 改頁,
                RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, entity.getNo(),
                entity.getHiHokenshaNo().value(), entity.getHiHokenshaName(), entity.getJigyoshoNo().value(),
                entity.getJigyoshoName(), entity.getServiceTeikyoYM().wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString(),
                new RString(entity.getTensuKingaku().toString()), 喪失事由コード, entity.getBikoOne(), entity.getSeiriNo(),
                entity.getJushoCode().value(), entity.getJusho().value(), entity.getGyoseikuCode().value(),
                entity.getGyoseiku(), サービス種類, entity.getSoshitsuYMD().wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString(),
                entity.getBikoTwo(),
                entity.getIsUpdate() ? RString.EMPTY : ASTERISK
        );

    }
}
