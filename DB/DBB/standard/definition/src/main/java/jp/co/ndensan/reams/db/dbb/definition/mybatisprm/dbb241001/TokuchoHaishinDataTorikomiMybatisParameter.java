/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb241001;

import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みのmybatisパラメーターです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHaishinDataTorikomiMybatisParameter {

    private GyomuCode gyomuCode;
    private FlexibleYear shoriNendo;
    private RString tsuchiNaiyoCode;
    private FlexibleYearMonth shoriTaishoYM;
    private RString kisoNenkinNo;
    private RString nenkinCode;
    private RString koseiCityCode;
    private int renban;
}
