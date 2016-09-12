/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosairai;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・認定調査依頼のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaIraiParameter {

    private RString 保険者番号;
    private RString 地区コード;
    private RString 申請書管理番号;
    private RString 概況調査テキストイメージ区分;
    private RString 処理状態区分通常;
    private RString 処理状態区分延期;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 地区コード 地区コード
     * @param 申請書管理番号 申請書管理番号
     * @param 概況調査テキストイメージ区分 概況調査テキストイメージ区分
     * @param 処理状態区分通常 処理状態区分通常
     * @param 処理状態区分延期 処理状態区分延期
     */
    public NinteichosaIraiParameter(
            RString 保険者番号,
            RString 地区コード,
            RString 申請書管理番号,
            RString 概況調査テキストイメージ区分,
            RString 処理状態区分通常,
            RString 処理状態区分延期) {
        this.保険者番号 = 保険者番号;
        this.地区コード = 地区コード;
        this.申請書管理番号 = 申請書管理番号;
        this.概況調査テキストイメージ区分 = 概況調査テキストイメージ区分;
        this.処理状態区分通常 = 処理状態区分通常;
        this.処理状態区分延期 = 処理状態区分延期;
    }

}
