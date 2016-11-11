/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA5010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA090010.DBA090010_AtenaSeelParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA5010011.AtenaSealCreateDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 宛名シール作成のHandlerです。
 *
 * @reamsid_L DBA-1210-010 zhengsongling
 */
public class AtenaSealCreateHandler {

    private final AtenaSealCreateDiv div;
    private static final RString SHIKAKUSHUTOKU = new RString("shikakuShutoku");
    private static final RString NENREITOTATSU = new RString("nenreiTotatsu");
    private static final RString JUTOKUNOMI = new RString("jutokuNomi");
    private static final RString JUKUNINTEISHINSEITYUIGAI = new RString("jukyuNinteiShinseityuIgai");
    private static final RString FLG = new RString("1");
    private static final RString 抽出対象者_1 = new RString("1");
    private static final RString 抽出対象者_2 = new RString("2");
    private static final RString 抽出対象者_3 = new RString("3");
    private static final RString 抽出対象者_4 = new RString("4");
    private static final RString 抽出対象者_5 = new RString("5");
    private static final RString 抽出対象者_6 = new RString("6");
    private static final int SAN = 3;
    private static final RString 資格区分_1号日本人 = new RString("1");
    private static final RString 資格区分_2号日本人 = new RString("2");
    private static final RString 資格区分_1号外国人 = new RString("3");
    private static final RString 資格区分_2号外国人 = new RString("4");
    private static final RString 資格区分_1号全て = new RString("5");
    private static final RString 資格区分_2号全て = new RString("6");
    private static final RString 資格区分_全て = new RString("7");
    private static final RString 面数_12 = new RString("12");
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 全市町村_KEY = new RString("000000");
    private static final RString 全市町村_VALUE = new RString("全市町村");
    private static final FlexibleDate 開始日 = new FlexibleDate("00000000");
    private static final FlexibleDate 終了日 = new FlexibleDate("99999999");
    private static final RString 資格区分_KEY_NIHONJIN1GO = new RString("nihonjin1go");
    private static final RString 資格区分_KEY_NIHONJIN2GO = new RString("nihonjin2go");
    private static final RString 資格区分_KEY_GAIKOKUJIN1GO = new RString("gaikokujin1go");
    private static final RString 資格区分_KEY_GAIKOKUJIN2GO = new RString("gaikokujin2go");
    private static final RString 資格区分_KEY_ALL1GO = new RString("all1go");
    private static final RString 資格区分_KEY_ALL2GO = new RString("all2go");
    private static final RString 帳票分類ID = new RString("DBZ100001_AtenaSeal");

    /**
     * コンストラクタです。
     *
     * @param div AtenaSealCreateDiv
     */
    public AtenaSealCreateHandler(AtenaSealCreateDiv div) {
        this.div = div;
    }

    /**
     * 宛名シール作成の初期化です。
     *
     * @param koseiShichosonList List<KoseiShichoson>
     */
    public void onLoad(List<KoseiShichoson> koseiShichosonList) {
        set市町村指定ドロップダウンリスト(koseiShichosonList);
        div.getHensyuHoho().getCcdJushoSettei().initialize(SubGyomuCode.DBZ介護共通.value(), 帳票分類ID);
        div.getCcdAtenaSealPosition().load(面数_12);
        div.getCcdShutsuryokuJun().load(SubGyomuCode.DBZ介護共通, new ReportId("DBZ100001_AtenaSeal"));
        div.setHidden_jutokuNomi(FLG);
        div.setHidden_jukyuNinteiShinseityuIgai(FLG);
    }

