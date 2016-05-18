/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.shichoson.Shichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.core.hihousyosai.HihousyosaiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 被保険者資格詳細異動Handlerクラスです。
 *
 * @reamsid_L DBA-0340-050 lijia
 *
 */
public class HihokenshaShisakuPanalHandler {

    private final HihokenshaShisakuPanalDiv panelDiv;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_照会 = new RString("照会");
    private static final int 処理日時_TMP = 9;
    private final RString 合併情報区分 = new RString("1");
    private final RString 広域保険者 = new RString("1");
    private final RString 単一保険者 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param panelDiv 事業者登録Div
     */
    public HihokenshaShisakuPanalHandler(HihokenshaShisakuPanalDiv panelDiv) {
        this.panelDiv = panelDiv;
    }

    /**
     * 画面初期化処理します。
     *
     * @param viewState 表示状態
     */
    public void initialize(RString viewState) {
        HihokenshaNo 被保番号 = ViewStateHolder.get(ViewStateKeys.資格異動の訂正_被保番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格異動の訂正_識別コード, ShikibetsuCode.class);
        ShikakuRirekiJoho 資格得喪情報
                = ViewStateHolder.get(ViewStateKeys.資格異動の訂正_資格得喪情報, ShikakuRirekiJoho.class);
        get宛名基本情報取得(識別コード);
        get資格系基本情報取得(被保番号);
        setドロップダウンリストの設定();
        if (viewState.equals(状態_追加)) {
            get画面初期の追加更新モードの表示制御();
        } else if (viewState.equals(状態_修正)) {
            get画面初期の追加更新モードの表示制御();
            set資格詳細情報設定(資格得喪情報, 被保番号, 識別コード, 資格得喪情報.getShutokuDate());
        } else if (viewState.equals(状態_削除)) {
            get画面初期の削除照会モードの表示制御();
            set資格詳細情報設定(資格得喪情報, 被保番号, 識別コード, 資格得喪情報.getShutokuDate());
        } else if (viewState.equals(状態_照会)) {
            get画面初期の削除照会モードの表示制御();
            set資格詳細情報設定(資格得喪情報, 被保番号, 識別コード, 資格得喪情報.getShutokuDate());
        }
    }

    private void get画面初期の追加更新モードの表示制御() {
        panelDiv.getKihonJoho().setDisabled(true);
        panelDiv.getShikakuShosai().setDisabled(false);
    }

    private void get画面初期の削除照会モードの表示制御() {
        panelDiv.getKihonJoho().setDisabled(true);
        panelDiv.getShikakuShosai().setDisabled(true);
    }

    private void setドロップダウンリストの設定() {
        get取得事由();
        get被保区分();
        get所在保険者と措置元保険者();
        表示と非表示();
        get旧保険者();
        get喪失事由();
    }

