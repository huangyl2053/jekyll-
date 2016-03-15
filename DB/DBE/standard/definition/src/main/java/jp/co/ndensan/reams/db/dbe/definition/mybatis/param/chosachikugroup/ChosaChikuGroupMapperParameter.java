/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikugroup;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 認定調査スケジュール登録8のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChosaChikuGroupMapperParameter {

    private final Code chosaChikuGroupCode;
    private final Code chosachikucode;
    private final LasdecCode shichosonCode;

    /**
     * コンストラクタです。
     *
     * @param chosaChikuGroupCode 調査地区グループコード
     * @param chosachikucode 調査地区コード
     * @param shichosonCode 市町村コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ChosaChikuGroupMapperParameter(Code chosaChikuGroupCode,
            Code chosachikucode,
            LasdecCode shichosonCode) {

        this.chosaChikuGroupCode = chosaChikuGroupCode;
        this.chosachikucode = chosachikucode;
        this.shichosonCode = shichosonCode;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param chosaChikuGroupCode 調査地区グループコード
     * @param chosachikucode 調査地区コード
     * @param shichosonCode 市町村コード
     * @return 認定調査スケジュール登録8検索パラメータ
     */
    public static ChosaChikuGroupMapperParameter createSelectByKeyParam(Code chosaChikuGroupCode,
            Code chosachikucode,
            LasdecCode shichosonCode) {
        return new ChosaChikuGroupMapperParameter(chosaChikuGroupCode, chosachikucode, shichosonCode);
    }
}
