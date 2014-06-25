/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * AtenaShokaiSimpleクラスを利用するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class AtenaShokaiSimpleAdapter {

    public static void setDemoData(KaigoAtenaInfoDiv div, ShikibetsuCode 識別コード) {
        AtenaShokaiSimple.setData(div.getAtenaInfo(), 識別コード);
    }
}
