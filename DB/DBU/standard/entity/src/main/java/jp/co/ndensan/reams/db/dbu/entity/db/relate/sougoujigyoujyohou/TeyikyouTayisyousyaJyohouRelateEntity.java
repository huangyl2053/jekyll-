/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.sougoujigyoujyohou;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;

/**
 * 提供基本情報のEntityクラスです。
 *
 * @reamsid_L DBU-4880-080 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TeyikyouTayisyousyaJyohouRelateEntity {

    private KojinNo kojinNo;
    private TeikyoKihonJohoNNTempEntity teikyoKihonJohoNNTempEntity;
}
