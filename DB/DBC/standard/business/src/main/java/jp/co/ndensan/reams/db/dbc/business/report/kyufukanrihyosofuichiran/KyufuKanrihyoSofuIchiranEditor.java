/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosofuichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
//import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200009_給付管理票送付一覧表のEditorです。
 *
 * @reamsid_L DBC-2840-041 kanghongsong
 */
public class KyufuKanrihyoSofuIchiranEditor implements IKyufuKanrihyoSofuIchiranEditor {

    private final KyufuKanrihyoSofuIchiranEntity entity;
    private final RString 備考 = new RString("限度基準額超過");
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    /**
     * インスタンスを生成します。
     *
     * @param entity 給付管理票送付一覧表
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     */
    protected KyufuKanrihyoSofuIchiranEditor(KyufuKanrihyoSofuIchiranEntity entity, Map<RString, RString> 出力順Map, List<RString> 改頁リスト) {
        this.entity = entity;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;

    }

    @Override
    public KyufuKanrihyoSofuIchiranReportSource edit(KyufuKanrihyoSofuIchiranReportSource source) {
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(entity.get作成日時().getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        hakkoYMD.append("△");
        hakkoYMD.append(entity.get作成日時().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        hakkoYMD.append("△");
        hakkoYMD.append("作成");
        source.printTimeStamp = new RString(hakkoYMD.toString());
        source.teishutsuYM = パターン56(entity.get処理年月());
        source.hokenshaNo = entity.get保険者番号();
        source.hokenshaName = entity.get保険者名();
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);
        source.kaiPege1 = get改頁(INDEX_1);
        source.kaiPege2 = get改頁(INDEX_2);
        source.kaiPege3 = get改頁(INDEX_3);
        source.kaiPege4 = get改頁(INDEX_4);
        source.kaiPege5 = get改頁(INDEX_5);
        source.listUpper_1 = パターン54(entity.get対象年月());
        source.listUpper_2 = entity.get被保険者番号();
        source.listUpper_3 = entity.get被保険者氏名();
        source.listUpper_4 = KyufukanrihyoSakuseiKubun.toValue(entity.get更新区分()).get名称();
        source.listUpper_5 = entity.get帳票通番();
        source.listUpper_6 = KyotakuServiceKubun.toValue(entity.get居宅サービス区分()).get名称();
        source.listUpper_7 = entity.get要介護状態区分();//TODO QA確認中
        source.listUpper_8 = toRString(entity.get区分支給限度基準額());
        source.listUpper_9 = パターン54(entity.get限度額管理開始年月日());
        source.listUpper_10 = パターン54(entity.get限度額管理終了年月日());
        source.listUpper_11 = new RString("");
        source.listUpper_12 = new RString("");
        source.listUpper_13 = toRString(entity.get合計単位());
        if (entity.get区分支給限度基準額().compareTo(entity.get合計単位()) < 0) {
            source.listUpper_14 = 備考;
        }
//        ShichosonSecurityJoho 介護導入形態 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
//        if (null != 介護導入形態) {
//            KaigoDonyuKubun 介護導入区分 = 介護導入形態.get介護導入区分();
//            if (KaigoDonyuKubun.未導入.code().equals(介護導入区分.code())) {
//                source.bikoTitle = new RString("");
//                source.listLower_1 = new RString("");
//            } else if (KaigoDonyuKubun.導入済.code().equals(介護導入区分.code())) {
//                source.bikoTitle = entity.get備考_証記載保険者番号();
//                source.listLower_1 = entity.get備考_証記載保険者番号();
//            }
//        }

        source.shinkiGokeiKensu = toRString(entity.get合計件数_新規());
        source.shuseiGokeiKensu = toRString(entity.get合計件数_修正());
        source.torikeshiGokeiKensu = toRString(entity.get合計件数_取消());
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString toRString(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toRString(金額, 0);
        }
        return RString.EMPTY;
    }

    private RString パターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
