/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukyufutaishoshain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranItem;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.KogakuKyufuMeisaiGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.KogakuKyufuTaishoshaInEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 高額介護サービス費給付対象者一覧表帳票ソースデータ作成
 *
 */
public class KogakuKyufuTaishoshaIchiranhyo {

    private static final RString DATE_作成 = new RString(" 作成");
    private static final RString KANJI_計 = new RString("計");
    private static final RString 氏名_データなし = new RString("該当データなし");
    private static final RString STRING_BLANK_HANKAKU = new RString(" ");
    private RString 作成日時;
    private RString 並び順の1件目;
    private RString 並び順の2件目;
    private RString 並び順の3件目;
    private RString 並び順の4件目;
    private RString 並び順の5件目;
    private RString 改頁;

    /**
     * 帳票データ作成します。
     *
     * @param 並び順1 RString
     * @param 並び順2 RString
     * @param 並び順3 RString
     * @param 並び順4 RString
     * @param 並び順5 RString
     * @param 改頁 RString
     * @param 高額介護サービス費給付対象者一覧List KogakuKyufuTaishoshaInEntity
     * @return 帳票用データ
     */
    public List<KogakuKyufuTaishoshaIchiranItem> getKogakuKyufuTaishoshaIchiranhyoData(
            RString 並び順1, RString 並び順2, RString 並び順3,
            RString 並び順4, RString 並び順5, RString 改頁,
            List<KogakuKyufuTaishoshaInEntity> 高額介護サービス費給付対象者一覧List) {
        List<KogakuKyufuTaishoshaIchiranItem> dataList = new ArrayList<>();
        YMDHMS now = YMDHMS.now();
        RStringBuilder builder = new RStringBuilder();
        builder.append(now.wareki()
                .eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString());
        builder.append(STRING_BLANK_HANKAKU);
        builder.append(now.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        builder.append(DATE_作成);
        作成日時 = builder.toRString();
        this.並び順の1件目 = 並び順1 == null ? RString.EMPTY : 並び順1;
        this.並び順の2件目 = 並び順1 == null ? RString.EMPTY : 並び順2;
        this.並び順の3件目 = 並び順1 == null ? RString.EMPTY : 並び順3;
        this.並び順の4件目 = 並び順1 == null ? RString.EMPTY : 並び順4;
        this.並び順の5件目 = 並び順1 == null ? RString.EMPTY : 並び順5;
        this.改頁 = 改頁;

        if (高額介護サービス費給付対象者一覧List == null || 高額介護サービス費給付対象者一覧List.isEmpty()) {
            return dataList;
        }

        for (KogakuKyufuTaishoshaInEntity entity : 高額介護サービス費給付対象者一覧List) {
            if (entity.get明細集計List() == null || entity.get明細集計List().isEmpty()) {
                KogakuKyufuTaishoshaIchiranItem item = new KogakuKyufuTaishoshaIchiranItem();
                item.set送付元団体名(entity.getHeadEntity().getKokukoRengoukaiNa());
                item.set保険者番号(entity.getHeadEntity().getHokenshaNo());
                item.set保険者名称(entity.getHeadEntity().getHihokenshaName());
                item.set並び順１(並び順の1件目);
                item.set並び順２(並び順の2件目);
                item.set並び順３(並び順の3件目);
                item.set並び順４(並び順の4件目);
                item.set並び順５(並び順の5件目);
                item.set改頁１(改頁);
                item.set改頁２(RString.EMPTY);
                item.set改頁３(RString.EMPTY);
                item.set改頁４(RString.EMPTY);
                item.set改頁５(RString.EMPTY);
                item.setページ番号(new RString("1"));
                item.set作成日時(作成日時);
                item.set被保険者氏名(氏名_データなし);
                dataList.add(item);
            } else {
                RString 被保険者番号 = entity.get明細集計List().get(0).get明細Entity().getHihokenshaNo();
                RString 送付元団体名 = entity.getHeadEntity().getKokukoRengoukaiNa();
                RString 保険者番号 = entity.getHeadEntity().getHokenshaNo();
                RString 保険者名称 = entity.getHeadEntity().getHihokenshaName();
                for (KogakuKyufuMeisaiGokeiEntity 該当データ : entity.get明細集計List()) {
                    if (!被保険者番号.equals(該当データ.get明細Entity().getHihokenshaNo())) {
                        dataList.add(makeItem(該当データ, 送付元団体名, 保険者番号, 保険者名称, true));
                        被保険者番号 = 該当データ.get明細Entity().getHihokenshaNo();
                    }
                    dataList.add(makeItem(該当データ, 送付元団体名, 保険者番号, 保険者名称, false));
                }
                KogakuKyufuMeisaiGokeiEntity 該当データ
                        = entity.get明細集計List().get(entity.get明細集計List().size() - 1);
                dataList.add(makeItem(該当データ, 送付元団体名, 保険者番号, 保険者名称, true));
            }
        }
        return dataList;
    }

    private KogakuKyufuTaishoshaIchiranItem makeItem(KogakuKyufuMeisaiGokeiEntity entity,
            RString 送付元団体名, RString 保険者番号, RString 保険者名称, boolean is集計) {
        KogakuKyufuTaishoshaIchiranItem item = new KogakuKyufuTaishoshaIchiranItem();
        if (is集計) {
            item.set送付元団体名(送付元団体名);
            item.set保険者番号(保険者番号);
            item.set保険者名称(保険者名称);
            item.set並び順１(並び順の1件目);
            item.set並び順２(並び順の2件目);
            item.set並び順３(並び順の3件目);
            item.set並び順４(並び順の4件目);
            item.set並び順５(並び順の5件目);
            item.set改頁１(改頁);
            item.set改頁２(RString.EMPTY);
            item.set改頁３(RString.EMPTY);
            item.set改頁４(RString.EMPTY);
            item.set改頁５(RString.EMPTY);
            item.set作成日時(作成日時);
            item.set通知書番号(RString.EMPTY);
            item.set被保険者番号(RString.EMPTY);
            item.set被保険者氏名(RString.EMPTY);
            item.setサービス提供年月(KANJI_計);
            item.set事業者番号(RString.EMPTY);
            item.set事業者名(RString.EMPTY);
            item.setサービス種類コード(RString.EMPTY);
            item.setサービス種類名称(RString.EMPTY);
            item.setサービス費用合計額(entity.get集計Entity().getServiceHiyoGokeiGakuGokei());
            item.set利用者負担額(entity.get集計Entity().getRiyoshaFutanGakuGokei());
            item.set算定基準額(entity.get集計Entity().getSanteiKijunGaku());
            item.set支払済金額(entity.get集計Entity().getShiharaiSumiKingakuGokei());
            item.set高額支給額(entity.get集計Entity().getKogakuShikyuGaku());
            item.set資格喪失日(entity.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            item.set備考(RString.EMPTY);
        } else {
            item.set送付元団体名(送付元団体名);
            item.set保険者番号(保険者番号);
            item.set保険者名称(保険者名称);
            item.set並び順１(並び順の1件目);
            item.set並び順２(並び順の2件目);
            item.set並び順３(並び順の3件目);
            item.set並び順４(並び順の4件目);
            item.set並び順５(並び順の5件目);
            item.set改頁１(改頁);
            item.set改頁２(RString.EMPTY);
            item.set改頁３(RString.EMPTY);
            item.set改頁４(RString.EMPTY);
            item.set改頁５(RString.EMPTY);
            item.set作成日時(作成日時);
            item.set通知書番号(entity.get明細Entity().getNo());
            item.set被保険者番号(entity.get明細Entity().getHihokenshaNo());
            item.set被保険者氏名(entity.get明細Entity().getHiHokenshaSimei());
            item.setサービス提供年月(new FlexibleYearMonth(entity.get明細Entity().getServiceTeikyoYM()).
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            item.set事業者番号(entity.get明細Entity().getJigyoshaNo());
            item.set事業者名(entity.get明細Entity().getJigyoshaName());
            item.setサービス種類コード(entity.get明細Entity().getServiceShuruiCode());
            item.setサービス種類名称(entity.get明細Entity().getServiceShuruiName());
            item.setサービス費用合計額(new RString(entity.get明細Entity().getServiceHiyoGokeiGaku().toString()));
            item.set利用者負担額(entity.get明細Entity().getRiyoshaFutanGaku());
            item.set算定基準額(RString.EMPTY);
            item.set支払済金額(RString.EMPTY);
            item.set高額支給額(RString.EMPTY);
            item.set資格喪失日(entity.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            item.set備考(entity.get明細Entity().getBikou());
        }
        return item;
    }
}
