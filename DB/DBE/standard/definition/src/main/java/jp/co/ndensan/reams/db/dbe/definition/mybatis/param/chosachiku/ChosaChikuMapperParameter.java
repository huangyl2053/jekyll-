/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachiku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール登録5を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaChikuMapperParameter {

    private RString chosaChikuCode;
    private RString shichosonCode;
    private RString ninteiChosainCode;
    private RString ninteiChosaItakusakiCode;
}
