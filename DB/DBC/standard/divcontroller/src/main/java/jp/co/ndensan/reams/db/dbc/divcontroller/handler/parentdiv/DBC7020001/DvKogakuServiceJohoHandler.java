/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710030.DBC710030_HanyoListKogakuKaigoServiceHiJokyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.SanteiKijun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShiharaiSaki;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShinsaHoho;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.Taishosha;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001.DvKogakuChushutsuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001.DvKogakuServiceJohoDiv;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCGM23001_汎用リスト出力(高額介護サービス費状況)
 *
 * @reamsid_L DBC-5040-010 chenyadong
 */
public class DvKogakuServiceJohoHandler {

    private final DvKogakuServiceJohoDiv div;
    private static final RString すべて_0 = new RString("0");
    private static final RString 事務広域 = new RString("事務広域");
    private static final RString 事務単一 = new RString("事務単一");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString すべて = new RString("すべて");
    private static final RString 口座払い = new RString("口座払い");
    private static final RString 窓口払い = new RString("窓口払い");
    private static final RString 項目名 = new RString("1");
    private static final RString 連番 = new RString("2");
    private static final RString 日付スラッシュ = new RString("3");
    private static final RString RSTRING_4 = new RString("4");
    private static final RString RSTRING_5 = new RString("5");
    private static final RString モード１ = new RString("DBCMN13001");
    private static final RString モード２ = new RString("DBCMN13019");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int INDEX_0 = 0;
    private static final int INDEX_4 = 4;
    private static final RString KEY_MODO = new RString("modo");
    private static final RString KEY_SHINSAYM = new RString("shinsaYM");
    private static final RString KEY_KOUSEISHICHOSONCODE = new RString("kouseiShichosonCode");
    private static final RString KEY_SERVICEYMFROM = new RString("serviceYmFrom");
    private static final RString KEY_SERVICEYMTO = new RString("serviceYmTo");
    private static final RString KEY_SHORIJOKYO = new RString("shoriJokyo");
    private static final RString KEY_SHINSAHOHO = new RString("shinsaHoho");
    private static final RString KEY_SANTEIKIJUN = new RString("santeiKijun");
    private static final RString KEY_KOKUHORENFUICCHI = new RString("kokuhorenFuicchi");
    private static final RString KEY_TAISHOSHA = new RString("taishosha");
    private static final RString KEY_SHINSEIKUBUN = new RString("shinseiKubun");
    private static final RString KEY_SHIHARAISAKI = new RString("shiharaiSaki");
    private static final RString KEY_KIYUKIKANCODE = new RString("kiyuKikanCode");
    private static final RString KEY_KIYUKIKANNAME = new RString("kiyuKikanName");
    private static final RString KEY_SHISEHIFROM = new RString("shisehiFrom");
    private static final RString KEY_SHISEHITO = new RString("shisehiTo");
    private static final RString KEY_HOKEMONOKETEIHIFROM = new RString("hokemonoKeteihiFrom");
    private static final RString KEY_HOKEMONOKETEIHITO = new RString("hokemonoKeteihiTo");
    private static final RString KEY_KOKUHOREKETEIYMFROM = new RString("kokuhoreKeteiymFrom");
    private static final RString KEY_KOKUHOREKETEIYMTO = new RString("kokuhoreKeteiymTo");
    private static final RString KEY_TAISHOSHAUKETORIYMFROM = new RString("taishoshaUketoriymFrom");
    private static final RString KEY_TAISHOSHAUKETORIYMTO = new RString("taishoshaUketoriymTo");
    private static final RString KEY_KOKUHORESOFUYMFROM = new RString("kokuhoreSofuYMFrom");
    private static final RString KEY_KOKUHORESOFUYMTO = new RString("kokuhoreSofuYMTo");
    private static final RString KEY_KETEIJOHOUKETORIYMFROM = new RString("keteijohoUketoriymFrom");
    private static final RString KEY_KETEIJOHOUKETORIYMTO = new RString("keteijohoUketoriymTo");
    private static final RString KEY_TOMOKUMEFUKA = new RString("tomokumeFuka");
    private static final RString KEY_REBANFUKA = new RString("rebanFuka");
    private static final RString KEY_HIZUKEHESHU = new RString("hizukeHeshu");
    private static final RString KEY_SHUTSURYOKUJU = new RString("shutsuryokuju");
    private static final RString KEY_KINYUKIKANSHITENCODE = new RString("kinyuKikanShitenCode");

