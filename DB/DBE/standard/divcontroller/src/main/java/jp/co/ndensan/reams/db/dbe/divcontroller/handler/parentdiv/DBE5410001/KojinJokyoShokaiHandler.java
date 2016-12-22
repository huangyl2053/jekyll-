/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5410001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.ChosaKekkaInfoKihonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.TokiJikouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoirai.ShujiiIkenshoIraiBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfokihon.ChosaKekkaInfoKihonParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kojinjokyoshokai.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001.KojinJokyoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiilenshoitem.ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoFinder;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfokihon.ChosaKekkaInfoKihonFinder;
import jp.co.ndensan.reams.db.dbe.service.core.basic.kojinjokyoshokai.KojinJokyoShokaiFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshoiraishokai.ShujiiIkenshoIraiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosairaishokai.NinteiChosaIraiShokaiMaster;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaijohokojin.KaisaiKekkaAndBashoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
//import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
//import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
//import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
//import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
//import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
//import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
//import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
//import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.IsExistJohoTeikyoDoui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShienShinseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.ninteichosairaishokai.NinteiChosaIraiShokaiFinder;
import jp.co.ndensan.reams.db.dbz.service.core.shinsakaijohokojin.ShinsakaiJohoKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定個人状況照会のハンドラークラスです。
 *
 * @reamsid_L DBE-0200-010 suguangjun
 */
public class KojinJokyoShokaiHandler {

    private final List<RString> 指定医フラグ = new ArrayList<>();
    private final Code 識別コード_09A = new Code("09A");
    private final Code 識別コード_09B = new Code("09B");
    private final RString 指定医 = new RString("指定医");
    private final KojinJokyoShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定個人状況照会div
     */
    public KojinJokyoShokaiHandler(KojinJokyoShokaiDiv div) {
        this.div = div;
    }

    /**
     * 要介護認定個人状況のデータを設定します。
     *
     * @param kojinJokyoShokaiList 要介護認定個人状況データ
     * @param 申請書管理番号 申請書管理番号
     */
    public void setKojinJokyoShokai(List<KojinJokyoShokai> kojinJokyoShokaiList, RString 申請書管理番号) {
        div.getCcdNinteiShinseishaKihonInfo().initialize(new ShinseishoKanriNo(申請書管理番号));
        div.setHihokenshano(kojinJokyoShokaiList.get(0).get被保番号());
        div.setShoKisaiHokenshaNo(kojinJokyoShokaiList.get(0).get保険者番号());
        div.getShujiiIryokikaknAndShujiiInput().getTxtShujiiIryoKikanCode().setValue(kojinJokyoShokaiList.get(0).get主治医医療機関コード());
        div.getShujiiIryokikaknAndShujiiInput().getTxtShujiiIryoKikanName().setValue(kojinJokyoShokaiList.get(0).get医療機関名称());
        div.getShujiiIryokikaknAndShujiiInput().getTxtShujiiCode().setValue(kojinJokyoShokaiList.get(0).get主治医コード());
        div.getShujiiIryokikaknAndShujiiInput().getTxtShujiiName().setValue(kojinJokyoShokaiList.get(0).get主治医氏名());
        div.getChosaItakusakiAndChosainGuide().getTxtChosaItakusakiCode().setValue(kojinJokyoShokaiList.get(0).get認定調査委託先コード());
        div.getChosaItakusakiAndChosainGuide().getTxtChosaItakusakiName().setValue(kojinJokyoShokaiList.get(0).get事業者名称());
        div.getChosaItakusakiAndChosainGuide().getTxtNinteiChosainCode().setValue(kojinJokyoShokaiList.get(0).get認定調査員コード());
        div.getChosaItakusakiAndChosainGuide().getTxtNinteiChosainName().setValue(kojinJokyoShokaiList.get(0).get調査員氏名());
        getchkShiteii(kojinJokyoShokaiList);
        getKojinJokyoShokai1(kojinJokyoShokaiList);
        getKojinJokyoShokai2(kojinJokyoShokaiList);
    }

    /**
     * 未登録時ボタン非活性。
     *
     * @param div 要介護認定個人状況照会div
     */
    public void 未登録時ボタン非活性(KojinJokyoShokaiDiv div) {

        div.getBtnRenrakusaki().setDisabled(true);
        div.getBtnShujiiIkenshoShokai().setDisabled(true);
        div.getBtnNinteiChosaIraiShokai().setDisabled(true);
        div.getBtnChosaKekkaInfoGaikyo().setDisabled(true);
        div.getBtnChosaKekkaInfoKihon().setDisabled(true);
        div.getBtnShichosonRenrakuJiko().setDisabled(true);
        div.getBtnShujiiIkenshoSakuseiIraiShokai().setDisabled(true);
        div.getBtnShinsakaiJoho().setDisabled(true);
    }

