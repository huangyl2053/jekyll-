/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.ShikakuShutokuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 資格取得異動のHandlerクラスです。
 */
public class ShiKaKuSyuToKuIdouTotalHandler {

    private static final RString 認定履歴ボタン = new RString("HihokenrirekiNashiMode");
    private static final RString 被保履歴ボタン = new RString("NinteirirekiNashiMode");
    private static final RString 状態_登録 = new RString("登録");

    private static final RString DBAMN21001_転入により取得 = new RString("DBAMN21001_転入により取得");
    private static final RString DBAMN21002_第2号被保険者取得申請により取得 = new RString("DBAMN21002_第2号被保険者取得申請により取得");
    private static final RString DBAMN21003_外国人申請により取得 = new RString("DBAMN21003_外国人申請により取得");
    private static final RString DBAMN21004_年齢到達により取得 = new RString("DBAMN21004_年齢到達により取得");
    private static final RString DBAMN21005_転居により取得_施設退所等 = new RString("DBAMN21005_転居により取得（施設退所等）");
    private static final RString DBAMN21006_帰化により取得 = new RString("DBAMN21006_帰化により取得");
    private static final RString DBAMN21007_職権により取得 = new RString("DBAMN21007_職権により取得");
    private static final RString DBAMN21008_その他事由により取得 = new RString("DBAMN21008_その他事由により取得");
    private static final RString 任意手入力付番 = new RString("3");
    private static final RString 追加 = new RString("追加");

    private static final RString FIRSTREQUEST以外 = new RString("2");
    private RString 状態_被保履歴タブ = RString.EMPTY;
    private RString 状態_医療保険タブ = RString.EMPTY;
    private RString 状態_老福年金タブ = RString.EMPTY;
    private RString 状態_施設入退所タブ = RString.EMPTY;

    /**
     * テストデータ
     */
    private static HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("0000000001"));
    private static RString 表示モード = new RString("HihokenrirekiNashiMode");
    private static ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("000001"));

    private final ShikakuShutokuIdoTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 資格取得異動Div
     */
    public ShiKaKuSyuToKuIdouTotalHandler(ShikakuShutokuIdoTotalDiv div) {
        this.div = div;
    }

    /**
     * 資格取得異動の初期化します。
     *
     */
    public void load() {
        kaigoShikakuKihon_onload(被保険者番号, 表示モード);
        kaigoNinteiAtenaInfo_onload(new ShikibetsuCode(RString.EMPTY));
        // TODO:　
        ViewStateHolder.put(ViewStateKeys.医療保険情報_識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.医療保険情報_市町村コード, LasdecCode.EMPTY);
        ViewStateHolder.put(ViewStateKeys.医療保険情報_モード, 状態_登録);
        ViewStateHolder.put(ViewStateKeys.モード, DBAMN21001_転入により取得);
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
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().initialize(被保険者番号, 識別コード);
            状態_被保履歴タブ = FIRSTREQUEST以外;
        }
        setDdlShikakuShutokuJiyu();
    }

    /**
     * 医療保険タブを打開です。
     *
     */
    public void onOpenTplIryou() {
        if (!状態_医療保険タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuShutokuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki().initialize(状態_登録, 識別コード.getColumnValue());
            状態_医療保険タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 老福年金タブを打開です。
     *
     */
    public void onOpenTplRoNen() {
        if (!状態_老福年金タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuShutokuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().initialize(識別コード, 被保険者番号);
            状態_老福年金タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 施設入退所タブを打開です。
     *
     */
    public void onOpenTplShisetsu() {
        if (!状態_施設入退所タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuShutokuJoho().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード);
            状態_施設入退所タブ = FIRSTREQUEST以外;
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
        div.getShikakuShutokuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki().save();
        // 老福年金タブ
        div.getShikakuShutokuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().click_Save();
        // 施設入退所タブ
        div.getShikakuShutokuJoho().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
    }

    /**
     *
     *
     */
    public void setDdlShikakuShutokuJiyu() {
        RString menuID = ResponseHolder.getMenuID();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getDdlShikakuShutokuJiyu().setDisabled(true);
        List<KeyValueDataSource> keyValueList = new ArrayList();
        if (DBAMN21001_転入により取得.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.転入.getコード(), ShikakuShutokuJiyu.転入.get名称()));
        } else if (DBAMN21002_第2号被保険者取得申請により取得.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu._２号申請.getコード(), ShikakuShutokuJiyu._２号申請.get名称()));
        } else if (DBAMN21003_外国人申請により取得.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.外国人.getコード(), ShikakuShutokuJiyu.外国人.get名称()));
        } else if (DBAMN21004_年齢到達により取得.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.年齢到達.getコード(), ShikakuShutokuJiyu.年齢到達.get名称()));
        } else if (DBAMN21005_転居により取得_施設退所等.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.他特例居住.getコード(), ShikakuShutokuJiyu.他特例居住.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.除外者居住.getコード(), ShikakuShutokuJiyu.除外者居住.get名称()));
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getDdlShikakuShutokuJiyu().setDisabled(false);
        } else if (DBAMN21006_帰化により取得.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.帰化.getコード(), ShikakuShutokuJiyu.帰化.get名称()));
        } else if (DBAMN21007_職権により取得.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.職権取得.getコード(), ShikakuShutokuJiyu.職権取得.get名称()));
        } else if (DBAMN21008_その他事由により取得.equals(menuID)) {
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.その他.getコード(), ShikakuShutokuJiyu.その他.get名称()));
        }
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getDdlShikakuShutokuJiyu().setDataSource(keyValueList);
    }

    public void get被保番号表示有無制御() {
        HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance().getHihokenshanotsukiban(識別コード);
        if (任意手入力付番.equals(BusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_付番方法, SubGyomuCode.DBA介護資格))
                && hihokenshaNo.isEmpty()) {
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtHihoNo().setDisplayNone(false);
        } else if (!hihokenshaNo.isEmpty()) {
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtHihoNo().setDisplayNone(true);
        } else if (hihokenshaNo == null) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }
    }

    private void save資格得喪履歴() {
        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        // TODO 資格取得登録チェック処理
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().getDataGridDataSource();
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
