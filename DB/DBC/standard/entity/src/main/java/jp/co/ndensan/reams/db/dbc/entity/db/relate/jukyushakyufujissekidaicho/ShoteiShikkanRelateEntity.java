/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の所定疾患施設療養費RelateEntityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoteiShikkanRelateEntity {

    private RString dbT3118_ryakusho;
    private DbT3017KyufujissekiKihonEntity dbt3017;
    private DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity dbt3032;

}
