/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA5010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.atenasealcreate.AtenaSealCreateBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA5010011.AtenaSealCreateDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private static final RString 広域 = new RString("1");
    private static final RString 市町村 = new RString("2");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString FOUR = new RString("4");
    private static final RString FIVE = new RString("5");
    private static final RString SIX = new RString("6");
    private static final RString SEVEN = new RString("7");
    private static final RString ONEONEONE = new RString("111");
    private static final RString TWELVE = new RString("12");
    private static final RString ONEONETWO = new RString("112");
    private static final RString ZEROZERO = new RString("00");
    private static final RString SIXZERO = new RString("000000");
    private static final RString SHICHOUSON = new RString("全市町村");
    private static final RString SUBETE = new RString("all");
    private static final FlexibleDate 開始日 = new FlexibleDate("00000000");
    private static final FlexibleDate 終了日 = new FlexibleDate("99999999");
    private static final RString NIHONJIN1GO = new RString("nihonjin1go");
    private static final RString NIHONJIN2GO = new RString("nihonjin2go");
    private static final RString GAIKOKUJIN1GO = new RString("gaikokujin1go");
    private static final RString GAIKOKUJIN2GO = new RString("gaikokujin2go");
    private static final RString ALL1GO = new RString("all1go");
    private static final RString ALL2GO = new RString("all2go");

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
     */
    public void onLoad() {
        RString 機能構成;
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (ONEONEONE.equals(shichosonSecurityJoho.get導入形態コード().value())
                || ONEONETWO.equals(shichosonSecurityJoho.get導入形態コード().value())) {
            機能構成 = 広域;
        } else {
            機能構成 = 市町村;
        }
        if (広域.equals(機能構成)) {
            div.getCyushutsuJoken().getDdlZensisyouson().getDataSource().clear();
            if (ZEROZERO.equals(shichosonSecurityJoho.get市町村情報().get市町村識別ID())) {
                List<KeyValueDataSource> list市町村指定 = new ArrayList<>();
                KeyValueDataSource dataSource = new KeyValueDataSource();
                dataSource.setKey(SIXZERO);
                dataSource.setValue(SHICHOUSON);
                list市町村指定.add(dataSource);
                div.getCyushutsuJoken().getDdlZensisyouson().setDataSource(list市町村指定);
                div.getCyushutsuJoken().getDdlZensisyouson().setDisabled(false);
            } else {
                List<KoseiShichoson> koseiShichosonList = KoikiShichosonJohoFinder.createInstance().getKoseiShichosonList().records();
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
        } else {
            div.getCyushutsuJoken().getDdlZensisyouson().setVisible(false);
        }
        div.getHensyuHoho().getCcdJushoSettei().initialize(SubGyomuCode.DBZ介護共通.value(), new RString("DBZ100001_AtenaSeal"));
        div.getCcdAtenaSealPosition().load(TWELVE);
        div.getCcdShutsuryokuJun().load(SubGyomuCode.DBZ介護共通, new ReportId("DBZ100001_AtenaSeal"));
        put_ViewStateKeys_onLoad();
    }

    /**
     * 抽出対象者チェックボックスです。
     *
     */
    public void onChange() {
        set抽出対象者();
        List<RString> listKey = div.getCyushutsuJoken().getChkTaishosha().getSelectedKeys();
        if (listKey.size() == 1) {
            oneClick(listKey);
        } else if (listKey.size() == 2) {
            twoClick(listKey);
            if (listKey.contains(SHIKAKUSHUTOKU) && listKey.contains(NENREITOTATSU)) {
                div.getCyushutsuJoken().getDdlShikakuKubun().setSelectedKey(SUBETE);
            }
        }
    }

    private void put_ViewStateKeys_onLoad() {
        ViewStateHolder.put(ViewStateKeys.資格取得者, null);
        ViewStateHolder.put(ViewStateKeys.年齢到達予定者, null);
        ViewStateHolder.put(ViewStateKeys.住所地特例者のみ, null);
        ViewStateHolder.put(ViewStateKeys.受給認定申請中を除く, null);
    }

    private void put_ViewStateKeys(List<RString> listKey) {
        for (RString key : listKey) {
            if (SHIKAKUSHUTOKU.equals(key)) {
                ViewStateHolder.put(ViewStateKeys.資格取得者, key);
            }
            if (NENREITOTATSU.equals(key)) {
                ViewStateHolder.put(ViewStateKeys.年齢到達予定者, key);
            }
            if (JUTOKUNOMI.equals(key)) {
                ViewStateHolder.put(ViewStateKeys.住所地特例者のみ, key);
            }
            if (JUKUNINTEISHINSEITYUIGAI.equals(key)) {
                ViewStateHolder.put(ViewStateKeys.受給認定申請中を除く, key);
            }
        }
    }

    private List<RString> get_ViewStateKeys() {
        List<RString> list抽出対象者 = new ArrayList<>();
        RString 資格取得者 = ViewStateHolder.get(ViewStateKeys.資格取得者, RString.class);
        RString 年齢到達予定者 = ViewStateHolder.get(ViewStateKeys.年齢到達予定者, RString.class);
        RString 住所地特例者のみ = ViewStateHolder.get(ViewStateKeys.住所地特例者のみ, RString.class);
        RString 受給認定申請中を除く = ViewStateHolder.get(ViewStateKeys.受給認定申請中を除く, RString.class);
        if (資格取得者 != null) {
            list抽出対象者.add(資格取得者);
        }
        if (年齢到達予定者 != null) {
            list抽出対象者.add(年齢到達予定者);
        }
        if (住所地特例者のみ != null) {
            list抽出対象者.add(住所地特例者のみ);
        }
        if (受給認定申請中を除く != null) {
            list抽出対象者.add(受給認定申請中を除く);
        }
        return list抽出対象者;
    }

    private void set抽出対象者() {
        div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(false);
        div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(false);
        div.getCyushutsuJoken().getLblToutatubi().setVisible(false);
    }

    private void setAll() {
        div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
        div.getCyushutsuJoken().getLblToutatubi().setVisible(true);
    }

    private void set資格取得者() {
        div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
        div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
    }

    private void set年齢到達予定者() {
        div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
        div.getCyushutsuJoken().getLblToutatubi().setVisible(true);
    }

    private void set住所地特例者のみ() {
        div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
        div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
    }

    private void set受給認定申請中を除く() {
        div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
        div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
    }

    private void oneClick(List<RString> listKey) {
        for (RString list : listKey) {
            if (SHIKAKUSHUTOKU.equals(list)) {
                put_ViewStateKeys_onLoad();
                put_ViewStateKeys(listKey);
                set資格取得者();
            } else if (NENREITOTATSU.equals(list)) {
                put_ViewStateKeys_onLoad();
                put_ViewStateKeys(listKey);
                set年齢到達予定者();
            } else if (JUTOKUNOMI.equals(list)) {
                put_ViewStateKeys_onLoad();
                put_ViewStateKeys(listKey);
                set住所地特例者のみ();
            } else if (JUKUNINTEISHINSEITYUIGAI.equals(list)) {
                put_ViewStateKeys_onLoad();
                put_ViewStateKeys(listKey);
                set受給認定申請中を除く();
            }
        }
    }

    private void twoClick(List<RString> listKey) {
        List<RString> key = new ArrayList<>();
        List<RString> list抽出対象者 = get_ViewStateKeys();
        if (list抽出対象者.isEmpty()) {
            return;
        }
        if (list抽出対象者.size() == 2) {
            edit_Chuushutsutaishou(listKey, key);
            return;
        }
        edit抽出対象者(list抽出対象者, key, listKey);
    }

    /**
     * 実行ボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter AtenaSealCreateBatchParameter
     */
    public AtenaSealCreateBatchParameter onclick_btnjikou() {
        RString 抽出対象者;
        FlexibleDate 抽出期間開始日;
        FlexibleDate 抽出期間終了日;
        List<RString> listKey = div.getCyushutsuJoken().getChkTaishosha().getSelectedKeys();
        if (listKey.size() == 2) {
            抽出対象者 = THREE;
        } else {
            if (listKey.contains(NENREITOTATSU)) {
                抽出対象者 = TWO;
            } else {
                抽出対象者 = ONE;
            }
        }
        RString 抽出期間 = new RString("");
        if (div.getCyushutsuJoken().getLblShikakuTokusoKikan().isVisible()) {
            抽出期間 = div.getCyushutsuJoken().getLblShikakuTokusoKikan().getText();
        } else if (div.getCyushutsuJoken().getLblToutatubi().isVisible()) {
            抽出期間 = div.getCyushutsuJoken().getLblToutatubi().getText();
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
        return new AtenaSealCreateBatchParameter(
                抽出対象者,
                抽出期間,
                抽出期間開始日,
                抽出期間終了日,
                code,
                div.getCyushutsuJoken().getDdlZensisyouson().getSelectedKey(),
                div.getHensyuHoho().getDdlSaiyusenJusho().getSelectedKey(),
                div.getHensyuHoho().getDdlKeisho().getSelectedKey(),
                div.getHensyuHoho().getRadIsPrintHihokenshaNo().getSelectedKey(),
                div.getHensyuHoho().getCcdJushoSettei().get町域編集方法(),
                div.getCcdShutsuryokuJun().get出力順ID(),
                SubGyomuCode.DBA介護資格.value());
    }

    private RString getCode(RString selectedKey) {
        RString code;
        if (NIHONJIN1GO.equals(selectedKey)) {
            code = ONE;
        } else if (NIHONJIN2GO.equals(selectedKey)) {
            code = TWO;
        } else if (GAIKOKUJIN1GO.equals(selectedKey)) {
            code = THREE;
        } else if (GAIKOKUJIN2GO.equals(selectedKey)) {
            code = FOUR;
        } else if (ALL1GO.equals(selectedKey)) {
            code = FIVE;
        } else if (ALL2GO.equals(selectedKey)) {
            code = SIX;
        } else {
            code = SEVEN;
        }
        return code;
    }

    private void edit_Chuushutsutaishou(List<RString> listKey, List<RString> key) {
        if (listKey.contains(JUTOKUNOMI)) {
            key.add(JUTOKUNOMI);
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            put_ViewStateKeys_onLoad();
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
            div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
        } else if (listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            key.add(JUKUNINTEISHINSEITYUIGAI);
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            put_ViewStateKeys_onLoad();
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
            div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
        } else {
            key.add(SHIKAKUSHUTOKU);
            key.add(NENREITOTATSU);
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            put_ViewStateKeys_onLoad();
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
            div.getCyushutsuJoken().getLblToutatubi().setVisible(true);
        }
    }

    private void edit抽出対象者(List<RString> list抽出対象者, List<RString> key, List<RString> listKey) {
        for (RString list : list抽出対象者) {
            if (SHIKAKUSHUTOKU.equals(list)) {
                edit抽出対象者_ShikakuShutoku(listKey, key);
            } else if (NENREITOTATSU.equals(list)) {
                edit抽出対象者_NenreiTotatsu(listKey, key);
            } else if (JUTOKUNOMI.equals(list)) {
                edit抽出対象者_JutokuNomi(listKey, key);
            } else if (JUKUNINTEISHINSEITYUIGAI.equals(list)) {
                edit抽出対象者_JukyuNinteiShinseityuIgai(listKey, key);
            }
        }
    }

    private void edit抽出対象者_ShikakuShutoku(List<RString> listKey, List<RString> key) {
        if (listKey.contains(NENREITOTATSU)) {
            put_ViewStateKeys_onLoad();
            put_ViewStateKeys(listKey);
            setAll();
        } else if (listKey.contains(JUTOKUNOMI)) {
            put_ViewStateKeys_onLoad();
            key.add(JUTOKUNOMI);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set住所地特例者のみ();
        } else if (listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            put_ViewStateKeys_onLoad();
            key.add(JUKUNINTEISHINSEITYUIGAI);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set受給認定申請中を除く();
        }
    }

    private void edit抽出対象者_NenreiTotatsu(List<RString> listKey, List<RString> key) {
        if (listKey.contains(SHIKAKUSHUTOKU)) {
            put_ViewStateKeys_onLoad();
            put_ViewStateKeys(listKey);
            setAll();
        } else if (listKey.contains(JUTOKUNOMI)) {
            put_ViewStateKeys_onLoad();
            key.add(JUTOKUNOMI);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set住所地特例者のみ();
        } else if (listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            put_ViewStateKeys_onLoad();
            key.add(JUKUNINTEISHINSEITYUIGAI);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set受給認定申請中を除く();
        }
    }

    private void edit抽出対象者_JutokuNomi(List<RString> listKey, List<RString> key) {
        if (listKey.contains(SHIKAKUSHUTOKU)) {
            put_ViewStateKeys_onLoad();
            key.add(SHIKAKUSHUTOKU);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set資格取得者();
        } else if (listKey.contains(NENREITOTATSU)) {
            put_ViewStateKeys_onLoad();
            key.add(NENREITOTATSU);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set年齢到達予定者();
        } else if (listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            put_ViewStateKeys_onLoad();
            key.add(JUKUNINTEISHINSEITYUIGAI);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set受給認定申請中を除く();
        }
    }

    private void edit抽出対象者_JukyuNinteiShinseityuIgai(List<RString> listKey, List<RString> key) {
        if (listKey.contains(SHIKAKUSHUTOKU)) {
            put_ViewStateKeys_onLoad();
            key.add(SHIKAKUSHUTOKU);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set資格取得者();
        } else if (listKey.contains(NENREITOTATSU)) {
            put_ViewStateKeys_onLoad();
            key.add(NENREITOTATSU);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set年齢到達予定者();
        } else if (listKey.contains(JUTOKUNOMI)) {
            put_ViewStateKeys_onLoad();
            key.add(JUTOKUNOMI);
            put_ViewStateKeys(key);
            div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            set住所地特例者のみ();
        }
    }
}
