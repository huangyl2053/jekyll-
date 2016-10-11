/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import java.io.Serializable;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * 帳票出力情報を取得用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServiceReportEntity implements Serializable {

    private YubinNo 郵便番号;
    private ChoikiCode 町域コード;
    private GyoseikuCode 行政区コード;
    private AtenaKanaMeisho カナ名称;
    private KetteiTsuchishoInfoTempEntity 一時Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
    private TokuteiKozaRelateEntity 口座;

}
