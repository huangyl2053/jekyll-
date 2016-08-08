/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kaigofukachoshuyuyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護保険料徴収猶予保存処理用のパラメータです。
 *
 * @reamsid_L DBB-1680-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKibetsuChoshuYuyoParam {

    private int 期;
    private FlexibleDate 徴収猶予開始日;
    private FlexibleDate 徴収猶予終了日;
}
