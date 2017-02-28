/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.ShinseiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090002.DBE090002_NinteikekkaJohoteikyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900002.YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900002.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 要介護認定情報提供一括発行Divのハンドラーです。
 *
 * @author N3212 竹内 和紀
 */
public class YokaigoNinteiJohoTeikyoIkkatsuHakkoHandler {

    private static final RString 二次判定日 = new RString("0");
    private static final RString 被保険者番号 = new RString("1");
    private final RString マスキング_なし = new RString("0");
    private final RString マスキング_あり = new RString("1");
    private final RString 出力方法_一式 = new RString("0");
    private final RString KEY0 = new RString("key0");

    private final YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     */
    public YokaigoNinteiJohoTeikyoIkkatsuHakkoHandler(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        this.div = div;
    }

    /**
     * 初期化処理です。
     */
    public void initialize() {
        clear検索条件();
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxHyojiKensu().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        div.getTxtMaxHyojiKensu().setValue(new Decimal(検索制御_最大取得件数.toString()));
        List<dgShinseiList_Row> dataSource = new ArrayList<>();
        div.getDgShinseiList().setDataSource(dataSource);
        div.getChkNinteiChosahyo().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkTokkiJiko().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkShujiiIkensho().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkSonotaShiryo().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkIchijiHanteiKekka().setSelectedItemsByKey(new ArrayList<RString>());
        setRadNinteiChosaMasking();
        setRadTokkiJikoMasking();
        setRadShujiiMasking();
        setRadSonotaShiryoMasking();
        setRadIchijiHanteiMasking();
    }

    /**
     * 申請一覧データグリッドを設定します。
     *
     * @param 申請一覧 申請一覧
     */
    public void set申請一覧データグリッド(SearchResult<ShinseiIchiran> 申請一覧) {
        List<dgShinseiList_Row> dataSource = new ArrayList<>();
        for (ShinseiIchiran 申請 : 申請一覧.records()) {
            dgShinseiList_Row row = new dgShinseiList_Row();
            row.setHokensha(申請.get保険者名称());
            row.setHihokenshaNo(申請.get被保険者番号());
            row.setHihokenshaName(申請.get被保険者氏名().value());
            row.getSeinengappi().setValue(申請.get生年月日());
            row.getNenrei().setValue(new Decimal(申請.get年齢()));
            row.setSeibetsu(Gender.toValue(申請.get性別()).getCommonName());
            row.getNinteiShinseibi().setValue(申請.get認定申請年月日());
            row.setShinseikubun(NinteiShinseiShinseijiKubunCode.toValue(申請.get申請区分()).get名称());
            row.setNijiHanteiKekka((申請.get二次判定結果() != null) ? YokaigoJotaiKubun.toValue(申請.get二次判定結果()).get名称() : RString.EMPTY);
            row.getKaisaiYoteibi().setValue((申請.get開催予定日() != null) ? 申請.get開催予定日() : FlexibleDate.EMPTY);
            row.getKaisaibi().setValue((申請.get開催日() != null) ? 申請.get開催日() : FlexibleDate.EMPTY);
            row.setHihokenshaDoi(申請.get被保険者の同意());
            row.setShujiiDoi(申請.get主治医の同意());
            row.setShinseishoKanriNo(申請.get申請書管理番号());
            row.setSelectable(申請.get被保険者の同意());
            dataSource.add(row);
        }
        div.getDgShinseiList().setDataSource(dataSource);
        div.getDgShinseiList().getGridSetting().setLimitRowCount(div.getTxtMaxHyojiKensu().getValue().intValue());
        div.getDgShinseiList().getGridSetting().setSelectedRowCount(申請一覧.totalCount());
    }

