/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200008;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.HihokenshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.KyufuGengakuHaakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.ShunoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.ShunoKibetsuEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付額減額把握リストEditorです。
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
public class KyufuGengakuHaakuIchiranEditor implements IKyufuGengakuHaakuIchiranEditor {

    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int LISTINDEX_5 = 5;
    private static final int LISTINDEX_6 = 6;
    private static final int LISTINDEX_7 = 7;
    private static final int LISTINDEX_8 = 8;
    private static final int LISTINDEX_9 = 9;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_19 = 19;
    private static final int NUM_20 = 20;
    private static final RString ホシ = new RString("*");
    private static final RString 作成 = new RString("作成");
    private static final RString タイトル = new RString("給付額減額把握リスト");
    private static final RString 申請中 = new RString("申請中");
    private static final RString 度保険料 = new RString("度保険料>");
    private static final RString 括弧レフト = new RString("<");
    private static final RString 収納情報なし = new RString("収　納　情　報　な　し");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString 記号1 = new RString("●");
    private static final RString 記号2 = new RString("○");
    private static final RString 記号3 = new RString("△");
    private static final RString 記号4 = new RString("未");

    private final RDateTime 作成日時;
    private final HokenshaNo 保険者番号;
    private final RString 保険者名称;
    private final KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity;
    private final IOutputOrder iOutputOrder;
    private final int count;

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 作成日時
     * @param 保険者番号 保険者番号
     * @param 保険者名称 保険者名称
     * @param 給付額減額把握リストEntity KyufuGengakuHaakuIchiranEntity
     * @param iOutputOrder IOutputOrder
     * @param count 印刷回数
     */
    protected KyufuGengakuHaakuIchiranEditor(RDateTime 作成日時, HokenshaNo 保険者番号, RString 保険者名称,
            KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity, IOutputOrder iOutputOrder, int count) {
        this.作成日時 = 作成日時;
        this.保険者名称 = 保険者名称;
        this.保険者番号 = 保険者番号;
        this.給付額減額把握リストEntity = 給付額減額把握リストEntity;
        this.iOutputOrder = iOutputOrder;
        this.count = count;
    }

    @Override
    public KyufuGengakuHaakuIchiranReportSource edit(KyufuGengakuHaakuIchiranReportSource source) {
        editHeader(source);
        edit被保険者情報(source);
        edit収納情報(source);
//        edit減額対象情報(source);
        return source;
    }

