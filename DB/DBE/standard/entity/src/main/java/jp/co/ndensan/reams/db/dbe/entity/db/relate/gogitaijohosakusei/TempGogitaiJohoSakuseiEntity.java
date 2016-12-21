/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import lombok.Getter;
import lombok.Setter;

/**
 * 合議体情報作成一時テーブルのEntityクラスです。
 *
 * @author n3304 岡澤 政幸
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TempGogitaiJohoSakuseiEntity {

    private TempGogitaiJohoSakusei 合議体情報作成Temp;

    /**
     * コンストラクタです。
     */
    public TempGogitaiJohoSakuseiEntity() {
        this.合議体情報作成Temp = new TempGogitaiJohoSakusei();
    }

}
