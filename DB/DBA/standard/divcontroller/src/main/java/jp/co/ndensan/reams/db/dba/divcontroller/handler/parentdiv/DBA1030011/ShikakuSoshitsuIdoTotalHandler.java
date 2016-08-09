/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011.ShikakuSoshitsuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakusoshitsu.HihokenshashikakusoshitsuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.SikakuKikan;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.TokusoRireki;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
    private static final RString 状態_照会 = new RString("照会");

    private static final RString DBAMN22001_転出により喪失 = new RString("DBAMN22001");
    private static final RString DBAMN22002_死亡により喪失 = new RString("DBAMN22002");
    private static final RString DBAMN22003_転居により喪失_施設入所等 = new RString("DBAMN22003");
    private static final RString DBAMN22004_国籍喪失により喪失 = new RString("DBAMN22004");
    private static final RString DBAMN22005_医療保険未加入により喪失 = new RString("DBAMN22005");
    private static final RString DBAMN22006_職権により喪失 = new RString("DBAMN22006");
    private static final RString DBAMN22007_その他事由により喪失 = new RString("DBAMN22007");
    private static final RString FIRSTREQUEST以外 = new RString("2");
    private static final Integer FIRSTINDEX = Integer.valueOf("0");
    private static final RString 修正 = new RString("修正");
    private final RString 表示モード = new RString("HihokenrirekiNashiMode");

    private HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
    private ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;

    private final ShikakuSoshitsuIdoTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 資格喪失異動Div
     * @param key 対象者
     */
    public ShikakuSoshitsuIdoTotalHandler(ShikakuSoshitsuIdoTotalDiv div, TaishoshaKey key) {
        this.div = div;
        被保険者番号 = key.get被保険者番号();
        識別コード = key.get識別コード();
    }

    /**
     * 資格喪失異動の初期化します。
     *
     * @param 状態_被保履歴タブ 状態_被保履歴タブ
     */
    public void load(RString 状態_被保履歴タブ) {
        kaigoShikakuKihon_onload(被保険者番号, 表示モード);
        kaigoNinteiAtenaInfo_onload(識別コード);
        onOpenTplDefault(状態_被保履歴タブ);
    }

    /**
     * 被保履歴タブを打開です。
     *
     * @param 状態_被保履歴タブ 状態_被保履歴タブ
     * @return 状態_被保履歴タブ 状態_被保履歴タブ
     */
    public RString onOpenTplDefault(RString 状態_被保履歴タブ) {
        if (RString.isNullOrEmpty(状態_被保履歴タブ) || !FIRSTREQUEST以外.equals(状態_被保履歴タブ)) {
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().initialize(被保険者番号, 識別コード);
            setRowState();
            状態_被保履歴タブ = new RString("2");
        }
        資格喪失情報状態の設定(資格喪失情報パネル初期のチェック());
        if (資格喪失情報パネル初期のチェック()) {
            資格喪失情報パネルの活性初期化();
        } else {
            資格喪失情報パネルの非活性初期化();
        }
        return 状態_被保履歴タブ;
    }

    /**
     * 医療保険タブを打開です。
     *
     * @param 状態_医療保険タブ 状態_医療保険タブ
     * @return 状態_医療保険タブ 状態_医療保険タブ
     */
    public RString onOpenTplIryou(RString 状態_医療保険タブ) {
        if (RString.isNullOrEmpty(状態_医療保険タブ) || !FIRSTREQUEST以外.equals(状態_医療保険タブ)) {

            div.getShikakuSoshitsuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki()
                    .initialize(状態_登録, 識別コード.getColumnValue(), 被保険者番号);
            状態_医療保険タブ = new RString("2");
        }
        return 状態_医療保険タブ;
    }

    /**
     * 老福年金タブを打開です。
     *
     * @param 状態_老福年金タブ 状態_老福年金タブ
     * @return 状態_老福年金タブ 状態_老福年金タブ
     */
    public RString onOpenTplRoNen(RString 状態_老福年金タブ) {
        if (RString.isNullOrEmpty(状態_老福年金タブ) || !状態_老福年金タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuSoshitsuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().initialize(識別コード, 被保険者番号);
            状態_老福年金タブ = new RString("2");
        }
        return 状態_老福年金タブ;
    }

    /**
     * 施設入退所タブを打開です。
     *
     * @param 状態_施設入退所タブ 状態_施設入退所タブ
     * @return 状態_施設入退所タブ 状態_施設入退所タブ
     */
    public RString onOpenTplShisetsu(RString 状態_施設入退所タブ) {
        if (RString.isNullOrEmpty(状態_施設入退所タブ) || !FIRSTREQUEST以外.equals(状態_施設入退所タブ)) {
            div.getShikakuSoshitsuJoho().getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード);
            状態_施設入退所タブ = new RString("2");
        }
        return 状態_施設入退所タブ;
    }

    /**
     * 証類状況タブを打開です。
     *
     * @param 状態_証類状況タブ 状態_証類状況タブ
     * @return 状態_証類状況タブ 状態_証類状況タブ
     */
    public RString onOpenTplShoruiJokyo(RString 状態_証類状況タブ) {
        if (RString.isNullOrEmpty(状態_証類状況タブ) || !FIRSTREQUEST以外.equals(状態_証類状況タブ)) {
            div.getShikakuSoshitsuJoho().getTabInputs().getShoruiJokyo().getCcdShoKaishuKirokuKanri().initialize(状態_更新, 被保険者番号);
            状態_証類状況タブ = new RString("2");
        }
        return 状態_証類状況タブ;
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
     * 資格喪失情報パネル初期のチェック １、最新被保履歴に資格喪失情報があるの場合：false ２、最新被保履歴に資格喪失情報がなしの場合：true
     *
     * @return boolean
     */
    public boolean 資格喪失情報パネル初期のチェック() {
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().getDataGridDataSource();
        if (rowList.isEmpty()) {
            return false;
        }
        dgShikakuShutokuRireki_Row row = rowList.get(0);
        return (row.getSoshitsuDate().getValue().isEmpty()
                && row.getSoshitsuTodokedeDate().getValue().isEmpty()
                && RString.isNullOrEmpty(row.getSoshitsuJiyu())
                && RString.isNullOrEmpty(row.getSoshitsuJiyuKey()));
    }

    /**
     * 資格喪失情報状態の設定
     *
     * @param 状態フラグ 状態フラグ
     */
    public void 資格喪失情報状態の設定(boolean 状態フラグ) {
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().getDataGridDataSource();
        if (rowList.isEmpty()) {
            return;
        }
        for (int i = 0; i < rowList.size(); i++) {
            rowList.get(i).setModifyButtonState(DataGridButtonState.Disabled);
            if (状態フラグ && i == FIRSTINDEX) {
                rowList.get(i).setModifyButtonState(DataGridButtonState.Enabled);
            }
        }
    }

    /**
     * 資格喪失情報パネルの非活性初期化
     */
    public void 資格喪失情報パネルの非活性初期化() {
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタンの表示状態(true);
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuDate().clearValue();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuTodokedeDate().clearValue();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().setReadOnly(true);
        setDdlShikakuSoshitsuJiyu();
    }

    /**
     * 資格喪失情報パネルの活性初期化
     */
    public void 資格喪失情報パネルの活性初期化() {
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタンの表示状態(true);
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuDate().clearValue();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuTodokedeDate().clearValue();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().setReadOnly(false);
        setDdlShikakuSoshitsuJiyu();
    }

    /**
     * 画面遷移のパラメータの設定します。
     *
     */
    public void setパラメータ() {
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.状態, 状態_照会);
        dgShikakuShutokuRireki_Row row = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().
                getCcdShikakuTokusoRireki().getDataGridSelectItem();
        ShikakuRirekiJoho joho = new ShikakuRirekiJoho();
        joho.setDaNo(row.getDaNo());
        joho.setHihokenshaKubun(row.getHihokenshaKubun());
        joho.setHihokenshaKubunKey(row.getHihokenshaKubunKey());
        joho.setHihokenshaNo(row.getHihokenshaNo());
        joho.setJutokuKubun(row.getJutokuKubun());
        joho.setKyuHokensha(row.getKyuHokenshaCode());
        joho.setShikakuShutokuJiyuCode(row.getShikakuShutokuJiyuCode());
        joho.setShikibetsuCode(row.getShikibetsuCode());
        joho.setShoriDateTime(row.getShoriDateTime());
        joho.setShozaiHokensha(row.getShozaiHokenshaCode());
        joho.setShutokuDate(row.getShutokuDate().getValue());
        joho.setShutokuJiyu(row.getShutokuJiyu());
        joho.setShutokuJiyuKey(row.getShutokuJiyuKey());
        joho.setShutokuTodokedeDate(row.getShutokuTodokedeDate().getValue());
        joho.setSochimotoHokensha(row.getSochimotoHokenshaCode());
        joho.setSoshitsuDate(row.getSoshitsuDate().getValue());
        joho.setSoshitsuJiyu(row.getSoshitsuJiyu());
        joho.setSoshitsuJiyuKey(row.getSoshitsuJiyuKey());
        joho.setSoshitsuTodokedeDate(row.getSoshitsuTodokedeDate().getValue());
        joho.setState(row.getState());
        ViewStateHolder.put(ViewStateKeys.資格得喪情報, joho);
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
            div.getKihonJoho().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        }
    }

    private void kaigoNinteiAtenaInfo_onload(ShikibetsuCode 識別コード) {
        div.getKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
    }

    private void save資格得喪履歴() {
        HihokenshashikakusoshitsuManager manager = HihokenshashikakusoshitsuManager.createInstance();
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki()
                .getDataGridDataSource();
        List<TokusoRireki> tokusoRirekiList = get開始日と終了日(rowList);
        List<SikakuKikan> sikakuKikanList = get取得日と喪失日(rowList);
        for (dgShikakuShutokuRireki_Row row : rowList) {
            if (修正.equals(row.getState())) {
                manager.shikakuSoshitsuTorokuCheck(識別コード, 被保険者番号, row.getSoshitsuDate().getValue(),
                        DateOfBirthFactory.createInstance(div.getKihonJoho().getCcdKaigoAtenaInfo().getShokaiData()
                                .getTxtSeinengappiYMD().getValue()),
                        tokusoRirekiList, sikakuKikanList);
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
