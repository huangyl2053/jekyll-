/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のmybatisprmです。
 *
 * @reamsid_L DBD-2030-010 x_youyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaDataMobileMybatisParameter {

    private List<RString> 申請書管理番号;
    private RString 概況調査テキストイメージ区分;
    private RString 特記事項テキストイメージ区分;
    private RString 処理状態区分;

    /**
     * @param 申請書管理番号 申請書管理番号
     */
    public ChosaDataMobileMybatisParameter(List<RString> 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
        this.概況調査テキストイメージ区分 = DbBusinessConfig.get(
                ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        this.特記事項テキストイメージ区分 = DbBusinessConfig.get(
                ConfigNameDBE.特記事項テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }
}
