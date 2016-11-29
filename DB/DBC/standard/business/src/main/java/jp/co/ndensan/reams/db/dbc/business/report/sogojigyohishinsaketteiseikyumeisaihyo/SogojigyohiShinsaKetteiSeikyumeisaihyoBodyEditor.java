/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200070_介護予防・日常生活支援総合事業費審査決定請求明細表帳票BodyEditorクラスです
 *
 * @reamsid_L DBC-2500-031 jiangwenkai
 */
public class SogojigyohiShinsaKetteiSeikyumeisaihyoBodyEditor implements ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor {

    private final SogojigyohiShinsaKetteiSeikyumeisaihyoEntity 帳票出力対象データ;
    private final boolean 合計出力flag;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiShinsaKetteiSeikyumeisaihyoEntity
     * @param 合計出力flag boolean
     */
    public SogojigyohiShinsaKetteiSeikyumeisaihyoBodyEditor(SogojigyohiShinsaKetteiSeikyumeisaihyoEntity 帳票出力対象データ, boolean 合計出力flag
    ) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.合計出力flag = 合計出力flag;
    }

    @Override
    public SogojigyohiShinsaKetteiSeikyumeisaihyoSource edit(SogojigyohiShinsaKetteiSeikyumeisaihyoSource source) {
        source.listMeisai_1 = getColumnValue(帳票出力対象データ.get審査決定請求明細().get事業所番号());
        source.listMeisai_2 = 帳票出力対象データ.get審査決定請求明細().get事業所名();
        source.listMeisai_3 = doパターン54(帳票出力対象データ.get審査決定請求明細().getサービス提供年月());
        source.listMeisai_4 = 帳票出力対象データ.get審査決定請求明細().getサービス種類名();
        source.listMeisai_5 = doカンマ編集(帳票出力対象データ.get審査決定請求明細().get件数());
        source.listMeisai_6 = doカンマ編集(帳票出力対象データ.get審査決定請求明細().get日数_回数());
        source.listMeisai_7 = doカンマ編集(帳票出力対象データ.get審査決定請求明細().get単位数());
        source.listMeisai_8 = doカンマ編集(帳票出力対象データ.get審査決定請求明細().get金額());
        source.listMeisai_9 = doカンマ編集(帳票出力対象データ.get審査決定請求明細().get介護給付費_総合事業費());
        source.listMeisai_10 = doカンマ編集(帳票出力対象データ.get審査決定請求明細().get利用者負担額());
        source.listMeisai_11 = getColumnValue(帳票出力対象データ.get審査決定請求明細().getサービス種類コード());
        if (合計出力flag) {
            source.gokeiKensu = doカンマ編集(帳票出力対象データ.get審査決定請求合計().get合計_件数());
            source.gokeiTanisu = doカンマ編集(帳票出力対象データ.get審査決定請求合計().get合計_単位数());
            source.gokeiKingaku = doカンマ編集(帳票出力対象データ.get審査決定請求合計().get合計_金額());
            source.gokeiKaigoKyufugaku = doカンマ編集(帳票出力対象データ.get審査決定請求合計().get合計_介護給付費_総合事業費());
            source.gokeiRiyoshaFutangaku = doカンマ編集(帳票出力対象データ.get審査決定請求合計().get合計_利用者負担額());
        }
        setPageBreakEmpty(source);
        return source;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
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

    private void setPageBreakEmpty(SogojigyohiShinsaKetteiSeikyumeisaihyoSource source) {
        if (source.shoKisaiHokenshaNo == null) {
            source.shoKisaiHokenshaNo = RString.EMPTY;
        }
    }
}
