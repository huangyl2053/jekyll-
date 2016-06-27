/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shoridatekanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 今回処理内容情報取得 Entity
 *
 * @reamsid_L DBB-1850-030 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KonkaiShoriNaiyoJohoEntity {

    private RString 年度内連番;
    private RString 対象者情報取得月;
    private RString 捕捉月１;
    private RString 捕捉月２;
    private RString 捕捉月３;
    private RString 特別徴収開始月;
}
