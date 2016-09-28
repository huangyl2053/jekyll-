/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutariyutesuseikenshinichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のパラメータクラスです。
 *
 * @reamsid_L DBC-2860-050 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData {

    private RString 総ページ;
    private FlexibleDate 作成年月日;
    private RString 事業者名;
    private FlexibleDate 集計期間開始;
    private FlexibleDate 集計期間終了;
    private RString 連番;
    private FlexibleDate 理由書作成日;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 改修先住所;
    private RString 工事の種類;
    private RString 理由書作成者;
    private RString 備考;

}
