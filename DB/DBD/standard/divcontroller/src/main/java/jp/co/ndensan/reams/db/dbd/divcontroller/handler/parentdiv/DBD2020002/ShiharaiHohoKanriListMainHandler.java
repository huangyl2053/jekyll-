/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020002.ShiharaiHohoKanriListMainDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 支払方法変更管理リストハンドラクラスです。
 *
 * @reamsid_L DBD-3630-010 zhulx
 */
public class ShiharaiHohoKanriListMainHandler {

    private final ShiharaiHohoKanriListMainDiv div;
    private static final RString RADIOBUTTONKEY0 = new RString("0");
    private static final RString RADIOBUTTONKEY1 = new RString("1");
    private static final RString RADIOBUTTONKEY2 = new RString("2");
    private static final RString RADIOBUTTONKEY3 = new RString("3");
    private static final RString RADIOBUTTONKEY4 = new RString("4");
    private static final RString RADIOBUTTONKEY5 = new RString("5");
    private static final RString RADIOBUTTONKEY6 = new RString("6");
    private static final RString DROPDOWNKEY0 = new RString("0");
    private static final RString DROPDOWNKEY1 = new RString("1");
    private static final RString DROPDOWNKEY2 = new RString("2");
    private static final RString DROPDOWNKEY3 = new RString("3");
    private static final RString DROPDOWNKEY4 = new RString("4");
    private static final RString 基準日 = new RString("基準日");

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        onLoad登録者の選択情報();
        onChange_radTorokusha();
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200007.getReportId());
    }

    /**
     * 登録区分を選択します。
     *
     */
    public void onChange_radTorokusha() {
        if (RADIOBUTTONKEY0.equals(div.getRadTorokusha().getSelectedKey())) {
            div.getDdl2GoSashitomeYokoku().setDisabled(true);
            div.getDdlGoSashitomeToroku().setDisabled(true);
            div.getDdl2GoShokanYokoku().setDisabled(true);
            div.getDdl1GoShokanKettei().setDisabled(true);
            div.getDdl1GoShokanKetteiSashitomeAriOnly().setDisabled(true);
            div.getDdl1GoShokanKetteiKojoAriOnly().setDisabled(true);
        } else if (RADIOBUTTONKEY1.equals(div.getRadTorokusha().getSelectedKey())) {
            div.getDdl2GoSashitomeYokoku().setDisabled(false);
            div.getDdlGoSashitomeToroku().setDisabled(true);
            div.getDdl2GoShokanYokoku().setDisabled(true);
            div.getDdl1GoShokanKettei().setDisabled(true);
            div.getDdl1GoShokanKetteiSashitomeAriOnly().setDisabled(true);
            div.getDdl1GoShokanKetteiKojoAriOnly().setDisabled(true);
        } else if (RADIOBUTTONKEY2.equals(div.getRadTorokusha().getSelectedKey())) {
            div.getDdl2GoSashitomeYokoku().setDisabled(true);
            div.getDdlGoSashitomeToroku().setDisabled(false);
            div.getDdl2GoShokanYokoku().setDisabled(true);
            div.getDdl1GoShokanKettei().setDisabled(true);
            div.getDdl1GoShokanKetteiSashitomeAriOnly().setDisabled(true);
            div.getDdl1GoShokanKetteiKojoAriOnly().setDisabled(true);
        } else if (RADIOBUTTONKEY3.equals(div.getRadTorokusha().getSelectedKey())) {
            div.getDdl2GoSashitomeYokoku().setDisabled(true);
            div.getDdlGoSashitomeToroku().setDisabled(true);
            div.getDdl2GoShokanYokoku().setDisabled(false);
            div.getDdl1GoShokanKettei().setDisabled(true);
            div.getDdl1GoShokanKetteiSashitomeAriOnly().setDisabled(true);
            div.getDdl1GoShokanKetteiKojoAriOnly().setDisabled(true);
        } else if (RADIOBUTTONKEY4.equals(div.getRadTorokusha().getSelectedKey())) {
            div.getDdl2GoSashitomeYokoku().setDisabled(true);
            div.getDdlGoSashitomeToroku().setDisabled(true);
            div.getDdl2GoShokanYokoku().setDisabled(true);
            div.getDdl1GoShokanKettei().setDisabled(false);
            div.getDdl1GoShokanKetteiSashitomeAriOnly().setDisabled(true);
            div.getDdl1GoShokanKetteiKojoAriOnly().setDisabled(true);
        } else if (RADIOBUTTONKEY5.equals(div.getRadTorokusha().getSelectedKey())) {
            div.getDdl2GoSashitomeYokoku().setDisabled(true);
            div.getDdlGoSashitomeToroku().setDisabled(true);
            div.getDdl2GoShokanYokoku().setDisabled(true);
            div.getDdl1GoShokanKettei().setDisabled(true);
            div.getDdl1GoShokanKetteiSashitomeAriOnly().setDisabled(false);
            div.getDdl1GoShokanKetteiKojoAriOnly().setDisabled(true);
        } else if (RADIOBUTTONKEY6.equals(div.getRadTorokusha().getSelectedKey())) {
            div.getDdl2GoSashitomeYokoku().setDisabled(true);
            div.getDdlGoSashitomeToroku().setDisabled(true);
            div.getDdl2GoShokanYokoku().setDisabled(true);
            div.getDdl1GoShokanKettei().setDisabled(true);
            div.getDdl1GoShokanKetteiSashitomeAriOnly().setDisabled(true);
            div.getDdl1GoShokanKetteiKojoAriOnly().setDisabled(false);
        }
        setSelTourokushaDefault();
    }

    /**
     * コンストラクタです。
     *
     * @param div PtnTotalDiv
     */
    public ShiharaiHohoKanriListMainHandler(ShiharaiHohoKanriListMainDiv div) {
        this.div = div;
    }

    /**
     * 基準日の必須チェックです。
     *
     * @return ValidationMessageControlPairs バリデーション結果
     */
    public ValidationMessageControlPairs 必須チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChushutsuJoken().getTxtKijunYMD().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 基準日.toString())));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private void onLoad登録者の選択情報() {
        div.getDdl2GoSashitomeYokoku().setDataSource(get登録者List(RADIOBUTTONKEY1));
        div.getDdlGoSashitomeToroku().setDataSource(get登録者List(RADIOBUTTONKEY2));
        div.getDdl2GoShokanYokoku().setDataSource(get登録者List(RADIOBUTTONKEY3));
        div.getDdl1GoShokanKettei().setDataSource(get登録者List(RADIOBUTTONKEY4));
        div.getDdl1GoShokanKetteiSashitomeAriOnly().setDataSource(get登録者List(RADIOBUTTONKEY5));
        div.getDdl1GoShokanKetteiKojoAriOnly().setDataSource(get登録者List(RADIOBUTTONKEY6));
    }

    private List<KeyValueDataSource> get登録者List(RString torokushaKbn) {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        KeyValueDataSource kv = new KeyValueDataSource(DROPDOWNKEY0, new RString("全て"));
        dataSources.add(kv);
        kv = new KeyValueDataSource(DROPDOWNKEY1, new RString("通知書未発行のみ"));
        dataSources.add(kv);

        if (RADIOBUTTONKEY1.equals(torokushaKbn)
                || RADIOBUTTONKEY2.equals(torokushaKbn)) {
            kv = new KeyValueDataSource(DROPDOWNKEY2, new RString("適用中者のみ"));
            dataSources.add(kv);
            kv = new KeyValueDataSource(DROPDOWNKEY3, new RString("適用終了者のみ"));
            dataSources.add(kv);
        } else if (RADIOBUTTONKEY3.equals(torokushaKbn)
                || RADIOBUTTONKEY4.equals(torokushaKbn)) {
            kv = new KeyValueDataSource(DROPDOWNKEY2, new RString("適用中者のみ"));
            dataSources.add(kv);
            kv = new KeyValueDataSource(DROPDOWNKEY3, new RString("適用中者（滞納保険料なし）のみ"));
            dataSources.add(kv);
            kv = new KeyValueDataSource(DROPDOWNKEY4, new RString("適用終了者のみ"));
            dataSources.add(kv);
        } else {
            kv = new KeyValueDataSource(DROPDOWNKEY2, new RString("滞納保険料なしのみ"));
            dataSources.add(kv);
        }

        return dataSources;
    }

    private void setSelTourokushaDefault() {
        div.getDdl2GoSashitomeYokoku().setSelectedKey(DROPDOWNKEY0);
        div.getDdlGoSashitomeToroku().setSelectedKey(DROPDOWNKEY0);
        div.getDdl2GoShokanYokoku().setSelectedKey(DROPDOWNKEY0);
        div.getDdl1GoShokanKettei().setSelectedKey(DROPDOWNKEY0);
        div.getDdl1GoShokanKetteiSashitomeAriOnly().setSelectedKey(DROPDOWNKEY0);
        div.getDdl1GoShokanKetteiKojoAriOnly().setSelectedKey(DROPDOWNKEY0);
    }
}
