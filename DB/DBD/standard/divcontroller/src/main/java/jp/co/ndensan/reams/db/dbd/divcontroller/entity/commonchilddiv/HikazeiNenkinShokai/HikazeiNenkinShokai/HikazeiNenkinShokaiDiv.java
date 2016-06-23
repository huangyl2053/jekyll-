package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinShokai.HikazeiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.hikazenenkintaishosha.HikazeNenkinTaishosha;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.KakushuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.ShoriKekka;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TeiseiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TsuchiNaiyoCode;
import jp.co.ndensan.reams.db.dbd.service.core.hikazeinenkin.HikazeNenkinTaishoshaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 【共有子Div】 非課税年金のクラスファイル
 *
 * @reamsid_L DBD-3560-140 liangbc
 */
public class HikazeiNenkinShokaiDiv extends Panel implements IHikazeiNenkinShokaiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("ddlNendo")
    private DropDownList ddlNendo;
    @JsonProperty("radRireki")
    private RadioButton radRireki;
    @JsonProperty("btnSaiHyoji")
    private Button btnSaiHyoji;
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("lblHojinHikazeiNenkinJoho")
    private Label lblHojinHikazeiNenkinJoho;
    @JsonProperty("txtShotokuKananGakugo")
    private TextBoxNum txtShotokuKananGakugo;
    @JsonProperty("dgHikazeiNenkinShokai")
    private DataGrid<dgHikazeiNenkinShokai_Row> dgHikazeiNenkinShokai;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihoNo
     * @return txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    /*
     * settxtHihoNo
     * @param txtHihoNo txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
    }

    /*
     * getddlNendo
     * @return ddlNendo
     */
    @JsonProperty("ddlNendo")
    public DropDownList getDdlNendo() {
        return ddlNendo;
    }

    /*
     * setddlNendo
     * @param ddlNendo ddlNendo
     */
    @JsonProperty("ddlNendo")
    public void setDdlNendo(DropDownList ddlNendo) {
        this.ddlNendo = ddlNendo;
    }

    /*
     * getradRireki
     * @return radRireki
     */
    @JsonProperty("radRireki")
    public RadioButton getRadRireki() {
        return radRireki;
    }

    /*
     * setradRireki
     * @param radRireki radRireki
     */
    @JsonProperty("radRireki")
    public void setRadRireki(RadioButton radRireki) {
        this.radRireki = radRireki;
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
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getlblHojinHikazeiNenkinJoho
     * @return lblHojinHikazeiNenkinJoho
     */
    @JsonProperty("lblHojinHikazeiNenkinJoho")
    public Label getLblHojinHikazeiNenkinJoho() {
        return lblHojinHikazeiNenkinJoho;
    }

    /*
     * setlblHojinHikazeiNenkinJoho
     * @param lblHojinHikazeiNenkinJoho lblHojinHikazeiNenkinJoho
     */
    @JsonProperty("lblHojinHikazeiNenkinJoho")
    public void setLblHojinHikazeiNenkinJoho(Label lblHojinHikazeiNenkinJoho) {
        this.lblHojinHikazeiNenkinJoho = lblHojinHikazeiNenkinJoho;
    }

    /*
     * gettxtShotokuKananGakugo
     * @return txtShotokuKananGakugo
     */
    @JsonProperty("txtShotokuKananGakugo")
    public TextBoxNum getTxtShotokuKananGakugo() {
        return txtShotokuKananGakugo;
    }

    /*
     * settxtShotokuKananGakugo
     * @param txtShotokuKananGakugo txtShotokuKananGakugo
     */
    @JsonProperty("txtShotokuKananGakugo")
    public void setTxtShotokuKananGakugo(TextBoxNum txtShotokuKananGakugo) {
        this.txtShotokuKananGakugo = txtShotokuKananGakugo;
    }

    /*
     * getdgHikazeiNenkinShokai
     * @return dgHikazeiNenkinShokai
     */
    @JsonProperty("dgHikazeiNenkinShokai")
    public DataGrid<dgHikazeiNenkinShokai_Row> getDgHikazeiNenkinShokai() {
        return dgHikazeiNenkinShokai;
    }

    /*
     * setdgHikazeiNenkinShokai
     * @param dgHikazeiNenkinShokai dgHikazeiNenkinShokai
     */
    @JsonProperty("dgHikazeiNenkinShokai")
    public void setDgHikazeiNenkinShokai(DataGrid<dgHikazeiNenkinShokai_Row> dgHikazeiNenkinShokai) {
        this.dgHikazeiNenkinShokai = dgHikazeiNenkinShokai;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private final static RString 同一年金単位最新KEY = new RString("1");
    private final static RString 全てKEY = new RString("2");
    private final static RString 改行タグ = new RString("<br>");

    /**
     * 初期化
     */
    @Override
    public void initialize() {
        if (getTxtHihoNo().getValue() == null || getTxtHihoNo().getValue().isEmpty()) {
            throw new SystemException("被保険者番号が設定されていません。");
        }
        get所得年度List();
        getRadRireki().setSelectedKey(同一年金単位最新KEY);
        再表示();
    }

    /**
     * 再表示
     */
    public void 再表示() {
        List<HikazeNenkinTaishosha> 同一年金単位最新履歴;
        同一年金単位最新履歴 = HikazeNenkinTaishoshaFinder.createInstance().
                select同一年金単位最新履歴(getTxtHihoNo().getValue(), new RYear(getDdlNendo().getSelectedKey()));
        if (全てKEY.equals(getRadRireki().getSelectedKey())) {
            Decimal 所得勘案額合 = Decimal.ZERO;
            List<HikazeNenkinTaishosha> 全て履歴 = HikazeNenkinTaishoshaFinder.createInstance().
                    select全て履歴(getTxtHihoNo().getValue(), new RYear(getDdlNendo().getSelectedKey()));
            for (HikazeNenkinTaishosha hikazeNenkinTaishosha : 同一年金単位最新履歴) {
                if (Decimal.canConvert(hikazeNenkinTaishosha.getDT金額1())) {
                    所得勘案額合 = 所得勘案額合.add(new Decimal(hikazeNenkinTaishosha.getDT金額1().toString()));
                }
            }
            set非課税年金照会データグリッド(全て履歴, false);
            getTxtShotokuKananGakugo().setValue(所得勘案額合);
        } else {
            set非課税年金照会データグリッド(同一年金単位最新履歴, true);
        }
    }

    private void set非課税年金照会データグリッド(List<HikazeNenkinTaishosha> list, boolean is同一年金単位最新) {
        List<dgHikazeiNenkinShokai_Row> rows = new ArrayList<>();
        Decimal 所得勘案額合 = Decimal.ZERO;
        for (HikazeNenkinTaishosha hikazeNenkinTaishosha : list) {
            TextBoxFlexibleDate 生年月日 = new TextBoxFlexibleDate();
            if (FlexibleDate.canConvert(hikazeNenkinTaishosha.getDT生年月日())) {
                生年月日.setValue(new FlexibleDate(hikazeNenkinTaishosha.getDT生年月日()));
            }
            TextBoxCode 基礎年金番号 = new TextBoxCode();
            基礎年金番号.setValue(hikazeNenkinTaishosha.get基礎年金番号());
            TextBoxCode 現基礎年金番号 = new TextBoxCode();
            現基礎年金番号.setValue(hikazeNenkinTaishosha.get現基礎年金番号());
            TextBoxCode 年金コード = new TextBoxCode();
            年金コード.setValue(hikazeNenkinTaishosha.get年金コード());
            TextBoxNum dt金額1 = new TextBoxNum();
            if (Decimal.canConvert(hikazeNenkinTaishosha.getDT金額1())) {
                dt金額1.setValue(new Decimal(hikazeNenkinTaishosha.getDT金額1().toString()));
            }
            TextBoxFlexibleDate dt作成年月日 = new TextBoxFlexibleDate();
            if (FlexibleDate.canConvert(hikazeNenkinTaishosha.getDT作成年月日())) {
                dt作成年月日.setValue(new FlexibleDate(hikazeNenkinTaishosha.getDT作成年月日()));
            }
            dgHikazeiNenkinShokai_Row row = new dgHikazeiNenkinShokai_Row(
                    ObjectUtil.defaultIfNull(hikazeNenkinTaishosha.getDTカナ氏名(), RString.EMPTY).
                    concat(改行タグ).
                    concat(ObjectUtil.defaultIfNull(hikazeNenkinTaishosha.getDT漢字氏名(), RString.EMPTY)),
                    生年月日,
                    Seibetsu.toValue(hikazeNenkinTaishosha.getDT性別()).get名称(),
                    hikazeNenkinTaishosha.getDT年金保険者コード(),
                    基礎年金番号,
                    現基礎年金番号,
                    年金コード,
                    dt金額1,
                    hikazeNenkinTaishosha.getDT通知内容コード() == null ? RString.EMPTY : TsuchiNaiyoCode.toValue(
                            hikazeNenkinTaishosha.getDT通知内容コード()).get名称(),
                    dt作成年月日,
                    hikazeNenkinTaishosha.getDT訂正表示() == null ? RString.EMPTY : TeiseiHyoji.toValue(
                            hikazeNenkinTaishosha.getDT訂正表示()).get名称(),
                    hikazeNenkinTaishosha.getDT各種区分() == null ? RString.EMPTY : KakushuKubun.toValue(
                            hikazeNenkinTaishosha.getDT各種区分()).get名称(),
                    hikazeNenkinTaishosha.getDT処理結果() == null ? RString.EMPTY : ShoriKekka.toValue(
                            hikazeNenkinTaishosha.getDT処理結果()).get名称(),
                    ObjectUtil.defaultIfNull(hikazeNenkinTaishosha.getDTカナ住所(), RString.EMPTY).concat(改行タグ).concat(
                            ObjectUtil.defaultIfNull(hikazeNenkinTaishosha.getDT漢字住所(), RString.EMPTY)),
                    hikazeNenkinTaishosha.get登録区分() == null ? RString.EMPTY : TorokuKubun.toValue(
                            hikazeNenkinTaishosha.get登録区分()).get名称());
            rows.add(row);
            if (Decimal.canConvert(hikazeNenkinTaishosha.getDT金額1())) {
                所得勘案額合 = 所得勘案額合.add(new Decimal(hikazeNenkinTaishosha.getDT金額1().toString()));
            }
        }
        if (is同一年金単位最新) {
            getTxtShotokuKananGakugo().setValue(所得勘案額合);
        }
        getDgHikazeiNenkinShokai().setDataSource(rows);
    }

    private void get所得年度List() {
        List<KeyValueDataSource> 所得年度List = new ArrayList<>();
        RYear 日付関連_所得年度 = new RYear(DbBusinessConfig.get(ConfigNameDBD.日付関連_所得年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        RYear 所得年度 = 日付関連_所得年度;
        for (int 平成12年 = 2000; 平成12年 <= 所得年度.getYearValue();) {
            所得年度List.add(new KeyValueDataSource(所得年度.seireki().toDateString(), 所得年度.wareki().toDateString()));
            所得年度 = 所得年度.minusYear(1);
        }
        getDdlNendo().setDataSource(所得年度List);
        getDdlNendo().setSelectedKey(日付関連_所得年度.seireki().toDateString());
    }

}