    private void set市町村指定ドロップダウンリスト(List<KoseiShichoson> koseiShichosonList) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 形態コード = shichosonSecurityJoho.get導入形態コード().value();
        RString 市町村識別ID = shichosonSecurityJoho.get市町村情報().get市町村識別ID();
        div.getCyushutsuJoken().getDdlZensisyouson().getDataSource().clear();
        if (DonyuKeitaiCode.事務広域.getCode().equals(形態コード)
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(形態コード)) {
            if (市町村識別ID_00.equals(市町村識別ID)) {
                List<KeyValueDataSource> list市町村指定 = new ArrayList<>();
                KeyValueDataSource dataSource = new KeyValueDataSource();
                KeyValueDataSource dataSources = new KeyValueDataSource();
                dataSource.setKey(全市町村_KEY);
                dataSource.setValue(全市町村_VALUE);
                list市町村指定.add(dataSource);
                dataSources.setKey(shichosonSecurityJoho.get市町村情報().get市町村コード().value());
                dataSources.setValue(shichosonSecurityJoho.get市町村情報().get市町村名称());
                list市町村指定.add(dataSources);
                div.getCyushutsuJoken().getDdlZensisyouson().setDataSource(list市町村指定);
                div.getCyushutsuJoken().getDdlZensisyouson().setDisabled(false);
            } else if (!市町村識別ID_00.equals(市町村識別ID)) {
                List<KeyValueDataSource> list市町村指定 = new ArrayList<>();
                for (KoseiShichoson shichosonList : koseiShichosonList) {
                    KeyValueDataSource dataSource = new KeyValueDataSource();
                    dataSource.setKey(shichosonList.get市町村コード().value());
                    dataSource.setValue(shichosonList.get市町村名称());
                    list市町村指定.add(dataSource);
                }
                div.getCyushutsuJoken().getDdlZensisyouson().setDataSource(list市町村指定);
                div.getCyushutsuJoken().getDdlZensisyouson().setDisabled(true);
            }
        } else if (DonyuKeitaiCode.事務単一.getCode().equals(形態コード)) {
            div.getCyushutsuJoken().getDdlZensisyouson().setVisible(false);
            List<KeyValueDataSource> list市町村指定 = new ArrayList<>();
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(RString.EMPTY);
            dataSource.setValue(RString.EMPTY);
            list市町村指定.add(dataSource);
            div.getCyushutsuJoken().getDdlZensisyouson().setDataSource(list市町村指定);
        }
    }

    /**
     * 抽出対象者チェックボックスです。
     *
     */
    public void onChange() {
        set抽出対象者();
        List<RString> listKey = div.getCyushutsuJoken().getChkTaishosha().getSelectedKeys();
        if (listKey.isEmpty()) {
            return;
        }
        if (listKey.size() == 1 && listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            List<RString> key = new ArrayList<>();
            key.add(JUKUNINTEISHINSEITYUIGAI);
            key.add(SHIKAKUSHUTOKU);
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
        }
        if (listKey.size() != 1) {
            if (JUTOKUNOMI.equals(div.getHidden_jutokuNomi())) {
                listKey.remove(JUTOKUNOMI);
                div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(listKey);
                div.setHidden_jutokuNomi(FLG);
            } else {
                if (listKey.contains(JUTOKUNOMI)) {
                    List<RString> key = new ArrayList<>();
                    key.add(JUTOKUNOMI);
                    listKey.clear();
                    listKey.add(JUTOKUNOMI);
                    div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
                    div.setHidden_jutokuNomi(JUTOKUNOMI);
                }
            }
        }
        if (listKey.size() == 2) {
            if (listKey.contains(NENREITOTATSU) && JUKUNINTEISHINSEITYUIGAI.equals(div.getHidden_jukyuNinteiShinseityuIgai())) {
                listKey.remove(JUKUNINTEISHINSEITYUIGAI);
                div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(listKey);
                div.setHidden_jukyuNinteiShinseityuIgai(FLG);
            } else if (listKey.contains(NENREITOTATSU) && listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
                listKey.remove(NENREITOTATSU);
                listKey.add(SHIKAKUSHUTOKU);
                div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(listKey);
                div.setHidden_jukyuNinteiShinseityuIgai(JUKUNINTEISHINSEITYUIGAI);
            }
        }
        get抽出対象者(listKey);
    }

    private void get抽出対象者(List<RString> listKey) {
        if (listKey.size() == 1 && listKey.contains(NENREITOTATSU)) {
            div.getCyushutsuJoken().getLblToutatubi().setVisible(true);
        } else {
            if (listKey.contains(NENREITOTATSU)) {
                div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
                div.getCyushutsuJoken().getLblToutatubi().setVisible(true);
            } else {
                div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
            }
        }
    }

    private void set抽出対象者() {
        div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(false);
        div.getCyushutsuJoken().getLblToutatubi().setVisible(false);
    }

    /**
     * 実行ボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter DBA090010_AtenaSeelParameter
     */
    public DBA090010_AtenaSeelParameter onclick_btnjikou() {
        RString 抽出対象者;
        FlexibleDate 抽出期間開始日;
        FlexibleDate 抽出期間終了日;
        List<RString> listKey = div.getCyushutsuJoken().getChkTaishosha().getSelectedKeys();
        if (listKey.size() == SAN) {
            抽出対象者 = 抽出対象者_6;
        } else if (listKey.size() == 2 && listKey.contains(NENREITOTATSU)) {
            抽出対象者 = 抽出対象者_3;
        } else if (listKey.size() == 2 && listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            抽出対象者 = 抽出対象者_5;
        } else {
            if (listKey.contains(SHIKAKUSHUTOKU)) {
                抽出対象者 = 抽出対象者_1;
            } else if (listKey.contains(NENREITOTATSU)) {
                抽出対象者 = 抽出対象者_2;
            } else {
                抽出対象者 = 抽出対象者_4;
            }
        }
        RString 抽出期間 = RString.EMPTY;
        if (div.getCyushutsuJoken().getLblToutatubi().isVisible()) {
            抽出期間 = div.getCyushutsuJoken().getLblToutatubi().getText();
        } else if (div.getCyushutsuJoken().getLblShikakuTokusoKikan().isVisible()) {
            抽出期間 = div.getCyushutsuJoken().getLblShikakuTokusoKikan().getText();
        }
        抽出期間開始日 = div.getCyushutsuJoken().getTxtShikakuTokusoFrom().getValue();
        if (抽出期間開始日.isEmpty()) {
            抽出期間開始日 = 開始日;
        }
        抽出期間終了日 = div.getCyushutsuJoken().getTxtShikakuTokusoTo().getValue();
        if (抽出期間終了日.isEmpty()) {
            抽出期間終了日 = 終了日;
        }
        RString code = getCode(div.getCyushutsuJoken().getDdlShikakuKubun().getSelectedKey());
        return new DBA090010_AtenaSeelParameter(
                抽出対象者,
                抽出期間,
                dateFormat(new RString(抽出期間開始日.toString())),
                dateFormat(new RString(抽出期間終了日.toString())),
                code,
                div.getCyushutsuJoken().getDdlZensisyouson().getSelectedKey(),
                div.getHensyuHoho().getDdlSaiyusenJusho().getSelectedKey(),
                div.getHensyuHoho().getDdlKeisho().getSelectedValue(),
                div.getHensyuHoho().getRadIsPrintHihokenshaNo().getSelectedKey(),
                div.getHensyuHoho().getCcdJushoSettei().is方書表示(),
                div.getHensyuHoho().getCcdJushoSettei().is市町村名表示(),
                div.getHensyuHoho().getCcdJushoSettei().is都道府県名表示(),
                div.getHensyuHoho().getCcdJushoSettei().is郡名表示(),
                div.getCcdShutsuryokuJun().get出力順ID(),
                SubGyomuCode.DBA介護資格.value());
    }

    private RString getCode(RString selectedKey) {
        RString code;
        if (資格区分_KEY_NIHONJIN1GO.equals(selectedKey)) {
            code = 資格区分_1号日本人;
        } else if (資格区分_KEY_NIHONJIN2GO.equals(selectedKey)) {
            code = 資格区分_2号日本人;
        } else if (資格区分_KEY_GAIKOKUJIN1GO.equals(selectedKey)) {
            code = 資格区分_1号外国人;
        } else if (資格区分_KEY_GAIKOKUJIN2GO.equals(selectedKey)) {
            code = 資格区分_2号外国人;
        } else if (資格区分_KEY_ALL1GO.equals(selectedKey)) {
            code = 資格区分_1号全て;
        } else if (資格区分_KEY_ALL2GO.equals(selectedKey)) {
            code = 資格区分_2号全て;
        } else {
            code = 資格区分_全て;
        }
        return code;
    }

    private RString dateFormat(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new FlexibleDate(obj).wareki().toDateString();
    }
}