    private void get取得事由() {
        List<KeyValueDataSource> 取得事由リスト = new ArrayList<>();
        KeyValueDataSource dateSource = new KeyValueDataSource();
        dateSource.setKey(ShikakuShutokuJiyu.転入.getコード());
        dateSource.setValue(ShikakuShutokuJiyu.転入.get名称());
        取得事由リスト.add(dateSource);
        KeyValueDataSource dateSource1 = new KeyValueDataSource();
        dateSource1.setKey(ShikakuShutokuJiyu.年齢到達.getコード());
        dateSource1.setValue(ShikakuShutokuJiyu.年齢到達.get名称());
        取得事由リスト.add(dateSource1);
        KeyValueDataSource dateSource2 = new KeyValueDataSource();
        dateSource2.setKey(ShikakuShutokuJiyu.外国人.getコード());
        dateSource2.setValue(ShikakuShutokuJiyu.外国人.get名称());
        取得事由リスト.add(dateSource2);
        KeyValueDataSource dateSource3 = new KeyValueDataSource();
        dateSource3.setKey(ShikakuShutokuJiyu._２号申請.getコード());
        dateSource3.setValue(ShikakuShutokuJiyu._２号申請.get名称());
        取得事由リスト.add(dateSource3);
        KeyValueDataSource dateSource4 = new KeyValueDataSource();
        dateSource4.setKey(ShikakuShutokuJiyu.他特例居住.getコード());
        dateSource4.setValue(ShikakuShutokuJiyu.他特例居住.get名称());
        取得事由リスト.add(dateSource4);
        KeyValueDataSource dateSource5 = new KeyValueDataSource();
        dateSource5.setKey(ShikakuShutokuJiyu.除外者居住.getコード());
        dateSource5.setValue(ShikakuShutokuJiyu.除外者居住.get名称());
        取得事由リスト.add(dateSource5);
        KeyValueDataSource dateSource6 = new KeyValueDataSource();
        dateSource6.setKey(ShikakuShutokuJiyu.帰化.getコード());
        dateSource6.setValue(ShikakuShutokuJiyu.帰化.get名称());
        取得事由リスト.add(dateSource6);
        KeyValueDataSource dateSource7 = new KeyValueDataSource();
        dateSource7.setKey(ShikakuShutokuJiyu.国籍取得.getコード());
        dateSource7.setValue(ShikakuShutokuJiyu.国籍取得.get名称());
        取得事由リスト.add(dateSource7);
        KeyValueDataSource dateSource8 = new KeyValueDataSource();
        dateSource8.setKey(ShikakuShutokuJiyu.職権取得.getコード());
        dateSource8.setValue(ShikakuShutokuJiyu.職権取得.get名称());
        取得事由リスト.add(dateSource8);
        KeyValueDataSource dateSource9 = new KeyValueDataSource();
        dateSource9.setKey(ShikakuShutokuJiyu.施行時取得.getコード());
        dateSource9.setValue(ShikakuShutokuJiyu.施行時取得.get名称());
        取得事由リスト.add(dateSource9);
        KeyValueDataSource dateSource10 = new KeyValueDataSource();
        dateSource10.setKey(ShikakuShutokuJiyu.その他.getコード());
        dateSource10.setValue(ShikakuShutokuJiyu.その他.get名称());
        取得事由リスト.add(dateSource10);
        panelDiv.getShikakuShosai().getDdlShutokuJiyu().setDataSource(取得事由リスト);
    }

    private void get被保区分() {
        List<KeyValueDataSource> 被保区分リスト = new ArrayList<>();
        KeyValueDataSource dateSource = new KeyValueDataSource();
        dateSource.setKey(ShikakuKubun._１号.getコード());
        dateSource.setValue(ShikakuKubun._１号.get名称());
        被保区分リスト.add(dateSource);
        KeyValueDataSource dateSource1 = new KeyValueDataSource();
        dateSource1.setKey(ShikakuKubun._２号.getコード());
        dateSource1.setValue(ShikakuKubun._２号.get名称());
        被保区分リスト.add(dateSource1);
        panelDiv.getShikakuShosai().getDdlHihoKubun().setDataSource(被保区分リスト);
    }

