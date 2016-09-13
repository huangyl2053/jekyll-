/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_エラーリストタイプ列挙型です。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
public enum KaigoGassan_ErrorListType {

    /**
     * コード:0000 名称:リストタイプ0 略称:定義なし
     */
    リストタイプ0("0000", null, null, null, null, null),
    /**
     * コード:0010 名称:リストタイプ1 略称:定義なし
     */
    リストタイプ1("0010", "被保険者番号", null, null, null, null),
    /**
     * コード:0020 名称:リストタイプ2 略称:定義なし
     */
    リストタイプ2("0020", "被保険者番号", null, null, null, null),
    /**
     * コード:0030 名称:リストタイプ3 略称:定義なし
     */
    リストタイプ3("0030", "被保険者番号", null, null, null, null);

    private final RString code;
    private final RString キー1;
    private final RString キー2;
    private final RString キー3;
    private final RString キー4;
    private final RString キー5;

    private KaigoGassan_ErrorListType(String code, String キー1, String キー2, String キー3, String キー4, String キー5) {
        this.code = new RString(code);
        this.キー1 = getNotNull(キー1);
        this.キー2 = getNotNull(キー2);
        this.キー3 = getNotNull(キー3);
        this.キー4 = getNotNull(キー4);
        this.キー5 = getNotNull(キー5);
    }

    private RString getNotNull(String キー) {
        return (null == キー) ? RString.EMPTY : new RString(キー);
    }

    /**
     * 国保連情報取込エラーリストタイプのコードを返します。
     *
     * @return 国保連情報取込エラーリストタイプのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * キー1の名称を返します。
     *
     * @return キー1の名称
     */
    public RString getキー1() {
        return キー1;
    }

    /**
     * キー2の名称を返します。
     *
     * @return キー1の名称
     */
    public RString getキー2() {
        return キー2;
    }

    /**
     * キー3の名称を返します。
     *
     * @return キー1の名称
     */
    public RString getキー3() {
        return キー3;
    }

    /**
     * キー4の名称を返します。
     *
     * @return キー1の名称
     */
    public RString getキー4() {
        return キー4;
    }

    /**
     * キー5の名称を返します。
     *
     * @return キー1の名称
     */
    public RString getキー5() {
        return キー5;
    }

}
