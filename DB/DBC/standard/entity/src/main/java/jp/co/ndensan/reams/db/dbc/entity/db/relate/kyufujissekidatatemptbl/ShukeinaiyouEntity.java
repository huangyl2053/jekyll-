/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 集計内容のEntity
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShukeinaiyouEntity {

    private int 人数;
    private int 費用総額;
    private RString ページNo;
    private RString 所得段階;
    private RString 要介護状態区分コード;
    private RString 集計内容;
}
