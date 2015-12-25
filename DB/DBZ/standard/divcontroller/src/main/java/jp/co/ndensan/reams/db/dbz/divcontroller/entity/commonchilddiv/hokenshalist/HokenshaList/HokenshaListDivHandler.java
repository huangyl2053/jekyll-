/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonlist.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.util.Comparators;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
//import jp.co.ndensan.reams.db.dbx.service.core.shichosonlist.ShichosonList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.session.PanelSessionAccessor;

/**
 * HokenshaListDivを扱います。
 * 関連するデータの取得やパネル内のデータ保持等を担当します。
 */
class HokenshaListDivHandler {

    private final HokenshaListDiv div;

    protected HokenshaListDivHandler(HokenshaListDiv div) {
        this.div = div;
    }

    /**
     * 保険者のリストを取得して、取得結果が持つ市町村名をddlHokenshaListへ市町村コードの昇順で設定します。
     * また、共有子Div内に、取得した保険者のリストを保持します。
     */
    void loadAndHoldHokenshaList() {
        List<ShichosonCodeNameResult> shichosonList = getShichosonCodeNameList();
//        Collections.sort(shichosonList, new Comparator<ShichosonCodeNameResult>() {
//            @Override
//            public int compare(ShichosonCodeNameResult o1, ShichosonCodeNameResult o2) {
//                return Objects.compare(o1.get市町村コード(), o2.get市町村コード(), Comparators.<LasdecCode>naturalOrder());
//            }
//        });

        List<KeyValueDataSource> list = new ArrayList<>();
//        if (1 < shichosonList.size()) {
        list.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
//        }

        Map<RString, ShichosonCodeNameResult> map = new HashMap<>();
        for (ShichosonCodeNameResult s : shichosonList) {
            RString key = s.get市町村コード().value();
            list.add(new KeyValueDataSource(key, s.get市町村名称()));
            map.put(key, s);
        }

        div.getDdlHokenshaList().setDataSource(list);
        ShichosonListHolder.putTo(div, map);
    }

    private List<ShichosonCodeNameResult> getShichosonCodeNameList() {
        //return ShichosonList.createInstance().getShichosonCodeNameList();
        return new ArrayList<ShichosonCodeNameResult>() {
            {
                add(new ShichosonCodeNameResult(
                        new LasdecCode("010102"), new RString("電算市"), new ShoKisaiHokenshaNo("010103"), TokeiTaishoKubun.構成市町村分)
                );
            }
        };
    }

    /**
     * ddlHokenshaListで選択されている市町村名に該当する保険者の情報を{@link ShichosonCodeNameResult}の形で返却します。
     *
     * @return 選択中の保険者の情報を持つ{@link ShichosonCodeNameResult}. 選択中の物が無い場合、{@link ShichosonCodeNameResult#EMPTY}
     * @throws {@link #loadAndHoldHokenshaList()} により、共有子Divの保険者情報が設定されていない場合
     */
    ShichosonCodeNameResult getSelectedItemAsShichosonCodeNameResult() {
        if (!ShichosonListHolder.hasShichosonList(div)) {
            throw new IllegalStateException("divに対して保険者情報が初期化されていません。そのため、指定の情報は取得できません。");
        }
        Map<RString, ShichosonCodeNameResult> map = ShichosonListHolder.getFrom(div);
        RString selectedKey = this.div.getDdlHokenshaList().getSelectedKey();
        if (map.containsKey(selectedKey)) {
            return map.get(selectedKey);
        } else {
            return ShichosonCodeNameResult.EMPTY;
        }
    }

    private static class ShichosonListHolder {

        private static final RString KEY;

        static {
            KEY = new RString("市町村リスト");
        }

        private static Map<RString, ShichosonCodeNameResult> getFrom(HokenshaListDiv div) {
            return Collections.unmodifiableMap(PanelSessionAccessor.get(div, KEY, Map.class));
        }

        private static void putTo(HokenshaListDiv div, Map<RString, ShichosonCodeNameResult> map) {
            PanelSessionAccessor.put(div, KEY, new HashMap<>(map));
        }

        private static boolean hasShichosonList(HokenshaListDiv div) {
            return PanelSessionAccessor.containsKey(div, KEY);
        }

        private ShichosonListHolder() {
        }
    }
}
