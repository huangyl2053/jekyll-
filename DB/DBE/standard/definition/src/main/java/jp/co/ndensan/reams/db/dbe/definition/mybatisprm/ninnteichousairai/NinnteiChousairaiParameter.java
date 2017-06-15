/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NinnteiChousairaiParameter {

    private final List<RString> 判定結果コードs_再調査 = Arrays.<RString>asList(
            HanteiKekkaCode.再調査_調査のみ.getコード(),
            HanteiKekkaCode.再調査_調査_意見書.getコード()
    );
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final RString 支所コード;
    private final LasdecCode 市町村コード;
    private final ChosaItakusakiCode 認定調査委託先コード;
    private final ChosainCode 認定調査員コード;
    private final boolean uses支所コード;
    private final boolean uses調査員コード;
    private final RString 依頼件数集計開始日;
    private final RString 依頼件数集計終了日;
    private final int 最大表示件数;

    private NinnteiChousairaiParameter(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード,
            RString 依頼件数集計開始日,
            RString 依頼件数集計終了日,
            int 最大表示件数) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.支所コード = 支所コード;
        this.市町村コード = 市町村コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.uses支所コード = !RString.isNullOrEmpty(支所コード);
        this.uses調査員コード = (認定調査員コード != null && !RString.isNullOrEmpty(認定調査員コード.value()));
        this.依頼件数集計開始日 = 依頼件数集計開始日;
        this.依頼件数集計終了日 = 依頼件数集計終了日;
        this.最大表示件数 = 最大表示件数;
    }

    /**
     * 認定調査委託先のパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 依頼件数集計開始日 依頼件数集計開始日
     * @param 依頼件数集計終了日 依頼件数集計終了日
     * @param 最大表示件数 最大表示件数
     * @return 認定調査委託先情報パラメータ
     */
    public static NinnteiChousairaiParameter createParam調査委託先(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            RDate 依頼件数集計開始日,
            RDate 依頼件数集計終了日,
            int 最大表示件数) {
        return new NinnteiChousairaiParameter(ShoKisaiHokenshaNo.EMPTY, RString.EMPTY, 市町村コード, 認定調査委託先コード, ChosainCode.EMPTY,
                依頼件数集計開始日.toDateString(), 依頼件数集計終了日.toDateString(), 最大表示件数);
    }

    /**
     * 未割付申請者のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 市町村コード 市町村コード
     * @return 認定調査委託先情報パラメータ
     */
    public static NinnteiChousairaiParameter createParam未割付申請者(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            LasdecCode 市町村コード) {
        return new NinnteiChousairaiParameter(証記載保険者番号, 支所コード, 市町村コード,
                ChosaItakusakiCode.EMPTY, ChosainCode.EMPTY, RString.EMPTY, RString.EMPTY, 0);
    }

    /**
     * 調査員情報のパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 調査員情報パラメータ
     */
    public static NinnteiChousairaiParameter createParamfor調査員情報(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード) {
        return new NinnteiChousairaiParameter(ShoKisaiHokenshaNo.EMPTY, RString.EMPTY, 市町村コード, 認定調査委託先コード,
                ChosainCode.EMPTY, RString.EMPTY, RString.EMPTY, 0);
    }

    /**
     * 割付済み申請者一覧のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return 割付済み申請者一覧パラメータ
     */
    public static NinnteiChousairaiParameter createParamfor割付済み申請者一覧(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード) {
        return new NinnteiChousairaiParameter(証記載保険者番号, 支所コード, 市町村コード, 認定調査委託先コード,
                認定調査員コード, RString.EMPTY, RString.EMPTY, 0);
    }

}
