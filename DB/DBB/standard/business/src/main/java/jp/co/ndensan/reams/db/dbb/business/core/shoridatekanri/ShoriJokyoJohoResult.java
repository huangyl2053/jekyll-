/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理状況一覧情報Result
 *
 * @reamsid_L DBB-1850-030 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriJokyoJohoResult {

    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RString 処理名;
    private FlexibleDate 基準年月日;
    private YMDHMS 基準日時;
}
