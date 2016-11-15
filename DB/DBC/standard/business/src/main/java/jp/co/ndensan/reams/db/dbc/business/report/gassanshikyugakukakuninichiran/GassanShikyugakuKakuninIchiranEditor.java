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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.TempDbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakukakuninichiran.GassanShikyugakuKakuninIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
    private static final RString 日時作成 = new RString("作成");
    private static final RString 接続文字 = new RString("～");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private final KogakuGassanShikyugakuKeisanKekkaIn entity;

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
        source.shutsuryokujun1 = get並び順(NUM_0);
        source.shutsuryokujun2 = get並び順(NUM_1);
        source.shutsuryokujun3 = get並び順(NUM_2);
        source.shutsuryokujun4 = get並び順(NUM_3);
        source.shutsuryokujun5 = get並び順(NUM_4);
        source.kaipage1 = get改頁(NUM_0);
        source.kaipage2 = get改頁(NUM_1);
        source.kaipage3 = get改頁(NUM_2);
        source.kaipage4 = get改頁(NUM_3);
        source.kaipage5 = get改頁(NUM_4);
        source.listUpper_1 = new RString(entity.get連番());
        source.listUpper_2 = 計算結果entity.getTaishoNendo().wareki().firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();

        TempDbWT0001HihokenshaEntity 被保険者entity = entity.get帳票用データ().get被保険者entity();
        source.listUpper_3 = 被保険者entity.getHihokenshaNo().value();
        source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                source.listUpper_3);
        source.listLower_1 = 被保険者entity.getMeisho();
        source.listUpper_4 = 計算結果entity.getShikyuShinseishoSeiriNo();
        source.listLower_2 = 計算結果entity.getJikoFutanSeiriNo();

        source.listUpper_5 = getlistUpper_5(計算結果entity.getTaishoKeisanKaishiYMD(), 計算結果entity.getTaishoKeisanShuryoYMD());

        source.listLower_3 = KaigoGassan_ShotokuKbn.toValue(計算結果entity.getShotokuKubun()).get名称();
        source.listLower_4 = KaigoGassan_Over70_ShotokuKbn.toValue(計算結果entity.getOver70_ShotokuKubun()).get名称();

        source.listUpper_6 = doカンマ編集(計算結果entity.getSetaiFutanSogaku());
        source.listLower_5 = doカンマ編集(計算結果entity.getSetaiGassanGaku());
        source.listLower_6 = doカンマ編集(計算結果entity.getOver70_SetaiGassanGaku());
        source.listUpper_7 = doカンマ編集(計算結果entity.getSanteiKijunGaku());
        source.listLower_7 = doカンマ編集(計算結果entity.getOver70_SanteiKijyunGaku());
        source.listUpper_8 = doカンマ編集(計算結果entity.getSetaiShikyuSogaku());
        source.listLower_8 = doカンマ編集(計算結果entity.getOver70_SetaiShikyuSogaku());
        source.listUpper_9 = doカンマ編集(計算結果entity.getHonninShikyugaku());
        source.listLower_9 = doカンマ編集(計算結果entity.getOver70_honninShikyugaku());

        source.yubinNo = getColumnValue(被保険者entity.getYubinNo());
        source.choikiCode = getColumnValue(被保険者entity.getChoikiCode());
        source.gyoseikuCode = getColumnValue(被保険者entity.getGyoseikuCode());
        source.shimei50onKana = 被保険者entity.getShimei50onKana();
        source.shichosonCode = getColumnValue(被保険者entity.getShichosonCode());
        source.shoKisaiHokenshaNo = getColumnValue(計算結果entity.getShoKisaiHokenshaNo());
        source.hihokenshaNo = getColumnValue(計算結果entity.getHihokenshaNoIn());

        source.shikibetsuCode = 被保険者entity.getShikibetsuCode().value();

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
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }

    private RString getlistUpper_5(FlexibleDate kaishiYMD, FlexibleDate shuryoYMD) {

        RStringBuilder sakuseiYMD = new RStringBuilder();
        if (kaishiYMD != null) {
            sakuseiYMD.append(kaishiYMD.wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).
                    toDateString());
        }
        sakuseiYMD.append(接続文字);
        if (shuryoYMD != null && !shuryoYMD.isEmpty()) {
            sakuseiYMD.append(shuryoYMD.wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).
                    toDateString());
        }

        return sakuseiYMD.toRString();
    }

    private RString get改頁(int index) {
        return index < entity.get改頁リスト().size() ? entity.get改頁リスト().get(index) : RString.EMPTY;
    }

    private RString get並び順(int index) {
        return index < entity.get並び順リスト().size() ? entity.get並び順リスト().get(index) : RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }
}
