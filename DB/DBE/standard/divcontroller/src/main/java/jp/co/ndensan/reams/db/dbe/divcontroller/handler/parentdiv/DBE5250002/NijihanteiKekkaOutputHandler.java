/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE491001.DBE491001_NichijiShinchokuParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525002.DBE525002_HanteiKekkaHokenshaParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.NijihanteiKekkaOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 判定結果情報出力(保険者)の取得するクラスです。
 *
 * @reamsid_L DBE-0190-010 lizhuoxuan
 */
public class NijihanteiKekkaOutputHandler {

    private final NijihanteiKekkaOutputDiv nijidiv;
    private final RString 判定結果ボタン = new RString("btnRenkeiDataOutput");
    private final RString 連携ボタン = new RString("btnHanteikekkaOutput");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString 未出力のみ = new RString("未出力のみ");
    private static final RString 出力済みを含む = new RString("出力済みを含む");
    private static final RString 二次判定日 = new RString("二次判定日");
    private static final RString 認定申請日 = new RString("認定申請日");

    /**
     * コンストラクタです。
     *
     * @param nijidiv 判定結果情報出力(保険者)
     */
    public NijihanteiKekkaOutputHandler(NijihanteiKekkaOutputDiv nijidiv) {
        this.nijidiv = nijidiv;
    }

