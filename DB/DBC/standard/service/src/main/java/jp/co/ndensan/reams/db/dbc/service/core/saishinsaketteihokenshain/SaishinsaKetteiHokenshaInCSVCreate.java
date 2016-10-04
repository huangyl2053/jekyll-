/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteihokenshain.SaishinsaKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.SaishinsaKetteitsuchishoCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiResultEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 再審査決定通知書情報取込BatchCreate
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiHokenshaInCSVCreate {

    private static final RString SAKUSEI = new RString("作成");

    /**
     * {@link InstanceProvider#create}にて生成した{@link SaishinsaKetteiHokenshaInCSVCreate}のインスタンスを返します。
     *
     * @return SaishinsaKetteiHokenshaInCSVCreate
     */
    public static SaishinsaKetteiHokenshaInCSVCreate createInstance() {

        return InstanceProvider.create(SaishinsaKetteiHokenshaInCSVCreate.class);
    }

    /**
     * CSVファイル1行目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @param parameter KohifutanshaDoIchiranhyoSakuseiProcessParameter
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public SaishinsaKetteitsuchishoCSVEntity
            toヘッダのデータ(SaishinsaKetteiResultEntity entity, SaishinsaKetteiProcessParameter parameter) {

        SaishinsaKetteitsuchishoCSVEntity returnEntity = to明細項目(entity);
        returnEntity.set取込年月(parameter.get処理年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RDateTime systemTime = RDateTime.now();
        RString 作成日 = systemTime.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = systemTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        returnEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
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
    public SaishinsaKetteitsuchishoCSVEntity to明細項目(SaishinsaKetteiResultEntity entity) {

        SaishinsaKetteitsuchishoCSVEntity resultEntity = new SaishinsaKetteitsuchishoCSVEntity();
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

        return resultEntity;
    }

    /**
     * CSVファイル2行目以降集計項目データを出力する
     *
     * @param entity SogojigyohiSaishinsaKetteiHokenshaInEntity
     * @return SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity
     */
    public SaishinsaKetteitsuchishoCSVEntity to集計項目(SaishinsaKetteiResultEntity entity) {

        SaishinsaKetteitsuchishoCSVEntity resultEntity = new SaishinsaKetteitsuchishoCSVEntity();
        resultEntity.set証記載保険者番号(entity.get証記載保険者番号().getColumnValue());
        resultEntity.set証記載保険者名(entity.get証記載保険者名());
        resultEntity.set介護給付費_申立_件数(doカンマ編集(entity.get介護給付費_申立_件数()));
        resultEntity.set介護給付費_申立_単位数(doカンマ編集(entity.get介護給付費_申立_単位数()));
        resultEntity.set介護給付費_申立_負担額(doカンマ編集(entity.get介護給付費_申立_負担額()));
        resultEntity.set介護給付費_決定_件数(doカンマ編集(entity.get介護給付費_決定_件数()));
        resultEntity.set介護給付費_決定_単位数(doカンマ編集(entity.get介護給付費_決定_単位数()));
        resultEntity.set介護給付費_決定_負担額(doカンマ編集(entity.get介護給付費_決定_負担額()));
        resultEntity.set介護給付費_調整_件数(doカンマ編集(entity.get介護給付費_調整_件数()));
        resultEntity.set介護給付費_調整_単位数(doカンマ編集(entity.get介護給付費_調整_単位数()));
        resultEntity.set介護給付費_調整_負担額(doカンマ編集(entity.get介護給付費_調整_負担額()));
        resultEntity.set高額介護サービス費_申立_件数(doカンマ編集(entity.get高額介護サービス費_申立_件数()));
        resultEntity.set高額介護サービス費_申立_単位数(doカンマ編集(entity.get高額介護サービス費_申立_単位数()));
        resultEntity.set高額介護サービス費_申立_負担額(doカンマ編集(entity.get高額介護サービス費_申立_負担額()));
        resultEntity.set高額介護サービス費_決定_件数(doカンマ編集(entity.get高額介護サービス費_決定_件数()));
        resultEntity.set高額介護サービス費_決定_単位数(doカンマ編集(entity.get高額介護サービス費_決定_単位数()));
        resultEntity.set高額介護サービス費_決定_負担額(doカンマ編集(entity.get高額介護サービス費_決定_負担額()));
        resultEntity.set高額介護サービス費_調整_件数(doカンマ編集(entity.get高額介護サービス費_調整_件数()));
        resultEntity.set高額介護サービス費_調整_単位数(doカンマ編集(entity.get高額介護サービス費_調整_単位数()));
        resultEntity.set高額介護サービス費_調整_負担額(doカンマ編集(entity.get高額介護サービス費_調整_負担額()));
        return resultEntity;
    }

    private RString doカンマ編集(Decimal number) {

        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

}
