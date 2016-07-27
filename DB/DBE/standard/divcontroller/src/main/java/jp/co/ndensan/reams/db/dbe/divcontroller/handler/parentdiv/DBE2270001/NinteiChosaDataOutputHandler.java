/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2270001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosadataoutput.NinteiChosaDataOutputBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.NinteiChosaDataOutputMybitisParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2270001.NinteiChosaDataOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2270001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 認定調査データ出力（モバイル）のHandlerクラスです。
 *
 * @reamsid_L DBE-1860-010 duanzhanli
 */
public class NinteiChosaDataOutputHandler {

    private final NinteiChosaDataOutputDiv div;
    private static final RString BTNEXECUTE = new RString("btnExecute");

    /**
     * コンストラクタです。
     *
     * @param div 認定調査データ出力（モバイル）Div
     */
    public NinteiChosaDataOutputHandler(NinteiChosaDataOutputDiv div) {
        this.div = div;
    }

    /**
     * 認定調査データ出力（モバイル）の初期化です。
     */
    public void load() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTNEXECUTE, false);
        div.getCcdHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getCcdChosaltakusakiAndChosainInput().initialize(new RString("SimpleInputMode"));
        div.getTxtMaxCount().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxCount().setMaxValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 検索パラメータの設定メッソドです。
     *
     * @return NinteiChosaDataOutputMybitisParameter
     */
    public NinteiChosaDataOutputMybitisParameter setParameter() {
        return NinteiChosaDataOutputMybitisParameter.createSelectByKeyParam(
                div.getCcdChosaltakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue(),
                div.getCcdChosaltakusakiAndChosainInput().getTxtChosainCode().getValue(),
                div.getTxtMaxCount().getValue(),
                div.getCcdHokensha().getSelectedItem().get市町村コード().value());
    }

    /**
     * 検索条件クリアの設定メッソドです。
     */
    public void clear検索条件() {
        div.getCcdChosaltakusakiAndChosainInput().clear();
        div.getNinteiKensakuJyoken().getTxtMaxCount().clearValue();
        div.getCcdHokensha().loadHokenshaList(GyomuBunrui.介護認定);
    }

    /**
     * 検索条件クリアの設定メッソドです。
     */
    public void setHdnShichosonCode() {
        div.getCcdChosaltakusakiAndChosainInput().setHdnShichosonCode(div.getCcdHokensha().getSelectedItem().get市町村コード().value());
    }

    /**
     * バッチパラメータの設定メッソドです。
     *
     * @return NinteiChosaDataOutputBatchParamter
     */
    public NinteiChosaDataOutputBatchParamter getBatchParameter() {
        NinteiChosaDataOutputBatchParamter batchParamter = new NinteiChosaDataOutputBatchParamter();
        batchParamter.setNinteichosaItakusakiCode(div.getCcdChosaltakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue());
        batchParamter.setNinteiChosainCode(div.getCcdChosaltakusakiAndChosainInput().getTxtChosainCode().getValue());
        List<dgNinteiChosaData_Row> rowList = div.getNinteiIchiran().getDgNinteiChosaData().getSelectedItems();
        List<RString> shinseishoKanriNoList = new ArrayList<>();
        for (dgNinteiChosaData_Row row : rowList) {
            shinseishoKanriNoList.add(row.getShinseishoKanriNo());
        }
        batchParamter.setShinseishoKanriNoList(shinseishoKanriNoList);
        batchParamter.setShichosonCode(div.getCcdHokensha().getSelectedItem().get市町村コード().value());
        return batchParamter;
    }

    /**
     * 認定調査一覧Gridの設定です。
     *
     * @param masterList masterList
     */
    public void get認定調査一覧(List<NinteiChosaDataOutputBusiness> masterList) {
        List<dgNinteiChosaData_Row> rowList = new ArrayList<>();
        boolean 共通ボタン活性フラグ = false;
        for (NinteiChosaDataOutputBusiness master : masterList) {
            共通ボタン活性フラグ = true;
            dgNinteiChosaData_Row row = new dgNinteiChosaData_Row();
            row.setNinteiChosaItakusakiCode(master.get認定調査委託先コード());
            row.setJigyoshaMeisho(master.get調査委託先名称());
            row.setNinteiChosainCode(master.get認定調査員コード());
            row.setChosainShimei(master.get調査員氏名());
            row.setMobairuData(getモバイルデータ出力済フラグ(master.isモバイルデータ出力済フラグ()));
            row.setShichosonMeisho(master.get保険者());
            row.setHihokenshaNo(master.get被保険者番号());
            row.setHihokenshaName(master.get氏名());
            row.setSeibetsu(Seibetsu.toValue(master.get性別()).get名称());
            row.setNinteiShinseiYMD(master.get認定申請年月日());
            row.setNinteiShinseiShinseijiKubunCode(NinteiShinseiShinseijiKubunCode.toValue(master.get認定申請区分_申請時_コード()).get名称());
            row.setShinseishoKanriNo(master.get申請書管理番号());
            rowList.add(row);
            アクセスログ(master.get申請書管理番号());
        }
        if (共通ボタン活性フラグ) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNEXECUTE, false);
        }
        div.getNinteiIchiran().getDgNinteiChosaData().setDataSource(rowList);
    }

    /**
     * 共通ボタン「データ出力を実行する」の活性を設定します。
     *
     */
    public void set共通ボタン() {
        div.getNinteiIchiran().setDisplayNone(false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTNEXECUTE, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNEXECUTE, true);
    }

    private void アクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号));
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private RString getモバイルデータ出力済フラグ(boolean flag) {
        RString モバイルデータ出力済 = RString.EMPTY;
        if (flag) {
            モバイルデータ出力済 = new RString("済");
        }
        return モバイルデータ出力済;
    }
}
