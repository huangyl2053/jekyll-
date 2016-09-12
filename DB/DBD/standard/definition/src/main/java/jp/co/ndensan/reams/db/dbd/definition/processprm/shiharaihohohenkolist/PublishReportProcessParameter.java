/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.shiharaihohohenkolist;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更管理リスト作成用のパラメータクラスです。
 *
 * @reamsid_L DBD-3630-010 liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PublishReportProcessParameter {

    private FlexibleDate 基準日;
}
