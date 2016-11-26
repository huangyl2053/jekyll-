package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiRelate;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * 給付実績基本情報共有子Divクラス。
 *
 * @reamsid_L DBC-2970-160 linghuhang
 */
public class KyufuJissekiHeaderDiv extends Panel implements IKyufuJissekiHeaderDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNo")
    private TextBox txtHihoNo;
    @JsonProperty("txtJuminShubetsu")
    private TextBox txtJuminShubetsu;
    @JsonProperty("txtYoKaigodo")
    private TextBox txtYoKaigodo;
    @JsonProperty("txtYukoKikan")
    private TextBoxDateRange txtYukoKikan;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("txtSeinengappi")
    private TextBoxDate txtSeinengappi;
    @JsonProperty("lin01")
    private HorizontalLine lin01;
    @JsonProperty("txtTeikyoNengetsu")
    private TextBoxDate txtTeikyoNengetsu;
    @JsonProperty("txtJissekiKubun")
    private TextBox txtJissekiKubun;
    @JsonProperty("txtSakuseiKubun")
    private TextBox txtSakuseiKubun;
    @JsonProperty("txtSeiriNo")
    private TextBox txtSeiriNo;
    @JsonProperty("txtShokisaiHokenshaNo")
    private TextBox txtShokisaiHokenshaNo;
    @JsonProperty("txtYoshikiNo")
    private TextBox txtYoshikiNo;
    @JsonProperty("txtYoshikiMeisho")
    private TextBox txtYoshikiMeisho;
    @JsonProperty("txtJigyoshaNo")
    private TextBox txtJigyoshaNo;
    @JsonProperty("Jigyosha")
    private TextBox Jigyosha;
    @JsonProperty("hiddenJigyoshaCode")
    private RString hiddenJigyoshaCode;
    @JsonProperty("hiddenYoshikiNo")
    private RString hiddenYoshikiNo;
    @JsonProperty("hiddenJissekiKubun")
    private RString hiddenJissekiKubun;

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
    public TextBox getTxtHihoNo() {
        return txtHihoNo;
    }

    /*
     * settxtHihoNo
     * @param txtHihoNo txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBox txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
    }

    /*
     * gettxtJuminShubetsu
     * @return txtJuminShubetsu
     */
    @JsonProperty("txtJuminShubetsu")
    public TextBox getTxtJuminShubetsu() {
        return txtJuminShubetsu;
    }

    /*
     * settxtJuminShubetsu
     * @param txtJuminShubetsu txtJuminShubetsu
     */
    @JsonProperty("txtJuminShubetsu")
    public void setTxtJuminShubetsu(TextBox txtJuminShubetsu) {
        this.txtJuminShubetsu = txtJuminShubetsu;
    }

    /*
     * gettxtYoKaigodo
     * @return txtYoKaigodo
     */
    @JsonProperty("txtYoKaigodo")
    public TextBox getTxtYoKaigodo() {
        return txtYoKaigodo;
    }

    /*
     * settxtYoKaigodo
     * @param txtYoKaigodo txtYoKaigodo
     */
    @JsonProperty("txtYoKaigodo")
    public void setTxtYoKaigodo(TextBox txtYoKaigodo) {
        this.txtYoKaigodo = txtYoKaigodo;
    }

    /*
     * gettxtYukoKikan
     * @return txtYukoKikan
     */
    @JsonProperty("txtYukoKikan")
    public TextBoxDateRange getTxtYukoKikan() {
        return txtYukoKikan;
    }

    /*
     * settxtYukoKikan
     * @param txtYukoKikan txtYukoKikan
     */
    @JsonProperty("txtYukoKikan")
    public void setTxtYukoKikan(TextBoxDateRange txtYukoKikan) {
        this.txtYukoKikan = txtYukoKikan;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtSeibetsu
     * @return txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    /*
     * settxtSeibetsu
     * @param txtSeibetsu txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu = txtSeibetsu;
    }

    /*
     * gettxtSeinengappi
     * @return txtSeinengappi
     */
    @JsonProperty("txtSeinengappi")
    public TextBoxDate getTxtSeinengappi() {
        return txtSeinengappi;
    }

    /*
     * settxtSeinengappi
     * @param txtSeinengappi txtSeinengappi
     */
    @JsonProperty("txtSeinengappi")
    public void setTxtSeinengappi(TextBoxDate txtSeinengappi) {
        this.txtSeinengappi = txtSeinengappi;
    }

    /*
     * getlin01
     * @return lin01
     */
    @JsonProperty("lin01")
    public HorizontalLine getLin01() {
        return lin01;
    }

    /*
     * setlin01
     * @param lin01 lin01
     */
    @JsonProperty("lin01")
    public void setLin01(HorizontalLine lin01) {
        this.lin01 = lin01;
    }

    /*
     * gettxtTeikyoNengetsu
     * @return txtTeikyoNengetsu
     */
    @JsonProperty("txtTeikyoNengetsu")
    public TextBoxDate getTxtTeikyoNengetsu() {
        return txtTeikyoNengetsu;
    }

    /*
     * settxtTeikyoNengetsu
     * @param txtTeikyoNengetsu txtTeikyoNengetsu
     */
    @JsonProperty("txtTeikyoNengetsu")
    public void setTxtTeikyoNengetsu(TextBoxDate txtTeikyoNengetsu) {
        this.txtTeikyoNengetsu = txtTeikyoNengetsu;
    }

    /*
     * gettxtJissekiKubun
     * @return txtJissekiKubun
     */
    @JsonProperty("txtJissekiKubun")
    public TextBox getTxtJissekiKubun() {
        return txtJissekiKubun;
    }

    /*
     * settxtJissekiKubun
     * @param txtJissekiKubun txtJissekiKubun
     */
    @JsonProperty("txtJissekiKubun")
    public void setTxtJissekiKubun(TextBox txtJissekiKubun) {
        this.txtJissekiKubun = txtJissekiKubun;
    }

    /*
     * gettxtSakuseiKubun
     * @return txtSakuseiKubun
     */
    @JsonProperty("txtSakuseiKubun")
    public TextBox getTxtSakuseiKubun() {
        return txtSakuseiKubun;
    }

    /*
     * settxtSakuseiKubun
     * @param txtSakuseiKubun txtSakuseiKubun
     */
    @JsonProperty("txtSakuseiKubun")
    public void setTxtSakuseiKubun(TextBox txtSakuseiKubun) {
        this.txtSakuseiKubun = txtSakuseiKubun;
    }

    /*
     * gettxtSeiriNo
     * @return txtSeiriNo
     */
    @JsonProperty("txtSeiriNo")
    public TextBox getTxtSeiriNo() {
        return txtSeiriNo;
    }

    /*
     * settxtSeiriNo
     * @param txtSeiriNo txtSeiriNo
     */
    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBox txtSeiriNo) {
        this.txtSeiriNo = txtSeiriNo;
    }

    /*
     * gettxtShokisaiHokenshaNo
     * @return txtShokisaiHokenshaNo
     */
    @JsonProperty("txtShokisaiHokenshaNo")
    public TextBox getTxtShokisaiHokenshaNo() {
        return txtShokisaiHokenshaNo;
    }

    /*
     * settxtShokisaiHokenshaNo
     * @param txtShokisaiHokenshaNo txtShokisaiHokenshaNo
     */
    @JsonProperty("txtShokisaiHokenshaNo")
    public void setTxtShokisaiHokenshaNo(TextBox txtShokisaiHokenshaNo) {
        this.txtShokisaiHokenshaNo = txtShokisaiHokenshaNo;
    }

    /*
     * gettxtYoshikiNo
     * @return txtYoshikiNo
     */
    @JsonProperty("txtYoshikiNo")
    public TextBox getTxtYoshikiNo() {
        return txtYoshikiNo;
    }

    /*
     * settxtYoshikiNo
     * @param txtYoshikiNo txtYoshikiNo
     */
    @JsonProperty("txtYoshikiNo")
    public void setTxtYoshikiNo(TextBox txtYoshikiNo) {
        this.txtYoshikiNo = txtYoshikiNo;
    }

    /*
     * gettxtYoshikiMeisho
     * @return txtYoshikiMeisho
     */
    @JsonProperty("txtYoshikiMeisho")
    public TextBox getTxtYoshikiMeisho() {
        return txtYoshikiMeisho;
    }

    /*
     * settxtYoshikiMeisho
     * @param txtYoshikiMeisho txtYoshikiMeisho
     */
    @JsonProperty("txtYoshikiMeisho")
    public void setTxtYoshikiMeisho(TextBox txtYoshikiMeisho) {
        this.txtYoshikiMeisho = txtYoshikiMeisho;
    }

    /*
     * gettxtJigyoshaNo
     * @return txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBox getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    /*
     * settxtJigyoshaNo
     * @param txtJigyoshaNo txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBox txtJigyoshaNo) {
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    /*
     * getJigyosha
     * @return Jigyosha
     */
    @JsonProperty("Jigyosha")
    public TextBox getJigyosha() {
        return Jigyosha;
    }

    /*
     * setJigyosha
     * @param Jigyosha Jigyosha
     */
    @JsonProperty("Jigyosha")
    public void setJigyosha(TextBox Jigyosha) {
        this.Jigyosha = Jigyosha;
    }

    /*
     * gethiddenJigyoshaCode
     * @return hiddenJigyoshaCode
     */
    @JsonProperty("hiddenJigyoshaCode")
    public RString getHiddenJigyoshaCode() {
        return hiddenJigyoshaCode;
    }

    /*
     * sethiddenJigyoshaCode
     * @param hiddenJigyoshaCode hiddenJigyoshaCode
     */
    @JsonProperty("hiddenJigyoshaCode")
    public void setHiddenJigyoshaCode(RString hiddenJigyoshaCode) {
        this.hiddenJigyoshaCode = hiddenJigyoshaCode;
    }

    /*
     * gethiddenYoshikiNo
     * @return hiddenYoshikiNo
     */
    @JsonProperty("hiddenYoshikiNo")
    public RString getHiddenYoshikiNo() {
        return hiddenYoshikiNo;
    }

    /*
     * sethiddenYoshikiNo
     * @param hiddenYoshikiNo hiddenYoshikiNo
     */
    @JsonProperty("hiddenYoshikiNo")
    public void setHiddenYoshikiNo(RString hiddenYoshikiNo) {
        this.hiddenYoshikiNo = hiddenYoshikiNo;
    }

    /*
     * gethiddenJissekiKubun
     * @return hiddenJissekiKubun
     */
    @JsonProperty("hiddenJissekiKubun")
    public RString getHiddenJissekiKubun() {
        return hiddenJissekiKubun;
    }

    /*
     * sethiddenJissekiKubun
     * @param hiddenJissekiKubun hiddenJissekiKubun
     */
    @JsonProperty("hiddenJissekiKubun")
    public void setHiddenJissekiKubun(RString hiddenJissekiKubun) {
        this.hiddenJissekiKubun = hiddenJissekiKubun;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private KyufuJissekiHeaderHandler getHandler() {
        return new KyufuJissekiHeaderHandler(this);
    }

    /**
     * 給付実績基本情報に初期化を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 識別番号
     * @param 整理番号 整理番号
     */
    @Override
    public void initialize(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号, NyuryokuShikibetsuNo 識別番号) {
        getHandler().initialize(被保険者番号, サービス提供年月, 整理番号, 識別番号);
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    @Override
    public void setサービス提供年月(RDate サービス提供年月) {
        getHandler().setサービス提供年月(サービス提供年月);
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    @Override
    public void set事業者名称(RString 事業者名称) {
        getHandler().set事業者名称(事業者名称);
    }

    /**
     * 実績区分を設定します。
     *
     * @param 実績区分コード 実績区分コード
     */
    @Override
    public void set実績区分(RString 実績区分コード) {
        getHandler().set実績区分(実績区分コード);
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    @Override
    public void set整理番号(RString 整理番号) {
        getHandler().set整理番号(整理番号);
    }

    /**
     * 識別番号名称を設定します。
     *
     * @param 識別番号名称 識別番号名称
     */
    @Override
    public void set識別番号名称(RString 識別番号名称) {
        getHandler().set識別番号名称(識別番号名称);
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号 事業者番号
     */
    @Override
    public RString get事業者番号() {
        return getHandler().get事業者番号();
    }

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号 整理番号
     */
    @Override
    public RString get整理番号() {
        return getHandler().get整理番号();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月 サービス提供年月
     */
    @Override
    public RDate getサービス提供年月() {
        return getHandler().getサービス提供年月();
    }

    /**
     * 様式番号を取得します。
     *
     * @return 様式番号 様式番号
     */
    @Override
    public RString get様式番号() {
        return getHandler().get様式番号();
    }

    /**
     * 実績区分コードを取得します。
     *
     * @return 実績区分コード 実績区分コード
     */
    @Override
    public RString get実績区分コード() {
        return getHandler().get実績区分コード();
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    @Override
    public void set事業者番号(RString 事業者番号) {
        getHandler().set事業者番号(事業者番号);
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     */
    @Override
    public void set様式番号(RString 様式番号) {
        getHandler().set様式番号(様式番号);
    }

    /**
     * 要介護度を取得します。
     *
     * @return 要介護度 要介護度
     */
    @Override
    public RString get要介護度() {
        return getHandler().get要介護度();
    }

    /**
     * 被保番号を設定します。
     *
     * @param 被保番号 被保番号
     */
    @Override
    public void set被保番号(RString 被保番号) {
        this.getTxtHihoNo().setValue(被保番号);
    }

    /**
     * 被保番号を取得します。
     *
     * @return 被保番号 被保番号
     */
    @Override
    public RString get被保番号() {
        return this.getTxtHihoNo().getValue();
    }

    /**
     * 住民種別を設定します。
     *
     * @param 住民種別 住民種別
     */
    @Override
    public void set住民種別(RString 住民種別) {
        this.getTxtJuminShubetsu().setValue(住民種別);
    }

    /**
     * 住民種別を取得します。
     *
     * @return 住民種別 住民種別
     */
    @Override
    public RString get住民種別() {
        return this.getTxtJuminShubetsu().getValue();
    }

    /**
     * 有効期間_開始を設定します。
     *
     * @param 有効期間_開始 有効期間_開始
     */
    @Override
    public void set有効期間_開始(RDate 有効期間_開始) {
        if (null == 有効期間_開始) {
            this.getTxtYukoKikan().clearFromValue();
            return;
        }
        this.getTxtYukoKikan().setFromValue(有効期間_開始);
    }

    /**
     * 有効期間_開始を取得します。
     *
     * @return 有効期間_開始 有効期間_開始
     */
    @Override
    public RDate get有効期間_開始() {
        return this.getTxtYukoKikan().getFromValue();
    }

    /**
     * 有効期間_終了を設定します。
     *
     * @param 有効期間_終了 有効期間_終了
     */
    @Override
    public void set有効期間_終了(RDate 有効期間_終了) {
        if (null == 有効期間_終了) {
            this.getTxtYukoKikan().clearToValue();
            return;
        }
        this.getTxtYukoKikan().setToValue(有効期間_終了);
    }

    /**
     * 有効期間_終了を取得します。
     *
     * @return 有効期間_終了 有効期間_終了
     */
    @Override
    public RDate get有効期間_終了() {
        return this.getTxtYukoKikan().getToValue();
    }

    /**
     * 氏名を設定します。
     *
     * @param 氏名 氏名
     */
    @Override
    public void set氏名(RString 氏名) {
        this.getTxtShimei().setValue(氏名);
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名 氏名
     */
    @Override
    public RString get氏名() {
        return this.getTxtShimei().getValue();
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     */
    @Override
    public void set性別(RString 性別) {
        this.getTxtSeibetsu().setValue(性別);
    }

    /**
     * 性別を取得します。
     *
     * @return 性別 性別
     */
    @Override
    public RString get性別() {
        return this.getTxtSeibetsu().getValue();
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     */
    @Override
    public void set生年月日(RDate 生年月日) {
        if (null == this.getTxtSeinengappi()) {
            this.getTxtSeinengappi().clearValue();
            return;
        }
        this.getTxtSeinengappi().setValue(生年月日);
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日 生年月日
     */
    @Override
    public RDate get生年月日() {
        return this.getTxtSeinengappi().getValue();
    }

    /**
     * 保険者を設定します。
     *
     * @param 保険者 保険者
     */
    @Override
    public void set保険者(RString 保険者) {
        this.getTxtShokisaiHokenshaNo().setValue(保険者);
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者 保険者
     */
    @Override
    public RString get保険者() {
        return this.getTxtShokisaiHokenshaNo().getValue();
    }

    /**
     * 被保情報を設定します。
     *
     * @param 給付実績基本情報子Divデータ 給付実績基本情報子Divデータ
     */
    @Override
    public void set被保情報(KyufuJissekiHeader 給付実績基本情報子Divデータ) {
        getHandler().set被保情報(給付実績基本情報子Divデータ);
    }

    /**
     * 被保情報を設定します。
     *
     * @param csData_A 給付実績基本情報子Divデータ
     */
    @Override
    public void set被保情報2(KyufuJissekiKihonShukeiRelate csData_A) {
        getHandler().set被保情報2(csData_A);
    }

    /**
     * 給付実績基本情報データを取得します。
     *
     * @return 給付実績基本情報データ 給付実績基本情報データ
     */
    @Override
    public KyufuJissekiHeaderAll get給付実績基本情報データ() {
        return getHandler().get給付実績基本情報データ();
    }

    /**
     * 給付実績基本情報を設定します。
     *
     * @param 給付実績基本情報 給付実績基本情報子Divデータ
     */
    @Override
    public void set給付実績基本情報データ(KyufuJissekiHeaderAll 給付実績基本情報) {
        getHandler().set給付実績基本情報データ(給付実績基本情報);
    }

    /**
     * 被保情報を設定します。
     *
     * @param 給付実績高額介護サービス費データ 給付実績高額介護サービス費データ
     */
    @Override
    public void set被保情報2_1(KyufujissekiKogakuKaigoServicehiRelate 給付実績高額介護サービス費データ) {
        getHandler().set被保情報2(給付実績高額介護サービス費データ);
    }
}
