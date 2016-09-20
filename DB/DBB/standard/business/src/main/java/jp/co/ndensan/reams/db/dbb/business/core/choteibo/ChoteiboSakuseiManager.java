/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choteibo;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021001.DBB021001_ChoteiboSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 調定簿作成を管理するクラスです。
 *
 * @reamsid_L DBB-0770-020 cuilin
 */
public class ChoteiboSakuseiManager {

    /**
     * 調定簿作成パラメータ作成
     *
     * @param 処理年度 処理年度
     * @param 開始年月日 開始年月日
     * @param 開始時分秒 開始時分秒
     * @param 終了年月日 終了年月日
     * @param 終了時分秒 終了時分秒
     * @return {@link DBB021001_ChoteiboSakuseiParameter}
     */
    public DBB021001_ChoteiboSakuseiParameter getChoteiboParameter(FlexibleYear 処理年度,
            RDate 開始年月日,
            RTime 開始時分秒,
            RDate 終了年月日,
            RTime 終了時分秒) {
        DBB021001_ChoteiboSakuseiParameter parameter = new DBB021001_ChoteiboSakuseiParameter();
        parameter.setShoriNendo(処理年度);
        parameter.setChushutsuStYMD(new YMDHMS(開始年月日, 開始時分秒));
        parameter.setChushutsuEdYMD(new YMDHMS(終了年月日, 終了時分秒));
        return parameter;
    }
}
