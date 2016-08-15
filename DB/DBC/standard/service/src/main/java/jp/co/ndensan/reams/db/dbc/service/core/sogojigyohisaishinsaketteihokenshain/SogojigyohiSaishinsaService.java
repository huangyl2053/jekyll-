/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInItem;
import jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費再審査決定通知書情報取込（保険者分）CSVファイル出力
 *
 * @reamsid_L DBC-4680-030 wangxue
 */
public class SogojigyohiSaishinsaService {

    /**
     * {@link InstanceProvider#create}にて生成した{@link ServicehiShikyuKetteiTsuchisho}のインスタンスを返します。
     *
     * @return ServicehiShikyuKetteiTsuchisho
     */
    public static SogojigyohiSaishinsaService createInstance() {

        return InstanceProvider.create(SogojigyohiSaishinsaService.class);
    }

    /**
     * CSVファイル1行目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @param parameter KohifutanshaDoIchiranhyoSakuseiProcessParameter
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
            toヘッダのデータ(SogojigyohiSaishinsaKetteiHokenshaInEntity entity, SogojigyohiSaishinsaDoIchiranhyoSakuseiProcessParameter parameter) {

        SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity returnEntity
                = to明細項目(entity);
        returnEntity.set取込年月(parameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RString 作成日 = parameter.getシステム日付().getDate().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = parameter.getシステム日付().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
        returnEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(new RString("作成")));
        returnEntity.set国保連合会名(entity.get国保連合会名());
        returnEntity.set審査委員会名(entity.get審査委員会名());
        return returnEntity;

    }

    /**
     * CSVファイル2行目以降細項目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity to明細項目(SogojigyohiSaishinsaKetteiHokenshaInEntity entity) {

        SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity resultEntity
                = new SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity();
        resultEntity.set取込年月(RString.EMPTY);
        resultEntity.set作成日時(RString.EMPTY);
        resultEntity.set国保連合会名(RString.EMPTY);
        resultEntity.set審査委員会名(RString.EMPTY);
        if (null != entity.get証記載保険者番号()) {
            resultEntity.set証記載保険者番号(entity.get証記載保険者番号().getColumnValue());
        }
        resultEntity.set証記載保険者名(entity.get証記載保険者名());
        if (entity.get取扱年月() != null) {
            resultEntity.set取扱年月(entity.get取扱年月().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != entity.get事業者番号()) {
            resultEntity.set事業者番号(entity.get事業者番号().getColumnValue());
        }
        resultEntity.set事業者名(entity.get事業者名());
        if (null != entity.get被保険者番号()) {
            resultEntity.set被保険者番号(entity.get被保険者番号().getColumnValue());
        }
        resultEntity.set被保険者氏名(entity.get被保険者氏名());
        if (null != entity.getサービス提供年月()) {
            resultEntity.setサービス提供年月(entity.getサービス提供年月().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != entity.getサービス種類コード()) {
            resultEntity.setサービス種類コード(entity.getサービス種類コード().getColumnValue());
        }
        resultEntity.setサービス種類名(entity.getサービス種類名());
        if (null != entity.get申立事由コード()) {
            resultEntity.set申立事由コード(entity.get申立事由コード().getColumnValue());
        }
        resultEntity.set申立事由(entity.get申立事由());
        resultEntity.set当初請求単位数(doカンマ編集(entity.get当初請求単位数()));
        resultEntity.set原審単位数(doカンマ編集(entity.get原審単位数()));
        resultEntity.set決定単位数(doカンマ編集(entity.get決定単位数()));
        resultEntity.set調整単位数(doカンマ編集(entity.get調整単位数()));
        resultEntity.set負担額(doカンマ編集(entity.get保険者負担額()));

        resultEntity.set総合事業費_決定_件数(RString.EMPTY);
        resultEntity.set総合事業費_決定_単位数(RString.EMPTY);
        resultEntity.set総合事業費_決定_負担額(RString.EMPTY);
        resultEntity.set総合事業費_調整_件数(RString.EMPTY);
        resultEntity.set総合事業費_調整_単位数(RString.EMPTY);
        resultEntity.set総合事業費_調整_負担額(RString.EMPTY);

        return resultEntity;
    }

    /**
     * CSVファイル2行目以降集計項目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity to集計項目(SogojigyohiSaishinsaKetteiHokenshaInEntity entity) {

        SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity resultEntity
                = new SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity();
        resultEntity.set証記載保険者番号(entity.get証記載保険者番号().getColumnValue());
        resultEntity.set証記載保険者名(entity.get証記載保険者名());
        resultEntity.set総合事業費_決定_件数(doカンマ編集(entity.get総合事業費_決定_件数()));
        resultEntity.set総合事業費_決定_単位数(doカンマ編集(entity.get総合事業費_決定_単位数()));
        resultEntity.set総合事業費_決定_負担額(doカンマ編集(entity.get総合事業費_決定_負担額()));
        resultEntity.set総合事業費_調整_件数(doカンマ編集(entity.get総合事業費_調整_件数()));
        resultEntity.set総合事業費_調整_単位数(doカンマ編集(entity.get総合事業費_調整_単位数()));
        resultEntity.set総合事業費_調整_負担額(doカンマ編集(entity.get総合事業費_調整_負担額()));
        return resultEntity;
    }

    private RString doカンマ編集(Decimal number) {

        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    /**
     * 帳票項目の値設定
     *
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @param outOrder IOutputOrder
     * @param 処理年月 FlexibleYearMonth
     * @param systemTime RDateTime
     * @param 通番 int
     * @return SogojigyohiSaishinsaKetteiHokenshaInItem
     */
    public SogojigyohiSaishinsaKetteiHokenshaInItem setItem(SogojigyohiSaishinsaKetteiHokenshaInEntity entity,
            IOutputOrder outOrder, FlexibleYearMonth 処理年月, RDateTime systemTime, int 通番) {

        SogojigyohiSaishinsaKetteiHokenshaInItem outItem = new SogojigyohiSaishinsaKetteiHokenshaInItem();
        RString 作成日 = systemTime.getDate().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = systemTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
        outItem.set印刷日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(new RString("作成")));
        outItem.set取込年月(処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outItem.set国保連合会名(entity.get国保連合会名());
        outItem.set審査委員会名(entity.get審査委員会名());
        outItem.set保険者番号(entity.get保険者番号() == null ? RString.EMPTY : entity.get保険者番号().getColumnValue());
        outItem.set保険者名(entity.get保険者名());
        outItem.set証記載保険者番号(entity.get証記載保険者番号() == null ? RString.EMPTY : entity.get証記載保険者番号().getColumnValue());
        outItem.set証記載保険者名(entity.get証記載保険者名());
        int i = 0;
        RString 並び順の１件目 = RString.EMPTY;
        RString 並び順の２件目 = RString.EMPTY;
        RString 並び順の３件目 = RString.EMPTY;
        RString 並び順の４件目 = RString.EMPTY;
        RString 並び順の５件目 = RString.EMPTY;
        if (outOrder != null) {
            for (ISetSortItem item : outOrder.get設定項目リスト()) {
                if (i == 0) {
                    並び順の１件目 = item.get項目名();
                } else if (i == 1) {
                    並び順の２件目 = item.get項目名();
                } else if (i == 2) {
                    並び順の３件目 = item.get項目名();
                } else if (i == 3) {
                    並び順の４件目 = item.get項目名();
                } else if (i == 4) {
                    並び順の５件目 = item.get項目名();
                }
                i = i + 1;
            }
        }
        outItem.set並び順１(並び順の１件目);
        outItem.set並び順２(並び順の２件目);
        outItem.set並び順３(並び順の３件目);
        outItem.set並び順４(並び順の４件目);
        outItem.set並び順５(並び順の５件目);
        outItem.set改頁１(RString.EMPTY);
        outItem.set改頁２(RString.EMPTY);
        outItem.set改頁３(RString.EMPTY);
        outItem.set改頁４(RString.EMPTY);
        outItem.set改頁５(RString.EMPTY);

        outItem.set通番(new RString(String.valueOf(通番)));
        outItem.set取扱年月(entity.get取扱年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outItem.set事業者番号(entity.get事業者番号() == null ? RString.EMPTY : entity.get事業者番号().getColumnValue());
        outItem.set事業者名(entity.get事業者名());
        outItem.setサービス提供年月(entity.getサービス提供年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outItem.setサービス種類コード(entity.getサービス種類コード() == null ? RString.EMPTY : entity.getサービス種類コード().getColumnValue());
        outItem.setサービス種類名(entity.getサービス種類名());
        outItem.set当初請求単位数(doカンマ編集(entity.get当初請求単位数()));
        outItem.set決定単位数(doカンマ編集(entity.get決定単位数()));
        outItem.set保険者負担額(doカンマ編集(entity.get保険者負担額()));
        outItem.set被保険者番号(entity.get被保険者番号() == null ? RString.EMPTY : entity.get被保険者番号().getColumnValue());
        outItem.set被保険者氏名(entity.get被保険者氏名());
        outItem.set申立事由コード(entity.get申立事由コード() == null ? RString.EMPTY : entity.get申立事由コード().getColumnValue());
        outItem.set申立事由(entity.get申立事由());
        outItem.set原審単位数(doカンマ編集(entity.get原審単位数()));
        outItem.set調整単位数(doカンマ編集(entity.get調整単位数()));

        outItem.set決定タイトル(new RString("＜再審査決定＞"));
        outItem.set決定件数タイトル(new RString("件数"));
        outItem.set決定単位数タイトル(new RString("単位数"));
        outItem.set決定負担額タイトル(new RString("保険者負担額"));
        outItem.set調整タイトル(new RString("＜調整＞"));
        outItem.set調整件数タイトル(new RString("件数"));
        outItem.set調整単位数タイトル(new RString("単位数"));
        outItem.set調整負担額タイトル(new RString("保険者負担額"));
        outItem.set総合事業費タイトル(new RString("総合事業費"));
        outItem.set総合事業費_決定_件数(doカンマ編集(entity.get総合事業費_決定_件数()));
        outItem.set総合事業費_決定_単位数(doカンマ編集(entity.get総合事業費_決定_単位数()));
        outItem.set総合事業費_決定_負担額(doカンマ編集(entity.get総合事業費_決定_負担額()));
        outItem.set総合事業費_調整_件数(doカンマ編集(entity.get総合事業費_調整_件数()));
        outItem.set総合事業費_調整_単位数(doカンマ編集(entity.get総合事業費_調整_単位数()));
        outItem.set総合事業費_調整_負担額(doカンマ編集(entity.get総合事業費_調整_負担額()));
        return outItem;
    }
}
