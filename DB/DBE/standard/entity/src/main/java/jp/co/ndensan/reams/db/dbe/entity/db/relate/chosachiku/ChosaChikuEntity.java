/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachiku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 地区認定調査員情報を定義したEntityクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ChosaChikuEntity {

    private RString chosaChikuCode;
    private RString shichosonCode;
    private RString shichosonMeisho;
    private int yusenNo;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private RString biko;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
}
