/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.business.core.dbd5010001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のBussinessです。
 *
 * @author_L DBD-2030-010 x_youyj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinTaishoBussiness {

    private RString 保険者;
    private RString 被保険者被保番号;
    private RString 被保険者氏名;
    private RString 更新対象完了日;
    private RString 更新対象通知年月日;
}
