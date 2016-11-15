/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunjikofutangakukeisankekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJigyobunJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 事業高額合算・事業分自己負担額計算結果一覧表帳票BodyEditorクラスです
 *
 * @reamsid_L DBC-4790-040 jiangwenkai
 */
public class GassanJigyobunJikofutangakuKeisanKekkaIchiranBodyEditor implements IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor {

    private final GassanJikofutangakuKeisanKekkaIchiranEntity 帳票出力対象データ;

    private static final RString 符号_1 = new RString("～");
    private static final RString 符号_2 = new RString("*");
    private static final RString 数字_1 = new RString("1");
    private static final RString 数字_2 = new RString("2");
    private static final RString 数字_3 = new RString("3");
    private static final RString 数字_4 = new RString("4");
    private static final RString 年度 = new RString("年度");
    private static final RString 一覧区分_1 = new RString("１：審査方法区分が未設定");
    private static final RString 一覧区分_2 = new RString("２：補正後事業高額支給額がマイナス値");
    private static final RString 一覧区分_3 = new RString("３：査方法区分が未設定かつ補正後事業高額支給額がマイナス値");
    private static final RString 一覧区分_4 = new RString("４：自己負担額＜事業高額支給額");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ GassanJikofutangakuKeisanKekkaIchiranEntity
     */
    public GassanJigyobunJikofutangakuKeisanKekkaIchiranBodyEditor(GassanJikofutangakuKeisanKekkaIchiranEntity 帳票出力対象データ
    ) {
        this.帳票出力対象データ = 帳票出力対象データ;
    }

    @Override
    public GassanJigyobunJikofutangakuKeisanKekkaIchiranSource edit(GassanJigyobunJikofutangakuKeisanKekkaIchiranSource source) {
        source.list_1 = getColumnValue(帳票出力対象データ.get被保険者番号());
        source.list_2 = 帳票出力対象データ.get被保険者氏名();
        if (数字_1.equals(帳票出力対象データ.get住民種別コード())) {
            source.list_3 = 帳票出力対象データ.get生年月日().wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
        } else if (数字_2.equals(帳票出力対象データ.get住民種別コード())) {
            source.list_3 = 帳票出力対象データ.get生年月日().seireki().toDateString();
        }
        source.list_4 = this.get性別(帳票出力対象データ.get性別());
        source.list_5 = 帳票出力対象データ.get申請書整理番号();
        source.list_6 = get年月日(帳票出力対象データ.get申請年月日());
        source.list_7 = get年月(帳票出力対象データ.get申請対象年度());
        if ((帳票出力対象データ.get介護加入期間開始().isEmpty() && 帳票出力対象データ.get介護加入期間開始().isEmpty())
                || 帳票出力対象データ.get介護加入期間終了().isEmpty()) {
            source.list_8 = get年月日(帳票出力対象データ.get介護加入期間開始());
        } else {
            source.list_8 = get年月日(帳票出力対象データ.get介護加入期間開始()).concat(符号_1).concat(get年月日(帳票出力対象データ.get介護加入期間終了()));
        }
        source.list_9 = this.get共通ポリシー金額(帳票出力対象データ.get自己負担額());
        source.list_10 = this.get共通ポリシー金額(帳票出力対象データ.get高額支給額());
        source.list_11 = this.get共通ポリシー金額(帳票出力対象データ.getOneTwo());
        source.list_12 = this.get共通ポリシー金額(帳票出力対象データ.get自己負担額内数());
        source.list_13 = this.get一覧表示区分(帳票出力対象データ.get一覧用確認区分(), 帳票出力対象データ.get一覧用確認区分２());
        editFour(source);
        return source;
    }

    private RString get性別(RString 性別) {
        if (Seibetsu.男.getコード().equals(性別)) {
            return Seibetsu.男.get名称();
        } else if (Seibetsu.女.getコード().equals(性別)) {
            return Seibetsu.女.get名称();
        }
        return RString.EMPTY;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString get共通ポリシー金額(Decimal 金額) {
        if (null != 金額) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        }
        return RString.EMPTY;
    }

    private RString get一覧表示区分(RString 一覧表示区分, RString 一覧表示区分2) {

        RString 区分 = RString.EMPTY;
        if (符号_2.equals(一覧表示区分2)) {
            区分 = 一覧区分_4;
        } else if (数字_1.equals(一覧表示区分)) {
            区分 = 一覧区分_1;
        } else if (数字_2.equals(一覧表示区分)) {
            区分 = 一覧区分_2;
        } else if (数字_3.equals(一覧表示区分)) {
            区分 = 一覧区分_3;
        } else if (数字_4.equals(一覧表示区分)) {
            区分 = 一覧区分_4;
        }
        return 区分;
    }

    private RString get年月日(FlexibleDate 年月日) {
        if (null != 年月日) {
            return 年月日.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get年月(FlexibleYear 年) {
        if (null != 年) {
            return 年.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString().concat(年度);
        }
        return RString.EMPTY;
    }

    private void editFour(GassanJigyobunJikofutangakuKeisanKekkaIchiranSource source) {
        source.yubinNo = 帳票出力対象データ.getYubinNo();
        source.choikiCode = 帳票出力対象データ.getChoikiCode();
        source.gyoseikuCode = 帳票出力対象データ.getGyoseikuCode();
        source.hokenshaNo = 帳票出力対象データ.getHokenshaNo();
        source.shichosonCode = 帳票出力対象データ.getShichosonCode();
    }

}
