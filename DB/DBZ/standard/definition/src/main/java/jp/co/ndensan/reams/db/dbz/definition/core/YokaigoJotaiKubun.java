/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.definition.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *要介護状態区分の列挙型です。
 * 
 * @author n8407 陳
 * 
 * @jpName
 * @bizDomain
 * @category
 * @subCategory
 * @mainClass
 * @reference
 * 
 */
public enum YokaigoJotaiKubun implements IYokaigoJotaiKubun{

    /**
     * 要介護状態区分が「事業対象者」であることを表します。<br />
     * コード：06
     */
    事業対象者("06");
    
    private final RString code;
    private final RString name;

    private YokaigoJotaiKubun(String code) {
        this.code = new RString(code);
        this.name = new RString(this.name());
    }

    @Override
    public RString getCode() {
        return code;
    }

    @Override
    public RString getName() {
        return name;
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     * @throws IllegalArgumentException 変換不可の場合
     */
    public static YokaigoJotaiKubun toValue(RString code) throws IllegalArgumentException {
        for (YokaigoJotaiKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護状態区分"));
    }
}
