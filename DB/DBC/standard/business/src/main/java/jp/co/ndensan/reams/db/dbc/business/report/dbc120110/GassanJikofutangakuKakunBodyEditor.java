/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120110;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Idokubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110.KogakuGassanJikofutangakuKakunEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120110.GassanJikofutangakuKakuninSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額合算自己負担額確認情報取込一覧表BodyEditor。
 *
 * @reamsid_L DBC-2650-030 chenjie
 */
public class GassanJikofutangakuKakunBodyEditor implements IGassanJikofutangakuKakunEditor {

    private final KogakuGassanJikofutangakuKakunEntity 帳票出力対象データ;
    private final int 連番;
    private final RString line = new RString(" ～ ");
    private final RString nendo = new RString("年度");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KogakuGassanJikofutangakuKakunEntity
     * @param 連番 int
     */
    public GassanJikofutangakuKakunBodyEditor(KogakuGassanJikofutangakuKakunEntity 帳票出力対象データ, int 連番) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.連番 = 連番;
    }

    @Override
    public GassanJikofutangakuKakuninSource edit(GassanJikofutangakuKakuninSource source) {
        source.list_1 = new RString(連番);
        source.list_2 = 帳票出力対象データ.get被保険者番号();
        source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                source.list_2);
        source.list_3 = 帳票出力対象データ.get被保険者氏名();
        source.list_4 = 帳票出力対象データ.get支給申請書整理番号();
        source.list_5 = doパターン307(帳票出力対象データ.get対象年度());
        source.list_6 = new RString(帳票出力対象データ.get履歴番号());
        source.list_7 = doパターン4(帳票出力対象データ.get申請年月日());
        source.list_8 = get異動区分(帳票出力対象データ.get異動区分コード());
        source.list_9 = get期間(帳票出力対象データ.get介護加入期間_開始(), 帳票出力対象データ.get介護加入期間_終了());
        source.list_10 = get期間(帳票出力対象データ.get対象計算期間_開始(), 帳票出力対象データ.get対象計算期間_終了());
        source.list_11 = doカンマ編集(帳票出力対象データ.get自己負担額合計());
        source.list_12 = doカンマ編集(帳票出力対象データ.get自己負担額合計_うち70_74歳());
        source.list_13 = doカンマ編集(帳票出力対象データ.get高額介護サービス費());
        source.shikibetsuCode = getColumnValue(帳票出力対象データ.get識別コード());
        return source;
    }

    private RString get期間(FlexibleDate 開始年月日, FlexibleDate 終了年月日) {
        return doパターン4(開始年月日).concat(line).concat(doパターン4(終了年月日));
    }

    private RString doパターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString get異動区分(RString 異動区分コード) {
        if (!RString.isNullOrEmpty(異動区分コード)) {
            return KaigoGassan_Idokubun.toValue(異動区分コード).get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString doパターン307(FlexibleYear 年度) {
        if (null == 年度) {
            return RString.EMPTY;
        }
        return 年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                fillType(FillType.BLANK).toDateString().concat(nendo);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
