/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.honnsanteifuka.HonnsanteiFukaProcessParamter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 共同処理用受給者異動連絡票作成のParameter
 *
 * @reamsid_L DBC-3300-150 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC110030_KyodoJukyushaIdoRenrakuhyoOutParameter extends BatchParameterBase {

    private static final String KEY_処理年月 = "処理年月";
    private static final String KEY_再処理区分 = "再処理区分";
    private static final String KEY_抽出条件 = "抽出条件";
    private static final String KEY_ファイル名 = "ファイル名";
    @BatchParameter(key = KEY_処理年月, name = "処理年月")
    private RYearMonth 処理年月;
    @BatchParameter(key = KEY_再処理区分, name = "再処理区分")
    private RString 再処理区分;
    @BatchParameter(key = KEY_抽出条件, name = "抽出条件")
    private RString 抽出条件;
    @BatchParameter(key = KEY_ファイル名, name = "ファイル名")
    private RString ファイル名;

    /**
     * Process用のパラメータを生成します。
     *
     * @return HonnsanteiFukaProcessParamter
     */
    public HonnsanteiFukaProcessParamter toProcessParamter() {
        RString 合併区分 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        return new HonnsanteiFukaProcessParamter(処理年月.toDateString(), 再処理区分, 合併区分);
    }
}
