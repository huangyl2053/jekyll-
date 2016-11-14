/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.koseitaishojissekiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200097_更正対象給付実績一覧表のEditorrクラスです。
 *
 * @reamsid_L DBC-4960-040 qinzhen
 */
public class KoseiTaishoJissekiIchiranEditor implements
        IKoseiTaishoJissekiIchiranEditor {

    private static final RString INDEX_1 = new RString("1");
    private static final RString INDEX_2 = new RString("2");
    private static final RString 前符号タイトル = new RString("※");
    private static final RString 年度タイトル = new RString("年度");
    private static final RString 被保険者番号タイトル = new RString("被保険者番号");
    private static final RString 日時作成 = new RString("作成");
    private static final RString サービス提供年月タイトル = new RString("サービス提供年月");
    private static final RString タイトル = new RString("更正対象給付実績一覧表");
    private final RDateTime 開始日時;
    private final RDateTime 終了日時;

    private final int 連番;
    private final KoseiTaishoJissekiIchiranEntity entity;
    private final RString 出力順;

    /**
     * コンストラクタです
     *
     * @param entity KoseiTaishoJissekiIchiranEntity
     * @param 開始日時 RDateTime
     * @param 終了日時 RDateTime
     * @param 出力順 RString
     * @param 連番 int
     *
     */
    public KoseiTaishoJissekiIchiranEditor(KoseiTaishoJissekiIchiranEntity entity,
            RDateTime 開始日時, RDateTime 終了日時, RString 出力順, int 連番) {
        this.entity = entity;
        this.開始日時 = 開始日時;
        this.終了日時 = 終了日時;
        this.出力順 = 出力順;
        this.連番 = 連番;
    }

    @Override
    public KoseiTaishoJissekiIchiranSource edit(KoseiTaishoJissekiIchiranSource source) {
        source.title = タイトル;
        source.printTimeStamp = getSakuseiYmhm(RDateTime.now()).concat(RString.HALF_SPACE).concat(日時作成);
        source.kaishiTimestamp = getSakuseiYmhm(開始日時);
        source.shuryoTimestamp = getSakuseiYmhm(終了日時);
        if (entity.get地方公共団体コード() != null) {
            source.cityCode = entity.get地方公共団体コード().value();
        }

        source.cityName = entity.get市町村名();

        if (INDEX_1.equals(出力順)) {
            source.sort1 = 年度タイトル;
            source.sort2 = 被保険者番号タイトル;
            source.sort3 = サービス提供年月タイトル;
        } else if (INDEX_2.equals(出力順)) {
            source.sort1 = 被保険者番号タイトル;
            source.sort2 = 年度タイトル;
            source.sort3 = サービス提供年月タイトル;
        }

        if (連番 != 0) {
            source.listKyufuJisseki_1 = new RString(連番);
        }

        if (entity.get被保険者番号() != null) {
            source.listKyufuJisseki_2 = entity.get被保険者番号();
        }

        source.listKyufuJisseki_3 = entity.get氏名();
        if (entity.get年度() != null) {
            source.listKyufuJisseki_4 = entity.get年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    fillType(FillType.BLANK).toDateString();
        }

        if (entity.getサービス提供年月() != null) {
            source.listKyufuJisseki_5 = entity.getサービス提供年月().wareki().firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }

        source.listKyufuJisseki_6 = entity.get入力識別番号();
        source.listKyufuJisseki_7 = entity.get事業者番号();
        source.listKyufuJisseki_8 = entity.get整理番号();
        source.listKyufuJisseki_9 = entity.getサービス種類();

        source.listKyufuJisseki_10 = doカンマ編集(entity.getサービス費用額());
        if (連番 != 0 && !doカンマ編集(entity.get軽減率()).isEmpty()) {
            source.listKyufuJisseki_11 = 前符号タイトル.concat(doカンマ編集(entity.get軽減率()));
        }
        source.listKyufuJisseki_13 = doカンマ編集(entity.get更正前給付率());
        source.listKyufuJisseki_14 = doカンマ編集(entity.get更正前請求額());
        source.listKyufuJisseki_15 = doカンマ編集(entity.get更正前自己負担額());
        source.listKyufuJisseki_16 = doカンマ編集(entity.get更正後給付率());
        source.listKyufuJisseki_17 = doカンマ編集(entity.get更正後請求額());
        source.listKyufuJisseki_18 = doカンマ編集(entity.get更正後自己負担額());
        source.listKyufuJisseki_19 = doカンマ編集(entity.get自己負担差額());
        if (連番 == 0 && !doカンマ編集(entity.get高額サービス費用額()).isEmpty()) {
            source.listKyufuJisseki_12 = 前符号タイトル.concat(doカンマ編集(entity.get高額サービス費用額()));
        }
        source.listKyufuJisseki_19 = doカンマ編集(entity.get自己負担差額());
        return source;

    }

    private RString getSakuseiYmhm(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));

        return sakuseiYMD.toRString();

    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }
}
