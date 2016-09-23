/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.chohyo.HyojiCodes;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.KakushuKubun;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表 Editor クラスです。
 *
 * @reamsid_L DBB-1840-080 liuxiaoyu
 */
public class TokubetsuChoshuIdojohoIchiranEditor implements ITokubetsuChoshuIdojohoIchiranEditor {

    private final TokuChoYidoIchiranEntity 特徴異動情報;
    private final RDateTime 作成日時;
    private final FlexibleYear 賦課年度;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 年度 = new RString("度");
    private static final int NUM_0 = 0;

    /**
     * コンストラクタです
     *
     * @param 特徴異動情報 TokuChoYidoIchiranEntity
     * @param 作成日時 RDateTime
     * @param 賦課年度 FlexibleYear
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     */
    public TokubetsuChoshuIdojohoIchiranEditor(
            TokuChoYidoIchiranEntity 特徴異動情報,
            RDateTime 作成日時,
            FlexibleYear 賦課年度,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁リスト) {
        this.特徴異動情報 = 特徴異動情報;
        this.作成日時 = 作成日時;
        this.賦課年度 = 賦課年度;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public TokubetsuChoshuIdojohoIchiranSource edit(TokubetsuChoshuIdojohoIchiranSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.nenkinHokenshaName = 特徴異動情報.get年金保険者名称();
        source.nendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString().concat(年度);
        UeT0511NenkinTokuchoKaifuJohoEntity 特徴異動追加情報 = 特徴異動情報.get特徴異動追加情報();
        source.tsuchiNaiyo = TsuchiNaiyoCodeType.toValue(特徴異動追加情報.getTsuchiNaiyoCode()).get通知内容名称();
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);
        source.kaipage1 = get改頁(INT_1);
        source.kaipage2 = get改頁(INT_2);
        source.kaipage3 = get改頁(INT_3);
        source.kaipage4 = get改頁(INT_4);
        source.kaipage5 = get改頁(INT_5);
        HyojiCodes 表示コード = 特徴異動情報.get表示コード();
        source.hyojicodeName1 = 表示コード.get表示コード名１();
        source.hyojicodeName2 = 表示コード.get表示コード名２();
        source.hyojicodeName3 = 表示コード.get表示コード名３();
        source.listUpper_1 = 特徴異動追加情報.getHihokenshaNo();
        source.listUpper_2 = 特徴異動追加情報.getKisoNenkinNo();
        source.listUpper_3 = 特徴異動追加情報.getDtKanaShimei();
        source.listUpper_4 = new FlexibleDate(特徴異動追加情報.getDtBirthDay()).wareki().toDateString();
        if (null != 特徴異動情報.get編集後宛先()) {
            source.listUpper_5 = 特徴異動情報.get編集後宛先().get行政区コード().getColumnValue();
        }
        source.listUpper_6 = 表示コード.get表示コード１();
        source.listUpper_7 = 表示コード.get表示コード２();
        source.listUpper_8 = 表示コード.get表示コード３();
        source.listUpper_9 = getDT各種金額欄(特徴異動追加情報.getDtKakushuKingaku1());
        source.listUpper_10 = getDT各種金額欄(特徴異動追加情報.getDtKakushuKingaku2());
        source.listUpper_11 = getDT各種金額欄(特徴異動追加情報.getDtKakushuKingaku3());
        ShikibetsuCode 識別コード = 特徴異動追加情報.getShikibetsuCode();
        if (null != 識別コード) {
            source.listLower_1 = 識別コード.getColumnValue();
        }
        source.listLower_2 = 特徴異動追加情報.getNenkinCode();
        source.listLower_3 = 特徴異動追加情報.getDtKanjiShimei();
        source.listLower_4 = 特徴異動追加情報.getDtSeibetsu();
        source.listLower_5 = new FlexibleDate(特徴異動追加情報.getDtKakushuYMD()).wareki().toDateString();
        source.listLower_6 = KakushuKubun.toValue(特徴異動追加情報.getTsuchiNaiyoCode(), 特徴異動追加情報.getDtKakushuKubun()).get各種区分名称();
        source.listLower_7 = 特徴異動追加情報.getDtYubinNo();
        source.listLower_8 = 特徴異動追加情報.getDtKanjiJusho();
        ShikibetsuCode shikibetsuCode = 特徴異動追加情報.getShikibetsuCode();
        if (null != shikibetsuCode) {
            source.shikibetsuCode = shikibetsuCode.getColumnValue();
        }
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }

    private RString getDT各種金額欄(RString dT各種金額欄) {
        if (null != dT各種金額欄) {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(dT各種金額欄.toString()), NUM_0);
        } else {
            return RString.EMPTY;
        }
    }
}
