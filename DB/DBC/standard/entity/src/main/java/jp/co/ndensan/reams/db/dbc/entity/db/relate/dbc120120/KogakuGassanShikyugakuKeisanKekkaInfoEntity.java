/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

/**
 * 一覧表作成する項目定義クラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyugakuKeisanKekkaInfoEntity {

    private TempDbWT0001HihokenshaEntity 被保険者entity;
    private DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity 計算結果entity;
}
