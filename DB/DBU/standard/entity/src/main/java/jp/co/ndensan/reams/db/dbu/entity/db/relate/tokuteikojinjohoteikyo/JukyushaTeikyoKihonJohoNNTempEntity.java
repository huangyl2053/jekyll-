package jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.uz.uza.biz.KojinNo;

/**
 * 提供基本情報nn一時テーブルです。
 *
 * @reamsid_L DBU-4880-050 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeikyoKihonJohoNNTempEntity {

    private TeikyoKihonJohoNNTempEntity teikyoJohoKohoEntity;
    private KojinNo kojinNoPSM;
}
