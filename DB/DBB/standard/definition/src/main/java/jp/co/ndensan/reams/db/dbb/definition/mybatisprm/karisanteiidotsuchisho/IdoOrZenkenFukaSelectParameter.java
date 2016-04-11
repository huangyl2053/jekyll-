/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho;

import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.karisanteiidotsuchisho.SeikatsuHogoTaishosha;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.karisanteiidotsuchisho.TaishoshaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.NonNull;

/**
 * 異動賦課情報一時テーブルOR全件賦課情報一時テーブルの全項目取得するパラメータです。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IdoOrZenkenFukaSelectParameter {

    private static final int 出力期1 = 1;
    private static final int 出力期2 = 2;
    private static final int 出力期3 = 3;
    private static final int 出力期4 = 4;
    private static final int 出力期5 = 5;
    private static final int 出力期6 = 6;
    private static final int 出力期7 = 7;
    private static final int 出力期8 = 8;
    private static final int 出力期9 = 9;
    private static final int 出力期10 = 10;
    private static final int 出力期11 = 11;
    private static final int 出力期12 = 12;
    private static final int 出力期13 = 13;
    private static final int 出力期14 = 14;
    private static final RString 口座区分_現金納付 = new RString("0");
    private static final RString 口座区分_口座振替者 = new RString("1");
    private static final RString 処理対象N_全件対象 = new RString("1");
    private static final RString 処理対象N_異動分対象 = new RString("2");
    private static final RString 通知書プリント条件N_全被保険者 = new RString("1");
    private static final RString 通知書プリント条件N_差引き保険料１円以上 = new RString("2");
    private static final RString 通知書プリント条件N_保険料変更有り = new RString("3");

    private final boolean is出力期_1;
    private final boolean is出力期_2;
    private final boolean is出力期_3;
    private final boolean is出力期_4;
    private final boolean is出力期_5;
    private final boolean is出力期_6;
    private final boolean is出力期_7;
    private final boolean is出力期_8;
    private final boolean is出力期_9;
    private final boolean is出力期_10;
    private final boolean is出力期_11;
    private final boolean is出力期_12;
    private final boolean is出力期_13;
    private final boolean is出力期_14;
    private final boolean is対象者区分_すべて選択;
    private final boolean is対象者区分_現金納付者;
    private final boolean is対象者区分_口座振替者;
    private final boolean is処理対象N_全件対象;
    private final boolean is処理対象N_異動分対象;
    private final boolean is通知書プリント条件N_全被保険者;
    private final boolean is通知書プリント条件N_差引き保険料１円以上;
    private final boolean is通知書プリント条件N_保険料変更有り;
    private final boolean is生活保護対象者_する;
    private final boolean is生活保護対象者_しない;
    private final int 出力期;
    private final RString 口座区分;
    private final TaishoshaKubun 対象者区分;
    private final RString 出力順;
    private final SeikatsuHogoTaishosha 生活保護対象者;
    private final RString 処理対象N;
    private final RString 通知書プリント条件N;

    private IdoOrZenkenFukaSelectParameter(
            int 出力期,
            @NonNull TaishoshaKubun 対象者区分,
            @NonNull RString 出力順,
            @NonNull SeikatsuHogoTaishosha 生活保護対象者,
            @NonNull RString 処理対象N,
            @NonNull RString 通知書プリント条件N) {
        this.出力期 = 出力期;
        this.対象者区分 = 対象者区分;
        this.出力順 = 出力順;
        is出力期_1 = 出力期1 >= 出力期;
        is出力期_2 = 出力期2 >= 出力期;
        is出力期_3 = 出力期3 >= 出力期;
        is出力期_4 = 出力期4 >= 出力期;
        is出力期_5 = 出力期5 >= 出力期;
        is出力期_6 = 出力期6 >= 出力期;
        is出力期_7 = 出力期7 >= 出力期;
        is出力期_8 = 出力期8 >= 出力期;
        is出力期_9 = 出力期9 >= 出力期;
        is出力期_10 = 出力期10 >= 出力期;
        is出力期_11 = 出力期11 >= 出力期;
        is出力期_12 = 出力期12 >= 出力期;
        is出力期_13 = 出力期13 >= 出力期;
        is出力期_14 = 出力期14 >= 出力期;
        is対象者区分_すべて選択 = TaishoshaKubun.すべて選択.equals(対象者区分);
        is対象者区分_口座振替者 = TaishoshaKubun.口座振替者.equals(対象者区分);
        is対象者区分_現金納付者 = TaishoshaKubun.現金納付者.equals(対象者区分);
        is生活保護対象者_する = SeikatsuHogoTaishosha.する.equals(生活保護対象者);
        is生活保護対象者_しない = SeikatsuHogoTaishosha.しない.equals(生活保護対象者);
        is処理対象N_全件対象 = 処理対象N_全件対象.equals(処理対象N);
        is処理対象N_異動分対象 = 処理対象N_異動分対象.equals(処理対象N);
        is通知書プリント条件N_全被保険者 = 通知書プリント条件N_全被保険者.equals(通知書プリント条件N);
        is通知書プリント条件N_差引き保険料１円以上 = 通知書プリント条件N_差引き保険料１円以上.equals(通知書プリント条件N);
        is通知書プリント条件N_保険料変更有り = 通知書プリント条件N_保険料変更有り.equals(通知書プリント条件N);
        口座区分 = is対象者区分_すべて選択 ? RString.EMPTY
                : is対象者区分_口座振替者 ? 口座区分_口座振替者
                : is対象者区分_現金納付者 ? 口座区分_現金納付 : RString.EMPTY;
        this.生活保護対象者 = 生活保護対象者;
        this.処理対象N = 処理対象N;
        this.通知書プリント条件N = 通知書プリント条件N;
    }

    /**
     * パラメータを作成する。
     *
     * @param 出力期 出力期
     * @param 対象者区分 対象者区分
     * @param 出力順 出力順
     * @param 生活保護対象者 生活保護対象者
     * @param 処理対象N 処理対象N
     * @param 通知書プリント条件N 通知書プリント条件N
     * @return 作成されたパラメータ
     */
    public static IdoOrZenkenFukaSelectParameter createParameter(
            int 出力期,
            TaishoshaKubun 対象者区分,
            RString 出力順,
            SeikatsuHogoTaishosha 生活保護対象者,
            RString 処理対象N,
            RString 通知書プリント条件N) {
        対象者区分 = null == 対象者区分 ? TaishoshaKubun.すべて選択 : 対象者区分;
        生活保護対象者 = null == 生活保護対象者 ? SeikatsuHogoTaishosha.しない : 生活保護対象者;
        出力順 = null == 出力順 ? RString.EMPTY : 出力順;
        処理対象N = null == 処理対象N ? RString.EMPTY : 処理対象N;
        通知書プリント条件N = null == 通知書プリント条件N ? RString.EMPTY : 通知書プリント条件N;
        return new IdoOrZenkenFukaSelectParameter(
                出力期, 対象者区分, 出力順, 生活保護対象者, 処理対象N, 通知書プリント条件N);
    }
}
