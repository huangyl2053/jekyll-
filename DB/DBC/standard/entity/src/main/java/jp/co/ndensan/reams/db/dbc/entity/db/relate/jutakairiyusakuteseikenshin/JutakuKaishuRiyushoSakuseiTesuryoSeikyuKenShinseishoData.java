/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakairiyusakuteseikenshin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のパラメータクラスです。
 *
 * @reamsid_L DBC-2860-040 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData {

    private RString 請求者_郵便番号;
    private RString 請求者_所在地;
    private RString 請求者_名称;
    private RString 請求者_代表者氏名;
    private RString 請求者_電話番号;
    private RString 通知文;
    private RString 指定事業者番号;
    private Decimal 請求金額;
    private RString 単価;
    private RString 件数;
    private RString 発行日;
    private RString 認証者役職名;
}
