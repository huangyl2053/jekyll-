/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KojinJokyoShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 個人状況照会Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class KojinJokyoShokai {

    /**
     * 個人状況照会画面の初期処理を表します。
     *
     * @param panel KojinJokyoShokaiDiv
     * @return ResponseData
     */
    public ResponseData<KojinJokyoShokaiDiv> dispKojinJokyoShokai(KojinJokyoShokaiDiv panel) {
        ResponseData<KojinJokyoShokaiDiv> response = new ResponseData<>();

        setKojinJokyoShokaiData(panel);
        response.data = panel;

        return response;

    }

    /*
     *個人状況照会情報を設定します。
     */
    private void setKojinJokyoShokaiData(KojinJokyoShokaiDiv panel) {

        //申請情報のパネルクローズ
        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().
                getTplKihonJoho().getShinseiJoho().setIsOpen(false);

        //家族等連絡先のパネルクローズ
        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().
                getTplKihonJoho().getKazokuRenrakusaki().setIsOpen(false);

        List<HashMap> HihokenshaShinchokuJohoList = YamlLoader.FOR_DBE.loadAsList(
                new RString("dbe8020001/HihokenshaShinchoku.yml"));

        List<HashMap> CityJohoList = YamlLoader.FOR_DBE.loadAsList(
                new RString("DemoCity.yml"));

        //被保険者情報の設定
        HashMap mapCityJoho = CityJohoList.get(0);
        HashMap mapHihokenshaJoho = HihokenshaShinchokuJohoList.get(0);
        setHihokenshaJoho(panel, mapCityJoho, mapHihokenshaJoho);

        //進捗情報の設定
        HashMap mapShinchokuJoho = HihokenshaShinchokuJohoList.get(1);
        setShinchokuJoho(panel, mapShinchokuJoho);

        //基本情報タブの設定
        setKihonJohoTab(panel);

        //認定調査タブの設定
        setNinteiChosaTab(panel);

    }

    /*
     *被保険者情報を設定します。
     */
    private void setHihokenshaJoho(KojinJokyoShokaiDiv panel,
            HashMap mapCityJoho, HashMap mapHihokenshaJoho) {

        panel.getCcdHihokenshaJoho().getTxtHokenshaNo().setValue(
                new RString(mapCityJoho.get("保険者番号").toString()));

        panel.getCcdHihokenshaJoho().getTxtHokenshaMeisho().setValue(
                new RString(mapCityJoho.get("保険者名称").toString()));

        panel.getCcdHihokenshaJoho().getTxtHihokenshaNo().setValue(
                new RString(mapHihokenshaJoho.get("hihokenNo").toString()));

        panel.getCcdHihokenshaJoho().getTxtHihokenshaShimei().setValue(
                new RString(mapHihokenshaJoho.get("shimei").toString()));

        panel.getCcdHihokenshaJoho().getTxtHihokenshaKubun().setValue(
                new RString(mapHihokenshaJoho.get("hihokenKbn").toString()));

        if (mapHihokenshaJoho.get("umareYmd").toString().isEmpty()) {
            panel.getCcdHihokenshaJoho().getTxtBirthDay().clearValue();
        } else {
            panel.getCcdHihokenshaJoho().getTxtBirthDay().setValue(
                    new RDate(mapHihokenshaJoho.get("umareYmd").toString()));
        }

        panel.getCcdHihokenshaJoho().getTxtNenrei().setValue(
                new RString(mapHihokenshaJoho.get("nenrei").toString()));

        if (mapHihokenshaJoho.get("shinseibi").toString().isEmpty()) {
            panel.getCcdHihokenshaJoho().getTxtNinteiShinseiYMD().clearValue();

        } else {
            panel.getCcdHihokenshaJoho().getTxtNinteiShinseiYMD().setValue(
                    new FlexibleDate(mapHihokenshaJoho.get("shinseibi").toString()));
        }

        panel.getCcdHihokenshaJoho().getTxtShinseiKubun().setValue(
                new RString(mapHihokenshaJoho.get("shinseiKbn").toString()));

        panel.getCcdHihokenshaJoho().getTxtZenkaiYokaigodo().setValue(
                new RString(mapHihokenshaJoho.get("zenNinteiKekka").toString()));

        if (mapHihokenshaJoho.get("zenNinteiKikanFrom").toString().isEmpty()) {
            panel.getCcdHihokenshaJoho().getTxtZenYukokikanStart().clearValue();
        } else {
            panel.getCcdHihokenshaJoho().getTxtZenYukokikanStart().setValue(
                    new FlexibleDate(mapHihokenshaJoho.get("zenNinteiKikanFrom").toString()));
        }

        if (mapHihokenshaJoho.get("zenNinteiKikanTo").toString().isEmpty()) {
            panel.getCcdHihokenshaJoho().getTxtZenYukokikanEnd().clearValue();
        } else {
            panel.getCcdHihokenshaJoho().getTxtZenYukokikanEnd().setValue(
                    new FlexibleDate(mapHihokenshaJoho.get("zenNinteiKikanTo").toString()));
        }

    }

    /*
     *進捗情報を設定します。
     */
    private void setShinchokuJoho(KojinJokyoShokaiDiv panel,
            HashMap mapShinchokuJoho) {

        if (mapShinchokuJoho.get("kanryoyoteibi1").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtShinseijiShoriYoteibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtShinseijiShoriYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi1").toString()));
        }

        if (mapShinchokuJoho.get("kanryoyoteibi2").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtChosaIraiYoteibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtChosaIraiYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi2").toString()));
        }

        if (mapShinchokuJoho.get("kanryoyoteibi3").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtChosahyoNyushuYoteibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtChosahyoNyushuYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi3").toString()));
        }

        if (mapShinchokuJoho.get("kanryoyoteibi4").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIkenshoIraiYoteibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIkenshoIraiYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi4").toString()));
        }

        if (mapShinchokuJoho.get("kanryoyoteibi5").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIkenshoNyushuYoteibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIkenshoNyushuYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi5").toString()));
        }

        if (mapShinchokuJoho.get("kanryoyoteibi6").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIchijiHanteiYoteibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIchijiHanteiYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi6").toString()));
        }

        if (mapShinchokuJoho.get("kanryoyoteibi7").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtShinsakaiTorokuYoteibi().clearValue();

        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtShinsakaiTorokuYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi7").toString()));
        }

        if (mapShinchokuJoho.get("kanryoyoteibi8").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtNijiHanteiYoteibi().clearValue();

        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtNijiHanteiYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi8").toString()));
        }

        if (mapShinchokuJoho.get("kanryoyoteibi9").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtHanteigoShoriYoteibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtHanteigoShoriYoteibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoyoteibi9").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi1").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtShinseijiShoriJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtShinseijiShoriJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi1").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi2").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtChosaIraiJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtChosaIraiJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi2").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi3").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtChosahyoNyushuJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtChosahyoNyushuJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi3").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi4").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIkenshoIraiJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIkenshoIraiJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi4").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi5").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIkenshoNyushuJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIkenshoNyushuJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi5").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi6").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIchijiHanteiJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtIchijiHanteiJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi6").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi7").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtShinsakaiTorokuJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtShinsakaiTorokuJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi7").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi8").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtNijiHanteiJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtNijiHanteiJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi8").toString()));
        }

        if (mapShinchokuJoho.get("kanryoJissekibi9").toString().isEmpty()) {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtHanteigoShoriJissekibi().clearValue();
        } else {
            panel.getShinchokuKakunin().getTblShinchokuKakunin().getTxtHanteigoShoriJissekibi().
                    setValue(new RDate(mapShinchokuJoho.get("kanryoJissekibi9").toString()));
        }

    }

    /*
     *基本情報タブを設定します。
     */
    private void setKihonJohoTab(KojinJokyoShokaiDiv panel) {

        List<HashMap> KihonJohoList = YamlLoader.FOR_DBE.loadAsList(
                new RString("dbe8020001/KihonJoho.yml"));

        //基本情報の設定
        HashMap mapKihonJoho = KihonJohoList.get(0);
        setKihonJoho(panel, mapKihonJoho);

        //申請情報の設定
        HashMap mapShinseiJoho = KihonJohoList.get(1);
        setShinseiJoho(panel, mapShinseiJoho);

        //家族等連絡先の設定
        HashMap mapKazokuRenrakusakiJoho = KihonJohoList.get(2);
        setKazokuRenrakusakiJoho(panel, mapKazokuRenrakusakiJoho);

    }

    /*
     *基本情報を設定します。
     */
    private void setKihonJoho(KojinJokyoShokaiDiv panel, HashMap mapKihonJoho) {

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtHihokenshaKana().setValue(
                        new RString(mapKihonJoho.get("hihokenshaKana").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtSeibetsu().setValue(
                        new RString(mapKihonJoho.get("seibetsu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtTel().setValue(
                        new RString(mapKihonJoho.get("tel").toString()));

        if (mapKihonJoho.get("yubinNo").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtYubinNo().clearValue();

        } else {

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtYubinNo().setValue(
                            new YubinNo(mapKihonJoho.get("yubinNo").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtJusho().setValue(
                        new RString(mapKihonJoho.get("jusho").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtTokuteiShippei().setValue(
                        new RString(mapKihonJoho.get("tokuteishippei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtIryoHokenShubetsu().setValue(
                        new RString(mapKihonJoho.get("iryoHokenShubetsu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtIryoHokenNo().setValue(
                        new RString(mapKihonJoho.get("iryoHokenNo").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtIryoHokenshaMei().setValue(
                        new RString(mapKihonJoho.get("iryoHokenshaMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtKigoBango().setValue(
                        new RString(mapKihonJoho.get("kigoBango").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtShinseiDaikoKbn().setValue(
                        new RString(mapKihonJoho.get("shinseiDaikoKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtShinseiDaikoJigyosha().setValue(
                        new RString(mapKihonJoho.get("shinseiDaikoJigyosha").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtJigyoshaKbn().setValue(
                        new RString(mapKihonJoho.get("jigyoshaKbn").toString()));

        if (mapKihonJoho.get("shinseishaYubinNo").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtShinseishaYubinNo().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtShinseishaYubinNo().setValue(
                            new YubinNo(mapKihonJoho.get("shinseishaYubinNo").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtShinseishaJusho().setValue(
                        new RString(mapKihonJoho.get("shinseishaJusho").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtShinseishaTel().setValue(
                        new RString(mapKihonJoho.get("shinseishaTel").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtShinseiRiyu().setValue(
                        new RString(mapKihonJoho.get("shinseiRiyu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtJohoTeikyoDoi().setValue(
                        new RString(mapKihonJoho.get("johoTeikyoDoi").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtEnkiTsuchiHakkoDoi().setValue(
                        new RString(mapKihonJoho.get("enkiTsuchiHakkoDoi").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtShisetsuNyushoUmu().setValue(
                        new RString(mapKihonJoho.get("shisetsuNyushoUmu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtShisetsuNyusho().setValue(
                        new RString(mapKihonJoho.get("shisetsuNyusho").toString()));

        if (mapKihonJoho.get("shisetsuNyushobi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtShisetsuNyushobi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtShisetsuNyushobi().setValue(
                            new RDate(mapKihonJoho.get("shisetsuNyushobi").toString()));
        }

        if (mapKihonJoho.get("shisetsuTaishobi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtShisetsuTaishobi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtShisetsuTaishobi().setValue(
                            new RDate(mapKihonJoho.get("shisetsuTaishobi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtShichosonRenrakuJiko().setValue(
                        new RString(mapKihonJoho.get("shichosonRenrakuJiko").toString()));

        if (mapKihonJoho.get("ichijiHanteiJohoChushutsubi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtIchijiHanteiJohoChushutsubi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtIchijiHanteiJohoChushutsubi().setValue(
                            new RDate(mapKihonJoho.get("ichijiHanteiJohoChushutsubi").toString()));
        }

        if (mapKihonJoho.get("iraiJohoDataSoshinbi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtIraiJohoDataSoshinbi().clearValue();

        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtIraiJohoDataSoshinbi().setValue(
                            new RDate(mapKihonJoho.get("iraiJohoDataSoshinbi").toString()));
        }

        if (mapKihonJoho.get("centerSoshinbi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtCenterSoshinbi().clearValue();

        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseishaShosaiJoho().getTxtCenterSoshinbi().setValue(
                            new RDate(mapKihonJoho.get("centerSoshinbi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseishaShosaiJoho().getTxtMemo().setValue(
                        new RString(mapKihonJoho.get("memo").toString()));

    }

    /*
     *申請情報を設定します。
     */
    private void setShinseiJoho(KojinJokyoShokaiDiv panel, HashMap mapShinseiJoho) {
        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseiJoho().getTxtShinseiEdaban().setValue(
                        new RString(mapShinseiJoho.get("shinseiEdaban").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseiJoho().getTxtShinseiKbnHorei().setValue(
                        new RString(mapShinseiJoho.get("shinseiKbnHorei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseiJoho().getTxtYokaigoYoshienShinseiKbn().setValue(
                        new RString(mapShinseiJoho.get("yokaigoYoshienShinseiKbn").toString()));

        if (mapShinseiJoho.get("kyakkabi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseiJoho().getTxtKyakkabi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseiJoho().getTxtKyakkabi().setValue(
                            new RDate(mapShinseiJoho.get("kyakkabi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseiJoho().getTxtShoriKbn().setValue(
                        new RString(mapShinseiJoho.get("shoriKbn").toString()));

        if (panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getShinseiJoho().getTxtShoriKbn().getValue().toString().equals("なし")) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseiJoho().getTxtShoribi().setVisible(false);

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseiJoho().getTxtShoriRiyu().setVisible(false);

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseiJoho().getTxtEnkiTsuchiHakkoKaisu().setVisible(false);
        } else {
            if (mapShinseiJoho.get("shoribi").toString().isEmpty()) {
                panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                        getShinseiJoho().getTxtShoribi().clearValue();
            } else {
                panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                        getShinseiJoho().getTxtShoribi().setValue(
                                new RDate(mapShinseiJoho.get("shoribi").toString()));
            }

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseiJoho().getTxtShoriRiyu().setValue(
                            new RString(mapShinseiJoho.get("shoriRiyu").toString()));

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getShinseiJoho().getTxtEnkiTsuchiHakkoKaisu().setValue(
                            new RString(mapShinseiJoho.get("enkiTsuchiHakkoKaisu").toString()));
        }

    }

    /*
     *家族連絡先情報を設定します。
     */
    private void setKazokuRenrakusakiJoho(KojinJokyoShokaiDiv panel, HashMap mapKazokuRenrakusakiJoho) {

        if (mapKazokuRenrakusakiJoho.get("kazokuYubinNo").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getKazokuRenrakusaki().getTxtKazokuYubinNo().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                    getKazokuRenrakusaki().getTxtKazokuYubinNo().setValue(
                            new YubinNo(mapKazokuRenrakusakiJoho.get("kazokuYubinNo").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getKazokuRenrakusaki().getTxtKazokuJusho().setValue(
                        new RString(mapKazokuRenrakusakiJoho.get("kazokuJusho").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getKazokuRenrakusaki().getTxtKazokuTel().setValue(
                        new RString(mapKazokuRenrakusakiJoho.get("kazokuTel").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getKazokuRenrakusaki().getTxtKazokuShimei().setValue(
                        new RString(mapKazokuRenrakusakiJoho.get("kazokuShimei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplKihonJoho().
                getKazokuRenrakusaki().getTxtChosaTaishoshaKankei().setValue(
                        new RString(mapKazokuRenrakusakiJoho.get("chosaTaishoshaKankei").toString()));

    }

    /*
     *認定調査タブを設定します。
     */
    private void setNinteiChosaTab(KojinJokyoShokaiDiv panel) {

        List<HashMap> NinteiChosaList = YamlLoader.FOR_DBE.loadAsList(
                new RString("dbe8020001/NinteiChosa.yml"));

        //今回調査依頼情報の設定
        HashMap mapKonkaiChosaIraiJoho = NinteiChosaList.get(0);
        setKonkaiChosaIraiJoho(panel, mapKonkaiChosaIraiJoho);

        //前回調査依頼情報の設定
        HashMap mapZenkaiChosaIraiJoho = NinteiChosaList.get(1);
        setZenkaiChosaIraiJoho(panel, mapZenkaiChosaIraiJoho);

        //特記事項一覧情報の設定
        HashMap mapTokkiJikoIchiranJoho = NinteiChosaList.get(2);
        setTokkiJikoIchiranJoho(panel, mapTokkiJikoIchiranJoho);

    }

    /*
     *今回調査依頼情報を設定します。
     */
    private void setKonkaiChosaIraiJoho(KojinJokyoShokaiDiv panel, HashMap mapKonkaiChosaIraiJoho) {

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosaBashoKbn().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosaBashoKbn").toString()));

        if (mapKonkaiChosaIraiJoho.get("konkaiShinkiChosaJissibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                    getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                    getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosaJissibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                    getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                    getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosaJissibi().setValue(
                            new RDate(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosaJissibi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosaJissiChikuCode().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosaJissiChikuCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosaJissiChikuMei().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosaJissiChikuMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosakikanCode().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosakikanCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosakikanMei().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosakikanMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosaItakuKbn().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosaItakuKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosainCode().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosainCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosainMei().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosainMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosainShikaku().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosainShikaku").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosakikanTel().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosakikanTel").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiShinkiChosakikanFax().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiShinkiChosakikanFax").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosaBashoKbn().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosaBashoKbn").toString()));

        if (mapKonkaiChosaIraiJoho.get("konkaiShinkiChosaJissibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                    getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                    getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosaJissibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                    getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                    getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosaJissibi().setValue(
                            new RDate(mapKonkaiChosaIraiJoho.get("konkaiSaiChosaJissibi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosaJissiChikuCode().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosaJissiChikuCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosaJissiChikuMei().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosaJissiChikuMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosakikanCode().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosakikanCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosakikanMei().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosakikanMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosaItakuKbn().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosaItakuKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosainCode().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosainCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosainMei().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosainMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosainShikaku().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosainShikaku").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosakikanTel().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosakikanTel").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiSaiChosakikanFax().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiSaiChosakikanFax").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getKonkaiHomonChosaIraiJoho().getTxtKonkaiKateiHomonUmu().setValue(
                        new RString(mapKonkaiChosaIraiJoho.get("konkaiKateiHomonUmu").toString()));

    }

    /*
     *前回調査依頼情報を設定します。
     */
    private void setZenkaiChosaIraiJoho(KojinJokyoShokaiDiv panel, HashMap mapZenkaiChosaIraiJoho) {
        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosaBashoKbn().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosaBashoKbn").toString()));

        if (mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosaJissibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                    getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                    getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosaJissibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                    getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                    getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosaJissibi().setValue(
                            new RDate(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosaJissibi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosaJissiChikuCode().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosaJissiChikuCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosaJissiChikuMei().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosaJissiChikuMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosakikanCode().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosakikanCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosakikanMei().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosakikanMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosaItakuKbn().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosaItakuKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosainCode().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosainCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosainMei().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosainMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosainShikaku().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosainShikaku").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosakikanTel().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosakikanTel").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiShinkiChosakikanFax().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosakikanFax").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosaBashoKbn().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosaBashoKbn").toString()));

        if (mapZenkaiChosaIraiJoho.get("zenkaiShinkiChosaJissibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                    getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                    getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosaJissibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                    getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                    getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosaJissibi().setValue(
                            new RDate(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosaJissibi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosaJissiChikuCode().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosaJissiChikuCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosaJissiChikuMei().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosaJissiChikuMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosakikanCode().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosakikanCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosakikanMei().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosakikanMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosaItakuKbn().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosaItakuKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosainCode().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosainCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosainMei().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosainMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosainShikaku().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosainShikaku").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosakikanTel().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosakikanTel").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiSaiChosakikanFax().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiSaiChosakikanFax").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplHomonChosaIraiJoho().
                getZenkaiHomonChosaIraiJoho().getTxtZenkaiKateiHomonUmu().setValue(
                        new RString(mapZenkaiChosaIraiJoho.get("zenkaiKateiHomonUmu").toString()));

    }

    /*
     *特記事項一覧情報を設定します。
     */
    private void setTokkiJikoIchiranJoho(KojinJokyoShokaiDiv panel, HashMap mapTokkiJikoIchiranJoho) {

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplTokkiJikoIchiran().getDdlTokkiJikoKomoku1().
                setSelectedItem(new RString(mapTokkiJikoIchiranJoho.get("tokkiChosaKomokumei1").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplTokkiJikoIchiran().getDdlTokkiJikoKomoku2().
                setSelectedItem(new RString(mapTokkiJikoIchiranJoho.get("tokkiChosaKomokumei2").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplTokkiJikoIchiran().getTxtTokkiJikoKomoku1().
                setValue(new RString(mapTokkiJikoIchiranJoho.get("tokkiChosaKomokuNaiyo1").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplNinteiChosa().
                getTabNinteiChosaKojinShokai().getTplTokkiJikoIchiran().getTxtTokkiJikoKomoku2().
                setValue(new RString(mapTokkiJikoIchiranJoho.get("tokkiChosaKomokuNaiyo2").toString()));

    }
}
