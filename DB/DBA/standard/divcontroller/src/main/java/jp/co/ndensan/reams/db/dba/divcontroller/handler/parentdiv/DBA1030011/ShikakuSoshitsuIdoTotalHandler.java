/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011.ShikakuSoshitsuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakusoshitsu.HihokenshashikakusoshitsuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.SikakuKikan;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.TokusoRireki;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格喪失異動のHandlerクラスです。
 *
 * @reamsid_L DBA-0552-030 wangkun
 */
public class ShikakuSoshitsuIdoTotalHandler {

    private static final RString 認定履歴ボタン = new RString("HihokenrirekiNashiMode");
    private static final RString 被保履歴ボタン = new RString("NinteirirekiNashiMode");
    private static final RString 状態_登録 = new RString("登録");
    private static final RString 状態_更新 = new RString("更新");

    private static final RString DBAMN22001_転出により喪失 = new RString("DBAMN22001");
    private static final RString DBAMN22002_死亡により喪失 = new RString("DBAMN22002");
    private static final RString DBAMN22003_転居により喪失_施設入所等 = new RString("DBAMN22003");
    private static final RString DBAMN22004_国籍喪失により喪失 = new RString("DBAMN22004");
    private static final RString DBAMN22005_医療保険未加入により喪失 = new RString("DBAMN22005");
    private static final RString DBAMN22006_職権により喪失 = new RString("DBAMN22006");
    private static final RString DBAMN22007_その他事由により喪失 = new RString("DBAMN22007");
    private static final RString FIRSTREQUEST以外 = new RString("2");
    private static final RString 修正 = new RString("修正");
    private final RString 表示モード = new RString("HihokenrirekiNashiMode");

    private RString 状態_被保履歴タブ = RString.EMPTY;
    private RString 状態_医療保険タブ = RString.EMPTY;
    private RString 状態_老福年金タブ = RString.EMPTY;
    private RString 状態_施設入退所タブ = RString.EMPTY;
    private RString 状態_証類状況タブ = RString.EMPTY;
    private HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
    private ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;

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
     */
    public void load() {
        被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        kaigoShikakuKihon_onload(被保険者番号, 表示モード);
        kaigoNinteiAtenaInfo_onload(識別コード);
        onOpenTplDefault();
    }

    /**
     * 被保履歴タブを打開です。
     */
    public void onOpenTplDefault() {
        if (!状態_被保履歴タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().initialize(被保険者番号, 識別コード);
            setRowState();
            状態_被保履歴タブ = FIRSTREQUEST以外;
        }
        setDdlShikakuSoshitsuJiyu();
    }

