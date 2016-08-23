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
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.divcontroller.controller.commonchilddiv.memo.MemoNyuryoku.MemoNyuryokuHandler;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;

/**
 * 画面設計_DBC_ShotokuJokyo_所得状況のクラスです。
 *
 * @reamsid_L DBC-4620-030 zhouchuanlin
 */
public class ShotokuJokyoHandler {

    private static final RString 業務コード = new RString("DB");
    private static final RString 照会モード = new RString("0");
    private static final RString 識別対象区分_個人 = new RString("個人");
    private static final RString 数値_0 = new RString("0");
    private static final RString 改行記号 = new RString("<br>");
    private static final Decimal 数値_38万 = new Decimal("380000");
    private static final Decimal 年齢_15 = new Decimal("15");
    private static final Decimal 年齢_16 = new Decimal("16");
    private static final Decimal 年齢_18 = new Decimal("18");
    private static final RString 文字列_識別対象コード = new RString("txtMemoShikibetsuTaishoCode");
    private static final RString メモボタン = new RString("btnMemo");
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
        if (照会モード.equals(hdnMode)) {
            div.getBtnKakutei().setDisabled(true);
        } else {
            div.getBtnKakutei().setDisabled(false);
        }
        div.getTxtKijunYMD().setValue(hdnKijunYMD);
        div.getTxtShoriNendo().setValue(hdnShoriNendo);
        div.setHdnGyomuCode(業務コード);
        List<SetaiinShotoku> 世帯員所得情報リスト = SetaiinShotokuJohoFinder.createInstance().get世帯員所得情報(hdnShikibetuCode, hdnShoriNendo.getNendo(), null);
        List<dgSteaiinShotoku_Row> rowList = set世帯員所得情報Grid(世帯員所得情報リスト, hdnKijunYMD);
        div.getDgSteaiinShotoku().setDataSource(rowList);
        MemoNyuryokuHandler.dataGridupdateImage(new GyomuCode(div.getHdnGyomuCode()), div.getDgSteaiinShotoku(),
                識別対象区分_個人, 文字列_識別対象コード, RString.EMPTY, RString.EMPTY,
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
            item.set生年月日(new FlexibleDate(row.getBirthYMD()));
            item.set性別(row.getGender());
            item.set年齢(row.getAge());
            if (!row.getZokugara().isNullOrEmpty()) {
                item.set続柄(Integer.valueOf(row.getZokugara().toString()));
            }
            item.set住民税(row.getJuminZei());
            if (!row.getGokeiShotoku().isNullOrEmpty()) {
                item.set合計所得金額(new Decimal(row.getGokeiShotoku().toString()));
            }
            if (!row.getNenkinShunyu().isNullOrEmpty()) {
                item.set年金等収入(new Decimal(row.getNenkinShunyu().toString()));
            }
            if (!row.getNenkinShotoku().isNullOrEmpty()) {
                item.set年金等所得(new Decimal(row.getNenkinShotoku().toString()));
            }
            if (!row.getKazeiShotoku().isNullOrEmpty()) {
                item.set課税所得(new Decimal(row.getKazeiShotoku().toString()));
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
            RString 被保険者番号;
            RString 生年月日 = RString.EMPTY;
            RString 年齢;
            RString 合計所得金額;
            RString 年金等収入;
            RString 年金等所得;
            RString 課税所得;
            RString 課税区分_住民税減免後;
            for (SetaiinShotoku item : 世帯員所得情報リスト) {
                row = new dgSteaiinShotoku_Row();
                row.setShikibetsuCode(item.get種別コード());
                被保険者番号 = new RString(item.get被保険者番号().toString());
                row.setHihokenshaNo(被保険者番号);
                row.setName(item.get氏名().concat(改行記号).concat(item.getカナ氏名()));
                if (null != item.get生年月日() && !item.get生年月日().isEmpty()) {
                    生年月日 = new RString(item.get生年月日().toString());
                }
                row.setBirthYMD(生年月日);
                row.setGender(item.get性別());
                年齢 = new AgeCalculator((IDateOfBirth) item.get生年月日(), JuminJotai.住民, item.get住民情報_異動日(), 世帯員把握基準日).get年齢();
                row.setAge(年齢);
                row.setZokugara(item.get続柄());
                課税区分_住民税減免後 = item.get課税区分_住民税減免後();
                if (KazeiKubun.課税.get名称().equals(課税区分_住民税減免後)) {
                    row.setJuminZei(SetaiKazeiKubun.課税.get名称());
                } else {
                    row.setJuminZei(SetaiKazeiKubun.非課税.get名称());
                }
                if (null != item.get合計所得金額()) {
                    合計所得金額 = new RString(item.get合計所得金額().toString());
                } else {
                    合計所得金額 = 数値_0;
                }
                row.setGokeiShotoku(合計所得金額);
                if (null != item.get年金収入額()) {
                    年金等収入 = new RString(item.get年金収入額().toString());
                } else {
                    年金等収入 = 数値_0;
                }
                row.setNenkinShunyu(年金等収入);
                if (null != item.get年金所得額()) {
                    年金等所得 = new RString(item.get年金所得額().toString());
                } else {
                    年金等所得 = 数値_0;
                }
                row.setNenkinShotoku(年金等所得);
                if (null != item.get課税所得額()) {
                    課税所得 = new RString(item.get課税所得額().toString());
                } else {
                    課税所得 = 数値_0;
                }
                row.setKazeiShotoku(課税所得);
                row.setShikibetsuTaishoKubun(識別対象区分_個人);
                Decimal 計算結果 = Decimal.ZERO;
                計算結果 = 計算結果.add(new Decimal(合計所得金額.toString())).subtract(new Decimal(年金等所得.toString())).add(new Decimal(年金等収入.toString()));
                if (計算結果.compareTo(数値_38万) <= 0 && new Decimal(年齢.toString()).compareTo(年齢_15) <= 0) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                } else if (計算結果.compareTo(数値_38万) <= 0 && new Decimal(年齢.toString()).compareTo(年齢_16) >= 0 && new Decimal(年齢.toString()).compareTo(年齢_18) <= 0) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorLightGreen);
                } else if (計算結果.compareTo(数値_38万) >= 0 && new Decimal(年齢.toString()).compareTo(年齢_18) <= 0) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorLightGray);
                }
                rowList.add(row);
            }
        }
        return rowList;
    }
}
