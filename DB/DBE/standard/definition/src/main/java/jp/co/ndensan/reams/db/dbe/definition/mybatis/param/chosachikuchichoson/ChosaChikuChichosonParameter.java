/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikuchichoson;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール登録7のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaChikuChichosonParameter {

    private final RString chosaChikuCode;
    private final RString shichosonCode;

    private ChosaChikuChichosonParameter(
            RString chosaChikuCode,
            RString shichosonCode) {
        this.chosaChikuCode = chosaChikuCode;
        this.shichosonCode = shichosonCode;
    }

    /**
     * パラメーターを作成します。
     *
     * @param chosaChikuCode 調査地区コード
     * @param shichosonCode 市町村コード
     * @return ChosaChikuChichosonParameter
     */
    public static ChosaChikuChichosonParameter createParameter(
            RString chosaChikuCode,
            RString shichosonCode) {
        return new ChosaChikuChichosonParameter(
                chosaChikuCode,
                shichosonCode);
    }
}
