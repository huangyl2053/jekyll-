/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachikuchichoson;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査地区市町村情報を定義したEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ChosaChikuChichosonRelateEntity {

    private int yusenNo;
    private RString shichosonCode;
    private boolean jiChikuFlag;
    private RString shichosonMeisho;
}