    private void editHeader(KyufuGengakuHaakuIchiranReportSource source) {
        source.printTimeStamp = new RStringBuilder()
                .append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString())
                .append(RString.FULL_SPACE)
                .append(作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒))
                .append(RString.FULL_SPACE)
                .append(作成).toRString();
        source.title = タイトル;
        //TODO バッチに「保険者番号」と「保険者名称」がないです。
        if (this.保険者番号 != null) {
            source.hokenshaNo = this.保険者番号.value();
        }
        if (this.保険者名称 != null) {
            source.hokenshaName = this.保険者名称;
        }
        if (this.iOutputOrder != null
                && (this.iOutputOrder.get設定項目リスト() != null && !this.iOutputOrder.get設定項目リスト().isEmpty())) {
            List<ISetSortItem> 設定項目リスト = this.iOutputOrder.get設定項目リスト();
            set出力順改頁(source, 設定項目リスト);
        }
    }

    private KyufuGengakuHaakuIchiranReportSource edit被保険者情報(KyufuGengakuHaakuIchiranReportSource source) {
        source = edit宛名情報(source);
        source = edit資格情報(source);
        source = edit認定情報(source);
        source = edit減額対象最新情報(source);
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit宛名情報(KyufuGengakuHaakuIchiranReportSource source) {
        if (給付額減額把握リストEntity.get被保険者情報Entity() != null) {
            HihokenshaJohoEntity 被保険者情報Entity = 給付額減額把握リストEntity.get被保険者情報Entity();
            if (被保険者情報Entity.get被保険者番号() != null) {
                source.listUpper1_1 = 被保険者情報Entity.get被保険者番号();
            }
            if (被保険者情報Entity.get識別コード() != null) {
                source.listUpper2_1 = 被保険者情報Entity.get識別コード();
            }
            source.listUpper1_2 = 被保険者情報Entity.get被保険者氏名カナ();
            source.listUpper2_2 = 被保険者情報Entity.get被保険者氏名();
            if (被保険者情報Entity.get世帯番号() != null) {
                source.listUpper1_3 = 被保険者情報Entity.get世帯番号();
            }
            source.listUpper1_4 = 被保険者情報Entity.get行政区ｺｰﾄﾞ();
            source.listUpper2_3 = 被保険者情報Entity.get行政区();
            source.listUpper2_4 = 被保険者情報Entity.get住所コード();
            if (被保険者情報Entity.get郵便番号() != null) {
                source.listUpper2_5 = 被保険者情報Entity.get郵便番号();
            }
            if (被保険者情報Entity.get住所() != null && 被保険者情報Entity.get住所().length() <= NUM_20) {
                source.listUpper2_6 = 被保険者情報Entity.get住所();
            }
            if (被保険者情報Entity.get住所() != null && 被保険者情報Entity.get住所().length() > NUM_20) {
                source.listUpper2_6 = 被保険者情報Entity.get住所().substring(0, NUM_19).concat(new RString("*"));
            }
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit資格情報(KyufuGengakuHaakuIchiranReportSource source) {
        if (給付額減額把握リストEntity.get被保険者情報Entity() != null) {
            HihokenshaJohoEntity 被保険者情報Entity = 給付額減額把握リストEntity.get被保険者情報Entity();
            if (被保険者情報Entity.get資格取得日() != null) {
                source.listUpper1_5 = 被保険者情報Entity.get資格取得日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (被保険者情報Entity.get資格喪失日() != null) {
                source.listUpper1_6 = 被保険者情報Entity.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (被保険者情報Entity.get喪失事由() != null) {
                source.listUpper1_7 = 被保険者情報Entity.get喪失事由();
            }
            if (被保険者情報Entity.get資格区分() != null) {
                source.listUpper1_8 = 被保険者情報Entity.get資格区分();
            }
            source.listUpper1_9 = 被保険者情報Entity.get住特フラグ();
            if (被保険者情報Entity.is生保フラグ()) {
                source.listUpper1_10 = ホシ;
            }
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit認定情報(KyufuGengakuHaakuIchiranReportSource source) {
        if (給付額減額把握リストEntity.get被保険者情報Entity() != null) {
            HihokenshaJohoEntity 被保険者情報Entity = 給付額減額把握リストEntity.get被保険者情報Entity();
            source.listUpper1_11 = get要介護度();
            if (被保険者情報Entity.get認定有効期間開始年月日() != null && 被保険者情報Entity.get認定有効期間終了年月日() != null) {
                RString 認定有効期間開始年月日 = 被保険者情報Entity.get認定有効期間開始年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                RString 認定有効期間終了年月日 = 被保険者情報Entity.get認定有効期間終了年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                source.listUpper1_12 = 認定有効期間開始年月日.concat("~").concat(認定有効期間終了年月日);
            }
            if (被保険者情報Entity.get認定日() != null) {
                source.listUpper2_7 = 被保険者情報Entity.get認定日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (被保険者情報Entity.is申請中フラグ()) {
                source.listUpper2_8 = 申請中;
            }
            if (被保険者情報Entity.get申請日() != null) {
                source.listUpper2_9 = 被保険者情報Entity.get申請日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit減額対象最新情報(KyufuGengakuHaakuIchiranReportSource source) {
        if (給付額減額把握リストEntity.get被保険者情報Entity() != null) {
            HihokenshaJohoEntity 被保険者情報Entity = 給付額減額把握リストEntity.get被保険者情報Entity();
            if (被保険者情報Entity.get徴収権消滅期間() != null) {
                source.shometsuKikan = 被保険者情報Entity.get徴収権消滅期間();
            }
            if (被保険者情報Entity.get納付済み期間() != null) {
                source.nofusumiKikan = 被保険者情報Entity.get納付済み期間();
            }
            if (被保険者情報Entity.get給付額減額期間() != null) {
                source.gengakuKikan = 被保険者情報Entity.get給付額減額期間();
            }
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit収納情報(KyufuGengakuHaakuIchiranReportSource source) {
        List<ShunoJohoEntity> 収納情報リスト = this.給付額減額把握リストEntity.get収納情報リスト();
        for (int shunoIndex = 0; shunoIndex < 収納情報リスト.size(); shunoIndex++) {
            //TODO QA
//            RString 特徴普徴区分 = 収納情報リスト.get(shunoIndex).get特徴普徴区分();
//            if (TokuchoFuchoKubun.特別徴収.get名称().equals(特徴普徴区分)) {
//
//            }
//            if (TokuchoFuchoKubun.普通徴収.get名称().equals(特徴普徴区分)) {
//
//            }
            if (!収納情報リスト.isEmpty()) {
                get賦課年度(source, 収納情報リスト);
            }
            edit年度1の期(source, 収納情報リスト);
            edit年度2の期(source, 収納情報リスト);
            edit年度3の期(source, 収納情報リスト);
            edit年度4の期(source, 収納情報リスト);
            edit年度5の期(source, 収納情報リスト);
            edit年度6の期(source, 収納情報リスト);
            edit年度7の期(source, 収納情報リスト);
            edit年度8の期(source, 収納情報リスト);
            edit年度9の期(source, 収納情報リスト);
            edit年度10の期(source, 収納情報リスト);
            get合計1(source);
            get合計2(source);
            get合計3(source);
            get合計4(source);
            get合計5(source);
            get収納情報なし1(source, 収納情報リスト);
            get収納情報なし2(source, 収納情報リスト);
        }
        return source;
    }

    private void get賦課年度(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        if (count == 1) {
            if (!収納情報リスト.isEmpty()) {
                source.nendoUpper1 = 括弧レフト.concat(収納情報リスト.get(0).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > 1) {
                source.nendoUpper2 = 括弧レフト.concat(収納情報リスト.get(1).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > 2) {
                source.nendoUpper3 = 括弧レフト.concat(収納情報リスト.get(2).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > NUM_3) {
                source.nendoUpper4 = 括弧レフト.concat(収納情報リスト.get(LISTINDEX_3).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > NUM_4) {
                source.nendoUpper5 = 括弧レフト.concat(収納情報リスト.get(LISTINDEX_4).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > NUM_5) {
                source.nendoLower1 = 括弧レフト.concat(収納情報リスト.get(LISTINDEX_5).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > NUM_6) {
                source.nendoLower2 = 括弧レフト.concat(収納情報リスト.get(LISTINDEX_6).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > NUM_7) {
                source.nendoLower3 = 括弧レフト.concat(収納情報リスト.get(LISTINDEX_7).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > NUM_8) {
                source.nendoLower4 = 括弧レフト.concat(収納情報リスト.get(LISTINDEX_8).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
            if (収納情報リスト.size() > NUM_9) {
                source.nendoLower5 = 括弧レフト.concat(収納情報リスト.get(LISTINDEX_9).get賦課年度().wareki().
                        eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString()).concat(度保険料);
            }
        }
    }

    private void edit年度1の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度1の収納 = new ShunoJohoEntity();
        if (!収納情報リスト.isEmpty()) {
            年度1の収納 = 収納情報リスト.get(0);
        }
        if (年度1の収納.get期別情報() != null && 年度1の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度1の期 = 年度1の収納.get期別情報().get(count - 1);
            source.listNendoBun1_1 = 年度1の期.get期別();
            if (年度1の期.get保険料金() != null) {
                source.listNendoBun1_2 = DecimalFormatter.toコンマ区切りRString(年度1の期.get保険料金(), 0);
            }
            if (年度1の期.get滞納額() != null) {
                source.listNendoBun1_3 = DecimalFormatter.toコンマ区切りRString(年度1の期.get滞納額(), 0);
            }
            if (年度1の期.get滞納区分() != null) {
                edit年度1の滞納区分(source, 年度1の期);
            }
            if (年度1の期.get時効起算日() != null) {
                source.listNendoBun1_5 = 年度1の期.get時効起算日().wareki().toDateString();
            }
            if (年度1の期.get時効起算事由() != null) {
                RString 年度1時効起算事由 = 年度1の期.get時効起算事由();
                RString 年度1時効起算事由名称 = RString.EMPTY;
                年度1時効起算事由名称 = JikoKisanbiKubun.toValue(年度1時効起算事由).get記号();
                source.listNendoBun1_6 = 年度1時効起算事由名称;
            }
        }
    }

    private void edit年度2の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度2の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > 1) {
            年度2の収納 = 収納情報リスト.get(1);
        }
        if (年度2の収納.get期別情報() != null && 年度2の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度2の期 = 年度2の収納.get期別情報().get(count - 1);
            source.listNendoBun2_1 = 年度2の期.get期別();
            if (年度2の期.get保険料金() != null) {
                source.listNendoBun2_2 = DecimalFormatter.toコンマ区切りRString(年度2の期.get保険料金(), 0);
            }
            if (年度2の期.get滞納額() != null) {
                source.listNendoBun2_3 = DecimalFormatter.toコンマ区切りRString(年度2の期.get滞納額(), 0);
            }
            if (年度2の期.get滞納区分() != null) {
                edit年度2の滞納区分(source, 年度2の期);
            }
            if (年度2の期.get時効起算日() != null) {
                source.listNendoBun2_5 = 年度2の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度2の期.get時効起算事由() != null) {
                RString 年度2時効起算事由 = 年度2の期.get時効起算事由();
                RString 年度2時効起算事由名称 = RString.EMPTY;
                年度2時効起算事由名称 = JikoKisanbiKubun.toValue(年度2時効起算事由).get記号();
                source.listNendoBun2_6 = 年度2時効起算事由名称;
            }
        }
    }

    private void edit年度3の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度3の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > 2) {
            年度3の収納 = 収納情報リスト.get(2);
        }
        if (年度3の収納.get期別情報() != null && 年度3の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度3の期 = 年度3の収納.get期別情報().get(count - 1);
            source.listNendoBun3_1 = 年度3の期.get期別();
            if (年度3の期.get保険料金() != null) {
                source.listNendoBun3_2 = DecimalFormatter.toコンマ区切りRString(年度3の期.get保険料金(), 0);
            }
            if (年度3の期.get滞納額() != null) {
                source.listNendoBun3_3 = DecimalFormatter.toコンマ区切りRString(年度3の期.get滞納額(), 0);
            }
            if (年度3の期.get滞納区分() != null) {
                edit年度3の滞納区分(source, 年度3の期);
            }
            if (年度3の期.get時効起算日() != null) {
                source.listNendoBun3_5 = 年度3の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度3の期.get時効起算事由() != null) {
                RString 年度3時効起算事由 = 年度3の期.get時効起算事由();
                RString 年度3時効起算事由名称 = RString.EMPTY;
                年度3時効起算事由名称 = JikoKisanbiKubun.toValue(年度3時効起算事由).get記号();
                source.listNendoBun3_6 = 年度3時効起算事由名称;
            }
        }
    }

    private void edit年度4の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度4の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > NUM_3) {
            年度4の収納 = 収納情報リスト.get(LISTINDEX_3);
        }
        if (年度4の収納.get期別情報() != null && 年度4の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度4の期 = 年度4の収納.get期別情報().get(count - 1);
            source.listNendoBun4_1 = 年度4の期.get期別();
            if (年度4の期.get保険料金() != null) {
                source.listNendoBun4_2 = DecimalFormatter.toコンマ区切りRString(年度4の期.get保険料金(), 0);
            }
            if (年度4の期.get滞納額() != null) {
                source.listNendoBun4_3 = DecimalFormatter.toコンマ区切りRString(年度4の期.get滞納額(), 0);
            }
            if (年度4の期.get滞納区分() != null) {
                edit年度4の滞納区分(source, 年度4の期);
            }
            if (年度4の期.get時効起算日() != null) {
                source.listNendoBun4_5 = 年度4の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度4の期.get時効起算事由() != null) {
                RString 年度4時効起算事由 = 年度4の期.get時効起算事由();
                RString 年度4時効起算事由名称 = RString.EMPTY;
                年度4時効起算事由名称 = JikoKisanbiKubun.toValue(年度4時効起算事由).get記号();
                source.listNendoBun4_6 = 年度4時効起算事由名称;
            }
        }
    }

    private void edit年度5の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度5の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > NUM_4) {
            年度5の収納 = 収納情報リスト.get(LISTINDEX_4);
        }
        if (年度5の収納.get期別情報() != null && 年度5の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度5の期 = 年度5の収納.get期別情報().get(count - 1);
            source.listNendoBun5_1 = 年度5の期.get期別();
            if (年度5の期.get保険料金() != null) {
                source.listNendoBun5_2 = DecimalFormatter.toコンマ区切りRString(年度5の期.get保険料金(), 0);
            }
            if (年度5の期.get滞納額() != null) {
                source.listNendoBun5_3 = DecimalFormatter.toコンマ区切りRString(年度5の期.get滞納額(), 0);
            }
            if (年度5の期.get滞納区分() != null) {
                edit年度5の滞納区分(source, 年度5の期);
            }
            if (年度5の期.get時効起算日() != null) {
                source.listNendoBun5_5 = 年度5の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度5の期.get時効起算事由() != null) {
                RString 年度5時効起算事由 = 年度5の期.get時効起算事由();
                RString 年度5時効起算事由名称 = RString.EMPTY;
                年度5時効起算事由名称 = JikoKisanbiKubun.toValue(年度5時効起算事由).get記号();
                source.listNendoBun5_6 = 年度5時効起算事由名称;
            }
        }
    }

    private void edit年度6の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度6の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > NUM_5) {
            年度6の収納 = 収納情報リスト.get(LISTINDEX_5);
        }
        if (年度6の収納.get期別情報() != null && 年度6の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度6の期 = 年度6の収納.get期別情報().get(count - 1);
            source.listNendoBun6_1 = 年度6の期.get期別();
            if (年度6の期.get保険料金() != null) {
                source.listNendoBun6_2 = DecimalFormatter.toコンマ区切りRString(年度6の期.get保険料金(), 0);
            }
            if (年度6の期.get滞納額() != null) {
                source.listNendoBun6_3 = DecimalFormatter.toコンマ区切りRString(年度6の期.get滞納額(), 0);
            }
            if (年度6の期.get滞納区分() != null) {
                edit年度6の滞納区分(source, 年度6の期);
            }
            if (年度6の期.get時効起算日() != null) {
                source.listNendoBun6_5 = 年度6の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度6の期.get時効起算事由() != null) {
                RString 年度6時効起算事由 = 年度6の期.get時効起算事由();
                RString 年度6時効起算事由名称 = RString.EMPTY;
                年度6時効起算事由名称 = JikoKisanbiKubun.toValue(年度6時効起算事由).get記号();
                source.listNendoBun6_6 = 年度6時効起算事由名称;
            }
        }
    }

    private void edit年度7の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度7の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > NUM_6) {
            年度7の収納 = 収納情報リスト.get(LISTINDEX_6);
        }
        if (年度7の収納.get期別情報() != null && 年度7の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度7の期 = 年度7の収納.get期別情報().get(count - 1);
            source.listNendoBun7_1 = 年度7の期.get期別();
            if (年度7の期.get保険料金() != null) {
                source.listNendoBun7_2 = DecimalFormatter.toコンマ区切りRString(年度7の期.get保険料金(), 0);
            }
            if (年度7の期.get滞納額() != null) {
                source.listNendoBun7_3 = DecimalFormatter.toコンマ区切りRString(年度7の期.get滞納額(), 0);
            }
            if (年度7の期.get滞納区分() != null) {
                edit年度7の滞納区分(source, 年度7の期);
            }
            if (年度7の期.get時効起算日() != null) {
                source.listNendoBun7_5 = 年度7の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度7の期.get時効起算事由() != null) {
                RString 年度7時効起算事由 = 年度7の期.get時効起算事由();
                RString 年度7時効起算事由名称 = RString.EMPTY;
                年度7時効起算事由名称 = JikoKisanbiKubun.toValue(年度7時効起算事由).get記号();
                source.listNendoBun7_6 = 年度7時効起算事由名称;
            }
        }
    }

    private void edit年度8の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度8の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > NUM_7) {
            年度8の収納 = 収納情報リスト.get(LISTINDEX_7);
        }
        if (年度8の収納.get期別情報() != null && 年度8の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度8の期 = 年度8の収納.get期別情報().get(count - 1);
            source.listNendoBun8_1 = 年度8の期.get期別();
            if (年度8の期.get保険料金() != null) {
                source.listNendoBun8_2 = DecimalFormatter.toコンマ区切りRString(年度8の期.get保険料金(), 0);
            }
            if (年度8の期.get滞納額() != null) {
                source.listNendoBun8_3 = DecimalFormatter.toコンマ区切りRString(年度8の期.get滞納額(), 0);
            }
            if (年度8の期.get滞納区分() != null) {
                edit年度8の滞納区分(source, 年度8の期);
            }
            if (年度8の期.get時効起算日() != null) {
                source.listNendoBun8_5 = 年度8の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度8の期.get時効起算事由() != null) {
                RString 年度8時効起算事由 = 年度8の期.get時効起算事由();
                RString 年度8時効起算事由名称 = RString.EMPTY;
                年度8時効起算事由名称 = JikoKisanbiKubun.toValue(年度8時効起算事由).get記号();
                source.listNendoBun8_6 = 年度8時効起算事由名称;
            }
        }
    }

    private void edit年度9の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度9の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > NUM_8) {
            年度9の収納 = 収納情報リスト.get(LISTINDEX_8);
        }
        if (年度9の収納.get期別情報() != null && 年度9の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度9の期 = 年度9の収納.get期別情報().get(count - 1);
            source.listNendoBun9_1 = 年度9の期.get期別();
            if (年度9の期.get保険料金() != null) {
                source.listNendoBun9_2 = DecimalFormatter.toコンマ区切りRString(年度9の期.get保険料金(), 0);
            }
            if (年度9の期.get滞納額() != null) {
                source.listNendoBun9_3 = DecimalFormatter.toコンマ区切りRString(年度9の期.get滞納額(), 0);
            }
            if (年度9の期.get滞納区分() != null) {
                edit年度9の滞納区分(source, 年度9の期);
            }
            if (年度9の期.get時効起算日() != null) {
                source.listNendoBun9_5 = 年度9の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度9の期.get時効起算事由() != null) {
                RString 年度9時効起算事由 = 年度9の期.get時効起算事由();
                RString 年度9時効起算事由名称 = RString.EMPTY;
                年度9時効起算事由名称 = JikoKisanbiKubun.toValue(年度9時効起算事由).get記号();
                source.listNendoBun9_6 = 年度9時効起算事由名称;
            }
        }
    }

    private void edit年度10の期(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        ShunoJohoEntity 年度10の収納 = new ShunoJohoEntity();
        if (収納情報リスト != null && 収納情報リスト.size() > NUM_9) {
            年度10の収納 = 収納情報リスト.get(LISTINDEX_9);
        }
        if (年度10の収納.get期別情報() != null && 年度10の収納.get期別情報().size() > count - 1) {
            ShunoKibetsuEntity 年度10の期 = 年度10の収納.get期別情報().get(count - 1);
            source.listNendoBun10_1 = 年度10の期.get期別();
            if (年度10の期.get保険料金() != null) {
                source.listNendoBun10_2 = DecimalFormatter.toコンマ区切りRString(年度10の期.get保険料金(), 0);
            }
            if (年度10の期.get滞納額() != null) {
                source.listNendoBun10_3 = DecimalFormatter.toコンマ区切りRString(年度10の期.get滞納額(), 0);
            }
            if (年度10の期.get滞納区分() != null) {
                edit年度10の滞納区分(source, 年度10の期);
            }
            if (年度10の期.get時効起算日() != null) {
                source.listNendoBun10_5 = 年度10の期.get時効起算日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (年度10の期.get時効起算事由() != null) {
                RString 年度10時効起算事由 = 年度10の期.get時効起算事由();
                RString 年度10時効起算事由名称 = RString.EMPTY;
                年度10時効起算事由名称 = JikoKisanbiKubun.toValue(年度10時効起算事由).get記号();
                source.listNendoBun10_6 = 年度10時効起算事由名称;
            }
        }
    }

    private void get合計1(KyufuGengakuHaakuIchiranReportSource source) {
        ShunoJohoEntity 年度1の収納 = new ShunoJohoEntity();
        ShunoJohoEntity 年度2の収納 = new ShunoJohoEntity();
        List<ShunoJohoEntity> 収納情報リスト = this.給付額減額把握リストEntity.get収納情報リスト();
        if (収納情報リスト == null) {
            収納情報リスト = new ArrayList<>();
        }
        if (!収納情報リスト.isEmpty()) {
            年度1の収納 = 収納情報リスト.get(0);
        }
        if (収納情報リスト.size() > 1) {
            年度2の収納 = 収納情報リスト.get(1);
        }
        Decimal 保険料額合計1 = Decimal.ZERO;
        Decimal 滞納額合計1 = Decimal.ZERO;
        Decimal 総合計1 = Decimal.ZERO;
        Decimal 保険料額合計2 = Decimal.ZERO;
        Decimal 滞納額合計2 = Decimal.ZERO;
        Decimal 総合計2 = Decimal.ZERO;
        if (年度1の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度1の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計1 = 保険料額合計1.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計1 = 滞納額合計1.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計1 = 保険料額合計1.add(滞納額合計1);
                }
            }
        }
        if (年度2の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度2の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計2 = 保険料額合計2.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計2 = 滞納額合計2.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計2 = 保険料額合計2.add(滞納額合計2);
                }
            }
        }
        source.hokenryogakuGokei1 = DecimalFormatter.toコンマ区切りRString(保険料額合計1, 0);
        source.tainogakuGokei1 = DecimalFormatter.toコンマ区切りRString(滞納額合計1, 0);
        source.soGokei1 = DecimalFormatter.toコンマ区切りRString(総合計1, 0);
        source.hokenryogakuGokei2 = DecimalFormatter.toコンマ区切りRString(保険料額合計2, 0);
        source.tainogakuGokei2 = DecimalFormatter.toコンマ区切りRString(滞納額合計2, 0);
        source.soGokei2 = DecimalFormatter.toコンマ区切りRString(総合計2, 0);
    }

    private void get合計2(KyufuGengakuHaakuIchiranReportSource source) {
        ShunoJohoEntity 年度3の収納 = new ShunoJohoEntity();
        ShunoJohoEntity 年度4の収納 = new ShunoJohoEntity();
        List<ShunoJohoEntity> 収納情報リスト = this.給付額減額把握リストEntity.get収納情報リスト();
        if (収納情報リスト == null) {
            収納情報リスト = new ArrayList<>();
        }
        if (収納情報リスト.size() > 2) {
            年度3の収納 = 収納情報リスト.get(2);
        }
        if (収納情報リスト.size() > NUM_3) {
            年度4の収納 = 収納情報リスト.get(LISTINDEX_3);
        }
        Decimal 保険料額合計3 = Decimal.ZERO;
        Decimal 滞納額合計3 = Decimal.ZERO;
        Decimal 総合計3 = Decimal.ZERO;
        Decimal 保険料額合計4 = Decimal.ZERO;
        Decimal 滞納額合計4 = Decimal.ZERO;
        Decimal 総合計4 = Decimal.ZERO;
        if (年度3の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度3の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計3 = 保険料額合計3.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計3 = 滞納額合計3.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計3 = 保険料額合計3.add(滞納額合計3);
                }
            }
        }
        if (年度4の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度4の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計4 = 保険料額合計4.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計4 = 滞納額合計4.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計4 = 保険料額合計4.add(滞納額合計4);
                }
            }
        }
        source.hokenryogakuGokei3 = DecimalFormatter.toコンマ区切りRString(保険料額合計3, 0);
        source.tainogakuGokei3 = DecimalFormatter.toコンマ区切りRString(滞納額合計3, 0);
        source.soGokei3 = DecimalFormatter.toコンマ区切りRString(総合計3, 0);
        source.hokenryogakuGokei4 = DecimalFormatter.toコンマ区切りRString(保険料額合計4, 0);
        source.tainogakuGokei4 = DecimalFormatter.toコンマ区切りRString(滞納額合計4, 0);
        source.soGokei4 = DecimalFormatter.toコンマ区切りRString(総合計4, 0);
    }

    private void get合計3(KyufuGengakuHaakuIchiranReportSource source) {
        ShunoJohoEntity 年度5の収納 = new ShunoJohoEntity();
        ShunoJohoEntity 年度6の収納 = new ShunoJohoEntity();
        List<ShunoJohoEntity> 収納情報リスト = this.給付額減額把握リストEntity.get収納情報リスト();
        if (収納情報リスト == null) {
            収納情報リスト = new ArrayList<>();
        }
        if (収納情報リスト.size() > NUM_4) {
            年度5の収納 = 収納情報リスト.get(LISTINDEX_4);
        }
        if (収納情報リスト.size() > NUM_5) {
            年度6の収納 = 収納情報リスト.get(LISTINDEX_5);
        }
        Decimal 保険料額合計5 = Decimal.ZERO;
        Decimal 滞納額合計5 = Decimal.ZERO;
        Decimal 総合計5 = Decimal.ZERO;
        Decimal 保険料額合計6 = Decimal.ZERO;
        Decimal 滞納額合計6 = Decimal.ZERO;
        Decimal 総合計6 = Decimal.ZERO;
        if (年度5の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度5の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計5 = 保険料額合計5.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計5 = 滞納額合計5.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計5 = 保険料額合計5.add(滞納額合計5);
                }
            }
        }
        if (年度6の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度6の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計6 = 保険料額合計6.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計6 = 滞納額合計6.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計6 = 保険料額合計6.add(滞納額合計6);
                }
            }
        }
        source.hokenryogakuGokei5 = DecimalFormatter.toコンマ区切りRString(保険料額合計5, 0);
        source.tainogakuGokei5 = DecimalFormatter.toコンマ区切りRString(滞納額合計5, 0);
        source.soGokei5 = DecimalFormatter.toコンマ区切りRString(総合計5, 0);
        source.hokenryogakuGokei6 = DecimalFormatter.toコンマ区切りRString(保険料額合計6, 0);
        source.tainogakuGokei6 = DecimalFormatter.toコンマ区切りRString(滞納額合計6, 0);
        source.soGokei6 = DecimalFormatter.toコンマ区切りRString(総合計6, 0);
    }

    private void get合計4(KyufuGengakuHaakuIchiranReportSource source) {
        ShunoJohoEntity 年度7の収納 = new ShunoJohoEntity();
        ShunoJohoEntity 年度8の収納 = new ShunoJohoEntity();
        List<ShunoJohoEntity> 収納情報リスト = this.給付額減額把握リストEntity.get収納情報リスト();
        if (収納情報リスト == null) {
            収納情報リスト = new ArrayList<>();
        }
        if (収納情報リスト.size() > NUM_6) {
            年度7の収納 = 収納情報リスト.get(LISTINDEX_6);
        }
        if (収納情報リスト.size() > NUM_7) {
            年度8の収納 = 収納情報リスト.get(LISTINDEX_7);
        }
        Decimal 保険料額合計7 = Decimal.ZERO;
        Decimal 滞納額合計7 = Decimal.ZERO;
        Decimal 総合計7 = Decimal.ZERO;
        Decimal 保険料額合計8 = Decimal.ZERO;
        Decimal 滞納額合計8 = Decimal.ZERO;
        Decimal 総合計8 = Decimal.ZERO;
        if (年度7の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度7の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計7 = 保険料額合計7.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計7 = 滞納額合計7.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計7 = 保険料額合計7.add(滞納額合計7);
                }
            }
        }
        if (年度8の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度8の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計8 = 保険料額合計8.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計8 = 滞納額合計8.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計8 = 保険料額合計8.add(滞納額合計8);
                }
            }
        }
        source.hokenryogakuGokei7 = DecimalFormatter.toコンマ区切りRString(保険料額合計7, 0);
        source.tainogakuGokei7 = DecimalFormatter.toコンマ区切りRString(滞納額合計7, 0);
        source.soGokei7 = DecimalFormatter.toコンマ区切りRString(総合計7, 0);
        source.hokenryogakuGokei8 = DecimalFormatter.toコンマ区切りRString(保険料額合計8, 0);
        source.tainogakuGokei8 = DecimalFormatter.toコンマ区切りRString(滞納額合計8, 0);
        source.soGokei8 = DecimalFormatter.toコンマ区切りRString(総合計8, 0);
    }

    private void get合計5(KyufuGengakuHaakuIchiranReportSource source) {
        ShunoJohoEntity 年度9の収納 = new ShunoJohoEntity();
        ShunoJohoEntity 年度10の収納 = new ShunoJohoEntity();
        List<ShunoJohoEntity> 収納情報リスト = this.給付額減額把握リストEntity.get収納情報リスト();
        if (収納情報リスト == null) {
            収納情報リスト = new ArrayList<>();
        }
        if (収納情報リスト.size() > NUM_8) {
            年度9の収納 = 収納情報リスト.get(LISTINDEX_8);
        }
        if (収納情報リスト.size() > NUM_9) {
            年度10の収納 = 収納情報リスト.get(LISTINDEX_9);
        }
        Decimal 保険料額合計9 = Decimal.ZERO;
        Decimal 滞納額合計9 = Decimal.ZERO;
        Decimal 総合計9 = Decimal.ZERO;
        Decimal 保険料額合計10 = Decimal.ZERO;
        Decimal 滞納額合計10 = Decimal.ZERO;
        Decimal 総合計10 = Decimal.ZERO;
        if (年度9の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度9の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計9 = 保険料額合計9.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計9 = 滞納額合計9.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計9 = 保険料額合計9.add(滞納額合計9);
                }
            }
        }
        if (年度10の収納.get期別情報() != null) {
            for (ShunoKibetsuEntity 期別情報 : 年度10の収納.get期別情報()) {
                if (期別情報.get保険料金() != null) {
                    保険料額合計10 = 保険料額合計10.add(期別情報.get保険料金());
                }
                if (期別情報.get滞納額() != null) {
                    滞納額合計10 = 滞納額合計10.add(期別情報.get滞納額());
                }
                if (期別情報.get保険料金() != null && 期別情報.get滞納額() != null) {
                    総合計10 = 保険料額合計10.add(滞納額合計10);
                }
            }
        }
        source.hokenryogakuGokei9 = DecimalFormatter.toコンマ区切りRString(保険料額合計9, 0);
        source.tainogakuGokei9 = DecimalFormatter.toコンマ区切りRString(滞納額合計9, 0);
        source.soGokei9 = DecimalFormatter.toコンマ区切りRString(総合計9, 0);
        source.hokenryogakuGokei10 = DecimalFormatter.toコンマ区切りRString(保険料額合計10, 0);
        source.tainogakuGokei10 = DecimalFormatter.toコンマ区切りRString(滞納額合計10, 0);
        source.soGokei10 = DecimalFormatter.toコンマ区切りRString(総合計10, 0);
    }

    private void get収納情報なし1(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        if (!収納情報リスト.isEmpty() && 収納情報リスト.get(0).get収納情報なし().equals(ONE)) {
            source.shunonashiUpper1 = 収納情報なし;
        }
        if (収納情報リスト.size() > 1 && 収納情報リスト.get(1).get収納情報なし().equals(ONE)) {
            source.shunonashiUpper2 = 収納情報なし;
        }
        if (収納情報リスト.size() > 2 && 収納情報リスト.get(2).get収納情報なし().equals(ONE)) {
            source.shunonashiUpper3 = 収納情報なし;
        }
        if (収納情報リスト.size() > NUM_3 && 収納情報リスト.get(LISTINDEX_3).get収納情報なし().equals(ONE)) {
            source.shunonashiUpper4 = 収納情報なし;
        }
        if (収納情報リスト.size() > NUM_4 && 収納情報リスト.get(LISTINDEX_4).get収納情報なし().equals(ONE)) {
            source.shunonashiUpper5 = 収納情報なし;
        }
    }

    private void get収納情報なし2(KyufuGengakuHaakuIchiranReportSource source, List<ShunoJohoEntity> 収納情報リスト) {
        if (収納情報リスト.size() > NUM_5 && 収納情報リスト.get(LISTINDEX_5).get収納情報なし().equals(ONE)) {
            source.shunonashiLower1 = 収納情報なし;
        }
        if (収納情報リスト.size() > NUM_6 && 収納情報リスト.get(LISTINDEX_6).get収納情報なし().equals(ONE)) {
            source.shunonashiLower2 = 収納情報なし;
        }
        if (収納情報リスト.size() > NUM_7 && 収納情報リスト.get(LISTINDEX_7).get収納情報なし().equals(ONE)) {
            source.shunonashiLower3 = 収納情報なし;
        }
        if (収納情報リスト.size() > NUM_8 && 収納情報リスト.get(LISTINDEX_8).get収納情報なし().equals(ONE)) {
            source.shunonashiLower4 = 収納情報なし;
        }
        if (収納情報リスト.size() > NUM_9 && 収納情報リスト.get(LISTINDEX_9).get収納情報なし().equals(ONE)) {
            source.shunonashiLower5 = 収納情報なし;
        }
    }

    //TODO QA「減額情報１」、「減額情報２」などはなんですか。
