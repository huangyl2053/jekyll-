/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShotokuJokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku.KijunShunyugakuDate;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShotokuJokyo.ShotokuJokyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShotokuJokyo.dgSteaiinShotoku_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.definition.core.memo.MemoShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.divcontroller.controller.commonchilddiv.memo.MemoNyuryoku.MemoNyuryokuHandler;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 画面設計_DBC_ShotokuJokyo_所得状況のクラスです。
 *
 * @reamsid_L DBC-4620-030 zhouchuanlin
 */
public class ShotokuJokyoHandler {

    private static final RString 照会モード = new RString("0");
    private static final RString 識別対象区分_個人 = new RString("個人");
    private static final RString 改行記号 = new RString("<br>");
    private static final Decimal 数値_38万 = new Decimal("380000");
    private static final Decimal 年齢_15 = new Decimal("15");
    private static final Decimal 年齢_16 = new Decimal("16");
    private static final Decimal 年齢_18 = new Decimal("18");
    private static final RString 文字列_識別対象コード = new RString("shikibetsuCode");
    private static final RString メモボタン = new RString("memo");
    private static final RString コンマ = new RString(",");
    private static final RString 時分秒 = new RString("000000");
    private final ShotokuJokyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShotokuJokyoDiv
     */
    public ShotokuJokyoHandler(ShotokuJokyoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div ShikibetsuBangoSelectorDiv
     * @return ShikibetsuBangoSelectorDivHandler
     */
    public static ShotokuJokyoHandler of(ShotokuJokyoDiv div) {
        return new ShotokuJokyoHandler(div);
    }

    /**
     * 所得状況的初期設定のメソッドです。
     *
     * @param hdnMode モード
     * @param hdnKijunYMD 世帯員把握基準日
     * @param hdnShoriNendo 処理年度
     * @param hdnShikibetuCode 識別コード
     */
    public void initialize(RString hdnMode, FlexibleDate hdnKijunYMD, FlexibleDate hdnShoriNendo, ShikibetsuCode hdnShikibetuCode) {
        RString 業務コード = GyomuCode.DB介護保険.getColumnValue();
        YMDHMS 所得基準年月日 = null;
        if (null != hdnKijunYMD) {
            所得基準年月日 = new YMDHMS((hdnKijunYMD.toString().concat(時分秒.toString())));
        }
        if (照会モード.equals(hdnMode)) {
            div.getBtnKakutei().setDisabled(true);
        } else {
            div.getBtnKakutei().setDisabled(false);
        }
        div.getTxtKijunYMD().setValue(hdnKijunYMD);
        div.getTxtShoriNendo().setValue(hdnShoriNendo);
        div.setHdnGyomuCode(業務コード);
        List<SetaiinShotoku> 世帯員所得情報リスト = SetaiinShotokuJohoFinder.createInstance().
                get世帯員所得情報(hdnShikibetuCode, hdnShoriNendo.getNendo(), 所得基準年月日);
        List<dgSteaiinShotoku_Row> rowList = set世帯員所得情報Grid(世帯員所得情報リスト, new FlexibleDate(RDateTime.now().getDate().toDateString()));
        div.getDgSteaiinShotoku().setDataSource(rowList);

        MemoNyuryokuHandler.dataGridupdateImage(new GyomuCode(div.getHdnGyomuCode()), SubGyomuCode.DBC介護給付, div.getDgSteaiinShotoku(),
                MemoShikibetsuTaisho.識別コード.get識別対象(), 文字列_識別対象コード, RString.EMPTY, RString.EMPTY,
                メモボタン);
    }

    /**
     * 世帯員情報クラス格納リストの設定メソッドです。
     *
     * @return List<KijunShunyugakuDate>　世帯員情報クラス格納リスト
     */
    public List<KijunShunyugakuDate> set世帯員情報クラス格納リスト() {
        List<KijunShunyugakuDate> list = new ArrayList<>();
        KijunShunyugakuDate item;
        RString 氏名 = RString.EMPTY;
        RString 氏名カナ = RString.EMPTY;
        RDate 生年月日;
        RDate 異動年月日;
        RDate 更正日;
        int length;
        for (dgSteaiinShotoku_Row row : div.getDgSteaiinShotoku().getSelectedItems()) {
            item = new KijunShunyugakuDate();
            item.set識別コード(row.getShikibetsuCode());
            item.set被保険者番号(row.getHihokenshaNo());
            length = row.getName().split(改行記号.toString()).size();
            if (length == 1) {
                氏名 = row.getName().split(改行記号.toString()).get(0);
            } else if (length == 2) {
                氏名 = row.getName().split(改行記号.toString()).get(0);
                氏名カナ = row.getName().split(改行記号.toString()).get(1);
            }
            item.set氏名(氏名);
            item.set氏名カナ(氏名カナ);
            生年月日 = new RDate(row.getBirthYMD().toString());
            item.set生年月日(new FlexibleDate(生年月日.toDateString()));
            item.set性別(row.getGender());
            item.set年齢(row.getAge());
            item.set続柄(row.getZokugara());
            item.set種別(row.getShubetsu());
            異動年月日 = new RDate(row.getIdoYMD().toString());
            item.set異動年月日(new FlexibleDate(異動年月日.toDateString()));
            item.set住民税(row.getJuminZei());
            if (!RString.isNullOrEmpty(row.getGokeiShotoku())) {
                item.set合計所得金額(new Decimal(row.getGokeiShotoku().replace(コンマ, RString.EMPTY).toString()));
            }
            if (!RString.isNullOrEmpty(row.getNenkinShunyu())) {
                item.set年金等収入(new Decimal(row.getNenkinShunyu().replace(コンマ, RString.EMPTY).toString()));
            }
            if (!RString.isNullOrEmpty(row.getNenkinShotoku())) {
                item.set年金等所得(new Decimal(row.getNenkinShotoku().replace(コンマ, RString.EMPTY).toString()));
            }
            if (!RString.isNullOrEmpty(row.getKazeiShotoku())) {
                item.set課税所得(new Decimal(row.getKazeiShotoku().replace(コンマ, RString.EMPTY).toString()));
            }
            if (!RString.isNullOrEmpty(row.getKoseiYMD())) {
                更正日 = new RDate(row.getKoseiYMD().toString());
                item.set更正日(new FlexibleDate(更正日.toDateString()));
            }
            list.add(item);
        }
        return list;
    }

    private List<dgSteaiinShotoku_Row> set世帯員所得情報Grid(List<SetaiinShotoku> 世帯員所得情報リスト, FlexibleDate 世帯員把握基準日) {
        dgSteaiinShotoku_Row row;
        List<dgSteaiinShotoku_Row> rowList = new ArrayList<>();
        if (世帯員所得情報リスト.isEmpty()) {
            div.getDgSteaiinShotoku().setDataSource(rowList);
        } else {
            RString 生年月日 = RString.EMPTY;
            RString 異動年月日 = RString.EMPTY;
            RString 更正日 = RString.EMPTY;
            IDateOfBirth dateofbirth;
            RString 年齢;
            RString 合計所得金額;
            RString 年金等収入;
            RString 年金等所得;
            RString 課税所得;
            RString 課税区分_住民税減免後;
            for (SetaiinShotoku item : 世帯員所得情報リスト) {
                row = new dgSteaiinShotoku_Row();
                row.setShikibetsuCode(item.get識別コード().value());
                row.setHihokenshaNo(item.get被保険者番号().value());
                row.setName(item.get氏名().concat(改行記号).concat(item.getカナ氏名()));
                if (null != item.get生年月日() && !item.get生年月日().isEmpty()) {
                    生年月日 = toWarekiHalf_Zero(item.get生年月日());
                }
                row.setBirthYMD(生年月日);
                row.setGender(item.get性別());
                dateofbirth = DateOfBirthFactory.createInstance(item.get生年月日());
                年齢 = new AgeCalculator(dateofbirth, JuminJotai.住民, item.get住民情報_異動日(), 世帯員把握基準日).get年齢();
                row.setAge(年齢);
                row.setZokugara(item.get続柄());
                row.setShubetsu(item.get種別());
                if (null != item.get住民情報_異動日() && !item.get住民情報_異動日().isEmpty()) {
                    異動年月日 = toWarekiHalf_Zero(item.get住民情報_異動日());
                }
                row.setIdoYMD(異動年月日);
                課税区分_住民税減免後 = item.get課税区分_住民税減免後();
                if (KazeiKubun.課税.getコード().equals(課税区分_住民税減免後)) {
                    row.setJuminZei(SetaiKazeiKubun.課税.get名称());
                } else {
                    row.setJuminZei(SetaiKazeiKubun.非課税.get名称());
                }
                合計所得金額 = DecimalFormatter.toコンマ区切りRString(nullToZero(item.get合計所得金額()), 0);
                row.setGokeiShotoku(合計所得金額);
                年金等収入 = DecimalFormatter.toコンマ区切りRString(nullToZero(item.get年金収入額()), 0);
                row.setNenkinShunyu(年金等収入);
                年金等所得 = DecimalFormatter.toコンマ区切りRString(nullToZero(item.get年金所得額()), 0);
                row.setNenkinShotoku(年金等所得);
                課税所得 = DecimalFormatter.toコンマ区切りRString(nullToZero(item.get課税所得額()), 0);
                row.setKazeiShotoku(課税所得);
                row.setShikibetsuTaishoKubun(MemoShikibetsuTaisho.識別コード.get識別対象());
                Decimal 計算結果 = Decimal.ZERO;
                計算結果 = 計算結果.add(nullToZero(item.get合計所得金額())).
                        subtract(nullToZero(item.get年金収入額())).add(nullToZero(item.get課税所得額()));
                if (計算結果.compareTo(数値_38万) <= 0 && new Decimal(年齢.toString()).compareTo(年齢_15) <= 0) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                } else if (計算結果.compareTo(数値_38万) <= 0
                        && 年齢_16.compareTo(new Decimal(年齢.toString())) <= 0
                        && new Decimal(年齢.toString()).compareTo(年齢_18) <= 0) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorLightGreen);
                } else if (数値_38万.compareTo(計算結果) <= 0 && new Decimal(年齢.toString()).compareTo(年齢_18) <= 0) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorLightGray);
                }
                if (null != item.get更正日() && !item.get更正日().isEmpty()) {
                    更正日 = toWarekiHalf_Zero(item.get更正日());
                }
                row.setKoseiYMD(更正日);
                rowList.add(row);
            }
        }
        return rowList;
    }

    private Decimal nullToZero(Decimal 金額) {
        if (金額 == null) {
            return Decimal.ZERO;
        }
        return 金額;
    }

    private RString toWarekiHalf_Zero(FlexibleDate targetValue) {
        if (targetValue == null) {
            return RString.EMPTY;
        }
        return targetValue.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).width(Width.HALF).toDateString();
    }
}
