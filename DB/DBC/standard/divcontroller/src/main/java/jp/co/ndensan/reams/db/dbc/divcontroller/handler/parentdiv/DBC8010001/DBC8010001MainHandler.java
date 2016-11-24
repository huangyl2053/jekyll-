/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.dbc8010001.DBC8010001;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050010.DBC050010_FurikomimeisaiFurikomiDataParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiIchiranChushutsuTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_SaishoriShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriTaisho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001.DBC8010001MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001.DBC8010001MainDivSpec;
import jp.co.ndensan.reams.db.dbc.service.core.furikomidaitasakusai.DBC8010001MainManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 振込明細・振込みデータ作成のHandlerです。
 *
 * @reamsid_L DBC-2180-010 x_liuwei
 */
public class DBC8010001MainHandler {

    private final DBC8010001MainDiv div;
    private static final int INDEXSTART = 0;
    private static final int INDEXEND = 6;
    private static final int INDEX_4 = 4;
    private static final RString 受託あり = new RString("2");

    /**
     * コンストラクターです。
     *
     * @param div GemmenJisshiJokyoMainDiv
     */
    public DBC8010001MainHandler(DBC8010001MainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs initialize(ValidationMessageControlPairs pairs) {
        div.getCcdChohyoShutsuryokujun().load(new SubGyomuCode(new RString("DBC")), new ReportId(new RString("DBC200101_FurikomiMeisaiIchiran")));

        RString メニューID = ResponseHolder.getMenuID();
        RString 振込単位 = DbBusinessConfig.get(ConfigNameDBC.振込単位, RDate.getNowDate(), SubGyomuCode.DBC介護給付);

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(UrErrorMessages.実行不可, "委託者情報の取得");
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8010001MainDivSpec.実行不可)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getItakusha()).build().check(messages));
        if (pairs.iterator().hasNext()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnBatchRegister"), true);
            return pairs;
        }

        RString 処理名 = prepare処理名(メニューID, 振込単位);
        DBC8010001MainManager manager = new DBC8010001MainManager();
        DBC8010001 dbc;
        dbc = manager.get前回処理情報(SubGyomuCode.DBC介護給付, new LasdecCode("000000"), 処理名, new RString("0000"), new FlexibleYear("0000"), new RString("0001"));

        init画面表示内容(メニューID, 振込単位, dbc);
        init表示制御(メニューID, 振込単位, dbc);
        return pairs;
    }

    private void init画面表示内容(RString メニューID, RString 振込単位, DBC8010001 dbc) {
        DBC8010001MainManager manager = new DBC8010001MainManager();
        DBC8010001 entity = manager.getFurikomiGroupItakushaRelateEntity(メニューID, 振込単位);
        div.getItakusha().getTxtItakushaCode().setValue(entity.getFurikomiGroupItakushaRelateEntity().get振込委託者RelateEntity().get(0).get振込委託者Entity().getItakushaCode());
        div.getItakusha().getTxtItakushamei().setValue(entity.getFurikomiGroupItakushaRelateEntity().get振込委託者RelateEntity().get(0).get振込委託者Entity().getItakushamei());
        div.getItakusha().setItakushaId(new RString(entity.getFurikomiGroupItakushaRelateEntity().get振込委託者RelateEntity().get(0).get振込委託者Entity().getItakushaId().toString()));
        div.getItakusha().getTxtFurikomiGroupCode().setValue(
                entity.getFurikomiGroupItakushaRelateEntity().get振込委託者RelateEntity().get(0).get振込委託者Entity().getKinyuKikanCode().value()
                .concat(entity.getFurikomiGroupItakushaRelateEntity().get振込グループEntity().getFurikomiGroupCode()));
        div.getItakusha().getTxtFurikomiGroupMeisho().setValue(entity.getFurikomiGroupItakushaRelateEntity().get振込グループEntity().getFurikomiGroupMeisho());
        List<KeyValueDataSource> list1 = new ArrayList<>();
        KeyValueDataSource source1 = new KeyValueDataSource();
        source1.setKey(Furikomi_ShoriTaisho.償還高額.getコード());
        source1.setValue(Furikomi_ShoriTaisho.償還高額.get名称());
        KeyValueDataSource source2 = new KeyValueDataSource();
        source2.setKey(Furikomi_ShoriTaisho.償還.getコード());
        source2.setValue(Furikomi_ShoriTaisho.償還.get名称());
        KeyValueDataSource source3 = new KeyValueDataSource();
        source3.setKey(Furikomi_ShoriTaisho.高額.getコード());
        source3.setValue(Furikomi_ShoriTaisho.高額.get名称());
        list1.add(source1);
        list1.add(source2);
        list1.add(source3);
        div.getDdlShoriTaisho().setDataSource(list1);

        List<KeyValueDataSource> list2 = new ArrayList<>();
        KeyValueDataSource source4 = new KeyValueDataSource();
        source4.setKey(Furikomi_ShoriKubun.振込データ作成.getコード());
        source4.setValue(Furikomi_ShoriKubun.振込データ作成.get名称());
        list2.add(source4);
        div.getRadShoriSentakuFurikomiDataSakusei().setDataSource(list2);
        div.getRadShoriSentakuFurikomiDataSakusei().setSelectedKey(new RString("1"));

        List<KeyValueDataSource> list3 = new ArrayList<>();
        KeyValueDataSource source5 = new KeyValueDataSource();
        source5.setKey(Furikomi_SaishoriShitei.再処理.getコード());
        source5.setValue(Furikomi_SaishoriShitei.再処理.get名称());
        list3.add(source5);
        div.getChkSaisakusei().setDataSource(list3);

        List<KeyValueDataSource> list4 = new ArrayList<>();
        KeyValueDataSource source6 = new KeyValueDataSource();
        source6.setKey(Furikomi_ShoriKubun.振込指定日修正.getコード());
        source6.setValue(Furikomi_ShoriKubun.振込指定日修正.get名称());
        list4.add(source6);
        div.getRadShoriSentakuFurikomiDataModify().setDataSource(list4);

        List<KeyValueDataSource> list5 = new ArrayList<>();
        KeyValueDataSource source7 = new KeyValueDataSource();
        source7.setKey(Furikomi_ShoriKubun.明細一覧表作成.getコード());
        source7.setValue(Furikomi_ShoriKubun.明細一覧表作成.get名称());
        list5.add(source7);
        div.getRadShoriSentakuIchiranhyoSakusei().setDataSource(list5);

        List<KeyValueDataSource> list6 = new ArrayList<>();
        KeyValueDataSource source8 = new KeyValueDataSource();
        source8.setKey(Furikomi_ShihraiHohoShitei.口座.getコード());
        source8.setValue(Furikomi_ShihraiHohoShitei.口座.get名称());
        KeyValueDataSource source9 = new KeyValueDataSource();
        source9.setKey(Furikomi_ShihraiHohoShitei.窓口.getコード());
        source9.setValue(Furikomi_ShihraiHohoShitei.窓口.get名称());
        list6.add(source8);
        list6.add(source9);
        div.getRadSiharaihohou().setDataSource(list6);

        if (null != dbc) {
            if (null != dbc.getEntity().getTaishoKaishiYMD() && !dbc.getEntity().getTaishoKaishiYMD().isEmpty()) {
                div.getTxtZenkaiTaishoYmdRange().setFromValue(dbc.getEntity().getTaishoKaishiYMD().toRDate());
            }
            if (null != dbc.getEntity().getTaishoShuryoYMD() && !dbc.getEntity().getTaishoShuryoYMD().isEmpty()) {
                div.getTxtZenkaiTaishoYmdRange().setToValue(dbc.getEntity().getTaishoShuryoYMD().toRDate());
            }
        }

        List<KeyValueDataSource> list7 = new ArrayList<>();
        KeyValueDataSource source10 = new KeyValueDataSource();
        source10.setKey(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済を除く.getコード());
        source10.setValue(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済を除く.get名称());
        KeyValueDataSource source11 = new KeyValueDataSource();
        source11.setKey(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済のみ.getコード());
        source11.setValue(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済のみ.get名称());
        KeyValueDataSource source12 = new KeyValueDataSource();
        source12.setKey(Furikomi_MeisaiIchiranChushutsuTaisho.全て.getコード());
        source12.setValue(Furikomi_MeisaiIchiranChushutsuTaisho.全て.get名称());
        list7.add(source10);
        list7.add(source11);
        list7.add(source12);
        div.getRadChushutsuTaisho().setDataSource(list7);
    }

    private void init表示制御(RString メニューID, RString 振込単位, DBC8010001 dbc) {
        RString 国保連共同処理受託区分_高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        boolean is決定者受取年月表示 = 国保連共同処理受託区分_高額.equals(受託あり);
        if (メニューID.equals(new RString("DBCMN43003"))) {
            if (振込単位.equals(new RString("1"))) {
                div.getDdlShoriTaisho().setSelectedKey(Furikomi_ShoriTaisho.償還高額.getコード());
                div.getDdlShoriTaisho().setDisabled(false);
                div.getTxtKetteishaUketoriYmRange().setDisabled(false);
                div.getTxtKetteishaUketoriYmRange().setVisible(is決定者受取年月表示);
            } else if (振込単位.equals(new RString("2"))) {
                div.getDdlShoriTaisho().setSelectedKey(Furikomi_ShoriTaisho.高額.getコード());
                div.getDdlShoriTaisho().setDisabled(true);
                div.getTxtKetteishaUketoriYmRange().setDisabled(false);
                div.getTxtKetteishaUketoriYmRange().setVisible(is決定者受取年月表示);
            }
        } else if (メニューID.equals(new RString("DBCMN54002"))) {
            if (振込単位.equals(new RString("1"))) {
                div.getDdlShoriTaisho().setSelectedKey(Furikomi_ShoriTaisho.償還高額.getコード());
                div.getDdlShoriTaisho().setDisabled(false);
                div.getTxtKetteishaUketoriYmRange().setDisabled(false);
                div.getTxtKetteishaUketoriYmRange().setVisible(is決定者受取年月表示);
            } else if (振込単位.equals(new RString("2"))) {
                div.getDdlShoriTaisho().setSelectedKey(Furikomi_ShoriTaisho.償還.getコード());
                div.getDdlShoriTaisho().setDisabled(true);
                div.getTxtKetteishaUketoriYmRange().setVisible(false);
            }
        }

        div.getRadShoriSentakuFurikomiDataSakusei().setSelectedKey(Furikomi_ShoriKubun.振込データ作成.getコード());
        div.getTxtFurikomiShiteiYMD().setValue(RDate.getNowDate());
        div.getRadShoriSentakuFurikomiDataModify().clearSelectedItem();
        div.getTxtWrongFurikomiShiteiYMD().clearValue();
        div.getTxtWrongFurikomiShiteiYMD().setDisabled(true);
        div.getTxtCorrectFurikomiShiteiYMD().clearValue();
        div.getTxtCorrectFurikomiShiteiYMD().setDisabled(true);
        div.getRadShoriSentakuIchiranhyoSakusei().clearSelectedItem();
        div.getRadSiharaihohou().setSelectedKey(Furikomi_ShihraiHohoShitei.口座.getコード());
        div.getRadSiharaihohou().setDisabled(true);

        if (null == dbc) {
            div.getTxtZenkaiTaishoYmdRange().clearFromValue();
            div.getTxtZenkaiTaishoYmdRange().clearToValue();
            div.getTxtKonkaiTaishoYmdRange().clearFromValue();
            div.getTxtKonkaiTaishoYmdRange().setToValue(RDate.getNowDate());
        } else {
            div.getTxtKonkaiTaishoYmdRange().setFromValue(dbc.getEntity().getTaishoShuryoYMD().toRDate().plusDay(1));
            if (RDate.getNowDate().isBeforeOrEquals(dbc.getEntity().getTaishoShuryoYMD().toRDate())) {
                div.getTxtKonkaiTaishoYmdRange().setToValue(dbc.getEntity().getTaishoShuryoYMD().toRDate().plusDay(1));
            } else {
                div.getTxtKonkaiTaishoYmdRange().setToValue(RDate.getNowDate());
            }
        }
        div.getTxtKetteishaUketoriYmRange().clearFromValue();
        div.getTxtKetteishaUketoriYmRange().clearToValue();

        div.getRadChushutsuTaisho().setSelectedKey(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済を除く.getコード());
        div.getRadChushutsuTaisho().setDisabled(true);
        div.getTxtTaishoSakuseiYMD().clearValue();
        div.getTxtTaishoSakuseiYMD().setDisabled(true);

    }

    /**
     * @param メニューID RString
     * @param 振込単位 RString
     * @return RString
     */
    public RString prepare処理名(RString メニューID, RString 振込単位) {
        RString 処理名 = new RString("");
        switch (メニューID.toString()) {
            case "DBCMN43003":
                switch (振込単位.toString()) {
                    case "1":
                        処理名 = ShoriName.給付振込データ作成_償還高額.get名称();
                        break;
                    case "2":
                        処理名 = ShoriName.給付振込データ作成_高額.get名称();
                        break;
                    default:
                        break;
                }
                break;
            case "DBCMN54002":
                switch (振込単位.toString()) {
                    case "1":
                        処理名 = ShoriName.給付振込データ作成_償還高額.get名称();
                        break;
                    case "2":
                        処理名 = ShoriName.給付振込データ作成_償還.get名称();
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return 処理名;
    }

    /**
     * 処理選択ラジオボタンonChange。
     */
    public void onChange_RadShoriSentaku() {
        if (null != div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey() && new RString("1").equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey())) {
            div.getTxtFurikomiShiteiYMD().setDisabled(false);
            div.getChkSaisakusei().setDisabled(false);
            div.getFurikomiDataModifyShiji().setDisabled(true);
            div.getTxtWrongFurikomiShiteiYMD().setDisabled(true);
            div.getTxtCorrectFurikomiShiteiYMD().setDisabled(true);
            div.getTxtWrongFurikomiShiteiYMD().clearValue();
            div.getTxtCorrectFurikomiShiteiYMD().clearValue();
            div.getRadSiharaihohou().setSelectedKey(Furikomi_ShihraiHohoShitei.口座.getコード());
            div.getIchiranhyoSakuseiShiji().setDisabled(true);
            div.getRadSiharaihohou().setDisabled(true);
            div.getTxtKonkaiTaishoYmdRange().setDisabled(false);
            div.getTxtKetteishaUketoriYmRange().setDisabled(false);
            div.getRadChushutsuTaisho().setSelectedKey(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済を除く.getコード());
            div.getRadChushutsuTaisho().setDisabled(true);
            div.getTxtTaishoSakuseiYMD().clearValue();
            div.getTxtTaishoSakuseiYMD().setDisabled(true);
        } else if (null != div.getRadShoriSentakuFurikomiDataModify().getSelectedKey() && new RString("2").equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey())) {
            div.getTxtFurikomiShiteiYMD().setDisabled(true);
            div.getChkSaisakusei().setSelectedItems(new ArrayList<KeyValueDataSource>());
            div.getChkSaisakusei().setDisabled(true);
            div.getFurikomiDataModifyShiji().setDisabled(false);
            div.getTxtWrongFurikomiShiteiYMD().setDisabled(false);
            div.getTxtCorrectFurikomiShiteiYMD().setDisabled(false);
            div.getRadSiharaihohou().setSelectedKey(Furikomi_ShihraiHohoShitei.口座.getコード());
            div.getIchiranhyoSakuseiShiji().setDisabled(true);
            div.getRadSiharaihohou().setDisabled(true);
            div.getTxtKonkaiTaishoYmdRange().setDisabled(true);
            div.getTxtKetteishaUketoriYmRange().setDisabled(true);
            div.getRadChushutsuTaisho().setSelectedKey(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済のみ.getコード());
            div.getRadChushutsuTaisho().setDisabled(true);
            div.getTxtTaishoSakuseiYMD().setDisabled(false);
            div.getTxtTaishoSakuseiYMD().setRequired(true);
        } else {
            div.getTxtFurikomiShiteiYMD().setDisabled(true);
            div.getChkSaisakusei().setSelectedItems(new ArrayList<KeyValueDataSource>());
            div.getChkSaisakusei().setDisabled(true);
            div.getFurikomiDataModifyShiji().setDisabled(true);
            div.getTxtWrongFurikomiShiteiYMD().setDisabled(false);
            div.getTxtCorrectFurikomiShiteiYMD().setDisabled(false);
            div.getTxtWrongFurikomiShiteiYMD().clearValue();
            div.getTxtCorrectFurikomiShiteiYMD().clearValue();
            div.getIchiranhyoSakuseiShiji().setDisabled(false);
            div.getRadSiharaihohou().setDisabled(false);
            div.getTxtKonkaiTaishoYmdRange().setDisabled(false);
            div.getTxtKetteishaUketoriYmRange().setDisabled(false);
            div.getRadChushutsuTaisho().setSelectedKey(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済を除く.getコード());
            div.getRadChushutsuTaisho().setDisabled(false);
            div.getTxtTaishoSakuseiYMD().clearValue();
            div.getTxtTaishoSakuseiYMD().setDisabled(true);
        }
    }

    /**
     * 再作成するチェックボックスonClick。
     */
    public void onClick_ChkSaisakusei() {
        if (!div.getChkSaisakusei().getSelectedKeys().isEmpty() && div.getChkSaisakusei().getSelectedKeys().get(0).equals(new RString("1"))) {
            div.getRadChushutsuTaisho().setSelectedKey(Furikomi_MeisaiIchiranChushutsuTaisho.全て.getコード());
            div.getRadChushutsuTaisho().setDisabled(true);
            div.getTxtTaishoSakuseiYMD().setDisabled(false);
            div.getTxtTaishoSakuseiYMD().setRequired(true);
        } else {
            div.getRadChushutsuTaisho().setSelectedKey(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済を除く.getコード());
            div.getRadChushutsuTaisho().setDisabled(true);
            div.getTxtTaishoSakuseiYMD().clearValue();
            div.getTxtTaishoSakuseiYMD().setDisabled(true);
        }
    }

    /**
     * 支払方法ラジオボタンonChange。
     */
    public void onChange_RadSiharaihohou() {
        RString key = div.getRadSiharaihohou().getSelectedKey();
        if (key.equals(Furikomi_ShihraiHohoShitei.口座.getコード())) {
            div.getRadChushutsuTaisho().setDisabled(false);
        } else {
            div.getRadChushutsuTaisho().setSelectedKey(Furikomi_MeisaiIchiranChushutsuTaisho.全て.getコード());
            div.getRadChushutsuTaisho().setDisabled(true);
            div.getTxtTaishoSakuseiYMD().clearValue();
            div.getTxtTaishoSakuseiYMD().setDisabled(true);
        }
    }

    /**
     * 抽出対象ラジオボタンonChange。
     */
    public void onChange_RadChushutsuTaisho() {
        RString key = div.getRadChushutsuTaisho().getSelectedKey();
        if (key.equals(Furikomi_MeisaiIchiranChushutsuTaisho.振込データ作成済のみ.getコード())) {
            div.getTxtTaishoSakuseiYMD().setDisabled(false);
            div.getTxtTaishoSakuseiYMD().setRequired(false);
        } else {
            div.getTxtTaishoSakuseiYMD().clearValue();
            div.getTxtTaishoSakuseiYMD().setDisabled(true);
        }
    }

    /**
     * 振込明細・振込みデータ作成パラメータを設定する。
     *
     * @return DBC050010_FurikomimeisaiFurikomiDataParameter
     */
    public DBC050010_FurikomimeisaiFurikomiDataParameter setBatchParameter() {
        DBC050010_FurikomimeisaiFurikomiDataParameter parameter = new DBC050010_FurikomimeisaiFurikomiDataParameter();
        parameter.set代表金融機関コード(new KinyuKikanCode(div.getItakusha().getTxtFurikomiGroupCode().getValue().substring(0, INDEX_4)));
        parameter.set再処理フラグ(div.getChkSaisakusei().isAllSelected());
        if (!div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey().isEmpty()) {
            parameter.set処理区分(Furikomi_ShoriKubun.toValue(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey()));
        } else if (!div.getRadShoriSentakuFurikomiDataModify().getSelectedKey().isEmpty()) {
            parameter.set処理区分(Furikomi_ShoriKubun.toValue(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey()));
        } else if (!div.getRadShoriSentakuIchiranhyoSakusei().getSelectedKey().isEmpty()) {
            parameter.set処理区分(Furikomi_ShoriKubun.toValue(div.getRadShoriSentakuIchiranhyoSakusei().getSelectedKey()));
        }
        parameter.set処理対象(Furikomi_ShoriTaisho.toValue(div.getDdlShoriTaisho().getSelectedKey()));
        parameter.set出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        parameter.set委託者コード(div.getTxtItakushaCode().getValue());
        if (null != div.getTxtTaishoSakuseiYMD().getValue()) {
            parameter.set対象作成年月日(new FlexibleDate(div.getTxtTaishoSakuseiYMD().getValue().toDateString()));
        }
        if (null != div.getTxtFurikomiShiteiYMD().getValue()) {
            parameter.set振込指定年月日(div.getTxtFurikomiShiteiYMD().getValue());
        }
        if (null != div.getTxtCorrectFurikomiShiteiYMD().getValue()) {
            parameter.set正振込指定年月日(div.getTxtCorrectFurikomiShiteiYMD().getValue());
        }
        if (null != div.getTxtKonkaiTaishoYmdRange().getToValue()) {
            parameter.set終了年月日(new FlexibleDate(div.getTxtKonkaiTaishoYmdRange().getToValue().toDateString()));
        }
        parameter.set抽出対象(Furikomi_MeisaiIchiranChushutsuTaisho.toValue(div.getRadChushutsuTaisho().getSelectedKey()));
        parameter.set振込グループコード(div.getItakusha().getTxtFurikomiGroupCode().getValue().substring(INDEX_4));

        parameter.set支払方法(Furikomi_ShihraiHohoShitei.toValue(div.getRadSiharaihohou().getSelectedKey()));
        if (null != div.getTxtKetteishaUketoriYmRange().getToValue()) {
            parameter.set終了受取年月(new FlexibleYearMonth(div.getTxtKetteishaUketoriYmRange().getToValue().toDateString().substring(INDEXSTART, INDEXEND)));
        }
        if (null != div.getTxtWrongFurikomiShiteiYMD().getValue()) {
            parameter.set誤振込指定年月日(div.getTxtWrongFurikomiShiteiYMD().getValue());

        }
        if (null != div.getTxtKetteishaUketoriYmRange().getFromValue()) {
            parameter.set開始受取年月(new FlexibleYearMonth(div.getTxtKetteishaUketoriYmRange().getFromValue().toDateString().substring(INDEXSTART, INDEXEND)));
        }
        if (null != div.getTxtKonkaiTaishoYmdRange().getFromValue()) {
            parameter.set開始年月日(new FlexibleDate(div.getTxtKonkaiTaishoYmdRange().getFromValue().toDateString()));
        }
        return parameter;
    }

    private static final class NoInputMessages implements IValidationMessage {

        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
