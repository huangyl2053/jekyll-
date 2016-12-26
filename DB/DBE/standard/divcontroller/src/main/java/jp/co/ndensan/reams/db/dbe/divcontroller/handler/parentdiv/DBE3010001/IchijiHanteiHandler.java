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
import jp.co.ndensan.reams.db.dbe.definition.batchprm.itizihanteishori.ItziHanteiShoriBatchParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.IchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
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

        if (!RString.isNullOrEmpty(row.getKeikokuCode())) {
            builder.set要介護認定一次判定警告コード(row.getKeikokuCode());
        }
        if (!RString.isNullOrEmpty(row.getJotaiAnteiseiCode())) {
            builder.set要介護認定状態の安定性コード(new Code(JotaiAnteiseiCode.
                    valueOf(row.getJotaiAnteiseiCode().toString()).getコード()));
        }
        if (!RString.isNullOrEmpty(row.getNinchishoJiritsudoIIijoNoGaizensei())) {
            builder.set認知症自立度Ⅱ以上の蓋然性(new Decimal(row.getNinchishoJiritsudoIIijoNoGaizensei().toString()));
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
     * @param personalData PersonalData
     */
    public void 対象者一覧の編集(List<IChiJiPanTeiSyoRiBusiness> 一次判定対象者一覧List, PersonalData personalData) {

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
            row.setKeikokuCode(business.get要介護認定一次判定警告コード());
            row.getChosaJissibi().setValue(business.get認定調査実施年月日());
            row.getIkenshoJuryobi().setValue(business.get主治医意見書受領年月日());
            row.setKijunJikan(new RString(String.valueOf(business.get要介護認定等基準時間())));
            row.setKijunJikanShokuji(new RString(String.valueOf(business.get要介護認定等基準時間_食事())));
            row.setKijunJikanHaisetsu(new RString(String.valueOf(business.get要介護認定等基準時間_排泄())));
            row.setKijunJikanIdo(new RString(String.valueOf(business.get要介護認定等基準時間_移動())));
            row.setKijunJikanSeiketsuHoji(new RString(String.valueOf(business.get要介護認定等基準時間_清潔保持())));
            row.setKijunJikanKansetsuCare(new RString(String.valueOf(business.get要介護認定等基準時間_間接ケア())));
            row.setKijunJikanBPSDKanren(new RString(String.valueOf(business.get要介護認定等基準時間_BPSD関連())));
            row.setKijunJikanKinoKunren(new RString(String.valueOf(business.get要介護認定等基準時間_機能訓練())));
            row.setKijunJikanIryoKanren(new RString(String.valueOf(business.get要介護認定等基準時間_医療関連())));
            row.setKijunJikanNinchishoKasan(new RString(String.valueOf(business.get要介護認定等基準時間_認知症加算())));
            row.setChukanHyokaKomoku1gun(new RString(String.valueOf(business.get中間評価項目得点第1群())));
            row.setChukanHyokaKomoku2gun(new RString(String.valueOf(business.get中間評価項目得点第2群())));
            row.setChukanHyokaKomoku3gun(new RString(String.valueOf(business.get中間評価項目得点第3群())));
            row.setChukanHyokaKomoku4gun(new RString(String.valueOf(business.get中間評価項目得点第4群())));
            row.setChukanHyokaKomoku5gun(new RString(String.valueOf(business.get中間評価項目得点第5群())));
            if (business.get要介護認定状態の安定性コード() != null && !business.get要介護認定状態の安定性コード().isEmpty()) {
                row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称());
            }
            if (business.get認知症自立度Ⅱ以上の蓋然性() != null) {
                row.setNinchishoJiritsudoIIijoNoGaizensei(new RString(String.valueOf(business.get認知症自立度Ⅱ以上の蓋然性().roundUpTo(2))));
            }
            if (business.get推定される給付区分コード() != null && !business.get推定される給付区分コード().isEmpty()) {
                row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(business.get推定される給付区分コード().value()).get名称());
            }
            row.setShinseishoKanriNo(business.get申請書管理番号().value());
            row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード());
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号().value()));

            rowList.add(row);
        }
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().setDataSource(rowList);
        setDisplayNoneOfIchijiHanteiDialigButton(div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran());
    }

    private void setDisplayNoneOfIchijiHanteiDialigButton(DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dg) {
        RString menuIdStr = ResponseHolder.getMenuID();
        IchijiHanteiMenuId menuId = IchijiHanteiMenuId.toValue(menuIdStr);
        switch (menuId) {
            case 一次判定処理:
                dg.getGridSetting().getColumn("btnSyokai").setVisible(false);
                dg.getGridSetting().getColumn("btnSentaku").setVisible(true);
                dg.getGridSetting().getColumn("columnState").setVisible(true);
                break;
            default:
                dg.getGridSetting().getColumn("btnSyokai").setVisible(true);
                dg.getGridSetting().getColumn("btnSentaku").setVisible(false);
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
                && !row.getKeikokuCode().equals(business.get要介護認定一次判定警告コード())) {
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
                && !row.getNinchishoJiritsudoIIijoNoGaizensei().equals(new RString(String.valueOf(business.get認知症自立度Ⅱ以上の蓋然性())))) {
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

        if (!row.getKijunJikan().equals(new RString(String.valueOf(business.get要介護認定等基準時間())))) {
            return true;
        }
        if (!row.getKijunJikanShokuji().equals(new RString(String.valueOf(business.get要介護認定等基準時間_食事())))) {
            return true;
        }
        if (!row.getKijunJikanHaisetsu().equals(new RString(String.valueOf(business.get要介護認定等基準時間_排泄())))) {
            return true;
        }
        if (!row.getKijunJikanIdo().equals(new RString(String.valueOf(business.get要介護認定等基準時間_移動())))) {
            return true;
        }
        if (!row.getKijunJikanSeiketsuHoji().equals(new RString(String.valueOf(business.get要介護認定等基準時間_清潔保持())))) {
            return true;
        }
        if (!row.getKijunJikanKansetsuCare().equals(new RString(String.valueOf(business.get要介護認定等基準時間_間接ケア())))) {
            return true;
        }
        if (!row.getKijunJikanBPSDKanren().equals(new RString(String.valueOf(business.get要介護認定等基準時間_BPSD関連())))) {
            return true;
        }
        if (!row.getKijunJikanKinoKunren().equals(new RString(String.valueOf(business.get要介護認定等基準時間_機能訓練())))) {
            return true;
        }
        if (!row.getKijunJikanIryoKanren().equals(new RString(String.valueOf(business.get要介護認定等基準時間_医療関連())))) {
            return true;
        }
        return !row.getKijunJikanNinchishoKasan().equals(new RString(String.valueOf(business.get要介護認定等基準時間_認知症加算())));
    }

    private boolean notEqualsRowData中間評価項目(dgIchijiHanteiTaishoshaIchiran_Row row, IchijiHanteiKekkaJoho business) {

        if (!row.getChukanHyokaKomoku1gun().equals(new RString(String.valueOf(business.get中間評価項目得点第1群())))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku2gun().equals(new RString(String.valueOf(business.get中間評価項目得点第2群())))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku3gun().equals(new RString(String.valueOf(business.get中間評価項目得点第3群())))) {
            return true;
        }
        if (!row.getChukanHyokaKomoku4gun().equals(new RString(String.valueOf(business.get中間評価項目得点第4群())))) {
            return true;
        }
        return !row.getChukanHyokaKomoku5gun().equals(new RString(String.valueOf(business.get中間評価項目得点第5群())));
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
            row.setColumnState(new RString("更新"));
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
                row.setKeikokuCode(business.get要介護認定一次判定警告コード());
            }
            row.setKijunJikan(new RString(String.valueOf(business.get要介護認定等基準時間())));
            row.setKijunJikanShokuji(new RString(String.valueOf(business.get要介護認定等基準時間_食事())));
            row.setKijunJikanHaisetsu(new RString(String.valueOf(business.get要介護認定等基準時間_排泄())));
            row.setKijunJikanIdo(new RString(String.valueOf(business.get要介護認定等基準時間_移動())));
            row.setKijunJikanSeiketsuHoji(new RString(String.valueOf(business.get要介護認定等基準時間_清潔保持())));
            row.setKijunJikanKansetsuCare(new RString(String.valueOf(business.get要介護認定等基準時間_間接ケア())));
            row.setKijunJikanBPSDKanren(new RString(String.valueOf(business.get要介護認定等基準時間_BPSD関連())));
            row.setKijunJikanKinoKunren(new RString(String.valueOf(business.get要介護認定等基準時間_機能訓練())));
            row.setKijunJikanIryoKanren(new RString(String.valueOf(business.get要介護認定等基準時間_医療関連())));
            row.setKijunJikanNinchishoKasan(new RString(String.valueOf(business.get要介護認定等基準時間_認知症加算())));
            row.setChukanHyokaKomoku1gun(new RString(String.valueOf(business.get中間評価項目得点第1群())));
            row.setChukanHyokaKomoku2gun(new RString(String.valueOf(business.get中間評価項目得点第2群())));
            row.setChukanHyokaKomoku3gun(new RString(String.valueOf(business.get中間評価項目得点第3群())));
            row.setChukanHyokaKomoku4gun(new RString(String.valueOf(business.get中間評価項目得点第4群())));
            row.setChukanHyokaKomoku5gun(new RString(String.valueOf(business.get中間評価項目得点第5群())));
            if (!isNullOrEmpty(business.get要介護認定状態の安定性コード())) {
                row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称());
            }
            if (business.get認知症自立度Ⅱ以上の蓋然性() != null) {
                row.setNinchishoJiritsudoIIijoNoGaizensei(new RString(String.valueOf(business.get認知症自立度Ⅱ以上の蓋然性())));
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
}
