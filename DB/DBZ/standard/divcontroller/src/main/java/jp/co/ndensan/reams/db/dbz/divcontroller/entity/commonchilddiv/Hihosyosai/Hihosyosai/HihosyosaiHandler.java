/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.Hihosyosai.Hihosyosai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.hihousyosai.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.shichoson.Shichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.dgJutoku_Row;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.hihousyosai.HihousyosaiFinder;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保詳細のHandlerクラスです。
 *
 * @reamsid_L DBA-0170-010 linghuhang
 */
public class HihosyosaiHandler {

    private final RString 合併情報区分 = new RString("1");
    private final RString 広域保険者 = new RString("1");
    private final RString 単一保険者 = new RString("2");
    private final HihosyosaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HihosyosaiDiv
     */
    public HihosyosaiHandler(HihosyosaiDiv div) {
        this.div = div;
    }

    /**
     * 被保詳細に初期化を設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 導入形態コード 導入形態コード
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @param 識別コード 識別コード
     * @param 資格取得日 資格取得日
     * @param 台帳種別 台帳種別
     */
    public void initialize(LasdecCode 市町村コード, RString 導入形態コード, LasdecCode 広住特措置元市町村コード,
            HihokenshaNo 被保険者番号, FlexibleDate 異動日, RString 枝番, ShikibetsuCode 識別コード, FlexibleDate 資格取得日,
            RString 台帳種別) {
        if (被保険者番号 == null || 被保険者番号.isEmpty() || 識別コード == null || 識別コード.isEmpty() || 資格取得日 == null || 資格取得日.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (市町村コード != null && !市町村コード.isEmpty()) {
            div.setHiddenShichosonCode(市町村コード.getColumnValue());
        }
        div.setHiddenDonyuKeitaiCode(導入形態コード);
        List<KeyValueDataSource> 被保区分情報
                = HihousyosaiFinder.createInstance().getHihokubunList().records();
        div.getDdlSyozaiHokensya().setDataSource(get所在保険者());
        div.getDdlSotimotoHokensya().setDataSource(get所在保険者());
        div.getDdlSyutokuJiyu().setDataSource(get取得事由());
        div.getDdlHihokubun().setDataSource(被保区分情報);
        div.getDdlSosichiJiyu().setDataSource(get喪失事由());
        表示と非表示();
        switch (div.getMode_DisplayType()) {
            case shokai:
                div.getDdlKyuHokensya().setDataSource(get旧保険者(市町村コード, 導入形態コード, 広住特措置元市町村コード));
                訂正モード(get得喪情報(被保険者番号, 異動日, 枝番));
                break;
            case toroku:
                登録モード(識別コード);
                break;
            case teiseitoroku_jyusyoti:
                div.getDdlKyuHokensya().setDataSource(get旧保険者(市町村コード, 導入形態コード, 広住特措置元市町村コード));
                訂正モード(get得喪情報(被保険者番号, 異動日, 枝番));
                break;
            case teiseitoroku_shikaku:
                div.getTabContainerDetail().setSelectedItem(div.getTabPnlShikaku());
                div.getDdlKyuHokensya().setDataSource(get旧保険者(市町村コード, 導入形態コード, 広住特措置元市町村コード));
                訂正モード(get得喪情報(被保険者番号, 異動日, 枝番));
                break;
            default:
                break;
        }
        div.getCcdJyusyotiTokure().initialize(被保険者番号, 識別コード, 資格取得日);
        div.getCcdShikakuKanrenIdo().initialize(被保険者番号, 識別コード, 資格取得日);
        if (RString.isNullOrEmpty(台帳種別)) {
            div.getCcdShisetuNyutaisyo().initialize(識別コード);
        } else {
            div.getCcdShisetuNyutaisyo().initialize(識別コード, 台帳種別);
        }
    }

    /**
     * 親画面資格変更異動する、被保詳細に初期化を設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 導入形態コード 導入形態コード
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @param 識別コード 識別コード
     * @param 資格取得日 資格取得日
     * @param 台帳種別 台帳種別
     */
    public void initilize(LasdecCode 市町村コード, RString 導入形態コード, LasdecCode 広住特措置元市町村コード,
            HihokenshaNo 被保険者番号, FlexibleDate 異動日, RString 枝番, ShikibetsuCode 識別コード, FlexibleDate 資格取得日, RString 台帳種別) {
        if (被保険者番号 == null || 被保険者番号.isEmpty() || 識別コード == null || 識別コード.isEmpty() || 資格取得日 == null || 資格取得日.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (市町村コード != null && !市町村コード.isEmpty()) {
            div.setHiddenShichosonCode(市町村コード.getColumnValue());
        }
        div.setHiddenDonyuKeitaiCode(導入形態コード);
        List<KeyValueDataSource> 被保区分情報
                = HihousyosaiFinder.createInstance().getHihokubunList().records();
        div.getDdlSyozaiHokensya().setDataSource(get所在保険者());
        div.getDdlSotimotoHokensya().setDataSource(get所在保険者());
        div.getDdlSyutokuJiyu().setDataSource(get取得事由());
        div.getDdlHihokubun().setDataSource(被保区分情報);
        div.getDdlSosichiJiyu().setDataSource(get喪失事由());
        表示と非表示();
        div.getDdlKyuHokensya().setDataSource(get旧保険者(市町村コード, 導入形態コード, 広住特措置元市町村コード));
        HihokenshaDaicho 得喪情報 = get得喪情報(被保険者番号, 異動日, 枝番);
        訂正モード(得喪情報);
        if (得喪情報.getShikakuSoshitsuYMD() != null && !得喪情報.getShikakuSoshitsuYMD().isEmpty()) {
            div.setDisabled(true);
        }
        div.getTabContainerDetail().setSelectedItem(div.getTabPnlShikaku());
        div.getCcdJyusyotiTokure().initialize(被保険者番号, 識別コード, 資格取得日);
        div.getCcdShikakuKanrenIdo().initialize(被保険者番号, 識別コード, 資格取得日);
        if (RString.isNullOrEmpty(台帳種別)) {
            div.getCcdShisetuNyutaisyo().initialize(識別コード);
        } else {
            div.getCcdShisetuNyutaisyo().initialize(識別コード, 台帳種別);
        }
    }

    /**
     * 所在保険者部品連動処理します。
     */
    public void onClick_Change() {
        LasdecCode 市町村コード = new LasdecCode(div.getHiddenShichosonCode());
        RString 導入形態コード = div.getHiddenDonyuKeitaiCode();
        if (広域保険者.equals(広域と市町村判断())) {
            RString 措置元保険者 = div.getDdlSotimotoHokensya().getSelectedKey();
            if (!RString.isNullOrEmpty(広域保険者)) {
                div.getDdlKyuHokensya().setDataSource(get旧保険者(市町村コード, 導入形態コード, new LasdecCode(措置元保険者)));
            }
        }
    }

    /**
     * 変更事由DDLを設定します。
     *
     * @param key 変更事由key
     * @param falg 活性フラグ
     */
    public void setDdlHenkoJiyu(RString key, boolean falg) {
        div.getCcdShikakuKanrenIdo().setDdlHenkoJiyu(key, falg);
    }

    /**
     * 施設入退所の保存処理する。
     */
    public void 施設入退所保存処理() {
        div.getCcdShisetuNyutaisyo().saveShisetsuNyutaisho();
    }

    /**
     * 住所地特例履歴情報を取得します。
     *
     * @return 住所地特例履歴情報 住所地特例履歴情報
     */
    public SearchResult<jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho> 住所地特例履歴情報取得() {
        List<dgJutoku_Row> dgJutokuList = div.getCcdJyusyotiTokure().getDgJutoku().getDataSource();
        List<jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho> returnList = new ArrayList<>();
        for (dgJutoku_Row row : dgJutokuList) {
            DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
            if (!RString.isNullOrEmpty(row.getState())) {
                entity.setJushochitokureiKaijoJiyuCode(row.getKaijoJiyuKey() == null ? RString.EMPTY : row.getKaijoJiyuKey());
                entity.setJushochitokureiKaijoTodokedeYMD(row.getKaijoTodokedeDate().getValue());
                entity.setJushochitokureiKaijoYMD(row.getKaijoDate().getValue());
                entity.setJushochitokureiTekiyoJiyuCode(row.getTekiyoJiyuKey() == null ? RString.EMPTY : row.getTekiyoJiyuKey());
                entity.setJushochitokureiTekiyoTodokedeYMD(row.getTekiyoTodokedeDate().getValue());
                entity.setJushochitokureiTekiyoYMD(row.getTekiyoDate().getValue());
                jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho hihokenshaDaicho
                        = new jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho(entity);
                returnList.add(hihokenshaDaicho);
            }
        }
        return SearchResult.of(returnList, 0, false);
    }

    /**
     * 資格関連異動一覧を取得します。
     *
     * @return 資格関連異動一覧 資格関連異動一覧
     */
    public SearchResult<jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho> 資格関連異動一覧取得() {
        return div.getCcdShikakuKanrenIdo().getGridData();
    }

    /**
     * 取得日と喪失日のチックを実施する。
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtSyutokuYMD() != null && div.getTxtSosichiYMD() != null
                && div.getTxtSosichiYMD().getValue().isBefore(div.getTxtSyutokuYMD().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new RRVMessages(UrErrorMessages.期間が不正_追加メッセージあり２,
                    "取得日（入力した値）", "喪失日（入力した値）"),
                    div.getTxtSyutokuYMD(), div.getTxtSosichiYMD()));
        }
        return validPairs;
    }

    private void 訂正モード(HihokenshaDaicho 得喪情報) {
        div.getTxtSyutokuYMD().setValue(new RDate(得喪情報.getShikakuShutokuYMD().toString()));
        div.getTxtSyutokutodokedeYMD().setValue(new RDate(得喪情報.getShikakuShutokuTodokedeYMD().toString()));
        set取得事由(得喪情報.getShikakuShutokuJiyuCode());
        set被保区分(得喪情報.getHihokennshaKubunCode());
        set所在保険者(得喪情報.getShichosonCode().getColumnValue());
        set措置元保険者(得喪情報.getKoikinaiTokureiSochimotoShichosonCode().getColumnValue());
        set旧保険者(得喪情報.getKyuShichosonCode().getColumnValue());
        div.getTxtSyoninichiji1().setValue(日期(得喪情報.getLastUpdateTimestamp()));
        if (得喪情報.getShikakuSoshitsuYMD() != null && !得喪情報.getShikakuSoshitsuYMD().isEmpty()) {
            div.getTxtSosichiYMD().setValue(new RDate(得喪情報.getShikakuSoshitsuYMD().toString()));
            div.getTxtSyoninichiji2().setValue(日期(得喪情報.getLastUpdateTimestamp()));
        } else {
            div.getTxtSosichiYMD().setDisabled(true);
        }
        if (得喪情報.getShikakuSoshitsuTodokedeYMD() != null
                && !得喪情報.getShikakuSoshitsuTodokedeYMD().isEmpty()) {
            div.getTxtSosichiTodokedeYMD().setValue(new RDate(得喪情報.getShikakuSoshitsuTodokedeYMD().toString()));
        } else {
            div.getTxtSosichiTodokedeYMD().setDisabled(true);
        }
        if (!RString.isNullOrEmpty(得喪情報.getShikakuSoshitsuJiyuCode())) {
            set喪失事由(得喪情報.getShikakuSoshitsuJiyuCode());
        } else {
            div.getDdlSosichiJiyu().setDisabled(true);
        }
    }

    private void 登録モード(ShikibetsuCode 識別コード) {
        LasdecCode 旧地方公共団体コード = LasdecCode.EMPTY;
        LasdecCode 現地方公共団体コード = LasdecCode.EMPTY;
        IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoSearchKey 検索キー
                = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true)
                .set識別コード(識別コード)
                .build();
        IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(検索キー);
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSM = InstanceProvider.create(UaFt200FindShikibetsuTaishoFunctionDac.class).select(psm);
        if (宛名PSM != null && !宛名PSM.isEmpty()) {
            旧地方公共団体コード = 宛名PSM.get(0).getKyuLasdecCode();
            現地方公共団体コード = 宛名PSM.get(0).getGenLasdecCode();
        }
        List<KoikiZenShichosonJoho> 市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
        LasdecCode 市町村コード = LasdecCode.EMPTY;
        if (市町村情報 != null && !市町村情報.isEmpty()) {
            市町村コード = 市町村情報.get(0).get市町村コード();
        }
        if (単一保険者.equals(広域と市町村判断())) {
            List<KeyValueDataSource> keyValueList = new ArrayList<>();
            if (現地方公共団体コード != null && !現地方公共団体コード.isEmpty()) {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(現地方公共団体コード.getColumnValue());
                keyValue.setValue(現地方公共団体コード.getColumnValue());
                keyValueList.add(keyValue);
                div.getDdlSyozaiHokensya().setDataSource(keyValueList);
                div.getDdlSyozaiHokensya().setSelectedKey(現地方公共団体コード.getColumnValue());
            }
        } else if (広域保険者.equals(広域と市町村判断())) {
            List<KeyValueDataSource> keyValueList = new ArrayList<>();
            if (市町村コード != null && !市町村コード.isEmpty()) {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(市町村コード.getColumnValue());
                keyValue.setValue(市町村コード.getColumnValue());
                keyValueList.add(keyValue);
                div.getDdlSyozaiHokensya().setDataSource(keyValueList);
                div.getDdlSyozaiHokensya().setSelectedKey(市町村コード.getColumnValue());
            }
        }
        if (is合併市町村()) {
            List<KeyValueDataSource> keyValueList = new ArrayList<>();
            if (旧地方公共団体コード != null && !旧地方公共団体コード.isEmpty()) {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(旧地方公共団体コード.getColumnValue());
                keyValue.setValue(旧地方公共団体コード.getColumnValue());
                keyValueList.add(keyValue);
                div.getDdlKyuHokensya().setDataSource(keyValueList);
                div.getDdlKyuHokensya().setSelectedKey(旧地方公共団体コード.getColumnValue());
            }
        }
    }

    private void 表示と非表示() {
        if (単一保険者.equals(広域と市町村判断())) {
            div.getLblSyozaiHokensya().setVisible(false);
            div.getDdlSyozaiHokensya().setVisible(false);
            div.getLblSotimotoHokensya().setVisible(false);
            div.getDdlSotimotoHokensya().setVisible(false);
        } else if (広域保険者.equals(広域と市町村判断())) {
            div.getLblSyozaiHokensya().setVisible(true);
            div.getDdlSyozaiHokensya().setVisible(true);
            div.getLblSotimotoHokensya().setVisible(true);
            div.getDdlSotimotoHokensya().setVisible(true);
        }
        if (is合併市町村()) {
            div.getLblKyuHokensya().setVisible(true);
            div.getDdlKyuHokensya().setVisible(true);
        } else {
            div.getLblKyuHokensya().setVisible(false);
            div.getDdlKyuHokensya().setVisible(false);
        }
    }

    private List<Shichoson> 旧保険者取得(LasdecCode 市町村コード, RString 導入形態コード, LasdecCode 広住特措置元市町村コード) {
        if (市町村コード == null || 市町村コード.isEmpty() || RString.isNullOrEmpty(導入形態コード)) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            return HihousyosaiFinder.createInstance().getGappeiShichosonList(広住特措置元市町村コード, DonyuKeitaiCode.toValue(導入形態コード)).records();
        }
        return HihousyosaiFinder.createInstance().getGappeiShichosonList(市町村コード, DonyuKeitaiCode.toValue(導入形態コード)).records();
    }

    private HihokenshaDaicho get得喪情報(HihokenshaNo 被保険者番号, FlexibleDate 異動日, RString 枝番) {
        if (被保険者番号 == null || 被保険者番号.isEmpty() || 異動日 == null || 異動日.isEmpty() || RString.isNullOrEmpty(枝番)) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        HihokenshaDaicho 得喪情報 = HihousyosaiFinder.createInstance().getTokusouJoho(被保険者番号, 異動日, 枝番);
        if (得喪情報 == null) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        return 得喪情報;
    }

    private List<KeyValueDataSource> get所在保険者() {
        List<KoseiShichosonMaster> 所在保険者情報
                = HihousyosaiFinder.createInstance().getKoseiShichosonMasterList().records();
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (KoseiShichosonMaster 所在保険者 : 所在保険者情報) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(所在保険者.getShichosonCode().getColumnValue());
            keyValue.setValue(new RString(所在保険者.getShoKisaiHokenshaNo().getColumnValue() + " " + 所在保険者.getShichosonMeisho()));
            keyValueList.add(keyValue);
        }
        return keyValueList;
    }

    private List<KeyValueDataSource> get旧保険者(LasdecCode 市町村コード, RString 導入形態コード, LasdecCode 広住特措置元市町村コード) {
        List<Shichoson> 旧保険者情報 = 旧保険者取得(市町村コード, 導入形態コード, 広住特措置元市町村コード);
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (Shichoson 旧保険者 : 旧保険者情報) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(旧保険者.get旧市町村コード().getColumnValue());
            keyValue.setValue(new RString(旧保険者.get旧市町村コード().getColumnValue() + " " + 旧保険者.get旧市町村名称()));
            keyValueList.add(keyValue);
        }
        return keyValueList;
    }

    private void set旧保険者(RString 旧保険者情報コード) {
        List<KeyValueDataSource> 旧保険者情報 = div.getDdlKyuHokensya().getDataSource();
        for (KeyValueDataSource keyValue : 旧保険者情報) {
            if (旧保険者情報コード.equals(keyValue.getKey())) {
                div.getDdlKyuHokensya().setSelectedKey(旧保険者情報コード);
            }
        }
    }

    private void set所在保険者(RString 所在保険者コード) {
        List<KeyValueDataSource> 所在保険者情報 = get所在保険者();
        for (KeyValueDataSource keyValue : 所在保険者情報) {
            if (所在保険者コード.equals(keyValue.getKey())) {
                div.getDdlSyozaiHokensya().setSelectedKey(所在保険者コード);
            }
        }
    }

    private void set措置元保険者(RString 措置元保険者コード) {
        List<KeyValueDataSource> 所在保険者情報 = get所在保険者();
        for (KeyValueDataSource keyValue : 所在保険者情報) {
            if (措置元保険者コード.equals(keyValue.getKey())) {
                div.getDdlSotimotoHokensya().setSelectedKey(措置元保険者コード);
            }
        }
    }

    private List<KeyValueDataSource> get取得事由() {
        FlexibleDate 基准日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<UzT0007CodeEntity> 取得事由List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), 基准日);
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (UzT0007CodeEntity entity : 取得事由List) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().getColumnValue());
            keyValue.setValue(entity.getコード略称());
            keyValueList.add(keyValue);
        }
        return keyValueList;
    }

    private void set取得事由(RString 取得事由コード) {
        List<KeyValueDataSource> 取得事由List = get取得事由();
        for (KeyValueDataSource keyValue : 取得事由List) {
            if (取得事由コード.equals(keyValue.getKey())) {
                div.getDdlSyutokuJiyu().setSelectedKey(取得事由コード);
            }
        }
    }

    private List<KeyValueDataSource> get被保区分() {
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (ShikakuKubun shikakuKubun : ShikakuKubun.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(shikakuKubun.getコード());
            keyValue.setValue(shikakuKubun.get名称());
            keyValueList.add(keyValue);
        }
        return keyValueList;
    }

    private void set被保区分(RString 被保区分コード) {
        List<KeyValueDataSource> 被保区分List = get被保区分();
        for (KeyValueDataSource keyValue : 被保区分List) {
            if (被保区分コード.equals(keyValue.getKey())) {
                div.getDdlHihokubun().setSelectedKey(被保区分コード);
            }
        }
    }

    private List<KeyValueDataSource> get喪失事由() {
        FlexibleDate 基准日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<UzT0007CodeEntity> 喪失事由List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格解除事由_他特例者.getCodeShubetsu(), 基准日);
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (UzT0007CodeEntity entity : 喪失事由List) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().getColumnValue());
            keyValue.setValue(entity.getコード略称());
            keyValueList.add(keyValue);
        }
        return keyValueList;
    }

    private void set喪失事由(RString 喪失事由コード) {
        List<KeyValueDataSource> 喪失事由List = get喪失事由();
        for (KeyValueDataSource keyValue : 喪失事由List) {
            if (喪失事由コード.equals(keyValue.getKey())) {
                div.getDdlSosichiJiyu().setSelectedKey(喪失事由コード);
            }
        }
    }

    private boolean is合併市町村() {
        RDate 適用基準日 = RDate.getNowDate();
        RString 合併市町村 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, 適用基準日, SubGyomuCode.DBU介護統計報告);
        return 合併情報区分.equals(合併市町村);
    }

    private RString 広域と市町村判断() {
        ShichosonSecurityJoho 介護導入形態 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (介護導入形態 != null) {
            DonyuKeitaiCode 導入形態コード = 介護導入形態.get導入形態コード();
            if (導入形態コード != null) {
                if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getCode())) {
                    return 広域保険者;
                } else if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード.getCode())
                        || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード.getCode())) {
                    return 単一保険者;
                }
            }
        }
        return RString.EMPTY;
    }

    private RString 日期(RDateTime 更新日時) {
        StringBuilder builder = new StringBuilder();
        builder.append(更新日時.getDate().wareki().toDateString())
                .append(" ")
                .append(更新日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        return new RString(builder.toString());
    }

    private static class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
