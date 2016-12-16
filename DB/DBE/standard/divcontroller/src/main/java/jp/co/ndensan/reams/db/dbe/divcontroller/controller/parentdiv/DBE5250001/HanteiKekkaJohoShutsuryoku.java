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
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSourceConverter;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 判定結果情報出力（介護認定審査会）クラスです。
 *
 * @reamsid_L DBE-0180-010 xuyannan
 */
public class HanteiKekkaJohoShutsuryoku {

    private static final RString モード = new RString("hanteiKekka");
    private static final RString 帳票発行ボタン = new RString("btnHanteiKekkaIchiran");

    /**
     * 判定結果情報出力（介護認定審査会）Divを初期化します。
     *
     * @param div 判定結果情報出力（介護認定審査会）Div
     * @return ResponseData<HanteiKekkaJohoShutsuryokuDiv> 判定結果情報出力（介護認定審査会）Div
     */
    public ResponseData<HanteiKekkaJohoShutsuryokuDiv> onLoad(HanteiKekkaJohoShutsuryokuDiv div) {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(帳票発行ボタン, false);
        div.getCcdIShinsakaiIchiranList().initialize(モード);
        Map<RString, RString> map = new LinkedHashMap<>();
        map.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.get帳票名称());
        map.put(DBE525001SelectChohyoType.要介護認定判定結果一覧表.getKey(), DBE525001SelectChohyoType.要介護認定判定結果一覧表.get帳票名称());
        map.put(DBE525001SelectChohyoType.要介護認定審査判定結果_鑑.getKey(), DBE525001SelectChohyoType.要介護認定審査判定結果_鑑.get帳票名称());
        map.put(DBE525001SelectChohyoType.要介護認定審査会議事録.getKey(), DBE525001SelectChohyoType.要介護認定審査会議事録.get帳票名称());
        map.put(DBE525001SelectChohyoType.要介護認定結果通知一覧表.getKey(), DBE525001SelectChohyoType.要介護認定結果通知一覧表.get帳票名称());
        div.getSelectShutsuryokuChohyo().getCblSelectShutsuryokuChohyo().setDataSource(KeyValueDataSourceConverter.getDataSource(map));
        div.getSelectShutsuryokuChohyo().getCblSelectShutsuryokuChohyo().setSelectedItems(KeyValueDataSourceConverter.getDataSource(map));
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
        parameter.setKaisaiBangouList(div.getCcdIShinsakaiIchiranList().get開催番号List());
        List<RString> selectedList = div.getSelectShutsuryokuChohyo().getCblSelectShutsuryokuChohyo().getSelectedKeys();
        if (selectedList.contains(DBE525001SelectChohyoType.要介護認定判定結果一覧表A3版.getKey())) {
            parameter.setPublish_HanteiKekkaA3(true);
        } else {
            parameter.setPublish_HanteiKekkaA3(false);
        }
        if (selectedList.contains(DBE525001SelectChohyoType.要介護認定判定結果一覧表.getKey())) {
            parameter.setPublish_HanteiKekka(true);
        } else {
            parameter.setPublish_HanteiKekka(false);
        }
        if (selectedList.contains(DBE525001SelectChohyoType.要介護認定審査判定結果_鑑.getKey())) {
            parameter.setPublish_HanteiKekkaKagami(true);
        } else {
            parameter.setPublish_HanteiKekkaKagami(false);
        }
        if (selectedList.contains(DBE525001SelectChohyoType.要介護認定審査会議事録.getKey())) {
            parameter.setPublish_ShinsakaiGijiroku(true);
        } else {
            parameter.setPublish_ShinsakaiGijiroku(false);
        }
        if (selectedList.contains(DBE525001SelectChohyoType.要介護認定結果通知一覧表.getKey())) {
            parameter.setPublish_KekkaTsuchiIchiran(true);
        } else {
            parameter.setPublish_KekkaTsuchiIchiran(false);
        }
        return ResponseData.of(parameter).respond();
    }

    private HanteiKekkaJohoShutsuryokuValidationHandler getValidationHandler(HanteiKekkaJohoShutsuryokuDiv div) {
        return new HanteiKekkaJohoShutsuryokuValidationHandler(div);
    }
}
