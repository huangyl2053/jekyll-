/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210031.ShotokuDankaibetsuHihokenshaSuIchiranDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBBGM21004_段階別被保険者数一覧表作成
 *
 * @reamsid_L DBB-1820-010 chenyadong
 */
public class ShotokuDankaibetsuHihokenshaSuIchiranHandler {

    private final ShotokuDankaibetsuHihokenshaSuIchiranDiv div;
    private static final RString 開始年度 = new RString("2000");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 導入形態コード_111 = new RString("111");
    private static final RString 導入形態コード_112 = new RString("112");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString MDAY_0331 = new RString("0331");
    private static final RString MDAY_0401 = new RString("0401");
    private static final RString MDAY_1231 = new RString("1231");
    //private static final RString KOUSEI_MODO_KOUSEI = new RString("1");
    /**
     * コンストラクタです。
     *
     * @param div ShinNendoKanriJohoSakuseiDiv
     */
    public ShotokuDankaibetsuHihokenshaSuIchiranHandler(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        int difference = Integer.parseInt(調定年度.toString()) - Integer.parseInt(開始年度.toString());
        List<KeyValueDataSource> datasource = insertIntoDatasource(調定年度, difference);
        div.getDdlChoteiNendo().setDataSource(datasource);
        div.getDdlChoteiNendo().setSelectedKey(調定年度);
        //TODO QA1196
        本算定賦課処理日の設定();
        ShichosonSecurityJoho 市町村情報;
        市町村情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村情報.get導入形態コード().getKey().compareTo(導入形態コード_111) == 0) {
            div.getShichoshonSelect().setVisible(true);
            div.getShichoshonSelect().setDisplayNone(false);
            div.getRadShichoson().setSelectedKey(KEY0);
            div.getBtnShichosonSelect().setVisible(false);
        } else {
            if (市町村情報.get導入形態コード().getKey().compareTo(導入形態コード_112) == 0
                    || 市町村情報.get導入形態コード().getKey().compareTo(導入形態コード_120) == 0) {
                div.getShichoshonSelect().setVisible(false);
            }
        }
        RDate システム日付 = RDate.getNowDate();
        List<RString> key = new ArrayList();
        div.getChkChosaJoken().setSelectedItemsByKey(key);
        div.getTxtShikakuKijunYMD().setValue(システム日付);
        div.getTxtChoteiKijunYMD().setValue(システム日付);
    }

    /**
     * insertintoDatasourceは循環がdatasourceです。
     *
     * @param difference int
     * @param 調定年度 RString
     * @return datasource List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> insertIntoDatasource(RString 調定年度, int difference) {
        List<KeyValueDataSource> datasourceList = new ArrayList();
        int 年度;
        for (int i = 0; i <= difference; i++) {
            KeyValueDataSource data = new KeyValueDataSource();
            年度 = Integer.parseInt(調定年度.toString()) - i;
            data.setKey(new RString(String.valueOf(年度)));
            data.setValue(new FlexibleYear(String.valueOf(年度)).wareki().toDateString());
            datasourceList.add(data);
        }
        return datasourceList;
    }

    private void 本算定賦課処理日の設定() {
        ShoriDateKanri 処理日付管理マスタ;
        div.getDdlChoteiNendo().getSelectedKey();
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        処理日付管理マスタ = manager.get処理日付管理(SubGyomuCode.DBB介護賦課, ShoriName.本算定賦課.get名称(),
                new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey()), 年度内連番);
        if (処理日付管理マスタ != null) {
            YMDHMS 基準日時 = 処理日付管理マスタ.get基準日時();
            if (基準日時 == null || 基準日時.isEmpty()) {
                div.getTxtHonsanteiShoriYMD().clearValue();
                div.getTxtHonsanteiShoriYMD().setValue(null);
            } else {
                div.getTxtHonsanteiShoriYMD().setValue(基準日時.getDate());
            }
        } else {
            div.getTxtHonsanteiShoriYMD().clearValue();
        }
    }

    /**
     * ddlChoteiNendoのonChange事件です。
     */
    public void onChangeNendo() {
        本算定賦課処理日の設定();
        List<RString> key = new ArrayList();
        div.getChkChosaJoken().setSelectedItemsByKey(key);
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        if (div.getDdlChoteiNendo().getSelectedKey().compareTo(調定年度) == 0) {
            div.getTxtShikakuKijunYMD().setValue(RDate.getNowDate());
        } else {
            div.getTxtShikakuKijunYMD().setValue(new RDate(div.getDdlChoteiNendo().getSelectedKey().concat(MDAY_0331).
                    toString()));
        }
        div.getTxtChoteiKijunYMD().setValue(RDate.getNowDate());
    }

    /**
     * radShichosonのonChange事件です。
     */
    public void onChangeShichoson() {
        if (div.getRadShichoson().getSelectedKey().equals(KEY1)) {
            div.getBtnShichosonSelect().setVisible(true);
        } else {
            div.getBtnShichosonSelect().setVisible(false);
        }
    }

    /**
     * btnShichosonSelectのonOkClose事件です。
     */
    //TODO QA.1203
   /* public void onOkCloseShichosonSelect() {
     //ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
     // div.
     }*/
    /**
     * btnShichosonSelectのonBeforeOpenDialog事件です。
     */
    //TODO　QA.1203
   /* public void onBeforeOpenDialog() {
     // ShichosonSelectorModel model = new ShichosonSelectorModel();
     //   model.setShichosonModel(KOUSEI_MODO_KOUSEI);
     //  div.setKyuShichoson(DataPassingConverter.serialize(model));
     }*/
    /**
     * chkChosaJokenのonChange事件です。
     */
    public void onChangeChosaJoken() {
        if (div.getChkChosaJoken().getSelectedKeys() != null && !div.getChkChosaJoken().getSelectedKeys().isEmpty()) {
            div.getTxtShikakuKijunYMD().setReadOnly(true);
            div.getTxtShikakuKijunYMD().setValue(new RDate(div.getDdlChoteiNendo().getSelectedKey().concat(MDAY_0401).
                    toString()));
            div.getTxtChoteiKijunYMD().setReadOnly(true);
            div.getTxtChoteiKijunYMD().setValue(new RDate(div.getDdlChoteiNendo().getSelectedKey().concat(MDAY_1231).
                    toString()));

        } else {
            RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                    SubGyomuCode.DBB介護賦課);
            if (div.getDdlChoteiNendo().getSelectedKey().compareTo(調定年度) == 0) {
                div.getTxtShikakuKijunYMD().setValue(RDate.getNowDate());
            } else {
                div.getTxtShikakuKijunYMD().setValue(new RDate(div.getDdlChoteiNendo().getSelectedKey().concat(MDAY_0331).
                        toString()));
            }
            div.getTxtChoteiKijunYMD().setValue(RDate.getNowDate());
        }
    }

}
