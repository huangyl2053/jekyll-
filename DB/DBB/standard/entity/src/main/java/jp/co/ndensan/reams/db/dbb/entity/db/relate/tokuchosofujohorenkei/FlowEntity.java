/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴送付情報連携Entityクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FlowEntity {

    private Map<RString, RString> ファイル;
    private Map<RString, Integer> レコード件数;

}
