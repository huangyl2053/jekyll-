/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutanwariai.KoseiJiyu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.FutanwariaiHanteiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaihanteiichiran.FutanWariaiHanteiIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 負担割合判定一覧表のBodyEditorクラスです。
 *
 * @reamsid_L DBC-4980-040 yuanzhenxia
 */
public class FutanWariaiHanteiIchiranEditor implements IFutanWariaiHanteiIchiranEditor {

    private static final RString 処理区分3 = new RString("3");
    private static final RString 処理区分2 = new RString("2");
    private static final RString 処理区分1 = new RString("1");
    private static final RString 本人未申告 = new RString("本人未申告");
    private static final RString 本人調査中 = new RString("本人調査中");
    private static final RString 本人非課税 = new RString("本人非課税");
    private static final RString 利 = new RString("利");
    private static final RString 率 = new RString("％");
    private static final RString 生活保護 = new RString("生活保護");
    private static final RString 旧措置 = new RString("旧措置");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 年 = new RString("年");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private static final RString HALFMONTH = new RString("#0");
    private RString 利用者負担割合判定管理_年度終了月日;
    private final FutanWariaiHanteiIchiranProcessParameter processParameter;
    private final FutanwariaiHanteiIchiranEntity entity;

    /**
     * コンストラクタです。
     *
     * @param processParameter FutanWariaiHanteiIchiranProcessParameter
     * @param entity FutanwariaiHanteiIchiranEntity
     */
    public FutanWariaiHanteiIchiranEditor(FutanWariaiHanteiIchiranProcessParameter processParameter, FutanwariaiHanteiIchiranEntity entity) {
        this.processParameter = processParameter;
        this.entity = entity;
        initialize();
    }

    private void initialize() {
        利用者負担割合判定管理_年度終了月日 = BusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
    }

    @Override
    public FutanWariaiHanteiIchiranSource edit(FutanWariaiHanteiIchiranSource source) {
        source.cityCode = entity.get地方公共団体コード();
        source.cityMei = entity.get市町村名();
        source.kijunYmd = edit基準日(entity.get今回年度());
        source.listList1_1 = entity.get今回被保険者番号().value();
        source.listList1_2 = edit被保険者区分コード(entity.get被保険者区分コード());
        // source.listList1_3  =
        source.listList1_4 = edit負担割合区分(entity.get今回負担割合区分());
        source.listList1_5 = DateConverter.decimalFormat(entity.get今回本人合計所得金額());
        source.listList1_6 = new RString(entity.get今回世帯１号被保険者数());
        source.listList1_7 = edit負担割合区分(entity.get前回負担割合区分());
        source.listList1_8 = DateConverter.decimalFormat(entity.get前回本人合計所得金額());
        source.listList1_9 = new RString(entity.get前回世帯１号被保険者数());
        source.listList1_10 = edit課税区分(entity.get課税区分_減免前());
        source.listList2_1 = getWarekiYmd(entity.get資格取得年月日());
        source.listList2_2 = getWarekiYmd(entity.get認定有効期間開始年月日());
        source.listList2_3 = getWarekiYmd(entity.get今回有効開始日());
        source.listList2_4 = DateConverter.decimalFormat(entity.get今回年金収入合計());
        source.listList2_5 = DateConverter.decimalFormat(entity.get今回その他の合計所得金額合計());
        source.listList2_6 = getWarekiYmd(entity.get前回有効開始日());
        source.listList2_7 = DateConverter.decimalFormat(entity.get前回年金収入合計());
        source.listList2_8 = DateConverter.decimalFormat(entity.get前回その他の合計所得金額合計());
        source.listList2_9 = edit減免(entity.get給付率());
        source.listList3_1 = getWarekiYmd(entity.get資格喪失年月日());
        source.listList3_2 = getWarekiYmd(entity.get認定有効期間終了年月日());
        source.listList3_3 = getWarekiYmd(entity.get今回有効終了日());
        source.listList3_4 = edit更正事由(entity.get今回更正事由().value());
        source.listList3_5 = getWarekiYmd(entity.get前回有効終了日());
        source.listList3_6 = edit更正事由(entity.get前回更正事由().value());
        source.listList3_7 = editその他();
        source.listList4_1 = new RString(entity.get連番()).padZeroToLeft(2);
        source.listList5_1 = entity.get名称().value();
        source.nendo = edit年度();
        source.shori = edit処理名();
        source.shoriYmd = edit処理日(processParameter.get処理日時());
        source.sort1 = 被保険者番号;
        return source;

    }

