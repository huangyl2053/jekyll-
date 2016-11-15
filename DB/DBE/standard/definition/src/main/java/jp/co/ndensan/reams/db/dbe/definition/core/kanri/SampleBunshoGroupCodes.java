/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.core.kanri;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public enum SampleBunshoGroupCodes {
    
    
    /**
     * コード:5001 名称:調査票概況調査特記事項 略称:定義なし
     */
    調査票概況調査特記事項("5001", "調査票概況調査特記事項"),
    
    
    /**
     * コード:5010 名称:調査票概況特記住宅改修 略称:定義なし
     */
    調査票概況特記住宅改修("5010", "調査票概況特記住宅改修"),
    
    
    /**
     * コード:5011 名称:調査票概況特記主訴 略称:定義なし
     */
    調査票概況特記主訴("5011", "調査票概況特記主訴"),
    
    
    /**
     * コード:5012 名称:調査票概況特記家族状況 略称:定義なし
     */
    調査票概況特記家族状況("5012", "調査票概況特記家族状況"),
    
    
    /**
     * コード:5013 名称:調査票概況特記居住環境 略称:定義なし
     */
    調査票概況特記居住環境("5013", "調査票概況特記居住環境"),
    
    
    /**
     * コード:5014 名称:調査票概況特記機器器械 略称:定義なし
     */
    調査票概況特記機器器械("5014", "調査票概況特記機器器械"),
    
    /**
     * コード:5015 名称:調査票調査項目特記事項 略称:定義なし
     */
    調査票調査項目特記事項("5015", "調査票調査項目特記事項");
   
    private final RString code;
    private final RString fullName;

    private SampleBunshoGroupCodes(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サンプル文書グループコードのコードを返します。
     *
     * @return サンプル文書グループコードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サンプル文書グループコードの名称を返します。
     *
     * @return サンプル文書グループコードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サンプル文書グループコードのコードと一致する内容を探します。
     *
     * @param code サンプル文書グループコードのコード
     * @return {@code code} に対応するサンプル文書グループコード
     */
    public static SampleBunshoGroupCodes toValue(RString code) {
        for (SampleBunshoGroupCodes sampleBunshoGroupCode : SampleBunshoGroupCodes.values()) {
            if (sampleBunshoGroupCode.code.equals(code)) {
                return sampleBunshoGroupCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サンプル文書グループコード"));
    }
}
