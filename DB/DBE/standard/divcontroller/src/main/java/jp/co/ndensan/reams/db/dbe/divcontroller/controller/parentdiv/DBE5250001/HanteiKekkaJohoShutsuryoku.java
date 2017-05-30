/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5250001;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525001.DBE525001SelectChohyoType;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525001.DBE525001_HanteiKekkaShinsakaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250001.HanteiKekkaJohoShutsuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250001.HanteiKekkaJohoShutsuryokuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSourceConverter;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 判定結果情報出力（介護認定審査会）クラスです。
 *
 * @reamsid_L DBE-0180-010 xuyannan
 */
public class HanteiKekkaJohoShutsuryoku {

    private static final RString モード = new RString("hanteiKekka");
    private static final RString 一覧グリッド高さ = new RString("300");
    private static final RString config_1 = new RString("1");
    private static final RString config_2 = new RString("2");
    private static final RString config_3 = new RString("3");
    private static final RString 広域保険者ID = new RString("00");

    /**
     * 判定結果情報出力（介護認定審査会）Divを初期化します。
     *
     * @param div 判定結果情報出力（介護認定審査会）Div
     * @return ResponseData<HanteiKekkaJohoShutsuryokuDiv> 判定結果情報出力（介護認定審査会）Div
     */
    public ResponseData<HanteiKekkaJohoShutsuryokuDiv> onLoad(HanteiKekkaJohoShutsuryokuDiv div) {
        div.getCcdIShinsakaiIchiranList().initialize(モード);
        Map<RString, RString> map = new LinkedHashMap<>();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 市町村識別ID = 市町村セキュリティ情報.get市町村情報().get市町村識別ID();
        if (広域保険者ID.equals(市町村識別ID)) {
            map.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.get帳票名称());
            map.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表.get帳票名称());
            map.put(DBE525001SelectChohyoType.要介護認定審査会議事録.getKey(), DBE525001SelectChohyoType.要介護認定審査会議事録.get帳票名称());
            map.put(DBE525001SelectChohyoType.要介護認定審査判定結果_鑑.getKey(), DBE525001SelectChohyoType.要介護認定審査判定結果_鑑.get帳票名称());
            map.put(DBE525001SelectChohyoType.要介護認定結果通知一覧表.getKey(), DBE525001SelectChohyoType.要介護認定結果通知一覧表.get帳票名称());
        } else {
            map.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.get帳票名称());
            map.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表.get帳票名称());
        }
        div.getSelectShutsuryokuChohyo().getCblSelectShutsuryokuChohyo().setDataSource(KeyValueDataSourceConverter.getDataSource(map));
        Map<RString, RString> selectedMap = new LinkedHashMap<>();
        RString 判定一覧出力帳票フラグ = DbBusinessConfig.get(ConfigNameDBE.判定一覧出力帳票フラグ, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (config_1.equals(判定一覧出力帳票フラグ)) {
            selectedMap.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.get帳票名称());
        } else if (config_2.equals(判定一覧出力帳票フラグ)) {
            selectedMap.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表.get帳票名称());
        } else if (config_3.equals(判定一覧出力帳票フラグ)) {
            selectedMap.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.get帳票名称());
            selectedMap.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表.get帳票名称());
        }
        if (広域保険者ID.equals(市町村識別ID)) {
            RString 審査会議事録出力フラグ = DbBusinessConfig.get(ConfigNameDBE.審査会議事録出力帳票フラグ, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            RString 初期選択_介護認定審査会判定結果鑑 = DbBusinessConfig.get(ConfigNameDBE.初期選択_介護認定審査会判定結果鑑, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            RString 初期選択_要介護認定結果通知一覧 = DbBusinessConfig.get(ConfigNameDBE.初期選択_要介護認定結果通知一覧, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (config_1.equals(審査会議事録出力フラグ)) {
                selectedMap.put(DBE525001SelectChohyoType.要介護認定審査会議事録.getKey(), DBE525001SelectChohyoType.要介護認定審査会議事録.get帳票名称());
            }
            if (config_1.equals(初期選択_介護認定審査会判定結果鑑)) {
                selectedMap.put(DBE525001SelectChohyoType.要介護認定審査判定結果_鑑.getKey(), DBE525001SelectChohyoType.要介護認定審査判定結果_鑑.get帳票名称());
            }
            if (config_1.equals(初期選択_要介護認定結果通知一覧)) {
                selectedMap.put(DBE525001SelectChohyoType.要介護認定結果通知一覧表.getKey(), DBE525001SelectChohyoType.要介護認定結果通知一覧表.get帳票名称());
            }
        }
        div.getSelectShutsuryokuChohyo().getCblSelectShutsuryokuChohyo().setSelectedItems(KeyValueDataSourceConverter.getDataSource(selectedMap));
        div.getCcdIShinsakaiIchiranList().set一覧グリッド高さ指定(一覧グリッド高さ);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会データ空チェックを実施します。
     *
     * @param div 判定結果情報出力（介護認定審査会）Div
     * @return ResponseData<NenreiTotatsuTorokushaListDiv>
     */
    public ResponseData<HanteiKekkaJohoShutsuryokuDiv> onClick_Check(HanteiKekkaJohoShutsuryokuDiv div) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (getValidationHandler(div).データ空チェック(validPairs).iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        } else if (getValidationHandler(div).未選択チェック(validPairs).iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * パラメーターを作成します。
     *
     * @param div バッチパラメータ情報Div
     * @return ResponseData<DBE525001_HanteiKekkaShinsakaiParameter>
     */
    public ResponseData<DBE525001_HanteiKekkaShinsakaiParameter> onClick_btnAction(HanteiKekkaJohoShutsuryokuDiv div) {
        DBE525001_HanteiKekkaShinsakaiParameter parameter = new DBE525001_HanteiKekkaShinsakaiParameter();
        parameter.setKaisaiBangou(div.getCcdIShinsakaiIchiranList().get開催番号List().get(0));
        List<RString> selectedChohyoList = div.getSelectShutsuryokuChohyo().getCblSelectShutsuryokuChohyo().getSelectedKeys();
        if (selectedChohyoList.contains(DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.getKey())) {
            parameter.setPublish_HanteiKekkaA3(true);
        } else {
            parameter.setPublish_HanteiKekkaA3(false);
        }
        if (selectedChohyoList.contains(DBE525001SelectChohyoType.要介護認定判定結果一覧表.getKey())) {
            parameter.setPublish_HanteiKekka(true);
        } else {
            parameter.setPublish_HanteiKekka(false);
        }
        if (selectedChohyoList.contains(DBE525001SelectChohyoType.要介護認定審査判定結果_鑑.getKey())) {
            parameter.setPublish_HanteiKekkaKagami(true);
        } else {
            parameter.setPublish_HanteiKekkaKagami(false);
        }
        if (selectedChohyoList.contains(DBE525001SelectChohyoType.要介護認定審査会議事録.getKey())) {
            parameter.setPublish_ShinsakaiGijiroku(true);
        } else {
            parameter.setPublish_ShinsakaiGijiroku(false);
        }
        if (selectedChohyoList.contains(DBE525001SelectChohyoType.要介護認定結果通知一覧表.getKey())) {
            parameter.setPublish_KekkaTsuchiIchiran(true);
        } else {
            parameter.setPublish_KekkaTsuchiIchiran(false);
        }
        parameter.setUserId(UrControlDataFactory.createInstance().getLoginInfo().getUserId());
        return ResponseData.of(parameter).respond();
    }

    private HanteiKekkaJohoShutsuryokuValidationHandler getValidationHandler(HanteiKekkaJohoShutsuryokuDiv div) {
        return new HanteiKekkaJohoShutsuryokuValidationHandler(div);
    }
}
