/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定申請者を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class YokaigoBatchMybitisParamter implements IMyBatisParameter {

    private final List<RString> 申請書管理番号List;
    private final RString 特記事項_フラグ;
    private final RString 原本マスク区分;

    private YokaigoBatchMybitisParamter(List<RString> 申請書管理番号List, RString 特記事項_フラグ, RString 原本マスク区分) {
        this.申請書管理番号List = 申請書管理番号List;
        this.特記事項_フラグ = 特記事項_フラグ;
        this.原本マスク区分 = 原本マスク区分;
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return YokaigoBatchMybitisParamter
     */
    public static YokaigoBatchMybitisParamter createParam(ShinseishoKanriNo 申請書管理番号) {
        List<RString> 申請書管理番号List = new ArrayList<>();
        申請書管理番号List.add(申請書管理番号.value());
        return new YokaigoBatchMybitisParamter(申請書管理番号List, RString.EMPTY, RString.EMPTY);
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 特記事項_フラグ 特記事項_フラグ
     * @return YokaigoBatchMybitisParamter
     */
    public static YokaigoBatchMybitisParamter createParam(RString 申請書管理番号, RString 特記事項_フラグ) {
        List<RString> 申請書管理番号List = new ArrayList<>();
        申請書管理番号List.add(申請書管理番号);
        RString 原本マスク区分 = GenponMaskKubun.原本.getコード();
        if (特記事項_フラグ.equals(new RString("1"))) {
            原本マスク区分 = GenponMaskKubun.マスク.getコード();
        }
        return new YokaigoBatchMybitisParamter(申請書管理番号List, 特記事項_フラグ, 原本マスク区分);
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号List 申請書管理番号のリスト
     * @param 特記事項_フラグ 特記事項_フラグ
     * @return YokaigoBatchMybitisParamter
     */
    public static YokaigoBatchMybitisParamter createParam(List<RString> 申請書管理番号List, RString 特記事項_フラグ) {
        RString 原本マスク区分 = GenponMaskKubun.原本.getコード();
        if (特記事項_フラグ.equals(new RString("1"))) {
            原本マスク区分 = GenponMaskKubun.マスク.getコード();
        }
        return new YokaigoBatchMybitisParamter(申請書管理番号List, 特記事項_フラグ, 原本マスク区分);
    }
}
