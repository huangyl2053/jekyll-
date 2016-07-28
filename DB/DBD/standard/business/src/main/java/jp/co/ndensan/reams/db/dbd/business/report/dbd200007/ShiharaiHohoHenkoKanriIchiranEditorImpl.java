/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200007;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.KingakuUnit;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 支払方法変更管理リストEditorクラスです。
 *
 * @reamsid_L DBD-3630-050 liangbc
 */
public class ShiharaiHohoHenkoKanriIchiranEditorImpl implements IShiharaiHohoHenkoKanriIchiranEditor {

    private final RDateTime 作成日時;
    private final HokenshaNo 保険者番号;
    private final RString 保険者名称;
    private final IOutputOrder 出力順;
    private final ShiharaiHohoHenkoEntity 支払方法変更リストEntity;
    private final int count;
    private static final RString 作成 = new RString("作成");
    private static final RString タイトル = new RString("支払方法変更管理リスト");
    private static final RString ホシ = new RString("*");
    private static final RString 左括弧 = new RString("＜");
    private static final RString 右括弧 = new RString("度保険料＞");
    private static final int ITEM1 = 0;
    private static final int ITEM2 = 1;
    private static final int ITEM3 = 2;
    private static final int ITEM4 = 3;
    private static final int ITEM5 = 4;
    private static final int 行数1 = 1;
    private static final int 行数2 = 2;
    private static final int 行数3 = 3;
    private static final int 行数4 = 4;
    private static final int 行数5 = 5;
    private static final int 行数6 = 6;
    private static final int 行数7 = 7;
    private static final int 行数8 = 8;
    private static final int 行数9 = 9;
    private static final int 行数10 = 10;
    private static final int 行数11 = 11;
    private static final int 行数12 = 12;
    private static final int 行数13 = 13;
    private static final int 行数14 = 14;
    private static final int 行数15 = 15;
    private static final int 行数16 = 16;
    private static final int 行数17 = 17;

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 作成日時
     * @param 保険者番号 保険者番号
     * @param 保険者名称 保険者名称
     * @param 出力順 出力順
     * @param 支払方法変更リストEntity 支払方法変更リストEntity
     * @param count 印刷回数
     */
    protected ShiharaiHohoHenkoKanriIchiranEditorImpl(RDateTime 作成日時,
            HokenshaNo 保険者番号,
            RString 保険者名称,
            IOutputOrder 出力順,
            ShiharaiHohoHenkoEntity 支払方法変更リストEntity,
            int count) {
        this.作成日時 = 作成日時;
        this.保険者名称 = 保険者名称;
        this.保険者番号 = 保険者番号;
        this.出力順 = 出力順;
        this.支払方法変更リストEntity = 支払方法変更リストEntity;
        this.count = count;
    }

