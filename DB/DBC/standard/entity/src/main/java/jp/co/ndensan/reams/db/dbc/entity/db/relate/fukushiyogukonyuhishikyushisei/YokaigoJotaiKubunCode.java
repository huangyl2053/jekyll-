/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 要介護認定状態区分コード、旧措置者フラグの取得
 *
 * @reamsid_L DBC-1020-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoJotaiKubunCode implements Serializable {

    private Code yokaigoJotaiKubunCode;
    private boolean kyuSochishaFlag;
}
