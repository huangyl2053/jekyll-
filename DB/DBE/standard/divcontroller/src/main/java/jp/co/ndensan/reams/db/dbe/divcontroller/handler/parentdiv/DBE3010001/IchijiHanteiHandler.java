/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijipanteisyori.IChiJiPanTeiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.itizihanteishori.ItziHanteiShoriBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.IchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
public class IchijiHanteiHandler {

    private final IchijiHanteiDiv div;
    private static final int DIVIDE_VALUE = 10;

    /**
     * 一次判定処理関連のメニューIDをまとめて定義します。
     */
    public enum IchijiHanteiMenuId {

        /**
         * 一次判定処理
         */
        一次判定処理("DBEMN51001"),
        /**
         * 一次判定インターフェース作成
         */
        一次判定インターフェース作成("DBEMN51003"),
        /**
         * 一次判定インターフェース取込
         */
        一次判定インターフェース取込("DBEMN51004"),
        /**
         * 完了処理_一次判定
         */
        完了処理_一次判定("DBEMN11006");

        private final RString menuId;

        private IchijiHanteiMenuId(String menuId) {
            this.menuId = new RString(menuId);
        }

        /**
         * メニューIDを示す文字列を返します。
         *
         * @return メニューID
         */
        public RString value() {
            return menuId;
        }

        /**
         * メニューIDを表す文字列を受け取り、合致する列挙値を返します。
         *
         * @param menuId メニューID
         * @return メニューIDを示す列挙値
         */
        public static IchijiHanteiMenuId toValue(RString menuId) {
            for (IchijiHanteiMenuId id : values()) {
                if (id.value().equals(menuId)) {
                    return id;
                }
            }
            throw new IllegalArgumentException("処理対象のMenuIdではありません。");
        }
    }

    /**
     * コンストラクタです。
     *
     * @param div IchijiHanteiDiv
     */
    public IchijiHanteiHandler(IchijiHanteiDiv div) {
        this.div = div;
    }

    /**
     * 認定調査データ取込の設定します。
     *
     */
    public void initializtion() {
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 最大上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getIchijiHanteiKensakuJoken().getTxtMaxCount().setValue(new Decimal(最大表示件数.toString()));
        div.getIchijiHanteiKensakuJoken().getTxtMaxCount().setMaxValue(new Decimal(最大上限.toString()));
    }

    /**
     * 特定のメニューから遷移した場合のみ、タイトルを設定し直します。
     *
     * @param menuId メニューID
     * @return タイトル名称
     */
    public RString getTitle(IchijiHanteiMenuId menuId) {
        switch (menuId) {
            case 一次判定処理:
            case 一次判定インターフェース作成:
            case 一次判定インターフェース取込:
                return new RString(menuId.name());
            default:
                break;
        }
        return ResponseData.of(div).respond().getRootTitle();
    }

    /**
     * 条件をクリアする。
     *
     */
    public void clear() {
        div.getIchijiHanteiKensakuJoken().getTxtShinseiDateRange().clearFromValue();
        div.getIchijiHanteiKensakuJoken().getTxtShinseiDateRange().clearToValue();
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 最大上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getIchijiHanteiKensakuJoken().getTxtMaxCount().setValue(new Decimal(最大表示件数.toString()));
        div.getIchijiHanteiKensakuJoken().getTxtMaxCount().setMaxValue(new Decimal(最大上限.toString()));
        div.getIchijiHanteiKensakuJoken().getTxtHihokenshaNo().clearValue();
        div.getIchijiHanteiKensakuJoken().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
    }

