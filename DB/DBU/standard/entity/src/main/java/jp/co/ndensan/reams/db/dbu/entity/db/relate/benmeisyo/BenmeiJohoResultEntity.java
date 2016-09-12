/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明情報取得のマッパーの戻るEntityです。
 *
 * @reamsid_L DBU-1080-010 zhengshukai
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BenmeiJohoResultEntity {

    private RString 処分種類コード;
    private FlexibleDate 弁明書作成日;
    private RString 弁明内容;

}