    @Override
    public ShiharaiHohoHenkoKanriIchiranReportSource edit(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (count == 1) {
            source = editHeader(source);
        }
        source = edit上部の被保険者情報(source);
        source = edit下部の被保険者情報(source);
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource editHeader(
            ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.printTimeStamp = new RStringBuilder()
                .append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString())
                .append(RString.FULL_SPACE)
                .append(作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒))
                .append(RString.FULL_SPACE)
                .append(作成).toRString();
        source.title = タイトル;
        source.hokenshaNo = 保険者番号.value();
        source.hokenshaName = 保険者名称;
        ISetSortItem 出力順Item1 = 出力順.get設定項目リスト().get(ITEM1);
        ISetSortItem 出力順Item2 = 出力順.get設定項目リスト().get(ITEM2);
        ISetSortItem 出力順Item3 = 出力順.get設定項目リスト().get(ITEM3);
        ISetSortItem 出力順Item4 = 出力順.get設定項目リスト().get(ITEM4);
        ISetSortItem 出力順Item5 = 出力順.get設定項目リスト().get(ITEM5);
        source.shutsuryokujun1 = OrderbyKey.toValue(出力順Item1.get項目ID()).getName();
        source.shutsuryokujun2 = OrderbyKey.toValue(出力順Item2.get項目ID()).getName();
        source.shutsuryokujun3 = OrderbyKey.toValue(出力順Item3.get項目ID()).getName();
        source.shutsuryokujun4 = OrderbyKey.toValue(出力順Item4.get項目ID()).getName();
        source.shutsuryokujun5 = OrderbyKey.toValue(出力順Item5.get項目ID()).getName();
        if (出力順Item1.is改頁項目()) {
            source.kaiPege1 = source.shutsuryokujun1;
        }
        if (出力順Item2.is改頁項目()) {
            source.kaiPege2 = source.shutsuryokujun2;
        }
        if (出力順Item3.is改頁項目()) {
            source.kaiPege3 = source.shutsuryokujun3;
        }
        if (出力順Item4.is改頁項目()) {
            source.kaiPege4 = source.shutsuryokujun4;
        }
        if (出力順Item5.is改頁項目()) {
            source.kaiPege5 = source.shutsuryokujun5;
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の被保険者情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (count == 1) {
            source = edit上部の宛名情報(source);
            source = edit上部の資格情報(source);
            source = edit上部の認定情報(source);
            source = edit上部の償還未払い情報(source);
            source = edit上部の滞納管理情報(source);
            source = edit上部の収納情報_過年度(source);
        }
        source = edit上部の滞納者対策情報(source);
        if (count <= 行数15) {
            source = edit上部の収納情報(source);
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の宛名情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.listUpper1_1 = 支払方法変更リストEntity.get被保険者番号().value();
        source.listUpper2_1 = 支払方法変更リストEntity.get識別コード().value();
        source.listUpper1_2 = 支払方法変更リストEntity.get被保険者氏名カナ();
        source.listUpper2_2 = 支払方法変更リストEntity.get被保険者氏名();
        source.listUpper1_3 = 支払方法変更リストEntity.get世帯番号().value();
        source.listUpper1_4 = 支払方法変更リストEntity.get行政区ｺｰﾄﾞ().value();
        source.listUpper2_3 = 支払方法変更リストEntity.get行政区();
        source.listUpper2_4 = 支払方法変更リストEntity.get住所コード().value();
        source.listUpper2_5 = 支払方法変更リストEntity.get郵便番号().getEditedYubinNo();
        source.listUpper2_6 = 支払方法変更リストEntity.get住所();
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の資格情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.listUpper1_5 = 支払方法変更リストEntity.get資格取得日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper1_6 = 支払方法変更リストEntity.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper1_7 = 支払方法変更リストEntity.get喪失事由().get名称();
        source.listUpper1_8 = 支払方法変更リストEntity.get資格区分().get名称();
        if (1 == 支払方法変更リストEntity.get住特フラグ()) {
            source.listUpper1_9 = ホシ;
        }
        source.listUpper1_10 = 支払方法変更リストEntity.get生保();
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の認定情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.listUpper1_11 = 支払方法変更リストEntity.get要介護度();
        source.listUpper1_12 = 支払方法変更リストEntity.get認定有効期間();
        source.listUpper1_13 = 支払方法変更リストEntity.get認定情報_申請中();
        source.listUpper1_14 = 支払方法変更リストEntity.get申請日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper2_7 = 支払方法変更リストEntity.get認定日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の償還未払い情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.listUpper2_8 = 支払方法変更リストEntity.get償還未払い情報_申請中();
        source.listUpper2_9 = 支払方法変更リストEntity.get償還未払い情報_申請日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper1_15 = new RString(支払方法変更リストEntity.get申請中件数());
        source.listUpper2_10 = 支払方法変更リストEntity.get整理番号().value();
        source.listUpper2_11 = 支払方法変更リストEntity.get提供年月().wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        source.listUpper2_12 = new RString(支払方法変更リストEntity.get未通知件数());
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の滞納管理情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.kanriJokyoUpper = 支払方法変更リストEntity.get滞納管理状況().get名称();
        source.kanriEndUpper = 支払方法変更リストEntity.get終了状況().get名称();
        source.saichoKikanUpper = new RString(支払方法変更リストEntity.get最長滞納期間());
        source.izenTainogakuUpper = new RString(
                KingakuFormatter.create(支払方法変更リストEntity.get以前滞納額()).format(KingakuUnit.円).setCommaSeparated().toString());
        source.izenKbnUpper = 支払方法変更リストEntity.get以前滞納区分().get名称();
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の滞納者対策情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        switch (count) {
            case 行数1:
                source.listUpper6_1 = 支払方法変更リストEntity.get適用開始日_1行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数2:
                source.listUpper6_1 = 支払方法変更リストEntity.get適用終了日_2行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数3:
                source.listUpper6_1 = 支払方法変更リストEntity.get終了受付日_3行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数4:
                source.listUpper6_1 = 支払方法変更リストEntity.get予告発行日_4行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数5:
                source.listUpper6_1 = 支払方法変更リストEntity.get弁明期限_5行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数6:
                source.listUpper6_1 = 支払方法変更リストEntity.get弁明受付日_6行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数7:
                source.listUpper6_1 = 支払方法変更リストEntity.get償還発行日_7行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数8:
                source.listUpper6_1 = 支払方法変更リストEntity.get償還証期限_8行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数9:
                source.listUpper6_1 = new RString(支払方法変更リストEntity.get差止中件数_9行目());
                break;
            case 行数10:
                source.listUpper6_1 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get差止中金額_10行目())
                        .format(KingakuUnit.円).setCommaSeparated().toString());
                break;
            case 行数11:
                source.listUpper6_1 = 支払方法変更リストEntity.get差止納付期日_11行目().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数12:
                source.listUpper6_1 = new RString(支払方法変更リストEntity.get控除件数_12行目());
                break;
            case 行数13:
                source.listUpper6_1 = 支払方法変更リストEntity.get控除証期限_13行目().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                break;
            case 行数14:
                source.listUpper6_1 = 支払方法変更リストEntity.get行14();
                break;
            case 行数15:
                source.listUpper6_1 = 支払方法変更リストEntity.get行15();
                break;
            case 行数16:
                source.listUpper6_1 = 支払方法変更リストEntity.get行16();
                break;
            case 行数17:
                source.listUpper6_1 = 支払方法変更リストEntity.get行17();
                break;
            default:
                break;
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の収納情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (count == 1) {
            source.nendoUpper1 = new RStringBuilder()
                    .append(左括弧)
                    .append(支払方法変更リストEntity.get日付関連_調定年度().minusYear(2).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                            .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                    .append(右括弧).toRString();
            source.nendoUpper2 = new RStringBuilder()
                    .append(左括弧)
                    .append(支払方法変更リストEntity.get日付関連_調定年度().minusYear(1).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                            .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                    .append(右括弧).toRString();
            source.nendoUpper3 = new RStringBuilder()
                    .append(左括弧)
                    .append(支払方法変更リストEntity.get日付関連_調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                            .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                    .append(右括弧).toRString();
            source.hokenryogakuGokeiUpper1 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get保険料額合計1()).format(KingakuUnit.円)
                    .setCommaSeparated().toString());
            source.tainogakuGokeiUpper1 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get滞納額合計1()).format(KingakuUnit.円)
                    .setCommaSeparated().toString());
            source.hokenryogakuGokeiUpper2 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get保険料額合計2()).format(KingakuUnit.円)
                    .setCommaSeparated().toString());
            source.hokenryogakuGokeiUpper3 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get保険料額合計3()).format(KingakuUnit.円)
                    .setCommaSeparated().toString());
            source.tainogakuGokeiUpper2 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get滞納額合計2()).format(KingakuUnit.円)
                    .setCommaSeparated().toString());
            source.tainogakuGokeiUpper3 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get滞納額合計3()).format(KingakuUnit.円)
                    .setCommaSeparated().toString());
        }
        source.listUpper3_1 = new RString(支払方法変更リストEntity.get年度1の期別().get(count - 1));
        source.listUpper3_2 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get年度1の保険料金().get(count - 1)).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.listUpper3_3 = 支払方法変更リストEntity.get年度1の納期限().get(count - 1).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper3_4 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get年度1の滞納額().get(count - 1)).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.listUpper3_5 = 支払方法変更リストEntity.get年度1の滞納区分().get(count - 1).get名称();
        source.listUpper3_6 = 支払方法変更リストEntity.get年度1の時効起算日().get(count - 1).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper3_7 = 支払方法変更リストEntity.get年度1の時効起算事由().get(count - 1);
        source.listUpper4_1 = new RString(支払方法変更リストEntity.get年度2の期別().get(count - 1));
        source.listUpper4_2 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get年度2の保険料金().get(count - 1)).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.listUpper4_3 = 支払方法変更リストEntity.get年度2の納期限().get(count - 1).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper4_4 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get年度2の滞納額().get(count - 1)).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.listUpper4_5 = 支払方法変更リストEntity.get年度2の滞納区分().get(count - 1).get名称();
        source.listUpper4_6 = 支払方法変更リストEntity.get年度2の時効起算日().get(count - 1).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper4_7 = 支払方法変更リストEntity.get年度2の時効起算事由().get(count - 1);
        source.listUpper5_1 = new RString(支払方法変更リストEntity.get年度3の期別().get(count - 1));
        source.listUpper5_2 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get年度3の保険料金().get(count - 1)).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.listUpper5_3 = 支払方法変更リストEntity.get年度3の納期限().get(count - 1).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper5_4 = new RString(KingakuFormatter.create(支払方法変更リストEntity.get年度3の滞納額().get(count - 1)).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.listUpper5_5 = 支払方法変更リストEntity.get年度3の滞納区分().get(count - 1).get名称();
        source.listUpper5_6 = 支払方法変更リストEntity.get年度3の時効起算日().get(count - 1).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper5_7 = 支払方法変更リストEntity.get年度3の時効起算事由().get(count - 1);
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の収納情報_過年度(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        //TODO
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の被保険者情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (count == 1) {
            source = edit下部の宛名情報(source);
            source = edit下部の資格情報(source);
            source = edit下部の認定情報(source);
            source = edit下部の償還未払い情報(source);
            source = edit下部の滞納管理情報(source);
            source = edit下部の収納情報_過年度(source);
        }
        source = edit下部の滞納者対策情報(source);
        if (count <= 行数15) {
            source = edit下部の収納情報(source);
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の宛名情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {

        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の資格情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {

        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の認定情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {

        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の償還未払い情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {

        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の滞納管理情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {

        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の滞納者対策情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {

        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の収納情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {

        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の収納情報_過年度(ShiharaiHohoHenkoKanriIchiranReportSource source) {

        return source;
    }

    /**
     * 支払方法変更管理リストの改頁出力順
     */
    enum OrderbyKey {

        郵便番号("0001", "郵便番号"),
        町域コード("0002", "町域コード"),
        行政区コード("0004", "行政区コード"),
        世帯コード("0008", "世帯コード"),
        識別コード("0009", "識別コード"),
        氏名５０音カナ("0010", "氏名５０音カナ"),
        市町村コード("0016", "市町村コード"),
        被保険者番号("0104", "被保険者番号");

        private final RString code;
        private final RString name;

        OrderbyKey(String code, String name) {
            this.code = new RString(code);
            this.name = new RString(name);
        }

        protected RString getCode() {
            return code;
        }

        protected RString getName() {
            return name;
        }

        /**
         * 改頁出力順のコードと一致する内容を探します。
         *
         * @param code 改頁出力順のコード
         * @return {@code code} に対応する改頁出力順
         */
        protected static OrderbyKey toValue(RString code) {

            for (OrderbyKey orderbyKey : OrderbyKey.values()) {
                if (orderbyKey.code.equals(code)) {
                    return orderbyKey;
                }
            }
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("改頁出力順"));
        }
    }
}
