/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekisyokaimeisaisyukei.KyufuJissekiSyokaiMeisaiSyukeiBusiness;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.dgKyufuJissekiMeisaiJustoku_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.dgKyufuJissekiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.dgKyufuJissekiShukei_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績照会_明細集計画面処理handlerクラスです。
 *
 * @reamsid_L DBC-2970-040 wangxiaodong
 */
public class KyufuJissekiSyokaiMeisaiSyukeiHandler {

    private static final FlexibleYearMonth 平成27年4月 = new FlexibleYearMonth("201504");
    private static final RString 非活性 = new RString("0");
    private static final RString TEXT_後 = new RString("後");
    private static final RString TEXT_保険 = new RString("保険");
    private static final RString TEXT_公費１ = new RString("公費１");
    private static final RString TEXT_公費２ = new RString("公費２");
    private static final RString TEXT_公費３ = new RString("公費３");
    private static final int INT_ZERO = 0;
    private static final RString 介護保険 = new RString("08");
    private final KyufuJissekiSyokaiMeisaiSyukeiDiv div;

    /**
     * コンストラクタです
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     */
    public KyufuJissekiSyokaiMeisaiSyukeiHandler(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 集計情報リスト List<KyufujissekiShukei>
     * @param 明細情報リスト List<KyufujissekiMeisaiBusiness>
     * @param 明細情報特例リスト List<KyufujissekiMeisaiJushochiTokureiBusiness>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 様式番号 RString
     * @param 保険者情報 List<KyufuJissekiSyokaiMeisaiSyukeiBusiness>
     */
    public void onLoad(List<KyufujissekiShukei> 集計情報リスト, List<KyufujissekiMeisaiBusiness> 明細情報リスト,
            List<KyufujissekiMeisaiJushochiTokureiBusiness> 明細情報特例リスト, FlexibleYearMonth サービス提供年月,
            RString 様式番号, List<KyufuJissekiSyokaiMeisaiSyukeiBusiness> 保険者情報) {
        set明細情報の表示制御(様式番号, サービス提供年月);
        set明細情報特例の表示制御(様式番号, サービス提供年月);
        setDataGrid総計(集計情報リスト, 明細情報リスト, 明細情報特例リスト, 保険者情報);
    }

    /**
     * 画面のデータを設定する。
     *
     * @param 集計情報リスト List<KyufujissekiShukei>
     * @param 明細情報リスト List<KyufujissekiMeisai>
     * @param 明細情報特例リスト List<KyufujissekiMeisaiJushochiTokureiBusiness>
     * @param 保険者情報 List<KyufuJissekiSyokaiMeisaiSyukeiBusiness>
     */
    public void setDataGrid総計(List<KyufujissekiShukei> 集計情報リスト,
            List<KyufujissekiMeisaiBusiness> 明細情報リスト,
            List<KyufujissekiMeisaiJushochiTokureiBusiness> 明細情報特例リスト,
            List<KyufuJissekiSyokaiMeisaiSyukeiBusiness> 保険者情報) {
        if (!div.getDgKyufuJissekiShukei().isDisplayNone() && !集計情報リスト.isEmpty()) {
            setDataGrid集計情報(集計情報リスト);
        } else {
            List<dgKyufuJissekiShukei_Row> rowList = new ArrayList<>();
            div.getDgKyufuJissekiShukei().setDataSource(rowList);
        }
        if (!div.getDgKyufuJissekiMeisai().isDisplayNone() && !明細情報リスト.isEmpty()) {
            setDataGrid明細情報(明細情報リスト);
        } else {
            List<dgKyufuJissekiMeisai_Row> rowList = new ArrayList<>();
            div.getDgKyufuJissekiMeisai().setDataSource(rowList);
        }
        if (!div.getDgKyufuJissekiMeisaiJustoku().isDisplayNone() && !明細情報特例リスト.isEmpty()) {
            setDataGrid明細情報特例(明細情報特例リスト, 保険者情報);
        } else {
            List<dgKyufuJissekiMeisaiJustoku_Row> rowList = new ArrayList<>();
            div.getDgKyufuJissekiMeisaiJustoku().setDataSource(rowList);
        }
    }

    private void setDataGrid集計情報(List<KyufujissekiShukei> 集計情報リスト) {
        List<dgKyufuJissekiShukei_Row> rowList = new ArrayList<>();
        for (KyufujissekiShukei 集計情報データ : 集計情報リスト) {
            rowList.addAll(set集計情報(集計情報データ));
        }
        div.getDgKyufuJissekiShukei().setDataSource(rowList);
    }

    private void setDataGrid明細情報(List<KyufujissekiMeisaiBusiness> 明細情報リスト) {
        List<dgKyufuJissekiMeisai_Row> rowList = new ArrayList<>();
        for (KyufujissekiMeisaiBusiness 明細情報データ : 明細情報リスト) {
            rowList.add(set明細情報(明細情報データ));
            rowList.add(set明細情報_後(明細情報データ));
        }
        div.getDgKyufuJissekiMeisai().setDataSource(rowList);
    }

    private void setDataGrid明細情報特例(List<KyufujissekiMeisaiJushochiTokureiBusiness> 明細情報特例リスト,
            List<KyufuJissekiSyokaiMeisaiSyukeiBusiness> 保険者情報) {
        List<dgKyufuJissekiMeisaiJustoku_Row> rowList = new ArrayList<>();
        for (KyufujissekiMeisaiJushochiTokureiBusiness 明細情報特例データ : 明細情報特例リスト) {
            rowList.add(set明細情報特例(明細情報特例データ.get給付実績明細住所地特例情報(), 保険者情報));
            rowList.add(set明細情報特例_後(明細情報特例データ.get給付実績明細住所地特例情報()));
        }
        div.getDgKyufuJissekiMeisaiJustoku().setDataSource(rowList);
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 ShikibetsuNoKanri
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {
        if (非活性.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        div.getBtnMeisaiShukei().setDisabled(true);
        if (非活性.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        addButtonSet(識別番号管理);
    }

    private void addButtonSet(ShikibetsuNoKanri 識別番号管理) {
        if (非活性.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        div.getBtnKogakuKaigoService().setDisabled(true);
        if (非活性.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
    }

    private void set明細情報の表示制御(RString 様式番号, FlexibleYearMonth サービス提供年月) {
        if (RString.isNullOrEmpty(様式番号)) {
            return;
        }
        KyufuJissekiYoshikiKubun 基準様式番号 = KyufuJissekiYoshikiKubun.toValue(様式番号);
        if (KyufuJissekiYoshikiKubun._21C1_福祉用具販売費.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._21C2_予防用具販売費.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._21D1_住宅改修費.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._21D2_予防住宅改修費.equals(基準様式番号)) {
            div.getDgKyufuJissekiMeisai().setDisplayNone(true);
        } else if (平成27年4月.isBeforeOrEquals(サービス提供年月)) {
            if (KyufuJissekiYoshikiKubun._7131_様式第二.equals(基準様式番号)
                    || KyufuJissekiYoshikiKubun._2131_様式第二.equals(基準様式番号)) {
                div.getDgKyufuJissekiMeisai().setDisplayNone(false);
            }
            if (KyufuJissekiYoshikiKubun._7132_様式第二の二.equals(基準様式番号)
                    || KyufuJissekiYoshikiKubun._2132_様式第二の二.equals(基準様式番号)) {
                div.getDgKyufuJissekiMeisai().setDisplayNone(false);
            }
        } else if (KyufuJissekiYoshikiKubun._71R1_様式第二の三.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._8171_様式第七の三.equals(基準様式番号)) {
            div.getDgKyufuJissekiMeisai().setDisplayNone(false);
        } else {
            div.getDgKyufuJissekiMeisai().setDisplayNone(true);
        }
    }

    private void set明細情報特例の表示制御(RString 様式番号, FlexibleYearMonth サービス提供年月) {
        if (RString.isNullOrEmpty(様式番号)) {
            return;
        }
        KyufuJissekiYoshikiKubun 基準様式番号 = KyufuJissekiYoshikiKubun.toValue(様式番号);
        if (平成27年4月.isBeforeOrEquals(サービス提供年月)) {
            if (KyufuJissekiYoshikiKubun._7131_様式第二.equals(基準様式番号)
                    || KyufuJissekiYoshikiKubun._2131_様式第二.equals(基準様式番号)) {
                div.getDgKyufuJissekiMeisaiJustoku().setDisplayNone(false);
            }
            if (KyufuJissekiYoshikiKubun._7132_様式第二の二.equals(基準様式番号)
                    || KyufuJissekiYoshikiKubun._2132_様式第二の二.equals(基準様式番号)) {
                div.getDgKyufuJissekiMeisaiJustoku().setDisplayNone(false);
            }
        } else if (KyufuJissekiYoshikiKubun._71R1_様式第二の三.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._8171_様式第七の三.equals(基準様式番号)) {
            div.getDgKyufuJissekiMeisaiJustoku().setDisplayNone(false);
        } else {
            div.getDgKyufuJissekiMeisaiJustoku().setDisplayNone(true);
        }
    }

    private List<dgKyufuJissekiShukei_Row> set集計情報(KyufujissekiShukei 集計情報) {
        List<dgKyufuJissekiShukei_Row> rowList = new ArrayList<>();
        dgKyufuJissekiShukei_Row row_保険 = new dgKyufuJissekiShukei_Row();
        row_保険.setTxtServiceShurui(setサービス種類(集計情報.getサービス種類コード()));
        row_保険.setTxtJitsuNissu(checkInteger(集計情報.getサービス実日数()));
        row_保険.setTxtKeikakuTani(checkDecimal(集計情報.get計画単位数()));
        row_保険.setTxtTaishoTani(checkDecimal(集計情報.get限度額管理対象単位数()));
        row_保険.setTxtTaishogaiTani(checkDecimal(集計情報.get限度額管理対象外単位数()));
        row_保険.setTxtTankiKeikakuNissu(checkInteger(集計情報.get短期入所計画日数()));
        row_保険.setTxtHokenKohi(TEXT_保険);
        row_保険.setTxtKettei(RString.EMPTY);
        row_保険.setTxtTankiJitsuNissu(checkInteger(集計情報.get短期入所実日数()));
        row_保険.setTxtTaniGokei(kinngakuFormat(集計情報.get保険_単位数合計()));
        row_保険.setTxtTanisuTanka(kinngakuFormat(集計情報.get保険_単位数単価()));
        row_保険.setTxtSeikyugaku(kinngakuFormat(集計情報.get保険_請求額()));
        row_保険.setTxtRiyoshaFutangaku(kinngakuFormat(集計情報.get保険_利用者負担額()));
        row_保険.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get保険_出来高単位数合計()));
        row_保険.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get保険_出来高請求額()));
        row_保険.setTxtDekidakaHonninFutangaku(kinngakuFormat(集計情報.get保険_出来高医療費利用者負担額()));
        row_保険.setTxtSaiShinsaKaisu(checkInteger(集計情報.get再審査回数()));
        row_保険.setTxtKagoKaisu(checkInteger(集計情報.get過誤回数()));
        row_保険.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_保険);
        dgKyufuJissekiShukei_Row row_後_保険 = new dgKyufuJissekiShukei_Row();
        row_後_保険.setTxtServiceShurui(RString.EMPTY);
        row_後_保険.setTxtJitsuNissu(RString.EMPTY);
        row_後_保険.setTxtKeikakuTani(RString.EMPTY);
        row_後_保険.setTxtTaishoTani(RString.EMPTY);
        row_後_保険.setTxtTaishogaiTani(RString.EMPTY);
        row_後_保険.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_後_保険.setTxtHokenKohi(TEXT_保険);
        row_後_保険.setTxtKettei(TEXT_後);
        row_後_保険.setTxtTankiJitsuNissu(checkInteger(集計情報.get後_短期入所実日数()));
        row_後_保険.setTxtTaniGokei(kinngakuFormat(集計情報.get後_単位数合計()));
        row_後_保険.setTxtTanisuTanka(RString.EMPTY);
        row_後_保険.setTxtSeikyugaku(kinngakuFormat(集計情報.get後_保険請求分請求額()));
        row_後_保険.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_後_保険.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get後_保険_出来高単位数合計()));
        row_後_保険.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get後_保険_出来高請求額()));
        row_後_保険.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_後_保険.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_後_保険.setTxtKagoKaisu(RString.EMPTY);
        row_後_保険.setTxtShinsaYM(RString.EMPTY);
        rowList.add(row_後_保険);
        dgKyufuJissekiShukei_Row row_公費１ = new dgKyufuJissekiShukei_Row();
        row_公費１.setTxtServiceShurui(RString.EMPTY);
        row_公費１.setTxtJitsuNissu(RString.EMPTY);
        row_公費１.setTxtKeikakuTani(RString.EMPTY);
        row_公費１.setTxtTaishoTani(RString.EMPTY);
        row_公費１.setTxtTaishogaiTani(RString.EMPTY);
        row_公費１.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_公費１.setTxtHokenKohi(TEXT_公費１);
        row_公費１.setTxtKettei(RString.EMPTY);
        row_公費１.setTxtTankiJitsuNissu(RString.EMPTY);
        row_公費１.setTxtTaniGokei(kinngakuFormat(集計情報.get公費１_単位数合計()));
        row_公費１.setTxtTanisuTanka(RString.EMPTY);
        row_公費１.setTxtSeikyugaku(kinngakuFormat(集計情報.get公費１_請求額()));
        row_公費１.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_公費１.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get公費１_出来高単位数合計()));
        row_公費１.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get公費１_出来高請求額()));
        row_公費１.setTxtDekidakaHonninFutangaku(kinngakuFormat(集計情報.get公費１_出来高医療費利用者負担額()));
        row_公費１.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_公費１.setTxtKagoKaisu(RString.EMPTY);
        row_公費１.setTxtShinsaYM(RString.EMPTY);
        rowList.add(row_公費１);
        dgKyufuJissekiShukei_Row row_後_公費１ = new dgKyufuJissekiShukei_Row();
        row_後_公費１.setTxtServiceShurui(RString.EMPTY);
        row_後_公費１.setTxtJitsuNissu(RString.EMPTY);
        row_後_公費１.setTxtKeikakuTani(RString.EMPTY);
        row_後_公費１.setTxtTaishoTani(RString.EMPTY);
        row_後_公費１.setTxtTaishogaiTani(RString.EMPTY);
        row_後_公費１.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_後_公費１.setTxtHokenKohi(TEXT_公費１);
        row_後_公費１.setTxtKettei(TEXT_後);
        row_後_公費１.setTxtTankiJitsuNissu(RString.EMPTY);
        row_後_公費１.setTxtTaniGokei(kinngakuFormat(集計情報.get後_公費１_単位数合計()));
        row_後_公費１.setTxtTanisuTanka(RString.EMPTY);
        row_後_公費１.setTxtSeikyugaku(kinngakuFormat(集計情報.get後_公費１_請求額()));
        row_後_公費１.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_後_公費１.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get後_公費１_出来高単位数合計()));
        row_後_公費１.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get後_公費１_出来高請求額()));
        row_後_公費１.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_後_公費１.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_後_公費１.setTxtKagoKaisu(RString.EMPTY);
        row_後_公費１.setTxtShinsaYM(RString.EMPTY);
        rowList.add(row_後_公費１);
        rowList.addAll(addSet集計情報(集計情報));
        return rowList;
    }

    private List<dgKyufuJissekiShukei_Row> addSet集計情報(KyufujissekiShukei 集計情報) {
        List<dgKyufuJissekiShukei_Row> rowList = new ArrayList<>();
        dgKyufuJissekiShukei_Row row_公費２ = new dgKyufuJissekiShukei_Row();
        row_公費２.setTxtServiceShurui(RString.EMPTY);
        row_公費２.setTxtJitsuNissu(RString.EMPTY);
        row_公費２.setTxtKeikakuTani(RString.EMPTY);
        row_公費２.setTxtTaishoTani(RString.EMPTY);
        row_公費２.setTxtTaishogaiTani(RString.EMPTY);
        row_公費２.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_公費２.setTxtHokenKohi(TEXT_公費２);
        row_公費２.setTxtKettei(RString.EMPTY);
        row_公費２.setTxtTankiJitsuNissu(RString.EMPTY);
        row_公費２.setTxtTaniGokei(kinngakuFormat(集計情報.get公費２_単位数合計()));
        row_公費２.setTxtTanisuTanka(RString.EMPTY);
        row_公費２.setTxtSeikyugaku(kinngakuFormat(集計情報.get公費２_請求額()));
        row_公費２.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_公費２.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get公費２_出来高単位数合計()));
        row_公費２.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get公費２_出来高請求額()));
        row_公費２.setTxtDekidakaHonninFutangaku(kinngakuFormat(集計情報.get公費２_出来高医療費本人負担額()));
        row_公費２.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_公費２.setTxtKagoKaisu(RString.EMPTY);
        row_公費２.setTxtShinsaYM(RString.EMPTY);
        rowList.add(row_公費２);
        dgKyufuJissekiShukei_Row row_後_公費２ = new dgKyufuJissekiShukei_Row();
        row_後_公費２.setTxtServiceShurui(RString.EMPTY);
        row_後_公費２.setTxtJitsuNissu(RString.EMPTY);
        row_後_公費２.setTxtKeikakuTani(RString.EMPTY);
        row_後_公費２.setTxtTaishoTani(RString.EMPTY);
        row_後_公費２.setTxtTaishogaiTani(RString.EMPTY);
        row_後_公費２.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_後_公費２.setTxtHokenKohi(TEXT_公費２);
        row_後_公費２.setTxtKettei(TEXT_後);
        row_後_公費２.setTxtTankiJitsuNissu(RString.EMPTY);
        row_後_公費２.setTxtTaniGokei(kinngakuFormat(集計情報.get後_公費２_単位数合計()));
        row_後_公費２.setTxtTanisuTanka(RString.EMPTY);
        row_後_公費２.setTxtSeikyugaku(kinngakuFormat(集計情報.get後_公費２_請求額()));
        row_後_公費２.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_後_公費２.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get後_公費２_出来高単位数合計()));
        row_後_公費２.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get後_公費２_出来高請求額()));
        row_後_公費２.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_後_公費２.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_後_公費２.setTxtKagoKaisu(RString.EMPTY);
        row_後_公費２.setTxtShinsaYM(RString.EMPTY);
        rowList.add(row_後_公費２);
        dgKyufuJissekiShukei_Row row_公費３ = new dgKyufuJissekiShukei_Row();
        row_公費３.setTxtServiceShurui(RString.EMPTY);
        row_公費３.setTxtJitsuNissu(RString.EMPTY);
        row_公費３.setTxtKeikakuTani(RString.EMPTY);
        row_公費３.setTxtTaishoTani(RString.EMPTY);
        row_公費３.setTxtTaishogaiTani(RString.EMPTY);
        row_公費３.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_公費３.setTxtHokenKohi(TEXT_公費３);
        row_公費３.setTxtKettei(RString.EMPTY);
        row_公費３.setTxtTankiJitsuNissu(RString.EMPTY);
        row_公費３.setTxtTaniGokei(kinngakuFormat(集計情報.get公費３_単位数合計()));
        row_公費３.setTxtTanisuTanka(RString.EMPTY);
        row_公費３.setTxtSeikyugaku(kinngakuFormat(集計情報.get公費３_請求額()));
        row_公費３.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_公費３.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get公費３_出来高単位数合計()));
        row_公費３.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get公費３_出来高請求額()));
        row_公費３.setTxtDekidakaHonninFutangaku(kinngakuFormat(集計情報.get公費３_出来高医療費本人負担額()));
        row_公費３.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_公費３.setTxtKagoKaisu(RString.EMPTY);
        row_公費３.setTxtShinsaYM(RString.EMPTY);
        rowList.add(row_公費３);
        dgKyufuJissekiShukei_Row row_後_公費３ = new dgKyufuJissekiShukei_Row();
        row_後_公費３.setTxtServiceShurui(RString.EMPTY);
        row_後_公費３.setTxtJitsuNissu(RString.EMPTY);
        row_後_公費３.setTxtKeikakuTani(RString.EMPTY);
        row_後_公費３.setTxtTaishoTani(RString.EMPTY);
        row_後_公費３.setTxtTaishogaiTani(RString.EMPTY);
        row_後_公費３.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_後_公費３.setTxtHokenKohi(TEXT_公費３);
        row_後_公費３.setTxtKettei(TEXT_後);
        row_後_公費３.setTxtTankiJitsuNissu(RString.EMPTY);
        row_後_公費３.setTxtTaniGokei(kinngakuFormat(集計情報.get後_公費３_単位数合計()));
        row_後_公費３.setTxtTanisuTanka(RString.EMPTY);
        row_後_公費３.setTxtSeikyugaku(kinngakuFormat(集計情報.get後_公費３_請求額()));
        row_後_公費３.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_後_公費３.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get後_公費３_出来高単位数合計()));
        row_後_公費３.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get後_公費３_出来高請求額()));
        row_後_公費３.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_後_公費３.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_後_公費３.setTxtKagoKaisu(RString.EMPTY);
        row_後_公費３.setTxtShinsaYM(RString.EMPTY);
        rowList.add(row_後_公費３);
        return rowList;
    }

    private dgKyufuJissekiMeisai_Row set明細情報(KyufujissekiMeisaiBusiness 明細情報) {
        dgKyufuJissekiMeisai_Row row = new dgKyufuJissekiMeisai_Row();
        row.setTxtService(setサービス種類(明細情報.get給付実績明細().getサービス種類コード()));
        row.setTxtKettei(RString.EMPTY);
        row.setTxtTani(checkDecimal(明細情報.get給付実績明細().get単位数()));
        row.setTxtKaisu(new RString(明細情報.get給付実績明細().get日数_回数()));
        row.setTxtKohi1Nissu(new RString(明細情報.get給付実績明細().get公費１対象日数_回数()));
        row.setTxtKohi2Nissu(new RString(明細情報.get給付実績明細().get公費２対象日数_回数()));
        row.setTxtKohi3Nissu(new RString(明細情報.get給付実績明細().get公費３対象日数_回数()));
        row.setTxtServiceTani(checkDecimal(明細情報.get給付実績明細().getサービス単位数()));
        row.setTxtKohi1Tani(checkDecimal(明細情報.get給付実績明細().get公費１対象サービス単位数()));
        row.setTxtKohi2Tani(checkDecimal(明細情報.get給付実績明細().get公費２対象サービス単位数()));
        row.setTxtKohi3Tani(checkDecimal(明細情報.get給付実績明細().get公費３対象サービス単位数()));
        row.setTxtSaiShinsaKaisu(new RString(明細情報.get給付実績明細().get再審査回数()));
        row.setTxtKagoKaisu(new RString(明細情報.get給付実績明細().get過誤回数()));
        row.setTxtShinsaYM(checkDate(明細情報.get給付実績明細().get審査年月()));
        row.setTxtTekiyo(明細情報.get給付実績明細().get摘要());
        return row;
    }

    private dgKyufuJissekiMeisai_Row set明細情報_後(KyufujissekiMeisaiBusiness 明細情報) {
        dgKyufuJissekiMeisai_Row row_後 = new dgKyufuJissekiMeisai_Row();
        row_後.setTxtService(RString.EMPTY);
        row_後.setTxtKettei(TEXT_後);
        row_後.setTxtTani(checkDecimal(明細情報.get給付実績明細().get後_単位数()));
        row_後.setTxtKaisu(new RString(明細情報.get給付実績明細().get後_日数_回数()));
        row_後.setTxtKohi1Nissu(new RString(明細情報.get給付実績明細().get後_公費１対象日数_回数()));
        row_後.setTxtKohi2Nissu(new RString(明細情報.get給付実績明細().get後_公費２対象日数_回数()));
        row_後.setTxtKohi3Nissu(new RString(明細情報.get給付実績明細().get後_公費３対象日数_回数()));
        row_後.setTxtServiceTani(checkDecimal(明細情報.get給付実績明細().get後_サービス単位数()));
        row_後.setTxtKohi1Tani(checkDecimal(明細情報.get給付実績明細().get後_公費１対象サービス単位数()));
        row_後.setTxtKohi2Tani(checkDecimal(明細情報.get給付実績明細().get後_公費２対象サービス単位数()));
        row_後.setTxtKohi3Tani(checkDecimal(明細情報.get給付実績明細().get後_公費３対象サービス単位数()));
        row_後.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_後.setTxtKagoKaisu(RString.EMPTY);
        row_後.setTxtShinsaYM(RString.EMPTY);
        row_後.setTxtTekiyo(RString.EMPTY);
        return row_後;
    }

    private dgKyufuJissekiMeisaiJustoku_Row set明細情報特例(KyufujissekiMeisaiJushochiTokurei 明細情報特例,
            List<KyufuJissekiSyokaiMeisaiSyukeiBusiness> 保険者情報) {
        dgKyufuJissekiMeisaiJustoku_Row row = new dgKyufuJissekiMeisaiJustoku_Row();
        row.setTxtService(setサービス種類(明細情報特例.getサービス種類コード()));
        row.setTxtKettei(RString.EMPTY);
        row.setTxtTani(checkDecimal(明細情報特例.get単位数()));
        row.setTxtKaisu(checkDecimal(明細情報特例.get日数_回数()));
        row.setTxtKohi1Nissu(checkDecimal(明細情報特例.get公費１対象日数_回数()));
        row.setTxtKohi2Nissu(checkDecimal(明細情報特例.get公費２対象日数_回数()));
        row.setTxtKohi3Nissu(checkDecimal(明細情報特例.get公費３対象日数_回数()));
        row.setTxtServiceTani(new RString(明細情報特例.getサービス単位数()));
        row.setTxtKohi1Tani(new RString(明細情報特例.get公費１対象サービス単位数()));
        row.setTxtKohi2Tani(new RString(明細情報特例.get公費２対象サービス単位数()));
        row.setTxtKohi3Tani(new RString(明細情報特例.get公費３対象サービス単位数()));
        row.setTxtSaiShinsaKaisu(checkDecimal(明細情報特例.get再審査回数()));
        row.setTxtKagoKaisu(checkDecimal(明細情報特例.get過誤回数()));
        row.setTxtShinsaYM(checkDate(明細情報特例.get審査年月()));
        row.setTxtShisetsuShozaiHokenshaNo(set施設所在保険者番号(明細情報特例.get施設所在保険者番号()));
        row.setTxtShisetsuShozaiHokenshaName(set保険者情報(明細情報特例, 保険者情報));
        row.setTxtTekiyo(明細情報特例.get摘要());
        return row;
    }

    private dgKyufuJissekiMeisaiJustoku_Row set明細情報特例_後(KyufujissekiMeisaiJushochiTokurei 明細情報特例) {
        dgKyufuJissekiMeisaiJustoku_Row row_後 = new dgKyufuJissekiMeisaiJustoku_Row();
        row_後.setTxtService(RString.EMPTY);
        row_後.setTxtKettei(TEXT_後);
        row_後.setTxtTani(checkDecimal(明細情報特例.get後_単位数()));
        row_後.setTxtKaisu(checkDecimal(明細情報特例.get後_日数_回数()));
        row_後.setTxtKohi1Nissu(checkDecimal(明細情報特例.get後_公費１対象日数_回数()));
        row_後.setTxtKohi2Nissu(checkDecimal(明細情報特例.get後_公費２対象日数_回数()));
        row_後.setTxtKohi3Nissu(checkDecimal(明細情報特例.get後_公費３対象日数_回数()));
        row_後.setTxtServiceTani(new RString(明細情報特例.get後_サービス単位数()));
        row_後.setTxtKohi1Tani(new RString(明細情報特例.get後_公費１対象サービス単位数()));
        row_後.setTxtKohi2Tani(new RString(明細情報特例.get後_公費２対象サービス単位数()));
        row_後.setTxtKohi3Tani(new RString(明細情報特例.get後_公費３対象サービス単位数()));
        row_後.setTxtSaiShinsaKaisu(RString.EMPTY);
        row_後.setTxtKagoKaisu(RString.EMPTY);
        row_後.setTxtShinsaYM(RString.EMPTY);
        row_後.setTxtShisetsuShozaiHokenshaNo(RString.EMPTY);
        row_後.setTxtShisetsuShozaiHokenshaName(RString.EMPTY);
        row_後.setTxtTekiyo(RString.EMPTY);
        return row_後;
    }

    private RString set保険者情報(KyufujissekiMeisaiJushochiTokurei 明細情報特例,
            List<KyufuJissekiSyokaiMeisaiSyukeiBusiness> 保険者情報) {
        for (KyufuJissekiSyokaiMeisaiSyukeiBusiness 保険者 : 保険者情報) {
            if (保険者.get保険者種別().equals(介護保険) && 保険者.get保険者番号().equals(明細情報特例.get被保険者番号().value())) {
                return 保険者.get保険者名();
            }
        }
        return RString.EMPTY;
    }

    private RString set施設所在保険者番号(ShoKisaiHokenshaNo data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return data.value();
    }

    private RString setサービス種類(ServiceShuruiCode サービス種類コード) {
        if (サービス種類コード != null && !サービス種類コード.isEmpty()) {
            return ServiceCategoryShurui.toValue(サービス種類コード.value()).get名称();
        }
        return RString.EMPTY;
    }

    private RString checkDate(FlexibleYearMonth data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return data.wareki().toDateString();
    }

    private RString checkInteger(Integer data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }

    private RString checkDecimal(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }

    private RString kinngakuFormat(Decimal data) {
        if (data == null || data == Decimal.ZERO) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(data, INT_ZERO);
    }
}