//    private void setGengakuTaishoJoho(KyufuGengakuHaakuIchiranReportSource source) {
//        if (this.減額対象情報リストEntity != null && !this.減額対象情報リストEntity.isEmpty()) {
//            for (int gengakuIndex = 0; gengakuIndex < 減額対象情報リストEntity.size(); gengakuIndex++) {
//            }
//        }
//
//    }
    private RString get要介護度() {
        if (this.給付額減額把握リストEntity.get被保険者情報Entity() != null) {
            HihokenshaJohoEntity 被保険者情報Entity = this.給付額減額把握リストEntity.get被保険者情報Entity();
            RString 要介護状態区分コード = 被保険者情報Entity.get要介護状態区分コード();
            KoroshoInterfaceShikibetsuCode 厚労省IF識別コード = KoroshoInterfaceShikibetsuCode.
                    toValue(被保険者情報Entity.get厚労省IF識別コード());
            return YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護状態区分コード).getName();
        }
        return RString.EMPTY;
    }

    private KyufuGengakuHaakuIchiranReportSource set出力順改頁(KyufuGengakuHaakuIchiranReportSource source,
            List<ISetSortItem> 設定項目リスト) {

        if (!設定項目リスト.isEmpty()) {
            source.shutsuryokujun1 = 設定項目リスト.get(0).get項目名();
            if (設定項目リスト.get(0).is改頁項目()) {
                source.kaiPege1 = 設定項目リスト.get(0).get項目名();
            }
        }
        if (設定項目リスト.size() > 1) {
            source.shutsuryokujun2 = 設定項目リスト.get(1).get項目名();
            if (設定項目リスト.get(1).is改頁項目()) {
                source.kaiPege2 = 設定項目リスト.get(1).get項目名();
            }
        }
        if (設定項目リスト.size() > 2) {
            source.shutsuryokujun3 = 設定項目リスト.get(2).get項目名();
            if (設定項目リスト.get(2).is改頁項目()) {
                source.kaiPege3 = 設定項目リスト.get(2).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_3) {
            source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            if (設定項目リスト.get(LISTINDEX_3).is改頁項目()) {
                source.kaiPege4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_4) {
            source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            if (設定項目リスト.get(LISTINDEX_4).is改頁項目()) {
                source.kaiPege5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度1の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度1の期) {
        if (年度1の期.get滞納区分().equals(ONE)) {
            source.listNendoBun1_4 = 記号1;
        } else if (年度1の期.get滞納区分().equals(TWO)) {
            source.listNendoBun1_4 = 記号2;
        } else if (年度1の期.get滞納区分().equals(THREE)) {
            source.listNendoBun1_4 = 記号3;
        } else {
            source.listNendoBun1_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度2の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度2の期) {
        if (年度2の期.get滞納区分().equals(ONE)) {
            source.listNendoBun2_4 = 記号1;
        } else if (年度2の期.get滞納区分().equals(TWO)) {
            source.listNendoBun2_4 = 記号2;
        } else if (年度2の期.get滞納区分().equals(THREE)) {
            source.listNendoBun2_4 = 記号3;
        } else {
            source.listNendoBun2_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度3の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度3の期) {
        if (年度3の期.get滞納区分().equals(ONE)) {
            source.listNendoBun3_4 = 記号1;
        } else if (年度3の期.get滞納区分().equals(TWO)) {
            source.listNendoBun3_4 = 記号2;
        } else if (年度3の期.get滞納区分().equals(THREE)) {
            source.listNendoBun3_4 = 記号3;
        } else {
            source.listNendoBun3_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度4の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度4の期) {
        if (年度4の期.get滞納区分().equals(ONE)) {
            source.listNendoBun4_4 = 記号1;
        } else if (年度4の期.get滞納区分().equals(TWO)) {
            source.listNendoBun4_4 = 記号2;
        } else if (年度4の期.get滞納区分().equals(THREE)) {
            source.listNendoBun4_4 = 記号3;
        } else {
            source.listNendoBun4_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度5の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度5の期) {
        if (年度5の期.get滞納区分().equals(ONE)) {
            source.listNendoBun5_4 = 記号1;
        } else if (年度5の期.get滞納区分().equals(TWO)) {
            source.listNendoBun5_4 = 記号2;
        } else if (年度5の期.get滞納区分().equals(THREE)) {
            source.listNendoBun5_4 = 記号3;
        } else {
            source.listNendoBun5_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度6の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度6の期) {
        if (年度6の期.get滞納区分().equals(ONE)) {
            source.listNendoBun6_4 = 記号1;
        } else if (年度6の期.get滞納区分().equals(TWO)) {
            source.listNendoBun6_4 = 記号2;
        } else if (年度6の期.get滞納区分().equals(THREE)) {
            source.listNendoBun6_4 = 記号3;
        } else {
            source.listNendoBun6_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度7の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度7の期) {
        if (年度7の期.get滞納区分().equals(ONE)) {
            source.listNendoBun7_4 = 記号1;
        } else if (年度7の期.get滞納区分().equals(TWO)) {
            source.listNendoBun7_4 = 記号2;
        } else if (年度7の期.get滞納区分().equals(THREE)) {
            source.listNendoBun7_4 = 記号3;
        } else {
            source.listNendoBun7_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度8の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度8の期) {
        if (年度8の期.get滞納区分().equals(ONE)) {
            source.listNendoBun8_4 = 記号1;
        } else if (年度8の期.get滞納区分().equals(TWO)) {
            source.listNendoBun8_4 = 記号2;
        } else if (年度8の期.get滞納区分().equals(THREE)) {
            source.listNendoBun8_4 = 記号3;
        } else {
            source.listNendoBun8_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度9の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度9の期) {
        if (年度9の期.get滞納区分().equals(ONE)) {
            source.listNendoBun9_4 = 記号1;
        } else if (年度9の期.get滞納区分().equals(TWO)) {
            source.listNendoBun9_4 = 記号2;
        } else if (年度9の期.get滞納区分().equals(THREE)) {
            source.listNendoBun9_4 = 記号3;
        } else {
            source.listNendoBun9_4 = 記号4;
        }
        return source;
    }

    private KyufuGengakuHaakuIchiranReportSource edit年度10の滞納区分(KyufuGengakuHaakuIchiranReportSource source,
            ShunoKibetsuEntity 年度10の期) {
        if (年度10の期.get滞納区分().equals(ONE)) {
            source.listNendoBun10_4 = 記号1;
        } else if (年度10の期.get滞納区分().equals(TWO)) {
            source.listNendoBun10_4 = 記号2;
        } else if (年度10の期.get滞納区分().equals(THREE)) {
            source.listNendoBun10_4 = 記号3;
        } else {
            source.listNendoBun10_4 = 記号4;
        }
        return source;
    }
}
