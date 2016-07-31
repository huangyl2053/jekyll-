/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.ShikakuShutokuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysGappeiJohoKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IHistoryIterator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 資格取得異動のHandlerクラスです。
 *
 * @reamsid_L DBA-0520-030 wangkun
 */
public class ShiKaKuSyuToKuIdouTotalHandler {

    private static final RString 認定履歴ボタン = new RString("HihokenrirekiNashiMode");
    private static final RString 被保履歴ボタン = new RString("NinteirirekiNashiMode");
    private static final RString 状態_登録 = new RString("登録");
    private static final RString 合併あり = new RString("1");
    private static final RString 合併なし = new RString("0");

    private static final RString DBAMN21001_転入により取得 = new RString("DBAMN21001");
    private static final RString DBAMN21002_第2号被保険者取得申請により取得 = new RString("DBAMN21002");
    private static final RString DBAMN21003_外国人申請により取得 = new RString("DBAMN21003");
    private static final RString DBAMN21004_年齢到達により取得 = new RString("DBAMN21004");
    private static final RString DBAMN21005_転居により取得_施設退所等 = new RString("DBAMN21005");
    private static final RString DBAMN21006_帰化により取得 = new RString("DBAMN21006");
    private static final RString DBAMN21007_職権により取得 = new RString("DBAMN21007");
    private static final RString DBAMN21008_その他事由により取得 = new RString("DBAMN21008");
    private static final RString 任意手入力付番 = new RString("3");
    private static final RString 追加 = new RString("追加");
    private static final RString 表示モード = new RString("HihokenrirekiNashiMode");
    private static final RString FIRSTREQUEST以外 = new RString("2");
    private HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
    private ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;

    private final ShikakuShutokuIdoTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 資格取得異動Div
     * @param key 対象者
     */
    public ShiKaKuSyuToKuIdouTotalHandler(ShikakuShutokuIdoTotalDiv div, TaishoshaKey key) {
        this.div = div;
        被保険者番号 = key.get被保険者番号();
        識別コード = key.get識別コード();
    }