    private RString edit基準日(FlexibleYear year) {
        if (!処理区分3.equals(processParameter.get処理区分())) {
            return getWarekiYmd(processParameter.get基準日());
        } else {
            return getWarekiYmd(new FlexibleDate(year.toDateString().concat(利用者負担割合判定管理_年度終了月日).toString()));
        }
    }

    private RString edit被保険者区分コード(RString code) {
        if (HihokenshaKubunCode.第１号被保険者.getコード().equals(code)) {
            return HihokenshaKubunCode.第１号被保険者.get名称();
        } else if (HihokenshaKubunCode.第２号被保険者.getコード().equals(code)) {
            return HihokenshaKubunCode.第２号被保険者.get名称();
        } else if (HihokenshaKubunCode.その他.getコード().equals(code)) {
            return HihokenshaKubunCode.その他.get名称();
        } else {
            return RString.EMPTY;
        }
    }
//    private RString edit要介護度(){
//    }

    private RString edit負担割合区分(RString code) {
        if (FutanwariaiKubun._１割.getコード().equals(code)) {
            return FutanwariaiKubun._１割.get名称();
        } else if (FutanwariaiKubun._２割.getコード().equals(code)) {
            return FutanwariaiKubun._２割.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit課税区分(RString code) {
        if (KazeiKubun.未申告.getコード().equals(code)) {
            return 本人未申告;
        } else if (KazeiKubun.所得調査中.getコード().equals(code)) {
            return 本人調査中;
        } else if (KazeiKubun.非課税.getコード().equals(code)) {
            return 本人非課税;
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit減免(RString 給付率) {
        if (!給付率.isEmpty()) {
            return 利.concat(給付率).concat(率);
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit更正事由(RString code) {
        if (KoseiJiyu.世帯員所得更正.getコード().equals(code)) {
            return KoseiJiyu.世帯員所得更正.get名称();
        } else if (KoseiJiyu.世帯構成変更.getコード().equals(code)) {
            return KoseiJiyu.世帯構成変更.get名称();
        } else if (KoseiJiyu.本人所得更正.getコード().equals(code)) {
            return KoseiJiyu.本人所得更正.get名称();
        } else if (KoseiJiyu.当初_継続_新規認定.getコード().equals(code)) {
            return KoseiJiyu.当初_継続_新規認定.get名称();
        } else if (KoseiJiyu.その他.getコード().equals(code)) {
            return KoseiJiyu.その他.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString editその他() {
        if (entity.get生活保護受給者識別コード() != null && !entity.get生活保護受給者識別コード().isEmpty()) {
            return 生活保護;
        }
        if (entity.get旧措置者フラグ()) {
            return 旧措置;
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit年度() {
        if (処理区分3.equals(processParameter.get処理区分())) {
            return DateConverter.getWarekiYear(new RYear(entity.get今回年度().toString()));
        } else {
            return DateConverter.getWarekiYear(new RYear(processParameter.get対象年度().toString()));
        }
    }

    private RString edit処理名() {
        if (処理区分1.equals(processParameter.get処理区分())) {
            return ShoriName.年次負担割合判定.get名称();
        } else if (処理区分2.equals(processParameter.get処理区分())) {
            return ShoriName.異動分負担割合判定.get名称();
        } else if (処理区分3.equals(processParameter.get処理区分())) {
            // TODO 異動分利用者負担割合判定（過年度）なし
            return ShoriName.異動分負担割合判定.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit処理日(RDateTime dateTime) {
        RString wareki = RString.EMPTY;
        if (dateTime != null) {
            wareki = dateTime.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.ZERO)
                    .getYear().concat(年).concat(dateTime.getDate().wareki().separator(Separator.JAPANESE)
                            .fillType(FillType.ZERO).getMonthDay())
                    .concat(new RString(new Decimal(dateTime.getHour()).toString(HALFMONTH.toString()))).concat(時)
                    .concat(new RString(new Decimal(dateTime.getMinute()).toString(HALFMONTH.toString()))).concat(分)
                    .concat(new RString(new Decimal(dateTime.getSecond()).toString(HALFMONTH.toString()))).concat(秒);
        }
        return wareki;

    }

    private RString getWarekiYmd(FlexibleDate date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.ZERO).getYear()
                    .concat(年).concat(date.wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).getMonthDay());
        }
        return wareki;
    }

}
