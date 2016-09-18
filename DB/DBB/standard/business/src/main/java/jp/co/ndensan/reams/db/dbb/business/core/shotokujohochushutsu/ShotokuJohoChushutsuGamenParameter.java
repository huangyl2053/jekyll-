/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.shotokujohochushutsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112003.SichousonEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携_の画面パラメータです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuJohoChushutsuGamenParameter {

    private FlexibleYear 処理年度;
    private List<SichousonEntity> 市町村情報List;
    private RString 出力順ID;
}
