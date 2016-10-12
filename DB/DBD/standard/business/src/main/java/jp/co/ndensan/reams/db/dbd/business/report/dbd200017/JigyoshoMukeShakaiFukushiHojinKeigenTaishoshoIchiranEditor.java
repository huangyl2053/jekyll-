/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200017;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.ShafukugemmenTaishoshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200017.JigyoshoMukeShakaiFukushiHojinKeigenReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 事業所向け社会福祉法人軽減対象者一覧表Editorです。
 *
 * @reamsid_L DBD-3810-040 donghj
 */
public class JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranEditor implements
        IJigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranEditor {

    private final ShafukugemmenTaishoshaJohoEntity 社福減免対象者情報;
    private final Association 地方公共団体;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final int index;
    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int LISTINDEX_5 = 5;

    /**
     * インスタンスを生成します。
     *
     * @param 社福減免対象者情報 ShafukugemmenTaishoshaJohoEntity
     * @param 地方公共団体 Association
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param index int
     */
    public JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranEditor(ShafukugemmenTaishoshaJohoEntity 社福減免対象者情報,
            Association 地方公共団体, Association association, IOutputOrder iOutputOrder, int index) {
        this.社福減免対象者情報 = 社福減免対象者情報;
        this.地方公共団体 = 地方公共団体;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.index = index;
    }

    @Override
    public JigyoshoMukeShakaiFukushiHojinKeigenReportSource edit(JigyoshoMukeShakaiFukushiHojinKeigenReportSource source) {
        edit項目(source);
        edit明細(source);
        return source;
    }

    private JigyoshoMukeShakaiFukushiHojinKeigenReportSource edit項目(JigyoshoMukeShakaiFukushiHojinKeigenReportSource source) {
        source.printTimeStamp = get作成日付();
        if (地方公共団体 != null) {
            source.hokenshaNo = 地方公共団体.get地方公共団体コード() == null ? RString.EMPTY : 地方公共団体.get地方公共団体コード().value();
            source.hokenshaName = 地方公共団体.get市町村名();
        }
        if (null != iOutputOrder) {
            setiOutputOrder(source);
            setBreakIoutputOrder(source);
        }
        if (association != null) {
            source.listShohokenshaName_1 = association.get市町村名();
        }

        return source;
    }

    private JigyoshoMukeShakaiFukushiHojinKeigenReportSource edit明細(JigyoshoMukeShakaiFukushiHojinKeigenReportSource source) {
        if (社福減免対象者情報 != null) {
            source.jigyoshaCd = 社福減免対象者情報.get事業所番号();
            source.jigyoshaName = 社福減免対象者情報.get事業者名称();
            source.yubinNo = 社福減免対象者情報.get郵便番号();
            source.jusho = 社福減免対象者情報.get事業者住所() == null ? RString.EMPTY : 社福減免対象者情報.get事業者住所().value();
            source.telNo = 社福減免対象者情報.get電話番号() == null ? RString.EMPTY : 社福減免対象者情報.get電話番号().value();
            source.listHihokenshaNameKana_1 = 社福減免対象者情報.getカナ名称() == null ? RString.EMPTY : 社福減免対象者情報.getカナ名称().value();
            source.listHihokenshaName_1 = 社福減免対象者情報.get名称() == null ? RString.EMPTY : 社福減免対象者情報.get名称().value();
            source.listMeisai_1 = new RString(index);
            source.listMeisai_2 = 社福減免対象者情報.get被保険者番号() == null ? RString.EMPTY : 社福減免対象者情報.get被保険者番号().value();
            if (JuminShubetsu.日本人.getCode().equals(社福減免対象者情報.get住民種別コード())
                    || JuminShubetsu.住登外個人_日本人.getCode().equals(社福減免対象者情報.get住民種別コード())) {
                source.listMeisai_3 = 社福減免対象者情報.get生年月日() == null ? RString.EMPTY : 社福減免対象者情報.get生年月日().
                        wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).
                        fillType(FillType.BLANK).toDateString();
            } else {
                source.listMeisai_3 = 社福減免対象者情報.get生年月日() == null ? RString.EMPTY : 社福減免対象者情報.get生年月日().
                        seireki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            if (社福減免対象者情報.get性別コード() != null && !社福減免対象者情報.get性別コード().isEmpty()) {
                source.listMeisai_4 = Seibetsu.toValue(社福減免対象者情報.get性別コード()).get名称();
            }
            if (社福減免対象者情報.get要介護認定状態区分コード() != null && !社福減免対象者情報.get要介護認定状態区分コード().isEmpty()) {
                source.listMeisai_5 = YokaigoJotaiKubun.toValue(社福減免対象者情報.get要介護認定状態区分コード().getColumnValue()).get名称();
            }
            source.listMeisai_6 = 社福減免対象者情報.get確認番号();
            source.listMeisai_7 = 社福減免対象者情報.get適用開始年月日() == null ? RString.EMPTY : 社福減免対象者情報.
                    get適用開始年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            source.listMeisai_8 = 社福減免対象者情報.get適用終了年月日() == null ? RString.EMPTY : 社福減免対象者情報.
                    get適用終了年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            source.listMeisai_9 = getサービス限定();

            source.listShohokenshaNo_1 = 社福減免対象者情報.get証記載保険者番号() == null ? RString.EMPTY : 社福減免対象者情報.get証記載保険者番号().value();

        } else {
            source.listHihokenshaName_1 = new RString("出力データ　０件");
        }
        return source;

    }

    private RString get作成日付() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RString 時分秒 = datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        systemDateTime.append(時分秒);
        return systemDateTime.toRString();
    }

    private RString getサービス限定() {
        RStringBuilder サービス限定 = new RStringBuilder();
        if (社福減免対象者情報.is居宅サービス限定()) {
            サービス限定.append(new RString("宅"));
        } else {
            サービス限定.append(RString.FULL_SPACE);
        }
        if (社福減免対象者情報.is居住費食費のみ()) {
            サービス限定.append(new RString("住"));
        } else {
            サービス限定.append(RString.FULL_SPACE);
        }
        if (社福減免対象者情報.is旧措置者ユニット型個室のみ()) {
            サービス限定.append(new RString("ユ"));
        } else {
            サービス限定.append(RString.FULL_SPACE);
        }
        return サービス限定.toRString();
    }

    private void setiOutputOrder(JigyoshoMukeShakaiFukushiHojinKeigenReportSource source) {

        Map<Integer, ISetSortItem> 出力順Map = ChohyoUtil.get出力順項目Map(iOutputOrder);
        if (出力順Map.get(LISTINDEX_1) != null) {
            source.shutsuryokujun1 = 出力順Map.get(LISTINDEX_1).get項目名();
        }
        if (出力順Map.get(LISTINDEX_2) != null) {
            source.shutsuryokujun2 = 出力順Map.get(LISTINDEX_2).get項目名();
        }
        if (出力順Map.get(LISTINDEX_3) != null) {
            source.shutsuryokujun3 = 出力順Map.get(LISTINDEX_3).get項目名();
        }
        if (出力順Map.get(LISTINDEX_4) != null) {
            source.shutsuryokujun4 = 出力順Map.get(LISTINDEX_4).get項目名();
        }
        if (出力順Map.get(LISTINDEX_5) != null) {
            source.shutsuryokujun5 = 出力順Map.get(LISTINDEX_5).get項目名();
        }

    }

    private void setBreakIoutputOrder(JigyoshoMukeShakaiFukushiHojinKeigenReportSource source) {
        int index2 = 0;
        List<RString> 改頁list = new ArrayList<>();
        List<ISetSortItem> list = iOutputOrder.get設定項目リスト();
        if (list == null) {
            list = new ArrayList<>();
        }
        for (int i = 0; i < LISTINDEX_5; i++) {
            if (list.size() > i && list.get(i).is改頁項目()) {
                改頁list.add(list.get(i).get項目名());
                index2++;
            }
        }
        for (int i = index2; i < LISTINDEX_5; i++) {
            改頁list.add(RString.EMPTY);
        }
        source.kaiPege1 = 改頁list.get(LISTINDEX_0);
        source.kaiPege2 = 改頁list.get(LISTINDEX_1);
        source.kaiPege3 = 改頁list.get(LISTINDEX_2);
        source.kaiPege4 = 改頁list.get(LISTINDEX_3);
        source.kaiPege5 = 改頁list.get(LISTINDEX_4);
    }

}
