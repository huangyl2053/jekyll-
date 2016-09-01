/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新申請のお知らせ通知書発行一覧表のEntityです。
 *
 * @reamsid_L DBD-1400-030 b_zhengs
 */
@Getter
@Setter
public class UpdateShenqingEntity {

    private RString 抽出対象期間;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 並び順1;
    private RString 並び順2;
    private RString 並び順3;
    private RString 並び順4;
    private RString 並び順5;
    private RString 印刷時間;
}
