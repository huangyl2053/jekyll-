/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishikakushogohyokeikasochi;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin.ShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohishikakushogohyokeikasochi.SogojigyohiShikakuShogohyoKeikaSochiSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費（経過措置）資格照合表Editorクラスです。
 *
 * @reamsid_L DBC-2890-031 wangxingpeng
 */
public class SogojigyohiShikakuShogohyoKeikaSochiEditor
        implements ISogojigyohiShikakuShogohyoKeikaSochiEditor {

    private final ShikakuShogohyoInEntity target;

    private static final RString SAKUSEI = new RString("作成");
    private IYokaigoJotaiKubun 要介護状態区分;
    private static final RString 合計件数 = new RString("合計件数");
    private static final RString 件 = new RString("件");
    private static final RString 期間 = new RString("～");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private final boolean flag;
    private final int 合計;
    private final YMDHMS システム日時;
    private final int 連番;
    private final DonyuKeitaiCode 導入形態コード;

    /**
     * コンストラクタです。
     *
     * @param flag boolean
     * @param 合計 int
     * @param target ShikakuShogohyoInEntity
     * @param システム日時 YMDHMS
     * @param 連番 int
     * @param 導入形態コード DonyuKeitaiCode
     */
    public SogojigyohiShikakuShogohyoKeikaSochiEditor(boolean flag,
            int 合計,
            ShikakuShogohyoInEntity target,
            YMDHMS システム日時,
            int 連番,
            DonyuKeitaiCode 導入形態コード) {
        this.flag = flag;
        this.合計 = 合計;
        this.target = target;
        this.システム日時 = システム日時;
        this.連番 = 連番;
        this.導入形態コード = 導入形態コード;

    }

    @Override
    public SogojigyohiShikakuShogohyoKeikaSochiSource edit(SogojigyohiShikakuShogohyoKeikaSochiSource source) {
        source.printTimeStamp = パターン12(システム日時);
        source.listUpper_1 = new RString(連番);
        if (target.get被保険者一時() != null) {
            editor編集1(source);
            source.shikibetsuCode = target.get被保険者一時().get識別コード();
            source.listUpper_2 = target.get被保険者一時().get登録被保険者番号().getColumnValue();
            source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                    ReportKomokuEditorUtil.get非空文字列(source.listUpper_2));
            source.listLower_1 = target.get被保険者一時().get宛名名称();
            if (導入形態コード.is広域()) {
                source.listUpper_3 = target.get被保険者一時().get証記載保険者番号().getColumnValue();
            }

            if (target.get資格照合表一時().getShinsaYM() != null) {
                source.shinsaYM = パターン56(target.get資格照合表一時().getShinsaYM());
            }
            source.hokenshaNo = target.get資格照合表一時().getHokenshaNo() == null ? RString.EMPTY
                    : target.get資格照合表一時().getHokenshaNo().getColumnValue();
            source.hokenshaName = target.get資格照合表一時().getHokenshaName();
            source.listUpper_4 = target.get資格照合表一時().getServiceShuruiCode().getColumnValue();
            source.listUpper_5 = target.get資格照合表一時().getServiceShuruiMei();
            if (target.get資格照合表一時().getServiceTeikyoYM() != null) {
                source.listUpper_6 = パターン54(target.get資格照合表一時().getServiceTeikyoYM());
            }
            source.listUpper_7 = target.get資格照合表一時().getShubetsu();
            source.listUpper_8 = target.get資格照合表一時().getJigyoshoNo().getColumnValue();
            source.listUpper_9 = target.get資格照合表一時().getJigyoshoMei();
            source.listUpper_14 = new RString(target.get資格照合表一時().getServiceNissuKaisu());
            if (target.get資格照合表一時().getServiceTanisu() != null) {
                source.listUpper_15 = decimal_to_string(target.get資格照合表一時().getServiceTanisu());
            }
            if (target.get資格照合表一時().getRiyoshaFutanGaku() != null) {
                source.listUpper_16 = decimal_to_string(target.get資格照合表一時().getRiyoshaFutanGaku());
            }
        }

        editor集計(source);

        return source;
    }

    private SogojigyohiShikakuShogohyoKeikaSochiSource editor編集1(SogojigyohiShikakuShogohyoKeikaSochiSource source) {
        要介護状態区分 = YokaigoJotaiKubunSupport.toValue(target.get資格照合表一時().getServiceTeikyoYM(),
                target.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
        source.listUpper_10 = 要介護状態区分.getName();
        if (target.get資格照合表一時().getNinteiYukoKikanKaishiYMD() != null) {
            source.listUpper_11 = パターン4(target.get資格照合表一時().getNinteiYukoKikanKaishiYMD());
        }
        if (target.get資格照合表一時().getNinteiYukoKikanKaishiYMD() != null
                && target.get資格照合表一時().getNinteiYukoKikanShuryoYMD() != null
                && target.get資格照合表一時().getNinteiYukoKikanKaishiYMD().isEmpty()
                && target.get資格照合表一時().getNinteiYukoKikanShuryoYMD().isEmpty()) {
            source.listUpper_12 = null;
        } else {
            source.listUpper_12 = 期間;
        }
        if (target.get資格照合表一時().getNinteiYukoKikanShuryoYMD() != null) {
            source.listUpper_13 = パターン4(target.get資格照合表一時().getNinteiYukoKikanShuryoYMD());
        }
        return source;
    }

    private SogojigyohiShikakuShogohyoKeikaSochiSource editor集計(SogojigyohiShikakuShogohyoKeikaSochiSource source) {
        if (flag) {
            source.gokeiKensuTitle = 合計件数;
            source.gokeiKensu = decimal_to_string(new Decimal(合計)).concat(件);
        }
        return source;
    }

    private RString パターン12(YMDHMS 作成日時) {
        if (null == 作成日時) {
            return RString.EMPTY;
        } else {
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getRDateTime().getTime().
                    toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
            return 作成日.concat(RString.HALF_SPACE).concat(作成時);
        }
    }

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString パターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString パターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 数値からstringに転換する。
     *
     * @param number 数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }
}
