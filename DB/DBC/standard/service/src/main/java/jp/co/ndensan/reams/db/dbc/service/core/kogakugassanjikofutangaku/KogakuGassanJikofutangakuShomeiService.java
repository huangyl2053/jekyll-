/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassanjikofutangaku;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Idokubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekikoshinin.KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoDateEntity;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額合算自己負担額証明書情報取込のCSVファイル出力。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class KogakuGassanJikofutangakuShomeiService {

    private static final RString 作成 = new RString("作成");
    private static final RString 差異有り = new RString("差異有り");

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuGassanJikofutangakuShomeiService}のインスタンスを返します。
     *
     * @return KogakuGassanJikofutangakuShomeiService
     */
    public static KogakuGassanJikofutangakuShomeiService createInstance() {

        return InstanceProvider.create(KogakuGassanJikofutangakuShomeiService.class);
    }

    /**
     * CSVファイル1行目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @param parameter KohifutanshaDoIchiranhyoSakuseiProcessParameter
     * @param 連番 int
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public KogakuGassanJikofutangakuCsvEntity
            toヘッダのデータ(KogakuGassanJikofutangakuShomeishoDateEntity entity, KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter parameter, int 連番) {

        KogakuGassanJikofutangakuCsvEntity returnEntity
                = to明細項目(entity, 連番);
        returnEntity.set取込年月(parameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
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
    public KogakuGassanJikofutangakuCsvEntity to明細項目(KogakuGassanJikofutangakuShomeishoDateEntity entity, int 連番) {

        KogakuGassanJikofutangakuCsvEntity resultEntity
                = new KogakuGassanJikofutangakuCsvEntity();
        resultEntity.set保険者番号(
                DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        resultEntity.set保険者名(
                DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        resultEntity.setNo(new RString(連番));
        resultEntity.set証記載保険者番号(entity.get高額合算自己負担額_保険者番号());
        resultEntity.set証記載保険者名(entity.get高額合算自己負担額_保険者名());
        resultEntity.set対象年度(entity.get高額合算自己負担額_対象年度());
        resultEntity.set被保険者番号(entity.get被保険者_登録被保険者番号());
        resultEntity.set被保険者氏名(entity.get被保険者_宛名名称());
        resultEntity.set支給申請書整理番号(entity.get高額合算自己負担額_支給申請書整理番号());
        resultEntity.set履歴番号(entity.get高額合算自己負担額_履歴番号());
        resultEntity.set申請年月日(entity.get高額合算自己負担額_申請年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        resultEntity.set異動区分コード(entity.get高額合算自己負担額_異動区分());
        resultEntity.set異動区分(KaigoGassan_Idokubun.valueOf(entity.get高額合算自己負担額_異動区分().toString()).get名称());
        resultEntity.set介護加入期間_開始(entity.get高額合算自己負担額_被保険者期間開始年月日().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        resultEntity.set介護加入期間_終了(entity.get高額合算自己負担額_被保険者期間終了年月日().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        resultEntity.set対象計算期間_開始(entity.get高額合算自己負担額_対象計算期間開始年月日().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        resultEntity.set対象計算期間_終了(entity.get高額合算自己負担額_対象計算期間終了年月日().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        resultEntity.set自己負担額証明書整理番号(entity.get高額合算自己負担額_自己負担額証明書整理番号());
        resultEntity.set自己負担額(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get高額合算自己負担額_合計_自己負担額().toString()), 0));
        resultEntity.set自己負担額_うち70_74歳(entity.get高額合算自己負担額_合計_70_74自己負担額_内訳());

        if (entity.is高額合算自己負担額_自己負担額差異フラグ()) {
            resultEntity.set自己負担額の差異(差異有り);
        } else {
            resultEntity.set自己負担額の差異(RString.EMPTY);
        }
        return resultEntity;
    }
}
