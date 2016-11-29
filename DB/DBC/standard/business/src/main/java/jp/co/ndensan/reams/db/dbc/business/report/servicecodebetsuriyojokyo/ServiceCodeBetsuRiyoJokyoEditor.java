/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.servicecodebetsuriyojokyo;

import jp.co.ndensan.reams.db.dbc.business.report.servicecoderiyojokyo.ServicecodeRiyojokyoReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecoderiyojokyo.ServicecodeRiyojokyoReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.servicecodebetsuriyojokyo.ServiceCodeBetsuRiyoJokyoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC300002_サービスコード別利用状況のEditorrクラスです。
 *
 * @reamsid_L DBC-3340-040 qinzhen
 */
public class ServiceCodeBetsuRiyoJokyoEditor implements
        IServiceCodeBetsuRiyoJokyoEditor {

    private static final RString 日時作成 = new RString("作成");

    private final RDateTime 作成日時;
    private final ServicecodeRiyojokyoReport entity;
    private static final RString 合計 = new RString("合計");

    /**
     * コンストラクタです
     *
     * @param entity ServicecodeRiyojokyoReport
     * @param 作成日時 RDateTime
     *
     */
    public ServiceCodeBetsuRiyoJokyoEditor(ServicecodeRiyojokyoReport entity, RDateTime 作成日時) {
        this.entity = entity;
        this.作成日時 = 作成日時;
    }

    @Override
    public ServiceCodeBetsuRiyoJokyoSource edit(ServiceCodeBetsuRiyoJokyoSource source) {

        ServicecodeRiyojokyoReportEntity 明細リスト = entity.get明細リスト();

        source.printTimeStamp1 = getSakuseiYmhm(作成日時);

        source.joken1 = entity.get条件１();
        source.joken2 = entity.get条件２();
        source.joken3 = entity.get条件３();
        source.hokenshaNo1 = entity.get保険者番号().value();
        source.hokenshaName1 = entity.get保険者名();

        if (明細リスト.get種類コード() != null) {
            source.List1_1 = 明細リスト.get種類コード();
        } else {
            source.List1_1 = RString.EMPTY;
        }
        source.List1_2 = 明細リスト.get項目コード();
        source.List1_3 = 明細リスト.getサービス略称_上();

        source.List1_4 = doカンマ編集(明細リスト.get非該当日数_回数集計値());
        source.List1_5 = doカンマ編集(明細リスト.get要支援１日数_回数集計値());
        source.List1_6 = doカンマ編集(明細リスト.get要支援２日数_回数集計値());
        source.List1_7 = doカンマ編集(明細リスト.get経過的要介護日数_回数集計値());
        source.List1_8 = doカンマ編集(明細リスト.get要介護１日数_回数集計値());
        source.List1_9 = doカンマ編集(明細リスト.get要介護２日数_回数集計値());
        source.List1_10 = doカンマ編集(明細リスト.get要介護３日数_回数集計値());
        source.List1_11 = doカンマ編集(明細リスト.get要介護４日数_回数集計値());
        source.List1_12 = doカンマ編集(明細リスト.get要介護５日数_回数集計値());
        source.List1_13 = doカンマ編集(明細リスト.get日数_回数合計値());

        source.List2_1 = 明細リスト.getサービス略称_下();
        source.List2_2 = doカンマ編集(明細リスト.get非該当単位数集計値());
        source.List2_3 = doカンマ編集(明細リスト.get要支援１単位数集計値());
        source.List2_4 = doカンマ編集(明細リスト.get要支援２単位数集計値());
        source.List2_5 = doカンマ編集(明細リスト.get経過的要介護単位数集計値());
        source.List2_6 = doカンマ編集(明細リスト.get要介護１単位数集計値());
        source.List2_7 = doカンマ編集(明細リスト.get要介護２単位数集計値());
        source.List2_8 = doカンマ編集(明細リスト.get要介護３単位数集計値());
        source.List2_9 = doカンマ編集(明細リスト.get要介護４単位数集計値());
        source.List2_10 = doカンマ編集(明細リスト.get要介護５単位数集計値());
        source.List2_11 = doカンマ編集(明細リスト.get単位数合計値());

        source.title = entity.getタイトル();
        source.breakKey = 明細リスト.get種類コード();
        return source;

    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString getSakuseiYmhm(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK)
                .toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }
}
