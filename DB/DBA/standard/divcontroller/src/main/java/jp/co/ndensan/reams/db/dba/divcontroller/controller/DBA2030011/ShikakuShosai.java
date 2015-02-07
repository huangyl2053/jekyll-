/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.DBA2030011;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.JushochiTokureiMenuType;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.ShikakuShosaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.KihonJohoDiv;
import jp.co.ndensan.reams.db.dba.model.relate.shikakuido.JushochiTokureiModel;
import jp.co.ndensan.reams.db.dba.realservice.JushochiTokureiRegister;
import jp.co.ndensan.reams.db.dbz.business.config.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.kyotsutokei.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.business.hokensha.IDonyuHokensha;
import jp.co.ndensan.reams.db.dbz.business.hokensha.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.business.hokensha.KoikiKoseiShichosons;
import jp.co.ndensan.reams.db.dbz.business.util.CodeMasterToKeyValueFunction;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ContainsKyuShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.Lists;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.IJushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.util.JushochiTokureiExecutionStatus;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonJohoModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.realservice.KijunTsukiShichosonFinder;
import jp.co.ndensan.reams.db.dbz.realservice.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.db.dbz.realservice.ShisetsuNyutaishoTokureiTaishoRelateManager;
import jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.realservice.hokensha.IDonyuHokenshaLoader;
import jp.co.ndensan.reams.db.dbz.realservice.hokensha.IKoikiKoseiShichosonFinder;
import jp.co.ndensan.reams.db.dbz.realservice.hokensha.KoikiKoseiShichosonFinderFactory;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.code.CodeMasterHelper;
import jp.co.ndensan.reams.ur.urz.definition.code.ICodeShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.code.ICodeValueObject;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuShutokuJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.InformationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.DivcontrollerMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICallbackMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.SingleButtonType;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 住所地特例画面における、資格詳細Divのイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShosai {

    private ICodeShubetsu KaigoshikakuShutokuJiyuHihokensha;

    /**
     * 画面が読み込まれた際に実行します。<br/>
     * 前画面から渡されているViewStateの該当者情報と画面IDを元に、住所地特例異動で使用する各種共有子Divの初期化を行います。
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格詳細Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> initialize(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LasdecCode lasdecCode = new LasdecCode(controlData.getDonyuDantaiCode().getColumnValue());
        IDonyuHokensha donyuHokensha = new IDonyuHokenshaLoader().load();
        GappeiJohoKanriConfig gappeiConfig = new GappeiJohoKanriConfig();

        viewErrorMessage(shikakuShosaiDiv, taishoshaKey, controlData);

        HihokenshaDaichoManager daichoManager = new HihokenshaDaichoManager();
        IItemList<HihokenshaDaichoModel> daichoList = daichoManager.get被保険者台帳一覧DescOrderByShoriTimestamp(
                lasdecCode, taishoshaKey.get被保険者番号());
        if (!daichoList.isEmpty()) {
            daichoList = new HihokenshaDaichoList(daichoList).toOneSeasonList(daichoList.findFirst().get().get資格取得年月日());
        }
        ShisetsuNyutaishoTokureiTaishoRelateManager nyutaishoManager = new ShisetsuNyutaishoTokureiTaishoRelateManager();
        IItemList<ShisetsuNyutaishoRelateModel> nyutaishoRelateList
                = nyutaishoManager.get台帳別施設入退所List(taishoshaKey.get識別コード(), DaichoType.被保険者);

        initializeHokenshaJoho(shikakuShosaiDiv, daichoList.findFirst(), lasdecCode, taishoshaKey.get識別コード(), donyuHokensha, gappeiConfig, controlData);
        setDataOfShikakuTokuso(shikakuShosaiDiv, daichoList.findFirst(), lasdecCode, donyuHokensha, gappeiConfig);
        setDefaultDataOfCcd(shikakuShosaiDiv, daichoList, nyutaishoRelateList);

        setJushochiTokureiView(shikakuShosaiDiv, controlData);

        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }

    private void initializeHokenshaJoho(ShikakuShosaiDiv shikakuShosaiDiv, Optional<HihokenshaDaichoModel> hihoDaicho, LasdecCode lasdecCode,
            ShikibetsuCode shikibetsuCode, IDonyuHokensha donyuHokensha, GappeiJohoKanriConfig gappeiConfig, IUrControlData controlData) {

        if (!donyuHokensha.is広域保険者() && !gappeiConfig.is合併あり()) {

            shikakuShosaiDiv.getDdlShutokuShozaiHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getDdlShutokuSochimotoHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getDdlShutokuKyuHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getLblShutokuShozaiHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getLblShutokuSochimotoHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getLblKyuHokensha().setDisplayNone(true);
            initializeJushochiTokureiRirekiList(controlData, hihoDaicho, shikakuShosaiDiv.getCcdJushochiTokureiRirekiList(),
                    JushochiTokureiRirekiListDiv.HokenshaJohoDisplayMode.TanitsuGappeiNashi);
            shikakuShosaiDiv.getCcdShikakuHenkoRireki().initialize(lasdecCode, hihoDaicho.get().get旧市町村コード(),
                    ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiNashi);
        } else if (!donyuHokensha.is広域保険者() && gappeiConfig.is合併あり()) {

            shikakuShosaiDiv.getDdlShutokuShozaiHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getDdlShutokuSochimotoHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getDdlShutokuKyuHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getLblShutokuShozaiHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getLblShutokuSochimotoHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getLblKyuHokensha().setDisplayNone(false);
            initializeJushochiTokureiRirekiList(controlData, hihoDaicho, shikakuShosaiDiv.getCcdJushochiTokureiRirekiList(),
                    JushochiTokureiRirekiListDiv.HokenshaJohoDisplayMode.TanitsuGappeiAri);
            shikakuShosaiDiv.getCcdShikakuHenkoRireki().initialize(lasdecCode, hihoDaicho.get().get旧市町村コード(),
                    ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiAri);
        } else if (donyuHokensha.is広域保険者() && !gappeiConfig.is合併あり()) {

            shikakuShosaiDiv.getDdlShutokuShozaiHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getDdlShutokuSochimotoHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getDdlShutokuKyuHokensha().setDisplayNone(true);
            shikakuShosaiDiv.getLblShutokuShozaiHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getLblShutokuSochimotoHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getLblKyuHokensha().setDisplayNone(true);
            initializeJushochiTokureiRirekiList(controlData, hihoDaicho, shikakuShosaiDiv.getCcdJushochiTokureiRirekiList(),
                    JushochiTokureiRirekiListDiv.HokenshaJohoDisplayMode.KoikiGappeiNashi);
            shikakuShosaiDiv.getCcdShikakuHenkoRireki().initialize(lasdecCode, hihoDaicho.get().get旧市町村コード(),
                    ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiNashi);
        } else {

            shikakuShosaiDiv.getDdlShutokuShozaiHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getDdlShutokuSochimotoHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getDdlShutokuKyuHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getLblShutokuShozaiHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getLblShutokuSochimotoHokensha().setDisplayNone(false);
            shikakuShosaiDiv.getLblKyuHokensha().setDisplayNone(false);
            initializeJushochiTokureiRirekiList(controlData, hihoDaicho, shikakuShosaiDiv.getCcdJushochiTokureiRirekiList(),
                    JushochiTokureiRirekiListDiv.HokenshaJohoDisplayMode.KoikiGappeiAri);
            shikakuShosaiDiv.getCcdShikakuHenkoRireki().initialize(lasdecCode, hihoDaicho.get().get旧市町村コード(),
                    ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiAri);
        }

        shikakuShosaiDiv.getCcdShisetsuNyutaishoRirekiKanri().initialize(lasdecCode, shikibetsuCode);
    }

    private void initializeJushochiTokureiRirekiList(IUrControlData controlData, Optional<HihokenshaDaichoModel> hihoDaicho,
            IJushochiTokureiRirekiListDiv jutokuDiv, JushochiTokureiRirekiListDiv.HokenshaJohoDisplayMode hokenshaMode) {
        ViewExecutionStatus exeStatus;
        JushochiTokureiExecutionStatus jutokuExeStatus;

        JushochiTokureiMenuType menuType = JushochiTokureiMenuType.toValue(controlData.getMenuID());
        switch (menuType) {
            case DBAMN25001_届出により適用:
            case DBAMN61002_転入転出保留対象者管理:
                exeStatus = ViewExecutionStatus.Add;
                jutokuExeStatus = JushochiTokureiExecutionStatus.Tekiyo;
                break;
            case DBAMN25002_届出により解除:
                exeStatus = ViewExecutionStatus.Modify;
                jutokuExeStatus = JushochiTokureiExecutionStatus.Kaijo;
                break;
            case DBAMN25003_届出により施設変更:
            case DBAMN52002_合併前の住所地特例措置解除:
            default:
                //TODO n8178 城間篤人 動作のために一時的に設定。後日必要な設定を確認した後に修正する。
                exeStatus = ViewExecutionStatus.Add;
                jutokuExeStatus = JushochiTokureiExecutionStatus.Tekiyo;
                break;
        }
        jutokuDiv.initialize(hihoDaicho.get().get旧市町村コード(), exeStatus, jutokuExeStatus, hokenshaMode);
    }

    private void setDataOfShikakuTokuso(ShikakuShosaiDiv shikakuShosaiDiv, Optional<HihokenshaDaichoModel> hihoDaicho, LasdecCode lasdecCode,
            IDonyuHokensha donyuHokensha, GappeiJohoKanriConfig gappeiConfig) {
        HihokenshaDaichoModel daichoModel = hihoDaicho.get();
        shikakuShosaiDiv.getTxtShutokuDate().setValue(daichoModel.get資格取得年月日());
        shikakuShosaiDiv.getTxtShutokuTodokedeDate().setValue(daichoModel.get資格取得届出年月日());
        List<KaigoShikakuShutokuJiyu> shutokuJiyuList = CodeMasterHelper.getCode(URZCodeShubetsu.介護資格取得事由);

        shikakuShosaiDiv.getDdlShutokuJiyu().setDataSource(
                ItemList.of(shutokuJiyuList).map(new CodeMasterToKeyValueFunction()).toList());
        if (!daichoModel.getEntity().getShikakuShutokuJiyuCode().getColumnValue().isEmpty()) {
            shikakuShosaiDiv.getDdlShutokuJiyu().setSelectedKey(daichoModel.get資格取得事由().getCode());
        }

        KeyValueDataSource hihoKubun1 = new KeyValueDataSource(HihokenshaKubun.第1号被保険者.code(), HihokenshaKubun.第1号被保険者.get略称());
        KeyValueDataSource hihoKubun2 = new KeyValueDataSource(HihokenshaKubun.第2号被保険者.code(), HihokenshaKubun.第2号被保険者.get略称());
        shikakuShosaiDiv.getDdlHihoKubun().setDataSource(Lists.newArrayList(hihoKubun1, hihoKubun2));
        shikakuShosaiDiv.getDdlHihoKubun().setSelectedKey(daichoModel.get被保険者区分コード());

        if (donyuHokensha.is広域保険者()) {
            //TODO n8178 城間篤人 生産性評価の対象でないため未実装　今後の回収で実装を行う
            //
            //1, 所在保険者の設定
            //広域の場合、Atenaから取得できる地区コード3（もしくはそれに代わるもの）から情報を取得する。（初期設定）
            //もしくは、住所地特例処理の中で設定した住民情報に合わせて変更を行う。（実行中のイベント）
            //DDLの内容は住民情報の候補に挙がる保険者の一覧？（設定は不要のため、内容を考慮する必要は無いかもしれない）
            //
            //2, 措置元保険者の設定
            //広域構成市町村の情報を、DDLに設定する。
            //DDLに設定した情報から、台帳情報に持つ措置元保険者情報に一致するものを選択する。
            shikakuShosaiDiv.getDdlShutokuShozaiHokensha().setDataSource(null);
            shikakuShosaiDiv.getDdlShutokuSochimotoHokensha().setDataSource(null);
        } else {

            KeyValueDataSource shozaihokenshaSource = new KeyValueDataSource(donyuHokensha.get証記載保険者番号().getColumnValue(),
                    donyuHokensha.get保険者名().value());
            shikakuShosaiDiv.getDdlShutokuShozaiHokensha().setDataSource(Lists.newArrayList(shozaihokenshaSource));
            shikakuShosaiDiv.getDdlShutokuSochimotoHokensha().setDataSource(Lists.newArrayList(new KeyValueDataSource()));
        }

        if (gappeiConfig.is合併あり()) {
            KijunTsukiShichosonFinder finder = new KijunTsukiShichosonFinder();
            Optional<GappeiShichosonJohoModel> gappeiInfo = finder.get基準月市町村情報(FlexibleDate.getNowDate().getYearMonth(),
                    hihoDaicho.get().get旧市町村コード());
            gappeiInfo.get().get単一市町村情報();

            IFunction function = new IFunction<IGappeiShichoson, KeyValueDataSource>() {
                @Override
                public KeyValueDataSource apply(IGappeiShichoson targetModel) {
                    return new KeyValueDataSource(targetModel.get旧市町村コード().getColumnValue(), targetModel.get旧市町村名称());
                }
            };
            shikakuShosaiDiv.getDdlShutokuKyuHokensha().setDataSource(gappeiInfo.get().get単一市町村情報().map(function).toList());
            shikakuShosaiDiv.getDdlShutokuKyuHokensha().setSelectedKey(hihoDaicho.get().get旧市町村コード().getColumnValue());
        }

        shikakuShosaiDiv.getTxtSoshitsuDate().setValue(daichoModel.get資格喪失年月日());
        shikakuShosaiDiv.getTxtSoshitsuTodokedeDate().setValue(daichoModel.get資格喪失届出年月日());

        List<KaigoShikakuSoshitsuJiyu> sositsuJiyuList = CodeMasterHelper.getCode(URZCodeShubetsu.介護資格喪失事由);
        shikakuShosaiDiv.getDdlSoshitsuJiyu().setDataSource(
                ItemList.of(sositsuJiyuList).map(new CodeMasterToKeyValueFunction()).toList());

        if (!daichoModel.getEntity().getShikakuSoshitsuJiyuCode().getColumnValue().isEmpty()) {
            shikakuShosaiDiv.getDdlSoshitsuJiyu().setSelectedKey(daichoModel.get資格喪失事由().getCode());
        }

        shikakuShosaiDiv.getTblShikakuShosai().setDisabled(true);
    }

    //TODO n8178 城間篤人 生産性評価では広域の考慮が不要なため、一時的にコメントアウト
//
//    private List<KeyValueDataSource> createKoseiShichosonDataSource() {
//        IKoikiKoseiShichosonFinder koikiJohoFinder = KoikiKoseiShichosonFinderFactory.createInstance();
//        KoikiKoseiShichosons koseiShichoson = koikiJohoFinder.load広域構成市町村(ContainsKyuShichoson.旧市町村を含まない);
//        IFunction koikiShichosonDataSource = new IFunction<IKoikiKoseiShichoson, KeyValueDataSource>() {
//            @Override
//            public KeyValueDataSource apply(IKoikiKoseiShichoson t) {
//                return new KeyValueDataSource(t.get市町村コード().getColumnValue(), t.get市町村名());
//            }
//        };
//        IItemList<KeyValueDataSource> dataSource = koseiShichoson.asItemList().map(koikiShichosonDataSource);
//        return dataSource.toList();
//    }
    private void setDefaultDataOfCcd(ShikakuShosaiDiv shikakuShosaiDiv, IItemList<HihokenshaDaichoModel> daichoList,
            IItemList<ShisetsuNyutaishoRelateModel> nyutaishoRelateList) {
        shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().set被保険者台帳情報(daichoList);
        shikakuShosaiDiv.getCcdShikakuHenkoRireki().set資格関連異動履歴(daichoList);
        shikakuShosaiDiv.getCcdShisetsuNyutaishoRirekiKanri().set施設入退所履歴(nyutaishoRelateList);
    }

    private void setJushochiTokureiView(ShikakuShosaiDiv shikakuShosaiDiv, IUrControlData controlData) {
        JushochiTokureiMenuType menuType = JushochiTokureiMenuType.toValue(controlData.getMenuID());
        switch (menuType) {
            case DBAMN25001_届出により適用:
                shikakuShosaiDiv.getTabShisakuShosaiRireki().setSelectedItem(shikakuShosaiDiv.getTplJutoku());
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.toroku);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setMeisaiDisplayMode(
                        JushochiTokureiRirekiListDiv.MeisaiDisplayMode.tekiyoInput);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setAddButtonDisplay(
                        JushochiTokureiRirekiListDiv.BtnDisplayMode.SetDisplay);
                break;
            case DBAMN25002_届出により解除:
                shikakuShosaiDiv.getTabShisakuShosaiRireki().setSelectedItem(shikakuShosaiDiv.getTplJutoku());
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.toroku);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setMeisaiDisplayMode(
                        JushochiTokureiRirekiListDiv.MeisaiDisplayMode.kaijoInput);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setAddButtonDisplay(
                        JushochiTokureiRirekiListDiv.BtnDisplayMode.SetDisplayNone);
                break;
            case DBAMN25003_届出により施設変更:
                shikakuShosaiDiv.getTabShisakuShosaiRireki().setSelectedItem(shikakuShosaiDiv.getTplShisetsuNyutaisho());
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.shokai);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setMeisaiDisplayMode(
                        JushochiTokureiRirekiListDiv.MeisaiDisplayMode.displayNone);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setAddButtonDisplay(
                        JushochiTokureiRirekiListDiv.BtnDisplayMode.SetDisplayNone);
                break;
            case DBAMN52002_合併前の住所地特例措置解除:
                shikakuShosaiDiv.getTabShisakuShosaiRireki().setSelectedItem(shikakuShosaiDiv.getTplJutoku());
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.toroku);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setMeisaiDisplayMode(
                        JushochiTokureiRirekiListDiv.MeisaiDisplayMode.kaijoInput);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setAddButtonDisplay(
                        JushochiTokureiRirekiListDiv.BtnDisplayMode.SetDisplayNone);
                break;
            case DBAMN61002_転入転出保留対象者管理:
                shikakuShosaiDiv.getTabShisakuShosaiRireki().setSelectedItem(shikakuShosaiDiv.getTplJutoku());
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.toroku);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setMeisaiDisplayMode(
                        JushochiTokureiRirekiListDiv.MeisaiDisplayMode.tekiyoInput);
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setAddButtonDisplay(
                        JushochiTokureiRirekiListDiv.BtnDisplayMode.SetDisplay);
                break;
            default:
                break;
        }
    }

    private void viewErrorMessage(ShikakuShosaiDiv shikakuShosaiDiv, TaishoshaKey taishoshaKey, IUrControlData controlData) {
        JushochiTokureiMenuType menuType = JushochiTokureiMenuType.toValue(controlData.getMenuID());

        switch (menuType) {
            case DBAMN25001_届出により適用:
            case DBAMN61002_転入転出保留対象者管理:
                if (is住所地特例適用者(taishoshaKey, controlData)) {
                    shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.shokai);

                    //TODO n8178 城間篤人 ApplicationExceptionでの実装ではメニューに遷移してしまうため問題がある。調査後、適切な処理に置き換える必要がある。 2015年3月
                    throw new ApplicationException(DbaErrorMessages.住所地特例として適用済.getMessage());
                }
                break;
            case DBAMN25002_届出により解除:
            case DBAMN25003_届出により施設変更:
            case DBAMN52002_合併前の住所地特例措置解除:
                if (!is住所地特例適用者(taishoshaKey, controlData)) {
                    shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.shokai);

                    //TODO n8178 城間篤人 ApplicationExceptionでの実装ではメニューに遷移してしまうため問題がある。調査後、適切な処理に置き換える必要がある。 2015年3月
                    throw new ApplicationException(DbaErrorMessages.住所地特例として未適用.getMessage());
                }
                break;
        }

    }

    private boolean is住所地特例適用者(TaishoshaKey taishoshaKey, IUrControlData controlData) {

        HihokenshaDaichoManager daichoManager = new HihokenshaDaichoManager();
        Optional<HihokenshaDaichoModel> daicho = daichoManager.
                get最新被保険者台帳(new LasdecCode(controlData.getDonyuDantaiCode().getColumnValue()), taishoshaKey.get識別コード());

        return !(is住所地特例未適用(daicho.get()) || is住所地特例解除済み(daicho.get()));
    }

    private boolean is住所地特例未適用(HihokenshaDaichoModel daicho) {
        return daicho.get住所地特例適用事由() == null
                || daicho.get適用届出年月日() == null
                || daicho.get適用年月日() == null;
    }

    private boolean is住所地特例解除済み(HihokenshaDaichoModel daicho) {
        return daicho.get住所地特例解除事由() != null
                || daicho.get解除届出年月日() != null
                || daicho.get解除年月日() != null;
    }

    /**
     * 共通ボタンエリアの、該当者一覧へ戻るためのボタンが押下された際に実行します。<br/>
     *
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格詳細Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onClick_btnBackGaitoshaIchiran(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        return checkInputDataBeforeBack(shikakuShosaiDiv);
    }

    /**
     * 共通ボタンエリアの、再検索を行うボタンが押下された際に実行します。<br/>
     *
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格詳細Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onClick_btnResearch(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        return checkInputDataBeforeBack(shikakuShosaiDiv);
    }

    private ResponseData<ShikakuShosaiDiv> checkInputDataBeforeBack(ShikakuShosaiDiv shikakuShosaiDiv) {

        ResponseData<ShikakuShosaiDiv> response = new ResponseData<>();
        if (shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().hasChanged()
                || shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().hasChangedInMeisai()
                || shikakuShosaiDiv.getCcdShisetsuNyutaishoRirekiKanri().hasChanged()
                || shikakuShosaiDiv.getCcdShisetsuNyutaishoRirekiKanri().hasChangedInMeisai()) {
            response.data = shikakuShosaiDiv;
            return response;
        }

        QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                UrQuestionMessages.入力内容の破棄.getMessage().evaluate(), "はい", "いいえ");

        response.addMessage(message);
        response.data = shikakuShosaiDiv;
        return response;
    }

    /**
     * {@link ShikakuShosai#onClick_btnUpdate}の処理が実行される前に、自動的に実行されるイベントです。<br/>
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onBeforeClick_btnUpdate(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        ResponseData<ShikakuShosaiDiv> response = new ResponseData<>();

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(
                ShikakuShosaiValidationHelper.validate保存前(null, null, null, null, null, JushochiTokureiExecutionStatus.Kaijo)
        );

        response.addValidationMessages(pairs);
        response.data = shikakuShosaiDiv;
        return response;
    }

    /**
     * 共通ボタンエリアの、住所地特例画面で入力した全ての情報を保存するためのボタンが押下された際に実行します。<br/>
     * 住所地特例情報と施設入退所情報が変更されているかを確認します。変更が無い場合はエラーメッセージをダイアログで表示します。<br/>
     * 変更が存在する場合は、保存処理を行うか否かを確認するダイアログを表示します。
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onClick_btnUpdate(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) throws InformationException {
        if (shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().hasChanged()) {

            return onClick_btnUpdate_onYes(shikakuShosaiDiv, kihonDiv);

            //TODO n8178 城間篤人 メッセージの「はい」をクリックする前に、状態遷移が動作してしまうため、確認用メッセージ表示を一時取りやめ。
//            ResponseData<ShikakuShosaiDiv> response = new ResponseData<>();
//            ICallbackMethod methodYes = DivcontrollerMethod.method(SingleButtonType.Free, "onClick_btnUpdate_onYes");
//            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
//                    UrQuestionMessages.保存の確認.getMessage().evaluate(), "はい", "いいえ");
//            ICallbackMethod[] methods = {methodYes};
//            message.addInvokeMethod(methods);
//            response.addMessage(message);
//            response.data = shikakuShosaiDiv;
//            return response;
        }

        //TODO n8178 城間篤人 ApplicationExceptionでの実装ではメニューに遷移してしまうため問題がある。調査後、適切な処理に置き換える必要がある。 2015年3月
        throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());

    }

    /**
     * onClick_btnUpdate実行後に表示される保存確認ダイアログで、はいを選択した場合に実行されます。<br/>
     * 被保険者台帳情報と施設入退所情報を同時に更新します。
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onClick_btnUpdate_onYes(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {

        IFunction function = new IFunction<ShisetsuNyutaishoRelateModel, ShisetsuNyutaishoModel>() {
            @Override
            public ShisetsuNyutaishoModel apply(ShisetsuNyutaishoRelateModel t) {
                return t.get介護保険施設入退所モデル();
            }
        };

        JushochiTokureiModel jutokuModel = new JushochiTokureiModel(
                shikakuShosaiDiv.getCcdJushochiTokureiRirekiList().get被保険者台帳情報().toList(),
                shikakuShosaiDiv.getCcdShisetsuNyutaishoRirekiKanri().get施設入退所履歴().map(function).toList()
        );

        new JushochiTokureiRegister().save(jutokuModel);
        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }

    /**
     * {@link ShikakuShosai#onClick_btnUpdate}の処理が正常に完了した後に、自動的に実行されるイベントです。<br/>
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> onAfterClick_btnUpdate(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }

}
