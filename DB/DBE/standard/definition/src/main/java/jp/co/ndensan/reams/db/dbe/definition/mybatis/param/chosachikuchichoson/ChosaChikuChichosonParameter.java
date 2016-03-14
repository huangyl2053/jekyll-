/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikuchichoson;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査地区市町村情報のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaChikuChichosonParameter {

    private RString chosaChikuCode;
    private RString shichosonCode;
}
