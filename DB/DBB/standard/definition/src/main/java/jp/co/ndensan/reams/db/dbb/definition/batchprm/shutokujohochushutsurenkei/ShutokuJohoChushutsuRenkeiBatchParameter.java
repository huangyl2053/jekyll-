/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.shutokujohochushutsurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 所得情報抽出・連携（バッチ）のバッチ起動時に設定されるパラメータ
 *
 * @reamsid_L DBB-1690-060 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShutokuJohoChushutsuRenkeiBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_SHORI_NENDO = "shorinendo";
    private static final String KEY_SHICHOSON_JOHO_LIST = "shichosonJohoList";
    private static final String KEY_SHUTSURYOKUJUN_ID = "shutsuryokujunID";
    private static final String KEY_CHOHYO_ID = "chohyoID";
    private static final String KEY_SHARE_FILES_NAME = "sharefilesname";
    private static final String KEY_SHARE_FILES_ID = "sharefilesID";
    private static final String KEY_SHORI_KUBUN = "shorikubun";
    private static final String KEY_SHORI_NICHIJI = "shorinichiji";

    @BatchParameter(key = KEY_SHORI_NENDO, name = "処理年度")
    private FlexibleYear shorinendo;
    @BatchParameter(key = KEY_SHICHOSON_JOHO_LIST, name = "市町村情報List")
    private List shichosonJohoList;
    @BatchParameter(key = KEY_SHUTSURYOKUJUN_ID, name = "出力順ID")
    private long shutsuryokujunID;
    @BatchParameter(key = KEY_CHOHYO_ID, name = "帳票ID")
    private ReportId chohyoID;
    @BatchParameter(key = KEY_SHARE_FILES_NAME, name = "共有ファイル名")
    private RString sharefilesname;
    @BatchParameter(key = KEY_SHARE_FILES_ID, name = "共有ファイルID")
    private RString sharefilesID;
    @BatchParameter(key = KEY_SHORI_KUBUN, name = "処理区分")
    private RString shorikubun;
    @BatchParameter(key = KEY_SHORI_NICHIJI, name = "処理日時")
    private YMDHMS shorinichiji;

    /**
     * 所得情報抽出・連携（バッチ）のProcessParamterパラメータ作成です。
     *
     * @return 所得情報抽出・連携（バッチ）のProcessParamterパラメータ
     */
    public ShutokuJohoShuchutsuRenkeiProcessParameter toProcessParamter() {
        return new ShutokuJohoShuchutsuRenkeiProcessParameter(
                shorinendo,
                shichosonJohoList,
                shutsuryokujunID,
                chohyoID,
                sharefilesname,
                sharefilesID,
                shorikubun,
                shorinichiji);
    }

    private FlexibleYear 処理年度;
    private List<ShichosonJohoShutoku> 市町村情報List;
    private long 出力順ID;
    private ReportId 帳票ID;
    private RString 共有ファイル名;
    private RString 共有ファイルID;
    private RString 処理区分;
    private YMDHMS 処理日時;
}
