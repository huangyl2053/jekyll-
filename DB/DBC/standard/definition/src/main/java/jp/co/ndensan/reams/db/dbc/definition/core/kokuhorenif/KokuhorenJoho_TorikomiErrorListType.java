package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報取込エラーリストタイプを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhangrui
 */
public enum KokuhorenJoho_TorikomiErrorListType {

    /**
     * コード:0010 名称:リストタイプ1 略称:定義なし
     */
    リストタイプ1("0010", "サービス提供年月", null, null, null, null),
    /**
     * コード:0020 名称:リストタイプ2 略称:定義なし
     */
    リストタイプ2("0020", "サービス提供年月", "整理番号", null, null, null);

    private final RString code;
    private final RString キー1;
    private final RString キー2;
    private final RString キー3;
    private final RString キー4;
    private final RString キー5;

    private KokuhorenJoho_TorikomiErrorListType(String code, String キー1, String キー2, String キー3, String キー4, String キー5) {
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