    private void get所在保険者と措置元保険者() {
        List<KoseiShichosonMaster> 所在保険者情報
                = HihousyosaiFinder.createInstance().getKoseiShichosonMasterList().records();
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (KoseiShichosonMaster 所在保険者 : 所在保険者情報) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(所在保険者.getShichosonCode().getColumnValue());
            keyValue.setValue(new RString(所在保険者.getShoKisaiHokenshaNo().getColumnValue() + " " + 所在保険者.getShichosonMeisho()));
            keyValueList.add(keyValue);
        }
        panelDiv.getShikakuShosai().getDdlShutokuShozaiHokensha().setDataSource(keyValueList);
        panelDiv.getShikakuShosai().getDdlShutokuSochimotoHokensha().setDataSource(keyValueList);
    }

    private void get旧保険者() {
        ShikakuRirekiJoho 資格得喪情報 = ViewStateHolder.get(ViewStateKeys.資格異動の訂正_資格得喪情報, ShikakuRirekiJoho.class);
        ShichosonSecurityJoho 介護導入形態 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (介護導入形態 != null) {
            DonyuKeitaiCode 導入形態コード = 介護導入形態.get導入形態コード();
            RString 所在保険者 = 資格得喪情報.getShozaiHokensha();
            RString 措置元保険者 = 資格得喪情報.getSochimotoHokensha();
            List<Shichoson> 旧保険者情報 = 旧保険者取得(
                    RString.isNullOrEmpty(所在保険者) ? LasdecCode.EMPTY : new LasdecCode(所在保険者),
                    導入形態コード.getCode(),
                    RString.isNullOrEmpty(措置元保険者) ? LasdecCode.EMPTY : new LasdecCode(措置元保険者));
            List<KeyValueDataSource> keyValueList = new ArrayList<>();
            for (Shichoson 旧保険者 : 旧保険者情報) {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(旧保険者.get旧市町村コード().getColumnValue());
                keyValue.setValue(new RString(旧保険者.get旧市町村コード().getColumnValue() + " " + 旧保険者.get旧市町村名称()));
                keyValueList.add(keyValue);
            }
            panelDiv.getShikakuShosai().getDdlShutokuKyuHokensha().setDataSource(keyValueList);
        }
    }

    private void get喪失事由() {
        List<KeyValueDataSource> 喪失事由リスト = new ArrayList<>();
        KeyValueDataSource dateSource = new KeyValueDataSource();
        dateSource.setKey(ShikakuSoshitsuJiyu.転出.getCode());
        dateSource.setValue(ShikakuSoshitsuJiyu.転出.getName());
        喪失事由リスト.add(dateSource);
        KeyValueDataSource dateSource1 = new KeyValueDataSource();
        dateSource1.setKey(ShikakuSoshitsuJiyu.死亡.getCode());
        dateSource1.setValue(ShikakuSoshitsuJiyu.死亡.getName());
        喪失事由リスト.add(dateSource1);
        KeyValueDataSource dateSource2 = new KeyValueDataSource();
        dateSource2.setKey(ShikakuSoshitsuJiyu.除外者.getCode());
        dateSource2.setValue(ShikakuSoshitsuJiyu.除外者.getName());
        喪失事由リスト.add(dateSource2);
        KeyValueDataSource dateSource3 = new KeyValueDataSource();
        dateSource3.setKey(ShikakuSoshitsuJiyu.国籍喪失.getCode());
        dateSource3.setValue(ShikakuSoshitsuJiyu.国籍喪失.getName());
        喪失事由リスト.add(dateSource3);
        KeyValueDataSource dateSource4 = new KeyValueDataSource();
        dateSource4.setKey(ShikakuSoshitsuJiyu.他特例者.getCode());
        dateSource4.setValue(ShikakuSoshitsuJiyu.他特例者.getName());
        喪失事由リスト.add(dateSource4);
        KeyValueDataSource dateSource5 = new KeyValueDataSource();
        dateSource5.setKey(ShikakuSoshitsuJiyu.職権喪失.getCode());
        dateSource5.setValue(ShikakuSoshitsuJiyu.職権喪失.getName());
        喪失事由リスト.add(dateSource5);
        KeyValueDataSource dateSource6 = new KeyValueDataSource();
        dateSource6.setKey(ShikakuSoshitsuJiyu.その他.getCode());
        dateSource6.setValue(ShikakuSoshitsuJiyu.その他.getName());
        喪失事由リスト.add(dateSource6);
        panelDiv.getShikakuShosai().getDdlSoshitsuJiyu().setDataSource(喪失事由リスト);
    }

    private void 表示と非表示() {
        if (単一保険者.equals(広域と市町村判断())) {
            panelDiv.getLblShutokuShozaiHokensha().setVisible(false);
            panelDiv.getDdlShutokuShozaiHokensha().setVisible(false);
            panelDiv.getLblShutokuSochimotoHokensha().setVisible(false);
            panelDiv.getDdlShutokuSochimotoHokensha().setVisible(false);
        } else if (広域保険者.equals(広域と市町村判断())) {
            panelDiv.getLblShutokuShozaiHokensha().setVisible(true);
            panelDiv.getDdlShutokuShozaiHokensha().setVisible(true);
            panelDiv.getLblShutokuSochimotoHokensha().setVisible(true);
            panelDiv.getDdlShutokuSochimotoHokensha().setVisible(true);
        }
        if (is合併市町村()) {
            panelDiv.getLblKyuHokensha().setVisible(true);
            panelDiv.getDdlShutokuKyuHokensha().setVisible(true);
        } else {
            panelDiv.getLblKyuHokensha().setVisible(false);
            panelDiv.getDdlShutokuKyuHokensha().setVisible(false);
        }
    }

    private boolean is合併市町村() {
        RString 合併市町村 = BusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告);
        return 合併情報区分.equals(合併市町村);
    }

    /**
     * 広域と市町村判断の処理します。
     *
     * @return 広域保険者または単一保険者
     */
    public RString 広域と市町村判断() {
        ShichosonSecurityJoho 介護導入形態 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (介護導入形態 != null) {
            DonyuKeitaiCode 導入形態コード = 介護導入形態.get導入形態コード();
            if (導入形態コード != null) {
                return 広域と単一判断(導入形態コード);
            }
        }
        return RString.EMPTY;
    }

    private RString 広域と単一判断(DonyuKeitaiCode 導入形態コード) {
        panelDiv.setHiddenDonyuKeitaiCode(導入形態コード.getCode());
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getCode())) {
            return 広域保険者;
        } else if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード.getCode())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード.getCode())) {
            return 単一保険者;
        }
        return RString.EMPTY;
    }

    /**
     * 広域と市町村判断の処理します。
     *
     * @param 市町村コード LasdecCode
     * @param 導入形態コード RString
     * @param 広住特措置元市町村コード LasdecCode
     * @return 広域保険者または単一保険者
     */
    public List<Shichoson> 旧保険者取得(LasdecCode 市町村コード, RString 導入形態コード, LasdecCode 広住特措置元市町村コード) {
        if (市町村コード == null || 市町村コード.isEmpty() || RString.isNullOrEmpty(導入形態コード)) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            return HihousyosaiFinder.createInstance().getGappeiShichosonList(広住特措置元市町村コード, DonyuKeitaiCode.toValue(導入形態コード)).records();
        }
        return HihousyosaiFinder.createInstance().getGappeiShichosonList(市町村コード, DonyuKeitaiCode.toValue(導入形態コード)).records();
    }

    private void get宛名基本情報取得(ShikibetsuCode 識別コード) {
        panelDiv.getKihonJoho().getCcdKaigoAtenaInfo().onLoad(識別コード);
    }

    private void get資格系基本情報取得(HihokenshaNo 被保番号) {
        panelDiv.getKihonJoho().getCcdKaigoShikakuKihon().onLoad(被保番号);
    }

    private void set資格詳細情報設定(
            ShikakuRirekiJoho 資格得喪情報,
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleDate 取得日) {
        set資格得喪情報設定(資格得喪情報);
        get住所地特例情報取得(被保険者番号, 識別コード, 取得日);
        get資格変更履歴情報取得(被保険者番号, 識別コード, 取得日);
        get施設入退所情報取得(識別コード);
    }

    private void set資格得喪情報設定(ShikakuRirekiJoho 資格得喪情報) {
        FlexibleDate 取得日 = 資格得喪情報.getShutokuDate();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtShutokuDate().setValue(取得日.isEmpty() ? FlexibleDate.EMPTY : 取得日);
        FlexibleDate 取得届出日 = 資格得喪情報.getShutokuTodokedeDate();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtShutokuTodokedeDate().setValue(
                取得届出日.isEmpty() ? FlexibleDate.EMPTY : 取得届出日);
        RString 取得事由 = 資格得喪情報.getShutokuJiyuKey();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuJiyu().setSelectedKey(
                取得事由.isEmpty() ? RString.EMPTY : 取得事由);
        FlexibleDate 喪失日 = 資格得喪情報.getSoshitsuDate();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuDate().setValue(喪失日.isEmpty() ? FlexibleDate.EMPTY : 喪失日);
        FlexibleDate 喪失届出日 = 資格得喪情報.getSoshitsuTodokedeDate();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuTodokedeDate().setValue(
                喪失届出日.isEmpty() ? FlexibleDate.EMPTY : 喪失届出日);
        RString 喪失事由 = 資格得喪情報.getSoshitsuJiyuKey();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlSoshitsuJiyu().setSelectedKey(
                喪失事由.isEmpty() ? RString.EMPTY : 喪失事由);
        RString 被保区分 = 資格得喪情報.getHihokenshaKubunKey();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlHihoKubun().setSelectedKey(
                被保区分.isEmpty() ? RString.EMPTY : 被保区分);
        RString 所在保険者 = 資格得喪情報.getShozaiHokensha();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuShozaiHokensha().setSelectedKey(
                所在保険者.isEmpty() ? RString.EMPTY : 所在保険者);
        RString 措置元保険者 = 資格得喪情報.getSochimotoHokensha();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuSochimotoHokensha().setSelectedKey(
                措置元保険者.isEmpty() ? RString.EMPTY : 措置元保険者);
        RString 旧保険者 = 資格得喪情報.getKyuHokensha();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha().setSelectedKey(
                旧保険者.isEmpty() ? RString.EMPTY : 旧保険者);
        RString 処理日時 = 資格得喪情報.getShoriDateTime();
        panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtShutokuShoriDate().setValue(rStringToFlexibleDate(処理日時));
        panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuShoriDate().setValue(rStringToFlexibleDate(処理日時));
    }

    private FlexibleDate rStringToFlexibleDate(RString 処理日時) {
        if (RString.isNullOrEmpty(処理日時)) {
            return FlexibleDate.EMPTY;
        }
        RDate date = new RDate(処理日時.toString().substring(0, 処理日時_TMP));
        return new FlexibleDate(date.toDateString());
    }

    private void get住所地特例情報取得(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        panelDiv.getShikakuShosai().getTabShisakuShosaiRireki().getCcdJushochiTokureiRirekiList().initialize(
                被保険者番号, 識別コード, 取得日);
    }

    private void get資格変更履歴情報取得(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        panelDiv.getShikakuShosai().getTabShisakuShosaiRireki().getCcdShikakuHenkoRireki().initialize(
                被保険者番号, 識別コード, 取得日);
    }

    private void get施設入退所情報取得(ShikibetsuCode 識別コード) {
        RString 台帳種別 = new RString("1");
        panelDiv.getShikakuShosai().getTabShisakuShosaiRireki().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード, 台帳種別);
    }

    /**
     * 資格詳細情報の取得を処理します。
     *
     * @return ShikakuRirekiJoho 資格詳細情報 setShutokuJiyuKey
     */
    public ShikakuRirekiJoho get資格詳細情報() {
        ShikakuRirekiJoho shikakuRirekiJoho = new ShikakuRirekiJoho();
        FlexibleDate 取得日 = panelDiv.getTxtShutokuDate().getValue();
        shikakuRirekiJoho.setShutokuDate(取得日.isEmpty() ? FlexibleDate.EMPTY : 取得日);
        FlexibleDate 取得届出日 = panelDiv.getTxtShutokuTodokedeDate().getValue();
        shikakuRirekiJoho.setShutokuTodokedeDate(取得届出日.isEmpty() ? FlexibleDate.EMPTY : 取得届出日);
        RString 取得事由 = panelDiv.getDdlShutokuJiyu().getSelectedKey();
        shikakuRirekiJoho.setShutokuJiyuKey(取得事由.isEmpty() ? RString.EMPTY : 取得事由);
        FlexibleDate 喪失日 = panelDiv.getTxtSoshitsuDate().getValue();
        shikakuRirekiJoho.setSoshitsuDate(喪失日.isEmpty() ? FlexibleDate.EMPTY : 喪失日);
        FlexibleDate 喪失届出日 = panelDiv.getTxtSoshitsuTodokedeDate().getValue();
        shikakuRirekiJoho.setSoshitsuTodokedeDate(喪失届出日.isEmpty() ? FlexibleDate.EMPTY : 喪失届出日);
        RString 喪失事由 = panelDiv.getDdlSoshitsuJiyu().getSelectedKey();
        shikakuRirekiJoho.setSoshitsuJiyuKey(喪失事由.isEmpty() ? RString.EMPTY : 喪失事由);
        RString 被保区分 = panelDiv.getDdlHihoKubun().getSelectedKey();
        shikakuRirekiJoho.setHihokenshaKubun(被保区分.isEmpty() ? RString.EMPTY : 被保区分);
        RString 所在保険者 = panelDiv.getDdlShutokuShozaiHokensha().getSelectedKey();
        shikakuRirekiJoho.setShozaiHokensha(所在保険者.isEmpty() ? RString.EMPTY : 所在保険者);
        RString 措置元保険者 = panelDiv.getDdlShutokuSochimotoHokensha().getSelectedKey();
        shikakuRirekiJoho.setSochimotoHokensha(措置元保険者.isEmpty() ? RString.EMPTY : 措置元保険者);
        RString 旧保険者 = panelDiv.getDdlShutokuKyuHokensha().getSelectedKey();
        shikakuRirekiJoho.setKyuHokensha(旧保険者.isEmpty() ? RString.EMPTY : 旧保険者);
        return shikakuRirekiJoho;
    }
}
