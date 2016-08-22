/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護給付費等審査決定請求明細表のHeaderEditorクラスです。
 *
 * @reamsid_L DBC-2500-030 jiangxiaolong
 */
public class KyufuhiShinsaKetteiSeikyuMeisaihyoHeaderEditor implements IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor {

    private final KyufuhiShinsaKetteiSeikyuMeisaihyoEntity 帳票出力対象;
    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;
    private static final RString SAKUSEI = new RString("作成");
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象 KyufuhiShinsaKetteiSeikyuMeisaihyoEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     */
    public KyufuhiShinsaKetteiSeikyuMeisaihyoHeaderEditor(
            KyufuhiShinsaKetteiSeikyuMeisaihyoEntity 帳票出力対象,
            Map<RString, RString> 出力順Map,
            RDateTime 作成日時) {
        this.帳票出力対象 = 帳票出力対象;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
    }

    @Override
    public KyufuhiShinsaKetteiSeikyuMeisaihyoSource edit(KyufuhiShinsaKetteiSeikyuMeisaihyoSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.shinsaYM = パターン56(帳票出力対象.get合計テータ().get審査年月());
        source.hokenshaNo = getColumnValue(帳票出力対象.get合計テータ().get保険者番号());
        source.hokenshaName = 帳票出力対象.get合計テータ().get保険者名();
        if (出力順Map != null) {
            if (!RString.isNullOrEmpty(出力順Map.get(KEY_並び順の２件目))) {
                source.shutsuryokujun1 = 出力順Map.get(KEY_並び順の２件目);
                source.kaipage1 = 出力順Map.get(KEY_並び順の２件目);
            }
            if (!RString.isNullOrEmpty(出力順Map.get(KEY_並び順の３件目))) {
                source.shutsuryokujun2 = 出力順Map.get(KEY_並び順の３件目);
                source.kaipage2 = 出力順Map.get(KEY_並び順の３件目);
            }
            if (!RString.isNullOrEmpty(出力順Map.get(KEY_並び順の４件目))) {
                source.shutsuryokujun3 = 出力順Map.get(KEY_並び順の４件目);
                source.kaipage3 = 出力順Map.get(KEY_並び順の４件目);
            }
            if (!RString.isNullOrEmpty(出力順Map.get(KEY_並び順の５件目))) {
                source.shutsuryokujun4 = 出力順Map.get(KEY_並び順の５件目);
                source.kaipage4 = 出力順Map.get(KEY_並び順の５件目);
            }
            if (!RString.isNullOrEmpty(出力順Map.get(KEY_並び順の６件目))) {
                source.shutsuryokujun5 = 出力順Map.get(KEY_並び順の６件目);
                source.kaipage5 = 出力順Map.get(KEY_並び順の６件目);
            }
        }
        source.kokuhorenName = 帳票出力対象.get合計テータ().get国保連合会名();
        source.shoKisaiHokenshaNo = getColumnValue(帳票出力対象.get合計テータ().get証記載保険者番号());

        return source;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
