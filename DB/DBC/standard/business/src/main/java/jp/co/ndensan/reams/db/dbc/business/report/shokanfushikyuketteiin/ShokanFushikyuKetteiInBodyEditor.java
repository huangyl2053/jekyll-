/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200022_償還払不支給決定者一覧表 ShokanFushikyuKetteiInBodyEditor
 *
 * @reamsid_L DBC-2590-040 xuhao
 */
public class ShokanFushikyuKetteiInBodyEditor implements IShokanFushikyuKetteiInEditor {

    private final ShokanFushikyuKetteiInEntity 帳票出力対象データ;
    private final RString 編集住所;
    private static final int 文字20 = 20;

    private static final RString コロン = new RString("：");
    private static final RString アスタリスク = new RString("*");
    private static final RString 更新DB有無_有 = new RString("1");
    private static final Code CODE = new Code("0003");
    private static final RString NAME = new RString("被保険者番号");

    /**
     * コンストラクタです
     *
     *
     * @param 帳票出力対象データ ShokanFushikyuKetteiInEntity
     * @param 編集住所 RString
     */
    protected ShokanFushikyuKetteiInBodyEditor(
            ShokanFushikyuKetteiInEntity 帳票出力対象データ,
            RString 編集住所) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.編集住所 = 編集住所;
    }

    @Override
    public ShokanbaraiFushikyuKetteishaIchiranSource edit(ShokanbaraiFushikyuKetteishaIchiranSource source) {
        source.listUpper_1 = 帳票出力対象データ.get決定通知();
        if (!RString.isNullOrEmpty(帳票出力対象データ.get被保険者番号().getColumnValue())) {
            source.listUpper_2 = 帳票出力対象データ.get被保険者番号().getColumnValue();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get被保険者氏名())) {
            source.listUpper_3 = 帳票出力対象データ.get被保険者氏名();
        }
        if (帳票出力対象データ.get事業者番号() != null) {
            source.listUpper_4 = 帳票出力対象データ.get事業者番号().getColumnValue();
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get事業者名())) {
            source.listUpper_5 = 帳票出力対象データ.get事業者名();
        }
        source.listUpper_6 = doパターン54(帳票出力対象データ.getサービス提供年月());
        source.listUpper_7 = doカンマ編集(帳票出力対象データ.get単位数());
        if (!RString.isNullOrEmpty(帳票出力対象データ.get資格喪失事由コード())) {
            source.listUpper_8 = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(),
                    new Code(帳票出力対象データ.get資格喪失事由コード()));
        }
        source.listUpper_9 = 帳票出力対象データ.get備考1();
        source.listLower_1 = 帳票出力対象データ.get整理番号();
        source.listLower_2 = 帳票出力対象データ.get町域コード();
        if (!RString.isNullOrEmpty(編集住所)) {
            source.listLower_3 = 編集住所.substringReturnAsPossible(0, 文字20);
        }
        source.listLower_4 = 帳票出力対象データ.get行政区コード();
        source.listLower_5 = 帳票出力対象データ.get行政区名();
        RString サービス種類コード = RString.EMPTY;
        if (null != 帳票出力対象データ.getサービス種類コード()) {
            サービス種類コード = 帳票出力対象データ.getサービス種類コード().getColumnValue();
        }
        RString サービス種類名 = (null == 帳票出力対象データ.getサービス種類名()) ? RString.EMPTY : 帳票出力対象データ.getサービス種類名();
        source.listLower_6 = サービス種類コード.concat(コロン).concat(サービス種類名);
        if (null != 帳票出力対象データ.get資格喪失日()) {
            source.listLower_7 = 帳票出力対象データ.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.listLower_8 = 帳票出力対象データ.get備考2();
        if (更新DB有無_有.equals(帳票出力対象データ.get更新DB無())) {
            source.listDBKoshinUmu_1 = アスタリスク;
        } else {
            source.listDBKoshinUmu_1 = RString.EMPTY;
        }
        if (帳票出力対象データ.get識別コード() != null) {
            source.shikibetuCode = 帳票出力対象データ.get識別コード();
        } else {
            source.shikibetuCode = ShikibetsuCode.EMPTY;
        }
        source.拡張情報 = new ExpandedInformation(CODE, NAME,
                ReportKomokuEditorUtil.get非空文字列(source.listUpper_2));
        if (帳票出力対象データ.get郵便番号() != null) {
            source.yubinNo = 帳票出力対象データ.get郵便番号();
        }
        if (帳票出力対象データ.get氏名５０音カナ() != null) {
            source.shimei50onKana = 帳票出力対象データ.get氏名５０音カナ();
        }
        setPageBreakEmpty(source);
        return source;
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private void setPageBreakEmpty(ShokanbaraiFushikyuKetteishaIchiranSource source) {
        if (source.listLower_2 == null) {
            source.listLower_2 = RString.EMPTY;
        }
        if (source.listLower_4 == null) {
            source.listLower_4 = RString.EMPTY;
        }
        if (source.listUpper_2 == null) {
            source.listUpper_2 = RString.EMPTY;
        }
        if (source.listUpper_1 == null) {
            source.listUpper_1 = RString.EMPTY;
        }
        if (source.listLower_1 == null) {
            source.listLower_1 = RString.EMPTY;
        }
        if (source.listLower_6 == null) {
            source.listLower_6 = RString.EMPTY;
        }
        if (source.yubinNo == null) {
            source.yubinNo = RString.EMPTY;
        }
        if (source.shimei50onKana == null) {
            source.shimei50onKana = RString.EMPTY;
        }
    }
}
