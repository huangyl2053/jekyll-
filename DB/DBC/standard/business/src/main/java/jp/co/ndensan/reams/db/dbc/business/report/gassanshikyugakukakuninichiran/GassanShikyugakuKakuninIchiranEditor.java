/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukakuninichiran;

import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakuGassanShikyugakuKeisanKekkaIn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakukakuninichiran.GassanShikyugakuKakuninIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 高額合算支給額計算結果連絡票情報確認リストのEditorrクラスです。
 *
 * @reamsid_L DBC-2680-031 qinzhen
 */
public class GassanShikyugakuKakuninIchiranEditor implements
        IGassanShikyugakuKakuninIchiranEditor {

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private final KogakuGassanShikyugakuKeisanKekkaIn entity;
    private static final RString 作成 = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param entity KogakuGassanShikyugakuKeisanKekkaIn
     *
     */
    public GassanShikyugakuKakuninIchiranEditor(KogakuGassanShikyugakuKeisanKekkaIn entity) {
        this.entity = entity;

    }

    @Override
    public GassanShikyugakuKakuninIchiranSource edit(GassanShikyugakuKakuninIchiranSource source) {
        DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity 計算結果entity = entity.get帳票用データ().get計算結果entity();
        source.printTimeStamp = getSakuseiYmhm(entity.get作成日時());
        source.torikomiYM = entity.get処理年月().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.hokenshaNo = entity.get保険者番号();
        source.hokenshaName = entity.get保険者名();
        source.shutsuryokujun1 = entity.get並び順リスト().get(NUM_0);
        source.shutsuryokujun2 = entity.get並び順リスト().get(NUM_1);
        source.shutsuryokujun3 = entity.get並び順リスト().get(NUM_2);
        source.shutsuryokujun4 = entity.get並び順リスト().get(NUM_3);
        source.shutsuryokujun5 = entity.get並び順リスト().get(NUM_4);
        source.kaipage1 = entity.get改頁リスト().get(NUM_0);
        source.kaipage2 = entity.get改頁リスト().get(NUM_1);
        source.kaipage3 = entity.get改頁リスト().get(NUM_2);
        source.kaipage4 = entity.get改頁リスト().get(NUM_3);
        source.kaipage5 = entity.get改頁リスト().get(NUM_4);
        source.listUpper_1 = new RString(entity.get連番());
        source.listUpper_2 = 計算結果entity.getTaishoNendo().wareki().firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
        source.listUpper_3 = entity.get帳票用データ().get被保険者entity().getHihokenshaNo().value();
        source.listLower_1 = entity.get帳票用データ().get被保険者entity().getMeisho();
        source.listUpper_4 = 計算結果entity.getShikyuShinseishoSeiriNo();

        if (計算結果entity.getJikoFutanSeiriNo() != null) {
            source.listLower_2 = 計算結果entity.getJikoFutanSeiriNo();
        }

        FlexibleDate kaishiYMD = 計算結果entity.getTaishoKeisanKaishiYMD();
        FlexibleDate shuryoYMD = 計算結果entity.getTaishoKeisanShuryoYMD();
        if (kaishiYMD != null && shuryoYMD != null) {
            source.listUpper_5 = getlistUpper_5(kaishiYMD, shuryoYMD);
        }

        source.listLower_3 = KaigoGassan_ShotokuKbn.toValue(計算結果entity.getShotokuKubun()).get名称();
        source.listLower_4 = KaigoGassan_Over70_ShotokuKbn.toValue(計算結果entity.getOver70_ShotokuKubun()).get名称();
        if (計算結果entity.getSetaiFutanSogaku() != null) {
            source.listUpper_6 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getSetaiFutanSogaku(), 0);
        }
        if (計算結果entity.getSetaiGassanGaku() != null) {
            source.listLower_5 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getSetaiGassanGaku(), 0);
        }
        if (計算結果entity.getOver70_SetaiGassanGaku() != null) {
            source.listLower_6 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getOver70_SetaiGassanGaku(), 0);
        }
        if (計算結果entity.getSanteiKijunGaku() != null) {
            source.listUpper_7 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getSanteiKijunGaku(), 0);
        }
        if (計算結果entity.getOver70_SanteiKijyunGaku() != null) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getOver70_SanteiKijyunGaku(), 0);
        }

        if (計算結果entity.getSetaiShikyuSogaku() != null) {
            source.listUpper_8 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getSetaiShikyuSogaku(), 0);
        }
        if (計算結果entity.getOver70_SetaiShikyuSogaku() != null) {
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getOver70_SetaiShikyuSogaku(), 0);
        }
        if (計算結果entity.getHonninShikyugaku() != null) {
            source.listUpper_9 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getHonninShikyugaku(), 0);
        }
        if (計算結果entity.getOver70_honninShikyugaku() != null) {
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(計算結果entity.getOver70_honninShikyugaku(), 0);
        }

        source.yubinNo = getColumnValue(entity.get帳票用データ().get被保険者entity().getYubinNo());
        source.choikiCode = getColumnValue(entity.get帳票用データ().get被保険者entity().getChoikiCode());
        source.gyoseikuCode = getColumnValue(entity.get帳票用データ().get被保険者entity().getGyoseikuCode());
        source.shimei50onKana = entity.get帳票用データ().get被保険者entity().getShimei50onKana();
        source.shichosonCode = getColumnValue(entity.get帳票用データ().get被保険者entity().getShichosonCode());
        source.shoKisaiHokenshaNo = getColumnValue(計算結果entity.getShoKisaiHokenshaNo());
        source.hihokenshaNo = getColumnValue(計算結果entity.getHihokenshaNoIn());

        return source;

    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString getSakuseiYmhm(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(作成);
        return sakuseiYMD.toRString();
    }

    private RString getlistUpper_5(FlexibleDate kaishiYMD, FlexibleDate shuryoYMD) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(kaishiYMD.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString());
        sakuseiYMD.append(new RString("～"));
        sakuseiYMD.append(shuryoYMD.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString());

        return sakuseiYMD.toRString();
    }
}
