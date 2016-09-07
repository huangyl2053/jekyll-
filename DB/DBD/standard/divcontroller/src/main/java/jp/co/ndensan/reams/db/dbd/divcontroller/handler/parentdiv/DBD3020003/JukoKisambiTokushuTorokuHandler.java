/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD3020003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JikoKisambiKanri;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JikoKisambiKanriBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TokuchoFuchoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003.JukoKisambiTokushuTorokuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003.dgJikoKisambi_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003.dgShunoJokyo_Row;
import jp.co.ndensan.reams.db.dbd.service.core.basic.JikoKisambiKanriManager;
import jp.co.ndensan.reams.db.dbd.service.core.dbd3020003.JukoKisambiTokushuTorokuManager;
import jp.co.ndensan.reams.db.dbd.service.core.taino.TainoJokyoResearcher;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 「時効起算日特殊登録」画面のHandlerクラスです。
 *
 * @reamsid_L DBD-3820-010 huangh
 */
public class JukoKisambiTokushuTorokuHandler {

    private final JukoKisambiTokushuTorokuDiv div;

    private final RString 年度 = new RString("年度");
    private final RString 期 = new RString("期");
    private final RString 修正 = new RString("修正");
    private final RString 全行表示_ON = new RString("isZengyoHyoji");

    private static final int INT_2 = 2;