    /**
     * ボタン非活性。
     *
     */
    public void ボタン非活性() {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 主治医意見書作成依頼履歴番号 = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class);
        int 認定調査依頼履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString 審査会開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(new ShinseishoKanriNo(申請書管理番号));
        KojinJokyoShokaiFinder kojinJokyoShokaiFinder = KojinJokyoShokaiFinder.createInstance();
        List<RenrakusakiJoho> rakusakiJohoList = kojinJokyoShokaiFinder.getRenrakusakiJoho(parameter).records();
        if (rakusakiJohoList.isEmpty()) {
            div.getBtnRenrakusaki().setDisabled(true);
        }

        List<NinteiChosaIraiShokaiMaster> ninteiChosaList = NinteiChosaIraiShokaiFinder.createInstance().getNinteiChousaJouhou(申請書管理番号).records();
        if (ninteiChosaList.isEmpty()) {
            div.getBtnNinteiChosaIraiShokai().setDisabled(true);
        }

        RString 概況調査テキスト_イメージ区分 = RString.EMPTY;
        RString 概況特記テキスト_イメージ区分 = RString.EMPTY;
        ChosaKekkaInfoGaikyoParameter gaikyoParameter = ChosaKekkaInfoGaikyoParameter.
                createGamenParam(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキスト_イメージ区分, 概況特記テキスト_イメージ区分);
        List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList
                = ChosaKekkaInfoGaikyoFinder.createInstance().getChosaKekkaInfoGaikyo(gaikyoParameter).records();
        if (chosaKekkaInfoGaikyoList == null || chosaKekkaInfoGaikyoList.isEmpty()) {
            概況調査テキスト_イメージ区分 = TokkijikoTextImageKubun.テキスト.getコード();
            概況特記テキスト_イメージ区分 = TokkijikoTextImageKubun.テキスト.getコード();
        } else {
            概況調査テキスト_イメージ区分 = chosaKekkaInfoGaikyoList.get(0).get概況調査テキストイメージ区分();
            概況特記テキスト_イメージ区分 = chosaKekkaInfoGaikyoList.get(0).get概況調査テキストイメージ区分();
        }
        gaikyoParameter = ChosaKekkaInfoGaikyoParameter.createGamenParam(
                申請書管理番号, 認定調査依頼履歴番号, 概況調査テキスト_イメージ区分, 概況特記テキスト_イメージ区分);
        List<RembanServiceJokyoBusiness> serviceJokyos
                = ChosaKekkaInfoGaikyoFinder.createInstance().getRembanServiceJokyo(gaikyoParameter).records();
        List<NinteichosahyoShisetsuRiyo> shisetsuRiyos
                = ChosaKekkaInfoGaikyoFinder.createInstance().get5210NinteichosahyoShisetsu(gaikyoParameter).records();
        if ((chosaKekkaInfoGaikyoList == null || chosaKekkaInfoGaikyoList.isEmpty()) && serviceJokyos.isEmpty() && shisetsuRiyos.isEmpty()) {
            div.getBtnChosaKekkaInfoGaikyo().setDisabled(true);
        }

        ChosaKekkaInfoKihonParameter kihonParameter = ChosaKekkaInfoKihonParameter.
                createGamenParam(申請書管理番号, 認定調査依頼履歴番号);
        List<ChosaKekkaInfoKihonBusiness> infoKihonList
                = ChosaKekkaInfoKihonFinder.createInstance().getChosaKekkaInfoKihon(kihonParameter).records();
        List<TokiJikouBusiness> serviceJokyosKihon
                = ChosaKekkaInfoKihonFinder.createInstance().getTokiJikou(kihonParameter).records();
        if (infoKihonList.isEmpty() && serviceJokyosKihon.isEmpty()) {
            div.getBtnChosaKekkaInfoKihon().setDisabled(true);
        }

        ShujiiIkenshoIraiShokaiFinder finder = ShujiiIkenshoIraiShokaiFinder.createInstance();
        List<ShujiiIkenshoIraiBusiness> 認定調査情報 = finder.getNinnteiChousa(申請書管理番号).records();
        if (認定調査情報.isEmpty()) {
            div.getBtnShujiiIkenshoSakuseiIraiShokai().setDisabled(true);
        }

