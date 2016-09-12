package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosaocrtorikomi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会審査結果登録（OCR)のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ChosaOCRTorikomiParameter {

    private final RString 介護認定審査会開催番号;
    private final RString 保険者番号;
    private final RString 被保険者番号;
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();

    private ChosaOCRTorikomiParameter(RString 介護認定審査会開催番号,
            RString 保険者番号,
            RString 被保険者番号) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
        this.保険者番号 = 保険者番号;
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @return 介護認定審査会審査結果パラメータ
     */
    public static ChosaOCRTorikomiParameter createParam(
            RString 介護認定審査会開催番号,
            RString 保険者番号,
            RString 被保険者番号) {
        return new ChosaOCRTorikomiParameter(介護認定審査会開催番号,
                保険者番号,
                被保険者番号);
    }
}
