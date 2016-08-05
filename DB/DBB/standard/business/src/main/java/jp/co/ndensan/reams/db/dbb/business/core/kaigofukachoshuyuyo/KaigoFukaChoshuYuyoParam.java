/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kaigofukachoshuyuyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険料徴収猶予保存処理用のパラメータです。
 *
 * @reamsid_L DBB-1680-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoFukaChoshuYuyoParam {

    private RString 状況;
    private boolean 決定区分;
    private FlexibleDate 申請日;
    private FlexibleDate 決定日;
    private FlexibleDate 取消日;
    private RString 申請事由;
    private Code 徴収猶予種類コード;
    private RString 徴収猶予事由;
    private Code 徴収猶予取消種類コード;
    private RString 徴収猶予取消事由;
    private List<KaigoKibetsuChoshuYuyoParam> 介護期別徴収猶予データ;
}
