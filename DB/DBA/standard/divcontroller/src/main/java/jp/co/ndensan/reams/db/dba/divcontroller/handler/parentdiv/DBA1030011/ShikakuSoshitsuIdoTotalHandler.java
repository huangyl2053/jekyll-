/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011.ShikakuSoshitsuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格喪失異動のHandlerクラスです。
 */
public class ShikakuSoshitsuIdoTotalHandler {

    private static final RString 認定履歴ボタン = new RString("HihokenrirekiNashiMode");
    private static final RString 被保履歴ボタン = new RString("NinteirirekiNashiMode");
    private static final RString 状態_登録 = new RString("登録");
    private static final RString 状態_更新 = new RString("更新");

    private static final RString DBAMN22001_転出により喪失 = new RString("DBAMN22001_転出により喪失");
    private static final RString DBAMN22002_死亡により喪失 = new RString("DBAMN22002_死亡により喪失");
    private static final RString DBAMN22003_転居により喪失_施設入所等 = new RString("DBAMN22003_転居により喪失（施設入所等）");
    private static final RString DBAMN22004_国籍喪失により喪失 = new RString("DBAMN22004_国籍喪失により喪失");
    private static final RString DBAMN22005_医療保険未加入により喪失 = new RString("DBAMN22005_医療保険未加入により喪失");
    private static final RString DBAMN22006_職権により喪失 = new RString("DBAMN22006_職権により喪失");
    private static final RString DBAMN22007_その他事由により喪失 = new RString("DBAMN22007_その他事由により喪失");

    private static final RString 任意手入力付番 = new RString("3");
    private static final RString 追加 = new RString("追加");

    private static final RString FIRSTREQUEST以外 = new RString("2");
    private RString 状態_被保履歴タブ = RString.EMPTY;
    private RString 状態_医療保険タブ = RString.EMPTY;
    private RString 状態_老福年金タブ = RString.EMPTY;
    private RString 状態_施設入退所タブ = RString.EMPTY;
    private RString 状態_証類状況タブ = RString.EMPTY;