        List<ShujiiIkenshoIkenItemEntity> entityList = ShujiiIkenshoIkenItemManager.createInstance().select主治医意見書(new ShinseishoKanriNo(申請書管理番号), Integer.parseInt(主治医意見書作成依頼履歴番号.toString()));
        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        Image イメージ情報 = imageManager.getイメージ情報(new ShinseishoKanriNo(申請書管理番号));
        if (entityList.isEmpty() && イメージ情報 == null) {
            div.getBtnShujiiIkenshoShokai().setDisabled(true);
        }

        KaisaiKekkaAndBashoJoho kaisai = new KaisaiKekkaAndBashoJoho(ShinsakaiJohoKojinFinder.createInstance().onLoad1(new ShinseishoKanriNo(申請書管理番号), 審査会開催番号));
        if (RString.isNullOrEmpty(kaisai.get介護認定審査会開催番号())) {
            div.getBtnShinsakaiJoho().setDisabled(true);
        }

    }

    private void getchkShiteii(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        RString 医師区分 = RString.EMPTY;
        if (kojinJokyoShokaiList.get(0).get医師区分コード() != null && !kojinJokyoShokaiList.get(0).get医師区分コード().isEmpty()) {
            医師区分 = IshiKubunCode.toValue(kojinJokyoShokaiList.get(0).get医師区分コード().value()).get名称();
        }
        if (指定医.equals(医師区分)) {
            指定医フラグ.clear();
            指定医フラグ.add(new RString("key0"));
            div.getChkShiteii().setSelectedItemsByKey(指定医フラグ);
        } else {
            指定医フラグ.clear();
            div.getChkShiteii().setSelectedItemsByKey(指定医フラグ);
        }
    }

    private void getKojinJokyoShokai1(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        if (kojinJokyoShokaiList.get(0).get認定調査依頼予定年月日() != null) {
            div.getTxtChosaIraiYoteiDate().setValue(new RDate(kojinJokyoShokaiList.get(0).get認定調査依頼予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定調査予定年月日() != null) {
            div.getTxtChosahyoNyushuYoteiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get認定調査予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get主治医意見書作成依頼予定年月日() != null) {
            div.getTxtIkenshoIraiYoteiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get主治医意見書作成依頼予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get主治医意見書登録予定年月日() != null) {
            div.getTxtIkenshoNyushuYoteiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get主治医意見書登録予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get要介護認定一次判定予定年月日() != null) {
            div.getTxtIchijiHanteiYoteiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get要介護認定一次判定予定年月日().toString()));
        }
        div.getTxtMaskingYoteiDate().setValue(null);
        if (kojinJokyoShokaiList.get(0).get認定審査会割当予定年月日() != null) {
            div.getTxtShinsakaiTorokuYoteiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get認定審査会割当予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定審査会予定年月日() != null) {
            div.getTxtNijiHanteiYoteiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get認定審査会予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定調査依頼完了年月日() != null) {
            div.getTxtChosaIraiJissekiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get認定調査依頼完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定調査完了年月日() != null) {
            div.getTxtChosahyoNyushuJissekiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get認定調査完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get主治医意見書作成依頼完了年月日() != null) {
            div.getTxtIkenshoIraiJissekiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get主治医意見書作成依頼完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get主治医意見書登録完了年月日() != null) {
            div.getTxtIkenshoNyushuJissekiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get主治医意見書登録完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get要介護認定一次判定完了年月日() != null) {
            div.getTxtIchijiHanteiJissekiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get要介護認定一次判定完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).getマスキング完了年月日() != null) {
            div.getTxtMaskingJissekiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).getマスキング完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定審査会割当完了年月日() != null) {
            div.getTxtShinsakaiTorokuJissekiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get認定審査会割当完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定審査会完了年月日() != null) {
            div.getTxtNijiHanteiJissekiDate().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get認定審査会完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定申請年月日() != null) {
            div.getTxtNinteiShinseiDay().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get認定申請年月日().toString()));
        }
    }

    private void getKojinJokyoShokai2(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        if (kojinJokyoShokaiList.get(0).get認定申請区分申請時() != null && !kojinJokyoShokaiList.get(0).get認定申請区分申請時().isEmpty()) {
            div.getTxtShinseiKubunShinseiji().setValue(NinteiShinseiShinseijiKubunCode.
                    toValue(new RString(kojinJokyoShokaiList.get(0).get認定申請区分申請時().toString())).get名称());
        }
        if (識別コード_09A.equals(kojinJokyoShokaiList.get(0).get厚労省IF識別コード())
                || 識別コード_09B.equals(kojinJokyoShokaiList.get(0).get厚労省IF識別コード())) {
            if (kojinJokyoShokaiList.get(0).get認定申請区分法令時() != null && !kojinJokyoShokaiList.get(0).get認定申請区分法令時().isEmpty()) {
                div.getTxtShinseiKubunHorei().setValue(NinteiShinseiHoreiCode.
                        toValue(kojinJokyoShokaiList.get(0).get認定申請区分法令時().value()).get名称());
            }
        } else {
            div.getTxtShinseiKubunHorei().setValue(RString.EMPTY);
        }
        set認定結果(kojinJokyoShokaiList);
        if (kojinJokyoShokaiList.get(0).get二次判定年月日() != null && !kojinJokyoShokaiList.get(0).get二次判定年月日().isEmpty()) {
            div.getTxtNijiHanteiYMD().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get二次判定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get二次判定認定有効開始年月日() != null && !kojinJokyoShokaiList.get(0).get二次判定認定有効開始年月日().isEmpty()) {
            div.getTxtNinteiYukoKikanFrom().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get二次判定認定有効開始年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get二次判定認定有効終了年月日() != null && !kojinJokyoShokaiList.get(0).get二次判定認定有効終了年月日().isEmpty()) {
            div.getTxtNinteiYukoKikanTo().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get二次判定認定有効終了年月日().toString()));
        }
        div.getTxtNinteiKikanMonth().setValue(new Decimal(kojinJokyoShokaiList.get(0).get二次判定認定有効期間()));
        if (kojinJokyoShokaiList.get(0).get要支援申請の区分() != null) {
            div.getTxtShinseiShubetsu().setValue(ShienShinseiKubun.
                    toValue(new RString(kojinJokyoShokaiList.get(0).get要支援申請の区分().toString())).get名称());
        }
        if (kojinJokyoShokaiList.get(0).get二号特定疾病コード() != null && !kojinJokyoShokaiList.get(0).get二号特定疾病コード().isEmpty()) {
            div.getTxtTokuteiShippei().setValue(TokuteiShippei.
                    toValue(new RString(kojinJokyoShokaiList.get(0).get二号特定疾病コード().toString())).get名称());
        }
        div.getTxtJohoTeikyoDoi().setValue(IsExistJohoTeikyoDoui.
                toValue(kojinJokyoShokaiList.get(0).is情報提供への同意有無()).get名称());
        set一次判定結果(kojinJokyoShokaiList);
        if (kojinJokyoShokaiList.get(0).get一次判定年月日() != null && !kojinJokyoShokaiList.get(0).get一次判定年月日().isEmpty()) {
            div.getTxtIchijiHanteiYMD().setValue(new RDate(
                    kojinJokyoShokaiList.get(0).get一次判定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get処理状態区分() != null && !kojinJokyoShokaiList.get(0).get処理状態区分().isEmpty()) {
            div.getTxtShoriKubun().setValue(ShoriJotaiKubun.
                    toValue(new RString(kojinJokyoShokaiList.get(0).get処理状態区分().toString())).get名称());
        }
    }

    private void set認定結果(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        div.getTxtNinteiKekka().setValue(kojinJokyoShokaiList.get(0).get二次判定結果名称());
    }

    private void set一次判定結果(List<KojinJokyoShokai> kojinJokyoShokaiList) {
//<<<<<<< HEAD
        div.getTxtIchijiHantei().setValue(kojinJokyoShokaiList.get(0).get一次判定結果名称());
        div.getTxtIchijiHanteiKeikokuCode().setValue(kojinJokyoShokaiList.get(0).get一次判定警告コード());
//=======
//        RString 一次判定結果 = RString.EMPTY;
//        RString 一次判定結果認知症加算 = RString.EMPTY;
//        if (識別コード_09A.equals(kojinJokyoShokaiList.get(0).get厚労省IF識別コード())
//                || 識別コード_09B.equals(kojinJokyoShokaiList.get(0).get厚労省IF識別コード())) {
//            if (kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード() != null
//                    && !kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().isEmpty()) {
//                一次判定結果 = IchijiHanteiKekkaCode09.
//                        toValue(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().value()).get名称();
//            }
//        } else if (識別コード_06A.equals(kojinJokyoShokaiList.get(0).get厚労省IF識別コード())) {
//            if (kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード() != null
//                    && !kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().isEmpty()) {
//                一次判定結果 = IchijiHanteiKekkaCode06.
//                        toValue(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().value()).get名称();
//            }
//        } else if (識別コード_02A.equals(kojinJokyoShokaiList.get(0).get厚労省IF識別コード())) {
//            if (kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード() != null
//                    && !kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().isEmpty()) {
//                一次判定結果 = IchijiHanteiKekkaCode02.
//                        toValue(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().value()).get名称();
//            }
//        } else if (識別コード_99A.equals(kojinJokyoShokaiList.get(0).get厚労省IF識別コード())
//                && kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード() != null
//                && !kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().isEmpty()) {
//            一次判定結果 = IchijiHanteiKekkaCode99.
//                    toValue(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().value()).get名称();
//        }
//        if (kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード認知症加算() != null
//                && !kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード認知症加算().isEmpty()) {
//            一次判定結果認知症加算 = IchijiHanteiKekkaCode09.
//                    toValue(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード認知症加算().value()).get名称();
//        }
//        if (kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().equals(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード認知症加算())) {
//            div.getTxtIchijiHantei().setValue(一次判定結果認知症加算);
//        } else {
//            RStringBuilder 一次判定 = new RStringBuilder();
//            一次判定.append(一次判定結果);
//            if (!RString.isNullOrEmpty(一次判定結果) && !RString.isNullOrEmpty(一次判定結果認知症加算)) {
//                一次判定.append("→");
//            }
//            一次判定.append(一次判定結果認知症加算);
//            div.getTxtIchijiHantei().setValue(一次判定.toRString());
//        }
//>>>>>>> origin/sync
    }

    /**
     * 要介護認定個人状況のデータを設定します。
     *
     * @param kojinJokyoShokaiList 要介護認定個人状況データ
     * @return KojinShinchokuJokyohyoEntity
     */
    public KojinShinchokuJokyohyoJoho setKojinShinchokuJokyohyo(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        return getKojinShinchokuJokyohyo(kojinJokyoShokaiList);
    }

    private KojinShinchokuJokyohyoJoho getKojinShinchokuJokyohyo(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        KojinShinchokuJokyohyoJoho jokyohyoEntity = new KojinShinchokuJokyohyoJoho();
        jokyohyoEntity.setHihokenshaNo(kojinJokyoShokaiList.get(0).get被保険者番号());
        jokyohyoEntity.setShinseiKubun(NinteiShinseiShinseijiKubunCode.toValue(
                kojinJokyoShokaiList.get(0).get認定申請区分申請時コード().getColumnValue()).get名称());
        jokyohyoEntity.setHihokenshaNameKana(kojinJokyoShokaiList.get(0).get被保険者氏名カナ());
        jokyohyoEntity.setShinseiYMD(new RString(kojinJokyoShokaiList.get(0).get認定申請年月日().toString()));
        jokyohyoEntity.setSeibetsu(kojinJokyoShokaiList.get(0).get性別() == null ? RString.EMPTY
                : Seibetsu.toValue(kojinJokyoShokaiList.get(0).get性別()).get名称());
        jokyohyoEntity.setHihokenshaName(kojinJokyoShokaiList.get(0).get被保険者氏名());
        jokyohyoEntity.setBirthYMD(new RString(kojinJokyoShokaiList.get(0).get生年月日().toString()));
        jokyohyoEntity.setAge(new RString(String.valueOf(kojinJokyoShokaiList.get(0).get年齢())));
        jokyohyoEntity.setYubinNo1(new RString(kojinJokyoShokaiList.get(0).get郵便番号().toString()));
        jokyohyoEntity.setHihokenshaJusho(new RString(kojinJokyoShokaiList.get(0).get住所().toString()));
        jokyohyoEntity.setTelNo1(new RString(kojinJokyoShokaiList.get(0).get電話番号().toString()));
        jokyohyoEntity.setShinseiRiyu(kojinJokyoShokaiList.get(0).get認定申請理由());
        jokyohyoEntity.setShinseishaName(kojinJokyoShokaiList.get(0).get申請者氏名());
        jokyohyoEntity.setShinseiDaikoJigyoshaName(kojinJokyoShokaiList.get(0).get申請代行事業者());
        if (kojinJokyoShokaiList.get(0).get申請者氏名() != null) {
            jokyohyoEntity.setShinseishaKankei(ShinseiTodokedeDaikoKubunCode.toValue(
                    kojinJokyoShokaiList.get(0).get申請届出代行区分コード().getColumnValue()).toRString());
        }
        jokyohyoEntity.setHonninKankei(kojinJokyoShokaiList.get(0).get申請届出者続柄コード().getColumnValue());
        jokyohyoEntity.setYubinNo2(kojinJokyoShokaiList.get(0).get申請者郵便番号().getColumnValue());
        jokyohyoEntity.setShinseishaJusho(kojinJokyoShokaiList.get(0).get申請届出者住所().getColumnValue());
        jokyohyoEntity.setTelNo2(kojinJokyoShokaiList.get(0).get申請届出者電話番号().getColumnValue());
        jokyohyoEntity.setShisetsuName(kojinJokyoShokaiList.get(0).get入所施設名());
        jokyohyoEntity.setShisetsujusho(kojinJokyoShokaiList.get(0).get入所施設所在地().getColumnValue());
        jokyohyoEntity.setTelNo3(kojinJokyoShokaiList.get(0).get入所施設電話番号().getColumnValue());
        jokyohyoEntity.setChosain_1(kojinJokyoShokaiList.get(0).get今回事業者名称());
        jokyohyoEntity.setChosain_2(kojinJokyoShokaiList.get(0).get今回調査員氏名());
        jokyohyoEntity.setChosain_3(kojinJokyoShokaiList.get(0).get今回調査員電話番号().getColumnValue());
        jokyohyoEntity.setChosain_4(kojinJokyoShokaiList.get(0).get前回事業者名称());
        jokyohyoEntity.setChosain_5(kojinJokyoShokaiList.get(0).get前回調査員氏名());
        jokyohyoEntity.setChosain_6(kojinJokyoShokaiList.get(0).get前回調査員電話番号().getColumnValue());
        jokyohyoEntity.setChosain_7(kojinJokyoShokaiList.get(0).get前々回事業者名称());
        jokyohyoEntity.setChosain_8(kojinJokyoShokaiList.get(0).get前々回調査員氏名());
        jokyohyoEntity.setChosain_9(kojinJokyoShokaiList.get(0).get前々回調査員電話番号().getColumnValue());
        jokyohyoEntity.setShui_1(kojinJokyoShokaiList.get(0).get今回医療機関名称());
        jokyohyoEntity.setShui_2(kojinJokyoShokaiList.get(0).get今回主治医名());
        jokyohyoEntity.setShui_3(kojinJokyoShokaiList.get(0).get今回主治医電話番号().getColumnValue());
        jokyohyoEntity.setShui_4(kojinJokyoShokaiList.get(0).get前回医療機関名称());
        jokyohyoEntity.setShui_5(kojinJokyoShokaiList.get(0).get前回主治医名());
        jokyohyoEntity.setShui_6(kojinJokyoShokaiList.get(0).get前回主治医電話番号().getColumnValue());
        jokyohyoEntity.setShui_7(kojinJokyoShokaiList.get(0).get前々回医療機関名称());
        jokyohyoEntity.setShui_8(kojinJokyoShokaiList.get(0).get前々回主治医名());
        jokyohyoEntity.setShui_9(kojinJokyoShokaiList.get(0).get前々回主治医電話番号().getColumnValue());
        jokyohyoEntity.setKonnkai_1(new RString(kojinJokyoShokaiList.get(0).get今回申請情報登録完了年月日().toString()));
        jokyohyoEntity.setZennkai_1(new RString(kojinJokyoShokaiList.get(0).get前回申請情報登録完了年月日().toString()));
        jokyohyoEntity.setZennnoma_1(new RString(kojinJokyoShokaiList.get(0).get前々回申請情報登録完了年月日().toString()));
        jokyohyoEntity.setKonnkai_2(new RString(kojinJokyoShokaiList.get(0).get今回認定調査依頼予定年月日().toString()));
        jokyohyoEntity.setZennkai_2(new RString(kojinJokyoShokaiList.get(0).get前回認定調査依頼予定年月日().toString()));
        jokyohyoEntity.setZennnoma_2(new RString(kojinJokyoShokaiList.get(0).get前々回認定調査依頼予定年月日().toString()));
        jokyohyoEntity.setKonnkai_3(new RString(kojinJokyoShokaiList.get(0).get今回認定調査依頼年月日().toString()));
        jokyohyoEntity.setZennkai_3(new RString(kojinJokyoShokaiList.get(0).get前回認定調査依頼年月日().toString()));
        jokyohyoEntity.setZennnoma_3(new RString(kojinJokyoShokaiList.get(0).get前々回認定調査依頼年月日().toString()));
        jokyohyoEntity.setKonnkai_4(new RString(kojinJokyoShokaiList.get(0).get今回調査依頼完了年月日().toString()));
        jokyohyoEntity.setZennkai_4(new RString(kojinJokyoShokaiList.get(0).get前回調査依頼完了年月日().toString()));
        jokyohyoEntity.setZennnoma_4(new RString(kojinJokyoShokaiList.get(0).get前々回調査依頼完了年月日().toString()));
        jokyohyoEntity.setKonnkai_5(new RString(kojinJokyoShokaiList.get(0).get今回認定調査予定年月日().toString()));
        jokyohyoEntity.setZennkai_5(new RString(kojinJokyoShokaiList.get(0).get前回認定調査予定年月日().toString()));
        jokyohyoEntity.setZennnoma_5(new RString(kojinJokyoShokaiList.get(0).get前々回認定調査予定年月日().toString()));
        jokyohyoEntity.setKonnkai_6(new RString(kojinJokyoShokaiList.get(0).get今回認定調査受領年月日().toString()));
        jokyohyoEntity.setZennkai_6(new RString(kojinJokyoShokaiList.get(0).get前回認定調査受領年月日().toString()));
        jokyohyoEntity.setZennnoma_6(new RString(kojinJokyoShokaiList.get(0).get前々回認定調査受領年月日().toString()));
        jokyohyoEntity.setKonnkai_7(new RString(kojinJokyoShokaiList.get(0).get今回調査完了年月日().toString()));
        jokyohyoEntity.setZennkai_7(new RString(kojinJokyoShokaiList.get(0).get前回調査完了年月日().toString()));
        jokyohyoEntity.setZennnoma_7(new RString(kojinJokyoShokaiList.get(0).get前々調査完了年月日().toString()));
        jokyohyoEntity.setKonnkai_8(new RString(kojinJokyoShokaiList.get(0).get今回主治医意見書作成依頼予定年月日().toString()));
        jokyohyoEntity.setZennkai_8(new RString(kojinJokyoShokaiList.get(0).get前回主治医意見書作成依頼予定年月日().toString()));
        jokyohyoEntity.setZennnoma_8(new RString(kojinJokyoShokaiList.get(0).get前々回主治医意見書作成依頼予定年月日().toString()));
        jokyohyoEntity.setKonnkai_9(new RString(kojinJokyoShokaiList.get(0).get今回主治医意見書作成依頼年月日().toString()));
        jokyohyoEntity.setZennkai_9(new RString(kojinJokyoShokaiList.get(0).get前回主治医意見書作成依頼年月日().toString()));
        jokyohyoEntity.setZennnoma_9(new RString(kojinJokyoShokaiList.get(0).get前々回主治医意見書作成依頼年月日().toString()));
        jokyohyoEntity.setKonnkai_10(new RString(kojinJokyoShokaiList.get(0).get今回意見書作成依頼完了年月日().toString()));
        jokyohyoEntity.setZennkai_10(new RString(kojinJokyoShokaiList.get(0).get前回意見書作成依頼完了年月日().toString()));
        jokyohyoEntity.setZennnoma_10(new RString(kojinJokyoShokaiList.get(0).get前々回意見書作成依頼完了年月日().toString()));
        jokyohyoEntity.setKonnkai_11(new RString(kojinJokyoShokaiList.get(0).get今回主治医意見書登録予定年月日().toString()));
        jokyohyoEntity.setZennkai_11(new RString(kojinJokyoShokaiList.get(0).get前回主治医意見書登録予定年月日().toString()));
        jokyohyoEntity.setZennnoma_11(new RString(kojinJokyoShokaiList.get(0).get前々回主治医意見書登録予定年月日().toString()));
        jokyohyoEntity.setKonnkai_12(new RString(kojinJokyoShokaiList.get(0).get今回主治医意見書受領年月日().toString()));
        jokyohyoEntity.setZennkai_12(new RString(kojinJokyoShokaiList.get(0).get前回主治医意見書受領年月日().toString()));
        jokyohyoEntity.setZennnoma_12(new RString(kojinJokyoShokaiList.get(0).get前々回主治医意見書受領年月日().toString()));
        jokyohyoEntity.setKonnkai_13(new RString(kojinJokyoShokaiList.get(0).get今回意見書登録完了年月日().toString()));
        jokyohyoEntity.setZennkai_13(new RString(kojinJokyoShokaiList.get(0).get前回意見書登録完了年月日().toString()));
        jokyohyoEntity.setZennnoma_13(new RString(kojinJokyoShokaiList.get(0).get前々回意見書登録完了年月日().toString()));
        jokyohyoEntity.setKonnkai_14(new RString(kojinJokyoShokaiList.get(0).get今回要介護認定一次判定予定年月日().toString()));
        jokyohyoEntity.setZennkai_14(new RString(kojinJokyoShokaiList.get(0).get前回要介護認定一次判定予定年月日().toString()));
        jokyohyoEntity.setZennnoma_14(new RString(kojinJokyoShokaiList.get(0).get前々回要介護認定一次判定予定年月日().toString()));
        jokyohyoEntity.setKonnkai_15(new RString(kojinJokyoShokaiList.get(0).get今回一次判定完了年月日().toString()));
        jokyohyoEntity.setZennkai_15(new RString(kojinJokyoShokaiList.get(0).get前回一次判定完了年月日().toString()));
        jokyohyoEntity.setZennnoma_15(new RString(kojinJokyoShokaiList.get(0).get前々回一次判定完了年月日().toString()));
        jokyohyoEntity.setKonnkai_16(new RString(kojinJokyoShokaiList.get(0).get今回マスキング完了年月日().toString()));
        jokyohyoEntity.setZennkai_16(new RString(kojinJokyoShokaiList.get(0).get前回マスキング完了年月日().toString()));
        jokyohyoEntity.setZennnoma_16(new RString(kojinJokyoShokaiList.get(0).get前々回マスキング完了年月日().toString()));
        jokyohyoEntity.setKonnkai_17(new RString(kojinJokyoShokaiList.get(0).get今回認定審査会割当予定年月日().toString()));
        jokyohyoEntity.setZennkai_17(new RString(kojinJokyoShokaiList.get(0).get前回認定審査会割当予定年月日().toString()));
        jokyohyoEntity.setZennnoma_17(new RString(kojinJokyoShokaiList.get(0).get前々回認定審査会割当予定年月日().toString()));
        jokyohyoEntity.setKonnkai_18(new RString(kojinJokyoShokaiList.get(0).get今回認定審査会予定年月日().toString()));
        jokyohyoEntity.setZennkai_18(new RString(kojinJokyoShokaiList.get(0).get前回認定審査会予定年月日().toString()));
        jokyohyoEntity.setZennnoma_18(new RString(kojinJokyoShokaiList.get(0).get前々回認定審査会予定年月日().toString()));
        jokyohyoEntity.setKonnkai_19(new RString(kojinJokyoShokaiList.get(0).get今回審査会割当完了年月日().toString()));
        jokyohyoEntity.setZennkai_19(new RString(kojinJokyoShokaiList.get(0).get前回審査会割当完了年月日().toString()));
        jokyohyoEntity.setZennnoma_19(new RString(kojinJokyoShokaiList.get(0).get前々回審査会割当完了年月日().toString()));
        jokyohyoEntity.setKonnkai_20(new RString(kojinJokyoShokaiList.get(0).get今回審査会完了年月日().toString()));
        jokyohyoEntity.setZennkai_20(new RString(kojinJokyoShokaiList.get(0).get前回審査会完了年月日().toString()));
        jokyohyoEntity.setZennnoma_20(new RString(kojinJokyoShokaiList.get(0).get前々回審査会完了年月日().toString()));
        jokyohyoEntity.setKonnkai_21(new RString(kojinJokyoShokaiList.get(0).get今回センター送信予定年月日().toString()));
        jokyohyoEntity.setZennkai_21(new RString(kojinJokyoShokaiList.get(0).get前回センター送信予定年月日().toString()));
        jokyohyoEntity.setZennnoma_21(new RString(kojinJokyoShokaiList.get(0).get前々回センター送信予定年月日().toString()));
        jokyohyoEntity.setKonnkai_22(new RString(kojinJokyoShokaiList.get(0).get今回センター送信年月日().toString()));
        jokyohyoEntity.setZennkai_22(new RString(kojinJokyoShokaiList.get(0).get前回センター送信年月日().toString()));
        jokyohyoEntity.setZennnoma_22(new RString(kojinJokyoShokaiList.get(0).get前々回センター送信年月日().toString()));
        return jokyohyoEntity;
    }
}
