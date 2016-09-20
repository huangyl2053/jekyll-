/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.choteibo.ChoteiboProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 調定簿作成バッチのパラメータ
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBB021001_ChoteiboSakuseiParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_SHORI_NENDO = "shoriNendo";
    private static final String KEY_CHOSHUTSU_ST_YMD = "chushutsuStYMD";
    private static final String KEY_CHOSHUTSU_ED_YMD = "chushutsuEdYMD";

    @BatchParameter(key = KEY_SHORI_NENDO, name = "処理年度")
    private FlexibleYear shoriNendo;
    @BatchParameter(key = KEY_CHOSHUTSU_ST_YMD, name = "開始調定日時")
    private YMDHMS chushutsuStYMD;
    @BatchParameter(key = KEY_CHOSHUTSU_ED_YMD, name = "終了調定日時")
    private YMDHMS chushutsuEdYMD;

    /**
     * バッチパラメータを作成
     *
     * @return ChoteiboProcessParameter
     */
    public ChoteiboProcessParameter toChoteiboBatchParameter() {
        return new ChoteiboProcessParameter(shoriNendo, chushutsuStYMD, chushutsuEdYMD);
    }
}
