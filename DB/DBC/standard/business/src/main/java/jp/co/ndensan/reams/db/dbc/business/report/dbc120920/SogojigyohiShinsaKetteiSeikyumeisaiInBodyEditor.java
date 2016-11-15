/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120920;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1611SinsaKetteiSeikyuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1612SinsaKetteiSeikyuKogakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1613SinsaKetteiSeikyuGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200084_総合事業費審査決定請求明細表帳票BodyEditor
 *
 * @reamsid_L DBC-2500-032 jiangxiaolong
 */
public class SogojigyohiShinsaKetteiSeikyumeisaiInBodyEditor
        implements ISogojigyohiShinsaKetteiSeikyumeisaiInEditor {

    private final SogojigyohiShinsaKetteiSeikyumeisaiInEntity 帳票出力対象データ;
    private final boolean 集計Flag;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiShinsaKetteiSeikyumeisaiInEntity
     * @param 集計Flag boolean
     */
    public SogojigyohiShinsaKetteiSeikyumeisaiInBodyEditor(
            SogojigyohiShinsaKetteiSeikyumeisaiInEntity 帳票出力対象データ, boolean 集計Flag) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
    }

    @Override
    public SogojigyohiShinsaKetteiSeikyumeisaihyoSource edit(
            SogojigyohiShinsaKetteiSeikyumeisaihyoSource source) {
        edit明細(source);
        if (集計Flag) {
            edit高額(source);
            edit集計(source);
        }
        return source;
    }

    private void edit明細(SogojigyohiShinsaKetteiSeikyumeisaihyoSource source) {
        DbWT1611SinsaKetteiSeikyuMeisaiEntity 審査決定請求明細一時TBL = 帳票出力対象データ.get審査決定請求明細一時TBL();
        source.listMeisai_1 = getColumnValue(審査決定請求明細一時TBL.get事業所番号());
        source.listMeisai_2 = 審査決定請求明細一時TBL.get事業所名();
        source.listMeisai_3 = doパターン54(審査決定請求明細一時TBL.getサービス提供年月());
        source.listMeisai_4 = 審査決定請求明細一時TBL.getサービス種類名();
        source.serviceShuruiCode = getColumnValue(審査決定請求明細一時TBL.getサービス種類コード());
        source.listMeisai_5 = doカンマ編集(審査決定請求明細一時TBL.get件数());
        source.listMeisai_6 = doカンマ編集(審査決定請求明細一時TBL.get日数_回数());
        source.listMeisai_7 = doカンマ編集(審査決定請求明細一時TBL.get単位数());
        source.listMeisai_8 = doカンマ編集(審査決定請求明細一時TBL.get金額());
        source.listMeisai_9 = doカンマ編集(審査決定請求明細一時TBL.get介護給付費_総合事業費());
        source.listMeisai_10 = doカンマ編集(審査決定請求明細一時TBL.get利用者負担額());
        source.listMeisai_11 = doカンマ編集(審査決定請求明細一時TBL.get公費負担額());
    }

    private void edit集計(SogojigyohiShinsaKetteiSeikyumeisaihyoSource source) {
        DbWT1613SinsaKetteiSeikyuGokeiEntity 審査決定請求合計一時TBL = 帳票出力対象データ.get審査決定請求合計一時TBL();
        source.gokeiKensu = doカンマ編集(審査決定請求合計一時TBL.get合計_件数());
        source.gokeiTanisu = doカンマ編集(審査決定請求合計一時TBL.get合計_単位数());
        source.gokeiKingaku = doカンマ編集(審査決定請求合計一時TBL.get合計_金額());
        source.gokeiKaigoKyufugaku = doカンマ編集(審査決定請求合計一時TBL.get合計_介護給付費_総合事業費());
        source.gokeiRiyoshaFutangaku = doカンマ編集(審査決定請求合計一時TBL.get合計_利用者負担額());
        source.gokeiKohiFutangaku = doカンマ編集(審査決定請求合計一時TBL.get合計_公費負担額());
    }

    private void edit高額(SogojigyohiShinsaKetteiSeikyumeisaihyoSource source) {
        DbWT1612SinsaKetteiSeikyuKogakuEntity 審査決定請求高額一時TBL = 帳票出力対象データ.get審査決定請求高額一時TBL();
        source.kogakuKensu = doカンマ編集(審査決定請求高額一時TBL.get高額_高額該当件数());
        source.kogakuServicegaku = doカンマ編集(審査決定請求高額一時TBL.get高額_高額介護サービス費());
        source.kogakuKohiFutangaku = doカンマ編集(審査決定請求高額一時TBL.get高額_公費負担額());
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

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
