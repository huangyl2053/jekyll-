/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200007;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TainoKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShunoKibetsuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShunoNendoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.KingakuUnit;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 支払方法変更管理リストEditorクラスです。
 *
 * @reamsid_L DBD-3630-050 xuyue
 */
public class ShiharaiHohoHenkoKanriIchiranEditorImpl implements IShiharaiHohoHenkoKanriIchiranEditor {

    private final RDateTime 作成日時;
    private final HokenshaNo 保険者番号;
    private final RString 保険者名称;
    private final IOutputOrder 出力順;
    private final ShiharaiHohoHenkoEntity 支払方法変更リストEntity_上;
    private final ShiharaiHohoHenkoEntity 支払方法変更リストEntity_下;
    private final int count;
    private static final RString 作成 = new RString("作成");
    private static final RString タイトル = new RString("支払方法変更管理リスト");
    private static final RString ホシ = new RString("*");
    private static final RString 左括弧 = new RString("＜");
    private static final RString 右括弧 = new RString("度保険料＞");
    private static final RString 収納情報なし = new RString("1");
    private static final RString 収納情報なし文字 = new RString("収　納　情　報　な　し");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
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
    private static final int NUM19 = 19;
    private static final int NUM20 = 20;

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 作成日時
     * @param 保険者番号 保険者番号
     * @param 保険者名称 保険者名称
     * @param 出力順 出力順
     * @param 支払方法変更リストEntity_上 支払方法変更リストEntity_上
     * @param 支払方法変更リストEntity_下 支払方法変更リストEntity_下
     * @param count 印刷回数
     */
    protected ShiharaiHohoHenkoKanriIchiranEditorImpl(RDateTime 作成日時,
            HokenshaNo 保険者番号,
            RString 保険者名称,
            IOutputOrder 出力順,
            ShiharaiHohoHenkoEntity 支払方法変更リストEntity_上, ShiharaiHohoHenkoEntity 支払方法変更リストEntity_下,
            int count) {
        this.作成日時 = 作成日時;
        this.保険者名称 = 保険者名称;
        this.保険者番号 = 保険者番号;
        this.出力順 = 出力順;
        this.支払方法変更リストEntity_上 = 支払方法変更リストEntity_上;
        this.支払方法変更リストEntity_下 = 支払方法変更リストEntity_下;
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

    private ShiharaiHohoHenkoKanriIchiranReportSource editHeader(ShiharaiHohoHenkoKanriIchiranReportSource source) {
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

        // TODO QA 95838
        List<ISetSortItem> list = new ArrayList<>();
        if (出力順 != null && 出力順.get設定項目リスト() == null) {
            list = 出力順.get設定項目リスト();
        }
        if (list.size() > INDEX_0) {
            source.shutsuryokujun1 = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1) {
            source.shutsuryokujun2 = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2) {
            source.shutsuryokujun3 = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3) {
            source.shutsuryokujun4 = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4) {
            source.shutsuryokujun5 = list.get(INDEX_4).get項目名();
        }
        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            source.kaiPege1 = list.get(0).get項目名();
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            source.kaiPege2 = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            source.kaiPege3 = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            source.kaiPege4 = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            source.kaiPege5 = list.get(INDEX_4).get項目名();
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
            source = edit上部の合計(source);
            if (収納情報なし.equals(支払方法変更リストEntity_上.get収納情報なし())) {
                source.shunonashiUpper = 収納情報なし文字;
            }
        }
        if (count <= 行数17) {
            source = edit上部の滞納者対策情報(source);
            source = edit上部の収納情報(source);
        }
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
            source = edit下部の合計(source);
            if (収納情報なし.equals(支払方法変更リストEntity_下.get収納情報なし())) {
                source.shunonashiLower = 収納情報なし文字;
            }
        }
        if (count <= 行数17) {
            source = edit下部の滞納者対策情報(source);
            source = edit下部の収納情報(source);
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の宛名情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (支払方法変更リストEntity_上.get被保険者番号() != null) {
            source.listUpper1_1 = 支払方法変更リストEntity_上.get被保険者番号().value();
        }
        if (支払方法変更リストEntity_上.get識別コード() != null) {
            source.listUpper2_1 = 支払方法変更リストEntity_上.get識別コード().value();
        }
        source.listUpper1_2 = 支払方法変更リストEntity_上.get被保険者氏名カナ();
        source.listUpper2_2 = 支払方法変更リストEntity_上.get被保険者氏名();
        if (支払方法変更リストEntity_上.get世帯番号() != null) {
            source.listUpper1_3 = 支払方法変更リストEntity_上.get世帯番号().value();
        }
        if (支払方法変更リストEntity_上.get行政区ｺｰﾄﾞ() != null) {
            source.listUpper1_4 = 支払方法変更リストEntity_上.get行政区ｺｰﾄﾞ().value();
        }
        source.listUpper2_3 = 支払方法変更リストEntity_上.get行政区();
        if (支払方法変更リストEntity_上.get住所コード() != null) {
            source.listUpper2_4 = 支払方法変更リストEntity_上.get住所コード().value();
        }
        if (支払方法変更リストEntity_上.get郵便番号() != null) {
            source.listUpper2_5 = 支払方法変更リストEntity_上.get郵便番号().getEditedYubinNo();
        }
        source.listUpper2_6 = edit住所(支払方法変更リストEntity_上.get住所());
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の資格情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (支払方法変更リストEntity_上.get資格取得日() != null) {
            source.listUpper1_5 = 支払方法変更リストEntity_上.get資格取得日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (支払方法変更リストEntity_上.get資格喪失日() != null) {
            source.listUpper1_6 = 支払方法変更リストEntity_上.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (支払方法変更リストEntity_上.get喪失事由() != null) {
            source.listUpper1_7 = 支払方法変更リストEntity_上.get喪失事由().get名称();
        }
        if (支払方法変更リストEntity_上.get資格区分() != null) {
            source.listUpper1_8 = 支払方法変更リストEntity_上.get資格区分().get名称();
        }
        if (1 == 支払方法変更リストEntity_上.get住特フラグ()) {
            source.listUpper1_9 = ホシ;
        }
        source.listUpper1_10 = 支払方法変更リストEntity_上.get生保();
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の認定情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.listUpper1_11 = 支払方法変更リストEntity_上.get要介護度();
        source.listUpper1_12 = 支払方法変更リストEntity_上.get認定有効期間();
        source.listUpper1_13 = 支払方法変更リストEntity_上.get認定情報_申請中();
        if (支払方法変更リストEntity_上.get申請日() != null) {
            source.listUpper1_14 = 支払方法変更リストEntity_上.get申請日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (支払方法変更リストEntity_上.get認定日() != null) {
            source.listUpper2_7 = 支払方法変更リストEntity_上.get認定日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の償還未払い情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.listUpper2_8 = 支払方法変更リストEntity_上.get償還未払い情報_申請中();
        if (支払方法変更リストEntity_上.get償還未払い情報_申請日() != null) {
            source.listUpper2_9 = 支払方法変更リストEntity_上.get償還未払い情報_申請日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.listUpper1_15 = 支払方法変更リストEntity_上.get申請中件数();
        if (支払方法変更リストEntity_上.get整理番号() != null) {
            source.listUpper2_10 = 支払方法変更リストEntity_上.get整理番号().value();
        }
        if (支払方法変更リストEntity_上.get提供年月() != null) {
            source.listUpper2_11 = 支払方法変更リストEntity_上.get提供年月().wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.listUpper2_12 = 支払方法変更リストEntity_上.get未通知件数();
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の滞納管理情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (支払方法変更リストEntity_上.get滞納管理状況() != null) {
            source.kanriJokyoUpper = 支払方法変更リストEntity_上.get滞納管理状況().get名称();
        }
        if (支払方法変更リストEntity_上.get終了状況() != null) {
            source.kanriEndUpper = 支払方法変更リストEntity_上.get終了状況().get名称();
        }
        source.saichoKikanUpper = 支払方法変更リストEntity_上.get最長滞納期間();
        if (支払方法変更リストEntity_上.get以前滞納額() != null) {
            source.izenTainogakuUpper = new RString(
                    KingakuFormatter.create(支払方法変更リストEntity_上.get以前滞納額()).format(KingakuUnit.円).setCommaSeparated().toString());
        }
        if (支払方法変更リストEntity_上.get以前滞納区分() != null) {
            source.izenKbnUpper = 支払方法変更リストEntity_上.get以前滞納区分().get名称();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の滞納者対策情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        edit上部の滞納者対策情報１To８(source);
        if (count == 行数9) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get差止中件数_9行目();

        } else if (count == 行数10 && 支払方法変更リストEntity_上.get差止中金額_10行目() != null) {
            source.listUpper6_1 = new RString(KingakuFormatter.create(支払方法変更リストEntity_上.get差止中金額_10行目())
                    .format(KingakuUnit.円).setCommaSeparated().toString());

        } else if (count == 行数11 && 支払方法変更リストEntity_上.get差止納付期日_11行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get差止納付期日_11行目().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数12) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get控除件数_12行目();

        } else if (count == 行数13 && 支払方法変更リストEntity_上.get控除証期限_13行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get控除証期限_13行目().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (count == 行数14) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get行14();
        } else if (count == 行数15) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get行15();
        } else if (count == 行数16) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get行16();
        } else if (count == 行数17) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get行17();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の滞納者対策情報１To８(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (count == 行数1 && 支払方法変更リストEntity_上.get適用開始日_1行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get適用開始日_1行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数2 && 支払方法変更リストEntity_上.get適用終了日_2行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get適用終了日_2行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数3 && 支払方法変更リストEntity_上.get終了受付日_3行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get終了受付日_3行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数4 && 支払方法変更リストEntity_上.get予告発行日_4行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get予告発行日_4行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数5 && 支払方法変更リストEntity_上.get弁明期限_5行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get弁明期限_5行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数6 && 支払方法変更リストEntity_上.get弁明受付日_6行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get弁明受付日_6行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数7 && 支払方法変更リストEntity_上.get償還発行日_7行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get償還発行日_7行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数8 && 支払方法変更リストEntity_上.get償還証期限_8行目() != null) {
            source.listUpper6_1 = 支払方法変更リストEntity_上.get償還証期限_8行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の収納情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (count == 1) {
            if (支払方法変更リストEntity_上.get日付関連_調定年度() != null) {
                source.nendoUpper1 = new RStringBuilder()
                        .append(左括弧)
                        .append(支払方法変更リストEntity_上.get日付関連_調定年度().minusYear(2).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                        .append(右括弧).toRString();
                source.nendoUpper2 = new RStringBuilder()
                        .append(左括弧)
                        .append(支払方法変更リストEntity_上.get日付関連_調定年度().minusYear(1).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                        .append(右括弧).toRString();
                source.nendoUpper3 = new RStringBuilder()
                        .append(左括弧)
                        .append(支払方法変更リストEntity_上.get日付関連_調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                        .append(右括弧).toRString();
            }
        }

        edit上部_年度１の期(source);
        edit上部_年度２の期(source);
        edit上部_年度３の期(source);
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部_年度１の期(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        ShunoNendoEntity 年度１の収納 = new ShunoNendoEntity();
        if (支払方法変更リストEntity_上.get収納情報List() != null && 支払方法変更リストEntity_上.get収納情報List().size() > 0) {
            年度１の収納 = 支払方法変更リストEntity_上.get収納情報List().get(0);
        }
        if (年度１の収納.get期別情報() != null && 年度１の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度１の期 = 年度１の収納.get期別情報().get(count - 1);
            source.listUpper3_1 = 年度１の期.get期別();
            if (年度１の期.get保険料金() != null) {
                source.listUpper3_2 = new RString(KingakuFormatter.create(年度１の期.get保険料金()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            if (年度１の期.get納期限() != null) {
                source.listUpper3_3 = 年度１の期.get納期限().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (年度１の期.get滞納額() != null) {
                source.listUpper3_4 = new RString(KingakuFormatter.create(年度１の期.get滞納額()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            source.listUpper3_5 = get滞納区分の記号(年度１の期.get滞納区分());
            if (年度１の期.get時効起算日() != null) {
                source.listUpper3_6 = 年度１の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.listUpper3_7 = 年度１の期.get時効起算事由();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部_年度２の期(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        ShunoNendoEntity 年度２の収納 = new ShunoNendoEntity();
        if (支払方法変更リストEntity_上.get収納情報List() != null && 支払方法変更リストEntity_上.get収納情報List().size() > 1) {
            年度２の収納 = 支払方法変更リストEntity_上.get収納情報List().get(1);
        }
        if (年度２の収納.get期別情報() != null && 年度２の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度２の期 = 年度２の収納.get期別情報().get(count - 1);
            source.listUpper4_1 = 年度２の期.get期別();
            if (年度２の期.get保険料金() != null) {
                source.listUpper4_2 = new RString(KingakuFormatter.create(年度２の期.get保険料金()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            if (年度２の期.get納期限() != null) {
                source.listUpper4_3 = 年度２の期.get納期限().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (年度２の期.get滞納額() != null) {
                source.listUpper4_4 = new RString(KingakuFormatter.create(年度２の期.get滞納額()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            source.listUpper4_5 = get滞納区分の記号(年度２の期.get滞納区分());
            if (年度２の期.get時効起算日() != null) {
                source.listUpper4_6 = 年度２の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.listUpper4_7 = 年度２の期.get時効起算事由();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部_年度３の期(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        ShunoNendoEntity 年度３の収納 = new ShunoNendoEntity();
        if (支払方法変更リストEntity_上.get収納情報List() != null && 支払方法変更リストEntity_上.get収納情報List().size() > 2) {
            年度３の収納 = 支払方法変更リストEntity_上.get収納情報List().get(2);
        }
        if (年度３の収納.get期別情報() != null && 年度３の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度３の期 = 年度３の収納.get期別情報().get(count - 1);
            source.listUpper5_1 = 年度３の期.get期別();
            if (年度３の期.get保険料金() != null) {
                source.listUpper5_2 = new RString(KingakuFormatter.create(年度３の期.get保険料金()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            if (年度３の期.get納期限() != null) {
                source.listUpper5_3 = 年度３の期.get納期限().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (年度３の期.get滞納額() != null) {
                source.listUpper5_4 = new RString(KingakuFormatter.create(年度３の期.get滞納額()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            source.listUpper5_5 = get滞納区分の記号(年度３の期.get滞納区分());
            if (年度３の期.get時効起算日() != null) {
                source.listUpper5_6 = 年度３の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.listUpper5_7 = 年度３の期.get時効起算事由();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の合計(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        ShunoNendoEntity 年度１の収納 = new ShunoNendoEntity();
        ShunoNendoEntity 年度２の収納 = new ShunoNendoEntity();
        ShunoNendoEntity 年度３の収納 = new ShunoNendoEntity();
        List<ShunoNendoEntity> 収納情報List = 支払方法変更リストEntity_上.get収納情報List();
        if (収納情報List == null) {
            収納情報List = new ArrayList<>();
        }
        if (収納情報List.size() > 0) {
            年度１の収納 = 収納情報List.get(0);
        }
        if (収納情報List.size() > 1) {
            年度２の収納 = 収納情報List.get(1);
        }
        if (収納情報List.size() > 2) {
            年度３の収納 = 収納情報List.get(2);
        }
        Decimal 保険料額合計１ = Decimal.ZERO;
        Decimal 滞納額合計１ = Decimal.ZERO;
        Decimal 保険料額合計２ = Decimal.ZERO;
        Decimal 滞納額合計２ = Decimal.ZERO;
        Decimal 保険料額合計３ = Decimal.ZERO;
        Decimal 滞納額合計３ = Decimal.ZERO;
        if (年度１の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度１の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計１ = 保険料額合計１.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計１ = 滞納額合計１.add(期別情報.get滞納額());
                }
            }
        }
        if (年度２の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度２の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計２ = 保険料額合計１.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計２ = 滞納額合計１.add(期別情報.get滞納額());
                }
            }
        }
        if (年度３の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度３の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計３ = 保険料額合計３.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計３ = 滞納額合計３.add(期別情報.get滞納額());
                }
            }
        }

        source.hokenryogakuGokeiUpper1 = new RString(KingakuFormatter.create(保険料額合計１).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.tainogakuGokeiUpper1 = new RString(KingakuFormatter.create(滞納額合計１).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.hokenryogakuGokeiUpper2 = new RString(KingakuFormatter.create(保険料額合計２).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.tainogakuGokeiUpper2 = new RString(KingakuFormatter.create(滞納額合計２).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.hokenryogakuGokeiUpper3 = new RString(KingakuFormatter.create(保険料額合計３).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.tainogakuGokeiUpper3 = new RString(KingakuFormatter.create(滞納額合計３).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit上部の収納情報_過年度(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        //TODO #89884
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の宛名情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (支払方法変更リストEntity_下.get被保険者番号() != null) {
            source.listLower1_1 = 支払方法変更リストEntity_下.get被保険者番号().value();
        }
        if (支払方法変更リストEntity_下.get識別コード() != null) {
            source.listLower2_1 = 支払方法変更リストEntity_下.get識別コード().value();
        }
        source.listLower1_2 = 支払方法変更リストEntity_下.get被保険者氏名カナ();
        source.listLower2_2 = 支払方法変更リストEntity_下.get被保険者氏名();
        if (支払方法変更リストEntity_下.get世帯番号() != null) {
            source.listLower1_3 = 支払方法変更リストEntity_下.get世帯番号().value();
        }
        if (支払方法変更リストEntity_下.get行政区ｺｰﾄﾞ() != null) {
            source.listLower1_4 = 支払方法変更リストEntity_下.get行政区ｺｰﾄﾞ().value();
        }
        source.listLower2_3 = 支払方法変更リストEntity_下.get行政区();
        if (支払方法変更リストEntity_下.get住所コード() != null) {
            source.listLower2_4 = 支払方法変更リストEntity_下.get住所コード().value();
        }
        if (支払方法変更リストEntity_下.get郵便番号() != null) {
            source.listLower2_5 = 支払方法変更リストEntity_下.get郵便番号().getEditedYubinNo();
        }
        source.listLower2_6 = edit住所(支払方法変更リストEntity_下.get住所());
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の資格情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (支払方法変更リストEntity_下.get資格取得日() != null) {
            source.listLower1_5 = 支払方法変更リストEntity_下.get資格取得日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (支払方法変更リストEntity_下.get資格喪失日() != null) {
            source.listLower1_6 = 支払方法変更リストEntity_下.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (支払方法変更リストEntity_下.get喪失事由() != null) {
            source.listLower1_7 = 支払方法変更リストEntity_下.get喪失事由().get名称();
        }
        if (支払方法変更リストEntity_下.get資格区分() != null) {
            source.listLower1_8 = 支払方法変更リストEntity_下.get資格区分().get名称();
        }
        if (1 == 支払方法変更リストEntity_下.get住特フラグ()) {
            source.listUpper1_9 = ホシ;
        }
        source.listUpper1_10 = 支払方法変更リストEntity_下.get生保();
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の認定情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.listLower1_11 = 支払方法変更リストEntity_下.get要介護度();
        source.listLower1_12 = 支払方法変更リストEntity_下.get認定有効期間();
        source.listLower1_13 = 支払方法変更リストEntity_下.get認定情報_申請中();
        if (支払方法変更リストEntity_下.get申請日() != null) {
            source.listLower1_14 = 支払方法変更リストEntity_下.get申請日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (支払方法変更リストEntity_下.get認定日() != null) {
            source.listLower2_7 = 支払方法変更リストEntity_下.get認定日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の償還未払い情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        source.listLower2_8 = 支払方法変更リストEntity_下.get償還未払い情報_申請中();
        if (支払方法変更リストEntity_下.get償還未払い情報_申請日() != null) {
            source.listLower2_9 = 支払方法変更リストEntity_下.get償還未払い情報_申請日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.listLower1_15 = 支払方法変更リストEntity_上.get申請中件数();
        if (支払方法変更リストEntity_下.get整理番号() != null) {
            source.listLower2_10 = 支払方法変更リストEntity_下.get整理番号().value();
        }
        if (支払方法変更リストEntity_下.get提供年月() != null) {
            source.listLower2_11 = 支払方法変更リストEntity_下.get提供年月().wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.listLower2_12 = 支払方法変更リストEntity_下.get未通知件数();
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の滞納管理情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (支払方法変更リストEntity_下.get滞納管理状況() != null) {
            source.kanriJokyoLower = 支払方法変更リストEntity_下.get滞納管理状況().get名称();
        }
        if (支払方法変更リストEntity_下.get終了状況() != null) {
            source.kanriEndLower = 支払方法変更リストEntity_下.get終了状況().get名称();
        }
        source.saichoKikanLower = 支払方法変更リストEntity_下.get最長滞納期間();
        if (支払方法変更リストEntity_下.get以前滞納額() != null) {
            source.izenTainogakuLower = new RString(
                    KingakuFormatter.create(支払方法変更リストEntity_下.get以前滞納額()).format(KingakuUnit.円).setCommaSeparated().toString());
        }
        if (支払方法変更リストEntity_下.get以前滞納区分() != null) {
            source.izenKbnLower = 支払方法変更リストEntity_下.get以前滞納区分().get名称();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の滞納者対策情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        edit下部の滞納者対策情報１To８(source);
        if (count == 行数9) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get差止中件数_9行目();

        } else if (count == 行数10 && 支払方法変更リストEntity_下.get差止中金額_10行目() != null) {
            source.listLower6_1 = new RString(KingakuFormatter.create(支払方法変更リストEntity_下.get差止中金額_10行目())
                    .format(KingakuUnit.円).setCommaSeparated().toString());

        } else if (count == 行数11 && 支払方法変更リストEntity_下.get差止納付期日_11行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get差止納付期日_11行目().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数12) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get控除件数_12行目();

        } else if (count == 行数13 && 支払方法変更リストEntity_下.get控除証期限_13行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get控除証期限_13行目().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (count == 行数14) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get行14();
        } else if (count == 行数15) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get行15();
        } else if (count == 行数16) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get行16();
        } else if (count == 行数17) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get行17();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の滞納者対策情報１To８(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (count == 行数1 && 支払方法変更リストEntity_下.get適用開始日_1行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get適用開始日_1行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数2 && 支払方法変更リストEntity_下.get適用終了日_2行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get適用終了日_2行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数3 && 支払方法変更リストEntity_下.get終了受付日_3行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get終了受付日_3行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数4 && 支払方法変更リストEntity_下.get予告発行日_4行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get予告発行日_4行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数5 && 支払方法変更リストEntity_下.get弁明期限_5行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get弁明期限_5行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数6 && 支払方法変更リストEntity_下.get弁明受付日_6行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get弁明受付日_6行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数7 && 支払方法変更リストEntity_下.get償還発行日_7行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get償還発行日_7行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        } else if (count == 行数8 && 支払方法変更リストEntity_下.get償還証期限_8行目() != null) {
            source.listLower6_1 = 支払方法変更リストEntity_下.get償還証期限_8行目().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の収納情報(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        if (count == 1) {
            if (支払方法変更リストEntity_下.get日付関連_調定年度() != null) {
                source.nendoLower1 = new RStringBuilder()
                        .append(左括弧)
                        .append(支払方法変更リストEntity_下.get日付関連_調定年度().minusYear(2).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                        .append(右括弧).toRString();
                source.nendoLower2 = new RStringBuilder()
                        .append(左括弧)
                        .append(支払方法変更リストEntity_下.get日付関連_調定年度().minusYear(1).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                        .append(右括弧).toRString();
                source.nendoLower3 = new RStringBuilder()
                        .append(左括弧)
                        .append(支払方法変更リストEntity_下.get日付関連_調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString())
                        .append(右括弧).toRString();
            }
        }
        edit下部_年度１の期(source);
        edit下部_年度２の期(source);
        edit下部_年度３の期(source);
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部_年度１の期(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        ShunoNendoEntity 年度１の収納 = new ShunoNendoEntity();
        if (支払方法変更リストEntity_下.get収納情報List() != null && 支払方法変更リストEntity_下.get収納情報List().size() > 0) {
            年度１の収納 = 支払方法変更リストEntity_下.get収納情報List().get(0);
        }
        if (年度１の収納.get期別情報() != null && 年度１の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度１の期 = 年度１の収納.get期別情報().get(count - 1);
            source.listLower3_1 = 年度１の期.get期別();
            if (年度１の期.get保険料金() != null) {
                source.listLower3_2 = new RString(KingakuFormatter.create(年度１の期.get保険料金()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            if (年度１の期.get納期限() != null) {
                source.listLower3_3 = 年度１の期.get納期限().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (年度１の期.get滞納額() != null) {
                source.listLower3_4 = new RString(KingakuFormatter.create(年度１の期.get滞納額()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            source.listLower3_5 = get滞納区分の記号(年度１の期.get滞納区分());
            if (年度１の期.get時効起算日() != null) {
                source.listLower3_6 = 年度１の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.listLower3_7 = 年度１の期.get時効起算事由();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部_年度２の期(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        ShunoNendoEntity 年度２の収納 = new ShunoNendoEntity();
        if (支払方法変更リストEntity_下.get収納情報List() != null && 支払方法変更リストEntity_下.get収納情報List().size() > 1) {
            年度２の収納 = 支払方法変更リストEntity_下.get収納情報List().get(1);
        }
        if (年度２の収納.get期別情報() != null && 年度２の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度２の期 = 年度２の収納.get期別情報().get(count - 1);
            source.listLower4_1 = 年度２の期.get期別();
            if (年度２の期.get保険料金() != null) {
                source.listLower4_2 = new RString(KingakuFormatter.create(年度２の期.get保険料金()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            if (年度２の期.get納期限() != null) {
                source.listLower4_3 = 年度２の期.get納期限().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (年度２の期.get滞納額() != null) {
                source.listLower4_4 = new RString(KingakuFormatter.create(年度２の期.get滞納額()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            source.listLower4_5 = get滞納区分の記号(年度２の期.get滞納区分());
            if (年度２の期.get時効起算日() != null) {
                source.listLower4_6 = 年度２の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.listLower4_7 = 年度２の期.get時効起算事由();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部_年度３の期(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        ShunoNendoEntity 年度３の収納 = new ShunoNendoEntity();
        if (支払方法変更リストEntity_下.get収納情報List() != null && 支払方法変更リストEntity_下.get収納情報List().size() > 2) {
            年度３の収納 = 支払方法変更リストEntity_下.get収納情報List().get(2);
        }

        if (年度３の収納.get期別情報() != null && 年度３の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度３の期 = 年度３の収納.get期別情報().get(count - 1);
            source.listLower5_1 = 年度３の期.get期別();
            if (年度３の期.get保険料金() != null) {
                source.listLower5_2 = new RString(KingakuFormatter.create(年度３の期.get保険料金()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            if (年度３の期.get納期限() != null) {
                source.listLower5_3 = 年度３の期.get納期限().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (年度３の期.get滞納額() != null) {
                source.listLower5_4 = new RString(KingakuFormatter.create(年度３の期.get滞納額()).format(KingakuUnit.円)
                        .setCommaSeparated().toString());
            }
            source.listLower5_5 = get滞納区分の記号(年度３の期.get滞納区分());
            if (年度３の期.get時効起算日() != null) {
                source.listLower5_6 = 年度３の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.listLower5_7 = 年度３の期.get時効起算事由();
        }
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の合計(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        ShunoNendoEntity 年度１の収納 = new ShunoNendoEntity();
        ShunoNendoEntity 年度２の収納 = new ShunoNendoEntity();
        ShunoNendoEntity 年度３の収納 = new ShunoNendoEntity();
        List<ShunoNendoEntity> 収納情報List = 支払方法変更リストEntity_下.get収納情報List();
        if (収納情報List == null) {
            収納情報List = new ArrayList<>();
        }
        if (収納情報List.size() > 0) {
            年度１の収納 = 収納情報List.get(0);
        }
        if (収納情報List.size() > 1) {
            年度２の収納 = 収納情報List.get(1);
        }
        if (収納情報List.size() > 2) {
            年度３の収納 = 収納情報List.get(2);
        }
        Decimal 保険料額合計１ = Decimal.ZERO;
        Decimal 滞納額合計１ = Decimal.ZERO;
        Decimal 保険料額合計２ = Decimal.ZERO;
        Decimal 滞納額合計２ = Decimal.ZERO;
        Decimal 保険料額合計３ = Decimal.ZERO;
        Decimal 滞納額合計３ = Decimal.ZERO;
        if (年度１の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度１の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計１ = 保険料額合計１.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計１ = 滞納額合計１.add(期別情報.get滞納額());
                }
            }
        }
        if (年度２の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度２の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計２ = 保険料額合計１.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計２ = 滞納額合計１.add(期別情報.get滞納額());
                }
            }
        }
        if (年度３の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度３の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計３ = 保険料額合計３.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計３ = 滞納額合計３.add(期別情報.get滞納額());
                }
            }
        }

        source.hokenryogakuGokeiLower1 = new RString(KingakuFormatter.create(保険料額合計１).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.tainogakuGokeiLower1 = new RString(KingakuFormatter.create(滞納額合計１).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.hokenryogakuGokeiLower2 = new RString(KingakuFormatter.create(保険料額合計２).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.tainogakuGokeiLower2 = new RString(KingakuFormatter.create(滞納額合計２).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.hokenryogakuGokeiLower3 = new RString(KingakuFormatter.create(保険料額合計３).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        source.tainogakuGokeiLower3 = new RString(KingakuFormatter.create(滞納額合計３).format(KingakuUnit.円)
                .setCommaSeparated().toString());
        return source;
    }

    private ShiharaiHohoHenkoKanriIchiranReportSource edit下部の収納情報_過年度(ShiharaiHohoHenkoKanriIchiranReportSource source) {
        //TODO #89884
        return source;
    }

    private RString get滞納区分の記号(TainoKubun 滞納区分) {
        if (TainoKubun.時効成立.equals(滞納区分)) {
            return new RString("名称");
        } else if (TainoKubun.最古滞納期.equals(滞納区分)) {
            return new RString("●");
        } else if (TainoKubun.滞納期.equals(滞納区分)) {
            return new RString("○");
        } else if (TainoKubun.納期限未到来.equals(滞納区分)) {
            return new RString("未");
        }
        return RString.EMPTY;
    }

    private RString edit住所(RString 住所) {
        if (住所 != null && 住所.length() > NUM20) {
            住所 = 住所.substring(0, NUM19).concat(ホシ);
        }
        return 住所;
    }

}
