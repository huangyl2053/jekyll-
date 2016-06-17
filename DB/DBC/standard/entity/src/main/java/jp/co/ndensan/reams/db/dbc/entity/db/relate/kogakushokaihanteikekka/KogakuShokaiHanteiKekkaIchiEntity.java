/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaihanteikekka;

import java.util.List;

/**
 * ビジネス設計_DBCMN11004_世帯合算並列表示（画面）のXML返したEntityです。
 *
 * @reamsid_L DBC-3000-050 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShokaiHanteiKekkaIchiEntity {

    /**
     * -- GETTER -- 高額判定結果_決定情報Listを返します。
     *
     * @return 高額判定結果_決定情報List -- SETTER -- 高額判定結果_決定情報Listを設定します。
     *
     * @param 高額判定結果_決定情報List 高額判定結果_決定情報List
     */
    private List<KogakuShokaiHanteiKekkaEntity> 高額判定結果_決定情報List;
}
