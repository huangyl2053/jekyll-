/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehisofuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehisofuichiran.KogakuServicehiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200019_高額介護サービス費給付判定結果送付一覧表のEditorrクラスです。
 *
 * @reamsid_L DBC-2610-040 qinzhen
 */
public class KogakuServicehiSofuIchiranEditor implements
        IKogakuServicehiSofuIchiranEditor {

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    private static final int INDEX_0 = 0;
    private static final int INDEX_20 = 20;
    private static final int INDEX_40 = 40;
    private static final int INDEX_60 = 60;

    private static final RString 日時作成 = new RString("作成");
    private static final RString 接続文字 = new RString(":");
    private static final Code DATA_3 = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    private final List<RString> 改頁リスト;
    private final List<RString> 並び順リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final int 連番;
    private final KogakuServicehiHanteiIchiranhyoTaisyoEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuServicehiHanteiIchiranhyoTaisyoEntity
     * @param 並び順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     *
     */
    public KogakuServicehiSofuIchiranEditor(KogakuServicehiHanteiIchiranhyoTaisyoEntity entity, List<RString> 並び順リスト,
            List<RString> 改頁リスト, FlexibleYearMonth 処理年月, RDateTime 作成日時, int 連番) {
        this.entity = entity;
        this.並び順リスト = 並び順リスト;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
    }

    @Override
    public KogakuServicehiSofuIchiranSource edit(KogakuServicehiSofuIchiranSource source) {

        source.printTimeStamp = getSakuseiYmhm(作成日時);
        source.sofuYM = 処理年月.wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.hokenshaNo = entity.get高額介護_保険者番号().value();
        source.hokenshaName = entity.get高額介護_保険者名();

        source.shutsuryokujun1 = get並び順(INDEX_1);
        source.shutsuryokujun2 = get並び順(INDEX_2);
        source.shutsuryokujun3 = get並び順(INDEX_3);
        source.shutsuryokujun4 = get並び順(INDEX_4);
        source.shutsuryokujun5 = get並び順(INDEX_5);
        source.kaipage1 = get改頁(INDEX_1);
        source.kaipage2 = get改頁(INDEX_2);
        source.kaipage3 = get改頁(INDEX_3);
        source.kaipage4 = get改頁(INDEX_4);
        source.kaipage5 = get改頁(INDEX_5);

        source.listCenter_1 = new RString(連番);

        if (entity.get高額介護_被保険者番号() != null) {
            source.listCenter_2 = entity.get高額介護_被保険者番号().value();
        }
        source.拡張情報 = new ExpandedInformation(DATA_3, 被保険者番号, get非空文字列(source.listCenter_2));
        source.listUpper_1 = entity.get被保険者_宛名カナ名称();
        source.listLower_1 = entity.get被保険者_宛名名称();
        source.listUpper_2 = entity.get被保険者_町域コード();
        source.listUpper_3 = entity.get被保険者_郵便番号();

        source.listUpper_4 = getlistUpper_4(entity.get被保険者_住所(), entity.get被保険者_番地(), entity.get被保険者_方書());
        source.listLower_2 = entity.get被保険者_行政区コード();
        source.listLower_3 = entity.get被保険者_行政区名();
        source.listLower_4 = entity.get高額介護_サービス提供年月().wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        source.listLower_5 = getlistLower_5(entity.get高額介護_支給区分コード());
        source.listLower_6 = getlistLower_6(entity.get高額介護_審査方法区分());

        if (entity.get高額介護_受付年月日() != null) {
            source.listUpper_5 = entity.get高額介護_受付年月日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).
                    toDateString();
        }
        source.listLower_7 = entity.get高額介護_決定年月日().wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString();

        source.listUpper_6 = doカンマ編集(entity.get高額介護_本人支払額());
        source.listLower_8 = doカンマ編集(entity.get高額介護_支給金額());

        if (entity.get高額介護_不支給理由().length() <= INDEX_20) {
            source.listUpper_7 = entity.get高額介護_不支給理由();
        } else if (entity.get高額介護_不支給理由().length() <= INDEX_40) {
            source.listUpper_7 = entity.get高額介護_不支給理由().substring(INDEX_0, INDEX_20);
            source.listCenter_3 = entity.get高額介護_不支給理由().substring(INDEX_20);
        } else {
            source.listUpper_7 = entity.get高額介護_不支給理由().substring(INDEX_0, INDEX_20);
            source.listCenter_3 = entity.get高額介護_不支給理由().substring(INDEX_20, INDEX_40);

            if (entity.get高額介護_不支給理由().length() <= INDEX_60) {
                source.listLower_9 = entity.get高額介護_不支給理由().substring(INDEX_40);
            } else {
                source.listLower_9 = entity.get高額介護_不支給理由().substring(INDEX_40, INDEX_60);
            }
        }

        source.shikibetsuCode = entity.get被保険者_識別コード().value();

        return source;

    }

    private RString getSakuseiYmhm(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();

    }

    private RString getlistUpper_4(RString jusho, RString banchi, RString katagaki) {
        RStringBuilder sakuseiYMD = new RStringBuilder();
        sakuseiYMD.append(jusho);
        sakuseiYMD.append(banchi);
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(katagaki);

        return sakuseiYMD.toRString();
    }

    private RString getlistLower_5(RString コード) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(コード);
        sakuseiYMD.append(接続文字);
        sakuseiYMD.append(ShikyuKubun.toValue(コード).get名称());

        return sakuseiYMD.toRString();

    }

    private RString getlistLower_6(RString コード) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(コード);
        sakuseiYMD.append(接続文字);
        sakuseiYMD.append(ShinsaHohoKubun.toValue(コード).get名称());

        return sakuseiYMD.toRString();

    }

    private RString get並び順(int index) {
        return index < 並び順リスト.size() ? 並び順リスト.get(index) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }
}
