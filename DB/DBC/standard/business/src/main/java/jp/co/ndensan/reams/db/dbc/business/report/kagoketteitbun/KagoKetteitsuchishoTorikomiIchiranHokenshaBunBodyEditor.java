/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120160.KagoKetteiHokenshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 過誤決定通知書情報取込一覧表（保険者分） 帳票KagoKetteitsuchishoTorikomiIchiranHokenshaBunBodyEditor
 *
 * @reamsid_L DBC-0980-470 lijunjun
 */
public class KagoKetteitsuchishoTorikomiIchiranHokenshaBunBodyEditor
        implements IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor {

    private final KagoKetteiHokenshaIchiranParameter 帳票用パラメター;
    private final KagoKetteiHokenshaChohyoEntity 帳票出力対象;

    private static final RString 件数タイトル = new RString("件数");
    private static final RString 単位数タイトル = new RString("単位数");
    private static final RString 負担額タイトル = new RString("公費負担額");
    private static final RString 介護給付費タイトル = new RString("介護給付費");
    private static final RString 高額介護サービス費タイトル = new RString("高額介護サービス費");
    private static final RString 特定入所者介護費等タイトル = new RString("特定入所者介護費等");
    private static final Code DATA_3 = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    /**
     * コンストラクタです
     *
     * @param 帳票用パラメター KagoKetteiHokenshaIchiranParameter
     */
    protected KagoKetteitsuchishoTorikomiIchiranHokenshaBunBodyEditor(
            KagoKetteiHokenshaIchiranParameter 帳票用パラメター) {
        this.帳票用パラメター = 帳票用パラメター;
        this.帳票出力対象 = 帳票用パラメター.get帳票出力対象();
    }

    @Override
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource edit(
            KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {
        edit明細(source);
        if (帳票用パラメター.is集計flg()) {
            edit集計(source);
        }
        source.shikibetuCode = 帳票出力対象.get識別コード();
        return source;
    }

    private void edit明細(KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {
        source.listUpper_1 = new RString(帳票用パラメター.get連番());
        source.listUpper_2 = doパターン54(帳票出力対象.get取扱年月());
        source.listUpper_3 = getColumnValue(帳票出力対象.get事業者番号());
        source.listUpper_4 = getColumnValue(帳票出力対象.get被保険者番号());
        if (!RString.isNullOrEmpty(source.listUpper_4)) {
            source.拡張情報 = new ExpandedInformation(DATA_3, 被保険者番号, source.listUpper_4);
        }
        source.listUpper_5 = 帳票出力対象.get被保険者氏名();
        source.listUpper_6 = doパターン54(帳票出力対象.getサービ提供年月());
        source.listUpper_7 = getColumnValue(帳票出力対象.getサービス種類コード());
        source.listUpper_8 = 帳票出力対象.getサービス種類名();
        source.listUpper_9 = doカンマ編集(帳票出力対象.get単位数());
        source.listLower_1 = 帳票出力対象.get事業者名();
        source.listLower_2 = getColumnValue(帳票出力対象.get過誤申立事由コード());
        source.listLower_3 = 帳票出力対象.get過誤申立事由();
        source.listLower_4 = doカンマ編集(帳票出力対象.get保険者負担額());
    }

    private void edit集計(KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {
        source.kensuTitle = 件数タイトル;
        source.tanisuTitle = 単位数タイトル;
        source.futangakuTitle = 負担額タイトル;
        source.kaigoKyufuhiTitle = 介護給付費タイトル;
        source.kogakuServicehiTitle = 高額介護サービス費タイトル;
        source.tokuteiNyushoshaKaigohiTitle = 特定入所者介護費等タイトル;
        source.kaigoKyufuhiKensu = doカンマ編集(帳票出力対象.get介護給付費の件数());
        source.kaigoKyufuhiTanisu = doカンマ編集(帳票出力対象.get介護給付費の単位数());
        source.kaigoKyufuhiFutangaku = doカンマ編集(帳票出力対象.get介護給付費の負担額());
        source.kogakuServicehiKensu = doカンマ編集(帳票出力対象.get高額介護サービス費の件数());
        source.kogakuServicehiTanisu = doカンマ編集(帳票出力対象.get高額介護サービス費の単位数());
        source.kogakuServicehiFutangaku = doカンマ編集(帳票出力対象.get高額介護サービス費の負担額());
        source.tokuteiNyushoshaKaigohiKensu = doカンマ編集(帳票出力対象.get特定入所者介護費等の件数());
        source.tokuteiNyushoshaKaigohiTanisu = doカンマ編集(帳票出力対象.get特定入所者介護費等の単位数());
        source.tokuteiNyushoshaKaigohiFutangaku = doカンマ編集(帳票出力対象.get特定入所者介護費等の負担額());
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

    private RString doカンマ編集(int number) {
        return DecimalFormatter.toコンマ区切りRString(new Decimal(number), 0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
