/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashisaku.HihokenshaShisaku;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeiseiManager;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.shichoson.Shichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
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
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 被保険者資格詳細異動Handlerクラスです。
 *
 * @reamsid_L DBA-0521-020 lijia
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
    private final HihokenshaShikakuTeiseiManager manager = HihokenshaShikakuTeiseiManager.createInstance();

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
        setドロップダウンリストの設定(viewState, 資格得喪情報, 識別コード);
        if (状態_追加.equals(viewState)) {
            get画面初期の追加更新モードの表示制御();
        } else if (状態_修正.equals(viewState)) {
            get画面初期の追加更新モードの表示制御();
            set資格詳細情報設定(viewState, 資格得喪情報, 被保番号, 識別コード, 資格得喪情報.getShutokuDate());
        } else if (状態_削除.equals(viewState)) {
            get画面初期の削除照会モードの表示制御();
            set資格詳細情報設定(viewState, 資格得喪情報, 被保番号, 識別コード, 資格得喪情報.getShutokuDate());
        } else if (状態_照会.equals(viewState)) {
            get画面初期の削除照会モードの表示制御();
            set資格詳細情報設定(viewState, 資格得喪情報, 被保番号, 識別コード, 資格得喪情報.getShutokuDate());
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

    private void setドロップダウンリストの設定(RString viewState, ShikakuRirekiJoho 資格得喪情報, ShikibetsuCode 識別コード) {
        get取得事由();
        get被保区分();
        get所在保険者と措置元保険者(viewState, 資格得喪情報, 識別コード);
        表示と非表示();
        get旧保険者(viewState, 資格得喪情報, 識別コード);
        get喪失事由();
    }

    private void get取得事由() {
        List<UzT0007CodeEntity> 取得事由List = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getコード());
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (UzT0007CodeEntity entity : 取得事由List) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().getColumnValue());
            keyValue.setValue(entity.getコード略称());
            keyValueList.add(keyValue);
        }
        panelDiv.getShikakuShosai().getDdlShutokuJiyu().setDataSource(keyValueList);
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

    private void get所在保険者と措置元保険者(RString viewState, ShikakuRirekiJoho 資格得喪情報, ShikibetsuCode 識別コード) {
        List<KeyValueDataSource> 所在保険者List = new ArrayList<>();
        List<KeyValueDataSource> 措置元保険者List = new ArrayList<>();
        if (単一保険者.equals(広域と市町村判断())) {
            if (状態_追加.equals(viewState)) {
                HihokenshaShisaku business = manager.get宛名情報(識別コード);
                RString 所在保険者 = business.getGenLasdecCode().getColumnValue();
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(所在保険者);
                keyValue.setValue(RString.EMPTY);
                所在保険者List.add(keyValue);
                panelDiv.getShikakuShosai().getDdlShutokuShozaiHokensha().setDataSource(所在保険者List);
            } else {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(資格得喪情報.getShozaiHokensha());
                keyValue.setValue(RString.EMPTY);
                所在保険者List.add(keyValue);
                panelDiv.getShikakuShosai().getDdlShutokuShozaiHokensha().setDataSource(所在保険者List);
                KeyValueDataSource keyValue2 = new KeyValueDataSource();
                keyValue2.setKey(資格得喪情報.getSochimotoHokensha());
                keyValue2.setValue(RString.EMPTY);
                措置元保険者List.add(keyValue2);
                panelDiv.getShikakuShosai().getDdlShutokuSochimotoHokensha().setDataSource(措置元保険者List);
            }
        } else if (広域保険者.equals(広域と市町村判断())) {
            List<KoseiShichosonMaster> 所在保険者情報
                    = HihousyosaiFinder.createInstance().getKoseiShichosonMasterList().records();
            for (KoseiShichosonMaster 所在保険者 : 所在保険者情報) {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(所在保険者.getShichosonCode().getColumnValue());
                keyValue.setValue(new RString(所在保険者.getShoKisaiHokenshaNo().getColumnValue() + " " + 所在保険者.getShichosonMeisho()));
                所在保険者List.add(keyValue);
            }
            panelDiv.getShikakuShosai().getDdlShutokuShozaiHokensha().setDataSource(所在保険者List);
            panelDiv.getShikakuShosai().getDdlShutokuSochimotoHokensha().setDataSource(所在保険者List);
        }
    }

    private void get旧保険者(RString viewState, ShikakuRirekiJoho 資格得喪情報, ShikibetsuCode 識別コード) {
        if (!is合併市町村()) {
            if (状態_修正.equals(viewState)) {
                List<KeyValueDataSource> keyValueList = new ArrayList<>();
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(資格得喪情報.getKyuHokensha());
                keyValue.setValue(RString.EMPTY);
                keyValueList.add(keyValue);
                panelDiv.getShikakuShosai().getDdlShutokuKyuHokensha().setDataSource(keyValueList);
            }
        } else {
            if (状態_追加.equals(viewState)) {
                旧保険者情報の設定(所在保険者の取得(識別コード), RString.EMPTY);
            } else {
                旧保険者情報の設定(資格得喪情報.getShozaiHokensha(), 資格得喪情報.getSochimotoHokensha());
            }
        }
    }

    private void 旧保険者情報の設定(RString 所在保険者, RString 措置元保険者) {
        ShichosonSecurityJoho 介護導入形態 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (介護導入形態 != null) {
            DonyuKeitaiCode 導入形態コード = 介護導入形態.get導入形態コード();
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

    private RString 所在保険者の取得(ShikibetsuCode 識別コード) {
        RString 所在保険者 = RString.EMPTY;
        if (単一保険者.equals(広域と市町村判断())) {
            HihokenshaShisaku business = manager.get宛名情報(識別コード);
            所在保険者 = business.getGenLasdecCode().getColumnValue();

        } else if (広域保険者.equals(広域と市町村判断())) {
            KoikiShichosonJohoFinder fider = KoikiShichosonJohoFinder.createInstance();
            List<KoikiZenShichosonJoho> koikiZenShichosonJohoList = fider.koseiShichosonJoho().records();
            if (!koikiZenShichosonJohoList.isEmpty()) {
                所在保険者 = koikiZenShichosonJohoList.get(0).get市町村コード().getColumnValue();
            }
        }
        return 所在保険者;
    }

    private RString 旧保険者の取得() {
        RString 旧保険者 = RString.EMPTY;
        if (is合併市町村()) {
            List<HihokenshaShisaku> 宛名情報List = manager.get宛名情報全て();
            if (!宛名情報List.isEmpty()) {
                旧保険者 = 宛名情報List.get(0).getKyuLasdecCode().getColumnValue();
            }
        }
        return 旧保険者;
    }

    private void get喪失事由() {
        List<UzT0007CodeEntity> 喪失事由List = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getコード());
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (UzT0007CodeEntity entity : 喪失事由List) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().getColumnValue());
            keyValue.setValue(entity.getコード略称());
            keyValueList.add(keyValue);
        }
        panelDiv.getShikakuShosai().getDdlSoshitsuJiyu().setDataSource(keyValueList);
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
        RString 合併市町村 = DbBusinessConfig.get(
                ConfigNameDBU.合併情報管理_合併情報区分,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
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
            RString viewState,
            ShikakuRirekiJoho 資格得喪情報,
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleDate 取得日) {
        set資格得喪情報設定(viewState, 識別コード, 資格得喪情報);
        get住所地特例情報取得(被保険者番号, 識別コード, 取得日);
        get資格変更履歴情報取得(被保険者番号, 識別コード, 取得日);
        get施設入退所情報取得(識別コード);
    }

    private void set資格得喪情報設定(RString viewState, ShikibetsuCode 識別コード, ShikakuRirekiJoho 資格得喪情報) {
        if (状態_追加.equals(viewState)) {
            RString 所在保険者 = 所在保険者の取得(識別コード);
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuShozaiHokensha().setSelectedKey(
                    所在保険者.isEmpty() ? RString.EMPTY : 所在保険者);
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuSochimotoHokensha().setSelectedKey(RString.EMPTY);
            RString 旧保険者 = 旧保険者の取得();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha().setSelectedKey(
                    旧保険者.isEmpty() ? RString.EMPTY : 旧保険者);
        } else {
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
