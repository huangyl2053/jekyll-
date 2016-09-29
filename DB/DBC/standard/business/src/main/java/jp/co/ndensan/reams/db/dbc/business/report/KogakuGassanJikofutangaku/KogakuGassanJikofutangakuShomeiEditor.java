/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.KogakuGassanJikofutangaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Idokubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.GassanJikofutangakuShomeishoTorikomiIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoDateEntity;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200034_高額合算自己負担額証明書情報取込一覧表のEntityです。
 *
 * @reamsid_L DBC-2640-030 zhengshenlei
 */
public class KogakuGassanJikofutangakuShomeiEditor implements IKogakuGassanJikofutangakuShomeiEditor {

    private final FlexibleYearMonth 処理年月;
    private final KogakuGassanJikofutangakuShomeishoDateEntity entity;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;
    private final YMDHMS システム日時;
    private final int 連番;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 図形 = new RString("～");
    private static final RString 差異有り = new RString("差異有り");

    /**
     * コンストラクタです
     *
     * @param 処理年月 FlexibleYearMonth
     * @param entity ChohyoShutsuryokuTaishoDateEntity
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     * @param システム日時 YMDHMS
     * @param 連番 int
     */
    public KogakuGassanJikofutangakuShomeiEditor(
            FlexibleYearMonth 処理年月,
            KogakuGassanJikofutangakuShomeishoDateEntity entity,
            RString 並び順の１件目,
            RString 並び順の２件目,
            RString 並び順の３件目,
            RString 並び順の４件目,
            RString 並び順の５件目,
            List<RString> 改頁項目List,
            YMDHMS システム日時,
            int 連番) {
        this.処理年月 = 処理年月;
        this.entity = entity;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
        this.システム日時 = システム日時;
        this.連番 = 連番;
    }

    @Override
    public GassanJikofutangakuShomeishoTorikomiIchiranSource edit(GassanJikofutangakuShomeishoTorikomiIchiranSource source) {
        RString 帳票作成年月日 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成日時 = システム日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成日時)
                .concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.shoriYM = 処理年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.hokenshaNo = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (entity != null) {
            source.shoKisaiHokenshaNo = entity.get高額合算自己負担額_保険者番号().value();
            source.shoKisaiHokenshaName = entity.get高額合算自己負担額_保険者名();
            set出力順And改ページ(source);
            source.list_1 = new RString(連番);
            source.list_2 = entity.get高額合算自己負担額_対象年度().toDateString();
            source.list_3 = entity.get被保険者_登録被保険者番号();
            source.list_4 = entity.get被保険者_宛名名称();
            source.list_5 = entity.get高額合算自己負担額_支給申請書整理番号();
            source.list_6 = new RString(entity.get高額合算自己負担額_履歴番号());
            source.list_7 = entity.get高額合算自己負担額_申請年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            source.list_8 = KaigoGassan_Idokubun.toValue(entity.get高額合算自己負担額_異動区分()).get名称();
            RString 被保険者期間開始年月日 = 年月日編集(entity.get高額合算自己負担額_被保険者期間開始年月日());
            RString 被保険者期間終了年月日 = 年月日編集(entity.get高額合算自己負担額_被保険者期間終了年月日());
            RString 対象計算期間開始年月日 = 年月日編集(entity.get高額合算自己負担額_対象計算期間開始年月日());
            RString 対象計算期間終了年月日 = 年月日編集(entity.get高額合算自己負担額_対象計算期間終了年月日());
            source.list_9 = 被保険者期間開始年月日.concat(図形).concat(被保険者期間終了年月日);
            source.list_10 = 対象計算期間開始年月日.concat(図形).concat(対象計算期間終了年月日);
            source.list_11 = entity.get高額合算自己負担額_自己負担額証明書整理番号();
            source.list_12 = new RString(entity.get高額合算自己負担額_合計_自己負担額().toString());
            source.list_13 = new RString(entity.get高額合算自己負担額_合計_70_74自己負担額_内訳().toString());
            if (entity.is高額合算自己負担額_自己負担額差異フラグ()) {
                source.list_14 = 差異有り;
            } else {
                source.list_14 = RString.EMPTY;
            }
        }
        return source;
    }

    private void set出力順And改ページ(GassanJikofutangakuShomeishoTorikomiIchiranSource source) {
        source.shutsuryokujun1 = 並び順の１件目;
        source.shutsuryokujun2 = 並び順の２件目;
        source.shutsuryokujun3 = 並び順の３件目;
        source.shutsuryokujun4 = 並び順の４件目;
        source.shutsuryokujun5 = 並び順の５件目;
        if (null != 改頁項目List && !改頁項目List.isEmpty()) {
            if (改頁項目List.size() > NUM_0) {
                source.kaipage1 = 改頁項目List.get(NUM_0);
            }
            if (改頁項目List.size() > NUM_1) {
                source.kaipage2 = 改頁項目List.get(NUM_1);
            }
            if (改頁項目List.size() > NUM_2) {
                source.kaipage3 = 改頁項目List.get(NUM_2);
            }
            if (改頁項目List.size() > NUM_3) {
                source.kaipage4 = 改頁項目List.get(NUM_3);
            }
            if (改頁項目List.size() > NUM_4) {
                source.kaipage5 = 改頁項目List.get(NUM_4);
            }
        }
    }

    private RString 年月日編集(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
