/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * その他機関選択ガイドのダイアログパラメータクラスです。
 *
 * @reamsid_L DBE-3000-050 wangkun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SoNoTaKikanGuideModel implements Serializable {

    private GyomuBunrui 業務分類;
    private RString 市町村コード;
    private RString その他機関コード;
    private RString その他機関名称;

}
