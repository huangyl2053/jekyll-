/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200088_基準収入額適用申請書一覧表 Editorクラスです。
 *
 * @reamsid_L DBC-4640-060 lijian
 */
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranEditor implements IKijunShunyugakuTekiyoShinseishoHakkoIchiranEditor {

    private final KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者;
    private static final RString 年度作成 = new RString("年度");
    private static final RString 日時作成 = new RString("作成");
    private final RString 保険者番号;
    private final RString 保険者名称;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;
    private final FlexibleYear 年度;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param 発行対象者 KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity
     * @param 保険者番号 RString
     * @param 保険者名称 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 年度 FlexibleYear
     */
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranEditor(
            KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者,
            RString 保険者番号,
            RString 保険者名称,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYear 年度) {
        this.発行対象者 = 発行対象者;
        this.保険者番号 = 保険者番号;
        this.保険者名称 = 保険者名称;
        this.出力順リスト = 出力順リスト;
        this.改頁リスト = 改頁リスト;
        this.年度 = 年度;

    }

    @Override
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranSource edit(KijunShunyugakuTekiyoShinseishoHakkoIchiranSource source) {
        source.printTimeStamp = get印刷日時(YMDHMS.now());
        if (年度 != null) {
            source.nendo = 年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().concat(年度作成);
        }
        source.hokenshaNo = 保険者番号;
        source.hokenshaName = 保険者名称;
        edit出力順(source);
        edit改ページ(source);

        source.listIchiran_1 = 発行対象者.get通番();
        source.listIchiran_2 = 発行対象者.get世帯番号();
        source.listIchiran_3 = 発行対象者.get世帯課税();
        source.listIchiran_4 = doカンマ編集(発行対象者.get総合計());
        source.listIchiran_5 = get非空文字列(発行対象者.get被保番号());
        source.listIchiran_6 = get非空文字列(発行対象者.get氏名());
        source.listIchiran_7 = 発行対象者.get年齢();
        source.listIchiran_9 = doカンマ編集(発行対象者.get課税所得());
        source.listIchiran_10 = doカンマ編集(発行対象者.get課税所得_控除後());
        source.listIchiran_11 = doカンマ編集(発行対象者.get年金収入());
        source.listIchiran_12 = doカンマ編集(発行対象者.getその他合計所得());
        source.listIchiran_13 = doカンマ編集(発行対象者.get合計());
        source.listIchiran_14 = 発行対象者.get要介護度();
        if (発行対象者.get生年月日() != null) {
            source.listIchiran_8 = 発行対象者.get生年月日().wareki().toDateString();
        }
        if (発行対象者.get認定開始日() != null) {
            source.listIchiran_15 = 発行対象者.get認定開始日().wareki().toDateString();
        }
        if (発行対象者.get認定終了日() != null) {
            source.listIchiran_16 = 発行対象者.get認定終了日().wareki().toDateString();
        }
        if (発行対象者.get識別コード() != null) {
            source.shikibetsuCode = 発行対象者.get識別コード().value();
        }
        source.yubinNo = 発行対象者.get郵便番号();
        source.choikiCode = 発行対象者.get町域コード();
        source.gyoseikuCode = 発行対象者.get行政区コード();
        source.setaiCode = 発行対象者.get世帯コード();
        source.shichosonCode = 発行対象者.get市町村コード();
        source.拡張情報A1 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), source.listIchiran_5);
        source.拡張情報A2 = new ExpandedInformation(new Code("0004"), new RString("被保険者氏名"), source.listIchiran_6);
        return source;
    }

    private void edit出力順(KijunShunyugakuTekiyoShinseishoHakkoIchiranSource source) {
        source.shutsuryokujun1 = get並び順(NUM_0);
        source.shutsuryokujun2 = get並び順(NUM_1);
        source.shutsuryokujun3 = get並び順(NUM_2);
        source.shutsuryokujun4 = get並び順(NUM_3);
        source.shutsuryokujun5 = get並び順(NUM_4);
    }

    private void edit改ページ(KijunShunyugakuTekiyoShinseishoHakkoIchiranSource source) {
        source.kaipage1 = get改頁(NUM_0);
        source.kaipage2 = get改頁(NUM_1);
        source.kaipage3 = get改頁(NUM_2);
        source.kaipage4 = get改頁(NUM_3);
        source.kaipage5 = get改頁(NUM_4);
    }

    private RString get並び順(int index) {
        return index < 出力順リスト.size() ? 出力順リスト.get(index) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString get印刷日時(YMDHMS datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }
}
