/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin;

/**
 * 被保険者一時償還払支給判定結果一時テーブル項目定義クラスです。
 *
 * @reamsid_L DBC-0980-331 chenaoqi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HihokenshaShokanEntity {

    private DbWT0001HihokenshaEntity 被保険者一時Entity;
    private DbWT3036ShokanHanteiKekkaEntity 判定結果一時Entity;
}
