/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranSource;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.KakushuKubun;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
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
    private final UaFt200FindShikibetsuTaishoEntity 宛名情報;
    private final RDateTime 作成日時;
    private final FlexibleYear 賦課年度;
    private final RString 保険者番号;
    private final RString 保険者名称;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    private static final RString SAKUSEI = new RString("作成");
    private static final RString 年度 = new RString("度");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final int NUM_0 = 0;

    /**
     * コンストラクタです
     *
     * @param 特徴異動情報 TokuChoYidoIchiranEntity
     * @param 宛名情報 UaFt200FindShikibetsuTaishoEntity
     * @param 作成日時 RDateTime
     * @param 賦課年度 FlexibleYear
     * @param 保険者番号 RString
     * @param 保険者名称 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     */
    public TokubetsuChoshuIdojohoIchiranEditor(
            TokuChoYidoIchiranEntity 特徴異動情報,
            UaFt200FindShikibetsuTaishoEntity 宛名情報,
            RDateTime 作成日時,
            FlexibleYear 賦課年度,
            RString 保険者番号,
            RString 保険者名称,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト) {
        this.特徴異動情報 = 特徴異動情報;
        this.宛名情報 = 宛名情報;
        this.作成日時 = 作成日時;
        this.賦課年度 = 賦課年度;
        this.保険者番号 = 保険者番号;
        this.保険者名称 = 保険者名称;
        this.出力順リスト = 出力順リスト;
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
        if (null != 特徴異動追加情報) {
            source.tsuchiNaiyo = TsuchiNaiyoCodeType.toValue(特徴異動追加情報.getTsuchiNaiyoCode()).get通知内容名称();
            source.listUpper_1 = 特徴異動追加情報.getHihokenshaNo();
            if (null != 特徴異動追加情報.getHihokenshaNo()) {
                source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                        特徴異動追加情報.getHihokenshaNo());
            }
            source.listUpper_2 = 特徴異動追加情報.getKisoNenkinNo();
            source.listUpper_3 = 特徴異動追加情報.getDtKanaShimei();
            source.shichosonCode = 特徴異動追加情報.getKoseiCityCode();
            RString 生年月日 = 特徴異動追加情報.getDtBirthDay();
            if (null != 生年月日) {
                source.listUpper_4 = new FlexibleDate(生年月日).wareki().toDateString();
            } else {
                source.listUpper_4 = RString.EMPTY;
            }
            source.listUpper_9 = getDT各種金額欄(特徴異動追加情報.getDtKakushuKingaku1());
            source.listUpper_10 = getDT各種金額欄(特徴異動追加情報.getDtKakushuKingaku2());
            source.listUpper_11 = getDT各種金額欄(特徴異動追加情報.getDtKakushuKingaku3());
            ShikibetsuCode 識別コード = 特徴異動追加情報.getShikibetsuCode();
            if (null != 識別コード) {
                source.listLower_1 = 識別コード.value();
            } else {
                source.listLower_1 = RString.EMPTY;
            }
            source.listLower_2 = 特徴異動追加情報.getNenkinCode();
            source.listLower_3 = 特徴異動追加情報.getDtKanjiShimei();
            source.listLower_4 = 特徴異動追加情報.getDtSeibetsu();
            RString 発生年月日 = 特徴異動追加情報.getDtKakushuYMD();
            if (null != 発生年月日) {
                source.listLower_5 = new FlexibleDate(発生年月日).wareki().toDateString();
            }
            source.listLower_6 = KakushuKubun.toValue(特徴異動追加情報.getTsuchiNaiyoCode(), 特徴異動追加情報.getDtKakushuKubun()).get各種区分名称();
            source.listLower_7 = 特徴異動追加情報.getDtYubinNo() == null ? RString.EMPTY
                    : new YubinNo(特徴異動追加情報.getDtYubinNo()).getEditedYubinNo();
            source.listLower_8 = 特徴異動追加情報.getDtKanjiJusho();
        } else {
            source.listUpper_1 = RString.EMPTY;
            source.listUpper_2 = RString.EMPTY;
            source.listUpper_3 = RString.EMPTY;
            source.listUpper_4 = RString.EMPTY;
            source.listLower_2 = RString.EMPTY;
            source.listLower_4 = RString.EMPTY;
        }
        source.hokenshaNo = 保険者番号;
        source.hokenshaName = 保険者名称;
        source.shutsuryokujun1 = get並び順(INDEX_0);
        source.shutsuryokujun2 = get並び順(INDEX_1);
        source.shutsuryokujun3 = get並び順(INDEX_2);
        source.shutsuryokujun4 = get並び順(INDEX_3);
        source.shutsuryokujun5 = get並び順(INDEX_4);
        source.kaipage1 = get改頁(INDEX_0);
        source.kaipage2 = get改頁(INDEX_1);
        source.kaipage3 = get改頁(INDEX_2);
        source.kaipage4 = get改頁(INDEX_3);
        source.kaipage5 = get改頁(INDEX_4);
        HyojiCodes 表示コード = 特徴異動情報.get表示コード();
        if (null != 表示コード) {
            source.hyojicodeName1 = 表示コード.get表示コード名１();
            source.hyojicodeName2 = 表示コード.get表示コード名２();
            source.hyojicodeName3 = 表示コード.get表示コード名３();
            source.listUpper_6 = 表示コード.get表示コード１();
            source.listUpper_7 = 表示コード.get表示コード２();
            source.listUpper_8 = 表示コード.get表示コード３();
        }
        if (null != 特徴異動情報.get編集後宛先()) {
            source.listUpper_5 = 特徴異動情報.get編集後宛先().get行政区コード().getColumnValue();
        } else {
            source.listUpper_5 = RString.EMPTY;
        }

        return source;
    }

    private RString get並び順(int 並び順Index) {
        return 並び順Index < 出力順リスト.size() ? 出力順リスト.get(並び順Index) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        RString 改頁コード = index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
        if (RString.isNullOrEmpty(改頁コード)) {
            return RString.EMPTY;
        }

        UeT0511NenkinTokuchoKaifuJohoEntity 特徴異動追加情報 = 特徴異動情報.get特徴異動追加情報();
        RString 性別 = RString.EMPTY;
        RString 氏名５０音カナ = RString.EMPTY;
        RString 生年月日 = RString.EMPTY;
        RString 行政区コード = RString.EMPTY;
        RString 識別コード = RString.EMPTY;

        if (宛名情報 != null) {
            性別 = 宛名情報.getSeibetsuCode() == null ? RString.EMPTY : 宛名情報.getSeibetsuCode();
            氏名５０音カナ = get氏名５０音カナ();
            生年月日 = get生年月日();
            識別コード = get識別コード();
        }
        if (null != 特徴異動情報.get編集後宛先()) {
            行政区コード = 特徴異動情報.get編集後宛先().get行政区コード() == null ? RString.EMPTY
                    : 特徴異動情報.get編集後宛先().get行政区コード().getColumnValue();
        }

        if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.市町村コード.get項目ID().equals(改頁コード)) {
            return 特徴異動追加情報.getKoseiCityCode();
        } else if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.年金コード.get項目ID().equals(改頁コード)) {
            return 特徴異動追加情報.getNenkinCode();
        } else if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.年金番号.get項目ID().equals(改頁コード)) {
            return 特徴異動追加情報.getKisoNenkinNo();
        } else if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.性別.get項目ID().equals(改頁コード)) {
            return 性別;
        } else if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.氏名５０音カナ.get項目ID().equals(改頁コード)) {
            return 氏名５０音カナ;
        } else if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.生年月日.get項目ID().equals(改頁コード)) {
            return 生年月日;
        } else if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.行政区コード.get項目ID().equals(改頁コード)) {
            return 行政区コード;
        } else if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.被保険者番号.get項目ID().equals(改頁コード)) {
            return 特徴異動追加情報.getHihokenshaNo();
        } else if (DBB200021_TokubetsuChoshuIdojohoIchiranEnum.識別コード.get項目ID().equals(改頁コード)) {
            return 識別コード;
        }
        return RString.EMPTY;
    }

    private RString get氏名５０音カナ() {
        if (宛名情報.getKanaMeisho() != null) {
            AtenaKanaMeisho 氏名 = 宛名情報.getKanaMeisho();
            if (氏名 != null) {
                return 氏名.getColumnValue();
            }
        }
        return RString.EMPTY;
    }

    private RString get生年月日() {
        if (宛名情報.getSeinengappiYMD() != null) {
            FlexibleDate 生年月日 = 宛名情報.getSeinengappiYMD();
            if (生年月日 != null) {
                return new RString(生年月日.toString());
            }
        }
        return RString.EMPTY;
    }

    private RString get識別コード() {
        if (宛名情報.getShikibetsuCode() != null) {
            ShikibetsuCode 識別コード = 宛名情報.getShikibetsuCode();
            if (識別コード != null) {
                return 識別コード.getColumnValue();
            }
        }
        return RString.EMPTY;
    }

    private RString getDT各種金額欄(RString dT各種金額欄) {
        if (null != dT各種金額欄 && !dT各種金額欄.isEmpty()) {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(dT各種金額欄.toString()), NUM_0);
        } else {
            return RString.EMPTY;
        }
    }
}