    /**
     * コンストラクタです。
     *
     * @param div 受給照会のコントロールdiv
     */
    public JukoKisambiTokushuTorokuHandler(JukoKisambiTokushuTorokuDiv div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @return List<TainoKiSummary>
     */
    public List<TainoKiSummary> initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {

        TainoJokyoResearcher search = TainoJokyoResearcher.createInstance();
        TainoHanteiResult resultList = search.research滞納状況(被保険者番号, FlexibleDate.getNowDate());

        if (resultList == null || resultList.get滞納情報().isEmpty()) {
            return new ArrayList<>();
        }

        div.getCcdAtenaInfo().initialize(識別コード);
        div.getCcdShikakuKihon().initialize(被保険者番号);

        div.getTxtTainoHanteiKijunDate().setValue(FlexibleDate.getNowDate());

        List<TainoKiSummary> 表示用リスト = new ArrayList<>();
        Map<FlexibleYear, TainoKiSummary> map = new HashMap<>();
        for (TainoKiSummary tainoKiSummary : resultList.get滞納情報()) {

            if (map.containsKey(tainoKiSummary.get調定年度())) {

                Decimal 調定額 = map.get(tainoKiSummary.get調定年度()).get調定額();
                Decimal 収入額 = map.get(tainoKiSummary.get調定年度()).get収入額();
                Decimal 滞納額 = map.get(tainoKiSummary.get調定年度()).get滞納額();

                TainoKiSummary newTainoKiSummary = new TainoKiSummary(
                        tainoKiSummary.get賦課年度(),
                        tainoKiSummary.get調定年度(),
                        tainoKiSummary.is過年度(),
                        tainoKiSummary.get期(),
                        tainoKiSummary.get調定額().add(調定額),
                        tainoKiSummary.get収入額().add(収入額),
                        tainoKiSummary.get滞納額().add(滞納額),
                        tainoKiSummary.get納期限(),
                        tainoKiSummary.get時効起算日(),
                        tainoKiSummary.get時効起算日区分(),
                        tainoKiSummary.get未納完納区分(),
                        tainoKiSummary.get時効区分(),
                        tainoKiSummary.get通知書番号(),
                        tainoKiSummary.get徴収方法(),
                        tainoKiSummary.get時効後収入区分(),
                        tainoKiSummary.get対象管理区分(),
                        tainoKiSummary.get控除額());

                map.put(tainoKiSummary.get調定年度(), newTainoKiSummary);
            } else {
                map.put(tainoKiSummary.get調定年度(), tainoKiSummary);

            }
        }

        表示用リスト.addAll(map.values());
        List<dgShunoJokyo_Row> rowList = new ArrayList<>();
        for (TainoKiSummary tainoKiSummary : 表示用リスト) {
            dgShunoJokyo_Row row = new dgShunoJokyo_Row();
            row.getChoteiNendo().setValue(new FlexibleDate(tainoKiSummary.get調定年度().wareki().
                    eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().concat(年度)));

            row.getChoteiGaku().setValue(tainoKiSummary.get調定額());
            row.getShunyuGaku().setValue(tainoKiSummary.get収入額());
            row.getJikoToraiMinogaku().setValue(tainoKiSummary.get滞納額());
            row.setNokigen(tainoKiSummary.get納期限().toDateString());
            row.setJikoKisanYMD(new RString(tainoKiSummary.get時効起算日().toString()));
            row.setJikoKisanYMDKubun(tainoKiSummary.get時効起算日区分().getコード());

            rowList.add(row);
        }
        div.getDgShunoJokyo().setDataSource(rowList);

        List<RString> chkZengyoHyoji = new ArrayList<>();
        chkZengyoHyoji.add(全行表示_ON);
        div.getChkZengyoHyoji().setSelectedItemsByKey(chkZengyoHyoji);
        return resultList.get滞納情報();
    }

    /**
     * gridのselect操作処理です。
     *
     * @param 時効起算日管理List List<JikoKisambiKanri>
     * @param 被保険者番号 HihokenshaNo
     */
    public void onClick_selectBySelectButton(
            List<JikoKisambiKanri> 時効起算日管理List,
            HihokenshaNo 被保険者番号) {

        List<dgJikoKisambi_Row> 時効起算日登録List = new ArrayList<>();
        boolean 存在フラグ = false;
        for (JikoKisambiKanri 時効起算日管理 : 時効起算日管理List) {
            if (時効起算日管理.get調定年度().
                    equals(new RYear(div.getDgShunoJokyo().getActiveRow().getChoteiNendo().getValue().getYearValue()))) {
                dgJikoKisambi_Row row = new dgJikoKisambi_Row();
                row.setFukaNendo(時効起算日管理.get賦課年度().wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
                row.setFuchoTokucho(TokuchoFuchoKubun.toValue(時効起算日管理.get特徴_普徴区分()).get名称());
                row.setTsuchishoNo(時効起算日管理.get通知書番号().getColumnValue());
                row.setKi(時効起算日管理.get収納期_月().padZeroToLeft(INT_2).concat(期));
                row.setChoteigaku(div.getDgShunoJokyo().getActiveRow().getChoteiGaku().getText());
                row.getNokigen().setValue(new FlexibleDate(div.getDgShunoJokyo().getActiveRow().getNokigen()));
                row.setShunyugaku(div.getDgShunoJokyo().getActiveRow().getShunyuGaku().getText());
                row.setMinogaku(div.getDgShunoJokyo().getActiveRow().getJikoToraiMinogaku().getText());
                row.getJikoKisaibi().setValue(new FlexibleDate(div.getDgShunoJokyo().getActiveRow().getJikoKisanYMD()));
                row.setJikoKisaibiJiyu(JikoKisanbiKubun.toValue(div.getDgShunoJokyo().getActiveRow().getJikoKisanYMDKubun()).get名称());
                row.getTokushuJikoKisaibi().setValue(new FlexibleDate(div.getDgShunoJokyo().getActiveRow().getJikoKisanYMD()));
                row.getTokushuJikoKisaibiJiyu().setDataSource(get時効起算日区分List());
                row.getTokushuJikoKisaibiJiyu().setSelectedKey(時効起算日管理.get時効起算日区分());

                時効起算日登録List.add(row);
                存在フラグ = true;
            }
        }
        if (!存在フラグ) {
            JukoKisambiTokushuTorokuManager manager = JukoKisambiTokushuTorokuManager.createInstance();

            List<JikoKisambiKanri> 時効起算日管理リスト = manager.get時効起算日管理(
                    被保険者番号, new RYear(div.getDgShunoJokyo().getActiveRow().getChoteiNendo().getValue().getYear().getYearValue()));

            for (JikoKisambiKanri 時効起算日管理 : 時効起算日管理リスト) {

                dgJikoKisambi_Row row = new dgJikoKisambi_Row();
                row.setFukaNendo(時効起算日管理.get賦課年度().wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
                row.setFuchoTokucho(TokuchoFuchoKubun.toValue(時効起算日管理.get特徴_普徴区分()).get名称());
                row.setTsuchishoNo(時効起算日管理.get通知書番号().getColumnValue());
                row.setKi(時効起算日管理.get収納期_月().padZeroToLeft(INT_2).concat(期));
                row.setChoteigaku(div.getDgShunoJokyo().getActiveRow().getChoteiGaku().getText());
                row.getNokigen().setValue(new FlexibleDate(div.getDgShunoJokyo().getActiveRow().getNokigen()));
                row.setShunyugaku(div.getDgShunoJokyo().getActiveRow().getShunyuGaku().getText());
                row.setMinogaku(div.getDgShunoJokyo().getActiveRow().getJikoToraiMinogaku().getText());
                row.getJikoKisaibi().setValue(new FlexibleDate(div.getDgShunoJokyo().getActiveRow().getJikoKisanYMD()));
                row.setJikoKisaibiJiyu(JikoKisanbiKubun.toValue(div.getDgShunoJokyo().getActiveRow().getJikoKisanYMDKubun()).get名称());
                row.getTokushuJikoKisaibi().setValue(new FlexibleDate(div.getDgShunoJokyo().getActiveRow().getJikoKisanYMD()));
                row.getTokushuJikoKisaibiJiyu().setDataSource(get時効起算日区分List());
                row.getTokushuJikoKisaibiJiyu().setSelectedKey(時効起算日管理.get時効起算日区分());
                row.setJikoKisambiKanri(DataPassingConverter.serialize(時効起算日管理));

                時効起算日登録List.add(row);
            }
        }

        div.getDgJikoKisambi().setDataSource(時効起算日登録List);
        div.getDdlFukushaJikoKisambiJiyu().setDataSource(get時効起算日区分List());
    }

    /**
     * 時効起算日登録Gridの内容変更判定です。
     *
     * @return boolean
     */
    public boolean is変更判定for時効起算日登録() {

        List<dgJikoKisambi_Row> rowList = div.getDgJikoKisambi().getDataSource();
        for (dgJikoKisambi_Row row : rowList) {
            if (!row.getJikoKisaibi().getValue().equals(row.getTokushuJikoKisaibi().getValue())
                    || !row.getJikoKisaibiJiyu().equals(row.getTokushuJikoKisaibiJiyu().getSelectedValue())) {
                return true;
            }
        }

        return false;
    }

    /**
     * 収納状況Gridの内容変更判定です。
     *
     * @return boolean
     */
    public boolean is変更判定for収納状況() {

        List<dgShunoJokyo_Row> rowList = div.getDgShunoJokyo().getDataSource();
        for (dgShunoJokyo_Row row : rowList) {
            if (修正.equals(row.getJotai())) {
                return true;
            }
        }

        return false;
    }

    /**
     * 全行表示チェックボックスです。
     *
     * @param 時効起算日管理List List<JikoKisambiKanri>
     */
    public void onChange_chkZengyoHyoji(List<JikoKisambiKanri> 時効起算日管理List) {

        List<dgJikoKisambi_Row> 時効起算日登録List = new ArrayList<>();
        Map<RString, RString> fukaNendoMap = new HashMap<>();
        Map<RString, RString> fuchoTokuchoMap = new HashMap<>();
        Map<RString, RString> tsuchishoNoMap = new HashMap<>();
        for (int i = 0; i < 時効起算日管理List.size(); i++) {
            if (div.getChkZengyoHyoji().isAllSelected()) {

                JikoKisambiKanri 時効起算日管理 = 時効起算日管理List.get(i);
                dgJikoKisambi_Row row = div.getDgJikoKisambi().getDataSource().get(i);
                row.setFukaNendo(時効起算日管理.get賦課年度().wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
                row.setFuchoTokucho(TokuchoFuchoKubun.toValue(時効起算日管理.get特徴_普徴区分()).get名称());
                row.setTsuchishoNo(時効起算日管理.get通知書番号().getColumnValue());

                時効起算日登録List.add(row);
            } else {

                dgJikoKisambi_Row row = div.getDgJikoKisambi().getDataSource().get(i);

                if (fukaNendoMap.containsKey(row.getFukaNendo())) {
                    row.setFukaNendo(RString.EMPTY);
                } else {
                    fukaNendoMap.put(row.getFukaNendo(), row.getFukaNendo());
                }
                if (fuchoTokuchoMap.containsKey(row.getFuchoTokucho())) {
                    row.setFuchoTokucho(RString.EMPTY);
                } else {
                    fuchoTokuchoMap.put(row.getFuchoTokucho(), row.getFuchoTokucho());
                }
                if (tsuchishoNoMap.containsKey(row.getTsuchishoNo())) {
                    row.setTsuchishoNo(RString.EMPTY);
                } else {
                    tsuchishoNoMap.put(row.getTsuchishoNo(), row.getTsuchishoNo());
                }

                時効起算日登録List.add(row);
            }
        }

        div.getDgJikoKisambi().setDataSource(時効起算日登録List);
    }

    /**
     * 複写ボタンです。
     *
     */
    public void onClick_btnIkkatsuFukusha() {

        List<dgJikoKisambi_Row> new時効起算日登録List = new ArrayList<>();
        List<dgJikoKisambi_Row> 時効起算日登録List = div.getDgJikoKisambi().getDataSource();
        for (dgJikoKisambi_Row row : 時効起算日登録List) {

            row.getTokushuJikoKisaibi().setValue(div.getTxtTokushuJikoKisambi().getValue());
            row.getTokushuJikoKisaibiJiyu().setSelectedKey(div.getDdlFukushaJikoKisambiJiyu().getSelectedKey());
            new時効起算日登録List.add(row);

        }
        div.getDgJikoKisambi().setDataSource(new時効起算日登録List);
    }

    /**
     * 確定ボタンです。
     *
     * @param 時効起算日管理List List<JikoKisambiKanri>
     * @return List<JikoKisambiKanri>
     */
    public List<JikoKisambiKanri> onClick_btnKakutei(List<JikoKisambiKanri> 時効起算日管理List) {

        List<dgJikoKisambi_Row> 時効起算日登録List = div.getDgJikoKisambi().getDataSource();
        List<JikoKisambiKanri> new時効起算日管理List = new ArrayList<>();
        for (dgJikoKisambi_Row row : 時効起算日登録List) {

            JikoKisambiKanri 時効起算日管理 = DataPassingConverter.deserialize(row.getJikoKisambiKanri(), JikoKisambiKanri.class);

            JikoKisambiKanriBuilder builder = 時効起算日管理.createBuilderForEdit();
            builder.set時効起算年月日(row.getTokushuJikoKisaibi().getValue());
            builder.set時効起算日区分(row.getTokushuJikoKisaibiJiyu().getSelectedKey());

            JikoKisambiKanri new時効起算日管理 = builder.build();

            if (!時効起算日管理List.contains(new時効起算日管理)) {
                new時効起算日管理 = new時効起算日管理.added();
                new時効起算日管理List.add(new時効起算日管理);
            } else if (RString.isNullOrEmpty(new RString(row.getTokushuJikoKisaibi().getValue().toString()))
                    && RString.isNullOrEmpty(row.getTokushuJikoKisaibiJiyu().getSelectedValue())) {
                new時効起算日管理 = new時効起算日管理.deleted();
                new時効起算日管理List.add(new時効起算日管理);
            } else {
                new時効起算日管理 = new時効起算日管理.modifiedModel();
                new時効起算日管理List.add(new時効起算日管理);
            }
        }

        return new時効起算日管理List;
    }

    /**
     * 保存するボタンです。
     *
     * @param 時効起算日管理List List<JikoKisambiKanri>
     */
    public void onClick_btnSave(List<JikoKisambiKanri> 時効起算日管理List) {

        for (JikoKisambiKanri jikoKisambiKanri : 時効起算日管理List) {
            JikoKisambiKanriManager manager = new JikoKisambiKanriManager();
            manager.save時効起算日管理(jikoKisambiKanri);
        }
    }

    private List<KeyValueDataSource> get時効起算日区分List() {

        List<KeyValueDataSource> 時効起算日区分List = new ArrayList<>();
        for (JikoKisanbiKubun 時効起算日区分 : JikoKisanbiKubun.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(時効起算日区分.getコード());
            keyValue.setValue(時効起算日区分.get名称());
            時効起算日区分List.add(keyValue);
        }
        return 時効起算日区分List;
    }
}