    /**
     * コンストラクタです。
     *
     * @param div DvKogakuServiceJohoDiv
     */
    public DvKogakuServiceJohoHandler(DvKogakuServiceJohoDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッドです
     *
     * @param div DvKogakuServiceJohoDiv
     * @return DvKogakuServiceJohoHandler
     */
    public static DvKogakuServiceJohoHandler of(DvKogakuServiceJohoDiv div) {
        return new DvKogakuServiceJohoHandler(div);
    }

    /**
     * 初期化設定のinitializeメソッドです
     *
     * @param state RString
     */
    public void initialize(RString state) {
        DvKogakuChushutsuJokenDiv panel = div.getDvKogakuServiceParam().getDvKogakuChushutsuJoken();
        panel.getDdlKogakuShoriJokyo().setDataSource(get処理状況リスト(state));
        panel.getDdlKogakuSanteiKijun().setDataSource(get算定基準リスト());
        panel.getRadKogakuTaishosha().setDataSource(get対象者リスト());
        panel.getRadKogakuShinseiKubun().setDataSource(get申請区分リスト());
        panel.getRadKogakuShiharaisaki().setDataSource(get支払先リスト());

        div.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShoriJokyo().setSelectedKey(すべて_0);
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuSanteiKijun().setSelectedKey(すべて_0);
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuTaishosha().setSelectedKey(すべて_0);
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShinseiKubun().setSelectedKey(すべて_0);
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShiharaisaki().setSelectedKey(すべて_0);

        if (state.equals(モード１)) {
            panel.getDdlKogakuShinsaHoho().setDataSource(get審査方法リスト());
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShinsaHoho().setSelectedKey(すべて_0);
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuKokuhorenFuicchi().setSelectedKey(すべて_0);
        }

    }

    /**
     * 入力チェックのメソッドです。
     *
     * @return ValidationMessageControlPairs
     *
     */
    public ValidationMessageControlPairs getCheckMessage() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();

        RDate サービス提供年月From = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM()
                .getFromValue();
        RDate サービス提供年月To = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM()
                .getToValue();
        if (サービス提供年月From != null
                && サービス提供年月To != null
                && サービス提供年月To.isBefore(サービス提供年月From)) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.終了日が開始日以前),
                    div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM()));
            return pairs;
        }

        RDate 申請日From = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate().getFromValue();
        RDate 申請日To = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate().getToValue();
        if (申請日From != null
                && 申請日To != null
                && 申請日To.isBefore(申請日From)) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.終了日が開始日以前),
                    div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate()));
            return pairs;
        }

        RDate 保険者決定日From = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate()
                .getFromValue();
        RDate 保険者決定日To = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate()
                .getToValue();
        if (保険者決定日From != null
                && 保険者決定日To != null
                && 保険者決定日To.isBefore(保険者決定日From)) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.終了日が開始日以前),
                    div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate()));
            return pairs;
        }

        checkMessage(pairs);
        return pairs;
    }

    /**
     * 金融機関共有子Divの制御のメソッドです
     */
    public void getKinyuKikanSeigyo() {
        if (すべて.equals(div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShiharaisaki()
                .getSelectedValue())
                || 口座払い.equals(div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShiharaisaki()
                        .getSelectedValue())) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan().setDisabled(false);
        } else if (窓口払い.equals(div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShiharaisaki()
                .getSelectedValue())) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan().clear();
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan().setDisabled(true);
        }
    }

    /**
     * 「実行する」ボタンを押下バッチ実行、バッチパラメータ作成をします。
     *
     * @param 市町村判定 RString
     * @return HanyoListKogakuKaigoBatchParameter 汎用リスト_高額介護サービス費状況_バッチパラメータクラスです
     */
    public DBC710030_HanyoListKogakuKaigoServiceHiJokyoParameter getBatchParamter(RString 市町村判定) {
        DBC710030_HanyoListKogakuKaigoServiceHiJokyoParameter batchparam = new DBC710030_HanyoListKogakuKaigoServiceHiJokyoParameter();
        batchparam.setModo(ViewStateHolder.get(ViewStateKeys.モード, int.class));
        if (div.getTxtShinsaNengetsu().getValue() == null) {
            batchparam.setShinsaYM(null);
        } else {
            batchparam.setShinsaYM(new FlexibleYearMonth(div.getTxtShinsaNengetsu().getValue().getYearMonth().toDateString()));
        }
        if (事務広域.equals(市町村判定)) {
            HokenshaSummary 保険者DDLSelected = div.getDvKogakuChushutsuJoken().getCcdHokenshaList().getSelectedItem();
            if (!全市町村.equals(保険者DDLSelected.get市町村名称())) {
                batchparam.setKouseiShichosonCode(div.getDvKogakuChushutsuJoken().getCcdHokenshaList().getSelectedItem()
                        .get市町村コード());
            } else {
                div.getDvKogakuChushutsuJoken().getCcdHokenshaList().isDisabled();
            }
        }
        if (事務単一.equals(市町村判定)) {
            div.getDvKogakuChushutsuJoken().getCcdHokenshaList().isDisabled();
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM().getFromValue() == null) {
            batchparam.setServiceYmFrom(null);
        } else {
            batchparam.setServiceYmFrom(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuServiceTeikyoYM().getFromValue().getYearMonth().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM().getToValue() == null) {
            batchparam.setServiceYmTo(null);
        } else {
            batchparam.setServiceYmTo(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuServiceTeikyoYM().getToValue().getYearMonth().toString()));
        }
        batchparam.setShoriJokyo(div
                .getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShoriJokyo().getSelectedKey());
        batchparam.setShinsaHoho(RString.EMPTY);
        batchparam.setSanteiKijun(div
                .getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuSanteiKijun().getSelectedKey());
        batchparam.setKokuhorenFuicchi(div
                .getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuKokuhorenFuicchi().getSelectedKey());
        batchparam.setTaishosha(div
                .getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuTaishosha().getSelectedKey());
        batchparam.setShinseiKubun(div
                .getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShinseiKubun().getSelectedKey());
        batchparam.setShiharaiSaki(div
                .getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShiharaisaki().getSelectedKey());
        batchparam.setKiyuKikanCode(div.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan()
                .getKinyuKikanCode() == null ? RString.EMPTY : div
                        .getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan().getKinyuKikanCode().value());
        batchparam.setKiyuKikanName(div.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan()
                .get金融機関() == null ? RString.EMPTY : div.getDvKogakuChushutsuJoken()
                        .getDvKogakuService().getCcdKogakuKinyuKikan().get金融機関().get金融機関名称());
        batchparam.setReamsLoginId(ControlDataHolder.getUserId());
        batchParamterHandleParentAdd(batchparam);
        batchParamterHandleSubAdd(batchparam);
        return batchparam;
    }

    private ValidationMessageControlPairs checkMessage(ValidationMessageControlPairs pairs) {

        RDate 国保連決定年月From = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM()
                .getFromValue();
        RDate 国保連決定年月To = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM()
                .getToValue();
        if (国保連決定年月From != null
                && 国保連決定年月To != null
                && 国保連決定年月To.isBefore(国保連決定年月From)) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.終了日が開始日以前),
                    div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM()));
            return pairs;
        }

        RDate 対象者受取年月From = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM()
                .getFromValue();
        RDate 対象者受取年月To = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM()
                .getToValue();
        if (対象者受取年月From != null
                && 対象者受取年月To != null
                && 対象者受取年月To.isBefore(対象者受取年月From)) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.終了日が開始日以前),
                    div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM()));
            return pairs;
        }

        RDate 国保連送付年月From = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM()
                .getFromValue();
        RDate 国保連送付年月To = div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM()
                .getToValue();
        if (国保連送付年月From != null
                && 国保連送付年月To != null
                && 国保連送付年月To.isBefore(国保連送付年月From)) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.終了日が開始日以前),
                    div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM()));
            return pairs;
        }

        RDate 決定情報受取年月From = div.getDvKogakuChushutsuJoken().getDvKogakuService()
                .getTxtKogakuKetteiJohoUketoriYM().getFromValue();
        RDate 決定情報受取年月To = div.getDvKogakuChushutsuJoken().getDvKogakuService()
                .getTxtKogakuKetteiJohoUketoriYM().getToValue();
        if (決定情報受取年月From != null
                && 決定情報受取年月To != null
                && 決定情報受取年月To.isBefore(決定情報受取年月From)) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.終了日が開始日以前),
                    div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM()));
            return pairs;
        }

        if (div.getCcdKogakuShutsuryokujun().get出力順ID() == null) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.出力順序を指定)));
            return pairs;
        }
        return pairs;
    }

    private void batchParamterHandleParentAdd(DBC710030_HanyoListKogakuKaigoServiceHiJokyoParameter batchparam) {
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate().getFromValue() == null) {
            batchparam.setShisehiFrom(null);
        } else {
            batchparam.setShisehiFrom(new FlexibleDate(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuShinseiDate().getFromValue().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate().getToValue() == null) {
            batchparam.setShisehiTo(null);
        } else {
            batchparam.setShisehiTo(new FlexibleDate(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuShinseiDate().getToValue().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate().getFromValue() == null) {
            batchparam.setHokemonoKeteihiFrom(null);
        } else {
            batchparam.setHokemonoKeteihiFrom(new FlexibleDate(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuHokenshaKetteiDate().getFromValue().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate().getToValue() == null) {
            batchparam.setHokemonoKeteihiTo(null);
        } else {
            batchparam.setHokemonoKeteihiTo(new FlexibleDate(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuHokenshaKetteiDate().getToValue().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM().getFromValue() == null) {
            batchparam.setKokuhoreKeteiymFrom(null);
        } else {
            batchparam.setKokuhoreKeteiymFrom(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuKokuhorenKetteiYM().getFromValue().getYearMonth().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM().getToValue() == null) {
            batchparam.setKokuhoreKeteiymTo(null);
        } else {
            batchparam.setKokuhoreKeteiymTo(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuKokuhorenKetteiYM().getToValue().getYearMonth().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM().getFromValue() == null) {
            batchparam.setTaishoshaUketoriymFrom(null);
        } else {
            batchparam.setTaishoshaUketoriymFrom(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuTaishoshaUketoriYM().getFromValue().getYearMonth().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM().getToValue() == null) {
            batchparam.setTaishoshaUketoriymTo(null);
        } else {
            batchparam.setTaishoshaUketoriymTo(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuTaishoshaUketoriYM().getToValue().getYearMonth().toString()));
        }

    }

    private void batchParamterHandleSubAdd(DBC710030_HanyoListKogakuKaigoServiceHiJokyoParameter batchparam) {
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM().getFromValue() == null) {
            batchparam.setKokuhoreSofuYMFrom(null);
        } else {
            batchparam.setKokuhoreSofuYMFrom(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuKokuhorenSofuYM().getFromValue().getYearMonth().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM().getToValue() == null) {
            batchparam.setKokuhoreSofuYMTo(null);
        } else {
            batchparam.setKokuhoreSofuYMTo(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuKokuhorenSofuYM().getToValue().getYearMonth().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM().getFromValue() == null) {
            batchparam.setKeteijohoUketoriymFrom(null);
        } else {
            batchparam.setKeteijohoUketoriymFrom(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuKetteiJohoUketoriYM().getFromValue().getYearMonth().toString()));
        }
        if (div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM().getToValue() == null) {
            batchparam.setKeteijohoUketoriymTo(null);
        } else {
            batchparam.setKeteijohoUketoriymTo(new FlexibleYearMonth(div.getDvKogakuChushutsuJoken().getDvKogakuService()
                    .getTxtKogakuKetteiJohoUketoriYM().getToValue().getYearMonth().toString()));
        }
        batchparam.setShutsuryokuju(div.getCcdKogakuShutsuryokujun().get出力順ID());
        batchparam.setShutsuryokuTomoku(div.getCcdKogakuShutsuryokuKomoku().get出力項目ID()
                .isEmpty() ? RString.EMPTY : div
                        .getCcdKogakuShutsuryokuKomoku().get出力項目ID());
        batchparam.setTomokumeFuka(div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(項目名));
        batchparam.setRebanFuka(div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(連番));
        batchparam.setHizukeHeshu(div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(日付スラッシュ));
    }

    private List<KeyValueDataSource> get処理状況リスト(RString state) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShoriJokyo 処理状況 : ShoriJokyo.values()) {
            if (state.equals(モード１)) {
                KeyValueDataSource dataSource = new KeyValueDataSource(処理状況.getコード(), 処理状況.get略称());
                dataSourceList.add(dataSource);
            }
            if (state.equals(モード２)) {
                RString コード = 処理状況.getコード();
                if (!コード.equals(RSTRING_4) && !コード.equals(RSTRING_5)) {
                    KeyValueDataSource dataSource = new KeyValueDataSource(処理状況.getコード(), 処理状況.get略称());
                    dataSourceList.add(dataSource);
                }
            }
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get審査方法リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShinsaHoho 審査方法 : ShinsaHoho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(審査方法.getコード(), 審査方法.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get算定基準リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (SanteiKijun 算定基準 : SanteiKijun.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(算定基準.getコード(), 算定基準.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get対象者リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (Taishosha 対象者 : Taishosha.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(対象者.getコード(), 対象者.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get申請区分リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShinseiKubun 申請区分 : ShinseiKubun.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(申請区分.getコード(), 申請区分.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get支払先リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShiharaiSaki 支払先 : ShiharaiSaki.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(支払先.getコード(), 支払先.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     * @param 市町村判定 RString
     */
    public void pamaRestore(RString 市町村判定) {

        BatchParameterMap restoreBatchParameterMap = div.getBtnKogakuParamRestore().getRestoreBatchParameterMap();
        restoreClear(市町村判定);
        FlexibleYearMonth 審査年月 = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_SHINSAYM);
        if (審査年月 != null && !審査年月.isEmpty()) {
            div.getTxtShinsaNengetsu().setValue(new RDate(審査年月.getYearValue(), 審査年月.getMonthValue(), 審査年月.getLastDay()));
        }
        LasdecCode 構成市町村コード = restoreBatchParameterMap.getParameterValue(LasdecCode.class, KEY_KOUSEISHICHOSONCODE);
        if (構成市町村コード != null && !構成市町村コード.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getCcdHokenshaList().setSelectedShichosonIfExist(構成市町村コード);
        }
        FlexibleYearMonth サービス提供年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_SERVICEYMFROM);
        if (サービス提供年月From != null && !サービス提供年月From.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM().setFromValue(
                    new RDate(サービス提供年月From.getYearValue(), サービス提供年月From.getMonthValue(), サービス提供年月From.getLastDay()));
        }
        FlexibleYearMonth サービス提供年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_SERVICEYMTO);
        if (サービス提供年月To != null && !サービス提供年月To.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM().setToValue(
                    new RDate(サービス提供年月To.getYearValue(), サービス提供年月To.getMonthValue(), サービス提供年月To.getLastDay()));
        }
        RString 処理状況 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_SHORIJOKYO);
        if (!RString.isNullOrEmpty(処理状況)) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShoriJokyo().setSelectedKey(処理状況);
        }
        RString 審査方法 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_SHINSAHOHO);
        if (!RString.isNullOrEmpty(審査方法)) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShinsaHoho().setSelectedKey(審査方法);
        }
        RString 算定基準 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_SANTEIKIJUN);
        if (!RString.isNullOrEmpty(算定基準)) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuSanteiKijun().setSelectedKey(算定基準);
        }
        RString 国保連不一致 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_KOKUHORENFUICCHI);
        if (!RString.isNullOrEmpty(国保連不一致)) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuKokuhorenFuicchi().setSelectedKey(国保連不一致);
        }
        RString 対象者 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_TAISHOSHA);
        if (!RString.isNullOrEmpty(対象者)) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuTaishosha().setSelectedKey(対象者);
        }
        RString 申請区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_SHINSEIKUBUN);
        if (!RString.isNullOrEmpty(申請区分)) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShinseiKubun().setSelectedKey(申請区分);
        }
        FlexibleYearMonth 対象者受取年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_TAISHOSHAUKETORIYMFROM);
        if (対象者受取年月From != null && !対象者受取年月From.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM().setFromValue(
                    new RDate(対象者受取年月From.getYearValue(), 対象者受取年月From.getMonthValue(), 対象者受取年月From.getLastDay()));
        }
        FlexibleYearMonth 対象者受取年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_TAISHOSHAUKETORIYMTO);
        if (対象者受取年月To != null && !対象者受取年月To.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM().setToValue(
                    new RDate(対象者受取年月To.getYearValue(), 対象者受取年月To.getMonthValue(), 対象者受取年月To.getLastDay()));
        }
        pamaRestorePart2(restoreBatchParameterMap);
        pamaRestorePart3(restoreBatchParameterMap);
    }

    private void restoreClear(RString 市町村判定) {
        if (事務広域.equals(市町村判定)) {
            div.getCcdHokenshaList().loadHokenshaList();
        } else {
            div.getCcdHokenshaList().setDisabled(true);
            div.getCcdHokenshaList().setVisible(false);
        }
        div.getTxtShinsaNengetsu().clearValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM().clearFromValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuServiceTeikyoYM().clearToValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate().clearFromValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate().clearToValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate().clearFromValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate().clearToValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM().clearFromValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM().clearToValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM().clearFromValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuTaishoshaUketoriYM().clearToValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM().clearFromValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM().clearToValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM().clearFromValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM().clearToValue();
        div.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan().clear();
    }

    private void pamaRestorePart2(BatchParameterMap restoreBatchParameterMap) {
        RString 支払先 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_SHIHARAISAKI);
        if (!RString.isNullOrEmpty(支払先)) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getRadKogakuShiharaisaki().setSelectedKey(支払先);
        }
        RString 金融機関コード = restoreBatchParameterMap.getParameterValue(RString.class, KEY_KIYUKIKANCODE);
        RString 金融機関名称 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_KIYUKIKANNAME);
        KinyuKikanShitenCode 支店コード = restoreBatchParameterMap.getParameterValue(KinyuKikanShitenCode.class, KEY_KINYUKIKANSHITENCODE);
        if (!RString.isNullOrEmpty(金融機関コード) && !RString.isNullOrEmpty(金融機関名称)) {
            set金融機関(金融機関コード, 支店コード);
        }
        FlexibleDate 申請日From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_SHISEHIFROM);
        if (申請日From != null && !申請日From.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate().setFromValue(new RDate(申請日From.toString()));
        }
        FlexibleDate 申請日To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_SHISEHITO);
        if (申請日To != null && !申請日To.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuShinseiDate().setToValue(new RDate(申請日To.toString()));
        }
        FlexibleDate 保険者決定日From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_HOKEMONOKETEIHIFROM);
        if (保険者決定日From != null && !保険者決定日From.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate().setFromValue(new RDate(保険者決定日From.toString()));
        }
        FlexibleDate 保険者決定日To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_HOKEMONOKETEIHITO);
        if (保険者決定日To != null && !保険者決定日To.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuHokenshaKetteiDate().setToValue(new RDate(保険者決定日To.toString()));
        }

        FlexibleYearMonth 国保連決定年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_KOKUHOREKETEIYMFROM);
        if (国保連決定年月From != null && !国保連決定年月From.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM().setFromValue(
                    new RDate(国保連決定年月From.getYearValue(), 国保連決定年月From.getMonthValue(), 国保連決定年月From.getLastDay()));
        }
        FlexibleYearMonth 国保連決定年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_KOKUHOREKETEIYMTO);
        if (国保連決定年月To != null && !国保連決定年月To.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenKetteiYM().setToValue(
                    new RDate(国保連決定年月To.getYearValue(), 国保連決定年月To.getMonthValue(), 国保連決定年月To.getLastDay()));
        }
    }

    private void pamaRestorePart3(BatchParameterMap restoreBatchParameterMap) {
        FlexibleYearMonth 国保連送付年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_KOKUHORESOFUYMFROM);
        if (国保連送付年月From != null && !国保連送付年月From.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM().setFromValue(
                    new RDate(国保連送付年月From.getYearValue(), 国保連送付年月From.getMonthValue(), 国保連送付年月From.getLastDay()));
        }
        FlexibleYearMonth 国保連送付年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_KOKUHORESOFUYMTO);
        if (国保連送付年月To != null && !国保連送付年月To.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKokuhorenSofuYM().setToValue(
                    new RDate(国保連送付年月To.getYearValue(), 国保連送付年月To.getMonthValue(), 国保連送付年月To.getLastDay()));
        }
        FlexibleYearMonth 決定情報受取年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_KETEIJOHOUKETORIYMFROM);
        if (決定情報受取年月From != null && !決定情報受取年月From.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM().setFromValue(
                    new RDate(決定情報受取年月From.getYearValue(), 決定情報受取年月From.getMonthValue(), 決定情報受取年月From.getLastDay()));
        }
        FlexibleYearMonth 決定情報受取年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_KETEIJOHOUKETORIYMTO);
        if (決定情報受取年月To != null && !決定情報受取年月To.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getTxtKogakuKetteiJohoUketoriYM().setToValue(
                    new RDate(決定情報受取年月To.getYearValue(), 決定情報受取年月To.getMonthValue(), 決定情報受取年月To.getLastDay()));
        }
        List<RString> csv編集方法リスト = new ArrayList<>();
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_TOMOKUMEFUKA);
        if (項目名付加) {
            csv編集方法リスト.add(項目名);
        }
        boolean 連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_REBANFUKA);
        if (連番付加) {
            csv編集方法リスト.add(連番);
        }
        boolean 日付スラッシュ付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_HIZUKEHESHU);
        if (日付スラッシュ付加) {
            csv編集方法リスト.add(日付スラッシュ);
        }
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集方法リスト);
        int モード = restoreBatchParameterMap.getParameterValue(int.class, KEY_MODO);
        Long 出力順 = restoreBatchParameterMap.getParameterValue(Long.class, KEY_SHUTSURYOKUJU);
        if (出力順 != null && モード == NUM_1) {
            div.getCcdKogakuShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701003.getReportId(), 出力順);
        } else if (出力順 != null && モード == NUM_2) {
            div.getCcdKogakuShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701019.getReportId(), 出力順);
        }
        getKinyuKikanSeigyo();
    }

    private void set金融機関(RString 金融機関コード, KinyuKikanShitenCode 支店コード) {
        if (支店コード != null && !支店コード.isEmpty()) {
            div.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan().search(new KinyuKikanCode(金融機関コード),
                    支店コード, FlexibleDate.getNowDate());
        } else {
            KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
            KinyuKikan 金融機関 = kinyuKikanManager.getValidKinyuKikanOn(FlexibleDate.getNowDate(), 金融機関コード.substring(INDEX_0, INDEX_4));
            if (金融機関 != null) {
                div.getDvKogakuChushutsuJoken().getDvKogakuService().getCcdKogakuKinyuKikan().set金融機関(金融機関);
            }
        }
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