    /**
     * 医療保険タブを打開です。
     */
    public void onOpenTplIryou() {
        if (!状態_医療保険タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki()
                    .initialize(状態_登録, 識別コード.getColumnValue());
            状態_医療保険タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 老福年金タブを打開です。
     */
    public void onOpenTplRoNen() {
        if (!状態_老福年金タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().initialize(識別コード, 被保険者番号);
            状態_老福年金タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 施設入退所タブを打開です。
     */
    public void onOpenTplShisetsu() {
        if (!状態_施設入退所タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード);
            状態_施設入退所タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 証類状況タブを打開です。
     */
    public void onOpenTplShoruiJokyo() {
        if (!状態_証類状況タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getTabInputs().getShoruiJokyo().getCcdShoKaishuKirokuKanri().initialize(状態_更新, 被保険者番号);
            状態_証類状況タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 保存処理します。
     */
    public void save() {
        save資格得喪履歴();
        div.getShikakuSoshitsuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki().save();
        div.getShikakuSoshitsuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().click_Save();
        div.getShikakuSoshitsuJoho().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
        div.getShikakuSoshitsuJoho().getTabInputs().getShoruiJokyo().getCcdShoKaishuKirokuKanri().saveShoKaishuKirokuKanri();
    }

    /**
     * 被保履歴タブの資格喪失情報パネルの喪失事由DDLの設定
     */
    public void setDdlShikakuSoshitsuJiyu() {
        RString menuID = ResponseHolder.getMenuID();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setDisabled(true);
        List<KeyValueDataSource> keyValueList = new ArrayList();
        keyValueList.add(new KeyValueDataSource(new RString("key0"), RString.EMPTY));
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
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu()
                    .setDataSource(keyValueList);
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                    .getDdlShikakuShutokuJiyu().setSelectedKey(ShikakuSoshitsuJiyu.その他.getコード());
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setDisabled(false);
            return;
        }
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setDataSource(keyValueList);
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().setSelectedIndex(1);
    }

    /**
     * 資格喪失情報パネルの初期化
     */
    public void 資格喪失情報パネルの初期化() {
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuDate().clearValue();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuTodokedeDate().clearValue();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().setDisabled(true);
        setDdlShikakuSoshitsuJiyu();
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
        if (!RString.isNullOrEmpty(被保険者番号.getColumnValue())) {
            div.getKihonJoho().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        }
    }

    private void kaigoNinteiAtenaInfo_onload(ShikibetsuCode 識別コード) {
        div.getKihonJoho().getCcdKaigoAtenaInfo().onLoad(識別コード);
    }

    private void save資格得喪履歴() {
        HihokenshashikakusoshitsuManager manager = HihokenshashikakusoshitsuManager.createInstance();
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki()
                .getDataGridDataSource();
        List<TokusoRireki> tokusoRirekiList = get開始日と終了日(rowList);
        List<SikakuKikan> sikakuKikanList = get取得日と喪失日(rowList);
        for (dgShikakuShutokuRireki_Row row : rowList) {
            if (修正.equals(row.getState())) {
                RString errorCode = manager.shikakuSoshitsuTorokuCheck(識別コード, 被保険者番号, row.getShutokuDate().getValue(),
                        DateOfBirthFactory.createInstance(div.getKihonJoho().getCcdKaigoAtenaInfo().getShokaiData()
                                .getTxtSeinengappiYMD().getValue()),
                        tokusoRirekiList, sikakuKikanList);
                // TODO
                if (!RString.isNullOrEmpty(errorCode)) {
                    throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage());
                }
                manager.saveHihokenshaShikakuSoshitsu(識別コード, 被保険者番号,
                        row.getSoshitsuDate().getValue(),
                        row.getSoshitsuJiyuKey(),
                        row.getSoshitsuTodokedeDate().getValue());
            }
        }
    }

    private void setRowState() {
        List<dgShikakuShutokuRireki_Row> rowListOld = div.getShikakuSoshitsuJoho()
                .getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().getDataGridDataSource();
        List<dgShikakuShutokuRireki_Row> rowListNew = new ArrayList<>();
        for (dgShikakuShutokuRireki_Row row : rowListOld) {
            row.setModifyButtonState(DataGridButtonState.Enabled);
            rowListNew.add(row);
        }
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().setDataGridDataSource(rowListNew);
    }

    private List<TokusoRireki> get開始日と終了日(List<dgShikakuShutokuRireki_Row> rowList) {
        List<TokusoRireki> resultList = new ArrayList<>();
        for (dgShikakuShutokuRireki_Row row : rowList) {
            resultList.add(new TokusoRireki(row.getShutokuDate().getValue(), row.getSoshitsuDate().getValue()));
        }
        return resultList;
    }

    private List<SikakuKikan> get取得日と喪失日(List<dgShikakuShutokuRireki_Row> rowList) {
        List<SikakuKikan> resultList = new ArrayList<>();
        for (dgShikakuShutokuRireki_Row row : rowList) {
            resultList.add(new SikakuKikan(row.getShutokuDate().getValue(), row.getSoshitsuDate().getValue()));
        }
        return resultList;
    }
}
