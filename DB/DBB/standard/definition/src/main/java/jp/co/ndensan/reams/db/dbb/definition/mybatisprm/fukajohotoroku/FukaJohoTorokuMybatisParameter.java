/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajohotoroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護賦課を管理するMAPPERクラスです。
 *
 * @reamsid_L DBB-9040-090 wangxiaodong
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoTorokuMybatisParameter {

    private RString syoriName;
    private FlexibleYear nendo;
}
