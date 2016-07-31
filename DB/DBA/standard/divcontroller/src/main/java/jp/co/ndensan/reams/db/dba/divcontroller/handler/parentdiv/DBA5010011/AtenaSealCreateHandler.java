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
    private static final RString 抽出対象者_1 = new RString("1");
    private static final RString 抽出対象者_2 = new RString("2");
    private static final RString 抽出対象者_3 = new RString("3");
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
    private static final RString SUBETE = new RString("all");
    private static final FlexibleDate 開始日 = new FlexibleDate("00000000");
    private static final FlexibleDate 終了日 = new FlexibleDate("99999999");
    private static final RString 資格区分_KEY_NIHONJIN1GO = new RString("nihonjin1go");
    private static final RString 資格区分_KEY_NIHONJIN2GO = new RString("nihonjin2go");
    private static final RString 資格区分_KEY_GAIKOKUJIN1GO = new RString("gaikokujin1go");
    private static final RString 資格区分_KEY_GAIKOKUJIN2GO = new RString("gaikokujin2go");
    private static final RString 資格区分_KEY_ALL1GO = new RString("all1go");
    private static final RString 資格区分_KEY_ALL2GO = new RString("all2go");

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
        div.getHensyuHoho().getCcdJushoSettei().initialize(SubGyomuCode.DBZ介護共通.value(), new RString("DBZ100001_AtenaSeal"));
        div.getCcdAtenaSealPosition().load(面数_12);
        div.getCcdShutsuryokuJun().load(SubGyomuCode.DBZ介護共通, new ReportId("DBZ100001_AtenaSeal"));
    }

    private void set市町村指定ドロップダウンリスト(List<KoseiShichoson> koseiShichosonList) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 形態コード = shichosonSecurityJoho.get導入形態コード().value();
        RString 市町村識別ID = shichosonSecurityJoho.get市町村情報().get市町村識別ID();
        if (DonyuKeitaiCode.事務広域.getCode().equals(形態コード)
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(形態コード)) {
            div.getCyushutsuJoken().getDdlZensisyouson().getDataSource().clear();
            if (市町村識別ID_00.equals(市町村識別ID)) {
                List<KeyValueDataSource> list市町村指定 = new ArrayList<>();
                KeyValueDataSource dataSource = new KeyValueDataSource();
                dataSource.setKey(全市町村_KEY);
                dataSource.setValue(全市町村_VALUE);
                list市町村指定.add(dataSource);
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
        if (listKey.size() == 1) {
            oneClick(listKey);
        }
        if (listKey.size() == 2) {
            twoClick(listKey);
        }
        if (listKey.contains(SHIKAKUSHUTOKU) && listKey.contains(NENREITOTATSU)) {
            div.getCyushutsuJoken().getDdlShikakuKubun().setSelectedKey(SUBETE);
        }

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
            clearhidden();
            if (SHIKAKUSHUTOKU.equals(list)) {
                div.setHidden_shikakuShutoku(SHIKAKUSHUTOKU);
                set資格取得者();
            } else if (NENREITOTATSU.equals(list)) {
                div.setHidden_nenreiTotatsu(NENREITOTATSU);
                set年齢到達予定者();
            } else if (JUTOKUNOMI.equals(list)) {
                div.setHidden_jutokuNomi(JUTOKUNOMI);
                set住所地特例者のみ();
            } else if (JUKUNINTEISHINSEITYUIGAI.equals(list)) {
                div.setHidden_jukyuNinteiShinseityuIgai(JUKUNINTEISHINSEITYUIGAI);
                set受給認定申請中を除く();
            }
        }
    }

    private void twoClick(List<RString> listKey) {
        List<RString> key = new ArrayList<>();
        List<RString> list抽出対象者 = getHidden();
        if (list抽出対象者.isEmpty()) {
            return;
        }
        if (list抽出対象者.size() == 2) {
            edit_Chuushutsutaishou(listKey, key);
            return;
        }
        edit抽出対象者(list抽出対象者, key, listKey);
    }

    private void clearhidden() {
        div.setHidden_shikakuShutoku(RString.EMPTY);
        div.setHidden_nenreiTotatsu(RString.EMPTY);
        div.setHidden_jutokuNomi(RString.EMPTY);
        div.setHidden_jukyuNinteiShinseityuIgai(RString.EMPTY);
    }

    private List<RString> getHidden() {
        List<RString> list抽出対象者 = new ArrayList<>();
        if (!div.getHidden_shikakuShutoku().isNullOrEmpty()) {
            list抽出対象者.add(div.getHidden_shikakuShutoku());
        }
        if (!div.getHidden_nenreiTotatsu().isNullOrEmpty()) {
            list抽出対象者.add(div.getHidden_nenreiTotatsu());
        }
        if (!div.getHidden_jutokuNomi().isNullOrEmpty()) {
            list抽出対象者.add(div.getHidden_jutokuNomi());
        }
        if (!div.getHidden_jukyuNinteiShinseityuIgai().isNullOrEmpty()) {
            list抽出対象者.add(div.getHidden_jukyuNinteiShinseityuIgai());
        }
        return list抽出対象者;
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
            抽出対象者 = 抽出対象者_3;
        } else {
            if (listKey.contains(NENREITOTATSU)) {
                抽出対象者 = 抽出対象者_2;
            } else {
                抽出対象者 = 抽出対象者_1;
            }
        }
        RString 抽出期間 = RString.EMPTY;
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

    private void sethidden(List<RString> key) {
        for (RString ketset : key) {
            if (SHIKAKUSHUTOKU.equals(ketset)) {
                div.setHidden_shikakuShutoku(ketset);
            }
            if (NENREITOTATSU.equals(ketset)) {
                div.setHidden_nenreiTotatsu(ketset);
            }
            if (JUTOKUNOMI.equals(ketset)) {
                div.setHidden_jutokuNomi(ketset);
            }
            if (JUKUNINTEISHINSEITYUIGAI.equals(ketset)) {
                div.setHidden_jukyuNinteiShinseityuIgai(ketset);
            }

        }
    }

    private void edit_Chuushutsutaishou(List<RString> listKey, List<RString> key) {
        clearhidden();
        if (listKey.contains(JUTOKUNOMI)) {
            key.add(JUTOKUNOMI);
            sethidden(key);
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
            div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
        } else if (listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            key.add(JUKUNINTEISHINSEITYUIGAI);
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            sethidden(key);
            div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
            div.getCyushutsuJoken().getLblShikakuTokusoKikan().setVisible(true);
        } else {
            key.add(SHIKAKUSHUTOKU);
            key.add(NENREITOTATSU);
            div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
            sethidden(key);
            div.getCyushutsuJoken().getLblCyushutuKikan().setVisible(true);
            div.getCyushutsuJoken().getLblToutatubi().setVisible(true);
        }
    }

    private void edit抽出対象者(List<RString> list抽出対象者, List<RString> key, List<RString> listKey) {
        for (RString list : list抽出対象者) {
            clearhidden();
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
            key.add(SHIKAKUSHUTOKU);
            key.add(NENREITOTATSU);
            sethidden(key);
            setselectkey(key);
            setAll();
        } else if (listKey.contains(JUTOKUNOMI)) {
            key.add(JUTOKUNOMI);
            sethidden(key);
            setselectkey(key);
            set住所地特例者のみ();
        } else if (listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            key.add(JUKUNINTEISHINSEITYUIGAI);
            sethidden(key);
            setselectkey(key);
            set受給認定申請中を除く();
        }
    }

    private void edit抽出対象者_NenreiTotatsu(List<RString> listKey, List<RString> key) {
        if (listKey.contains(SHIKAKUSHUTOKU)) {
            key.add(SHIKAKUSHUTOKU);
            key.add(NENREITOTATSU);
            setselectkey(key);
            sethidden(key);
            setAll();
        } else if (listKey.contains(JUTOKUNOMI)) {
            key.add(JUTOKUNOMI);
            sethidden(key);
            setselectkey(key);
            set住所地特例者のみ();
        } else if (listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            key.add(JUKUNINTEISHINSEITYUIGAI);
            sethidden(key);
            setselectkey(key);
            set受給認定申請中を除く();
        }
    }

    private void edit抽出対象者_JutokuNomi(List<RString> listKey, List<RString> key) {
        if (listKey.contains(SHIKAKUSHUTOKU)) {
            key.add(SHIKAKUSHUTOKU);
            sethidden(key);
            setselectkey(key);
            set資格取得者();
        } else if (listKey.contains(NENREITOTATSU)) {
            key.add(NENREITOTATSU);
            sethidden(key);
            setselectkey(key);
            set年齢到達予定者();
        } else if (listKey.contains(JUKUNINTEISHINSEITYUIGAI)) {
            key.add(JUKUNINTEISHINSEITYUIGAI);
            sethidden(key);
            setselectkey(key);
            set受給認定申請中を除く();
        }
    }

    private void edit抽出対象者_JukyuNinteiShinseityuIgai(List<RString> listKey, List<RString> key) {
        if (listKey.contains(SHIKAKUSHUTOKU)) {
            key.add(SHIKAKUSHUTOKU);
            sethidden(key);
            setselectkey(key);
            set資格取得者();
        } else if (listKey.contains(NENREITOTATSU)) {
            key.add(NENREITOTATSU);
            sethidden(key);
            setselectkey(key);
            set年齢到達予定者();
        } else if (listKey.contains(JUTOKUNOMI)) {
            key.add(JUTOKUNOMI);
            sethidden(key);
            setselectkey(key);
            set住所地特例者のみ();
        }
    }

    private void setselectkey(List<RString> key) {
        div.getCyushutsuJoken().getChkTaishosha().getSelectedItems().clear();
        div.getCyushutsuJoken().getChkTaishosha().setSelectedItemsByKey(key);
    }

}
