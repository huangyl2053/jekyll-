/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_KyufuJissekiSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額合算給付実績情報取込一覧表BodyEditorクラスです。
 *
 * @reamsid_L DBC-2700-030 wangxingpeng
 */
public class GassanKyufujissekiTorikomiIchiranBodyEditor implements IGassanKyufujissekiTorikomiIchiranEditor {

    private final KogakuGassanKyufuJissekiInEntity target;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param target KogakuGassanKyufuJissekiInEntity
     * @param 連番 int
     */
    public GassanKyufujissekiTorikomiIchiranBodyEditor(KogakuGassanKyufuJissekiInEntity target,
            int 連番) {
        this.target = target;
        this.連番 = 連番;
    }

    @Override
    public GassanKyufujissekiTorikomiIchiranSource edit(GassanKyufujissekiTorikomiIchiranSource source) {
        source.list_1 = new RString(連番);
        if (target.get被保険者一時().get登録被保険者番号() != null) {
            source.list_2 = target.get被保険者一時().get登録被保険者番号().getColumnValue();
        }
        source.list_3 = target.get被保険者一時().get宛名名称();
        source.list_4 = target.get高額合算給付実績一時().getShikyuShinseishoSeiriNo();
        source.list_5 = target.get高額合算給付実績一時().getJikoFutanSeiriNo();
        source.list_6 = KaigoGassan_KyufuJissekiSakuseiKubun
                .toValue(target.get高額合算給付実績一時().getKyufuJissekiSakuseiKubunCode()).get名称();
        if (target.get高額合算給付実績一時().getShoKisaiHokenshaNo() != null) {
            source.list_7 = target.get高額合算給付実績一時().getShoKisaiHokenshaNo().getColumnValue();
        }
        source.list_8 = パターン4(target.get高額合算給付実績一時().getShinseiYMD());
        source.list_9 = パターン4(target.get高額合算給付実績一時().getKetteiYMD());
        if (target.get高額合算給付実績一時().getJikoFutanSogaku() != null) {
            source.list_10 = decimal_to_string(target.get高額合算給付実績一時().getJikoFutanSogaku());
        }
        if (target.get高額合算給付実績一時().getShikyuGaku() != null) {
            source.list_11 = decimal_to_string(target.get高額合算給付実績一時().getShikyuGaku());
        }

        source.yubinNo = target.get被保険者一時().get郵便番号();
        source.choikiCode = target.get被保険者一時().get町域コード();
        source.gyoseikuCode = target.get被保険者一時().get行政区コード();
        if (target.get被保険者一時().get市町村コード() != null) {
            source.shichosonCode = target.get被保険者一時().get市町村コード().getColumnValue();
        }
        source.shimei50onKana = target.get被保険者一時().get氏名50音カナ();
        source.shikyuShinseishoSeiriNo = target.get高額合算給付実績一時().getShikyuShinseishoSeiriNo();
        source.shikibetsuCode = target.get被保険者一時().get識別コード();
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                ReportKomokuEditorUtil.get非空文字列(source.list_2));
        return source;
    }

    private RString パターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 数値からstringに転換する。
     *
     * @param number 数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }
}
