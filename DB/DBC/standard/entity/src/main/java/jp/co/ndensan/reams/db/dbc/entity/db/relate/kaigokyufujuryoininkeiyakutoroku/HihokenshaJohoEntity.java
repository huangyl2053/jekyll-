/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku;

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
 * 被保険者情報Entityクラスです。
 *
 * @reamsid_L DBC-2130-050 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaJohoEntity {

    private LasdecCode 市町村コード;
    private ShikibetsuCode 識別コード;
    private AtenaKanaMeisho 名称カナ;
    private AtenaMeisho 名称漢字;
    private FlexibleDate 生年月日;
    private RString 性別;
    private YubinNo 郵便番号;
    private ZenkokuJushoCode 全国住所コード;
    private GyoseikuCode 行政区コード;
    private RString 住民種別コード;
    private AtenaJusho 住所;
}
