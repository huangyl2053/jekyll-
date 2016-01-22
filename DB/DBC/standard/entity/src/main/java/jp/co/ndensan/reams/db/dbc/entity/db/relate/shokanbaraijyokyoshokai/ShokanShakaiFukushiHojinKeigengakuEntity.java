/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス提供証明書のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShakaiFukushiHojinKeigengakuEntity implements Cloneable, Serializable {

    private DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity;
    private RString serviceShuruiRyakusho;
}