    /**
     * テストデータ
     */
    private static HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("0000000001"));
    private static RString 表示モード = new RString("HihokenrirekiNashiMode");
    private static ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("000001"));

    private final ShikakuSoshitsuIdoTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 資格喪失異動Div
     */
    public ShikakuSoshitsuIdoTotalHandler(ShikakuSoshitsuIdoTotalDiv div) {
        this.div = div;
    }

    /**
     * 資格喪失異動の初期化します。
     *
     */
    public void load() {
        kaigoShikakuKihon_onload(被保険者番号, 表示モード);
        kaigoNinteiAtenaInfo_onload(new ShikibetsuCode(RString.EMPTY));
        // TODO:　
        ViewStateHolder.put(ViewStateKeys.医療保険情報_識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.医療保険情報_市町村コード, LasdecCode.EMPTY);
        ViewStateHolder.put(ViewStateKeys.医療保険情報_モード, 状態_登録);
        ViewStateHolder.put(ViewStateKeys.モード, DBAMN22001_転出により喪失);
        onOpenTplDefault();
    }

    private void kaigoShikakuKihon_onload(HihokenshaNo 被保険者番号, RString 表示モード) {
        if (!RString.isNullOrEmpty(表示モード)) {
            if (認定履歴ボタン.equals(表示モード)) {
                div.getKihonJoho().getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(false);
                div.getKihonJoho().getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(true);
            } else if (被保履歴ボタン.equals(表示モード)) {
                div.getKihonJoho().getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(true);
                div.getKihonJoho().getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(false);
            }
        }

        // 楊さん指示より、以下実行です。
        if (!RString.isNullOrEmpty(被保険者番号.getColumnValue())) {
            div.getKihonJoho().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        }
    }

    private void kaigoNinteiAtenaInfo_onload(ShikibetsuCode 識別コード) {
        div.getKihonJoho().getCcdKaigoAtenaInfo().onLoad(識別コード);

    }

    /**
     * 被保履歴タブを打開です。
     *
     */
    public void onOpenTplDefault() {
        if (!状態_被保履歴タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().initialize(被保険者番号, 識別コード);
            状態_被保履歴タブ = FIRSTREQUEST以外;
        }
        setDdlShikakuSoshitsuJiyu();
    }

    /**
     * 医療保険タブを打開です。
     *
     */
    public void onOpenTplIryou() {
        if (!状態_医療保険タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki().initialize(状態_登録, 識別コード.getColumnValue());
            状態_医療保険タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 老福年金タブを打開です。
     *
     */
    public void onOpenTplRoNen() {
        if (!状態_老福年金タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().initialize(識別コード, 被保険者番号);
            状態_老福年金タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 施設入退所タブを打開です。
     *
     */
    public void onOpenTplShisetsu() {
        if (!状態_施設入退所タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード);
            状態_施設入退所タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 証類状況タブを打開です。
     *
     */
    public void onOpenTplShoruiJokyo() {
        if (!状態_証類状況タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getTabInputs().getShoruiJokyo().getCcdShoKaishuKirokuKanri().initialize(状態_更新, 被保険者番号);
            状態_証類状況タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 保存処理します。
     *
     */
    public void save() {
        // 資格得喪履歴  楊さんの状態は確認を待ち
        save資格得喪履歴();
        // 医療保険タブ
        div.getShikakuSoshitsuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki().save();
        // 老福年金タブ
        div.getShikakuSoshitsuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().click_Save();
        // 施設入退所タブ
        div.getShikakuSoshitsuJoho().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
        // 証類状況タブ
        div.getShikakuSoshitsuJoho().getTabInputs().getShoruiJokyo().getCcdShoKaishuKirokuKanri().saveShoKaishuKirokuKanri();
    }

    /**
     * 被保履歴タブの資格喪失情報パネルの喪失事由DDLの設定
     *
     */
    public void setDdlShikakuSoshitsuJiyu() {
        RString menuID = ResponseHolder.getMenuID();
        //------------------------
        menuID = DBAMN22001_転出により喪失;
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setDisabled(true);
        List<KeyValueDataSource> keyValueList = new ArrayList();
        if (DBAMN22001_転出により喪失.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.転出.getコード(), ShikakuSoshitsuJiyu.転出.get名称()));
        } else if (DBAMN22002_死亡により喪失.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.死亡.getコード(), ShikakuSoshitsuJiyu.死亡.get名称()));
        } else if (DBAMN22003_転居により喪失_施設入所等.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.除外者.getコード(), ShikakuSoshitsuJiyu.除外者.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.他特例者.getコード(), ShikakuSoshitsuJiyu.他特例者.get名称()));
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setDisabled(false);
        } else if (DBAMN22004_国籍喪失により喪失.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.国籍喪失.getコード(), ShikakuSoshitsuJiyu.国籍喪失.get名称()));
        } else if (DBAMN22005_医療保険未加入により喪失.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.その他.getコード(), ShikakuSoshitsuJiyu.その他.get名称()));
        } else if (DBAMN22006_職権により喪失.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.職権喪失.getコード(), ShikakuSoshitsuJiyu.職権喪失.get名称()));
        } else if (DBAMN22007_その他事由により喪失.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.転出.getコード(), ShikakuSoshitsuJiyu.転出.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.死亡.getコード(), ShikakuSoshitsuJiyu.死亡.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.除外者.getコード(), ShikakuSoshitsuJiyu.除外者.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.他特例者.getコード(), ShikakuSoshitsuJiyu.他特例者.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.国籍喪失.getコード(), ShikakuSoshitsuJiyu.国籍喪失.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.その他.getコード(), ShikakuSoshitsuJiyu.その他.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuSoshitsuJiyu.職権喪失.getコード(), ShikakuSoshitsuJiyu.職権喪失.get名称()));
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setDataSource(keyValueList);
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                    .getDdlShikakuShutokuJiyu().setSelectedKey(ShikakuSoshitsuJiyu.その他.getコード());
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setDisabled(false);
            return;
        }
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setDataSource(keyValueList);
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setSelectedIndex(0);
    }

    public void 資格喪失情報パネルの初期化() {
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuDate().clearValue();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuTodokedeDate().clearValue();
        setDdlShikakuSoshitsuJiyu();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().setDisabled(true);
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(false);
    }

    private void save資格得喪履歴() {
        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        // TODO 資格取得登録チェック処理
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().getDataGridDataSource();
        for (dgShikakuShutokuRireki_Row row : rowList) {
            if (追加.equals(row.getState())) {
                HihokenshaDaicho business = new HihokenshaDaicho(new HihokenshaNo(row.getHihokenshaNo()), row.getShutokuDate().getValue(), row.getDaNo());
                HihokenshaDaichoBuilder build = business.createBuilderForEdit();
                build.set資格変更届出年月日(row.getShutokuTodokedeDate().getValue());
                build.set資格取得事由コード(row.getSoshitsuJiyuKey());
                manager.saveHihokenshaShutoku(build.build(),
                        DateOfBirthFactory.createInstance(div.getKihonJoho().getCcdKaigoAtenaInfo().getShokaiData().getTxtSeinengappiYMD().getValue()));
            }
        }
    }

}
