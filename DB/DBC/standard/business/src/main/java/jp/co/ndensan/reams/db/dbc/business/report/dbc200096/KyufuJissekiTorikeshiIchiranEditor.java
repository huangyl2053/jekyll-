/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200096;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KoseitaishoKyuhuzissekiJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200096.KyufuJissekiTorikeshiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200096_給付実績取消一覧表Editor
 *
 * @reamsid_L DBC-4960-050 jiangxiaolong
 */
public class KyufuJissekiTorikeshiIchiranEditor
        implements IKyufuJissekiTorikeshiIchiranEditor {

    private final KoseitaishoKyuhuzissekiJohoTempEntity entity;
    private final RDateTime 抽出期間開始日時;
    private final RDateTime 抽出期間終了日時;
    private final Association association;
    private final RString 出力順;
    private final int 連番;
    private static final RString SAKUSEI = new RString("作成");
    private static final RString INDEX_1 = new RString("1");
    private static final RString 前符号タイトル = new RString("※");
    private static final RString 年度タイトル = new RString("年度");
    private static final RString 被保険者番号タイトル = new RString("被保険者番号");
    private static final RString サービス提供年月タイトル = new RString("サービス提供年月");
    private static final RString 給付実績取消一覧表 = new RString("給付実績取消一覧表");

    /**
     * コンストラクタです
     *
     * @param entity KoseitaishoKyuhuzissekiJohoTempEntity
     * @param 抽出期間開始日時 RDateTime
     * @param 抽出期間終了日時 RDateTime
     * @param association Association
     * @param 出力順 RString
     * @param 連番 int
     */
    public KyufuJissekiTorikeshiIchiranEditor(
            KoseitaishoKyuhuzissekiJohoTempEntity entity, RDateTime 抽出期間開始日時,
            RDateTime 抽出期間終了日時, RString 出力順, Association association, int 連番) {
        this.entity = entity;
        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
        this.出力順 = 出力順;
        this.association = association;
        this.連番 = 連番;
    }

    @Override
    public KyufuJissekiTorikeshiIchiranSource edit(
            KyufuJissekiTorikeshiIchiranSource source) {
        editSource(source);
        return source;
    }

    private void editSource(KyufuJissekiTorikeshiIchiranSource source) {
        source.printTimeStamp = get日時(RDateTime.now());
        source.kaishiTimestamp = get日時(this.抽出期間開始日時);
        source.shuryoTimestamp = get日時(this.抽出期間終了日時);
        source.title = 給付実績取消一覧表;
        if (null != association) {
            source.cityCode = getColumnValue(association.get地方公共団体コード());
            source.cityName = association.get市町村名();
        }
        if (出力順.equals(INDEX_1)) {
            source.sort1 = 年度タイトル;
            source.sort2 = 被保険者番号タイトル;
        } else {
            source.sort1 = 被保険者番号タイトル;
            source.sort2 = 年度タイトル;
        }

        source.sort3 = サービス提供年月タイトル;
        source.listKyufuJisseki_1 = new RString(this.連番);
        edit更正対象給付実績情報(source);

    }

    private void edit更正対象給付実績情報(KyufuJissekiTorikeshiIchiranSource source) {
        if (null == entity) {
            return;
        }
        source.listKyufuJisseki_2 = getColumnValue(entity.get被保険者番号());
        source.listKyufuJisseki_3 = entity.get氏名();
        source.listKyufuJisseki_4 = getパターン308(entity.get年度());
        source.listKyufuJisseki_5 = getパターン254(entity.getサービス提供年月());
        source.listKyufuJisseki_6 = getColumnValue(entity.get入力識別番号());
        source.listKyufuJisseki_7 = entity.get事業者番号();
        source.listKyufuJisseki_8 = entity.get整理番号();
        source.listKyufuJisseki_9 = entity.getサービス種類();
        source.listKyufuJisseki_10 = doカンマ編集(entity.getサービス費用額());
        if (!doカンマ編集(entity.get軽減率()).isEmpty()) {
            source.listKyufuJisseki_11 = 前符号タイトル;
        }
        if (null != entity.get更正前保険給付率()) {
            source.listKyufuJisseki_13 = doカンマ編集(entity.get更正前保険給付率().getColumnValue());
        }
        source.listKyufuJisseki_14 = doカンマ編集(entity.get更正前請求額());
        source.listKyufuJisseki_15 = doカンマ編集(entity.get更正前自己負担額());
    }

    private static RString getパターン254(FlexibleYearMonth date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki()
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString getパターン308(FlexibleYear date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString get日時(RDateTime 作成日時) {
        if (null != 作成日時) {
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
            return 作成日.concat(RString.HALF_SPACE).concat(作成時);
        }
        return RString.EMPTY;
    }
}
