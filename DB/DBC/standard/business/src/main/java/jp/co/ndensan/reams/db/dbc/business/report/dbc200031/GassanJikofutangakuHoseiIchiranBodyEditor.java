/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200031;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200031.GassanJikofutangakuHoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200031.GassanJikofutangakuHoseiIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * 帳票設計_DBCMN62002_高額合算自己負担額補正結果一覧表BodyEditor
 *
 * @reamsid_L DBC-2320-040 jiangxiaolong
 */
public class GassanJikofutangakuHoseiIchiranBodyEditor
        implements IGassanJikofutangakuHoseiIchiranEditor {

    private final GassanJikofutangakuHoseiIchiranEntity entity;
    private static final RString 種別日本人 = new RString("1");
    private static final RString 種別外国人 = new RString("2");
    private static final RString 度 = new RString("度");
    private static final RString LINE = new RString(" ～ ");

    /**
     * コンストラクタです
     *
     * @param entity GassanJikofutangakuHoseiIchiranEntity
     */
    public GassanJikofutangakuHoseiIchiranBodyEditor(
            GassanJikofutangakuHoseiIchiranEntity entity) {
        this.entity = entity;
    }

    @Override
    public GassanJikofutangakuHoseiIchiranSource edit(
            GassanJikofutangakuHoseiIchiranSource source) {
        if (null == entity) {
            return source;
        }
        edit明細(source);
        edit出力項目(source);
        setPageBreakEmpty(source);
        return source;
    }

    private void edit明細(GassanJikofutangakuHoseiIchiranSource source) {
        source.listList1_1 = getColumnValue(entity.get被保険者番号());
        source.listList1_2 = entity.get被保険者氏名();
        if (entity.get生年月日() != null
                && 種別日本人.equals(entity.get宛名ﾃﾞｰﾀ種別())) {
            source.listList1_3 = entity.get生年月日().wareki().toDateString();
        } else if (entity.get生年月日() != null
                && 種別外国人.equals(entity.get宛名ﾃﾞｰﾀ種別())) {
            source.listList1_3 = entity.get生年月日().seireki().toDateString();
        }
        if (Seibetsu.男.getコード().equals(entity.get性別())) {
            source.listList1_4 = Seibetsu.男.get名称();
        } else if (Seibetsu.女.getコード().equals(entity.get性別())) {
            source.listList1_4 = Seibetsu.女.get名称();
        }
        source.listList1_5 = entity.get申請書整理番号();
        if (entity.get申請対象年度() != null) {
            source.listList1_6 = entity.get申請対象年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(度);
        } else {
            source.listList1_6 = RString.EMPTY;
        }
        if (entity.get介護加入期間開始() != null
                && entity.get介護加入期間終了() != null) {
            RString 介護加入期間開始 = getパターン4(entity.get介護加入期間開始());
            RString 介護加入期間終了 = getパターン4(entity.get介護加入期間終了());
            source.listList1_7 = 介護加入期間開始.concat(LINE).concat(介護加入期間終了);
        }
        source.listList1_8 = get共通ポリシー金額1(entity.get補正前_自己負担額());
        source.listList1_9 = get共通ポリシー金額1(entity.get補正前_70_74自己負担額());
        source.listList1_10 = get共通ポリシー金額1(entity.get補正前_高額支給額());
        source.listList1_11 = get共通ポリシー金額1(entity.get補正後_自己負担額());
        source.listList1_12 = get共通ポリシー金額1(entity.get補正後_70_74自己負担額());
        source.listList1_13 = get共通ポリシー金額1(entity.get補正後_高額支給額());
        source.listList1_14 = entity.get負担額補正有無();
        source.listList1_15 = entity.get支給額補正有無();
        source.listList1_16 = entity.get警告();
        source.listList1_17 = entity.get警告2();
    }

    private void edit出力項目(GassanJikofutangakuHoseiIchiranSource source) {
        source.add_choikiCode = getColumnValue(entity.get町域コード());
        source.add_gyoseikuCode = getColumnValue(entity.get行政区コード());
        source.add_hokenshaNo = getColumnValue(entity.get証記載保険者番号());
        source.add_kanaMeisho = getColumnValue(entity.get氏名５０音カナ());
        source.add_shichosonCode = getColumnValue(entity.get市町村コード());
        if (entity.get申請年月日() != null && !entity.get申請年月日().isEmpty()) {
            source.add_shinnseiYMD = new RString(entity.get申請年月日().toString());
        } else {
            source.add_shinnseiYMD = RString.EMPTY;
        }
        source.add_yubinNo = getColumnValue(entity.get郵便番号());
    }

    private RString get共通ポリシー金額1(Decimal 金額) {
        if (null == 金額) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private static RString getパターン4(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private void setPageBreakEmpty(GassanJikofutangakuHoseiIchiranSource source) {
        if (source.listList1_5 == null) {
            source.listList1_5 = RString.EMPTY;
        }
        if (entity.get申請書整理番号() == null) {
            entity.set申請書整理番号(RString.EMPTY);
        }
        if (entity.get被保険者番号() == null) {
            entity.set被保険者番号(HihokenshaNo.EMPTY);
        }
        if (entity.get申請対象年度() == null) {
            entity.set申請対象年度(FlexibleYear.EMPTY);
        }
    }
}
