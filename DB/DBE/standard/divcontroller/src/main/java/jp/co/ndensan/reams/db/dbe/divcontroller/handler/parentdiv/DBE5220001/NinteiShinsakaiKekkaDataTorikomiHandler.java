/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE518002.DBE518002_NinteiShinsaIraiIfTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShinsakaiDataName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.dgTorikomiTaiasho_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;

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
    private final RString 名称_審査会情報;
    private final RString 名称_審査委員;
    private final RString 名称_審査結果;
    private final RString 名称_認定;
    private final RString ファイル名_審査会情報;
    private final RString ファイル名_審査委員;
    private final RString ファイル名_審査結果;
    private final RString ファイル名_認定;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiShinsakaiKekkaDataTorikomiHandler(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        this.div = div;
        RDate 基準日 = RDate.getNowDate();
        名称_審査会情報 = DbBusinessConfig.get(ConfigNameDBE.モバイル審査会結果データ審査会情報取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        名称_審査委員 = DbBusinessConfig.get(ConfigNameDBE.モバイル審査会結果データ審査委員取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        名称_審査結果 = DbBusinessConfig.get(ConfigNameDBE.モバイル審査会結果データ審査結果取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        名称_認定 = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会結果データファイル名, 基準日, SubGyomuCode.DBE認定支援);
        ファイル名_審査会情報 = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル審査会情報, 基準日, SubGyomuCode.DBE認定支援);
        ファイル名_審査委員 = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル審査委員, 基準日, SubGyomuCode.DBE認定支援);
        ファイル名_審査結果 = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル審査結果, 基準日, SubGyomuCode.DBE認定支援);
        ファイル名_認定 = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会結果データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
    }

    /**
     * 画面初期化セートセットです
     *
     */
    public void setOnLoad() {
        List<dgTorikomiTaiasho_Row> dataGridList = new ArrayList<>();
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(SELECT_KEY0)
            && div.getRadShinsain().getSelectedKey().contains(SELECT_KEY0)) {
            dataGridList.add(creatDgShinseishaIchiranRow(
                名称_審査会情報, ファイル名_審査会情報, div.getHdnTxtKensuShinsakaiJoho(), ShinsakaiDataName.審査会情報.getファイル名称()));
            dataGridList.add(creatDgShinseishaIchiranRow(
                名称_審査委員, ファイル名_審査委員, div.getHdnTxtKensuShinsaIin(), ShinsakaiDataName.審査委員.getファイル名称()));
            dataGridList.add(creatDgShinseishaIchiranRow(
                名称_審査結果, ファイル名_審査結果, div.getHdnTxtKensuShinsaKekka(), ShinsakaiDataName.審査結果.getファイル名称()));
            div.getDgTorikomiTaiasho().setHeight(new RString("99"));
        }
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(SELECT_KEY0)
            && div.getRadShinsain().getSelectedKey().contains(SELECT_KEY1)) {
            dataGridList.add(creatDgShinseishaIchiranRow(
                名称_審査会情報, ファイル名_審査会情報, div.getHdnTxtKensuShinsakaiJoho(), ShinsakaiDataName.審査会情報.getファイル名称()));
            dataGridList.add(creatDgShinseishaIchiranRow(
                名称_審査結果, ファイル名_審査結果, div.getHdnTxtKensuShinsaKekka(), ShinsakaiDataName.審査結果.getファイル名称()));
            div.getDgTorikomiTaiasho().setHeight(new RString("74"));
        }
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(SELECT_KEY1)) {
            dataGridList.add(creatDgShinseishaIchiranRow(名称_認定, ファイル名_認定, div.getHdnTxtKensuNintei(), ファイル名_認定));
            div.getDgTorikomiTaiasho().setHeight(new RString("49"));
        }
        div.getDgTorikomiTaiasho().getDataSource().clear();
        div.getDgTorikomiTaiasho().setDataSource(dataGridList);
    }

    /**
     * バッチ用パラメータクラスを作成します。
     *
     * @return DBE518002_NinteiShinsaIraiIfTorikomiParameter
     */
    public DBE518002_NinteiShinsaIraiIfTorikomiParameter setBatchParameter() {
        DBE518002_NinteiShinsaIraiIfTorikomiParameter batchParameter = new DBE518002_NinteiShinsaIraiIfTorikomiParameter();
        List<RString> fileList = new ArrayList<>();
        for (dgTorikomiTaiasho_Row row : div.getDgTorikomiTaiasho().getDataSource()) {
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
        batchParameter.setMediapath(DbBusinessConfig
            .get(ConfigNameDBE.OCRアップロード用ファイル格納パス, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        return batchParameter;
    }

    private dgTorikomiTaiasho_Row creatDgShinseishaIchiranRow(RString meisho, RString fileName, RString 件数, RString csvName) {
        dgTorikomiTaiasho_Row row = new dgTorikomiTaiasho_Row();
        row.setMeisho(meisho);
        row.setFileName(fileName);
        row.setCsvName(csvName);
        if (!件数.isEmpty()) {
            row.getDataNum().setValue(new Decimal(件数.toString()));
        }
        return row;
    }

    /**
     * 実際に取り込む用ファイル名を返します。
     *
     * @param file FileData
     * @return ファイル名
     */
    public RString getFileName(FileData file) {
        RString name = file.getFileName().split("＿").get(1);
        if (ShinsakaiDataName.審査会情報.getファイル名称().equals(name)) {
            return ファイル名_審査会情報;
        }
        if (ShinsakaiDataName.審査委員.getファイル名称().equals(name)) {
            return ファイル名_審査委員;
        }
        if (ShinsakaiDataName.審査結果.getファイル名称().equals(name)) {
            return ファイル名_審査結果;
        }
        return ファイル名_審査会情報;
    }
}
