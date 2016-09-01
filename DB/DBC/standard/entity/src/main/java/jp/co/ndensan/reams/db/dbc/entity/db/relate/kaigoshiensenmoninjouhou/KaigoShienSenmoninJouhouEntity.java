/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigoshiensenmoninjouhou;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護支援専門員登録画面 Entityクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoShienSenmoninJouhouEntity {

    private DbT7064CareManegerEntity careManegerentity;
    private RString shozokuJigyoshaNo;
    private RString shozokuJigyoshaMei;
}
