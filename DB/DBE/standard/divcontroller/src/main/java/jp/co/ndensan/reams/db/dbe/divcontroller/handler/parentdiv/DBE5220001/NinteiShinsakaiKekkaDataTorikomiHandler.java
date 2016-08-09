/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteishinsakaikekkadatatorikomi.ShinsakaiKekkaDataTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.dgTorikomiTaiasho_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBE5220001_介護認定審査会審査結果データ取込み（モバイル）Handlerクラスです
 *
 * @reamsid_L DBE-1841-010 xuyongchao
 */
public class NinteiShinsakaiKekkaDataTorikomiHandler {

    private final NinteiShinsakaiKekkaDataTorikomiDiv div;
    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString SERVER_PATH = new RString("\\db\\dbe\\DivConNinteiShinsakaiKekkaDataTorikomi\\DivConOnclick_BtnUpload");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiShinsakaiKekkaDataTorikomiHandler(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化セートセットです
     *
     */
    public void setOnLoad() {
        List<dgTorikomiTaiasho_Row> dataGridList = new ArrayList<>();
        RString 審査会審査結果データ = RString.EMPTY;
        RString ファイル名称 = RString.EMPTY;
        RDate 基準日 = RDate.getNowDate();
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(SELECT_KEY0)
                && div.getRadShinsain().getSelectedKey().contains(SELECT_KEY0)) {
            審査会審査結果データ = DbBusinessConfig.get(ConfigNameDBE.モバイル審査会結果データ審査委員取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
            ファイル名称 = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル審査委員, 基準日, SubGyomuCode.DBE認定支援);
            dataGridList.add(creatDgShinseishaIchiranRow(審査会審査結果データ, ファイル名称));

            審査会審査結果データ = DbBusinessConfig.get(ConfigNameDBE.モバイル審査会結果データ審査結果取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
            ファイル名称 = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル審査結果, 基準日, SubGyomuCode.DBE認定支援);
            dataGridList.add(creatDgShinseishaIchiranRow(審査会審査結果データ, ファイル名称));
        }
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(SELECT_KEY0)
                && div.getRadShinsain().getSelectedKey().contains(SELECT_KEY1)) {
            審査会審査結果データ = DbBusinessConfig.get(ConfigNameDBE.モバイル審査会結果データ審査結果取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
            ファイル名称 = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル審査結果, 基準日, SubGyomuCode.DBE認定支援);
            dataGridList.add(creatDgShinseishaIchiranRow(審査会審査結果データ, ファイル名称));
        }
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(SELECT_KEY1)) {
            審査会審査結果データ = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会結果データファイル名, 基準日, SubGyomuCode.DBE認定支援);
            ファイル名称 = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会結果データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
            dataGridList.add(creatDgShinseishaIchiranRow(審査会審査結果データ, ファイル名称));
        }
        div.getDgTorikomiTaiasho().getDataSource().clear();
        div.getDgTorikomiTaiasho().setDataSource(dataGridList);
    }

    /**
     * バッチ用パラメータクラスを作成します。
     *
     */
    public void setBatchParameter() {
        ShinsakaiKekkaDataTorikomiBatchParameter batchParameter = new ShinsakaiKekkaDataTorikomiBatchParameter();
        List<RString> fileList = new ArrayList<>();
        for (dgTorikomiTaiasho_Row row : div.getDgTorikomiTaiasho().getSelectedItems()) {
            fileList.add(row.getFileName());
        }
        batchParameter.setFilename(fileList);
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(SELECT_KEY0)) {
            batchParameter.setTorikomidatakubun(RSTRING_1);
        } else {
            batchParameter.setTorikomidatakubun(RSTRING_2);
        }
        if (div.getRadTorikomiNaiyo().getSelectedKey().contains(SELECT_KEY0)) {
            batchParameter.setTorikominaiyoukubun(RSTRING_1);
        } else {
            batchParameter.setTorikominaiyoukubun(RSTRING_2);
        }
        if (div.getRadShinsain().getSelectedKey().contains(SELECT_KEY0)) {
            batchParameter.setShinsakaiiintorikomikubun(RSTRING_1);
        } else {
            batchParameter.setShinsakaiiintorikomikubun(RSTRING_2);
        }
        batchParameter.setMediapath(SERVER_PATH);
    }

    private dgTorikomiTaiasho_Row creatDgShinseishaIchiranRow(RString meisho, RString fileName) {
        dgTorikomiTaiasho_Row row = new dgTorikomiTaiasho_Row();
        row.setMeisho(meisho);
        row.setFileName(fileName);
        return row;
    }
}
