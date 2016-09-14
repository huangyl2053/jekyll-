/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.gassanjikofutangakushomeishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc040040.GassanJikofutangakushomeishoHakkoIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.JikoFutangakushomeishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 自己負担証明書作成（括）のCsvEntityEditorクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class GassanJikofutangakushomeishoHakkoIchiranCsvEntityEditor {

    private final JikoFutangakushomeishoEntity entity;
    private final RDateTime システム日時;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param システム日時 システム日時
     * @param 連番 連番
     */
    public GassanJikofutangakushomeishoHakkoIchiranCsvEntityEditor(JikoFutangakushomeishoEntity entity,
            RDateTime システム日時, int 連番) {
        this.entity = entity;
        this.システム日時 = システム日時;
        this.連番 = 連番;
    }

    /**
     * CSVレコードを取得します。
     *
     * s* @return GassanJikofutangakushomeishoHakkoIchiranCsvEntity
     */
    public GassanJikofutangakushomeishoHakkoIchiranCsvEntity edit() {
        GassanJikofutangakushomeishoHakkoIchiranCsvEntity csvEntity = new GassanJikofutangakushomeishoHakkoIchiranCsvEntity();
        csvEntity.set発行日時(format日時(システム日時));
        csvEntity.set連番(new RString(連番));
        csvEntity.set被保険者番号(entity.get高額合算一時().getHihokenshaNo().getColumnValue());
        csvEntity.set被保険者氏名(entity.get高額合算一時().getJikoFutanGaku_HihokenshaShimei().getColumnValue());
        csvEntity.set生年月日(dateFormat12(entity.get高額合算一時().getAtena_SeinengappiYMD()));
        csvEntity.set性別(entity.get高額合算一時().getAtena_Seibetsu());
        csvEntity.set申請書整理番号(entity.get高額合算一時().getShikyuShinseishoSeiriNo());
        csvEntity.set申請対象年度(dateFormat107(entity.get高額合算一時().getTaishoNendo()));
        csvEntity.set介護加入期間開始(dateFormat6(entity.get高額合算一時().getJikoFutanGaku_HihokenshaKaishiYMD()));
        csvEntity.set介護加入期間終了(dateFormat6(entity.get高額合算一時().getJikoFutanGaku_HihokenshaShuryoYMD()));
        csvEntity.set自己負担額証明書整理番号(entity.get高額合算一時().getJikoFutanGaku_JikoFutanSeiriNo());
        csvEntity.set自己負担楽合計金額_補正後(toRString(entity.get高額合算一時().getJikoFutanGaku_Sumi_Gokei_JikoFutanGaku()));
        csvEntity.setうち70_74歳の者に係る自己負担額(toRString(entity.get高額合算一時().getJikoFutanGaku_Sumi_Gokei_70_74JikoFutanGaku()));
        return csvEntity;
    }

    private RString dateFormat107(FlexibleYear year) {
        if (year == null) {
            return RString.EMPTY;
        }
        return year.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }

    private RString dateFormat6(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
    }

    private RString dateFormat12(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
    }

    private RString toRString(Decimal dec) {
        if (dec == null) {
            return RString.EMPTY;
        }
        return new RString(dec.toString());
    }

    private RString format日時(RDateTime 作成日時) {
        if (作成日時 == null) {
            return RString.EMPTY;
        }

        RStringBuilder dateTime = new RStringBuilder();

        dateTime.append(作成日時.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        dateTime.append(RString.FULL_SPACE);
        dateTime.append(作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return dateTime.toRString();
    }
}
