/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.util.accesslog;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * アクセスログの{@link ExpandedInformation}を扱います。 介護保険業務内で用いる各拡張情報のコードと名称を管理します。
 * <p/>
 * {@link #fromValue(jp.co.ndensan.reams.uz.uza.lang.RString)}により、値を指定することで、拡張情報を生成します。
 */
public enum ExpandedInfomations {

    /**
     * コード：0001　名称：申請書管理番号
     */
    申請書管理番号("0001", "申請書管理番号"),
    /**
     * コード：0002　名称：証記載保険者番号
     */
    証記載保険者番号("0002", "証記載保険者番号"),
    /**
     * コード：0003　名称：被保険者番号
     */
    被保険者番号("0003", "被保険者番号");
    private final Code aCode;
    private final RString aName;

    private ExpandedInfomations(String aCode, String aName) {
        this.aCode = new Code(aCode);
        this.aName = new RString(aName);
    }

    /**
     * 指定の値を保持した{@link ExpandedInformation}を生成します。
     *
     * @param aValue 拡張情報の値
     * @return {@link ExpandedInformation}
     */
    public ExpandedInformation fromValue(RString aValue) {
        return new ExpandedInformation(this.aCode, this.aName, aValue == null ? RString.EMPTY : aValue);
    }
}
