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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.NinteichosaIraiByHandDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.RequestContentsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgNinteichosaIraiListForByHand_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * NinteichosaIraiByHandDivを操作するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaIraiByHand {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaIraiByHandDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiByHandDiv> onLoad(NinteichosaIraiByHandDiv div) {
        ResponseData<NinteichosaIraiByHandDiv> response = new ResponseData<>();

        div.getChosairaiBindByHandMain().getComNinteichosaIraiListGod().getDgNinteichosaIraiListForByHand()
                .setDataSource(ChosaIraiTargets.DATA_SORCE);
        RequestContents.onLoad(div.getChosairaiBindByHandMain().getRequestContents());

        response.data = div;
        return response;
    }

    private static final class RequestContents {

        private static final int NUM_OF_A_WEEK = 7;

        private static void onLoad(RequestContentsDiv div) {
            div.getDdIraiKubun().setSelectedItem(new RString("1"));
            FlexibleDate nowDate = FlexibleDate.getNowDate();
            div.getTxtChosaIraiDate().setValue(nowDate);
            div.getTxtChosaKigenDate().setValue(nowDate.plusDay(NUM_OF_A_WEEK));
        }

    }

    private enum DemoData {

        依頼者一覧("ChosaIraiTargets.yml");
        private final RString path;

        private DemoData(String fileName) {
            this.path = new RString("dbe2010002/" + fileName);
        }

        RString getPath() {
            return this.path;
        }
    }

    private static final class ChosaIraiTargets {

        private static final List<dgNinteichosaIraiListForByHand_Row> DATA_SORCE;

        static {
            DATA_SORCE = new ArrayList<>();
            try {
                List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(DemoData.依頼者一覧.getPath());
                for (Map target : targetSource) {
                    DATA_SORCE.add(to_dgNinteichosaIraiListForByHand_Row(target));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private static dgNinteichosaIraiListForByHand_Row to_dgNinteichosaIraiListForByHand_Row(Map map) {
            RString shimei = toRString(map.get("氏名"));
            RString kanaShimei = toRString(map.get("カナ氏名"));
            return new dgNinteichosaIraiListForByHand_Row(
                    compose調査状況(toRString(map.get("調査状況"))),
                    new Button(),
                    toRString(map.get("保険者番号")),
                    toRString(map.get("市町村")),
                    toRString(map.get("支所コード")),
                    toRString(map.get("支所")),
                    toRString(map.get("被保番号")),
                    shimei,
                    kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    toRString(map.get("認定申請区分")),
                    toTextBoxFlexibleDate(map.get("認定申請日")),
                    toRString(map.get("調査依頼区分")),
                    toTextBoxFlexibleDate(map.get("調査依頼日")),
                    toTextBoxFlexibleDate(map.get("調査期限日")),
                    toTextBoxFlexibleDate(map.get("依頼書発行日")),
                    toRString(map.get("調査委託先番号")),
                    toRString(map.get("調査委託先名")),
                    toRString(map.get("調査員番号")),
                    toRString(map.get("調査員名")),
                    toRString(map.get("前回調査委託先番号")),
                    toRString(map.get("前回調査委託先名")),
                    toRString(map.get("前回調査員番号")),
                    toRString(map.get("前回調査員名")),
                    toRString(map.get("前々回調査委託先番号")),
                    toRString(map.get("前々回調査委託先名")),
                    toRString(map.get("前々回調査員番号")),
                    toRString(map.get("前々回調査員名")),
                    toTextBoxFlexibleDate(map.get("督促日")),
                    toRString(map.get("督促回数")),
                    toRString(map.get("郵便番号")),
                    toRString(map.get("住所")),
                    toRString(map.get("入所施設"))
            );
        }
    }

    private static RString toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

    private static RString compose調査状況(RString rstr) {
        if (rstr.equals(new RString("true"))) {
            return new RString("済");
        } else {
            return new RString("未済");
        }
    }

    private static TextBoxFlexibleDate toTextBoxFlexibleDate(Object obj) {
        TextBoxFlexibleDate textBox = new TextBoxFlexibleDate();
        RString date = toRString(obj);
        if (date.equals(RString.EMPTY)) {
            textBox.setValue(FlexibleDate.EMPTY);
        } else {
            textBox.setValue(new FlexibleDate(date));
        }
        return textBox;
    }
}
