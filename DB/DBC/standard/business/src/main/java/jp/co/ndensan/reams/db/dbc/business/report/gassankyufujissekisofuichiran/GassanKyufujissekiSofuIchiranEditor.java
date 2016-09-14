/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassankyufujissekisofuichiran;

import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakugassanKyufujissekiDoSofuReportEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_KyufuJissekiSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200042_高額合算給付実績情報送付一覧表のEditorrクラスです。
 *
 * @reamsid_L DBC-2710-040 qinzhen
 */
public class GassanKyufujissekiSofuIchiranEditor implements
        IGassanKyufujissekiSofuIchiranEditor {

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString 日時作成 = new RString("作成");
    private final KogakugassanKyufujissekiDoSofuReportEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakugassanKyufujissekiDoSofuReportEntity
     *
     */
    public GassanKyufujissekiSofuIchiranEditor(KogakugassanKyufujissekiDoSofuReportEntity entity) {
        this.entity = entity;

    }

    @Override
    public GassanKyufujissekiSofuIchiranSource edit(GassanKyufujissekiSofuIchiranSource source) {

        source.printTimeStamp = getSakuseiYmhm(entity.get作成日時());
        source.sofuYM = entity.get処理年月().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
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

        source.list_1 = new RString(entity.get連番());

        if (entity.get帳票用データ() != null) {
            if (entity.get帳票用データ().get給付実績_被保険者番号() != null) {
                source.list_2 = entity.get帳票用データ().get給付実績_被保険者番号().value();
            }

            source.list_3 = entity.get帳票用データ().get宛名名称();
            source.list_4 = entity.get帳票用データ().get支給申請書整理番号();
            source.list_5 = entity.get帳票用データ().get自己負担額証明書整理番号();
            source.list_6 = KaigoGassan_KyufuJissekiSakuseiKubun.toValue(entity.get帳票用データ().get給付実績作成区分コード()).get名称();

            if (entity.get帳票用データ().get給付実績_証記載保険者番号() != null) {
                source.list_7 = entity.get帳票用データ().get給付実績_証記載保険者番号().value();
            }

            source.list_8 = entity.get帳票用データ().get申請年月日().wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();

            if (entity.get帳票用データ().get決定年月日() != null) {
                source.list_9 = entity.get帳票用データ().get決定年月日().wareki().
                        eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }

            if (entity.get帳票用データ().get自己負担総額() != null) {
                source.list_10 = DecimalFormatter.toコンマ区切りRString(entity.get帳票用データ().get自己負担総額(), 0);
            }
            if (entity.get帳票用データ().get支給額() != null) {
                source.list_11 = DecimalFormatter.toコンマ区切りRString(entity.get帳票用データ().get支給額(), 0);
            }
        }
        return source;

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

    private RString get改頁(int index) {
        return index < entity.get改頁リスト().size() ? entity.get改頁リスト().get(index) : RString.EMPTY;
    }

    private RString get並び順(int index) {
        return index < entity.get並び順リスト().size() ? entity.get並び順リスト().get(index) : RString.EMPTY;
    }

}
