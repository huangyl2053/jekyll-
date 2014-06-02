/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoIdoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoKanriTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.dgShisetsuNyutaishoKanriGaitosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.SaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 施設入退所の異動履歴を表示しているDivのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class ShisetsuNyutaishoIdo {

    private static final RString SHISETSU_NYUTAISHO_RIREKI = new RString("DBA2010011/ShisetsuNyutaishoRireki.yml");

    /**
     * 該当者検索画面でグリッドから対象者を選択した際に実行されます。
     *
     * @param idoRirekiDiv 施設入退所異動履歴Div
     * @param gaitoshaDiv 該当者Div
     * @param saikinShorishaDiv 最近処理者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSelect(ShisetsuNyutaishoIdoDiv idoRirekiDiv,
            ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SaikinShorishaRirekiDiv saikinShorishaDiv) {
        ResponseData<ShisetsuNyutaishoIdoDiv> response = new ResponseData<>();

        DataGrid<dgShisetsuNyutaishoKanriGaitosha_Row> gaitoshaGrid = gaitoshaDiv.getDgShisetsuNyutaishoKanriGaitosha();
        dgShisetsuNyutaishoKanriGaitosha_Row row = gaitoshaGrid.getClickedItem();
        ShisetsuNyutaishoRirekiKanriDiv rirekiKanriDiv = idoRirekiDiv.getShisetsuNyutaishoKanri();
        List<HashMap> idoRirekiList = getIdoRireki(row);
        setIdoRirekiGrid(rirekiKanriDiv.getDgShisetsuNyutaishoRireki(), idoRirekiList);

        setDdlTaishoShisetsu(idoRirekiDiv);
        setRadShisetsuShurui(idoRirekiDiv);
        if (idoRirekiList.isEmpty()) {
            rirekiKanriDiv.getShisetsuNyutaishoInput().setDisabled(false);
            rirekiKanriDiv.getBtnUpdateShisetsuNyutaisho().setDisabled(false);
        } else {
            rirekiKanriDiv.getShisetsuNyutaishoInput().setDisabled(true);
            rirekiKanriDiv.getBtnUpdateShisetsuNyutaisho().setDisabled(true);
        }

        response.data = idoRirekiDiv;
        return response;
    }

    private void setRadShisetsuShurui(ShisetsuNyutaishoIdoDiv idoRirekiDiv) {
        ShisetsuJohoDiv shisetsuJoho = idoRirekiDiv.getShisetsuNyutaishoKanri().getShisetsuNyutaishoInput().getShisetsuJoho();
        List<KeyValueDataSource> sourceList = new ArrayList<>();
        KeyValueDataSource source1 = new KeyValueDataSource(new RString("kaigoHokenShisetsu"), new RString("介護保険施設"));
        KeyValueDataSource source2 = new KeyValueDataSource(new RString("other"), new RString("その他特例施設"));
        sourceList.add(source1);
        sourceList.add(source2);
        shisetsuJoho.getRadShisetsuShurui().setDataSource(sourceList);
        shisetsuJoho.getRadShisetsuShurui().setSelectedItem(new RString("kaigoHokenShisetsu"));

        shisetsuJoho.getBtnJigyoshaInputGuide().setDisplayNone(false);
        shisetsuJoho.getBtnOtherTokureiShisetsuInputGuide().setDisplayNone(true);
        shisetsuJoho.getBtnJogaiShisetsuInputGuide().setDisplayNone(true);
    }

    private void setDdlTaishoShisetsu(ShisetsuNyutaishoIdoDiv idoRirekiDiv) {
        ShisetsuNyutaishoInputDiv inputDiv = idoRirekiDiv.getShisetsuNyutaishoKanri().getShisetsuNyutaishoInput();
        List<KeyValueDataSource> sourceList = new ArrayList<>();
        KeyValueDataSource source1 = new KeyValueDataSource(new RString("kannai"), new RString("管内施設"));
        KeyValueDataSource source2 = new KeyValueDataSource(new RString("jutoku"), new RString("住所地特例措置"));
        sourceList.add(source1);
        sourceList.add(source2);
        inputDiv.getDdlTaishoJoho().setDataSource(sourceList);
    }

    private List<HashMap> getIdoRireki(dgShisetsuNyutaishoKanriGaitosha_Row row) {
        List<HashMap> gaitoshaRirekiList = YamlLoader.FOR_DBA.loadAsList(SHISETSU_NYUTAISHO_RIREKI);
        for (HashMap gaitoshaRireki : gaitoshaRirekiList) {
            if (gaitoshaRireki.get("被保番号").toString().equals(row.getHihokenshaNo().toString())) {
                return (List<HashMap>) gaitoshaRireki.get("異動履歴");
            }
        }
        return Collections.EMPTY_LIST;
    }

    private void setIdoRirekiGrid(DataGrid<dgShisetsuNyutaishoRireki_Row> idoRirekiGrid, List<HashMap> idoRirekiList) {
        List<dgShisetsuNyutaishoRireki_Row> dataSource = new ArrayList<>();
        for (HashMap gaitosha : idoRirekiList) {
            dataSource.add(createIdoRirekiRow(gaitosha));
        }
        idoRirekiGrid.setDataSource(dataSource);
    }

    private dgShisetsuNyutaishoRireki_Row createIdoRirekiRow(HashMap gaitosha) {
        dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row(new Button(), new Button(), new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.getNyushoDate().setValue(new FlexibleDate(gaitosha.get("入所日").toString()));
        if (gaitosha.get("退所日") != null) {
            row.getTaishoDate().setValue(new FlexibleDate(gaitosha.get("退所日").toString()));
        }
        row.setShisetsuCode(new RString(gaitosha.get("施設コード").toString()));
        row.setShisetsuMeisho(new RString(gaitosha.get("施設名称").toString()));
        row.setShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));
        row.setShisetsuShuruiKey(new RString(gaitosha.get("施設種類Key").toString()));
        row.setShisetsuShurui(new RString(gaitosha.get("施設種類").toString()));
        row.setTaishoJohoKey(new RString(gaitosha.get("対象情報Key").toString()));
        row.setTaishoJoho(new RString(gaitosha.get("対象情報").toString()));
        return row;
    }

    /**
     * 該当者検索画面で、グリッドに表示された該当者が一人しかいない場合に実行されます。
     *
     * @param idoRirekiDiv 施設入退所異動履歴Div
     * @param gaitoshaDiv 該当者Div
     * @param saikinShorishaDiv 最近処理者Div
     * @return レスポンス
     */
    public ResponseData onOnlyRow_dgShisetsuNyutaishoKanriGaitosha(ShisetsuNyutaishoIdoDiv idoRirekiDiv,
            ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SaikinShorishaRirekiDiv saikinShorishaDiv) {
        ResponseData<ShisetsuNyutaishoIdoDiv> response = new ResponseData<>();

        response.data = idoRirekiDiv;
        return response;
    }

    /**
     * 該当者検索画面で、グリッドから対象者をダブルクリックで選択した際に実行されます。
     *
     * @param idoRirekiDiv 施設入退所異動履歴Div
     * @param gaitoshaDiv 該当者Div
     * @param saikinShorishaDiv 最近処理者Div
     * @return レスポンス
     */
    public ResponseData onSelectByDblClick_dgShisetsuNyutaishoKanriGaitosha(ShisetsuNyutaishoIdoDiv idoRirekiDiv,
            ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SaikinShorishaRirekiDiv saikinShorishaDiv) {
        ResponseData<ShisetsuNyutaishoIdoDiv> response = new ResponseData<>();

        response.data = idoRirekiDiv;
        return response;
    }

    /**
     * 該当者検索画面で、最近処理者Divから対象者を選択した際に実行されます。
     *
     * @param idoRirekiDiv 施設入退所異動履歴Div
     * @param gaitoshaDiv 該当者Div
     * @param saikinShorishaDiv 最近処理者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSaikinShorishaHyoji(ShisetsuNyutaishoIdoDiv idoRirekiDiv,
            ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SaikinShorishaRirekiDiv saikinShorishaDiv) {
        ResponseData<ShisetsuNyutaishoIdoDiv> response = new ResponseData<>();

        response.data = idoRirekiDiv;
        return response;
    }

}