    /**
     * 判定結果情報出力(保険者)初期処理する。
     */
    public void initialize() {
        nijidiv.getKensakuJoken().getCcdHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(判定結果ボタン, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(連携ボタン, true);
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        nijidiv.getKensakuJoken().getTxtHyojiDataLimit().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        nijidiv.getKensakuJoken().getTxtHyojiDataLimit().setValue(new Decimal(検索制御_最大取得件数.toString()));
        List<dgTaishoshaIchiran_Row> dgKoufuKaishuList = new ArrayList<>();
        nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setDataSource(dgKoufuKaishuList);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 判定結果情報出力(保険者)検索処理する。
     *
     * @param 被保険者番号
     * @return 検索結果が存在する場合、{@code true}.
     */
    public boolean kennsaku(RString 被保険者番号) {
        List<dgTaishoshaIchiran_Row> dgTaishoshaIchiranList = new ArrayList<>();
        HanteiKekkaJouhouShuturyokuParameter hanteiParameter = createParameter(被保険者番号);
        SearchResult<HanteiKekkaJouhouShuturyokuBusiness> 判定結果情報検索結果 = HanteiKekkaJouhouShuturyokuFinder.createInstance()
                .getHanteiKekka(hanteiParameter);
        List<HanteiKekkaJouhouShuturyokuBusiness> ninteiList = 判定結果情報検索結果.records();
        if (ninteiList != null && !ninteiList.isEmpty()) {
            for (HanteiKekkaJouhouShuturyokuBusiness jigyoshaInput : ninteiList) {
                dgTaishoshaIchiran_Row dgFukushiyoguShohin = new dgTaishoshaIchiran_Row();
                dgFukushiyoguShohin.getHihokenshaNo().setValue(nullToEmpty(jigyoshaInput.get被保険者番号()));
                dgFukushiyoguShohin.setHihokenshaShimei(nullToEmpty(jigyoshaInput.get被保険者氏名()));
                dgFukushiyoguShohin.setHihokenshaKanaShimei(nullToEmpty(jigyoshaInput.get被保険者カナ氏名()));
                dgFukushiyoguShohin.setSeibetsu(Seibetsu.toValue(jigyoshaInput.get性別()).get名称());
                if (jigyoshaInput.get生年月日() != null) {
                    dgFukushiyoguShohin.getBirthYMD().setValue(new FlexibleDate(jigyoshaInput.get生年月日().toString()));
                }
                dgFukushiyoguShohin.getNinteiShinseiDay().
                        setValue(jigyoshaInput.get認定申請年月日() == null ? FlexibleDate.EMPTY
                                        : new FlexibleDate(jigyoshaInput.get認定申請年月日().toString()));
                dgFukushiyoguShohin.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.
                        toValue(jigyoshaInput.get認定申請区分_申請時コード()).get名称());
                if (jigyoshaInput.get二次判定要介護状態区分コード() != null) {
                    dgFukushiyoguShohin.setNijiHanteiKekka(YokaigoJotaiKubun09.toValue(jigyoshaInput.get二次判定要介護状態区分コード()).get名称());
                }
                RStringBuilder 審査会名称 = new RStringBuilder();
                審査会名称.append(new RString("第"));
                審査会名称.append(jigyoshaInput.get開催番号() == null ? RString.EMPTY : jigyoshaInput.get開催番号());
                審査会名称.append(new RString("回審査会"));
                dgFukushiyoguShohin.setKaigoNinteiShinsakaiName(審査会名称.toRString());
                dgFukushiyoguShohin.setShinseishoKanriNo(jigyoshaInput.get申請書管理番号());
                dgTaishoshaIchiranList.add(dgFukushiyoguShohin);
            }
            DataGridSetting gridSetting = nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getGridSetting();
            gridSetting.setLimitRowCount(hanteiParameter.getLimitCount());
            gridSetting.setSelectedRowCount(判定結果情報検索結果.totalCount());
            nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setGridSetting(gridSetting);
            nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setDataSource(dgTaishoshaIchiranList);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(判定結果ボタン, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(連携ボタン, false);
            return true;
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(判定結果ボタン, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(連携ボタン, true);
            return false;
        }
    }

    /**
     * 検索条件を作成します。
     *
     * @return 検索条件
     */
    private HanteiKekkaJouhouShuturyokuParameter createParameter(RString 被保険者番号) {
        HanteiKekkaJouhouShuturyokuParameter parameter = new HanteiKekkaJouhouShuturyokuParameter();
        int 最大表示件数 = Integer.parseInt(nijidiv.getKensakuJoken().getTxtHyojiDataLimit().getValue().toString());
        if (最大表示件数 != 0) {
            parameter.setUseLimitCount(true);
            parameter.setLimitCount(最大表示件数);
        }
        editShosaiJokenForParameter(parameter, 被保険者番号);
        return parameter;
    }

    private void editShosaiJokenForParameter(HanteiKekkaJouhouShuturyokuParameter parameter, RString 被保険者番号) {
        RString fromtime = RString.EMPTY;
        if (nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getFromValue() != null) {
            fromtime = new RString(nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getFromValue().toString());
        }
        RString totime = RString.EMPTY;
        if (nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getToValue() != null) {
            totime = new RString(nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getToValue().toString());
        }
        if (KEY0.equals(nijidiv.getKensakuJoken().getRadTeishutsuKigen().getSelectedKey())) {
            FlexibleDate 二次判定日FROM = new FlexibleDate(fromtime);
            if (!FlexibleDate.EMPTY.equals(二次判定日FROM)) {
                parameter.setNijiHanteiYMDFrom(二次判定日FROM);
                parameter.setUseNijiHanteiYMDFrom(true);
            }
            FlexibleDate 二次判定日To = new FlexibleDate(totime);
            if (!FlexibleDate.EMPTY.equals(二次判定日To)) {
                parameter.setNijiHanteiYMDTo(二次判定日To);
                parameter.setUseNijiHanteiYMDTo(true);
            }
        } else if (KEY1.equals(nijidiv.getKensakuJoken().getRadTeishutsuKigen().getSelectedKey())) {
            FlexibleDate 認定申請日FROM = nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getFromValue().toFlexibleDate();
            if (認定申請日FROM != null) {
                parameter.setNinteiShinseiYMDFrom(認定申請日FROM);
                parameter.setUseNinteiShinseiYMDFrom(true);
            }

            FlexibleDate 認定申請日To = nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getToValue().toFlexibleDate();
            if (認定申請日To != null) {
                parameter.setNinteiShinseiYMDTo(認定申請日To);
                parameter.setUseNinteiShinseiYMDTo(true);
            }
        }

        RString データ出力有無 = nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey();
        if (KEY0.equals(データ出力有無)) {
            parameter.setUseMisyutsuryokuNomi(true);
        }
        if (!RString.isNullOrEmpty(被保険者番号)) {
            parameter.setHihokenshaNo(被保険者番号);
            parameter.setUseHihokenshaNo(true);
        }
        RString 証記載保険者番号 = nijidiv.getKensakuJoken().getCcdHokensha().getSelectedItem().get証記載保険者番号().getColumnValue();
        if (!RString.isNullOrEmpty(証記載保険者番号)) {
            parameter.setShoKisaiHokenshaNo(証記載保険者番号);
            parameter.setUseShoKisaiHokenshaNo(true);
        }
    }

    /**
     * 判定結果情報出力(保険者)作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return DBE525002_HanteiKekkaHokenshaParameter
     */
    public DBE525002_HanteiKekkaHokenshaParameter setBatchParameter() {
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinseishoKanriNo.add(row.getShinseishoKanriNo());
            }
        }
        DBE525002_HanteiKekkaHokenshaParameter hanteibatchParameter
                = new DBE525002_HanteiKekkaHokenshaParameter();
        hanteibatchParameter.setShinseishoKanriNoList(shinseishoKanriNo);
        hanteibatchParameter.setFayirukuben(new RString("1"));
        hanteibatchParameter.setHokensha(nijidiv.getKensakuJoken().getCcdHokensha().getSelectedItem().get証記載保険者番号().getColumnValue());
        hanteibatchParameter.setHokenshaName(nijidiv.getKensakuJoken().getCcdHokensha().getSelectedItem().get市町村名称());
        if (KEY0.equals(nijidiv.getKensakuJoken().getRadTeishutsuKigen().getSelectedKey())) {
            hanteibatchParameter.setChushutsuHoho(二次判定日);
        } else if (KEY1.equals(nijidiv.getKensakuJoken().getRadTeishutsuKigen().getSelectedKey())) {
            hanteibatchParameter.setChushutsuHoho(認定申請日);
        }
        hanteibatchParameter.setChushutsuFromDate(nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getFromValue().toDateString());
        hanteibatchParameter.setChushutsuToDate(nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getToValue().toDateString());
        hanteibatchParameter.setHihokenshaNo(nijidiv.getKensakuJoken().getTxtHihokenshaNo().getValue());
        if (KEY0.equals(nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey())) {
            hanteibatchParameter.setDataShutsuryokuUmu(未出力のみ);
        } else if (KEY1.equals(nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey())) {
            hanteibatchParameter.setDataShutsuryokuUmu(出力済みを含む);
        }
        return hanteibatchParameter;
    }

    /**
     * 判定結果情報出力(保険者)作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return DBE491001_NichijiShinchokuParameter
     */
    public DBE491001_NichijiShinchokuParameter setCSVBatchParameter() {
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinseishoKanriNo.add(row.getShinseishoKanriNo());
            }
        }
        DBE491001_NichijiShinchokuParameter shinchokuParameter
                = new DBE491001_NichijiShinchokuParameter();
        shinchokuParameter.setShinseishoKanriNoList(shinseishoKanriNo);
        shinchokuParameter.setFayirukuben(new RString("1"));
        shinchokuParameter.setHokensha(nijidiv.getKensakuJoken().getCcdHokensha().getSelectedItem().get証記載保険者番号().getColumnValue());
        shinchokuParameter.setHokenshaName(nijidiv.getKensakuJoken().getCcdHokensha().getSelectedItem().get市町村名称());
        if (KEY0.equals(nijidiv.getKensakuJoken().getRadTeishutsuKigen().getSelectedKey())) {
            shinchokuParameter.setChushutsuHoho(二次判定日);
        } else if (KEY1.equals(nijidiv.getKensakuJoken().getRadTeishutsuKigen().getSelectedKey())) {
            shinchokuParameter.setChushutsuHoho(認定申請日);
        }
        shinchokuParameter.setChushutsuFromDate(nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getFromValue().toDateString());
        shinchokuParameter.setChushutsuToDate(nijidiv.getKensakuJoken().getTxtTeishutsuKigenDateRange().getToValue().toDateString());
        shinchokuParameter.setHihokenshaNo(nijidiv.getKensakuJoken().getTxtHihokenshaNo().getValue());
        if (KEY0.equals(nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey())) {
            shinchokuParameter.setDataShutsuryokuUmu(未出力のみ);
        } else if (KEY1.equals(nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey())) {
            shinchokuParameter.setDataShutsuryokuUmu(出力済みを含む);
        }
        return shinchokuParameter;
    }
}
