/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200003_振込明細一覧表（高額合算） HeaderEditorクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranBodyEditor implements IFurikomiMeisaiIchiranEditor {

    private final FurikaeGoMeisaiEntity 振込明細一覧Entity;
    private final int 番号;
    private static final RString 事業対象値 = new RString("事業対象");
    private static final RString 支払方法区分値 = new RString("1");
    private static final RString 作成年度 = new RString("年度");
    private static final RString 接続文字 = new RString("～");
    private static final int 件数値TWO = 2;
    private static final int 件数値ONE = 1;
    private static final RString 名寄せ値 = new RString("有");
    private static final int LENGTH_FOUR = 4;
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_FOUR = 4;

    /**
     * コンストラクタです。
     *
     * @param 振込明細一覧Entity FurikaeGoMeisaiEntity
     * @param 番号 int
     */
    public FurikomiMeisaiIchiranBodyEditor(FurikaeGoMeisaiEntity 振込明細一覧Entity, int 番号) {
        this.振込明細一覧Entity = 振込明細一覧Entity;
        this.番号 = 番号;
    }

    @Override
    public FurikomiMeisaiIchiranSource edit(FurikomiMeisaiIchiranSource source) {

        if (振込明細一覧Entity.get識別コード() != null) {
            source.shikibetsuCode = 振込明細一覧Entity.get識別コード().value();
        }

        if (振込明細一覧Entity.get被保険者番号() != null) {
            source.list1_1 = 振込明細一覧Entity.get被保険者番号().value();
        }

        source.list1_2 = 振込明細一覧Entity.get氏名漢字();

        source.list1_3 = 振込明細一覧Entity.get支給申請書整理番号();

        source.list1_4 = パターン4編集(振込明細一覧Entity.get申請年月日());

        RString 名称 = RString.EMPTY;
        if (振込明細一覧Entity.get申請区分コード() != null && !振込明細一覧Entity.get申請区分コード().isEmpty()) {
            名称 = NinteiShinseiShinseijiKubunCode.toValue(振込明細一覧Entity.get申請区分コード()).get名称();
        }
        if (名称.length() <= LENGTH_FOUR) {
            source.list1_5 = 名称;
        } else {
            source.list1_5 = 名称.substring(INDEX_ZERO, INDEX_FOUR);
        }

        set認定有効期間開始終了と要介護度(source);
        set上段と下段(source);

        source.list1_7 = doカンマ編集(振込明細一覧Entity.get自己負担総額円());
        source.list2_1 = パターン305編集(振込明細一覧Entity.get対象年度());
        source.list2_2 = 振込明細一覧Entity.get住所();
        source.list2_3 = パターン254編集(振込明細一覧Entity.get対象計算期間開始年月()).concat(接続文字)
                .concat(パターン254編集(振込明細一覧Entity.get対象計算期間終了年月()));
        source.list2_4 = パターン4編集(振込明細一覧Entity.get決定年月日());
        source.list2_7 = doカンマ編集(振込明細一覧Entity.get振込金額());
        source.ｌist3_1 = new RString(番号);

        if (振込明細一覧Entity.get支払区分方法コード() != null) {
            source.list4_1 = ShiharaiHohoKubun.toValue(振込明細一覧Entity.get支払区分方法コード()).get略称();
        }

        if (件数値TWO <= 振込明細一覧Entity.get名寄せ件数()) {
            source.list5_1 = 名寄せ値;
        } else if (振込明細一覧Entity.get名寄せ件数() == 件数値ONE) {
            source.list5_1 = RString.EMPTY;
        }

        if (振込明細一覧Entity.is頁計フラグ()) {
            source.ninzu_shokei = doカンマ編集(振込明細一覧Entity.get頁計人数());
            source.shikyu_shokei = doカンマ編集(振込明細一覧Entity.get頁計金額());
        }
        if (振込明細一覧Entity.is総合計フラグ()) {
            source.yoshien_ninzu_gokei = doカンマ編集(振込明細一覧Entity.get総合計要支援人数());
            source.yoshien_kingaku_gokei = doカンマ編集(振込明細一覧Entity.get総合計要支援金額());
            source.jigyotaisho_ninzu_gokei = doカンマ編集(振込明細一覧Entity.get総合計事業対象人数());
            source.jigyotaisho_kingaku_gokei = doカンマ編集(振込明細一覧Entity.get総合計事業対象金額());
            source.fumei_ninzu_gokei = doカンマ編集(振込明細一覧Entity.get総合計不明人数());
            source.fumei_kingaku_gokei = doカンマ編集(振込明細一覧Entity.get総合計不明金額());
            source.ninzu_gokei = doカンマ編集(振込明細一覧Entity.get総合計人数());
            source.shikyu_gokei = doカンマ編集(振込明細一覧Entity.get総合計金額());
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.list1_1));
        return source;
    }

    private void set上段と下段(FurikomiMeisaiIchiranSource source) {

        if (支払方法区分値.equals(振込明細一覧Entity.get支払方法区分())) {
            source.list1_8 = 振込明細一覧Entity.get支払場所();
            source.list2_8 = パターン4編集(振込明細一覧Entity.get支払期間開始年月日()).concat(RString.HALF_SPACE)
                    .concat(パターン143編集(new RTime(振込明細一覧Entity.get支払窓口開始時間()))).concat(接続文字)
                    .concat(パターン4編集(振込明細一覧Entity.get支払期間終了年月日())).concat(RString.HALF_SPACE)
                    .concat(パターン143編集(new RTime(振込明細一覧Entity.get支払窓口終了時間())));
        } else {
            source.list1_8 = 振込明細一覧Entity.get金融機関名称().concat(RString.HALF_SPACE).concat(振込明細一覧Entity.get支店名称());
            source.list2_8 = 振込明細一覧Entity.get預金種別名称().concat(RString.HALF_SPACE).concat(振込明細一覧Entity.get口座番号())
                    .concat(RString.HALF_SPACE).concat(振込明細一覧Entity.get口座名義人());
        }

    }

    private void set認定有効期間開始終了と要介護度(FurikomiMeisaiIchiranSource source) {

        if (!振込明細一覧Entity.get要介護認定状態区分コード().isEmpty()) {
            source.list1_6 = パターン4編集(振込明細一覧Entity.get認定有効期間開始年月日());
            source.list2_6 = パターン4編集(振込明細一覧Entity.get認定有効期間終了年月日());
            source.list2_5 = YokaigoJotaiKubunSupport.
                    toValue(振込明細一覧Entity.get対象計算期間終了年月(), 振込明細一覧Entity.get要介護認定状態区分コード()).getName();
        } else if (振込明細一覧Entity.get要介護認定状態区分コード().isEmpty() && 振込明細一覧Entity.is総合事業フラグ()) {
            source.list1_6 = パターン4編集(振込明細一覧Entity.get総合事業適用開始年月日());
            source.list2_6 = パターン4編集(振込明細一覧Entity.get総合事業適用終了年月日());
            source.list2_5 = 事業対象値;
        } else if (振込明細一覧Entity.get要介護認定状態区分コード().isEmpty() && !振込明細一覧Entity.is総合事業フラグ()) {
            source.list1_6 = RString.EMPTY;
            source.list2_6 = RString.EMPTY;
            source.list2_5 = RString.EMPTY;
        }

    }

    private RString パターン4編集(FlexibleDate 年月日) {
        if (年月日 != null) {
            return 年月日.wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString パターン143編集(RTime 時間) {
        if (時間 != null) {
            return 時間.toFormattedTimeString(DisplayTimeFormat.HH_mm);
        }
        return RString.EMPTY;
    }

    private RString パターン254編集(FlexibleYearMonth 年月) {
        if (年月 != null) {
            return 年月.wareki().firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString パターン305編集(FlexibleYear 年度) {
        if (年度 != null) {
            return 年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().concat(作成年度);
        }
        return RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }

}
