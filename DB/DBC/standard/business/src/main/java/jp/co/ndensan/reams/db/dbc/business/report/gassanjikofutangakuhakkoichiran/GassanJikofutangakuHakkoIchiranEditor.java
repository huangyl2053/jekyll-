/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakuhakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjikofutangakuhakkoichiran.GassanJikofutangakuHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200035_高額合算自己負担額証明書発行一覧表のEditorrクラスです。
 *
 * @reamsid_L DBC-2380-040 qinzhen
 */
public class GassanJikofutangakuHakkoIchiranEditor implements
        IGassanJikofutangakuHakkoIchiranEditor {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final RString 年度 = new RString("年度");
    private static final RString 接続文字 = new RString("～");

    private final int 連番;
    private final KogakuGassanData entity;
    private final IOutputOrder 出力順情報;

    /**
     * コンストラクタです
     *
     * @param entity KogakuGassanData
     * @param 出力順情報 IOutputOrder
     * @param 連番 int
     *
     */
    public GassanJikofutangakuHakkoIchiranEditor(KogakuGassanData entity, IOutputOrder 出力順情報, int 連番) {
        this.entity = entity;
        this.出力順情報 = 出力順情報;
        this.連番 = 連番;
    }

    @Override
    public GassanJikofutangakuHakkoIchiranSource edit(GassanJikofutangakuHakkoIchiranSource source) {

        source.printTimeStamp = getSakuseiYmhm(RDate.getNowDate(), RTime.now());
        source.hokenshaNo = entity.get保険者番号().value();
        source.hokenshaName = entity.get保険者名();
        source.郵便番号 = entity.get郵便番号();
        source.町域コード = entity.get町域コード();
        source.行政区コード = entity.get行政区コード();
        source.市町村コード = entity.get市町村コード();
        source.証記載保険者番号 = entity.get証記載保険者番号();
        source.氏名５０音カナ = entity.get氏名５０音カナ();

        setHeader(source);

        source.list_1 = new RString(連番);

        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
            source.list_2 = entity.get被保険者番号().value();
            source.expandedInformation = new ExpandedInformation(Code.EMPTY, RString.EMPTY,
                    source.list_2);
        }
        if (entity.get被保険者氏名() != null && !entity.get被保険者氏名().isEmpty()) {
            source.list_3 = entity.get被保険者氏名().value();
        }

        source.list_4 = getDate1(entity.get生年月日());
        source.list_5 = entity.get性別().getName().getShortJapanese();

        source.list_6 = entity.get支給申請書整理番号();
        source.list_7 = entity.get対象年度().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                fillType(FillType.BLANK).toDateString().concat(年度);

        source.list_8 = getPrintTime(entity.get被保険者期間開始年月日(), entity.get被保険者期間終了年月日());
        source.list_9 = entity.get自己負担額証明書整理番号();
        if (entity.get補正済_合計_自己負担額() != null) {
            source.list_10 = DecimalFormatter.toコンマ区切りRString(entity.get補正済_合計_自己負担額(), 0);
        }
        if (entity.get補正済_合計_70_74自己負担額_内訳() != null) {
            source.list_11 = DecimalFormatter.toコンマ区切りRString(entity.get補正済_合計_70_74自己負担額_内訳(), 0);
        }
        source.shikibetsuCode = entity.get識別コード().value();

        return source;

    }

    private RString getSakuseiYmhm(RDate nowDate, RTime now) {
        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(nowDate.wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).
                toDateString());
        sakuseiYMD.append(RString.FULL_SPACE);
        sakuseiYMD.append(now.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return sakuseiYMD.toRString();
    }

    private RString getPrintTime(FlexibleDate kaishiYMD, FlexibleDate shuryoYMD) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(getDate1(kaishiYMD));
        sakuseiYMD.append(接続文字);
        if (shuryoYMD != null && !shuryoYMD.isEmpty()) {
            sakuseiYMD.append(getDate1(shuryoYMD));
        }
        return sakuseiYMD.toRString();
    }

    private void setHeader(GassanJikofutangakuHakkoIchiranSource source) {

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

        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            改頁１ = list.get(0).get項目名();
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            改頁２ = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            改頁３ = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            改頁４ = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            改頁５ = list.get(INDEX_4).get項目名();
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

        source.kaipage1 = 改頁１;
        source.kaipage2 = 改頁２;
        source.kaipage3 = 改頁３;
        source.kaipage4 = 改頁４;
        source.kaipage5 = 改頁５;

        source.shutsuryokujun1 = 出力順１;
        source.shutsuryokujun2 = 出力順２;
        source.shutsuryokujun3 = 出力順３;
        source.shutsuryokujun4 = 出力順４;
        source.shutsuryokujun5 = 出力順５;
    }

    private static RString getDate1(FlexibleDate date) {
        if (date == null || date.equals(FlexibleDate.MAX) || date.equals(FlexibleDate.MIN)) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString();
    }
}
