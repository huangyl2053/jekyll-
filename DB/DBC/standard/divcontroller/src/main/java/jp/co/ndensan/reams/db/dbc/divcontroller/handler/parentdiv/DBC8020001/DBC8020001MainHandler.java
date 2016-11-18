/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.dbc8020001.DBC8020001;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050021.DBC050021_FurikomimeisaiFurikomiDataKogakuGassanParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050022.DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050023.DBC050023_FurikomimeisaiFurikomiDataJigyoKogakuGassanParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiIchiranChushutsuTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_SaishoriShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001.DBC8020001MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001.DBC8020001MainDivSpec;
import jp.co.ndensan.reams.db.dbc.service.core.jigyogasanjigyobunmeisaishosakusei.DBC8020001MainManager;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * 事業合算・事業分振込明細書作成（一括）のHandlerです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class DBC8020001MainHandler {

    private final DBC8020001MainDiv div;
    private static final RString メニューID_DBCMN63005 = new RString("DBCMN63005");
    private static final RString メニューID_DBCMNL3003 = new RString("DBCMNL3003");
    private static final RString メニューID_DBCMNN2004 = new RString("DBCMNN2004");
    private static final RString 実行するボタン_高額合算 = new RString("btnBatchRegisterKogakuGassan");
    private static final RString 実行するボタン_事業高額 = new RString("btnBatchRegisterJigyoKogaku");
    private static final RString 実行するボタン_事業高額合算 = new RString("btnBatchRegisterJigyoKogakuGassan");
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final RString 処理枝番 = new RString("0000");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString メッセージ = new RString("委託者情報の取得");
    private static final RString 振込データを作成する = new RString("振込データを作成する");
    private static final RString 振込指定日を修正する = new RString("振込指定日を修正する");
    private static final RString INDEX_1 = new RString("1");
    private static final RString INDEX_2 = new RString("2");
    private static final int INDEXSTART = 0;
    private static final int INDEX_4 = 4;
    private static final int INDEXEND = 6;

    /**
     * コンストラクターです。
     *
     * @param div GemmenJisshiJokyoMainDiv
     */
    public DBC8020001MainHandler(DBC8020001MainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs initialize(ValidationMessageControlPairs pairs) {

        RString メニューID = ResponseHolder.getMenuID();
        RString 処理名 = prepare処理名(メニューID);
        if (メニューID_DBCMN63005.equals(メニューID) || メニューID_DBCMNN2004.equals(メニューID)) {
            div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200003.getReportId());
        } else if (メニューID_DBCMNL3003.equals(メニューID)) {
            div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200102.getReportId());
        }

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(UrErrorMessages.実行不可, メッセージ.toString());
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8020001MainDivSpec.実行不可)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getItakusha()).build().check(messages));
        if (pairs.iterator().hasNext()) {
            if (メニューID_DBCMN63005.equals(メニューID)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行するボタン_高額合算, true);
            } else if (メニューID_DBCMNL3003.equals(メニューID)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行するボタン_事業高額, true);
            } else if (メニューID_DBCMNN2004.equals(メニューID)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行するボタン_事業高額合算, true);
            }
            return pairs;
        }

        DBC8020001MainManager manager = new DBC8020001MainManager();
        DBC8020001 dbc;
        dbc = manager.get前回処理情報(SubGyomuCode.DBC介護給付, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);

        init画面表示内容(メニューID, dbc);
        init表示制御(メニューID, dbc);
        return pairs;
    }

    private void init画面表示内容(RString メニューID, DBC8020001 dbc) {
        DBC8020001MainManager manager = new DBC8020001MainManager();
        DBC8020001 entity = manager.getFurikomiGroupItakushaRelateEntity(メニューID);
        KinyuKikanCode 代表金融機関コード = entity.getFurikomiGroupItakushaRelateEntity().get振込グループEntity().getDaihyoKinyuKikanCode();
        RString 振込グループコード = entity.getFurikomiGroupItakushaRelateEntity().get振込グループEntity().getFurikomiGroupCode();
        div.getItakusha().getTxtItakushaCode().setValue(entity.getFurikomiGroupItakushaRelateEntity().get振込委託者RelateEntity().
                get(0).get振込委託者Entity().getItakushaCode());
        div.getItakusha().getTxtItakushamei().setValue(entity.getFurikomiGroupItakushaRelateEntity().get振込委託者RelateEntity().
                get(0).get振込委託者Entity().getItakushamei());
        div.getItakusha().setItakushaId(new RString(entity.getFurikomiGroupItakushaRelateEntity().get振込委託者RelateEntity().
                get(0).get振込委託者Entity().getItakushaId().toString()));
        if (null != 代表金融機関コード) {
            div.getItakusha().getTxtFurikomiGroupCode().setValue(代表金融機関コード.value().concat(振込グループコード));
        }
        div.getItakusha().getTxtFurikomiGroupMeisho().setValue(entity.getFurikomiGroupItakushaRelateEntity().
                get振込グループEntity().getFurikomiGroupMeisho());

        List<KeyValueDataSource> list2 = new ArrayList<>();
        KeyValueDataSource source4 = new KeyValueDataSource();
        source4.setKey(Furikomi_ShoriKubun.振込データ作成.getコード());
        source4.setValue(Furikomi_ShoriKubun.振込データ作成.get名称());
        list2.add(source4);
        div.getRadShoriSentakuFurikomiDataSakusei().setDataSource(list2);
        div.getRadShoriSentakuFurikomiDataSakusei().setSelectedKey(INDEX_1);

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
            if (null != dbc.getEntity().getTaishoKaishiYMD()) {
                div.getTxtZenkaiTaishoYmdRange().setFromValue(new RDate(dbc.getEntity().getTaishoKaishiYMD().toString()));
            }
            if (null != dbc.getEntity().getTaishoShuryoYMD()) {
                div.getTxtZenkaiTaishoYmdRange().setToValue(new RDate(dbc.getEntity().getTaishoShuryoYMD().toString()));
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

    private void init表示制御(RString メニューID, DBC8020001 dbc) {
        if (メニューID.equals(メニューID_DBCMN63005)) {
            div.getTxtKetteishaUketoriYmRange().setVisible(false);
        } else if (メニューID.equals(メニューID_DBCMNL3003)) {
            div.getTxtKetteishaUketoriYmRange().setDisabled(false);
        } else if (メニューID.equals(メニューID_DBCMNN2004)) {
            div.getTxtKetteishaUketoriYmRange().setVisible(false);
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
            if (dbc.getEntity().getTaishoShuryoYMD() != null && !FlexibleDate.EMPTY.equals(dbc.getEntity().getTaishoShuryoYMD())) {
                div.getTxtKonkaiTaishoYmdRange().setFromValue(new RDate(dbc.getEntity().getTaishoShuryoYMD().toString()).plusDay(1));
                if (RDate.getNowDate().isBeforeOrEquals(new RDate(dbc.getEntity().getTaishoShuryoYMD().toString()))) {
                    div.getTxtKonkaiTaishoYmdRange().setToValue(new RDate(dbc.getEntity().getTaishoShuryoYMD().toString()).plusDay(1));
                } else {
                    div.getTxtKonkaiTaishoYmdRange().setToValue(RDate.getNowDate());
                }
            } else {
                div.getTxtKonkaiTaishoYmdRange().clearFromValue();
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

    private RString prepare処理名(RString メニューID) {
        RString 処理名 = RString.EMPTY;
        switch (メニューID.toString()) {
            case "DBCMN63005":
                処理名 = ShoriName.給付振込データ作成_高額合算.get名称();
                break;
            case "DBCMNL3003":
                処理名 = ShoriName.給付振込データ作成_事業高額.get名称();
                break;
            case "DBCMNN2004":
                処理名 = ShoriName.給付振込データ作成_事業高額合算.get名称();
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
        if (null != div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey()
                && INDEX_1.equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey())) {
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
        } else if (null != div.getRadShoriSentakuFurikomiDataModify().getSelectedKey()
                && INDEX_2.equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey())) {
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
        if (!div.getChkSaisakusei().getSelectedKeys().isEmpty() && div.getChkSaisakusei().getSelectedKeys().get(0).equals(INDEX_1)) {
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
     * 振込明細・振込みデータ作成（高額合算）パラメータを設定する。
     *
     * @return DBC050021_FurikomimeisaiFurikomiDataKogakuGassanParameter
     */
    public DBC050021_FurikomimeisaiFurikomiDataKogakuGassanParameter set高額合算BatchParameter() {
        DBC050021_FurikomimeisaiFurikomiDataKogakuGassanParameter parameter = new DBC050021_FurikomimeisaiFurikomiDataKogakuGassanParameter();
        parameter.set代表金融機関コード(new KinyuKikanCode(div.getItakusha().getTxtFurikomiGroupCode().getValue().substring(INDEXSTART, INDEX_4)));
        parameter.set再処理フラグ(div.getChkSaisakusei().isAllSelected());
        if (null != div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey()
                && INDEX_1.equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey())) {
            parameter.set処理区分(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey());
        } else if (null != div.getRadShoriSentakuFurikomiDataModify().getSelectedKey()
                && INDEX_2.equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey())) {
            parameter.set処理区分(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey());
        } else {
            parameter.set処理区分(div.getRadShoriSentakuIchiranhyoSakusei().getSelectedKey());
        }
        parameter.set出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID()));
        parameter.set委託者コード(div.getItakusha().getItakushaId());
        if (null != div.getTxtTaishoSakuseiYMD().getValue()) {
            parameter.set対象作成年月日(new FlexibleDate(div.getTxtTaishoSakuseiYMD().getValue().toDateString()));
        }
        if (振込データを作成する.equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedValue())) {
            if (null != div.getTxtFurikomiShiteiYMD().getValue()) {
                parameter.set振込指定年月日(div.getTxtFurikomiShiteiYMD().getValue());
            }
        } else if (振込指定日を修正する.equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedValue())
                && null != div.getTxtCorrectFurikomiShiteiYMD().getValue()) {
            parameter.set振込指定年月日(div.getTxtCorrectFurikomiShiteiYMD().getValue());
        }
        if (null != div.getTxtCorrectFurikomiShiteiYMD().getValue()) {
            parameter.set正振込指定年月日(div.getTxtCorrectFurikomiShiteiYMD().getValue());
        }
        if (null != div.getTxtKonkaiTaishoYmdRange().getToValue()) {
            parameter.set終了年月日(new FlexibleDate(div.getTxtKonkaiTaishoYmdRange().getToValue().toDateString()));
        }
        parameter.set抽出対象(div.getRadChushutsuTaisho().getSelectedKey());
        parameter.set振込グループコード(div.getItakusha().getTxtFurikomiGroupCode().getValue().substring(INDEX_4, INDEXEND));

        parameter.set支払方法(div.getRadSiharaihohou().getSelectedKey());
        if (null != div.getTxtKetteishaUketoriYmRange().getToValue()) {
            parameter.set終了受取年月(new FlexibleYearMonth(div.getTxtKetteishaUketoriYmRange().getToValue().toDateString()
                    .substring(INDEXSTART, INDEXEND)));
        }
        if (null != div.getTxtWrongFurikomiShiteiYMD().getValue()) {
            parameter.set誤振込指定年月日(div.getTxtWrongFurikomiShiteiYMD().getValue());

        }
        if (null != div.getTxtKetteishaUketoriYmRange().getFromValue()) {
            parameter.set開始受取年月(new FlexibleYearMonth(div.getTxtKetteishaUketoriYmRange().getFromValue().toDateString()
                    .substring(INDEXSTART, INDEXEND)));
        }
        if (null != div.getTxtKonkaiTaishoYmdRange().getFromValue()) {
            parameter.set開始年月日(new FlexibleDate(div.getTxtKonkaiTaishoYmdRange().getFromValue().toDateString()));
        }
        return parameter;
    }

    /**
     * 振込明細・振込みデータ作成（事業高額）パラメータを設定する。
     *
     * @return DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter
     */
    public DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter set事業高額BatchParameter() {
        DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter parameter = new DBC050022_FurikomimeisaiFurikomiDataJigyoKogakuParameter();
        parameter.set代表金融機関コード(new KinyuKikanCode(div.getItakusha().getTxtFurikomiGroupCode().getValue().substring(INDEXSTART, INDEX_4)));
        parameter.set再処理フラグ(div.getChkSaisakusei().isAllSelected());
        if (null != div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey()
                && INDEX_1.equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey())) {
            parameter.set処理区分(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey());
        } else if (null != div.getRadShoriSentakuFurikomiDataModify().getSelectedKey()
                && INDEX_2.equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey())) {
            parameter.set処理区分(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey());
        } else {
            parameter.set処理区分(div.getRadShoriSentakuIchiranhyoSakusei().getSelectedKey());
        }
        parameter.set出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID()));
        parameter.set委託者コード(div.getItakusha().getItakushaId());
        if (null != div.getTxtTaishoSakuseiYMD().getValue()) {
            parameter.set対象作成年月日(new FlexibleDate(div.getTxtTaishoSakuseiYMD().getValue().toDateString()));
        }
        if (振込データを作成する.equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedValue())) {
            if (null != div.getTxtFurikomiShiteiYMD().getValue()) {
                parameter.set振込指定年月日(div.getTxtFurikomiShiteiYMD().getValue());
            }
        } else if (振込指定日を修正する.equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedValue())
                && null != div.getTxtCorrectFurikomiShiteiYMD().getValue()) {
            parameter.set振込指定年月日(div.getTxtCorrectFurikomiShiteiYMD().getValue());
        }
        if (null != div.getTxtCorrectFurikomiShiteiYMD().getValue()) {
            parameter.set正振込指定年月日(div.getTxtCorrectFurikomiShiteiYMD().getValue());
        }
        if (null != div.getTxtKonkaiTaishoYmdRange().getToValue()) {
            parameter.set終了年月日(new FlexibleDate(div.getTxtKonkaiTaishoYmdRange().getToValue().toDateString()));
        }
        parameter.set抽出対象(div.getRadChushutsuTaisho().getSelectedKey());
        parameter.set振込グループコード(div.getItakusha().getTxtFurikomiGroupCode().getValue().substring(INDEX_4, INDEXEND));

        parameter.set支払方法(div.getRadSiharaihohou().getSelectedKey());
        if (null != div.getTxtKetteishaUketoriYmRange().getToValue()) {
            parameter.set終了受取年月(new FlexibleYearMonth(div.getTxtKetteishaUketoriYmRange().getToValue().toDateString()
                    .substring(INDEXSTART, INDEXEND)));
        }
        if (null != div.getTxtWrongFurikomiShiteiYMD().getValue()) {
            parameter.set誤振込指定年月日(div.getTxtWrongFurikomiShiteiYMD().getValue());

        }
        if (null != div.getTxtKetteishaUketoriYmRange().getFromValue()) {
            parameter.set開始受取年月(new FlexibleYearMonth(div.getTxtKetteishaUketoriYmRange().getFromValue().toDateString()
                    .substring(INDEXSTART, INDEXEND)));
        }
        if (null != div.getTxtKonkaiTaishoYmdRange().getFromValue()) {
            parameter.set開始年月日(new FlexibleDate(div.getTxtKonkaiTaishoYmdRange().getFromValue().toDateString()));
        }
        return parameter;
    }

    /**
     * 振込明細・振込みデータ作成（事業高額合算）パラメータを設定する。
     *
     * @return DBC050023_FurikomimeisaiFurikomiDataJigyoKogakuGassanParameter
     */
    public DBC050023_FurikomimeisaiFurikomiDataJigyoKogakuGassanParameter set事業高額合算BatchParameter() {
        DBC050023_FurikomimeisaiFurikomiDataJigyoKogakuGassanParameter parameter
                = new DBC050023_FurikomimeisaiFurikomiDataJigyoKogakuGassanParameter();
        parameter.set代表金融機関コード(new KinyuKikanCode(div.getItakusha().getTxtFurikomiGroupCode().getValue().substring(INDEXSTART, INDEX_4)));
        parameter.set再処理フラグ(div.getChkSaisakusei().isAllSelected());
        if (null != div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey()
                && INDEX_1.equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey())) {
            parameter.set処理区分(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedKey());
        } else if (null != div.getRadShoriSentakuFurikomiDataModify().getSelectedKey()
                && INDEX_2.equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey())) {
            parameter.set処理区分(div.getRadShoriSentakuFurikomiDataModify().getSelectedKey());
        } else {
            parameter.set処理区分(div.getRadShoriSentakuIchiranhyoSakusei().getSelectedKey());
        }
        parameter.set出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID()));
        parameter.set委託者コード(div.getItakusha().getItakushaId());
        if (null != div.getTxtTaishoSakuseiYMD().getValue()) {
            parameter.set対象作成年月日(new FlexibleDate(div.getTxtTaishoSakuseiYMD().getValue().toDateString()));
        }
        if (振込データを作成する.equals(div.getRadShoriSentakuFurikomiDataSakusei().getSelectedValue())) {
            if (null != div.getTxtFurikomiShiteiYMD().getValue()) {
                parameter.set振込指定年月日(div.getTxtFurikomiShiteiYMD().getValue());
            }
        } else if (振込指定日を修正する.equals(div.getRadShoriSentakuFurikomiDataModify().getSelectedValue())
                && null != div.getTxtCorrectFurikomiShiteiYMD().getValue()) {
            parameter.set振込指定年月日(div.getTxtCorrectFurikomiShiteiYMD().getValue());
        }
        if (null != div.getTxtCorrectFurikomiShiteiYMD().getValue()) {
            parameter.set正振込指定年月日(div.getTxtCorrectFurikomiShiteiYMD().getValue());
        }
        if (null != div.getTxtKonkaiTaishoYmdRange().getToValue()) {
            parameter.set終了年月日(new FlexibleDate(div.getTxtKonkaiTaishoYmdRange().getToValue().toDateString()));
        }
        parameter.set抽出対象(div.getRadChushutsuTaisho().getSelectedKey());
        parameter.set振込グループコード(div.getItakusha().getTxtFurikomiGroupCode().getValue().substring(INDEX_4, INDEXEND));

        parameter.set支払方法(div.getRadSiharaihohou().getSelectedKey());
        if (null != div.getTxtKetteishaUketoriYmRange().getToValue()) {
            parameter.set終了受取年月(new FlexibleYearMonth(div.getTxtKetteishaUketoriYmRange().getToValue().toDateString()
                    .substring(INDEXSTART, INDEXEND)));
        }
        if (null != div.getTxtWrongFurikomiShiteiYMD().getValue()) {
            parameter.set誤振込指定年月日(div.getTxtWrongFurikomiShiteiYMD().getValue());

        }
        if (null != div.getTxtKetteishaUketoriYmRange().getFromValue()) {
            parameter.set開始受取年月(new FlexibleYearMonth(div.getTxtKetteishaUketoriYmRange().getFromValue().toDateString()
                    .substring(INDEXSTART, INDEXEND)));
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