    /**
     * 前排他キーの取得します。
     *
     * @return 前排他キー 前排他キー
     */
    public RString get前排他キー() {
        RStringBuilder rstrBuilder = new RStringBuilder("ShikakuShutokuIdo");
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance().getHihokenshanotsukiban(識別コード);
            if (!(hihokenshaNo == null || hihokenshaNo.isEmpty())) {
                rstrBuilder.append("HihokenshaNo");
            }
        } else {
            rstrBuilder.append("HihokenshaNo");
        }
        return rstrBuilder.toRString();
    }

    /**
     * 資格取得異動の初期化します。
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
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().initialize(被保険者番号, 識別コード);
            状態_被保履歴タブ = new RString("2");
        }
        if (資格取得情報パネル初期のチェック()) {
            資格取得情報パネルの非活性初期化();
        } else {
            資格取得情報パネルの活性初期化();
        }
        get被保番号表示有無制御();
        return 状態_被保履歴タブ;
    }

    /**
     * 資格取得情報パネル初期のチェック １、最新被保履歴に資格喪失情報があるの場合：false ２、最新被保履歴に資格喪失情報がなしの場合：true
     *
     * @return boolean
     */
    public boolean 資格取得情報パネル初期のチェック() {
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
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
     * 資格取得情報パネルの非活性初期化
     */
    public void 資格取得情報パネルの非活性初期化() {
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(true);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtShutokuDate().clearValue();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtShutokuTodokedeDate().clearValue();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setReadOnly(true);
        setDdlShikakuShutokuJiyu();
    }

    /**
     * 資格取得情報パネルの活性初期化
     */
    public void 資格取得情報パネルの活性初期化() {
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(false);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtShutokuDate().clearValue();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtShutokuTodokedeDate().clearValue();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setReadOnly(true);
        setDdlShikakuShutokuJiyu();
    }

    /**
     * 医療保険タブを打開です。
     *
     * @param 状態_医療保険タブ 状態_医療保険タブ
     * @return 状態_医療保険タブ 状態_医療保険タブ
     */
    public RString onOpenTplIryou(RString 状態_医療保険タブ) {
        if (RString.isNullOrEmpty(状態_医療保険タブ) || !FIRSTREQUEST以外.equals(状態_医療保険タブ)) {
            div.getShikakuShutokuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki()
                    .initialize(状態_登録, 識別コード.getColumnValue());
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
        if (RString.isNullOrEmpty(状態_老福年金タブ) || !FIRSTREQUEST以外.equals(状態_老福年金タブ)) {
            div.getShikakuShutokuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().initialize(識別コード, 被保険者番号);
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
            div.getShikakuShutokuJoho().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード);
            状態_施設入退所タブ = new RString("2");
        }
        return 状態_施設入退所タブ;
    }

    /**
     * 保存処理します。
     */
    public void save() {
        save資格得喪履歴();
        div.getShikakuShutokuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki().save();
        div.getShikakuShutokuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().click_Save();
        div.getShikakuShutokuJoho().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
    }

    /**
     * 被保履歴タブの資格取得情報パネルの取得事由DDLの設定
     */
    public void setDdlShikakuShutokuJiyu() {
        RString menuID = ResponseHolder.getMenuID();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getDdlShikakuShutokuJiyu().setDisabled(true);
        List<KeyValueDataSource> keyValueList = new ArrayList();
        keyValueList.add(new KeyValueDataSource(new RString("key0"), RString.EMPTY));
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
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.転入.getコード(), ShikakuShutokuJiyu.転入.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu._２号申請.getコード(), ShikakuShutokuJiyu._２号申請.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.外国人.getコード(), ShikakuShutokuJiyu.外国人.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.年齢到達.getコード(), ShikakuShutokuJiyu.年齢到達.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.他特例居住.getコード(), ShikakuShutokuJiyu.他特例居住.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.除外者居住.getコード(), ShikakuShutokuJiyu.除外者居住.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.帰化.getコード(), ShikakuShutokuJiyu.帰化.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.職権取得.getコード(), ShikakuShutokuJiyu.職権取得.get名称()));
            keyValueList.add(new KeyValueDataSource(ShikakuShutokuJiyu.その他.getコード(), ShikakuShutokuJiyu.その他.get名称()));
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getDdlShikakuShutokuJiyu().setDataSource(keyValueList);
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getDdlShikakuShutokuJiyu().setDisabled(false);
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput()
                    .getDdlShikakuShutokuJiyu().setSelectedKey(ShikakuShutokuJiyu.その他.getコード());
            return;
        }
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getDdlShikakuShutokuJiyu().setDataSource(keyValueList);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getDdlShikakuShutokuJiyu().setSelectedIndex(1);
    }

    /**
     * 資格取得情報パネルの初期化
     */
    public void 資格取得情報パネルの初期化() {
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(true);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setReadOnly(false);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtHihoNo().clearValue();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtShutokuDate().clearValue();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtShutokuTodokedeDate().clearValue();
        setDdlShikakuShutokuJiyu();
    }

    /**
     * 被保番号表示有無制御
     */
    public void get被保番号表示有無制御() {
        HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance().getHihokenshanotsukiban(識別コード);
        if (hihokenshaNo == null) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        } else if (任意手入力付番.equals(DbBusinessConfig.get(ConfigNameDBA.被保険者番号付番方法_付番方法, RDate.getNowDate(), SubGyomuCode.DBA介護資格))
                && hihokenshaNo.isEmpty()) {
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtHihoNo().setDisplayNone(false);
        } else if (!hihokenshaNo.isEmpty()) {
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().getTxtHihoNo().setDisplayNone(true);
        }
    }

    /**
     * 画面遷移のパラメータの設定します。
     *
     * @return ShikakuRirekiJoho
     */
    public ShikakuRirekiJoho setパラメータ() {
        dgShikakuShutokuRireki_Row row = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().
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
        return joho;
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

    private LasdecCode get導入形態チェック() {
        ShichosonSecurityJoho 市町村情報セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村情報セキュリティ情報 != null && 市町村情報セキュリティ情報.get導入形態コード() != null) {
            get市町村コード(市町村情報セキュリティ情報);
        }
        return LasdecCode.EMPTY;
    }

    private LasdecCode get市町村コード(ShichosonSecurityJoho 市町村情報セキュリティ情報) {
        if (new RString("111").equals(市町村情報セキュリティ情報.get導入形態コード().value())
                || new RString("112").equals(市町村情報セキュリティ情報.get導入形態コード().value())
                || new RString("211").equals(市町村情報セキュリティ情報.get導入形態コード().value())) {
            IHistoryIterator<IShikibetsuTaisho> ite = div.getKihonJoho().getCcdKaigoAtenaInfo().getAtenaInfoDiv()
                    .getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().getAll();
            if (ite.hasPrevious()) {
                return ite.previous().get現全国地方公共団体コード();
            }
        } else if (new RString("120").equals(市町村情報セキュリティ情報.get導入形態コード().value())
                || new RString("220").equals(市町村情報セキュリティ情報.get導入形態コード().value())) {
            KoikiShichosonJohoFinder johoFinder = KoikiShichosonJohoFinder.createInstance();
            List<KoikiZenShichosonJoho> johoList = johoFinder.koseiShichosonJoho().records();
            return johoList.get(0).get市町村コード();
        }
        return LasdecCode.EMPTY;
    }

    private void save資格得喪履歴() {
        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().getDataGridDataSource();
        for (dgShikakuShutokuRireki_Row row : rowList) {
            if (追加.equals(row.getState())) {
                HihokenshaDaicho business = new HihokenshaDaicho(new HihokenshaNo(row.getHihokenshaNo()),
                        row.getShutokuDate().getValue(), row.getDaNo());
                HihokenshaDaichoBuilder build = business.createBuilderForEdit();
                build.set資格取得届出年月日(row.getShutokuTodokedeDate().getValue());
                build.set資格取得事由コード(row.getShutokuJiyuKey());
                build.set資格取得年月日(row.getShutokuDate().getValue());
                build.set市町村コード(get導入形態チェック());
                build.set被保険者区分コード(RString.EMPTY);
                if (合併あり.equals(DbBusinessConfig.get(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分,
                        RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                    IHistoryIterator<IShikibetsuTaisho> ite = div.getKihonJoho().getCcdKaigoAtenaInfo().getAtenaInfoDiv()
                            .getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().getAll();
                    build.set旧市町村コード(ite.previous().get旧全国地方公共団体コード());
                } else if (合併なし.equals(DbBusinessConfig.get(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分,
                        RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                    build.set旧市町村コード(LasdecCode.EMPTY);
                }
                build.set広住特措置元市町村コード(LasdecCode.EMPTY);
                build.set識別コード(識別コード);
                build.set異動事由コード(row.getShutokuJiyuKey());
                manager.shikakuShutokuTorokuCheck(DateOfBirthFactory.createInstance(div.getKihonJoho()
                        .getCcdKaigoAtenaInfo().getShokaiData().getTxtSeinengappiYMD().getValue()),
                        row.getShutokuDate().getValue(), row.getSoshitsuJiyuKey());
                manager.saveHihokenshaShutoku(build.build(),
                        DateOfBirthFactory.createInstance(div.getKihonJoho().getCcdKaigoAtenaInfo()
                                .getShokaiData().getTxtSeinengappiYMD().getValue()));
            }
        }
    }
}
