/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD0530011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.KokiKoreishaInfo;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD0530011.KokiKoreishaDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsuType;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaSearchItem;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.IHokenjaManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.INewSearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.StringOperator;

/**
 * 後期資格情報登録Handler
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public class KokiKoreishaHandler {

    private final KokiKoreishaDiv div;
    private static final RString コード = new RString("2");
    private static final RString コード111 = new RString("111");
    private static final RString コード112 = new RString("112");
    private static final RString コード120 = new RString("120");
    private static final RString 単一市町村 = new RString("1");
    private static final RString 広域市町村 = new RString("2");
    private static final RString 広域保険者 = new RString("3");

    /**
     * 生成されたインタフェースを返します
     *
     * @param div 画面DIV
     */
    public KokiKoreishaHandler(KokiKoreishaDiv div) {
        this.div = div;
    }

    /**
     * 初期化
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 後期高齢者情報 KokiKoreishaInfo
     */
    public void onLoad(ShikibetsuCode shikibetsuCode, HihokenshaNo 被保険者番号, KokiKoreishaInfo 後期高齢者情報) {
        LockingKey 排他キー = new LockingKey(new RString("DBCHihokenshaNo").concat(被保険者番号.getColumnValue()));
        RealInitialLocker.lock(排他キー);
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        IHokenjaManager iHokenjaManager = HokenjaManagerFactory.createInstance();
        INewSearchCondition 検索条件 = SearchConditionFactory.condition(
                HokenjaSearchItem.保険者種別, StringOperator.完全一致, HokenjaShubetsuType.後期高齢.code());
        List<Hokenja> hokenja = iHokenjaManager.get保険者一覧(検索条件);
        RString 介護導入形態 = shichosonSecurityJoho.get導入形態コード().value();
        if (介護導入形態.equals(コード111)) {
            介護導入形態 = 広域保険者;
        }
        if (介護導入形態.equals(コード112)) {
            介護導入形態 = 広域市町村;
        }
        if (介護導入形態.equals(コード120)) {
            介護導入形態 = 単一市町村;
        }
        div.getHeaderPanel().getCcdAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        div.getHeaderPanel().getCcdAtenaInfo().setShoriType(コード);
        div.getHeaderPanel().getCcdAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, shikibetsuCode);
        div.getHeaderPanel().getCcdAtenaInfo().initialize();
        div.getHeaderPanel().getCcdShikakuInfo().initialize(shichosonSecurityJoho.get市町村情報().get市町村コード().value(), 被保険者番号.value());
        set資格取得事由();
        set資格喪失事由();
        set保険者番号(hokenja);
        if (後期高齢者情報 != null) {
            div.getMeisaiPanel().getTxtRirekiNo().setValue(後期高齢者情報.get履歴番号());
            if (後期高齢者情報.get後期高齢保険者番号_市町村() != null && !後期高齢者情報.get後期高齢保険者番号_市町村().isEmpty()) {
                div.getMeisaiPanel().getDdlHokenshaNo().setSelectedKey(後期高齢者情報.get後期高齢保険者番号_市町村());
            }
            if (後期高齢者情報.get後期高齢被保険者番号() != null) {
                div.getMeisaiPanel().getTxtHihokenshaNo().setValue(後期高齢者情報.get後期高齢被保険者番号());
            }
            if (後期高齢者情報.get資格取得日() != null) {
                div.getMeisaiPanel().getTxtShikakuShutokuYMD().setValue(new RDate(後期高齢者情報.get資格取得日().toString()));
            }

            if (後期高齢者情報.get資格喪失日() != null) {
                div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().setValue(new RDate(後期高齢者情報.get資格喪失日().toString()));
            }
            if (後期高齢者情報.get登録区分().equals(new RString("1"))) {
                List<RString> keys = new ArrayList<>();
                keys.add(new RString("key0"));
                div.getMeisaiPanel().getChkTorokuKubun().setSelectedItemsByKey(keys);
            }
            if (後期高齢者情報.get保険者適用開始日() != null && !後期高齢者情報.get保険者適用開始日().isEmpty()) {
                div.getMeisaiPanel().getTxtHokenshaKaishiYMD().setValue(new RDate(後期高齢者情報.get保険者適用開始日().toString()));
            }
            if (後期高齢者情報.get保険者適用終了日() != null && !後期高齢者情報.get保険者適用終了日().isEmpty()) {
                div.getMeisaiPanel().getTxtHokenshaShuryoYMD().setValue(new RDate(後期高齢者情報.get保険者適用終了日().toString()));
            }
            if (後期高齢者情報.get資格取得事由コード() != null && !後期高齢者情報.get資格取得事由コード().isEmpty()) {
                div.getMeisaiPanel().getDdlShikakuShutokuJiyu().setSelectedKey(後期高齢者情報.get資格取得事由コード());
            }
            if (後期高齢者情報.get資格喪失事由コード() != null) {
                div.getMeisaiPanel().getDdlShikakuSoshitsuJiyu().setSelectedKey(後期高齢者情報.get資格喪失事由コード());
            }
            if (後期高齢者情報.get個人区分コード() != null) {
                div.getMeisaiPanel().getDdlKojinKubunCode().setSelectedKey(後期高齢者情報.get個人区分コード());
            }
        }
        setVisible();
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        AccessLogger.log(AccessLogType.照会, PersonalData.of(shikibetsuCode, expandedInfo));
    }

    /**
     * 前排他キーの解除
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void 前排他キーの解除(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(new RString("DBCHihokenshaNo").concat(被保険者番号.getColumnValue()));
        RealInitialLocker.release(new LockingKey(排他キー));
    }

    private void set資格取得事由() {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        for (ShikakuShutokuJiyu code : ShikakuShutokuJiyu.values()) {
            dataSources.add(get資格取得事由(code));
        }
        div.getMeisaiPanel().getDdlShikakuShutokuJiyu().setDataSource(dataSources);
    }

    private void set保険者番号(List<Hokenja> hokenja) {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        for (Hokenja 保険者番号 : hokenja) {
            KeyValueDataSource keyValue = new KeyValueDataSource(保険者番号.get保険者番号().value(),
                    保険者番号.get保険者番号().value().concat(RString.HALF_SPACE).concat(保険者番号.get保険者名()));
            dataSources.add(keyValue);
        }
        div.getMeisaiPanel().getDdlHokenshaNo().setDataSource(dataSources);
    }

    private void set資格喪失事由() {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        dataSources.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ShikakuSoshitsuJiyu code : ShikakuSoshitsuJiyu.values()) {
            if (!code.get名称().isEmpty()) {
                dataSources.add(get資格喪失事由(code));
            }
        }
        div.getMeisaiPanel().getDdlShikakuSoshitsuJiyu().setDataSource(dataSources);
    }

    private KeyValueDataSource get資格取得事由(ShikakuShutokuJiyu 資格取得事由) {
        return new KeyValueDataSource(資格取得事由.getコード(), 資格取得事由.get名称());
    }

    private KeyValueDataSource get資格喪失事由(ShikakuSoshitsuJiyu 資格喪失事由) {
        return new KeyValueDataSource(資格喪失事由.getコード(), 資格喪失事由.get名称());
    }

    private void setVisible() {
        if (!DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期ＩＦ種類, RDate.getNowDate(), SubGyomuCode.DBC介護給付).
                equals(コード)) {
            div.getMeisaiPanel().getTxtHokenshaKaishiYMD().setVisible(false);
            div.getMeisaiPanel().getTxtHokenshaShuryoYMD().setVisible(false);
            div.getMeisaiPanel().getDdlShikakuShutokuJiyu().setVisible(false);
            div.getMeisaiPanel().getDdlShikakuSoshitsuJiyu().setVisible(false);
            div.getMeisaiPanel().getDdlKojinKubunCode().setVisible(false);
        }
    }
}
