/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshashisaku.HihokenshaShisaku;
import jp.co.ndensan.reams.db.dbz.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeiseiManager;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.shichoson.Shichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoState;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.hihousyosai.HihousyosaiFinder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

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
     * @param 被保険者台帳情報 被保険者台帳情報
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 資格取得日 資格取得日
     * @param 施設入退所情報Models 施設入退所情報Models
     */
    public void initialize(RString viewState, List<HihokenshaDaicho> 被保険者台帳情報, ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, FlexibleDate 資格取得日, Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Models) {

        HihokenshaDaicho 資格得喪情報 = get最新資格得喪データ(被保険者台帳情報, 資格取得日);
        setドロップダウンリストの設定(viewState, 資格得喪情報);

        get宛名基本情報取得(識別コード);
        get資格系基本情報取得(被保険者番号);

        set資格得喪情報設定(viewState, 識別コード, 被保険者台帳情報, 資格取得日);

        if (状態_追加.equals(viewState)) {
            get画面初期の追加モードの表示制御();
            set登録モードOfDialog(被保険者台帳情報, 被保険者番号, 識別コード, 資格取得日, 施設入退所情報Models);
        } else if (状態_修正.equals(viewState)) {
            get画面初期の更新モードの表示制御();
            set登録モードOfDialog(被保険者台帳情報, 被保険者番号, 識別コード, 資格取得日, 施設入退所情報Models);
        } else if (状態_削除.equals(viewState)) {
            get画面初期の削除照会モードの表示制御();
            set照会モードOfDialog(被保険者台帳情報, 被保険者番号, 識別コード, 資格取得日);
        } else if (状態_照会.equals(viewState)) {
            get画面初期の削除照会モードの表示制御();
            set照会モードOfDialog(被保険者台帳情報, 被保険者番号, 識別コード, 資格取得日);
        }
    }

    /**
     * 画面に入力された情報から、資格取得・喪失の情報を新しく生成します。
     *
     * @param 被保番号 被保険者番号
     * @param 識別コード 識別コード
     * @return 生成した被保険者台帳情報
     */
    public List<HihokenshaDaicho> createNewRirekiData(HihokenshaNo 被保番号, ShikibetsuCode 識別コード) {
        List<HihokenshaDaicho> hihoList = new ArrayList<>();

        ShikakuRirekiJoho inputData = get資格詳細情報();
        HihokenshaDaicho daicho = new HihokenshaDaicho(被保番号, inputData.getShutokuDate(), new RString("0001"));
        HihokenshaDaichoBuilder builder = daicho.createBuilderForEdit();
        builder.set識別コード(識別コード);
        builder.set資格取得年月日(inputData.getShutokuDate());
        builder.set資格取得届出年月日(inputData.getShutokuTodokedeDate());
        builder.set資格取得事由コード(inputData.getShutokuJiyuKey());
        builder.set異動事由コード(inputData.getShutokuJiyuKey());
        builder.set被保険者区分コード(inputData.getHihokenshaKubun());
        builder.set市町村コード(new LasdecCode(inputData.getShozaiHokensha()));
        builder.set広住特措置元市町村コード(new LasdecCode(inputData.getSochimotoHokensha()));
        builder.set旧市町村コード(new LasdecCode(inputData.getKyuHokensha()));
        hihoList.add(builder.build());

        if (inputData.getSoshitsuDate() != null && !inputData.getSoshitsuDate().isEmpty()) {
            HihokenshaDaicho soshitsuDaicho = new HihokenshaDaicho(被保番号, inputData.getSoshitsuDate(), new RString("0001"));
            HihokenshaDaichoBuilder soshitsuBuilder = soshitsuDaicho.createBuilderForEdit();
            soshitsuBuilder.set識別コード(識別コード);
            soshitsuBuilder.set資格取得年月日(inputData.getShutokuDate());
            soshitsuBuilder.set資格取得届出年月日(inputData.getShutokuTodokedeDate());
            soshitsuBuilder.set資格取得事由コード(inputData.getShutokuJiyuKey());
            soshitsuBuilder.set被保険者区分コード(inputData.getHihokenshaKubun());
            soshitsuBuilder.set市町村コード(new LasdecCode(inputData.getShozaiHokensha()));
            soshitsuBuilder.set広住特措置元市町村コード(new LasdecCode(inputData.getSochimotoHokensha()));
            soshitsuBuilder.set旧市町村コード(new LasdecCode(inputData.getKyuHokensha()));
            soshitsuBuilder.set資格喪失年月日(inputData.getSoshitsuDate());
            soshitsuBuilder.set資格喪失届出年月日(inputData.getSoshitsuTodokedeDate());
            soshitsuBuilder.set資格喪失事由コード(inputData.getSoshitsuJiyuKey());
            soshitsuBuilder.set異動事由コード(inputData.getSoshitsuJiyuKey());
            hihoList.add(soshitsuBuilder.build());
        }

        return hihoList;
    }

    private void set照会モードOfDialog(List<HihokenshaDaicho> 被保険者台帳情報, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 資格取得日) {
        panelDiv.getCcdJutokuDialogButton().initialize(ItemList.of(被保険者台帳情報), 被保険者番号, 資格取得日, JushochiTokureiState.照会);
        panelDiv.getCcdShikakuHenkoDialogButton().initialize(ItemList.of(被保険者台帳情報), 被保険者番号, 識別コード, 資格取得日, ShikakuHenkoState.照会);
        panelDiv.getCcdShisetsuNyutaishoDialogButton().initialize(識別コード, DaichoType.被保険者.getコード(), ShisetsuNyutaishoState.照会);
    }

    private void set登録モードOfDialog(List<HihokenshaDaicho> 被保険者台帳情報, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 資格取得日) {
        panelDiv.getCcdJutokuDialogButton().initialize(ItemList.of(被保険者台帳情報), 被保険者番号, 資格取得日, JushochiTokureiState.登録);
        panelDiv.getCcdShikakuHenkoDialogButton().initialize(ItemList.of(被保険者台帳情報), 被保険者番号, 識別コード, 資格取得日, ShikakuHenkoState.登録);
        panelDiv.getCcdShisetsuNyutaishoDialogButton().initialize(識別コード, DaichoType.被保険者.getコード(), ShisetsuNyutaishoState.登録);
    }

    private void set登録モードOfDialog(List<HihokenshaDaicho> 被保険者台帳情報, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード,
            FlexibleDate 資格取得日, Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho) {
        if (shisetsuNyutaisho == null || shisetsuNyutaisho.values().isEmpty()) {
            set登録モードOfDialog(被保険者台帳情報, 被保険者番号, 識別コード, 資格取得日);
            return;
        }
        panelDiv.getCcdJutokuDialogButton().initialize(ItemList.of(被保険者台帳情報), 被保険者番号, 資格取得日, JushochiTokureiState.登録);
        panelDiv.getCcdShikakuHenkoDialogButton().initialize(ItemList.of(被保険者台帳情報), 被保険者番号, 識別コード, 資格取得日, ShikakuHenkoState.登録);
        panelDiv.getCcdShisetsuNyutaishoDialogButton().initialize(識別コード, DaichoType.被保険者.getコード(), ShisetsuNyutaishoState.登録, shisetsuNyutaisho);
    }

    /**
     * 引数から受け取った被保険者台帳の中から指定した資格取得日に合致するデータを調べ、その中で最も新しいデータを返します。
     *
     * @param 被保険者台帳情報 元となる被保険者台帳情報
     * @param 資格取得日 最新資格得喪の探す際の基準になる資格取得日
     * @return 最新の資格得喪データ
     */
    public HihokenshaDaicho get最新資格得喪データ(List<HihokenshaDaicho> 被保険者台帳情報, FlexibleDate 資格取得日) {
        HihokenshaDaichoList hihoList = new HihokenshaDaichoList(ItemList.of(被保険者台帳情報));
        IItemList<HihokenshaDaicho> oneSeasonList = hihoList.toOneSeasonList(資格取得日);
        if (oneSeasonList.isEmpty()) {
            return null;
        }
        Optional<HihokenshaDaicho> 最新データ = oneSeasonList.findFirst();
        return 最新データ.get();
    }

    private void get画面初期の更新モードの表示制御() {
        panelDiv.getKihonJoho().setDisabled(false);
        panelDiv.getShikakuShosai().setDisabled(false);
    }

    private void get画面初期の追加モードの表示制御() {
        panelDiv.getKihonJoho().setDisabled(false);
        panelDiv.getShikakuShosai().setDisabled(false);
        panelDiv.getBtnTokusoKakutei().setDisplayNone(false);
        panelDiv.getShikakuShosai().getShikakuShosaiDialogs().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
    }

    private void get画面初期の削除照会モードの表示制御() {
        panelDiv.getKihonJoho().setDisabled(false);

        setIs資格得喪Input(true);
        panelDiv.getShikakuShosai().getShikakuShosaiDialogs().setReadOnly(false);
    }

    private void setIs資格得喪Input(boolean isReadOnly) {
        panelDiv.getShikakuShosai().getTxtShutokuDate().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getTxtShutokuTodokedeDate().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getDdlShutokuJiyu().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getDdlHihoKubun().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getDdlShutokuShozaiHokensha().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getDdlShutokuSochimotoHokensha().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getDdlShutokuKyuHokensha().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getTxtShutokuShoriDate().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getTxtSoshitsuDate().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getTxtSoshitsuTodokedeDate().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getDdlSoshitsuJiyu().setReadOnly(isReadOnly);
        panelDiv.getShikakuShosai().getTxtSoshitsuShoriDate().setReadOnly(isReadOnly);
    }

    private void setドロップダウンリストの設定(RString viewState, HihokenshaDaicho 資格得喪情報) {
        get取得事由();
        get被保区分();
        get所在保険者と措置元保険者(viewState, 資格得喪情報);
        表示と非表示();
        get旧保険者(viewState, 資格得喪情報);
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
        dateSource.setValue(ShikakuKubun._１号.get略称());
        被保区分リスト.add(dateSource);
        KeyValueDataSource dateSource1 = new KeyValueDataSource();
        dateSource1.setKey(ShikakuKubun._２号.getコード());
        dateSource1.setValue(ShikakuKubun._２号.get略称());
        被保区分リスト.add(dateSource1);
        panelDiv.getShikakuShosai().getDdlHihoKubun().setDataSource(被保区分リスト);
    }

    private void get所在保険者と措置元保険者(RString viewState, HihokenshaDaicho 資格得喪情報) {
        List<KeyValueDataSource> 所在保険者List = new ArrayList<>();
        List<KeyValueDataSource> 措置元保険者List = new ArrayList<>();
        if (単一保険者.equals(広域と市町村判断())) {
            if (状態_追加.equals(viewState)) {
                RString 所在保険者 = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().getColumnValue();
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(所在保険者);
                keyValue.setValue(RString.EMPTY);
                所在保険者List.add(keyValue);
                panelDiv.getShikakuShosai().getDdlShutokuShozaiHokensha().setDataSource(所在保険者List);
            } else {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(資格得喪情報.get市町村コード().getColumnValue());
                keyValue.setValue(RString.EMPTY);
                所在保険者List.add(keyValue);
                panelDiv.getShikakuShosai().getDdlShutokuShozaiHokensha().setDataSource(所在保険者List);
                KeyValueDataSource keyValue2 = new KeyValueDataSource();
                keyValue2.setKey(資格得喪情報.get市町村コード().getColumnValue());
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
                措置元保険者List.add(keyValue);
            }
            panelDiv.getShikakuShosai().getDdlShutokuShozaiHokensha().setDataSource(所在保険者List);
            panelDiv.getShikakuShosai().getDdlShutokuSochimotoHokensha().setDataSource(措置元保険者List);
        }
    }

    private void get旧保険者(RString viewState, HihokenshaDaicho 資格得喪情報) {

        if (!is合併市町村()) {
            if (状態_修正.equals(viewState)) {
                List<KeyValueDataSource> keyValueList = new ArrayList<>();
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(資格得喪情報.get旧市町村コード().getColumnValue());
                keyValue.setValue(RString.EMPTY);
                keyValueList.add(keyValue);
                panelDiv.getShikakuShosai().getDdlShutokuKyuHokensha().setDataSource(keyValueList);
            }
        } else {
            if (単一保険者.equals(広域と市町村判断())) {
                旧保険者情報の設定(所在保険者の取得(), RString.EMPTY);
            } else {
                旧保険者情報の設定(資格得喪情報.get市町村コード().getColumnValue(), 資格得喪情報.get広住特措置元市町村コード().getColumnValue());
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

    private RString 所在保険者の取得() {
        RString 所在保険者 = RString.EMPTY;
        if (単一保険者.equals(広域と市町村判断())) {
            所在保険者 = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().getColumnValue();

        } else if (広域保険者.equals(広域と市町村判断())) {
            KoikiShichosonJohoFinder fider = KoikiShichosonJohoFinder.createInstance();
            List<KoikiZenShichosonJoho> koikiZenShichosonJohoList = fider.koseiShichosonJoho().records();
            if (!koikiZenShichosonJohoList.isEmpty()) {
                所在保険者 = koikiZenShichosonJohoList.get(0).get市町村コード().getColumnValue();
            }
        }
        return 所在保険者;
    }

    private RString 旧保険者の取得(ShikibetsuCode 識別コード) {
        RString 旧保険者 = RString.EMPTY;
        if (is合併市町村()) {
            List<HihokenshaShisaku> 宛名情報List = manager.get宛名情報全て(識別コード);
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
            panelDiv.getLblShutokuShozaiHokensha().setDisplayNone(true);
            panelDiv.getDdlShutokuShozaiHokensha().setDisplayNone(true);
            panelDiv.getLblShutokuSochimotoHokensha().setDisplayNone(true);
            panelDiv.getDdlShutokuSochimotoHokensha().setDisplayNone(true);
        } else if (広域保険者.equals(広域と市町村判断())) {
            panelDiv.getLblShutokuShozaiHokensha().setDisplayNone(false);
            panelDiv.getDdlShutokuShozaiHokensha().setDisplayNone(false);
            panelDiv.getLblShutokuSochimotoHokensha().setDisplayNone(false);
            panelDiv.getDdlShutokuSochimotoHokensha().setDisplayNone(false);
        }
        if (is合併市町村()) {
            panelDiv.getLblKyuHokensha().setDisplayNone(false);
            panelDiv.getDdlShutokuKyuHokensha().setDisplayNone(false);
        } else {
            panelDiv.getLblKyuHokensha().setDisplayNone(true);
            panelDiv.getDdlShutokuKyuHokensha().setDisplayNone(true);
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
        if (RString.isNullOrEmpty(導入形態コード)) {
            return new ArrayList<>();
        }

        if (!広住特措置元市町村コード.isEmpty()) {
            return HihousyosaiFinder.createInstance().getGappeiShichosonList(広住特措置元市町村コード, DonyuKeitaiCode.toValue(導入形態コード)).records();
        }
        if (!市町村コード.isEmpty()) {
            return HihousyosaiFinder.createInstance().getGappeiShichosonList(市町村コード, DonyuKeitaiCode.toValue(導入形態コード)).records();
        }
        return new ArrayList<>();
    }

    private void get宛名基本情報取得(ShikibetsuCode 識別コード) {
        panelDiv.getKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
    }

    private void get資格系基本情報取得(HihokenshaNo 被保番号) {
        panelDiv.getKihonJoho().getCcdKaigoShikakuKihon().initialize(被保番号);
    }

    private void set資格得喪情報設定(RString viewState, ShikibetsuCode 識別コード, List<HihokenshaDaicho> 被保険者台帳情報, FlexibleDate 資格取得日) {
        if (状態_追加.equals(viewState)) {
            RString 所在保険者 = 所在保険者の取得();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuShozaiHokensha().setSelectedKey(
                    所在保険者.isEmpty() ? RString.EMPTY : 所在保険者);
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuSochimotoHokensha().setSelectedKey(RString.EMPTY);
            set旧保険者(識別コード);
        } else {
            HihokenshaDaichoList hihoList = new HihokenshaDaichoList(ItemList.of(被保険者台帳情報));
            IItemList<HihokenshaDaicho> oneSeasonList = hihoList.toOneSeasonList(資格取得日);
            if (oneSeasonList.isEmpty()) {
                return;
            }
            Optional<HihokenshaDaicho> 最新データ = oneSeasonList.findFirst();
            HihokenshaDaicho 資格得喪情報 = 最新データ.get();

            FlexibleDate 取得日 = 資格得喪情報.get資格取得年月日();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtShutokuDate().setValue(
                    valueOrEmptyIfNull(取得日));
            FlexibleDate 取得届出日 = 資格得喪情報.get資格取得届出年月日();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtShutokuTodokedeDate().setValue(
                    valueOrEmptyIfNull(取得届出日));
            RString 取得事由 = 資格得喪情報.get資格取得事由コード();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuJiyu().setSelectedKey(
                    valueOrEmptyIfNull(取得事由));
            FlexibleDate 喪失日 = 資格得喪情報.get資格喪失年月日();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuDate().setValue(
                    valueOrEmptyIfNull(喪失日));
            FlexibleDate 喪失届出日 = 資格得喪情報.get資格喪失届出年月日();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuTodokedeDate().setValue(
                    valueOrEmptyIfNull(喪失届出日));
            RString 喪失事由 = 資格得喪情報.get資格喪失事由コード();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlSoshitsuJiyu().setSelectedKey(
                    valueOrEmptyIfNull(喪失事由));
            RString 被保区分 = 資格得喪情報.get被保険者区分コード();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlHihoKubun().setSelectedKey(
                    valueOrEmptyIfNull(被保区分));
            LasdecCode 所在保険者 = 資格得喪情報.get市町村コード();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuShozaiHokensha().setSelectedKey(
                    valueOrEmptyIfNull(所在保険者).getColumnValue());
            LasdecCode 措置元保険者 = 資格得喪情報.get広住特措置元市町村コード();
            panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuSochimotoHokensha().setSelectedKey(
                    valueOrEmptyIfNull(措置元保険者).getColumnValue());
            LasdecCode 旧保険者 = 資格得喪情報.get旧市町村コード();

            DropDownList shutokuKeyHokensha = panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha();
            if (shutokuKeyHokensha.getDataSource().isEmpty()
                    || (shutokuKeyHokensha.getDataSource().isEmpty() && shutokuKeyHokensha.getIsBlankLine())) {
                panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha().setDisabled(true);
            } else {
                panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha().setSelectedKey(
                        旧保険者 == null || 旧保険者.isEmpty() ? RString.EMPTY : 旧保険者.getColumnValue());
            }
            RDateTime 処理日時 = 資格得喪情報.toEntity().getLastUpdateTimestamp();
            RStringBuilder 処理日時表示 = new RStringBuilder();
            RString 処理日時Str = RString.EMPTY;
            if (処理日時 != null) {
                処理日時表示.append(処理日時.getDate().wareki().toDateString());
                処理日時表示.append(RString.HALF_SPACE);
                処理日時表示.append(String.format("%02d", 処理日時.getHour()));
                処理日時表示.append(":");
                処理日時表示.append(String.format("%02d", 処理日時.getMinute()));
                処理日時表示.append(":");
                処理日時表示.append(String.format("%02d", 処理日時.getSecond()));
                処理日時Str = 処理日時表示.toRString();
            }
            panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtShutokuShoriDate().setValue(rStringToFlexibleDate(処理日時Str));
            panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuShoriDate().setValue(rStringToFlexibleDate(処理日時Str));
        }
    }

    private void set旧保険者(ShikibetsuCode 識別コード) {
        RString 旧保険者 = 旧保険者の取得(識別コード);
        for (KeyValueDataSource source : panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha().getDataSource()) {
            if (source.getKey().equals(旧保険者)) {
                panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha().setSelectedKey(旧保険者);
                break;
            }
        }
    }

    private RString valueOrEmptyIfNull(RString rString) {
        return rString == null ? RString.EMPTY : rString;
    }

    private FlexibleDate valueOrEmptyIfNull(FlexibleDate fDate) {
        return fDate == null ? FlexibleDate.EMPTY : fDate;
    }

    private LasdecCode valueOrEmptyIfNull(LasdecCode lasdecCode) {
        return lasdecCode == null ? LasdecCode.EMPTY : lasdecCode;
    }

    private FlexibleDate rStringToFlexibleDate(RString 処理日時) {
        if (RString.isNullOrEmpty(処理日時)) {
            return FlexibleDate.EMPTY;
        }
        RDate date = new RDate(処理日時.toString().substring(0, 処理日時_TMP));
        return new FlexibleDate(date.toDateString());
    }

    /**
     * 資格得喪情報に変更があるかを判定します。
     *
     * @param 被保険者台帳情報 被保険者台帳情報のList。前画面からViewStateで渡ってきたものを受け取る前提。
     * @param 資格取得日 資格取得年月日。前画面からViewStateで渡ってきたものを受け取る前提。
     * @return 変更有りと判断した場合true、それ以外の場合false
     */
    public boolean is資格得喪情報変更有り(List<HihokenshaDaicho> 被保険者台帳情報, FlexibleDate 資格取得日) {

        HihokenshaDaichoList hihoList = new HihokenshaDaichoList(ItemList.of(被保険者台帳情報));
        IItemList<HihokenshaDaicho> oneSeasonList = hihoList.toOneSeasonList(資格取得日);
        if (oneSeasonList.isEmpty()) {
            return true;
        }

        boolean is変更有り = false;
        Optional<HihokenshaDaicho> 最新データ = oneSeasonList.findFirst();
        HihokenshaDaicho 資格得喪情報 = 最新データ.get();

        FlexibleDate 取得日 = 資格得喪情報.get資格取得年月日();
        FlexibleDate 入力取得日 = panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtShutokuDate().getValue();
        if (!取得日.equals(入力取得日)) {
            is変更有り = true;
        }

        FlexibleDate 取得届出日 = valueOrEmptyIfNull(資格得喪情報.get資格取得届出年月日());
        FlexibleDate 入力取得届出日 = panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtShutokuTodokedeDate().getValue();
        if (!取得届出日.equals(入力取得届出日)) {
            is変更有り = true;
        }

        RString 取得事由 = valueOrEmptyIfNull(資格得喪情報.get資格取得事由コード());
        RString 入力取得事由 = panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuJiyu().getSelectedKey();
        if (!取得事由.equals(入力取得事由)) {
            is変更有り = true;
        }

        FlexibleDate 喪失日 = valueOrEmptyIfNull(資格得喪情報.get資格喪失年月日());
        FlexibleDate 入力喪失日 = panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuDate().getValue();
        if (!喪失日.isEmpty() && !喪失日.equals(入力喪失日)) {
            is変更有り = true;
        }

        FlexibleDate 喪失届出日 = valueOrEmptyIfNull(資格得喪情報.get資格喪失届出年月日());
        FlexibleDate 入力喪失届出日 = panelDiv.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuTodokedeDate().getValue();
        if (!喪失届出日.isEmpty() && !喪失届出日.equals(入力喪失届出日)) {
            is変更有り = true;
        }

        RString 喪失事由 = valueOrEmptyIfNull(資格得喪情報.get資格喪失事由コード());
        RString 入力喪失事由 = panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlSoshitsuJiyu().getSelectedKey();
        if (!喪失事由.isEmpty() && !喪失事由.equals(入力喪失事由)) {
            is変更有り = true;
        }

        RString 被保区分 = valueOrEmptyIfNull(資格得喪情報.get被保険者区分コード());
        RString 入力被保区分 = panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlHihoKubun().getSelectedKey();
        if (!被保区分.equals(入力被保区分)) {
            is変更有り = true;
        }

        LasdecCode 所在保険者 = valueOrEmptyIfNull(資格得喪情報.get市町村コード());
        RString 入力所在保険者 = panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuShozaiHokensha().getSelectedKey();
        if (!所在保険者.isEmpty() && !所在保険者.getColumnValue().equals(入力所在保険者)) {
            is変更有り = true;
        }

        LasdecCode 措置元保険者 = valueOrEmptyIfNull(資格得喪情報.get広住特措置元市町村コード());
        RString 入力措置元保険者 = panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuSochimotoHokensha().getSelectedKey();
        if (!措置元保険者.isEmpty() && !措置元保険者.getColumnValue().equals(入力措置元保険者)) {
            is変更有り = true;
        }

        LasdecCode 旧保険者 = valueOrEmptyIfNull(資格得喪情報.get旧市町村コード());
        RString 入力旧保険者 = panelDiv.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha().getSelectedKey();
        if (!旧保険者.isEmpty() && !旧保険者.getColumnValue().equals(入力旧保険者)) {
            is変更有り = true;
        }

        return is変更有り;
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

    /**
     * 住所地特例ダイアログに設定されている情報を取得します。更新未更新関わらず、住特のデータだと判断できるもの全てを取得します。
     *
     * @return 住所地特例情報のList
     */
    public List<HihokenshaDaicho> get住所地特例List() {
        List<HihokenshaDaicho> 住所地特例情報 = panelDiv.getCcdJutokuDialogButton().get修正後被保険者データ().toList();
        List<HihokenshaDaicho> retList = new ArrayList<>();
        for (HihokenshaDaicho daicho : 住所地特例情報) {
            if (ShikakuJutokuTekiyoJiyu.checkIdoJiyu(daicho.get異動事由コード())) {
                retList.add(daicho);
            } else if (ShikakuJutokuKaijoJiyu.checkIdoJiyu(daicho.get異動事由コード())) {
                retList.add(daicho);
            }
        }
        return retList;

    }

    /**
     * 資格変更ダイアログに設定されている情報を取得します。更新未更新関わらず、変更のデータだと判断できるもの全てを取得します。
     *
     * @return 資格変更情報のList
     */
    public List<HihokenshaDaicho> get資格変更List() {
        List<HihokenshaDaicho> 資格変更履歴情報 = panelDiv.getCcdShikakuHenkoDialogButton().get修正後被保険者データ().toList();
        List<HihokenshaDaicho> retList = new ArrayList<>();
        for (HihokenshaDaicho daicho : 資格変更履歴情報) {
            if (ShikakuHenkoJiyu.checkIdoJiyu(daicho.get異動事由コード())) {
                retList.add(daicho);
            }
        }
        return retList;
    }

    /**
     * 被保険者台帳情報に対して住所地特例情報を反映し、新たなリストを作成して返します。
     *
     * @param 入力内容反映前 入力内容反映前
     * @param 住所地特例情報 住所地特例情報
     * @return 住所地特例情報を反映した、被保険者台帳情報
     */
    public List<HihokenshaDaicho> create住所地特例データ統合リスト(List<HihokenshaDaicho> 入力内容反映前, List<HihokenshaDaicho> 住所地特例情報) {
        List<HihokenshaDaicho> integrateList = new ArrayList<>();
        boolean isAdded;

        for (HihokenshaDaicho daicho : 入力内容反映前) {
            isAdded = integrateJutoku(住所地特例情報, daicho, integrateList);
            if (!isAdded) {
                integrateList.add(daicho);
            }
        }
        integrateList.addAll(extractAddData(住所地特例情報));

        return integrateList;
    }

    private List<HihokenshaDaicho> extractAddData(List<HihokenshaDaicho> 反映対象データ) {
        List<HihokenshaDaicho> extractionData = new ArrayList<>();
        for (HihokenshaDaicho daicho : 反映対象データ) {
            if (EntityDataState.Added.equals(daicho.toEntity().getState())) {
                extractionData.add(daicho);
            }
        }
        return extractionData;
    }

    private boolean integrateJutoku(List<HihokenshaDaicho> 住所地特例情報, HihokenshaDaicho daicho, List<HihokenshaDaicho> integrateList) {
        boolean isAdded = false;
        if (daicho.is論理削除フラグ()) {
            return isAdded;
        }

        for (HihokenshaDaicho jutokuDaicho : 住所地特例情報) {
            isAdded = setJutokuDataAndCheckAdded(integrateList, daicho, jutokuDaicho, isAdded);
        }
        return isAdded;
    }

    private boolean setJutokuDataAndCheckAdded(List<HihokenshaDaicho> integrateList, HihokenshaDaicho daicho,
            HihokenshaDaicho jutokuDaicho, boolean isAdded) {
        if (EntityDataState.Unchanged.equals(jutokuDaicho.toEntity().getState())) {
            return isAdded;
        }
        if (jutokuDaicho.is論理削除フラグ()) {
            return isAdded;
        }
        if (!is主キー一致(daicho, jutokuDaicho)) {
            return isAdded;
        }

        if (is住所地特例解除(jutokuDaicho)) {
            if (!isUpdate解除情報(daicho, jutokuDaicho)) {
                return isAdded;
            }
            if (daicho.get異動日().equals(jutokuDaicho.get適用年月日())) {
                integrateList.add(setIdoDate(jutokuDaicho, jutokuDaicho.get解除年月日(), jutokuDaicho.get住所地特例解除事由コード()));
            } else if (!daicho.get異動日().equals(jutokuDaicho.get解除年月日()) && !isAdded) {
                integrateList.add(setIdoDate(jutokuDaicho, jutokuDaicho.get解除年月日(), jutokuDaicho.get住所地特例解除事由コード()));
                integrateList.add(setLogicalDelete(daicho));
                isAdded = true;
            }
        } else {
            if (!isUpdate適用情報(daicho, jutokuDaicho)) {
                return isAdded;
            }
            integrateList.add(jutokuDaicho);
            if (!daicho.get異動日().equals(jutokuDaicho.get適用年月日()) && !isAdded) {
                integrateList.add(setLogicalDelete(daicho));
                isAdded = true;
            }
        }
        return isAdded;
    }

    /**
     * 被保険者台帳情報に対して資格変更情報を反映し、新たなリストを作成して返します。
     *
     * @param 入力内容反映前 入力内容反映前
     * @param 資格変更履歴情報 資格変更履歴情報
     * @return 資格変更情報を反映した、被保険者台帳情報
     */
    public List<HihokenshaDaicho> create資格変更データ統合リスト(List<HihokenshaDaicho> 入力内容反映前, List<HihokenshaDaicho> 資格変更履歴情報) {
        List<HihokenshaDaicho> integrateList = new ArrayList<>();
        boolean isAdded;
        for (HihokenshaDaicho daicho : 入力内容反映前) {

            isAdded = integrateHenko(資格変更履歴情報, daicho, integrateList);
            if (!isAdded) {
                integrateList.add(daicho);
            }
        }
        integrateList.addAll(extractAddData(資格変更履歴情報));
        return integrateList;
    }

    private boolean integrateHenko(List<HihokenshaDaicho> 資格変更履歴情報, HihokenshaDaicho daicho, List<HihokenshaDaicho> integrateList) {
        boolean isAdded = false;
        if (daicho.is論理削除フラグ()) {
            return isAdded;
        }

        for (HihokenshaDaicho henkoDaicho : 資格変更履歴情報) {
            if (henkoDaicho.is論理削除フラグ()) {
                continue;
            }
            if (EntityDataState.Unchanged.equals(henkoDaicho.toEntity().getState())) {
                continue;
            }

            if (!is主キー一致(daicho, henkoDaicho)) {
                continue;
            }
            if (!isUpdate資格変更(daicho, henkoDaicho)) {
                continue;
            }
            integrateList.add(setIdoDate(henkoDaicho, henkoDaicho.get資格変更年月日(), henkoDaicho.get資格変更事由コード()));
            integrateList.add(setLogicalDelete(daicho));
            isAdded = true;
        }
        return isAdded;
    }

    /**
     * 引数に渡された被保険者台帳情報を、履歴として前データを正しく引き継いでいくよう修正します。
     * 引数に受け取る修正対象は、1資格得喪失期間の被保険者台帳であることが前提です。
     *
     * @param 修正対象 修正対象の被保険者台帳リスト
     * @return 修正した被保険者台帳リスト
     */
    public List<HihokenshaDaicho> create引継情報反映リスト(List<HihokenshaDaicho> 修正対象) {
        List<HihokenshaDaicho> afterReflectList = new ArrayList<>();
        IItemList<HihokenshaDaicho> daichoList = new HihokenshaDaichoList(ItemList.of(修正対象)).to昇順List();
        HihokenshaShikakuShutokuManager shikakuShutokuManager = HihokenshaShikakuShutokuManager.createInstance();
        ShikakuRirekiJoho 資格詳細情報 = get資格詳細情報();

        HihokenshaDaicho beforeData = null;
        for (HihokenshaDaicho daicho : daichoList) {
            boolean is修正 = false;

            if (daicho.is論理削除フラグ() || daicho.isDeleted()) {
                afterReflectList.add(daicho);
                continue;
            }

            HihokenshaDaichoBuilder builder = daicho.createBuilderForEdit();
            is修正 = set資格取得情報For資格詳細情報入力(daicho, 資格詳細情報, builder, is修正);
            if (beforeData != null) {
                set識別コード(daicho, beforeData, builder);
                set市町村コード(daicho, beforeData, builder);
                is修正 = set資格取得情報(daicho, beforeData, builder, is修正);
                is修正 = set資格取得届出情報(daicho, beforeData, builder, is修正);
                is修正 = set1号年齢到達情報(daicho, beforeData, builder, is修正);
                is修正 = set被保険者区分情報(daicho, beforeData, builder, is修正);
                is修正 = set資格変更情報(daicho, beforeData, builder, is修正);
                is修正 = set住所地特例情報(beforeData, daicho, builder, is修正);
                is修正 = set住所地特例フラグ(beforeData, daicho, builder, is修正);
                is修正 = set広域内住所地特例フラグ(beforeData, daicho, builder, is修正);
                is修正 = set被保険者区分(beforeData, daicho, builder, is修正);
                is修正 = set旧市町村コード(beforeData, daicho, builder, is修正);
                is修正 = set広住特措置元市町村コード(beforeData, daicho, builder, is修正);
            }

            if (is修正) {
                HihokenshaDaicho newData = builder.build();
                if (newData.toEntity().equalsPrimaryKeys(daicho.toEntity())) {
                    RString 枝番 = shikakuShutokuManager.getSaidaiEdaban(newData.get被保険者番号(), newData.get異動日());
                    builder.set枝番(new RString(String.valueOf(枝番)));

                    newData = builder.build().createNewCopyData();
                }

                if (!EntityDataState.Added.equals(daicho.toEntity().getState())) {
                    afterReflectList.add(setLogicalDelete(daicho));
                }
                afterReflectList.add(newData);
                beforeData = newData;
            } else {
                afterReflectList.add(daicho);
                beforeData = daicho;
            }
        }

        HihokenshaDaichoList afterList = new HihokenshaDaichoList(ItemList.of(afterReflectList));
        IItemList<HihokenshaDaicho> afterItemList = afterList.to降順List();
        HihokenshaDaicho daicho = afterItemList.findFirst().get();

        if (isUpdate資格喪失(daicho, 資格詳細情報)) {
            HihokenshaDaichoBuilder builder = daicho.createBuilderForEdit();
            builder.set資格喪失年月日(資格詳細情報.getSoshitsuDate());
            builder.set資格喪失届出年月日(資格詳細情報.getSoshitsuTodokedeDate());
            builder.set資格喪失事由コード(資格詳細情報.getSoshitsuJiyuKey());
        }

        return afterList.to降順List().toList();
    }

    private boolean set住所地特例情報(HihokenshaDaicho beforeData, HihokenshaDaicho daicho, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (!nullOrEmpty(beforeData.get解除年月日())
                && !nullOrEmpty(daicho.get適用年月日())
                && beforeData.get適用年月日().equals(daicho.get適用年月日())) {
            builder.set適用年月日(FlexibleDate.EMPTY);
            builder.set適用届出年月日(FlexibleDate.EMPTY);
            builder.set住所地特例適用事由コード(RString.EMPTY);
            is修正 = true;
        }
        if (nullOrEmpty(beforeData.get解除年月日()) && !nullOrEmpty(beforeData.get適用年月日())
                && ((nullOrEmpty(daicho.get適用年月日()))
                || (!daicho.get適用年月日().equals(beforeData.get適用年月日())))) {
            builder.set適用年月日(beforeData.get適用年月日());
            builder.set適用届出年月日(beforeData.get適用届出年月日());
            builder.set住所地特例適用事由コード(beforeData.get住所地特例適用事由コード());
            if (nullOrEmpty(daicho.get適用年月日()) && !nullOrEmpty(beforeData.get適用年月日())) {
                is修正 = true;
            }
        }
        return is修正;
    }

    private boolean set住所地特例フラグ(HihokenshaDaicho beforeData, HihokenshaDaicho daicho, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get住所地特例フラグ()) && !nullOrEmpty(beforeData.get住所地特例フラグ())) {
            builder.set住所地特例フラグ(beforeData.get住所地特例フラグ());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set広域内住所地特例フラグ(HihokenshaDaicho beforeData, HihokenshaDaicho daicho, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get広域内住所地特例フラグ()) && !nullOrEmpty(beforeData.get広域内住所地特例フラグ())) {
            builder.set広域内住所地特例フラグ(beforeData.get広域内住所地特例フラグ());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set被保険者区分(HihokenshaDaicho beforeData, HihokenshaDaicho daicho, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get被保険者区分コード()) && !nullOrEmpty(beforeData.get被保険者区分コード())) {
            builder.set被保険者区分コード(beforeData.get被保険者区分コード());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set旧市町村コード(HihokenshaDaicho beforeData, HihokenshaDaicho daicho, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get旧市町村コード()) && !nullOrEmpty(beforeData.get旧市町村コード())) {
            builder.set旧市町村コード(beforeData.get旧市町村コード());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set広住特措置元市町村コード(HihokenshaDaicho beforeData, HihokenshaDaicho daicho, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get広住特措置元市町村コード()) && !nullOrEmpty(beforeData.get広住特措置元市町村コード())) {
            builder.set広住特措置元市町村コード(beforeData.get広住特措置元市町村コード());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set資格変更情報(HihokenshaDaicho daicho, HihokenshaDaicho beforeData, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get資格変更年月日()) && !nullOrEmpty(beforeData.get資格変更年月日())) {
            builder.set資格変更年月日(beforeData.get資格変更年月日());
            builder.set資格変更届出年月日(beforeData.get資格変更届出年月日());
            builder.set資格変更事由コード(beforeData.get資格変更事由コード());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set被保険者区分情報(HihokenshaDaicho daicho, HihokenshaDaicho beforeData, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get被保険者区分コード()) && !nullOrEmpty(beforeData.get被保険者区分コード())) {
            builder.set被保険者区分コード(beforeData.get被保険者区分コード());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set1号年齢到達情報(HihokenshaDaicho daicho, HihokenshaDaicho beforeData, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get第1号資格取得年月日()) && !nullOrEmpty(beforeData.get第1号資格取得年月日())) {
            builder.set第1号資格取得年月日(beforeData.get第1号資格取得年月日());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set資格取得届出情報(HihokenshaDaicho daicho, HihokenshaDaicho beforeData, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get資格取得届出年月日()) && !nullOrEmpty(beforeData.get資格取得届出年月日())) {
            builder.set資格取得届出年月日(beforeData.get資格取得届出年月日());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set資格取得情報(HihokenshaDaicho daicho, HihokenshaDaicho beforeData, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (nullOrEmpty(daicho.get資格取得年月日()) && !nullOrEmpty(beforeData.get資格取得年月日())) {
            builder.set資格取得年月日(beforeData.get資格取得年月日());
            builder.set資格取得事由コード(beforeData.get資格取得事由コード());
            is修正 = true;
        }
        return is修正;
    }

    private boolean set資格取得情報For資格詳細情報入力(HihokenshaDaicho daicho, ShikakuRirekiJoho 資格詳細情報, HihokenshaDaichoBuilder builder, boolean is修正) {
        if (isUpdate資格取得(daicho, 資格詳細情報)) {
            builder.set資格取得年月日(資格詳細情報.getShutokuDate());
            builder.set資格取得届出年月日(資格詳細情報.getShutokuTodokedeDate());
            builder.set資格取得事由コード(資格詳細情報.getShutokuJiyuKey());
            is修正 = true;
        }
        return is修正;
    }

    private void set市町村コード(HihokenshaDaicho daicho, HihokenshaDaicho beforeData, HihokenshaDaichoBuilder builder) {
        if (nullOrEmpty(daicho.get市町村コード()) && !nullOrEmpty(beforeData.get市町村コード())) {
            builder.set市町村コード(beforeData.get市町村コード());
        }
    }

    private void set識別コード(HihokenshaDaicho daicho, HihokenshaDaicho beforeData, HihokenshaDaichoBuilder builder) {
        if (nullOrEmpty(daicho.get識別コード()) && !nullOrEmpty(beforeData.get識別コード())) {
            builder.set識別コード(beforeData.get識別コード());
        }
    }

    private boolean nullOrEmpty(FlexibleDate date) {
        return date == null || date.isEmpty();
    }

    private boolean nullOrEmpty(RString date) {
        return date == null || date.isEmpty();
    }

    private boolean nullOrEmpty(LasdecCode date) {
        return date == null || date.isEmpty();
    }

    private boolean nullOrEmpty(ShikibetsuCode date) {
        return date == null || date.isEmpty();
    }

    private boolean is主キー一致(HihokenshaDaicho obj1, HihokenshaDaicho obj2) {
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.toEntity().equalsPrimaryKeys(obj2.toEntity());
    }

    private boolean is住所地特例解除(HihokenshaDaicho kaijoDaicho) {
        if (kaijoDaicho == null) {
            return false;
        }
        return !(kaijoDaicho.get解除年月日() == null || kaijoDaicho.get解除年月日().isEmpty());
    }

    private boolean isUpdate適用情報(HihokenshaDaicho daicho, HihokenshaDaicho tekiyoDaicho) {
        if (daicho == null || tekiyoDaicho == null) {
            return false;
        }
        FlexibleDate 適用年月日 = daicho.get適用年月日() == null ? FlexibleDate.EMPTY : daicho.get適用年月日();
        FlexibleDate 適用届出年月日 = daicho.get適用届出年月日() == null ? FlexibleDate.EMPTY : daicho.get適用届出年月日();
        RString 住所地特例適用事由コード = daicho.get住所地特例適用事由コード() == null ? RString.EMPTY : daicho.get住所地特例適用事由コード();
        return (!適用年月日.equals(tekiyoDaicho.get適用年月日()))
                || (!適用届出年月日.equals(tekiyoDaicho.get適用届出年月日()))
                || (!住所地特例適用事由コード.equals(tekiyoDaicho.get住所地特例適用事由コード()));
    }

    private boolean isUpdate解除情報(HihokenshaDaicho daicho, HihokenshaDaicho jutokuDaicho) {
        if (daicho == null || jutokuDaicho == null) {
            return false;
        }
        FlexibleDate 解除年月日 = daicho.get解除年月日() == null ? FlexibleDate.EMPTY : daicho.get解除年月日();
        FlexibleDate 解除届出年月日 = daicho.get解除届出年月日() == null ? FlexibleDate.EMPTY : daicho.get解除届出年月日();
        RString 住所地特例解除事由コード = daicho.get住所地特例解除事由コード() == null ? RString.EMPTY : daicho.get住所地特例解除事由コード();
        return (!解除年月日.equals(jutokuDaicho.get解除年月日()))
                || (!解除届出年月日.equals(jutokuDaicho.get解除届出年月日()))
                || (!住所地特例解除事由コード.equals(jutokuDaicho.get住所地特例解除事由コード()));
    }

    private boolean isUpdate資格変更(HihokenshaDaicho daicho, HihokenshaDaicho henkoDaicho) {
        if (daicho == null || henkoDaicho == null) {
            return false;
        }
        FlexibleDate 資格変更年月日 = daicho.get資格変更年月日() == null ? FlexibleDate.EMPTY : daicho.get資格変更年月日();
        FlexibleDate 資格変更届出年月日 = daicho.get資格変更届出年月日() == null ? FlexibleDate.EMPTY : daicho.get資格変更届出年月日();
        RString 資格変更事由コード = daicho.get資格変更事由コード() == null ? RString.EMPTY : daicho.get資格変更事由コード();
        LasdecCode 旧市町村コード = daicho.get旧市町村コード() == null ? LasdecCode.EMPTY : daicho.get旧市町村コード();
        LasdecCode 広住特措置元市町村コード = daicho.get広住特措置元市町村コード() == null ? LasdecCode.EMPTY : daicho.get広住特措置元市町村コード();

        return (!資格変更年月日.equals(henkoDaicho.get資格変更年月日()))
                || (!資格変更届出年月日.equals(henkoDaicho.get資格変更届出年月日()))
                || (!資格変更事由コード.equals(henkoDaicho.get資格変更事由コード()))
                || (!旧市町村コード.equals(henkoDaicho.get旧市町村コード()))
                || (!広住特措置元市町村コード.equals(henkoDaicho.get広住特措置元市町村コード()));
        //TODO n8178 城間 住民情報の反映をどうするか？
    }

    private HihokenshaDaicho setLogicalDelete(HihokenshaDaicho daicho) {
        HihokenshaDaichoBuilder builder = daicho.createBuilderForEdit();
        builder.set論理削除フラグ(true);
        return builder.build();
    }

    private HihokenshaDaicho setIdoDate(HihokenshaDaicho daicho, FlexibleDate idoDate, RString idoJiyuCode) {
        return daicho.createBuilderForEdit().set異動日(idoDate).set異動事由コード(idoJiyuCode).build().createNewCopyData();
    }

    private boolean isUpdate資格取得(HihokenshaDaicho daicho, ShikakuRirekiJoho 資格詳細情報) {
        FlexibleDate 資格取得日 = daicho.get資格取得年月日() == null ? FlexibleDate.EMPTY : daicho.get資格取得年月日();
        RString 資格取得事由コード = daicho.get資格取得事由コード() == null ? RString.EMPTY : daicho.get資格取得事由コード();

        return (!資格取得日.equals(資格詳細情報.getShutokuDate()))
                || (!資格取得事由コード.equals(資格詳細情報.getShutokuJiyuKey()));
    }

    private boolean isUpdate資格喪失(HihokenshaDaicho daicho, ShikakuRirekiJoho 資格詳細情報) {
        FlexibleDate 資格喪失日 = daicho.get資格喪失年月日() == null ? FlexibleDate.EMPTY : daicho.get資格喪失年月日();
        FlexibleDate 資格喪失届出日 = daicho.get資格喪失年月日() == null ? FlexibleDate.EMPTY : daicho.get資格喪失届出年月日();
        RString 資格喪失事由コード = daicho.get資格喪失年月日() == null ? RString.EMPTY : daicho.get資格喪失事由コード();

        return ((!nullOrEmpty(資格詳細情報.getSoshitsuDate())
                || !nullOrEmpty(資格詳細情報.getSoshitsuTodokedeDate())
                || !nullOrEmpty(資格詳細情報.getSoshitsuJiyuKey()))
                && (!資格喪失日.equals(資格詳細情報.getSoshitsuDate()))
                || (!資格喪失届出日.equals(資格詳細情報.getSoshitsuTodokedeDate()))
                || (!資格喪失事由コード.equals(資格詳細情報.getSoshitsuJiyuKey())));
    }

}
