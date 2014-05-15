/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsakaiIinListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsakaiIinList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * ShinsakaiIinListDivを操作します。
 *
 * @author N3327 三浦 凌
 */
public class ShinsakaiIinList {

    /**
     * ロード時の処理です。
     *
     * @param div ShinsakaiIinListDiv
     * @return ResponseData
     */
    public ResponseData<ShinsakaiIinListDiv> onLoad(ShinsakaiIinListDiv div) {
        ResponseData<ShinsakaiIinListDiv> response = new ResponseData<>();

        ShinsakaiIinList.init(div);

        response.data = div;
        return response;
    }

    /**
     * 審査会委員の情報を検索し、設定します。
     *
     * @param div ShinsakaiIinListDiv
     */
    public static void init(ShinsakaiIinListDiv div) {
        div.getDgShinsakaiIinList().setDataSource(getListOfShinsakaiIin());
    }

    private static List<dgShinsakaiIinList_Row> getListOfShinsakaiIin() {
        List<dgShinsakaiIinList_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("ShinsakaiIinList.yml"));
        for (Map info : targetSource) {
            list.add(toDgShinsakaiIinList_Row(info));
        }
        return list;
    }

    private static dgShinsakaiIinList_Row toDgShinsakaiIinList_Row(Map map) {
        RString shimei = _toRString(map.get("氏名"));
        RString kanaShimei = _toRString(map.get("カナ氏名"));
        dgShinsakaiIinList_Row row = new dgShinsakaiIinList_Row(
                new Button(),
                _toRString(map.get("審査会委員番号")),
                shimei,
                kanaShimei,
                DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                _toRString(map.get("所属機関")),
                _toRString(map.get("性別")),
                _toRString(map.get("資格")));
        return row;
    }

    private static RString _toRString(Object obj) {
        return new RString(obj.toString());
    }

}
