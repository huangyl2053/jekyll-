/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiKojinJohoTeikyoMybatisParamater implements IMyBatisParameter {

    private RString subGyomuCode;
    private RString shoriName1;
    private RString shoriName2;
    private boolean isTosyo;

}