    /**
     * 検索条件をクリアします。
     */
    public void clear検索条件() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getRadKensakuKomoku().setSelectedIndex(0);
        div.getTxtNijiHanteibi().clearFromValue();
        div.getTxtNijiHanteibi().clearToValue();
        div.getTxtHihokenshaNo().clearValue();
        div.getChkDoiNashiFukumu().setSelectedItemsByKey(new ArrayList<RString>());
    }

    /**
     * 認定調査票マスキングラジオボタンを設定します。
     */
    public void setRadNinteiChosaMasking() {
        if (div.getChkNinteiChosahyo().getSelectedItems().isEmpty()) {
            div.getRadNinteiChosaMasking().setDisabled(true);
            div.getRadNinteiChosaMasking().setSelectedKey(マスキング_なし);
        } else {
            div.getRadNinteiChosaMasking().setDisabled(false);
        }
    }

    /**
     * 特記事項マスキングラジオボタンを設定します。
     */
    public void setRadTokkiJikoMasking() {
        if (div.getChkTokkiJiko().getSelectedItems().isEmpty()) {
            div.getRadTokkiJikoMasking().setDisabled(true);
            div.getRadTokkiJikoMasking().setSelectedKey(マスキング_あり);
        } else {
            div.getRadTokkiJikoMasking().setDisabled(false);
        }
    }

    /**
     * 主治医意見書マスキングラジオボタンを設定します。
     */
    public void setRadShujiiMasking() {
        if (div.getChkShujiiIkensho().getSelectedItems().isEmpty()) {
            div.getRadShujiiMasking().setDisabled(true);
            div.getRadShujiiMasking().setSelectedKey(マスキング_あり);
        } else {
            div.getRadShujiiMasking().setDisabled(false);
        }
    }

    /**
     * その他資料マスキングラジオボタンを設定します。
     */
    public void setRadSonotaShiryoMasking() {
        if (div.getChkSonotaShiryo().getSelectedItems().isEmpty()) {
            div.getRadSonotaShiryoMasking().setDisabled(true);
            div.getRadSonotaShiryoMasking().setSelectedKey(マスキング_あり);
        } else {
            div.getRadSonotaShiryoMasking().setDisabled(false);
        }
    }

    /**
     * 一次判定結果マスキングラジオボタンを設定します。
     */
    public void setRadIchijiHanteiMasking() {
        if (div.getChkIchijiHanteiKekka().getSelectedItems().isEmpty()) {
            div.getRadIchijiHanteiMasking().setDisabled(true);
            div.getRadIchijiHanteiMasking().setSelectedKey(マスキング_なし);
        } else {
            div.getRadIchijiHanteiMasking().setDisabled(false);
        }
    }

    /**
     * 発行する帳票に関するコントロールを設定します。
     */
    public void set発行する帳票() {
        if (出力方法_一式.equals(div.getRadOutputHoho().getSelectedKey())) {
            List<RString> keys = new ArrayList<>();
            keys.add(KEY0);
            div.getChkNinteiChosahyo().setDisabled(true);
            div.getChkNinteiChosahyo().setSelectedItemsByKey(keys);
            div.getChkTokkiJiko().setDisabled(true);
            div.getChkTokkiJiko().setSelectedItemsByKey(keys);
            div.getChkShujiiIkensho().setDisabled(true);
            div.getChkShujiiIkensho().setSelectedItemsByKey(keys);
            div.getChkSonotaShiryo().setDisabled(true);
            div.getChkSonotaShiryo().setSelectedItemsByKey(keys);
            div.getChkIchijiHanteiKekka().setDisabled(true);
            div.getChkIchijiHanteiKekka().setSelectedItemsByKey(keys);
            div.getRadNinteiChosaMasking().setDisabled(false);
            div.getRadTokkiJikoMasking().setDisabled(false);
            div.getRadShujiiMasking().setDisabled(false);
            div.getRadSonotaShiryoMasking().setDisabled(false);
            div.getRadIchijiHanteiMasking().setDisabled(false);
        } else {
            div.getChkNinteiChosahyo().setDisabled(false);
            div.getChkNinteiChosahyo().setSelectedItemsByKey(new ArrayList<RString>());
            div.getChkTokkiJiko().setDisabled(false);
            div.getChkTokkiJiko().setSelectedItemsByKey(new ArrayList<RString>());
            div.getChkShujiiIkensho().setDisabled(false);
            div.getChkShujiiIkensho().setSelectedItemsByKey(new ArrayList<RString>());
            div.getChkSonotaShiryo().setDisabled(false);
            div.getChkSonotaShiryo().setSelectedItemsByKey(new ArrayList<RString>());
            div.getChkIchijiHanteiKekka().setDisabled(false);
            div.getChkIchijiHanteiKekka().setSelectedItemsByKey(new ArrayList<RString>());
            div.getRadNinteiChosaMasking().setDisabled(true);
            div.getRadTokkiJikoMasking().setDisabled(true);
            div.getRadShujiiMasking().setDisabled(true);
            div.getRadSonotaShiryoMasking().setDisabled(true);
            div.getRadIchijiHanteiMasking().setDisabled(true);
        }
    }

    /**
     * 主治医意見書チェックボックスのみ選択されているか返します。
     *
     * @return true：主治医意見書チェックボックスのみ選択されている場合<br/>
     * false：それ以外の場合
     */
    public boolean is主治医意見書のみ選択() {
        return !div.getChkNinteiChosahyo().isAllSelected()
                && !div.getChkTokkiJiko().isAllSelected()
                && div.getChkShujiiIkensho().isAllSelected()
                && !div.getChkSonotaShiryo().isAllSelected()
                && !div.getChkIchijiHanteiKekka().isAllSelected();
    }

    /**
     * 申請一覧データグリッドで選択しているデータの内、主治医の同意がないデータの被保険者番号のリストを返します。
     *
     * @return 主治医の同意がないデータの被保険者番号のリスト
     */
    public List<RString> get主治医の同意がない被保険者番号List() {
        List<RString> 主治医の同意がない被保険者番号List = new ArrayList<>();
        for (dgShinseiList_Row row : div.getDgShinseiList().getSelectedItems()) {
            if (!row.getShujiiDoi()) {
                主治医の同意がない被保険者番号List.add(row.getHihokenshaNo());
            }
        }
        return 主治医の同意がない被保険者番号List;
    }

    /**
     * 申請一覧データグリッドで選択しているデータの内、二次判定結果が決定していないデータの被保険者番号のリストを返します。
     *
     * @return 二次判定結果が決定していないデータの被保険者番号のリスト
     */
    public List<RString> get二次判定結果が決定していない被保険者番号List() {
        List<RString> 二次判定結果が決定していない被保険者番号List = new ArrayList<>();
        for (dgShinseiList_Row row : div.getDgShinseiList().getSelectedItems()) {
            if (row.getNinteiShinsakaiKanryoYMD().getValue() == null
                    || row.getNinteiShinsakaiKanryoYMD().getValue().isEmpty()) {
                二次判定結果が決定していない被保険者番号List.add(row.getHihokenshaNo());
            }
        }
        return 二次判定結果が決定していない被保険者番号List;
    }

    /**
     * 申請一覧データグリッドで選択しているデータの内、印刷済のデータの被保険者番号のリストを返します。
     *
     * @return 印刷済のデータの被保険者番号のリスト
     */
    public List<RString> get印刷済の被保険者番号List() {
        List<RString> 印刷済被保険者番号List = new ArrayList<>();
        for (dgShinseiList_Row row : div.getDgShinseiList().getSelectedItems()) {
            if (row.getJohoteikyoSiryoOutputYMD().getValue() != null
                    && !row.getJohoteikyoSiryoOutputYMD().getValue().isEmpty()) {
                印刷済被保険者番号List.add(row.getHihokenshaNo());
            }
        }
        return 印刷済被保険者番号List;
    }

    /**
     * 検索用パラメータを作成します。
     *
     * @return YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter
     */
    public YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter createSearchParameter() {
        return new YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter(
                div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value(),
                div.getRadKensakuKomoku().getSelectedKey().equals(二次判定日),
                div.getTxtNijiHanteibi().getFromValue(),
                div.getTxtNijiHanteibi().getToValue(),
                div.getRadKensakuKomoku().getSelectedKey().equals(被保険者番号),
                div.getTxtHihokenshaNo().getValue(),
                div.getChkDoiNashiFukumu().isAllSelected(),
                div.getTxtMaxHyojiKensu().getValue().intValue());
    }

    /**
     * バッチパラメータを作成します。
     *
     * @return DBE090002_NinteikekkaJohoteikyoParameter
     */
    public DBE090002_NinteikekkaJohoteikyoParameter createBatchParameter() {
        DBE090002_NinteikekkaJohoteikyoParameter parameter = new DBE090002_NinteikekkaJohoteikyoParameter();
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        List<RString> 申請書管理番号List = new ArrayList<>();
        for (dgShinseiList_Row row : div.getDgShinseiList().getSelectedItems()) {
            申請書管理番号List.add(row.getShinseishoKanriNo());
        }
        parameter.set申請書管理番号(申請書管理番号List);
        parameter.set出力方法(div.getRadOutputHoho().getSelectedKey());
        parameter.set認定調査票出力(div.getChkNinteiChosahyo().isAllSelected());
        parameter.set特記事項出力(div.getChkTokkiJiko().isAllSelected());
        parameter.set主治医意見書出力(div.getChkShujiiIkensho().isAllSelected());
        parameter.setその他資料出力(div.getChkSonotaShiryo().isAllSelected());
        parameter.set一次判定結果出力(div.getChkIchijiHanteiKekka().isAllSelected());
        parameter.set認定調査票マスキング区分(div.getRadNinteiChosaMasking().getSelectedKey());
        parameter.set特記事項マスキング区分(div.getRadTokkiJikoMasking().getSelectedKey());
        parameter.set主治医意見書マスキング区分(div.getRadShujiiMasking().getSelectedKey());
        parameter.setその他資料マスキング区分(div.getRadSonotaShiryoMasking().getSelectedKey());
        parameter.set一次判定結果マスキング区分(div.getRadIchijiHanteiMasking().getSelectedKey());
        return parameter;
    }
}
