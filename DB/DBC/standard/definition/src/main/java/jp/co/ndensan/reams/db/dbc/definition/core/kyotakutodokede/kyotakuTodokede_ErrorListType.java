/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kyotakutodokede;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計画届出状況リストを表す列挙型です。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
public enum kyotakuTodokede_ErrorListType {

    /**
     * コード:0000 名称:リストタイプ0 略称:定義なし
     */
    リストタイプ0("0000", "被保険者情報取得エラー"),
    /**
     * コード:0010 名称:リストタイプ1 略称:定義なし
     */
    リストタイプ1("0010", "宛名取得エラー");

    private final RString code;
    private final RString fullName;

    private kyotakuTodokede_ErrorListType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 計画届出状況リストのコードを返します。
     *
     * @return 計画届出状況リストのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 計画届出状況リストの名称を返します。
     *
     * @return 計画届出状況リストの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 計画届出状況リストのコードと一致する内容を探します。
     *
     * @param code 計画届出状況リストのコード
     * @return {@code code} に対応する計画届出状況リスト
     */
    public static kyotakuTodokede_ErrorListType toValue(RString code) {

        for (kyotakuTodokede_ErrorListType kaigoJotaiKubun : kyotakuTodokede_ErrorListType.values()) {
            if (kaigoJotaiKubun.code.equals(code)) {
                return kaigoJotaiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("計画届出状況リストのコード"));
    }

}