    /**
     * バッチパラメータの作成。
     *
     * @param バッチ出力区分 RString
     * @return ItziHanteiShoriBatchParamter
     */
    public ItziHanteiShoriBatchParamter バッチパラメータの作成(RString バッチ出力区分) {

        ItziHanteiShoriBatchParamter parameter = new ItziHanteiShoriBatchParamter();
        List<dgIchijiHanteiTaishoshaIchiran_Row> rowList = div.getIchijiHanteiShoriTaishoshaIchiran().
                getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();

        List<RString> shinseishoKanriNoList = new ArrayList<>();
        List<RString> hihoNoList = new ArrayList<>();
        List<RString> shinseibiList = new ArrayList<>();
        List<RString> shokisaiHokenshaList = new ArrayList<>();

        for (dgIchijiHanteiTaishoshaIchiran_Row row : rowList) {
            shinseishoKanriNoList.add(row.getShinseishoKanriNo());
            hihoNoList.add(row.getHihokenNo());
            shinseibiList.add(row.getShinseibi().getValue().wareki().toDateString());
            shokisaiHokenshaList.add(row.getHokensha());
        }

        parameter.setShinseishoKanriNoList(shinseishoKanriNoList);
        parameter.setHihokenshaNoList(hihoNoList);
        parameter.setShokisaiHokenshaMeiList(shokisaiHokenshaList);
        parameter.setShinseibiList(shinseibiList);
        parameter.setBattishuturyokukubun(バッチ出力区分);
        if (new RString("2").equals(バッチ出力区分)) {

            if (RString.isNullOrEmpty(div.getファイルID())) {
                throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace("取込対象のファイルを"));
            }
            parameter.setFileId(RDateTime.parse(div.getファイルID().toString()));
        }
        return parameter;
    }

    /**
     * 要介護認定一次判定結果情報の編集。
     *
     * @param row 対象者一覧
     * @param entity 要介護認定一次判定結果情報
     * @param flg 登録、更新判定フラグ
     * @return 要介護認定一次判定結果情報ビルダー
     */
    public IchijiHanteiKekkaJohoBuilder 要介護認定一次判定結果情報の編集(dgIchijiHanteiTaishoshaIchiran_Row row,
            IchijiHanteiKekkaJoho entity, RString flg) {

        IchijiHanteiKekkaJohoBuilder builder = entity.createBuilderForEdit();
        if (flg.isEmpty()) {
            builder.set仮一次判定区分(true);
        }
        builder.set要介護認定一次判定年月日(row.getIchijiHanteibi().getValue());
        builder.set要介護認定一次判定結果コード(new Code(row.getIchijiHanteiKekka()));
        builder.set要介護認定一次判定結果コード_認知症加算(new Code(row.getIchijiHanteiKekkaNinchishoKasanCode()));
        builder.set要介護認定等基準時間(Integer.valueOf(row.getKijunJikan().toString()));
        builder.set要介護認定等基準時間_食事(Integer.valueOf(row.getKijunJikanShokuji().toString()));
        builder.set要介護認定等基準時間_排泄(Integer.valueOf(row.getKijunJikanHaisetsu().toString()));
        builder.set要介護認定等基準時間_移動(Integer.valueOf(row.getKijunJikanIdo().toString()));
        builder.set要介護認定等基準時間_清潔保持(Integer.valueOf(row.getKijunJikanSeiketsuHoji().toString()));
        builder.set要介護認定等基準時間_間接ケア(Integer.valueOf(row.getKijunJikanKansetsuCare().toString()));
        builder.set要介護認定等基準時間_BPSD関連(Integer.valueOf(row.getKijunJikanBPSDKanren().toString()));
        builder.set要介護認定等基準時間_機能訓練(Integer.valueOf(row.getKijunJikanKinoKunren().toString()));
        builder.set要介護認定等基準時間_医療関連(Integer.valueOf(row.getKijunJikanIryoKanren().toString()));
        builder.set要介護認定等基準時間_認知症加算(Integer.valueOf(row.getKijunJikanNinchishoKasan().toString()));
        builder.set中間評価項目得点第1群(Integer.valueOf(row.getChukanHyokaKomoku1gun().toString()));
        builder.set中間評価項目得点第2群(Integer.valueOf(row.getChukanHyokaKomoku2gun().toString()));
        builder.set中間評価項目得点第3群(Integer.valueOf(row.getChukanHyokaKomoku3gun().toString()));
        builder.set中間評価項目得点第4群(Integer.valueOf(row.getChukanHyokaKomoku4gun().toString()));
        builder.set中間評価項目得点第5群(Integer.valueOf(row.getChukanHyokaKomoku5gun().toString()));

        if (!RString.isNullOrEmpty(row.getHiddenKeikokuCode())) {
            builder.set要介護認定一次判定警告コード(row.getHiddenKeikokuCode());
        }
        if (!RString.isNullOrEmpty(row.getJotaiAnteiseiCode())) {
            builder.set要介護認定状態の安定性コード(new Code(JotaiAnteiseiCode.
                    valueOf(row.getJotaiAnteiseiCode().toString()).getコード()));
        }
        if (row.getHiddenNinchishoJiritsudoIIijoNoGaizensei().getValue() != null) {
            builder.set認知症自立度Ⅱ以上の蓋然性(new Decimal(row.getHiddenNinchishoJiritsudoIIijoNoGaizensei().toString()));
        }
        if (!RString.isNullOrEmpty(row.getSuiteiKyufuKubunCode())) {
            builder.set認知機能及び状態安定性から推定される給付区分コード(new Code(SuiteiKyufuKubunCode.
                    valueOf(row.getSuiteiKyufuKubunCode().toString()).getコード()));
        }

        return builder;
    }

    /**
     * 対象者一覧の編集。
     *
     * @param 一次判定対象者一覧List List<IChiJiPanTeiSyoRiBusiness>
     */
    public void 対象者一覧の編集(List<IChiJiPanTeiSyoRiBusiness> 一次判定対象者一覧List) {

        List<dgIchijiHanteiTaishoshaIchiran_Row> rowList = new ArrayList<>();
        for (IChiJiPanTeiSyoRiBusiness business : 一次判定対象者一覧List) {

            dgIchijiHanteiTaishoshaIchiran_Row row = new dgIchijiHanteiTaishoshaIchiran_Row();
            row.setColumnState(RString.EMPTY);
            row.setHokensha(business.get市町村名称());
            row.setHihokenNo(business.get被保険者番号());
            row.setHihokenshaName(business.get被保険者氏名().value());
            row.getShinseibi().setValue(business.get認定申請年月日());
            row.setShinseiKbnShin(NinteiShinseiShinseijiKubunCode.
                    toValue(business.get認定申請区分_申請時コード().value()).get名称());
            row.getIchijiHanteibi().setValue(business.get要介護認定一次判定年月日());

            if (business.get要介護認定一次判定結果コード() != null) {
                row.setIchijiHanteiKekkaCode(business.get要介護認定一次判定結果コード().getColumnValue());
                row.setIchijiHanteiKekka(get一次判定結果名称(new Code(business.
                        get厚労省IF識別コード()), business.get要介護認定一次判定結果コード()));
            }
            if (business.get要介護認定一次判定結果コード_認知症加算() != null) {
                row.setIchijiHanteiKekkaNinchishoKasanCode(business.get要介護認定一次判定結果コード_認知症加算().getColumnValue());
                row.setIchijiHanteiKekkaNinchishoKasan(get一次判定結果名称(new Code(business.
                        get厚労省IF識別コード()), business.get要介護認定一次判定結果コード_認知症加算()));
            }

            if (business.get要介護認定一次判定警告コード() != null) {
                if (is警告コードAllZERO(business.get要介護認定一次判定警告コード())) {
                    row.setKeikokuCode(RString.EMPTY);
                } else {
                    row.setKeikokuCode(business.get要介護認定一次判定警告コード());
                }
                row.setHiddenKeikokuCode(business.get要介護認定一次判定警告コード());
            }

            row.getChosaJissibi().setValue(business.get認定調査実施年月日());
            row.getIkenshoJuryobi().setValue(business.get主治医意見書受領年月日());
            row.getKijunJikan().setValue(divideValue(business.get要介護認定等基準時間()));
            row.getKijunJikanShokuji().setValue(divideValue(business.get要介護認定等基準時間_食事()));
            row.getKijunJikanHaisetsu().setValue(divideValue(business.get要介護認定等基準時間_排泄()));
            row.getKijunJikanIdo().setValue(divideValue(business.get要介護認定等基準時間_移動()));
            row.getKijunJikanSeiketsuHoji().setValue(divideValue(business.get要介護認定等基準時間_清潔保持()));
            row.getKijunJikanKansetsuCare().setValue(divideValue(business.get要介護認定等基準時間_間接ケア()));
            row.getKijunJikanBPSDKanren().setValue(divideValue(business.get要介護認定等基準時間_BPSD関連()));
            row.getKijunJikanKinoKunren().setValue(divideValue(business.get要介護認定等基準時間_機能訓練()));
            row.getKijunJikanIryoKanren().setValue(divideValue(business.get要介護認定等基準時間_医療関連()));
            row.getKijunJikanNinchishoKasan().setValue(divideValue(business.get要介護認定等基準時間_認知症加算()));
            row.getChukanHyokaKomoku1gun().setValue(divideValue(business.get中間評価項目得点第1群()));
            row.getChukanHyokaKomoku2gun().setValue(divideValue(business.get中間評価項目得点第2群()));
            row.getChukanHyokaKomoku3gun().setValue(divideValue(business.get中間評価項目得点第3群()));
            row.getChukanHyokaKomoku4gun().setValue(divideValue(business.get中間評価項目得点第4群()));
            row.getChukanHyokaKomoku5gun().setValue(divideValue(business.get中間評価項目得点第5群()));

            if (!RString.isNullOrEmpty(row.getIchijiHanteiKekkaCode())) {
                set認知症自立度(business.get申請書管理番号(), row);
            }

            if (business.get要介護認定状態の安定性コード() != null && !business.get要介護認定状態の安定性コード().isEmpty()) {
                row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称());
            }

            if (business.get認知症自立度Ⅱ以上の蓋然性() != null) {
                row.getNinchishoJiritsudoIIijoNoGaizensei().setValue(business.get認知症自立度Ⅱ以上の蓋然性());
                if (business.get認知症自立度Ⅱ以上の蓋然性().compareTo(Decimal.ZERO) < 0) {
                    row.getNinchishoJiritsudoIIijoNoGaizensei().setValue(null);
                }
                row.getHiddenNinchishoJiritsudoIIijoNoGaizensei().setValue(business.get認知症自立度Ⅱ以上の蓋然性());
            }

            if (business.get推定される給付区分コード() != null && !business.get推定される給付区分コード().isEmpty()) {
                row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(business.get推定される給付区分コード().value()).get名称());
            }
            row.setShinseishoKanriNo(business.get申請書管理番号().value());
            row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード());
            row.setShoKisaiHokenshaNo(business.get証記載保険者番号().getColumnValue());

            rowList.add(row);
        }
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().setDataSource(rowList);
        setDisplayNoneOfIchijiHanteiDialigButton(div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran());
    }

    private void set認知症自立度(ShinseishoKanriNo shinseishoKanriNo, dgIchijiHanteiTaishoshaIchiran_Row row) {
        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
        List<RString> jiritsudoCode = manager.get認知症高齢者自立度コード(shinseishoKanriNo);
        if (!jiritsudoCode.isEmpty()) {
            if (jiritsudoCode.get(0).isEmpty()) {
                row.setNinteiChosaTorikomiUmu(RString.EMPTY);
                row.setNinteiChosaNinchishodo(RString.EMPTY);
            } else {
                row.setNinteiChosaTorikomiUmu(new RString("済"));
                row.setNinteiChosaNinchishodo(NinchishoNichijoSeikatsuJiritsudoCode.toValue(jiritsudoCode.get(0)).get名称());
            }
            if (jiritsudoCode.get(1).isEmpty()) {
                row.setIkenshoTorikomiUmu(RString.EMPTY);
                row.setIkenshoNinchishodo(RString.EMPTY);
            } else {
                row.setIkenshoTorikomiUmu(new RString("済"));
                row.setIkenshoNinchishodo(NinchishoNichijoSeikatsuJiritsudoCode.toValue(jiritsudoCode.get(1)).get名称());
            }
        }
    }

    private Decimal divideValue(int value) {
        return new Decimal(value).divide(DIVIDE_VALUE);
    }

    /**
     * グリッドのフッターに、最大表示件数と検索件数を表示します。
     *
     * @param menuID メニューID
     * @param shinseishoKanriNoList 申請書管理番号List
     */
    public void setLimitValueOfGrid(RString menuID, ShinseishoKanriNoList shinseishoKanriNoList) {

        IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();

        IChiJiPanTeiSyoRiParameter parameter = createParameter(menuID, shinseishoKanriNoList);
        Decimal 検索件数 = div.getIchijiHanteiKensakuJoken().getTxtMaxCount().getValue();
        Decimal dataNum = new Decimal(manager.get対象者件数(IChiJiPanTeiSyoRiParameter.createParameterOf一次判定対象件数(parameter)));

        if (検索件数.compareTo(dataNum) < 0) {
            div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getGridSetting().setLimitRowCount(検索件数.intValue());
            div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getGridSetting().setSelectedRowCount(dataNum.intValue());
        } else {
            div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getGridSetting().setLimitRowCount(0);
            div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getGridSetting().setSelectedRowCount(0);
        }
    }

    private void setDisplayNoneOfIchijiHanteiDialigButton(DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dg) {
        RString menuIdStr = ResponseHolder.getMenuID();
        IchijiHanteiMenuId menuId = IchijiHanteiMenuId.toValue(menuIdStr);
        switch (menuId) {
            case 一次判定処理:
                dg.getGridSetting().getColumn("columnState").setVisible(true);
                break;
            default:
                dg.getGridSetting().getColumn("columnState").setVisible(false);
                break;
        }
    }

    /**
     * 対象者の編集処理を行う前に、内容に変化があるかどうかをチェックします。
     *
     * @param row 対象者一覧のデータ
     * @param business 要介護認定一次判定結果情報
     * @return 値を比較して、1項目でも差がある場合はtrueを返す。それ以外の場合はfalseを返す。
     */
    public boolean notEqualsRowData(dgIchijiHanteiTaishoshaIchiran_Row row, IchijiHanteiKekkaJoho business) {

        if (business == null) {
            return false;
        }

        if (business.get要介護認定一次判定年月日() != null
                && !row.getIchijiHanteibi().getValue().equals(business.get要介護認定一次判定年月日())) {
            return true;
        }

        if (notEqualsRowData一次判定結果コード(row, business)) {
            return true;
        }

        if (business.get要介護認定一次判定結果コード_認知症加算() != null
                && !row.getIchijiHanteiKekkaNinchishoKasanCode().equals(business.get要介護認定一次判定結果コード_認知症加算().getColumnValue())) {
            return true;
        }
        if (business.get要介護認定一次判定警告コード() != null
                && !row.getHiddenKeikokuCode().equals(business.get要介護認定一次判定警告コード())) {
            return true;
        }

        if (notEqualsRowData基準時間(row, business)) {
            return true;
        }
        if (notEqualsRowData中間評価項目(row, business)) {
            return true;
        }

        if (business.get要介護認定状態の安定性コード() != null && !business.get要介護認定状態の安定性コード().isEmpty()
                && !row.getJotaiAnteiseiCode().equals(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称())) {
            return true;
        }
        if (business.get認知症自立度Ⅱ以上の蓋然性() != null
                && !row.getHiddenNinchishoJiritsudoIIijoNoGaizensei().getValue().equals(business.get認知症自立度Ⅱ以上の蓋然性())) {
            return true;
        }
        if (business.get認知機能及び状態安定性から推定される給付区分コード() != null
                && !business.get認知機能及び状態安定性から推定される給付区分コード().isEmpty()) {
            return !row.getSuiteiKyufuKubunCode().equals(SuiteiKyufuKubunCode
                    .toValue(business.get認知機能及び状態安定性から推定される給付区分コード().value()).get名称());
        }

        return false;
    }

    private boolean notEqualsRowData一次判定結果コード(dgIchijiHanteiTaishoshaIchiran_Row row, IchijiHanteiKekkaJoho business) {

        if (business.get要介護認定一次判定結果コード() != null) {
            if (!row.getIchijiHanteiKekkaCode().equals(business.get要介護認定一次判定結果コード().getColumnValue())) {
                return true;
            }
            if (!row.getIchijiHanteiKekka().equals(IchijiHanteiKekkaCode09.toValue(business.
                    get要介護認定一次判定結果コード().value()).get名称())) {
                return true;
            }
        }
        return false;
    }

    private boolean notEqualsRowData基準時間(dgIchijiHanteiTaishoshaIchiran_Row row, IchijiHanteiKekkaJoho business) {

        if (!row.getKijunJikan().getValue().equals(divideValue(business.get要介護認定等基準時間()))) {
            return true;
        }
        if (!row.getKijunJikanShokuji().getValue().equals(divideValue(business.get要介護認定等基準時間_食事()))) {
            return true;
        }
        if (!row.getKijunJikanHaisetsu().getValue().equals(divideValue(business.get要介護認定等基準時間_排泄()))) {
            return true;
        }
        if (!row.getKijunJikanIdo().getValue().equals(divideValue(business.get要介護認定等基準時間_移動()))) {
            return true;
        }
        if (!row.getKijunJikanSeiketsuHoji().getValue().equals(divideValue(business.get要介護認定等基準時間_清潔保持()))) {
            return true;
        }
        if (!row.getKijunJikanKansetsuCare().getValue().equals(divideValue(business.get要介護認定等基準時間_間接ケア()))) {
            return true;
        }
        if (!row.getKijunJikanBPSDKanren().getValue().equals(divideValue(business.get要介護認定等基準時間_BPSD関連()))) {
            return true;
        }
        if (!row.getKijunJikanKinoKunren().getValue().equals(divideValue(business.get要介護認定等基準時間_機能訓練()))) {
            return true;
        }
        if (!row.getKijunJikanIryoKanren().getValue().equals(divideValue(business.get要介護認定等基準時間_医療関連()))) {
            return true;
        }
        return !row.getKijunJikanNinchishoKasan().getValue().equals(divideValue(business.get要介護認定等基準時間_認知症加算()));
    }

    private boolean notEqualsRowData中間評価項目(dgIchijiHanteiTaishoshaIchiran_Row row, IchijiHanteiKekkaJoho business) {

        if (!row.getChukanHyokaKomoku1gun().getValue().equals(divideValue(business.get中間評価項目得点第1群()))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku2gun().getValue().equals(divideValue(business.get中間評価項目得点第2群()))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku3gun().getValue().equals(divideValue(business.get中間評価項目得点第3群()))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku4gun().getValue().equals(divideValue(business.get中間評価項目得点第4群()))) {
            return true;
        }
        return !row.getChukanHyokaKomoku5gun().getValue().equals(divideValue(business.get中間評価項目得点第5群()));
    }

    /**
     * 対象者一覧の「⇒」の編集。
     *
     * @param row 対象者一覧
     * @param index 選択のインデックス
     * @param business 要介護認定一次判定結果情報
     */
    public void 対象者一覧更新の編集(dgIchijiHanteiTaishoshaIchiran_Row row, int index, IchijiHanteiKekkaJoho business) {

        if (business != null) {
            row.setColumnState(new RString("修正"));
            if (business.get要介護認定一次判定年月日() != null) {
                row.getIchijiHanteibi().setValue(business.get要介護認定一次判定年月日());
            }
            if (!isNullOrEmpty(business.get要介護認定一次判定結果コード())) {
                row.setIchijiHanteiKekkaCode(business.get要介護認定一次判定結果コード().getColumnValue());
                row.setIchijiHanteiKekka(IchijiHanteiKekkaCode09.toValue(business.
                        get要介護認定一次判定結果コード().value()).get名称());
            }
            if (!isNullOrEmpty(business.get要介護認定一次判定結果コード_認知症加算())) {
                row.setIchijiHanteiKekkaNinchishoKasanCode(business.get要介護認定一次判定結果コード_認知症加算().getColumnValue());
                row.setIchijiHanteiKekkaNinchishoKasan(IchijiHanteiKekkaCode09.
                        toValue(business.get要介護認定一次判定結果コード_認知症加算().value()).get名称());
            }
            if (business.get要介護認定一次判定警告コード() != null) {
                if (is警告コードAllZERO(business.get要介護認定一次判定警告コード())) {
                    row.setKeikokuCode(RString.EMPTY);
                } else {
                    row.setKeikokuCode(business.get要介護認定一次判定警告コード());
                }
                row.setHiddenKeikokuCode(business.get要介護認定一次判定警告コード());
            }
            row.getKijunJikan().setValue(divideValue(business.get要介護認定等基準時間()));
            row.getKijunJikanShokuji().setValue(divideValue(business.get要介護認定等基準時間_食事()));
            row.getKijunJikanHaisetsu().setValue(divideValue(business.get要介護認定等基準時間_排泄()));
            row.getKijunJikanIdo().setValue(divideValue(business.get要介護認定等基準時間_移動()));
            row.getKijunJikanSeiketsuHoji().setValue(divideValue(business.get要介護認定等基準時間_清潔保持()));
            row.getKijunJikanKansetsuCare().setValue(divideValue(business.get要介護認定等基準時間_間接ケア()));
            row.getKijunJikanBPSDKanren().setValue(divideValue(business.get要介護認定等基準時間_BPSD関連()));
            row.getKijunJikanKinoKunren().setValue(divideValue(business.get要介護認定等基準時間_機能訓練()));
            row.getKijunJikanIryoKanren().setValue(divideValue(business.get要介護認定等基準時間_医療関連()));
            row.getKijunJikanNinchishoKasan().setValue(divideValue(business.get要介護認定等基準時間_認知症加算()));
            row.getChukanHyokaKomoku1gun().setValue(divideValue(business.get中間評価項目得点第1群()));
            row.getChukanHyokaKomoku2gun().setValue(divideValue(business.get中間評価項目得点第2群()));
            row.getChukanHyokaKomoku3gun().setValue(divideValue(business.get中間評価項目得点第3群()));
            row.getChukanHyokaKomoku4gun().setValue(divideValue(business.get中間評価項目得点第4群()));
            row.getChukanHyokaKomoku5gun().setValue(divideValue(business.get中間評価項目得点第5群()));
            if (!isNullOrEmpty(business.get要介護認定状態の安定性コード())) {
                row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称());
            }

            if (!RString.isNullOrEmpty(row.getIchijiHanteiKekkaCode())) {
                set認知症自立度(new ShinseishoKanriNo(row.getShinseishoKanriNo()), row);
            }

            if (business.get認知症自立度Ⅱ以上の蓋然性() != null) {
                row.getNinchishoJiritsudoIIijoNoGaizensei().setValue(business.get認知症自立度Ⅱ以上の蓋然性());
                if (business.get認知症自立度Ⅱ以上の蓋然性().compareTo(Decimal.ZERO) < 0) {
                    row.getNinchishoJiritsudoIIijoNoGaizensei().setValue(null);
                }
                row.getHiddenNinchishoJiritsudoIIijoNoGaizensei().setValue(business.get認知症自立度Ⅱ以上の蓋然性());
            }

            if (!isNullOrEmpty(business.get認知機能及び状態安定性から推定される給付区分コード())) {
                row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(business.get認知機能及び状態安定性から推定される給付区分コード().value()).get名称());
            }
        }
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getDataSource().set(index, row);
    }

    private boolean isNullOrEmpty(Code code) {
        return code == null || code.isEmpty();
    }

    private RString get一次判定結果名称(Code 厚労省IF識別コード, Code 一次判定結果コード) {

        if (厚労省IF識別コード != null && 一次判定結果コード != null && !一次判定結果コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                return IchijiHanteiKekkaCode99.toValue(一次判定結果コード.getKey()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                return IchijiHanteiKekkaCode02.toValue(一次判定結果コード.getKey()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                return IchijiHanteiKekkaCode06.toValue(一次判定結果コード.getKey()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                return IchijiHanteiKekkaCode09.toValue(一次判定結果コード.getKey()).get名称();
            }
        }
        return RString.EMPTY;
    }

    /**
     * グリッドで選択中のデータから申請書管理番号を取得します。
     *
     * @return 選択中データの申請書管理番号
     */
    public List<ShinseishoKanriNo> get申請書管理番号fromSelectedItemOfGrid() {

        DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dg = div.getIchijiHanteiShoriTaishoshaIchiran()
                .getDgIchijiHanteiTaishoshaIchiran();
        List<dgIchijiHanteiTaishoshaIchiran_Row> rowList = dg.getSelectedItems();

        List<ShinseishoKanriNo> noList = new ArrayList<>();
        for (dgIchijiHanteiTaishoshaIchiran_Row row : rowList) {
            if (!RString.isNullOrEmpty(row.getShinseishoKanriNo())) {
                noList.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            }
        }
        return noList;
    }

    /**
     * 一次判定対象者を取得するためのパラメータを作成します。
     *
     * @param menuID メニューID
     * @param shinseishoKanriNoList 申請書管理番号List
     * @return パラメータクラス
     */
    public IChiJiPanTeiSyoRiParameter createParameter(RString menuID, ShinseishoKanriNoList shinseishoKanriNoList) {
        return createParameter(menuID, RString.EMPTY, shinseishoKanriNoList);
    }

    /**
     * 一次判定対象者を取得するためのパラメータを作成します。
     *
     * @param menuID メニューID
     * @param hihokenshaNo 被保険者番号
     * @param shinseishoKanriNoList 申請書管理番号List
     * @return パラメータクラス
     */
    public IChiJiPanTeiSyoRiParameter createParameter(RString menuID, RString hihokenshaNo, ShinseishoKanriNoList shinseishoKanriNoList) {
        ShoKisaiHokenshaNo 証記載保険者No = div.getIchijiHanteiKensakuJoken().getCcdHokenshaList().getSelectedItem().get証記載保険者番号();

        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RDate 認定申請年月日開始 = div.getIchijiHanteiKensakuJoken().getTxtShinseiDateRange().getFromValue();
        RDate 認定申請年月日終了 = div.getIchijiHanteiKensakuJoken().getTxtShinseiDateRange().getToValue();
        Decimal 検索件数 = div.getIchijiHanteiKensakuJoken().getTxtMaxCount().getValue();

        return IChiJiPanTeiSyoRiParameter.
                createParameter(
                        証記載保険者No,
                        ShoriJotaiKubun.通常.getコード(),
                        ShoriJotaiKubun.延期.getコード(),
                        イメージ区分,
                        認定申請年月日開始 == null ? FlexibleDate.EMPTY : new FlexibleDate(認定申請年月日開始.toDateString()),
                        認定申請年月日終了 == null ? FlexibleDate.EMPTY : new FlexibleDate(認定申請年月日終了.toDateString()),
                        検索件数,
                        menuID,
                        shinseishoKanriNoList.getShinseishoKanriNoS(),
                        hihokenshaNo);
    }

    /**
     * グリッドを、複数選択可能な状態にします。
     *
     * @param is複数選択可
     */
    public void setMultiSelectable(boolean is複数選択可) {
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getGridSetting().setMultiSelectable(is複数選択可);
    }

    /**
     * グリッドに選択ボタンを表示します。
     *
     * @param is選択ボタン表示
     */
    public void setIsShowSelectButtonColumn(boolean is選択ボタン表示) {
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getGridSetting()
                .setIsShowSelectButtonColumn(is選択ボタン表示);
    }

    private boolean is警告コードAllZERO(RString 警告コード) {
        return 警告コード.toString().matches("^0+$");
    }
}
