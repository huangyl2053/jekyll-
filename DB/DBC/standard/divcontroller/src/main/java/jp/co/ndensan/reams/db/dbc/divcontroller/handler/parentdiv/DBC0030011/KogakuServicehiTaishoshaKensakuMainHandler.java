/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuResultEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.JidoShokanTaishoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.TaishoshaKensakuHoho;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuSearch;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.HihokenshaKensakuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.KogakuServicehiTaishoshaKensakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.NengetsuKensakuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.dgKogakuServicehiRireki_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbc.service.core.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaFinder;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.service.core.view.HihokenshaDaichoAliveManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 高額介護サービス費照会（対象者検索）のHandler
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiTaishoshaKensakuMainHandler {

    private final KogakuServicehiTaishoshaKensakuMainDiv div;
    private static final RString 月初 = new RString("01");
    private static final RString 指定R = new RString("指定");
    private static final RString 被保険者名R = new RString("被保険者名");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 提供年月FROMR = new RString("提供年月From");
    private static final RString 提供年月TOR = new RString("提供年月To");
    private static final RString 申請年月FROMR = new RString("申請年月From");
    private static final RString 申請年月TOR = new RString("申請年月To");
    private static final RString 決定年月FROMR = new RString("決定年月From");
    private static final RString 決定年月TOR = new RString("決定年月To");
    private static final RString 提供年月R = new RString("提供年月");
    private static final RString 申請年月R = new RString("申請年月");
    private static final RString 決定年月R = new RString("決定年月");
    private static final int INDEX_ゼロ = 0;
    private static final int INDEX_イチ = 1;
    private static final RString 市町村識別ID_00 = new RString("00");
    private static final RString 市町村コード_000000 = new RString("000000");

    /**
     * 高額介護サービス費照会（対象者検索）のHandlerです。
     *
     * @param div KogakuServicehiTaishoshaKensakuMainDiv
     */
    public KogakuServicehiTaishoshaKensakuMainHandler(KogakuServicehiTaishoshaKensakuMainDiv div) {
        this.div = div;
    }

    /**
     * 条件ラジオーを設定する。
     */
    public void load検索条件エリア() {
        List<KeyValueDataSource> dataSource_被保険者 = new ArrayList<>();
        List<KeyValueDataSource> dataSource_年月 = new ArrayList<>();
        dataSource_被保険者.add(new KeyValueDataSource(
                TaishoshaKensakuHoho.被保険者指定.getコード(), TaishoshaKensakuHoho.被保険者指定.get名称()));
        dataSource_年月.add(new KeyValueDataSource(
                TaishoshaKensakuHoho.年月指定.getコード(), TaishoshaKensakuHoho.年月指定.get名称()));
        div.getKogakuServicehiSearch().getRadHihokenshaShitei().setDataSource(dataSource_被保険者);
        div.getKogakuServicehiSearch().getRadNengetsuShitei().setDataSource(dataSource_年月);
        div.getKogakuServicehiSearch().getRadHihokenshaShitei().setSelectedKey(TaishoshaKensakuHoho.被保険者指定.getコード());
        div.getKogakuServicehiSearch().getRadNengetsuShitei().clearSelectedItem();
        List<dgKogakuServicehiRireki_Row> dataSource = new ArrayList<>();
        div.getKogakuServicehiResult().getDgKogakuServicehiRireki().setDataSource(dataSource);
    }

    /**
     * 該当者検索画面から対象を選択して戻ってきた場合、被保番号と氏名
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @return 対象データなしflag boolean
     */
    public boolean set被保険者名(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        if (識別コード == null || 識別コード.isEmpty()) {
            div.getKogakuServicehiSearch().getHihokenshaShitei().getHihokenshaKensakuJoken().getTxtHihoName().setValue(RString.EMPTY);
            return true;
        }
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList();
        List<JuminJotai> 住民状態List = new ArrayList();
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        住民状態List.add(JuminJotai.住民);
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        builder.set住民種別(住民種別List);
        builder.set住民状態(住民状態List);
        builder.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        builder.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        AtenaMeisho 名称 = KogakuShokaiTaishoshaFinder.createInstance().get氏名(searchKey);
        if (名称 != null && !名称.isEmpty()) {
            div.getKogakuServicehiSearch().getHihokenshaShitei().getHihokenshaKensakuJoken().getTxtHihoName().setValue(名称.getColumnValue());
            return false;
        } else {
            div.getKogakuServicehiSearch().getHihokenshaShitei().getHihokenshaKensakuJoken().getTxtHihoName().setValue(RString.EMPTY);
            return true;
        }
    }

    /**
     * 「被保番号」onBlur事件です。
     *
     * @return 対象データなしflag boolean
     */
    public boolean onBlur_txtHihoNo() {
        RString 被保番号R = div.getKogakuServicehiSearch().getHihokenshaShitei().getHihokenshaKensakuJoken().getTxtHihoNo().getValue();
        if (被保番号R == null || 被保番号R.isEmpty()) {
            div.getKogakuServicehiSearch().getHihokenshaShitei().getHihokenshaKensakuJoken().getTxtHihoName().setValue(RString.EMPTY);
            return true;
        }
        HihokenshaNo 被保険者番号 = new HihokenshaNo(被保番号R);
        HihokenshaDaichoAlive entity = new HihokenshaDaichoAliveManager().get最新の被保険者台帳履歴(被保険者番号);
        if (entity != null) {
            return set被保険者名(被保険者番号, entity.get識別コード());
        } else {
            div.getKogakuServicehiSearch().getHihokenshaShitei().getHihokenshaKensakuJoken().getTxtHihoName().setValue(RString.EMPTY);
            return true;
        }
    }

    /**
     * 「条件をクリアする」ボタンを押下した際に実行します。
     */
    public void click条件をクリアする() {
        HihokenshaKensakuJokenDiv panel指定_被保険者 = div.getKogakuServicehiSearch().getHihokenshaKensakuJoken();
        NengetsuKensakuJokenDiv panel指定_年月 = div.getKogakuServicehiSearch().getNengetsuKensakuJoken();
        panel指定_被保険者.getTxtHihoNo().clearValue();
        panel指定_被保険者.getTxtHihoName().clearValue();
        panel指定_被保険者.getTxtKetteiYMRange().clearFromValue();
        panel指定_被保険者.getTxtKetteiYMRange().clearToValue();
        panel指定_被保険者.getTxtShinseiYMRange().clearFromValue();
        panel指定_被保険者.getTxtShinseiYMRange().clearToValue();
        panel指定_被保険者.getTxtTeikyoYMRange().clearFromValue();
        panel指定_被保険者.getTxtTeikyoYMRange().clearToValue();
        panel指定_年月.getTxtKetteiYM().clearValue();
        panel指定_年月.getTxtShinseiYM().clearValue();
        panel指定_年月.getTxtTeikyoYM().clearValue();
        div.getKogakuServicehiSearch().getRadHihokenshaShitei().setSelectedIndex(INDEX_ゼロ);
        div.getKogakuServicehiSearch().getRadNengetsuShitei().clearSelectedItem();
        panel指定_年月.setDisabled(true);
        panel指定_被保険者.setDisabled(false);
    }

    /**
     * 検索処理、対象者一覧（パネル）初期化する。
     *
     * @param メニューID RString
     * @return 該当者一覧キー KogakuServiceData
     */
    public KogakuServiceData load該当者一覧情報(RString メニューID) {
        KogakuShokaiTaishoshaKensakuSearch searchCondition;
        if (div.getKogakuServicehiSearch().getRadNengetsuShitei().getSelectedIndex() < INDEX_ゼロ) {
            HihokenshaKensakuJokenDiv panel指定_被保険者 = div.getKogakuServicehiSearch().getHihokenshaKensakuJoken();
            RString 被保険者番号 = panel指定_被保険者.getTxtHihoNo().getValue();
            RDate 提供年月From = panel指定_被保険者.getTxtTeikyoYMRange().getFromValue();
            RDate 提供年月To = panel指定_被保険者.getTxtTeikyoYMRange().getToValue();
            RDate 申請年月From = panel指定_被保険者.getTxtShinseiYMRange().getFromValue();
            RDate 申請年月To = panel指定_被保険者.getTxtShinseiYMRange().getToValue();
            RDate 決定年月From = panel指定_被保険者.getTxtKetteiYMRange().getFromValue();
            RDate 決定年月To = panel指定_被保険者.getTxtKetteiYMRange().getToValue();
            searchCondition = getパラメータ(メニューID, 被保険者番号,
                    提供年月From, 提供年月To, 申請年月From, 申請年月To, 決定年月From, 決定年月To);
        } else {
            NengetsuKensakuJokenDiv panel指定_年月 = div.getKogakuServicehiSearch().getNengetsuKensakuJoken();
            RDate 提供年月 = panel指定_年月.getTxtTeikyoYM().getValue();
            RDate 申請年月 = panel指定_年月.getTxtShinseiYM().getValue();
            RDate 決定年月 = panel指定_年月.getTxtKetteiYM().getValue();
            searchCondition = getパラメータ(メニューID, RString.EMPTY, 提供年月, 提供年月, 申請年月, 申請年月, 決定年月, 決定年月);
        }
        return 検索(searchCondition);
    }

    /**
     * 検索処理、対象者一覧（パネル）初期化する。
     *
     * @param searchCondition KogakuShokaiTaishoshaFinderSearch
     * @return 該当者一覧キー KogakuServiceData
     */
    public KogakuServiceData 検索(KogakuShokaiTaishoshaKensakuSearch searchCondition) {
        List<KogakuShokaiTaishoshaKensakuResultEntity> 該当者一覧情報
                = KogakuShokaiTaishoshaFinder.createInstance().selectTaishosha(searchCondition);
        if (該当者一覧情報 == null || 該当者一覧情報.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage().evaluate());
        } else if (該当者一覧情報.size() == INDEX_イチ) {
            List<dgKogakuServicehiRireki_Row> dataSource = new ArrayList<>();
            dgKogakuServicehiRireki_Row row = setRow(該当者一覧情報.get(0));
            dataSource.add(row);
            div.getKogakuServicehiResult().getDgKogakuServicehiRireki().setDataSource(dataSource);
            return set該当者一覧キー(row);
        } else {
            List<dgKogakuServicehiRireki_Row> dataSource = new ArrayList<>();
            for (KogakuShokaiTaishoshaKensakuResultEntity entity : 該当者一覧情報) {
                dgKogakuServicehiRireki_Row row = setRow(entity);
                dataSource.add(row);
            }
            div.getKogakuServicehiResult().getDgKogakuServicehiRireki().setDataSource(dataSource);
            return null;
        }
    }

    /**
     * パラメータを作成する。
     *
     * @param メニューID RString
     * @param 被保険者番号 RString
     * @param 提供年月From RDate
     * @param 提供年月To RDate
     * @param 申請年月From RDate
     * @param 申請年月To RDate
     * @param 決定年月From RDate
     * @param 決定年月To RDate
     * @return searchパラメータ KogakuShokaiTaishoshaFinderSearch
     */
    public KogakuShokaiTaishoshaKensakuSearch getパラメータ(RString メニューID, RString 被保険者番号,
            RDate 提供年月From, RDate 提供年月To, RDate 申請年月From, RDate 申請年月To, RDate 決定年月From, RDate 決定年月To) {
        KogakuShokaiTaishoshaKensakuSearch searchCondition = new KogakuShokaiTaishoshaKensakuSearch();
        LasdecCode 市町村コード;
        KoseiShichosonJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get市町村情報();
        if (市町村識別ID_00.equals(市町村セキュリティ情報.get市町村識別ID())) {
            市町村コード = new LasdecCode(市町村コード_000000);
        } else {
            市町村コード = 市町村セキュリティ情報.get市町村コード();
        }
        searchCondition.set市町村コード(市町村コード);
        searchCondition.setメニューID(メニューID);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            searchCondition.set被保険者番号(new HihokenshaNo(被保険者番号));
        }
        if (提供年月From != null) {
            searchCondition.set提供年月From(new FlexibleYearMonth(提供年月From.getYearMonth().toString()));
        }
        if (提供年月To != null) {
            searchCondition.set提供年月To(new FlexibleYearMonth(提供年月To.getYearMonth().toString()));
        }
        if (申請年月From != null) {
            searchCondition.set申請年月From(new FlexibleDate(申請年月From.getYearMonth().toString().concat(月初.toString())));
        }
        if (申請年月To != null) {
            searchCondition.set申請年月To(new FlexibleDate(申請年月To.getYearMonth().toString()
                    .concat(String.valueOf(申請年月To.getYearMonth().getLastDay()))));
        }
        if (決定年月From != null) {
            searchCondition.set決定年月From(new FlexibleDate(決定年月From.getYearMonth().toString().concat(月初.toString())));
        }
        if (決定年月To != null) {
            searchCondition.set決定年月To(new FlexibleDate(決定年月To.getYearMonth().toString()
                    .concat(String.valueOf(決定年月To.getYearMonth().getLastDay()))));
        }
        return searchCondition;
    }

    /**
     * データグリッドの「選択」ボタンを押下した際に実行します。
     *
     * @return 該当者一覧キー KogakuServiceData
     */
    public KogakuServiceData onClick_選択() {
        dgKogakuServicehiRireki_Row row = div.getKogakuServicehiResult().getDgKogakuServicehiRireki().getClickedItem();
        return set該当者一覧キー(row);
    }

    /**
     * 検索条件エリアの検索条件のonChange事件です。
     */
    public void onChange検索条件エリア() {
        if (div.getKogakuServicehiSearch().getRadHihokenshaShitei().getSelectedIndex() < INDEX_ゼロ) {
            div.getKogakuServicehiSearch().getNengetsuKensakuJoken().setDisabled(false);
            div.getKogakuServicehiSearch().getHihokenshaKensakuJoken().setDisabled(true);
        } else {
            div.getKogakuServicehiSearch().getNengetsuKensakuJoken().setDisabled(true);
            div.getKogakuServicehiSearch().getHihokenshaKensakuJoken().setDisabled(false);
        }
    }

    /**
     * 検索条件エリアのRString内容をを返しする。
     *
     * @return 検索条件エリアの内容 Mapper<RString, RString>
     */
    public Map<RString, RString> get検索条件エリアRStr() {
        Map<RString, RString> map = new HashMap<>();
        if (div.getKogakuServicehiSearch().getRadHihokenshaShitei().getSelectedIndex() < 0) {
            map.put(指定R, TaishoshaKensakuHoho.年月指定.getコード());
        } else {
            map.put(指定R, TaishoshaKensakuHoho.被保険者指定.getコード());
        }
        map.put(被保険者名R, div.getKogakuServicehiSearch().getHihokenshaKensakuJoken().getTxtHihoName().getValue());
        map.put(被保険者番号R, div.getKogakuServicehiSearch().getHihokenshaKensakuJoken().getTxtHihoNo().getValue());
        return map;
    }

    /**
     * 検索条件エリアのRDate内容をを返しする。
     *
     * @return 検索条件エリアの内容 Mapper<RString, RString>
     */
    public Map<RString, RDate> get検索条件エリアRDate() {
        Map<RString, RDate> map = new HashMap<>();
        HihokenshaKensakuJokenDiv panel指定_被保険者 = div.getKogakuServicehiSearch().getHihokenshaKensakuJoken();
        NengetsuKensakuJokenDiv panel指定_年月 = div.getKogakuServicehiSearch().getNengetsuKensakuJoken();
        map.put(提供年月FROMR, panel指定_被保険者.getTxtTeikyoYMRange().getFromValue());
        map.put(提供年月TOR, panel指定_被保険者.getTxtTeikyoYMRange().getToValue());
        map.put(申請年月FROMR, panel指定_被保険者.getTxtShinseiYMRange().getFromValue());
        map.put(申請年月TOR, panel指定_被保険者.getTxtShinseiYMRange().getToValue());
        map.put(決定年月FROMR, panel指定_被保険者.getTxtKetteiYMRange().getFromValue());
        map.put(決定年月TOR, panel指定_被保険者.getTxtKetteiYMRange().getToValue());
        map.put(提供年月R, panel指定_年月.getTxtTeikyoYM().getValue());
        map.put(申請年月R, panel指定_年月.getTxtShinseiYM().getValue());
        map.put(決定年月R, panel指定_年月.getTxtKetteiYM().getValue());
        return map;
    }

    /**
     * 検索条件を復活する。
     *
     * @param 指定 RString
     * @param 被保険者番号 RString
     * @param 被保険者名 RString
     * @param 提供年月From RDate
     * @param 提供年月To RDate
     * @param 申請年月From RDate
     * @param 申請年月To RDate
     * @param 決定年月From RDate
     * @param 決定年月To RDate
     * @param 提供年月 RDate
     * @param 申請年月 RDate
     * @param 決定年月 RDate
     */
    public void set検索条件(RString 指定, RString 被保険者番号, RString 被保険者名, RDate 提供年月From, RDate 提供年月To,
            RDate 申請年月From, RDate 申請年月To, RDate 決定年月From, RDate 決定年月To, RDate 提供年月, RDate 申請年月, RDate 決定年月) {
        HihokenshaKensakuJokenDiv panel指定_被保険者 = div.getKogakuServicehiSearch().getHihokenshaKensakuJoken();
        NengetsuKensakuJokenDiv panel指定_年月 = div.getKogakuServicehiSearch().getNengetsuKensakuJoken();
        RString 指定_被保険者 = TaishoshaKensakuHoho.被保険者指定.getコード();
        panel指定_被保険者.getTxtHihoNo().setValue(被保険者番号);
        panel指定_被保険者.getTxtHihoName().setValue(被保険者名);
        panel指定_被保険者.getTxtTeikyoYMRange().setFromValue(提供年月From);
        panel指定_被保険者.getTxtTeikyoYMRange().setToValue(提供年月To);
        panel指定_被保険者.getTxtShinseiYMRange().setFromValue(申請年月From);
        panel指定_被保険者.getTxtShinseiYMRange().setToValue(申請年月To);
        panel指定_被保険者.getTxtKetteiYMRange().setFromValue(決定年月From);
        panel指定_被保険者.getTxtKetteiYMRange().setToValue(決定年月To);
        panel指定_年月.getTxtTeikyoYM().setValue(提供年月);
        panel指定_年月.getTxtShinseiYM().setValue(申請年月);
        panel指定_年月.getTxtKetteiYM().setValue(決定年月);
        if (指定_被保険者.equals(指定)) {
            div.getKogakuServicehiSearch().getRadNengetsuShitei().clearSelectedItem();
            div.getKogakuServicehiSearch().getRadHihokenshaShitei().setSelectedIndex(INDEX_ゼロ);
            panel指定_被保険者.setDisabled(false);
            panel指定_年月.setDisabled(true);
        } else {
            div.getKogakuServicehiSearch().getRadHihokenshaShitei().clearSelectedItem();
            div.getKogakuServicehiSearch().getRadNengetsuShitei().setSelectedIndex(INDEX_ゼロ);
            panel指定_年月.setDisabled(false);
            panel指定_被保険者.setDisabled(true);
        }
    }

    /**
     * 「再検索する」ボタンを押下した、高額介護サービス費一覧エリアをクリア。
     */
    public void clear一覧エリア() {
        List<dgKogakuServicehiRireki_Row> dataSource = new ArrayList<>();
        div.getKogakuServicehiResult().getDgKogakuServicehiRireki().setDataSource(dataSource);
    }

    private KogakuServiceData set該当者一覧キー(dgKogakuServicehiRireki_Row row) {
        KogakuServiceData 該当者一覧キー = new KogakuServiceData();
        RString 被保険者番号 = row.getTxtHihoNo();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            該当者一覧キー.set被保険者番号(new HihokenshaNo(被保険者番号));
        } else {
            該当者一覧キー.set被保険者番号(HihokenshaNo.EMPTY);
        }
        RDate サービス提供年月 = row.getTxtTeikyoYM().getValue();
        if (サービス提供年月 != null) {
            該当者一覧キー.setサービス提供年月(new FlexibleYearMonth(サービス提供年月.getYearMonth().toString()));
        } else {
            該当者一覧キー.setサービス提供年月(FlexibleYearMonth.EMPTY);
        }
        RString 履歴番号 = row.getTxtRirekiNo();
        if (履歴番号 != null && !履歴番号.isEmpty()) {
            該当者一覧キー.set履歴番号(new Decimal(履歴番号.toString()));
        } else {
            該当者一覧キー.set履歴番号(null);
        }
        RString 証記載保険者番号 = row.getTxtHdnShoHokensha();
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            該当者一覧キー.set証記載保険者番号(new HokenshaNo(証記載保険者番号));
        } else {
            該当者一覧キー.set証記載保険者番号(HokenshaNo.EMPTY);
        }
        RString 識別コード = row.getTxtHdnShikibetsuCode();
        if (識別コード != null && !識別コード.isEmpty()) {
            該当者一覧キー.set識別コード(new ShikibetsuCode(識別コード));
        } else {
            該当者一覧キー.set識別コード(ShikibetsuCode.EMPTY);
        }
        return 該当者一覧キー;
    }

    private dgKogakuServicehiRireki_Row setRow(KogakuShokaiTaishoshaKensakuResultEntity entity) {
        dgKogakuServicehiRireki_Row row = new dgKogakuServicehiRireki_Row();
        HihokenshaNo 被保険者番号 = entity.get被保険者番号();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            row.setTxtHihoNo(被保険者番号.getColumnValue());
        }
        AtenaMeisho 申請者氏名 = entity.get識別対象().get名称() == null ? AtenaMeisho.EMPTY : entity.get識別対象().get名称().getName();
        if (申請者氏名 != null && !申請者氏名.isEmpty()) {
            row.setTxtHihoName(申請者氏名.getColumnValue());
        }
        FlexibleYearMonth サービス提供年月 = entity.getサービス提供年月();
        if (サービス提供年月 != null && !サービス提供年月.isEmpty()) {
            row.getTxtTeikyoYM().setValue(new RDate(サービス提供年月.toString()));
        }
        row.getTxtKogakuShikyuAmount().setValue(entity.get高額支給額());
        FlexibleDate 申請日 = entity.get申請年月日();
        if (申請日 != null && !申請日.isEmpty()) {
            row.getTxtShinseiDate().setValue(new RDate(申請日.toString()));
        }
        FlexibleDate 決定日 = entity.get決定年月日();
        if (決定日 != null && !決定日.isEmpty()) {
            row.getTxtKetteiDate().setValue(new RDate(決定日.toString()));
        }
        RString 支給区分コード = entity.get支給区分コード();
        if (支給区分コード != null && !支給区分コード.isEmpty()) {
            row.setTxtShikyuKubun(ShikyuKubun.toValue(支給区分コード).get名称());
        }
        row.getTxtShikyuKingaku().setValue(entity.get支給金額());
        if (entity.is自動償還対象フラグ()) {
            row.setTxtKogakuJidoShokan(JidoShokanTaishoKubun.あり.get名称());
        } else {
            row.setTxtKogakuJidoShokan(JidoShokanTaishoKubun.なし.get名称());
        }
        Decimal 履歴番号 = entity.get履歴番号();
        if (履歴番号 != null) {
            row.setTxtRirekiNo(new RString(履歴番号.toString()));
        }
        return setRow(entity, row);
    }

    private dgKogakuServicehiRireki_Row setRow(KogakuShokaiTaishoshaKensakuResultEntity entity, dgKogakuServicehiRireki_Row row) {
        HokenshaNo 証記載保険者番号 = entity.get証記載保険者番号();
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            row.setTxtHdnShoHokensha(証記載保険者番号.getColumnValue());
        }
        ShikibetsuCode 識別コード = entity.get識別対象().get識別コード();
        if (識別コード != null && !識別コード.isEmpty()) {
            row.setTxtHdnShikibetsuCode(識別コード.getColumnValue());
        }
        return row;
    }

}
