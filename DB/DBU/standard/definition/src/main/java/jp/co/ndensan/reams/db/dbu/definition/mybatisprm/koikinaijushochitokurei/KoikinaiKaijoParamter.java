/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.koikinaijushochitokurei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 広域内住所地特例者一覧表の広域特解除情報を取得処理のMyBatisパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiKaijoParamter {
    
    private final RString hihokenshaNo;
    private final RString idoYMD;
    private final RString shikakuShutokuYMD;
    
    /**
     * コンストラクタです。
     * @param hihokenshaNo 被保険者番号
     * @param idoYMD 異動日
     * @param shikakuShutokuYMD 資格取得年月日
     */
    public KoikinaiKaijoParamter(RString hihokenshaNo,
            RString idoYMD,
            RString shikakuShutokuYMD) {
        this.hihokenshaNo = hihokenshaNo;
        this.idoYMD = idoYMD;
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }
    
    /**
     * 広域内住所地特例者一覧表の広域特解除情報を取得処理のMyBatisパラメータのcreateです。
     * @param hihokenshaNo 被保険者番号
     * @param idoYMD 異動日
     * @param shikakuShutokuYMD 資格取得年月日
     * @return 広域内住所地特例者一覧表の広域特解除情報を取得処理のMyBatisパラメータ
     */
    public static KoikinaiKaijoParamter createParam(RString hihokenshaNo,
            RString idoYMD,
            RString shikakuShutokuYMD) {
        return new KoikinaiKaijoParamter(hihokenshaNo, idoYMD, shikakuShutokuYMD);
        
    }
}
