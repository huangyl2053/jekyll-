/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200007;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 支払方法変更管理リストのItemです。
 *
 * @reamsid_L DBD-3630-050 liangbc
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoKanriIchiranItem {

    RDateTime 作成日時;
    HokenshaNo 保険者番号;
    RString 保険者名称;
    IOutputOrder 出力順;
    ShiharaiHohoHenkoEntity 支払方法変更リストEntity;

}
