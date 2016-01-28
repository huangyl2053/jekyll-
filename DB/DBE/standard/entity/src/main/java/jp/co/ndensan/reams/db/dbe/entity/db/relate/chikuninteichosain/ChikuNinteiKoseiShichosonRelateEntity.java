/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChikuNinteiKoseiShichosonRelateEntity {

    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private Code chosaChikuCode;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private RString shichosonShokibetsuID;
}
