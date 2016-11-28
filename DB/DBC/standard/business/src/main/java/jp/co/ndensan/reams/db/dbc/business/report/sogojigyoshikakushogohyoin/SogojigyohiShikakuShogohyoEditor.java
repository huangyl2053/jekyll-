/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyoshikakushogohyoin;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費資格照合表Editor
 *
 * @reamsid_L DBC-2890-032 wangxue
 */
public class SogojigyohiShikakuShogohyoEditor implements ISogojigyohiShikakuShogohyoEditor {

    private static final RString 合計件数タイトル = new RString("合計件数");
    private static final RString KEN = new RString("件");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString ティルデ = new RString("～");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final int DIVIDE_100 = 100;
    private static final int 小数点 = 2;
    private final SogojigyohiShikakuShogohyoInEntity entity;
    private final DonyuKeitaiCode 導入形態コード;
    private final RDateTime システム日付;
    private final boolean flg;
    private final int 合計件数;

    /**
     * コンストラクタです
     *
     * @param entity SogojigyohiShikakuShogohyoInEntity
     * @param 導入形態コード DonyuKeitaiCode
     * @param システム日付 RDateTime
     * @param 合計件数 int
     * @param flg boolean
     */
    public SogojigyohiShikakuShogohyoEditor(SogojigyohiShikakuShogohyoInEntity entity, DonyuKeitaiCode 導入形態コード,
            RDateTime システム日付, boolean flg, int 合計件数) {
        this.entity = entity;
        this.導入形態コード = 導入形態コード;
        this.システム日付 = システム日付;
        this.flg = flg;
        this.合計件数 = 合計件数;
    }

    @Override
    public SogojigyohiShikakuShogohyoInSource edit(SogojigyohiShikakuShogohyoInSource source) {

        RString 審査年月 = entity.get審査年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.shinsaYM = 審査年月;
        RString 作成日 = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = システム日付.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.shikibetsuCode = entity.get識別コード();
        if (null != entity.get資格照合_保険者番号()) {
            source.hokenshaNo = entity.get資格照合_保険者番号().getColumnValue();
        } else {
            source.hokenshaNo = RString.EMPTY;
        }
        source.hokenshaName = entity.get資格照合_保険者名();
        source.listUpper_1 = new RString(entity.get連番());
        if (null != entity.get被保険者_被保険者番号()) {
            source.listUpper_2 = entity.get被保険者_被保険者番号().getColumnValue();
            source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                    ReportKomokuEditorUtil.get非空文字列(source.listUpper_2));
        }
        if (導入形態コード.is広域() && null != entity.get証記載保険者番号()) {
            source.listUpper_3 = entity.get証記載保険者番号().getColumnValue();
        } else {
            source.listUpper_3 = RString.EMPTY;
        }
        source.listUpper_4 = entity.getサービス提供年月().wareki().separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
        if (null != entity.getサービス種類コード()) {
            source.listUpper_5 = entity.getサービス種類コード().getColumnValue();
        }
        source.listUpper_6 = entity.get種別();
        if (null != entity.get事業所番号()) {
            source.listUpper_7 = entity.get事業所番号().getColumnValue();
        }
        if (null != entity.getサービス提供年月() && !entity.getサービス提供年月().isEmpty()
                && null != entity.get要介護区分コード() && !entity.get要介護区分コード().isEmpty()) {
            IYokaigoJotaiKubun 要介護区分 = YokaigoJotaiKubunSupport.toValue(entity.getサービス提供年月(),
                    entity.get要介護区分コード().getColumnValue());
            source.listUpper_8 = 要介護区分.getName();
        }
        if (null != entity.get支援事業所番号()) {
            source.listLower_7 = entity.get支援事業所番号().getColumnValue();
        }
        set費用と区分(source);
        set有効期間(source);
        set合計件数(source);

        return source;
    }

    private void set費用と区分(SogojigyohiShikakuShogohyoInSource source) {
        source.listUpper_12 = doカンマ編集(entity.get支給限度額());
        if (null != entity.get居宅サービス計画作成区分コード()) {
            source.listUpper_13 = entity.get居宅サービス計画作成区分コード().getColumnValue();
        }
        if (null != entity.get単位数単価()) {
            source.listUpper_14 = DecimalFormatter.toRString(entity.get単位数単価().divide(DIVIDE_100), 小数点);
        }
        source.listUpper_15 = do給付率編集(entity.get保険給付率());
        source.listUpper_16 = do給付率編集(entity.get公費１給付率());
        source.listUpper_17 = do給付率編集(entity.get公費２給付率());
        source.listUpper_18 = do給付率編集(entity.get公費３給付率());
        source.listUpper_19 = doカンマ編集(new Decimal(entity.getサービス日数_回数()));
        source.listUpper_20 = doカンマ編集(entity.getサービス単位数());
        source.listUpper_21 = doカンマ編集(entity.get利用者負担額());
        source.listLower_1 = entity.get宛名名称();
        source.listLower_2 = entity.getサービス種類名();
        source.listLower_3 = entity.get事業所名();

    }

    private void set有効期間(SogojigyohiShikakuShogohyoInSource source) {

        if (null != entity.get認定有効期間_開始年月日()) {
            source.listUpper_9 = entity.get認定有効期間_開始年月日().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString();
        }
        if (null != entity.get認定有効期間_開始年月日() && !entity.get認定有効期間_開始年月日().isEmpty()
                || null != entity.get認定有効期間_終了年月日() && !entity.get認定有効期間_終了年月日().isEmpty()) {
            source.listUpper_10 = ティルデ;
        }
        if (null != entity.get認定有効期間_終了年月日()) {
            source.listUpper_11 = entity.get認定有効期間_終了年月日().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString();
        }
        if (null != entity.get限度額適用期間_開始年月日()) {
            source.listLower_4 = entity.get限度額適用期間_開始年月日().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString();
        }
        if (null != entity.get限度額適用期間_開始年月日() && !entity.get限度額適用期間_開始年月日().isEmpty()
                || null != entity.get限度額適用期間_終了年月日() && !entity.get限度額適用期間_終了年月日().isEmpty()) {
            source.listLower_5 = ティルデ;
        }
        if (null != entity.get限度額適用期間_終了年月日()) {
            source.listLower_6 = entity.get限度額適用期間_終了年月日().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString();
        }
    }

    private void set合計件数(SogojigyohiShikakuShogohyoInSource source) {
        if (flg) {
            source.gokeiKensuTitle = 合計件数タイトル;
            source.gokeiKensu = doカンマ編集(new Decimal(合計件数)).concat(KEN);
        } else {
            source.gokeiKensuTitle = RString.EMPTY;
            source.gokeiKensu = RString.EMPTY;
        }
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString do給付率編集(HokenKyufuRitsu number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toRString(number.getColumnValue(), 0);
    }

}
