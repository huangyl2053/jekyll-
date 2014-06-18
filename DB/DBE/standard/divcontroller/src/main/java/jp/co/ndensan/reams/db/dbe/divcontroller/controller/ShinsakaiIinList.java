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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsakaiIinList.ShinsakaiIinListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsakaiIinList.dgShinsakaiIinChildList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * ShinsakaiIinListDivを操作します。 (共有子Div DBE.ShinsakaiIinList)
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
        div.getDgShinsakaiIinChildList().setDataSource(getListOfShinsakaiIin());
    }

    private static List<dgShinsakaiIinChildList_Row> getListOfShinsakaiIin() {
        List<dgShinsakaiIinChildList_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("ShinsakaiIinList/ShinsakaiIinList.yml"));
        for (Map info : targetSource) {
            list.add(toDgShinsakaiIinChildList_Row(info));
        }
        return list;
    }

    private static dgShinsakaiIinChildList_Row toDgShinsakaiIinChildList_Row(Map map) {
        RString shimei = _toRString(map.get("氏名"));
        RString kanaShimei = _toRString(map.get("カナ氏名"));
        dgShinsakaiIinChildList_Row row = new dgShinsakaiIinChildList_Row(
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
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

}
