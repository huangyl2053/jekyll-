/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210021;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021021.DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021021.DankaibetsuShunoritsuEntity;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021.ShotokuDankaibetsuShunoritsuIchiranDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBB0210021_保険料段階別収納率一覧表作成のハンドラクラスです。
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public class ShotokuDankaibetsuShunoritsuIchiranHandler {

    private final ShotokuDankaibetsuShunoritsuIchiranDiv div;
    private RDate 調定年度;
    private RDate 基準日;
    private static final RString NUM_0 = new RString("0");
    private static final RString NUM_1 = new RString("1");
    private static final RString NUM_2 = new RString("2");
    private static final RString NUM_3 = new RString("3");
    private static final RString NUM_4 = new RString("4");
    private static final int 定数_13 = 13;
    private static final int 定数_1 = 1;
    private static final int 定数_2 = 2;
    private static final RString KEY_0 = new RString("key0");
    private static final RString 年齢 = new RString("nenrei");
    private static final RString 生年月日 = new RString("umareYMD");
    private static final RString 月時点の認定者 = new RString("月時点の認定者");
    private static final RString 月時点の受給者 = new RString("月時点の受給者");

    /**
     * コンストラクタです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     */
    public ShotokuDankaibetsuShunoritsuIchiranHandler(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     * @return ハンドラ
     */
    public static ShotokuDankaibetsuShunoritsuIchiranHandler of(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        return new ShotokuDankaibetsuShunoritsuIchiranHandler(div);
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @return RString
     */
    public RString onLoad() {
        基準日 = RDate.getNowDate();
        RString 日付関連_調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, 基準日, SubGyomuCode.DBB介護賦課);
        調定年度 = new RDate(日付関連_調定年度.toString());
        RString 日付関連_当初年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_当初年度, 基準日, SubGyomuCode.DBB介護賦課);
        div.getTxtChoteiNendoRange().setMaxDateString(日付関連_調定年度);
        div.getTxtChoteiNendoRange().setMinDateString(日付関連_当初年度);
        div.getTxtFukaNendoRange().setMaxDateString(日付関連_調定年度);
        div.getTxtFukaNendoRange().setMinDateString(日付関連_当初年度);
        div.getTxtChoteiNendoRange().setFromValue(調定年度);
        div.getTxtChoteiNendoRange().setToValue(調定年度);
        div.getTxtFukaNendoRange().setFromValue(調定年度);
        div.getTxtFukaNendoRange().setToValue(調定年度);
        RYear システム日付の年 = 基準日.getYear();
        RString システム日付の月 = new RString(基準日.getMonthValue());
        RYear 調定年度の年 = new RYear(日付関連_調定年度);
        RYear 当初年度の年 = new RYear(日付関連_当初年度);
        List<KeyValueDataSource> ddlChoteiKijunY = setdataSourceY(システム日付の年, 当初年度の年);
        div.getDdlChoteiKijunY().setDataSource(ddlChoteiKijunY);
        div.getDdlChoteiKijunY().setSelectedValue(システム日付の年.toDateString());
        List<KeyValueDataSource> ddlChoteiKijunM = setdataSourceM();
        div.getDdlChoteiKijunM().setDataSource(ddlChoteiKijunM);
        div.getDdlChoteiKijunM().setSelectedValue(システム日付の月);
        List<KeyValueDataSource> ddlJukyuKijunY = setdataSourceY(調定年度の年, 当初年度の年);
        div.getDdlJukyuKijunY().setDataSource(ddlJukyuKijunY);
        List<KeyValueDataSource> ddlJukyuKijunM = setdataSourceM();
        div.getDdlJukyuKijunM().setDataSource(ddlJukyuKijunM);
        div.getDdlJukyuKijunM().setSelectedValue(システム日付の月);
        div.getRadChushutsuJoken().setSelectedKey(NUM_1);
        RString 現在基準月 = onChange_radChushutsuJoken(日付関連_調定年度, 日付関連_当初年度, システム日付の月);
        年齢_生年月日の選択状態();
        return 現在基準月;
    }

    /**
     * onChange_radChushutsuJokenのメソッドます。
     *
     * @param 日付関連_調定年度 RString
     * @param 日付関連_当初年度 RString
     * @param 未来基準月 RString
     * @return ResponseData ShotokuDankaibetsuShunoritsuIchiranDiv
     */
    public RString onChange_radChushutsuJoken(RString 日付関連_調定年度, RString 日付関連_当初年度, RString 未来基準月) {
        RString 現在基準月 = div.getDdlJukyuKijunM().getSelectedValue();
        if (現在基準月 == null || 現在基準月.isEmpty()) {
            現在基準月 = 未来基準月;
        }
        if (div.getRadChushutsuJoken().getSelectedKey().equals(NUM_1)) {
            div.getDdlJukyuKijunY().setDisabled(true);
            div.getDdlJukyuKijunM().setDisabled(true);
            div.getDdlJukyuKijunY().getDataSource().clear();
            div.getDdlJukyuKijunM().getDataSource().clear();
            div.getDdlJukyuKijunM().setLabelRText(RString.EMPTY);
            return 現在基準月;
        }
        RYear 調定年度の年 = new RYear(日付関連_調定年度);
        RYear 当初年度の年 = new RYear(日付関連_当初年度);
        div.getDdlJukyuKijunY().setDisabled(false);
        div.getDdlJukyuKijunM().setDisabled(false);
        List<KeyValueDataSource> ddlJukyuKijunY = setdataSourceY(調定年度の年, 当初年度の年);
        div.getDdlJukyuKijunY().setDataSource(ddlJukyuKijunY);
        List<KeyValueDataSource> ddlJukyuKijunM = setdataSourceM();
        div.getDdlJukyuKijunM().setDataSource(ddlJukyuKijunM);
        div.getDdlJukyuKijunY().setSelectedValue(調定年度の年.toDateString());
        div.getDdlJukyuKijunM().setSelectedValue(現在基準月);
        if (div.getRadChushutsuJoken().getSelectedKey().equals(NUM_2)) {
            div.getDdlJukyuKijunM().setLabelRText(月時点の認定者);
            return 現在基準月;
        }
        if (div.getRadChushutsuJoken().getSelectedKey().equals(NUM_3)) {
            div.getDdlJukyuKijunM().setLabelRText(月時点の受給者);
            return 現在基準月;
        }
        if (div.getRadChushutsuJoken().getSelectedKey().equals(NUM_4)) {
            div.getDdlJukyuKijunM().setLabelRText(月時点の認定者);
            return 現在基準月;
        }
        return 現在基準月;
    }

    /**
     * 年齢_生年月日の選択状態のメソッドます。
     *
     */
    public void 年齢_生年月日の選択状態() {
        if (div.getRadNenrei().getSelectedKey().equals(年齢)) {
            div.getTxtBirthRange().setDisabled(true);
            div.getTxtAgeRange().setDisabled(false);
            div.getTxtNenreiKijunYMD().setDisabled(false);
            div.getRadNenrei().setRequired(true);
            div.getRadUmareYMD().setRequired(false);
        }
        if (div.getRadUmareYMD().getSelectedKey().equals(生年月日)) {
            div.getTxtBirthRange().setDisabled(false);
            div.getTxtAgeRange().setDisabled(true);
            div.getTxtNenreiKijunYMD().setDisabled(true);
            div.getRadNenrei().setRequired(false);
            div.getRadUmareYMD().setRequired(true);
        }
    }

    /**
     * setバッチのメソッドます。
     *
     * @return DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter
     */
    public DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter createDankaibetsuShunoritsuIchiranBatchParameter() {
        DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter parameter = new DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter();
        RDate 調定年度_開始 = div.getTxtChoteiNendoRange().getFromValue();
        RDate 調定年度_終了 = div.getTxtChoteiNendoRange().getToValue();
        RDate 賦課年度_開始 = div.getTxtFukaNendoRange().getFromValue();
        RDate 賦課年度_終了 = div.getTxtFukaNendoRange().getToValue();
        基準日 = RDate.getNowDate();
        RString 日付関連_調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, 基準日, SubGyomuCode.DBB介護賦課);
        RString 調定基準年 = div.getDdlChoteiKijunY().getSelectedValue();
        RString 調定基準月 = div.getDdlChoteiKijunM().getSelectedValue();
        RString 調定基準年月 = null;
        RString 基準年 = div.getDdlJukyuKijunY().getSelectedValue();
        RString 基準月 = div.getDdlJukyuKijunM().getSelectedValue();
        RString 基準年月 = null;
        List<RString> 完納出力区分 = div.getChkKanno().getSelectedKeys();
        RDate 生年月日_開始 = div.getTxtBirthRange().getFromValue();
        RDate 生年月日_終了 = div.getTxtBirthRange().getToValue();
        Decimal 年齢_開始 = div.getTxtAgeRange().getFromValue();
        Decimal 年齢_終了 = div.getTxtAgeRange().getToValue();
        RDate 年齢基準日 = div.getTxtNenreiKijunYMD().getValue();
        parameter.set調定年度_開始(new FlexibleYear(調定年度_開始.getYear().toDateString()));
        parameter.set調定年度_終了(new FlexibleYear(調定年度_終了.getYear().toDateString()));
        parameter.set賦課年度_開始(new FlexibleYear(賦課年度_開始.getYear().toDateString()));
        parameter.set賦課年度_終了(new FlexibleYear(賦課年度_終了.getYear().toDateString()));
        if (!(日付関連_調定年度 == null || 日付関連_調定年度.isEmpty())) {
            parameter.set会計年度(new FlexibleYear(日付関連_調定年度));
        }
        if (!(調定基準月 == null || 調定基準月.isEmpty())) {
            if (調定基準月.length() == 定数_1) {
                調定基準年月 = 調定基準年.concat(NUM_0).concat(調定基準月);
            }
            if (調定基準月.length() == 定数_2) {
                調定基準年月 = 調定基準年.concat(調定基準月);
            }
        }
        parameter.set調定基準年月(new FlexibleYearMonth(調定基準年月));
        parameter.set抽出条件(div.getRadChushutsuJoken().getSelectedKey());
        if (!(基準月.isNullOrEmpty())) {
            if (基準月.length() == 定数_1) {
                基準年月 = 基準年.concat(NUM_0).concat(基準月);
            }
            if (基準月.length() == 定数_2) {
                基準年月 = 基準年.concat(基準月);
            }
            parameter.set基準年月(new FlexibleYearMonth(基準年月));
        }
        if (div.getRadNenrei().getSelectedKey().equals(年齢)) {
            parameter.set生年月日年齢区分(div.getRadNenrei().getSelectedValue());
        }
        if (div.getRadUmareYMD().getSelectedKey().equals(生年月日)) {
            parameter.set生年月日年齢区分(div.getRadUmareYMD().getSelectedValue());
        }
        if (生年月日_開始 != null) {
            parameter.set生年月日_開始(new FlexibleDate(生年月日_開始.toDateString()));
        }
        if (生年月日_終了 != null) {
            parameter.set生年月日_終了(new FlexibleDate(生年月日_終了.toDateString()));
        }
        parameter.set年齢_開始(年齢_開始);
        parameter.set年齢_終了(年齢_終了);
        if (年齢基準日 != null) {
            parameter.set年齢基準日(new FlexibleDate(年齢基準日.toDateString()));
        }
        RString 導入形態コード = div.getCcdChikuShichosonSelect().get導入形態コード();
        parameter.set広域判定区分(導入形態コード);
        if (導入形態コード.equals(DonyuKeitaiCode.事務単一.getCode())) {
            parameter.set選択対象区分(div.getCcdChikuShichosonSelect().get選択対象());
            Map<RString, RString> map = div.getCcdChikuShichosonSelect().get選択結果();
            parameter.set選択対象リスト(map);
        }
        if (導入形態コード.equals(DonyuKeitaiCode.事務広域.getCode())) {
            RString 市町村コード = div.getCcdChikuShichosonSelect().get市町村コード();
            RString 市町村名称 = div.getCcdChikuShichosonSelect().get市町村名称();
            RString 旧市町村コード = div.getCcdChikuShichosonSelect().get旧市町村コード();
            RString 旧市町村名称 = div.getCcdChikuShichosonSelect().get旧市町村名称();
            DankaibetsuShunoritsuEntity 市町村情報 = new DankaibetsuShunoritsuEntity(市町村コード, 市町村名称);
            DankaibetsuShunoritsuEntity 旧市町村情報 = new DankaibetsuShunoritsuEntity(旧市町村コード, 旧市町村名称);
            parameter.set市町村情報(市町村情報);
            parameter.set旧市町村情報(旧市町村情報);
        }
        RString 完納出力 = NUM_0;
        for (RString string : 完納出力区分) {
            if (string.equals(KEY_0)) {
                完納出力 = NUM_1;
            }
        }
        parameter.set完納出力区分(完納出力);
        return parameter;
    }

    private List<KeyValueDataSource> setdataSourceM() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int i = 1; i < 定数_13; i++) {
            RString key = new RString(i);
            RString value = new RString(i);
            KeyValueDataSource dateSource = new KeyValueDataSource(key, value);
            dataSourceList.add(dateSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> setdataSourceY(RYear maxYear, RYear minYear) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        while (minYear.isBeforeOrEquals(maxYear)) {
            RString key = maxYear.toDateString();
            RString value = maxYear.toDateString();
            KeyValueDataSource dateSource = new KeyValueDataSource(key, value);
            dataSourceList.add(dateSource);
            maxYear = maxYear.minusYear(1);
        }
        return dataSourceList;
    }
}
