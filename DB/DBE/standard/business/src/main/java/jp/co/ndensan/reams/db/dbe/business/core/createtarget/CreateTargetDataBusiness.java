/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * センター送信Csvデータ出力情報ビジネスクラスです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateTargetDataBusiness {

    private CreateTargetCsvBusiness csvBusiness;
    private List<CreateTargetBusiness> 主治医意見書;
    private List<CreateTargetBusiness> サービスの状況;
    private List<CreateTargetBusiness> 調査票調査項目;
    private List<CreateTargetBusiness> 前回調査票調査項目;
    private List<CreateTargetBusiness> 前回サービスの状況;
}
