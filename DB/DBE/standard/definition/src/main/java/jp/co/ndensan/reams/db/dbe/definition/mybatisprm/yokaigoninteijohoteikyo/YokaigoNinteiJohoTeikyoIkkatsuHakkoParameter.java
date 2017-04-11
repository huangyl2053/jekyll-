/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定情報提供一括発行のMyBatis用パラメータクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter {

    private final RString 保険者番号;
    private final boolean use二次判定日;
    private final RString 二次判定日From;
    private final RString 二次判定日To;
    private final boolean use被保険者番号;
    private final RString 被保険者番号;
    private final boolean include被保険者未同意;
    private final int 最大表示件数;
    private final RString 通常;
    private final RString 延期;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param use二次判定日 use二次判定日
     * @param 二次判定日From 二次判定日From
     * @param 二次判定日To 二次判定日To
     * @param use被保険者番号 use被保険者番号
     * @param 被保険者番号 被保険者番号
     * @param include被保険者未同意 include被保険者未同意
     * @param 最大表示件数 最大表示件数
     */
    public YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter(RString 保険者番号,
            boolean use二次判定日, RString 二次判定日From, RString 二次判定日To, boolean use被保険者番号,
            RString 被保険者番号, boolean include被保険者未同意, int 最大表示件数) {
        this.保険者番号 = 保険者番号;
        this.use二次判定日 = use二次判定日;
        this.二次判定日From = 二次判定日From;
        this.二次判定日To = 二次判定日To;
        this.use被保険者番号 = use被保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.include被保険者未同意 = include被保険者未同意;
        this.最大表示件数 = 最大表示件数;
        this.通常 = ShoriJotaiKubun.通常.getコード();
        this.延期 = ShoriJotaiKubun.延期.getコード();
    }
}
