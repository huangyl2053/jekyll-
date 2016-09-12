/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認証者・電子公印Entityです。
 *
 * @reamsid_L DBU-1080-010 zhengshukai
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinshoshaDenshiKoinDataEntity {

    private RString 認証者役職名;
    private RString 認職者氏名;
    private RString 電子公印;
    private RString 公印省略;
    private RString 公印文字列;
}
