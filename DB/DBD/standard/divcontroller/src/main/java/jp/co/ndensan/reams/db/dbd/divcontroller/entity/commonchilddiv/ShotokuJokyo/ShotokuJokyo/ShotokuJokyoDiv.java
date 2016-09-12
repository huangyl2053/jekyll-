package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShotokuJokyo.ShotokuJokyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.ur.urd.business.core.seikatsuhogo.Seikatsuhogo;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.ISeikatsuhogoManager;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.SeikatsuhogoManagerFactory;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.KingakuUnit;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShotokuJokyo のクラスファイル
 *
 * @reamsid_L DBD-3560-110 liangbc
 */
public class ShotokuJokyoDiv extends Panel implements IShotokuJokyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetaiKijunYMD")
    private TextBoxDate txtSetaiKijunYMD;
    @JsonProperty("ddShotokuNendo")
    private DropDownList ddShotokuNendo;
    @JsonProperty("btnSaiHyoji")
    private Button btnSaiHyoji;
    @JsonProperty("dgSetaiShotoku")
    private DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku;
    @JsonProperty("btnRirekiClose")
    private Button btnRirekiClose;
    @JsonProperty("txtShikibetsuCode")
    private RString txtShikibetsuCode;
    @JsonProperty("txtShotokuKijunYMDHMS")
    private RString txtShotokuKijunYMDHMS;
    @JsonProperty("txtGyomuCode")
    private RString txtGyomuCode;
    @JsonProperty("txtMemoShikibetsuKbn")
    private RString txtMemoShikibetsuKbn;
    @JsonProperty("txtMemoShikibetsuTaishoCode")
    private RString txtMemoShikibetsuTaishoCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSetaiKijunYMD
     * @return txtSetaiKijunYMD
     */
    @JsonProperty("txtSetaiKijunYMD")
    public TextBoxDate getTxtSetaiKijunYMD() {
        return txtSetaiKijunYMD;
    }

    /*
     * settxtSetaiKijunYMD
     * @param txtSetaiKijunYMD txtSetaiKijunYMD
     */
    @JsonProperty("txtSetaiKijunYMD")
    public void setTxtSetaiKijunYMD(TextBoxDate txtSetaiKijunYMD) {
        this.txtSetaiKijunYMD = txtSetaiKijunYMD;
    }

    /*
     * getddShotokuNendo
     * @return ddShotokuNendo
     */
    @JsonProperty("ddShotokuNendo")
    public DropDownList getDdShotokuNendo() {
        return ddShotokuNendo;
    }

    /*
     * setddShotokuNendo
     * @param ddShotokuNendo ddShotokuNendo
     */
    @JsonProperty("ddShotokuNendo")
    public void setDdShotokuNendo(DropDownList ddShotokuNendo) {
        this.ddShotokuNendo = ddShotokuNendo;
    }

    /*
     * getbtnSaiHyoji
     * @return btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public Button getBtnSaiHyoji() {
        return btnSaiHyoji;
    }

    /*
     * setbtnSaiHyoji
     * @param btnSaiHyoji btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public void setBtnSaiHyoji(Button btnSaiHyoji) {
        this.btnSaiHyoji = btnSaiHyoji;
    }

    /*
     * getdgSetaiShotoku
     * @return dgSetaiShotoku
     */
    @JsonProperty("dgSetaiShotoku")
    public DataGrid<dgSetaiShotoku_Row> getDgSetaiShotoku() {
        return dgSetaiShotoku;
    }

    /*
     * setdgSetaiShotoku
     * @param dgSetaiShotoku dgSetaiShotoku
     */
    @JsonProperty("dgSetaiShotoku")
    public void setDgSetaiShotoku(DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku) {
        this.dgSetaiShotoku = dgSetaiShotoku;
    }

    /*
     * getbtnRirekiClose
     * @return btnRirekiClose
     */
    @JsonProperty("btnRirekiClose")
    public Button getBtnRirekiClose() {
        return btnRirekiClose;
    }

    /*
     * setbtnRirekiClose
     * @param btnRirekiClose btnRirekiClose
     */
    @JsonProperty("btnRirekiClose")
    public void setBtnRirekiClose(Button btnRirekiClose) {
        this.btnRirekiClose = btnRirekiClose;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShotokuKijunYMDHMS
     * @return txtShotokuKijunYMDHMS
     */
    @JsonProperty("txtShotokuKijunYMDHMS")
    public RString getTxtShotokuKijunYMDHMS() {
        return txtShotokuKijunYMDHMS;
    }

    /*
     * settxtShotokuKijunYMDHMS
     * @param txtShotokuKijunYMDHMS txtShotokuKijunYMDHMS
     */
    @JsonProperty("txtShotokuKijunYMDHMS")
    public void setTxtShotokuKijunYMDHMS(RString txtShotokuKijunYMDHMS) {
        this.txtShotokuKijunYMDHMS = txtShotokuKijunYMDHMS;
    }

    /*
     * gettxtGyomuCode
     * @return txtGyomuCode
     */
    @JsonProperty("txtGyomuCode")
    public RString getTxtGyomuCode() {
        return txtGyomuCode;
    }

    /*
     * settxtGyomuCode
     * @param txtGyomuCode txtGyomuCode
     */
    @JsonProperty("txtGyomuCode")
    public void setTxtGyomuCode(RString txtGyomuCode) {
        this.txtGyomuCode = txtGyomuCode;
    }

    /*
     * gettxtMemoShikibetsuKbn
     * @return txtMemoShikibetsuKbn
     */
    @JsonProperty("txtMemoShikibetsuKbn")
    public RString getTxtMemoShikibetsuKbn() {
        return txtMemoShikibetsuKbn;
    }

    /*
     * settxtMemoShikibetsuKbn
     * @param txtMemoShikibetsuKbn txtMemoShikibetsuKbn
     */
    @JsonProperty("txtMemoShikibetsuKbn")
    public void setTxtMemoShikibetsuKbn(RString txtMemoShikibetsuKbn) {
        this.txtMemoShikibetsuKbn = txtMemoShikibetsuKbn;
    }

    /*
     * gettxtMemoShikibetsuTaishoCode
     * @return txtMemoShikibetsuTaishoCode
     */
    @JsonProperty("txtMemoShikibetsuTaishoCode")
    public RString getTxtMemoShikibetsuTaishoCode() {
        return txtMemoShikibetsuTaishoCode;
    }

    /*
     * settxtMemoShikibetsuTaishoCode
     * @param txtMemoShikibetsuTaishoCode txtMemoShikibetsuTaishoCode
     */
    @JsonProperty("txtMemoShikibetsuTaishoCode")
    public void setTxtMemoShikibetsuTaishoCode(RString txtMemoShikibetsuTaishoCode) {
        this.txtMemoShikibetsuTaishoCode = txtMemoShikibetsuTaishoCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private final static RString BR = new RString("<br>");
    private final static RString マル = new RString("○");
    private final static RString 表示しない = new RString("0");
    private final static RString 住民税_減免前 = new RString("juminzeiGemmenMae");
    private final static RString 住民税_減免後 = new RString("juminzeiGemmenGo");
    private final static RString 住民税 = new RString("juminzei");

    @Override
    public void initialize(ShikibetsuCode 識別コード, YMDHMS 所得基準年月日) {
        if (識別コード == null || 識別コード.isEmpty()) {
            throw new SystemException("識別コードが設定されていません。");
        }
        setTxtShikibetsuCode(識別コード.getColumnValue());
        getTxtSetaiKijunYMD().setValue(RDate.getNowDate());
        get所得年度List();
        世帯員所得情報の取得(識別コード, 所得基準年月日);

    }

    /**
     * 世帯員所得情報の取得
     *
     * @param 識別コード 識別コード
     * @param 所得基準年月日 所得基準年月日
     */
    public void 世帯員所得情報の取得(ShikibetsuCode 識別コード, YMDHMS 所得基準年月日) {
        SetaiinShotokuJohoFinder finder = SetaiinShotokuJohoFinder.createInstance();
        List<SetaiinShotoku> 世帯員所得情報 = finder.get世帯員所得情報(識別コード,
                new FlexibleYear(getDdShotokuNendo().getSelectedKey()),
                所得基準年月日);

        Collections.sort(世帯員所得情報, new Comparator<SetaiinShotoku>() {
            @Override
            public int compare(SetaiinShotoku o1, SetaiinShotoku o2) {
                return orderBy本人区分And住民票表示順(o1, o2);
            }
        });

        List<dgSetaiShotoku_Row> rows = new ArrayList<>();
        for (SetaiinShotoku setaiinShotoku : 世帯員所得情報) {
            boolean is老齢福祉年金受給者 = 老齢福祉年金受給者判定(
                    setaiinShotoku.get識別コード(), setaiinShotoku.get被保険者番号(), new FlexibleDate(getTxtSetaiKijunYMD().getValue().toDateString()));
            boolean is生活保護受給者 = 生活保護受給者判定(識別コード);
            RString 生保_老齢 = get生保_老齢(is老齢福祉年金受給者, is生活保護受給者);
            dgSetaiShotoku_Row row = new dgSetaiShotoku_Row();
            row.setShikibetsuCodeHihokenshaNo(
                    setaiinShotoku.get識別コード().getColumnValue().concat(BR).concat(setaiinShotoku.get被保険者番号().getColumnValue()));
            row.setShimei(ObjectUtil.defaultIfNull(setaiinShotoku.getカナ氏名(), RString.EMPTY).concat(BR).
                    concat(ObjectUtil.defaultIfNull(setaiinShotoku.get氏名(), RString.EMPTY)));
            row.setSeinengappiSeibetsuZokugara(new RString(ObjectUtil.defaultIfNull(setaiinShotoku.get生年月日(), FlexibleDate.EMPTY).toString()).
                    concat(RString.FULL_SPACE).concat(ObjectUtil.defaultIfNull(setaiinShotoku.get性別(), RString.EMPTY)).concat(BR).
                    concat(ObjectUtil.defaultIfNull(setaiinShotoku.get続柄(), RString.EMPTY)));
            row.setShubetsu(setaiinShotoku.get種別());
            row.setIdoDate(new RString(ObjectUtil.defaultIfNull(setaiinShotoku.get住民情報_異動日(), FlexibleDate.EMPTY).toString()));
            row.setRiyoshaFutandankai(利用者負担段階の判定(setaiinShotoku, is老齢福祉年金受給者, is生活保護受給者).get名称());
            row.setSeihoRorei(生保_老齢);
            if (setaiinShotoku.get課税区分_住民税減免前() != null && !setaiinShotoku.get課税区分_住民税減免前().isEmpty()) {
                row.setJuminzeiGemmenMae(KazeiKubun.toValue(setaiinShotoku.get課税区分_住民税減免前()).get名称());
            }
            if (setaiinShotoku.get課税区分_住民税減免後() != null && !setaiinShotoku.get課税区分_住民税減免後().isEmpty()) {
                row.setJuminzeiGemmenGo(KazeiKubun.toValue(setaiinShotoku.get課税区分_住民税減免後()).get名称());
            }
            if (setaiinShotoku.get課税区分_住民税減免前() != null && !setaiinShotoku.get課税区分_住民税減免前().isEmpty()) {
                row.setJuminzei(KazeiKubun.toValue(setaiinShotoku.get課税区分_住民税減免前()).get名称());
            }
            row.setGokeiShotokuKingaku(
                    new RString(KingakuFormatter.create(ObjectUtil.defaultIfNull(setaiinShotoku.get合計所得金額(), Decimal.ZERO)).
                            format(KingakuUnit.円).setCommaSeparated().toString()));
            row.setNenkinShunyu(
                    new RString(KingakuFormatter.create(ObjectUtil.defaultIfNull(setaiinShotoku.get年金収入額(), Decimal.ZERO)).
                            format(KingakuUnit.円).setCommaSeparated().toString()));
            row.setNenkinShotoku(
                    new RString(KingakuFormatter.create(ObjectUtil.defaultIfNull(setaiinShotoku.get年金所得額(), Decimal.ZERO)).
                            format(KingakuUnit.円).setCommaSeparated().toString()));
            row.setKoseiDate(new RString(ObjectUtil.defaultIfNull(setaiinShotoku.get更正日(), FlexibleDate.EMPTY).toString()));
            rows.add(row);
        }
        getDgSetaiShotoku().setDataSource(rows);
        if (表示しない.equals(DbBusinessConfig.get(ConfigNameDBB.所得引出_住民税減免前後表示区分, RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            getDgSetaiShotoku().getGridSetting().getColumn(住民税_減免前).setVisible(false);
            getDgSetaiShotoku().getGridSetting().getColumn(住民税_減免後).setVisible(false);
            getDgSetaiShotoku().getGridSetting().getColumn(住民税).setVisible(true);
        } else {
            getDgSetaiShotoku().getGridSetting().getColumn(住民税_減免前).setVisible(true);
            getDgSetaiShotoku().getGridSetting().getColumn(住民税_減免後).setVisible(true);
            getDgSetaiShotoku().getGridSetting().getColumn(住民税).setVisible(false);
        }
    }

    public YMDHMS get所得基準年月日() {
        if (getTxtShotokuKijunYMDHMS() != null && !getTxtShotokuKijunYMDHMS().isEmpty()) {
            return new YMDHMS(getTxtShotokuKijunYMDHMS());
        } else {
            return new YMDHMS(RDate.getNowDateTime());
        }
    }

    private void get所得年度List() {
        List<KeyValueDataSource> 所得年度List = new ArrayList<>();
        RYear 日付関連_所得年度 = new RYear(DbBusinessConfig.get(ConfigNameDBD.日付関連_所得年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        RYear 所得年度 = 日付関連_所得年度;
        for (int 平成12年 = 2000; 平成12年 <= 所得年度.getYearValue();) {
            所得年度List.add(new KeyValueDataSource(所得年度.seireki().toDateString(), 所得年度.wareki().toDateString()));
            所得年度 = 所得年度.minusYear(1);
        }
        getDdShotokuNendo().setDataSource(所得年度List);
        getDdShotokuNendo().setSelectedKey(日付関連_所得年度.seireki().toDateString());
    }

    private boolean 老齢福祉年金受給者判定(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 所得基準年月日) {
        RoreiFukushiNenkinJukyushaManager manager = RoreiFukushiNenkinJukyushaManager.createInstance();
        return manager.老齢福祉年金受給者判定(識別コード, 被保険者番号, 所得基準年月日);
    }

    private boolean 生活保護受給者判定(ShikibetsuCode 識別コード) {
        ISeikatsuhogoManager manager = SeikatsuhogoManagerFactory.createInstance();
        Seikatsuhogo 最新生活保護 = manager.get最新生活保護(識別コード, GyomuCode.DB介護保険);
        return 最新生活保護 != null;

    }

    private RiyoshaFutanDankai 利用者負担段階の判定(SetaiinShotoku 世帯員所得情報, boolean is老齢福祉年金受給者, boolean is生活保護受給者) {
        if (is生活保護受給者 || is老齢福祉年金受給者) {
            return RiyoshaFutanDankai.第一段階;
        }
        if (KazeiKubun.課税.getコード().equals(世帯員所得情報.get課税区分_住民税減免前())) {
            return RiyoshaFutanDankai.第四段階;
        }
        if (ObjectUtil.defaultIfNull(世帯員所得情報.get年金収入額(), Decimal.ZERO).add(
                ObjectUtil.defaultIfNull(世帯員所得情報.get合計所得金額(), Decimal.ZERO)).compareTo(new Decimal(800000)) <= 0) {
            return RiyoshaFutanDankai.第二段階;
        }
        return RiyoshaFutanDankai.第三段階;
    }

    private RString get生保_老齢(boolean is老齢福祉年金受給者, boolean is生活保護受給者) {
        RString 生保_老齢 = RString.EMPTY;
        if (is生活保護受給者) {
            生保_老齢 = 生保_老齢.concat(マル);
        }
        生保_老齢 = 生保_老齢.concat(BR);
        if (is老齢福祉年金受給者) {
            生保_老齢 = 生保_老齢.concat(マル);
        }
        return 生保_老齢;
    }

    private int orderBy本人区分And住民票表示順(SetaiinShotoku o1, SetaiinShotoku o2) {
        if ((o1.get本人区分() == null ? 0 : Integer.parseInt(o1.get本人区分().toString()))
                < (o2.get本人区分() == null ? 0 : Integer.parseInt(o2.get本人区分().toString()))) {
            return -1;
        } else if ((o1.get本人区分() == null ? 0 : Integer.parseInt(o1.get本人区分().toString()))
                == (o2.get本人区分() == null ? 0 : Integer.parseInt(o2.get本人区分().toString()))) {
            if (o1.get住民票表示順() < o2.get住民票表示順()) {
                return -1;
            } else if (o1.get住民票表示順() == o2.get住民票表示順()) {
                return 0;
            }
        }
        return 1;
    }
}
