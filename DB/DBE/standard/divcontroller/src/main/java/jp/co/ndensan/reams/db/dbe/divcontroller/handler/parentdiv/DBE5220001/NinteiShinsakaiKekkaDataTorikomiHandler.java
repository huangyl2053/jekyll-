/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001;

import java.io.File;
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

/**
 * 画面設計_DBE5220001_介護認定審査会審査結果データ取込み（モバイル）Handlerクラスです
 *
 * @reamsid_L DBE-1841-010 xuyongchao
 */
public class NinteiShinsakaiKekkaDataTorikomiHandler {

    private final NinteiShinsakaiKekkaDataTorikomiDiv div;

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
        TorikomiConditions c = new TorikomiConditions(this.div);
        List<dgTorikomiTaiasho_Row> dataGridList = new ArrayList<>();
        if (c.get取込対象データ().isMobile()) {
            dataGridList.add(creatDgShinseishaIchiranRow(
                    ファイル名_審査会情報, div.getHdnTxtKensuShinsakaiJoho(), ShinsakaiDataName.審査会情報.getファイル名称()));
            dataGridList.add(creatDgShinseishaIchiranRow(
                    ファイル名_審査委員, div.getHdnTxtKensuShinsaIin(), ShinsakaiDataName.審査委員.getファイル名称()));
            dataGridList.add(creatDgShinseishaIchiranRow(
                    ファイル名_審査結果, div.getHdnTxtKensuShinsaKekka(), ShinsakaiDataName.審査結果.getファイル名称()));
            div.getDgTorikomiTaiasho().setHeight(new RString("99"));
            div.getDataTorikomi().setDisplayNone(false);
        } else if (c.get取込対象データ().isNinteiSoft()) {
            dataGridList.add(creatDgShinseishaIchiranRow(
                    ファイル名_認定, div.getHdnTxtKensuNintei(), ファイル名_認定));
            div.getDgTorikomiTaiasho().setHeight(new RString("49"));
            div.getDataTorikomi().setDisplayNone(true);
        }
        div.getDgTorikomiTaiasho().getDataSource().clear();
        div.getDgTorikomiTaiasho().setDataSource(dataGridList);
    }

    /**
     * バッチ用パラメータクラスを作成します。
     *
     * @param torikomiFileDirectoryPath 取込対象ファイルの存在するディレクトリパス
     * @return DBE518002_NinteiShinsaIraiIfTorikomiParameter
     */
    public DBE518002_NinteiShinsaIraiIfTorikomiParameter setBatchParameter(RString torikomiFileDirectoryPath) {
        DBE518002_NinteiShinsaIraiIfTorikomiParameter batchParameter = new DBE518002_NinteiShinsaIraiIfTorikomiParameter();
        List<RString> fileList = new ArrayList<>();
        for (dgTorikomiTaiasho_Row row : div.getDgTorikomiTaiasho().getDataSource()) {
            fileList.add(row.getFileName());
        }
        batchParameter.setFilename(fileList);
        TorikomiConditions c = new TorikomiConditions(div);
        batchParameter.setTorikomidatakubun(c.get取込対象データ().code());
        batchParameter.setTorikominaiyoukubun(c.get取込内容().code());
        batchParameter.setShinsakaiiintorikomikubun(c.get審査員出欠取込区分());
        batchParameter.setMediapath(torikomiFileDirectoryPath);
        return batchParameter;
    }

    private dgTorikomiTaiasho_Row creatDgShinseishaIchiranRow(RString fileName, RString 件数, RString csvName) {
        dgTorikomiTaiasho_Row row = new dgTorikomiTaiasho_Row();
        row.setImportingFileName(RString.EMPTY);
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
    public RString getFileName(File file) {
        RString name = new RString(file.getName()).split("＿").get(1);
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
