/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報作成エラーリストタイプを表す列挙型です。
 *
 * @reamsid_L DBC-2460-011 jiangwenkai
 */
public enum KokuhorenJoho_SakuseiErrorListType {

    /**
     * コード:0000 名称:リストタイプ0 略称:定義なし
     */
    リストタイプ0("0000", null, null, null, null, null),
    /**
     * コード:0010 名称:リストタイプ1 略称:定義なし
     */
    リストタイプ1("0010", "支給申請書整理番号", "口座ID", null, null, null),
    /**
     * コード:0020 名称:リストタイプ2 略称:定義なし
     */
    リストタイプ2("0020", "支給申請書整理番号", null, null, null, null),
    /**
     * コード:0030 名称:リストタイプ3 略称:定義なし
     */
    リストタイプ3("0030", "交換情報識別番号", "入力識別番号", "サービス提供年月", "事業者番号", "整理番号"),
    /**
     * コード:0040 名称:リストタイプ4 略称:定義なし
     */
    リストタイプ4("0040", "対象年月", "利用年月", "事業者番号", "サービス種類コード", "サービス項目コード"),
    /**
     * コード:0050 名称:リストタイプ5 略称:定義なし
     */
    リストタイプ5("0050", "事業者番号", "サービス提供年月", "サービス種類コード", "サービス項目コード", null);

    private final RString code;
    private final RString キー1;
    private final RString キー2;
    private final RString キー3;
    private final RString キー4;
    private final RString キー5;

    private KokuhorenJoho_SakuseiErrorListType(String code, String キー1, String キー2, String キー3, String キー4, String キー5) {
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
     * 国保連情報作成エラーリストタイプのコードを返します。
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
