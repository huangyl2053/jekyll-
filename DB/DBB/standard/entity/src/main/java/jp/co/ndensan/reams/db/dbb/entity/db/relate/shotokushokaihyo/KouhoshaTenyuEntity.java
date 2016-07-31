/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 候補者（転入者）
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KouhoshaTenyuEntity {

    private RString 候補者区分;
    private ShikibetsuCode 識別コード;
    private RString 住民種別コード;
    private AtenaMeisho 名称;
    private AtenaKanaMeisho カナ名称;
    private RString 管内管外区分;
    private YubinNo 郵便番号;
    private RString 町域コード;
    private RString 全国住所コード;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 行政区コード;
    private RString 地区コード１;
    private RString 地区コード２;
    private RString 地区コード３;
    private RString 住民状態コード;
    private SetaiCode 世帯コード;
    private FlexibleDate 生年月日;
    private FlexibleDate 登録異動年月日;
    private RString 転入前全国住所コード;
    private RString 転入前住所;
    private RString 転入前番地;
    private RString 転入前方書;
    private RString 登録事由コード;
    private FlexibleDate min登録異動年月日;
}
