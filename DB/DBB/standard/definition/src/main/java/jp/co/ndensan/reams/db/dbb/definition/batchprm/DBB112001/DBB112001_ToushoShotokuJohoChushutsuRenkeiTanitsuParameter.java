/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112003.SichousonEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携_当初単一のバッチパラメータです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter extends BatchParameterBase {

    private static final String NAME_SHORI_NENDO = "処理年度";
    private static final String KEY_SHORI_NENDO = "shorinendo";
    private static final String NAME_SHICHOSON_JOHO_LIST = "市町村情報List";
    private static final String KEY_SHICHOSON_JOHO_LIST = "shichosonJohoList";
    private static final String NAME_SHUTSURYOKUJUN_ID = "出力順ID";
    private static final String KEY_SHUTSURYOKUJUN_ID = "shutsuryokujunID";
    private static final String NAME_CHOHYO_ID = "帳票ID";
    private static final String KEY_CHOHYO_ID = "chohyoID";
    private static final String NAME_SHARE_FILES_NAME = "共有ファイル名";
    private static final String KEY_SHARE_FILES_NAME = "sharefilesname";
    private static final String NAME_SHARE_FILES_ID = "共有ファイルID";
    private static final String KEY_SHARE_FILES_ID = "sharefilesID";
    private static final String NAME_SHORI_KUBUN = "処理区分";
    private static final String KEY_SHORI_KUBUN = "shorikubun";
    private static final String NAME_SHORI_NICHIJI = "処理日時";
    private static final String KEY_SHORI_NICHIJI = "shorinichiji";

    @BatchParameter(key = KEY_SHORI_NENDO, name = NAME_SHORI_NENDO)
    private FlexibleYear 処理年度;
    @BatchParameter(key = KEY_SHICHOSON_JOHO_LIST, name = NAME_SHICHOSON_JOHO_LIST)
    private List<SichousonEntity> 市町村情報List;
    @BatchParameter(key = KEY_SHUTSURYOKUJUN_ID, name = NAME_SHUTSURYOKUJUN_ID)
    private RString 出力順ID;
    @BatchParameter(key = KEY_CHOHYO_ID, name = NAME_CHOHYO_ID)
    private ReportId 帳票ID;
    @BatchParameter(key = KEY_SHARE_FILES_NAME, name = NAME_SHARE_FILES_NAME)
    private RString 共有ファイル名;
    @BatchParameter(key = KEY_SHARE_FILES_ID, name = NAME_SHARE_FILES_ID)
    private RString 共有ファイルID;
    @BatchParameter(key = KEY_SHORI_KUBUN, name = NAME_SHORI_KUBUN)
    private RString 処理区分;
    @BatchParameter(key = KEY_SHORI_NICHIJI, name = NAME_SHORI_NICHIJI)
    private YMDHMS 処理日時;

    /**
     * 所得情報抽出・連携（バッチ）_単一のProcessParamterパラメータ作成する。
     *
     * @return 所得情報抽出・連携（バッチ）_単一のProcessParamterパラメータ
     */
    public ShutokuJohoShuchutsuRenkeiProcessParameter toProcessParamter() {
        return new ShutokuJohoShuchutsuRenkeiProcessParameter(
                処理年度,
                市町村情報List,
                出力順ID,
                帳票ID,
                共有ファイル名,
                共有ファイルID,
                処理区分,
                処理日時);
    }

}
