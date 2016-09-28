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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 「時効起算日特殊登録」画面のHandlerクラスです。
 *
 * @reamsid_L DBD-3820-010 huangh
 */
public class JukoKisambiTokushuTorokuHandler {

    private final JukoKisambiTokushuTorokuDiv div;

    private final RString 年度 = new RString("年度");
    private final RString 保険料 = new RString("保険料");
    private final RString 期 = new RString("期");
    private final RString 修正 = new RString("修正");
    private final RString 全行表示_ON = new RString("isZengyoHyoji");

    private static final char CHAR_0 = 0;
    private static final int INT_2 = 2;
    private static final int INT_10 = 10;

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
            row.setSeirekiChoteiNendo(tainoKiSummary.get調定年度().toDateString());

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
     * @param 滞納判定結果List List<TainoKiSummary>
     * @param 時効起算日管理List List<JikoKisambiKanri>
     * @param 被保険者番号 HihokenshaNo
     * @return List<JikoKisambiKanri>
     */
    public List<JikoKisambiKanri> onClick_selectBySelectButton(
            List<TainoKiSummary> 滞納判定結果List,
            List<JikoKisambiKanri> 時効起算日管理List,
            HihokenshaNo 被保険者番号) {

        div.getJikoKisambi().getLblHokenryoTitle().setText(div.getDgShunoJokyo().getActiveRow().getChoteiNendo().
                getText().concat(保険料));
        RString 調定年度 = div.getDgShunoJokyo().getActiveRow().getSeirekiChoteiNendo();
        div.setHdnChoteiNendo(null判定(調定年度));

        List<JikoKisambiKanri> dbから時効起算日管理List = this.get時効起算日管理リスト(被保険者番号, new RYear(調定年度));
        List<dgJikoKisambi_Row> 時効起算日登録List = new ArrayList<>();
        boolean 存在フラグ = false;

        for (TainoKiSummary tainoKiSummary : 滞納判定結果List) {
            if (tainoKiSummary.get調定年度().toDateString().equals(調定年度)) {
                dgJikoKisambi_Row row = new dgJikoKisambi_Row();
                row.setFukaNendo(tainoKiSummary.get賦課年度().wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
                row.setHdnFukaNendo(tainoKiSummary.get賦課年度().toDateString());
                row.setFuchoTokucho(TokuchoFuchoKubun.toValue(tainoKiSummary.get徴収方法().getコード()).get名称());
                row.setHdnFuchoTokucho(tainoKiSummary.get徴収方法().getコード());
                row.setTsuchishoNo(tainoKiSummary.get通知書番号().getColumnValue());
                row.setHdnTsuchishoNo(tainoKiSummary.get通知書番号().getColumnValue());
                row.setKi(tainoKiSummary.get期().padZeroToLeft(INT_2).concat(期));
                row.setChoteigaku(new RString(tainoKiSummary.get調定額().toString()));
                row.getNokigen().setValue(new FlexibleDate(tainoKiSummary.get納期限().toDateString()));
                row.setShunyugaku(new RString(tainoKiSummary.get収入額().toString()));
                row.setMinogaku(new RString(tainoKiSummary.get滞納額().toString()));
                row.getJikoKisaibi().setValue(tainoKiSummary.get時効起算日());
                row.setJikoKisaibiJiyu(JikoKisanbiKubun.toValue(tainoKiSummary.get時効起算日区分().getコード()).get名称());
                row.getTokushuJikoKisaibiJiyu().setDataSource(get時効起算日区分List());

                for (JikoKisambiKanri jikoKisambiKanri : 時効起算日管理List) {
                    if (new RString(jikoKisambiKanri.get調定年度().getYearValue()).equals(調定年度)
                            && new RString(jikoKisambiKanri.get賦課年度().getYearValue()).equals(row.getHdnFukaNendo())
                            && jikoKisambiKanri.get特徴_普徴区分().equals(row.getHdnFuchoTokucho())
                            && jikoKisambiKanri.get通知書番号().value().equals(row.getTsuchishoNo())
                            && jikoKisambiKanri.get収納期_月().equals(row.getKi().substring(0, INT_2).trimStart(CHAR_0))) {
                        row.getTokushuJikoKisaibi().setValue(jikoKisambiKanri.get時効起算年月日());
                        row.getTokushuJikoKisaibiJiyu().setSelectedKey(jikoKisambiKanri.get時効起算日区分());
                        存在フラグ = true;
                    }

                }
                if (!存在フラグ) {
                    時効起算日管理List.addAll(this.setFor時効起算日管理が存在しない(被保険者番号, new RYear(調定年度), row, dbから時効起算日管理List));
                }

                if (MinoKannoKubun.過納.equals(tainoKiSummary.get未納完納区分())) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorGreen);
                } else if (MinoKannoKubun.未納あり.equals(tainoKiSummary.get未納完納区分())
                        && JikoKubun.時効未到来.equals(tainoKiSummary.get時効区分())) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorYellow);
                } else if (MinoKannoKubun.未納あり.equals(tainoKiSummary.get未納完納区分())
                        && JikoKubun.時効到来.equals(tainoKiSummary.get時効区分())
                        && new FlexibleDate(tainoKiSummary.get納期限().toDateString()).
                        compareTo(div.getTxtTainoHanteiKijunDate().getValue().minusYear(INT_10)) > 0) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorRed);
                } else if (MinoKannoKubun.未納あり.equals(tainoKiSummary.get未納完納区分())
                        && JikoKubun.時効到来.equals(tainoKiSummary.get時効区分())
                        && new FlexibleDate(tainoKiSummary.get納期限().toDateString()).
                        compareTo(div.getTxtTainoHanteiKijunDate().getValue().minusYear(INT_10)) <= 0) {
                    row.setRowBgColor(DataGridCellBgColor.bgColorGray);
                }
                時効起算日登録List.add(row);
            }
        }
        div.getDgJikoKisambi().setDataSource(時効起算日登録List);
        div.getDdlFukushaJikoKisambiJiyu().setDataSource(get時効起算日区分List());

        return 時効起算日管理List;
    }

    /**
     * 時効起算日登録Gridの内容変更判定です。
     *
     * @param 時効起算日管理List List<JikoKisambiKanri>
     * @return boolean
     */
    public boolean is変更判定for時効起算日登録(List<JikoKisambiKanri> 時効起算日管理List) {

        List<dgJikoKisambi_Row> rowList = div.getDgJikoKisambi().getDataSource();
        RString 調定年度 = div.getHdnChoteiNendo();
        for (dgJikoKisambi_Row row : rowList) {
            for (JikoKisambiKanri 時効起算日管理 : 時効起算日管理List) {
                if (new RString(時効起算日管理.get調定年度().getYearValue()).equals(調定年度)
                        && new RString(時効起算日管理.get賦課年度().getYearValue()).equals(row.getHdnFukaNendo())
                        && 時効起算日管理.get特徴_普徴区分().equals(row.getHdnFuchoTokucho())
                        && 時効起算日管理.get通知書番号().value().equals(row.getTsuchishoNo())
                        && 時効起算日管理.get収納期_月().equals(row.getKi().substring(0, INT_2).trimStart(CHAR_0))
                        && (!時効起算日管理.get時効起算年月日().equals(row.getTokushuJikoKisaibi().getValue())
                        || !時効起算日管理.get時効起算日区分().equals(row.getTokushuJikoKisaibiJiyu().getSelectedKey()))) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 時効起算日登録Gridの内容変更判定です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return boolean
     */
    public boolean is変更判定for保存(HihokenshaNo 被保険者番号) {

        List<dgJikoKisambi_Row> rowList = div.getDgJikoKisambi().getDataSource();
        RString 調定年度 = div.getHdnChoteiNendo();
        List<JikoKisambiKanri> 時効起算日管理List = this.get時効起算日管理リスト(被保険者番号, new RYear(調定年度));
        for (dgJikoKisambi_Row row : rowList) {
            for (JikoKisambiKanri 時効起算日管理 : 時効起算日管理List) {
                if (new RString(時効起算日管理.get調定年度().getYearValue()).equals(調定年度)
                        && new RString(時効起算日管理.get賦課年度().getYearValue()).equals(row.getHdnFukaNendo())
                        && 時効起算日管理.get特徴_普徴区分().equals(row.getHdnFuchoTokucho())
                        && 時効起算日管理.get通知書番号().value().equals(row.getTsuchishoNo())
                        && 時効起算日管理.get収納期_月().equals(row.getKi().substring(0, INT_2).trimStart(CHAR_0))
                        && (!時効起算日管理.get時効起算年月日().equals(row.getTokushuJikoKisaibi().getValue())
                        || !時効起算日管理.get時効起算日区分().equals(row.getTokushuJikoKisaibiJiyu().getSelectedKey()))) {
                    return true;
                }
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
     */
    public void onChange_chkZengyoHyoji() {

        List<dgJikoKisambi_Row> 時効起算日登録List = div.getDgJikoKisambi().getDataSource();
        List<dgJikoKisambi_Row> new時効起算日登録List = new ArrayList<>();
        Map<RString, RString> fukaNendoMap = new HashMap<>();
        Map<RString, RString> fuchoTokuchoMap = new HashMap<>();
        Map<RString, RString> tsuchishoNoMap = new HashMap<>();
        for (dgJikoKisambi_Row row : 時効起算日登録List) {
            if (div.getChkZengyoHyoji().isAllSelected()) {

                row.setFukaNendo(new FlexibleYear(row.getHdnFukaNendo()).wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
                row.setFuchoTokucho(TokuchoFuchoKubun.toValue(row.getHdnFuchoTokucho()).get名称());
                row.setTsuchishoNo(row.getHdnTsuchishoNo());

                new時効起算日登録List.add(row);
            } else {

                if (fukaNendoMap.containsKey(row.getHdnFukaNendo())) {
                    row.setFukaNendo(RString.EMPTY);
                } else {
                    fukaNendoMap.put(row.getHdnFukaNendo(), row.getHdnFukaNendo());
                }
                if (fuchoTokuchoMap.containsKey(row.getHdnFuchoTokucho())) {
                    row.setFuchoTokucho(RString.EMPTY);
                } else {
                    fuchoTokuchoMap.put(row.getHdnFuchoTokucho(), row.getHdnFuchoTokucho());
                }
                if (tsuchishoNoMap.containsKey(row.getHdnTsuchishoNo())) {
                    row.setTsuchishoNo(RString.EMPTY);
                } else {
                    tsuchishoNoMap.put(row.getHdnTsuchishoNo(), row.getHdnTsuchishoNo());
                }

                new時効起算日登録List.add(row);
            }
        }

        div.getDgJikoKisambi().setDataSource(new時効起算日登録List);
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
        div.getTxtTokushuJikoKisambi().clearValue();
        div.getDdlFukushaJikoKisambiJiyu().setSelectedKey(RString.EMPTY);
    }

    /**
     * 確定ボタンです。
     *
     * @param 時効起算日管理List List<JikoKisambiKanri>
     * @param 被保険者番号 HihokenshaNo
     * @return List<JikoKisambiKanri>
     */
    public List<JikoKisambiKanri> onClick_btnKakutei(List<JikoKisambiKanri> 時効起算日管理List, HihokenshaNo 被保険者番号) {

        RString 調定年度 = div.getDgShunoJokyo().getActiveRow().getSeirekiChoteiNendo();
        List<dgJikoKisambi_Row> 時効起算日登録List = div.getDgJikoKisambi().getDataSource();
        for (dgJikoKisambi_Row row : 時効起算日登録List) {
            for (int i = 0; i < 時効起算日管理List.size(); i++) {
                JikoKisambiKanri 時効起算日管理 = 時効起算日管理List.get(i);
                if (new RYear(調定年度).equals(時効起算日管理.get調定年度())
                        && 時効起算日管理.get賦課年度().equals(new RYear(row.getHdnFukaNendo()))
                        && 時効起算日管理.get特徴_普徴区分().equals(row.getHdnFuchoTokucho())
                        && 時効起算日管理.get通知書番号().getColumnValue().equals(row.getHdnTsuchishoNo())
                        && 時効起算日管理.get収納期_月().equals(row.getKi().substring(0, INT_2).trimStart(CHAR_0))) {

                    時効起算日管理List.remove(i);
                    JikoKisambiKanriBuilder builder = 時効起算日管理.createBuilderForEdit();
                    builder.set時効起算年月日(row.getTokushuJikoKisaibi().getValue());
                    builder.set時効起算日区分(row.getTokushuJikoKisaibiJiyu().getSelectedKey());
                    builder.set論理削除フラグ(false);
                    時効起算日管理 = builder.build();
                    if (時効起算日管理.isAdded()
                            && row.getTokushuJikoKisaibi().getValue().isEmpty()) {
                        時効起算日管理 = 時効起算日管理.unChanged();

                    }
                    if (!時効起算日管理.isUnchanged()
                            && row.getTokushuJikoKisaibi().getValue().isEmpty()) {
                        時効起算日管理 = 時効起算日管理.deleted();
                    }
                    if (i == 時効起算日登録List.size() - 1) {
                        時効起算日管理List.add(時効起算日管理);
                    } else {
                        時効起算日管理List.add(i, 時効起算日管理);
                    }
                    if (!時効起算日管理.isUnchanged()) {
                        div.getDgShunoJokyo().getActiveRow().setJotai(修正);
                    }
                    break;
                }
            }
        }

        return 時効起算日管理List;
    }

    /**
     * 保存するボタンです。
     *
     * @param 時効起算日管理List List<JikoKisambiKanri>
     */
    public void onClick_btnSave(List<JikoKisambiKanri> 時効起算日管理List) {

        for (JikoKisambiKanri jikoKisambiKanri : 時効起算日管理List) {
            JikoKisambiKanriManager manager = new JikoKisambiKanriManager();
            if (jikoKisambiKanri.isDeleted()) {
                manager.save時効起算日管理ForDeletePhysical(jikoKisambiKanri);
                continue;
            }
            if (jikoKisambiKanri.isUnchanged()) {
                continue;
            }
            manager.save時効起算日管理(jikoKisambiKanri);
        }
    }

    private List<KeyValueDataSource> get時効起算日区分List() {

        List<KeyValueDataSource> 時効起算日区分List = new ArrayList<>();
        時効起算日区分List.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (JikoKisanbiKubun 時効起算日区分 : JikoKisanbiKubun.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(時効起算日区分.getコード());
            keyValue.setValue(時効起算日区分.get名称());
            時効起算日区分List.add(keyValue);
        }
        return 時効起算日区分List;
    }

    private RString null判定(RString 判断用の値) {

        return 判断用の値 == null ? RString.EMPTY : 判断用の値;
    }

    private List<JikoKisambiKanri> setFor時効起算日管理が存在しない(
            HihokenshaNo 被保険者番号,
            RYear 調定年度,
            dgJikoKisambi_Row row,
            List<JikoKisambiKanri> 時効起算日管理リスト) {

        List<JikoKisambiKanri> 保存用時効起算日管理リスト = new ArrayList<>();
        boolean 存在フラグ = false;

        for (int i = 0; i < 時効起算日管理リスト.size(); i++) {
            JikoKisambiKanri 時効起算日管理 = 時効起算日管理リスト.get(i);
            if (new RString(時効起算日管理.get賦課年度().getYearValue()).equals(row.getHdnFukaNendo())
                    && 時効起算日管理.get特徴_普徴区分().equals(row.getHdnFuchoTokucho())
                    && 時効起算日管理.get通知書番号().value().equals(row.getHdnTsuchishoNo())
                    && 時効起算日管理.get収納期_月().equals(row.getKi().substring(0, INT_2).trimStart(CHAR_0))) {
                row.getTokushuJikoKisaibi().setValue(時効起算日管理.get時効起算年月日());
                row.getTokushuJikoKisaibiJiyu().setSelectedKey(時効起算日管理.get時効起算日区分());

                時効起算日管理 = 時効起算日管理.unChanged();
                時効起算日管理 = 時効起算日管理.modifiedModel();

                保存用時効起算日管理リスト.add(時効起算日管理);
                存在フラグ = true;
                break;
            }
        }

        if (!存在フラグ) {
            JikoKisambiKanri newJikoKisambiKanri = new JikoKisambiKanri(
                    new ShoKisaiHokenshaNo(div.getHdnShoKisaiHokenshaNo()),
                    被保険者番号,
                    調定年度,
                    new RYear(row.getHdnFukaNendo()),
                    row.getHdnFuchoTokucho(),
                    new TsuchishoNo(row.getHdnTsuchishoNo()),
                    row.getKi().substring(0, INT_2).trimStart(CHAR_0),
                    0);

            JikoKisambiKanriBuilder builder = newJikoKisambiKanri.createBuilderForEdit();
            builder.set時効起算年月日(FlexibleDate.EMPTY);
            builder.set時効起算日区分(RString.EMPTY);
            builder.set論理削除フラグ(false);
            newJikoKisambiKanri = builder.build().added();

            保存用時効起算日管理リスト.add(newJikoKisambiKanri);
        }

        return 保存用時効起算日管理リスト;
    }

    private List<JikoKisambiKanri> get時効起算日管理リスト(
            HihokenshaNo 被保険者番号,
            RYear 調定年度) {
        JukoKisambiTokushuTorokuManager manager = JukoKisambiTokushuTorokuManager.createInstance();
        List<JikoKisambiKanri> 時効起算日管理リスト = manager.get時効起算日管理(被保険者番号, 調定年度);

        return 時効起算日管理リスト;
    }
}
