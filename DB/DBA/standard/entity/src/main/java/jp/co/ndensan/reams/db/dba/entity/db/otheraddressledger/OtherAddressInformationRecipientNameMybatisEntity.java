/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名識別対象PSMのエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OtherAddressInformationRecipientNameMybatisEntity {

    private AtenaKanaMeisho カナ名称;
    private AtenaMeisho 氏名;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private SetaiCode 世帯コード;
    private ShikibetsuCode 識別コード;
    private RString 地区名１;
    private RString 地区名２;
    private RString 地区名３;
    private ChikuCode 地区コード１;
    private ChikuCode 地区コード２;
    private ChikuCode 地区コード３;
    private AtenaJusho 住所;
    private ZenkokuJushoCode 住所コード;
    private GyoseikuCode 行政区コード;
    private ZenkokuJushoCode 前住所コード;
    private AtenaJusho 前住所;
    private FlexibleDate 転入年月日;
    private FlexibleDate 転出年月日;
    private RString 連絡先;

}
