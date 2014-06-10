/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KojinJokyoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.dgShinsakaiIinJoho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIchijiHanteiKeikokuCode_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

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

        //意見書タブの設定
        setIkenshoTab(panel);

        //審査会タブの設定
        setShinsakaiTab(panel);

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

        if (mapKonkaiChosaIraiJoho.get("konkaiSaiChosaJissibi").toString().isEmpty()) {
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

    /*
     *意見書情報タブを設定します。
     */
    private void setIkenshoTab(KojinJokyoShokaiDiv panel) {

        List<HashMap> IkenshoList = YamlLoader.FOR_DBE.loadAsList(
                new RString("dbe8020001/Ikensho.yml"));

        //今回主治医依頼情報の設定
        HashMap mapKonkaiShujiiIraiJoho = IkenshoList.get(0);
        setKonkaiShujiiIraiJoho(panel, mapKonkaiShujiiIraiJoho);

        //前回主治医依頼情報の設定
        HashMap mapZenkaiShujiiIraiJoho = IkenshoList.get(1);
        setZenkaiShujiiIraiJoho(panel, mapZenkaiShujiiIraiJoho);

    }

    /*
     *今回主治医依頼情報を設定します。
     */
    private void setKonkaiShujiiIraiJoho(KojinJokyoShokaiDiv panel, HashMap mapKonkaiShujiiIraiJoho) {

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIkenshoSakuseiIraiRirekiNo().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiIkenshoSakuseiIraiRirekiNo").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIkenshoIraiKbn().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiIkenshoIraiKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiSakuseiKaisu().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiSakuseiKaisu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiShujiiShiteiiKbn().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiShujiiShiteiiKbn").toString()));

        if (mapKonkaiShujiiIraiJoho.get("konkaiIkenshoIraibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                    getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                    getKonkaiShujiiIraiJoho().getTxtKonkaiIkenshoIraibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                    getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                    getKonkaiShujiiIraiJoho().getTxtKonkaiIkenshoIraibi().setValue(
                            new RDate(mapKonkaiShujiiIraiJoho.get("konkaiIkenshoIraibi").toString()));
        }

        if (mapKonkaiShujiiIraiJoho.get("konkaiIkenshoKinyubi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                    getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                    getKonkaiShujiiIraiJoho().getTxtKonkaiIkenshoKinyubi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                    getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                    getKonkaiShujiiIraiJoho().getTxtKonkaiIkenshoKinyubi().setValue(
                            new RDate(mapKonkaiShujiiIraiJoho.get("konkaiIkenshoKinyubi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiShujiiCode().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiShujiiCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiShujiiMei().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiShujiiMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIryokikanCode().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiIryokikanCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIryokikanMei().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiIryokikanMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIryokikanYubinNo().setValue(
                        new YubinNo(mapKonkaiShujiiIraiJoho.get("konkaiIryokikanYubinNo").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIryokikanJusho().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiIryokikanJusho").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIryokikanTel().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiIryokikanTel").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIryokikanFax().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiIryokikanFax").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getKonkaiShujiiIraiJoho().getTxtKonkaiIryokikanDaihyoshaShimei().setValue(
                        new RString(mapKonkaiShujiiIraiJoho.get("konkaiIryokikanDaihyoshaShimei").toString()));

    }

    /*
     *前回主治医依頼情報を設定します。
     */
    private void setZenkaiShujiiIraiJoho(KojinJokyoShokaiDiv panel, HashMap mapZenkaiShujiiIraiJoho) {

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIkenshoSakuseiIraiRirekiNo().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiIkenshoSakuseiIraiRirekiNo").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIkenshoIraiKbn().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiIkenshoIraiKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiSakuseiKaisua().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiSakuseiKaisu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiShujiiShiteiiKbn().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiShujiiShiteiiKbn").toString()));

        if (mapZenkaiShujiiIraiJoho.get("zenkaiIkenshoIraibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                    getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                    getZenkaiShujiiIraiJoho().getTxtZenkaiIkenshoIraibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                    getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                    getZenkaiShujiiIraiJoho().getTxtZenkaiIkenshoIraibi().setValue(
                            new RDate(mapZenkaiShujiiIraiJoho.get("zenkaiIkenshoIraibi").toString()));
        }

        if (mapZenkaiShujiiIraiJoho.get("zenkaiIkenshoKinyubi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                    getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                    getZenkaiShujiiIraiJoho().getTxtZenkaiIkenshoKinyubi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                    getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                    getZenkaiShujiiIraiJoho().getTxtZenkaiIkenshoKinyubi().setValue(
                            new RDate(mapZenkaiShujiiIraiJoho.get("zenkaiIkenshoKinyubi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiShujiiCode().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiShujiiCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiShujiiMei().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiShujiiMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIryokikanCode().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiIryokikanCode").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIryokikanMei().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiIryokikanMei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIryokikanYubinNo().setValue(
                        new YubinNo(mapZenkaiShujiiIraiJoho.get("zenkaiIryokikanYubinNo").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIryokikanJusho().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiIryokikanJusho").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIryokikanTel().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiIryokikanTel").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIryokikanFax().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiIryokikanFax").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplIkensho().
                getTabIkenshoKojinShokai().getTplShujiiIraiJoho().
                getZenkaiShujiiIraiJoho().getTxtZenkaiIryokikanDaihyoshaShimei().setValue(
                        new RString(mapZenkaiShujiiIraiJoho.get("zenkaiIryokikanDaihyoshaShimei").toString()));
    }

    /*
     *審査会情報タブを設定します。
     */
    private void setShinsakaiTab(KojinJokyoShokaiDiv panel) {

        List<HashMap> ShinsakaiList = YamlLoader.FOR_DBE.loadAsList(
                new RString("dbe8020001/Shinsakai.yml"));

        //一次判定情報の設定
        HashMap mapIchijiHanteiJoho = ShinsakaiList.get(0);
        setIchijiHanteiJoho(panel, mapIchijiHanteiJoho);

        //審査会情報の設定
        HashMap mapShinsakaiJoho = ShinsakaiList.get(1);
        setShinsakaiJoho(panel, mapShinsakaiJoho);

        //審査会結果情報の設定
        HashMap mapShinsakaiKekkaJoho = ShinsakaiList.get(2);
        setShinsakaiKekkaJoho(panel, mapShinsakaiKekkaJoho);

    }

    /*
     *一次判定情報を設定します。
     */
    private void setIchijiHanteiJoho(KojinJokyoShokaiDiv panel, HashMap mapIchijiHanteiJoho) {

        if (mapIchijiHanteiJoho.get("ichijiHanteibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtIchijiHanteibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtIchijiHanteibi().setValue(
                            new RDate(mapIchijiHanteiJoho.get("ichijiHanteibi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtIchijiHanteiKekka().setValue(
                        new RString(mapIchijiHanteiJoho.get("kaigodo").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtKijunJikan().setValue(
                        new RString(mapIchijiHanteiJoho.get("kijunjikan").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtShokuji().setValue(
                        new RString(mapIchijiHanteiJoho.get("shokuji").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtHaisetsu().setValue(
                        new RString(mapIchijiHanteiJoho.get("haisetsu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtIdo().setValue(
                        new RString(mapIchijiHanteiJoho.get("ido").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtSeiketsuHoji().setValue(
                        new RString(mapIchijiHanteiJoho.get("seiketsuhoji").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtKansetsuCare().setValue(
                        new RString(mapIchijiHanteiJoho.get("kansetsucare").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtBpsdKanren().setValue(
                        new RString(mapIchijiHanteiJoho.get("bpsd").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtKinoKunren().setValue(
                        new RString(mapIchijiHanteiJoho.get("kinokunren").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtIryoKanren().setValue(
                        new RString(mapIchijiHanteiJoho.get("iryokanren").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblKijunJikan().getTxtNinchishoKasan().setValue(
                        new RString(mapIchijiHanteiJoho.get("ninchishokasan").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai1gun().setValue(
                        new RString(mapIchijiHanteiJoho.get("chukantokuten1").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai2gun().setValue(
                        new RString(mapIchijiHanteiJoho.get("chukantokuten2").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai3gun().setValue(
                        new RString(mapIchijiHanteiJoho.get("chukantokuten3").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai4gun().setValue(
                        new RString(mapIchijiHanteiJoho.get("chukantokuten4").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai5gun().setValue(
                        new RString(mapIchijiHanteiJoho.get("chukantokuten5").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtJiritsudoChosa().setValue(
                        new RString(mapIchijiHanteiJoho.get("jiritsudochosa").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtJiritsudoIkensho().setValue(
                        new RString(mapIchijiHanteiJoho.get("jiritsudoikensho").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtGaizensei().setValue(
                        new RString(mapIchijiHanteiJoho.get("gaizensei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtJyotaiAnteisei().setValue(
                        new RString(mapIchijiHanteiJoho.get("anteisei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplIchijiHantei().getCcdIchijiHanteiJoho().getTxtKyufuKbn().setValue(
                        new RString(mapIchijiHanteiJoho.get("kyufukbn").toString()));

        //一次判定警告コード表示
        if (mapIchijiHanteiJoho.get("keikokusu").toString().equals("0")) {
            List<dgIchijiHanteiKeikokuCode_Row> arraydata = new ArrayList<>();
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplIchijiHantei().getCcdIchijiHanteiJoho().getDgIchijiHanteiKeikokuCode().setDataSource(arraydata);

        } else {
            List arraydata = createRowIchijiHanteiKeikokuCode(mapIchijiHanteiJoho);
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplIchijiHantei().getCcdIchijiHanteiJoho().getDgIchijiHanteiKeikokuCode().setDataSource(arraydata);
        }

    }

    /*
     *一次判定警告コードデータグリッド情報を設定します。
     */
    private List createRowIchijiHanteiKeikokuCode(HashMap IchijiHanteiKekka) {

        List arrayDataList = new ArrayList();

        for (int i = 1; i <= Integer.parseInt((String) IchijiHanteiKekka.get("keikokusu")); i++) {

            String strKey1 = "keikokuno" + i;
            String strKeikokuNo = (String) IchijiHanteiKekka.get(strKey1);

            String strKey2 = "keikokucode" + i;
            String strKeikokuCode = (String) IchijiHanteiKekka.get(strKey2);

            String strKey3 = "keikokunaiyo" + i;
            String strKeikokuNaiyo = (String) IchijiHanteiKekka.get(strKey3);

            arrayDataList.add(createRowIchijiHanteiKeikokuCode(strKeikokuNo, strKeikokuCode, strKeikokuNaiyo));
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する一次判定警告コード一覧データを作成します。
     */
    private dgIchijiHanteiKeikokuCode_Row createRowIchijiHanteiKeikokuCode(
            String KeikokuNo,
            String KeikokuCode,
            String KeikokuNaiyo
    ) {

        dgIchijiHanteiKeikokuCode_Row rowIchijiHanteiKeikokuCode = new dgIchijiHanteiKeikokuCode_Row(
                new RString(KeikokuNo),
                new RString(KeikokuCode),
                new RString(KeikokuNaiyo)
        );
        return rowIchijiHanteiKeikokuCode;
    }

    /*
     *審査会情報を設定します。
     */
    private void setShinsakaiJoho(KojinJokyoShokaiDiv panel, HashMap mapShinsakaiJoho) {

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiKaisaiNo().setValue(
                        new RString(mapShinsakaiJoho.get("shinsakaiKaisaiNo").toString()));

        if (mapShinsakaiJoho.get("shinsakaiKaisaiYoteibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiKaisaiYoteibi().clearValue();
        } else {

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiKaisaiYoteibi().setValue(
                            new RDate(mapShinsakaiJoho.get("shinsakaiKaisaiYoteibi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplShinsakaiJoho().getShinsakaiJoho().getTxtGogitai().setValue(
                        new RString(mapShinsakaiJoho.get("gogitai").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiKaisaiBasho().setValue(
                        new RString(mapShinsakaiJoho.get("shinsakaiKaisaiBasho").toString()));

        if (mapShinsakaiJoho.get("shinsakaiShiryoSakuseibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiShiryoSakuseibi().clearValue();
        } else {

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiShiryoSakuseibi().setValue(
                            new RDate(mapShinsakaiJoho.get("shinsakaiShiryoSakuseibi").toString()));
        }

        if (mapShinsakaiJoho.get("shinsakaiKaishiYoteiJikan").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiKaishiYoteiJikan().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiKaishiYoteiJikan().setValue(
                            RTime.parse(mapShinsakaiJoho.get("shinsakaiKaishiYoteiJikan").toString()));
        }

        if (mapShinsakaiJoho.get("shinsakaiShuryoYoteiJikan").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiShuryoYoteiJikan().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getTxtShinsakaiShuryoYoteiJikan().setValue(
                            RTime.parse(mapShinsakaiJoho.get("shinsakaiShuryoYoteiJikan").toString()));
        }

        if (mapShinsakaiJoho.get("seishinkaiSonzaiKbn").toString().equals("1")) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            dataSource.add(new KeyValueDataSource(new RString("1"), new RString("精神科医存在区分")));
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getChkSeishinkaiSonzaiKbn().setSelectedItems(dataSource);

        }

        if (mapShinsakaiJoho.get("gogitaiDummyKbn").toString().equals("1")) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            dataSource.add(new KeyValueDataSource(new RString("1"), new RString("合議体ダミー区分")));
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiJoho().getChkGogitaiDummyKbn().setSelectedItems(dataSource);

        }

        //審査委員情報表示
        if (mapShinsakaiJoho.get("shinsainsu").toString().equals("0")) {
            List<dgShinsakaiIinJoho_Row> arraydata = new ArrayList<>();
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiIinJoho().getDgShinsakaiIinJoho().setDataSource(arraydata);

        } else {
            List arraydata = createRowShinsakaiIin(mapShinsakaiJoho);
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsakaiIinJoho().getDgShinsakaiIinJoho().setDataSource(arraydata);
        }

        if (mapShinsakaiJoho.get("shisakaiKaisaibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShisakaiKaisaibi().clearValue();
        } else {

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShisakaiKaisaibi().setValue(
                            new RDate(mapShinsakaiJoho.get("shisakaiKaisaibi").toString()));
        }

        if (mapShinsakaiJoho.get("shinsakaiHanteibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShinsakaiHanteibi().clearValue();
        } else {

            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShinsakaiHanteibi().setValue(
                            new RDate(mapShinsakaiJoho.get("shinsakaiHanteibi").toString()));
        }

        if (mapShinsakaiJoho.get("shinsakaiKaishiJikan").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShinsakaiKaishiJikan().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShinsakaiKaishiJikan().setValue(
                            RTime.parse(mapShinsakaiJoho.get("shinsakaiKaishiJikan").toString()));
        }

        if (mapShinsakaiJoho.get("shinsakaiShuryoJikan").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShinsakaiShuryoJikan().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShinsakaiShuryoJikan().setValue(
                            RTime.parse(mapShinsakaiJoho.get("shinsakaiShuryoJikan").toString()));
        }

        if (mapShinsakaiJoho.get("shinsaHanteiJikan").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShinsaHanteiJikan().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().getTabShinsakaiKojinShokai().
                    getTplShinsakaiJoho().getShinsaKekkaJoho().getTxtShinsaHanteiJikan().setValue(
                            RTime.parse(mapShinsakaiJoho.get("shinsaHanteiJikan").toString()));
        }

    }

    /*
     *審査会結果情報を設定します。
     */
    private void setShinsakaiKekkaJoho(KojinJokyoShokaiDiv panel, HashMap mapShinsakaiKekkaJoho) {

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtYokaigoJotaiKbn().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("yokaigoJotaiKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtHenkoRiyu().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("henkoRiyu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtShinsakaiIkenShurui().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("shinsakaiIkenShurui").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtShinsakaiIken().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("shinsakaiIken").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtShinsakaiMemo().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("shinsakaiMemo").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtYokaigoJyotaizorei().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("yokaigoJyotaizorei").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtTsuchiKbn().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("tsuchiKbn").toString()));

        if (mapShinsakaiKekkaJoho.get("tsuchibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                    getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                    getKonkaiShinsaKekka().getTxtTsuchiKbn().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                    getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                    getKonkaiShinsaKekka().getTxtTsuchibi().setValue(
                            new RDate(mapShinsakaiKekkaJoho.get("tsuchibi").toString()));
        }

        if (mapShinsakaiKekkaJoho.get("yukokikanKaishibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                    getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                    getKonkaiShinsaKekka().getTxtYukokikanKaishibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                    getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                    getKonkaiShinsaKekka().getTxtYukokikanKaishibi().setValue(
                            new RDate(mapShinsakaiKekkaJoho.get("yukokikanKaishibi").toString()));
        }

        if (mapShinsakaiKekkaJoho.get("yukokikanShuryobi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                    getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                    getKonkaiShinsaKekka().getTxtYukokikanShuryobi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                    getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                    getKonkaiShinsaKekka().getTxtYukokikanShuryobi().setValue(
                            new RDate(mapShinsakaiKekkaJoho.get("yukokikanShuryobi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtNinteiKikan().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("ninteikikan").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getKonkaiShinsaKekka().getTxtTsuchiRiyu().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("tsuchiRiyu").toString()));

        if (mapShinsakaiKekkaJoho.get("zenkaiShinsakaiHanteibi").toString().isEmpty()) {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                    getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                    getZenkaiShinsaKekka().getTxtZenkaiShinsakaiHanteibi().clearValue();
        } else {
            panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                    getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                    getZenkaiShinsaKekka().getTxtZenkaiShinsakaiHanteibi().setValue(
                            new RDate(mapShinsakaiKekkaJoho.get("zenkaiShinsakaiHanteibi").toString()));
        }

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getZenkaiShinsaKekka().getTxtZenkaiYokaigoJotaiKbn().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("zenkaiYokaigoJotaiKbn").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getZenkaiShinsaKekka().getTxtZenkaiHenkoRiyu().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("zenkaiHenkoRiyu").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getZenkaiShinsaKekka().getTxtZenkaiShinsakaiIkenShurui().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("zenkaiShinsakaiIkenShurui").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getZenkaiShinsaKekka().getTxtZenkaiShinsakaiIken().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("zenkaiShinsakaiIken").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getZenkaiShinsaKekka().getTxtZenkaiShinsakaiMemo().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("zenkaiShinsakaiMemo").toString()));

        panel.getKojinJokyoShokaiSub().getTabKojinJokyoShokai().getTplShinsakai().
                getTabShinsakaiKojinShokai().getTplShinsakaiKekka().
                getZenkaiShinsaKekka().getTxtZenkaiYokaigoJyotaizorei().setValue(
                        new RString(mapShinsakaiKekkaJoho.get("zenkaiYokaigoJyotaizorei").toString()));
    }

    /*
     *審査会委員データグリッド情報を設定します。
     */
    private List createRowShinsakaiIin(HashMap shinsakaiIin) {

        List arrayDataList = new ArrayList();

        for (int i = 1; i <= Integer.parseInt((String) shinsakaiIin.get("shinsainsu")); i++) {

            String strKey1 = "shinsakaiIin" + i;
            String strShinsakaiIin = (String) shinsakaiIin.get(strKey1);

            String strKey2 = "shinsainKbn" + i;
            String strShinsainKbn = (String) shinsakaiIin.get(strKey2);

            String strKey3 = "gogitaichoKbn" + i;
            String strGogitaichoKbn = (String) shinsakaiIin.get(strKey3);

            String strKey4 = "shukketsuKbn" + i;
            String strShukketsuKbn = (String) shinsakaiIin.get(strKey4);

            arrayDataList.add(createRowShinsakaiIin(strShinsakaiIin, strShinsainKbn, strGogitaichoKbn, strShukketsuKbn));
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する審査会委員一覧データを作成します。
     */
    private dgShinsakaiIinJoho_Row createRowShinsakaiIin(
            String ShinsakaiIin,
            String ShinsainKbn,
            String GogitaichoKbn,
            String ShukketsuKbn
    ) {

        dgShinsakaiIinJoho_Row rowShinsakaiIin = new dgShinsakaiIinJoho_Row(
                new RString(ShinsakaiIin),
                new RString(ShinsainKbn),
                new RString(GogitaichoKbn),
                new RString(ShukketsuKbn)
        );
        return rowShinsakaiIin;
    }

}
