/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0140011;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyotruku.KaigojuminHyotrukuBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0140011.JukiRendoTandokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;

/**
 *
 * 住民異動連携情報登録クラスです。
 *
 * @reamsid_L DBA-1400-010 houtianpeng
 */
public class JukiRendoTandokuHandler {

    private final JukiRendoTandokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 住民異動連携情報登録情報Div
     */
    public JukiRendoTandokuHandler(JukiRendoTandokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     */
    public void initialize() {

        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnJikko"), true);
    }

    /**
     * 画面編集。
     *
     * @param file FileData
     */
    public void 画面編集(FileData file) {

        div.getTxtSakuseiYMD().setValue(new RDate(RDate.getNowDate().toString()));
        div.getTxtSakuseiTime().setValue(RDate.getNowTime());
        div.getTxtKensu().setValue(new Decimal(jp.co.ndensan.reams.uz.uza.io.File.size(file.getFilePath())));
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnJikko"), false);
    }

    /**
     * 画面初期化処理します。
     *
     * @return KaigojuminHyotrukuBatchParameter
     */
    public KaigojuminHyotrukuBatchParameter setBatchParameter() {
        KaigojuminHyotrukuBatchParameter parameter = new KaigojuminHyotrukuBatchParameter();

        parameter.setShoriTimestamp(RDateTime.now());
        return parameter;
    }
}
