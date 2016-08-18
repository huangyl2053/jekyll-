/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbc.definition.core.keikoku.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekikoshinin.KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.chohyoshutsuryokutaishodate.ChohyoShutsuryokuTaishoDateEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績更新結果情報取込のCSVファイル出力。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
public class KyufuJissekiKoshinJohoService {

    private static final RString 作成 = new RString("作成");
    private static final RString マルONE = new RString("◎");
    private static final RString マルTWO = new RString("○");
    private static final RString マルTHREE = new RString("●");
    private static final RString 事業者名不明 = new RString("事業者名不明");

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuJissekiKoshinJohoService}のインスタンスを返します。
     *
     * @return KyufuJissekiKoshinJohoService
     */
    public static KyufuJissekiKoshinJohoService createInstance() {

        return InstanceProvider.create(KyufuJissekiKoshinJohoService.class);
    }

    /**
     * CSVファイル1行目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @param parameter KohifutanshaDoIchiranhyoSakuseiProcessParameter
     * @param 連番 int
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public KyufuJissekiKoshinJohoIchiranCsvEntity
            toヘッダのデータ(ChohyoShutsuryokuTaishoDateEntity entity, KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter parameter, int 連番) {

        KyufuJissekiKoshinJohoIchiranCsvEntity returnEntity
                = to明細項目(entity, 連番);
        returnEntity.set処理年月(parameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RString 作成日 = parameter.getシステム日付().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        RString 作成時 = parameter.getシステム日付().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(作成);
        returnEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
        return returnEntity;

    }

    /**
     * CSVファイル2行目以降細項目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @param 連番 int
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public KyufuJissekiKoshinJohoIchiranCsvEntity to明細項目(ChohyoShutsuryokuTaishoDateEntity entity, int 連番) {

        KyufuJissekiKoshinJohoIchiranCsvEntity resultEntity
                = new KyufuJissekiKoshinJohoIchiranCsvEntity();
        resultEntity.set保険者番号(entity.get給付実績_コントロールレコード保険者番号());
        resultEntity.set保険者名(entity.get給付実績_コントロールレコード保険者名());
        resultEntity.setNo(連番);
        resultEntity.set入力識別番号(entity.get給付実績_入力識別番号());
        resultEntity.set入力識別名称(entity.get給付実績_入力識別名称());
        if (!RString.isNullOrEmpty(entity.get給付実績_給付実績情報作成区分コード())) {
            KyufuSakuseiKubun 給付実績情報作成区分 = KyufuSakuseiKubun.toValue(entity.get給付実績_給付実績情報作成区分コード());
            resultEntity.set作成区分(entity.get給付実績_給付実績情報作成区分コード());
            resultEntity.set作成区分名(給付実績情報作成区分.get名称());
        }
        resultEntity.set被保険者番号(entity.get被保険者_登録被保険者番号());
        resultEntity.set被保険者カナ氏名(entity.get被保険者_宛名カナ名称());
        resultEntity.set被保険者氏名(entity.get被保険者_宛名名称());
        resultEntity.setサービス提供年月(doパターン54(entity.get給付実績_サービス提供年月()));
        if (!RString.isNullOrEmpty(entity.get給付実績_給付実績区分())) {
            KyufuJissekiKubun 給付実績区分 = KyufuJissekiKubun.toValue(entity.get給付実績_給付実績区分());
            resultEntity.set給付実績区分(entity.get給付実績_給付実績区分());
            resultEntity.set給付実績区分名(給付実績区分.get名称());
        }
        resultEntity.set事業者番号(entity.get給付実績_事業所番号());
        if (!RString.isNullOrEmpty(entity.get給付実績_事業所番号()) && entity.get給付実績_事業者名称().isEmpty()) {
            resultEntity.set事業者名(事業者名不明);
        } else {
            resultEntity.set事業者名(entity.get給付実績_事業者名称());
        }
        resultEntity.set整理番号(entity.get給付実績_整理番号());
        if (entity.get給付実績_レコード件数H1() >= 1) {
            resultEntity.set作成レコード種別_01基本(マルTWO);
        } else {
            resultEntity.set作成レコード種別_01基本(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D1() >= 1 && entity.get給付実績_レコード件数DD() >= 1) {
            resultEntity.set作成レコード種別_02明細(マルONE);
        } else if (entity.get給付実績_レコード件数D1() >= 1 && entity.get給付実績_レコード件数DD() == 0) {
            resultEntity.set作成レコード種別_02明細(マルTWO);
        } else if (entity.get給付実績_レコード件数D1() == 0 && entity.get給付実績_レコード件数DD() >= 0) {
            resultEntity.set作成レコード種別_02明細(マルTHREE);
        } else if (entity.get給付実績_レコード件数D1() == 0 && entity.get給付実績_レコード件数DD() == 0) {
            resultEntity.set作成レコード種別_02明細(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D2() >= 1) {
            resultEntity.set作成レコード種別_03施設(マルTWO);
        } else {
            resultEntity.set作成レコード種別_03施設(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D3() >= 1) {
            resultEntity.set作成レコード種別_04特診(マルTWO);
        } else {
            resultEntity.set作成レコード種別_04特診(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D4() >= 1) {
            resultEntity.set作成レコード種別_05食事(マルTWO);
        } else {
            resultEntity.set作成レコード種別_05食事(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D5() >= 1) {
            resultEntity.set作成レコード種別_06計画(マルTWO);
        } else {
            resultEntity.set作成レコード種別_06計画(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D6() >= 1) {
            resultEntity.set作成レコード種別_07用具(マルTWO);
        } else {
            resultEntity.set作成レコード種別_07用具(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D7() >= 1) {
            resultEntity.set作成レコード種別_08住宅(マルTWO);
        } else {
            resultEntity.set作成レコード種別_08住宅(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D8() >= 1 || entity.get給付実績_レコード件数DE() >= 1) {
            resultEntity.set作成レコード種別_09高額(マルTWO);
        } else {
            resultEntity.set作成レコード種別_09高額(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数T1() >= 1) {
            resultEntity.set作成レコード種別_10集計(マルTWO);
        } else {
            resultEntity.set作成レコード種別_10集計(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数D9() >= 1) {
            resultEntity.set作成レコード種別_11特定(マルTWO);
        } else {
            resultEntity.set作成レコード種別_11特定(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数DA() >= 1) {
            resultEntity.set作成レコード種別_12社福(マルTWO);
        } else {
            resultEntity.set作成レコード種別_12社福(RString.EMPTY);
        }
        if (entity.get給付実績_レコード件数DC() >= 1) {
            resultEntity.set作成レコード種別_13所定(マルTWO);
        } else {
            resultEntity.set作成レコード種別_13所定(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(entity.get給付実績_警告区分コード())) {
            KeikokuKubun 警告区分 = KeikokuKubun.toValue(entity.get給付実績_警告区分コード());
            resultEntity.set備考(警告区分.get名称());
        }
        return resultEntity;
    }

    /**
     * CSVファイル2行目以降集計項目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @param 合計件数 int
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public KyufuJissekiKoshinJohoIchiranCsvEntity to集計項目(ChohyoShutsuryokuTaishoDateEntity entity, int 合計件数) {
        KyufuJissekiKoshinJohoIchiranCsvEntity resultEntity
                = new KyufuJissekiKoshinJohoIchiranCsvEntity();
        resultEntity.set保険者番号(entity.get給付実績_コントロールレコード保険者番号());
        resultEntity.set保険者名(entity.get給付実績_コントロールレコード保険者名());
        resultEntity.set合計件数(doカンマ編集(new Decimal(合計件数)));
        return resultEntity;
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal number) {

        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }
}
