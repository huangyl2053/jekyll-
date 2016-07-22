/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.DbWT3054KogakuKyufuTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.KyuufuTaishoshaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額介護サービス費給付対象者一覧表帳票BodyEditor
 *
 * @reamsid_L DBC-0980-490 surun
 */
public class KogakuKyufuTaishoshaIchiranBodyEditor implements IKogakuKyufuTaishoshaIchiranEditor {

    private final KyuufuTaishoshaHihokenshaEntity 帳票出力対象データ;
    private final Boolean 集計Flag;
    private final Boolean 被保険者氏名Flag;
    private static final RString 漢字_計 = new RString("「計」");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KyuufuTaishoshaHihokenshaEntity
     * @param 集計Flag boolean
     * @param 被保険者氏名Flag Boolean
     */
    public KogakuKyufuTaishoshaIchiranBodyEditor(KyuufuTaishoshaHihokenshaEntity 帳票出力対象データ,
            Boolean 集計Flag, Boolean 被保険者氏名Flag) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
        this.被保険者氏名Flag = 被保険者氏名Flag;
    }

    @Override
    public KogakuKyufuTaishoshaIchiranSource edit(KogakuKyufuTaishoshaIchiranSource source) {
        DbWT3054KogakuKyufuTaishoshaTempEntity 対象者 = 帳票出力対象データ.get対象者();
        DbWT0001HihokenshaTempEntity 被保険者一時 = 帳票出力対象データ.get被保険者一時();
        if (!集計Flag) {
            source.listUpper_1 = 対象者.getNo();
            source.listUpper_4 = getColumnValue(対象者.get事業所番号());
            source.listUpper_5 = getColumnValue(対象者.getサービス種類コード());
            source.listUpper_6 = doカンマ編集(対象者.getサービス費用合計額());
            source.listUpper_7 = RString.EMPTY;
            source.listUpper_8 = RString.EMPTY;
            source.listUpper_9 = doパターン12(被保険者一時.get資格喪失日());
            source.listUpper_10 = 対象者.get備考();
            if (被保険者氏名Flag) {
                source.listUpper_2 = getColumnValue(被保険者一時.get登録被保険者番号());
                source.listUpper_3 = doパターン54(対象者.getサービス提供年月());
                source.listLower_1 = 被保険者一時.get宛名名称();
            }
            source.listLower_2 = 対象者.get事業所名();
            source.listLower_3 = 対象者.getサービス種類名();
            source.listLower_4 = doカンマ編集(対象者.get利用者負担額());
            source.listLower_5 = RString.EMPTY;
        } else {
            source.listUpper_3 = 漢字_計;
            source.listUpper_6 = doカンマ編集(対象者.getサービス費用合計額合計());
            source.listUpper_7 = doカンマ編集(対象者.get算定基準額());
            source.listUpper_8 = doカンマ編集(対象者.get高額支給額());
            source.listLower_4 = doカンマ編集(対象者.get利用者負担額合計());
            source.listLower_5 = doカンマ編集(対象者.get支払済金額合計());
        }
        return source;
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString doパターン12(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
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
