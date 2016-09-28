/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010020;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成対象データ取得エンティティのクラスです。
 *
 * @reamsid_L DBC-1970-030 zhouchuanlin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity {

    private DbT3076KogakuJuryoininKeiyakuJigyoshaEntity 高額介護事業者;
    private DbT7060KaigoJigyoshaEntity 介護事業者;
    private DbT7062KaigoJigyoshaDaihyoshaEntity 介護事業者代表者;
    private UaFt250FindAtesakiEntity 宛先;
    private AtenaMeisho 名称;
    private AtenaKanaMeisho カナ名称;
    private FlexibleDate 生年月日;
    private RString 性別;
    private YubinNo 郵便番号;
    private ZenkokuJushoCode 全国住所コード;
    private RString 住民種別コード;
    private GyoseikuCode 行政区コード;
    private AtenaJusho 住所;
    private LasdecCode 市町村コード;
    private ShikibetsuCode 識別コード;
}
