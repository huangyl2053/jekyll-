/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書発行一覧表Entityです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinOshiraseHeaderEntity {

    private RString 抽出対象期間;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 並び順1;
    private RString 並び順2;
    private RString 並び順3;
    private RString 並び順4;
    private RString 並び順5;
    private RString 印刷時間;
    private KoshinOshiraseTsuchishoHakoEntity tsuchishoHakoEntity;
}
