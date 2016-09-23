/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kanri.chohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 表示コード情報です。
 *
 * @reamsid_L DBB-1840-080 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HyojiCodes {

    private RString 表示コード１;
    private RString 表示コード名１;
    private RString 表示コード２;
    private RString 表示コード名２;
    private RString 表示コード３;
    private RString 表示コード名３;

}
