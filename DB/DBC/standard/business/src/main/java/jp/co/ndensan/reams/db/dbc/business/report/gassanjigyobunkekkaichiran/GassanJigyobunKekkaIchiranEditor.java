/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jigyobunshikyugakurenrakuhyo.JigyobunShikyugakuRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBCMNN1004_事業分支給額計算のEditorrクラスです。
 *
 * @reamsid_L DBC-4830-040 qinzhen
 */
public class GassanJigyobunKekkaIchiranEditor implements
        IGassanJigyobunKekkaIchiranEditor {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    private final RString 区分コード_1 = new RString("1");
    private final RString 区分コード_2 = new RString("2");
    private final RString 受取年月タイトル = new RString("受取年月：");
    private final RString 被保険者番号タイトル = new RString("被保険者番号：");
    private final RString 年度タイトル = new RString("年度：");
    private final RString 年度文字 = new RString("年度");
    private final RString 支給結果 = new RString("支給");
    private final RString 不支給結果 = new RString("不支給");
    private final RString 口座方法 = new RString("口座");
    private final RString 窓口方法 = new RString("窓口");
    private final RString 証明書なし = new RString("なし");
    private final RString 証明書あり = new RString("あり");
    private final RString 接続文字 = new RString("-");
    private final RString 無関連データ = new RString("該当データ無し");

    private final JigyobunShikyugakuRenrakuhyo entity;
    private final IOutputOrder 出力順情報;
    private final RString 自市町村コード;
    private final List<RString> breakItemIds;

    /**
     * コンストラクタです
     *
     * @param entity JigyobunShikyugakuRenrakuhyo
     * @param 出力順情報 IOutputOrder
     * @param 自市町村コード RString
     * @param breakItemIds List<RString>
     *
     */
    public GassanJigyobunKekkaIchiranEditor(JigyobunShikyugakuRenrakuhyo entity, IOutputOrder 出力順情報, RString 自市町村コード,
            List<RString> breakItemIds) {
        this.entity = entity;
        this.出力順情報 = 出力順情報;
        this.自市町村コード = 自市町村コード;
        this.breakItemIds = breakItemIds;
    }

    @Override
    public GassanJigyobunKekkaIchiranSource edit(GassanJigyobunKekkaIchiranSource source) {
        GassanJigyobunKekkaIchiranEntity 帳票用データ = entity.get帳票用データ();

        source.shori_ymd_hms = getSakuseiYmhm(RDate.getNowDate(), RTime.now());
        if (entity.get出力対象区分().equals(区分コード_1)) {
            source.data1 = 受取年月タイトル.concat(entity.get受取年月().wareki().
                    eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).
                    toDateString());

        } else if (entity.get出力対象区分().equals(区分コード_2)) {
            source.data1 = 被保険者番号タイトル.concat(entity.get被保険者番号().value());
            source.data2 = 年度タイトル.concat(entity.get年度().wareki().
                    eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    fillType(FillType.BLANK).toDateString().
                    concat(年度文字));
        }

        source.city_cd = 自市町村コード;
        source.city_mei = entity.get市町村名();

        if (帳票用データ == null) {
            source.List1_2 = 無関連データ;
        } else {
            if (帳票用データ.get支給額_被保険者番号() != null) {
                source.List1_1 = 帳票用データ.get支給額_被保険者番号().value();
                source.expandedInformation = new ExpandedInformation(Code.EMPTY, RString.EMPTY,
                        source.List1_1);
            }

            if (帳票用データ.get件数() > INDEX_0) {
                source.List1_2 = 帳票用データ.get宛名氏名();
                source.shikibetsuCode = 帳票用データ.get識別コード().value();
            } else if (帳票用データ.get件数() == INDEX_0) {
                source.List1_2 = 無関連データ;
            }
            source.List1_3 = 帳票用データ.get支給額_支給申請書整理番号();
            setList1_4(source, 帳票用データ);
            source.List1_5 = doカンマ編集(帳票用データ.get支給額_世帯負担総額());
            source.List1_6 = doカンマ編集(帳票用データ.get支給額_介護等合算一部負担金等世帯合算額());
            source.List1_7 = doカンマ編集(帳票用データ.get支給額_70歳以上介護等合算一部負担金等世帯合算額());
            source.List1_8 = doカンマ編集(帳票用データ.get支給額_介護等合算算定基準額());
            source.List1_9 = doカンマ編集(帳票用データ.get支給額_70歳以上介護等合算算定基準額());
            source.List1_10 = doカンマ編集(帳票用データ.get支給額_世帯支給総額());
            source.List1_11 = doカンマ編集(帳票用データ.get支給額_うち70歳以上分世帯支給総額());
            source.List1_12 = doカンマ編集(帳票用データ.get支給額_按分後支給額());
            source.List1_13 = doカンマ編集(帳票用データ.get支給額_うち70歳以上分按分後支給額());

            RString 口座番号 = RString.EMPTY;
            if (!RString.isNullOrEmpty(帳票用データ.get口座番号())) {
                口座番号 = 帳票用データ.get口座番号();
            }

            RString 金融機関コード = RString.EMPTY;
            if (!RString.isNullOrEmpty(帳票用データ.get金融機関コード())) {
                金融機関コード = 帳票用データ.get金融機関コード();
            }

            RString 金融機関支店コード = RString.EMPTY;
            if (!RString.isNullOrEmpty(帳票用データ.get金融機関支店コード())) {
                金融機関支店コード = 帳票用データ.get金融機関支店コード();
            }

            RString 決定_支払場所 = RString.EMPTY;
            if (!RString.isNullOrEmpty(帳票用データ.get決定_支払場所())) {
                決定_支払場所 = 帳票用データ.get決定_支払場所();
            }

            if (帳票用データ.get決定_支払方法区分().equals(区分コード_1)) {
                source.List1_14 = 口座方法.concat(金融機関コード).concat(接続文字).
                        concat(金融機関支店コード).concat(RString.FULL_SPACE).concat(口座番号);
            } else if (帳票用データ.get決定_支払方法区分().equals(区分コード_2)) {
                source.List1_14 = 窓口方法.concat(決定_支払場所);
            }

            if (RString.isNullOrEmpty(帳票用データ.get支給額明細_自己負担額証明書整理番号())) {
                source.List1_15 = 証明書なし;
            } else {
                source.List1_15 = 証明書あり;
            }

            source.gyoseiCode = 帳票用データ.getGyoseiCode();
            source.choikiCode = 帳票用データ.getChoikiCode();
            source.shichosonCode = 帳票用データ.getShichosonCode();
            source.yubinNo = 帳票用データ.getYubinNo();
            source.taishoNendo = 帳票用データ.getTaishoNendo();
            source.shoKisaiHokenshaNo = 帳票用データ.getShoKisaiHokenshaNo();
            setHeader(source);
        }
        setPageBreakEmpty(source);
        return source;

    }

    private void setPageBreakEmpty(GassanJigyobunKekkaIchiranSource source) {
        if (source.shoKisaiHokenshaNo == null) {
            source.shoKisaiHokenshaNo = RString.EMPTY;
        }
        if (source.yubinNo == null) {
            source.yubinNo = RString.EMPTY;
        }
        if (source.choikiCode == null) {
            source.choikiCode = RString.EMPTY;
        }
        if (source.gyoseiCode == null) {
            source.gyoseiCode = RString.EMPTY;
        }
        if (source.atenaKanaShimei == null) {
            source.atenaKanaShimei = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = RString.EMPTY;
        }
        if (source.taishoNendo == null) {
            source.taishoNendo = RString.EMPTY;
        }
        if (source.List1_1 == null) {
            source.List1_1 = RString.EMPTY;
        }
        if (source.List1_3 == null) {
            source.List1_3 = RString.EMPTY;
        }
        if (source.List1_4 == null) {
            source.List1_4 = RString.EMPTY;
        }
        if (source.List1_14 == null) {
            source.List1_14 = RString.EMPTY;
        }
    }

    private RString getSakuseiYmhm(RDate nowDate, RTime now) {
        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(nowDate.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).
                toDateString());
        sakuseiYMD.append(RString.FULL_SPACE);
        sakuseiYMD.append(now.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return sakuseiYMD.toRString();
    }

    private void setHeader(GassanJigyobunKekkaIchiranSource source) {

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        RString 出力順１ = RString.EMPTY;
        RString 出力順２ = RString.EMPTY;
        RString 出力順３ = RString.EMPTY;
        RString 出力順４ = RString.EMPTY;
        RString 出力順５ = RString.EMPTY;

        List<ISetSortItem> list;
        if (出力順情報 != null) {
            list = 出力順情報.get設定項目リスト();
        } else {
            list = null;
        }

        if (list == null) {
            list = new ArrayList<>();
        }

        List<RString> returnList = getReturnList(source);
        if (returnList.size() > INDEX_0) {
            改頁１ = returnList.get(INDEX_0);
        }
        if (returnList.size() > INDEX_1) {
            改頁２ = returnList.get(INDEX_1);
        }
        if (returnList.size() > INDEX_2) {
            改頁３ = returnList.get(INDEX_2);
        }
        if (returnList.size() > INDEX_3) {
            改頁４ = returnList.get(INDEX_3);
        }
        if (returnList.size() > INDEX_4) {
            改頁５ = returnList.get(INDEX_4);
        }

        if (list.size() > INDEX_0) {
            出力順１ = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1) {
            出力順２ = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2) {
            出力順３ = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3) {
            出力順４ = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4) {
            出力順５ = list.get(INDEX_4).get項目名();
        }

        source.kai_page_area1 = 改頁１;
        source.kai_page_area2 = 改頁２;
        source.kai_page_area3 = 改頁３;
        source.kai_page_area4 = 改頁４;
        source.kai_page_area5 = 改頁５;

        source.sort_jun_area1 = 出力順１;
        source.sort_jun_area2 = 出力順２;
        source.sort_jun_area3 = 出力順３;
        source.sort_jun_area4 = 出力順４;
        source.sort_jun_area5 = 出力順５;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private void setList1_4(GassanJigyobunKekkaIchiranSource source, GassanJigyobunKekkaIchiranEntity 帳票用データ) {
        if (!RString.isNullOrEmpty(帳票用データ.get決定_支給区分コード())) {
            if (区分コード_1.equals(帳票用データ.get決定_支給区分コード())) {
                source.List1_4 = 支給結果;
            } else if (区分コード_2.equals(帳票用データ.get決定_支給区分コード())) {
                source.List1_4 = 不支給結果;
            }
        }
    }

    private List<RString> getReturnList(GassanJigyobunKekkaIchiranSource source) {
        List<RString> list = this.breakItemIds;
        List<RString> list2 = new ArrayList();
        for (RString str : list) {
            list2.add(get改頁項目(str, source));
        }
        return list2;
    }

    private RString get改頁項目(RString 項目ID, GassanJigyobunKekkaIchiranSource source) {
        if (GassanJigyobunKekkaIchiranOrder.証記載保険者番号.get項目ID().equals(項目ID)) {
            return source.shoKisaiHokenshaNo;
        }
        if (GassanJigyobunKekkaIchiranOrder.郵便番号.get項目ID().equals(項目ID)) {
            return source.yubinNo;
        }
        if (GassanJigyobunKekkaIchiranOrder.町域コード.get項目ID().equals(項目ID)) {
            return source.choikiCode;
        }
        if (GassanJigyobunKekkaIchiranOrder.行政区コード.get項目ID().equals(項目ID)) {
            return source.gyoseiCode;
        }
        if (GassanJigyobunKekkaIchiranOrder.氏名５０音カナ.get項目ID().equals(項目ID)) {
            return source.atenaKanaShimei;
        }
        if (GassanJigyobunKekkaIchiranOrder.市町村コード.get項目ID().equals(項目ID)) {
            return source.shichosonCode;
        }
        if (GassanJigyobunKekkaIchiranOrder.被保険者番号.get項目ID().equals(項目ID)) {
            return source.List1_1;
        }
        if (GassanJigyobunKekkaIchiranOrder.支払方法.get項目ID().equals(項目ID)) {
            return source.List1_14;
        }
        if (GassanJigyobunKekkaIchiranOrder.対象年度.get項目ID().equals(項目ID)) {
            return source.taishoNendo;
        }
        if (GassanJigyobunKekkaIchiranOrder.支給区分コード.get項目ID().equals(項目ID)) {
            return source.List1_4;
        }
        if (GassanJigyobunKekkaIchiranOrder.申請書整理番号.get項目ID().equals(項目ID)) {
            return source.List1_3;
        }
        return RString.EMPTY;
    }
}
