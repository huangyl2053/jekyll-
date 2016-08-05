/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu;

import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetManager;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル取得を実行する。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KokuhorenkyoutsuGetFileProcess extends SimpleBatchProcessBase {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_RETURNENTITY;

    private KokuhorenkyotsuGetFileProcessParameter parameter;

    static {
        PARAMETER_OUT_RETURNENTITY = new RString("returnEntity");
    }

    OutputParameter<KokuhorenKyoutsuuFileGetReturnEntity> returnEntity;

    @Override
    protected void process() {
        KokuhorenKyoutsuuFileGetManager ファイル取得Manager = KokuhorenKyoutsuuFileGetManager.createInstance();
        KokuhorenKyoutsuuFileGetReturnEntity entity
                = ファイル取得Manager.getFile(parameter.get交換情報識別番号(), parameter.getファイル格納フォルダ名());
        returnEntity = new OutputParameter<>();
        returnEntity.setValue(entity);
    }

}
