/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護給付費等審査決定請求明細表のBodyEditorクラスです。
 *
 * @reamsid_L DBC-2500-030 jiangxiaolong
 */
public class KyufuhiShinsaKetteiSeikyuMeisaihyoBodyEditor implements IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor {

    private final KyufuhiShinsaKetteiSeikyuMeisaihyoEntity 帳票出力対象;
    private boolean 出力Flag = false;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象 KyufuhiShinsaKetteiSeikyuMeisaihyoEntity
     * @param 出力Flag boolean
     */
    public KyufuhiShinsaKetteiSeikyuMeisaihyoBodyEditor(
            KyufuhiShinsaKetteiSeikyuMeisaihyoEntity 帳票出力対象,
            boolean 出力Flag) {
        this.帳票出力対象 = 帳票出力対象;
        this.出力Flag = 出力Flag;
    }

    @Override
    public KyufuhiShinsaKetteiSeikyuMeisaihyoSource edit(KyufuhiShinsaKetteiSeikyuMeisaihyoSource source) {
        source.listMeisai_1 = getColumnValue(帳票出力対象.get明細テータ().get事業所番号());
        source.listMeisai_2 = 帳票出力対象.get明細テータ().get事業所名();
        source.listMeisai_3 = doパターン54(帳票出力対象.get明細テータ().getサービス提供年月());
        source.listMeisai_4 = 帳票出力対象.get明細テータ().getサービス種類名();
        source.listMeisai_5 = doカンマ編集(帳票出力対象.get明細テータ().get件数());
        source.listMeisai_6 = doカンマ編集(帳票出力対象.get明細テータ().get日数_回数());
        source.listMeisai_7 = doカンマ編集(帳票出力対象.get明細テータ().get単位数());
        source.listMeisai_8 = doカンマ編集(帳票出力対象.get明細テータ().get金額());
        source.listMeisai_9 = doカンマ編集(帳票出力対象.get明細テータ().get介護給付費_総合事業費());
        source.listMeisai_10 = doカンマ編集(帳票出力対象.get明細テータ().get利用者負担額());
        source.listMeisai_11 = doカンマ編集(帳票出力対象.get明細テータ().get公費負担額());
        if (出力Flag) {
            source.kogakuKensu = doカンマ編集(帳票出力対象.get高額テータ().get高額_高額該当件数());
            source.kogakuServicegaku = doカンマ編集(帳票出力対象.get高額テータ().get高額_高額介護サービス費());
            source.kogakuKohiFutangaku = doカンマ編集(帳票出力対象.get高額テータ().get高額_公費負担額());
            source.gokeiKensu = doカンマ編集(帳票出力対象.get合計テータ().get合計_件数());
            source.gokeiTanisu = doカンマ編集(帳票出力対象.get合計テータ().get合計_単位数());
            source.gokeiKingaku = doカンマ編集(帳票出力対象.get合計テータ().get合計_金額());
            source.gokeiKaigoKyufugaku = doカンマ編集(帳票出力対象.get合計テータ().get合計_介護給付費_総合事業費());
            source.gokeiRiyoshaFutangaku = doカンマ編集(帳票出力対象.get合計テータ().get合計_利用者負担額());
            source.gokeiKohiFutangaku = doカンマ編集(帳票出力対象.get合計テータ().get合計_公費負担額());
        }
        return source;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
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
}
