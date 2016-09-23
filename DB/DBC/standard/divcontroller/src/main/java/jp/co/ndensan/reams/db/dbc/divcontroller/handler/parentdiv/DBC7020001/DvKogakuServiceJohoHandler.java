/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.KokuhorenFuicchi;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.SanteiKijun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShiharaiSaki;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShinsaHoho;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.Taishosha;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001.DvKogakuChushutsuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001.DvKogakuServiceJohoDiv;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
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
    private static final RString モード１ = new RString("DBCMN23001");
    private static final RString モード２ = new RString("DBCMN23019");

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
            panel.getRadKogakuKokuhorenFuicchi().setDataSource(get国保連不一致リスト());
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
    public HanyoListKogakuKaigoBatchParameter getBatchParamter(RString 市町村判定) {
        HanyoListKogakuKaigoBatchParameter batchparam = new HanyoListKogakuKaigoBatchParameter();
        batchparam.setModo(ViewStateHolder.get(ViewStateKeys.モード, int.class));
        if (div.getTxtShinsaNengetsu().getValue() == null) {
            batchparam.setShinsaYM(null);
        } else {
            batchparam.setShinsaYM(new FlexibleYearMonth(div.getTxtShinsaNengetsu().getValue().toString()));
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
        batchparam.setShinsaHoho(div
                .getDvKogakuChushutsuJoken().getDvKogakuService().getDdlKogakuShinsaHoho().getSelectedKey());
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
        return pairs;
    }

    private void batchParamterHandleParentAdd(HanyoListKogakuKaigoBatchParameter batchparam) {
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

    }

    private void batchParamterHandleSubAdd(HanyoListKogakuKaigoBatchParameter batchparam) {
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

    private List<KeyValueDataSource> get国保連不一致リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (KokuhorenFuicchi 国保連不一致 : KokuhorenFuicchi.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(国保連不一致.getコード(), 国保連不一致.get名称());
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
