/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.hikazeinenkintaishoshaJoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報取込を取得するEntityクラスです。
 *
 * @reamsid_L DBB-4910-010 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNenkinTaishoshaJohoBusiness {

    private RString 月;
    private RString 月コード;
    private RString 処理;
    private RString 処理コード;
    private RString 処理状態コード;
    private RString 処理状態;
    private RString 処理日時;
    private RString 対象ファイル;
}
